// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResUtils
{

    private static final String ATTR_NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/util/ResUtils);

    private ResUtils()
    {
    }

    public static boolean getAttributeBooleanValue(AttributeSet attributeset, String s, boolean flag)
    {
        if (attributeset == null)
        {
            return flag;
        } else
        {
            return attributeset.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", s, flag);
        }
    }

    public static int getAttributeIntValue(AttributeSet attributeset, String s, int i)
    {
        if (attributeset == null)
        {
            return i;
        } else
        {
            return attributeset.getAttributeIntValue("http://schemas.android.com/apk/res-auto", s, i);
        }
    }

    public static int getResourceId(int i, Context context, String s, String s1)
    {
        int j = context.getResources().getIdentifier(s1, s, context.getPackageName());
        if (j == 0)
        {
            return i;
        } else
        {
            return j;
        }
    }

    public static Typeface loadFontFromRes(int i, Context context)
    {
        Context context1;
        Object obj;
        String s;
        obj = null;
        InputStream inputstream;
        byte abyte0[];
        try
        {
            inputstream = context.getResources().openRawResource(i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("Could not openRawResource font", context);
            return null;
        }
        context1 = obj;
        abyte0 = new byte[inputstream.available()];
        context1 = obj;
        s = (new StringBuilder()).append(context.getCacheDir()).append("/rs_font").append(System.currentTimeMillis()).append(".raw").toString();
        context1 = obj;
        context = new BufferedOutputStream(new FileOutputStream(s));
_L2:
        context1 = obj;
        i = inputstream.read(abyte0);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        context1 = obj;
        context.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
_L4:
        return context;
_L1:
        context1 = obj;
        context.close();
        context1 = obj;
        context = Typeface.createFromFile(s);
        context1 = context;
        try
        {
            (new File(s)).delete();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("Could not openRawResource font", context);
            context = context1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
