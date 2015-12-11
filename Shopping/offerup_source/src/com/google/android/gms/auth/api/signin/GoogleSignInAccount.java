// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.auth.api.signin:
//            zzc

public class GoogleSignInAccount
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    public static zzmn zzSY = zzmp.zzqt();
    final int versionCode;
    private String zzSZ;
    private String zzSs;
    private String zzTa;
    private Uri zzTb;
    private String zzTc;
    private long zzTd;
    private String zzwN;

    GoogleSignInAccount(int i, String s, String s1, String s2, String s3, Uri uri, String s4, 
            long l)
    {
        versionCode = i;
        zzwN = zzx.zzcr(s);
        zzSs = s1;
        zzSZ = s2;
        zzTa = s3;
        zzTb = uri;
        zzTc = s4;
        zzTd = l;
    }

    private JSONObject zzlX()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", getId());
            if (getIdToken() != null)
            {
                jsonobject.put("tokenId", getIdToken());
            }
            if (getEmail() != null)
            {
                jsonobject.put("email", getEmail());
            }
            if (getDisplayName() != null)
            {
                jsonobject.put("displayName", getDisplayName());
            }
            if (zzlT() != null)
            {
                jsonobject.put("photoUrl", zzlT().toString());
            }
            if (zzlU() != null)
            {
                jsonobject.put("serverAuthCode", zzlU());
            }
            jsonobject.put("expirationTime", zzTd);
        }
        catch (JSONException jsonexception)
        {
            throw new RuntimeException(jsonexception);
        }
        return jsonobject;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof GoogleSignInAccount))
        {
            return false;
        } else
        {
            return ((GoogleSignInAccount)obj).zzlW().equals(zzlW());
        }
    }

    public String getDisplayName()
    {
        return zzTa;
    }

    public String getEmail()
    {
        return zzSZ;
    }

    public String getId()
    {
        return zzwN;
    }

    public String getIdToken()
    {
        return zzSs;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    public Uri zzlT()
    {
        return zzTb;
    }

    public String zzlU()
    {
        return zzTc;
    }

    public long zzlV()
    {
        return zzTd;
    }

    public String zzlW()
    {
        return zzlX().toString();
    }

}
