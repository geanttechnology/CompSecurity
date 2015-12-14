// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.amazon;

import android.app.Activity;
import com.amazon.gallery.framework.gallery.view.ViewNotificationManager;

public interface ScreenModeManager
{
    public static final class ScreenMode extends Enum
    {

        private static final ScreenMode $VALUES[];
        public static final ScreenMode FULL_SCREEN;
        public static final ScreenMode GRID_GEN5;
        public static final ScreenMode NORMAL_OPAQUE_UI;
        public static final ScreenMode NORMAL_STABLE;
        public static final ScreenMode NORMAL_STABLE_OPAQUE_UI;
        public static final ScreenMode SUPER_FULL_SCREEN;
        public static final ScreenMode SUPER_FULL_SCREEN_OPAQUE_UI;

        public static ScreenMode valueOf(String s)
        {
            return (ScreenMode)Enum.valueOf(com/amazon/gallery/framework/kindle/amazon/ScreenModeManager$ScreenMode, s);
        }

        public static ScreenMode[] values()
        {
            return (ScreenMode[])$VALUES.clone();
        }

        static 
        {
            SUPER_FULL_SCREEN = new ScreenMode("SUPER_FULL_SCREEN", 0);
            SUPER_FULL_SCREEN_OPAQUE_UI = new ScreenMode("SUPER_FULL_SCREEN_OPAQUE_UI", 1);
            FULL_SCREEN = new ScreenMode("FULL_SCREEN", 2);
            NORMAL_STABLE = new ScreenMode("NORMAL_STABLE", 3);
            NORMAL_STABLE_OPAQUE_UI = new ScreenMode("NORMAL_STABLE_OPAQUE_UI", 4);
            NORMAL_OPAQUE_UI = new ScreenMode("NORMAL_OPAQUE_UI", 5);
            GRID_GEN5 = new ScreenMode("GRID_GEN5", 6);
            $VALUES = (new ScreenMode[] {
                SUPER_FULL_SCREEN, SUPER_FULL_SCREEN_OPAQUE_UI, FULL_SCREEN, NORMAL_STABLE, NORMAL_STABLE_OPAQUE_UI, NORMAL_OPAQUE_UI, GRID_GEN5
            });
        }

        private ScreenMode(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract ScreenMode getAlternateScreenMode();

    public abstract ScreenMode getScreenMode();

    public abstract boolean hasOpaqueUI();

    public abstract boolean isFullScreen();

    public abstract boolean isNormalMode();

    public abstract void setNotificationManager(ViewNotificationManager viewnotificationmanager);

    public abstract void setScreenMode(ScreenMode screenmode, Activity activity);

    public abstract void setScreenMode(ScreenMode screenmode, Activity activity, boolean flag);

    public abstract boolean shouldResetMode();
}
