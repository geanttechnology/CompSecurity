// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.DialogInterface;

// Referenced classes of package com.groupon.util:
//            ThanksUIUtil

class r
    implements android.content..OnClickListener
{

    final ThanksUIUtil this$0;
    final android.content..OnCancelListener val$onCancelListener;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (val$onCancelListener != null)
        {
            val$onCancelListener.onCancel(dialoginterface);
        }
    }

    r()
    {
        this$0 = final_thanksuiutil;
        val$onCancelListener = android.content..OnCancelListener.this;
        super();
    }
}
