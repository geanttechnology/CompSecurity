// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            CursorListFactory, DataProviderAsyncCursorList, GalleryDBConnectionManager, CursorListDataProvider

public class CursorListFactoryImpl
    implements CursorListFactory
{

    private final GalleryDBConnectionManager connectionManager;

    public CursorListFactoryImpl(GalleryDBConnectionManager gallerydbconnectionmanager)
    {
        connectionManager = gallerydbconnectionmanager;
    }

    public List createCursorList(CursorListDataProvider cursorlistdataprovider)
    {
        return new DataProviderAsyncCursorList(cursorlistdataprovider, connectionManager, 64);
    }

    public Iterable createIterator(CursorListDataProvider cursorlistdataprovider)
    {
        return new DataProviderAsyncCursorList(cursorlistdataprovider, connectionManager, 7168);
    }
}
