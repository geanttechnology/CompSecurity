// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.list;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.list.interfaces.ListDetail;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.cache.list:
//            CacheListSummary

public class CacheListDetail extends CacheListSummary
    implements Parcelable, ListDetail
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CacheListDetail createFromParcel(Parcel parcel)
        {
            return new CacheListDetail(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CacheListDetail[] newArray(int i)
        {
            return new CacheListDetail[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private List mListItems;

    public CacheListDetail()
    {
        mListItems = new ArrayList();
    }

    private CacheListDetail(Parcel parcel)
    {
        super(parcel);
        mListItems = new ArrayList();
        parcel.readList(mListItems, com/target/mothership/model/list/interfaces/ListDetail.getClassLoader());
    }


    public CacheListDetail(CacheListSummary cachelistsummary)
    {
        mListItems = new ArrayList();
        setDefaultList(cachelistsummary.isDefaultList());
        setDescription(cachelistsummary.getDescription());
        setOrganization(cachelistsummary.getOrganization());
        setChannel(cachelistsummary.getChannel());
        setId(cachelistsummary.getId());
        setLocation(cachelistsummary.getLocation());
        setTitle(cachelistsummary.getTitle());
        setTitleResourceId(cachelistsummary.getTitleResourceId());
        setKey(cachelistsummary.getKey());
        setGuestId(cachelistsummary.getGuestId());
        setServerLastModifiedDate(cachelistsummary.getServerLastModifiedDate());
        setLastModifiedDate(cachelistsummary.getLastModifiedDate());
        setLastModifiedUserId(cachelistsummary.getLastModifiedUserId());
        setListToken(cachelistsummary.getListToken());
        setListPosition(cachelistsummary.getListPosition());
        setDirty(cachelistsummary.isDirty());
        setDeleting(cachelistsummary.isDeleting());
        setItemCount(cachelistsummary.getItemCount());
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
        if (!super.equals(obj))
        {
            return false;
        }
        obj = (CacheListDetail)obj;
        if (mListItems == null) goto _L4; else goto _L3
_L3:
        if (mListItems.equals(((CacheListDetail) (obj)).mListItems)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((CacheListDetail) (obj)).mListItems == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public List getListItems()
    {
        return mListItems;
    }

    public int hashCode()
    {
        int j = super.hashCode();
        int i;
        if (mListItems != null)
        {
            i = mListItems.hashCode();
        } else
        {
            i = 0;
        }
        return i + j * 31;
    }

    public void setListItems(List list)
    {
        mListItems = list;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeList(mListItems);
    }

}
