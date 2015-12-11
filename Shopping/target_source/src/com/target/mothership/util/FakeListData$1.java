// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import com.target.mothership.common.c.b;
import com.target.mothership.model.list.interfaces.ListDetail;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.target.mothership.util:
//            i

static final class val.isDefault
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
        return val$description;
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
        return val$itemCount;
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
        return i.a(val$itemCount, false, null);
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
        return val$location;
    }

    public String getOrganization()
    {
        return val$organization;
    }

    public Date getServerLastModifiedDate()
    {
        return new Date();
    }

    public String getTitle()
    {
        return val$title;
    }

    public String getTitleResourceId()
    {
        return null;
    }

    public boolean isDefaultList()
    {
        return val$isDefault;
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

    s.ListDetail(int j, String s, String s1, String s2, String s3, boolean flag)
    {
        val$itemCount = j;
        val$organization = s;
        val$location = s1;
        val$title = s2;
        val$description = s3;
        val$isDefault = flag;
        super();
    }
}
