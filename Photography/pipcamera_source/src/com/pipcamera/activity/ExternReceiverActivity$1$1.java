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

class a
    implements od
{

    final sh a;

    public void a(boolean flag, boolean flag1)
    {
        a.a.finish();
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/pipcamera/activity/ExternReceiverActivity$1

/* anonymous class */
    class ExternReceiverActivity._cls1
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
            oc.e(c, bitmap, null, null, s, new ExternReceiverActivity._cls1._cls1(this));
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

            
            {
                c = externreceiveractivity;
                a = s;
                b = s1;
                super();
            }
    }

}
