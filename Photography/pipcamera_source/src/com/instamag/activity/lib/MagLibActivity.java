// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.fotoable.alertAd.TAlertAdActivity;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.global.SimpleDialogFragment;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.compose.CollageType;
import eh;
import ek;
import ew;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import ju;
import ke;
import kf;
import pb;
import qn;

// Referenced classes of package com.instamag.activity.lib:
//            LocalLibFragement

public class MagLibActivity extends FullscreenActivity
    implements ek
{

    public static LocationManager a;
    public final LocationListener b = new LocationListener() {

        final MagLibActivity a;

        public void onLocationChanged(Location location)
        {
            Log.v("WantuApplication", (new StringBuilder()).append("WantuApplication").append(" : ").append("onLocationChanged").toString());
            if (location != null)
            {
                PIPCameraApplication.d.a(location.getLatitude());
                PIPCameraApplication.d.b(location.getLongitude());
                PIPCameraApplication.f = true;
            }
            MagLibActivity.a.removeUpdates(a.b);
        }

        public void onProviderDisabled(String s)
        {
            Log.v("WantuApplication", (new StringBuilder()).append("WantuApplication").append(" : ").append("onProviderDisabled").toString());
        }

        public void onProviderEnabled(String s)
        {
            Log.v("WantuApplication", (new StringBuilder()).append("WantuApplication").append(" : ").append("onProviderEnabled").toString());
        }

        public void onStatusChanged(String s, int i1, Bundle bundle)
        {
        }

            
            {
                a = MagLibActivity.this;
                super();
            }
    };
    int c;
    qn d;
    SimpleDialogFragment e;
    ke f;
    private Fragment g;
    private RelativeLayout h;
    private BroadcastReceiver i;
    private int j;
    private int k;
    private String l;
    private LocalLibFragement m;
    private CollageType n;

    public MagLibActivity()
    {
        i = null;
        j = 0;
        k = 1;
        l = "MainLibActivity";
        n = CollageType.COLLAGE_MAGZINE;
        c = 0;
        d = new qn() {

            final MagLibActivity a;

            public void a(int i1)
            {
                a.c = i1;
                a.c();
            }

            
            {
                a = MagLibActivity.this;
                super();
            }
        };
        f = new ke() {

            final MagLibActivity a;

            public void a()
            {
                if (a.e != null)
                {
                    a.e.dismiss();
                    a.e = null;
                }
                HashMap hashmap = new HashMap();
                if (pb.b())
                {
                    hashmap.put("chinese", (new StringBuilder()).append("").append(a.c).toString());
                } else
                {
                    hashmap.put("english", (new StringBuilder()).append("").append(a.c).toString());
                }
                FlurryAgent.logEvent("MagADResToWantuDownload", hashmap);
                a.d();
            }

            public void b()
            {
                if (a.e != null)
                {
                    a.e.dismiss();
                    a.e = null;
                }
            }

            
            {
                a = MagLibActivity.this;
                super();
            }
        };
    }

    private Dialog a(Context context)
    {
        context = new android.app.AlertDialog.Builder(context);
        context.setTitle(getResources().getString(0x7f0602b1));
        context.setMessage(getResources().getString(0x7f06014c));
        context.setPositiveButton(getResources().getString(0x7f060135), null);
        return context.create();
    }

    private Location a(String s)
    {
        Location location;
        Object obj;
        Object obj1;
        obj1 = null;
        location = null;
        obj = null;
        if (!a.isProviderEnabled(s))
        {
            break MISSING_BLOCK_LABEL_184;
        }
        Log.v("WantuApplication", (new StringBuilder()).append("WantuApplication").append(" : ").append("requestLocationUpdates").toString());
        location = a.getLastKnownLocation(s);
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if (!s.equalsIgnoreCase("gps"))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        boolean flag;
        if ((new Date(System.currentTimeMillis())).getTime() - location.getTime() > 0xf731400L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        a.requestLocationUpdates(s, 10000L, 10F, b);
        break MISSING_BLOCK_LABEL_184;
        a.requestLocationUpdates(s, 10000L, 10F, b);
        return location;
        a.requestLocationUpdates(s, 10000L, 10F, b);
        return location;
        s;
        location = obj;
_L4:
        s.printStackTrace();
        return location;
        s;
        location = obj1;
_L2:
        s.printStackTrace();
        return location;
        s;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        if (true) goto _L4; else goto _L3
_L3:
        return location;
    }

    private void a(Uri uri)
    {
        Log.v(l, (new StringBuilder()).append(l).append("finishedChoosePhoto").append(uri.toString()).toString());
    }

    private boolean a(String s, String s1)
    {
        if (s == null)
        {
            return s1 == null;
        } else
        {
            return s.equals(s1);
        }
    }

    private void e()
    {
        Log.v("WantuApplication", (new StringBuilder()).append("WantuApplication").append(" : ").append("requestLocation").toString());
        if (a == null)
        {
            a = (LocationManager)getSystemService("location");
        }
        if (b != null)
        {
            a.removeUpdates(b);
        }
        Location location = a("gps");
        Location location1 = a("network");
        if (location != null && location1 != null)
        {
            location = a(location, location1);
            PIPCameraApplication.d.a(location.getLatitude());
            PIPCameraApplication.d.b(location.getLongitude());
        } else
        {
            if (location != null)
            {
                PIPCameraApplication.d.a(location.getLatitude());
                PIPCameraApplication.d.b(location.getLongitude());
                return;
            }
            if (location1 != null)
            {
                PIPCameraApplication.d.a(location1.getLatitude());
                PIPCameraApplication.d.b(location1.getLongitude());
                return;
            }
        }
    }

    protected Location a(Location location, Location location1)
    {
        boolean flag3 = true;
        if (location1 != null)
        {
            long l1 = location.getTime() - location1.getTime();
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (l1 > 0x1d4c0L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (l1 < 0xfffffffffffe2b40L)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (l1 > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag1)
            {
                if (flag2)
                {
                    return location1;
                }
                int i1 = (int)(location.getAccuracy() - location1.getAccuracy());
                boolean flag4;
                if (i1 > 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (i1 < 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (i1 <= 200)
                {
                    flag3 = false;
                }
                flag4 = a(location.getProvider(), location1.getProvider());
                if (!flag2 && (!flag || flag1) && (!flag || flag3 || !flag4))
                {
                    return location1;
                }
            }
        }
        return location;
    }

    protected void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        registerReceiver(i, intentfilter);
    }

    public void a(eh eh1)
    {
        if (eh1 != null)
        {
            eh1 = eh.a(eh1);
            if (eh1 != null)
            {
                Intent intent = new Intent(this, com/fotoable/alertAd/TAlertAdActivity);
                intent.putExtra("alertItemJson", eh1);
                startActivity(intent);
            }
        }
    }

    public void b()
    {
        if (a != null && b != null)
        {
            Log.v("WantuApplication", (new StringBuilder()).append("WantuApplication").append(" : ").append("removeGPSLisenter").toString());
            a.removeUpdates(b);
        }
    }

    public void c()
    {
        FlurryAgent.logEvent("MagADResToWantuShow");
        if (e != null) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        e = new SimpleDialogFragment();
        s1 = "Download FotoRus to get more styles.";
        s = "Get";
        if (!pb.b()) goto _L4; else goto _L3
_L3:
        s1 = "\u4E0B\u8F7D\u201C\u73A9\u56FE-\u5168\u80FD\u7F8E\u5316\u201D\uFF0C\u4F53\u9A8C\u66F4\u591A\u7D20\u6750\u3002";
        s = "\u4E0B\u8F7D";
_L6:
        e.a(true);
        e.c(s);
        e.a(getResources().getString(0x7f060277));
        e.b(s1);
        e.a(f);
        e.show(getSupportFragmentManager(), l);
_L2:
        return;
_L4:
        if (pb.c())
        {
            s1 = "\u4E0B\u8F09\u201C\u73A9\u5716-\u5168\u80FD\u7F8E\u5316\u201D\uFF0C\u9AD4\u9A57\u66F4\u591A\u7D20\u6750\u3002";
            s = "\u4E0B\u8F09";
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void d()
    {
        Intent intent = new Intent(this, com/fotoable/adbuttonlib/TWebBrowActivity);
        if (pb.a())
        {
            intent.putExtra("webUriString", kf.b);
        } else
        {
            intent.putExtra("webUriString", kf.c);
        }
        startActivity(intent);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        Uri uri;
        Object obj;
        if (j1 != -1)
        {
            return;
        }
        Log.v(l, (new StringBuilder()).append(l).append("resultCode :").append(String.valueOf(j1)).toString());
        Log.v(l, (new StringBuilder()).append(l).append("resultCode :").append(String.valueOf(i1)).toString());
        obj = null;
        uri = obj;
        i1;
        JVM INSTR tableswitch 3021 3023: default 116
    //                   3021 127
    //                   3022 120
    //                   3023 164;
           goto _L1 _L2 _L3 _L4
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        uri = obj;
_L6:
        a(uri);
        return;
_L2:
        if (intent == null)
        {
            Toast.makeText(this, "Load photo from gallery failed", 1).show();
            return;
        }
        uri = intent.getData();
        Log.v("url", uri.toString());
        continue; /* Loop/switch isn't completed */
_L4:
        uri = Uri.fromFile(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.tmp/capture.jpg").toString()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f03004b);
        Log.d(l, (new StringBuilder()).append(l).append(" ").append("onCreate_start").toString());
        if (getIntent() != null && getIntent().hasExtra("lib_collageType"))
        {
            if (getIntent().getIntExtra("lib_collageType", 0) == 0)
            {
                n = CollageType.COLLAGE_MAGZINE;
            } else
            {
                n = CollageType.COLLAGE_COMIC;
            }
        }
        if (bundle != null && bundle.containsKey("lib_collageType"))
        {
            if (bundle.getInt("lib_collageType", 0) == 0)
            {
                n = CollageType.COLLAGE_MAGZINE;
            } else
            {
                n = CollageType.COLLAGE_COMIC;
            }
        }
        h = (RelativeLayout)findViewById(0x7f0c0055);
        if (bundle != null)
        {
            g = getSupportFragmentManager().getFragment(bundle, "mContent");
            if (g != null && (g instanceof LocalLibFragement))
            {
                m = (LocalLibFragement)g;
            }
        }
        getSupportFragmentManager().beginTransaction();
        if (m == null)
        {
            m = new LocalLibFragement();
        }
        m.a(d);
        getSupportFragmentManager().beginTransaction().replace(0x7f0c00ea, m).commit();
        g = m;
        i = new BroadcastReceiver() {

            final MagLibActivity a;

            public void onReceive(Context context, Intent intent)
            {
                intent.getAction();
            }

            
            {
                a = MagLibActivity.this;
                super();
            }
        };
        a();
        if ("mounted".equals(Environment.getExternalStorageState()) || !ImageCache.f())
        {
            long l1 = ImageCache.a(Environment.getExternalStorageDirectory());
            ImageCache.a(Environment.getDataDirectory());
            if (l1 < 0x1400000L)
            {
                a(this).show();
            }
        }
    }

    protected void onDestroy()
    {
        unregisterReceiver(i);
        super.onDestroy();
        Log.v(l, (new StringBuilder()).append(l).append(" onDestroy").toString());
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            finish();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public void onResume()
    {
        super.onResume();
        Log.v(l, (new StringBuilder()).append(l).append(" onResume").toString());
        if (!ew.n(this))
        {
            h.setVisibility(0);
            FotoAdFactory.createAdBanner(this, h);
        } else
        {
            h.setVisibility(8);
        }
        if (!PIPCameraApplication.f)
        {
            e();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        getSupportFragmentManager().putFragment(bundle, "mContent", g);
        bundle.putInt("lib_collageType", n.ordinal());
    }

    protected void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
        b();
    }
}
