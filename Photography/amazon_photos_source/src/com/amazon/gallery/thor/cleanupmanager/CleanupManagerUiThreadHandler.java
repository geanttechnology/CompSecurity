// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cleanupmanager;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;
import com.amazon.gallery.thor.app.activity.CleanupManagerActivity;
import java.lang.ref.WeakReference;

// Referenced classes of package com.amazon.gallery.thor.cleanupmanager:
//            CleanupManagerDialogHelper

public class CleanupManagerUiThreadHandler extends Handler
{

    private final WeakReference activityWeakReference;

    public CleanupManagerUiThreadHandler(CleanupManagerActivity cleanupmanageractivity)
    {
        activityWeakReference = new WeakReference(cleanupmanageractivity);
    }

    public void handleMessage(Message message)
    {
        if (activityWeakReference.get() != null)
        {
            CleanupManagerActivity cleanupmanageractivity = (CleanupManagerActivity)activityWeakReference.get();
            ProgressBar progressbar;
            switch (message.what)
            {
            default:
                super.handleMessage(message);
                return;

            case 0: // '\0'
                cleanupmanageractivity.getRecyclerAdapter().notifyDataSetChanged();
                return;

            case 1: // '\001'
                cleanupmanageractivity.getDialogHelper().showNoDupesFoundDialog();
                return;

            case 2: // '\002'
                cleanupmanageractivity.updateActionBar();
                return;

            case 3: // '\003'
                progressbar = (ProgressBar)cleanupmanageractivity.findViewById(0x7f0c0116);
                break;
            }
            progressbar.setProgress(((Integer)message.obj).intValue());
            if (progressbar.getProgress() == progressbar.getMax())
            {
                cleanupmanageractivity.findViewById(0x7f0c0115).setVisibility(8);
                return;
            }
        }
    }

    public void sendNoDupesFoundMessage()
    {
        sendMessage(Message.obtain(this, 1));
    }

    public void sendRefreshViewMessage()
    {
        sendMessage(Message.obtain(this, 0));
    }

    public void sendUpdateProgressBarMessage(long l)
    {
        sendMessage(Message.obtain(this, 3, Integer.valueOf((int)l)));
    }

    public void sendUpdateSelectSortInActionBarMessage()
    {
        sendMessage(Message.obtain(this, 2));
    }
}
