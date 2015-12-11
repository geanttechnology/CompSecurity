// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.a;

import android.graphics.Bitmap;
import android.util.Base64;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;

public class b
{
    public static interface a
    {

        public abstract void a(Bitmap bitmap);

        public abstract void d();
    }


    private static final String BASE_64_POSTFIX = "==";
    private static final String BASE_64_PREFIX = "data:image/gif;base64,";

    public b()
    {
    }

    private Bitmap a(String s)
    {
        s = Base64.decode(s.getBytes(), 0);
        return BitmapFactoryInstrumentation.decodeByteArray(s, 0, s.length);
    }

    public void a(String s, a a1)
    {
        s = a(s.replace("data:image/gif;base64,", "").replace("==", ""));
        if (s != null)
        {
            a1.a(s);
            return;
        } else
        {
            a1.d();
            return;
        }
    }
}
