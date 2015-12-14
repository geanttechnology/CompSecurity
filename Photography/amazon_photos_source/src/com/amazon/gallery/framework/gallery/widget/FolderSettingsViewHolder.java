// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.gallery.framework.gallery.view.ViewNameFactory;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;

public class FolderSettingsViewHolder extends ItemViewHolder
{

    public CheckBox checkbox;
    public TextView subtitleText;
    public TextView textView;

    public FolderSettingsViewHolder(Tag tag, View view)
    {
        super(tag, view);
        setImageView((ImageView)view.findViewById(0x7f0c0149));
        textView = (TextView)view.findViewById(0x7f0c014b);
    }

    public volatile void updateView(Persistable persistable, Context context)
    {
        updateView((Tag)persistable, context);
    }

    public void updateView(Tag tag, Context context)
    {
        super.updateView(tag, context);
        if (tag.hasProperty(TagProperty.REMOVABLE))
        {
            textView.setText(String.format("%s %s", new Object[] {
                tag.getLabel(), context.getResources().getString(0x7f0e0205)
            }));
            return;
        } else
        {
            textView.setText(ViewNameFactory.getTitle(tag, context));
            return;
        }
    }
}
