// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            al

class VideoImage
    implements Parcelable, Externalizable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new VideoImage(parcel);
        }

        public final volatile Object[] newArray(int i1)
        {
            return new VideoImage[i1];
        }

    };
    private static final String t = com/millennialmedia/android/VideoImage.getName();
    String a;
    long b;
    String c[];
    String d;
    String e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    int l;
    int m;
    long n;
    long o;
    float p;
    float q;
    long r;
    boolean s;

    public VideoImage()
    {
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        p = 1.0F;
        q = 1.0F;
        r = 1000L;
    }

    VideoImage(Parcel parcel)
    {
        boolean flag;
        flag = true;
        super();
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        p = 1.0F;
        q = 1.0F;
        r = 1000L;
        a = parcel.readString();
        b = parcel.readLong();
        c = new String[parcel.readInt()];
        parcel.readStringArray(c);
        d = parcel.readString();
        e = parcel.readString();
        f = parcel.readInt();
        g = parcel.readInt();
        h = parcel.readInt();
        i = parcel.readInt();
        j = parcel.readInt();
        k = parcel.readInt();
        l = parcel.readInt();
        m = parcel.readInt();
        n = parcel.readLong();
        o = parcel.readLong();
        p = parcel.readFloat();
        q = parcel.readFloat();
        r = parcel.readLong();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        s = flag;
        return;
        parcel;
        al.a(t, "VideoImage parcel creation exception: ", parcel);
        return;
    }

    VideoImage(JSONObject jsonobject)
    {
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        p = 1.0F;
        q = 1.0F;
        r = 1000L;
        a(jsonobject);
    }

    private void a(JSONObject jsonobject)
    {
        int i1 = 0;
        if (jsonobject == null)
        {
            return;
        }
        a = jsonobject.optString("image", null);
        b = jsonobject.optLong("contentLength");
        Object obj = jsonobject.optJSONArray("activity");
        if (obj != null)
        {
            c = new String[((JSONArray) (obj)).length()];
            for (; i1 < ((JSONArray) (obj)).length(); i1++)
            {
                c[i1] = ((JSONArray) (obj)).optString(i1);
            }

        } else
        {
            c = new String[0];
        }
        d = jsonobject.optString("url", null);
        e = jsonobject.optString("overlayOrientation", null);
        j = jsonobject.optInt("android-layout");
        k = jsonobject.optInt("android-layoutAnchor");
        l = jsonobject.optInt("android-layout2");
        m = jsonobject.optInt("android-layoutAnchor2");
        f = jsonobject.optInt("android-paddingTop");
        h = jsonobject.optInt("android-paddingLeft");
        i = jsonobject.optInt("android-paddingRight");
        g = jsonobject.optInt("android-paddingBottom");
        n = (long)(jsonobject.optDouble("appearanceDelay", 0.0D) * 1000D);
        o = (long)(jsonobject.optDouble("inactivityTimeout", 0.0D) * 1000D);
        obj = jsonobject.optJSONObject("opacity");
        if (obj != null)
        {
            p = (float)((JSONObject) (obj)).optDouble("start", 1.0D);
            q = (float)((JSONObject) (obj)).optDouble("end", 1.0D);
            r = (long)(((JSONObject) (obj)).optDouble("fadeDuration", 1.0D) * 1000D);
        }
        s = jsonobject.optBoolean("is_leavebehind");
    }

    final String a()
    {
        if (a != null)
        {
            Uri uri = Uri.parse(a);
            if (uri != null && uri.getLastPathSegment() != null)
            {
                return uri.getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat");
            }
        }
        return null;
    }

    public int describeContents()
    {
        return 0;
    }

    public void readExternal(ObjectInput objectinput)
    {
        a = (String)objectinput.readObject();
        b = objectinput.readLong();
        int j1 = objectinput.readInt();
        c = new String[j1];
        for (int i1 = 0; i1 < j1; i1++)
        {
            c[i1] = (String)objectinput.readObject();
        }

        d = (String)objectinput.readObject();
        e = (String)objectinput.readObject();
        f = objectinput.readInt();
        g = objectinput.readInt();
        h = objectinput.readInt();
        i = objectinput.readInt();
        j = objectinput.readInt();
        k = objectinput.readInt();
        l = objectinput.readInt();
        m = objectinput.readInt();
        n = objectinput.readLong();
        o = objectinput.readLong();
        p = objectinput.readFloat();
        q = objectinput.readFloat();
        r = objectinput.readLong();
        s = objectinput.readBoolean();
    }

    public void writeExternal(ObjectOutput objectoutput)
    {
        objectoutput.writeObject(a);
        objectoutput.writeLong(b);
        objectoutput.writeInt(c.length);
        String as[] = c;
        int j1 = as.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            objectoutput.writeObject(as[i1]);
        }

        objectoutput.writeObject(d);
        objectoutput.writeObject(e);
        objectoutput.writeInt(f);
        objectoutput.writeInt(g);
        objectoutput.writeInt(h);
        objectoutput.writeInt(i);
        objectoutput.writeInt(j);
        objectoutput.writeInt(k);
        objectoutput.writeInt(l);
        objectoutput.writeInt(m);
        objectoutput.writeLong(n);
        objectoutput.writeLong(o);
        objectoutput.writeFloat(p);
        objectoutput.writeFloat(q);
        objectoutput.writeLong(r);
        objectoutput.writeBoolean(s);
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeString(a);
        parcel.writeLong(b);
        parcel.writeInt(c.length);
        parcel.writeStringArray(c);
        parcel.writeString(d);
        parcel.writeString(e);
        parcel.writeInt(f);
        parcel.writeInt(g);
        parcel.writeInt(h);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeInt(k);
        parcel.writeInt(l);
        parcel.writeInt(m);
        parcel.writeLong(n);
        parcel.writeLong(o);
        parcel.writeFloat(p);
        parcel.writeFloat(q);
        parcel.writeLong(r);
        if (s)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
    }

}
