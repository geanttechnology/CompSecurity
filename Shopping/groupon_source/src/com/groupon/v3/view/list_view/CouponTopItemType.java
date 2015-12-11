// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.list_view;

import com.groupon.view.widgetcards.CouponTopItem;
import java.util.ArrayList;

// Referenced classes of package com.groupon.v3.view.list_view:
//            GenericListItemType

public class CouponTopItemType extends GenericListItemType
{
    public static final class ItemType extends Enum
    {

        private static final ItemType $VALUES[];
        public static final ItemType NEARBY;
        public static final ItemType TOP_CATEGORY;
        public static final ItemType TOP_MERCHANT;

        public static ItemType valueOf(String s)
        {
            return (ItemType)Enum.valueOf(com/groupon/v3/view/list_view/CouponTopItemType$ItemType, s);
        }

        public static ItemType[] values()
        {
            return (ItemType[])$VALUES.clone();
        }

        static 
        {
            NEARBY = new ItemType("NEARBY", 0);
            TOP_MERCHANT = new ItemType("TOP_MERCHANT", 1);
            TOP_CATEGORY = new ItemType("TOP_CATEGORY", 2);
            $VALUES = (new ItemType[] {
                NEARBY, TOP_MERCHANT, TOP_CATEGORY
            });
        }

        private ItemType(String s, int i)
        {
            super(s, i);
        }
    }


    private static int itemCountMax = 3;
    protected ArrayList items;
    protected int position;

    public CouponTopItemType(ItemType itemtype, int i)
    {
        super(itemtype);
        items = new ArrayList();
        position = i;
    }

    public boolean addItem(CouponTopItem coupontopitem)
    {
        boolean flag = false;
        if (items.size() < itemCountMax)
        {
            items.add(coupontopitem);
            flag = true;
        }
        return flag;
    }

    public ArrayList getItems()
    {
        return items;
    }

    public int getPosition()
    {
        return position;
    }

}
