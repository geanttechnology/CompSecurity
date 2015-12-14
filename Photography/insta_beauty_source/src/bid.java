// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;

class bid
    implements android.content.DialogInterface.OnCancelListener
{

    final bic a;

    bid(bic bic1)
    {
        a = bic1;
        super();
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        a.cancel(true);
    }
}
