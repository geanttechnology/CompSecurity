// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.content.DialogInterface;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedback

class this._cls0
    implements android.content..OnClickListener
{

    final UserFeedback this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }

    ()
    {
        this$0 = UserFeedback.this;
        super();
    }
}
