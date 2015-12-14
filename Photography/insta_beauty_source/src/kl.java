// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.TBeautyAdjustScrollView;

public class kl
    implements android.view.View.OnClickListener
{

    final TBeautyAdjustScrollView a;

    public kl(TBeautyAdjustScrollView tbeautyadjustscrollview)
    {
        a = tbeautyadjustscrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TBeautyAdjustScrollView.access$000(a) != null)
        {
            TBeautyAdjustScrollView.access$000(a).a(a, (com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState)view.getTag());
        }
    }
}
