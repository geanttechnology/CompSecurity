// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import java.util.Locale;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            Expression, DcsState

static final class rString extends rString
{

    public String eval(DcsState dcsstate)
    {
        String s = dcsstate.locale.getLanguage();
        dcsstate = s;
        if (s.length() > 2)
        {
            dcsstate = s.substring(0, 2);
        }
        return dcsstate;
    }

    rString()
    {
    }
}
