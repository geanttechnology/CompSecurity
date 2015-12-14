// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.framework.data.dao.SortOrder;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            CursorRowDataProvider, GalleryDBConnectionManager, CursorRowProcessor

public static class connectionManager
{

    private String columns[];
    private GalleryDBConnectionManager connectionManager;
    private String groupBy;
    private String having;
    private String orderBy;
    private CursorRowProcessor rowProcessor;
    private String selection;
    private String selectionArgs[];
    private String table;

    public CursorRowDataProvider build()
    {
        boolean flag1 = true;
        boolean flag;
        if (rowProcessor != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertTrue(flag);
        if (table != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertTrue(flag);
        if (columns != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        DebugAssert.assertTrue(flag);
        return new CursorRowDataProvider(connectionManager, rowProcessor, table, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public orderBy from(String s)
    {
        table = s;
        return this;
    }

    public table groupBy(String s)
    {
        groupBy = s;
        return this;
    }

    public groupBy orderBy(SortOrder sortorder)
    {
        orderBy = sortorder.getOrderByString();
        return this;
    }

    public orderBy orderBy(String s)
    {
        orderBy = s;
        return this;
    }

    public transient orderBy select(String as[])
    {
        columns = as;
        return this;
    }

    public columns setRowProcessor(CursorRowProcessor cursorrowprocessor)
    {
        rowProcessor = cursorrowprocessor;
        return this;
    }

    public transient rowProcessor where(String s, String as[])
    {
        selection = s;
        selectionArgs = as;
        return this;
    }

    public (GalleryDBConnectionManager gallerydbconnectionmanager)
    {
        connectionManager = gallerydbconnectionmanager;
    }
}
