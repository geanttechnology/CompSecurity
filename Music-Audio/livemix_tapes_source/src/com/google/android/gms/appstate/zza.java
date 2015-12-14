// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.appstate:
//            AppState

public final class zza
    implements AppState
{

    private final int zzQm;
    private final String zzQn;
    private final byte zzQo[];
    private final boolean zzQp;
    private final String zzQq;
    private final byte zzQr[];

    public zza(AppState appstate)
    {
        zzQm = appstate.getKey();
        zzQn = appstate.getLocalVersion();
        zzQo = appstate.getLocalData();
        zzQp = appstate.hasConflict();
        zzQq = appstate.getConflictVersion();
        zzQr = appstate.getConflictData();
    }

    static int zza(AppState appstate)
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(appstate.getKey()), appstate.getLocalVersion(), appstate.getLocalData(), Boolean.valueOf(appstate.hasConflict()), appstate.getConflictVersion(), appstate.getConflictData()
        });
    }

    static boolean zza(AppState appstate, Object obj)
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
        if (!zzw.equal(Integer.valueOf(((AppState) (obj)).getKey()), Integer.valueOf(appstate.getKey())) || !zzw.equal(((AppState) (obj)).getLocalVersion(), appstate.getLocalVersion()) || !zzw.equal(((AppState) (obj)).getLocalData(), appstate.getLocalData()) || !zzw.equal(Boolean.valueOf(((AppState) (obj)).hasConflict()), Boolean.valueOf(appstate.hasConflict())) || !zzw.equal(((AppState) (obj)).getConflictVersion(), appstate.getConflictVersion()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((AppState) (obj)).getConflictData(), appstate.getConflictData())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(AppState appstate)
    {
        return zzw.zzu(appstate).zzg("Key", Integer.valueOf(appstate.getKey())).zzg("LocalVersion", appstate.getLocalVersion()).zzg("LocalData", appstate.getLocalData()).zzg("HasConflict", Boolean.valueOf(appstate.hasConflict())).zzg("ConflictVersion", appstate.getConflictVersion()).zzg("ConflictData", appstate.getConflictData()).toString();
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Object freeze()
    {
        return zzlk();
    }

    public byte[] getConflictData()
    {
        return zzQr;
    }

    public String getConflictVersion()
    {
        return zzQq;
    }

    public int getKey()
    {
        return zzQm;
    }

    public byte[] getLocalData()
    {
        return zzQo;
    }

    public String getLocalVersion()
    {
        return zzQn;
    }

    public boolean hasConflict()
    {
        return zzQp;
    }

    public int hashCode()
    {
        return zza(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return zzb(this);
    }

    public AppState zzlk()
    {
        return this;
    }
}
