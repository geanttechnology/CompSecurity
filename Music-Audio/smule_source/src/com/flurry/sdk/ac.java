// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.NativeAsset;
import com.flurry.android.impl.ads.protocol.v13.NativeAssetType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.sdk:
//            ap, ag, cy

public class ac
{

    private static final String a[] = new String[0];

    private static String a(AdFrame adframe)
    {
        while (adframe == null || adframe.display == null || adframe.binding != 3) 
        {
            return null;
        }
        return adframe.display;
    }

    private static String a(AdFrame adframe, String s)
    {
        if (adframe != null && !TextUtils.isEmpty(s) && adframe.content != null)
        {
            adframe = a(adframe.content, s);
            if (!TextUtils.isEmpty(adframe))
            {
                return adframe;
            }
        }
        return null;
    }

    private static String a(String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        s1 = null;
_L6:
        return s1;
_L2:
        String s2 = "";
        Iterator iterator;
        boolean flag;
        try
        {
            iterator = Arrays.asList(s1.split("\\s*-\\s*")).iterator();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        s1 = s2;
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = (String)iterator.next();
        s1 = (new JSONObject(s)).getString(s1);
        flag = TextUtils.isEmpty(s1);
        if (!flag)
        {
            s = s1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        break MISSING_BLOCK_LABEL_82;
_L4:
        break MISSING_BLOCK_LABEL_38;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static List a(ap ap1, int i)
    {
        if (ap1 == null)
        {
            return Collections.emptyList();
        }
        Object obj1 = ap1.b(i);
        if (obj1 == null)
        {
            return Collections.emptyList();
        }
        Object obj = ag.a(((AdFrame) (obj1)).cachingEnum);
        if (ag.a.equals(obj))
        {
            return Collections.emptyList();
        }
        obj = new ArrayList();
        if (((AdFrame) (obj1)).cacheWhitelistedAssets != null && ((AdFrame) (obj1)).cacheWhitelistedAssets.size() > 0)
        {
            ap1 = ((AdFrame) (obj1)).cacheWhitelistedAssets.iterator();
            do
            {
                if (!ap1.hasNext())
                {
                    break;
                }
                obj1 = (String)ap1.next();
                if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    ((List) (obj)).add(obj1);
                }
            } while (true);
        } else
        if (((AdFrame) (obj1)).binding == 7)
        {
            ap1 = ap1.i().iterator();
            do
            {
                if (!ap1.hasNext())
                {
                    break;
                }
                Object obj2 = (NativeAsset)ap1.next();
                if (NativeAssetType.IMAGE.equals(((NativeAsset) (obj2)).type))
                {
                    obj2 = ((NativeAsset) (obj2)).value;
                    if (!TextUtils.isEmpty(((CharSequence) (obj2))) && !a(((AdFrame) (obj1)).cacheBlacklistedAssets, ((String) (obj2))))
                    {
                        ((List) (obj)).add(obj2);
                    }
                }
            } while (true);
        } else
        {
            ap1 = b(ap1, i);
            if (!TextUtils.isEmpty(ap1) && !a(((AdFrame) (obj1)).cacheBlacklistedAssets, ((String) (ap1))))
            {
                ((List) (obj)).add(ap1);
            }
            ap1 = a(((AdFrame) (obj1)));
            if (!TextUtils.isEmpty(ap1) && !a(((AdFrame) (obj1)).cacheBlacklistedAssets, ((String) (ap1))))
            {
                ((List) (obj)).add(ap1);
            }
            ap1 = a;
            int j = ap1.length;
            for (i = 0; i < j; i++)
            {
                String s = a(((AdFrame) (obj1)), ap1[i]);
                if (!TextUtils.isEmpty(s) && !a(((AdFrame) (obj1)).cacheBlacklistedAssets, s))
                {
                    ((List) (obj)).add(s);
                }
            }

        }
        return ((List) (obj));
    }

    private static boolean a(List list, String s)
    {
        if (list == null)
        {
            return false;
        }
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            if (s.equals((String)list.next()))
            {
                return true;
            }
        }

        return false;
    }

    private static String b(ap ap1, int i)
    {
        ap1 = ap1.d(i);
        if (ap1 != null)
        {
            return ap1.f();
        } else
        {
            return null;
        }
    }

}
