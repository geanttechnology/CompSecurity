// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;


// Referenced classes of package com.socialin.android.apiv3.request:
//            RequestParams

public class ParamWithItemId extends RequestParams
{

    public boolean isDesignItem;
    public long itemId;
    public int limit;
    public int offset;

    public ParamWithItemId()
    {
        isDesignItem = false;
        offset = -1;
        limit = 60;
    }
}
