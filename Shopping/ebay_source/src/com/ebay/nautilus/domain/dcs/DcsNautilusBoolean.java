// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropBoolean, DcsState

public final class DcsNautilusBoolean extends Enum
    implements DcsPropBoolean
{

    private static final DcsNautilusBoolean $VALUES[];
    public static final DcsNautilusBoolean DRAFTS_ANDROID_MOTORS_APP;
    public static final DcsNautilusBoolean DRAFTS_BEAR;
    public static final DcsNautilusBoolean DRAFTS_CUB;
    public static final DcsNautilusBoolean DRAFTS_IPAD;
    public static final DcsNautilusBoolean DRAFTS_IPHONE;
    public static final DcsNautilusBoolean DRAFTS_SYI;
    public static final DcsNautilusBoolean DRAFTS_WEBNEXT;
    public static final DcsNautilusBoolean DRAFTS_WINDOWS8;
    public static final DcsNautilusBoolean DRAFTS_WINDOWS8_PHONE;
    public static final DcsNautilusBoolean GBH;
    public static final DcsNautilusBoolean HttpClientFallback;
    public static final DcsNautilusBoolean PROX;
    public static final DcsNautilusBoolean PUDO;
    public static final DcsNautilusBoolean PayPalDyson;
    public static final DcsNautilusBoolean QA_ENABLED;
    public static final DcsNautilusBoolean SellDefaultBestOffer;
    public static final DcsNautilusBoolean SellPrefillPaypalEmail;
    public static final DcsNautilusBoolean SellPrefillSpecifics;
    public static final DcsNautilusBoolean SellShippingGuidance;
    public static final DcsNautilusBoolean SiteSpeedSendData;
    public static final DcsNautilusBoolean ThreatMatrixRiskModule;
    public static final DcsNautilusBoolean UseZoomImageService;
    public static final DcsNautilusBoolean payments_showEekRatings;
    public static final DcsNautilusBoolean payments_showItemSpecifics;
    public static final DcsNautilusBoolean searchFollowEnablePersistentCache;
    public static final DcsNautilusBoolean searchFollowRequestUsernameField;
    private final Object defaultValue;

    private DcsNautilusBoolean(String s, int i)
    {
        super(s, i);
        defaultValue = Boolean.FALSE;
    }

    private DcsNautilusBoolean(String s, int i, String s1)
    {
        super(s, i);
        defaultValue = s1;
    }

    private DcsNautilusBoolean(String s, int i, boolean flag)
    {
        super(s, i);
        defaultValue = Boolean.valueOf(flag);
    }

    public static DcsNautilusBoolean valueOf(String s)
    {
        return (DcsNautilusBoolean)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsNautilusBoolean, s);
    }

    public static DcsNautilusBoolean[] values()
    {
        return (DcsNautilusBoolean[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        return defaultValue;
    }

    public String key()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusBoolean[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusBoolean = new int[DcsNautilusBoolean.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusBoolean[DcsNautilusBoolean.SellDefaultBestOffer.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusBoolean[DcsNautilusBoolean.SiteSpeedSendData.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusBoolean[DcsNautilusBoolean.ThreatMatrixRiskModule.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusBoolean[DcsNautilusBoolean.PayPalDyson.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.dcs.DcsNautilusBoolean[ordinal()])
        {
        default:
            return name();

        case 1: // '\001'
            return "Sell.DefaultBestOffer";

        case 2: // '\002'
            return "SiteSpeed.sendData";

        case 3: // '\003'
            return "tmx.risk.module";

        case 4: // '\004'
            return "paypal.dyson";
        }
    }

    static 
    {
        QA_ENABLED = new DcsNautilusBoolean("QA_ENABLED", 0);
        SiteSpeedSendData = new DcsNautilusBoolean("SiteSpeedSendData", 1);
        UseZoomImageService = new DcsNautilusBoolean("UseZoomImageService", 2);
        GBH = new DcsNautilusBoolean("GBH", 3, true);
        PUDO = new DcsNautilusBoolean("PUDO", 4);
        ThreatMatrixRiskModule = new DcsNautilusBoolean("ThreatMatrixRiskModule", 5);
        PayPalDyson = new DcsNautilusBoolean("PayPalDyson", 6);
        HttpClientFallback = new DcsNautilusBoolean("HttpClientFallback", 7);
        searchFollowEnablePersistentCache = new DcsNautilusBoolean("searchFollowEnablePersistentCache", 8, true);
        searchFollowRequestUsernameField = new DcsNautilusBoolean("searchFollowRequestUsernameField", 9, true);
        PROX = new DcsNautilusBoolean("PROX", 10);
        payments_showEekRatings = new DcsNautilusBoolean("payments_showEekRatings", 11);
        payments_showItemSpecifics = new DcsNautilusBoolean("payments_showItemSpecifics", 12);
        DRAFTS_ANDROID_MOTORS_APP = new DcsNautilusBoolean("DRAFTS_ANDROID_MOTORS_APP", 13, true);
        DRAFTS_SYI = new DcsNautilusBoolean("DRAFTS_SYI", 14, true);
        DRAFTS_WEBNEXT = new DcsNautilusBoolean("DRAFTS_WEBNEXT", 15, true);
        DRAFTS_IPHONE = new DcsNautilusBoolean("DRAFTS_IPHONE", 16, true);
        DRAFTS_IPAD = new DcsNautilusBoolean("DRAFTS_IPAD", 17, true);
        DRAFTS_WINDOWS8 = new DcsNautilusBoolean("DRAFTS_WINDOWS8", 18, true);
        DRAFTS_WINDOWS8_PHONE = new DcsNautilusBoolean("DRAFTS_WINDOWS8_PHONE", 19, true);
        DRAFTS_BEAR = new DcsNautilusBoolean("DRAFTS_BEAR", 20, true);
        DRAFTS_CUB = new DcsNautilusBoolean("DRAFTS_CUB", 21, true);
        SellDefaultBestOffer = new DcsNautilusBoolean("SellDefaultBestOffer", 22);
        SellPrefillPaypalEmail = new DcsNautilusBoolean("SellPrefillPaypalEmail", 23);
        SellShippingGuidance = new DcsNautilusBoolean("SellShippingGuidance", 24, "${prefCountry} in 'AU,DE,GB,US'");
        SellPrefillSpecifics = new DcsNautilusBoolean("SellPrefillSpecifics", 25, "${prefCountry} in 'AU,DE,GB,IN,US'");
        $VALUES = (new DcsNautilusBoolean[] {
            QA_ENABLED, SiteSpeedSendData, UseZoomImageService, GBH, PUDO, ThreatMatrixRiskModule, PayPalDyson, HttpClientFallback, searchFollowEnablePersistentCache, searchFollowRequestUsernameField, 
            PROX, payments_showEekRatings, payments_showItemSpecifics, DRAFTS_ANDROID_MOTORS_APP, DRAFTS_SYI, DRAFTS_WEBNEXT, DRAFTS_IPHONE, DRAFTS_IPAD, DRAFTS_WINDOWS8, DRAFTS_WINDOWS8_PHONE, 
            DRAFTS_BEAR, DRAFTS_CUB, SellDefaultBestOffer, SellPrefillPaypalEmail, SellShippingGuidance, SellPrefillSpecifics
        });
    }
}
