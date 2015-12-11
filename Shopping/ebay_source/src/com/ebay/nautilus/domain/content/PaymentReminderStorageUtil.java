// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PaymentReminderStorageUtil extends SQLiteOpenHelper
{
    public static class PaymentReminderStorageParams
    {

        public long id;
        public long transactionCreationDate;
        public ArrayList variationSpecifics;

        public PaymentReminderStorageParams()
        {
        }
    }


    private static final String COLUMN_INSERT_DATE = "insert_date";
    private static final String COLUMN_ITEM_ID = "item_id";
    private static final String COLUMN_TRANSCATION_CREATION_DATE = "transaction_creation_date";
    private static final String COLUMN_VARIATION_INFO = "variation_info";
    private static final String DATABASE_NAME = "payment_reminder.db";
    private static final int DATABASE_VERSION = 2;
    private static final String QUERY_STRING = "item_id = ? AND variation_info= ? AND transaction_creation_date= ?";
    private static final long RECORD_RETENTION_TIME = 0x134fd9000L;
    private static final String TABLE_NAME = "payment_reminder";
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("PRStorageUtil", 3, "Payment Storage Util");
    private static PaymentReminderStorageUtil prStorageUtil = null;

    private PaymentReminderStorageUtil(Context context)
    {
        super(context, "payment_reminder.db", null, 2);
    }

    public static void create(Context context)
    {
        if (prStorageUtil == null)
        {
            prStorageUtil = new PaymentReminderStorageUtil(context.getApplicationContext());
        }
    }

    public static boolean deleteItem(PaymentReminderStorageParams paymentreminderstorageparams)
    {
        boolean flag = true;
        if (paymentreminderstorageparams != null && paymentreminderstorageparams.id != 0L && paymentreminderstorageparams.transactionCreationDate != 0L) goto _L2; else goto _L1
_L1:
        flag = false;
_L5:
        return flag;
_L2:
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        SQLiteDatabase sqlitedatabase2;
        Object obj;
        int i;
        lock.writeLock().lock();
        i = 0;
        obj = null;
        sqlitedatabase2 = null;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = obj;
        if (paymentreminderstorageparams.variationSpecifics == null) goto _L4; else goto _L3
_L3:
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = obj;
        String s = paymentreminderstorageparams.variationSpecifics.toString();
_L6:
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = obj;
        sqlitedatabase2 = prStorageUtil.getReadableDatabase();
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = sqlitedatabase2;
        int j = sqlitedatabase2.delete("payment_reminder", "item_id = ? AND variation_info= ? AND transaction_creation_date= ?", new String[] {
            Long.toString(paymentreminderstorageparams.id), s, Long.toString(paymentreminderstorageparams.transactionCreationDate)
        });
        i = j;
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.close();
        }
        lock.writeLock().unlock();
_L7:
        if (i <= 0)
        {
            return false;
        }
          goto _L5
_L4:
        s = "";
          goto _L6
        paymentreminderstorageparams;
        sqlitedatabase = sqlitedatabase1;
        logTag.logAsError("Failed to delete Item for Payment Reminder", paymentreminderstorageparams);
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        lock.writeLock().unlock();
          goto _L7
        paymentreminderstorageparams;
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        lock.writeLock().unlock();
        throw paymentreminderstorageparams;
          goto _L6
    }

    private static void flushSoldAndOldRecords(ArrayList arraylist)
    {
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        lock.writeLock().lock();
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase2 = prStorageUtil.getReadableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        long l = (new Date()).getTime();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        int i = sqlitedatabase2.delete("payment_reminder", (new StringBuilder()).append("insert_date <= ").append(l - 0x134fd9000L).toString(), null);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        logTag.log((new StringBuilder()).append("Total rows delete based on timestamp ").append(i).toString());
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        Iterator iterator = arraylist.iterator();
_L3:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        PaymentReminderStorageParams paymentreminderstorageparams = (PaymentReminderStorageParams)iterator.next();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (paymentreminderstorageparams.variationSpecifics == null)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        arraylist = paymentreminderstorageparams.variationSpecifics.toString();
_L4:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        i += sqlitedatabase2.delete("payment_reminder", "item_id = ? AND variation_info= ? AND transaction_creation_date= ?", new String[] {
            Long.toString(paymentreminderstorageparams.id), arraylist, Long.toString(paymentreminderstorageparams.transactionCreationDate)
        });
          goto _L3
_L2:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        logTag.log((new StringBuilder()).append("Total rows delete based on item id's ").append(i).toString());
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.close();
        }
        lock.writeLock().unlock();
        return;
        arraylist;
        sqlitedatabase1 = sqlitedatabase;
        logTag.logAsError("Failed to remove old and sold records for Payment Reminder", arraylist);
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        lock.writeLock().unlock();
        return;
        arraylist;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        lock.writeLock().unlock();
        throw arraylist;
        arraylist = "";
          goto _L4
    }

    public static void flushSoldAndOldRecords(List list)
    {
        ArrayList arraylist = new ArrayList();
        if (list != null)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                MyEbayListItem myebaylistitem = (MyEbayListItem)list.next();
                if (myebaylistitem.transaction != null && myebaylistitem.transaction.isPaid())
                {
                    PaymentReminderStorageParams paymentreminderstorageparams = new PaymentReminderStorageParams();
                    paymentreminderstorageparams.id = myebaylistitem.id;
                    long l;
                    if (myebaylistitem.transaction != null)
                    {
                        l = myebaylistitem.transaction.createdDate.getTime();
                    } else
                    {
                        l = 0L;
                    }
                    paymentreminderstorageparams.transactionCreationDate = l;
                    paymentreminderstorageparams.variationSpecifics = myebaylistitem.nameValueList;
                    arraylist.add(paymentreminderstorageparams);
                }
            } while (true);
        }
        (new Thread(new Runnable(arraylist) {

            final ArrayList val$soldIds;

            public void run()
            {
                PaymentReminderStorageUtil.flushSoldAndOldRecords(soldIds);
            }

            
            {
                soldIds = arraylist;
                super();
            }
        })).start();
    }

    public static long getPaymentReminderSentDate(PaymentReminderStorageParams paymentreminderstorageparams)
    {
        SQLiteDatabase sqlitedatabase;
        PaymentReminderStorageParams paymentreminderstorageparams1;
        SQLiteDatabase sqlitedatabase1;
        PaymentReminderStorageParams paymentreminderstorageparams2;
        SQLiteDatabase sqlitedatabase2;
        Object obj;
        Object obj1;
        String s1;
        long l1;
        if (paymentreminderstorageparams == null || paymentreminderstorageparams.id == 0L || paymentreminderstorageparams.transactionCreationDate == 0L)
        {
            return 0L;
        }
        lock.readLock().lock();
        l1 = 0L;
        obj1 = null;
        obj = null;
        s1 = null;
        sqlitedatabase2 = null;
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = s1;
        paymentreminderstorageparams1 = obj1;
        if (paymentreminderstorageparams.variationSpecifics == null) goto _L2; else goto _L1
_L1:
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = s1;
        paymentreminderstorageparams1 = obj1;
        String s = paymentreminderstorageparams.variationSpecifics.toString();
_L4:
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = s1;
        paymentreminderstorageparams1 = obj1;
        sqlitedatabase2 = prStorageUtil.getReadableDatabase();
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = sqlitedatabase2;
        paymentreminderstorageparams1 = obj1;
        s1 = Long.toString(paymentreminderstorageparams.id);
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = sqlitedatabase2;
        paymentreminderstorageparams1 = obj1;
        paymentreminderstorageparams = Long.toString(paymentreminderstorageparams.transactionCreationDate);
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = sqlitedatabase2;
        paymentreminderstorageparams1 = obj1;
        paymentreminderstorageparams = sqlitedatabase2.query(false, "payment_reminder", new String[] {
            "insert_date"
        }, "item_id = ? AND variation_info= ? AND transaction_creation_date= ?", new String[] {
            s1, s, paymentreminderstorageparams
        }, null, null, null, null);
        long l;
        l = l1;
        if (paymentreminderstorageparams == null)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        l = l1;
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = paymentreminderstorageparams;
        sqlitedatabase = sqlitedatabase2;
        paymentreminderstorageparams1 = paymentreminderstorageparams;
        if (!paymentreminderstorageparams.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_268;
        }
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = paymentreminderstorageparams;
        sqlitedatabase = sqlitedatabase2;
        paymentreminderstorageparams1 = paymentreminderstorageparams;
        l = paymentreminderstorageparams.getLong(paymentreminderstorageparams.getColumnIndex("insert_date"));
        if (paymentreminderstorageparams != null)
        {
            paymentreminderstorageparams.close();
        }
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.close();
        }
        lock.readLock().unlock();
        return l;
