// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.google.android.gms.common.internal.f;

// Referenced classes of package android.support.v7:
//            vf

public class vm
{

    public static boolean a()
    {
        return f.a && vf.b() && vf.a() == Process.myUid();
    }

    public static boolean a(Context context, String s)
    {
        boolean flag = false;
        context = context.getPackageManager();
        int i;
        try
        {
            i = context.getApplicationInfo(s, 0).flags;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if ((i & 0x200000) != 0)
        {
            flag = true;
        }
        return flag;
    }
}
