// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.os.Bundle;

class bsp extends bsm
{

    final bso a;

    bsp(bso bso1)
    {
        a = bso1;
        super();
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        a.a(activity);
    }

    public void onActivityResumed(Activity activity)
    {
        a.a(activity);
    }

    public void onActivityStarted(Activity activity)
    {
        a.a(activity);
    }
}
