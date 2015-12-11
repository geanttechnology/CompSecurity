// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.iu;

// Referenced classes of package com.google.android.gms.wallet:
//            FullWalletRequest, MaskedWalletRequest, NotifyTransactionStatusRequest

public final class Wallet
{
    public static final class WalletOptions
        implements com.google.android.gms.common.api.GoogleApiClient.ApiOptions
    {

        public final int environment;
        public final int theme;

        private WalletOptions()
        {
            this(new Builder());
        }


        private WalletOptions(Builder builder)
        {
            environment = Builder.a(builder);
            theme = Builder.b(builder);
        }

    }

    public static final class WalletOptions.Builder
    {

        private int Hi;
        private int mTheme;

        static int a(WalletOptions.Builder builder)
        {
            return builder.Hi;
        }

        static int b(WalletOptions.Builder builder)
        {
            return builder.mTheme;
        }

        public WalletOptions build()
        {
            return new WalletOptions(this);
        }

        public WalletOptions.Builder setEnvironment(int i)
        {
            if (i == 0 || i == 2 || i == 1)
            {
                Hi = i;
                return this;
            } else
            {
                throw new IllegalArgumentException(String.format("Invalid environment value %d", new Object[] {
                    Integer.valueOf(i)
                }));
            }
        }

        public WalletOptions.Builder setTheme(int i)
        {
            if (i == 0 || i == 1)
            {
                mTheme = i;
                return this;
            } else
            {
                throw new IllegalArgumentException(String.format("Invalid theme value %d", new Object[] {
                    Integer.valueOf(i)
                }));
            }
        }

        public WalletOptions.Builder()
        {
            Hi = 0;
            mTheme = 0;
        }
    }

    private static abstract class a extends com.google.android.gms.common.api.a.a
    {

        public Result e(Status status)
        {
            return g(status);
        }

        public Status g(Status status)
        {
            return status;
        }

        public a()
        {
            super(Wallet.jO);
        }
    }


    public static final Api API;
    static final com.google.android.gms.common.api.Api.b jO;

    private Wallet()
    {
    }

    public static void changeMaskedWallet(GoogleApiClient googleapiclient, String s, String s1, int i)
    {
        googleapiclient.a(new a(s, s1, i) {

            final int Hc;
            final String Hf;
            final String Hg;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((iu)a1);
            }

            protected void a(iu iu1)
            {
                iu1.changeMaskedWallet(Hf, Hg, Hc);
                a(((Result) (Status.nA)));
            }

            
            {
                Hf = s;
                Hg = s1;
                Hc = i;
                super();
            }
        });
    }

    public static void checkForPreAuthorization(GoogleApiClient googleapiclient, int i)
    {
        googleapiclient.a(new a(i) {

            final int Hc;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((iu)a1);
            }

            protected void a(iu iu1)
            {
                iu1.checkForPreAuthorization(Hc);
                a(((Result) (Status.nA)));
            }

            
            {
                Hc = i;
                super();
            }
        });
    }

    public static void loadFullWallet(GoogleApiClient googleapiclient, FullWalletRequest fullwalletrequest, int i)
    {
        googleapiclient.a(new a(fullwalletrequest, i) {

            final int Hc;
            final FullWalletRequest He;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((iu)a1);
            }

            protected void a(iu iu1)
            {
                iu1.loadFullWallet(He, Hc);
                a(((Result) (Status.nA)));
            }

            
            {
                He = fullwalletrequest;
                Hc = i;
                super();
            }
        });
    }

    public static void loadMaskedWallet(GoogleApiClient googleapiclient, MaskedWalletRequest maskedwalletrequest, int i)
    {
        googleapiclient.a(new a(maskedwalletrequest, i) {

            final int Hc;
            final MaskedWalletRequest Hd;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((iu)a1);
            }

            protected void a(iu iu1)
            {
                iu1.loadMaskedWallet(Hd, Hc);
                a(((Result) (Status.nA)));
            }

            
            {
                Hd = maskedwalletrequest;
                Hc = i;
                super();
            }
        });
    }

    public static void notifyTransactionStatus(GoogleApiClient googleapiclient, NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        googleapiclient.a(new a(notifytransactionstatusrequest) {

            final NotifyTransactionStatusRequest Hh;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((iu)a1);
            }

            protected void a(iu iu1)
            {
                iu1.notifyTransactionStatus(Hh);
                a(((Result) (Status.nA)));
            }

            
            {
                Hh = notifytransactionstatusrequest;
                super();
            }
        });
    }

    static 
    {
        jO = new com.google.android.gms.common.api.Api.b() {

            public com.google.android.gms.common.api.Api.a b(Context context, dt dt1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return h(context, dt1, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public int getPriority()
            {
                return 0x7fffffff;
            }

            public iu h(Context context, dt dt1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                eg.b(context instanceof Activity, "An Activity must be used for Wallet APIs");
                Activity activity = (Activity)context;
                boolean flag;
                if (apioptions == null || (apioptions instanceof WalletOptions))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                eg.b(flag, "WalletOptions must be used for Wallet APIs");
                if (apioptions != null)
                {
                    context = (WalletOptions)apioptions;
                } else
                {
                    context = new WalletOptions();
                }
                return new iu(activity, connectioncallbacks, onconnectionfailedlistener, ((WalletOptions) (context)).environment, dt1.getAccountName(), ((WalletOptions) (context)).theme);
            }

        };
        API = new Api(jO, new Scope[0]);
    }
}
