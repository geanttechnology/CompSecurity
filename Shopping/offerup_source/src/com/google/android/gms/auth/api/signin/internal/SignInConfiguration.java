// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.auth.api.signin.internal:
//            zzh, zzc

public final class SignInConfiguration
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    private static int zzTr = 31;
    final int versionCode;
    private String zzTl;
    private final String zzTs;
    private EmailSignInConfig zzTt;
    private GoogleSignInConfig zzTu;
    private FacebookSignInConfig zzTv;
    private String zzTw;

    SignInConfiguration(int i, String s, String s1, EmailSignInConfig emailsigninconfig, GoogleSignInConfig googlesigninconfig, FacebookSignInConfig facebooksigninconfig, String s2)
    {
        versionCode = i;
        zzTs = zzx.zzcr(s);
        zzTl = s1;
        zzTt = emailsigninconfig;
        zzTu = googlesigninconfig;
        zzTv = facebooksigninconfig;
        zzTw = s2;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (!zzTs.equals(((SignInConfiguration) (obj = (SignInConfiguration)obj)).zzme())) goto _L1; else goto _L3
_L3:
        if (!TextUtils.isEmpty(zzTl)) goto _L5; else goto _L4
_L4:
        if (!TextUtils.isEmpty(((SignInConfiguration) (obj)).zzmb())) goto _L1; else goto _L6
_L6:
        if (!TextUtils.isEmpty(zzTw)) goto _L8; else goto _L7
_L7:
        if (!TextUtils.isEmpty(((SignInConfiguration) (obj)).zzmi()))
        {
            break; /* Loop/switch isn't completed */
        }
_L15:
        if (zzTt != null) goto _L10; else goto _L9
_L9:
        if (((SignInConfiguration) (obj)).zzmf() != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L17:
        if (zzTv != null) goto _L12; else goto _L11
_L11:
        if (((SignInConfiguration) (obj)).zzmh() != null)
        {
            break; /* Loop/switch isn't completed */
        }
          goto _L13
_L5:
        if (!zzTl.equals(((SignInConfiguration) (obj)).zzmb())) goto _L14; else goto _L6
_L14:
        break; /* Loop/switch isn't completed */
_L8:
        if (!zzTw.equals(((SignInConfiguration) (obj)).zzmi())) goto _L16; else goto _L15
_L16:
        break; /* Loop/switch isn't completed */
_L10:
        if (!zzTt.equals(((SignInConfiguration) (obj)).zzmf())) goto _L18; else goto _L17
_L18:
        break; /* Loop/switch isn't completed */
_L12:
        if (!zzTv.equals(((SignInConfiguration) (obj)).zzmh())) goto _L1; else goto _L13
_L13:
        if (zzTu == null)
        {
            if (((SignInConfiguration) (obj)).zzmg() != null)
            {
                break; /* Loop/switch isn't completed */
            }
            break; /* Loop/switch isn't completed */
        }
        boolean flag;
        try
        {
            flag = zzTu.equals(((SignInConfiguration) (obj)).zzmg());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (!flag) goto _L1; else goto _L19
_L19:
        return true;
    }

    public final int hashCode()
    {
        return (new zzc()).zzl(zzTs).zzl(zzTl).zzl(zzTw).zzl(zzTt).zzl(zzTu).zzl(zzTv).zzmd();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

    public final String zzmb()
    {
        return zzTl;
    }

    public final String zzme()
    {
        return zzTs;
    }

    public final EmailSignInConfig zzmf()
    {
        return zzTt;
    }

    public final GoogleSignInConfig zzmg()
    {
        return zzTu;
    }

    public final FacebookSignInConfig zzmh()
    {
        return zzTv;
    }

    public final String zzmi()
    {
        return zzTw;
    }

}
