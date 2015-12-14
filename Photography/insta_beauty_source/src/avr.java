// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.activity.TTieZhiActivity;

class avr
    implements Runnable
{

    final avq a;

    avr(avq avq1)
    {
        a = avq1;
        super();
    }

    public void run()
    {
        a.a.b.a.a.setResult(-1);
        TTieZhiActivity.a(a.a.b.a.a, false, "");
        a.a.b.a.a.finish();
        a.a.b.a.a.overridePendingTransition(0, 0x7f04001e);
    }
}
