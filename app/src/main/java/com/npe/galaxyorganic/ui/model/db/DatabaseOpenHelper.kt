package com.npe.galaxyorganic.ui.model.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
class DatabaseOpenHelper(context: Context) : ManagedSQLiteOpenHelper(context, "Customer.db", null , 1){
    companion object {
        private var instance: DatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DatabaseOpenHelper {
            if (instance == null) {
                instance = DatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as DatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(CustomerModel.TABLE_CUSTOMER, true,
            CustomerModel.ID to INTEGER+ PRIMARY_KEY+ AUTOINCREMENT,
            CustomerModel.CUSTOMER_ID to INTEGER + UNIQUE,
            CustomerModel.CUSTOMER_NAME to TEXT,
            CustomerModel.CUSTOMER_EMAIL to TEXT,
            CustomerModel.CUSTOMER_PHOTO to TEXT,
            CustomerModel.LOGIN_FROM to TEXT
        )
        db?.createTable(OrderModel.TABLE_ORDER, true,
            OrderModel.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            OrderModel.PRODUCT_ID to INTEGER ,
            OrderModel.PRODUCT_NAME to TEXT,
            OrderModel.PRODUCT_PRICE to INTEGER,
            OrderModel.QUANTITY to INTEGER,
            OrderModel.SUB_TOTAL to INTEGER,
            OrderModel.IMAGE to TEXT)

        db?.createTable(PaymentModel.TABLE_PAYMENT, true,
            PaymentModel.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            PaymentModel.NAMA_PENERIMA to TEXT,
            PaymentModel.EMAIL_PENERIMA to TEXT,
            PaymentModel.TANGGAL_BELI to TEXT,
            PaymentModel.ALAMAT_PENERIMA to TEXT,
            PaymentModel.NOTELP_PENERIMA to TEXT,
            PaymentModel.SUBTOTAL to TEXT,
            PaymentModel.DISKON to TEXT,
            PaymentModel.TOTAL_HARGA to TEXT)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(CustomerModel.TABLE_CUSTOMER, true)
        db?.dropTable(OrderModel.TABLE_ORDER , true)
        db?.dropTable(PaymentModel.TABLE_PAYMENT, true)
    }
}
val Context.database: DatabaseOpenHelper
    get() = DatabaseOpenHelper.getInstance(applicationContext)