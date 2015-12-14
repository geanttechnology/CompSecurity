// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.Context;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import java.io.File;

public abstract class FreeTimeCommon
{
    public static final class ProfileState extends Enum
    {

        private static final ProfileState $VALUES[];
        public static final ProfileState FREETIME;
        public static final ProfileState PARENT;
        public static final ProfileState TEENTIME;
        public static final ProfileState TWEENTIME;
        private final String maturity;

        public static ProfileState valueOf(String s)
        {
            return (ProfileState)Enum.valueOf(com/amazon/gallery/thor/app/FreeTimeCommon$ProfileState, s);
        }

        public static ProfileState[] values()
        {
            return (ProfileState[])$VALUES.clone();
        }

        public String getMaturity()
        {
            return maturity;
        }

        static 
        {
            FREETIME = new ProfileState("FREETIME", 0, "FREETIME");
            TWEENTIME = new ProfileState("TWEENTIME", 1, "TEENTIME");
            TEENTIME = new ProfileState("TEENTIME", 2, "TEENTIME");
            PARENT = new ProfileState("PARENT", 3, "ADULT");
            $VALUES = (new ProfileState[] {
                FREETIME, TWEENTIME, TEENTIME, PARENT
            });
        }

        private ProfileState(String s, int i, String s1)
        {
            super(s, i);
            maturity = s1;
        }
    }


    private static final String TAG = com/amazon/gallery/thor/app/FreeTimeCommon.getName();

    public FreeTimeCommon()
    {
    }

    public static String getChildPreferenceId(int i)
    {
        return (new StringBuilder()).append("ProfilePreferences").append(i).toString();
    }

    public static String getFreeTimeLocation()
    {
        return "/data/securedStorageLocation/com.amazon.camera/FreeTime";
    }

    public static File getFreeTimeRemovableStorageLocation(RemovableStorageManager removablestoragemanager)
    {
        removablestoragemanager = removablestoragemanager.getRemovableStorageRootDirectory();
        if (removablestoragemanager == null)
        {
            return null;
        } else
        {
            return new File(removablestoragemanager, "/DCIM/Camera/FreeTime");
        }
    }

    public static ProfileState getUserTheme(Context context)
    {
        if (BuildFlavors.isAosp())
        {
            return ProfileState.PARENT;
        }
        context = android.provider.Settings.Secure.getString(context.getContentResolver(), "SAFEMODE_EXPERIENCE");
        if ("TEEN".equals(context))
        {
            return ProfileState.TEENTIME;
        }
        if ("TWEEN".equals(context))
        {
            return ProfileState.TWEENTIME;
        }
        if ("KFT".equals(context))
        {
            return ProfileState.FREETIME;
        } else
        {
            return ProfileState.PARENT;
        }
    }

}
