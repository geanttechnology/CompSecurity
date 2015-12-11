// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface Decorations
{

    public abstract List getActionLabels();

    public abstract List getHeader();

    public abstract List getTracking();

    public abstract void setActionLabels(List list);

    public abstract void setHeader(List list);

    public abstract void setTracking(List list);
}
