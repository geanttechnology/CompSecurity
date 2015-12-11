// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class m
    implements i
{

    public m()
    {
    }

    public void a(Context context, j j1)
    {
        String s;
        try
        {
            context = new BufferedReader(new FileReader("/proc/version"), 256);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        s = context.readLine();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        context.close();
        context = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(s);
        if (!context.matches())
        {
            return;
        }
        break MISSING_BLOCK_LABEL_62;
        j1;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        context.close();
        throw j1;
        if (context.groupCount() < 4) goto _L2; else goto _L1
_L1:
        s = context.group(1);
        if (s == null) goto _L4; else goto _L3
_L3:
        if (s.length() <= 50) goto _L4; else goto _L5
_L5:
        j1.a("KERV", s.substring(0, 50));
_L17:
        s = context.group(2);
        if (s == null) goto _L7; else goto _L6
_L6:
        if (s.length() <= 50) goto _L7; else goto _L8
_L8:
        j1.a("AKID", s.substring(0, 50));
_L14:
        s = context.group(3);
        if (s == null) goto _L10; else goto _L9
_L9:
        if (s.length() <= 50) goto _L10; else goto _L11
_L11:
        j1.a("AKBN", s.substring(0, 50));
_L15:
        context = context.group(4);
        if (context == null) goto _L13; else goto _L12
_L12:
        if (context.length() > 50)
        {
            j1.a("AKD", context.substring(0, 50));
            return;
        }
          goto _L13
_L4:
        j1.a("KERV", s);
        continue; /* Loop/switch isn't completed */
_L7:
        j1.a("AKID", s);
          goto _L14
_L10:
        j1.a("AKBN", s);
          goto _L15
_L13:
        j1.a("AKD", context);
_L2:
        return;
        if (true) goto _L17; else goto _L16
_L16:
    }
}
