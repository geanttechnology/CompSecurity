// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import java.io.File;

// Referenced classes of package com.millennialmedia.android:
//            MMActivity

class MMBaseActivity
{

    MMActivity b;

    MMBaseActivity()
    {
    }

    protected void a()
    {
        b.d();
    }

    protected void a(int i, int j, Intent intent)
    {
        b.a(i, j, intent);
    }

    protected void a(Bundle bundle)
    {
        b.b(bundle);
    }

    protected void b()
    {
        b.e();
    }

    protected void b(Bundle bundle)
    {
        b.c(bundle);
    }

    protected void c()
    {
        b.c();
    }

    protected void d()
    {
        b.b();
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        return b.a(motionevent);
    }

    public void finish()
    {
        b.finishSuper();
    }

    public File getCacheDir()
    {
        return b.getCacheDir();
    }

    public ContentResolver getContentResolver()
    {
        return b.getContentResolver();
    }

    public Intent getIntent()
    {
        return b.getIntent();
    }

    public Object getLastNonConfigurationInstance()
    {
        return b.getLastNonConfigurationInstance();
    }

    public Object getSystemService(String s)
    {
        return b.getSystemService(s);
    }

    public Window getWindow()
    {
        return b.getWindow();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        b.a(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        b.a(bundle);
    }

    protected void onDestroy()
    {
        b.a();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return b.a(i, keyevent);
    }

    public Object onRetainNonConfigurationInstance()
    {
        return b.f();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        b.a(flag);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        return b.registerReceiver(broadcastreceiver, intentfilter);
    }

    public final boolean requestWindowFeature(int i)
    {
        return b.requestWindowFeature(i);
    }

    public final void runOnUiThread(Runnable runnable)
    {
        b.runOnUiThread(runnable);
    }

    public void setContentView(View view)
    {
        b.setContentView(view);
    }

    public void setRequestedOrientation(int i)
    {
        b.setRequestedOrientation(i);
    }

    public final void setResult(int i)
    {
        b.setResult(i);
    }

    public void setTheme(int i)
    {
        b.setTheme(i);
    }

    public void startActivity(Intent intent)
    {
        b.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i)
    {
        b.startActivityForResult(intent, i);
    }

    public void unregisterReceiver(BroadcastReceiver broadcastreceiver)
    {
        b.unregisterReceiver(broadcastreceiver);
    }
}
