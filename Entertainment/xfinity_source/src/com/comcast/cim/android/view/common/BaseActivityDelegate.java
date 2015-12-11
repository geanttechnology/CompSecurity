// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.android.debug.hv.ViewServer;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.GestureListenerLayout;
import com.comcast.cim.android.accessibility.PassiveGestureListener;
import com.comcast.cim.android.accessibility.PassiveStateChangeListener;
import com.comcast.cim.android.accessibility.SpeechDelegate;
import com.comcast.cim.android.accessibility.SpeechListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.accessibility.TalkDelegateFactory;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.container.CALContainer;

// Referenced classes of package com.comcast.cim.android.view.common:
//            OrientationStrategyProvider, OrientationStrategy

public class BaseActivityDelegate
{

    private final AccessibilityUtil accessibilityUtil;
    private final Activity activity;
    private final AndroidDevice androidDevice;
    private final android.view.LayoutInflater.Factory customLayoutInflaterFactory = CALContainer.getInstance().getLayoutInflatorFactory();
    private final InputMethodManager inputMethodManager;
    private final OrientationStrategyProvider orientationStrategyProvider;
    private SpeechDelegate speechDelegate;
    private TalkDelegate talkDelegate;
    private final TalkDelegateFactory talkDelegateFactory;
    private boolean wasInAccessibilityMode;

    public BaseActivityDelegate(Activity activity1, OrientationStrategyProvider orientationstrategyprovider, AndroidDevice androiddevice, AccessibilityUtil accessibilityutil, InputMethodManager inputmethodmanager, TalkDelegateFactory talkdelegatefactory)
    {
        activity = activity1;
        orientationStrategyProvider = orientationstrategyprovider;
        androidDevice = androiddevice;
        accessibilityUtil = accessibilityutil;
        inputMethodManager = inputmethodmanager;
        talkDelegateFactory = talkdelegatefactory;
    }

    public void addSpeechListener(SpeechListener speechlistener)
    {
        speechDelegate.addSpeechListener(speechlistener);
    }

    public void checkTalkBackModeOnResume()
    {
        checkTalkBackModeOnResume(null);
    }

    public void checkTalkBackModeOnResume(Intent intent)
    {
        if (accessibilityUtil.isAccessibilityEnabled() != wasInAccessibilityMode)
        {
            wasInAccessibilityMode = accessibilityUtil.isAccessibilityEnabled();
            Intent intent1 = intent;
            if (intent == null)
            {
                intent1 = activity.getIntent();
                activity.finish();
            }
            activity.startActivity(intent1);
        }
    }

    public View createView(String s, Context context, AttributeSet attributeset)
    {
        return customLayoutInflaterFactory.onCreateView(s, context, attributeset);
    }

    public SpeechDelegate getSpeechDelegate()
    {
        return speechDelegate;
    }

    public TalkDelegate getTalkDelegate()
    {
        if (talkDelegate == null)
        {
            talkDelegate = talkDelegateFactory.getTalkDelegate(activity, null);
        }
        return talkDelegate;
    }

    public boolean isAccessibilityEnabled()
    {
        return accessibilityUtil.isAccessibilityEnabled();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (speechDelegate.onActivityResult(i, j, intent));
    }

    public void onCreate()
    {
        activity.setRequestedOrientation(orientationStrategyProvider.getOrientationStrategy().getAppropriateOrientation());
        if (androidDevice.isDebuggable())
        {
            ViewServer.get(activity).addWindow(activity);
        }
        wasInAccessibilityMode = accessibilityUtil.isAccessibilityEnabled();
        getTalkDelegate();
        speechDelegate = new SpeechDelegate(activity);
        talkDelegate.ignoreAnnounceTitleOnce();
    }

    public void onDestroy()
    {
        if (androidDevice.isDebuggable())
        {
            ViewServer.get(activity).removeWindow(activity);
        }
        talkDelegate.onDestroy();
    }

    public void onResume()
    {
        if (androidDevice.isDebuggable())
        {
            ViewServer.get(activity).setFocusedWindow(activity);
        }
        talkDelegate.announceTitle();
    }

    public void onSpeechSwipe(Class class1)
    {
        talkDelegate.stopSpeaking();
        speechDelegate.getSpeechInput(class1);
    }

    public void removeSpeechListener(SpeechListener speechlistener)
    {
        speechDelegate.removeSpeechListener(speechlistener);
    }

    public void setupPassiveGestureDetector(View view, int i, PassiveStateChangeListener passivestatechangelistener)
    {
        if (isAccessibilityEnabled())
        {
            ((GestureListenerLayout)view.findViewById(i)).setGestureListener(new GestureDetector(activity, new PassiveGestureListener(passivestatechangelistener)));
        }
    }

    protected void setupTalkDelegateDefault()
    {
        if (isAccessibilityEnabled())
        {
            talkDelegate = talkDelegateFactory.getDefaultTalkDelegate(activity);
        }
    }

    protected void setupTalkDelegateForAccessibilityViaLayout()
    {
        if (isAccessibilityEnabled())
        {
            talkDelegate = talkDelegateFactory.getTalkDelegate(activity, activity.getWindow().getDecorView());
        }
    }
}
