// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            IAppCloudModule, en, FlurryAppCloud, et, 
//            cy

class es
    implements IAppCloudModule
{

    private static es gw;
    private static String p = "FlurryAgent";
    private String aA;
    private String gu;
    private volatile boolean gv;

    private es()
    {
        gu = "";
    }

    static es aW()
    {
        com/flurry/android/es;
        JVM INSTR monitorenter ;
        es es1;
        if (gw == null)
        {
            gw = new es();
        }
        es1 = gw;
        com/flurry/android/es;
        JVM INSTR monitorexit ;
        return es1;
        Exception exception;
        exception;
        throw exception;
    }

    final void a(en en1)
    {
        if (!gv)
        {
            aA = en1.aA;
            gv = true;
        }
        FlurryAppCloud.g(aA);
    }

    public String getLastUserId()
    {
        return et.aZ();
    }

    public String getPushToken()
    {
        cy.e(p, "getting push token.");
        return gu;
    }

    final boolean isInitialized()
    {
        return gv;
    }

    public final void setPushToken(String s)
    {
        if (!s.equals(null) || !s.equals("NP"))
        {
            cy.e(p, "setting push token.");
            if (s.length() > 0)
            {
                gu = s;
            }
        } else
        if (s.equals("NP"))
        {
            gu = s;
            return;
        }
    }

}
