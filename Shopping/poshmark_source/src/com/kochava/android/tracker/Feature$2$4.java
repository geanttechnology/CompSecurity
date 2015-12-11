// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.kochava.android.tracker:
//            Feature, Global, KochavaDbAdapter

class this._cls1 extends TimerTask
{

    final h this$1;

    public void run()
    {
        flush();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/kochava/android/tracker/Feature$2

/* anonymous class */
    class Feature._cls2 extends Handler
    {

        final Feature this$0;

        public void handleMessage(Message message)
        {
            boolean flag;
            flag = message.getData().getBoolean("sendonstart");
            Feature.access$1(Feature.this, Feature.access$0(Feature.this));
            Feature.access$3(Feature.this, Feature.access$2(Feature.this));
            Feature.access$5(Feature.this, Feature.access$4(Feature.this));
            Feature.access$6(Feature.this, "Default");
            Feature.access$7(Feature.this, "N/A");
            Feature.access$8(Feature.this, "");
            PackageManager packagemanager = Feature.access$9(Feature.this).getApplicationContext().getPackageManager();
            message = packagemanager.getApplicationInfo(Feature.access$9(Feature.this).getPackageName(), 0);
_L2:
            Feature feature = Feature.this;
            if (message == null)
            {
                break MISSING_BLOCK_LABEL_921;
            }
            message = packagemanager.getApplicationLabel(message);
_L4:
            Feature.access$6(feature, (String)message);
            if (Global.DEBUG)
            {
                Log.i("KochavaTracker", (new StringBuilder("mAppName now: ")).append(Feature.access$10(Feature.this)).toString());
            }
_L3:
            try
            {
                Feature.access$7(Feature.this, (new StringBuilder(String.valueOf(Feature.access$9(Feature.this).getPackageManager().getPackageInfo(Feature.access$9(Feature.this).getPackageName(), 0).versionCode))).toString());
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", (new StringBuilder("mAppVersionCode now: ")).append(Feature.access$11(Feature.this)).toString());
                }
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                if (Global.DEBUGERROR)
                {
                    Log.e("KochavaTracker", (new StringBuilder("Error gathering app version code ")).append(message.toString()).toString());
                }
            }
            try
            {
                Feature.access$8(Feature.this, Feature.access$9(Feature.this).getPackageManager().getPackageInfo(Feature.access$9(Feature.this).getPackageName(), 0).versionName);
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", (new StringBuilder("mAppVersionName now: ")).append(Feature.access$12(Feature.this)).toString());
                }
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                if (Global.DEBUGERROR)
                {
                    Log.e("KochavaTracker", (new StringBuilder("Error gathering app version name ")).append(message.toString()).toString());
                }
            }
            try
            {
                message = (WindowManager)Feature.access$9(Feature.this).getSystemService("window");
                Feature.access$13(Feature.this, message.getDefaultDisplay().getHeight());
                Feature.access$14(Feature.this, message.getDefaultDisplay().getWidth());
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", (new StringBuilder("Height: ")).append(Feature.access$15(Feature.this)).append(" | Width: ").append(Feature.access$16(Feature.this)).toString());
                }
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                if (Global.DEBUGERROR)
                {
                    Log.e("KochavaTracker", (new StringBuilder("Error ")).append(message.toString()).toString());
                }
            }
            Feature.access$17(Feature.this, android.provider.Settings.Secure.getString(Feature.access$9(Feature.this).getContentResolver(), "android_id"));
            Feature.access$19(Feature.this, Feature.access$18(Feature.this));
            Feature.access$20(Feature.this, Feature.access$9(Feature.this).getSharedPreferences("initPrefs", 0));
            if (Feature.access$21(Feature.this).getString("initBool", "").equals(""))
            {
                Feature.access$21(Feature.this).edit().putString("initBool", "false").commit();
            }
            if (Feature.access$21(Feature.this).getString("kochavaappdata", null) != null)
            {
                message = Feature.access$22(Feature.this).getApplicationData(Feature.access$21(Feature.this).getString("kochavaappdata", null));
                String s = Feature.access$23(Feature.this);
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", (new StringBuilder("[KOCHAVA] Stored Data: ")).append(message).toString());
                    Log.e("KochavaTracker", (new StringBuilder("[KOCHAVA] Created Data: ")).append(s).toString());
                }
                android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                if (message == null)
                {
                    Feature.access$22(Feature.this).insertApplicationData(Feature.access$21(Feature.this).getString("kochavaappdata", null), s);
                    Feature.access$24(1);
                } else
                if (!message.equals(s))
                {
                    Feature.access$22(Feature.this).updateApplicationData(Feature.access$21(Feature.this).getString("kochavaappdata", null), s);
                } else
                {
                    if (Global.DEBUG)
                    {
                        Log.e("KochavaTracker", "Set start of life to false");
                    }
                    Feature.access$25(Feature.this, false);
                }
            } else
            {
                Feature.access$25(Feature.this, false);
            }
            Feature.access$22(Feature.this).cleanupEvents(System.currentTimeMillis() - 0x240c8400L);
            if (Feature.access$26(Feature.this) || !Feature.access$21(Feature.this).getString("initBool", "").equals("") && Feature.access$21(Feature.this).getString("initBool", "").equals("false"))
            {
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "Initial event has not yet been qued in the database, making initial call");
                }
                Feature.access$27(Feature.this, "initial", null);
            }
            Feature.access$28(Feature.this, new Timer());
            Feature.access$29(Feature.this).schedule(new Feature._cls2._cls1(), 0L, 60000L);
            Feature.access$30(Feature.this, new Timer());
            if (!flag)
            {
                Feature.access$31(Feature.this).schedule(new Feature._cls2._cls2(), 0x927c0L);
                return;
            } else
            {
                Feature.access$31(Feature.this).schedule(new Feature._cls2._cls3(), 2000L);
                Feature.access$33(Feature.this, new Timer());
                Feature.access$34(Feature.this).schedule(new Feature._cls2._cls4(), 4000L);
                return;
            }
            namenotfoundexception;
            s = null;
            message = s;
            if (!Global.DEBUGERROR) goto _L2; else goto _L1
_L1:
            Log.e("KochavaTracker", (new StringBuilder("Error gathering app name ")).append(namenotfoundexception.toString()).toString());
            message = s;
              goto _L2
            message;
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", (new StringBuilder("Error gathering app name ")).append(message.toString()).toString());
            }
              goto _L3
            message = "(unknown)";
              goto _L4
        }


            
            {
                this$0 = Feature.this;
                super();
            }

        // Unreferenced inner class com/kochava/android/tracker/Feature$2$1

/* anonymous class */
        class Feature._cls2._cls1 extends TimerTask
        {

            final Feature._cls2 this$1;

            public void run()
            {
                flush();
            }

                    
                    {
                        this$1 = Feature._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/kochava/android/tracker/Feature$2$2

/* anonymous class */
        class Feature._cls2._cls2 extends TimerTask
        {

            final Feature._cls2 this$1;

            public void run()
            {
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "Reached 10 min mark w/o sending initial, sending now.");
                }
                Feature.access$32(this$0, false);
            }

                    
                    {
                        this$1 = Feature._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/kochava/android/tracker/Feature$2$3

/* anonymous class */
        class Feature._cls2._cls3 extends TimerTask
        {

            final Feature._cls2 this$1;

            public void run()
            {
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "Scheduling timer to que initial event if needed.");
                }
                Feature.access$32(this$0, false);
            }

                    
                    {
                        this$1 = Feature._cls2.this;
                        super();
                    }
        }

    }

}
