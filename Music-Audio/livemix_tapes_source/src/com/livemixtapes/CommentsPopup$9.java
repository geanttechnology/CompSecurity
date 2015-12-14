// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;
import android.widget.PopupWindow;

// Referenced classes of package com.livemixtapes:
//            CommentsPopup

class val.popupWindow
    implements android.view.ener
{

    final CommentsPopup this$0;
    private final PopupWindow val$popupWindow;

    public void onClick(View view)
    {
        val$popupWindow.dismiss();
        shareSocialNetworks("com.tumblr");
    }

    ()
    {
        this$0 = final_commentspopup;
        val$popupWindow = PopupWindow.this;
        super();
    }
}
