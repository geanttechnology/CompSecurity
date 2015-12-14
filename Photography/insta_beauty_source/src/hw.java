// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;

class hw
    implements android.content.DialogInterface.OnClickListener
{

    final hu a;

    hw(hu hu1)
    {
        a = hu1;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        hu.b(a).dismiss();
        hu.a(a, null);
    }
}
