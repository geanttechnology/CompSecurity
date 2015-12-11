// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.view.View;
import android.widget.AdapterView;
import com.comcast.cim.cmasl.utils.CommonUtils;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            MultiDeleteBrowseFragment

class tItemClickListener
    implements android.widget.ner
{

    final MultiDeleteBrowseFragment this$0;
    emClickListener wrappedItemClickListener;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!MultiDeleteBrowseFragment.access$700(MultiDeleteBrowseFragment.this))
        {
            MultiDeleteBrowseFragment.access$800(MultiDeleteBrowseFragment.this);
            adapterview = ((AdapterView) (CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i))));
            if (inBabyGuideMode && adapterview == null)
            {
                return;
            } else
            {
                wrappedItemClickListener.onItemClicked(adapterview);
                return;
            }
        } else
        {
            MultiDeleteBrowseFragment.access$900(MultiDeleteBrowseFragment.this);
            return;
        }
    }

    emClickListener()
    {
        this$0 = MultiDeleteBrowseFragment.this;
        super();
        wrappedItemClickListener = getItemClickListener();
    }
}
