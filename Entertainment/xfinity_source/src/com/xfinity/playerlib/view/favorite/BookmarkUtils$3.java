// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import android.content.DialogInterface;

// Referenced classes of package com.xfinity.playerlib.view.favorite:
//            BookmarkUtils

class this._cls0
    implements android.content.OnClickListener
{

    final BookmarkUtils this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }

    _cls9()
    {
        this$0 = BookmarkUtils.this;
        super();
    }
}
