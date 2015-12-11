// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.content.DialogInterface;

// Referenced classes of package com.ebay.mobile.photomanager:
//            PhotoManagerView, PhotoManagerViewAdapter

class index
    implements android.content.lickListener
{

    int index;
    final PhotoManagerView this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i != -1 || PhotoManagerView.access$100(PhotoManagerView.this) == null)
        {
            return;
        } else
        {
            PhotoManagerView.access$100(PhotoManagerView.this).remove(index);
            invalidateViews();
            return;
        }
    }

    (int i)
    {
        this$0 = PhotoManagerView.this;
        super();
        index = i;
    }
}
