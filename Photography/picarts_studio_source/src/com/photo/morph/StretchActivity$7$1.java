// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.os.Handler;

// Referenced classes of package com.photo.morph:
//            StretchActivity

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        StretchActivity.A(a.a);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/photo/morph/StretchActivity$7

/* anonymous class */
    final class StretchActivity._cls7
        implements Runnable
    {

        final StretchActivity a;

        public final void run()
        {
            (new Handler()).post(new StretchActivity._cls7._cls1(this));
        }

            
            {
                a = stretchactivity;
                super();
            }
    }

}
