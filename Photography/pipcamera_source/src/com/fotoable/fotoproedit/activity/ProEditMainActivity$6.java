// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import gm;
import gp;
import java.io.File;
import rd;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditMainActivity

class a
    implements Runnable
{

    final ProEditMainActivity a;

    public void run()
    {
        try
        {
            gm.c().a(new gp() {

                final ProEditMainActivity._cls6 a;

                public void a(String s)
                {
                    s = rd.a(s);
                    if (s == null || !s.exists()) goto _L2; else goto _L1
_L1:
                    ProEditMainActivity.a(a.a, s);
_L4:
                    a.a.b();
                    return;
_L2:
                    s = gm.c().k();
                    if (s != null)
                    {
                        try
                        {
                            s = rd.a(s);
                            ProEditMainActivity.a(a.a, s);
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            s.printStackTrace();
                        }
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                a = ProEditMainActivity._cls6.this;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        a.b();
    }

    _cls1.a(ProEditMainActivity proeditmainactivity)
    {
        a = proeditmainactivity;
        super();
    }
}
