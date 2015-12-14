// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.imagelib.filter.TImageFilterInfo;
import java.util.ArrayList;

public class bgq extends bgm
{

    public bgq()
    {
    }

    protected bgj a()
    {
        return new bgp();
    }

    protected String a(Object obj)
    {
        obj = (TImageFilterInfo)obj;
        String s = bgx.a();
        return String.format("%s&type=%s&name=%s&%s", new Object[] {
            bgx.m, bgv.getStringByResType(d.b), ((TImageFilterInfo) (obj)).name, s
        });
    }

    protected String a(ArrayList arraylist)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        while (i < arraylist.size()) 
        {
            String s = ((TImageFilterInfo)arraylist.get(i)).filterName;
            if (s.compareToIgnoreCase("0") != 0)
            {
                if (stringbuilder.length() != 0)
                {
                    stringbuilder.append(",");
                } else
                {
                    stringbuilder.append("&existNames=");
                }
                stringbuilder.append(s);
            }
            i++;
        }
        arraylist = bgx.a();
        return String.format("%s&type=%s&materialtype=%s&%s%s", new Object[] {
            bgx.l, bgv.getStringByResType(d.b), d.a, arraylist, stringbuilder.toString()
        });
    }
}
