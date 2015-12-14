// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.res.Resources;
import android.support.v7.widget.Toolbar;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.view.ViewStateListener;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.di.AppKeys;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorActionBar, GalleryNavigationSetting, GalleryToolbar

public class FreetimeActionBar extends ThorActionBar
{

    private FeatureChecker featureChecker;
    protected String headerName;

    public FreetimeActionBar(BeanAwareActivity beanawareactivity, boolean flag, Toolbar toolbar)
    {
        super(null, beanawareactivity, flag, toolbar);
        featureChecker = (FeatureChecker)beanawareactivity.getApplicationBean(AppKeys.FEATURE_CHECKER);
        if (featureChecker.alwaysTransparentHAB())
        {
            headerName = "";
            resetBackground();
        } else
        {
            headerName = beanawareactivity.getResources().getString(0x7f0e0059);
        }
        if (!featureChecker.hasLeftPanel())
        {
            this.toolbar.setNavigationSetting(GalleryNavigationSetting.NONE);
        }
    }

    protected boolean isTintEnabled()
    {
        return false;
    }

    protected boolean isTransparent()
    {
        if (featureChecker.alwaysTransparentHAB())
        {
            return true;
        } else
        {
            return super.isTransparent();
        }
    }

    protected void updateCounter(String s)
    {
        if (featureChecker.alwaysTransparentHAB())
        {
            s = "";
        }
        super.updateCounter(s);
    }

    public void viewStateChanged(ViewDescriptor viewdescriptor)
    {
        boolean flag1 = featureChecker.alwaysTransparentHAB();
        updateTitle(headerName);
        viewStateListener.onFocusedGained(viewdescriptor);
        boolean flag;
        if (viewdescriptor.getMediaItem() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        updateRefineSubtitleState(viewdescriptor);
        resetBackground();
        if (!featureChecker.hasLeftPanel())
        {
            viewdescriptor = GalleryNavigationSetting.NONE;
        } else
        if (flag && !flag1)
        {
            viewdescriptor = GalleryNavigationSetting.BACK;
        } else
        if (viewdescriptor.getCollectionType() == com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.TAG)
        {
            viewdescriptor = GalleryNavigationSetting.BACK;
        } else
        {
            viewdescriptor = GalleryNavigationSetting.NONE;
        }
        toolbar.setNavigationSetting(viewdescriptor);
    }
}
