// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.effects.utils;

import android.os.Build;

public final class RenderScriptI32UnsuportedDevices extends Enum
{

    private static final RenderScriptI32UnsuportedDevices $VALUES[];
    public static final RenderScriptI32UnsuportedDevices GENYMOTION_LG_OPTIMUS_L3;
    public static final RenderScriptI32UnsuportedDevices LG_OPTIMUS_L3;
    public static final RenderScriptI32UnsuportedDevices SAMSUNG_GT_I9500;
    public static final RenderScriptI32UnsuportedDevices SAMSUNG_SM_N900;
    public static final RenderScriptI32UnsuportedDevices SAMSUNG_SM_N910C;
    public static final RenderScriptI32UnsuportedDevices UNKNOWN;
    public static final RenderScriptI32UnsuportedDevices currentDevice = getCurrentDevice();
    private final String manufacturer;
    private final String model;

    private RenderScriptI32UnsuportedDevices(String s, int i, String s1, String s2)
    {
        super(s, i);
        manufacturer = s1;
        model = s2;
    }

    public static boolean deviceSupportRenderScriptI32()
    {
        return getCurrentDevice() == UNKNOWN;
    }

    private static RenderScriptI32UnsuportedDevices getCurrentDevice()
    {
        RenderScriptI32UnsuportedDevices arenderscripti32unsuporteddevices[];
        int i;
        int j;
        arenderscripti32unsuporteddevices = values();
        j = arenderscripti32unsuporteddevices.length;
        i = 0;
_L7:
        RenderScriptI32UnsuportedDevices renderscripti32unsuporteddevices;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        renderscripti32unsuporteddevices = arenderscripti32unsuporteddevices[i];
        if (renderscripti32unsuporteddevices.manufacturer == null && renderscripti32unsuporteddevices.model == null) goto _L2; else goto _L1
_L1:
        if (renderscripti32unsuporteddevices.manufacturer == null || renderscripti32unsuporteddevices.model == null) goto _L4; else goto _L3
_L3:
        if (!Build.MANUFACTURER.toLowerCase().contains(renderscripti32unsuporteddevices.manufacturer) || !Build.MODEL.toLowerCase().equalsIgnoreCase(renderscripti32unsuporteddevices.model)) goto _L2; else goto _L5
_L5:
        return renderscripti32unsuporteddevices;
_L4:
        if (renderscripti32unsuporteddevices.model == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (Build.MODEL.toLowerCase().equalsIgnoreCase(renderscripti32unsuporteddevices.model)) goto _L5; else goto _L2
_L2:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        if (renderscripti32unsuporteddevices.manufacturer == null || !Build.MANUFACTURER.toLowerCase().contains(renderscripti32unsuporteddevices.manufacturer)) goto _L2; else goto _L8
_L8:
        return renderscripti32unsuporteddevices;
        return UNKNOWN;
    }

    public static RenderScriptI32UnsuportedDevices valueOf(String s)
    {
        return (RenderScriptI32UnsuportedDevices)Enum.valueOf(com/photo/effects/utils/RenderScriptI32UnsuportedDevices, s);
    }

    public static RenderScriptI32UnsuportedDevices[] values()
    {
        return (RenderScriptI32UnsuportedDevices[])$VALUES.clone();
    }

    static 
    {
        SAMSUNG_SM_N910C = new RenderScriptI32UnsuportedDevices("SAMSUNG_SM_N910C", 0, "samsung", "sm-n910c");
        SAMSUNG_GT_I9500 = new RenderScriptI32UnsuportedDevices("SAMSUNG_GT_I9500", 1, "samsung", "gt-i9500");
        SAMSUNG_SM_N900 = new RenderScriptI32UnsuportedDevices("SAMSUNG_SM_N900", 2, "samsung", "sm-n900");
        LG_OPTIMUS_L3 = new RenderScriptI32UnsuportedDevices("LG_OPTIMUS_L3", 3, "lg", "lg-e400");
        GENYMOTION_LG_OPTIMUS_L3 = new RenderScriptI32UnsuportedDevices("GENYMOTION_LG_OPTIMUS_L3", 4, "genymotion", "LG Optimus L3 II - 4.1.1 - API 16 - 240x320");
        UNKNOWN = new RenderScriptI32UnsuportedDevices("UNKNOWN", 5, null, null);
        $VALUES = (new RenderScriptI32UnsuportedDevices[] {
            SAMSUNG_SM_N910C, SAMSUNG_GT_I9500, SAMSUNG_SM_N900, LG_OPTIMUS_L3, GENYMOTION_LG_OPTIMUS_L3, UNKNOWN
        });
    }
}
