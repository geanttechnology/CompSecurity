// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.net.Uri;
import android.view.View;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            SlideShowView, UICImageView, p

class a
    implements Runnable
{

    final SlideShowView a;

    public void run()
    {
        if (SlideShowView.a(a).size() == 0)
        {
            return;
        }
        UICImageView uicimageview = (UICImageView)SlideShowView.a(a).get(SlideShowView.c(a));
        if (uicimageview.a())
        {
            android.view.ViewParent viewparent = a.getParent();
            if (viewparent instanceof View)
            {
                ((View)viewparent).setVisibility(0);
            }
            if (a.getVisibility() != 0)
            {
                a.setVisibility(0);
                if (SlideShowView.g(a) != null)
                {
                    SlideShowView.g(a).a();
                }
            }
            uicimageview.setVisibility(0);
            int i = SlideShowView.c(a);
            int j = SlideShowView.a(a).size();
            uicimageview = (UICImageView)SlideShowView.a(a).get((i + 1) % j);
            if (!uicimageview.a())
            {
                uicimageview.setImageURI((Uri)uicimageview.getTag());
                return;
            } else
            {
                a.postDelayed(SlideShowView.e(a), SlideShowView.f(a));
                return;
            }
        } else
        {
            uicimageview.setImageURI((Uri)uicimageview.getTag());
            return;
        }
    }

    (SlideShowView slideshowview)
    {
        a = slideshowview;
        super();
    }
}
