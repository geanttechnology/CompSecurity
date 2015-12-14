// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.utility.d;

// Referenced classes of package com.cyberlink.you:
//            g

public class BaseFragmentActivity extends FragmentActivity
{

    public BaseFragmentActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        Log.v("BaseFragmentActivity", (new StringBuilder()).append("[onCreate] ").append(getClass().getName()).toString());
        g.a = this;
        g.a().g(this);
        super.onCreate(bundle);
    }

    protected void onDestroy()
    {
        Log.v("BaseFragmentActivity", (new StringBuilder()).append("[onDestroy] ").append(getClass().getName()).toString());
        super.onDestroy();
    }

    protected void onPause()
    {
        Log.v("BaseFragmentActivity", (new StringBuilder()).append("[onPause] ").append(getClass().getName()).toString());
        super.onPause();
        LoadImageUtils.a();
    }

    protected void onRestart()
    {
        Log.v("BaseFragmentActivity", (new StringBuilder()).append("[onRestart] ").append(getClass().getName()).toString());
        super.onRestart();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        try
        {
            Log.v("BaseFragmentActivity", (new StringBuilder()).append("[onRestoreInstanceState] savedInstanceState: ").append(d.a(bundle)).toString());
            super.onRestoreInstanceState(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
    }

    protected void onResume()
    {
        Log.v("BaseFragmentActivity", (new StringBuilder()).append("[onResume] ").append(getClass().getName()).toString());
        g.a = this;
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        try
        {
            Log.v("BaseFragmentActivity", (new StringBuilder()).append("[onSaveInstanceState] outState before super: ").append(d.a(bundle)).toString());
            super.onSaveInstanceState(bundle);
            Log.v("BaseFragmentActivity", (new StringBuilder()).append("[onSaveInstanceState] outState after super: ").append(d.a(bundle)).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
    }

    protected void onStart()
    {
        Log.v("BaseFragmentActivity", (new StringBuilder()).append("[onStart] ").append(getClass().getName()).toString());
        super.onStart();
        long l = Runtime.getRuntime().totalMemory();
        long l1 = Runtime.getRuntime().totalMemory();
        long l2 = Runtime.getRuntime().freeMemory();
        Log.v(getClass().getSimpleName(), (new StringBuilder()).append("totalMemory: ").append(l).append(" totalMemory (in-used): ").append(l1 - l2).toString());
        Log.v(getClass().getSimpleName(), (new StringBuilder()).append("nativeHeapAllocatedSize: ").append(Debug.getNativeHeapAllocatedSize()).append(" nativeHeapSize:").append(Debug.getNativeHeapSize()).toString());
    }

    protected void onStop()
    {
        Log.v("BaseFragmentActivity", (new StringBuilder()).append("[onStop] ").append(getClass().getName()).toString());
        super.onStop();
    }
}
