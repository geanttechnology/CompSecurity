// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeauty;

import acb;
import acc;
import acd;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import aym;
import azo;
import com.fotoable.view.actionbar.CommonActionBarView1;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.fotoable.fotobeauty:
//            FullscreenActivity

public class SettingActivity extends FullscreenActivity
    implements aym
{

    private final String A = "\u5E94\u7528\u5B9D";
    private ArrayList B;
    private ListView C;
    private SharedPreferences D;
    CommonActionBarView1 a;
    private ListView b;
    private ListView c;
    private ListView d;
    private ArrayList e;
    private ArrayList f;
    private ArrayList g;
    private SimpleAdapter h;
    private SimpleAdapter i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x[];
    private String y;
    private Resources z;

    public SettingActivity()
    {
        e = null;
        f = null;
        g = null;
        B = null;
    }

    public static String a(SettingActivity settingactivity)
    {
        return settingactivity.t;
    }

    private void a(int i1)
    {
        HashMap hashmap = new HashMap();
        i1;
        JVM INSTR tableswitch 0 0: default 28
    //                   0 54;
           goto _L1 _L2
_L1:
        g.remove(i1);
        g.add(i1, hashmap);
        i.notifyDataSetChanged();
        return;
_L2:
        hashmap.put("ItemConfigTitle", s);
        hashmap.put("ItemConfigSelected", x[D.getInt(azo.a, 0)]);
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void a(TextView textview)
    {
    }

    private void a(TextView textview, String s1)
    {
        if (s1.compareTo(k) == 0)
        {
            a(textview);
            return;
        } else
        {
            textview.setText(k);
            return;
        }
    }

    public static void a(SettingActivity settingactivity, int i1)
    {
        settingactivity.a(i1);
    }

    public static void a(SettingActivity settingactivity, TextView textview, String s1)
    {
        settingactivity.a(textview, s1);
    }

    public static String[] b(SettingActivity settingactivity)
    {
        return settingactivity.x;
    }

    public static SharedPreferences c(SettingActivity settingactivity)
    {
        return settingactivity.D;
    }

    public static String d(SettingActivity settingactivity)
    {
        return settingactivity.u;
    }

    private void e()
    {
        if (e == null)
        {
            e = new ArrayList();
            return;
        } else
        {
            e.clear();
            return;
        }
    }

    private void f()
    {
        Object obj;
        HashMap hashmap;
        if (f == null)
        {
            f = new ArrayList();
        } else
        {
            f.clear();
        }
        hashmap = new HashMap();
        hashmap.put("ItemImage", Integer.valueOf(0x7f02034c));
        try
        {
            obj = getPackageManager().getPackageInfo(getPackageName(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            hashmap.put("ItemTitle", p);
            namenotfoundexception.printStackTrace();
            namenotfoundexception = null;
        }
        if (obj != null)
        {
            obj = ((PackageInfo) (obj)).versionName;
            hashmap.put("ItemTitle", (new StringBuilder()).append(getResources().getString(0x7f060077)).append(" ").append(((String) (obj))).toString());
        }
        f.add(hashmap);
    }

    private void g()
    {
        HashMap hashmap;
        if (g == null)
        {
            g = new ArrayList();
        } else
        {
            g.clear();
        }
        hashmap = new HashMap();
        hashmap.put("ItemConfigTitle", s);
        hashmap.put("ItemConfigSelected", x[D.getInt(azo.a, 0)]);
        g.add(hashmap);
    }

    private void h()
    {
        HashMap hashmap;
        if (B == null)
        {
            B = new ArrayList();
        } else
        {
            B.clear();
        }
        hashmap = new HashMap();
        getClass();
        hashmap.put("ItemTitle", "\u5E94\u7528\u5B9D");
        hashmap.put("ItemText", "");
        B.add(hashmap);
    }

    public void a()
    {
    }

    public void b()
    {
        backBtnClicked(null);
    }

    public void backBtnClicked(View view)
    {
        finish();
    }

    public void c()
    {
        z = getResources();
        y = z.getString(0x7f06021c);
        j = z.getString(0x7f060212);
        k = z.getString(0x7f06021e);
        m = z.getString(0x7f0600fc);
        l = z.getString(0x7f06021b);
        n = z.getString(0x7f06021a);
        p = z.getString(0x7f06021f);
        o = z.getString(0x7f060219);
        q = z.getString(0x7f060220);
        r = z.getString(0x7f060218);
        s = z.getString(0x7f060217);
        t = z.getString(0x7f0600a8);
        u = z.getString(0x7f060214);
        v = z.getString(0x7f060215);
        w = z.getString(0x7f060216);
        x = (new String[] {
            v, w
        });
    }

    public void d()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300c1);
        c();
        d();
        D = getSharedPreferences("SP", 0);
        a = (CommonActionBarView1)findViewById(0x7f0d00b3);
        a.setIsNextButtonShow(false);
        a.setActionBarTitle(getResources().getString(0x7f060210));
        a.setOnAcceptListener(this);
        b = (ListView)findViewById(0x7f0d0307);
        e();
        h = new SimpleAdapter(this, e, 0x7f030131, new String[] {
            "ItemImage", "ItemTitle", "ItemText"
        }, new int[] {
            0x7f0d0462, 0x7f0d0372, 0x7f0d0463
        });
        b.setAdapter(h);
        ((TextView)findViewById(0x7f0d0308)).setText(getResources().getString(0x7f060218));
        d = (ListView)findViewById(0x7f0d0309);
        g();
        i = new SimpleAdapter(this, g, 0x7f030067, new String[] {
            "ItemConfigTitle", "ItemConfigSelected"
        }, new int[] {
            0x7f0d022c, 0x7f0d022d
        });
        d.setAdapter(i);
        c = (ListView)findViewById(0x7f0d01fd);
        f();
        bundle = new SimpleAdapter(this, f, 0x7f030131, new String[] {
            "ItemImage", "ItemTitle", "ItemText"
        }, new int[] {
            0x7f0d0462, 0x7f0d0372, 0x7f0d0463
        });
        c.setAdapter(bundle);
        ((TextView)findViewById(0x7f0d030b)).setVisibility(4);
        C = (ListView)findViewById(0x7f0d030c);
        h();
        bundle = new SimpleAdapter(this, B, 0x7f030131, new String[] {
            "ItemImage", "ItemTitle", "ItemText"
        }, new int[] {
            0x7f0d0462, 0x7f0d0372, 0x7f0d0463
        });
        C.setAdapter(bundle);
        C.setVisibility(4);
        C.setOnItemClickListener(new acb(this));
        b.setOnItemClickListener(new acc(this));
        d.setOnItemClickListener(new acd(this));
    }

    protected void onResume()
    {
        e();
        if (h != null)
        {
            h.notifyDataSetChanged();
        }
        super.onResume();
    }
}
