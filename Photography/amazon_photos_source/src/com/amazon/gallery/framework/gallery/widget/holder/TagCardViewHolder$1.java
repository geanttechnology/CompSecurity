// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget.holder;

import android.view.MenuItem;
import com.amazon.gallery.framework.gallery.actions.SelectionAction;
import com.amazon.gallery.framework.model.tags.Tag;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget.holder:
//            TagCardViewHolder

class val.item
    implements android.support.v7.widget.ickListener
{

    final TagCardViewHolder this$0;
    final Tag val$item;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        menuitem = (SelectionAction)TagCardViewHolder.access$000(TagCardViewHolder.this).get(Integer.valueOf(menuitem.getItemId()));
        if (menuitem != null)
        {
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(val$item);
            menuitem.executeTags(arraylist);
        }
        return true;
    }

    ()
    {
        this$0 = final_tagcardviewholder;
        val$item = Tag.this;
        super();
    }
}
