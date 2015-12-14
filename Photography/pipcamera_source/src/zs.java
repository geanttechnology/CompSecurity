// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Application;
import android.content.Context;

public class zs
{

    private final Application a;
    private zt b;

    public zs(Context context)
    {
        a = (Application)context.getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            b = new zt(a);
        }
    }

    public void a()
    {
        if (b != null)
        {
            zt.a(b);
        }
    }

    public boolean a(zu zu)
    {
        return b != null && zt.a(b, zu);
    }
}
