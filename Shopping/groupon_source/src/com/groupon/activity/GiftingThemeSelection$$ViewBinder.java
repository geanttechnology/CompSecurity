// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

// Referenced classes of package com.groupon.activity:
//            GiftingThemeSelection, GrouponActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, GiftingThemeSelection giftingthemeselection, Object obj)
    {
        super.(ewbinder, giftingthemeselection, obj);
        giftingthemeselection.themeWebViewPlaceholder = (FrameLayout)ewbinder.meWebViewPlaceholder((View)ewbinder.w(obj, 0x7f100370, "field 'themeWebViewPlaceholder'"), 0x7f100370, "field 'themeWebViewPlaceholder'");
        giftingthemeselection.webviewProgressBar = (ProgressBar)ewbinder.viewProgressBar((View)ewbinder.w(obj, 0x7f1000df, "field 'webviewProgressBar'"), 0x7f1000df, "field 'webviewProgressBar'");
        giftingthemeselection.themesProgressBar = (ProgressBar)ewbinder.mesProgressBar((View)ewbinder.w(obj, 0x7f1002f9, "field 'themesProgressBar'"), 0x7f1002f9, "field 'themesProgressBar'");
        giftingthemeselection.scrollThemeSelector = (RecyclerView)ewbinder.ollThemeSelector((View)ewbinder.w(obj, 0x7f1002fa, "field 'scrollThemeSelector'"), 0x7f1002fa, "field 'scrollThemeSelector'");
        giftingthemeselection.submitButton = (Button)ewbinder.mitButton((View)ewbinder.w(obj, 0x7f100102, "field 'submitButton'"), 0x7f100102, "field 'submitButton'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (GiftingThemeSelection)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GiftingThemeSelection)obj, obj1);
    }

    public void unbind(GiftingThemeSelection giftingthemeselection)
    {
        super.(giftingthemeselection);
        giftingthemeselection.themeWebViewPlaceholder = null;
        giftingthemeselection.webviewProgressBar = null;
        giftingthemeselection.themesProgressBar = null;
        giftingthemeselection.scrollThemeSelector = null;
        giftingthemeselection.submitButton = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((GiftingThemeSelection)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((GiftingThemeSelection)obj);
    }

    public ()
    {
    }
}
