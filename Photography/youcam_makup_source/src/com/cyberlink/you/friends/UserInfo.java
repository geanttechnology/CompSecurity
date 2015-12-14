// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONObject;

public class UserInfo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UserInfo a(Parcel parcel)
        {
            return new UserInfo(parcel);
        }

        public UserInfo[] a(int i1)
        {
            return new UserInfo[i1];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i1)
        {
            return a(i1);
        }

    };
    public static boolean s = true;
    private static boolean t = true;
    private static boolean u = false;
    private static boolean v = false;
    private static boolean w = false;
    public long a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;

    public UserInfo()
    {
        a = 0L;
        b = "";
        c = "";
        d = "";
        e = "";
        f = "";
        g = "";
        i = "";
        h = "";
        j = "";
        l = "";
        k = "";
        m = "";
        n = s;
        o = t;
        p = u;
        q = v;
        r = w;
    }

    public UserInfo(Parcel parcel)
    {
        boolean flag1 = false;
        super();
        a = parcel.readLong();
        b = parcel.readString();
        c = parcel.readString();
        d = parcel.readString();
        e = parcel.readString();
        f = parcel.readString();
        g = parcel.readString();
        i = parcel.readString();
        h = parcel.readString();
        j = parcel.readString();
        l = parcel.readString();
        k = parcel.readString();
        m = parcel.readString();
        boolean flag;
        if (parcel.readByte() == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        n = flag;
        if (parcel.readByte() == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        o = flag;
        if (parcel.readByte() == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        p = flag;
        if (parcel.readByte() == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        q = flag;
        if (parcel.readByte() == 0)
        {
            flag = flag1;
        } else
        {
            flag = true;
        }
        r = flag;
    }

    public String a()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("userId", a);
            jsonobject.put("displayName", b);
            jsonobject.put("avatar", c);
            jsonobject.put("statusMessage", d);
            jsonobject.put("publicId", e);
            jsonobject.put("jid", f);
            jsonobject.put("avatarAlbumId", g);
            jsonobject.put("cover", i);
            jsonobject.put("coverAlbumId", h);
            jsonobject.put("accountPhone", j);
            jsonobject.put("accounts", l);
            jsonobject.put("hiddenAlbumId", k);
            jsonobject.put("attr_publicKey", m);
            jsonobject.put("attrs_notification_enabled", n);
            jsonobject.put("attrs_profile_publicId_enabled", o);
            jsonobject.put("attrs_friend_autoInvite_enabled", p);
            jsonobject.put("attrs_friend_autoAccept_enabled", q);
            jsonobject.put("attrs_notification_hide_message_enabled", r);
        }
        catch (Exception exception)
        {
            Log.d("UserInfo", "[toJsonString]convert to json string fail");
            return "";
        }
        return jsonobject.toString();
    }

    public boolean a(String s1)
    {
        Exception exception;
        try
        {
            s1 = new JSONObject(s1);
            a = s1.getLong("userId");
            b = s1.getString("displayName");
            c = s1.getString("avatar");
            d = s1.getString("statusMessage");
            e = s1.getString("publicId");
            f = s1.getString("jid");
            g = s1.getString("avatarAlbumId");
            i = s1.getString("cover");
            h = s1.getString("coverAlbumId");
            j = s1.getString("accountPhone");
            if (s1.has("accounts"))
            {
                l = s1.getString("accounts");
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("UserInfo", "[updateByJsonString]convert to json string fail");
            return false;
        }
        k = s1.getString("hiddenAlbumId");
_L2:
        if (s1.has("attr_publicKey"))
        {
            m = s1.getString("attr_publicKey");
        }
        n = s1.getBoolean("attrs_notification_enabled");
        o = s1.getBoolean("attrs_profile_publicId_enabled");
        p = s1.getBoolean("attrs_friend_autoInvite_enabled");
        q = s1.getBoolean("attrs_friend_autoAccept_enabled");
        if (s1.has("attrs_notification_hide_message_enabled"))
        {
            r = s1.getBoolean("attrs_notification_hide_message_enabled");
        }
        break; /* Loop/switch isn't completed */
        exception;
        k = (new StringBuilder()).append("UserHidden:").append(String.valueOf(a)).toString();
        if (true) goto _L2; else goto _L1
_L1:
        return true;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        parcel.writeLong(a);
        parcel.writeString(b);
        parcel.writeString(c);
        parcel.writeString(d);
        parcel.writeString(e);
        parcel.writeString(f);
        parcel.writeString(g);
        parcel.writeString(i);
        parcel.writeString(h);
        parcel.writeString(j);
        parcel.writeString(l);
        parcel.writeString(k);
        parcel.writeString(m);
        if (n)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        if (o)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        if (p)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        if (q)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        if (r)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
    }

}
