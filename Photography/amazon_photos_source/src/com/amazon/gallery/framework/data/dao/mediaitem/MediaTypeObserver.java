// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.mediaitem;

import com.amazon.gallery.framework.model.media.MediaType;

public interface MediaTypeObserver
{

    public abstract void onMediaItemCollectionChanged(MediaType mediatype);
}
