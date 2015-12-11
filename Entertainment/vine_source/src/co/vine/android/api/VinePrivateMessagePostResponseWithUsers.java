// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.api:
//            VinePost

public class VinePrivateMessagePostResponseWithUsers
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VinePrivateMessagePostResponseWithUsers createFromParcel(Parcel parcel)
        {
            return new VinePrivateMessagePostResponseWithUsers(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VinePrivateMessagePostResponseWithUsers[] newArray(int i)
        {
            return new VinePrivateMessagePostResponseWithUsers[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final VinePost post;
    public final ArrayList recipients;
    public final ArrayList responses;
    public final ArrayList users;

    public VinePrivateMessagePostResponseWithUsers(Parcel parcel)
    {
        responses = (ArrayList)parcel.readSerializable();
        recipients = (ArrayList)parcel.readSerializable();
        users = (ArrayList)parcel.readSerializable();
        post = (VinePost)parcel.readParcelable(co/vine/android/api/VinePost.getClassLoader());
    }

    public VinePrivateMessagePostResponseWithUsers(ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2, VinePost vinepost)
    {
        responses = arraylist;
        recipients = arraylist1;
        users = arraylist2;
        post = vinepost;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(responses);
        parcel.writeSerializable(recipients);
        parcel.writeSerializable(users);
        parcel.writeParcelable(post, i);
    }

}
