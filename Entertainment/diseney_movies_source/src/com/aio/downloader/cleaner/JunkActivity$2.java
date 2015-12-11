// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.util.Log;
import com.xiaos.adapter.PinnedHeaderExpandableAdapter;

// Referenced classes of package com.aio.downloader.cleaner:
//            JunkActivity

class this._cls0
    implements com.xiaos.adapter.andableAdapter.GroupCheckListener
{

    final JunkActivity this$0;

    public void ClickGroupCheckBox(int i)
    {
        JunkActivity.access$53(JunkActivity.this, i);
        Log.e("fff", (new StringBuilder("2num")).append(JunkActivity.access$54(JunkActivity.this)).toString());
        if (JunkActivity.access$54(JunkActivity.this) != 0)
        {
            JunkActivity.access$52(JunkActivity.this).notifyDataSetChanged();
            JunkActivity.access$53(JunkActivity.this, 0);
        }
    }

    apter()
    {
        this$0 = JunkActivity.this;
        super();
    }
}
