// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.DialogInterface;

// Referenced classes of package com.groupon.activity:
//            Splash

class this._cls0
    implements android.content.erface.OnCancelListener
{

    final Splash this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        finish();
    }

    e()
    {
        this$0 = Splash.this;
        super();
    }
}
