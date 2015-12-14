// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotobeauty.FullscreenActivity;
import java.util.ArrayList;
import java.util.HashMap;
import pt;
import sf;
import sg;
import sh;
import si;
import sk;
import sl;
import sm;
import so;

public class fotobeautySettingActivity extends FullscreenActivity
{

    private SimpleAdapter A;
    private ListView a;
    private ListView b;
    private ListView c;
    private ListView d;
    private ListView e;
    private ImageView f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private ArrayList m;
    private ArrayList n;
    private ArrayList o;
    private ArrayList p;
    private ArrayList q;
    private String r;
    private String s;
    private String t;
    private String u;
    private TextView v;
    private so w;
    private so x;
    private SimpleAdapter y;
    private SimpleAdapter z;

    public fotobeautySettingActivity()
    {
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
    }

    public static ImageView a(fotobeautySettingActivity fotobeautysettingactivity)
    {
        return fotobeautysettingactivity.f;
    }

    private void a(int i1)
    {
        HashMap hashmap = new HashMap();
        i1;
        JVM INSTR tableswitch 0 0: default 28
    //                   0 54;
           goto _L1 _L2
_L1:
        q.remove(i1);
        q.add(i1, hashmap);
        A.notifyDataSetChanged();
        return;
_L2:
        hashmap.put("itemText", u);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static void a(fotobeautySettingActivity fotobeautysettingactivity, int i1)
    {
        fotobeautysettingactivity.a(i1);
    }

    private void e()
    {
        g = getResources().getString(0x7f060279);
        h = getResources().getString(0x7f060275);
        i = getResources().getString(0x7f060276);
        j = getResources().getString(0x7f060211);
        k = getResources().getString(0x7f060277);
        l = getResources().getString(0x7f060274);
        s = getResources().getString(0x7f0601d6);
        t = getResources().getString(0x7f060152);
        u = sm.a();
        r = getResources().getString(0x7f060339);
    }

    private void f()
    {
        HashMap hashmap;
        if (q == null)
        {
            q = new ArrayList();
        } else
        {
            q.clear();
        }
        hashmap = new HashMap();
        hashmap.put("ItemConfigTitle", u);
        q.add(hashmap);
    }

    public void a()
    {
        HashMap hashmap;
        if (o == null)
        {
            o = new ArrayList();
        } else
        {
            o.clear();
        }
        hashmap = new HashMap();
        hashmap.put("itemContentText", g);
        hashmap.put("itemIsChecked", Boolean.valueOf(pt.b(pt.b, this, true)));
        hashmap.put("itemIdStr", pt.b);
        o.add(hashmap);
        hashmap = new HashMap();
        hashmap.put("itemContentText", h);
        hashmap.put("itemIsChecked", Boolean.valueOf(pt.b(pt.c, this, false)));
        hashmap.put("itemIdStr", pt.c);
        o.add(hashmap);
        hashmap = new HashMap();
        hashmap.put("itemContentText", l);
        hashmap.put("itemIsChecked", Boolean.valueOf(pt.b(pt.d, this, true)));
        hashmap.put("itemIdStr", pt.d);
        o.add(hashmap);
    }

    public void b()
    {
        HashMap hashmap;
        HashMap hashmap1;
        boolean flag;
        if (p == null)
        {
            p = new ArrayList();
        } else
        {
            p.clear();
        }
        hashmap = new HashMap();
        hashmap1 = new HashMap();
        hashmap.put("itemContentText", s);
        hashmap1.put("itemContentText", t);
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hashmap.put("itemIsChecked", Boolean.valueOf(pt.b(pt.h, this, flag)));
        hashmap1.put("itemIsChecked", Boolean.valueOf(pt.b(pt.t, this, false)));
        hashmap.put("itemIdStr", pt.h);
        hashmap1.put("itemIdStr", pt.t);
        p.add(hashmap);
        p.add(hashmap1);
    }

    public void c()
    {
        HashMap hashmap;
        if (n == null)
        {
            n = new ArrayList();
        } else
        {
            n.clear();
        }
        hashmap = new HashMap();
        hashmap.put("itemText", j);
        n.add(hashmap);
        hashmap = new HashMap();
        hashmap.put("itemText", r);
        n.add(hashmap);
    }

    public void d()
    {
        PackageInfo packageinfo;
        HashMap hashmap;
        if (m == null)
        {
            m = new ArrayList();
        } else
        {
            m.clear();
        }
        hashmap = new HashMap();
        hashmap.put("itemText", i);
        try
        {
            packageinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            hashmap.put("itemtextVer", k);
            Crashlytics.logException(namenotfoundexception);
            namenotfoundexception.printStackTrace();
            namenotfoundexception = null;
        }
        if (packageinfo != null)
        {
            hashmap.put("itemtextVer", packageinfo.versionName);
        }
        m.add(hashmap);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03005a);
        e();
        f = (ImageView)findViewById(0x7f0d01f5);
        f.setOnClickListener(new sf(this));
        f.setOnTouchListener(new sg(this));
        a = (ListView)findViewById(0x7f0d01f7);
        a();
        w = new so(o, this, new sh(this));
        a.setAdapter(w);
        b = (ListView)findViewById(0x7f0d01f9);
        v = (TextView)findViewById(0x7f0d01f8);
        b();
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b.setVisibility(0);
            v.setVisibility(0);
        } else
        {
            b.setVisibility(8);
            v.setVisibility(8);
        }
        x = new so(p, this, new si(this));
        b.setAdapter(x);
        c = (ListView)findViewById(0x7f0d01fd);
        d();
        y = new SimpleAdapter(this, m, 0x7f03005c, new String[] {
            "itemText", "itemtextVer"
        }, new int[] {
            0x7f0d0202, 0x7f0d0203
        });
        c.setAdapter(y);
        d = (ListView)findViewById(0x7f0d01ff);
        c();
        z = new SimpleAdapter(this, n, 0x7f03005c, new String[] {
            "itemText", "itemtextVer"
        }, new int[] {
            0x7f0d0202, 0x7f0d0203
        });
        d.setAdapter(z);
        d.setOnItemClickListener(new sk(this));
        e = (ListView)findViewById(0x7f0d01fb);
        f();
        A = new SimpleAdapter(this, q, 0x7f03005c, new String[] {
            "itemText", "itemtextVer"
        }, new int[] {
            0x7f0d0202, 0x7f0d0203
        });
        e.setAdapter(A);
        e.setOnItemClickListener(new sl(this));
    }

    protected void onResume()
    {
        if (e != null)
        {
            u = sm.a();
            a(0);
        }
        super.onResume();
        FlurryAgent.onPageView();
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(getApplicationContext(), "J3DP5Q6Y48C3GPJXV4X3");
    }

    protected void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
    }
}
