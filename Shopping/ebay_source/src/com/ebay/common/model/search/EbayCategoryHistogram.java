// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public final class EbayCategoryHistogram
    implements Parcelable
{
    public static class BreadCrumb
    {

        public final long categoryId;
        public final String displayName;

        BreadCrumb(String s, long l)
        {
            displayName = s;
            categoryId = l;
        }
    }

    public static class Category
    {

        public static int UNINITIALIZED_LEVEL = 0x80000000;
        public int count;
        public long id;
        public boolean isLeaf;
        public int level;
        public String name;
        public long parentId;

        public String toString()
        {
            if (count != 0)
            {
                return (new StringBuilder()).append(name).append(" (").append(count).append(')').toString();
            } else
            {
                return name;
            }
        }


        public Category()
        {
            id = 0L;
            name = null;
            parentId = 0L;
            count = 0;
            level = UNINITIALIZED_LEVEL;
            isLeaf = false;
        }

        public Category(Category category)
        {
            id = 0L;
            name = null;
            parentId = 0L;
            count = 0;
            level = UNINITIALIZED_LEVEL;
            isLeaf = false;
            id = category.id;
            name = category.name;
            parentId = category.parentId;
            count = category.count;
            level = category.level;
            isLeaf = category.isLeaf;
        }
    }

    public static final class ParentCategory extends Category
    {

        public final ArrayList children;

        public ParentCategory()
        {
            children = new ArrayList();
        }

        public ParentCategory(Category category)
        {
            super(category);
            children = new ArrayList();
        }

        ParentCategory(ArrayList arraylist)
        {
            children = arraylist;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayCategoryHistogram createFromParcel(Parcel parcel)
        {
            return new EbayCategoryHistogram(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayCategoryHistogram[] newArray(int i)
        {
            return new EbayCategoryHistogram[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private BreadCrumb breadCrumb;
    public final ArrayList categories;

    public EbayCategoryHistogram()
    {
        breadCrumb = null;
        categories = new ArrayList();
    }

    EbayCategoryHistogram(Parcel parcel)
    {
        breadCrumb = null;
        int j = parcel.readInt();
        ArrayList arraylist = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            arraylist.add(readParent(parcel));
        }

        categories = arraylist;
        if (parcel.readInt() == 1)
        {
            breadCrumb = new BreadCrumb(parcel.readString(), parcel.readLong());
        }
    }

    private void computeBreadcrumb(long l)
    {
        breadCrumb = null;
        long l1 = -1L;
        int j = categories.size();
        int i = 0;
        do
        {
            Object obj;
label0:
            {
                long l2 = l1;
                if (i < j)
                {
                    l2 = l1;
                    if (l1 == -1L)
                    {
                        obj = (ParentCategory)categories.get(i);
                        if (((ParentCategory) (obj)).id != l)
                        {
                            break label0;
                        }
                        l2 = ((ParentCategory) (obj)).parentId;
                    }
                }
                obj = categories.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    ParentCategory parentcategory = (ParentCategory)((Iterator) (obj)).next();
                    if (parentcategory.id != l2)
                    {
                        continue;
                    }
                    breadCrumb = new BreadCrumb(parentcategory.name, parentcategory.id);
                    break;
                } while (true);
                return;
            }
            obj = ((ParentCategory) (obj)).children.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Category category = (Category)((Iterator) (obj)).next();
                if (category.id == l)
                {
                    l1 = category.parentId;
                }
            } while (true);
            i++;
        } while (true);
    }

    private Category readChild(Parcel parcel, Category category)
    {
        boolean flag = true;
        category.id = parcel.readLong();
        category.name = parcel.readString();
        category.count = parcel.readInt();
        category.parentId = parcel.readLong();
        category.level = parcel.readInt();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        category.isLeaf = flag;
        return category;
    }

    private ParentCategory readParent(Parcel parcel)
    {
        int j = parcel.readInt();
        ArrayList arraylist = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            arraylist.add(readChild(parcel, new Category()));
        }

        return (ParentCategory)readChild(parcel, new ParentCategory(arraylist));
    }

    private void writeChild(Parcel parcel, Category category)
    {
        parcel.writeLong(category.id);
        parcel.writeString(category.name);
        parcel.writeInt(category.count);
        parcel.writeLong(category.parentId);
        parcel.writeInt(category.level);
        int i;
        if (category.isLeaf)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

    private void writeParent(Parcel parcel, ParentCategory parentcategory)
    {
        int j = parentcategory.children.size();
        parcel.writeInt(j);
        for (int i = 0; i < j; i++)
        {
            writeChild(parcel, (Category)parentcategory.children.get(i));
        }

        writeChild(parcel, parentcategory);
    }

    public int describeContents()
    {
        return 0;
    }

    public BreadCrumb getBreadCrumb()
    {
        return breadCrumb;
    }

    public Category getLeafCategory(long l)
    {
        Iterator iterator = categories.iterator();
        Category category;
label0:
        do
        {
            if (iterator.hasNext())
            {
                Object obj = (ParentCategory)iterator.next();
                if (((ParentCategory) (obj)).id == l && ((ParentCategory) (obj)).isLeaf)
                {
                    return ((Category) (obj));
                }
                obj = ((ParentCategory) (obj)).children.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue label0;
                    }
                    category = (Category)((Iterator) (obj)).next();
                } while (category.id != l || !category.isLeaf);
                break;
            } else
            {
                return null;
            }
        } while (true);
        return category;
    }

    public void reconstructWithTwoLevels(long l)
    {
        if (l != 0L)
        {
            computeBreadcrumb(l);
            Category category = getLeafCategory(l);
            if (category != null)
            {
                categories.clear();
                categories.add(new ParentCategory(category));
            }
        }
        if (categories.size() > 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ListIterator listiterator;
        int i;
        listiterator = categories.listIterator();
        i = 0;
        do
        {
            if (!listiterator.hasNext())
            {
                break;
            }
            int j = ((ParentCategory)listiterator.next()).level;
            if (j != Category.UNINITIALIZED_LEVEL && j > i)
            {
                i = j;
            }
        } while (true);
        listiterator = categories.listIterator();
_L9:
        ParentCategory parentcategory;
        while (listiterator.hasNext()) 
        {
label0:
            {
                parentcategory = (ParentCategory)listiterator.next();
                if (parentcategory.level == Category.UNINITIALIZED_LEVEL || parentcategory.level >= i - 1)
                {
                    break label0;
                }
                listiterator.remove();
            }
        }
          goto _L3
        Iterator iterator = categories.iterator();
_L7:
        if (!iterator.hasNext()) goto _L5; else goto _L4
_L4:
        ParentCategory parentcategory1 = (ParentCategory)iterator.next();
        if (parentcategory1.id != parentcategory.parentId) goto _L7; else goto _L6
_L6:
        parentcategory1.children.add(new Category(parentcategory));
        listiterator.remove();
_L5:
        if (true) goto _L9; else goto _L8
_L8:
_L3:
        if (true) goto _L1; else goto _L10
_L10:
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ArrayList arraylist = categories;
        int j = arraylist.size();
        parcel.writeInt(j);
        for (i = 0; i < j; i++)
        {
            writeParent(parcel, (ParentCategory)arraylist.get(i));
        }

        if (breadCrumb != null)
        {
            parcel.writeInt(1);
            parcel.writeString(breadCrumb.displayName);
            parcel.writeLong(breadCrumb.categoryId);
            return;
        } else
        {
            parcel.writeInt(0);
            return;
        }
    }

}
