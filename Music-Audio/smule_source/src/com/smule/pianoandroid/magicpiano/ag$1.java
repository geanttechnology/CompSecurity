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
    implements Observer
{

    final ag a;

    public void update(Observable observable, Object obj)
    {
        h.a().b("MagicNetwork.SERVER_MAINTENANCE_EVENT", this);
        if (!ag.k())
        {
            a.runOnUiThread(new Runnable() {

                final ag._cls1 a;

                public void run()
                {
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a.a);
                    builder.setMessage(0x7f0c0199);
                    builder.setCancelable(false);
                    builder.setPositiveButton(0x7f0c01c0, new android.content.DialogInterface.OnClickListener(this) {

                        final _cls1 a;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            ag.a(a.a.a).dismiss();
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    ag.a(a.a, builder.create());
                    ag.a(a.a).show();
                    ag.b(true);
                }

            
            {
                a = ag._cls1.this;
                super();
            }
            });
        }
    }

    _cls1.a(ag ag1)
    {
        a = ag1;
        super();
    }
}
