// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.os.FileObserver;
import android.os.Handler;

// Referenced classes of package com.flurry.sdk:
//            hq, al, fp

class t> extends hq
{

    final a a;

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

    r(r r)
    {
        a = r;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/al$1

/* anonymous class */
    class al._cls1 extends FileObserver
    {

        final al a;

        public void onEvent(int i, String s)
        {
            if ((i & 0x800) != 0 || (i & 0x400) != 0)
            {
                fp.a().f().post(new al._cls1._cls1(this));
            }
        }

            
            {
                a = al1;
                super(s);
            }
    }

}
