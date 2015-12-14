// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.view.View;
import com.amazon.gallery.thor.app.ui.cab.TagContextBar;
import java.util.ArrayList;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            FoldersActivity

class this._cls0
    implements android.view.er
{

    final FoldersActivity this$0;

    public void onClick(View view)
    {
        view = new ArrayList(((TagContextBar)FoldersActivity.access$000(FoldersActivity.this)).getSelectables());
        FoldersActivity.access$500(FoldersActivity.this, view);
    }

    ()
    {
        this$0 = FoldersActivity.this;
        super();
    }
}
