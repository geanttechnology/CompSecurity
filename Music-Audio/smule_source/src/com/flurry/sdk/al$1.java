// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.os.FileObserver;
import android.os.Handler;

// Referenced classes of package com.flurry.sdk:
//            al, fp, hq

class ver extends FileObserver
{

    final al a;

    public void onEvent(int i, String s)
    {
        if ((i & 0x800) != 0 || (i & 0x400) != 0)
        {
            fp.a().f().post(new hq() {

                final al._cls1 a;

                public void safeRun()
                {
                    if (al.b(a.a) == null)
                    {
                        return;
                    } else
                    {
                        a.a.b();
                        a.a.a();
                        return;
                    }
                }

            
            {
                a = al._cls1.this;
                super();
            }
            });
        }
    }

    nit>(al al1, String s)
    {
        a = al1;
        super(s);
    }
}
