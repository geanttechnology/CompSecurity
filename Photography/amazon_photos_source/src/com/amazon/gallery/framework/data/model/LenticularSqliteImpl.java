// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.model;

import com.amazon.gallery.framework.data.dao.mediaitem.AbstractOrderedGroupPhotoSqlite;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.LocalMediaItemDaoSqliteImpl;
import com.amazon.gallery.framework.model.media.GroupType;

public class LenticularSqliteImpl extends AbstractOrderedGroupPhotoSqlite
{

    public LenticularSqliteImpl(LocalMediaItemDaoSqliteImpl localmediaitemdaosqliteimpl)
    {
        super(localmediaitemdaosqliteimpl);
    }

    public GroupType getGroupType()
    {
        return GroupType.LENTICULAR;
    }
}
