// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.caching.CachingManager;

// Referenced classes of package com.flurry.android:
//            es, r, ez, gn, 
//            at, az, dc, CacheSearchData, 
//            CacheSearchItemsData, CacheSyncManager, FlurryAppCloudRequestManager, cy, 
//            en, FlurryAgent, fk, et, 
//            FlurryWallet, AppCloudSearch

public class FlurryAppCloud
{

    private static CacheSearchItemsData bA = null;
    private static boolean bB = true;
    private static boolean bC = false;
    private static es bD = es.aW();
    private static String bt = "appcloud.flurry.com";
    private static String bu = "appcloud-node-stage.corp.flurry.com";
    private static CachingManager bv = null;
    private static CacheSyncManager bw = null;
    private static fk bx = null;
    private static r by = null;
    private static CacheSearchData bz = null;
    private static az f = null;
    private static at g = null;
    private static dc h = null;
    private static String p = "FlurryAgent";

    public FlurryAppCloud()
    {
    }

    static CachingManager C()
    {
        return bv;
    }

    static CacheSyncManager D()
    {
        return bw;
    }

    static fk E()
    {
        return bx;
    }

    static r F()
    {
        return by;
    }

    static void G()
    {
        if (by != null)
        {
            by.start();
        }
    }

    static void H()
    {
        if (by != null)
        {
            by.stop();
        }
    }

    static String I()
    {
        if (bB)
        {
            return bt;
        } else
        {
            return bu;
        }
    }

    static Object a(gn gn1)
    {
        switch (ez.gI[gn1.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return g;

        case 2: // '\002'
            return f;

        case 3: // '\003'
            return h;

        case 4: // '\004'
            return bz;

        case 5: // '\005'
            return bA;
        }
    }

    static void d(Context context, String s)
    {
        g = new at(context, s);
        f = new az(context, s);
        h = new dc(context, s);
        bz = new CacheSearchData(context, s);
        bA = new CacheSearchItemsData(context, s);
        bw.a();
        bw.synchronize();
    }

    static void g(String s)
    {
        FlurryAppCloudRequestManager.g(s);
    }

    public static String getPushToken()
    {
        return bD.getPushToken();
    }

    public static void initAppCloudModule(Context context)
    {
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        cy.d(p, "Context passed to getAppCloud was null.");
        if (!bC)
        {
            if (!bD.isInitialized())
            {
                cy.c(p, "Initializing Flurry AppCloud");
                en en1 = new en();
                en1.aA = FlurryAgent.y();
                es.aW().a(en1);
                cy.c(p, "Flurry AppCloud initialized");
            }
            bC = true;
        }
        bx = new fk();
        by = new r();
        bv = new CachingManager(context);
        bw = new CacheSyncManager();
        et.g(context);
        FlurryWallet.g(context);
        String s = et.aZ();
        if (!TextUtils.isEmpty(s))
        {
            d(context, s);
        }
        return;
        context;
        cy.b(p, "", context);
        return;
    }

    public static void printDB()
    {
        bw.toStringAndPrint();
        AppCloudSearch.toStringAndPrint();
    }

    public static void setAppCloudServerToStaging(boolean flag)
    {
        if (!flag)
        {
            bB = true;
            return;
        } else
        {
            bB = false;
            return;
        }
    }

    public static void setPushToken(String s)
    {
        if (!s.equals(null) || !s.equals("NP"))
        {
            cy.e(p, "setting push token.");
            if (s.length() > 0)
            {
                bD.setPushToken(s);
            }
        } else
        if (s.equals("NP"))
        {
            bD.setPushToken(s);
            return;
        }
    }

    public static void synchronize()
    {
        bw.synchronize();
    }

}
