// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.disk;

import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.concurrent.Future;

// Referenced classes of package com.amazon.gallery.framework.network.disk:
//            ContentLoadCallback

public interface NetworkStore
{

    public abstract Future loadContent(MediaItem mediaitem, ContentLoadCallback contentloadcallback, boolean flag);

    public abstract boolean loadContentSynchronously(MediaItem mediaitem, int i, int j, ScaleMode scalemode, com.amazon.gallery.framework.data.store.Asset.AssetType assettype, boolean flag);

    public abstract boolean loadContentSynchronously(MediaItem mediaitem, boolean flag);
}
