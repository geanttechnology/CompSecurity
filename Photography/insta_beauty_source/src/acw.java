// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeauty.WantuActivity;

public class acw
    implements com.fotoable.adbuttonlib.TAdButtonGroup.OnAdButtonClickedLisener
{

    final WantuActivity a;

    public acw(WantuActivity wantuactivity)
    {
        a = wantuactivity;
        super();
    }

    public void onAdButtonClicked(String s)
    {
        WantuActivity.a(a, s);
    }
}
