// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.tag;

import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.model.tags.TagType;

public interface TagTagTypeObserver
{

    public abstract void onTagsChanged(TagType tagtype, ChangeList changelist);
}
