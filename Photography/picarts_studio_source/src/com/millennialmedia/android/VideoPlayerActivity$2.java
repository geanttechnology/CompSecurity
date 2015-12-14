// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.View;
import android.widget.VideoView;

// Referenced classes of package com.millennialmedia.android:
//            VideoPlayerActivity

class a
    implements android.view.ayerActivity._cls2
{

    private VideoPlayerActivity a;

    public void onClick(View view)
    {
        if (a.f != null)
        {
            a.f.seekTo(0);
        }
    }

    (VideoPlayerActivity videoplayeractivity)
    {
        a = videoplayeractivity;
        super();
    }
}
