// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;

class aln
    implements android.content.DialogInterface.OnCancelListener
{

    final alm a;

    aln(alm alm1)
    {
        a = alm1;
        super();
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        a.cancel(true);
        if (a.b != null)
        {
            a.b.a(0);
        }
    }
}
