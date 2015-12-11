// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface Domain
{

    public abstract List getDomains();

    public abstract String getId();

    public abstract String getLabel();

    public abstract String getValue();

    public abstract void setDomains(List list);

    public abstract void setId(String s);

    public abstract void setLabel(String s);

    public abstract void setValue(String s);
}
