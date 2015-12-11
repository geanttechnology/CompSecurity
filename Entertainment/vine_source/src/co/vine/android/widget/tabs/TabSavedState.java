// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.tabs;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.widget.tabs:
//            TabInfo

public class TabSavedState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TabSavedState createFromParcel(Parcel parcel)
        {
            return new TabSavedState(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public TabSavedState[] newArray(int i)
        {
            return new TabSavedState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String tags[];

    public TabSavedState(Parcel parcel)
    {
        tags = parcel.createStringArray();
    }

    public TabSavedState(ArrayList arraylist)
    {
        int j = arraylist.size();
        String as[] = new String[j];
        for (int i = 0; i < j; i++)
        {
            as[i] = ((TabInfo)arraylist.get(i)).mTag;
        }

        tags = as;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeStringArray(tags);
    }

}
