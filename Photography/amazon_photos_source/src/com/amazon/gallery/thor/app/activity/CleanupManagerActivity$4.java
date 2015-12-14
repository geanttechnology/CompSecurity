// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.framework.gallery.widget.MediaItemListAdapter;
import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;
import com.amazon.gallery.thor.app.ui.cab.CleanupManagerActivityContextBar;
import com.amazon.gallery.thor.cleanupmanager.CleanupManagerDialogHelper;
import com.amazon.gallery.thor.cleanupmanager.DeduplicationHelper;
import org.apache.commons.io.FileUtils;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            CleanupManagerActivity, AndroidToolbar

class this._cls0
    implements android.support.v7.widget.stener
{

    final CleanupManagerActivity this$0;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        case 2131493434: 
        default:
            return false;

        case 2131493435: 
            CleanupManagerActivity.access$400(CleanupManagerActivity.this).getToolbar().getMenu().findItem(0x7f0c023f).setTitle((new StringBuilder()).append(getString(0x7f0e007c)).append(" ( ").append(FileUtils.byteCountToDisplaySize(CleanupManagerActivity.access$300(CleanupManagerActivity.this).getTotalDupesFileSize())).append(" )").toString());
            return true;

        case 2131493436: 
            CleanupManagerActivity.access$500(CleanupManagerActivity.this, 0x1f400000L);
            CleanupManagerActivity.access$600(CleanupManagerActivity.this).trackEvent(tricsEvent.CleanupActivitySelect500Mb);
            return true;

        case 2131493437: 
            CleanupManagerActivity.access$500(CleanupManagerActivity.this, 0x40000000L);
            CleanupManagerActivity.access$600(CleanupManagerActivity.this).trackEvent(tricsEvent.CleanupActivitySelect1Gb);
            return true;

        case 2131493438: 
            CleanupManagerActivity.access$500(CleanupManagerActivity.this, 0x80000000L);
            CleanupManagerActivity.access$600(CleanupManagerActivity.this).trackEvent(tricsEvent.CleanupActivitySelect2Gb);
            return true;

        case 2131493439: 
            CleanupManagerActivity.access$200(CleanupManagerActivity.this).addAll(CleanupManagerActivity.access$100(CleanupManagerActivity.this).getItems());
            GlobalMessagingBus.post(new MultiSelectModeCommand(true, com.amazon.gallery.foundation.utils.messaging.tranceType.TAP));
            CleanupManagerActivity.access$700(CleanupManagerActivity.this).notifyDataSetChanged();
            CleanupManagerActivity.access$600(CleanupManagerActivity.this).trackEvent(tricsEvent.CleanupActivitySelectAll);
            return true;

        case 2131493433: 
            CleanupManagerActivity.access$800(CleanupManagerActivity.this).showInstructionDialog(CleanupManagerActivity.access$300(CleanupManagerActivity.this).isNoDupesFound());
            CleanupManagerActivity.access$600(CleanupManagerActivity.this).trackEvent(tricsEvent.CleanupActivityInfoExecuted);
            return true;
        }
    }

    per()
    {
        this$0 = CleanupManagerActivity.this;
        super();
    }
}
