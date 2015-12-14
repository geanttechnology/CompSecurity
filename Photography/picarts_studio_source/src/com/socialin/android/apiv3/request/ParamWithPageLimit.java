// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;


// Referenced classes of package com.socialin.android.apiv3.request:
//            ParamWithUserData

public class ParamWithPageLimit extends ParamWithUserData
{

    public int contentRating;
    public long lastId;
    public int limit;
    public int offset;

    public ParamWithPageLimit()
    {
        offset = -1;
        limit = -1;
        lastId = 0L;
    }
}
