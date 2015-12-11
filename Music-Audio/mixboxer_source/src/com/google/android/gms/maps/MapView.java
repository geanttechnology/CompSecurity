// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.internal.eg;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.q;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptions, GoogleMap

public class MapView extends FrameLayout
{
    static class a
        implements LifecycleDelegate
    {

        private final ViewGroup BZ;
        private final IMapViewDelegate Ca;
        private View Cb;

        public IMapViewDelegate ey()
        {
            return Ca;
        }

        public void onCreate(Bundle bundle)
        {
            try
            {
                Ca.onCreate(bundle);
                Cb = (View)c.b(Ca.getView());
                BZ.removeAllViews();
                BZ.addView(Cb);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new RuntimeRemoteException(bundle);
            }
        }

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy()
        {
            try
            {
                Ca.onDestroy();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onDestroyView()
        {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
        {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory()
        {
            try
            {
                Ca.onLowMemory();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onPause()
        {
            try
            {
                Ca.onPause();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onResume()
        {
            try
            {
                Ca.onResume();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onSaveInstanceState(Bundle bundle)
        {
            try
            {
                Ca.onSaveInstanceState(bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new RuntimeRemoteException(bundle);
            }
        }

        public a(ViewGroup viewgroup, IMapViewDelegate imapviewdelegate)
        {
            Ca = (IMapViewDelegate)eg.f(imapviewdelegate);
            BZ = (ViewGroup)eg.f(viewgroup);
        }
    }

    static class b extends com.google.android.gms.dynamic.a
    {

        protected d BX;
        private final ViewGroup Cc;
        private final GoogleMapOptions Cd;
        private final Context mContext;

        protected void a(d d1)
        {
            BX = d1;
            ex();
        }

        public void ex()
        {
            if (BX == null || cZ() != null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            IMapViewDelegate imapviewdelegate = q.u(mContext).a(c.h(mContext), Cd);
            BX.a(new a(Cc, imapviewdelegate));
            return;
            Object obj;
            obj;
            throw new RuntimeRemoteException(((RemoteException) (obj)));
            obj;
        }

        b(ViewGroup viewgroup, Context context, GoogleMapOptions googlemapoptions)
        {
            Cc = viewgroup;
            mContext = context;
            Cd = googlemapoptions;
        }
    }


    private GoogleMap BU;
    private final b BY;

    public MapView(Context context)
    {
        super(context);
        BY = new b(this, context, null);
    }

    public MapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        BY = new b(this, context, GoogleMapOptions.createFromAttributes(context, attributeset));
    }

    public MapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        BY = new b(this, context, GoogleMapOptions.createFromAttributes(context, attributeset));
    }

    public MapView(Context context, GoogleMapOptions googlemapoptions)
    {
        super(context);
        BY = new b(this, context, googlemapoptions);
    }

    public final GoogleMap getMap()
    {
        if (BU != null)
        {
            return BU;
        }
        BY.ex();
        if (BY.cZ() == null)
        {
            return null;
        }
        try
        {
            BU = new GoogleMap(((a)BY.cZ()).ey().getMap());
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return BU;
    }

    public final void onCreate(Bundle bundle)
    {
        BY.onCreate(bundle);
        if (BY.cZ() == null)
        {
            BY.a(this);
        }
    }

    public final void onDestroy()
    {
        BY.onDestroy();
    }

    public final void onLowMemory()
    {
        BY.onLowMemory();
    }

    public final void onPause()
    {
        BY.onPause();
    }

    public final void onResume()
    {
        BY.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        BY.onSaveInstanceState(bundle);
    }
}
