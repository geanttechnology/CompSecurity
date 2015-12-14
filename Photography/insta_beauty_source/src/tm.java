// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.newui.MNewBeautyMainFragment;

class tm
    implements Runnable
{

    final tl a;

    tm(tl tl1)
    {
        a = tl1;
        super();
    }

    public void run()
    {
        MNewBeautyMainFragment.e(a.a).setImageBitmap(a.a.c);
    }
}
