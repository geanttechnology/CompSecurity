// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android.compat;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.playhaven.android.PlayHaven;

public class VendorCompat
{
    public static final class ID extends Enum
    {

        private static final ID $VALUES[];
        public static final ID com_playhaven_android_view_Exit;
        public static final ID com_playhaven_android_view_Exit_button;
        public static final ID com_playhaven_android_view_LoadingAnimation;
        public static final ID com_playhaven_android_view_Overlay;
        public static final ID playhaven_activity_view;
        public static final ID playhaven_dialog_view;

        public static ID valueOf(String s)
        {
            return (ID)Enum.valueOf(com/playhaven/android/compat/VendorCompat$ID, s);
        }

        public static ID[] values()
        {
            return (ID[])$VALUES.clone();
        }

        static 
        {
            playhaven_dialog_view = new ID("playhaven_dialog_view", 0);
            com_playhaven_android_view_Overlay = new ID("com_playhaven_android_view_Overlay", 1);
            com_playhaven_android_view_LoadingAnimation = new ID("com_playhaven_android_view_LoadingAnimation", 2);
            com_playhaven_android_view_Exit = new ID("com_playhaven_android_view_Exit", 3);
            com_playhaven_android_view_Exit_button = new ID("com_playhaven_android_view_Exit_button", 4);
            playhaven_activity_view = new ID("playhaven_activity_view", 5);
            $VALUES = (new ID[] {
                playhaven_dialog_view, com_playhaven_android_view_Overlay, com_playhaven_android_view_LoadingAnimation, com_playhaven_android_view_Exit, com_playhaven_android_view_Exit_button, playhaven_activity_view
            });
        }

        private ID(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class LAYOUT extends Enum
    {

        private static final LAYOUT $VALUES[];
        public static final LAYOUT playhaven_activity;
        public static final LAYOUT playhaven_dialog;
        public static final LAYOUT playhaven_exit;
        public static final LAYOUT playhaven_loadinganim;
        public static final LAYOUT playhaven_overlay;

        public static LAYOUT valueOf(String s)
        {
            return (LAYOUT)Enum.valueOf(com/playhaven/android/compat/VendorCompat$LAYOUT, s);
        }

        public static LAYOUT[] values()
        {
            return (LAYOUT[])$VALUES.clone();
        }

        static 
        {
            playhaven_activity = new LAYOUT("playhaven_activity", 0);
            playhaven_overlay = new LAYOUT("playhaven_overlay", 1);
            playhaven_loadinganim = new LAYOUT("playhaven_loadinganim", 2);
            playhaven_exit = new LAYOUT("playhaven_exit", 3);
            playhaven_dialog = new LAYOUT("playhaven_dialog", 4);
            $VALUES = (new LAYOUT[] {
                playhaven_activity, playhaven_overlay, playhaven_loadinganim, playhaven_exit, playhaven_dialog
            });
        }

        private LAYOUT(String s, int i)
        {
            super(s, i);
        }
    }


    private String vendorId;

    public VendorCompat(Context context, String s)
    {
        this(s);
    }

    public VendorCompat(String s)
    {
        if (s != null || s.length() > 0)
        {
            vendorId = s.replaceAll("[^A-Za-z0-9\\-\\.\\_\\~]*", "");
        }
        if (vendorId == null || vendorId.length() == 0)
        {
            PlayHaven.v("vendorId has no valid characters in it. Using default.", new Object[0]);
            vendorId = getClass().getSimpleName();
        }
        vendorId = vendorId.substring(0, Math.min(vendorId.length(), 42));
    }

    public int getAttrId(Context context, ATTR attr)
    {
    /* block-local class not found */
    class ATTR {}

    /* block-local class not found */
    class ResourceType {}

        switch (_cls1..SwitchMap.com.playhaven.android.compat.VendorCompat.ATTR[attr.ordinal()])
        {
        default:
            return getResourceId(context, ResourceType.attr, attr.name());

        case 1: // '\001'
            return com.playhaven.android.R.styleable.com_playhaven_android_view_PlayHavenView_cuDisplayOptions;

        case 2: // '\002'
            return com.playhaven.android.R.styleable.com_playhaven_android_view_PlayHavenView_placementTag;

        case 3: // '\003'
            return com.playhaven.android.R.styleable.com_playhaven_android_view_Badge_placementTag;

        case 4: // '\004'
            return com.playhaven.android.R.styleable.com_playhaven_android_view_Badge_badgeTextColor;
        }
    }

    public int getDrawableId(Context context, DRAWABLE drawable)
    {
    /* block-local class not found */
    class DRAWABLE {}

        return getResourceId(context, ResourceType.drawable, drawable.name());
    }

    public int getId(Context context, ID id)
    {
        switch (_cls1..SwitchMap.com.playhaven.android.compat.VendorCompat.ID[id.ordinal()])
        {
        default:
            return getResourceId(context, ResourceType.id, id.name());

        case 1: // '\001'
            return com.playhaven.android.R.id.com_playhaven_android_view_Exit;

        case 2: // '\002'
            return com.playhaven.android.R.id.com_playhaven_android_view_Exit_button;

        case 3: // '\003'
            return com.playhaven.android.R.id.com_playhaven_android_view_Overlay;

        case 4: // '\004'
            return com.playhaven.android.R.id.com_playhaven_android_view_LoadingAnimation;
        }
    }

    public int getLayoutId(Context context, LAYOUT layout)
    {
        return getResourceId(context, ResourceType.layout, layout.name());
    }

    public int getResourceId(Context context, ResourceType resourcetype, String s)
    {
        return context.getResources().getIdentifier(s, resourcetype.name(), context.getPackageName());
    }

    public String getVendorId()
    {
        return vendorId;
    }

    public TypedArray obtainStyledAttributes(Context context, AttributeSet attributeset, STYLEABLE styleable)
    {
    /* block-local class not found */
    class STYLEABLE {}

        switch (_cls1..SwitchMap.com.playhaven.android.compat.VendorCompat.STYLEABLE[styleable.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return context.obtainStyledAttributes(attributeset, com.playhaven.android.R.styleable.com_playhaven_android_view_Badge, 0, 0);

        case 2: // '\002'
            return context.obtainStyledAttributes(attributeset, com.playhaven.android.R.styleable.com_playhaven_android_view_PlayHavenView, 0, 0);
        }
    }

    /* member class not found */
    class _cls1 {}

}
