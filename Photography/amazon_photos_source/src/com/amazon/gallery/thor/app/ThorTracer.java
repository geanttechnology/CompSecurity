// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.os.Trace;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GTracer;

public class ThorTracer
    implements GTracer
{

    public ThorTracer()
    {
    }

    public void beginSection(String s)
    {
        if (Api.isAtLeastJellyBeanMR2())
        {
            Trace.beginSection(s);
        }
    }

    public void endSection()
    {
        if (Api.isAtLeastJellyBeanMR2())
        {
            Trace.endSection();
        }
    }
}
