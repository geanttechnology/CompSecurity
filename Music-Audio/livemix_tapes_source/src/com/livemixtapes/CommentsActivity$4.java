// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.widget.AbsListView;

// Referenced classes of package com.livemixtapes:
//            CommentsActivity

class this._cls0
    implements android.widget.lListener
{

    final CommentsActivity this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        while (stop_loading || i + j != k || k == 0 || flag_loading) 
        {
            return;
        }
        flag_loading = true;
        (new ONParse(CommentsActivity.this, null)).execute(new String[] {
            lastSavedCommentTimestamp
        });
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    ONParse()
    {
        this$0 = CommentsActivity.this;
        super();
    }
}
