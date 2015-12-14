// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.widget;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.internal.AppInviteDialogFeature;
import com.facebook.share.model.AppInviteContent;
import java.util.ArrayList;
import java.util.List;

public class AppInviteDialog extends FacebookDialogBase
{

    private static final int DEFAULT_REQUEST_CODE;
    private static final String TAG = "AppInviteDialog";

    public AppInviteDialog(Activity activity)
    {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public AppInviteDialog(Fragment fragment)
    {
        super(fragment, DEFAULT_REQUEST_CODE);
    }

    public static boolean canShow()
    {
        return canShowNativeDialog() || canShowWebFallback();
    }

    private static boolean canShowNativeDialog()
    {
        return android.os.Build.VERSION.SDK_INT >= 14 && DialogPresenter.canPresentNativeDialogWithFeature(getFeature());
    }

    private static boolean canShowWebFallback()
    {
        return android.os.Build.VERSION.SDK_INT >= 14 && DialogPresenter.canPresentWebFallbackDialogWithFeature(getFeature());
    }

    private static Bundle createParameters(AppInviteContent appinvitecontent)
    {
        Bundle bundle = new Bundle();
        bundle.putString("app_link_url", appinvitecontent.getApplinkUrl());
        bundle.putString("preview_image_url", appinvitecontent.getPreviewImageUrl());
        return bundle;
    }

    private static DialogFeature getFeature()
    {
        return AppInviteDialogFeature.APP_INVITES_DIALOG;
    }

    public static void show(Activity activity, AppInviteContent appinvitecontent)
    {
        (new AppInviteDialog(activity)).show(appinvitecontent);
    }

    public static void show(Fragment fragment, AppInviteContent appinvitecontent)
    {
        (new AppInviteDialog(fragment)).show(appinvitecontent);
    }

    protected AppCall createBaseAppCall()
    {
        return new AppCall(getRequestCode());
    }

    protected List getOrderedModeHandlers()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new NativeHandler(null));
        arraylist.add(new WebFallbackHandler(null));
        return arraylist;
    }

    protected void registerCallbackImpl(CallbackManagerImpl callbackmanagerimpl, FacebookCallback facebookcallback)
    {
        if (facebookcallback == null)
        {
            facebookcallback = null;
        } else
        {
            facebookcallback = new _cls1(facebookcallback, facebookcallback);
        }
        facebookcallback = new _cls2(facebookcallback);
        callbackmanagerimpl.registerCallback(getRequestCode(), facebookcallback);
    }

    static 
    {
        DEFAULT_REQUEST_CODE = com.facebook.internal.CallbackManagerImpl.RequestCodeOffset.AppInvite.toRequestCode();
    }





    /* member class not found */
    class NativeHandler {}


    /* member class not found */
    class WebFallbackHandler {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