_L2:
        s = "";
        if (true) goto _L4; else goto _L3
_L3:
        paymentreminderstorageparams;
        sqlitedatabase = sqlitedatabase1;
        paymentreminderstorageparams1 = paymentreminderstorageparams2;
        logTag.logAsError("Failed to fetch the Payment Reminder sent date", paymentreminderstorageparams);
        if (paymentreminderstorageparams2 != null)
        {
            paymentreminderstorageparams2.close();
        }
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        lock.readLock().unlock();
        return 0L;
        paymentreminderstorageparams;
        if (paymentreminderstorageparams1 != null)
        {
            paymentreminderstorageparams1.close();
        }
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        lock.readLock().unlock();
        throw paymentreminderstorageparams;
    }

    public static boolean isReminderSent(PaymentReminderStorageParams paymentreminderstorageparams)
    {
        SQLiteDatabase sqlitedatabase;
        PaymentReminderStorageParams paymentreminderstorageparams1;
        SQLiteDatabase sqlitedatabase1;
        PaymentReminderStorageParams paymentreminderstorageparams2;
        SQLiteDatabase sqlitedatabase2;
        Object obj;
        Object obj1;
        String s1;
        boolean flag1;
        if (paymentreminderstorageparams == null || paymentreminderstorageparams.id == 0L || paymentreminderstorageparams.transactionCreationDate == 0L)
        {
            return false;
        }
        lock.readLock().lock();
        flag1 = false;
        obj1 = null;
        obj = null;
        s1 = null;
        sqlitedatabase2 = null;
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = s1;
        paymentreminderstorageparams1 = obj1;
        if (paymentreminderstorageparams.variationSpecifics == null) goto _L2; else goto _L1
_L1:
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = s1;
        paymentreminderstorageparams1 = obj1;
        String s = paymentreminderstorageparams.variationSpecifics.toString();
_L4:
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = s1;
        paymentreminderstorageparams1 = obj1;
        sqlitedatabase2 = prStorageUtil.getReadableDatabase();
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = sqlitedatabase2;
        paymentreminderstorageparams1 = obj1;
        s1 = Long.toString(paymentreminderstorageparams.id);
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = sqlitedatabase2;
        paymentreminderstorageparams1 = obj1;
        paymentreminderstorageparams = Long.toString(paymentreminderstorageparams.transactionCreationDate);
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = obj;
        sqlitedatabase = sqlitedatabase2;
        paymentreminderstorageparams1 = obj1;
        paymentreminderstorageparams = sqlitedatabase2.query(false, "payment_reminder", new String[] {
            "item_id", "variation_info"
        }, "item_id = ? AND variation_info= ? AND transaction_creation_date= ?", new String[] {
            s1, s, paymentreminderstorageparams
        }, null, null, null, null);
        boolean flag;
        flag = flag1;
        if (paymentreminderstorageparams == null)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        sqlitedatabase1 = sqlitedatabase2;
        paymentreminderstorageparams2 = paymentreminderstorageparams;
        sqlitedatabase = sqlitedatabase2;
        paymentreminderstorageparams1 = paymentreminderstorageparams;
        boolean flag2 = paymentreminderstorageparams.moveToFirst();
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
        if (paymentreminderstorageparams != null)
        {
            paymentreminderstorageparams.close();
        }
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.close();
        }
        lock.readLock().unlock();
        return flag;
