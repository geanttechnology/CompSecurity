// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.receipt;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.SystemUtils;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.receipt:
//            ReceiptManager, Receipt, ReceiptProvider

static final class mContext extends Handler
{

    public static final int MESSAGE_ADD_TICKET = 100;
    public static final int MESSAGE_CLOSE = 3;
    public static final int MESSAGE_INIT = 1;
    public static final int MESSAGE_OPEN = 2;
    public static final int MESSAGE_UPLOAD = 4;
    com.aviary.android.feather.common.log.Ticket logger;
    private Context mContext;
    private Handler mUploadHandler;

    private void addTicket(Receipt receipt)
        throws JSONException
    {
        org.json.JSONObject jsonobject = receipt.toJSON(mContext);
        long l = ReceiptProvider.getInstance(mContext).addTicket(jsonobject, receipt.isFree);
        logger.ger("added ticket with id: %d", new Object[] {
            Long.valueOf(l)
        });
    }

    private void close()
    {
    }

    private void init()
    {
        logger.ger("init");
        mUploadHandler = new er(mContext, ReceiptManager.S_UPLOAD_HANDLER_THREAD.getLooper());
    }

    private void open()
    {
    }

    private void upload()
    {
        logger.ger("upload");
        mUploadHandler.sendEmptyMessage(1);
    }

    public void handleMessage(Message message)
    {
        logger.ger("handleMessage: %d", new Object[] {
            Integer.valueOf(message.what)
        });
        SystemUtils.throwIfNonUiThread(mContext);
        message.what;
        JVM INSTR lookupswitch 5: default 165
    //                   1: 114
    //                   2: 138
    //                   3: 143
    //                   4: 148
    //                   100: 153;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        logger.ger("didn't handle message: %d", new Object[] {
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
        logger.(message.getMessage());
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

    e(Context context, Looper looper)
    {
        super(looper);
        logger = LoggerFactory.getLogger(com/aviary/android/feather/receipt/ReceiptManager$Dispatcher.getSimpleName(), com.aviary.android.feather.common.log.onsoleLoggerType);
        mContext = context;
    }
}
