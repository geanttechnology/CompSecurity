// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.DialogInterface;

final class bu
    implements android.content.DialogInterface.OnClickListener
{

    private Activity a;

    bu(Activity activity)
    {
        a = activity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        a.finish();
    }
}
