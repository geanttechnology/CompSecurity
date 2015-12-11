// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            al

class VideoLogEvent
    implements Parcelable, Externalizable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new VideoLogEvent(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new VideoLogEvent[i];
        }

    };
    private static final String c = com/millennialmedia/android/VideoLogEvent.getName();
    long a;
    String b[];

    public VideoLogEvent()
    {
    }

    VideoLogEvent(Parcel parcel)
    {
        try
        {
            a = parcel.readLong();
            b = new String[parcel.readInt()];
            parcel.readStringArray(b);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            al.a(c, "VideoLogEvent parcel creation exception: ", parcel);
        }
    }

    VideoLogEvent(JSONObject jsonobject)
    {
        a(jsonobject);
    }

    private void a(JSONObject jsonobject)
    {
        int i = 0;
        if (jsonobject != null)
        {
            a = jsonobject.optInt("time") * 1000;
            jsonobject = jsonobject.optJSONArray("urls");
            if (jsonobject != null)
            {
                b = new String[jsonobject.length()];
                while (i < jsonobject.length()) 
                {
                    b[i] = jsonobject.optString(i);
                    i++;
                }
            } else
            {
                b = new String[0];
                return;
            }
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void readExternal(ObjectInput objectinput)
    {
        a = objectinput.readLong();
        int j = objectinput.readInt();
        b = new String[j];
        for (int i = 0; i < j; i++)
        {
            b[i] = (String)objectinput.readObject();
        }

    }

    public void writeExternal(ObjectOutput objectoutput)
    {
        objectoutput.writeLong(a);
        objectoutput.writeInt(b.length);
        String as[] = b;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            objectoutput.writeObject(as[i]);
        }

    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(a);
        parcel.writeInt(b.length);
        parcel.writeStringArray(b);
    }

}
