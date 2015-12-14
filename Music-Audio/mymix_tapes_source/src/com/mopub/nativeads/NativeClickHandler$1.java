// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;

// Referenced classes of package com.mopub.nativeads:
//            NativeClickHandler, ClickInterface

class val.clickInterface
    implements android.view.dler._cls1
{

    final NativeClickHandler this$0;
    final ClickInterface val$clickInterface;

    public void onClick(View view)
    {
        val$clickInterface.handleClick(view);
    }

    ()
    {
        this$0 = final_nativeclickhandler;
        val$clickInterface = ClickInterface.this;
        super();
    }
}
