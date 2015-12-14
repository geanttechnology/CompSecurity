// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.List;

public class bgb
{

    private ArrayList a;
    private bgv b;
    private bgc c;

    public bgb()
    {
        a = new ArrayList(0);
    }

    public void a(bgc bgc1)
    {
        c = bgc1;
    }

    public void a(TResInfo tresinfo, EOnlineResType eonlinerestype)
    {
        if (b == null || b.getType() != eonlinerestype)
        {
            b = bgs.a(eonlinerestype);
            b.deleteInfo(tresinfo);
            return;
        } else
        {
            b.deleteInfo(tresinfo);
            return;
        }
    }

    public void a(List list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            Object obj = (String)list.get(i);
            EOnlineResType eonlinerestype = bgv.getResTypeByString(((String) (obj)));
            b = bgs.a(eonlinerestype);
            List list1 = b.netMaterials();
            if (list1 == null)
            {
                continue;
            }
            bga bga1 = new bga();
            bga1.a = ((String) (obj));
            bga1.b = eonlinerestype;
            obj = new ArrayList(list1.size());
            for (int j = 0; j < list1.size(); j++)
            {
                ((ArrayList) (obj)).add((TResInfo)list1.get(j));
            }

            bga1.c = ((ArrayList) (obj));
            a.add(bga1);
        }

        if (c != null)
        {
            c.a(a);
        }
    }
}
