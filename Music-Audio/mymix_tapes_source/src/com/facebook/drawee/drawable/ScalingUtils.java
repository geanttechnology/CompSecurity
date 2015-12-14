// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

public class ScalingUtils
{
    public static final class ScaleType extends Enum
    {

        private static final ScaleType $VALUES[];
        public static final ScaleType CENTER;
        public static final ScaleType CENTER_CROP;
        public static final ScaleType CENTER_INSIDE;
        public static final ScaleType FIT_CENTER;
        public static final ScaleType FIT_END;
        public static final ScaleType FIT_START;
        public static final ScaleType FIT_XY;
        public static final ScaleType FOCUS_CROP;

        public static ScaleType fromString(String s)
        {
            if (s.equals("none"))
            {
                return null;
            }
            if (s.equals("fitXY"))
            {
                return FIT_XY;
            }
            if (s.equals("fitStart"))
            {
                return FIT_START;
            }
            if (s.equals("fitCenter"))
            {
                return FIT_CENTER;
            }
            if (s.equals("fitEnd"))
            {
                return FIT_END;
            }
            if (s.equals("center"))
            {
                return CENTER;
            }
            if (s.equals("centerInside"))
            {
                return CENTER_INSIDE;
            }
            if (s.equals("centerCrop"))
            {
                return CENTER_CROP;
            }
            if (s.equals("focusCrop"))
            {
                return FOCUS_CROP;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unrecognized scale type: ").append(s).append("; use a value defined in the ScalingUtils.fromString method").toString());
            }
        }

        public static ScaleType valueOf(String s)
        {
            return (ScaleType)Enum.valueOf(com/facebook/drawee/drawable/ScalingUtils$ScaleType, s);
        }

        public static ScaleType[] values()
        {
            return (ScaleType[])$VALUES.clone();
        }

        static 
        {
            FIT_XY = new ScaleType("FIT_XY", 0);
            FIT_START = new ScaleType("FIT_START", 1);
            FIT_CENTER = new ScaleType("FIT_CENTER", 2);
            FIT_END = new ScaleType("FIT_END", 3);
            CENTER = new ScaleType("CENTER", 4);
            CENTER_INSIDE = new ScaleType("CENTER_INSIDE", 5);
            CENTER_CROP = new ScaleType("CENTER_CROP", 6);
            FOCUS_CROP = new ScaleType("FOCUS_CROP", 7);
            $VALUES = (new ScaleType[] {
                FIT_XY, FIT_START, FIT_CENTER, FIT_END, CENTER, CENTER_INSIDE, CENTER_CROP, FOCUS_CROP
            });
        }

        private ScaleType(String s, int i)
        {
            super(s, i);
        }
    }


    public ScalingUtils()
    {
    }

