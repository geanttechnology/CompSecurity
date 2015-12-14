// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.dagger;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.framework.gallery.view.ViewNotificationManager;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;

public class ThorScreenModeManager
    implements ScreenModeManager
{

    private com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode screenMode;
    private ViewNotificationManager viewNotificationManager;

    public ThorScreenModeManager()
    {
    }

    private void addTranslucentFlags(Window window)
    {
        window.addFlags(0x8000000);
    }

    private void applyScreenMode(Window window, com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode screenmode)
    {
        if (!Api.isAtLeastJellyBean())
        {
            setFullScreenModePreJellyBean(screenmode, window);
        }
        window = window.getDecorView();
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode = new int[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN_OPAQUE_UI.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.FULL_SCREEN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.GRID_GEN5.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE_OPAQUE_UI.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_OPAQUE_UI.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode[screenmode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            window.setSystemUiVisibility(3846);
            return;

        case 3: // '\003'
            window.setSystemUiVisibility(1798);
            return;

        case 4: // '\004'
            DebugAssert.assertMsg("Should not be using gen5 in this method.");
            // fall through

        case 5: // '\005'
        case 6: // '\006'
            window.setSystemUiVisibility(1792);
            return;

        case 7: // '\007'
            window.setSystemUiVisibility(0);
            break;
        }
    }

    private void applyScreenModeGen5(Window window, com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode screenmode)
    {
        android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
        _cls1..SwitchMap.com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode[screenmode.ordinal()];
        JVM INSTR tableswitch 1 6: default 52
    //                   1 58
    //                   2 58
    //                   3 69
    //                   4 95
    //                   5 121
    //                   6 121;
           goto _L1 _L2 _L2 _L3 _L4 _L5 _L5
_L1:
        window.setAttributes(layoutparams);
        return;
_L2:
        layoutparams.systemUiVisibility = layoutparams.systemUiVisibility | 8;
_L3:
        layoutparams.flags = layoutparams.flags | 0x400;
        layoutparams.systemUiVisibility = layoutparams.systemUiVisibility | 0x30;
        continue; /* Loop/switch isn't completed */
_L4:
        layoutparams.flags = layoutparams.flags & 0xfffffbff;
        layoutparams.systemUiVisibility = layoutparams.systemUiVisibility & 0xffffffc7;
        continue; /* Loop/switch isn't completed */
_L5:
        layoutparams.flags = layoutparams.flags & 0xfffffbff;
        layoutparams.systemUiVisibility = layoutparams.systemUiVisibility & -9;
        layoutparams.systemUiVisibility = layoutparams.systemUiVisibility | 0x30;
        if (true) goto _L1; else goto _L6
_L6:
    }

    private void notifyScreenModeChange()
    {
        if (viewNotificationManager == null)
        {
            return;
        }
        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode[screenMode.ordinal()])
        {
        case 4: // '\004'
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            viewNotificationManager.notifyEnterFullScreen();
            return;

        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            viewNotificationManager.notifyExitFullScreen();
            break;
        }
    }

    private void removeTranslucentFlags(Window window)
    {
        window.clearFlags(0x8000000);
    }

    private void setFullScreenModePreJellyBean(com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode screenmode, Window window)
    {
        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode[screenmode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            window.addFlags(1024);
            return;

        case 4: // '\004'
            DebugAssert.assertMsg("Should not be using gen5 in this method.");
            // fall through

        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            window.clearFlags(1024);
            break;
        }
    }

    private void setTranslucentNavigationFlag(com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode screenmode, Window window)
    {
        if (!Api.isAtLeastKitkat())
        {
            return;
        }
        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode[screenmode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 3: // '\003'
        case 5: // '\005'
            addTranslucentFlags(window);
            return;

        case 2: // '\002'
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
            removeTranslucentFlags(window);
            break;
        }
    }

    public com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode getAlternateScreenMode()
    {
        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode[screenMode.ordinal()])
        {
        case 3: // '\003'
        case 4: // '\004'
        default:
            return screenMode;

        case 1: // '\001'
            return com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN_OPAQUE_UI;

        case 2: // '\002'
            return com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN;

        case 5: // '\005'
            return com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE_OPAQUE_UI;

        case 6: // '\006'
            return com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE;
        }
    }

    public com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode getScreenMode()
    {
        return screenMode;
    }

    public boolean hasOpaqueUI()
    {
        return screenMode == com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN_OPAQUE_UI || screenMode == com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE_OPAQUE_UI || screenMode == com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_OPAQUE_UI;
    }

    public boolean isFullScreen()
    {
        return screenMode == com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.FULL_SCREEN || screenMode == com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN || screenMode == com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN_OPAQUE_UI;
    }

    public boolean isNormalMode()
    {
        return screenMode == com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_OPAQUE_UI;
    }

    public void setNotificationManager(ViewNotificationManager viewnotificationmanager)
    {
        viewNotificationManager = viewnotificationmanager;
    }

    public void setScreenMode(com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode screenmode, Activity activity)
    {
        setScreenMode(screenmode, activity, true);
    }

    public void setScreenMode(com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode screenmode, Activity activity, boolean flag)
    {
        screenMode = screenmode;
        activity = activity.getWindow();
        if (!BuildFlavors.isGen5()) goto _L2; else goto _L1
_L1:
        applyScreenModeGen5(activity, screenmode);
_L4:
        if (flag)
        {
            notifyScreenModeChange();
        }
        setTranslucentNavigationFlag(screenmode, activity);
        return;
_L2:
        if (Api.isAtLeastJellyBean())
        {
            applyScreenMode(activity, screenmode);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean shouldResetMode()
    {
        return hasOpaqueUI() || screenMode == com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.GRID_GEN5;
    }
}
