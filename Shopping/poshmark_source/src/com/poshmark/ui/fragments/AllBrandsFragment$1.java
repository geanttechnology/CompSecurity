// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.ContentResolver;
import android.content.Context;
import android.view.View;
import com.poshmark.application.PMApplication;
import com.poshmark.db.PMDbContentProvider;

// Referenced classes of package com.poshmark.ui.fragments:
//            AllBrandsFragment

class this._cls0
    implements android.view.
{

    final AllBrandsFragment this$0;

    public void onClick(View view)
    {
        PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_BRANDS, null, null);
    }

    ()
    {
        this$0 = AllBrandsFragment.this;
        super();
    }
}
