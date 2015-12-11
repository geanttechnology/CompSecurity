// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPAccountManager

public static final class ScreenPosition.mValue
{
    public static final class ProgressBarState extends Enum
    {

        private static final ProgressBarState $VALUES[];
        public static final ProgressBarState OFF;
        public static final ProgressBarState PROGRESS_BAR;
        public static final ProgressBarState SPINNER_LARGE;
        public static final ProgressBarState SPINNER_MEDIUM;
        public static final ProgressBarState SPINNER_SMALL;
        private String mValue;

        public static ProgressBarState get(String s)
        {
            ProgressBarState aprogressbarstate[] = values();
            int j = aprogressbarstate.length;
            for (int i = 0; i < j; i++)
            {
                ProgressBarState progressbarstate = aprogressbarstate[i];
                if (progressbarstate.getValue().equals(s))
                {
                    return progressbarstate;
                }
            }

            MAPLog.formattedError(MAPAccountManager.access$000(), "Invalid ProgressBarState value: %s", new Object[] {
                s
            });
            return null;
        }

        public static ProgressBarState valueOf(String s)
        {
            return (ProgressBarState)Enum.valueOf(com/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState, s);
        }

        public static ProgressBarState[] values()
        {
            return (ProgressBarState[])$VALUES.clone();
        }

        public String getValue()
        {
            return mValue;
        }

        public String toString()
        {
            return getValue();
        }

        static 
        {
            OFF = new ProgressBarState("OFF", 0, "off");
            PROGRESS_BAR = new ProgressBarState("PROGRESS_BAR", 1, "progress_bar");
            SPINNER_SMALL = new ProgressBarState("SPINNER_SMALL", 2, "spinner_small");
            SPINNER_MEDIUM = new ProgressBarState("SPINNER_MEDIUM", 3, "spinner_medium");
            SPINNER_LARGE = new ProgressBarState("SPINNER_LARGE", 4, "spinner_large");
            $VALUES = (new ProgressBarState[] {
                OFF, PROGRESS_BAR, SPINNER_SMALL, SPINNER_MEDIUM, SPINNER_LARGE
            });
        }

        private ProgressBarState(String s, int i, String s1)
        {
            super(s, i);
            mValue = s1;
        }
    }

    public static final class ScreenPosition extends Enum
    {

        private static final ScreenPosition $VALUES[];
        public static final ScreenPosition BOTTOM_CENTER;
        public static final ScreenPosition BOTTOM_LEFT;
        public static final ScreenPosition BOTTOM_RIGHT;
        public static final ScreenPosition CENTER_CENTER;
        public static final ScreenPosition CENTER_LEFT;
        public static final ScreenPosition CENTER_RIGHT;
        public static final ScreenPosition TOP_CENTER;
        public static final ScreenPosition TOP_LEFT;
        public static final ScreenPosition TOP_RIGHT;
        private String mValue;

        public static ScreenPosition get(String s)
        {
            ScreenPosition ascreenposition[] = values();
            int j = ascreenposition.length;
            for (int i = 0; i < j; i++)
            {
                ScreenPosition screenposition = ascreenposition[i];
                if (screenposition.getValue().equals(s))
                {
                    return screenposition;
                }
            }

            MAPLog.formattedError(MAPAccountManager.access$000(), "Invalid ScreenPosition value: %s", new Object[] {
                s
            });
            return null;
        }

        public static ScreenPosition valueOf(String s)
        {
            return (ScreenPosition)Enum.valueOf(com/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition, s);
        }

        public static ScreenPosition[] values()
        {
            return (ScreenPosition[])$VALUES.clone();
        }

        public String getValue()
        {
            return mValue;
        }

        public String toString()
        {
            return getValue();
        }

        static 
        {
            TOP_LEFT = new ScreenPosition("TOP_LEFT", 0, "top_left");
            TOP_CENTER = new ScreenPosition("TOP_CENTER", 1, "top_center");
            TOP_RIGHT = new ScreenPosition("TOP_RIGHT", 2, "top_right");
            CENTER_LEFT = new ScreenPosition("CENTER_LEFT", 3, "center_left");
            CENTER_CENTER = new ScreenPosition("CENTER_CENTER", 4, "center_center");
            CENTER_RIGHT = new ScreenPosition("CENTER_RIGHT", 5, "center_right");
            BOTTOM_LEFT = new ScreenPosition("BOTTOM_LEFT", 6, "bottom_left");
            BOTTOM_CENTER = new ScreenPosition("BOTTOM_CENTER", 7, "bottom_center");
            BOTTOM_RIGHT = new ScreenPosition("BOTTOM_RIGHT", 8, "bottom_right");
            $VALUES = (new ScreenPosition[] {
                TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER_LEFT, CENTER_CENTER, CENTER_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
            });
        }

        private ScreenPosition(String s, int i, String s1)
        {
            super(s, i);
            mValue = s1;
        }
    }


    public static final String KEY_ABOVE_LOCKSCREEN = "AuthPortalActivityUIOptions.aboveLockScreen";
    public static final String KEY_AMAZON_SCREEN_MODES = "AuthPortalActivityUIOptions.amazonScreenModes";
    public static final String KEY_INVERT_SPINNER = "progressbar_invert_spinner";
    public static final String KEY_IS_FULLSCREEN = "AuthPortalActivityUIOptions.fullscreen";
    public static final String KEY_PROGRESSBAR_BACKGROUND_RESOURCE = "progressbar_background_resource";
    public static final String KEY_PROGRESSBAR_FADE = "progressbar_fade";
    public static final String KEY_PROGRESSBAR_POSITION = "progressbar_position";
    public static final String KEY_PROGRESSBAR_PRIMARY_COLOR = "progressbar_primary_color";
    public static final String KEY_PROGRESSBAR_RESOURCE = "progressbar_resource";
    public static final String KEY_PROGRESSBAR_SECONDARY_COLOR = "progressbar_secondary_color";
    public static final String KEY_PROGRESSBAR_STATE = "progressbar_state";
    public static final String KEY_PROGRESSBAR_STRETCH = "progressbar_stretch";
    public static final String KEY_REQUESTED_ORIENTATION = "AuthPortalActivityUIOptions.requestedOrientation";
    public static final String KEY_SPLASH_SCREEN_RESOURCE = "splashscreen_resource";
    public static final String KEY_SPLASH_SCREEN_SCALE_TYPE = "splashscreen_scale_type";
    public static final String KEY_SYSTEM_UI_VISIBILITY = "AuthPortalActivityUIOptions.systemUiVisibility";
    public static final String KEY_WINDOW_FLAGS = "AuthPortalActivityUIOptions.windowFlags";

    public ScreenPosition.mValue()
    {
    }
}
