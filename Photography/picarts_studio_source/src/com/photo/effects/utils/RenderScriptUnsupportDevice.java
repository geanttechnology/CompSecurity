// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.effects.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.util.a;
import java.util.ArrayList;

public final class RenderScriptUnsupportDevice extends Enum
{

    private static final RenderScriptUnsupportDevice $VALUES[];
    public static final RenderScriptUnsupportDevice ACER_A1_840FHD;
    public static final RenderScriptUnsupportDevice ASUS_K00E;
    public static final RenderScriptUnsupportDevice ASUS_K00Y;
    public static final RenderScriptUnsupportDevice ASUS_K00Z;
    public static final RenderScriptUnsupportDevice ASUS_K011;
    public static final RenderScriptUnsupportDevice ASUS_K011_1;
    public static final RenderScriptUnsupportDevice ASUS_K012;
    public static final RenderScriptUnsupportDevice ASUS_K012_2;
    public static final RenderScriptUnsupportDevice ASUS_K015;
    public static final RenderScriptUnsupportDevice ASUS_K017;
    public static final RenderScriptUnsupportDevice ASUS_K019_1;
    public static final RenderScriptUnsupportDevice ASUS_K019_3;
    public static final RenderScriptUnsupportDevice ASUS_K01A;
    public static final RenderScriptUnsupportDevice ASUS_K01H;
    public static final RenderScriptUnsupportDevice ASUS_K900;
    public static final RenderScriptUnsupportDevice ASUS_ME302C;
    public static final RenderScriptUnsupportDevice ASUS_T00E;
    public static final RenderScriptUnsupportDevice ASUS_T00F;
    public static final RenderScriptUnsupportDevice ASUS_T00G;
    public static final RenderScriptUnsupportDevice ASUS_T00I;
    public static final RenderScriptUnsupportDevice ASUS_T00J;
    public static final RenderScriptUnsupportDevice ASUS_T00P;
    public static final RenderScriptUnsupportDevice ASUS_T00Q;
    public static final RenderScriptUnsupportDevice ASUS_Z002;
    public static final RenderScriptUnsupportDevice DELL_THUNDERBIRD;
    public static final RenderScriptUnsupportDevice DELL_VENUE8;
    public static final RenderScriptUnsupportDevice DELL_YELLOWTAIL;
    public static final RenderScriptUnsupportDevice GENYMOTION_LG_OPTIMUS_L3;
    public static final RenderScriptUnsupportDevice INTEL_MOFD_V0;
    public static final RenderScriptUnsupportDevice LG_OPTIMUS_L3;
    public static final RenderScriptUnsupportDevice LG_OPTIMUS_L3_1;
    public static final RenderScriptUnsupportDevice LG_OPTIMUS_L3_425;
    public static final RenderScriptUnsupportDevice LG_OPTIMUS_L3_430;
    public static final RenderScriptUnsupportDevice LG_OPTIMUS_LG_L3;
    public static final RenderScriptUnsupportDevice LG_OPTIMUS_LG_L3_425;
    public static final RenderScriptUnsupportDevice LG_OPTIMUS_LG_L3_430;
    public static final RenderScriptUnsupportDevice TESCO;
    public static final RenderScriptUnsupportDevice UNKNOWN;
    public static final RenderScriptUnsupportDevice currentDevice = getCurrentDevice();
    private final String manufacturer;
    private final String model;

    private RenderScriptUnsupportDevice(String s, int i, String s1, String s2)
    {
        super(s, i);
        manufacturer = s1;
        model = s2;
    }

