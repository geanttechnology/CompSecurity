// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import com.groupon.db.models.Pagination;
import com.groupon.db.models.Relevance;
import java.util.List;

public class DealsResponse
{

    public List dealSubsetAttributes;
    public List deals;
    public Pagination pagination;
    public Relevance relevanceService;

    public DealsResponse()
    {
    }
}
