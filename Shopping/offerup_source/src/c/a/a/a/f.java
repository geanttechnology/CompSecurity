// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package c.a.a.a:
//            d, e

final class f extends d
{

    private e a;

    f(e e1)
    {
        a = e1;
        super();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle)
    {
        a.a(activity);
    }

    public final void onActivityResumed(Activity activity)
    {
        a.a(activity);
    }

    public final void onActivityStarted(Activity activity)
    {
        a.a(activity);
    }
}
