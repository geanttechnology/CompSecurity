// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;

final class nh
    implements bjp
{

    private ng a;

    nh(ng ng1)
    {
        a = ng1;
        super();
    }

    public final Object b_()
    {
        Object obj;
label0:
        {
            obj = a.a.c.i();
            Object obj1 = a.a;
            boolean flag = ((SharedPreferences) (obj)).getBoolean("enable_exo_cache", false);
            obj1 = a.a.a.getExternalCacheDir();
            if (flag)
            {
                obj = obj1;
                if (obj1 != null)
                {
                    break label0;
                }
            }
            obj = null;
        }
        return obj;
    }
}
