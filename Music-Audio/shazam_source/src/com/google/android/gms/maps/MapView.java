// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.b.a;
import com.google.android.gms.b.b;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.maps.a.ai;
import com.google.android.gms.maps.a.e;
import com.google.android.gms.maps.a.k;
import com.google.android.gms.maps.a.n;
import com.google.android.gms.maps.model.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptions, c, e, d

public class MapView extends FrameLayout
{
    static final class a
        implements k
    {

        final e a;
        private final ViewGroup b;
        private View c;

        public final void a()
        {
            try
            {
                a.b();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new d(remoteexception);
            }
        }

        public final void a(Bundle bundle)
        {
            try
            {
                a.a(bundle);
                c = (View)com.google.android.gms.b.d.a(a.f());
                b.removeAllViews();
                b.addView(c);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new d(bundle);
            }
        }

        public final void b()
        {
            try
            {
                a.c();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new d(remoteexception);
            }
        }

        public final void b(Bundle bundle)
        {
            try
            {
                a.b(bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new d(bundle);
            }
        }

        public final void c()
        {
            try
            {
                a.d();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new d(remoteexception);
            }
        }

        public final void d()
        {
            try
            {
                a.e();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new d(remoteexception);
            }
        }

        public a(ViewGroup viewgroup, e e1)
        {
            a = (e)w.a(e1);
            b = (ViewGroup)w.a(viewgroup);
        }
    }

    public static final class b extends com.google.android.gms.b.b
    {

        protected com.google.android.gms.b.e d;
        private final ViewGroup e;
        private final Context f;
        private final GoogleMapOptions g;
        private final List h = new ArrayList();

        public final void a()
        {
            if (d == null || super.a != null)
            {
                break MISSING_BLOCK_LABEL_161;
            }
            Object obj;
            com.google.android.gms.maps.d.a(f);
            obj = ai.a(f).a(com.google.android.gms.b.d.a(f), g);
            if (obj == null)
            {
                return;
            }
            d.a(new a(e, ((e) (obj))));
            obj = h.iterator();
_L1:
            com.google.android.gms.maps.e e1;
            a a1;
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_150;
            }
            e1 = (com.google.android.gms.maps.e)((Iterator) (obj)).next();
            a1 = (a)super.a;
            try
            {
                a1.a.a(new com.google.android.gms.maps.a.w.a(a1, e1) {

                    final com.google.android.gms.maps.e a;
                    final a b;

                    public final void a(com.google.android.gms.maps.a.b b1)
                    {
                        new com.google.android.gms.maps.c(b1);
                    }

            
            {
                b = a1;
                a = e1;
                super();
            }
                });
            }
            catch (RemoteException remoteexception)
            {
                try
                {
                    throw new d(remoteexception);
                }
                catch (RemoteException remoteexception1)
                {
                    throw new d(remoteexception1);
                }
                catch (c c1) { }
                break MISSING_BLOCK_LABEL_161;
            }
              goto _L1
            h.clear();
            return;
        }

        protected final void a(com.google.android.gms.b.e e1)
        {
            d = e1;
            a();
        }

        b(ViewGroup viewgroup, Context context, GoogleMapOptions googlemapoptions)
        {
            e = viewgroup;
            f = context;
            g = googlemapoptions;
        }
    }


    public final b a;
    private com.google.android.gms.maps.c b;

    public MapView(Context context)
    {
        super(context);
        a = new b(this, context, null);
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new b(this, context, com.google.android.gms.maps.GoogleMapOptions.a(context, attributeset));
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new b(this, context, com.google.android.gms.maps.GoogleMapOptions.a(context, attributeset));
        setClickable(true);
    }

    public MapView(Context context, GoogleMapOptions googlemapoptions)
    {
        super(context);
        a = new b(this, context, googlemapoptions);
        setClickable(true);
    }

    public final void a()
    {
        b b1 = a;
        if (((com.google.android.gms.b.b) (b1)).a != null)
        {
            ((com.google.android.gms.b.b) (b1)).a.c();
            return;
        } else
        {
            b1.a(1);
            return;
        }
    }

    public final com.google.android.gms.maps.c getMap()
    {
        if (b != null)
        {
            return b;
        }
        a.a();
        if (((com.google.android.gms.b.b) (a)).a == null)
        {
            return null;
        }
        try
        {
            b = new com.google.android.gms.maps.c(((a)((com.google.android.gms.b.b) (a)).a).a.a());
        }
        catch (RemoteException remoteexception)
        {
            throw new d(remoteexception);
        }
        return b;
    }
}
