// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Dialog;
import android.view.View;
import android.view.Window;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            CreateAlbumDialog

class this._cls0
    implements android.view.stener
{

    final CreateAlbumDialog this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            CreateAlbumDialog.access$100(CreateAlbumDialog.this).getWindow().setSoftInputMode(5);
        }
    }

    ()
    {
        this$0 = CreateAlbumDialog.this;
        super();
    }
}
