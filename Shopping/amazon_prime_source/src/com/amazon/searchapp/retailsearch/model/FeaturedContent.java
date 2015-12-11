// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface FeaturedContent
{

    public abstract List getContent();

    public abstract String getDescription();

    public abstract int getPosition();

    public abstract int getPriority();

    public abstract String getStyle();

    public abstract String getTitle();

    public abstract void setContent(List list);

    public abstract void setDescription(String s);

    public abstract void setPosition(int i);

    public abstract void setPriority(int i);

    public abstract void setStyle(String s);

    public abstract void setTitle(String s);
}
