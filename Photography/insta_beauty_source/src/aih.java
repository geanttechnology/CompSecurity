// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;

class aih
    implements Runnable
{

    final aig a;

    aih(aig aig1)
    {
        a = aig1;
        super();
    }

    public void run()
    {
        ProEditNewStretchActivity.c(a.a);
    }
}
