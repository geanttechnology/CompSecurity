// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.pipcamera.activity.weibo.QQAuthroizeActivity;
import com.pipcamera.application.PIPCameraApplication;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import ry;
import yz;
import zb;
import ze;

// Referenced classes of package com.pipcamera.activity:
//            FullscreenActivity, FWebViewActivity

public class SettingActivity extends FullscreenActivity
{

    private String A;
    private Resources B;
    private final String C = "\u5E94\u7528\u5B9D";
    private ArrayList D;
    private zb E;
    private final String a = "SettingActivity";
    private ListView b;
    private ListView c;
    private ListView d;
    private ListView e;
    private ListView f;
    private ArrayList g;
    private ArrayList h;
    private ArrayList i;
    private ArrayList j;
    private ArrayList k;
    private Button l;
    private SimpleAdapter m;
    private SimpleAdapter n;
    private SimpleAdapter o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public SettingActivity()
    {
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        D = null;
    }

    static SimpleAdapter a(SettingActivity settingactivity)
    {
        return settingactivity.o;
    }

    private void a(int i1)
    {
        HashMap hashmap = new HashMap();
        i1;
        JVM INSTR tableswitch 0 0: default 28
    //                   0 54;
           goto _L1 _L2
_L1:
        i.remove(i1);
        i.add(i1, hashmap);
        n.notifyDataSetChanged();
        return;
_L2:
        hashmap.put("ItemConfigTitle", x);
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void a(TextView textview, String s1)
    {
        if (s1.compareTo(q) == 0)
        {
            b();
            return;
        }
        try
        {
            if (E == null)
            {
                E = new zb("382743411764062");
            }
            E.a(this);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            Crashlytics.logException(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            Crashlytics.logException(s1);
        }
        s1 = getSharedPreferences("com.wantu.android.WantuSetting", 0).edit();
        s1.putBoolean("com.wantu.android.facebook.isconnected.key", false);
        s1.putString("com.wantu.android.facebook.accesstoken.key", null);
        s1.putString("com.wantu.android.facebook.accesstoken.expire.key", null);
        s1.commit();
        textview.setText(q);
    }

    static void a(SettingActivity settingactivity, int i1)
    {
        settingactivity.a(i1);
    }

    static void a(SettingActivity settingactivity, TextView textview, String s1)
    {
        settingactivity.a(textview, s1);
    }

    private void b()
    {
        if (checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
        {
            ze.a(this, "\u6CA1\u6709\u6743\u9650", "\u5E94\u7528\u9700\u8981\u8BBF\u95EE\u4E92\u8054\u7F51\u7684\u6743\u9650");
        }
        E = new zb("382743411764062");
        zb zb1 = E;
        ry ry1 = new ry(this);
        zb1.a(this, new String[] {
            "offline_access", "publish_stream", "user_photos", "publish_checkins", "photo_upload"
        }, ry1);
    }

    private void b(TextView textview, String s1)
    {
        if (s1.compareTo(q) == 0)
        {
            c();
            return;
        } else
        {
            yz.a(this, false, null, null);
            textview.setText(q);
            return;
        }
    }

    public static void b(SettingActivity settingactivity)
    {
        settingactivity.d();
    }

    static void b(SettingActivity settingactivity, TextView textview, String s1)
    {
        settingactivity.b(textview, s1);
    }

    public static SimpleAdapter c(SettingActivity settingactivity)
    {
        return settingactivity.m;
    }

    private void c()
    {
        if (checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
        {
            ze.a(this, "\u6CA1\u6709\u6743\u9650", "\u5E94\u7528\u9700\u8981\u8BBF\u95EE\u4E92\u8054\u7F51\u7684\u6743\u9650");
        }
        Intent intent = new Intent(this, com/pipcamera/activity/weibo/QQAuthroizeActivity);
        intent.putExtra("com.wantu.android.source", "setting");
        startActivity(intent);
    }

    private void d()
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
        hashmap.put("ItemImage", Integer.valueOf(0x7f0200f9));
        hashmap.put("ItemTitle", s);
        if (!Boolean.valueOf(getSharedPreferences("com.wantu.android.WantuSetting", 0).getBoolean("com.wantu.android.facebook.isconnected.key", false)).booleanValue())
        {
            hashmap.put("ItemText", q);
        } else
        {
            hashmap.put("ItemText", p);
        }
        g.add(hashmap);
        hashmap = new HashMap();
        hashmap.put("ItemImage", Integer.valueOf(0x7f020275));
        hashmap.put("ItemTitle", u);
        if (yz.a(this))
        {
            hashmap.put("ItemText", p);
        } else
        {
            hashmap.put("ItemText", q);
        }
        g.add(hashmap);
    }

    private void e()
    {
        Object obj;
        HashMap hashmap;
        if (h == null)
        {
            h = new ArrayList();
        } else
        {
            h.clear();
        }
        hashmap = new HashMap();
        hashmap.put("ItemImage", Integer.valueOf(0x7f0201fb));
        try
        {
            obj = getPackageManager().getPackageInfo(getPackageName(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            hashmap.put("ItemTitle", v);
            namenotfoundexception.printStackTrace();
            Crashlytics.logException(namenotfoundexception);
            namenotfoundexception = null;
        }
        if (obj != null)
        {
            obj = ((PackageInfo) (obj)).versionName;
            hashmap.put("ItemTitle", (new StringBuilder()).append(getResources().getString(0x7f060031)).append(" ").append(((String) (obj))).toString());
        }
        h.add(hashmap);
    }

    private void f()
    {
        HashMap hashmap;
        if (i == null)
        {
            i = new ArrayList();
        } else
        {
            i.clear();
        }
        hashmap = new HashMap();
        hashmap.put("ItemConfigTitle", x);
        i.add(hashmap);
        hashmap = new HashMap();
        hashmap.put("ItemConfigTitle", z);
        i.add(hashmap);
    }

    private void g()
    {
        HashMap hashmap;
        if (j == null)
        {
            j = new ArrayList();
        } else
        {
            j.clear();
        }
        hashmap = new HashMap();
        hashmap.put("ItemImage", Integer.valueOf(0));
        hashmap.put("ItemTitle", i());
        hashmap.put("ItemText", "");
        j.add(hashmap);
    }

    private void h()
    {
        HashMap hashmap;
        if (k == null)
        {
            k = new ArrayList();
        } else
        {
            k.clear();
        }
        hashmap = new HashMap();
        hashmap.put("ItemImage", Integer.valueOf(0));
        hashmap.put("ItemTitle", y);
        hashmap.put("ItemText", "");
        k.add(hashmap);
    }

    private String i()
    {
        boolean flag = false;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            flag = true;
        }
        Object obj;
        if (flag)
        {
            obj = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
            String s1 = (new StringBuilder()).append(((String) (obj))).append("/Camera/").toString();
            File file = new File(s1);
            obj = s1;
            if (!file.exists())
            {
                file.mkdirs();
                obj = s1;
            }
        } else
        {
            obj = PIPCameraApplication.a;
            String s2 = getDir("PIPCamera", 1).getAbsolutePath();
            File file1 = new File(s2);
            obj = s2;
            if (!file1.exists())
            {
                file1.mkdirs();
                return s2;
            }
        }
        return ((String) (obj));
    }

    public void OnRequsetBtnClicked(View view)
    {
        startActivity(new Intent(this, com/pipcamera/activity/FWebViewActivity));
        FlurryAgent.logEvent("RequsetBtnClicked");
    }

    public void a()
    {
        B = getResources();
        A = B.getString(0x7f0601f7);
        p = B.getString(0x7f0601eb);
        q = B.getString(0x7f0601f8);
        s = B.getString(0x7f0600ea);
        r = B.getString(0x7f0601f6);
        t = B.getString(0x7f0601f5);
        v = B.getString(0x7f0601f9);
        u = B.getString(0x7f0601f4);
        w = B.getString(0x7f0601fa);
        x = B.getString(0x7f0601ea);
        y = B.getString(0x7f0601ed);
        z = B.getString(0x7f0601ec);
    }

    public void backBtnClicked(View view)
    {
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030082);
        a();
        l = (Button)findViewById(0x7f0c0080);
        l.setVisibility(4);
        ((TextView)findViewById(0x7f0c002d)).setText(getResources().getString(0x7f0601e9));
        b = (ListView)findViewById(0x7f0c0237);
        d();
        m = new SimpleAdapter(this, g, 0x7f0300db, new String[] {
            "ItemImage", "ItemTitle", "ItemText"
        }, new int[] {
            0x7f0c034d, 0x7f0c022b, 0x7f0c034e
        });
        b.setAdapter(m);
        c = (ListView)findViewById(0x7f0c023b);
        e();
        bundle = new SimpleAdapter(this, h, 0x7f0300db, new String[] {
            "ItemImage", "ItemTitle", "ItemText"
        }, new int[] {
            0x7f0c034d, 0x7f0c022b, 0x7f0c034e
        });
        c.setAdapter(bundle);
        e = (ListView)findViewById(0x7f0c023d);
        g();
        bundle = new SimpleAdapter(this, j, 0x7f03007d, new String[] {
            "ItemTitle"
        }, new int[] {
            0x7f0c022b
        });
        e.setAdapter(bundle);
        d = (ListView)findViewById(0x7f0c023f);
        f();
        n = new SimpleAdapter(this, i, 0x7f03009b, new String[] {
            "ItemConfigTitle"
        }, new int[] {
            0x7f0c0268
        });
        d.setAdapter(n);
        d.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SettingActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                if (i1 == 0)
                {
                    adapterview = new Intent("android.intent.action.VIEW");
                    adapterview.setData(Uri.parse("market://details?id=com.pipcamera.activity"));
                    adapterview = Intent.createChooser(adapterview, null);
                    a.startActivity(adapterview);
                    SettingActivity.a(a, 0);
                } else
                if (i1 == 1)
                {
                    adapterview = new Intent("android.intent.action.VIEW");
                    adapterview.setData(Uri.parse("https://m.facebook.com/ads/ad_choices"));
                    adapterview = Intent.createChooser(adapterview, null);
                    a.startActivity(adapterview);
                    return;
                }
            }

            
            {
                a = SettingActivity.this;
                super();
            }
        });
        b.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SettingActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = (TextView)view.findViewById(0x7f0c034e);
                view = adapterview.getText().toString();
                if (i1 == 0)
                {
                    SettingActivity.a(a, adapterview, view);
                } else
                if (i1 != 1 && i1 != 2 && i1 == 3)
                {
                    SettingActivity.b(a, adapterview, view);
                    return;
                }
            }

            
            {
                a = SettingActivity.this;
                super();
            }
        });
        f = (ListView)findViewById(0x7f0c0239);
        h();
        o = new settingAdapeter(this, k, 0x7f03007d, new String[] {
            "ItemTitle"
        }, new int[] {
            0x7f0c022b
        });
        f.setAdapter(o);
        f.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SettingActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                a.OnRequsetBtnClicked(view);
                SettingActivity.a(a).notifyDataSetChanged();
            }

            
            {
                a = SettingActivity.this;
                super();
            }
        });
    }

    protected void onResume()
    {
        d();
        if (m != null)
        {
            m.notifyDataSetChanged();
        }
        super.onResume();
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }

    private class settingAdapeter extends SimpleAdapter
    {

        private int dataCount;
        final SettingActivity this$0;

        public View getView(int i1, View view, ViewGroup viewgroup)
        {
            return super.getView(i1, view, viewgroup);
        }

        public settingAdapeter(Context context, List list, int i1, String as[], int ai[])
        {
            this$0 = SettingActivity.this;
            super(context, list, i1, as, ai);
            dataCount = list.size();
        }
    }

}
