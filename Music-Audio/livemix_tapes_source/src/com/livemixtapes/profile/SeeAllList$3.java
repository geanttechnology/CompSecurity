// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.livemixtapes.profile:
//            SeeAllList

class this._cls0
    implements android.view.istener
{

    final SeeAllList this$0;

    public void onClick(View view)
    {
        view = SeeAllList.this;
        boolean flag;
        if (isEditableMode)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        view.isEditableMode = flag;
        if (isEditableMode)
        {
            textViewAction.setText("Done");
        } else
        {
            textViewAction.setText("Edit");
        }
        adapter.notifyDataSetChanged();
    }

    ayListAdapter()
    {
        this$0 = SeeAllList.this;
        super();
    }
}
