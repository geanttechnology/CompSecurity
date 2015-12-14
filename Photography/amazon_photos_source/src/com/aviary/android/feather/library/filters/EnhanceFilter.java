// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.filters;

import android.graphics.Bitmap;
import com.aviary.android.feather.headless.filters.NativeFilter;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;
import java.util.Locale;
import org.json.JSONException;

public class EnhanceFilter extends NativeFilter
{
    public static final class Types extends Enum
    {

        private static final Types $VALUES[];
        public static final Types ColorFix;
        public static final Types HiDef;
        public static final Types Illuminate;

        public static Types valueOf(String s)
        {
            return (Types)Enum.valueOf(com/aviary/android/feather/library/filters/EnhanceFilter$Types, s);
        }

        public static Types[] values()
        {
            return (Types[])$VALUES.clone();
        }

        static 
        {
            HiDef = new Types("HiDef", 0);
            Illuminate = new Types("Illuminate", 1);
            ColorFix = new Types("ColorFix", 2);
            $VALUES = (new Types[] {
                HiDef, Illuminate, ColorFix
            });
        }

        private Types(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String ENHANCE_COLOR_FIX = "enhance_color_fix";
    public static final String ENHANCE_HIDEF = "enhance_hi_def";
    public static final String ENHANCE_ILLUMINATE = "enhance_illuminate";

    EnhanceFilter()
    {
        super(new String[] {
            "enhance"
        });
        setType(Types.HiDef);
    }

    public void executeInPlace(Bitmap bitmap)
        throws JSONException
    {
        throw new IllegalStateException("NotImplemented");
    }

    public void setType(Types types)
    {
        this;
        JVM INSTR monitorenter ;
        mActions.get(0).setValue("name", types.name().toLowerCase(Locale.US));
        this;
        JVM INSTR monitorexit ;
        return;
        types;
        this;
        JVM INSTR monitorexit ;
        throw types;
    }
}
