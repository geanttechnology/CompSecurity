// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.model;

import java.util.ArrayList;
import java.util.List;

public class ContentRowModel
{

    private final int columns;
    private final List content;
    private final int spacing;

    public ContentRowModel(ContentRowModel contentrowmodel)
    {
        this(((List) (new ArrayList(contentrowmodel.getContent()))), contentrowmodel.getColumns(), contentrowmodel.getSpacing());
    }

    public ContentRowModel(List list, int i, int j)
    {
        content = list;
        spacing = j;
        columns = i;
    }

    public int getColumns()
    {
        return columns;
    }

    public List getContent()
    {
        return content;
    }

    public int getSpacing()
    {
        return spacing;
    }
}
