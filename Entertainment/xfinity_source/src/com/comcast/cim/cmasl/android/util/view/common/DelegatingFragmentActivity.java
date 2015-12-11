// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.common:
//            ActivityDelegate

public class DelegatingFragmentActivity extends FragmentActivity
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/android/util/view/common/DelegatingFragmentActivity);
    private List delegateList;

    public DelegatingFragmentActivity()
    {
        delegateList = new ArrayList();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        for (Iterator iterator = delegateList.iterator(); iterator.hasNext(); ((ActivityDelegate)iterator.next()).onActivityResult(i, j, intent)) { }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        for (bundle = delegateList.iterator(); bundle.hasNext(); ((ActivityDelegate)bundle.next()).onCreate()) { }
    }

    public View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        View view = null;
        Object obj = delegateList.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            ActivityDelegate activitydelegate = (ActivityDelegate)((Iterator) (obj)).next();
            if (view == null)
            {
                view = activitydelegate.onCreateView(s, context, attributeset);
            }
        } while (true);
        obj = view;
        if (view == null)
        {
            obj = super.onCreateView(s, context, attributeset);
        }
        return ((View) (obj));
    }

    protected void onPause()
    {
        super.onStart();
        for (Iterator iterator = delegateList.iterator(); iterator.hasNext(); ((ActivityDelegate)iterator.next()).onPause()) { }
    }

    public void onResume()
    {
        super.onResume();
        boolean flag1 = true;
        Iterator iterator = delegateList.iterator();
label0:
        do
        {
            do
            {
                boolean flag = flag1;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                ActivityDelegate activitydelegate = (ActivityDelegate)iterator.next();
                boolean flag2 = activitydelegate.onResume();
                if (flag1 && flag2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag1 = flag;
            } while (flag2);
            flag1 = flag;
        } while (!activitydelegate.isBlocking());
        if (flag)
        {
            onResumeInternal();
        }
    }

    public void onResumeInternal()
    {
    }

    protected void onStart()
    {
        super.onStart();
        for (Iterator iterator = delegateList.iterator(); iterator.hasNext(); ((ActivityDelegate)iterator.next()).onStart()) { }
        onStartInternal();
    }

    public void onStartInternal()
    {
    }

    protected void onStop()
    {
        super.onStart();
        for (Iterator iterator = delegateList.iterator(); iterator.hasNext(); ((ActivityDelegate)iterator.next()).onStop()) { }
    }

}
