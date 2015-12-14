// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.glide;

import com.amazon.gallery.framework.model.Persistable;
import com.bumptech.glide.Priority;
import java.io.File;

public interface ModelFetcher
{

    public abstract void cancel();

    public abstract String getId(Persistable persistable, int i, int j);

    public abstract File loadData(Persistable persistable, Priority priority, int i, int j);
}