_L2:
        s = "";
        if (true) goto _L4; else goto _L3
_L3:
        paymentreminderstorageparams;
        sqlitedatabase = sqlitedatabase1;
        paymentreminderstorageparams1 = paymentreminderstorageparams2;
        logTag.logAsError("Failed to fetch the Payment Reminder Staus", paymentreminderstorageparams);
        if (paymentreminderstorageparams2 != null)
        {
            paymentreminderstorageparams2.close();
        }
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        lock.readLock().unlock();
        return false;
        paymentreminderstorageparams;
        if (paymentreminderstorageparams1 != null)
        {
            paymentreminderstorageparams1.close();
        }
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        lock.readLock().unlock();
        throw paymentreminderstorageparams;
    }

    public static boolean setStatusToSent(PaymentReminderStorageParams paymentreminderstorageparams)
    {
        if (paymentreminderstorageparams != null && paymentreminderstorageparams.id != 0L && paymentreminderstorageparams.transactionCreationDate != 0L) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        SQLiteDatabase sqlitedatabase2;
        ContentValues contentvalues;
        long l;
        lock.writeLock().lock();
        l = -1L;
        contentvalues = null;
        sqlitedatabase2 = null;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = contentvalues;
        if (paymentreminderstorageparams.variationSpecifics == null) goto _L4; else goto _L3
_L3:
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = contentvalues;
        String s = paymentreminderstorageparams.variationSpecifics.toString();
_L5:
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = contentvalues;
        sqlitedatabase2 = prStorageUtil.getWritableDatabase();
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = sqlitedatabase2;
        contentvalues = new ContentValues();
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = sqlitedatabase2;
        contentvalues.put("item_id", Long.valueOf(paymentreminderstorageparams.id));
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = sqlitedatabase2;
        contentvalues.put("variation_info", s);
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = sqlitedatabase2;
        contentvalues.put("transaction_creation_date", Long.valueOf(paymentreminderstorageparams.transactionCreationDate));
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = sqlitedatabase2;
        contentvalues.put("insert_date", Long.valueOf((new Date()).getTime()));
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase = sqlitedatabase2;
        long l1 = sqlitedatabase2.insert("payment_reminder", null, contentvalues);
        l = l1;
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.close();
        }
        lock.writeLock().unlock();
_L6:
        if (l != -1L)
        {
            return true;
        }
          goto _L1
_L4:
        s = "";
          goto _L5
        paymentreminderstorageparams;
        sqlitedatabase = sqlitedatabase1;
        logTag.logAsError("Failure to Insert the Payment Reminder status", paymentreminderstorageparams);
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        lock.writeLock().unlock();
          goto _L6
        paymentreminderstorageparams;
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        lock.writeLock().unlock();
        throw paymentreminderstorageparams;
          goto _L5
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE payment_reminder(item_id INTEGER,variation_info TEXT,transaction_creation_date INTEGER,insert_date INTEGER )");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS payment_reminder");
        onCreate(sqlitedatabase);
    }


}
