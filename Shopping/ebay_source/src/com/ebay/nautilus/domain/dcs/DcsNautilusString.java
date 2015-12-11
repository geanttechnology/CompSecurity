// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropString, DcsState

public final class DcsNautilusString extends Enum
    implements DcsPropString
{

    private static final DcsNautilusString $VALUES[];
    public static final DcsNautilusString MerchandiseImageRewriterType;
    public static final DcsNautilusString SellCharityDonationDefault;
    public static final DcsNautilusString ThumbnailHost;
    public static final DcsNautilusString ViewItemImageRewriterType;
    public static final DcsNautilusString ZoomDefaultImageFormat;
    public static final DcsNautilusString ZoomGalleryUrl;
    public static final DcsNautilusString ZoomMerchUrl;
    public static final DcsNautilusString ZoomViewItemUrl;
    private final String defaultValue;

    private DcsNautilusString(String s, int i)
    {
        super(s, i);
        defaultValue = null;
    }

    private DcsNautilusString(String s, int i, String s1)
    {
        super(s, i);
        defaultValue = s1;
    }

    public static DcsNautilusString valueOf(String s)
    {
        return (DcsNautilusString)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsNautilusString, s);
    }

    public static DcsNautilusString[] values()
    {
        return (DcsNautilusString[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        return defaultValue;
    }

    public String key()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusString[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusString = new int[DcsNautilusString.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusString[DcsNautilusString.SellCharityDonationDefault.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.dcs.DcsNautilusString[ordinal()])
        {
        default:
            return name();

        case 1: // '\001'
            return "Sell.CharityDonationDefault";
        }
    }

    static 
    {
        ThumbnailHost = new DcsNautilusString("ThumbnailHost", 0);
        ZoomGalleryUrl = new DcsNautilusString("ZoomGalleryUrl", 1, "i.ebayimg.com");
        ZoomViewItemUrl = new DcsNautilusString("ZoomViewItemUrl", 2, "i.ebayimg.com");
        ZoomMerchUrl = new DcsNautilusString("ZoomMerchUrl", 3, "i.ebayimg.com");
        ZoomDefaultImageFormat = new DcsNautilusString("ZoomDefaultImageFormat", 4, "jpg");
        MerchandiseImageRewriterType = new DcsNautilusString("MerchandiseImageRewriterType", 5, com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType.ZOOM_MERCH.name());
        ViewItemImageRewriterType = new DcsNautilusString("ViewItemImageRewriterType", 6, com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType.EPS.name());
        SellCharityDonationDefault = new DcsNautilusString("SellCharityDonationDefault", 7, "25");
        $VALUES = (new DcsNautilusString[] {
            ThumbnailHost, ZoomGalleryUrl, ZoomViewItemUrl, ZoomMerchUrl, ZoomDefaultImageFormat, MerchandiseImageRewriterType, ViewItemImageRewriterType, SellCharityDonationDefault
        });
    }
}
