// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.view.View;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.tags.TagType;

// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            NoAlbumsFragment

class this._cls0
    implements android.view.r
{

    final NoAlbumsFragment this$0;

    public void onClick(View view)
    {
        startActivity(IntentUtil.getCollectionListIntent(TagType.FOLDER));
    }

    A()
    {
        this$0 = NoAlbumsFragment.this;
        super();
    }
}
