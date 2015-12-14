// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import com.pf.common.utility.m;

public class c
{

    public byte a[][];
    public int b;
    public int c;

    public c()
    {
    }

    void a()
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] == null)
            {
                m.d("EyeLinerEffectPanel", (new StringBuilder()).append("Unassigned eyeliner_model_images[").append(i).append("]").toString());
                a[i] = new byte[b * c];
            }
        }

    }
}
