// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ChromeVisibilityEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.view.NoOpViewStateListener;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.view.ViewNameFactory;
import com.amazon.gallery.framework.gallery.view.ViewNotificationManager;
import com.amazon.gallery.framework.gallery.view.ViewStateListener;
import com.amazon.gallery.framework.kindle.amazon.KindleFrameworkDependencyInjector;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.albums.AlbumPageTracker;
import com.amazon.gallery.thor.app.ui.MarginHelper;
import com.amazon.gallery.thor.thisday.ThisDayUtils;
import com.amazon.gallery.thor.thisday.ThisDayViewDescriptor;

// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            ScreenUtil

public abstract class NavigationBar
{

    private static final String TAG = com/amazon/gallery/framework/kindle/ui/NavigationBar.getName();
    protected SparseArray actions;
    protected final Activity activity;
    protected final String counterTextResourceString;
    protected boolean decorOverlayEnabled;
    private ViewGroup navBarLayout;
    protected ViewNotificationManager viewNotificationManager;
    protected final ViewStateListener viewStateListener = new NoOpViewStateListener() {

        boolean enabled;
        final NavigationBar this$0;

        public void onEnterFullScreen()
        {
            if (!enabled)
            {
                return;
            } else
            {
                enterFullScreen();
                return;
            }
        }

        public void onExitFullScreen()
        {
            if (!enabled)
            {
                return;
            } else
            {
                exitFullScreen();
                return;
            }
        }

        public void onFocusedGained(ViewDescriptor viewdescriptor)
        {
            if (!enabled)
            {
                return;
            } else
            {
                updateRefineSubtitleState(viewdescriptor);
                return;
            }
        }

        public void onRotation()
        {
            super.onRotation();
            executeOnRotation();
        }

        public void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag)
        {
            if (!enabled)
            {
                return;
            } else
            {
                viewStateChanged(viewdescriptor);
                return;
            }
        }

            
            {
                this$0 = NavigationBar.this;
                super();
                enabled = true;
            }
    };

    public NavigationBar(Activity activity1)
    {
        decorOverlayEnabled = false;
        actions = new SparseArray();
        activity = activity1;
        counterTextResourceString = activity1.getResources().getString(0x7f0e006e);
        KindleFrameworkDependencyInjector.inject(this);
    }

    public void adjustMargin()
    {
        if (decorOverlayEnabled)
        {
            Resources resources = activity.getResources();
            int i = 0;
            if (resources.getConfiguration().orientation == 2)
            {
                i = ScreenUtil.getNavigationBarWidthForPadding(activity);
            }
            MarginHelper.adjustRightMargin(navBarLayout, i);
            MarginHelper.adjustTopMargin(navBarLayout, ScreenUtil.getStatusBarHeightForPadding(resources));
        }
    }

    public void enterFullScreen()
    {
        this;
        JVM INSTR monitorenter ;
        hide();
        GlobalMessagingBus.post(new ChromeVisibilityEvent(false));
        GLogger.d(TAG, "navbar enter full screen", new Object[0]);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void executeOnRotation()
    {
        int i = (int)activity.getResources().getDimension(0x7f0a000c);
        adjustMargin();
        updateTitleWidth(i);
    }

    public void exitFullScreen()
    {
        this;
        JVM INSTR monitorenter ;
        show();
        GlobalMessagingBus.post(new ChromeVisibilityEvent(true));
        GLogger.d(TAG, "navbar exit full screen", new Object[0]);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void forceHide()
    {
        navBarLayout.setVisibility(4);
    }

    public void forceShow()
    {
        navBarLayout.setVisibility(0);
    }

    public ViewStateListener getViewStateListener()
    {
        return viewStateListener;
    }

    public void hide()
    {
        navBarLayout.animate().alpha(0.0F).setDuration(350L).setListener(new AnimatorListenerAdapter() {

            final NavigationBar this$0;

            public void onAnimationEnd(Animator animator)
            {
                navBarLayout.setVisibility(4);
            }

            
            {
                this$0 = NavigationBar.this;
                super();
            }
        });
    }

    protected void removeCounter()
    {
    }

    public void setNavBarLayout(ViewGroup viewgroup)
    {
        navBarLayout = viewgroup;
    }

    public void setNotificationManager(ViewNotificationManager viewnotificationmanager)
    {
        viewNotificationManager = viewnotificationmanager;
        viewnotificationmanager.addListener(viewStateListener);
    }

    public void show()
    {
        navBarLayout.animate().alpha(1.0F).setDuration(350L).setListener(new AnimatorListenerAdapter() {

            final NavigationBar this$0;

            public void onAnimationStart(Animator animator)
            {
                navBarLayout.bringToFront();
                animator = (View)navBarLayout.getParent();
                if (animator != null && !Api.isAtLeastKitkat())
                {
                    animator.requestLayout();
                }
                navBarLayout.setVisibility(0);
            }

            
            {
                this$0 = NavigationBar.this;
                super();
            }
        });
    }

    protected void updateCounter(String s)
    {
    }

    public void updateHeaderOptions(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
    }

    protected void updateRefineSubtitleState(ViewDescriptor viewdescriptor)
    {
        if (viewdescriptor.getMediaItem() == null || viewdescriptor.isPreload())
        {
            removeCounter();
            return;
        }
        ThisDayViewDescriptor thisdayviewdescriptor = viewdescriptor.getThisDayViewDescriptor();
        if (thisdayviewdescriptor != null && thisdayviewdescriptor.isShuffleData)
        {
            updateCounter(ThisDayUtils.getDateStringLong(activity.getApplicationContext(), thisdayviewdescriptor.focusedMediaItemCreationDate));
            return;
        }
        int i = viewdescriptor.getCollectionSize();
        if (viewdescriptor.getCollectionType().equals(com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.DYNAMIC_ALBUM))
        {
            i = AlbumPageTracker.getInstance().getTotalItems();
        }
        updateCounter(String.format(counterTextResourceString, new Object[] {
            Integer.valueOf(viewdescriptor.getFocusedIndex() + 1), Integer.valueOf(i)
        }));
    }

    protected void updateTitle(String s)
    {
    }

    protected void updateTitleWidth(int i)
    {
    }

    public void viewStateChanged(ViewDescriptor viewdescriptor)
    {
        if (FeatureManager.isFeatureEnabled(Features.HIDE) && activity.getIntent().getBooleanExtra("view_hidden_content_button", false))
        {
            updateTitle(activity.getString(0x7f0e022f));
        } else
        {
            updateTitle(ViewNameFactory.getTitle(viewdescriptor, activity));
        }
        viewStateListener.onFocusedGained(viewdescriptor);
    }


}
