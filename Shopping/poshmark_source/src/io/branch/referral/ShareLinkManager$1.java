// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.AdapterView;
import java.util.List;

// Referenced classes of package io.branch.referral:
//            ShareLinkManager, AnimatedDialog

class ooserArrayAdapter
    implements android.widget.lickListener
{

    final ShareLinkManager this$0;
    final ooserArrayAdapter val$adapter;
    final List val$matchingApps;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (view.getTag() instanceof reShareItem)
        {
            ShareLinkManager.access$302(ShareLinkManager.this, val$matchingApps);
            val$adapter.notifyDataSetChanged();
        } else
        {
            if (callback_ != null)
            {
                callback_.onChannelSelected(((ResolveInfo)view.getTag()).loadLabel(context_.getPackageManager()).toString());
            }
            val$adapter.selectedPos = i;
            val$adapter.notifyDataSetChanged();
            ShareLinkManager.access$400(ShareLinkManager.this, (ResolveInfo)view.getTag());
            if (shareDlg_ != null)
            {
                shareDlg_.cancel();
                return;
            }
        }
    }

    ooserArrayAdapter()
    {
        this$0 = final_sharelinkmanager;
        val$matchingApps = list;
        val$adapter = ooserArrayAdapter.this;
        super();
    }
}
