// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.auth.api.credentials:
//            zzc, CredentialPickerConfig

public final class CredentialRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    final int mVersionCode;
    private final boolean zzSo;
    private final String zzSp[];
    private final CredentialPickerConfig zzSq;
    private final CredentialPickerConfig zzSr;

    CredentialRequest(int i, boolean flag, String as[], CredentialPickerConfig credentialpickerconfig, CredentialPickerConfig credentialpickerconfig1)
    {
        mVersionCode = i;
        zzSo = flag;
        zzSp = (String[])zzx.zzw(as);
        as = credentialpickerconfig;
        if (credentialpickerconfig == null)
        {
            as = (new CredentialPickerConfig.Builder()).build();
        }
        zzSq = as;
        as = credentialpickerconfig1;
        if (credentialpickerconfig1 == null)
        {
            as = (new CredentialPickerConfig.Builder()).build();
        }
        zzSr = as;
    }

    private CredentialRequest(Builder builder)
    {
        this(2, Builder.zza(builder), Builder.zzb(builder), Builder.zzc(builder), Builder.zzd(builder));
    }

    CredentialRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String[] getAccountTypes()
    {
        return zzSp;
    }

    public final CredentialPickerConfig getCredentialHintPickerConfig()
    {
        return zzSr;
    }

    public final CredentialPickerConfig getCredentialPickerConfig()
    {
        return zzSq;
    }

    public final boolean getSupportsPasswordLogin()
    {
        return zzSo;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }


    private class Builder
    {

        private boolean zzSo;
        private String zzSp[];
        private CredentialPickerConfig zzSq;
        private CredentialPickerConfig zzSr;

        static boolean zza(Builder builder)
        {
            return builder.zzSo;
        }

        static String[] zzb(Builder builder)
        {
            return builder.zzSp;
        }

        static CredentialPickerConfig zzc(Builder builder)
        {
            return builder.zzSq;
        }

        static CredentialPickerConfig zzd(Builder builder)
        {
            return builder.zzSr;
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

        public final transient Builder setAccountTypes(String as[])
        {
            zzSp = as;
            return this;
        }

        public final Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialpickerconfig)
        {
            zzSr = credentialpickerconfig;
            return this;
        }

        public final Builder setCredentialPickerConfig(CredentialPickerConfig credentialpickerconfig)
        {
            zzSq = credentialpickerconfig;
            return this;
        }

        public final Builder setSupportsPasswordLogin(boolean flag)
        {
            zzSo = flag;
            return this;
        }

        public Builder()
        {
        }
    }

}
