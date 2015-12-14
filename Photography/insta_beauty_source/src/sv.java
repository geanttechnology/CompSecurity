// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;

public class sv
    implements st
{

    private final Context a;

    public sv(Context context)
    {
        a = context;
    }

    private boolean b()
    {
        return a.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    public int a()
    {
        return !b() ? 0 : 1;
    }

    public Camera a(int i)
    {
        return Camera.open();
    }

    public void a(int i, su su1)
    {
        su1.a = 0;
        su1.b = 90;
    }

    public boolean b(int i)
    {
        if (i == 0)
        {
            return b();
        } else
        {
            return false;
        }
    }

    public int c(int i)
    {
        return -1;
    }

    public int d(int i)
    {
        return !b() ? -1 : 0;
    }
}
