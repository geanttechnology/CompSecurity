// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;

class uj
    implements Runnable
{

    final ui a;

    uj(ui ui1)
    {
        a = ui1;
        super();
    }

    public void run()
    {
        MNewFotoBeautyActivity.s(a.a);
    }
}
