// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

class agd
    implements Runnable
{

    final agc a;

    agd(agc agc1)
    {
        a = agc1;
        super();
    }

    public void run()
    {
        a.a.a.c();
        a.a.a.setResult(-1);
        a.a.a.finish();
        a.a.a.overridePendingTransition(0, 0x7f04001e);
    }
}
