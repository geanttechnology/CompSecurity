// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;

class uc
    implements Runnable
{

    final ub a;

    uc(ub ub1)
    {
        a = ub1;
        super();
    }

    public void run()
    {
        MNewFotoBeautyActivity.s(a.b);
        a.b.finish();
    }
}
