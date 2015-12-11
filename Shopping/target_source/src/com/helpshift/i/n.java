// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.net.ParseException;
import android.util.Log;
import java.text.DecimalFormat;
import java.util.Date;

// Referenced classes of package com.helpshift.i:
//            h

public final class n
{

    public static Float a(String s)
    {
        Float float1 = new Float(0.0F);
        String s1 = h.f.format((double)System.currentTimeMillis() / 1000D);
        float f;
        try
        {
            f = (float)((double)((new Date((long)Double.valueOf(Double.parseDouble(s) * 1000D).doubleValue())).getTime() / 1000L) - Double.parseDouble(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.d("HelpShiftDebug", "Could not parse the server date");
            return float1;
        }
        return Float.valueOf(f);
    }

    public static String a(Float float1)
    {
        String s = h.f.format((double)System.currentTimeMillis() / 1000D);
        if (float1.floatValue() != 0.0F)
        {
            double d = (double)System.currentTimeMillis() / 1000D;
            s = h.f.format(Double.valueOf(d).doubleValue() + (double)float1.floatValue());
        }
        return s;
    }
}
