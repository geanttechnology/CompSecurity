// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.uicomp;

import android.util.Log;
import android.widget.GridView;
import com.fotoable.photoselector.model.GroupGridAdapter;

// Referenced classes of package com.fotoable.photoselector.uicomp:
//            ImageGridFragment

class a
    implements android.view.lobalLayoutListener
{

    final GridView a;
    final ImageGridFragment b;

    public void onGlobalLayout()
    {
        if (ImageGridFragment.a(b).getNumColumns() == 0)
        {
            int i = (int)Math.floor(a.getWidth() / (ImageGridFragment.b(b) + ImageGridFragment.c(b)));
            if (i > 0)
            {
                int j = a.getWidth() / i;
                int k = ImageGridFragment.c(b);
                ImageGridFragment.a(b).setNumColumns(i);
                ImageGridFragment.a(b).setItemHeight(j - k);
                Log.d("ImageGridFragment", (new StringBuilder()).append("onCreateView - numColumns set to ").append(i).toString());
            }
        }
    }

    (ImageGridFragment imagegridfragment, GridView gridview)
    {
        b = imagegridfragment;
        a = gridview;
        super();
    }
}
