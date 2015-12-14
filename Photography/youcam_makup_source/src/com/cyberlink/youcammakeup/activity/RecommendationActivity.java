// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;
import com.cyberlink.youcammakeup.clflurry.al;
import com.cyberlink.youcammakeup.database.a.a;
import com.cyberlink.youcammakeup.database.a.b;
import com.cyberlink.youcammakeup.database.a.c;
import com.cyberlink.youcammakeup.database.a.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.f;
import com.cyberlink.youcammakeup.utility.j;
import com.cyberlink.youcammakeup.utility.k;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.dialogs.y;
import com.google.android.gms.ads.AdSize;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

public class RecommendationActivity extends BaseActivity
{

    private static final String a = com/cyberlink/youcammakeup/kernelctrl/status/StatusManager.getName();
    private static LinkedList k;
    private Groups b;
    private View c;
    private LinearLayout d;
    private TextView e;
    private List f;
    private List g;
    private List h;
    private HashMap i;
    private int j;

    public RecommendationActivity()
    {
        b = com.cyberlink.youcammakeup.activity.Groups.a;
    }

    private void a(Groups groups)
    {
        Iterator iterator = f.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            e e1 = (e)iterator.next();
            if (e1.b().equals(groups.toString()))
            {
                i.put(e1.a(), Integer.valueOf(e1.c()));
            }
        } while (true);
    }

    static void a(RecommendationActivity recommendationactivity)
    {
        recommendationactivity.j();
    }

    private void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, String s1, String s2)
    {
        o o1 = Globals.d().i();
        o1.c(this);
        o1.a(new y(flag, flag1, flag2, flag3, s, s1));
        o1.a(new w(o1) {

            final o a;
            final RecommendationActivity b;

            public void a(boolean flag4)
            {
                a.i(b);
                b.f();
            }

            public void b(boolean flag4)
            {
                a.i(b);
                com.cyberlink.youcammakeup.activity.RecommendationActivity.a(b);
            }

            
            {
                b = RecommendationActivity.this;
                a = o1;
                super();
            }
        });
        o1.b(null, s2);
    }

    static HashMap b(RecommendationActivity recommendationactivity)
    {
        return recommendationactivity.i;
    }

    static LinearLayout c(RecommendationActivity recommendationactivity)
    {
        return recommendationactivity.d;
    }

    static TextView d(RecommendationActivity recommendationactivity)
    {
        return recommendationactivity.e;
    }

    static void e(RecommendationActivity recommendationactivity)
    {
        recommendationactivity.n();
    }

    private void j()
    {
        if (NetworkManager.L())
        {
            if (k())
            {
                Globals.d().i().b(this);
                m();
                return;
            } else
            {
                a(true, false, true, false, getString(0x7f0703fd), null, getString(0x7f070534));
                return;
            }
        } else
        {
            a(true, true, true, true, getString(0x7f0703fd), getString(0x7f070529), getString(0x7f070533));
            return;
        }
    }

    private boolean k()
    {
        boolean flag1 = false;
        boolean flag;
        try
        {
            f = com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.h.a(com.cyberlink.youcammakeup.utility.f.b("GetADUnitListTask"));
            g = com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.e.a(com.cyberlink.youcammakeup.utility.f.b("GetADUnitContentTask"));
        }
        catch (JSONException jsonexception)
        {
            Log.e("RecommendationActivity", "jason data parse error");
            return false;
        }
        catch (NullPointerException nullpointerexception)
        {
            Log.e("RecommendationActivity", "jason data is null");
            return false;
        }
        i = new HashMap();
        a(b);
        if (i.size() == 0)
        {
            a(com.cyberlink.youcammakeup.activity.Groups.b);
        }
        flag = flag1;
        if (i.size() > 0)
        {
            flag = flag1;
            if (f != null)
            {
                flag = flag1;
                if (g != null)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void l()
    {
        Globals.d().b(this);
        Object obj = getIntent().getStringExtra("title");
        if (obj != null)
        {
            obj = ((String) (obj)).replace('\n', ' ');
            ((TextView)findViewById(0x7f0c0185)).setText(((CharSequence) (obj)));
        }
        obj = com.cyberlink.youcammakeup.activity.Groups.b(getIntent());
        if (obj != null)
        {
            b = ((Groups) (obj));
        }
        c = findViewById(0x7f0c0184);
        h = new LinkedList();
        d = (LinearLayout)findViewById(0x7f0c0187);
        e = (TextView)findViewById(0x7f0c0188);
    }

    private void m()
    {
        j = 0;
        Object obj = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        ((Display) (obj)).getSize(point);
        int i1 = point.x;
        int k1 = (i1 * 273) / 1080;
        obj = g.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            a a1 = (a)((Iterator) (obj)).next();
            if (a1.c() && i.containsKey(a1.a().a()))
            {
                if (System.currentTimeMillis() > ((c)a1.b().get(0)).b())
                {
                    n();
                } else
                {
                    j j1 = new j(a1.d(), k, i1, k1);
                    j1.a(new k(a1, j1) {

                        final a a;
                        final j b;
                        final RecommendationActivity c;

                        public void a()
                        {
                            boolean flag = false;
                            Globals.d().i().h(c);
                            LinearLayout linearlayout = (LinearLayout)View.inflate(c, 0x7f030201, null);
                            LinearLayout linearlayout1 = (LinearLayout)linearlayout.findViewById(0x7f0c08d7);
                            linearlayout.setId(((Integer)com.cyberlink.youcammakeup.activity.RecommendationActivity.b(c).get(a.a().a())).intValue());
                            ((TextView)linearlayout.findViewById(0x7f0c08d8)).setText(((c)a.b().get(0)).d());
                            ((TextView)linearlayout.findViewById(0x7f0c08d9)).setText(((c)a.b().get(0)).e());
                            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1, 80);
                            b.a(linearlayout1, layoutparams);
                            int l1 = 0;
                            do
                            {
                                if (l1 >= com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).getChildCount() || linearlayout.getId() < com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).getChildAt(l1).getId())
                                {
                                    com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).addView(linearlayout, l1);
                                    l1 = ((flag) ? 1 : 0);
                                    while (l1 < com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).getChildCount()) 
                                    {
                                        if (l1 % 2 == 0)
                                        {
                                            com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).getChildAt(l1).setBackgroundColor(0xfff8f8f8);
                                        } else
                                        {
                                            com.cyberlink.youcammakeup.activity.RecommendationActivity.c(c).getChildAt(l1).setBackgroundColor(-1);
                                        }
                                        l1++;
                                    }
                                    break;
                                }
                                l1++;
                            } while (true);
                            RecommendationActivity.d(c).setVisibility(8);
                        }

                        public void b()
                        {
                            com.cyberlink.youcammakeup.activity.RecommendationActivity.e(c);
                        }

            
            {
                c = RecommendationActivity.this;
                a = a1;
                b = j1;
                super();
            }
                    });
                    j1.a();
                    h.add(j1);
                }
            }
        } while (true);
    }

    private void n()
    {
        j = j + 1;
        if (j == i.size())
        {
            runOnUiThread(new Runnable() {

                final RecommendationActivity a;

                public void run()
                {
                    Globals.d().i().h(a);
                    RecommendationActivity.d(a).setText(0x7f07051d);
                    RecommendationActivity.d(a).setTextColor(0xff000000);
                }

            
            {
                a = RecommendationActivity.this;
                super();
            }
            });
        }
    }

    private void o()
    {
        c.setOnClickListener(new android.view.View.OnClickListener() {

            final RecommendationActivity a;

            public void onClick(View view)
            {
                a.f();
            }

            
            {
                a = RecommendationActivity.this;
                super();
            }
        });
    }

    private void p()
    {
        c.setOnClickListener(null);
        c = null;
    }

    public boolean e()
    {
        startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        finish();
        overridePendingTransition(0x7f040004, 0x7f040005);
        return true;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001b);
        StatusManager.j().a("recommendationPage");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.e, this);
        l();
        o();
        j();
    }

    public void onDestroy()
    {
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.e, null);
        for (Iterator iterator = h.iterator(); iterator.hasNext(); ((j)iterator.next()).d()) { }
        p();
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            return f();
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        for (Iterator iterator = h.iterator(); iterator.hasNext(); ((j)iterator.next()).c()) { }
        Globals.d().c("recommendationPage");
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        YMKLauncherEvent.b("Recommendation");
        super.onResume();
        com.cyberlink.youcammakeup.clflurry.b.a(new al());
        for (Iterator iterator = h.iterator(); iterator.hasNext(); ((j)iterator.next()).b()) { }
        Globals.d().c(null);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(a, StatusManager.j());
    }

    protected void onStart()
    {
        super.onStart();
        StatusManager.j().a("recommendationPage");
        StatusManager.j().a(Boolean.valueOf(true));
    }

    static 
    {
        k = new LinkedList();
        k.add(new AdSize(600, 150));
        k.add(new AdSize(480, 120));
        k.add(new AdSize(360, 90));
        k.add(new AdSize(320, 80));
    }

    private class Groups extends Enum
    {

        public static final Groups a;
        public static final Groups b;
        private static final Groups c[];

        public static Groups b(Intent intent)
        {
            if (!intent.hasExtra("Groups"))
            {
                throw new IllegalStateException();
            } else
            {
                return values()[intent.getIntExtra("Groups", -1)];
            }
        }

        public static Groups valueOf(String s)
        {
            return (Groups)Enum.valueOf(com/cyberlink/youcammakeup/activity/RecommendationActivity$Groups, s);
        }

        public static Groups[] values()
        {
            return (Groups[])c.clone();
        }

        public void a(Intent intent)
        {
            intent.putExtra("Groups", ordinal());
        }

        static 
        {
            a = new Groups("Recommendation", 0) {

                public String toString()
                {
                    return "GROUP_ANDOIRD_YMK_RECOMMENDATION_001";
                }

            };
            b = new Groups("CyberLink", 1) {

                public String toString()
                {
                    return "GROUP_ANDROID_YMK_CYBERLINK_APP";
                }

            };
            c = (new Groups[] {
                a, b
            });
        }

        private Groups(String s, int i1)
        {
            super(s, i1);
        }

    }

}
