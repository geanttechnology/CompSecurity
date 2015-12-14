// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.ui;

import android.util.Log;
import android.widget.GridView;
import com.fotoable.photoselector.model.GroupGridAdapter;

// Referenced classes of package com.fotoable.photoselector.ui:
//            MediaStoreGridFragment

class a
    implements android.view.LayoutListener
{

    final GridView a;
    final MediaStoreGridFragment b;

    public void onGlobalLayout()
    {
        if (b.b.getNumColumns() == 0)
        {
            int i = (int)Math.floor(a.getWidth() / (MediaStoreGridFragment.a(b) + MediaStoreGridFragment.b(b)));
            if (i > 0)
            {
                int j = a.getWidth() / i;
                int k = MediaStoreGridFragment.b(b);
                b.b.setNumColumns(i);
                b.b.setItemHeight(j - k);
                Log.d("MultiPhotoSelectorFragment", (new StringBuilder()).append("onCreateView - numColumns set to ").append(i).toString());
            }
        }
    }

    (MediaStoreGridFragment mediastoregridfragment, GridView gridview)
    {
        b = mediastoregridfragment;
        a = gridview;
        super();
    }
}
