// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.studio.utils.c;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.GetItemsParams;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.adapter.y;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import java.util.List;
import myobfuscated.cr.a;
import myobfuscated.cr.f;
import myobfuscated.cr.h;

public final class aw extends f
    implements LocationListener
{

    private BaseSocialinApiRequestController c;
    private y d;
    private Adress m;
    private Location n;

    public aw()
    {
        c = RequestControllerFactory.createSearchItemsController();
    }

    private void a(double d1, double d2)
    {
        m = new Adress();
        m.setLatitude((float)d1);
        m.setLongitude((float)d2);
        if (SocialinV3.getInstance().getUser().isRegistered())
        {
            SocialinV3.getInstance().getUser().address = m;
        }
        GetItemsParams getitemsparams = (GetItemsParams)c.getRequestParams();
        int i;
        if (SocialinV3.getInstance().getUser().mature)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        getitemsparams.contentRating = i;
        getitemsparams.searchNear = (new StringBuilder()).append(m.getLatitude()).append(",").append(m.getLongitude()).toString();
        a(false, true, true);
    }

    static void a(aw aw1, int i)
    {
        GalleryUtils.a(aw1.getActivity(), (android.os.Parcelable[])aw1.d.getItems().toArray(new ImageItem[aw1.d.getItemCount()]), i, null, 4539);
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (getArguments() != null && getArguments().containsKey("location"))
        {
            m = (Adress)getArguments().getParcelable("location");
        }
        int i;
        if (m == null)
        {
            if (com.picsart.studio.utils.c.a(getActivity().getApplicationContext(), this) != null)
            {
                a(m.getLatitude(), m.getLongitude());
            } else
            {
                DialogUtils.showNoLocationProviderDialog(getActivity(), 0x7f080448, 0x7f08047e, 0x7f0802f6, 0x7f0802a4, 0x7f0203eb);
            }
            i = 0;
        } else
        {
            i = 1;
        }
        if (i != 0)
        {
            bundle = (GetItemsParams)c.getRequestParams();
            if (SocialinV3.getInstance().getUser().mature)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            bundle.contentRating = i;
            bundle.searchNear = (new StringBuilder()).append(m.getLatitude()).append(",").append(m.getLongitude()).toString();
            a(false, true, true);
        }
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        d = new y(getActivity());
        d.setOnItemClickListener(new _cls1());
        b(d, myobfuscated.cr.a.a(c, d));
        a((new h(getResources())).a(3, 2).a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
            com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.STAGGERED
        }).b());
    }

    public final void onLocationChanged(Location location)
    {
        if (getActivity() != null)
        {
            com.socialin.android.d.a("PhotosByLocationFragment", "onLocationChanged");
            if (com.picsart.studio.utils.c.a(location, n))
            {
                n = location;
                if (n != null)
                {
                    a(n.getLatitude(), n.getLongitude());
                    return;
                }
            }
        }
    }

    public final void onProviderDisabled(String s)
    {
        com.socialin.android.d.a("PhotosByLocationFragment", (new StringBuilder("onProviderDisabled  ")).append(s).toString());
    }

    public final void onProviderEnabled(String s)
    {
        com.socialin.android.d.a("PhotosByLocationFragment", (new StringBuilder(" onProviderEnabled   ")).append(s).toString());
    }

    public final void onStatusChanged(String s, int i, Bundle bundle)
    {
        com.socialin.android.d.a("PhotosByLocationFragment", (new StringBuilder("onStatusChanged  provider= ")).append(s).append(" status= ").append(i).toString());
    }

    /* member class not found */
    class _cls1 {}

}
