// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.receipt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.amazon.gallery.framework.aspect.AviaryReceiptLibraryAspect;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.SystemUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.reflect.Factory;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.receipt:
//            ReceiptUtils, Receipt, ReceiptProvider

public final class ReceiptManager
{
    static final class Dispatcher extends Handler
    {

        public static final int MESSAGE_ADD_TICKET = 100;
        public static final int MESSAGE_CLOSE = 3;
        public static final int MESSAGE_INIT = 1;
        public static final int MESSAGE_OPEN = 2;
        public static final int MESSAGE_UPLOAD = 4;
        com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
        private Context mContext;
        private Handler mUploadHandler;

        private void addTicket(Receipt receipt)
            throws JSONException
        {
            org.json.JSONObject jsonobject = receipt.toJSON(mContext);
            long l = ReceiptProvider.getInstance(mContext).addTicket(jsonobject, receipt.isFree);
            logger.log("added ticket with id: %d", new Object[] {
                Long.valueOf(l)
            });
        }

        private void close()
        {
        }

        private void init()
        {
            logger.info("init");
            mUploadHandler = new UploadHandler(mContext, ReceiptManager.S_UPLOAD_HANDLER_THREAD.getLooper());
        }

        private void open()
        {
        }

        private void upload()
        {
            logger.info("upload");
            mUploadHandler.sendEmptyMessage(1);
        }

