// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.DialogInterface;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements android.content.lListener
{

    final VideoPlayerActivity this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        finish();
    }

    Listener()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
