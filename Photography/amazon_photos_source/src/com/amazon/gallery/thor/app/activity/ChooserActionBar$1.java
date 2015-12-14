// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.view.View;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ChooserActionBar

class this._cls0
    implements android.view.r
{

    final ChooserActionBar this$0;

    public void onClick(View view)
    {
        ChooserActionBar.access$000(ChooserActionBar.this).onBackPressed();
    }

    ()
    {
        this$0 = ChooserActionBar.this;
        super();
    }
}
