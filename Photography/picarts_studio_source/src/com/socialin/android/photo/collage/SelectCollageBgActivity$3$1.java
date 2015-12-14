// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;

import com.socialin.android.util.Utils;

// Referenced classes of package com.socialin.android.photo.collage:
//            SelectCollageBgActivity

final class a
    implements Runnable
{

    private tring a;

    public final void run()
    {
        if (!a.a.isFinishing())
        {
            Utils.c(a.a, a.a.getString(0x7f08024e));
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/collage/SelectCollageBgActivity$3

/* anonymous class */
    final class SelectCollageBgActivity._cls3 extends Thread
    {

        final SelectCollageBgActivity a;
        private String b;
        private String c;
        private String d;

        public final void run()
        {
            boolean flag = SelectCollageBgActivity.b(a, b, c, d);
            if (flag)
            {
                SelectCollageBgActivity.e(a);
            }
            if (!flag)
            {
                a.runOnUiThread(new SelectCollageBgActivity._cls3._cls1(this));
            }
        }

            
            {
                a = selectcollagebgactivity;
                b = s;
                c = s1;
                d = s2;
                super();
            }
    }

}
