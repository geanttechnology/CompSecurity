// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util.image;

import co.vine.android.network.HttpResult;
import java.util.HashMap;

// Referenced classes of package co.vine.android.util.image:
//            PhotoImagesCache, ImageKey

public interface PhotoImagesListener
{

    public abstract void onPhotoImageError(PhotoImagesCache photoimagescache, ImageKey imagekey, HttpResult httpresult);

    public abstract void onPhotoImageLoaded(PhotoImagesCache photoimagescache, HashMap hashmap);
}
