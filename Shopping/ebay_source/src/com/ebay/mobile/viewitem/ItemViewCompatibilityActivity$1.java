// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.text.TextUtils;
import android.view.View;
import com.ebay.mobile.Item;
import com.ebay.mobile.Vehicle;
import com.ebay.nautilus.domain.data.ItemCompatibilty;
import com.ebay.nautilus.domain.data.NameValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewCompatibilityActivity, ItemViewCompatibilityLeafActivity

class val.value
    implements android.view.yActivity._cls1
{

    final ItemViewCompatibilityActivity this$0;
    final String val$value;

    public void onClick(View view)
    {
        ItemViewCompatibilityActivity.access$000(ItemViewCompatibilityActivity.this).add(val$value);
        if (!ItemViewCompatibilityActivity.access$100(ItemViewCompatibilityActivity.this))
        {
            view = new Vehicle();
            Iterator iterator = item.itemCompatibiltyList.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ItemCompatibilty itemcompatibilty = (ItemCompatibilty)iterator.next();
                if (!itemcompatibilty.matches(ItemViewCompatibilityActivity.access$200(ItemViewCompatibilityActivity.this), ItemViewCompatibilityActivity.access$000(ItemViewCompatibilityActivity.this)))
                {
                    continue;
                }
                for (Iterator iterator1 = itemcompatibilty.nameValueList.iterator(); iterator1.hasNext();)
                {
                    Object obj = (NameValue)iterator1.next();
                    String s = ((NameValue) (obj)).getName();
                    obj = ((NameValue) (obj)).getValue();
                    if (!TextUtils.isEmpty(val$value))
                    {
                        Iterator iterator2 = ItemViewCompatibilityActivity.access$200(ItemViewCompatibilityActivity.this).iterator();
                        while (iterator2.hasNext()) 
                        {
                            String s1 = (String)iterator2.next();
                            if (s1.equalsIgnoreCase(s))
                            {
                                ((Vehicle) (view)).attributes.add(new NameValue(s1, ((String) (obj))));
                            }
                        }
                    }
                }

                break;
            } while (true);
            ItemViewCompatibilityLeafActivity.StartActivityForResult(ItemViewCompatibilityActivity.this, 2, viewData, view);
        }
    }

    y()
    {
        this$0 = final_itemviewcompatibilityactivity;
        val$value = String.this;
        super();
    }
}
