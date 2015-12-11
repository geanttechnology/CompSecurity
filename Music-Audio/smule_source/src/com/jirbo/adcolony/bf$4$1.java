// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.MediaController;

// Referenced classes of package com.jirbo.adcolony:
//            bf

class a
    implements android.content.nterface.OnClickListener
{

    final a a;

    public void onClick(DialogInterface dialoginterface, int i)
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

    // Unreferenced inner class com/jirbo/adcolony/bf$4

/* anonymous class */
    class bf._cls4
        implements android.media.MediaPlayer.OnErrorListener
    {

        final bf a;

        public boolean onError(MediaPlayer mediaplayer, int i, int j)
        {
            Log.d(a.a, (new StringBuilder()).append("Error: ").append(i).append(",").append(j).toString());
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
            a.b().getResources();
            if (i == 200)
            {
                mediaplayer = "Invalid progressive playback";
            } else
            {
                mediaplayer = "Unknown error";
            }
            (new android.app.AlertDialog.Builder(a.b())).setTitle("ERROR").setMessage(mediaplayer).setPositiveButton("OKAY", new bf._cls4._cls1(this)).setCancelable(false).show();
            return true;
        }

            
            {
                a = bf1;
                super();
            }
    }

}
