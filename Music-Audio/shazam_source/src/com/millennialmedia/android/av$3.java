// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

// Referenced classes of package com.millennialmedia.android:
//            av

final class a
    implements android.view.OnClickListener
{

    final av a;

    public final void onClick(View view)
    {
label0:
        {
            if (a.e != null)
            {
                if (!a.e.isPlaying())
                {
                    break label0;
                }
                a.k();
                a.j.setBackgroundResource(0x1080024);
            }
            return;
        }
        if (a.c)
        {
            a.c(0);
        } else
        if (a.n && !a.c)
        {
            a.l();
        } else
        {
            a.c(a.b);
        }
        a.j.setBackgroundResource(0x1080023);
    }

    (av av1)
    {
        a = av1;
        super();
    }
}
