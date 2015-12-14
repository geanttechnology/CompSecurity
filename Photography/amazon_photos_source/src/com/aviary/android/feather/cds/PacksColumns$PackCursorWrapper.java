// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            PacksColumns

public static final class r extends r
{

    orWrapper content;
    String creationDate;
    int displayOrder;
    String identifier;
    int markedForDeletion;
    String packType;
    String versionKey;
    int visible;

    public static r create(Cursor cursor)
    {
        if (pper.isValid(cursor))
        {
            r r = new <init>(cursor.getLong(cursor.getColumnIndex("pack_id")));
            int i = cursor.getColumnIndex("pack_identifier");
            if (i > -1)
            {
                r.identifier = cursor.getString(i);
            }
            i = cursor.getColumnIndex("pack_versionKey");
            if (i > -1)
            {
                r.versionKey = cursor.getString(i);
            }
            i = cursor.getColumnIndex("pack_type");
            if (i > -1)
            {
                r.packType = cursor.getString(i);
            }
            i = cursor.getColumnIndex("pack_markedForDeletion");
            if (i > -1)
            {
                r.markedForDeletion = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("pack_visible");
            if (i > -1)
            {
                r.visible = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("pack_displayOrder");
            if (i > -1)
            {
                r.displayOrder = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("pack_creationDate");
            if (i > -1)
            {
                r.creationDate = cursor.getString(i);
            }
            return r;
        } else
        {
            return null;
        }
    }

    public Object clone()
    {
        creationDate creationdate = new <init>(id);
        creationdate.identifier = identifier;
        creationdate.packType = packType;
        creationdate.versionKey = versionKey;
        creationdate.displayOrder = displayOrder;
        creationdate.visible = visible;
        creationdate.creationDate = creationDate;
        creationdate.markedForDeletion = markedForDeletion;
        if (content != null)
        {
            creationdate.content = (orWrapper)content.clone();
        }
        return creationdate;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof orWrapper.clone))
        {
            obj = (orWrapper.clone)obj;
            if (id == ((id) (obj)).id)
            {
                return true;
            }
        }
        return false;
    }

    public orWrapper getContent()
    {
        return content;
    }

    public String getCreationDate()
    {
        return creationDate;
    }

    public int getDisplayOrder()
    {
        return displayOrder;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public int getMarkedForDeletion()
    {
        return markedForDeletion;
    }

    public String getPackType()
    {
        return packType;
    }

    public String getVersionKey()
    {
        return versionKey;
    }

    public int getVisible()
    {
        return visible;
    }

    public int hashCode()
    {
        return Long.valueOf(id).hashCode();
    }

    public void setContent(orWrapper orwrapper)
    {
        content = orwrapper;
    }

    public String toString()
    {
        return (new StringBuilder()).append("PacksColumn.Pack{ id: ").append(id).append(", identifier: ").append(identifier).append(", packType: ").append(packType).append(", versionKey: ").append(versionKey).append(", markedForDeletion: ").append(markedForDeletion).append(", order: ").append(displayOrder).append(", visible: ").append(visible).append(" }").toString();
    }

    orWrapper(long l)
    {
        super(l);
    }
}
