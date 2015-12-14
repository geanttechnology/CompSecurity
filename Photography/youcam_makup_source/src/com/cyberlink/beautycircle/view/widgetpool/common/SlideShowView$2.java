// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.net.Uri;
import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.Campaign;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            SlideShowView

class a
    implements android.view.ener
{

    final Campaign a;
    final SlideShowView b;

    public void onClick(View view)
    {
        c.a(b.getContext(), a.link.toString(), 1);
    }

    (SlideShowView slideshowview, Campaign campaign)
    {
        b = slideshowview;
        a = campaign;
        super();
    }
}
