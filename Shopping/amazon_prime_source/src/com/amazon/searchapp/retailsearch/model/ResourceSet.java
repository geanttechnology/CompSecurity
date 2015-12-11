// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface ResourceSet
{

    public abstract String getId();

    public abstract List getImages();

    public abstract List getStrings();

    public abstract String getVersion();

    public abstract void setId(String s);

    public abstract void setImages(List list);

    public abstract void setStrings(List list);

    public abstract void setVersion(String s);
}
