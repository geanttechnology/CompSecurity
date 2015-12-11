// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.DialogInterface;

// Referenced classes of package com.groupon.service:
//            SoftwareUpdateService

class ener
    implements android.content.istener
{

    final SoftwareUpdateService this$0;
    final android.content.Listener val$cancelListener;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (val$cancelListener != null)
        {
            val$cancelListener.onCancel(dialoginterface);
        }
    }

    ener()
    {
        this$0 = final_softwareupdateservice;
        val$cancelListener = android.content.Listener.this;
        super();
    }
}
