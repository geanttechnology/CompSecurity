// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.millennialmedia.android:
//            ai, ao, aj, an, 
//            u

final class i extends ai
{

    i()
    {
    }

    final aj a(String s, Map map)
    {
        int i1 = 0;
        if ("resize".equals(s))
        {
            s = (ao)c.get();
            if (s != null)
            {
                if (s.q())
                {
                    return aj.b("State is currently resized");
                }
                String s1 = (String)map.get("width");
                Object obj = (String)map.get("height");
                String s2;
                int j;
                int k;
                int l;
                int j1;
                int k1;
                boolean flag;
                if (!TextUtils.isEmpty(s1))
                {
                    j = (int)Float.parseFloat(s1);
                } else
                {
                    j = 0;
                }
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    k = (int)Float.parseFloat(((String) (obj)));
                } else
                {
                    k = 0;
                }
                s1 = (String)map.get("customClosePosition");
                obj = (String)map.get("offsetX");
                s2 = (String)map.get("offsetY");
                if (!TextUtils.isEmpty(s2))
                {
                    l = (int)Float.parseFloat(s2);
                } else
                {
                    l = 0;
                }
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    i1 = (int)Float.parseFloat(((String) (obj)));
                }
                flag = Boolean.parseBoolean((String)map.get("allowOffscreen"));
                map = s.getContext();
                obj = map.getResources().getDisplayMetrics();
                j1 = Integer.parseInt(an.f(map));
                k1 = Integer.parseInt(an.g(map));
                s.a(new u(((DisplayMetrics) (obj)).density, j, k, s1, i1, l, flag, j1, k1));
                return aj.a("Success.");
            } else
            {
                return null;
            }
        } else
        {
            return null;
        }
    }
}
