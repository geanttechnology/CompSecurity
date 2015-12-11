// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.a.a.a.a;
import com.google.android.a.a.a.b;
import com.google.android.a.a.a.f;
import com.google.android.a.a.a.p;
import com.google.android.a.a.a.r;
import com.google.android.a.a.a.t;

// Referenced classes of package com.google.android.a.a:
//            e

public final class d extends Fragment
    implements c.c
{
    private final class a
        implements e.b
    {

        final d a;

        private a()
        {
            a = d.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    public String a;
    public c.b b;
    private final a c = new a((byte)0);
    private Bundle d;
    private e e;
    private boolean f;

    public d()
    {
    }

    public final void a()
    {
        if (e != null && b != null)
        {
            e e1 = e;
            boolean flag = f;
            i j;
            String s;
            Object obj;
            Bundle bundle;
            if (flag && android.os.Build.VERSION.SDK_INT < 14)
            {
                String.format("Could not enable TextureView because API level is lower than 14", new Object[0]);
                e1.g = false;
            } else
            {
                e1.g = flag;
            }
            e1 = e;
            j = getActivity();
            s = a;
            obj = b;
            bundle = d;
            if (e1.b == null && e1.f == null)
            {
                com.google.android.a.a.a.b.a(j, "activity cannot be null");
                e1.d = (c.c)com.google.android.a.a.a.b.a(this, "provider cannot be null");
                e1.f = (c.b)com.google.android.a.a.a.b.a(obj, "listener cannot be null");
                e1.e = bundle;
                obj = e1.c;
                ((p) (obj)).a.setVisibility(0);
                ((p) (obj)).b.setVisibility(8);
                e1.a = com.google.android.a.a.a.a.a().a(e1.getContext(), s, new e._cls1(e1, j), new e._cls2(e1));
                e1.a.e();
            }
            d = null;
            b = null;
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            bundle = bundle.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE");
        } else
        {
            bundle = null;
        }
        d = bundle;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        e = new e(getActivity(), c);
        a();
        return e;
    }

    public final void onDestroy()
    {
        if (e != null)
        {
            i j = getActivity();
            e e1 = e;
            boolean flag;
            if (j == null || j.isFinishing())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (e1.b != null)
            {
                t t1 = e1.b;
                try
                {
                    t1.a.e(flag);
                }
                catch (RemoteException remoteexception)
                {
                    throw new r(remoteexception);
                }
                e1.a(flag);
            }
        }
        super.onDestroy();
    }

    public final void onDestroyView()
    {
        e.a(getActivity().isFinishing());
        e = null;
        super.onDestroyView();
    }

    public final void onPause()
    {
        Object obj = e;
        if (((e) (obj)).b != null)
        {
            obj = ((e) (obj)).b;
            try
            {
                ((t) (obj)).a.o();
            }
            catch (RemoteException remoteexception)
            {
                throw new r(remoteexception);
            }
        }
        super.onPause();
    }

    public final void onResume()
    {
        Object obj;
        super.onResume();
        obj = e;
        if (((e) (obj)).b == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        obj = ((e) (obj)).b;
        ((t) (obj)).a.n();
        return;
        RemoteException remoteexception;
        remoteexception;
        throw new r(remoteexception);
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        Object obj;
        if (e != null)
        {
            obj = e;
            if (((e) (obj)).b == null)
            {
                obj = ((e) (obj)).e;
            } else
            {
                obj = ((e) (obj)).b.d();
            }
        } else
        {
            obj = d;
        }
        bundle.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", ((Bundle) (obj)));
    }

    public final void onStart()
    {
        Object obj;
        super.onStart();
        obj = e;
        if (((e) (obj)).b == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        obj = ((e) (obj)).b;
        ((t) (obj)).a.m();
        return;
        RemoteException remoteexception;
        remoteexception;
        throw new r(remoteexception);
    }

    public final void onStop()
    {
        Object obj = e;
        if (((e) (obj)).b != null)
        {
            obj = ((e) (obj)).b;
            try
            {
                ((t) (obj)).a.p();
            }
            catch (RemoteException remoteexception)
            {
                throw new r(remoteexception);
            }
        }
        super.onStop();
    }
}
