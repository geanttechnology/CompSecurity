// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util.video;

import co.vine.android.network.HttpResult;
import java.util.HashMap;

// Referenced classes of package co.vine.android.util.video:
//            VideoCache, VideoKey

public interface VideoListener
{

    public abstract void onVideoPathError(VideoCache videocache, VideoKey videokey, HttpResult httpresult);

    public abstract void onVideoPathObtained(VideoCache videocache, HashMap hashmap);
}
