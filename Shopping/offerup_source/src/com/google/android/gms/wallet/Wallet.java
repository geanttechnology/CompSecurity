// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.wallet.firstparty.zza;
import com.google.android.gms.wallet.wobs.zzj;

// Referenced classes of package com.google.android.gms.wallet:
//            Payments, FullWalletRequest, MaskedWalletRequest, NotifyTransactionStatusRequest

public final class Wallet
{

    public static final Api API;
    public static final Payments Payments = new zzrn();
    private static final com.google.android.gms.common.api.Api.zzc zzRk;
    private static final com.google.android.gms.common.api.Api.zza zzRl;
    public static final zzj zzbdJ = new zzrr();
    public static final zza zzbdK = new zzrq();

    private Wallet()
    {
    }

    public static void changeMaskedWallet(GoogleApiClient googleapiclient, String s, String s1, int i)
    {
        Payments.changeMaskedWallet(googleapiclient, s, s1, i);
    }

    public static void checkForPreAuthorization(GoogleApiClient googleapiclient, int i)
    {
        Payments.checkForPreAuthorization(googleapiclient, i);
    }

    public static void loadFullWallet(GoogleApiClient googleapiclient, FullWalletRequest fullwalletrequest, int i)
    {
        Payments.loadFullWallet(googleapiclient, fullwalletrequest, i);
    }

    public static void loadMaskedWallet(GoogleApiClient googleapiclient, MaskedWalletRequest maskedwalletrequest, int i)
    {
        Payments.loadMaskedWallet(googleapiclient, maskedwalletrequest, i);
    }

    public static void notifyTransactionStatus(GoogleApiClient googleapiclient, NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        Payments.notifyTransactionStatus(googleapiclient, notifytransactionstatusrequest);
    }

    static com.google.android.gms.common.api.Api.zzc zzEF()
    {
        return zzRk;
    }

    static 
    {
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        zzRl = new _cls1();
        API = new Api("Wallet.API", zzRl, zzRk);
    }

    private class _cls1 extends com.google.android.gms.common.api.Api.zza
    {

        public final volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf, (WalletOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final zzro zza(Context context, Looper looper, zzf zzf, WalletOptions walletoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            if (walletoptions == null)
            {
                walletoptions = new WalletOptions(null);
            }
            return new zzro(context, looper, zzf, connectioncallbacks, onconnectionfailedlistener, walletoptions.environment, walletoptions.theme);
        }

        _cls1()
        {
        }

        private class WalletOptions
            implements com.google.android.gms.common.api.Api.ApiOptions.HasOptions
        {

            public final int environment;
            public final int theme;

            private WalletOptions()
            {
                class Builder
                {

                    private int mTheme;
                    private int zzbdL;

                    static int zza(Builder builder)
                    {
                        return builder.zzbdL;
                    }

                    static int zzb(Builder builder)
                    {
                        return builder.mTheme;
                    }

                    public final WalletOptions build()
                    {
                        return new WalletOptions(this, null);
                    }

                    public final Builder setEnvironment(int i)
                    {
                        if (i == 0 || i == 2 || i == 1 || i == 3)
                        {
                            zzbdL = i;
                            return this;
                        } else
                        {
                            throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[] {
                                Integer.valueOf(i)
                            }));
                        }
                    }

                    public final Builder setTheme(int i)
                    {
                        if (i == 0 || i == 1)
                        {
                            mTheme = i;
                            return this;
                        } else
                        {
                            throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[] {
                                Integer.valueOf(i)
                            }));
                        }
                    }

                    public Builder()
                    {
                        zzbdL = 3;
                        mTheme = 0;
                    }
                }

                this(new Builder());
            }

            WalletOptions(_cls1 _pcls1)
            {
                this();
            }

            private WalletOptions(Builder builder)
            {
                environment = com.google.android.gms.wallet.Builder.zza(builder);
                theme = Builder.zzb(builder);
            }

            WalletOptions(Builder builder, _cls1 _pcls1)
            {
                this(builder);
            }
        }

    }

}
