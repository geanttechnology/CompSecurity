// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.g;

import bo.app.br;
import bo.app.ec;
import bo.app.eo;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.g:
//            c

public final class f extends c
{

    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public f(JSONObject jsonobject, br br, ec ec)
    {
        super(jsonobject, br, ec);
        b = eo.a(jsonobject, "title");
        a = jsonobject.getString("description");
        c = eo.a(jsonobject, "url");
        d = eo.a(jsonobject, "domain");
    }

    public final String toString()
    {
        return (new StringBuilder("TextAnnouncementCard{mId='")).append(g).append('\'').append(", mViewed='").append(h).append('\'').append(", mCreated='").append(j).append('\'').append(", mUpdated='").append(k).append('\'').append(", mDescription='").append(a).append('\'').append(", mTitle='").append(b).append('\'').append(", mUrl='").append(c).append('\'').append(", mDomain='").append(d).append('\'').append("}").toString();
    }
}
