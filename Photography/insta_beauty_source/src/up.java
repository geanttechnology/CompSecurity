// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.ProEidtActionBarView;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;

public class up
    implements kh
{

    final MNewFotoBeautyActivity a;

    public up(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        a = mnewfotobeautyactivity;
        super();
    }

    public void a()
    {
        MNewFotoBeautyActivity.g(a);
        MNewFotoBeautyActivity.h(a);
    }

    public void b()
    {
        a.a();
    }

    public void c()
    {
        if (uv.c().f())
        {
            android.graphics.Bitmap bitmap = uv.c().g();
            MNewFotoBeautyActivity.a(a, bitmap);
            MNewFotoBeautyActivity.e(a).setImageBitmap(MNewFotoBeautyActivity.f(a));
        }
        MNewFotoBeautyActivity.i(a).updateBackState(uv.c().e(), uv.c().f());
    }

    public void d()
    {
        if (uv.c().e())
        {
            android.graphics.Bitmap bitmap = uv.c().h();
            MNewFotoBeautyActivity.a(a, bitmap);
            MNewFotoBeautyActivity.e(a).setImageBitmap(MNewFotoBeautyActivity.f(a));
        }
        MNewFotoBeautyActivity.i(a).updateBackState(uv.c().e(), uv.c().f());
    }
}
