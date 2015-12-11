// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.os.Bundle;
import com.tremorvideo.a.a;
import com.tremorvideo.a.c;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ab, ax

class a
    implements Runnable
{

    final  a;

    public void run()
    {
        ab ab1 = new ab(a.a.b, a.a.d, com.tremorvideo.sdk.android.videoad.a, new ab.b() {

            final ax._cls1._cls3 a;

            public void a(boolean flag)
            {
                com.tremorvideo.sdk.android.videoad.ax.a(a.a.a, true);
            }

            
            {
                a = ax._cls1._cls3.this;
                super();
            }
        });
        ab1.setCanceledOnTouchOutside(false);
        ab1.setTitle("Facebook");
        ab1.a("Posted to Facebook successfully.");
        ab1.a("Ok", "");
        ab1.show();
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/tremorvideo/sdk/android/videoad/ax$1

/* anonymous class */
    class ax._cls1
        implements com.tremorvideo.a.b.a
    {

        final ax a;

        public void a()
        {
            com.tremorvideo.sdk.android.videoad.ax.a(a, true);
        }

        public void a(Bundle bundle)
        {
            a.b.runOnUiThread(new ax._cls1._cls3(this));
        }

        public void a(a a1)
        {
            a.b.runOnUiThread(new ax._cls1._cls2());
        }

        public void a(c c)
        {
            a.b.runOnUiThread(new ax._cls1._cls1());
        }

            
            {
                a = ax1;
                super();
            }

        // Unreferenced inner class com/tremorvideo/sdk/android/videoad/ax$1$1

/* anonymous class */
        class ax._cls1._cls1
            implements Runnable
        {

            final ax._cls1 a;

            public void run()
            {
                ab ab1 = new ab(a.a.b, a.a.d, com.tremorvideo.sdk.android.videoad.ab.a.a, new ax._cls1._cls1._cls1(this));
                ab1.setCanceledOnTouchOutside(false);
                ab1.setTitle("Facebook");
                ab1.a("There was an error posting to your Facebook page.");
                ab1.a("Ok", "");
                ab1.show();
            }

                    
                    {
                        a = ax._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/tremorvideo/sdk/android/videoad/ax$1$1$1

/* anonymous class */
        class ax._cls1._cls1._cls1
            implements ab.b
        {

            final ax._cls1._cls1 a;

            public void a(boolean flag)
            {
                com.tremorvideo.sdk.android.videoad.ax.a(a.a.a, true);
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }


        // Unreferenced inner class com/tremorvideo/sdk/android/videoad/ax$1$2

/* anonymous class */
        class ax._cls1._cls2
            implements Runnable
        {

            final ax._cls1 a;

            public void run()
            {
                ab ab1 = new ab(a.a.b, a.a.d, com.tremorvideo.sdk.android.videoad.ab.a.a, new ax._cls1._cls2._cls1(this));
                ab1.setCanceledOnTouchOutside(false);
                ab1.setTitle("Facebook");
                ab1.a("There was an error posting to your Facebook page.");
                ab1.a("Ok", "");
                ab1.show();
            }

                    
                    {
                        a = ax._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/tremorvideo/sdk/android/videoad/ax$1$2$1

/* anonymous class */
        class ax._cls1._cls2._cls1
            implements ab.b
        {

            final ax._cls1._cls2 a;

            public void a(boolean flag)
            {
                com.tremorvideo.sdk.android.videoad.ax.a(a.a.a, true);
            }

                    
                    {
                        a = _pcls2;
                        super();
                    }
        }

    }

}
