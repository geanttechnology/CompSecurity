// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import com.crashlytics.android.Crashlytics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class vs
{

    public static String a(Context context, int i)
    {
        StringBuilder stringbuilder;
        context = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i)));
        stringbuilder = new StringBuilder();
_L1:
        String s;
        try
        {
            s = context.readLine();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
            return null;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        stringbuilder.append(s);
        stringbuilder.append('\n');
          goto _L1
        return stringbuilder.toString();
    }
}
