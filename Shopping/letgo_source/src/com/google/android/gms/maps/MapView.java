// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.lj;
import android.support.v7.ll;
import android.support.v7.lm;
import android.support.v7.yn;
import android.support.v7.yq;
import android.support.v7.yw;
import android.support.v7.yz;
import android.support.v7.zv;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.maps.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptions, c, e, d

public class MapView extends FrameLayout
{
    static class a
        implements yw
    {

        private final ViewGroup a;
        private final yq b;
        private View c;

        public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void a()
        {
            try
            {
                b.b();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
        }

        public void a(Activity activity, Bundle bundle, Bundle bundle1)
        {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void a(Bundle bundle)
        {
            try
            {
                b.a(bundle);
                c = (View)ll.a(b.f());
                a.removeAllViews();
                a.addView(c);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new e(bundle);
            }
        }

        public void a(com.google.android.gms.maps.e e1)
        {
            try
            {
                b.a(new android.support.v7.zi.a(this, e1) {

                    final com.google.android.gms.maps.e a;
                    final a b;

                    public void a(yn yn)
                        throws RemoteException
                    {
                        a.a(new com.google.android.gms.maps.c(yn));
                    }

            
            {
                b = a1;
                a = e1;
                super();
            }
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (com.google.android.gms.maps.e e1)
            {
                throw new e(e1);
            }
        }

        public void b()
        {
            try
            {
                b.c();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
        }

        public void b(Bundle bundle)
        {
            try
            {
                b.b(bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new e(bundle);
            }
        }

        public void c()
        {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void d()
        {
            try
            {
                b.d();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
        }

        public void e()
        {
            try
            {
                b.e();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
        }

        public yq f()
        {
            return b;
        }

        public a(ViewGroup viewgroup, yq yq1)
        {
            b = (yq)x.a(yq1);
            a = (ViewGroup)x.a(viewgroup);
        }
    }

    static class b extends lj
    {

        protected lm a;
        private final ViewGroup b;
        private final Context c;
        private final GoogleMapOptions d;
        private final List e = new ArrayList();

        protected void a(lm lm1)
        {
            a = lm1;
            g();
        }

        public void a(com.google.android.gms.maps.e e1)
        {
            if (a() != null)
            {
                ((a)a()).a(e1);
                return;
            } else
            {
                e.add(e1);
                return;
            }
        }

        public void g()
        {
            if (a == null || a() != null)
            {
                break MISSING_BLOCK_LABEL_136;
            }
            yq yq1;
            com.google.android.gms.maps.d.a(c);
            yq1 = zv.a(c).a(ll.a(c), d);
            if (yq1 == null)
            {
                return;
            }
            RemoteException remoteexception;
            a.a(new a(b, yq1));
            com.google.android.gms.maps.e e1;
            for (Iterator iterator = e.iterator(); iterator.hasNext(); ((a)a()).a(e1))
            {
                e1 = (com.google.android.gms.maps.e)iterator.next();
            }

            try
            {
                e.clear();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
            catch (c c1) { }
        }

        b(ViewGroup viewgroup, Context context, GoogleMapOptions googlemapoptions)
        {
            b = viewgroup;
            c = context;
            d = googlemapoptions;
        }
    }


    private final b a;
    private com.google.android.gms.maps.c b;

    public MapView(Context context)
    {
        super(context);
        a = new b(this, context, null);
        a();
    }

    public MapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new b(this, context, GoogleMapOptions.a(context, attributeset));
        a();
    }

    public MapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new b(this, context, GoogleMapOptions.a(context, attributeset));
        a();
    }

    public MapView(Context context, GoogleMapOptions googlemapoptions)
    {
        super(context);
        a = new b(this, context, googlemapoptions);
        a();
    }

    private void a()
    {
        setClickable(true);
    }

    public final void a(Bundle bundle)
    {
        a.a(bundle);
        if (a.a() == null)
        {
            lj.b(this);
        }
    }

    public void a(com.google.android.gms.maps.e e1)
    {
        x.b("getMapAsync() must be called on the main thread");
        a.a(e1);
    }

    public final com.google.android.gms.maps.c getMap()
    {
        if (b != null)
        {
            return b;
        }
        a.g();
        if (a.a() == null)
        {
            return null;
        }
        try
        {
            b = new com.google.android.gms.maps.c(((a)a.a()).f().a());
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
        return b;
    }
}
