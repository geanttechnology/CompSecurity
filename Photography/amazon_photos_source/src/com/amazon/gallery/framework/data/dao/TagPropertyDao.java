// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagSqliteImpl;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TagPropertyDao
{

    private final Map column2prop = new HashMap();
    private final Map prop2column = new HashMap();

    public TagPropertyDao()
    {
        init();
    }

    public void assignColumn(String s, Class class1)
    {
        class1 = (Enum[])class1.getEnumConstants();
        column2prop.put(s, class1);
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = class1[i];
            prop2column.put(obj, s);
        }

    }

    public String getColumn(TagProperty tagproperty)
    {
        return (String)prop2column.get(tagproperty);
    }

    protected void init()
    {
        assignColumn("storage", com/amazon/gallery/framework/model/tags/CommonTagProperty$Storage);
        assignColumn("misc", com/amazon/gallery/framework/model/tags/CommonTagProperty$Misc);
        assignColumn("update_status", com/amazon/gallery/framework/model/tags/CommonTagProperty$Status);
        assignColumn("new_content", com/amazon/gallery/framework/model/tags/CommonTagProperty$NewContent);
        assignColumn("auto_save", com/amazon/gallery/framework/model/tags/CommonTagProperty$AutoSave);
    }

    public void readTagProperties(Cursor cursor, Tag tag)
    {
        String s;
        int i;
        for (Iterator iterator = column2prop.keySet().iterator(); iterator.hasNext(); tag.setProperty(((TagProperty[])column2prop.get(s))[i]))
        {
            s = (String)iterator.next();
            i = cursor.getInt(cursor.getColumnIndexOrThrow(s));
        }

    }

    public void writeTagProperties(ContentValues contentvalues, TagSqliteImpl tagsqliteimpl)
    {
        TagProperty tagproperty;
        for (tagsqliteimpl = tagsqliteimpl.getProperties().iterator(); tagsqliteimpl.hasNext(); contentvalues.put((String)prop2column.get(tagproperty), Integer.valueOf(tagproperty.ordinal())))
        {
            tagproperty = (TagProperty)tagsqliteimpl.next();
        }

    }
}
