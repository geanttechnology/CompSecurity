// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.view.View;

// Referenced classes of package com.facebook.ads:
//            VideoAdActivity

class i
    implements android.view.View.OnClickListener
{

    final VideoAdActivity a;

    i(VideoAdActivity videoadactivity)
    {
        a = videoadactivity;
        super();
    }

    public void onClick(View view)
    {
        VideoAdActivity.access$202(a, true);
        a.finish();
    }
}
