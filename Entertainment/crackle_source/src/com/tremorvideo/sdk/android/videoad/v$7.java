// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.VideoView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v

class a
    implements Runnable
{

    final v a;

    public void run()
    {
        if (v.p(a) == null)
        {
            android.app.tDialog.Builder builder = new android.app.tDialog.Builder(v.q(a));
            builder.setTitle("Cannot play video");
            builder.setMessage("Sorry, this video cannot be played");
            builder.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                final v._cls7 a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    v.r(a.a);
                }

            
            {
                a = v._cls7.this;
                super();
            }
            });
            v.a(a, builder.create());
            v.p(a).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final v._cls7 a;

                public void onCancel(DialogInterface dialoginterface)
                {
                    v.r(a.a);
                }

            
            {
                a = v._cls7.this;
                super();
            }
            });
        }
        v.p(a).show();
        v.a(a, 0L);
        if (v.e(a).isPlaying())
        {
            v.e(a).stopPlayback();
        }
        v.e(a).setVisibility(8);
    }

    _cls2.a(v v1)
    {
        a = v1;
        super();
    }
}
