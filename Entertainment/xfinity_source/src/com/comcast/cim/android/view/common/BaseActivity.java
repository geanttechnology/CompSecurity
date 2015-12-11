// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.DefaultSpeechListener;
import com.comcast.cim.android.accessibility.PassiveStateChangeListener;
import com.comcast.cim.android.accessibility.SpeechDelegate;
import com.comcast.cim.android.accessibility.SpeechListener;
import com.comcast.cim.android.accessibility.SpeechRecognizer;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.container.CALContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.view.common:
//            OrientationStrategyProvider, BaseActivityDelegate, OrientationStrategy

public abstract class BaseActivity extends Activity
    implements AlternateInterfaceListener, PassiveStateChangeListener, OrientationStrategyProvider
{
    protected class ActivitySpeechListener extends DefaultSpeechListener
    {

        final BaseActivity this$0;

        public boolean onSpeechResponseCancel()
        {
            getTalkDelegate().stopSpeaking();
            return true;
        }

        public boolean onSpeechResponseClose()
        {
            finish();
            return true;
        }

        protected ActivitySpeechListener()
        {
            this$0 = BaseActivity.this;
            super();
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/common/BaseActivity);
    private ActionBar actionBar;
    protected TextView actionBarTitle;
    private final AndroidDevice androidDevice = CALContainer.getInstance().getAndroidDevice();
    private BaseActivityDelegate baseActivityDelegate;
    private OrientationStrategy defaultOrientationStrategy;
    public boolean ignoreAnnounceTitle;

    public BaseActivity()
    {
        baseActivityDelegate = CALContainer.getInstance().getBaseActivityDelegate(this, this);
        defaultOrientationStrategy = CALContainer.getInstance().getDefaultOrientationStrategy();
        ignoreAnnounceTitle = false;
    }

    protected void addDefaultActivitySpeechListener()
    {
        baseActivityDelegate.addSpeechListener(new ActivitySpeechListener());
    }

    public void addSpeechListener(SpeechListener speechlistener)
    {
        baseActivityDelegate.addSpeechListener(speechlistener);
    }

    protected void checkTalkBackModeOnResume()
    {
        baseActivityDelegate.checkTalkBackModeOnResume();
    }

    public void checkTalkBackModeOnResume(Intent intent)
    {
        baseActivityDelegate.checkTalkBackModeOnResume(intent);
    }

    public OrientationStrategy getOrientationStrategy()
    {
        return defaultOrientationStrategy;
    }

    public SpeechDelegate getSpeechDelegate()
    {
        return baseActivityDelegate.getSpeechDelegate();
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/comcast/cim/android/accessibility/SpeechRecognizer;
    }

    public TalkDelegate getTalkDelegate()
    {
        return baseActivityDelegate.getTalkDelegate();
    }

    public boolean isAccessibilityEnabled()
    {
        return baseActivityDelegate.isAccessibilityEnabled();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        baseActivityDelegate.onActivityResult(i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (androidDevice.isKindle())
        {
            getWindow().addFlags(1024);
        }
        baseActivityDelegate.onCreate();
        actionBar = getActionBar();
        if (actionBar != null)
        {
            bundle = actionBar.getCustomView();
            if (bundle != null)
            {
                actionBarTitle = (TextView)bundle.findViewById(com.comcast.cim.android.R.id.title);
                if (actionBarTitle != null)
                {
                    actionBarTitle.setText(getTitle());
                }
            }
        }
        addDefaultActivitySpeechListener();
    }

    public View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        View view = baseActivityDelegate.createView(s, context, attributeset);
        if (view != null)
        {
            return view;
        } else
        {
            return super.onCreateView(s, context, attributeset);
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        baseActivityDelegate.onDestroy();
    }

    protected void onResume()
    {
        super.onResume();
        baseActivityDelegate.onResume();
    }

    public void onSpeechSwipe()
    {
        ignoreAnnounceTitle = true;
        baseActivityDelegate.onSpeechSwipe(getSpeechRecognizerClass());
    }

    public void removeSpeechListener(SpeechListener speechlistener)
    {
        baseActivityDelegate.removeSpeechListener(speechlistener);
    }

    protected void resetActionBarIcon()
    {
        actionBar.setIcon(com.comcast.cim.android.R.drawable.ico_browse);
    }

    protected void setActionBarIcon(int i)
    {
        actionBar.setIcon(i);
    }

    public void setTitle(int i)
    {
        super.setTitle(i);
        if (actionBarTitle != null)
        {
            actionBarTitle.setText(i);
        }
    }

    public void setTitle(CharSequence charsequence)
    {
        super.setTitle(charsequence);
        if (actionBarTitle != null)
        {
            actionBarTitle.setText(charsequence);
        }
    }

    public void setupPassiveGestureDetector(View view, int i)
    {
        baseActivityDelegate.setupPassiveGestureDetector(view, i, this);
    }

    protected void setupTalkDelegateDefault()
    {
        baseActivityDelegate.setupTalkDelegateDefault();
    }

    protected void setupTalkDelegateForAccessibilityViaLayout()
    {
        baseActivityDelegate.setupTalkDelegateForAccessibilityViaLayout();
    }

}
