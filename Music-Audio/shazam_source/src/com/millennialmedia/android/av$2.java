// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.View;
import android.widget.VideoView;

// Referenced classes of package com.millennialmedia.android:
//            av

final class a
    implements android.view.OnClickListener
{

    final av a;

    public final void onClick(View view)
    {
        if (a.e != null)
        {
            a.e.seekTo(0);
        }
    }

    (av av1)
    {
        a = av1;
        super();
    }
}
