// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public final class CvAnimationType extends Enum
{

    private static final CvAnimationType $VALUES[];
    public static final CvAnimationType BOTTOM_TOP;
    public static final CvAnimationType DEFAULT;
    public static final CvAnimationType FADE;
    public static final CvAnimationType LEFT_RIGHT;
    public static final CvAnimationType NONE;
    public static final CvAnimationType RIGHT_LEFT;
    public static final CvAnimationType TOP_BOTTOM;

    private CvAnimationType(String s, int i)
    {
        super(s, i);
    }

    private Animation create(boolean flag)
    {
        float f;
        float f2;
        if (this == DEFAULT)
        {
            return FADE.create(flag);
        }
        f = 0.0F;
        f2 = 1.0F;
        static class _cls1
        {

            static final int $SwitchMap$com$apprupt$sdk$CvAnimationType[];

            static 
            {
                $SwitchMap$com$apprupt$sdk$CvAnimationType = new int[CvAnimationType.values().length];
                try
                {
                    $SwitchMap$com$apprupt$sdk$CvAnimationType[CvAnimationType.LEFT_RIGHT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$apprupt$sdk$CvAnimationType[CvAnimationType.RIGHT_LEFT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$apprupt$sdk$CvAnimationType[CvAnimationType.TOP_BOTTOM.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$apprupt$sdk$CvAnimationType[CvAnimationType.BOTTOM_TOP.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$apprupt$sdk$CvAnimationType[CvAnimationType.NONE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$apprupt$sdk$CvAnimationType[CvAnimationType.FADE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.apprupt.sdk.CvAnimationType[ordinal()];
        JVM INSTR tableswitch 5 6: default 52
    //                   5 146
    //                   6 146;
           goto _L1 _L2 _L2
_L1:
        float f1;
        float f3;
        f = 0.0F;
        f1 = 0.0F;
        f2 = 0.0F;
        f3 = 0.0F;
        if (!flag) goto _L4; else goto _L3
_L3:
        _cls1..SwitchMap.com.apprupt.sdk.CvAnimationType[ordinal()];
        JVM INSTR tableswitch 1 4: default 104
    //                   1 236
    //                   2 241
    //                   3 247
    //                   4 253;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        Object obj;
        obj = new TranslateAnimation(2, f, 2, f1, 2, f2, 2, f3);
        ((Animation) (obj)).setDuration(500L);
_L11:
        ((Animation) (obj)).setInterpolator(new AccelerateInterpolator());
        return ((Animation) (obj));
_L2:
        long l;
        if (flag)
        {
            f = 1.0F;
            if (this == NONE)
            {
                f1 = 0.9F;
            } else
            {
                f1 = 0.0F;
            }
        } else
        {
            f1 = f2;
            if (this == NONE)
            {
                f = 0.9F;
                f1 = f2;
            }
        }
        obj = new AlphaAnimation(f, f1);
        l = 800L;
        if (this != NONE)
        {
            break; /* Loop/switch isn't completed */
        }
        l = 10L;
_L13:
        ((Animation) (obj)).setDuration(l);
        if (true) goto _L11; else goto _L10
_L10:
        if (!flag) goto _L13; else goto _L12
_L12:
        l = 500L;
          goto _L13
_L6:
        f1 = 1.0F;
        continue; /* Loop/switch isn't completed */
_L7:
        f1 = -1F;
        continue; /* Loop/switch isn't completed */
_L8:
        f3 = 1.0F;
        continue; /* Loop/switch isn't completed */
_L9:
        f3 = -1F;
        if (true) goto _L5; else goto _L4
_L4:
        switch (_cls1..SwitchMap.com.apprupt.sdk.CvAnimationType[ordinal()])
        {
        case 1: // '\001'
            f = -1F;
            break;

        case 2: // '\002'
            f = 1.0F;
            break;

        case 3: // '\003'
            f2 = -1F;
            break;

        case 4: // '\004'
            f2 = 1.0F;
            break;
        }
        if (true) goto _L5; else goto _L14
_L14:
    }

    public static CvAnimationType valueOf(String s)
    {
        return (CvAnimationType)Enum.valueOf(com/apprupt/sdk/CvAnimationType, s);
    }

    public static CvAnimationType[] values()
    {
        return (CvAnimationType[])$VALUES.clone();
    }

    Animation in()
    {
        return create(false);
    }

    Animation out()
    {
        return create(true);
    }

    static 
    {
        NONE = new CvAnimationType("NONE", 0);
        DEFAULT = new CvAnimationType("DEFAULT", 1);
        FADE = new CvAnimationType("FADE", 2);
        LEFT_RIGHT = new CvAnimationType("LEFT_RIGHT", 3);
        RIGHT_LEFT = new CvAnimationType("RIGHT_LEFT", 4);
        TOP_BOTTOM = new CvAnimationType("TOP_BOTTOM", 5);
        BOTTOM_TOP = new CvAnimationType("BOTTOM_TOP", 6);
        $VALUES = (new CvAnimationType[] {
            NONE, DEFAULT, FADE, LEFT_RIGHT, RIGHT_LEFT, TOP_BOTTOM, BOTTOM_TOP
        });
    }
}
