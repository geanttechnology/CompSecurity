// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import com.groupon.view.LiveChatView;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class LiveChatViewHolder extends RecyclerItemViewHolder
{

    LiveChatView liveChatView;

    public LiveChatViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        liveChatView.updateLiveChatSection(true);
    }
}
