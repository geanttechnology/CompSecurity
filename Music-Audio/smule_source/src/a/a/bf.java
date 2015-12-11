// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import java.util.List;

// Referenced classes of package a.a:
//            bd, be, ah

public final class bf
    implements bd
{

    private String a;

    public bf()
    {
        String s = null;
        super();
        a = null;
        be.c();
        be.b();
        if (be.c().b)
        {
            s = ((android.app.ActivityManager.RunningTaskInfo)((ActivityManager)be.b().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.flattenToShortString().replace("/", "");
        }
        a = s;
    }

    public final String a()
    {
        return "activity";
    }

    public final volatile Object b()
    {
        return a;
    }
}
