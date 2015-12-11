// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.smule.android.f.h;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        android.app.alog.Builder builder = new android.app.alog.Builder(a.a);
        builder.setMessage(0x7f0c0199);
        builder.setCancelable(false);
        builder.setPositiveButton(0x7f0c01c0, new android.content.DialogInterface.OnClickListener() {

            final ag._cls1._cls1 a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                ag.a(a.a.a).dismiss();
            }

            
            {
                a = ag._cls1._cls1.this;
                super();
            }
        });
        ag.a(a.a, builder.create());
        ag.a(a.a).show();
        ag.b(true);
    }

    _cls1.a(_cls1.a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/ag$1

/* anonymous class */
    class ag._cls1
        implements Observer
    {

        final ag a;

        public void update(Observable observable, Object obj)
        {
            h.a().b("MagicNetwork.SERVER_MAINTENANCE_EVENT", this);
            if (!ag.k())
            {
                a.runOnUiThread(new ag._cls1._cls1(this));
            }
        }

            
            {
                a = ag1;
                super();
            }
    }

}
