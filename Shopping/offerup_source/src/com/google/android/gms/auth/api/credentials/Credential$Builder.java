// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

// Referenced classes of package com.google.android.gms.auth.api.credentials:
//            Credential

public class zzwN
{

    private String mName;
    private Uri zzSh;
    private List zzSi;
    private String zzSj;
    private String zzSk;
    private String zzSl;
    private String zzSm;
    private final String zzwN;

    public Credential build()
    {
        if (!TextUtils.isEmpty(zzSj) && !TextUtils.isEmpty(zzSk))
        {
            throw new IllegalStateException("Only one of password or accountType may be set");
        } else
        {
            return new Credential(3, zzwN, mName, zzSh, zzSi, zzSj, zzSk, zzSl, zzSm);
        }
    }

    public zzSm setAccountType(String s)
    {
        String s1 = Uri.parse(s).getScheme();
        boolean flag;
        if ("http".equalsIgnoreCase(s1) || "https".equalsIgnoreCase(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        zzSk = s;
        return this;
    }

    public zzSk setName(String s)
    {
        mName = s;
        return this;
    }

    public mName setPassword(String s)
    {
        zzSj = s;
        return this;
    }

    public zzSj setProfilePictureUri(Uri uri)
    {
        zzSh = uri;
        return this;
    }

    public (Credential credential)
    {
        zzwN = Credential.zza(credential);
        mName = Credential.zzb(credential);
        zzSh = Credential.zzc(credential);
        zzSi = Credential.zzd(credential);
        zzSj = Credential.zze(credential);
        zzSk = Credential.zzf(credential);
        zzSl = Credential.zzg(credential);
        zzSm = Credential.zzh(credential);
    }

    public zzSm(String s)
    {
        zzwN = s;
    }
}
