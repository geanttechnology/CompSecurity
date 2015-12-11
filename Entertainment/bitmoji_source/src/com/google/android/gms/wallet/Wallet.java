// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.jg;

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

        private int Zw;
        private int mTheme;

        static int a(WalletOptions.Builder builder)
        {
            return builder.Zw;
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
                Zw = i;
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
            Zw = 0;
            mTheme = 0;
        }
    }

    private static abstract class a extends com.google.android.gms.common.api.a.a
    {

        public Result d(Status status)
        {
            return f(status);
        }

        public Status f(Status status)
        {
            return status;
        }

        public a()
        {
            super(Wallet.va);
        }
    }


    public static final Api API;
    static final com.google.android.gms.common.api.Api.b va;

    private Wallet()
    {
    }

    public static void changeMaskedWallet(GoogleApiClient googleapiclient, String s, String s1, int i)
    {
        googleapiclient.a(new a(s, s1, i) {

            final int Kx;
            final String Zt;
            final String Zu;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((jg)a1);
            }

            protected void a(jg jg1)
            {
                jg1.changeMaskedWallet(Zt, Zu, Kx);
                a(((Result) (Status.zQ)));
            }

            
            {
                Zt = s;
                Zu = s1;
                Kx = i;
                super();
            }
        });
    }

    public static void checkForPreAuthorization(GoogleApiClient googleapiclient, int i)
    {
        googleapiclient.a(new a(i) {

            final int Kx;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((jg)a1);
            }

            protected void a(jg jg1)
            {
                jg1.checkForPreAuthorization(Kx);
                a(((Result) (Status.zQ)));
            }

            
            {
                Kx = i;
                super();
            }
        });
    }

    public static void loadFullWallet(GoogleApiClient googleapiclient, FullWalletRequest fullwalletrequest, int i)
    {
        googleapiclient.a(new a(fullwalletrequest, i) {

            final int Kx;
            final FullWalletRequest Zs;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((jg)a1);
            }

            protected void a(jg jg1)
            {
                jg1.loadFullWallet(Zs, Kx);
                a(((Result) (Status.zQ)));
            }

            
            {
                Zs = fullwalletrequest;
                Kx = i;
                super();
            }
        });
    }

    public static void loadMaskedWallet(GoogleApiClient googleapiclient, MaskedWalletRequest maskedwalletrequest, int i)
    {
        googleapiclient.a(new a(maskedwalletrequest, i) {

            final int Kx;
            final MaskedWalletRequest Zr;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((jg)a1);
            }

            protected void a(jg jg1)
            {
                jg1.loadMaskedWallet(Zr, Kx);
                a(((Result) (Status.zQ)));
            }

            
            {
                Zr = maskedwalletrequest;
                Kx = i;
                super();
            }
        });
    }

    public static void notifyTransactionStatus(GoogleApiClient googleapiclient, NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        googleapiclient.a(new a(notifytransactionstatusrequest) {

            final NotifyTransactionStatusRequest Zv;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((jg)a1);
            }

            protected void a(jg jg1)
            {
                jg1.notifyTransactionStatus(Zv);
                a(((Result) (Status.zQ)));
            }

            
            {
                Zv = notifytransactionstatusrequest;
                super();
            }
        });
    }

    static 
    {
        va = new com.google.android.gms.common.api.Api.b() {

            public com.google.android.gms.common.api.Api.a b(Context context, Looper looper, ee ee1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return i(context, looper, ee1, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public int getPriority()
            {
                return 0x7fffffff;
            }

            public jg i(Context context, Looper looper, ee ee1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                er.b(context instanceof Activity, "An Activity must be used for Wallet APIs");
                Activity activity = (Activity)context;
                boolean flag;
                if (apioptions == null || (apioptions instanceof WalletOptions))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                er.b(flag, "WalletOptions must be used for Wallet APIs");
                if (apioptions != null)
                {
                    context = (WalletOptions)apioptions;
                } else
                {
                    context = new WalletOptions();
                }
                return new jg(activity, looper, connectioncallbacks, onconnectionfailedlistener, ((WalletOptions) (context)).environment, ee1.getAccountName(), ((WalletOptions) (context)).theme);
            }

        };
        API = new Api(va, new Scope[0]);
    }
}
