// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.DialogInterface;
import android.os.Bundle;

// Referenced classes of package com.groupon.util:
//            GrouponDialogFragment, GrouponDialogListener

class this._cls0
    implements android.content.istener
{

    final GrouponDialogFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        GrouponDialogListener groupondialoglistener = getListener();
        if (groupondialoglistener != null)
        {
            groupondialoglistener.onDialogItemClick(getArguments().getString("dialog_tag", null), dialoginterface, i);
        }
    }

    stener()
    {
        this$0 = GrouponDialogFragment.this;
        super();
    }
}
