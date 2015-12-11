// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.player.SdkVideoView;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.ConversationMenuHelper;
import com.jeremyfeinstein.slidingmenu.lib.SlidingActivityHelper;

// Referenced classes of package co.vine.android:
//            BaseActionBarActivity, ScrollListener

public abstract class BaseControllerActionBarActivity extends BaseActionBarActivity
    implements ScrollListener
{

    public static final String EXTRA_TITLE_ID = "title";
    protected AppController mAppController;
    protected AppSessionListener mAppSessionListener;
    private ConversationMenuHelper mConversationSlidingMenuHelper;

    public BaseControllerActionBarActivity()
    {
    }

    protected SlidingActivityHelper createSlidingMenuHelper()
    {
        mConversationSlidingMenuHelper = new ConversationMenuHelper(this);
        return mConversationSlidingMenuHelper;
    }

    public AppController getAppController()
    {
        return mAppController;
    }

    public ConversationMenuHelper getConversationSlidingMenuHelper()
    {
        return mConversationSlidingMenuHelper;
    }

    public boolean isConversationSideMenuEnabled()
    {
        return false;
    }

    protected boolean isSlidingMenuEnabled()
    {
        return isConversationSideMenuEnabled();
    }

    public void notifyColorChange(int i)
    {
        if (mConversationSlidingMenuHelper != null)
        {
            mConversationSlidingMenuHelper.setPersonalizedColor(i);
        }
    }

    protected void onCreate(Bundle bundle, int i, boolean flag)
    {
        onCreate(bundle, i, flag, false);
    }

    public void onCreate(Bundle bundle, int i, boolean flag, boolean flag1)
    {
        super.onCreate(bundle, i, flag, flag1);
        mAppController = AppController.getInstance(this);
        if (mConversationSlidingMenuHelper != null)
        {
            mConversationSlidingMenuHelper.setupConversationSlidingMenu();
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (android.os.Build.VERSION.SDK_INT >= 14 && !BuildUtil.isExplore())
        {
            SdkVideoView.releaseStaticIfNeeded();
        }
    }

    protected void onPause()
    {
        super.onPause();
        if (mConversationSlidingMenuHelper != null)
        {
            mConversationSlidingMenuHelper.onPause();
        }
        if (mAppSessionListener != null)
        {
            mAppController.removeListener(mAppSessionListener);
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (mConversationSlidingMenuHelper != null)
        {
            mConversationSlidingMenuHelper.onResume();
        }
        if (mAppSessionListener != null)
        {
            mAppController.addListener(mAppSessionListener);
        }
    }

    public void onScroll(int i)
    {
    }
}
