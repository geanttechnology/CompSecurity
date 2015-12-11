// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class cgz
{

    final SharedPreferences a;
    List b;
    boolean c;

    public cgz(SharedPreferences sharedpreferences)
    {
        a = (SharedPreferences)b.b(sharedpreferences, "preferences can not be null");
        c = false;
    }

    public List a()
    {
        if (c)
        {
            return b;
        }
        if (!a.contains("screenIds"))
        {
            b = new ArrayList();
        } else
        {
            String as[] = a.getString("screenIds", "").split(",");
            String as1[] = a.getString("screenNames", "").split(",");
            ArrayList arraylist = new ArrayList();
            int i = 0;
            while (i < as.length) 
            {
                String s = as[i];
                if (!TextUtils.isEmpty(s))
                {
                    cgr cgr1 = new cgr(s);
                    if (i < as1.length)
                    {
                        s = as1[i];
                    } else
                    {
                        s = "";
                    }
                    arraylist.add(new cgc(cgr1, s, null, null));
                }
                i++;
            }
            b = arraylist;
        }
        c = true;
        return b;
    }
}
