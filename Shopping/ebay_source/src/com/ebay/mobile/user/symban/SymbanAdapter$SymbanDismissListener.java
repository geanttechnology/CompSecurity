// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import android.widget.ListView;
import com.ebay.nautilus.domain.data.SymbanNotification;
import java.util.HashSet;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanAdapter

private class <init>
    implements com.ebay.mobile.widget.smissCallbacks
{

    final SymbanAdapter this$0;

    public boolean canDismiss(int i)
    {
        return true;
    }

    public void onDismiss(ListView listview, int i)
    {
        if (i < getCount())
        {
            listview = (SymbanNotification)getItem(i);
        } else
        {
            listview = null;
        }
        if (listview != null)
        {
            String s = listview.getNotificationId();
            if (!dismissItems.contains(s))
            {
                dismissItems.add(s);
                if (itemDismissedListener != null)
                {
                    itemDismissedListener.onItemDismissed(listview);
                }
            }
        }
    }

    public void onUndismiss(ListView listview, int i)
    {
        if (i < getCount())
        {
            listview = (SymbanNotification)getItem(i);
        } else
        {
            listview = null;
        }
        if (listview != null)
        {
            String s = listview.getNotificationId();
            if (dismissItems.contains(s))
            {
                removeFromDismissList(listview);
            }
        }
    }

    private r()
    {
        this$0 = SymbanAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
