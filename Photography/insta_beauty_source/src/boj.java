// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;

class boj
    implements android.content.DialogInterface.OnClickListener
{

    final boh a;

    boj(boh boh)
    {
        a = boh;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }
}
