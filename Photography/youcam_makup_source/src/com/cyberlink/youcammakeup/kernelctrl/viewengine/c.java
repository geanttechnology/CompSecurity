// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import com.cyberlink.youcammakeup.kernelctrl.ROI;

public class c
{

    public ROI a;
    public ViewEngine.TaskRole b;
    public ViewEngine.ThumbnailRule c;
    public ViewEngine.DecodePolicy d;
    public Boolean e;
    public Boolean f;

    public c(ViewEngine.TaskRole taskrole)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        if (taskrole == null)
        {
            throw new IllegalArgumentException("Invalid Argument: role should not be null.");
        } else
        {
            b = taskrole;
            return;
        }
    }

    ViewEngine.Argd a()
    {
        ViewEngine.Argd argd = new ViewEngine.Argd(null);
        if (a != null)
        {
            argd.put("ROI", a);
        }
        if (b != null)
        {
            argd.put("Role", b);
        }
        if (c != null)
        {
            argd.put("thumbRule", c);
        }
        if (d != null)
        {
            argd.put("policy", d);
        }
        if (e != null)
        {
            argd.put("bIgnoreCacheForFastBg", e);
        }
        if (f != null)
        {
            argd.put("bNotGenerateCache", f);
        }
        return argd;
    }
}
