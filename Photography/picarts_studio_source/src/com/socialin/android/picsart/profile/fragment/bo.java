// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.picsart.studio.utils.c;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.UpdateUserController;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.android.dialog.d;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.activity.LoginFragmentActivity;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.util.i;
import com.socialin.android.util.s;
import com.socialin.asyncnet.b;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            bp

public class bo extends d
    implements LocationListener
{

    private static final String a = com/socialin/android/picsart/profile/fragment/bo.getSimpleName();
    private UpdateUserController b;
    private UpdateUserParams c;
    private Adress d;
    private Button e;
    private g f;

    public bo()
    {
        b = new UpdateUserController();
        c = new UpdateUserParams();
    }

    static String a()
    {
        return a;
    }

    private void a(Location location)
    {
        Object obj = getActivity();
        if (obj != null && !((Activity) (obj)).isFinishing() && location != null)
        {
            d = com.picsart.studio.utils.c.a(location, ((Activity) (obj)));
            ((Activity) (obj)).runOnUiThread(new _cls4());
            location = getActivity();
            obj = f;
            if (!location.isFinishing() && obj != null && ((Dialog) (obj)).isShowing())
            {
                location.runOnUiThread(new i(((Dialog) (obj))));
                return;
            }
        }
    }

    static void a(bo bo1)
    {
        bo1.b();
    }

    static void a(bo bo1, Location location)
    {
        bo1.a(location);
    }

    static g b(bo bo1)
    {
        return bo1.f;
    }

    private void b()
    {
        Object obj = getActivity();
        if (obj != null && !((Activity) (obj)).isFinishing() && getView() != null)
        {
            Object obj1 = getActivity();
            boolean flag;
            if (obj1 == null || ((Activity) (obj1)).isFinishing())
            {
                flag = false;
            } else
            if (SocialinV3.getInstance().getUser() == null || SocialinV3.getInstance().getUser().id < 0L || !SocialinV3.getInstance().isRegistered())
            {
                com.socialin.android.d.b(com/socialin/android/picsart/profile/fragment/bo.getName(), "User is not registered!");
                Intent intent = ((Activity) (obj1)).getIntent();
                intent.setClassName(((Activity) (obj1)).getPackageName(), com/socialin/android/picsart/profile/activity/LoginFragmentActivity.getName());
                intent.setFlags(0x20000);
                intent.putExtra("from", "UserLocationChange");
                startActivityForResult(intent, 1003);
                flag = false;
            } else
            {
                flag = true;
            }
            if (flag)
            {
                if (!s.a(((android.content.Context) (obj))))
                {
                    y.a(((Activity) (obj)));
                    return;
                }
                if (e != null)
                {
                    e.setEnabled(false);
                }
                obj = (new StringBuilder()).append(((EditText)getView().findViewById(0x7f100a1b)).getText().toString().trim()).append(" ").toString();
                obj1 = (new StringBuilder()).append(((EditText)getView().findViewById(0x7f100a1c)).getText().toString().trim()).append(" ").toString();
                d.city = ((String) (obj1));
                d.country = ((String) (obj));
                c.address = d;
                b.doRequest(a, c);
                return;
            }
        }
    }

    static Button c(bo bo1)
    {
        return bo1.e;
    }

    static UpdateUserParams d(bo bo1)
    {
        return bo1.c;
    }

    static Adress e(bo bo1)
    {
        return bo1.d;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity();
        Object obj = getView();
        if (bundle == null || obj == null)
        {
            return;
        }
        b.setRequestCompleteListener(new bp(this));
        d = SocialinV3.getInstance().getUser().address;
        if (d == null)
        {
            d = new Adress();
        }
        ((View) (obj)).findViewById(0x7f100a1e).setOnClickListener(new _cls1());
        e = (Button)((View) (obj)).findViewById(0x7f100a1f);
        e.setOnClickListener(new _cls2());
        ((View) (obj)).findViewById(0x7f100a1d).setOnClickListener(new _cls3(bundle));
        EditText edittext = (EditText)((View) (obj)).findViewById(0x7f100a1b);
        if (d.country == null || d.country.equals("\""))
        {
            bundle = "";
        } else
        {
            bundle = d.country;
        }
        edittext.setText(bundle);
        obj = (EditText)((View) (obj)).findViewById(0x7f100a1c);
        if (d.city == null || d.city.equals("\""))
        {
            bundle = "";
        } else
        {
            bundle = d.city;
        }
        ((EditText) (obj)).setText(bundle);
    }

    public void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        if (k != -1) goto _L2; else goto _L1
_L1:
        j;
        JVM INSTR tableswitch 1003 1003: default 32
    //                   1003 33;
           goto _L2 _L3
_L2:
        return;
_L3:
        b();
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        f = new g(getActivity());
        f.setCancelable(true);
        setStyle(1, 0x7f0c0190);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03022b, viewgroup, false);
        m.b(layoutinflater).setText(0x7f080537);
        return layoutinflater;
    }

    public void onDestroy()
    {
        com.socialin.asyncnet.b.a().a(a);
        if (b != null)
        {
            b.setRequestCompleteListener(null);
        }
        super.onDestroy();
    }

    public void onLocationChanged(Location location)
    {
        a(location);
    }

    public void onPause()
    {
        super.onPause();
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        } else
        {
            ((LocationManager)activity.getSystemService("location")).removeUpdates(this);
            return;
        }
    }

    public void onProviderDisabled(String s1)
    {
    }

    public void onProviderEnabled(String s1)
    {
    }

    public void onStatusChanged(String s1, int j, Bundle bundle)
    {
    }


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
