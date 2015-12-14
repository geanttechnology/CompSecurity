// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;

class ahl
    implements Runnable
{

    final ahk a;

    ahl(ahk ahk1)
    {
        a = ahk1;
        super();
    }

    public void run()
    {
        a.a.b.setResult(-1);
        a.a.b.b();
        a.a.b.finish();
        a.a.b.overridePendingTransition(0, 0x7f04001e);
    }
}
