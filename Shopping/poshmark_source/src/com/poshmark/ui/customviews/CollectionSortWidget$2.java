// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.View;
import com.poshmark.utils.CollectionSortWidgetListener;

// Referenced classes of package com.poshmark.ui.customviews:
//            CollectionSortWidget

class this._cls0
    implements android.view.onSortWidget._cls2
{

    final CollectionSortWidget this$0;

    public void onClick(View view)
    {
        if (listener != null)
        {
            if (currentActiveButton != null)
            {
                CollectionSortWidget.access$000(CollectionSortWidget.this, currentActiveButton);
            }
            currentActiveButton = centerButton;
            CollectionSortWidget.access$100(CollectionSortWidget.this, currentActiveButton);
            listener.sortWidgetClicked((rtType)view.getTag());
        }
    }

    rtType()
    {
        this$0 = CollectionSortWidget.this;
        super();
    }
}
