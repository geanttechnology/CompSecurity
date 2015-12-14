// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;

class ain
    implements Runnable
{

    final aim a;

    ain(aim aim1)
    {
        a = aim1;
        super();
    }

    public void run()
    {
        a.a.setResult(-1);
        a.a.b();
        a.a.finish();
        a.a.overridePendingTransition(0, 0x7f04001e);
    }
}
