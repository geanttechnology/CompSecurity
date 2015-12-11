// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.api:
//            VineRTCParticipant

public class VineRTCConversation
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineRTCConversation createFromParcel(Parcel parcel)
        {
            return new VineRTCConversation(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineRTCConversation[] newArray(int i)
        {
            return new VineRTCConversation[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public long conversationId;
    public ArrayList participants;

    public VineRTCConversation(long l, ArrayList arraylist)
    {
        participants = new ArrayList();
        conversationId = l;
        participants = arraylist;
    }

    public VineRTCConversation(Parcel parcel)
    {
        participants = new ArrayList();
        conversationId = parcel.readLong();
        parcel.readTypedList(participants, VineRTCParticipant.CREATOR);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(conversationId);
        parcel.writeTypedList(participants);
    }

}
