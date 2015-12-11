// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import co.vine.android.util.CrashUtil;
import com.flurry.android.FlurryAgent;

// Referenced classes of package co.vine.android:
//            BaseActionBarActivity

public class BaseFragment extends Fragment
{

    public static final String ARG_ACTION = "action";

    public BaseFragment()
    {
    }

    public static Bundle prepareArguments(Intent intent)
    {
        if (intent != null)
        {
            Bundle bundle;
            if (intent.getExtras() != null)
            {
                bundle = intent.getExtras();
            } else
            {
                bundle = new Bundle();
            }
            bundle.putString("action", intent.getAction());
            return bundle;
        } else
        {
            return null;
        }
    }

    public void onResume()
    {
        super.onResume();
        CrashUtil.set("Fragment", (new StringBuilder()).append(getClass().getName()).append(" - ").append(System.currentTimeMillis()).toString());
        FlurryAgent.onPageView();
    }

    public void setActionBarColor()
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity instanceof BaseActionBarActivity)
        {
            ((BaseActionBarActivity)fragmentactivity).setActionBarColor();
        }
    }

    public void setActionBarColor(int i)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity instanceof BaseActionBarActivity)
        {
            ((BaseActionBarActivity)fragmentactivity).setActionBarColor(i);
        }
    }

    public void setActionBarTransition(TransitionDrawable transitiondrawable)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity instanceof BaseActionBarActivity)
        {
            ((BaseActionBarActivity)fragmentactivity).setActionBarTransition(transitiondrawable);
        }
    }
}
