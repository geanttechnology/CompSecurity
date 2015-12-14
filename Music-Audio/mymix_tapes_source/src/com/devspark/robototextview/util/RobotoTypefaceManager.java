// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.devspark.robototextview.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;

public class RobotoTypefaceManager
{
    public class FontFamily
    {

        public static final int ROBOTO = 0;
        public static final int ROBOTO_CONDENSED = 1;
        public static final int ROBOTO_SLAB = 2;
        final RobotoTypefaceManager this$0;

        public FontFamily()
        {
            this$0 = RobotoTypefaceManager.this;
            super();
        }
    }

    public class TextStyle
    {

        public static final int ITALIC = 1;
        public static final int NORMAL = 0;
        final RobotoTypefaceManager this$0;

        public TextStyle()
        {
            this$0 = RobotoTypefaceManager.this;
            super();
        }
    }

    public class TextWeight
    {

        public static final int BOLD = 4;
        public static final int LIGHT = 2;
        public static final int MEDIUM = 3;
        public static final int NORMAL = 0;
        public static final int THIN = 1;
        public static final int ULTRA_BOLD = 5;
        final RobotoTypefaceManager this$0;

        public TextWeight()
        {
            this$0 = RobotoTypefaceManager.this;
            super();
        }
    }

    public class Typeface
    {

        public static final int ROBOTO_BLACK = 10;
        public static final int ROBOTO_BLACK_ITALIC = 11;
        public static final int ROBOTO_BOLD = 8;
        public static final int ROBOTO_BOLD_ITALIC = 9;
        public static final int ROBOTO_CONDENSED_BOLD = 16;
        public static final int ROBOTO_CONDENSED_BOLD_ITALIC = 17;
        public static final int ROBOTO_CONDENSED_ITALIC = 15;
        public static final int ROBOTO_CONDENSED_LIGHT = 12;
        public static final int ROBOTO_CONDENSED_LIGHT_ITALIC = 13;
        public static final int ROBOTO_CONDENSED_REGULAR = 14;
        public static final int ROBOTO_ITALIC = 5;
        public static final int ROBOTO_LIGHT = 2;
        public static final int ROBOTO_LIGHT_ITALIC = 3;
        public static final int ROBOTO_MEDIUM = 6;
        public static final int ROBOTO_MEDIUM_ITALIC = 7;
        public static final int ROBOTO_REGULAR = 4;
        public static final int ROBOTO_SLAB_BOLD = 21;
        public static final int ROBOTO_SLAB_LIGHT = 19;
        public static final int ROBOTO_SLAB_REGULAR = 20;
        public static final int ROBOTO_SLAB_THIN = 18;
        public static final int ROBOTO_THIN = 0;
        public static final int ROBOTO_THIN_ITALIC = 1;
        final RobotoTypefaceManager this$0;

        public Typeface()
        {
            this$0 = RobotoTypefaceManager.this;
            super();
        }
    }


    private static final SparseArray mTypefaces = new SparseArray(22);

    public RobotoTypefaceManager()
    {
    }

    private static android.graphics.Typeface createTypeface(Context context, int i)
        throws IllegalArgumentException
    {
        i;
        JVM INSTR tableswitch 0 21: default 104
    //                   0 131
    //                   1 143
    //                   2 149
    //                   3 155
    //                   4 161
    //                   5 167
    //                   6 173
    //                   7 179
    //                   8 185
    //                   9 191
    //                   10 197
    //                   11 203
    //                   12 209
    //                   13 215
    //                   14 221
    //                   15 227
    //                   16 233
    //                   17 239
    //                   18 245
    //                   19 251
    //                   20 257
    //                   21 263;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown `typeface` attribute value ").append(i).toString());
_L2:
        String s = "fonts/Roboto-Thin.ttf";
_L25:
        return android.graphics.Typeface.createFromAsset(context.getAssets(), s);
_L3:
        s = "fonts/Roboto-ThinItalic.ttf";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "fonts/Roboto-Light.ttf";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "fonts/Roboto-LightItalic.ttf";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "fonts/Roboto-Regular.ttf";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "fonts/Roboto-Italic.ttf";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "fonts/Roboto-Medium.ttf";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "fonts/Roboto-MediumItalic.ttf";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "fonts/Roboto-Bold.ttf";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "fonts/Roboto-BoldItalic.ttf";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "fonts/Roboto-Black.ttf";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "fonts/Roboto-BlackItalic.ttf";
        continue; /* Loop/switch isn't completed */
_L14:
        s = "fonts/RobotoCondensed-Light.ttf";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "fonts/RobotoCondensed-LightItalic.ttf";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "fonts/RobotoCondensed-Regular.ttf";
        continue; /* Loop/switch isn't completed */
_L17:
        s = "fonts/RobotoCondensed-Italic.ttf";
        continue; /* Loop/switch isn't completed */
_L18:
        s = "fonts/RobotoCondensed-Bold.ttf";
        continue; /* Loop/switch isn't completed */
_L19:
        s = "fonts/RobotoCondensed-BoldItalic.ttf";
        continue; /* Loop/switch isn't completed */
_L20:
        s = "fonts/RobotoSlab-Thin.ttf";
        continue; /* Loop/switch isn't completed */
_L21:
        s = "fonts/RobotoSlab-Light.ttf";
        continue; /* Loop/switch isn't completed */
_L22:
        s = "fonts/RobotoSlab-Regular.ttf";
        continue; /* Loop/switch isn't completed */
_L23:
        s = "fonts/RobotoSlab-Bold.ttf";
        if (true) goto _L25; else goto _L24
_L24:
    }

