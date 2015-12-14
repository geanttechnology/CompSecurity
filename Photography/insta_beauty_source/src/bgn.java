// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.CGBlendMode;
import com.wantu.piprender.renderengine.filters.BlendMode;

public class bgn
{

    public static BlendMode a(CGBlendMode cgblendmode)
    {
        BlendMode blendmode = BlendMode.NORMAL;
        switch (bgo.a[cgblendmode.ordinal()])
        {
        default:
            return blendmode;

        case 1: // '\001'
            return BlendMode.NORMAL;

        case 2: // '\002'
            return BlendMode.MULTIPLY;

        case 3: // '\003'
            return BlendMode.SCREEN;

        case 4: // '\004'
            return BlendMode.OVERLAY;

        case 5: // '\005'
            return BlendMode.DARKEN;

        case 6: // '\006'
            return BlendMode.LIGHTEN;

        case 7: // '\007'
            return BlendMode.COLORDODGE;

        case 8: // '\b'
            return BlendMode.COLORBURN;

        case 9: // '\t'
            return BlendMode.SOFTLIGHT;

        case 10: // '\n'
            return BlendMode.DIFFERENCE;

        case 11: // '\013'
            return BlendMode.EXCLUSION;

        case 12: // '\f'
            return BlendMode.HUE;

        case 13: // '\r'
            return BlendMode.SATURATION;

        case 14: // '\016'
            return BlendMode.COLOR;

        case 15: // '\017'
            return BlendMode.LUMINOSITY;

        case 16: // '\020'
            return BlendMode.HARDLIGHT;
        }
    }
}
