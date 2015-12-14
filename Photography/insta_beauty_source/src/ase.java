// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.widget.GridView;
import com.fotoable.photoselector.activity.PhotoSelectorGridFragment;
import com.fotoable.photoselector.model.GroupGridAdapter;

public class ase
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final GridView a;
    final PhotoSelectorGridFragment b;

    public ase(PhotoSelectorGridFragment photoselectorgridfragment, GridView gridview)
    {
        b = photoselectorgridfragment;
        a = gridview;
        super();
    }

    public void onGlobalLayout()
    {
        if (b.a.getNumColumns() == 0)
        {
            int i = (int)Math.floor(a.getWidth() / (PhotoSelectorGridFragment.a(b) + PhotoSelectorGridFragment.b(b)));
            if (i > 0)
            {
                int j = a.getWidth() / i - PhotoSelectorGridFragment.b(b);
                b.a.setNumColumns(i);
                b.a.setItemHeight(j);
                Log.d("PhotoSelectorGridFragment", (new StringBuilder()).append("onCreateView - numColumns set to ").append(i).toString());
                Log.d("PhotoSelectorGridFragment", (new StringBuilder()).append("onCreateView - columnWidth set to ").append(j).toString());
            }
        }
    }
}
