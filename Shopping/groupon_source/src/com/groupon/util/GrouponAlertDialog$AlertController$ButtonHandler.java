// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.groupon.util:
//            GrouponAlertDialog

private static final class mDialog extends Handler
{

    private static final int MSG_DISMISS_DIALOG = 1;
    private WeakReference mDialog;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch -3 1: default 40
    //                   -3 41
    //                   -2 41
    //                   -1 41
    //                   0 40
    //                   1 74;
           goto _L1 _L2 _L2 _L2 _L1 _L3
_L1:
        DialogInterface dialoginterface;
        return;
_L2:
        if ((dialoginterface = (DialogInterface)mDialog.get()) != null)
        {
            ((android.content..mDialog)message.obj).mDialog(dialoginterface, message.what);
            return;
        }
          goto _L1
_L3:
        ((DialogInterface)message.obj).dismiss();
        return;
    }

    public (DialogInterface dialoginterface)
    {
        mDialog = new WeakReference(dialoginterface);
    }
}
