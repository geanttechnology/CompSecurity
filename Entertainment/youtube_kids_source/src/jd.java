// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaRouter;
import java.lang.reflect.Method;

public final class jd
{

    Method a;

    public jd()
    {
        if (android.os.Build.VERSION.SDK_INT < 16 || android.os.Build.VERSION.SDK_INT > 17)
        {
            throw new UnsupportedOperationException();
        }
        try
        {
            a = android/media/MediaRouter.getMethod("selectRouteInt", new Class[] {
                Integer.TYPE, android/media/MediaRouter$RouteInfo
            });
            return;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return;
        }
    }
}
