// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import co.vine.android.api.VinePrivateMessage;
import co.vine.android.service.VineUploadService;

// Referenced classes of package co.vine.android:
//            ConversationAdapter

class val.v
    implements Runnable
{

    final ConversationAdapter this$0;
    final View val$v;
    final VinePrivateMessage val$vpm;

    public void run()
    {
        ConversationAdapter.access$1200(ConversationAdapter.this).startService(VineUploadService.getVMPostIntent(ConversationAdapter.access$1100(ConversationAdapter.this), val$vpm.uploadPath, true, val$vpm.messageRowId, val$vpm.conversationRowId, null, val$vpm.message, val$vpm.postId, val$vpm.videoUrl, val$vpm.thumbnailUrl, val$vpm.maxLoops));
        ViewGroup viewgroup = (ViewGroup)val$v.getParent();
        View view1 = viewgroup.findViewById(0x7f0a013e);
        View view = view1;
        if (view1 == null)
        {
            view = viewgroup.findViewById(0x7f0a0143);
        }
        if (view != null)
        {
            view.setVisibility(0);
            val$v.setVisibility(4);
        }
    }

    ()
    {
        this$0 = final_conversationadapter;
        val$vpm = vineprivatemessage;
        val$v = View.this;
        super();
    }
}
