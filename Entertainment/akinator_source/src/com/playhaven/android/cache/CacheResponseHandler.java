// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android.cache;

import com.playhaven.android.PlayHavenException;
import java.net.URL;

// Referenced classes of package com.playhaven.android.cache:
//            CachedInfo

public interface CacheResponseHandler
{

    public abstract void cacheFail(URL url, PlayHavenException playhavenexception);

    public transient abstract void cacheSuccess(CachedInfo acachedinfo[]);
}
