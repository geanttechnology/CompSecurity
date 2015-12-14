// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.filter;


public interface DaoFilter
{

    public abstract Object getFilter();

    public abstract String getWhereClause();

    public abstract boolean isSet();
}
