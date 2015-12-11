// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import com.groupon.db.models.DealSummary;

public interface DealClickListener
{

    public abstract void onDealClicked(int i, DealSummary dealsummary);
}
