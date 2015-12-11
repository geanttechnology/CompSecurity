// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.t;
import java.util.List;

public class ah extends t
{

    public List feedListItems;

    public String toString()
    {
        return (new StringBuilder()).append("ListFeedResponse [mResponse=").append(a).append(", feedListItems=").append(feedListItems).append("]").toString();
    }
}
