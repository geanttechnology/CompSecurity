// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.app.ListActivity;

// Referenced classes of package cn.jpush.android.api:
//            JPushInterface

public class InstrumentedListActivity extends ListActivity
{

    public InstrumentedListActivity()
    {
    }

    protected void onPause()
    {
        super.onPause();
        JPushInterface.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        JPushInterface.onResume(this);
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
    }
}
