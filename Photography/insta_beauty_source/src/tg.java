// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.FotoBeautySimpleActivity;

class tg
    implements Runnable
{

    final tf a;

    tg(tf tf1)
    {
        a = tf1;
        super();
    }

    public void run()
    {
        if (FotoBeautySimpleActivity.f(a.b) != null)
        {
            FotoBeautySimpleActivity.f(a.b).a(a.a, FotoBeautySimpleActivity.b());
        }
    }
}
