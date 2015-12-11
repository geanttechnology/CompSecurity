// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, o, r, al, 
//            b

public final class m extends p
{

    protected String a;
    protected String b;
    protected boolean c;
    protected int d;
    protected boolean e;
    protected int f;
    protected boolean g;
    protected boolean h;

    public m(r r1)
    {
        super(r1);
    }

    protected final void a()
    {
        Object obj = super.i.a;
        try
        {
            obj = ((Context) (obj)).getPackageManager().getApplicationInfo(((Context) (obj)).getPackageName(), 129);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            d("PackageManager doesn't know about the app package", obj);
            obj = null;
        }
        if (obj == null)
        {
            e("Couldn't get ApplicationInfo to load global config");
        } else
        {
            obj = ((ApplicationInfo) (obj)).metaData;
            if (obj != null)
            {
                int j = ((Bundle) (obj)).getInt("com.google.android.gms.analytics.globalConfigResource");
                if (j > 0)
                {
                    b b1 = (b)(new al(super.i)).a(j);
                    if (b1 != null)
                    {
                        b("Loading global XML config values");
                        int k;
                        if (b1.a != null)
                        {
                            k = 1;
                        } else
                        {
                            k = 0;
                        }
                        if (k != 0)
                        {
                            String s = b1.a;
                            b = s;
                            b("XML config - app name", s);
                        }
                        if (b1.b != null)
                        {
                            k = 1;
                        } else
                        {
                            k = 0;
                        }
                        if (k != 0)
                        {
                            String s1 = b1.b;
                            a = s1;
                            b("XML config - app version", s1);
                        }
                        if (b1.c != null)
                        {
                            k = 1;
                        } else
                        {
                            k = 0;
                        }
                        if (k != 0)
                        {
                            String s2 = b1.c.toLowerCase();
                            if ("verbose".equals(s2))
                            {
                                k = 0;
                            } else
                            if ("info".equals(s2))
                            {
                                k = 1;
                            } else
                            if ("warning".equals(s2))
                            {
                                k = 2;
                            } else
                            if ("error".equals(s2))
                            {
                                k = 3;
                            } else
                            {
                                k = -1;
                            }
                            if (k >= 0)
                            {
                                d = k;
                                a("XML config - log level", Integer.valueOf(k));
                            }
                        }
                        if (b1.d >= 0)
                        {
                            k = 1;
                        } else
                        {
                            k = 0;
                        }
                        if (k != 0)
                        {
                            k = b1.d;
                            f = k;
                            e = true;
                            b("XML config - dispatch period (sec)", Integer.valueOf(k));
                        }
                        if (b1.e != -1)
                        {
                            k = 1;
                        } else
                        {
                            k = 0;
                        }
                        if (k != 0)
                        {
                            boolean flag;
                            if (b1.e == 1)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            h = flag;
                            g = true;
                            b("XML config - dry run", Boolean.valueOf(flag));
                            return;
                        }
                    }
                }
            }
        }
    }

    public final String b()
    {
        o();
        return a;
    }

    public final String c()
    {
        o();
        return b;
    }

    public final boolean d()
    {
        o();
        return c;
    }

    public final int e()
    {
        o();
        return d;
    }

    public final boolean f()
    {
        o();
        return e;
    }

    public final int g()
    {
        o();
        return f;
    }

    public final boolean h()
    {
        o();
        return g;
    }

    public final boolean i()
    {
        o();
        return h;
    }
}
