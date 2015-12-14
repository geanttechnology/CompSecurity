// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import com.applovin.sdk.AppLovinSdk;

// Referenced classes of package com.applovin.impl.adview:
//            v, al, am

public abstract class u extends View
{

    protected final AppLovinSdk a;
    protected final Context b;

    u(AppLovinSdk applovinsdk, Context context)
    {
        super(context);
        b = context;
        a = applovinsdk;
    }

    public static u a(AppLovinSdk applovinsdk, Context context, v v1)
    {
        if (v1.equals(v.b))
        {
            return new al(applovinsdk, context);
        } else
        {
            return new am(applovinsdk, context);
        }
    }

    public abstract void a(int i);
}
