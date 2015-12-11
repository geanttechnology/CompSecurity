// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.Display;
import android.view.WindowManager;

public final class chx
    implements bjp
{

    private WindowManager a;

    public chx(chw chw, WindowManager windowmanager)
    {
        a = windowmanager;
        super();
    }

    public final Object b_()
    {
        return Float.valueOf(a.getDefaultDisplay().getRefreshRate());
    }
}
