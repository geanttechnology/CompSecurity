// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials;


// Referenced classes of package com.google.android.gms.auth.api.credentials:
//            CredentialPickerConfig

public class mShowCancelButton
{

    private boolean mShowCancelButton;
    private boolean zzSn;

    static boolean zza(mShowCancelButton mshowcancelbutton)
    {
        return mshowcancelbutton.zzSn;
    }

    static boolean zzb(zzSn zzsn)
    {
        return zzsn.mShowCancelButton;
    }

    public CredentialPickerConfig build()
    {
        return new CredentialPickerConfig(this, null);
    }

    public mShowCancelButton setShowAddAccountButton(boolean flag)
    {
        zzSn = flag;
        return this;
    }

    public zzSn setShowCancelButton(boolean flag)
    {
        mShowCancelButton = flag;
        return this;
    }

    public ()
    {
        zzSn = false;
        mShowCancelButton = true;
    }
}
