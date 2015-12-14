// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

// Referenced classes of package com.millennialmedia.android:
//            VideoPlayerActivity

class a
    implements android.view.ayerActivity._cls3
{

    private VideoPlayerActivity a;

    public void onClick(View view)
    {
label0:
        {
            if (a.f != null)
            {
                if (!a.f.isPlaying())
                {
                    break label0;
                }
                a.m();
                a.h.setBackgroundResource(0x1080024);
            }
            return;
        }
        if (a.e)
        {
            a.a(0);
        } else
        if (a.i && !a.e)
        {
            a.g();
        } else
        {
            a.a(a.d);
        }
        a.h.setBackgroundResource(0x1080023);
    }

    (VideoPlayerActivity videoplayeractivity)
    {
        a = videoplayeractivity;
        super();
    }
}
