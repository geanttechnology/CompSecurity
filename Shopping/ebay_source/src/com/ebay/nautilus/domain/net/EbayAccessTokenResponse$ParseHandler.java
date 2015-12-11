// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.ebay.nautilus.domain.datamapping.BaseDataMapped;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayAccessTokenResponse

static class  extends BaseDataMapped
{

    public String accessToken;
    public String error;
    public int expiresIn;
    public String refreshToken;
    public String tokenType;

    ()
    {
    }
}
