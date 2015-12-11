// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.IBinder;
import android.os.SystemClock;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.analytics.FloaterGoogleAnalyticsService;
import com.bitstrips.imoji.ui.LoginActivity;
import com.crashlytics.android.Crashlytics;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.bitstrips.imoji.services:
//            PackageService

public class FloaterService extends Service
{
    private class CheckForegroundProcessTask extends TimerTask
    {

        private boolean hasSendEvent;
        final FloaterService this$0;

        private void sendFloaterInviewEvent(boolean flag, String s)
        {
            if (flag && !hasSendEvent)
            {
                floaterAnalyticsService.sendEvent(Category.FLOATER, Action.INVIEW, s);
                hasSendEvent = true;
            } else
            if (!flag)
            {
                hasSendEvent = false;
                return;
            }
        }

        public void run()
        {
            String s = getWhitelistedForegroundProcess();
            boolean flag;
            if (s != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            sendFloaterInviewEvent(flag, s);
            floaterView.post(flag. new Runnable() {

                final CheckForegroundProcessTask this$1;
                final boolean val$whitelistedAppInForeground;

                public void run()
                {
                    if (whitelistedAppInForeground)
                    {
                        floaterView.setVisibility(0);
                        return;
                    } else
                    {
                        floaterView.setVisibility(4);
                        return;
                    }
                }

            
            {
                this$1 = final_checkforegroundprocesstask;
                whitelistedAppInForeground = Z.this;
                super();
            }
            });
        }

        private CheckForegroundProcessTask()
        {
            this$0 = FloaterService.this;
            super();
            hasSendEvent = false;
        }

    }

    private class FloaterClickListener
        implements android.view.View.OnClickListener
    {

        final FloaterService this$0;

        public void onClick(View view)
        {
            view = getWhitelistedForegroundProcess();
            if (view != null)
            {
                Intent intent = new Intent(getBaseContext(), com/bitstrips/imoji/ui/LoginActivity);
                intent.addFlags(0x10000000);
                intent.addFlags(32768);
                intent.addFlags(0x40000000);
                if (processCheckTimer != null)
                {
                    intent.putExtra("targetProcess", view);
                }
                analytics.sendEvent(Category.FLOATER, Action.CLICK, view);
                startActivity(intent);
            }
        }

        private FloaterClickListener()
        {
            this$0 = FloaterService.this;
            super();
        }

    }

    private class FloaterTouchListener
        implements android.view.View.OnTouchListener
    {

        private static final int MOVE_THRESHOLD = 10;
        private int counter;
        private float initialTouchX;
        private float initialTouchY;
        private int initialX;
        private int initialY;
        private boolean moved;
        private final android.view.WindowManager.LayoutParams params;
        final FloaterService this$0;

        private void handleDown(MotionEvent motionevent)
        {
            counter = 0;
            initialX = params.x;
            initialY = params.y;
            initialTouchX = motionevent.getRawX();
            initialTouchY = motionevent.getRawY();
        }

        private void handleMove(MotionEvent motionevent)
        {
            counter = counter + 1;
            params.x = initialX + (int)(motionevent.getRawX() - initialTouchX);
            params.y = initialY + (int)(motionevent.getRawY() - initialTouchY);
            windowManager.updateViewLayout(floaterView, params);
        }

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            switch (motionevent.getAction())
            {
            default:
                return false;

            case 0: // '\0'
                moved = false;
                handleDown(motionevent);
                return false;

            case 1: // '\001'
                if (!moved)
                {
                    view.performClick();
                }
                return moved;

            case 2: // '\002'
                handleMove(motionevent);
                break;
            }
            boolean flag;
            if (counter > 10)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            moved = flag;
            return false;
        }

        public FloaterTouchListener(android.view.WindowManager.LayoutParams layoutparams)
        {
            this$0 = FloaterService.this;
            super();
            moved = false;
            params = layoutparams;
        }
    }


    private static final int PROCESS_CHECK_INTERVAL = 1000;
    public static final String TARGET_PROCESS_KEY = "targetProcess";
    AnalyticsService analytics;
    FloaterGoogleAnalyticsService floaterAnalyticsService;
    private View floaterView;
    PackageService packageService;
    Picasso picasso;
    private Timer processCheckTimer;
    private Intent startIntent;
    private WindowManager windowManager;

    public FloaterService()
    {
    }

    private void createFloater(android.view.WindowManager.LayoutParams layoutparams)
    {
        floaterView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030036, null, true);
        try
        {
            windowManager.addView(floaterView, layoutparams);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (android.view.WindowManager.LayoutParams layoutparams)
        {
            Crashlytics.log("Could not add floater to the window. Crash avoided");
        }
    }

