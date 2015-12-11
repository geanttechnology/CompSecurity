// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.DialogInterface;
import android.webkit.JsResult;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AvatarBuilderActivity

class val.result
    implements android.content.istener
{

    final AvatarBuilderActivity this$0;
    final JsResult val$result;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        val$result.cancel();
    }

    ()
    {
        this$0 = final_avatarbuilderactivity;
        val$result = JsResult.this;
        super();
    }
}