    public static Matrix getTransform(Matrix matrix, Rect rect, int i, int j, float f, float f1, ScaleType scaletype)
    {
        int k = rect.width();
        int l = rect.height();
        float f2 = (float)k / (float)i;
        float f3 = (float)l / (float)j;
        static class _cls1
        {

            static final int $SwitchMap$com$facebook$drawee$drawable$ScalingUtils$ScaleType[];

            static 
            {
                $SwitchMap$com$facebook$drawee$drawable$ScalingUtils$ScaleType = new int[ScaleType.values().length];
                try
                {
                    $SwitchMap$com$facebook$drawee$drawable$ScalingUtils$ScaleType[ScaleType.FIT_XY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$facebook$drawee$drawable$ScalingUtils$ScaleType[ScaleType.FIT_START.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$facebook$drawee$drawable$ScalingUtils$ScaleType[ScaleType.FIT_CENTER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$facebook$drawee$drawable$ScalingUtils$ScaleType[ScaleType.FIT_END.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$facebook$drawee$drawable$ScalingUtils$ScaleType[ScaleType.CENTER.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$facebook$drawee$drawable$ScalingUtils$ScaleType[ScaleType.CENTER_INSIDE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$facebook$drawee$drawable$ScalingUtils$ScaleType[ScaleType.CENTER_CROP.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$facebook$drawee$drawable$ScalingUtils$ScaleType[ScaleType.FOCUS_CROP.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.facebook.drawee.drawable.ScalingUtils.ScaleType[scaletype.ordinal()])
        {
        default:
            throw new UnsupportedOperationException((new StringBuilder()).append("Unsupported scale type: ").append(scaletype).toString());

        case 1: // '\001'
            f = rect.left;
            f1 = rect.top;
            matrix.setScale(f2, f3);
            matrix.postTranslate((int)(0.5F + f), (int)(0.5F + f1));
            return matrix;

        case 2: // '\002'
            f = Math.min(f2, f3);
            f1 = rect.left;
            f2 = rect.top;
            matrix.setScale(f, f);
            matrix.postTranslate((int)(0.5F + f1), (int)(0.5F + f2));
            return matrix;

        case 3: // '\003'
            f = Math.min(f2, f3);
            f1 = rect.left;
            f2 = k;
            f3 = i;
            float f5 = rect.top;
            float f9 = l;
            float f12 = j;
            matrix.setScale(f, f);
            matrix.postTranslate((int)(0.5F + (f1 + (f2 - f3 * f) * 0.5F)), (int)(0.5F + (f5 + (f9 - f12 * f) * 0.5F)));
            return matrix;

        case 4: // '\004'
            f = Math.min(f2, f3);
            f1 = rect.left;
            f2 = k;
            f3 = i;
            float f6 = rect.top;
            float f10 = l;
            float f13 = j;
            matrix.setScale(f, f);
            matrix.postTranslate((int)(0.5F + (f1 + (f2 - f3 * f))), (int)(0.5F + (f6 + (f10 - f13 * f))));
            return matrix;

        case 5: // '\005'
            f = rect.left;
            f1 = k - i;
            f2 = rect.top;
            f3 = l - j;
            matrix.setTranslate((int)(0.5F + (f + f1 * 0.5F)), (int)(0.5F + (f2 + f3 * 0.5F)));
            return matrix;

        case 6: // '\006'
            f = Math.min(Math.min(f2, f3), 1.0F);
            f1 = rect.left;
            f2 = k;
            f3 = i;
            float f7 = rect.top;
            float f11 = l;
            float f14 = j;
            matrix.setScale(f, f);
            matrix.postTranslate((int)(0.5F + (f1 + (f2 - f3 * f) * 0.5F)), (int)(0.5F + (f7 + (f11 - f14 * f) * 0.5F)));
            return matrix;

        case 7: // '\007'
            if (f3 > f2)
            {
                f2 = f3;
                f = (float)rect.left + ((float)k - (float)i * f2) * 0.5F;
                f1 = rect.top;
            } else
            {
                f = rect.left;
                f1 = (float)rect.top + ((float)l - (float)j * f2) * 0.5F;
            }
            matrix.setScale(f2, f2);
            matrix.postTranslate((int)(0.5F + f), (int)(0.5F + f1));
            return matrix;

        case 8: // '\b'
            break;
        }
        if (f3 > f2)
        {
            f1 = k;
            f2 = i;
            f1 = (float)rect.left + Math.max(Math.min(f1 * 0.5F - f2 * f3 * f, 0.0F), (float)k - (float)i * f3);
            f2 = rect.top;
            f = f3;
        } else
        {
            f = f2;
            f2 = rect.left;
            float f4 = l;
            float f8 = j;
            f4 = (float)rect.top + Math.max(Math.min(f4 * 0.5F - f8 * f * f1, 0.0F), (float)l - (float)j * f);
            f1 = f2;
            f2 = f4;
        }
        matrix.setScale(f, f);
        matrix.postTranslate((int)(0.5F + f1), (int)(0.5F + f2));
        return matrix;
    }
}
