// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import com.target.ui.analytics.a.h;
import com.target.ui.analytics.b.c;
import com.target.ui.analytics.b.d;
import com.target.ui.analytics.b.e;
import com.target.ui.analytics.b.f;
import com.target.ui.analytics.b.g;
import com.target.ui.analytics.b.i;
import com.target.ui.analytics.b.j;
import com.target.ui.analytics.b.k;
import com.target.ui.analytics.d.b;
import com.target.ui.d.a;

// Referenced classes of package de.greenrobot.event:
//            SubscriberIndex, SubscriberMethod, ThreadMode, NoSubscriberEvent

class GeneratedSubscriberIndex extends SubscriberIndex
{

    GeneratedSubscriberIndex()
    {
    }

    SubscriberMethod[] createSubscribersFor(Class class1)
    {
        if (class1 == com/target/ui/d/a)
        {
            return (new SubscriberMethod[] {
                createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/d, ThreadMode.PostThread, 0, false)
            });
        }
        if (class1 == com/target/ui/analytics/c/a)
        {
            return (new SubscriberMethod[] {
                createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/i, ThreadMode.PostThread, 0, false)
            });
        }
        if (class1 == com/target/ui/analytics/d/b)
        {
            return (new SubscriberMethod[] {
                createSubscriberMethod(class1, "onHighProfileHandledErrorEvent", com/target/ui/analytics/b/b, ThreadMode.BackgroundThread, 0, false)
            });
        }
        if (class1 == com/target/ui/util/c/a$c)
        {
            return (new SubscriberMethod[] {
                createSubscriberMethod(class1, "onEvent", de/greenrobot/event/NoSubscriberEvent, ThreadMode.PostThread, 0, false)
            });
        }
        if (class1 == com/target/ui/analytics/a/h)
        {
            return (new SubscriberMethod[] {
                createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/e, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/g, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/i, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/j, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/k, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/h, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/c, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/f, ThreadMode.BackgroundThread, 0, false)
            });
        }
        if (class1 == com/target/ui/j/c)
        {
            return (new SubscriberMethod[] {
                createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/e, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/g, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/i, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/j, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/k, ThreadMode.BackgroundThread, 0, false), createSubscriberMethod(class1, "onEvent", com/target/ui/analytics/b/h, ThreadMode.BackgroundThread, 0, false)
            });
        } else
        {
            return null;
        }
    }
}
