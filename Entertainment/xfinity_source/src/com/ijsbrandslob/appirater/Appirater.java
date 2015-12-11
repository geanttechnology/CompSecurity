// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ijsbrandslob.appirater;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Appirater
{
    public static interface Configuration
    {

        public abstract int getDaysUntilPrompt();

        public abstract int getMillisBeforeReminding();

        public abstract int getSignificantEventsUntilPrompt();

        public abstract int getUsesUntilPrompt();
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/ijsbrandslob/appirater/Appirater);
    private AndroidDevice androidDevice;
    private Configuration config;
    private InternetConnection internetConnection;
    private final boolean isDebuggable;
    private Context mContext;
    private int mCurrentVersion;
    private boolean mDeclinedToRate;
    private Date mFirstUseDate;
    private boolean mRatedCurrentVersion;
    private Date mReminderRequestDate;
    private int mSignificantEventCount;
    private int mUseCount;
    private Dialog rateDialog;

    public Appirater(Context context, Configuration configuration, InternetConnection internetconnection, boolean flag, AndroidDevice androiddevice)
    {
        mContext = context;
        config = configuration;
        internetConnection = internetconnection;
        androidDevice = androiddevice;
        loadSettings();
        isDebuggable = flag;
    }

    private int getAppVersion()
    {
        int i;
        try
        {
            i = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            throw new RuntimeException("Everything we know is wrong", namenotfoundexception);
        }
        return i;
    }

    private void incrementAndRate(boolean flag, Activity activity)
    {
        incrementUseCount();
        if (flag && ratingConditionsHaveBeenMet() && internetConnection.isConnected())
        {
            showRatingAlert(activity);
        }
    }

    private void incrementSignificantEventAndRate(boolean flag, Activity activity)
    {
        incrementSignificantEventCount();
        if (flag && ratingConditionsHaveBeenMet() && internetConnection.isConnected())
        {
            showRatingAlert(activity);
        }
    }

    private void incrementSignificantEventCount()
    {
        int i = getAppVersion();
        if (mCurrentVersion == -1)
        {
            mCurrentVersion = i;
        }
        LOG.debug(String.format("APPIRATER Tracking version: %d", new Object[] {
            Integer.valueOf(mCurrentVersion)
        }));
        if (mCurrentVersion == i)
        {
            if (mFirstUseDate == null)
            {
                mFirstUseDate = new Date();
            }
            mSignificantEventCount = mSignificantEventCount + 1;
            LOG.debug(String.format("APPIRATER Significant event count: %d", new Object[] {
                Integer.valueOf(mSignificantEventCount)
            }));
        } else
        {
            mCurrentVersion = i;
            mFirstUseDate = null;
            mUseCount = 0;
            mSignificantEventCount = 1;
            mRatedCurrentVersion = false;
            mDeclinedToRate = false;
            mReminderRequestDate = null;
        }
        saveSettings();
    }

    private void incrementUseCount()
    {
        int i = getAppVersion();
        if (mCurrentVersion == -1)
        {
            mCurrentVersion = i;
        }
        LOG.debug(String.format("APPIRATER Tracking version: %d", new Object[] {
            Integer.valueOf(mCurrentVersion)
        }));
        if (mCurrentVersion == i)
        {
            if (mFirstUseDate == null)
            {
                mFirstUseDate = new Date();
            }
            mUseCount = mUseCount + 1;
            LOG.debug(String.format("APPIRATER Use count: %d", new Object[] {
                Integer.valueOf(mUseCount)
            }));
        } else
        {
            mCurrentVersion = i;
            mFirstUseDate = new Date();
            mUseCount = 1;
            mSignificantEventCount = 0;
            mRatedCurrentVersion = false;
            mDeclinedToRate = false;
            mReminderRequestDate = null;
        }
        saveSettings();
    }

    private void loadSettings()
    {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(mContext.getPackageName(), 0);
        if (sharedpreferences.contains("APPIRATER_FIRST_USE_DATE"))
        {
            long l = sharedpreferences.getLong("APPIRATER_FIRST_USE_DATE", -1L);
            if (-1L != l)
            {
                mFirstUseDate = new Date(l);
            }
            l = sharedpreferences.getLong("APPIRATER_REMINDER_REQUEST_DATE", -1L);
            if (-1L != l)
            {
                mReminderRequestDate = new Date(l);
            }
            mUseCount = sharedpreferences.getInt("APPIRATER_USE_COUNT", 0);
            mSignificantEventCount = sharedpreferences.getInt("APPIRATER_SIG_EVENT_COUNT", 0);
            mCurrentVersion = sharedpreferences.getInt("APPIRATER_CURRENT_VERSION", 0);
            mRatedCurrentVersion = sharedpreferences.getBoolean("APPIRATER_RATED_CURRENT_VERSION", false);
            mDeclinedToRate = sharedpreferences.getBoolean("APPIRATER_DECLINED_TO_RATE", false);
        }
    }

    private boolean ratingConditionsHaveBeenMet()
    {
        for (Date date = new Date(); date.getTime() - mFirstUseDate.getTime() < (long)(0x5265c00 * config.getDaysUntilPrompt()) || mUseCount < config.getUsesUntilPrompt() || mSignificantEventCount < config.getSignificantEventsUntilPrompt() || mDeclinedToRate || mRatedCurrentVersion || mReminderRequestDate != null && date.getTime() - mReminderRequestDate.getTime() < (long)config.getMillisBeforeReminding();)
        {
            return false;
        }

        return true;
    }

    private void saveSettings()
    {
        android.content.SharedPreferences.Editor editor = mContext.getSharedPreferences(mContext.getPackageName(), 0).edit();
        long l = -1L;
        if (mFirstUseDate != null)
        {
            l = mFirstUseDate.getTime();
        }
        editor.putLong("APPIRATER_FIRST_USE_DATE", l);
        l = -1L;
        if (mReminderRequestDate != null)
        {
            l = mReminderRequestDate.getTime();
        }
        editor.putLong("APPIRATER_REMINDER_REQUEST_DATE", l);
        editor.putInt("APPIRATER_USE_COUNT", mUseCount);
        editor.putInt("APPIRATER_SIG_EVENT_COUNT", mSignificantEventCount);
        editor.putInt("APPIRATER_CURRENT_VERSION", mCurrentVersion);
        editor.putBoolean("APPIRATER_RATED_CURRENT_VERSION", mRatedCurrentVersion);
        editor.putBoolean("APPIRATER_DECLINED_TO_RATE", mDeclinedToRate);
        editor.commit();
    }

    private void showRatingAlert(final Activity activity)
    {
        if (rateDialog == null || !rateDialog.isShowing())
        {
            rateDialog = new Dialog(activity);
            Object obj = mContext.getResources();
            Button button;
            Object obj1;
            final Dialog internalRateDialog;
            try
            {
                obj1 = mContext.getPackageManager().getApplicationLabel(mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), 0));
            }
            // Misplaced declaration of an exception variable
            catch (final Activity activity)
            {
                throw new RuntimeException("Everything we know is wrong", activity);
            }
            rateDialog.setTitle(String.format(((Resources) (obj)).getString(com.xfinity.playerlib.R.string.APPIRATER_MESSAGE_TITLE), new Object[] {
                obj1
            }));
            rateDialog.setContentView(com.xfinity.playerlib.R.layout.appirater);
            ((TextView)rateDialog.findViewById(com.xfinity.playerlib.R.id.appirater_message_area)).setText(String.format(((Resources) (obj)).getString(com.xfinity.playerlib.R.string.APPIRATER_MESSAGE), new Object[] {
                obj1
            }));
            button = (Button)rateDialog.findViewById(com.xfinity.playerlib.R.id.appirater_rate_button);
            button.setText(String.format(((Resources) (obj)).getString(com.xfinity.playerlib.R.string.APPIRATER_RATE_BUTTON), new Object[] {
                obj1
            }));
            obj = (Button)rateDialog.findViewById(com.xfinity.playerlib.R.id.appirater_rate_later_button);
            obj1 = (Button)rateDialog.findViewById(com.xfinity.playerlib.R.id.appirater_cancel_button);
            internalRateDialog = rateDialog;
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final Appirater this$0;
                final Activity val$activity;
                final Dialog val$internalRateDialog;

                public void onClick(View view)
                {
                    if (androidDevice.isKindleOrFromAmazonStore())
                    {
                        view = "amzn://apps/android?p=%s";
                    } else
                    {
                        view = "market://details?id=%s";
                    }
                    view = Uri.parse(String.format(view, new Object[] {
                        mContext.getPackageName()
                    }));
                    view = (new Intent("android.intent.action.VIEW")).setData(view);
                    activity.startActivity(view);
                    mRatedCurrentVersion = true;
                    saveSettings();
                    internalRateDialog.dismiss();
                }

            
            {
                this$0 = Appirater.this;
                activity = activity1;
                internalRateDialog = dialog;
                super();
            }
            });
            ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final Appirater this$0;
                final Dialog val$internalRateDialog;

                public void onClick(View view)
                {
                    if (isDebuggable)
                    {
                        mReminderRequestDate = new Date();
                    } else
                    {
                        view = Calendar.getInstance();
                        view.setTime(new Date());
                        view.add(5, 1);
                        mReminderRequestDate = view.getTime();
                    }
                    saveSettings();
                    internalRateDialog.dismiss();
                }

            
            {
                this$0 = Appirater.this;
                internalRateDialog = dialog;
                super();
            }
            });
            ((Button) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

                final Appirater this$0;
                final Dialog val$internalRateDialog;

                public void onClick(View view)
                {
                    mDeclinedToRate = true;
                    saveSettings();
                    internalRateDialog.dismiss();
                }

            
            {
                this$0 = Appirater.this;
                internalRateDialog = dialog;
                super();
            }
            });
            rateDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final Appirater this$0;

                public void onCancel(DialogInterface dialoginterface)
                {
                    mDeclinedToRate = true;
                    saveSettings();
                }

            
            {
                this$0 = Appirater.this;
                super();
            }
            });
            internalRateDialog.show();
        }
    }

    public void appEnteredForeground(boolean flag, Activity activity)
    {
        incrementAndRate(flag, activity);
    }

    public void dismiss()
    {
        if (rateDialog != null && rateDialog.isShowing())
        {
            rateDialog.dismiss();
        }
        rateDialog = null;
    }

    public void userDidSignificantEvent(boolean flag, Activity activity)
    {
        incrementSignificantEventAndRate(flag, activity);
    }





/*
    static boolean access$202(Appirater appirater, boolean flag)
    {
        appirater.mRatedCurrentVersion = flag;
        return flag;
    }

*/




/*
    static Date access$502(Appirater appirater, Date date)
    {
        appirater.mReminderRequestDate = date;
        return date;
    }

*/


/*
    static boolean access$602(Appirater appirater, boolean flag)
    {
        appirater.mDeclinedToRate = flag;
        return flag;
    }

*/
}
