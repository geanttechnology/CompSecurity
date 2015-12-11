// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
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
    final int mVersionCode;
    private final Uri zzSh;
    private final List zzSi;
    private final String zzSj;
    private final String zzSk;
    private final String zzSl;
    private final String zzSm;
    private final String zzwN;

    Credential(int i, String s, String s1, Uri uri, List list, String s2, String s3, 
            String s4, String s5)
    {
        mVersionCode = i;
        zzwN = (String)zzx.zzw(s);
        mName = s1;
        zzSh = uri;
        if (list == null)
        {
            s = Collections.emptyList();
        } else
        {
            s = Collections.unmodifiableList(list);
        }
        zzSi = s;
        zzSj = s2;
        zzSk = s3;
        zzSl = s4;
        zzSm = s5;
    }

    static String zza(Credential credential)
    {
        return credential.zzwN;
    }

    static String zzb(Credential credential)
    {
        return credential.mName;
    }

    static Uri zzc(Credential credential)
    {
        return credential.zzSh;
    }

    static List zzd(Credential credential)
    {
        return credential.zzSi;
    }

    static String zze(Credential credential)
    {
        return credential.zzSj;
    }

    static String zzf(Credential credential)
    {
        return credential.zzSk;
    }

    static String zzg(Credential credential)
    {
        return credential.zzSl;
    }

    static String zzh(Credential credential)
    {
        return credential.zzSm;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Credential))
            {
                return false;
            }
            obj = (Credential)obj;
            if (!TextUtils.equals(zzwN, ((Credential) (obj)).zzwN) || !TextUtils.equals(mName, ((Credential) (obj)).mName) || !zzw.equal(zzSh, ((Credential) (obj)).zzSh) || !TextUtils.equals(zzSj, ((Credential) (obj)).zzSj) || !TextUtils.equals(zzSk, ((Credential) (obj)).zzSk) || !TextUtils.equals(zzSl, ((Credential) (obj)).zzSl))
            {
                return false;
            }
        }
        return true;
    }

    public String getAccountType()
    {
        return zzSk;
    }

    public String getGeneratedPassword()
    {
        return zzSl;
    }

    public String getId()
    {
        return zzwN;
    }

    public List getIdTokens()
    {
        return zzSi;
    }

    public String getName()
    {
        return mName;
    }

    public String getPassword()
    {
        return zzSj;
    }

    public Uri getProfilePictureUri()
    {
        return zzSh;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzwN, mName, zzSh, zzSj, zzSk, zzSl
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.auth.api.credentials.zza.zza(this, parcel, i);
    }

    public String zzlI()
    {
        return zzSm;
    }

}
