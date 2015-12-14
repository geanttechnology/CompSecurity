// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.fotoable.beautyui.TBeautyAdjustScrollView;
import com.fotoable.beautyui.newui.MNewBeautyMainFragment;
import com.fotoable.beautyui.newui.MNewProEditScrollView;

public class tj
    implements android.view.View.OnClickListener
{

    final MNewBeautyMainFragment a;

    public tj(MNewBeautyMainFragment mnewbeautymainfragment)
    {
        a = mnewbeautymainfragment;
        super();
    }

    public void onClick(View view)
    {
        MNewBeautyMainFragment.a(a).setVisibility(0);
        MNewBeautyMainFragment.b(a).setVisibility(4);
        MNewBeautyMainFragment.c(a).setTextColor(a.getResources().getColor(0x7f0c009d));
        MNewBeautyMainFragment.d(a).setTextColor(a.getResources().getColor(0x7f0c002d));
    }
}
