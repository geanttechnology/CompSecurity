// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.TBeautyAdjustScrollView;
import com.fotoable.beautyui.newui.MNewBeautyMainFragment;

public class tp
    implements km
{

    final MNewBeautyMainFragment a;

    public tp(MNewBeautyMainFragment mnewbeautymainfragment)
    {
        a = mnewbeautymainfragment;
        super();
    }

    public void a(TBeautyAdjustScrollView tbeautyadjustscrollview, com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate)
    {
        if (a.b != null)
        {
            a.b.a(maintoolstate);
        }
    }
}
