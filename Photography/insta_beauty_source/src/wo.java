// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.beautyui.ImageDetailView;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.newui.MSlimBodyFragment;

class wo
    implements Runnable
{

    final wn a;

    wo(wn wn1)
    {
        a = wn1;
        super();
    }

    public void run()
    {
        Bitmap bitmap = MSlimBodyFragment.f(a.a).copy(MSlimBodyFragment.f(a.a).getConfig(), true);
        MSlimBodyFragment.Q(a.a).a(bitmap);
        MSlimBodyFragment.a(a.a, bitmap);
        MSlimBodyFragment.c(a.a).setImage(MSlimBodyFragment.f(a.a));
        ws.a[MSlimBodyFragment.e(a.a).ordinal()];
        JVM INSTR tableswitch 1 2: default 116
    //                   1 173
    //                   2 173;
           goto _L1 _L2 _L2
_L1:
        MSlimBodyFragment.x(a.a).setImageBitmap(MSlimBodyFragment.f(a.a));
        MSlimBodyFragment.a(a.a).setImageBitmap(MSlimBodyFragment.f(a.a));
_L4:
        MSlimBodyFragment.S(a.a);
        return;
_L2:
        if (MSlimBodyFragment.R(a.a))
        {
            MSlimBodyFragment.b(a.a, false);
            MSlimBodyFragment.a(a.a).setImageBitmap(MSlimBodyFragment.f(a.a));
            xc.a().a(0, 1, 600, MSlimBodyFragment.a(a.a), new wp(this));
        } else
        {
            MSlimBodyFragment.x(a.a).setImageBitmap(MSlimBodyFragment.f(a.a));
            MSlimBodyFragment.a(a.a).setImageBitmap(MSlimBodyFragment.f(a.a));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