    private static RenderScriptUnsupportDevice getCurrentDevice()
    {
        RenderScriptUnsupportDevice arenderscriptunsupportdevice[];
        int i;
        int j;
        arenderscriptunsupportdevice = values();
        j = arenderscriptunsupportdevice.length;
        i = 0;
_L7:
        RenderScriptUnsupportDevice renderscriptunsupportdevice;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        renderscriptunsupportdevice = arenderscriptunsupportdevice[i];
        if (renderscriptunsupportdevice.manufacturer == null && renderscriptunsupportdevice.model == null) goto _L2; else goto _L1
_L1:
        if (renderscriptunsupportdevice.manufacturer == null || renderscriptunsupportdevice.model == null) goto _L4; else goto _L3
_L3:
        if (!Build.MANUFACTURER.toLowerCase().contains(renderscriptunsupportdevice.manufacturer) || !Build.MODEL.toLowerCase().equalsIgnoreCase(renderscriptunsupportdevice.model)) goto _L2; else goto _L5
_L5:
        return renderscriptunsupportdevice;
_L4:
        if (renderscriptunsupportdevice.model == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (Build.MODEL.toLowerCase().equalsIgnoreCase(renderscriptunsupportdevice.model)) goto _L5; else goto _L2
_L2:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        if (renderscriptunsupportdevice.manufacturer == null || !Build.MANUFACTURER.toLowerCase().contains(renderscriptunsupportdevice.manufacturer)) goto _L2; else goto _L8
_L8:
        return renderscriptunsupportdevice;
        return UNKNOWN;
    }

    public static boolean setupAndGetRenderScriptSupport(Context context)
    {
label0:
        {
            context = new a(context);
            boolean flag = ((a) (context)).a.getSharedPreferences(((a) (context)).b, 0).getBoolean("useRenderScript", true);
            boolean flag1 = flag;
            if (!flag)
            {
                break label0;
            }
            if (currentDevice == UNKNOWN)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (flag)
            {
                if (!skipRenderscript())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag1 = flag;
                if (flag)
                {
                    break label0;
                }
                flag1 = flag;
            }
            context = ((a) (context)).a.getSharedPreferences(((a) (context)).b, 0).edit();
            context.putBoolean("useRenderScript", false);
            context.commit();
        }
        return flag1;
    }

    private static boolean skipRenderscript()
    {
        ArrayList arraylist;
        boolean flag;
        boolean flag1;
        flag1 = false;
        arraylist = SocialinV3.getInstance().getAppProps().getData().skipRenderscriptDevices;
        flag = flag1;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L9:
        flag = flag1;
        if (i >= arraylist.size()) goto _L2; else goto _L3
_L3:
        Object obj = (com.socialin.android.apiv3.model.AppProps.SkipRenderscriptForDevice)arraylist.get(i);
        String s;
        if (((com.socialin.android.apiv3.model.AppProps.SkipRenderscriptForDevice) (obj)).manufacturer != null && !((com.socialin.android.apiv3.model.AppProps.SkipRenderscriptForDevice) (obj)).manufacturer.equalsIgnoreCase(""))
        {
            s = ((com.socialin.android.apiv3.model.AppProps.SkipRenderscriptForDevice) (obj)).manufacturer.toLowerCase();
        } else
        {
            s = null;
        }
        if (((com.socialin.android.apiv3.model.AppProps.SkipRenderscriptForDevice) (obj)).model != null && !((com.socialin.android.apiv3.model.AppProps.SkipRenderscriptForDevice) (obj)).model.equalsIgnoreCase(""))
        {
            obj = ((com.socialin.android.apiv3.model.AppProps.SkipRenderscriptForDevice) (obj)).model.toLowerCase();
        } else
        {
            obj = null;
        }
        if (s == null || obj == null) goto _L5; else goto _L4
_L4:
        if (!Build.MANUFACTURER.toLowerCase().contains(s) || !((String) (obj)).equalsIgnoreCase("all") && !Build.MODEL.toLowerCase().equalsIgnoreCase(((String) (obj)))) goto _L7; else goto _L6
_L6:
        flag = true;
_L2:
        return flag;
_L5:
        if (s != null)
        {
            if (Build.MANUFACTURER.toLowerCase().contains(s))
            {
                return true;
            }
        } else
        if (obj != null && Build.MODEL.toLowerCase().equalsIgnoreCase(((String) (obj))))
        {
            return true;
        }
_L7:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static RenderScriptUnsupportDevice valueOf(String s)
    {
        return (RenderScriptUnsupportDevice)Enum.valueOf(com/photo/effects/utils/RenderScriptUnsupportDevice, s);
    }

    public static RenderScriptUnsupportDevice[] values()
    {
        return (RenderScriptUnsupportDevice[])$VALUES.clone();
    }

    static 
    {
        ASUS_T00F = new RenderScriptUnsupportDevice("ASUS_T00F", 0, "asus", "asus_t00f");
        ASUS_T00Q = new RenderScriptUnsupportDevice("ASUS_T00Q", 1, "asus", "asus_t00q");
        ASUS_T00I = new RenderScriptUnsupportDevice("ASUS_T00I", 2, "asus", "asus_t00i");
        ASUS_Z002 = new RenderScriptUnsupportDevice("ASUS_Z002", 3, "asus", "asus_z002");
        ASUS_T00G = new RenderScriptUnsupportDevice("ASUS_T00G", 4, "asus", "asus_t00g");
        ASUS_T00J = new RenderScriptUnsupportDevice("ASUS_T00J", 5, "asus", "asus_t00j");
        ASUS_T00P = new RenderScriptUnsupportDevice("ASUS_T00P", 6, "asus", "asus_t00p");
        ASUS_K019_3 = new RenderScriptUnsupportDevice("ASUS_K019_3", 7, "asus", "k019_3");
        ASUS_K019_1 = new RenderScriptUnsupportDevice("ASUS_K019_1", 8, "asus", "k019_1");
        ASUS_K00Z = new RenderScriptUnsupportDevice("ASUS_K00Z", 9, "asus", "k00z");
        ASUS_K00Y = new RenderScriptUnsupportDevice("ASUS_K00Y", 10, "asus", "k00y");
        ASUS_K012 = new RenderScriptUnsupportDevice("ASUS_K012", 11, "asus", "k012");
        ASUS_K01H = new RenderScriptUnsupportDevice("ASUS_K01H", 12, "asus", "k01h");
        ASUS_K011 = new RenderScriptUnsupportDevice("ASUS_K011", 13, "asus", "k011");
        ASUS_K011_1 = new RenderScriptUnsupportDevice("ASUS_K011_1", 14, "asus", "k011_1");
        ASUS_K015 = new RenderScriptUnsupportDevice("ASUS_K015", 15, "asus", "k015");
        ASUS_K00E = new RenderScriptUnsupportDevice("ASUS_K00E", 16, "asus", "k00e");
        ASUS_ME302C = new RenderScriptUnsupportDevice("ASUS_ME302C", 17, "asus", "me302c");
        ASUS_K017 = new RenderScriptUnsupportDevice("ASUS_K017", 18, "asus", "k017");
        DELL_YELLOWTAIL = new RenderScriptUnsupportDevice("DELL_YELLOWTAIL", 19, "dell", "yellowtail");
        DELL_THUNDERBIRD = new RenderScriptUnsupportDevice("DELL_THUNDERBIRD", 20, "dell", "thunderbird");
        ASUS_K01A = new RenderScriptUnsupportDevice("ASUS_K01A", 21, "asus", "k01a");
        ASUS_T00E = new RenderScriptUnsupportDevice("ASUS_T00E", 22, "asus", "asus_t00e");
        ASUS_K900 = new RenderScriptUnsupportDevice("ASUS_K900", 23, "asus", "k900");
        ASUS_K012_2 = new RenderScriptUnsupportDevice("ASUS_K012_2", 24, "asus", "k012_2");
        DELL_VENUE8 = new RenderScriptUnsupportDevice("DELL_VENUE8", 25, "dell", "venue8");
        ACER_A1_840FHD = new RenderScriptUnsupportDevice("ACER_A1_840FHD", 26, "acer", "a1-840fhd");
        TESCO = new RenderScriptUnsupportDevice("TESCO", 27, "tesco", null);
        GENYMOTION_LG_OPTIMUS_L3 = new RenderScriptUnsupportDevice("GENYMOTION_LG_OPTIMUS_L3", 28, "genymotion", "LG Optimus L3 II - 4.1.1 - API 16 - 240x320");
        LG_OPTIMUS_L3 = new RenderScriptUnsupportDevice("LG_OPTIMUS_L3", 29, "lg", "lg-e400");
        LG_OPTIMUS_L3_1 = new RenderScriptUnsupportDevice("LG_OPTIMUS_L3_1", 30, "lg", "e400");
        LG_OPTIMUS_L3_425 = new RenderScriptUnsupportDevice("LG_OPTIMUS_L3_425", 31, "lg", "e425");
        LG_OPTIMUS_L3_430 = new RenderScriptUnsupportDevice("LG_OPTIMUS_L3_430", 32, "lg", "e430");
        LG_OPTIMUS_LG_L3 = new RenderScriptUnsupportDevice("LG_OPTIMUS_LG_L3", 33, "lg", "lg-e400");
        LG_OPTIMUS_LG_L3_425 = new RenderScriptUnsupportDevice("LG_OPTIMUS_LG_L3_425", 34, "lg", "lg-e425");
        LG_OPTIMUS_LG_L3_430 = new RenderScriptUnsupportDevice("LG_OPTIMUS_LG_L3_430", 35, "lg", "lg-e430");
        INTEL_MOFD_V0 = new RenderScriptUnsupportDevice("INTEL_MOFD_V0", 36, "intel", "mofd_v0");
        UNKNOWN = new RenderScriptUnsupportDevice("UNKNOWN", 37, null, null);
        $VALUES = (new RenderScriptUnsupportDevice[] {
            ASUS_T00F, ASUS_T00Q, ASUS_T00I, ASUS_Z002, ASUS_T00G, ASUS_T00J, ASUS_T00P, ASUS_K019_3, ASUS_K019_1, ASUS_K00Z, 
            ASUS_K00Y, ASUS_K012, ASUS_K01H, ASUS_K011, ASUS_K011_1, ASUS_K015, ASUS_K00E, ASUS_ME302C, ASUS_K017, DELL_YELLOWTAIL, 
            DELL_THUNDERBIRD, ASUS_K01A, ASUS_T00E, ASUS_K900, ASUS_K012_2, DELL_VENUE8, ACER_A1_840FHD, TESCO, GENYMOTION_LG_OPTIMUS_L3, LG_OPTIMUS_L3, 
            LG_OPTIMUS_L3_1, LG_OPTIMUS_L3_425, LG_OPTIMUS_L3_430, LG_OPTIMUS_LG_L3, LG_OPTIMUS_LG_L3_425, LG_OPTIMUS_LG_L3_430, INTEL_MOFD_V0, UNKNOWN
        });
    }
}
