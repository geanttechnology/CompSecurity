// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;

public class uo
    implements android.view.View.OnClickListener
{

    final MNewFotoBeautyActivity a;

    public uo(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        a = mnewfotobeautyactivity;
        super();
    }

    public void onClick(View view)
    {
        MNewFotoBeautyActivity.a(a, com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.OneKey);
    }
}
