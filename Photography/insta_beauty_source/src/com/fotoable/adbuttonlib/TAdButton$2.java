// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.view.View;
import any;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdButton, TAdItem

class this._cls0
    implements android.view.Listener
{

    final TAdButton this$0;

    public void onClick(View view)
    {
        if (TAdButton.access$200(TAdButton.this) != null && TAdButton.access$200(TAdButton.this).madId.equalsIgnoreCase(TAdButton.TAG_Native) && TAdButton.access$300(TAdButton.this) != null && TAdButton.access$300(TAdButton.this).nativeItem != null)
        {
            TAdButton.access$300(TAdButton.this).nativeItem.b(TAdButton.this);
        }
    }

    toNativeIcon()
    {
        this$0 = TAdButton.this;
        super();
    }
}
