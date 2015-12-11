// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package co.vine.android.api:
//            VineRecipient, VineError

public class VinePrivateMessageResponse
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VinePrivateMessageResponse createFromParcel(Parcel parcel)
        {
            return new VinePrivateMessageResponse(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VinePrivateMessageResponse[] newArray(int i)
        {
            return new VinePrivateMessageResponse[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final long conversationId;
    public final VineError error;
    public final long messageId;
    public final int networkType;
    public final VineRecipient recipient;
    public final String shareUrl;
    public final String thumbnailUrl;
    public final String videoUrl;

    public VinePrivateMessageResponse(Parcel parcel)
    {
        recipient = (VineRecipient)parcel.readParcelable(co/vine/android/api/VineRecipient.getClassLoader());
        conversationId = parcel.readLong();
        messageId = parcel.readLong();
        videoUrl = parcel.readString();
        thumbnailUrl = parcel.readString();
        shareUrl = parcel.readString();
        error = (VineError)parcel.readParcelable(co/vine/android/api/VineError.getClassLoader());
        networkType = parcel.readInt();
    }

    public VinePrivateMessageResponse(VineRecipient vinerecipient, long l, long l1, String s, String s1, 
            String s2, VineError vineerror, int i)
    {
        recipient = vinerecipient;
        conversationId = l;
        messageId = l1;
        videoUrl = s;
        thumbnailUrl = s1;
        shareUrl = s2;
        error = vineerror;
        networkType = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(recipient, i);
        parcel.writeLong(conversationId);
        parcel.writeLong(messageId);
        parcel.writeString(videoUrl);
        parcel.writeString(thumbnailUrl);
        parcel.writeString(shareUrl);
        parcel.writeParcelable(error, i);
        parcel.writeInt(networkType);
    }

}
