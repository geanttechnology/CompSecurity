// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.buttons;

import com.amazon.retailsearch.android.ui.cart.CartStateListener;
import com.amazon.retailsearch.util.Utils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class AddToCartState
{

    public static final int ADDED = 1;
    public static final int IN_PROGRESS = 2;
    public static final int NONE = 0;
    private boolean isUpdated;
    private String itemId;
    private final Set listeners = Collections.newSetFromMap(new WeakHashMap());
    private int quantity;
    private int state;
    private int stockOnHand;

    public AddToCartState()
    {
        isUpdated = false;
        state = 0;
        quantity = 0;
        itemId = null;
        stockOnHand = 0;
    }

    public void addListener(CartStateListener cartstatelistener)
    {
        if (cartstatelistener == null)
        {
            return;
        } else
        {
            listeners.add(cartstatelistener);
            return;
        }
    }

    public void asyncUpdate(int i, String s, int j)
    {
        isUpdated = true;
        if (quantity != i && !Utils.isEmpty(listeners))
        {
            for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((CartStateListener)iterator.next()).onQuantityUpdated(i)) { }
        }
        quantity = i;
        itemId = s;
        stockOnHand = j;
    }

    public String getItemId()
    {
        return itemId;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getState()
    {
        return state;
    }

    public int getStockOnHand()
    {
        return stockOnHand;
    }

    public boolean isUpdated()
    {
        return isUpdated;
    }

    public void removeListener(CartStateListener cartstatelistener)
    {
        if (cartstatelistener == null)
        {
            return;
        } else
        {
            listeners.remove(cartstatelistener);
            return;
        }
    }

    public void reset()
    {
        reset(0);
    }

    public void reset(int i)
    {
        update(i, null, 0);
    }

    public void setIsUpdated(boolean flag)
    {
        isUpdated = flag;
    }

    public void setState(int i)
    {
        if (i != state) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j = state;
        state = i;
        if (!Utils.isEmpty(listeners))
        {
            Iterator iterator = listeners.iterator();
            while (iterator.hasNext()) 
            {
                ((CartStateListener)iterator.next()).onStateChange(j);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void update(int i, String s, int j)
    {
        asyncUpdate(i, s, j);
        if (i > 0)
        {
            setState(1);
            return;
        } else
        {
            setState(0);
            return;
        }
    }
}
