// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.entry;

import com.amazon.retailsearch.android.ui.listadapter.ModelViewEntry;
import com.amazon.retailsearch.android.ui.results.layout.model.ContentRowModel;
import com.amazon.retailsearch.android.ui.results.layout.view.ContentRow;

public class ContentRowEntry extends ModelViewEntry
{

    public ContentRowEntry(int i, ContentRowModel contentrowmodel)
    {
        super(i, com/amazon/retailsearch/android/ui/results/layout/view/ContentRow, contentrowmodel);
    }

    public ContentRowEntry(ContentRowEntry contentrowentry)
    {
        this(contentrowentry.getType(), new ContentRowModel((ContentRowModel)contentrowentry.getModel()));
    }
}
