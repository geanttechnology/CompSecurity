// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.j;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.bn;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.dialogs.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, CameraActivity, LibraryPickerActivity

public class WeekStarActivity extends BaseActivity
{

    private ArrayList a;
    private ProgressBar b;
    private int c;
    private int d;
    private String e;
    private View f;
    private android.view.View.OnClickListener g;

    public WeekStarActivity()
    {
        c = 0;
        d = 0;
        g = new android.view.View.OnClickListener() {

            final WeekStarActivity a;

            public void onClick(View view)
            {
                a.f();
            }

            
            {
                a = WeekStarActivity.this;
                super();
            }
        };
    }

    static ProgressBar a(WeekStarActivity weekstaractivity)
    {
        return weekstaractivity.b;
    }

    static void a(WeekStarActivity weekstaractivity, MakeupItemMetadata makeupitemmetadata)
    {
        weekstaractivity.a(makeupitemmetadata);
    }

    static void a(WeekStarActivity weekstaractivity, String s)
    {
        weekstaractivity.a(s);
    }

    static void a(WeekStarActivity weekstaractivity, boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, String s1, String s2)
    {
        weekstaractivity.a(flag, flag1, flag2, flag3, s, s1, s2);
    }

    private void a(MakeupItemMetadata makeupitemmetadata)
    {
        NetworkManager networkmanager = Globals.d().w();
        try
        {
            networkmanager.a(new d(networkmanager, 0x15ab1cL, makeupitemmetadata, new j() {

                final WeekStarActivity a;

                public void a(a a1)
                {
                    com.cyberlink.youcammakeup.activity.WeekStarActivity.a(a).setProgress((WeekStarActivity.c(a) * 100) / com.cyberlink.youcammakeup.activity.WeekStarActivity.d(a) + (int)((100L * a1.a()) / a1.b() / (long)com.cyberlink.youcammakeup.activity.WeekStarActivity.d(a)));
                }

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
                {
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    WeekStarActivity.b(a);
                    if (WeekStarActivity.c(a) == com.cyberlink.youcammakeup.activity.WeekStarActivity.d(a))
                    {
                        com.cyberlink.youcammakeup.activity.WeekStarActivity.a(a).setProgress(100);
                        com.cyberlink.youcammakeup.activity.WeekStarActivity.a(a, com.cyberlink.youcammakeup.activity.WeekStarActivity.e(a));
                    }
                }

                public void b(Object obj)
                {
                    a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
                }

                public void b(Void void1)
                {
                }

                public void c(Object obj)
                {
                    b((Void)obj);
                }

                public void d(Object obj)
                {
                    a((a)obj);
                }

            
            {
                a = WeekStarActivity.this;
                super();
            }
            }));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MakeupItemMetadata makeupitemmetadata)
        {
            makeupitemmetadata.printStackTrace();
        }
    }

    private void a(String s)
    {
        Globals.d(new Runnable() {

            final WeekStarActivity a;

            public void run()
            {
                WeekStarActivity.f(a).setVisibility(8);
            }

            
            {
                a = WeekStarActivity.this;
                super();
            }
        });
        findViewById(0x7f0c0205).setOnClickListener(new android.view.View.OnClickListener(s) {

            final String a;
            final WeekStarActivity b;

            public void onClick(View view)
            {
                MakeupItemMetadata makeupitemmetadata = h.v().a(a);
                MakeupMode makeupmode = MakeupMode.a;
                BeautyMode beautymode = BeautyMode.D;
                view = (new Intent()).setFlags(0x4000000);
                DownloadUseUtils.a(false);
                view.putExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE", new com.cyberlink.youcammakeup.utility.DownloadUseUtils.UseTemplate(makeupitemmetadata.a(), makeupitemmetadata.b(), makeupmode, beautymode));
                if (makeupitemmetadata.x())
                {
                    view.setClass(b, com/cyberlink/youcammakeup/activity/CameraActivity);
                } else
                {
                    LibraryPickerActivity.State state = new LibraryPickerActivity.State("editView");
                    view.setClass(b, com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
                    view.putExtra("LibraryPickerActivity_STATE", state);
                }
                DownloadUseUtils.a(b.getIntent(), view);
                if (view.getComponent().getClassName().equals(com/cyberlink/youcammakeup/activity/LibraryPickerActivity.getName()))
                {
                    StatusManager.j().b(-1L);
                    StatusManager.j().a(-1L, null);
                    b.startActivity(view);
                    return;
                }
                if (view.getComponent().getClassName().equals(com/cyberlink/youcammakeup/activity/CameraActivity.getName()))
                {
                    view.putExtra(b.getResources().getString(0x7f070729), com/cyberlink/youcammakeup/activity/WeekStarActivity);
                    b.startActivity(view);
                    return;
                } else
                {
                    b.startActivity(view);
                    b.finish();
                    return;
                }
            }

            
            {
                b = WeekStarActivity.this;
                a = s;
                super();
            }
        });
    }

    private void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, String s1, String s2)
    {
        o o1 = Globals.d().i();
        o1.c(this);
        o1.a(new y(flag, flag1, flag2, flag3, s, s1));
        o1.a(new w(o1) {

            final o a;
            final WeekStarActivity b;

            public void a(boolean flag4)
            {
                a.i(b);
                b.f();
            }

            public void b(boolean flag4)
            {
            }

            
            {
                b = WeekStarActivity.this;
                a = o1;
                super();
            }
        });
        o1.b(null, s2);
    }

