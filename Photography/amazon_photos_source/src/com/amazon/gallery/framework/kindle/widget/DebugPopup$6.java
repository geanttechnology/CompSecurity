// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import android.content.DialogInterface;
import java.util.ArrayList;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget:
//            DebugPopup

class this._cls0
    implements android.content.ce.OnClickListener
{

    final DebugPopup this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        ((nuEntry)DebugPopup.access$100().get(i)).showSubMenu(context);
    }

    nuEntry()
    {
        this$0 = DebugPopup.this;
        super();
    }
}
