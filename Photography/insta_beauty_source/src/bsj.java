// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Application;
import android.content.Context;

public class bsj
{

    private final Application a;
    private bsk b;

    public bsj(Context context)
    {
        a = (Application)context.getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            b = new bsk(a);
        }
    }

    public void a()
    {
        if (b != null)
        {
            bsk.a(b);
        }
    }

    public boolean a(bsm bsm)
    {
        return b != null && bsk.a(b, bsm);
    }
}