    static int b(WeekStarActivity weekstaractivity)
    {
        int i = weekstaractivity.d;
        weekstaractivity.d = i + 1;
        return i;
    }

    static int c(WeekStarActivity weekstaractivity)
    {
        return weekstaractivity.d;
    }

    static int d(WeekStarActivity weekstaractivity)
    {
        return weekstaractivity.c;
    }

    static String e(WeekStarActivity weekstaractivity)
    {
        return weekstaractivity.e;
    }

    static View f(WeekStarActivity weekstaractivity)
    {
        return weekstaractivity.f;
    }

    public boolean e()
    {
        startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030026);
        StatusManager.j().a("weekStar");
        b = (ProgressBar)findViewById(0x7f0c0206);
        Object obj = getIntent();
        a = ((Intent) (obj)).getStringArrayListExtra("Guid");
        bundle = ((Intent) (obj)).getStringExtra("Button");
        obj = ((Intent) (obj)).getStringExtra("ImageURI");
        if (a == null || a.size() == 0)
        {
            f();
            return;
        }
        findViewById(0x7f0c0204).setOnClickListener(g);
        ((TextView)findViewById(0x7f0c0207)).setText(bundle);
        if (obj != null)
        {
            ((ImageView)findViewById(0x7f0c0203)).setImageURI(Uri.parse(((String) (obj))));
        }
        f = findViewById(0x7f0c0208);
        e = (String)a.get(0);
        c = a.size();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            return f();
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    protected void onPause()
    {
        Globals.d().c("weekStar");
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Globals.d().c(null);
        f.setVisibility(0);
        ArrayList arraylist = new ArrayList();
        d = 0;
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            if (bo.h(s))
            {
                d = d + 1;
            } else
            {
                arraylist.add(s);
            }
        }

        b.setProgress((d * 100) / c);
        if (d == c)
        {
            a(e);
            return;
        }
        if (!NetworkManager.L())
        {
            a(true, false, true, false, getString(0x7f0703fd), null, getString(0x7f070533));
            return;
        } else
        {
            bn.b(arraylist, new e() {

                final WeekStarActivity a;

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    if (list.size() == 0)
                    {
                        com.cyberlink.youcammakeup.activity.WeekStarActivity.a(a, true, false, true, false, a.getString(0x7f0703fd), null, a.getString(0x7f07051d));
                    } else
                    {
                        com.cyberlink.youcammakeup.activity.WeekStarActivity.a(a).setMax(100);
                        list = list.iterator();
                        while (list.hasNext()) 
                        {
                            MakeupItemMetadata makeupitemmetadata = (MakeupItemMetadata)list.next();
                            com.cyberlink.youcammakeup.activity.WeekStarActivity.a(a, makeupitemmetadata);
                        }
                    }
                }

                public void b(Object obj)
                {
                }

                public void c(Object obj)
                {
                }

            
            {
                a = WeekStarActivity.this;
                super();
            }
            });
            return;
        }
    }

    protected void onStart()
    {
        super.onStart();
        StatusManager.j().a("weekStar");
    }
}
