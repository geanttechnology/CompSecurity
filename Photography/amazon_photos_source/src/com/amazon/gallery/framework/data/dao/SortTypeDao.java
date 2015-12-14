// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import java.util.Collection;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            MediaItemSortType

public interface SortTypeDao
{

    public abstract void deleteSortTags(Collection collection);

    public abstract MediaItemSortType getSortTypeById(String s);

    public abstract void saveSortTypeById(String s, MediaItemSortType mediaitemsorttype);
}
