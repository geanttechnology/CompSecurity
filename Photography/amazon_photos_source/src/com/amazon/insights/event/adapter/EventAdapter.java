// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.event.adapter;

import com.amazon.insights.event.InternalEvent;

public interface EventAdapter
{

    public abstract Object translateFromEvent(InternalEvent internalevent);
}
