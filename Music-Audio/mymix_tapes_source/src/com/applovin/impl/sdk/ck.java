// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

// Referenced classes of package com.applovin.impl.sdk:
//            bv, AppLovinSdkImpl, bw, cl, 
//            cx

public class ck extends bv
{

    private final String a;
    private final Map b;
    private final AppLovinPostbackListener c;
    private int d;
    private int i;
    private int j;

    public ck(AppLovinSdkImpl applovinsdkimpl, String s, Map map, AppLovinPostbackListener applovinpostbacklistener)
    {
        super("TaskDispatchPostback", applovinsdkimpl);
        j = -1;
        a = s;
        c = applovinpostbacklistener;
        b = map;
    }

    static int a(ck ck1)
    {
        return ck1.j;
    }

    static Map b(ck ck1)
    {
        return ck1.b;
    }

    static String c(ck ck1)
    {
        return ck1.a;
    }

    static AppLovinPostbackListener d(ck ck1)
    {
        return ck1.c;
    }

    public void a(int k)
    {
        d = k;
    }

    public void b(int k)
    {
        i = k;
    }

    public void c(int k)
    {
        j = k;
    }

    public void run()
    {
        if (!AppLovinSdkUtils.isValidString(a))
        {
            f.getLogger().i("TaskDispatchPostback", "Requested URL is not valid; nothing to do...");
            c.onPostbackFailure(a, -900);
            return;
        }
        cl cl1;
        int k;
        if (d < 0)
        {
            k = ((Integer)f.a(bw.aG)).intValue();
        } else
        {
            k = d;
        }
        cl1 = new cl(this, "RepeatTaskDispatchPostback", k, f);
        cl1.a(i);
        cl1.run();
    }
}
