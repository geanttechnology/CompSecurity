// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.smule.android.facebook.a;
import com.smule.android.facebook.c;
import com.smule.android.facebook.d;
import com.smule.pianoandroid.magicpiano.b.e;
import com.smule.pianoandroid.magicpiano.registration.FacebookEmailActivity;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap

class a
    implements Runnable
{

    final c a;
    final e b;

    public void run()
    {
        if (a == null || TextUtils.isEmpty(a.c))
        {
            Intent intent = new Intent(b.b.b.getApplicationContext(), com/smule/pianoandroid/magicpiano/registration/FacebookEmailActivity);
            b.b.b.startActivity(intent);
            b.b.b.finish();
            return;
        } else
        {
            ap.s(b.b.b).post(new Runnable() {

                final ap._cls16._cls1._cls1 a;

                public void run()
                {
                    (new e(a.b.a.a, false)).execute(new Void[0]);
                }

            
            {
                a = ap._cls16._cls1._cls1.this;
                super();
            }
            });
            return;
        }
    }

    _cls1.a(_cls1.a a1, c c1)
    {
        b = a1;
        a = c1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/ap$16

/* anonymous class */
    class ap._cls16
        implements Runnable
    {

        final ap a;

        public void run()
        {
            com.smule.android.facebook.a.a().a(new ap._cls16._cls1(this));
        }

            
            {
                a = ap1;
                super();
            }
    }


    // Unreferenced inner class com/smule/pianoandroid/magicpiano/ap$16$1

/* anonymous class */
    class ap._cls16._cls1
        implements d
    {

        final ap._cls16 a;

        public void a(c c1)
        {
            a.a.runOnUiThread(new ap._cls16._cls1._cls1(this, c1));
        }

            
            {
                a = _pcls16;
                super();
            }
    }

}
