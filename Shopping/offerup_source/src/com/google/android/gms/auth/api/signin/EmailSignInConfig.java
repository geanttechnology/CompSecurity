// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.gms.auth.api.signin:
//            zza

public class EmailSignInConfig
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int versionCode;
    private final Uri zzSU;
    private String zzSV;
    private Uri zzSW;

    EmailSignInConfig(int i, Uri uri, String s, Uri uri1)
    {
        zzx.zzb(uri, "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzh(uri.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzb(Patterns.WEB_URL.matcher(uri.toString()).matches(), "Invalid server widget url");
        versionCode = i;
        zzSU = uri;
        zzSV = s;
        zzSW = uri1;
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
        if (!zzSU.equals(((EmailSignInConfig) (obj = (EmailSignInConfig)obj)).zzlO())) goto _L1; else goto _L3
_L3:
        if (zzSW != null) goto _L5; else goto _L4
_L4:
        if (((EmailSignInConfig) (obj)).zzlP() != null) goto _L1; else goto _L6
_L5:
        if (!zzSW.equals(((EmailSignInConfig) (obj)).zzlP())) goto _L1; else goto _L6
_L6:
        if (TextUtils.isEmpty(zzSV))
        {
            if (!TextUtils.isEmpty(((EmailSignInConfig) (obj)).zzlQ()))
            {
                break; /* Loop/switch isn't completed */
            }
            break; /* Loop/switch isn't completed */
        }
        boolean flag;
        try
        {
            flag = zzSV.equals(((EmailSignInConfig) (obj)).zzlQ());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (!flag) goto _L1; else goto _L7
_L7:
        return true;
    }

    public int hashCode()
    {
        return (new zzc()).zzl(zzSU).zzl(zzSW).zzl(zzSV).zzmd();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public Uri zzlO()
    {
        return zzSU;
    }

    public Uri zzlP()
    {
        return zzSW;
    }

    public String zzlQ()
    {
        return zzSV;
    }

}
