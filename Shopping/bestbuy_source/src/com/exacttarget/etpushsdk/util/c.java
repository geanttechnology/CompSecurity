// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import p;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            m

public class c
{

    public static Bitmap a(String s)
    {
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setDoInput(true);
        p.a(s);
        s.connect();
        p.b(s);
        IOException ioexception;
        try
        {
            return BitmapFactory.decodeStream(p.d(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!uc", s.getMessage(), s);
        }
        break MISSING_BLOCK_LABEL_60;
        ioexception;
        p.a(s, ioexception);
        throw ioexception;
        return null;
    }
}
