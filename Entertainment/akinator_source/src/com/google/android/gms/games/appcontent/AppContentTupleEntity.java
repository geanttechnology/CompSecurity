// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.games.appcontent:
//            AppContentTuple, AppContentTupleEntityCreator

public final class AppContentTupleEntity
    implements SafeParcelable, AppContentTuple
{

    public static final AppContentTupleEntityCreator CREATOR = new AppContentTupleEntityCreator();
    private final String mName;
    private final String mValue;
    private final int mVersionCode;

    AppContentTupleEntity(int i, String s, String s1)
    {
        mVersionCode = i;
        mName = s;
        mValue = s1;
    }

    public AppContentTupleEntity(AppContentTuple appcontenttuple)
    {
        mVersionCode = 1;
        mName = appcontenttuple.getName();
        mValue = appcontenttuple.getValue();
    }

    static int zza(AppContentTuple appcontenttuple)
    {
        return zzw.hashCode(new Object[] {
            appcontenttuple.getName(), appcontenttuple.getValue()
        });
    }

    static boolean zza(AppContentTuple appcontenttuple, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof AppContentTuple) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (appcontenttuple == obj) goto _L4; else goto _L3
_L3:
        obj = (AppContentTuple)obj;
        if (!zzw.equal(((AppContentTuple) (obj)).getName(), appcontenttuple.getName()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((AppContentTuple) (obj)).getValue(), appcontenttuple.getValue())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(AppContentTuple appcontenttuple)
    {
        return zzw.zzv(appcontenttuple).zzg("Name", appcontenttuple.getName()).zzg("Value", appcontenttuple.getValue()).toString();
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
        return zzuq();
    }

    public String getName()
    {
        return mName;
    }

    public String getValue()
    {
        return mValue;
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
        AppContentTupleEntityCreator.zza(this, parcel, i);
    }

    public AppContentTuple zzuq()
    {
        return this;
    }

}
