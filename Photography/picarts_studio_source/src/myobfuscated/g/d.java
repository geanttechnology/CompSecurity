// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.g;

import bo.app.br;
import bo.app.ec;
import bo.app.eo;
import com.appboy.Constants;
import com.appboy.enums.AppStore;
import myobfuscated.i.a;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.g:
//            c

public final class d extends c
{

    private static final String t;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public double e;
    public int f;
    public final double n;
    public final String o;
    public String p;
    public String q;
    public AppStore r;
    public String s;

    public d(JSONObject jsonobject, br br, ec ec)
    {
        super(jsonobject, br, ec);
        a = jsonobject.getString("title");
        b = jsonobject.getString("subtitle");
        c = jsonobject.getString("caption");
        d = jsonobject.getString("image");
        try
        {
            e = jsonobject.getDouble("rating");
            f = jsonobject.getInt("reviews");
        }
        // Misplaced declaration of an exception variable
        catch (br br)
        {
            e = 0.0D;
            f = 0;
        }
        if (jsonobject.has("package"))
        {
            p = jsonobject.getString("package");
        }
        if (jsonobject.has("kindle_id"))
        {
            q = jsonobject.getString("kindle_id");
        }
        n = jsonobject.getDouble("price");
        if (jsonobject.has("display_price"))
        {
            s = jsonobject.getString("display_price");
        }
        o = jsonobject.getString("url");
        if (eo.a(jsonobject, "store") == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        jsonobject = eo.a(jsonobject, "store");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        r = AppStore.valueOf(AppStore.serverStringToEnumString(jsonobject));
        return;
        try
        {
            r = AppStore.GOOGLE_PLAY_STORE;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            myobfuscated.i.a.c(t, "Caught exception creating cross promotion small card Json.", jsonobject);
        }
        r = AppStore.GOOGLE_PLAY_STORE;
        return;
    }

    public final String toString()
    {
        return (new StringBuilder("CrossPromotionSmallCard{mId='")).append(g).append('\'').append(", mViewed='").append(h).append('\'').append(", mCreated='").append(j).append('\'').append(", mUpdated='").append(k).append('\'').append(", mTitle='").append(a).append('\'').append(", mSubtitle='").append(b).append('\'').append(", mCaption='").append(c).append('\'').append(", mImageUrl='").append(d).append('\'').append(", mRating=").append(e).append(", mReviewCount=").append(f).append(", mPrice=").append(n).append(", mPackage=").append(p).append(", mUrl='").append(o).append('\'').append(", mAppStore='").append(r).append('\'').append(", mKindleId='").append(q).append('\'').append(", mDisplayPrice='").append(s).append('\'').append("}").toString();
    }

    static 
    {
        t = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, myobfuscated/g/d.getName()
        });
    }
}
