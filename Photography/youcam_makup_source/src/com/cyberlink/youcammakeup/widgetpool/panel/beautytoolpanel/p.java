// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.content.res.Resources;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.av;

public class p
{

    public Integer a;
    public String b;
    public String c;
    public com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType d;
    public boolean e;
    private av f;

    public p(String s, String s1, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType sourcetype, boolean flag, av av1)
    {
        a = null;
        b = "";
        c = null;
        d = null;
        e = false;
        b = s;
        c = s1;
        d = sourcetype;
        e = flag;
        f = av1;
    }

    public String a()
    {
        if (c != null && (c.equals("default_original_wig") || c.equals("default_original_eye_wear")))
        {
            return Globals.d().getResources().getString(0x7f0703ce);
        } else
        {
            return av.a(f);
        }
    }
}
