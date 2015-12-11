// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.DialogInterface;

// Referenced classes of package com.poshmark.utils:
//            ListingManager

class this._cls0
    implements android.content.nClickListener
{

    final ListingManager this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            ListingManager.access$000(ListingManager.this);
            return;
        } else
        {
            currentSentImageIndex = 0;
            return;
        }
    }

    ickListener()
    {
        this$0 = ListingManager.this;
        super();
    }
}
