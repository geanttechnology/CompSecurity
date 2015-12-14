// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;


// Referenced classes of package com.socialin.android.apiv3.request:
//            RequestParams

public class ParamWithUserData extends RequestParams
{

    public long userId;
    public String userIds;
    public String username;

    public ParamWithUserData()
    {
        userId = 0L;
    }
}
