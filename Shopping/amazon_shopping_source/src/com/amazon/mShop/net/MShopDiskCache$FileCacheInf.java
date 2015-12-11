// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.util.Map;

// Referenced classes of package com.amazon.mShop.net:
//            MShopDiskCache

public static class mHeaderFields
{

    public Map mHeaderFields;
    public Inf mLruInf;

    public Inf(Inf inf, Map map)
    {
        mLruInf = inf;
        mHeaderFields = map;
    }
}
