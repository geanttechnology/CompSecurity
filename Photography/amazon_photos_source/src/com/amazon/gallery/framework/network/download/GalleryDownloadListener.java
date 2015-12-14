// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import com.amazon.gallery.framework.model.ObjectID;

public interface GalleryDownloadListener
{

    public abstract void onProgress(ObjectID objectid, ObjectID objectid1, int i, int j);

    public abstract void onRequested(ObjectID objectid);
}
