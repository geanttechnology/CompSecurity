// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.kb;
import android.support.v7.kc;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            c, b, r, k, 
//            h, s

public final class AccessToken
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AccessToken a(Parcel parcel)
        {
            return new AccessToken(parcel);
        }

        public AccessToken[] a(int i1)
        {
            return new AccessToken[i1];
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
    private static final Date a;
    private static final Date b;
    private static final Date c = new Date();
    private static final c d;
    private final Date e;
    private final Set f;
    private final Set g;
    private final String h;
    private final c i;
    private final Date j;
    private final String k;
    private final String l;

    AccessToken(Parcel parcel)
    {
        e = new Date(parcel.readLong());
        ArrayList arraylist = new ArrayList();
        parcel.readStringList(arraylist);
        f = Collections.unmodifiableSet(new HashSet(arraylist));
        arraylist.clear();
        parcel.readStringList(arraylist);
        g = Collections.unmodifiableSet(new HashSet(arraylist));
        h = parcel.readString();
        i = com.facebook.c.valueOf(parcel.readString());
        j = new Date(parcel.readLong());
        k = parcel.readString();
        l = parcel.readString();
    }

    public AccessToken(String s1, String s2, String s3, Collection collection, Collection collection1, c c1, Date date, 
            Date date1)
    {
        kc.a(s1, "accessToken");
        kc.a(s2, "applicationId");
        kc.a(s3, "userId");
        if (date == null)
        {
            date = b;
        }
        e = date;
        if (collection != null)
        {
            collection = new HashSet(collection);
        } else
        {
            collection = new HashSet();
        }
        f = Collections.unmodifiableSet(collection);
        if (collection1 != null)
        {
            collection = new HashSet(collection1);
        } else
        {
            collection = new HashSet();
        }
        g = Collections.unmodifiableSet(collection);
        h = s1;
        if (c1 == null)
        {
            c1 = d;
        }
        i = c1;
        if (date1 == null)
        {
            date1 = c;
        }
        j = date1;
        k = s2;
        l = s3;
    }

    public static AccessToken a()
    {
        return com.facebook.b.a().b();
    }

    static AccessToken a(Bundle bundle)
    {
        List list = a(bundle, "com.facebook.TokenCachingStrategy.Permissions");
        List list1 = a(bundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
        String s2 = r.d(bundle);
        String s1 = s2;
        if (kb.a(s2))
        {
            s1 = com.facebook.k.i();
        }
        s2 = r.b(bundle);
        Object obj = kb.d(s2);
        try
        {
            obj = ((JSONObject) (obj)).getString("id");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return null;
        }
        return new AccessToken(s2, s1, ((String) (obj)), list, list1, r.c(bundle), r.a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), r.a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"));
    }

    static AccessToken a(JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject.getInt("version") > 1)
        {
            throw new h("Unknown AccessToken serialization format.");
        } else
        {
            String s1 = jsonobject.getString("token");
            Date date = new Date(jsonobject.getLong("expires_at"));
            JSONArray jsonarray = jsonobject.getJSONArray("permissions");
            JSONArray jsonarray1 = jsonobject.getJSONArray("declined_permissions");
            Date date1 = new Date(jsonobject.getLong("last_refresh"));
            c c1 = com.facebook.c.valueOf(jsonobject.getString("source"));
            return new AccessToken(s1, jsonobject.getString("application_id"), jsonobject.getString("user_id"), kb.a(jsonarray), kb.a(jsonarray1), c1, date, date1);
        }
    }

    static List a(Bundle bundle, String s1)
    {
        bundle = bundle.getStringArrayList(s1);
        if (bundle == null)
        {
            return Collections.emptyList();
        } else
        {
            return Collections.unmodifiableList(new ArrayList(bundle));
        }
    }

    public static void a(AccessToken accesstoken)
    {
        com.facebook.b.a().a(accesstoken);
    }

    private void a(StringBuilder stringbuilder)
    {
        stringbuilder.append(" permissions:");
        if (f == null)
        {
            stringbuilder.append("null");
            return;
        } else
        {
            stringbuilder.append("[");
            stringbuilder.append(TextUtils.join(", ", f));
            stringbuilder.append("]");
            return;
        }
    }

    private String k()
    {
        if (h == null)
        {
            return "null";
        }
        if (com.facebook.k.a(s.b))
        {
            return h;
        } else
        {
            return "ACCESS_TOKEN_REMOVED";
        }
    }

    public String b()
    {
        return h;
    }

    public Date c()
    {
        return e;
    }

    public Set d()
    {
        return f;
    }

    public int describeContents()
    {
        return 0;
    }

    public Set e()
    {
        return g;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof AccessToken))
            {
                return false;
            }
            obj = (AccessToken)obj;
            if (!e.equals(((AccessToken) (obj)).e) || !f.equals(((AccessToken) (obj)).f) || !g.equals(((AccessToken) (obj)).g) || !h.equals(((AccessToken) (obj)).h) || i != ((AccessToken) (obj)).i || !j.equals(((AccessToken) (obj)).j) || (k != null ? !k.equals(((AccessToken) (obj)).k) : ((AccessToken) (obj)).k != null) || !l.equals(((AccessToken) (obj)).l))
            {
                return false;
            }
        }
        return true;
    }

    public c f()
    {
        return i;
    }

    public Date g()
    {
        return j;
    }

    public String h()
    {
        return k;
    }

    public int hashCode()
    {
        int j1 = e.hashCode();
        int k1 = f.hashCode();
        int l1 = g.hashCode();
        int i2 = h.hashCode();
        int j2 = i.hashCode();
        int k2 = j.hashCode();
        int i1;
        if (k == null)
        {
            i1 = 0;
        } else
        {
            i1 = k.hashCode();
        }
        return (i1 + ((((((j1 + 527) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31) * 31 + l.hashCode();
    }

    public String i()
    {
        return l;
    }

    JSONObject j()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("version", 1);
        jsonobject.put("token", h);
        jsonobject.put("expires_at", e.getTime());
        jsonobject.put("permissions", new JSONArray(f));
        jsonobject.put("declined_permissions", new JSONArray(g));
        jsonobject.put("last_refresh", j.getTime());
        jsonobject.put("source", i.name());
        jsonobject.put("application_id", k);
        jsonobject.put("user_id", l);
        return jsonobject;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{AccessToken");
        stringbuilder.append(" token:").append(k());
        a(stringbuilder);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeLong(e.getTime());
        parcel.writeStringList(new ArrayList(f));
        parcel.writeStringList(new ArrayList(g));
        parcel.writeString(h);
        parcel.writeString(i.name());
        parcel.writeLong(j.getTime());
        parcel.writeString(k);
        parcel.writeString(l);
    }

    static 
    {
        a = new Date(0x7fffffffffffffffL);
        b = a;
        d = c.b;
    }
}
