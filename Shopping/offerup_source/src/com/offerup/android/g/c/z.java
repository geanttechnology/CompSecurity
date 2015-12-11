// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import com.b.a.a.g;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.offerup.android.b.a;
import com.offerup.android.dto.ItemPost;
import com.offerup.android.utils.OfferUpLocation;
import com.offerup.android.utils.al;
import com.offerup.android.utils.an;
import com.offerup.android.utils.ap;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.v;
import com.squareup.otto.Bus;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.g.c:
//            a, aa, ab, ac, 
//            ae, ad

public final class z extends com.offerup.android.g.c.a
{

    private boolean b;
    private String c;
    private Double d;
    private Double e;
    private String f;
    private CheckBox g;
    private Button h;
    private CallbackManager i;

    public z()
    {
    }

    static CheckBox a(z z1)
    {
        return z1.g;
    }

    public static z a(Integer integer, String s, Double double1, Double double2, String s1)
    {
        boolean flag = true;
        z z1 = new z();
        Bundle bundle = new Bundle();
        if (integer != null)
        {
            if (integer.intValue() != 1)
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        bundle.putBoolean("share_to_facebook", flag);
        if (s != null)
        {
            bundle.putString("zipcode", s);
        }
        if (double1 != null)
        {
            bundle.putDouble("latitude", double1.doubleValue());
        }
        if (double2 != null)
        {
            bundle.putDouble("longitude", double2.doubleValue());
        }
        if (s1 != null)
        {
            bundle.putString("location_name", s1);
        }
        z1.setArguments(bundle);
        return z1;
    }

    static boolean a(z z1, boolean flag)
    {
        z1.b = flag;
        return flag;
    }

    static void b(z z1)
    {
        if (StringUtils.isEmpty(ba.b()))
        {
            com.b.a.a.g.a(z1, "About to request read permissions");
            LoginManager.getInstance().logInWithReadPermissions(z1, v.c);
            return;
        }
        try
        {
            com.b.a.a.g.a(z1, "About to request post permissions");
            LoginManager.getInstance().logInWithPublishPermissions(z1, v.a);
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(z1, exception);
        }
        return;
    }

    private void l()
    {
        h.setError(null);
        if (f != null)
        {
            h.setText(f);
            return;
        }
        if (StringUtils.isNotEmpty(c))
        {
            h.setText((new StringBuilder("Zip: ")).append(c).toString());
            return;
        }
        if (e != null && d != null && e.doubleValue() != 0.0D && d.doubleValue() != 0.0D)
        {
            h.setText("Your Location");
            return;
        } else
        {
            h.setText("Set Location");
            return;
        }
    }

    final void a(Bundle bundle)
    {
        bundle.putBoolean("share_to_facebook", b);
        if (c != null)
        {
            bundle.putString("zipcode", c);
        } else
        {
            bundle.remove("zipcode");
        }
        if (d != null)
        {
            bundle.putDouble("latitude", d.doubleValue());
        } else
        {
            bundle.remove("latitude");
        }
        if (e != null)
        {
            bundle.putDouble("longitude", e.doubleValue());
        } else
        {
            bundle.remove("longitude");
        }
        if (f != null)
        {
            bundle.putString("location_name", f);
            return;
        } else
        {
            bundle.remove("location_name");
            return;
        }
    }

    final void a(View view)
    {
        view.findViewById(0x7f100265).setOnClickListener(new aa(this));
        g = (CheckBox)view.findViewById(0x7f100266);
        g.setOnCheckedChangeListener(new ab(this));
        h = (Button)view.findViewById(0x7f100269);
        h.setOnClickListener(new ac(this));
    }

    final void a(List list)
    {
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            String s = (String)list.get(i1);
            if ("Please set a location".equals(s))
            {
                h.setError(s);
                Toast.makeText(getActivity(), s, 0).show();
            }
        }

    }

    final void b()
    {
    }

    final void b(Bundle bundle)
    {
        b = bundle.getBoolean("share_to_facebook");
        if (bundle.containsKey("zipcode"))
        {
            c = bundle.getString("zipcode");
        } else
        {
            c = null;
        }
        if (bundle.containsKey("latitude"))
        {
            d = Double.valueOf(bundle.getDouble("latitude"));
        } else
        {
            d = null;
        }
        if (bundle.containsKey("longitude"))
        {
            e = Double.valueOf(bundle.getDouble("longitude"));
        } else
        {
            e = null;
        }
        if (bundle.containsKey("location_name"))
        {
            f = bundle.getString("location_name");
            return;
        } else
        {
            f = null;
            return;
        }
    }

    final void c()
    {
        g.setChecked(b);
        if (g.getError() != null)
        {
            g.setError(null);
        }
        l();
    }

    final String d()
    {
        return "item_post_4";
    }

    final int e()
    {
        return 0x7f0901ec;
    }

    final int f()
    {
        return 0x7f0901b6;
    }

    final int g()
    {
        return 0x7f040099;
    }

    final int h()
    {
        return 0x7f0201b5;
    }

    final List i()
    {
        int i1 = 1;
        ArrayList arraylist = new ArrayList(1);
        Object obj = new ItemPost();
        ((ItemPost) (obj)).setLatitude(d);
        ((ItemPost) (obj)).setLongitude(e);
        ((ItemPost) (obj)).setZipcode(c);
        if (!b)
        {
            i1 = 0;
        }
        ((ItemPost) (obj)).setShareToFacebook(Integer.valueOf(i1));
        obj = new al(((ItemPost) (obj)));
        if (!((al) (obj)).d() && !((al) (obj)).c())
        {
            arraylist.add("Please set a location");
        }
        return arraylist;
    }

    final Object j()
    {
        return k();
    }

    final ae k()
    {
        return new ae(this, b, c, d, e, f, (byte)0);
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i.onActivityResult(i1, j1, intent);
        if (i1 == 4 && j1 == -1)
        {
            getActivity();
            intent = an.a(ap.b);
            if (intent.d() != 0.0D)
            {
                d = Double.valueOf(intent.d());
            } else
            {
                d = null;
            }
            if (intent.c() != 0.0D)
            {
                e = Double.valueOf(intent.c());
            } else
            {
                e = null;
            }
            if (StringUtils.isNotEmpty(intent.a()))
            {
                c = intent.a();
            } else
            {
                c = null;
            }
            if (StringUtils.isNotEmpty(intent.f()) && StringUtils.isNotEmpty(intent.h()))
            {
                f = (new StringBuilder()).append(intent.f()).append(", ").append(intent.h()).toString();
            } else
            {
                f = null;
            }
            com.offerup.android.b.a.getInstance().post(k());
            l();
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        i = com.facebook.CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(i, new ad(this, (byte)0));
    }
}
