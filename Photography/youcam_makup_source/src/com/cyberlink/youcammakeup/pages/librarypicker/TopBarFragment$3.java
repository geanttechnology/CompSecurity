// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKLivePhotoEvent;
import com.cyberlink.youcammakeup.clflurry.b;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker:
//            TopBarFragment

class a
    implements android.view.ner
{

    final TopBarFragment a;

    public void onClick(View view)
    {
        b.a(new YMKLivePhotoEvent(com.cyberlink.youcammakeup.clflurry..Operation.e));
        a.b();
    }

    (TopBarFragment topbarfragment)
    {
        a = topbarfragment;
        super();
    }
}
