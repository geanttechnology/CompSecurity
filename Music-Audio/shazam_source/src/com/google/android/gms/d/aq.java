// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.google.android.gms.common.internal.w;
import java.util.List;

public final class aq
{

    private final Context a;

    public aq(Context context)
    {
        w.a(context, "Context can not be null");
        a = context;
    }

    public final boolean a()
    {
        return "mounted".equals(Environment.getExternalStorageState()) && a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public final boolean a(Intent intent)
    {
        boolean flag = false;
        w.a(intent, "Intent can not be null");
        if (!a.getPackageManager().queryIntentActivities(intent, 0).isEmpty())
        {
            flag = true;
        }
        return flag;
    }

    public final boolean b()
    {
        Intent intent = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.dir/event");
        return android.os.Build.VERSION.SDK_INT >= 14 && a(intent);
    }
}
