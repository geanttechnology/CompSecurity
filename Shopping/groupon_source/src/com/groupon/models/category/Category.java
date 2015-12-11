// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.category;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.support.ParcelableCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Category
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/category/Category);
    public List children;
    public int count;
    public String friendlyName;
    public String friendlyNameShort;
    public String guid;
    public boolean hasSubcategories;
    public String id;
    public int imageResId;
    public boolean isAllDeals;
    public boolean isSubcategory;
    public String name;
    public Category parent;
    public String relevanceContext;
    public int visibility;

    public Category()
    {
        children = new ArrayList();
    }

    public Category(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        children = new ArrayList();
        friendlyNameShort = parcel.readString();
        count = parcel.readInt();
        friendlyName = parcel.readString();
        id = parcel.readString();
        guid = parcel.readString();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isSubcategory = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasSubcategories = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isAllDeals = flag;
        parent = (Category)parcel.readParcelable(com/groupon/models/category/Category.getClassLoader());
        relevanceContext = parcel.readString();
        imageResId = parcel.readInt();
        children = new ArrayList();
        parcel.readList(children, com/groupon/models/category/Category.getClassLoader());
        visibility = parcel.readInt();
    }

    public Category(Category category, String s, String s1, String s2, int i)
    {
        children = new ArrayList();
        friendlyNameShort = s2;
        count = i;
        friendlyName = s1;
        id = s;
        parent = category;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (Category)obj;
        if (id == null) goto _L4; else goto _L3
_L3:
        if (id.equals(((Category) (obj)).id)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((Category) (obj)).id == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public List getChildren()
    {
        for (Iterator iterator = children.iterator(); iterator.hasNext();)
        {
            ((Category)iterator.next()).isSubcategory = true;
        }

        return children;
    }

    public int hashCode()
    {
        if (id != null)
        {
            return id.hashCode();
        } else
        {
            return 0;
        }
    }

    public boolean isParent()
    {
        return parent == null;
    }

    public String toNstTracking(int i)
    {
        return (new StringBuilder()).append(friendlyName).append(",").append(id).append(",").append(i).toString();
    }

    public String toString()
    {
        return friendlyNameShort;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(friendlyNameShort);
        parcel.writeInt(count);
        parcel.writeString(friendlyName);
        parcel.writeString(id);
        parcel.writeString(guid);
        int j;
        if (isSubcategory)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (hasSubcategories)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (isAllDeals)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeParcelable(parent, i);
        parcel.writeString(relevanceContext);
        parcel.writeInt(imageResId);
        parcel.writeList(children);
        parcel.writeInt(visibility);
    }

}
