// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.api:
//            d, Api, Scope, c

public interface GoogleApiClient
{
    public static final class Builder
    {

        private Looper DF;
        private final Set DH = new HashSet();
        private int DI;
        private View DJ;
        private String DK;
        private final Map DL = new HashMap();
        private FragmentActivity DM;
        private OnConnectionFailedListener DN;
        private final Set DO = new HashSet();
        private final Set DP = new HashSet();
        private final Context mContext;
        private String yQ;

        private d eJ()
        {
            FragmentManager fragmentmanager;
label0:
            {
                fragmentmanager = DM.getSupportFragmentManager();
                if (fragmentmanager.getFragments() == null)
                {
                    break label0;
                }
                Iterator iterator = fragmentmanager.getFragments().iterator();
                Fragment fragment;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    fragment = (Fragment)iterator.next();
                } while (!(fragment instanceof d) || !fragment.isAdded() || ((d)fragment).isInitialized());
                return (d)fragment;
            }
            d d1 = new d();
            fragmentmanager.beginTransaction().add(d1, null).commit();
            return d1;
        }

        public Builder addApi(Api api)
        {
            DL.put(api, null);
            api = api.eA();
            int j = api.size();
            for (int i = 0; i < j; i++)
            {
                DH.add(((Scope)api.get(i)).eP());
            }

            return this;
        }

        public GoogleApiClient build()
        {
            d d1;
            c c1;
            boolean flag;
            if (!DL.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            hm.b(flag, "must call addApi() to add at least one API");
            d1 = null;
            if (DM != null)
            {
                d1 = eJ();
            }
            c1 = new c(mContext, DF, eI(), DL, d1, DO, DP);
            if (d1 != null)
            {
                d1.a(c1, DN);
            }
            return c1;
        }

        public gy eI()
        {
            return new gy(yQ, DH, DI, DJ, DK);
        }

        public Builder(Context context)
        {
            mContext = context;
            DF = context.getMainLooper();
            DK = context.getPackageName();
        }
    }

    public static interface ConnectionCallbacks
    {

        public abstract void onConnected(Bundle bundle);

        public abstract void onConnectionSuspended(int i);
    }

    public static interface OnConnectionFailedListener
        extends com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener
    {

        public abstract void onConnectionFailed(ConnectionResult connectionresult);
    }


    public abstract a.b a(a.b b);

    public abstract ConnectionResult blockingConnect();

    public abstract void connect();

    public abstract void disconnect();

    public abstract boolean isConnected();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectioncallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener);
}
