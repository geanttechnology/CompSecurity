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
    private final String zzass;
    private final String zzast;
    private final String zzasu;
    private final Bundle zzasv;

    AppContentConditionEntity(int i, String s, String s1, String s2, Bundle bundle)
    {
        mVersionCode = i;
        zzass = s;
        zzast = s1;
        zzasu = s2;
        zzasv = bundle;
    }

    public AppContentConditionEntity(AppContentCondition appcontentcondition)
    {
        mVersionCode = 1;
        zzass = appcontentcondition.zztq();
        zzast = appcontentcondition.zztr();
        zzasu = appcontentcondition.zzts();
        zzasv = appcontentcondition.zztt();
    }

    static int zza(AppContentCondition appcontentcondition)
    {
        return zzw.hashCode(new Object[] {
            appcontentcondition.zztq(), appcontentcondition.zztr(), appcontentcondition.zzts(), appcontentcondition.zztt()
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
        if (!zzw.equal(((AppContentCondition) (obj)).zztq(), appcontentcondition.zztq()) || !zzw.equal(((AppContentCondition) (obj)).zztr(), appcontentcondition.zztr()) || !zzw.equal(((AppContentCondition) (obj)).zzts(), appcontentcondition.zzts()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((AppContentCondition) (obj)).zztt(), appcontentcondition.zztt())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(AppContentCondition appcontentcondition)
    {
        return zzw.zzu(appcontentcondition).zzg("DefaultValue", appcontentcondition.zztq()).zzg("ExpectedValue", appcontentcondition.zztr()).zzg("Predicate", appcontentcondition.zzts()).zzg("PredicateParameters", appcontentcondition.zztt()).toString();
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
        return zztu();
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

    public String zztq()
    {
        return zzass;
    }

    public String zztr()
    {
        return zzast;
    }

    public String zzts()
    {
        return zzasu;
    }

    public Bundle zztt()
    {
        return zzasv;
    }

    public AppContentCondition zztu()
    {
        return this;
    }

}
