// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.view.SpinnerButton;
import com.groupon.view.UrlImageView;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage, GrouponActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, BusinessSpecialPage businessspecialpage, Object obj)
    {
        super.(ewbinder, businessspecialpage, obj);
        businessspecialpage.specialIcon = (ImageView)ewbinder.cialIcon((View)ewbinder.iew(obj, 0x7f10014a, "field 'specialIcon'"), 0x7f10014a, "field 'specialIcon'");
        businessspecialpage.specialName = (TextView)ewbinder.cialName((View)ewbinder.iew(obj, 0x7f10014b, "field 'specialName'"), 0x7f10014b, "field 'specialName'");
        businessspecialpage.specialTime = (TextView)ewbinder.cialTime((View)ewbinder.iew(obj, 0x7f10014c, "field 'specialTime'"), 0x7f10014c, "field 'specialTime'");
        businessspecialpage.specialDetail = (TextView)ewbinder.cialDetail((View)ewbinder.iew(obj, 0x7f10014d, "field 'specialDetail'"), 0x7f10014d, "field 'specialDetail'");
        businessspecialpage.specialButton = (SpinnerButton)ewbinder.cialButton((View)ewbinder.iew(obj, 0x7f10014e, "field 'specialButton'"), 0x7f10014e, "field 'specialButton'");
        businessspecialpage.specialSavedText = (TextView)ewbinder.cialSavedText((View)ewbinder.iew(obj, 0x7f10014f, "field 'specialSavedText'"), 0x7f10014f, "field 'specialSavedText'");
        businessspecialpage.specialInfoText = (TextView)ewbinder.cialInfoText((View)ewbinder.iew(obj, 0x7f100150, "field 'specialInfoText'"), 0x7f100150, "field 'specialInfoText'");
        businessspecialpage.specialEmailSection = (RelativeLayout)ewbinder.cialEmailSection((View)ewbinder.iew(obj, 0x7f100151, "field 'specialEmailSection'"), 0x7f100151, "field 'specialEmailSection'");
        businessspecialpage.instructions = (WebView)ewbinder.tructions((View)ewbinder.iew(obj, 0x7f100153, "field 'instructions'"), 0x7f100153, "field 'instructions'");
        businessspecialpage.promoCode = (TextView)ewbinder.moCode((View)ewbinder.iew(obj, 0x7f100155, "field 'promoCode'"), 0x7f100155, "field 'promoCode'");
        businessspecialpage.printable = (UrlImageView)ewbinder.ntable((View)ewbinder.iew(obj, 0x7f100154, "field 'printable'"), 0x7f100154, "field 'printable'");
        businessspecialpage.progressBar = (ProgressBar)ewbinder.gressBar((View)ewbinder.iew(obj, 0x7f10010b, "field 'progressBar'"), 0x7f10010b, "field 'progressBar'");
        businessspecialpage.specialLayout = (LinearLayout)ewbinder.cialLayout((View)ewbinder.iew(obj, 0x7f100149, "field 'specialLayout'"), 0x7f100149, "field 'specialLayout'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (BusinessSpecialPage)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (BusinessSpecialPage)obj, obj1);
    }

    public void unbind(BusinessSpecialPage businessspecialpage)
    {
        super.nd(businessspecialpage);
        businessspecialpage.specialIcon = null;
        businessspecialpage.specialName = null;
        businessspecialpage.specialTime = null;
        businessspecialpage.specialDetail = null;
        businessspecialpage.specialButton = null;
        businessspecialpage.specialSavedText = null;
        businessspecialpage.specialInfoText = null;
        businessspecialpage.specialEmailSection = null;
        businessspecialpage.instructions = null;
        businessspecialpage.promoCode = null;
        businessspecialpage.printable = null;
        businessspecialpage.progressBar = null;
        businessspecialpage.specialLayout = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((BusinessSpecialPage)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((BusinessSpecialPage)obj);
    }

    public ()
    {
    }
}
