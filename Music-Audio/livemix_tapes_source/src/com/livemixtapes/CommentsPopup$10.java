// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.PopupWindow;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            CommentsPopup

class val.popupWindow
    implements android.view.ner
{

    final CommentsPopup this$0;
    private final PopupWindow val$popupWindow;

    public void onClick(View view)
    {
        val$popupWindow.dismiss();
        ((ClipboardManager)mActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", (String)mixtape.get("sharetext")));
    }

    ()
    {
        this$0 = final_commentspopup;
        val$popupWindow = PopupWindow.this;
        super();
    }
}
