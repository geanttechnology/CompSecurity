// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import com.aviary.android.feather.library.content.ToolEntry;

// Referenced classes of package com.aviary.android.feather.sdk:
//            FeatherActivity, AviaryMainController

class val.tag
    implements Runnable
{

    final FeatherActivity this$0;
    final Object val$tag;

    public void run()
    {
        mMainController.activateTool((ToolEntry)val$tag);
    }

    r()
    {
        this$0 = final_featheractivity;
        val$tag = Object.this;
        super();
    }
}
