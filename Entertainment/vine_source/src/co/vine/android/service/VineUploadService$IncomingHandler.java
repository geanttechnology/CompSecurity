// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.service:
//            VineUploadService

private class <init> extends Handler
{

    final VineUploadService this$0;

    public void handleMessage(Message message)
    {
        SLog.dWithTag("VineUploadService", (new StringBuilder()).append("Message received, what=").append(message.what).append(", replyTo=").append(message.replyTo).toString());
        message.what;
        JVM INSTR tableswitch 1 2: default 64
    //                   1 65
    //                   2 168;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if ((message = message.replyTo) != null)
        {
            VineUploadService.access$102(message);
            Bundle bundle = new Bundle();
              = VineUploadService.access$200(VineUploadService.this);
            if ( != null)
            {
                bundle.putLong("conversation_row_id", .conversationRowId);
                bundle.putString("thumbnail", .thumbnail);
                boolean flag;
                if (!android.os.viceAsyncTask.thumbnail.thumbnail(.getStatus()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                bundle.putBoolean("is_active", flag);
            }
            try
            {
                message.send(Message.obtain(null, 3, bundle));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                SLog.e("Failed to reply.", message);
            }
            return;
        }
          goto _L1
_L3:
        VineUploadService.access$102(null);
        return;
    }

    private ()
    {
        this$0 = VineUploadService.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
