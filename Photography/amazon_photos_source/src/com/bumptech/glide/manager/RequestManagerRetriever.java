// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.bumptech.glide.manager:
//            ApplicationLifecycle, RequestManagerFragment, SupportRequestManagerFragment

public class RequestManagerRetriever
    implements android.os.Handler.Callback
{

    private static final RequestManagerRetriever INSTANCE = new RequestManagerRetriever();
    private volatile RequestManager applicationManager;
    private final Handler handler = new Handler(Looper.getMainLooper(), this);
    final Map pendingRequestManagerFragments = new HashMap();
    final Map pendingSupportRequestManagerFragments = new HashMap();

    RequestManagerRetriever()
    {
    }

    private static void assertNotDestroyed(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())
        {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        } else
        {
            return;
        }
    }

    public static RequestManagerRetriever get()
    {
        return INSTANCE;
    }

    private RequestManager getApplicationManager(Context context)
    {
        if (applicationManager != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (applicationManager == null)
        {
            applicationManager = new RequestManager(context.getApplicationContext(), new ApplicationLifecycle());
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return applicationManager;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
    }

    RequestManager fragmentGet(Context context, FragmentManager fragmentmanager)
    {
        Object obj = (RequestManagerFragment)fragmentmanager.findFragmentByTag("com.bumptech.glide.manager");
        RequestManagerFragment requestmanagerfragment = ((RequestManagerFragment) (obj));
        if (obj == null)
        {
            obj = (RequestManagerFragment)pendingRequestManagerFragments.get(fragmentmanager);
            requestmanagerfragment = ((RequestManagerFragment) (obj));
            if (obj == null)
            {
                requestmanagerfragment = new RequestManagerFragment();
                pendingRequestManagerFragments.put(fragmentmanager, requestmanagerfragment);
                fragmentmanager.beginTransaction().add(requestmanagerfragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
                handler.obtainMessage(1, fragmentmanager).sendToTarget();
            }
        }
        obj = requestmanagerfragment.getRequestManager();
        fragmentmanager = ((FragmentManager) (obj));
        if (obj == null)
        {
            fragmentmanager = new RequestManager(context, requestmanagerfragment.getLifecycle());
            requestmanagerfragment.setRequestManager(fragmentmanager);
        }
        return fragmentmanager;
    }

    public RequestManager get(Activity activity)
    {
        if (Util.isOnBackgroundThread() || android.os.Build.VERSION.SDK_INT < 11)
        {
            return get(activity.getApplicationContext());
        } else
        {
            assertNotDestroyed(activity);
            return fragmentGet(activity, activity.getFragmentManager());
        }
    }

    public RequestManager get(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (Util.isOnMainThread() && !(context instanceof Application))
        {
            if (context instanceof FragmentActivity)
            {
                return get((FragmentActivity)context);
            }
            if (context instanceof Activity)
            {
                return get((Activity)context);
            }
            if (context instanceof ContextWrapper)
            {
                return get(((ContextWrapper)context).getBaseContext());
            }
        }
        return getApplicationManager(context);
    }

    public RequestManager get(Fragment fragment)
    {
        if (fragment.getActivity() == null)
        {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (Util.isOnBackgroundThread())
        {
            return get(fragment.getActivity().getApplicationContext());
        } else
        {
            android.support.v4.app.FragmentManager fragmentmanager = fragment.getChildFragmentManager();
            return supportFragmentGet(fragment.getActivity(), fragmentmanager);
        }
    }

    public RequestManager get(FragmentActivity fragmentactivity)
    {
        if (Util.isOnBackgroundThread())
        {
            return get(fragmentactivity.getApplicationContext());
        } else
        {
            assertNotDestroyed(fragmentactivity);
            return supportFragmentGet(fragmentactivity, fragmentactivity.getSupportFragmentManager());
        }
    }

    public boolean handleMessage(Message message)
    {
        Object obj;
        Object obj1;
        boolean flag;
        flag = true;
        obj = null;
        obj1 = null;
        message.what;
        JVM INSTR tableswitch 1 2: default 32
    //                   1 83
    //                   2 107;
           goto _L1 _L2 _L3
_L1:
        flag = false;
        message = obj1;
_L5:
        if (flag && obj == null && Log.isLoggable("com.bumptech.glide.manager", 5))
        {
            Log.w("com.bumptech.glide.manager", (new StringBuilder()).append("Failed to remove expected request manager fragment, manager: ").append(message).toString());
        }
        return flag;
_L2:
        obj = (FragmentManager)message.obj;
        message = ((Message) (obj));
        obj = pendingRequestManagerFragments.remove(obj);
        continue; /* Loop/switch isn't completed */
_L3:
        obj = (android.support.v4.app.FragmentManager)message.obj;
        message = ((Message) (obj));
        obj = pendingSupportRequestManagerFragments.remove(obj);
        if (true) goto _L5; else goto _L4
_L4:
    }

    RequestManager supportFragmentGet(Context context, android.support.v4.app.FragmentManager fragmentmanager)
    {
        Object obj = (SupportRequestManagerFragment)fragmentmanager.findFragmentByTag("com.bumptech.glide.manager");
        SupportRequestManagerFragment supportrequestmanagerfragment = ((SupportRequestManagerFragment) (obj));
        if (obj == null)
        {
            obj = (SupportRequestManagerFragment)pendingSupportRequestManagerFragments.get(fragmentmanager);
            supportrequestmanagerfragment = ((SupportRequestManagerFragment) (obj));
            if (obj == null)
            {
                supportrequestmanagerfragment = new SupportRequestManagerFragment();
                pendingSupportRequestManagerFragments.put(fragmentmanager, supportrequestmanagerfragment);
                fragmentmanager.beginTransaction().add(supportrequestmanagerfragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
                handler.obtainMessage(2, fragmentmanager).sendToTarget();
            }
        }
        obj = supportrequestmanagerfragment.getRequestManager();
        fragmentmanager = ((android.support.v4.app.FragmentManager) (obj));
        if (obj == null)
        {
            fragmentmanager = new RequestManager(context, supportrequestmanagerfragment.getLifecycle());
            supportrequestmanagerfragment.setRequestManager(fragmentmanager);
        }
        return fragmentmanager;
    }

}
