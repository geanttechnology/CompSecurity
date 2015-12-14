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

public final class a extends c
{

    public final String a;
    public final String b;
    public final String c;
    public final float d;

    public a(JSONObject jsonobject, br br, ec ec)
    {
        super(jsonobject, br, ec);
        a = jsonobject.getString("image");
        b = eo.a(jsonobject, "url");
        c = eo.a(jsonobject, "domain");
        d = (float)jsonobject.optDouble("aspect_ratio", 0.0D);
    }

    public final String toString()
    {
        return (new StringBuilder("BannerImageCard{mId='")).append(g).append('\'').append(", mViewed='").append(h).append('\'').append(", mCreated='").append(j).append('\'').append(", mUpdated='").append(k).append('\'').append(", mImageUrl='").append(a).append('\'').append(", mUrl='").append(b).append('\'').append(", mDomain='").append(c).append('\'').append(", mAspectRatio='").append(d).append('\'').append("}").toString();
    }
}
