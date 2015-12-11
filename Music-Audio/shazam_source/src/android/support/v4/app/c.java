// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package android.support.v4.app:
//            d

public class c
{
    private static final class a extends c
    {

        private final d a;

        public final Bundle a()
        {
            return a.a.toBundle();
        }

        a(d d1)
        {
            a = d1;
        }
    }


    protected c()
    {
    }

    public static c a(Activity activity, View view, String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return new a(new d(ActivityOptions.makeSceneTransitionAnimation(activity, view, s)));
        } else
        {
            return new c();
        }
    }

    public Bundle a()
    {
        return null;
    }
}
