// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget.holder;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.amazon.gallery.framework.gallery.actions.SelectionAction;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget.holder:
//            TagViewHolder

public class TagCardViewHolder extends TagViewHolder
{
    public static interface MultiselectModeChecker
    {

        public abstract boolean isInMultiSelectMode();
    }


    private final Map actionMap;
    private final Toolbar itemToolbar;
    private final MultiselectModeChecker multiselectModeChecker;

    public TagCardViewHolder(Tag tag, View view, GalleryDownloadManager gallerydownloadmanager, Map map, MultiselectModeChecker multiselectmodechecker)
    {
        super(tag, view, gallerydownloadmanager);
        itemToolbar = (Toolbar)view.findViewById(0x7f0c01ea);
        multiselectModeChecker = multiselectmodechecker;
        actionMap = map;
        itemToolbar.inflateMenu(0x7f100003);
    }

    private void filterMenuOptions(Menu menu, TagType tagtype)
    {
        boolean flag = multiselectModeChecker.isInMultiSelectMode();
        int i = 0;
        while (i < menu.size()) 
        {
            tagtype = menu.getItem(i);
            int j = tagtype.getItemId();
            if (actionMap.containsKey(Integer.valueOf(j)) && !flag)
            {
                List list = Collections.singletonList(getItem());
                tagtype.setVisible(((SelectionAction)actionMap.get(Integer.valueOf(j))).canExecuteTags(list));
            } else
            {
                tagtype.setVisible(false);
            }
            i++;
        }
    }

    private void updateMenuOptions(Toolbar toolbar, final Tag item)
    {
        filterMenuOptions(toolbar.getMenu(), item.getType());
        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {

            final TagCardViewHolder this$0;
            final Tag val$item;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                menuitem = (SelectionAction)actionMap.get(Integer.valueOf(menuitem.getItemId()));
                if (menuitem != null)
                {
                    ArrayList arraylist = new ArrayList(1);
                    arraylist.add(item);
                    menuitem.executeTags(arraylist);
                }
                return true;
            }

            
            {
                this$0 = TagCardViewHolder.this;
                item = tag;
                super();
            }
        });
    }

    public volatile void updateView(Persistable persistable, Context context)
    {
        updateView((Tag)persistable, context);
    }

    public void updateView(Tag tag, Context context)
    {
        super.updateView(tag, context);
        updateMenuOptions(itemToolbar, tag);
        if (tag.getCustomCoverId() == null)
        {
            itemToolbar.setBackgroundDrawable(null);
            return;
        } else
        {
            itemToolbar.setBackgroundDrawable(context.getResources().getDrawable(0x7f02003e));
            return;
        }
    }

}
