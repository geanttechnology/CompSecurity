// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.adjust.sdk.Adjust;
import com.appboy.Appboy;
import com.appboy.ui.inappmessage.a;
import com.firegnom.rat.ActivityDestroyListener;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.util.UserSession;
import com.socialin.android.util.Utils;
import com.socialin.android.util.b;
import com.socialin.android.util.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.activity:
//            FragmentActionsListenerActivity, ActivityResultListener

public abstract class BaseActivity extends FragmentActionsListenerActivity
{

    protected ActivityResultListener activityResultListener;
    private FrameLayout galleryItemFragmentFrame;
    private List observers;
    protected boolean refreshData;
    public BaseActivity self;
    private UserSession session;

    public BaseActivity()
    {
        self = this;
    }

    private void addFragmentToView()
    {
        Fragment fragment;
        FragmentTransaction fragmenttransaction;
        Bundle bundle;
        fragmenttransaction = getFragmentManager().beginTransaction();
        fragment = getFragmentManager().findFragmentByTag("gallery_item_show_fragment_tag");
        bundle = new Bundle(fragment.getArguments());
        fragmenttransaction.remove(fragment);
        Fragment fragment1 = (Fragment)fragment.getClass().newInstance();
        fragment = fragment1;
_L2:
        fragment.setArguments(bundle);
        fragmenttransaction.replace(galleryItemFragmentFrame.getId(), fragment, "gallery_item_show_fragment_tag");
        fragmenttransaction.commit();
        return;
        Object obj;
        obj;
        ((InstantiationException) (obj)).printStackTrace();
        continue; /* Loop/switch isn't completed */
        obj;
        ((IllegalAccessException) (obj)).printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void constructGalleryItemFragmentContainer()
    {
        ViewGroup viewgroup = (ViewGroup)getWindow().getDecorView().findViewById(0x1020002);
        android.view.ViewGroup.LayoutParams layoutparams = viewgroup.getLayoutParams();
        galleryItemFragmentFrame = new FrameLayout(this);
        galleryItemFragmentFrame.setId(0x7f10004d);
        galleryItemFragmentFrame.setLayoutParams(layoutparams);
        viewgroup.addView(galleryItemFragmentFrame);
    }

    private void showImagePreviewFragmentContainer()
    {
        if (galleryItemFragmentFrame == null)
        {
            constructGalleryItemFragmentContainer();
            addFragmentToView();
        }
        Utils.a(true, this);
    }

    public void addOnDestroyListener(ActivityDestroyListener activitydestroylistener)
    {
        observers.add(activitydestroylistener);
    }

    public void closeNavigationBar(Runnable runnable)
    {
    }

    public FrameLayout getGalleryItemFragmentFrame()
    {
        if (galleryItemFragmentFrame == null)
        {
            constructGalleryItemFragmentContainer();
        }
        galleryItemFragmentFrame.setVisibility(0);
        return galleryItemFragmentFrame;
    }

    public void hideImagePreviewFragmentContainer()
    {
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentByTag("gallery_item_show_fragment_tag")).commit();
        if (galleryItemFragmentFrame != null)
        {
            galleryItemFragmentFrame.setVisibility(8);
        }
        Utils.a(false, this);
    }

    public boolean isPhotoFragmentOpen()
    {
        return getFragmentManager().findFragmentByTag("gallery_item_show_fragment_tag") != null && getFragmentManager().findFragmentByTag("gallery_item_show_fragment_tag").isAdded();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (activityResultListener != null)
        {
            activityResultListener.onActivityResult(i, j, intent);
        }
    }

    public void onBackPressed()
    {
        if (isPhotoFragmentOpen())
        {
            hideImagePreviewFragmentContainer();
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        for (Iterator iterator = observers.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((ActivityDestroyListener)iterator.next()).onActivityDestroyed();
        }

        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        c.a();
        session = UserSession.getInstance(this);
        observers = new ArrayList();
    }

    public void onDestroy()
    {
        for (Iterator iterator = observers.iterator(); iterator.hasNext(); ((ActivityDestroyListener)iterator.next()).onActivityDestroyed()) { }
        super.onDestroy();
    }

    public void onInstagramTokenResult()
    {
    }

    public void onPause()
    {
        super.onPause();
        try
        {
            a.a().b(this);
            Appboy.getInstance(this).closeSession(this);
            if (SocialinV3.getInstance().getSettings().isAdjustEnabled())
            {
                Adjust.onPause();
            }
            session.stopSession();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (isPhotoFragmentOpen())
        {
            showImagePreviewFragmentContainer();
        }
    }

    public void onResume()
    {
        super.onResume();
        try
        {
            session.startSession();
            if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
            {
                if (Appboy.getInstance(this).openSession(this))
                {
                    b.a(getApplicationContext());
                    b.a();
                    refreshData = true;
                }
                a.a().a(this);
                if (refreshData)
                {
                    Appboy.getInstance(this).requestInAppMessageRefresh();
                    refreshData = false;
                }
            }
            a.a().a(this);
            if (refreshData)
            {
                Appboy.getInstance(this).requestInAppMessageRefresh();
                refreshData = false;
            }
            if (SocialinV3.getInstance().getSettings().isAdjustEnabled())
            {
                Adjust.onResume();
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistablebundle)
    {
        super.onSaveInstanceState(bundle, persistablebundle);
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
    }

    public void setOnResultListener(ActivityResultListener activityresultlistener)
    {
        activityResultListener = activityresultlistener;
    }
}
