// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage;

import android.app.Activity;
import android.app.Application;
import android.os.PowerManager;
import io.presage.activities.PresageActivity;
import io.presage.new.b;
import io.presage.utils.e;

// Referenced classes of package io.presage:
//            Presage

final class g
    implements b
{

    final Presage a;

    g(Presage presage)
    {
        a = presage;
        super();
    }

    public final void a()
    {
        Presage.getInstance().launch();
    }

    public final void a(Activity activity)
    {
        e.b(new String[] {
            "User is going to leave the application by clicking on home. The last activity was", activity.getClass().getName()
        });
        while ((activity instanceof PresageActivity) || !((PowerManager)Presage.access$300(a).getSystemService("power")).isScreenOn()) 
        {
            return;
        }
        Presage.access$400(a);
    }
}
