// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import com.target.mothership.common.c.b;
import com.target.mothership.model.list.interfaces.ListSummary;
import java.util.Date;

// Referenced classes of package com.target.mothership.util:
//            i

static final class val.isDefault
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

    s.ListSummary(String s, int j, boolean flag)
    {
        val$title = s;
        val$itemCount = j;
        val$isDefault = flag;
        super();
    }
}
