// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import com.appnexus.opensdk.b.k;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            GooglePlayDFPBanner

class a
{

    public boolean a;
    public String b;
    public boolean c;
    final GooglePlayDFPBanner d;

    private static boolean a(JSONObject jsonobject, String s)
    {
        boolean flag = false;
        boolean flag1 = jsonobject.getBoolean(s);
        flag = flag1;
_L2:
        return flag;
        JSONException jsonexception;
        jsonexception;
        int i;
        try
        {
            i = jsonobject.getInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return false;
        }
        switch (i)
        {
        default:
            return false;

        case 1: // '\001'
            return true;

        case 0: // '\0'
            break;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public (GooglePlayDFPBanner googleplaydfpbanner, String s)
    {
        d = googleplaydfpbanner;
        super();
        a = false;
        c = false;
        if (k.a(s))
        {
            break MISSING_BLOCK_LABEL_55;
        }
        googleplaydfpbanner = new JSONObject(s);
        c = a(googleplaydfpbanner, "smartbanner");
        a = a(googleplaydfpbanner, "swipeable");
        return;
        googleplaydfpbanner;
    }
}
