// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import com.smule.android.c.aa;
import com.smule.magicpiano.PianoCoreBridge;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.smule.pianoandroid.utils:
//            n

public class g
{

    private static final String a = com/smule/pianoandroid/utils/g.getName();

    public g()
    {
    }

    public static void a(String s, int i, int j)
    {
        aa.a(a, "trimCache - start");
        Object obj1 = new ArrayList();
        Object obj = new HashMap();
        s = (new File(s)).listFiles();
        if (s != null)
        {
            int i1 = s.length;
            for (int k = 0; k < i1; k++)
            {
                String s1 = s[k].getPath();
                ((Map) (obj)).put(s1, Integer.valueOf(PianoCoreBridge.getFileLastAccessedTime(s1)));
            }

        }
        if (j != 0)
        {
            int l = (int)((float)System.currentTimeMillis() / 1000F);
            s = ((Map) (obj)).entrySet().iterator();
            do
            {
                if (!s.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)s.next();
                if (((Integer)entry.getValue()).intValue() + j < l)
                {
                    ((List) (obj1)).add(entry.getKey());
                    ((Map) (obj)).remove(entry.getKey());
                }
            } while (true);
        }
        if (i != 0)
        {
            s = n.a(((Map) (obj)));
            for (j = 0; j < s.size() - i; j++)
            {
                ((List) (obj1)).add(((java.util.Map.Entry)s.get(j)).getKey());
            }

        }
        for (s = ((List) (obj1)).iterator(); s.hasNext(); aa.a(a, (new StringBuilder()).append("trimCache - deleting: ").append(((String) (obj1))).toString()))
        {
            obj1 = (String)s.next();
            File file = new File(((String) (obj1)));
            if (file.isDirectory())
            {
                File afile[] = file.listFiles();
                j = afile.length;
                for (i = 0; i < j; i++)
                {
                    if (!afile[i].delete())
                    {
                        aa.b(a, (new StringBuilder()).append("trimCache - Could not delete cache file: ").append(((String) (obj1))).toString());
                    }
                }

            }
            if (!file.delete())
            {
                aa.b(a, (new StringBuilder()).append("trimCache - Could not delete cache file: ").append(((String) (obj1))).toString());
            }
            ((Map) (obj)).remove(obj1);
        }

        for (s = ((Map) (obj)).entrySet().iterator(); s.hasNext(); PianoCoreBridge.setFileLastAccessedTime((String)((java.util.Map.Entry) (obj)).getKey(), ((Integer)((java.util.Map.Entry) (obj)).getValue()).intValue()))
        {
            obj = (java.util.Map.Entry)s.next();
        }

        aa.a(a, "trimCache - end");
    }

}
