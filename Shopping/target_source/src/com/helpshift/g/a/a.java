// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.g.a;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;

public final class a
{

    public static BitmapDrawable a(Context context, String s)
    {
        s = Base64.decode(s, 0);
        s = BitmapFactoryInstrumentation.decodeByteArray(s, 0, s.length);
        return new BitmapDrawable(context.getResources(), s);
    }
}
