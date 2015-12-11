// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.groupon.view:
//            MapSliceImprovedView, UrlImageView

public class 
    implements butterknife.nder
{

    public void bind(butterknife.nder nder, MapSliceImprovedView mapsliceimprovedview, Object obj)
    {
        mapsliceimprovedview.imageContainer = (View)nder.ew(obj, 0x7f1002c5, "field 'imageContainer'");
        mapsliceimprovedview.image = (UrlImageView)nder.ew((View)nder.ew(obj, 0x7f100076, "field 'image'"), 0x7f100076, "field 'image'");
        mapsliceimprovedview.message = (TextView)nder.((View)nder.ew(obj, 0x7f10027c, "field 'message'"), 0x7f10027c, "field 'message'");
        mapsliceimprovedview.vendorAddressContainer = (View)nder.ew(obj, 0x7f1003f4, "field 'vendorAddressContainer'");
        mapsliceimprovedview.vendorAddressView = (TextView)nder.ddressView((View)nder.ew(obj, 0x7f1003f5, "field 'vendorAddressView'"), 0x7f1003f5, "field 'vendorAddressView'");
        mapsliceimprovedview.multipleLocationsContainer = (View)nder.ew(obj, 0x7f1003f6, "field 'multipleLocationsContainer'");
        mapsliceimprovedview.multipleLocationsView = (View)nder.ew(obj, 0x7f1003f7, "field 'multipleLocationsView'");
        mapsliceimprovedview.multipleLocationsCountView = (TextView)nder.eLocationsCountView((View)nder.ew(obj, 0x7f1003f8, "field 'multipleLocationsCountView'"), 0x7f1003f8, "field 'multipleLocationsCountView'");
        mapsliceimprovedview.vendorPhoneContainer = (View)nder.ew(obj, 0x7f1003f9, "field 'vendorPhoneContainer'");
        mapsliceimprovedview.vendorPhoneView = (TextView)nder.honeView((View)nder.ew(obj, 0x7f1003fa, "field 'vendorPhoneView'"), 0x7f1003fa, "field 'vendorPhoneView'");
        mapsliceimprovedview.vendorUrlContainer = (View)nder.ew(obj, 0x7f1003fc, "field 'vendorUrlContainer'");
        mapsliceimprovedview.vendorUrlView = (TextView)nder.rlView((View)nder.ew(obj, 0x7f100351, "field 'vendorUrlView'"), 0x7f100351, "field 'vendorUrlView'");
        mapsliceimprovedview.phoneUrlDivider = (View)nder.ew(obj, 0x7f1003fb, "field 'phoneUrlDivider'");
    }

    public volatile void bind(butterknife.nder nder, Object obj, Object obj1)
    {
        bind(nder, (MapSliceImprovedView)obj, obj1);
    }

    public void unbind(MapSliceImprovedView mapsliceimprovedview)
    {
        mapsliceimprovedview.imageContainer = null;
        mapsliceimprovedview.image = null;
        mapsliceimprovedview.message = null;
        mapsliceimprovedview.vendorAddressContainer = null;
        mapsliceimprovedview.vendorAddressView = null;
        mapsliceimprovedview.multipleLocationsContainer = null;
        mapsliceimprovedview.multipleLocationsView = null;
        mapsliceimprovedview.multipleLocationsCountView = null;
        mapsliceimprovedview.vendorPhoneContainer = null;
        mapsliceimprovedview.vendorPhoneView = null;
        mapsliceimprovedview.vendorUrlContainer = null;
        mapsliceimprovedview.vendorUrlView = null;
        mapsliceimprovedview.phoneUrlDivider = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((MapSliceImprovedView)obj);
    }

    public ()
    {
    }
}
