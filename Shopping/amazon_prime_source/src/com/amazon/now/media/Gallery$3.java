// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.view.View;

// Referenced classes of package com.amazon.now.media:
//            Gallery, GalleryPanel, PinchImageView

class this._cls0
    implements android.view.ckListener
{

    final Gallery this$0;

    public void onClick(View view)
    {
        view = ((View) (view.getTag()));
        if (view instanceof Integer)
        {
            view = (Integer)view;
            setCurrentPage(view.intValue());
            Gallery.access$000(Gallery.this).selectDot(view.intValue(), false);
            if (getVisibility() == 4)
            {
                setVisibility(0);
                if (Gallery.access$100(Gallery.this) != null)
                {
                    Gallery.access$100(Gallery.this).setVisibility(4);
                }
            }
        }
    }

    View()
    {
        this$0 = Gallery.this;
        super();
    }
}
