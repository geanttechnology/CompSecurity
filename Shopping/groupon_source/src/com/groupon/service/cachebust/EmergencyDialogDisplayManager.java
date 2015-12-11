// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.cachebust;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.groupon.activity.Carousel;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class EmergencyDialogDisplayManager
{

    private Activity activity;
    private Application application;

    public EmergencyDialogDisplayManager()
    {
    }

    private void setCleanCacheBustFlagInPrefs(String s)
    {
        ((SharedPreferences)RoboGuice.getInjector(application).getInstance(Key.get(com/groupon/util/ArraySharedPreferences, Names.named("cacheBust")))).edit().putString("X-Groupon-Cache-Token", s).putBoolean("clearCache", true).commit();
    }

    public void onCacheBustHeaderReceived(String s)
    {
        setCleanCacheBustFlagInPrefs(s);
        if (activity == null || activity.isFinishing())
        {
            return;
        } else
        {
            activity.runOnUiThread(new Runnable() {

                final EmergencyDialogDisplayManager this$0;

                public void run()
                {
                    com.groupon.util.GrouponAlertDialog.Builder builder = new com.groupon.util.GrouponAlertDialog.Builder(activity);
                    builder.setCancelable(false).setMessage(0x7f0800bb).setNegativeButton(0x7f0804fe, new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            ((Logger)RoboGuice.getInjector(activity).getInstance(com/groupon/tracking/mobile/sdk/Logger)).logGeneralEvent("CacheBusting", "restart", activity.getLocalClassName(), 0, Logger.NULL_NST_FIELD);
                            if (activity instanceof Carousel)
                            {
                                System.exit(0);
                                return;
                            } else
                            {
                                dialoginterface = new Intent(activity.getApplicationContext(), com/groupon/activity/Carousel);
                                dialoginterface.setFlags(0x4000000);
                                dialoginterface.putExtra("EXIT", true);
                                activity.startActivity(dialoginterface);
                                return;
                            }
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    builder.create().show();
                }

            
            {
                this$0 = EmergencyDialogDisplayManager.this;
                super();
            }
            });
            return;
        }
    }

    public void setCurrentActivity(Activity activity1)
    {
        activity = activity1;
    }

}
