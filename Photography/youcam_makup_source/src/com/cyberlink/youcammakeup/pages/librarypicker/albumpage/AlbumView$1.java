// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.albumpage;

import android.view.View;
import android.widget.AdapterView;
import com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.albumpage:
//            AlbumView, c, a

class a
    implements android.widget.OnItemClickListener
{

    final AlbumView a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        l = AlbumView.a(a).a(i).e();
        AlbumView.b(a).a(l);
    }

    (AlbumView albumview)
    {
        a = albumview;
        super();
    }
}
