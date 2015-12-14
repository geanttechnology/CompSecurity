// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.ProEidtActionBarView;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;

public class uu
    implements xb
{

    final MNewFotoBeautyActivity a;

    public uu(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        a = mnewfotobeautyactivity;
        super();
    }

    public Bitmap a()
    {
        return MNewFotoBeautyActivity.f(a);
    }

    public void a(Bitmap bitmap, com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate)
    {
        sx.a("BeautyEditFunc_Save", (new StringBuilder()).append("Tool_").append(maintoolstate.toString()).toString());
        MNewFotoBeautyActivity.a(a, bitmap);
        a.k = false;
        MNewFotoBeautyActivity.e(a).setImageBitmap(MNewFotoBeautyActivity.f(a));
        if (MNewFotoBeautyActivity.r(a) != null)
        {
            MNewFotoBeautyActivity.r(a).b();
        }
        MNewFotoBeautyActivity.i(a).updateBackState(uv.c().e(), uv.c().f());
        Log.e("MNewFotoBeautyActivity", (new StringBuilder()).append("beautyengine softer nextstep ").append(maintoolstate).toString());
        a.a();
    }

    public void a(com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate)
    {
        sx.a("BeautyEditFunc_Back", (new StringBuilder()).append("Tool_").append(maintoolstate.toString()).toString());
        if (MNewFotoBeautyActivity.r(a) != null)
        {
            MNewFotoBeautyActivity.r(a).b();
        }
        a.a();
        Log.e("MNewFotoBeautyActivity", (new StringBuilder()).append("beautyengine softer backstep ").append(maintoolstate).toString());
    }

    public ig b()
    {
        return MNewFotoBeautyActivity.r(a);
    }

    public void b(com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate)
    {
        if (maintoolstate == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.OneKey)
        {
            MNewFotoBeautyActivity.t(a);
            return;
        } else
        {
            a.b();
            return;
        }
    }

    public boolean c()
    {
        return MNewFotoBeautyActivity.u(a);
    }
}
