// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.deduplicate;

import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.List;

public interface Deduplicater
{

    public abstract List getCloudDuplicates(MediaItem mediaitem);

    public abstract List getLocalDuplicates(MediaItem mediaitem);

    public abstract void onAccountRegistered();
}
