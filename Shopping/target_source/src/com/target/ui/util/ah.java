// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v4.f.a;
import android.text.SpannableString;
import android.util.AttributeSet;
import java.util.Map;

public class ah
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a ITALIC;
        public static final a LIGHT;
        public static final a LIGHT_ITALIC;
        public static final a MEDIUM;
        public static final a REGULAR;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/util/ah$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            ITALIC = new a("ITALIC", 0);
            LIGHT = new a("LIGHT", 1);
            LIGHT_ITALIC = new a("LIGHT_ITALIC", 2);
            MEDIUM = new a("MEDIUM", 3);
            REGULAR = new a("REGULAR", 4);
            $VALUES = (new a[] {
                ITALIC, LIGHT, LIGHT_ITALIC, MEDIUM, REGULAR
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String FILE_NAME_ITALIC = "fonts/HelveticaNeueforTarget-It.ttf";
    private static final String FILE_NAME_LIGHT = "fonts/HelveticaNeueforTarget-Lt.ttf";
    private static final String FILE_NAME_LIGHT_ITALIC = "fonts/HelveticaNeueforTarget-LtIt.ttf";
    private static final String FILE_NAME_MEDIUM = "fonts/HelveticaNeueforTarget-Md.ttf";
    private static final String FILE_NAME_REGULAR = "fonts/HelveticaNeueforTarget-Rm.ttf";
    private static final Map TYPEFACE_CACHE = new android.support.v4.f.a();

    public static Typeface a(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return a(context, a.REGULAR);
        }
        attributeset = context.obtainStyledAttributes(attributeset, com.target.ui.a.a.TargetFont, 0, 0);
        if (attributeset == null)
        {
            return a(context, a.REGULAR);
        }
        attributeset.getInteger(0, 4);
        JVM INSTR tableswitch 0 3: default 72
    //                   0 86
    //                   1 97
    //                   2 108
    //                   3 119;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        context = a(context, a.REGULAR);
_L7:
        attributeset.recycle();
        return context;
_L2:
        context = a(context, a.ITALIC);
        continue; /* Loop/switch isn't completed */
_L3:
        context = a(context, a.LIGHT);
        continue; /* Loop/switch isn't completed */
_L4:
        context = a(context, a.LIGHT_ITALIC);
        continue; /* Loop/switch isn't completed */
_L5:
        context = a(context, a.MEDIUM);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static Typeface a(Context context, a a1)
    {
        Typeface typeface = (Typeface)TYPEFACE_CACHE.get(a1);
        if (typeface != null)
        {
            return typeface;
        }
        context = context.getAssets();
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$util$TargetFontUtils$FontStyle[];

            static 
            {
                $SwitchMap$com$target$ui$util$TargetFontUtils$FontStyle = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$util$TargetFontUtils$FontStyle[a.ITALIC.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$util$TargetFontUtils$FontStyle[a.LIGHT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$util$TargetFontUtils$FontStyle[a.LIGHT_ITALIC.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$util$TargetFontUtils$FontStyle[a.MEDIUM.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$util$TargetFontUtils$FontStyle[a.REGULAR.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.ui.util.TargetFontUtils.FontStyle[a1.ordinal()];
        JVM INSTR tableswitch 1 4: default 64
    //                   1 84
    //                   2 94
    //                   3 104
    //                   4 114;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        context = Typeface.createFromAsset(context, "fonts/HelveticaNeueforTarget-Rm.ttf");
_L7:
        TYPEFACE_CACHE.put(a1, context);
        return context;
_L2:
        context = Typeface.createFromAsset(context, "fonts/HelveticaNeueforTarget-It.ttf");
        continue; /* Loop/switch isn't completed */
_L3:
        context = Typeface.createFromAsset(context, "fonts/HelveticaNeueforTarget-Lt.ttf");
        continue; /* Loop/switch isn't completed */
_L4:
        context = Typeface.createFromAsset(context, "fonts/HelveticaNeueforTarget-LtIt.ttf");
        continue; /* Loop/switch isn't completed */
_L5:
        context = Typeface.createFromAsset(context, "fonts/HelveticaNeueforTarget-Md.ttf");
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static SpannableString a(Context context, a a1, String s)
    {
        s = new SpannableString(s);
        s.setSpan(new com.target.ui.span.a(a(context, a1)), 0, s.length(), 33);
        return s;
    }

}
