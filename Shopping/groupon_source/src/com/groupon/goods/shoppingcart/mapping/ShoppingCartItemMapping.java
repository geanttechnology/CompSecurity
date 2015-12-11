// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.mapping;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.groupon.goods.shoppingcart.event.ShoppingCartItemEditModeToggledEvent;
import com.groupon.goods.shoppingcart.v3.FixedMapping;
import com.groupon.models.shoppingCart.ShoppingCartItem;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.squareup.otto.Bus;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.groupon.goods.shoppingcart.mapping:
//            ShoppingCartItemViewHolder

public class ShoppingCartItemMapping extends FixedMapping
{

    private static final String EDIT_ITEMS = "EDIT_ITEMS";
    private final Bus bus;
    private final Set editItems = new HashSet();

    public ShoppingCartItemMapping(Bus bus1)
    {
        super(com/groupon/models/shoppingCart/ShoppingCartItem);
        bus = bus1;
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (ShoppingCartItem)universallistadapter.getItem(i);
        bindView(i, (ShoppingCartItemViewHolder)viewholder, ((ShoppingCartItem) (universallistadapter)));
    }

    public void bindView(int i, ShoppingCartItemViewHolder shoppingcartitemviewholder, ShoppingCartItem shoppingcartitem)
    {
        shoppingcartitemviewholder.bind(i, shoppingcartitem, editItems.contains(Integer.valueOf(shoppingcartitem.hashCode())));
    }

    public View createView(Context context)
    {
        throw new RuntimeException();
    }

    public View createView(Context context, ViewGroup viewgroup)
    {
        return LayoutInflater.from(context).inflate(0x7f030147, viewgroup, false);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, ViewGroup viewgroup)
    {
        context = createView(context, viewgroup);
        viewgroup = new ShoppingCartItemViewHolder(context);
        context.setTag(viewgroup);
        return viewgroup;
    }

    public void onEditModeToggled(ShoppingCartItemEditModeToggledEvent shoppingcartitemeditmodetoggledevent)
    {
        int i = shoppingcartitemeditmodetoggledevent.item.hashCode();
        if (editItems.contains(Integer.valueOf(i)))
        {
            editItems.remove(Integer.valueOf(i));
            return;
        } else
        {
            editItems.add(Integer.valueOf(i));
            return;
        }
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            if ((bundle = (Set)bundle.getSerializable("EDIT_ITEMS")) != null && !bundle.isEmpty())
            {
                editItems.addAll(bundle);
                return;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putSerializable("EDIT_ITEMS", (Serializable)editItems);
    }

    public void register()
    {
        bus.register(this);
    }

    public void setEditMode(ShoppingCartItem shoppingcartitem, boolean flag)
    {
        int i = shoppingcartitem.hashCode();
        if (flag)
        {
            editItems.add(Integer.valueOf(i));
            return;
        } else
        {
            editItems.remove(Integer.valueOf(i));
            return;
        }
    }

    public void unregister()
    {
        bus.unregister(this);
    }
}
