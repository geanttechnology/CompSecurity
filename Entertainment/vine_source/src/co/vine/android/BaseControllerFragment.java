// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;

// Referenced classes of package co.vine.android:
//            BaseFragment

public class BaseControllerFragment extends BaseFragment
{

    protected AppController mAppController;
    protected AppSessionListener mAppSessionListener;

    public BaseControllerFragment()
    {
    }

    public AppController getAppController()
    {
        return mAppController;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppController = AppController.getInstance(getActivity());
    }

    public void onPause()
    {
        super.onPause();
        AppController appcontroller = mAppController;
        if (appcontroller != null && mAppSessionListener != null)
        {
            appcontroller.removeListener(mAppSessionListener);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (mAppSessionListener != null)
        {
            mAppController.addListener(mAppSessionListener);
        }
    }
}
