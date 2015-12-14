// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.amazon.gallery.thor.folders.FoldersAdapter;
import java.util.Collections;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            FoldersActivity

class this._cls0
    implements android.view.er
{

    final FoldersActivity this$0;

    public void onClick(View view)
    {
        view = (View)view.getParent();
        int i = FoldersActivity.access$200(FoldersActivity.this).getChildAdapterPosition(view);
        view = FoldersActivity.access$300(FoldersActivity.this).getFolderForPosition(i);
        FoldersActivity.access$500(FoldersActivity.this, Collections.singletonList(view));
    }

    ()
    {
        this$0 = FoldersActivity.this;
        super();
    }
}
