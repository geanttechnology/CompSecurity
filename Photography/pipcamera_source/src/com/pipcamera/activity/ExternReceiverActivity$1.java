// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.graphics.Bitmap;
import kz;
import oc;
import od;
import oe;

// Referenced classes of package com.pipcamera.activity:
//            ExternReceiverActivity

class b
    implements kz
{

    final String a;
    final String b;
    final ExternReceiverActivity c;

    public void a(Bitmap bitmap)
    {
        String s1 = a;
        String s = s1;
        if (b != null)
        {
            s = (new StringBuilder()).append(s1).append(" ").append(b).toString();
        }
        oc.e(c, bitmap, null, null, s, new od() {

            final ExternReceiverActivity._cls1 a;

            public void a(boolean flag, boolean flag1)
            {
                a.c.finish();
            }

            
            {
                a = ExternReceiverActivity._cls1.this;
                super();
            }
        });
    }

    public void a(Exception exception)
    {
        String s = a;
        exception = s;
        if (b != null)
        {
            exception = (new StringBuilder()).append(s).append(" ").append(b).toString();
        }
        oe.a(c, exception);
        c.finish();
    }

    _cls1.a(ExternReceiverActivity externreceiveractivity, String s, String s1)
    {
        c = externreceiveractivity;
        a = s;
        b = s1;
        super();
    }
}
