// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.FotoBeautySimpleActivity;

public class te
    implements Runnable
{

    final FotoBeautySimpleActivity a;

    public te(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        a = fotobeautysimpleactivity;
        super();
    }

    public void run()
    {
        if (FotoBeautySimpleActivity.f(a) != null)
        {
            FotoBeautySimpleActivity.f(a).a(FotoBeautySimpleActivity.b());
        }
    }
}
