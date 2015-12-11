// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp:
//            BlackTieProtection

public class Services
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private BlackTieProtection blackTieProtection;

    public Services()
    {
    }

    public BlackTieProtection getBlackTieProtection()
    {
        return blackTieProtection;
    }

    public void setBlackTieProtection(BlackTieProtection blacktieprotection)
    {
        blackTieProtection = blacktieprotection;
    }
}
