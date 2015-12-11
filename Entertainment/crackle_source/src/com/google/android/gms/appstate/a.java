// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.internal.ee;

// Referenced classes of package com.google.android.gms.appstate:
//            AppState

public final class a
    implements AppState
{

    private final int jI;
    private final String jJ;
    private final byte jK[];
    private final boolean jL;
    private final String jM;
    private final byte jN[];

    public a(AppState appstate)
    {
        jI = appstate.getKey();
        jJ = appstate.getLocalVersion();
        jK = appstate.getLocalData();
        jL = appstate.hasConflict();
        jM = appstate.getConflictVersion();
        jN = appstate.getConflictData();
    }

    static int a(AppState appstate)
    {
        return ee.hashCode(new Object[] {
            Integer.valueOf(appstate.getKey()), appstate.getLocalVersion(), appstate.getLocalData(), Boolean.valueOf(appstate.hasConflict()), appstate.getConflictVersion(), appstate.getConflictData()
        });
    }

    static boolean a(AppState appstate, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof AppState) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (appstate == obj) goto _L4; else goto _L3
_L3:
        obj = (AppState)obj;
        if (!ee.equal(Integer.valueOf(((AppState) (obj)).getKey()), Integer.valueOf(appstate.getKey())) || !ee.equal(((AppState) (obj)).getLocalVersion(), appstate.getLocalVersion()) || !ee.equal(((AppState) (obj)).getLocalData(), appstate.getLocalData()) || !ee.equal(Boolean.valueOf(((AppState) (obj)).hasConflict()), Boolean.valueOf(appstate.hasConflict())) || !ee.equal(((AppState) (obj)).getConflictVersion(), appstate.getConflictVersion()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ee.equal(((AppState) (obj)).getConflictData(), appstate.getConflictData())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String b(AppState appstate)
    {
        return ee.e(appstate).a("Key", Integer.valueOf(appstate.getKey())).a("LocalVersion", appstate.getLocalVersion()).a("LocalData", appstate.getLocalData()).a("HasConflict", Boolean.valueOf(appstate.hasConflict())).a("ConflictVersion", appstate.getConflictVersion()).a("ConflictData", appstate.getConflictData()).toString();
    }

    public AppState aK()
    {
        return this;
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public Object freeze()
    {
        return aK();
    }

    public byte[] getConflictData()
    {
        return jN;
    }

    public String getConflictVersion()
    {
        return jM;
    }

    public int getKey()
    {
        return jI;
    }

    public byte[] getLocalData()
    {
        return jK;
    }

    public String getLocalVersion()
    {
        return jJ;
    }

    public boolean hasConflict()
    {
        return jL;
    }

    public int hashCode()
    {
        return a(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return b(this);
    }
}
