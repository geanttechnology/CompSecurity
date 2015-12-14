// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;

class un
    implements Runnable
{

    final um a;

    un(um um1)
    {
        a = um1;
        super();
    }

    public void run()
    {
        MNewFotoBeautyActivity.e(a.a).setImageBitmap(MNewFotoBeautyActivity.f(a.a));
    }
}
