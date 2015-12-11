// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import ady;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import pp;
import pu;
import qm;
import qp;
import rd;
import re;
import rf;

public class g extends Fragment
    implements android.content.DialogInterface.OnCancelListener, android.support.v4.app.LoaderManager.LoaderCallbacks
{

    private boolean a;
    private int b;
    private pp c;
    private final Handler d = new Handler(Looper.getMainLooper());
    private final SparseArray e = new SparseArray();

    public g()
    {
        b = -1;
    }

    public static g a(FragmentActivity fragmentactivity)
    {
label0:
        {
            ady.b("Must be called from main thread of process");
            FragmentManager fragmentmanager = fragmentactivity.getSupportFragmentManager();
            g g1;
            try
            {
                g1 = (g)fragmentmanager.findFragmentByTag("GmsSupportLifecycleFragment");
            }
            // Misplaced declaration of an exception variable
            catch (FragmentActivity fragmentactivity)
            {
                throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", fragmentactivity);
            }
            if (g1 != null)
            {
                fragmentactivity = g1;
                if (!g1.isRemoving())
                {
                    break label0;
                }
            }
            fragmentactivity = new g();
            fragmentmanager.beginTransaction().add(fragmentactivity, "GmsSupportLifecycleFragment").commit();
            fragmentmanager.executePendingTransactions();
        }
        return fragmentactivity;
    }

    private void a()
    {
        int i = 0;
        a = false;
        b = -1;
        c = null;
        LoaderManager loadermanager = getLoaderManager();
        for (; i < e.size(); i++)
        {
            int j = e.keyAt(i);
            rd rd1 = c(j);
            if (rd1 != null)
            {
                rd1.a();
            }
            loadermanager.initLoader(j, null, this);
        }

    }

    private void a(int i, pp pp1)
    {
        if (!a)
        {
            a = true;
            b = i;
            c = pp1;
            d.post(new rf(this, i, pp1));
        }
    }

    public static void a(g g1)
    {
        g1.a();
    }

    public static void a(g g1, int i, pp pp1)
    {
        g1.b(i, pp1);
    }

    private void b(int i, pp pp1)
    {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        Object obj = (re)e.get(i);
        if (obj != null)
        {
            b(i);
            obj = ((re) (obj)).b;
            if (obj != null)
            {
                ((qp) (obj)).onConnectionFailed(pp1);
            }
        }
        a();
    }

    private void d(int i)
    {
        if (i == b)
        {
            a();
        }
    }

    public qm a(int i)
    {
        if (getActivity() != null)
        {
            rd rd1 = c(i);
            if (rd1 != null)
            {
                return rd1.a;
            }
        }
        return null;
    }

    public void a(int i, qm qm, qp qp1)
    {
        ady.a(qm, "GoogleApiClient instance cannot be null");
        boolean flag;
        if (e.indexOfKey(i) < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.a(flag, (new StringBuilder()).append("Already managing a GoogleApiClient with id ").append(i).toString());
        qm = new re(qm, qp1);
        e.put(i, qm);
        if (getActivity() != null)
        {
            getLoaderManager().initLoader(i, null, this);
        }
    }

    public void a(Loader loader, pp pp1)
    {
        if (pp1.b())
        {
            d(loader.getId());
            return;
        } else
        {
            a(loader.getId(), pp1);
            return;
        }
    }

    public void b(int i)
    {
        getLoaderManager().destroyLoader(i);
        e.remove(i);
    }

    rd c(int i)
    {
        rd rd1;
        try
        {
            rd1 = (rd)getLoaderManager().getLoader(i);
        }
        catch (ClassCastException classcastexception)
        {
            throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", classcastexception);
        }
        return rd1;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        boolean flag = true;
        i;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 55
    //                   2 39;
           goto _L1 _L2 _L3
_L1:
        i = 0;
_L5:
        if (i != 0)
        {
            a();
            return;
        } else
        {
            b(b, c);
            return;
        }
_L3:
        if (pu.a(getActivity()) != 0) goto _L1; else goto _L4
_L4:
        i = ((flag) ? 1 : 0);
          goto _L5
_L2:
        if (j != -1) goto _L1; else goto _L6
_L6:
        i = ((flag) ? 1 : 0);
          goto _L5
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        int i = 0;
        while (i < e.size()) 
        {
            int j = e.keyAt(i);
            activity = c(j);
            if (activity != null && ((re)e.valueAt(i)).a != ((rd) (activity)).a)
            {
                getLoaderManager().restartLoader(j, null, this);
            } else
            {
                getLoaderManager().initLoader(j, null, this);
            }
            i++;
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        b(b, c);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            a = bundle.getBoolean("resolving_error", false);
            b = bundle.getInt("failed_client_id", -1);
            if (b >= 0)
            {
                c = new pp(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new rd(getActivity(), ((re)e.get(i)).a);
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        a(loader, (pp)obj);
    }

    public void onLoaderReset(Loader loader)
    {
        if (loader.getId() == b)
        {
            a();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", a);
        if (b >= 0)
        {
            bundle.putInt("failed_client_id", b);
            bundle.putInt("failed_status", c.c());
            bundle.putParcelable("failed_resolution", c.d());
        }
    }

    public void onStart()
    {
        super.onStart();
        if (!a)
        {
            for (int i = 0; i < e.size(); i++)
            {
                getLoaderManager().initLoader(e.keyAt(i), null, this);
            }

        }
    }
}