    private String getAppNameForLollipopWithBlackMagic(List list)
    {
        Object obj = null;
        Field field;
        Iterator iterator;
        try
        {
            field = android/app/ActivityManager$RunningAppProcessInfo.getDeclaredField("processState");
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
            return null;
        }
        iterator = list.iterator();
        do
        {
            list = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            list = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
            if (((android.app.ActivityManager.RunningAppProcessInfo) (list)).importance != 100 || ((android.app.ActivityManager.RunningAppProcessInfo) (list)).importanceReasonCode != 0)
            {
                continue;
            }
            Integer integer;
            try
            {
                integer = Integer.valueOf(field.getInt(list));
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                list.printStackTrace();
                return null;
            }
            if (integer == null || integer.intValue() != 2)
            {
                continue;
            }
            list = ((android.app.ActivityManager.RunningAppProcessInfo) (list)).processName;
            break;
        } while (true);
        return list;
    }

    private int getCenterX()
    {
        return getDisplaySize().x / 2 - (int)getResources().getDimension(0x7f0a00a5) / 2;
    }

    private Point getDisplaySize()
    {
        Point point = new Point();
        Display display = windowManager.getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            getSize(point, display);
            return point;
        } else
        {
            getSizeCompat(point, display);
            return point;
        }
    }

    private android.view.WindowManager.LayoutParams getLayoutParams()
    {
        android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams(-2, -2, 2002, 8, -3);
        layoutparams.gravity = 51;
        layoutparams.x = getCenterX();
        layoutparams.y = 0;
        return layoutparams;
    }

    private String getRunningTask()
    {
        Object obj = (ActivityManager)getSystemService("activity");
        if (android.os.Build.VERSION.SDK_INT <= 20) goto _L2; else goto _L1
_L1:
        obj = ((ActivityManager) (obj)).getRunningAppProcesses();
        if (obj != null && !((List) (obj)).isEmpty() && ((List) (obj)).get(0) != null) goto _L4; else goto _L3
_L3:
        return null;
_L4:
        return getAppNameForLollipopWithBlackMagic(((List) (obj)));
_L2:
        obj = ((ActivityManager) (obj)).getRunningTasks(1);
        if (obj != null && !((List) (obj)).isEmpty() && ((List) (obj)).get(0) != null)
        {
            return ((android.app.ActivityManager.RunningTaskInfo)((List) (obj)).get(0)).topActivity.getPackageName();
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private void getSize(Point point, Display display)
    {
        display.getSize(point);
    }

    private void getSizeCompat(Point point, Display display)
    {
        point.x = display.getWidth();
        point.y = display.getHeight();
    }

    private String getWhitelistedForegroundProcess()
    {
        List list = Arrays.asList(getResources().getStringArray(0x7f070000));
        String s1 = getRunningTask();
        String s;
        if (s1 == null)
        {
            s = null;
        } else
        {
            if (s1.equals("com.facebook.orca") && packageService.isAppInstalled("com.bitstrips.bitmoji.messenger"))
            {
                return null;
            }
            s = s1;
            if (!list.contains(s1))
            {
                return null;
            }
        }
        return s;
    }

    private void restartSelf()
    {
        Object obj = getBaseContext();
        if (obj != null && startIntent != null)
        {
            obj = PendingIntent.getService(((android.content.Context) (obj)), 0, startIntent, 0x40000000);
            ((AlarmManager)getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + 1000L, ((PendingIntent) (obj)));
        }
    }

    public IBinder onBind(Intent intent)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate()
    {
        super.onCreate();
        Fabric.with(this, new Kit[] {
            new Crashlytics()
        });
        ((InjectorApplication)getApplication()).inject(this);
        windowManager = (WindowManager)getSystemService("window");
        android.view.WindowManager.LayoutParams layoutparams = getLayoutParams();
        createFloater(layoutparams);
        floaterView.setVisibility(4);
        floaterView.setOnTouchListener(new FloaterTouchListener(layoutparams));
        floaterView.setOnClickListener(new FloaterClickListener());
        processCheckTimer = new Timer();
        processCheckTimer.schedule(new CheckForegroundProcessTask(), 0L, 1000L);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (floaterView != null)
        {
            windowManager.removeView(floaterView);
        }
        processCheckTimer.cancel();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        startIntent = intent;
        if (intent != null)
        {
            intent = intent.getData();
            Target target = (Target)floaterView.findViewById(0x7f0b00bc);
            picasso.load(intent).resizeDimen(0x7f0a00a3, 0x7f0a00a3).noFade().into(target);
        }
        return 0;
    }

    public void onTaskRemoved(Intent intent)
    {
        super.onTaskRemoved(intent);
        stopSelf();
        restartSelf();
    }




}