        public void handleMessage(Message message)
        {
            logger.info("handleMessage: %d", new Object[] {
                Integer.valueOf(message.what)
            });
            SystemUtils.throwIfNonUiThread(mContext);
            message.what;
            JVM INSTR lookupswitch 5: default 165
        //                       1: 114
        //                       2: 138
        //                       3: 143
        //                       4: 148
        //                       100: 153;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            logger.warn("didn't handle message: %d", new Object[] {
                Integer.valueOf(message.what)
            });
            return;
_L2:
            try
            {
                init();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                message.printStackTrace();
            }
            logger.error(message.getMessage());
            return;
_L3:
            open();
            return;
_L4:
            close();
            return;
_L5:
            upload();
            return;
_L6:
            addTicket((Receipt)message.obj);
            return;
        }

        Dispatcher(Context context, Looper looper)
        {
            super(looper);
            logger = LoggerFactory.getLogger(com/aviary/android/feather/receipt/ReceiptManager$Dispatcher.getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
            mContext = context;
        }
    }

    static class Status
    {

        int count;
        long id;
        int status;

        Status(long l, int i)
        {
            this(l, i, 1);
        }

        public Status(long l, int i, int j)
        {
            id = l;
            status = i;
            count = j;
        }
    }

    static final class UploadHandler extends Handler
    {

        static final int MESSAGE_UPLOAD = 1;
        private static final org.aspectj.lang.JoinPoint.StaticPart ajc$tjp_0;
        com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
        private Context mContext;

        private static void ajc$preClinit()
        {
            Factory factory = new Factory("ReceiptManager.java", com/aviary/android/feather/receipt/ReceiptManager$UploadHandler);
            ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig("2", "upload", "com.aviary.android.feather.receipt.ReceiptManager$UploadHandler", "", "", "", "void"), 211);
        }

        private void handleResults(Collection collection, ReceiptProvider receiptprovider)
        {
            logger.info("handleResults");
            for (collection = collection.iterator(); collection.hasNext();)
            {
                Object obj = (Status)collection.next();
                logger.log("item {id: %d, status: %d, failCount: %d}", new Object[] {
                    Long.valueOf(((Status) (obj)).id), Integer.valueOf(((Status) (obj)).status), Integer.valueOf(((Status) (obj)).count)
                });
                if (((Status) (obj)).status == 200)
                {
                    try
                    {
                        int i = receiptprovider.delete("receipts_table", "r_id=?", new String[] {
                            String.valueOf(((Status) (obj)).id)
                        });
                        logger.log("deleteCount: %d", new Object[] {
                            Integer.valueOf(i)
                        });
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((SQLiteException) (obj)).printStackTrace();
                    }
                } else
                if (((Status) (obj)).count < 10)
                {
                    ContentValues contentvalues = new ContentValues();
                    contentvalues.put("u_receipt_id", Long.valueOf(((Status) (obj)).id));
                    contentvalues.put("u_response_status", Integer.valueOf(((Status) (obj)).status));
                    contentvalues.put("u_fail_count", Integer.valueOf(((Status) (obj)).count + 1));
                    try
                    {
                        long l = receiptprovider.insert("uploads_table", null, contentvalues, 5);
                        logger.log("added %d to the upload table", new Object[] {
                            Long.valueOf(l)
                        });
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((SQLiteException) (obj)).printStackTrace();
                    }
                } else
                {
                    logger.warn("we need to delete this item, too many fails (%d)!", new Object[] {
                        Integer.valueOf(((Status) (obj)).count)
                    });
                    try
                    {
                        int j = receiptprovider.delete("receipts_table", "r_id=?", new String[] {
                            String.valueOf(((Status) (obj)).id)
                        });
                        logger.log("delete count: %d", new Object[] {
                            Integer.valueOf(j)
                        });
                    }
                    catch (SQLiteException sqliteexception)
                    {
                        sqliteexception.printStackTrace();
                    }
                }
            }

        }

        private void upload()
        {
            JoinPoint joinpoint = Factory.makeJP(ajc$tjp_0, this, this);
            class AjcClosure1 extends AroundClosure
            {

                public Object run(Object aobj[])
                {
                    aobj = super.state;
                    UploadHandler.upload_aroundBody0((UploadHandler)aobj[0], (JoinPoint)aobj[1]);
                    return null;
                }

                public AjcClosure1(Object aobj[])
                {
                    super(aobj);
                }
            }

            AviaryReceiptLibraryAspect.aspectOf().invokeMethod((new AjcClosure1(new Object[] {
                this, joinpoint
            })).linkClosureAndJoinPoint(0x11010));
        }

        private Collection uploadReceipts(Cursor cursor)
        {
            logger.info("uploadReceipts: {cursor.size: %d}", new Object[] {
                Integer.valueOf(cursor.getCount())
            });
            ArrayList arraylist = new ArrayList();
            int i = 0;
            do
            {
                if (!cursor.moveToNext())
                {
                    break;
                }
                long l1 = cursor.getLong(cursor.getColumnIndex("r_id"));
                byte abyte0[] = cursor.getBlob(cursor.getColumnIndex("r_json"));
                int j = cursor.getInt(cursor.getColumnIndex("r_is_free"));
                int k = ReceiptUtils.clamp(cursor.getInt(cursor.getColumnIndex("u_fail_count")), 0, 255);
                int l = ReceiptUtils.clamp(cursor.getInt(cursor.getColumnIndex("u_response_status")), 0, 1000);
                String s1 = new String(abyte0, Charset.forName("UTF-8"));
                logger.log("trying to upload ticket: %d {fails count: %d}", new Object[] {
                    Long.valueOf(l1), Integer.valueOf(k)
                });
                String s;
                if (j == 1)
                {
                    s = "http://receipts.aviary.com/v2/receipt/android/free";
                } else
                {
                    s = "http://receipts.aviary.com/v2/receipt/android/paid";
                }
                try
                {
                    j = ReceiptUtils.upload(s, s1);
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                    j = 404;
                }
                logger.log("status: %d", new Object[] {
                    Integer.valueOf(j)
                });
                if (l != j)
                {
                    logger.log("ok, the error code is different. Let's reset the fail count to 1");
                    k = 0;
                } else
                {
                    logger.log("error code is the same, increment the fail count");
                }
                arraylist.add(new Status(l1, j, k));
                j = i + 1;
                i = j;
            } while (j < 10);
            return arraylist;
        }

        static final void upload_aroundBody0(UploadHandler uploadhandler, JoinPoint joinpoint)
        {
            uploadhandler.logger.info("upload");
            SystemUtils.throwIfNonUiThread(uploadhandler.mContext);
            joinpoint = ReceiptProvider.getInstance(uploadhandler.mContext);
            Cursor cursor = joinpoint.getNewReceipts();
            if (cursor != null)
            {
                Collection collection = uploadhandler.uploadReceipts(cursor);
                IOUtils.closeSilently(cursor);
                uploadhandler.handleResults(collection, joinpoint);
            }
            cursor = joinpoint.getFailedReceipts();
            if (cursor != null)
            {
                Collection collection1 = uploadhandler.uploadReceipts(cursor);
                IOUtils.closeSilently(cursor);
                uploadhandler.handleResults(collection1, joinpoint);
            }
            cursor = joinpoint.query("receipts_table", null, null, null, null, null, null);
            if (cursor != null)
            {
                uploadhandler.logger.log("receipts table has %d rows", new Object[] {
                    Integer.valueOf(cursor.getCount())
                });
            }
            IOUtils.closeSilently(cursor);
            joinpoint = joinpoint.query("uploads_table", null, null, null, null, null, null);
            if (joinpoint != null)
            {
                uploadhandler.logger.log("uploads table has %d rows", new Object[] {
                    Integer.valueOf(joinpoint.getCount())
                });
            }
            IOUtils.closeSilently(joinpoint);
        }

        public void handleMessage(Message message)
        {
            logger.info("handleMessage: %d", new Object[] {
                Integer.valueOf(message.what)
            });
            message.what;
            JVM INSTR tableswitch 1 1: default 85
        //                       1 61;
               goto _L1 _L2
_L1:
            logger.warn("not handled");
            return;
_L2:
            try
            {
                upload();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                message.printStackTrace();
            }
            logger.error(message.getMessage());
            return;
        }

        static 
        {
            ajc$preClinit();
        }

        public UploadHandler(Context context, Looper looper)
        {
            super(looper);
            logger = LoggerFactory.getLogger("UploadHandler", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
            mContext = context;
        }
    }


    private static final int FAIL_COUNT_MAX = 255;
    static final int MAX_UPLOADS_PER_SESSION = 10;
    static final int MAX_UPLOAD_FAIL_COUNT = 10;
    static final String SERVER_ROOT = "http://receipts.aviary.com/v2/receipt/android/";
    static final int STATUS_MAX = 1000;
    static final int STATUS_OK = 200;
    static final HandlerThread S_DISPATCHER_HANDLER_THREAD = ReceiptUtils.getHandlerThread(com/aviary/android/feather/receipt/ReceiptManager$Dispatcher.getSimpleName());
    static final HandlerThread S_UPLOAD_HANDLER_THREAD = ReceiptUtils.getHandlerThread(com/aviary/android/feather/receipt/ReceiptManager$UploadHandler.getSimpleName());
    static final String URI_FREE = "http://receipts.aviary.com/v2/receipt/android/free";
    static final String URI_PAID = "http://receipts.aviary.com/v2/receipt/android/paid";
    private static ReceiptManager sInstance;
    com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private final Context mContext;
    private final Dispatcher mDispatcher;

    private ReceiptManager(Context context)
    {
        logger = LoggerFactory.getLogger("ReceiptManager", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
        mContext = context;
        mDispatcher = new Dispatcher(mContext, S_DISPATCHER_HANDLER_THREAD.getLooper());
        mDispatcher.sendEmptyMessage(1);
    }

    public static ReceiptManager getInstance(Context context)
    {
        if (sInstance != null) goto _L2; else goto _L1
_L1:
        com/aviary/android/feather/receipt/ReceiptManager;
        JVM INSTR monitorenter ;
        if (sInstance != null) goto _L4; else goto _L3
_L3:
        com/aviary/android/feather/receipt/ReceiptManager;
        JVM INSTR monitorenter ;
        sInstance = new ReceiptManager(context);
        com/aviary/android/feather/receipt/ReceiptManager;
        JVM INSTR monitorexit ;
_L4:
        com/aviary/android/feather/receipt/ReceiptManager;
        JVM INSTR monitorexit ;
_L2:
        return sInstance;
        context;
        com/aviary/android/feather/receipt/ReceiptManager;
        JVM INSTR monitorexit ;
        throw context;
        context;
        com/aviary/android/feather/receipt/ReceiptManager;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void close()
    {
        mDispatcher.sendEmptyMessage(3);
    }

    public void open()
    {
        mDispatcher.sendEmptyMessage(2);
    }

    public void sendTicket(Receipt receipt)
    {
        mDispatcher.sendMessage(mDispatcher.obtainMessage(100, receipt));
    }

    public void upload()
    {
        mDispatcher.sendEmptyMessage(4);
    }

}
