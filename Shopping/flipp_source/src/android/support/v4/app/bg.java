// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

// Referenced classes of package android.support.v4.app:
//            bf, bh

final class bg extends bf
{

    bg()
    {
    }

    public final Intent a(Activity activity)
    {
        Intent intent1 = bh.a(activity);
        Intent intent = intent1;
        if (intent1 == null)
        {
            intent = super.a(activity);
        }
        return intent;
    }

    public final String a(Context context, ActivityInfo activityinfo)
    {
        String s1 = bh.a(activityinfo);
        String s = s1;
        if (s1 == null)
        {
            s = super.a(context, activityinfo);
        }
        return s;
    }

    public final boolean a(Activity activity, Intent intent)
    {
        return bh.a(activity, intent);
    }
}
