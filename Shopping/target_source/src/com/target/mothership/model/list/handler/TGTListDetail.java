// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.list.interfaces.ListDetail;
import com.target.mothership.model.list.interfaces.ListItem;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.list.handler:
//            TGTListSummary

class TGTListDetail extends TGTListSummary
    implements Parcelable, ListDetail
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTListDetail a(Parcel parcel)
        {
            return new TGTListDetail(parcel);
        }

        public TGTListDetail[] a(int i)
        {
            return new TGTListDetail[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private List mListItems;

    public TGTListDetail()
    {
        mListItems = new ArrayList();
    }

    private TGTListDetail(Parcel parcel)
    {
        super(parcel);
        mListItems = new ArrayList();
        parcel.readList(mListItems, com/target/mothership/model/list/interfaces/ListItem.getClassLoader());
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
        if (!super.equals(obj))
        {
            return false;
        }
        obj = (TGTListDetail)obj;
        if (mListItems == null) goto _L4; else goto _L3
_L3:
        if (mListItems.equals(((TGTListDetail) (obj)).mListItems)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((TGTListDetail) (obj)).mListItems == null)
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

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeList(mListItems);
    }

}
