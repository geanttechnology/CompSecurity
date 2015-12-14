// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;


// Referenced classes of package com.socialin.android.apiv3.request:
//            ParamWithPageLimit

public class GetItemsParams extends ParamWithPageLimit
{

    public int interesting;
    public double latitude;
    public double longitude;
    public int recent;
    public String searchLocation;
    public String searchNear;
    public String searchQuery;
    public String searchTag;
    public String type;

    public GetItemsParams()
    {
        interesting = 0;
        recent = 0;
    }
}
