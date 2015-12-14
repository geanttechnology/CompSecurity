// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bd;
import com.cyberlink.youcammakeup.utility.cd;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.a.a;
import com.cyberlink.youcammakeup.widgetpool.a.b;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SettingActivity, TestSettingActivity

public class AboutActivity extends BaseActivity
{

    private android.view.View.OnClickListener a;
    private android.view.View.OnClickListener b;
    private android.view.View.OnClickListener c;

    public AboutActivity()
    {
        a = new android.view.View.OnClickListener() {

            final AboutActivity a;

            public void onClick(View view)
            {
                a.f();
            }

            
            {
                a = AboutActivity.this;
                super();
            }
        };
        b = new android.view.View.OnClickListener() {

            final AboutActivity a;

            public void onClick(View view)
            {
                bd.a(a);
            }

            
            {
                a = AboutActivity.this;
                super();
            }
        };
        c = new android.view.View.OnClickListener() {

            final AboutActivity a;
            private a b;

            public void onClick(View view)
            {
                if (b != null && !b.isVisible())
                {
                    o.a(a, b, "LegalDialog");
                    return;
                } else
                {
                    b = new a();
                    o.a(a, b, "LegalDialog");
                    return;
                }
            }

            
            {
                a = AboutActivity.this;
                super();
                b = null;
            }
        };
    }

    private void a(String s)
    {
        View view = findViewById(0x7f0c007a);
        View view1 = findViewById(0x7f0c007b);
        view.setVisibility(0);
        view1.setVisibility(0);
        view1.setOnClickListener(b);
        ((TextView)findViewById(0x7f0c007c)).setText(s);
    }

    private void b(String s)
    {
        String s1 = z.i();
        if (s1 == null || s1.isEmpty() || !cd.a(s, s1))
        {
            l();
            return;
        } else
        {
            a(s1);
            return;
        }
    }

    private void j()
    {
        findViewById(0x7f0c0076).setOnClickListener(a);
        TextView textview = (TextView)findViewById(0x7f0c0079);
        String s = com.cyberlink.youcammakeup.widgetpool.a.b.a().b();
        textview.setText(s);
        if (Globals.d().c().b())
        {
            b(s);
        } else
        {
            l();
        }
        findViewById(0x7f0c007d).setOnClickListener(c);
    }

    private void k()
    {
        findViewById(0x7f0c0077).setOnTouchListener(new android.view.View.OnTouchListener() {

            final AboutActivity a;
            private boolean b;
            private int c;

            static int a(_cls1 _pcls1, int i)
            {
                _pcls1.c = i;
                return i;
            }

            static boolean a(_cls1 _pcls1, boolean flag)
            {
                _pcls1.b = flag;
                return flag;
            }

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getActionMasked() == 0)
                {
                    if (!b)
                    {
                        b = true;
                        c = 0;
                        view.postDelayed(new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                com.cyberlink.youcammakeup.activity._cls1.a(a, false);
                                com.cyberlink.youcammakeup.activity._cls1.a(a, 0);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        }, 600L);
                    }
                    c = c + 1;
                }
                if (c >= 5)
                {
                    view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/TestSettingActivity);
                    a.startActivity(view);
                }
                return true;
            }

            
            {
                a = AboutActivity.this;
                super();
                b = false;
                c = 0;
            }
        });
    }

    private void l()
    {
        View view = findViewById(0x7f0c007a);
        View view1 = findViewById(0x7f0c007b);
        view.setVisibility(8);
        view1.setVisibility(8);
    }

    public boolean e()
    {
        startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/SettingActivity));
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030002);
        j();
        k();
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
            f();
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    protected void onPause()
    {
        Globals.d().c("aboutPage");
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Globals.d().c(null);
    }
}
