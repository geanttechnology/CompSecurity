// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import ail;
import aim;
import ain;
import aio;
import aiq;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ani;
import ank;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.bestbuy.android.bbyobjects.MapBaseFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lu;
import nr;

// Referenced classes of package com.bestbuy.android.activities.blueassist:
//            BlueAssistStoreSelectionActivity

public class BlueAssistStoreMapFragment extends BBYBaseFragment
    implements aio, aiq
{

    private MapBaseFragment a;
    private aim b;
    private ArrayList c;
    private ank g;
    private int h;
    private Activity i;
    private Map j;

    public BlueAssistStoreMapFragment()
    {
        c = new ArrayList();
        h = 9;
        j = new HashMap();
    }

    public BlueAssistStoreMapFragment(ArrayList arraylist)
    {
        c = new ArrayList();
        h = 9;
        j = new HashMap();
        c.addAll(arraylist);
    }

    static View a(BlueAssistStoreMapFragment blueassiststoremapfragment, ank ank1)
    {
        return blueassiststoremapfragment.c(ank1);
    }

    private void a(ank ank1, LatLng latlng)
    {
        int k = 0;
        do
        {
label0:
            {
                if (k < c.size())
                {
                    Object obj = (BBYStore)c.get(k);
                    Double double1 = Double.valueOf(((BBYStore) (obj)).getStoreDetails().getLatitude());
                    obj = Double.valueOf(((BBYStore) (obj)).getStoreDetails().getLongitude());
                    if (Math.abs(double1.doubleValue() - latlng.a) >= 1.0000000000000001E-05D || Math.abs(((Double) (obj)).doubleValue() - latlng.b) >= 1.0000000000000001E-05D)
                    {
                        break label0;
                    }
                }
                g.a(ani.a(0x7f020049));
                g = ank1;
                return;
            }
            k++;
        } while (true);
    }

    private View c(ank ank1)
    {
        View view = i.getLayoutInflater().inflate(0x7f0300fd, null);
        ank1 = ank1.a();
        ank1 = (BBYStore)j.get(ank1);
        BBYTextView bbytextview = (BBYTextView)view.findViewById(0x7f0c0024);
        BBYTextView bbytextview1 = (BBYTextView)view.findViewById(0x7f0c0027);
        BBYTextView bbytextview2 = (BBYTextView)view.findViewById(0x7f0c0026);
        ((BBYTextView)view.findViewById(0x7f0c0025)).setText(ank1.getStoreDetails().getAddress());
        bbytextview2.setText((new StringBuilder()).append(ank1.getStoreDetails().getCity()).append(", ").append(ank1.getStoreDetails().getState()).append(" ").append(ank1.getStoreDetails().getZipCode()).toString());
        bbytextview.setText(ank1.getStoreDetails().getName());
        bbytextview1.setText(nr.a(ank1));
        return view;
    }

    public void a(ArrayList arraylist, int k)
    {
        if (k <= 1)
        {
            c.clear();
        }
        c.addAll(arraylist);
        b_();
    }

    public boolean a(ank ank1)
    {
        lu.a(lu.ag);
        if (!ank1.equals(g))
        {
            ank1.a(ani.a(0x7f020048));
            LatLng latlng = ank1.a();
            ank1.b();
            a(ank1, latlng);
        }
        return false;
    }

    public void b(ank ank1)
    {
        ank1 = ank1.a();
        ank1 = (BBYStore)j.get(ank1);
        if (i instanceof BlueAssistStoreSelectionActivity)
        {
            ((BlueAssistStoreSelectionActivity)i).a(ank1);
        }
    }

    public void b_()
    {
        if (a != null)
        {
            b = a.b();
            if (b != null && !c.isEmpty())
            {
                b.b();
                b.a(new ain() {

                    final BlueAssistStoreMapFragment a;

                    public View a(ank ank1)
                    {
                        return null;
                    }

                    public View b(ank ank1)
                    {
                        return BlueAssistStoreMapFragment.a(a, ank1);
                    }

            
            {
                a = BlueAssistStoreMapFragment.this;
                super();
            }
                });
                b.a(this);
                b.a(this);
                if (b != null)
                {
                    int k = 0;
                    while (k < c.size()) 
                    {
                        BBYStore bbystore = (BBYStore)c.get(k);
                        Object obj = Double.valueOf(bbystore.getStoreDetails().getLatitude());
                        Double double1 = Double.valueOf(bbystore.getStoreDetails().getLongitude());
                        obj = new LatLng(((Double) (obj)).doubleValue(), double1.doubleValue());
                        if (k == 0)
                        {
                            b.a(ail.a(((LatLng) (obj)), h));
                            g = b.a((new MarkerOptions()).a(((LatLng) (obj))).a(ani.a(0x7f020048)));
                            j.put(g.a(), bbystore);
                        } else
                        {
                            obj = b.a((new MarkerOptions()).a(((LatLng) (obj))).a(ani.a(0x7f020049)));
                            j.put(((ank) (obj)).a(), bbystore);
                        }
                        k++;
                    }
                }
            }
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        i = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03003f, viewgroup, false);
        a = MapBaseFragment.a(this);
        viewgroup = getChildFragmentManager().beginTransaction();
        viewgroup.add(0x7f0c0107, a);
        viewgroup.commitAllowingStateLoss();
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        try
        {
            Field field = android/support/v4/app/Fragment.getDeclaredField("mChildFragmentManager");
            field.setAccessible(true);
            field.set(this, null);
            return;
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            throw new RuntimeException(nosuchfieldexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RuntimeException(illegalaccessexception);
        }
    }

    public void onStart()
    {
        super.onStart();
        lu.a(lu.aO);
    }
}
