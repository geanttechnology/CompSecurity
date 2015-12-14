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

class this._cls0
    implements android.view.eatureNotification._cls1._cls1
{

    final ssActiveDialog this$0;

    public void onClick(View view)
    {
        if (NewFeatureNotification.access$100().isShowing())
        {
            NewFeatureNotification.access$100().dismiss();
            ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveDialog();
        }
    }

    <init>()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/kindle/NewFeatureNotification$1

/* anonymous class */
    static final class NewFeatureNotification._cls1 extends ShowDialogSyncTask
    {

        final FragmentActivity val$activity;

        protected Dialog createDialog()
        {
            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(activity);
            ComponentProfiler _tmp = NewFeatureNotification.access$002(new ComponentProfiler((Profiler)((BeanAwareActivity)activity).getApplicationBean(Keys.PROFILER), com/amazon/gallery/framework/kindle/AutoUploadNotification));
            View view = activity.getLayoutInflater().inflate(0x7f0300b1, null);
            builder.setView(view);
            AlertDialog _tmp1 = NewFeatureNotification.access$102(builder.create());
            NewFeatureNotification.access$100().setCancelable(false);
            NewFeatureNotification.access$100().setCanceledOnTouchOutside(false);
            view.findViewById(0x7f0c018f).setOnClickListener(new NewFeatureNotification._cls1._cls1());
            NewFeatureNotification.access$000().trackEvent(NewFeatureNotification.MetricsEvent.NewFeatureDialogDisplayed);
            return NewFeatureNotification.access$100();
        }

            
            {
                activity = fragmentactivity;
                super(activity1);
            }
    }

}
