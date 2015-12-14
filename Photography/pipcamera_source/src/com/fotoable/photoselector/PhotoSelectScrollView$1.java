// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import android.view.View;
import android.widget.LinearLayout;
import nb;

// Referenced classes of package com.fotoable.photoselector:
//            PhotoSelectScrollView

class a
    implements android.view.tScrollView._cls1
{

    final View a;
    final PhotoSelectScrollView b;

    public void onClick(View view)
    {
        if (PhotoSelectScrollView.access$000(b) != null)
        {
            PhotoSelectScrollView.access$000(b).a(a.getTag());
            PhotoSelectScrollView.access$100(b).removeView(a);
            for (int i = 0; i < PhotoSelectScrollView.access$100(b).getChildCount(); i++)
            {
                PhotoSelectScrollView.access$100(b).getChildAt(i).setTag(new Integer(i));
            }

        }
    }

    (PhotoSelectScrollView photoselectscrollview, View view)
    {
        b = photoselectscrollview;
        a = view;
        super();
    }
}
