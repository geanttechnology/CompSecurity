// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import android.content.Context;
import bm;
import cz;
import d;
import eo;
import java.util.Vector;

public final class b
{

    private bm a;
    private Context b;
    private boolean c;

    public b(Vector vector)
    {
        a = d.a(getClass());
        b = null;
        c = false;
        if (vector != null)
        {
            int i = 0;
            while (i < vector.size()) 
            {
                cz cz1 = (cz)vector.get(i);
                String s = cz1.a();
                if (cz1.d() == cz.a.a)
                {
                    if (s.equals("Android_Context"))
                    {
                        b = (Context)cz1.c();
                        if (a.b())
                        {
                            a.b((new StringBuilder("NMSP_DEFINES_ANDROID_CONTEXT is passed in as")).append(b).toString());
                        }
                    } else
                    if (s.equals("Disable_Bluetooth") && (new String(cz1.b())).equalsIgnoreCase("TRUE"))
                    {
                        if (a.b())
                        {
                            a.b("Disable_Bluetooth is true.");
                        }
                        c = true;
                    }
                }
                i++;
            }
        }
    }

    public final boolean a()
    {
        if (!c)
        {
            if (b == null)
            {
                if (a.e())
                {
                    a.e("ANDROID_CONTEXT parameter is not passed in!!!");
                    return false;
                }
            } else
            {
                eo eo1 = eo.a(b);
                boolean flag = eo1.b();
                eo1.c();
                return flag;
            }
        }
        return false;
    }
}
