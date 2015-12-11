// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.view.MenuItem;
import java.util.Map;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatViewManager, BoldChatSession

class val.brandings
    implements Runnable
{

    final BoldChatViewManager this$0;
    final Map val$brandings;

    public void run()
    {
        if (val$brandings != null && BoldChatViewManager.access$100(BoldChatViewManager.this) != null)
        {
            BoldChatViewManager.access$100(BoldChatViewManager.this).setTitle(BoldChatSession.getBranding("api#chat#end", val$brandings, BoldChatViewManager.access$200(BoldChatViewManager.this)));
        }
    }

    ()
    {
        this$0 = final_boldchatviewmanager;
        val$brandings = Map.this;
        super();
    }
}
