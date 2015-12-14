// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumsMetricsHelper

public class AlbumsWelcomeLetterHelper
{
    public class ShowLetterDialogTask extends ShowDialogSyncTask
    {

        final AlbumsWelcomeLetterHelper this$0;

        public Dialog createDialog()
        {
            SharedPreferences sharedpreferences = mActivity.getSharedPreferences("galleryKindleSharedPrefs", 0);
            String s = (new StringBuilder()).append(System.getProperty("line.separator")).append(System.getProperty("line.separator")).toString();
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(mActivity.getString(0x7f0e0038)).append(s).append(mActivity.getString(0x7f0e0039)).append(s).append(mActivity.getString(0x7f0e003a)).append(s).append(mActivity.getString(0x7f0e003b));
            s = stringbuilder.toString();
            return (new DialogManager()).createDialog(mActivity, mActivity.getString(0x7f0e0091), null, s, sharedpreferences. new android.content.DialogInterface.OnClickListener() {

                final ShowLetterDialogTask this$1;
                final SharedPreferences val$sharedPrefs;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    sharedPrefs.edit().putBoolean("show_albums_welcome_letter", false).apply();
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = final_showletterdialogtask;
                sharedPrefs = SharedPreferences.this;
                super();
            }
            });
        }

        public ShowLetterDialogTask(Activity activity)
        {
            this$0 = AlbumsWelcomeLetterHelper.this;
            super(activity);
        }
    }


    private final ComponentProfiler profiler;

    public AlbumsWelcomeLetterHelper(Profiler profiler1)
    {
        profiler = new ComponentProfiler(profiler1, "AlbumsMetrics");
    }

    public boolean shouldShowLetter(Context context)
    {
        return context.getSharedPreferences("galleryKindleSharedPrefs", 0).getBoolean("show_albums_welcome_letter", true);
    }

    public void showLetter(Activity activity)
    {
        final SharedPreferences sharedPrefs = activity.getSharedPreferences("galleryKindleSharedPrefs", 0);
        (new ShowLetterDialogTask(activity)).useDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final AlbumsWelcomeLetterHelper this$0;
            final SharedPreferences val$sharedPrefs;

            public void onDismiss(DialogInterface dialoginterface)
            {
                dialoginterface = AlbumsMetricsHelper.MetricsEvent.PhotoAlbumsLetterClose;
                profiler.trackEvent(dialoginterface, AlbumsMetricsHelper.createMetricsExtra(dialoginterface.name(), null, null));
                sharedPrefs.edit().putBoolean("show_albums_welcome_letter", false).apply();
            }

            
            {
                this$0 = AlbumsWelcomeLetterHelper.this;
                sharedPrefs = sharedpreferences;
                super();
            }
        }).useCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final AlbumsWelcomeLetterHelper this$0;
            final SharedPreferences val$sharedPrefs;

            public void onCancel(DialogInterface dialoginterface)
            {
                sharedPrefs.edit().putBoolean("show_albums_welcome_letter", false).apply();
            }

            
            {
                this$0 = AlbumsWelcomeLetterHelper.this;
                sharedPrefs = sharedpreferences;
                super();
            }
        }).queue();
        activity = AlbumsMetricsHelper.MetricsEvent.PhotoAlbumsLetterView;
        profiler.trackEvent(activity, AlbumsMetricsHelper.createMetricsExtra(activity.name(), null, null));
    }

}
