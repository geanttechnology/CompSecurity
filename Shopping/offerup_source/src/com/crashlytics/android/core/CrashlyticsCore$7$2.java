// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.content.DialogInterface;

class this._cls1
    implements android.content.ickListener
{

    final nLatch.setOptIn this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        latch.setOptIn(false);
        dialoginterface.dismiss();
    }

    nLatch()
    {
        this$1 = this._cls1.this;
        super();
    }
}
