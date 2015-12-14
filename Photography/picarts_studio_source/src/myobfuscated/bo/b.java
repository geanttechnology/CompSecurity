// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

// Referenced classes of package myobfuscated.bo:
//            a

public final class b extends a
{

    public b(Context context)
    {
        super(context);
    }

    public final void a(int i)
    {
        Intent intent = new Intent("com.anddoes.launcher.COUNTER_CHANGED");
        intent.putExtra("package", a.getPackageName());
        intent.putExtra("count", i);
        intent.putExtra("class", a.getPackageManager().getLaunchIntentForPackage(a.getPackageName()).getComponent().getClassName());
        a.sendBroadcast(intent);
    }
}
