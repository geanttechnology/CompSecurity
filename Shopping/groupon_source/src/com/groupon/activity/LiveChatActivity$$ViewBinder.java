// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.boldchat.sdk.BoldChatView;

// Referenced classes of package com.groupon.activity:
//            LiveChatActivity, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (LiveChatActivity)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, LiveChatActivity livechatactivity, Object obj)
    {
        super.ind(ewbinder, livechatactivity, obj);
        livechatactivity.boldChatView = (BoldChatView)ewbinder.dChatView((View)ewbinder.edView(obj, 0x7f1003d7, "field 'boldChatView'"), 0x7f1003d7, "field 'boldChatView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (LiveChatActivity)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((LiveChatActivity)grouponactivity);
    }

    public void unbind(LiveChatActivity livechatactivity)
    {
        super.nbind(livechatactivity);
        livechatactivity.boldChatView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((LiveChatActivity)obj);
    }

    public ()
    {
    }
}
