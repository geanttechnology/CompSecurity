// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.newui.MNewBeautyMainFragment;

public class tn
    implements android.view.View.OnClickListener
{

    final MNewBeautyMainFragment a;

    public tn(MNewBeautyMainFragment mnewbeautymainfragment)
    {
        a = mnewbeautymainfragment;
        super();
    }

    public void onClick(View view)
    {
        if (a.b != null)
        {
            a.b.a(com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.OneKey);
        }
    }
}
