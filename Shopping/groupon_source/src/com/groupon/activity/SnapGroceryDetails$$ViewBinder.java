// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import com.groupon.util.GrouponNavigationDrawerActivity;
import com.groupon.view.UrlImageView;

// Referenced classes of package com.groupon.activity:
//            SnapGroceryDetails, GrouponFragmentActivity

public class nder extends nder
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(ewbinder, (SnapGroceryDetails)grouponfragmentactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, SnapGroceryDetails snapgrocerydetails, Object obj)
    {
        super.bind(ewbinder, snapgrocerydetails, obj);
        snapgrocerydetails.groceryImage = (UrlImageView)ewbinder.ceryImage((View)ewbinder.View(obj, 0x7f10033a, "field 'groceryImage'"), 0x7f10033a, "field 'groceryImage'");
        snapgrocerydetails.groceryItemTitle = (TextView)ewbinder.ceryItemTitle((View)ewbinder.View(obj, 0x7f10033b, "field 'groceryItemTitle'"), 0x7f10033b, "field 'groceryItemTitle'");
        snapgrocerydetails.groceryCashBack = (TextView)ewbinder.ceryCashBack((View)ewbinder.View(obj, 0x7f10033c, "field 'groceryCashBack'"), 0x7f10033c, "field 'groceryCashBack'");
        snapgrocerydetails.instructionHeader = (TextView)ewbinder.tructionHeader((View)ewbinder.View(obj, 0x7f10033e, "field 'instructionHeader'"), 0x7f10033e, "field 'instructionHeader'");
        snapgrocerydetails.instructionDetails = (WebView)ewbinder.tructionDetails((View)ewbinder.View(obj, 0x7f10033f, "field 'instructionDetails'"), 0x7f10033f, "field 'instructionDetails'");
        snapgrocerydetails.offerHeader = (TextView)ewbinder.erHeader((View)ewbinder.View(obj, 0x7f100341, "field 'offerHeader'"), 0x7f100341, "field 'offerHeader'");
        snapgrocerydetails.offerDetails = (WebView)ewbinder.erDetails((View)ewbinder.View(obj, 0x7f100342, "field 'offerDetails'"), 0x7f100342, "field 'offerDetails'");
        snapgrocerydetails.productHeader = (TextView)ewbinder.ductHeader((View)ewbinder.View(obj, 0x7f100344, "field 'productHeader'"), 0x7f100344, "field 'productHeader'");
        snapgrocerydetails.productDetails = (WebView)ewbinder.ductDetails((View)ewbinder.View(obj, 0x7f100345, "field 'productDetails'"), 0x7f100345, "field 'productDetails'");
        snapgrocerydetails.finePrintHeader = (TextView)ewbinder.ePrintHeader((View)ewbinder.View(obj, 0x7f100338, "field 'finePrintHeader'"), 0x7f100338, "field 'finePrintHeader'");
        snapgrocerydetails.finePrint = (WebView)ewbinder.ePrint((View)ewbinder.View(obj, 0x7f100339, "field 'finePrint'"), 0x7f100339, "field 'finePrint'");
        snapgrocerydetails.redeemButton = (Button)ewbinder.eemButton((View)ewbinder.View(obj, 0x7f100336, "field 'redeemButton'"), 0x7f100336, "field 'redeemButton'");
        snapgrocerydetails.offerSection = (View)ewbinder.View(obj, 0x7f100340, "field 'offerSection'");
        snapgrocerydetails.productSection = (View)ewbinder.View(obj, 0x7f100343, "field 'productSection'");
        snapgrocerydetails.intructionSection = (View)ewbinder.View(obj, 0x7f10033d, "field 'intructionSection'");
        snapgrocerydetails.finePrintSection = (View)ewbinder.View(obj, 0x7f100337, "field 'finePrintSection'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (SnapGroceryDetails)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (SnapGroceryDetails)obj, obj1);
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((SnapGroceryDetails)grouponfragmentactivity);
    }

    public void unbind(SnapGroceryDetails snapgrocerydetails)
    {
        super.unbind(snapgrocerydetails);
        snapgrocerydetails.groceryImage = null;
        snapgrocerydetails.groceryItemTitle = null;
        snapgrocerydetails.groceryCashBack = null;
        snapgrocerydetails.instructionHeader = null;
        snapgrocerydetails.instructionDetails = null;
        snapgrocerydetails.offerHeader = null;
        snapgrocerydetails.offerDetails = null;
        snapgrocerydetails.productHeader = null;
        snapgrocerydetails.productDetails = null;
        snapgrocerydetails.finePrintHeader = null;
        snapgrocerydetails.finePrint = null;
        snapgrocerydetails.redeemButton = null;
        snapgrocerydetails.offerSection = null;
        snapgrocerydetails.productSection = null;
        snapgrocerydetails.intructionSection = null;
        snapgrocerydetails.finePrintSection = null;
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((SnapGroceryDetails)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((SnapGroceryDetails)obj);
    }

    public nder()
    {
    }
}
