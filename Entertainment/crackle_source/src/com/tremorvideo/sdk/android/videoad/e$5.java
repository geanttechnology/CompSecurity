// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.VideoView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e

class a
    implements Runnable
{

    final e a;

    public void run()
    {
        if (e.p(a) == null)
        {
            android.app.tDialog.Builder builder = new android.app.tDialog.Builder(a.c);
            builder.setTitle("Cannot play video");
            builder.setMessage("Sorry, this video cannot be played");
            builder.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                final e._cls5 a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    e.q(a.a);
                }

            
            {
                a = e._cls5.this;
                super();
            }
            });
            e.a(a, builder.create());
            e.p(a).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final e._cls5 a;

                public void onCancel(DialogInterface dialoginterface)
                {
                    e.q(a.a);
                }

            
            {
                a = e._cls5.this;
                super();
            }
            });
        }
        e.p(a).show();
        e.a(a, 0L);
        if (e.d(a).isPlaying())
        {
            e.d(a).stopPlayback();
        }
        e.d(a).setVisibility(8);
    }

    _cls2.a(e e1)
    {
        a = e1;
        super();
    }
}
