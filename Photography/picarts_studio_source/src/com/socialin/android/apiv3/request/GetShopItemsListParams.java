// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;


// Referenced classes of package com.socialin.android.apiv3.request:
//            ParamWithUserData

public class GetShopItemsListParams extends ParamWithUserData
{

    public int limit;
    public int offset;
    public String price;
    public String tag;

    public GetShopItemsListParams()
    {
        limit = -1;
        price = "";
        tag = "";
    }
}
