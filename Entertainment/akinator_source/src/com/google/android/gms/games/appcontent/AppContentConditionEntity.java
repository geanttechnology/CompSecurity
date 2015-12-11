// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.games.appcontent:
//            AppContentCondition, AppContentConditionEntityCreator

public final class AppContentConditionEntity
    implements SafeParcelable, AppContentCondition
{

    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
    private final int mVersionCode;
    private final String zzauQ;
    private final String zzauR;
    private final String zzauS;
    private final Bundle zzauT;

    AppContentConditionEntity(int i, String s, String s1, String s2, Bundle bundle)
    {
        mVersionCode = i;
        zzauQ = s;
        zzauR = s1;
        zzauS = s2;
        zzauT = bundle;
    }

    public AppContentConditionEntity(AppContentCondition appcontentcondition)
    {
        mVersionCode = 1;
        zzauQ = appcontentcondition.zzuf();
        zzauR = appcontentcondition.zzug();
        zzauS = appcontentcondition.zzuh();
        zzauT = appcontentcondition.zzui();
    }

    static int zza(AppContentCondition appcontentcondition)
    {
        return zzw.hashCode(new Object[] {
            appcontentcondition.zzuf(), appcontentcondition.zzug(), appcontentcondition.zzuh(), appcontentcondition.zzui()
        });
    }

    static boolean zza(AppContentCondition appcontentcondition, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof AppContentCondition) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (appcontentcondition == obj) goto _L4; else goto _L3
_L3:
        obj = (AppContentCondition)obj;
        if (!zzw.equal(((AppContentCondition) (obj)).zzuf(), appcontentcondition.zzuf()) || !zzw.equal(((AppContentCondition) (obj)).zzug(), appcontentcondition.zzug()) || !zzw.equal(((AppContentCondition) (obj)).zzuh(), appcontentcondition.zzuh()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((AppContentCondition) (obj)).zzui(), appcontentcondition.zzui())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(AppContentCondition appcontentcondition)
    {
        return zzw.zzv(appcontentcondition).zzg("DefaultValue", appcontentcondition.zzuf()).zzg("ExpectedValue", appcontentcondition.zzug()).zzg("Predicate", appcontentcondition.zzuh()).zzg("PredicateParameters", appcontentcondition.zzui()).toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Object freeze()
    {
        return zzuj();
    }

    public int getVersionCode()
    {
        return mVersionCode;
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

    public void writeToParcel(Parcel parcel, int i)
    {
        AppContentConditionEntityCreator.zza(this, parcel, i);
    }

    public String zzuf()
    {
        return zzauQ;
    }

    public String zzug()
    {
        return zzauR;
    }

    public String zzuh()
    {
        return zzauS;
    }

    public Bundle zzui()
    {
        return zzauT;
    }

    public AppContentCondition zzuj()
    {
        return this;
    }

}
