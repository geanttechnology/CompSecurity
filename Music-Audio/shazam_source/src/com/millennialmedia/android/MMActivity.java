// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            ae, ac, al

public class MMActivity extends Activity
{
    private static final class a extends android.view.GestureDetector.SimpleOnGestureListener
    {

        WeakReference a;

        public final boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            motionevent = (MMActivity)a.get();
            if (motionevent != null)
            {
                an.a.a(ac.a(((MMActivity) (motionevent)).b));
            }
            return false;
        }

        public a(MMActivity mmactivity)
        {
            a = new WeakReference(mmactivity);
        }
    }


    ae a;
    long b;
    GestureDetector c;

    public MMActivity()
    {
    }

    final void a()
    {
        super.onDestroy();
    }

    final void a(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    final void a(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    final void a(boolean flag)
    {
        super.onWindowFocusChanged(flag);
    }

    final boolean a(int i, KeyEvent keyevent)
    {
        return super.onKeyDown(i, keyevent);
    }

    final void b()
    {
        super.onStop();
    }

    final void b(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    final void c()
    {
        super.onResume();
    }

    final void c(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    final void d()
    {
        super.onPause();
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (c != null)
        {
            c.onTouchEvent(motionevent);
        }
        if (a != null)
        {
            return a.d.Activity.dispatchTouchEvent(motionevent);
        } else
        {
            return super.dispatchTouchEvent(motionevent);
        }
    }

    final Object e()
    {
        return super.onRetainNonConfigurationInstance();
    }

    public final void f()
    {
        an.a.e(ac.a(b));
        super.finish();
    }

    public void finish()
    {
        if (a != null)
        {
            a.a();
            return;
        } else
        {
            an.a.e(ac.a(b));
            super.finish();
            return;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (a != null)
        {
            a.d.Activity.onActivityResult(i, j, intent);
            return;
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (a != null)
        {
            a.a(configuration);
            return;
        } else
        {
            super.onConfigurationChanged(configuration);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        String s;
        super.onCreate(bundle);
        s = null;
        b = getIntent().getLongExtra("internalId", -4L);
        String s1 = getIntent().getStringExtra("class");
        s = s1;
        a = (ae)Class.forName(s1).newInstance();
        s = s1;
        a.d = this;
        s = s1;
        a.a(bundle);
        s = s1;
        try
        {
            c = new GestureDetector(getApplicationContext(), new a(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            al.a("MMActivity", String.format("Could not start activity for %s. ", new Object[] {
                s
            }), bundle);
        }
        bundle.printStackTrace();
        finish();
        return;
    }

    protected void onDestroy()
    {
        if (a != null)
        {
            a.d();
            return;
        } else
        {
            super.onDestroy();
            return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (a != null)
        {
            return a.a(i, keyevent);
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPause()
    {
        if (a != null)
        {
            a.c();
            return;
        } else
        {
            super.onPause();
            return;
        }
    }

    protected void onRestart()
    {
        if (a != null)
        {
            a.d.Activity.onRestart();
            return;
        } else
        {
            super.onRestart();
            return;
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        if (a != null)
        {
            a.c(bundle);
            return;
        } else
        {
            super.onRestoreInstanceState(bundle);
            return;
        }
    }

    protected void onResume()
    {
        if (a != null)
        {
            a.b();
            return;
        } else
        {
            super.onResume();
            return;
        }
    }

    public Object onRetainNonConfigurationInstance()
    {
        if (a != null)
        {
            return a.f();
        } else
        {
            return super.onRetainNonConfigurationInstance();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (a != null)
        {
            a.b(bundle);
            return;
        } else
        {
            super.onSaveInstanceState(bundle);
            return;
        }
    }

    protected void onStart()
    {
        if (a != null)
        {
            a.d.Activity.onStart();
            return;
        } else
        {
            super.onStart();
            return;
        }
    }

    protected void onStop()
    {
        if (a != null)
        {
            a.e();
            return;
        } else
        {
            super.onStop();
            return;
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        if (a != null)
        {
            a.b(flag);
            return;
        } else
        {
            super.onWindowFocusChanged(flag);
            return;
        }
    }
}
