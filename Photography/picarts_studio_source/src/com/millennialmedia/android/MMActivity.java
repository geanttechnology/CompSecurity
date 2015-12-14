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

// Referenced classes of package com.millennialmedia.android:
//            MMBaseActivity, MMAdImplController, MMLog

public class MMActivity extends Activity
{

    MMBaseActivity a;
    long b;
    private GestureDetector c;

    public MMActivity()
    {
    }

    final void a()
    {
        super.onDestroy();
    }

    final void a(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
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

    final boolean a(MotionEvent motionevent)
    {
        return super.dispatchTouchEvent(motionevent);
    }

    final void b()
    {
        super.onStart();
    }

    final void b(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    final void c()
    {
        super.onStop();
    }

    final void c(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    final void d()
    {
        super.onResume();
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (c != null)
        {
            c.onTouchEvent(motionevent);
        }
        if (a != null)
        {
            return a.dispatchTouchEvent(motionevent);
        } else
        {
            return super.dispatchTouchEvent(motionevent);
        }
    }

    final void e()
    {
        super.onPause();
    }

    final Object f()
    {
        return super.onRetainNonConfigurationInstance();
    }

    public void finish()
    {
        if (a != null)
        {
            a.finish();
            return;
        } else
        {
            MMSDK.Event.e(MMAdImplController.a(b));
            super.finish();
            return;
        }
    }

    public void finishSuper()
    {
        MMSDK.Event.e(MMAdImplController.a(b));
        super.finish();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (a != null)
        {
            a.a(i, j, intent);
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
            a.onConfigurationChanged(configuration);
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
        a = (MMBaseActivity)Class.forName(s1).newInstance();
        s = s1;
        a.b = this;
        s = s1;
        a.onCreate(bundle);
        s = s1;
        try
        {
            c = new GestureDetector(getApplicationContext(), new InterstitialGestureListener());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            MMLog.a("MMActivity", String.format("Could not start activity for %s. ", new Object[] {
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
            a.onDestroy();
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
            return a.onKeyDown(i, keyevent);
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPause()
    {
        if (a != null)
        {
            a.b();
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
            a.b.Activity.onRestart();
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
            a.b(bundle);
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
            a.a();
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
            return a.onRetainNonConfigurationInstance();
        } else
        {
            return super.onRetainNonConfigurationInstance();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (a != null)
        {
            a.a(bundle);
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
            a.d();
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
            a.c();
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
            a.onWindowFocusChanged(flag);
            return;
        } else
        {
            super.onWindowFocusChanged(flag);
            return;
        }
    }

    private class InterstitialGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        private WeakReference a;

        public boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            motionevent = (MMActivity)a.get();
            if (motionevent != null)
            {
                MMSDK.Event.a(MMAdImplController.a(((MMActivity) (motionevent)).b));
            }
            return false;
        }

        public InterstitialGestureListener()
        {
            a = new WeakReference(MMActivity.this);
        }
    }

}