    private static int getTypefaceValue(int i, int j, int k)
    {
        if (i == 0)
        {
            if (j == 0)
            {
                switch (k)
                {
                default:
                    throw new IllegalArgumentException((new StringBuilder()).append("`textStyle` attribute value ").append(k).append(" is not supported for this fontFamily ").append(i).append(" and textWeight ").append(j).toString());

                case 0: // '\0'
                    return 4;

                case 1: // '\001'
                    return 5;
                }
            }
            if (j == 1)
            {
                switch (k)
                {
                default:
                    throw new IllegalArgumentException((new StringBuilder()).append("`textStyle` attribute value ").append(k).append(" is not supported for this fontFamily ").append(i).append(" and textWeight ").append(j).toString());

                case 0: // '\0'
                    return 0;

                case 1: // '\001'
                    return 1;
                }
            }
            if (j == 2)
            {
                switch (k)
                {
                default:
                    throw new IllegalArgumentException((new StringBuilder()).append("`textStyle` attribute value ").append(k).append(" is not supported for this fontFamily ").append(i).append(" and textWeight ").append(j).toString());

                case 0: // '\0'
                    return 2;

                case 1: // '\001'
                    return 3;
                }
            }
            if (j == 3)
            {
                switch (k)
                {
                default:
                    throw new IllegalArgumentException((new StringBuilder()).append("`textStyle` attribute value ").append(k).append(" is not supported for this fontFamily ").append(i).append(" and textWeight ").append(j).toString());

                case 0: // '\0'
                    return 6;

                case 1: // '\001'
                    return 7;
                }
            }
            if (j == 4)
            {
                switch (k)
                {
                default:
                    throw new IllegalArgumentException((new StringBuilder()).append("`textStyle` attribute value ").append(k).append(" is not supported for this fontFamily ").append(i).append(" and textWeight ").append(j).toString());

                case 0: // '\0'
                    return 8;

                case 1: // '\001'
                    return 9;
                }
            }
            if (j == 5)
            {
                switch (k)
                {
                default:
                    throw new IllegalArgumentException((new StringBuilder()).append("`textStyle` attribute value ").append(k).append(" is not supported for this fontFamily ").append(i).append(" and textWeight ").append(j).toString());

                case 0: // '\0'
                    return 10;

                case 1: // '\001'
                    return 11;
                }
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("`textWeight` attribute value ").append(j).append(" is not supported for this font family ").append(i).toString());
            }
        }
        if (i == 1)
        {
            if (j == 0)
            {
                switch (k)
                {
                default:
                    throw new IllegalArgumentException((new StringBuilder()).append("`textStyle` attribute value ").append(k).append(" is not supported for this fontFamily ").append(i).append(" and textWeight ").append(j).toString());

                case 0: // '\0'
                    return 14;

                case 1: // '\001'
                    return 15;
                }
            }
            if (j == 2)
            {
                switch (k)
                {
                default:
                    throw new IllegalArgumentException((new StringBuilder()).append("`textStyle` attribute value ").append(k).append(" is not supported for this fontFamily ").append(i).append(" and textWeight ").append(j).toString());

                case 0: // '\0'
                    return 12;

                case 1: // '\001'
                    return 13;
                }
            }
            if (j == 4)
            {
                switch (k)
                {
                default:
                    throw new IllegalArgumentException((new StringBuilder()).append("`textStyle` attribute value ").append(k).append(" is not supported for this fontFamily ").append(i).append(" and textWeight ").append(j).toString());

                case 0: // '\0'
                    return 16;

                case 1: // '\001'
                    return 17;
                }
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("`textWeight` attribute value ").append(j).append(" is not supported for this font family ").append(i).toString());
            }
        }
        if (i == 2)
        {
            if (k != 0)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("`textStyle` attribute value ").append(k).append(" is not supported for this fontFamily ").append(i).toString());
            }
            if (j == 0)
            {
                return 20;
            }
            if (j == 1)
            {
                return 18;
            }
            if (j == 2)
            {
                return 19;
            }
            if (j == 4)
            {
                return 21;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("`textWeight` attribute value ").append(j).append(" is not supported for this font family ").append(i).toString());
            }
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown `fontFamily` attribute value ").append(i).toString());
        }
    }

    public static android.graphics.Typeface obtainTypeface(Context context, int i)
        throws IllegalArgumentException
    {
        android.graphics.Typeface typeface1 = (android.graphics.Typeface)mTypefaces.get(i);
        android.graphics.Typeface typeface = typeface1;
        if (typeface1 == null)
        {
            typeface = createTypeface(context, i);
            mTypefaces.put(i, typeface);
        }
        return typeface;
    }

    public static android.graphics.Typeface obtainTypeface(Context context, int i, int j, int k)
        throws IllegalArgumentException
    {
        return obtainTypeface(context, getTypefaceValue(i, j, k));
    }

}
