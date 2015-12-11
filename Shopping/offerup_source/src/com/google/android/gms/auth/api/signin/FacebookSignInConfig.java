// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;

// Referenced classes of package com.google.android.gms.auth.api.signin:
//            zzb

public class FacebookSignInConfig
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private Intent mIntent;
    final int versionCode;
    private final ArrayList zzSX;

    public FacebookSignInConfig()
    {
        this(1, null, new ArrayList());
    }

    FacebookSignInConfig(int i, Intent intent, ArrayList arraylist)
    {
        versionCode = i;
        mIntent = intent;
        zzSX = arraylist;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        boolean flag;
        if (zzSX.size() != ((FacebookSignInConfig) (obj = (FacebookSignInConfig)obj)).zzlS().size() || !(flag = zzSX.containsAll(((FacebookSignInConfig) (obj)).zzlS()))) goto _L1; else goto _L3
_L3:
        return true;
        obj;
        return false;
    }

    public int hashCode()
    {
        Collections.sort(zzSX);
        return zzSX.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    public Intent zzlR()
    {
        return mIntent;
    }

    public ArrayList zzlS()
    {
        return new ArrayList(zzSX);
    }

}
