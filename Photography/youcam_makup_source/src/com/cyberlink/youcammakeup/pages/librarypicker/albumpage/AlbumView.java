// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.albumpage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.albumpage:
//            c, a

public class AlbumView extends ListView
{

    private LibraryViewFragment a;
    private c b;

    public AlbumView(Context context)
    {
        super(context);
    }

    public AlbumView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public AlbumView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static c a(AlbumView albumview)
    {
        return albumview.b;
    }

    static LibraryViewFragment b(AlbumView albumview)
    {
        return albumview.a;
    }

    public void a()
    {
        if (b != null)
        {
            b.a();
        }
    }

    public void a(Context context)
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            b = new c(context);
            setAdapter(b);
            setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final AlbumView a;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    l = AlbumView.a(a).a(i).e();
                    AlbumView.b(a).a(l);
                }

            
            {
                a = AlbumView.this;
                super();
            }
            });
            return;
        }
    }

    public void setLibraryViewFragment(LibraryViewFragment libraryviewfragment)
    {
        a = libraryviewfragment;
    }
}
