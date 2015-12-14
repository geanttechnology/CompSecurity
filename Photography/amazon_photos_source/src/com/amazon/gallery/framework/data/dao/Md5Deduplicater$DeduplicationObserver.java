// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            Md5Deduplicater

public static interface Q
{

    public abstract boolean isObserverActive();

    public abstract void onDeduplicationFinished(List list);

    public abstract void onDuplicatesFound(List list, long l);

    public abstract void onUpdateProgress(long l);
}
