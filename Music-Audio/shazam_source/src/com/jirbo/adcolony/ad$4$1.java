// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.widget.MediaController;

// Referenced classes of package com.jirbo.adcolony:
//            ad

final class a
    implements android.content.nterface.OnClickListener
{

    final a a;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        if (a.a.n != null)
        {
            a.a.n.onCompletion(a.a.h);
        }
    }

    ilder(ilder ilder)
    {
        a = ilder;
        super();
    }

    // Unreferenced inner class com/jirbo/adcolony/ad$4

/* anonymous class */
    final class ad._cls4
        implements android.media.MediaPlayer.OnErrorListener
    {

        final ad a;

        public final boolean onError(MediaPlayer mediaplayer, int i, int j)
        {
            (new StringBuilder("Error: ")).append(i).append(",").append(j);
            a.e = -1;
            a.f = -1;
            if (a.m != null)
            {
                a.m.hide();
            }
            while (a.q != null && a.q.onError(a.h, i, j) || a.getWindowToken() == null) 
            {
                return true;
            }
            ad.b().getResources();
            if (i == 200)
            {
                mediaplayer = "Invalid progressive playback";
            } else
            {
                mediaplayer = "Unknown error";
            }
            (new android.app.AlertDialog.Builder(ad.b())).setTitle("ERROR").setMessage(mediaplayer).setPositiveButton("OKAY", new ad._cls4._cls1(this)).setCancelable(false).show();
            return true;
        }

            
            {
                a = ad1;
                super();
            }
    }

}
