// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.MenuItem;
import com.groupon.util.GrouponDialogFragment;

// Referenced classes of package com.groupon.activity:
//            BugReport

class gment
    implements android.view.enuItemClickListener
{

    final BugReport this$0;
    final GrouponDialogFragment val$dialogFragment;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        if (valid())
        {
            GrouponDialogFragment.show(getFragmentManager(), val$dialogFragment, "report_a_bug_thanks_dialog");
        }
        return false;
    }

    gment()
    {
        this$0 = final_bugreport;
        val$dialogFragment = GrouponDialogFragment.this;
        super();
    }
}
