// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;


// Referenced classes of package com.socialin.android.apiv3.request:
//            ParamWithPageLimit

public class ContestParams extends ParamWithPageLimit
{

    public static final String ORDER_EDITOR = "editor";
    public static final String ORDER_ME = "submissions";
    public static final String ORDER_RECENT = "recent";
    public static final String ORDER_TOP = "top";
    public static final String ORDER_TRENDING = "trending";
    public static final String ORDER_WINNERS = "winners";
    public String contestName;
    public String order;
    public long photoId;
    public String type;
    public int votePlace;

    public ContestParams()
    {
    }
}
