// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface ActionLabel
{

    public abstract List getLabel();

    public abstract String getType();

    public abstract void setLabel(List list);

    public abstract void setType(String s);
}
