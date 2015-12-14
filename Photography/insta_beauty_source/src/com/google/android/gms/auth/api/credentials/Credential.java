// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.auth.api.credentials:
//            zza

public class Credential
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    private final String mName;
    final int zzCY;
    private final String zzKI;
    private final String zzOS;
    private final String zzOT;
    private final Uri zzOU;
    private final List zzOV;
    private final String zzOW;
    private final String zzOX;

    Credential(int i, String s, String s1, String s2, String s3, Uri uri, List list, 
            String s4, String s5)
    {
        zzCY = i;
        zzOS = s;
        zzOT = s1;
        zzKI = (String)zzu.zzu(s2);
        mName = s3;
        zzOU = uri;
        if (list == null)
        {
            s = Collections.emptyList();
        } else
        {
            s = Collections.unmodifiableList(list);
        }
        zzOV = s;
        zzOW = s4;
        zzOX = s5;
    }

    static String zza(Credential credential)
    {
        return credential.zzKI;
    }

    static String zzb(Credential credential)
    {
        return credential.mName;
    }

    static Uri zzc(Credential credential)
    {
        return credential.zzOU;
    }

    static List zzd(Credential credential)
    {
        return credential.zzOV;
    }

    static String zze(Credential credential)
    {
        return credential.zzOW;
    }

    static String zzf(Credential credential)
    {
        return credential.zzOX;
    }

    static String zzg(Credential credential)
    {
        return credential.zzOS;
    }

    static String zzh(Credential credential)
    {
        return credential.zzOT;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAccountType()
    {
        return zzOX;
    }

    public String getId()
    {
        return zzKI;
    }

    public String getName()
    {
        return mName;
    }

    public String getPassword()
    {
        return zzOW;
    }

    public Uri getProfilePictureUri()
    {
        return zzOU;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.auth.api.credentials.zza.zza(this, parcel, i);
    }

    public String zzkZ()
    {
        return zzOS;
    }

    public String zzla()
    {
        return zzOT;
    }

    public List zzlb()
    {
        return zzOV;
    }

}
