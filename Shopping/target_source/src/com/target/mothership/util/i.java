// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.c.b;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.list.interfaces.ListDetail;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.ListSummary;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class i
{
    class FakeListData._cls1ListItemMock
        implements ListItem
    {

        private int mQuantity;
        final int val$purchasedQuantity;
        final String val$rawTcin;
        final int val$requestedQuantity;
        final String val$title;

        public int describeContents()
        {
            return 0;
        }

        public int getDesiredQuantity()
        {
            return requestedQuantity;
        }

        public long getItemPosition()
        {
            return 0L;
        }

        public int getKey()
        {
            return 1;
        }

        public Date getLastModifiedDate()
        {
            return new Date();
        }

        public String getListId()
        {
            return "123";
        }

        public String getListItemId()
        {
            return null;
        }

        public int getListKey()
        {
            return 4;
        }

        public String getNote()
        {
            return "Note";
        }

        public int getPurchasedQuantity()
        {
            return purchasedQuantity;
        }

        public Date getServerLastModifiedDate()
        {
            return new Date();
        }

        public e getTcin()
        {
            if (rawTcin != null)
            {
                return e.b(new Tcin(rawTcin));
            } else
            {
                return e.e();
            }
        }

        public String getTitle()
        {
            return title;
        }

        public boolean isCompleted()
        {
            return false;
        }

        public boolean isDeleting()
        {
            return false;
        }

        public boolean isDirty()
        {
            return false;
        }

        public boolean isFulfilled()
        {
            return purchasedQuantity > 0;
        }

        public void writeToParcel(Parcel parcel, int j)
        {
        }

        FakeListData._cls1ListItemMock()
        {
            requestedQuantity = j;
            rawTcin = s;
            title = s1;
            purchasedQuantity = k;
            super();
            mQuantity = requestedQuantity;
        }
    }


    public static ListDetail a(String s, int j, boolean flag)
    {
        return a(s, null, null, null, j, flag);
    }

    public static ListDetail a(String s, String s1, String s2, String s3, int j, boolean flag)
    {
        return new FakeListData._cls1(j, s1, s2, s, s3, flag);
    }

    public static ListItem a(final String rawTcin, boolean flag, final String title, final int requestedQuantity, final int purchasedQuantity)
    {
        return new FakeListData._cls1ListItemMock();
    }

    public static List a(int j, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        for (int k = 0; k < j; k++)
        {
            arraylist.add(b((new StringBuilder()).append("List ").append(k).toString(), j, flag));
        }

        return arraylist;
    }

    public static List a(int j, boolean flag, ListItem listitem)
    {
        ArrayList arraylist = new ArrayList();
        for (int k = 0; k < j; k++)
        {
            arraylist.add(a((new StringBuilder()).append("tcin-0900-").append(k).toString(), flag, (new StringBuilder()).append("Item ").append(k).toString(), 1, 0));
        }

        if (listitem != null)
        {
            arraylist.add(listitem);
        }
        return arraylist;
    }

    public static ListSummary b(String s, int j, boolean flag)
    {
        return new FakeListData._cls2(s, j, flag);
    }

    public static List b(int j, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        for (int k = 0; k < j; k++)
        {
            arraylist.add(a((new StringBuilder()).append("List ").append(k).toString(), j, flag));
        }

        return arraylist;
    }

    // Unreferenced inner class com/target/mothership/util/FakeListData$1

/* anonymous class */
    static final class FakeListData._cls1
        implements ListDetail
    {

        final String val$description;
        final boolean val$isDefault;
        final int val$itemCount;
        final String val$location;
        final String val$organization;
        final String val$title;

        public int describeContents()
        {
            return 0;
        }

        public b getChannel()
        {
            return null;
        }

        public String getDescription()
        {
            return description;
        }

        public String getGuestId()
        {
            return null;
        }

        public String getId()
        {
            return "1";
        }

        public int getItemCount()
        {
            return itemCount;
        }

        public int getKey()
        {
            return 1;
        }

        public Date getLastModifiedDate()
        {
            return new Date();
        }

        public String getLastModifiedUserId()
        {
            return "1";
        }

        public List getListItems()
        {
            return i.a(itemCount, false, null);
        }

        public long getListPosition()
        {
            return 0L;
        }

        public String getListToken()
        {
            return null;
        }

        public String getLocation()
        {
            return location;
        }

        public String getOrganization()
        {
            return organization;
        }

        public Date getServerLastModifiedDate()
        {
            return new Date();
        }

        public String getTitle()
        {
            return title;
        }

        public String getTitleResourceId()
        {
            return null;
        }

        public boolean isDefaultList()
        {
            return isDefault;
        }

        public boolean isDeleting()
        {
            return false;
        }

        public boolean isDirty()
        {
            return false;
        }

        public void writeToParcel(Parcel parcel, int j)
        {
        }

            
            {
                itemCount = j;
                organization = s;
                location = s1;
                title = s2;
                description = s3;
                isDefault = flag;
                super();
            }
    }


    // Unreferenced inner class com/target/mothership/util/FakeListData$2

/* anonymous class */
    static final class FakeListData._cls2
        implements ListSummary
    {

        final boolean val$isDefault;
        final int val$itemCount;
        final String val$title;

        public int describeContents()
        {
            return 0;
        }

        public b getChannel()
        {
            return b.MOBILE;
        }

        public String getDescription()
        {
            return "Description";
        }

        public String getGuestId()
        {
            return "1";
        }

        public String getId()
        {
            return "1";
        }

        public int getItemCount()
        {
            return itemCount;
        }

        public int getKey()
        {
            return 1;
        }

        public Date getLastModifiedDate()
        {
            return new Date();
        }

        public String getLastModifiedUserId()
        {
            return "1";
        }

        public long getListPosition()
        {
            return 0L;
        }

        public String getListToken()
        {
            return null;
        }

        public String getLocation()
        {
            return "Location";
        }

        public String getOrganization()
        {
            return "Organization";
        }

        public Date getServerLastModifiedDate()
        {
            return new Date();
        }

        public String getTitle()
        {
            return title;
        }

        public String getTitleResourceId()
        {
            return null;
        }

        public boolean isDefaultList()
        {
            return isDefault;
        }

        public boolean isDeleting()
        {
            return false;
        }

        public boolean isDirty()
        {
            return false;
        }

        public void writeToParcel(Parcel parcel, int j)
        {
        }

            
            {
                title = s;
                itemCount = j;
                isDefault = flag;
                super();
            }
    }

}
