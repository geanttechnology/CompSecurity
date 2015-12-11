// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class VineInbox
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineInbox createFromParcel(Parcel parcel)
        {
            return new VineInbox(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineInbox[] newArray(int i)
        {
            return new VineInbox[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public ArrayList conversations;
    public ArrayList participants;

    public VineInbox()
    {
    }

    public VineInbox(Parcel parcel)
    {
        ClassLoader classloader = getClass().getClassLoader();
        conversations = parcel.readArrayList(classloader);
        participants = parcel.readArrayList(classloader);
    }

    public VineInbox(ArrayList arraylist, ArrayList arraylist1)
    {
        conversations = arraylist;
        participants = arraylist1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (VineInbox)obj;
            if (conversations == null ? ((VineInbox) (obj)).conversations != null : !conversations.equals(((VineInbox) (obj)).conversations))
            {
                return false;
            }
            if (participants == null ? ((VineInbox) (obj)).participants != null : !participants.equals(((VineInbox) (obj)).participants))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (conversations != null)
        {
            i = conversations.hashCode();
        } else
        {
            i = 0;
        }
        if (participants != null)
        {
            j = participants.hashCode();
        }
        return i * 31 + j;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(conversations);
        parcel.writeSerializable(participants);
    }

}
