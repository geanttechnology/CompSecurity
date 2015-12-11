// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;

// Referenced classes of package android.support.v4.app:
//            p, o

final class n
{

    private static SharedElementCallback a(o o)
    {
        p p1 = null;
        if (o != null)
        {
            p1 = new p(o);
        }
        return p1;
    }

    public static void a(Activity activity)
    {
        activity.finishAfterTransition();
    }

    public static void a(Activity activity, o o)
    {
        activity.setEnterSharedElementCallback(a(o));
    }

    public static void b(Activity activity)
    {
        activity.postponeEnterTransition();
    }

    public static void b(Activity activity, o o)
    {
        activity.setExitSharedElementCallback(a(o));
    }

    public static void c(Activity activity)
    {
        activity.startPostponedEnterTransition();
    }
}
