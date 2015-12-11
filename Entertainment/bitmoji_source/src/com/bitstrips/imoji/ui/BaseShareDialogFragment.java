// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.manager.RecentImojiesManager;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.util.PreferenceUtils;
import java.io.File;
import java.util.List;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ResolveInfosSorter, IntentCreatorService

public abstract class BaseShareDialogFragment extends DialogFragment
{

    public static String FILE_PATH_KEY = "filePath";
    public static String IMOJI_KEY = "imoji";
    public static String INTENT_KEY = "intent";
    AnalyticsService analytics;
    protected String filePath;
    protected Imoji imoji;
    IntentCreatorService intentCreatorService;
    PreferenceUtils preferenceUtils;
    RecentImojiesManager recentImojiesManager;
    private com.bitstrips.imoji.manager.RecentImojiesManager.Callback recentsCallback;
    ResolveInfosSorter resolveInfosSorter;
    protected Intent shareIntent;

    public BaseShareDialogFragment()
    {
        recentsCallback = null;
    }

    protected void addToRecents()
    {
        recentImojiesManager.addRecentTemplateId(imoji.getTemplateId(), recentsCallback);
    }

    protected void commonShareAppMethod(String s)
    {
        shareIntent.setPackage(s);
        startActivity(shareIntent);
    }

    abstract View createButton(LayoutInflater layoutinflater, String s, Drawable drawable);

    protected View createShareAppButton(LayoutInflater layoutinflater, final ResolveInfo resolveInfo)
    {
        layoutinflater = createButton(layoutinflater, resolveInfo.loadLabel(getActivity().getPackageManager()).toString(), resolveInfo.loadIcon(getActivity().getPackageManager()));
        layoutinflater.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseShareDialogFragment this$0;
            final ResolveInfo val$resolveInfo;

            public void onClick(View view)
            {
                addToRecents();
                view = resolveInfo.activityInfo.packageName;
                preferenceUtils.increaseShareImageAppPriority(view);
                sendAnalyticsEvents(view);
                if (view.equals("com.facebook.orca"))
                {
                    shareToFacebookMessenger();
                } else
                if (view.equals("com.facebook.katana"))
                {
                    shareToFacebook();
                } else
                {
                    commonShareAppMethod(view);
                }
                dismiss();
            }

            
            {
                this$0 = BaseShareDialogFragment.this;
                resolveInfo = resolveinfo;
                super();
            }
        });
        return layoutinflater;
    }

    protected List getResolveInfos(String as[])
    {
        as = preferenceUtils.getShareImagePackagePriorityMap(as);
        return resolveInfosSorter.sort(getActivity().getPackageManager().queryIntentActivities(shareIntent, 0), as);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((InjectorApplication)getActivity().getApplication()).inject(this);
        shareIntent = (Intent)getArguments().get(INTENT_KEY);
        imoji = (Imoji)getArguments().getParcelable(IMOJI_KEY);
        filePath = getArguments().getString(FILE_PATH_KEY);
    }

    abstract void sendAnalyticsEvents(String s);

    protected void setRecentsCallback(com.bitstrips.imoji.manager.RecentImojiesManager.Callback callback)
    {
        recentsCallback = callback;
    }

    protected void shareToFacebook()
    {
        commonShareAppMethod("com.facebook.katana");
    }

    protected void shareToFacebookMessenger()
    {
        intentCreatorService.createFacebookMessengerIntent(getActivity(), Uri.fromFile(new File(filePath)), imoji.getTemplateId());
    }

}
