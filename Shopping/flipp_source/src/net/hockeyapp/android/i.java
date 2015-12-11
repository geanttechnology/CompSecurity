// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import net.hockeyapp.android.e.e;
import net.hockeyapp.android.e.f;

// Referenced classes of package net.hockeyapp.android:
//            FeedbackActivity

final class i
    implements Runnable
{

    final FeedbackActivity a;

    i(FeedbackActivity feedbackactivity)
    {
        a = feedbackactivity;
        super();
    }

    public final void run()
    {
        f.a.a(a, null);
        a.a(false);
    }
}
