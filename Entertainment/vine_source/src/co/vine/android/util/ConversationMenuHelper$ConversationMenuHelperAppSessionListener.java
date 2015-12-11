// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import co.vine.android.BaseControllerActionBarActivity;
import co.vine.android.ConversationActivity;
import co.vine.android.FriendSearchAdapter;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android.util:
//            ConversationMenuHelper

public class this._cls0 extends AppSessionListener
{

    final ConversationMenuHelper this$0;

    public void onGetConversationRowIdComplete(long l, long l1, String s, boolean flag)
    {
        if (l == ConversationMenuHelper.access$600(ConversationMenuHelper.this) || l == ConversationMenuHelper.access$700(ConversationMenuHelper.this))
        {
            if (l == ConversationMenuHelper.access$700(ConversationMenuHelper.this))
            {
                toggleContactSearch(false);
            }
            ConversationMenuHelper.access$602(ConversationMenuHelper.this, -1L);
            ConversationMenuHelper.access$800(ConversationMenuHelper.this).clearUnreadMessageCount(l1);
            ConversationMenuHelper.access$300(ConversationMenuHelper.this).startActivity(ConversationActivity.getIntent(ConversationMenuHelper.access$300(ConversationMenuHelper.this), l1, s, l, flag, false));
        }
    }

    public void onGetFriendsTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
    {
        showSearchProgressBar(false);
        if (arraylist != null && ConversationMenuHelper.access$900(ConversationMenuHelper.this))
        {
            ConversationMenuHelper.access$1100(ConversationMenuHelper.this, arraylist);
        }
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        if (ConversationMenuHelper.access$900(ConversationMenuHelper.this) && ConversationMenuHelper.access$1000(ConversationMenuHelper.this) != null)
        {
            ConversationMenuHelper.access$1000(ConversationMenuHelper.this).setUserImages(hashmap);
        }
    }

    public ()
    {
        this$0 = ConversationMenuHelper.this;
        super();
    }
}
