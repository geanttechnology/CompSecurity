// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            CursorListDataProvider

public interface CursorListFactory
{

    public abstract List createCursorList(CursorListDataProvider cursorlistdataprovider);

    public abstract Iterable createIterator(CursorListDataProvider cursorlistdataprovider);
}
