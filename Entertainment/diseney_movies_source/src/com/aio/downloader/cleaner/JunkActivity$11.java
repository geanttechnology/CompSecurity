// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.DialogInterface;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.xiaos.adapter.PinnedHeaderExpandableAdapter;
import com.xiaos.view.PinnedHeaderExpandableListView;

// Referenced classes of package com.aio.downloader.cleaner:
//            JunkActivity

class this._cls0
    implements android.content.OnClickListener
{

    final JunkActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        JunkActivity.access$42(JunkActivity.this).setVisibility(8);
        JunkActivity.access$43(JunkActivity.this).setVisibility(0);
        JunkActivity.access$1(JunkActivity.this).setVisibility(8);
        JunkActivity.access$2(JunkActivity.this).setVisibility(0);
        JunkActivity.access$17(JunkActivity.this).setVisibility(8);
        JunkActivity.access$18(JunkActivity.this).setVisibility(0);
        JunkActivity.access$28(JunkActivity.this).setVisibility(8);
        JunkActivity.access$29(JunkActivity.this).setVisibility(0);
        JunkActivity.access$37(JunkActivity.this).setVisibility(8);
        JunkActivity.access$38(JunkActivity.this).setVisibility(0);
        sticky_content.setVisibility(8);
        JunkActivity.access$46(JunkActivity.this).setVisibility(0);
        JunkActivity.access$51(JunkActivity.this, new PinnedHeaderExpandableAdapter(JunkActivity.access$47(JunkActivity.this), JunkActivity.access$16(JunkActivity.this), JunkActivity.access$33(JunkActivity.this), JunkActivity.access$26(JunkActivity.this), JunkActivity.access$48(JunkActivity.this), getApplicationContext(), JunkActivity.access$49(JunkActivity.this), JunkActivity.access$45(JunkActivity.this), JunkActivity.access$50(JunkActivity.this)));
        JunkActivity.access$49(JunkActivity.this).setAdapter(JunkActivity.access$52(JunkActivity.this));
    }

    ew()
    {
        this$0 = JunkActivity.this;
        super();
    }
}
