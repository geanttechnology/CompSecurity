// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.model.page_item.interfaces.TrackingInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            e, i, s, y

public class ac extends e
{
    private static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a InternalPromo;
        public static final a PdpDeepLink;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/target/ui/analytics/a/ac$a, s1);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            InternalPromo = new a("InternalPromo", 0);
            PdpDeepLink = new a("PdpDeepLink", 1);
            $VALUES = (new a[] {
                InternalPromo, PdpDeepLink
            });
        }

        private a(String s1, int j)
        {
            super(s1, j);
        }
    }


    private final Integer mColumn;
    private final a mPageItemType;
    private final ProductIdentifier mProductIdentifier;
    private final Integer mRow;
    private final TrackingInfo mTrackingInfo;

    private ac(a a1, TrackingInfo trackinginfo, ProductIdentifier productidentifier, Integer integer, Integer integer1)
    {
        mTrackingInfo = trackinginfo;
        mProductIdentifier = productidentifier;
        mPageItemType = a1;
        mRow = integer;
        mColumn = integer1;
    }

    public static ac a(ProductIdentifier productidentifier)
    {
        return new ac(a.PdpDeepLink, null, productidentifier, null, null);
    }

    public static ac a(TrackingInfo trackinginfo, int j, int k)
    {
        return new ac(a.InternalPromo, trackinginfo, null, Integer.valueOf(j), Integer.valueOf(k));
    }

    private String a(ProductIdentifier productidentifier, TrackingInfo trackinginfo)
    {
        if (productidentifier == null && trackinginfo == null)
        {
            return null;
        }
        if (productidentifier != null)
        {
            return b(productidentifier);
        } else
        {
            return trackinginfo.a();
        }
    }

    private String a(TrackingInfo trackinginfo)
    {
        if (trackinginfo == null)
        {
            return null;
        } else
        {
            return trackinginfo.a();
        }
    }

    private String a(Integer integer, Integer integer1)
    {
        if (integer == null || integer1 == null)
        {
            return null;
        } else
        {
            return String.format("r%dc%d", new Object[] {
                mRow, mColumn
            });
        }
    }

    private String b(ProductIdentifier productidentifier)
    {
        if (productidentifier == null)
        {
            return "";
        }
        com.target.mothership.common.product.ProductIdentifier.a a1 = productidentifier.a();
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[];
            static final int $SwitchMap$com$target$ui$analytics$brighttag$TapFeaturedEvent$PageItemType[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType = new int[com.target.mothership.common.product.ProductIdentifier.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[com.target.mothership.common.product.ProductIdentifier.a.TCIN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[com.target.mothership.common.product.ProductIdentifier.a.DPCI.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[com.target.mothership.common.product.ProductIdentifier.a.UPC.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[com.target.mothership.common.product.ProductIdentifier.a.CATENTRYID.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[com.target.mothership.common.product.ProductIdentifier.a.BARCODE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$target$ui$analytics$brighttag$TapFeaturedEvent$PageItemType = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapFeaturedEvent$PageItemType[a.InternalPromo.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapFeaturedEvent$PageItemType[a.PdpDeepLink.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.product.ProductIdentifier.ProductIdType[a1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
        case 2: // '\002'
            return productidentifier.b();
        }
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "tapActionName", a(mProductIdentifier, mTrackingInfo));
        com.target.ui.analytics.a.i.a(map, "internalPromotionID", a(mTrackingInfo));
        com.target.ui.analytics.a.i.a(map, "linkPosition", a(mRow, mColumn));
        return map;
    }

    protected s c()
    {
        return s.Featured;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected y i()
    {
        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapFeaturedEvent.PageItemType[mPageItemType.ordinal()])
        {
        default:
            return y.Unknown;

        case 1: // '\001'
            return y.FeaturedInternalPromo;

        case 2: // '\002'
            return y.FeaturedProduct;
        }
    }
}
