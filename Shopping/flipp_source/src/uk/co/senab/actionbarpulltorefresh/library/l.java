// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.actionbarpulltorefresh.library;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;

// Referenced classes of package uk.co.senab.actionbarpulltorefresh.library:
//            e, j

final class l
    implements e
{

    final j a;

    l(j j)
    {
        a = j;
        super();
    }

    public final Context a(Activity activity)
    {
        Object obj = null;
        Context context = obj;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            ActionBar actionbar = activity.getActionBar();
            context = obj;
            if (actionbar != null)
            {
                context = actionbar.getThemedContext();
            }
        }
        if (context == null)
        {
            return activity;
        } else
        {
            return context;
        }
    }
}
