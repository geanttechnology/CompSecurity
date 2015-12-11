// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import io.presage.do.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.actions:
//            a

public final class h extends a
{

    public h(String s, String s1, e e1)
    {
        super(s, s1, e1);
    }

    public final String k()
    {
        if (a().equals("home"))
        {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(0x10000000);
            h().startActivity(intent);
            o();
            return null;
        }
        HashMap hashmap = (HashMap)(new Gson()).fromJson(b().b("extra"), java/util/Map);
        String s3 = b().b("flag");
        String s2 = b().b("category");
        String s4 = b().b("data");
        String s6 = b().b("action");
        Object obj = b().b("type");
        String s = b().b("component_pkg");
        String s1 = b().b("component_cls");
        if (obj != null && ((String) (obj)).length() > 0)
        {
            obj = new Intent(((String) (obj)));
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            if (s4 != null && s4.length() > 0)
            {
                ((Intent) (obj)).setData(Uri.parse(s4));
            }
            if (s6 != null && s6.length() > 0)
            {
                ((Intent) (obj)).setAction(s6);
            }
            if (s3 != null && s3.length() > 0)
            {
                String as1[] = s3.split(",");
                int l = as1.length;
                for (int i = 0; i < l; i++)
                {
                    ((Intent) (obj)).addFlags(Integer.parseInt(as1[i].trim()));
                }

            }
            if (hashmap != null)
            {
                String s5;
                for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); ((Intent) (obj)).putExtra(s5, (String)hashmap.get(s5)))
                {
                    s5 = (String)iterator.next();
                }

            }
            if (s2 != null && s2.length() > 0)
            {
                String as[] = s2.split(",");
                int i1 = as.length;
                for (int j = 0; j < i1; j++)
                {
                    ((Intent) (obj)).addCategory(as[j].trim());
                }

            }
            if (s != null && s.length() > 0 && s1 != null && s1.length() > 0)
            {
                ((Intent) (obj)).setComponent(new ComponentName(s, s1));
            }
            h().startActivity(((Intent) (obj)));
        }
        n();
        return null;
    }
}
