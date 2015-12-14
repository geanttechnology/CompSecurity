// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.utility.d;

// Referenced classes of package com.cyberlink.you:
//            g

public class BaseActivity extends Activity
{

    public BaseActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        Log.v("BaseActivity", (new StringBuilder()).append("[onCreate] ").append(getClass().getName()).toString());
        g.a = this;
        g.a().g(this);
        super.onCreate(bundle);
    }

    protected void onDestroy()
    {
        Log.v("BaseActivity", (new StringBuilder()).append("[onDestroy] ").append(getClass().getName()).toString());
        super.onDestroy();
    }

    protected void onPause()
    {
        Log.v("BaseActivity", (new StringBuilder()).append("[onPause] ").append(getClass().getName()).toString());
        super.onPause();
        LoadImageUtils.a();
    }

    protected void onRestart()
    {
        Log.v("BaseActivity", (new StringBuilder()).append("[onRestart] ").append(getClass().getName()).toString());
        super.onRestart();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        Log.v("BaseActivity", (new StringBuilder()).append("[onRestoreInstanceState] savedInstanceState: ").append(d.a(bundle)).toString());
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        Log.v("BaseActivity", (new StringBuilder()).append("[onResume] ").append(getClass().getName()).toString());
        g.a = this;
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        Log.v("BaseActivity", (new StringBuilder()).append("[onSaveInstanceState] outState before super: ").append(d.a(bundle)).toString());
        super.onSaveInstanceState(bundle);
        Log.v("BaseActivity", (new StringBuilder()).append("[onSaveInstanceState] outState after super: ").append(d.a(bundle)).toString());
    }

    protected void onStart()
    {
        Log.v("BaseActivity", (new StringBuilder()).append("[onStart] ").append(getClass().getName()).toString());
        super.onStart();
        long l = Runtime.getRuntime().totalMemory();
        long l1 = Runtime.getRuntime().totalMemory();
        long l2 = Runtime.getRuntime().freeMemory();
        Log.v(getClass().getSimpleName(), (new StringBuilder()).append("totalMemory: ").append(l).append(" totalMemory (in-used): ").append(l1 - l2).toString());
        Log.v(getClass().getSimpleName(), (new StringBuilder()).append("nativeHeapAllocatedSize: ").append(Debug.getNativeHeapAllocatedSize()).append(" nativeHeapSize:").append(Debug.getNativeHeapSize()).toString());
    }

    protected void onStop()
    {
        Log.v("BaseActivity", (new StringBuilder()).append("[onStop] ").append(getClass().getName()).toString());
        super.onStop();
    }
}
