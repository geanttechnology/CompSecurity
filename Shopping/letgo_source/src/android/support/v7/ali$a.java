// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.net.http.HttpResponseCache;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            ali, alj

private static class onseCache
{

    static Object a(Context context)
        throws IOException
    {
        java.io.File file = alj.b(context);
        HttpResponseCache httpresponsecache = HttpResponseCache.getInstalled();
        context = httpresponsecache;
        if (httpresponsecache == null)
        {
            context = HttpResponseCache.install(file, alj.a(file));
        }
        return context;
    }
}
