// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            NewFeatureNotification, Keys, AutoUploadNotification

static final class k extends ShowDialogSyncTask
{

    final FragmentActivity val$activity;

    protected Dialog createDialog()
    {
        android.support.v7.app.tification._cls1 _lcls1 = new android.support.v7.app.>(val$activity);
        ComponentProfiler _tmp = NewFeatureNotification.access$002(new ComponentProfiler((Profiler)((BeanAwareActivity)val$activity).getApplicationBean(Keys.PROFILER), com/amazon/gallery/framework/kindle/AutoUploadNotification));
        View view = val$activity.getLayoutInflater().inflate(0x7f0300b1, null);
        _lcls1.ew(view);
        AlertDialog _tmp1 = NewFeatureNotification.access$102(_lcls1.e());
        NewFeatureNotification.access$100().setCancelable(false);
        NewFeatureNotification.access$100().setCanceledOnTouchOutside(false);
        view.findViewById(0x7f0c018f).setOnClickListener(new android.view.View.OnClickListener() {

            final NewFeatureNotification._cls1 this$0;

            public void onClick(View view1)
            {
                if (NewFeatureNotification.access$100().isShowing())
                {
                    NewFeatureNotification.access$100().dismiss();
                    ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveDialog();
                }
            }

            
            {
                this$0 = NewFeatureNotification._cls1.this;
                super();
            }
        });
        NewFeatureNotification.access$000().trackEvent(tricsEvent.NewFeatureDialogDisplayed);
        return NewFeatureNotification.access$100();
    }

    _cls1.this._cls0(Activity activity1, FragmentActivity fragmentactivity)
    {
        val$activity = fragmentactivity;
        super(activity1);
    }
}
