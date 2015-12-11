// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials;


// Referenced classes of package com.google.android.gms.auth.api.credentials:
//            CredentialRequest, CredentialPickerConfig

public final class 
{

    private boolean zzSo;
    private String zzSp[];
    private CredentialPickerConfig zzSq;
    private CredentialPickerConfig zzSr;

    static boolean zza( )
    {
        return .zzSo;
    }

    static String[] zzb(zzSo zzso)
    {
        return zzso.zzSp;
    }

    static CredentialPickerConfig zzc(zzSp zzsp)
    {
        return zzsp.zzSq;
    }

    static CredentialPickerConfig zzd(zzSq zzsq)
    {
        return zzsq.zzSr;
    }

    public final CredentialRequest build()
    {
        if (zzSp == null)
        {
            zzSp = new String[0];
        }
        if (!zzSo && zzSp.length == 0)
        {
            throw new IllegalStateException("At least one authentication method must be specified");
        } else
        {
            return new CredentialRequest(this, null);
        }
    }

    public final transient zzSp setAccountTypes(String as[])
    {
        zzSp = as;
        return this;
    }

    public final zzSp setCredentialHintPickerConfig(CredentialPickerConfig credentialpickerconfig)
    {
        zzSr = credentialpickerconfig;
        return this;
    }

    public final zzSr setCredentialPickerConfig(CredentialPickerConfig credentialpickerconfig)
    {
        zzSq = credentialpickerconfig;
        return this;
    }

    public final zzSq setSupportsPasswordLogin(boolean flag)
    {
        zzSo = flag;
        return this;
    }

    public ()
    {
    }
}
