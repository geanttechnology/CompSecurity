// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessageFragment, PhotoGalleryFragment

class val.pictureUrls
    implements android.view.er
{

    final MessageFragment this$0;
    final ArrayList val$pictureUrls;

    public void onClick(View view)
    {
        view = (String)view.getTag();
        PhotoGalleryFragment.newInstance(val$pictureUrls, view).show(getFragmentManager(), null);
    }

    nt()
    {
        this$0 = final_messagefragment;
        val$pictureUrls = ArrayList.this;
        super();
    }
}
