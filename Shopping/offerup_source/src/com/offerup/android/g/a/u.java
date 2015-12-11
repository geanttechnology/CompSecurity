// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.b.a.a.g;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.offerup.android.dto.Item;
import com.urbanairship.google.PlayServicesUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

// Referenced classes of package com.offerup.android.g.a:
//            h, w, v, x

public final class u extends h
{

    private SupportMapFragment b;
    private TextView c;
    private x d;

    public u()
    {
    }

    public static u a()
    {
        return new u();
    }

    static void a(u u1, GoogleMap googlemap, double d1, double d2)
    {
        MapsInitializer.initialize(u1.getActivity());
        googlemap.getUiSettings().setMapToolbarEnabled(false);
        googlemap.setOnMapClickListener(new w(u1));
        googlemap.clear();
        LatLng latlng = new LatLng(d1, d2);
        googlemap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(latlng, 13F, 0.0F, 0.0F)));
        int i = u1.getResources().getColor(0x7f0e00de);
        googlemap.addCircle((new CircleOptions()).center(latlng).radius(850D).fillColor(i).strokeColor(i).strokeWidth(2.0F));
    }

    protected final void a(Item item)
    {
label0:
        {
            String s = item.getLatitude();
            String s1 = item.getLongitude();
            if (NumberUtils.isNumber(s) && NumberUtils.isNumber(s1))
            {
                double d1 = Double.parseDouble(s);
                double d2 = Double.parseDouble(s1);
                if (PlayServicesUtils.isGooglePlayServicesAvailable(getActivity()) == 0)
                {
                    if (b == null)
                    {
                        MapsInitializer.initialize(getActivity());
                        b = SupportMapFragment.newInstance((new GoogleMapOptions()).liteMode(true).mapType(1));
                        getChildFragmentManager().a().a().b(0x7f100209, b).c();
                    }
                    b.getMapAsync(new v(this, d1, d2));
                } else
                {
                    if (c != null)
                    {
                        c.setVisibility(8);
                    }
                    d.a(this);
                }
            } else
            {
                d.a(this);
            }
            item = item.getLocationName();
            if (c != null)
            {
                if (!StringUtils.isEmpty(item))
                {
                    break label0;
                }
                c.setVisibility(8);
            }
            return;
        }
        c.setVisibility(0);
        c.setText(item);
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            d = (x)activity;
            return;
        }
        catch (Exception exception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement LocationFragmentListener").toString());
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f04008c, viewgroup, false);
        c = (TextView)layoutinflater.findViewById(0x7f100208);
        return layoutinflater;
    }

    public final void onDestroyView()
    {
        try
        {
            if (b != null)
            {
                b.onDestroyView();
            }
        }
        catch (Exception exception)
        {
            g.a(this, exception);
        }
        super.onDestroyView();
    }

    public final void onDetach()
    {
        d = null;
        super.onDetach();
    }
}
