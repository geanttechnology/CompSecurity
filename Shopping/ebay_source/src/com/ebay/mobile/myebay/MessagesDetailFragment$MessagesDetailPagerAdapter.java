// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import com.ebay.nautilus.domain.content.dm.MessagesUtils;
import com.ebay.nautilus.domain.data.EbayMessage;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesDetailFragment, MessageFragment

private class messages extends FragmentStatePagerAdapter
{

    private final List messages;
    final MessagesDetailFragment this$0;

    public int getCount()
    {
        if (messages != null)
        {
            return messages.size();
        } else
        {
            return 0;
        }
    }

    public Fragment getItem(int i)
    {
        MessageFragment messagefragment = new MessageFragment();
        Bundle bundle = new Bundle();
        if (messages != null && i < messages.size())
        {
            EbayMessage ebaymessage = (EbayMessage)messages.get(i);
            bundle.putParcelable("com.ebay.mobile.param.message", ebaymessage);
            if (ebaymessage.equals(MessagesDetailFragment.access$100(MessagesDetailFragment.this)) && MessagesDetailFragment.access$600() != null)
            {
                bundle.putBundle("com.ebay.mobile.param.webview.state", MessagesDetailFragment.access$600());
                Bundle _tmp = MessagesDetailFragment.access$602(null);
            }
        }
        messagefragment.setArguments(bundle);
        messagefragment.setOnSaveMessageFragmentStateListener(MessagesDetailFragment.this);
        return messagefragment;
    }

    public boolean updateMessages(List list)
    {
        return MessagesUtils.updateAll(list, messages);
    }

    public (FragmentManager fragmentmanager, List list)
    {
        this$0 = MessagesDetailFragment.this;
        super(fragmentmanager);
        messages = new ArrayList(list);
    }
}
