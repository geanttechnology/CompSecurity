// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.content.DialogInterface;

// Referenced classes of package com.groupon.http:
//            RetryQueue

class this._cls0
    implements android.content.ce.OnClickListener
{

    final RetryQueue this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        retry();
    }

    e()
    {
        this$0 = RetryQueue.this;
        super();
    }
}
