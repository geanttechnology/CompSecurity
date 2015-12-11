// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.groupon.view.WobbleSpaceshipCatView;

// Referenced classes of package com.groupon.activity:
//            Splash, GrouponActivity

public class ewBinder extends ewBinder
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (Splash)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, Splash splash, Object obj)
    {
        super.bind(ewbinder, splash, obj);
        splash.firstTimeChoosePlease = (TextView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f100537, "field 'firstTimeChoosePlease'"), 0x7f100537, "field 'firstTimeChoosePlease'");
        splash.tryAnotherCity = (Button)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f100538, "field 'tryAnotherCity'"), 0x7f100538, "field 'tryAnotherCity'");
        splash.wobbleSpaceshipCatView = (WobbleSpaceshipCatView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f1003e1, "field 'wobbleSpaceshipCatView'"), 0x7f1003e1, "field 'wobbleSpaceshipCatView'");
        splash.bottomContainer = (View)ewbinder.findRequiredView(obj, 0x7f100366, "field 'bottomContainer'");
        splash.divisionChooser = (View)ewbinder.findRequiredView(obj, 0x7f100536, "field 'divisionChooser'");
        splash.cityImage = (View)ewbinder.findOptionalView(obj, 0x7f10036c, null);
        splash.continueButtonContainer = (View)ewbinder.findOptionalView(obj, 0x7f100476, null);
        splash.welcomeText = (View)ewbinder.findRequiredView(obj, 0x7f100535, "field 'welcomeText'");
        splash.grouponLogo = (View)ewbinder.findRequiredView(obj, 0x7f10036b, "field 'grouponLogo'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (Splash)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((Splash)grouponactivity);
    }

    public void unbind(Splash splash)
    {
        super.unbind(splash);
        splash.firstTimeChoosePlease = null;
        splash.tryAnotherCity = null;
        splash.wobbleSpaceshipCatView = null;
        splash.bottomContainer = null;
        splash.divisionChooser = null;
        splash.cityImage = null;
        splash.continueButtonContainer = null;
        splash.welcomeText = null;
        splash.grouponLogo = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((Splash)obj);
    }

    public ewBinder()
    {
    }
}
