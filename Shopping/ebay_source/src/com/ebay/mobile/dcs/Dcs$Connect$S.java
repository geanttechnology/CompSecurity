// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.nautilus.domain.dcs.DcsPropString;
import com.ebay.nautilus.domain.dcs.DcsState;

// Referenced classes of package com.ebay.mobile.dcs:
//            Dcs

public static final class defaultValue extends Enum
    implements DcsPropString
{

    private static final ocsSsoScope $VALUES[];
    public static final ocsSsoScope ocsSsoScope;
    public static final ocsSsoScope ocsUrl;
    public static final ocsSsoScope privacyNoticeUrl;
    public static final ocsSsoScope userAgreementUrl;
    private final String defaultValue;
    private final String key;

    public static opString valueOf(String s)
    {
        return (opString)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Connect$S, s);
    }

    public static opString[] values()
    {
        return (opString[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        dcsstate = dcsstate.ebayCountry;
        switch (ap.com.ebay.mobile.dcs.Dcs.Connect.S[ordinal()])
        {
        default:
            return defaultValue;

        case 1: // '\001'
            return com.ebay.common.view.util.ager.Default.getEulaUrl(dcsstate);

        case 2: // '\002'
            return com.ebay.common.view.util.ager.Default.getPrivacyUrl(dcsstate);

        case 3: // '\003'
            return com.ebay.common.view.util.ager.Default.getOcsUrl(dcsstate);
        }
    }

    public String key()
    {
        return key;
    }

    static 
    {
        userAgreementUrl = new <init>("userAgreementUrl", 0);
        privacyNoticeUrl = new <init>("privacyNoticeUrl", 1);
        ocsUrl = new <init>("ocsUrl", 2);
        ocsSsoScope = new <init>("ocsSsoScope", 3, "//EBAYSSO/EBAYCLASSIC");
        $VALUES = (new .VALUES[] {
            userAgreementUrl, privacyNoticeUrl, ocsUrl, ocsSsoScope
        });
    }

    private ate(String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("connect.").append(name()).toString();
        defaultValue = null;
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("connect.").append(name()).toString();
        defaultValue = s1;
    }
}
