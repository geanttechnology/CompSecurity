// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.helpshift.q;

public final class e
{

    public static Boolean a(Activity activity)
    {
        boolean flag;
        if ((activity.getWindow().getAttributes().flags & 0x400) == 1024)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public static void a()
    {
        q.b();
    }

    public static void b()
    {
        q.a();
    }

    public static void b(Activity activity)
    {
        if (Boolean.valueOf(activity.getIntent().getExtras().getBoolean("showInFullScreen")).booleanValue())
        {
            activity.getWindow().clearFlags(1024);
            activity.getWindow().addFlags(2048);
        }
    }

    public static void c(Activity activity)
    {
        if (Boolean.valueOf(activity.getIntent().getExtras().getBoolean("showInFullScreen")).booleanValue())
        {
            activity.getWindow().clearFlags(2048);
            activity.getWindow().addFlags(1024);
        }
    }
}
