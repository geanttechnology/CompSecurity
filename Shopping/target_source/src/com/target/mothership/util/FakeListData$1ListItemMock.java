// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.list.interfaces.ListItem;
import java.util.Date;

// Referenced classes of package com.target.mothership.util:
//            i

class val.requestedQuantity
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
        return val$requestedQuantity;
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
        return val$purchasedQuantity;
    }

    public Date getServerLastModifiedDate()
    {
        return new Date();
    }

    public e getTcin()
    {
        if (val$rawTcin != null)
        {
            return e.b(new Tcin(val$rawTcin));
        } else
        {
            return e.e();
        }
    }

    public String getTitle()
    {
        return val$title;
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
        return val$purchasedQuantity > 0;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
    }

    ()
    {
        val$requestedQuantity = j;
        val$rawTcin = s;
        val$title = s1;
        val$purchasedQuantity = k;
        super();
        mQuantity = val$requestedQuantity;
    }
}
