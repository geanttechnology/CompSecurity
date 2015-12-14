// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.model.res.TResInfo;
import com.wantu.piprender.ESceneMode;
import java.util.ArrayList;
import java.util.List;

public class tj
{

    private ArrayList a;
    private tk b;

    public tj()
    {
        a = new ArrayList(0);
    }

    public ESceneMode a(EOnlineResType eonlinerestype)
    {
        if (eonlinerestype == EOnlineResType.PIP_SCENE)
        {
            return ESceneMode.SCENE_MODE1;
        }
        if (eonlinerestype == EOnlineResType.PIP_SCENE2)
        {
            return ESceneMode.SCENE_MODE2;
        } else
        {
            return ESceneMode.SCENE_MODE1;
        }
    }

    public void a(TResInfo tresinfo, EOnlineResType eonlinerestype)
    {
        kf.c().d().a(a(eonlinerestype));
        kf.c().d().a(tresinfo);
    }

    public void a(List list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            Object obj = (String)list.get(i);
            EOnlineResType eonlinerestype = tu.getResTypeByString(((String) (obj)));
            kf.c().d().a(a(eonlinerestype));
            List list1 = kf.c().d().b();
            if (list1 == null)
            {
                continue;
            }
            ti ti1 = new ti();
            ti1.a = ((String) (obj));
            ti1.b = eonlinerestype;
            obj = new ArrayList(list1.size());
            for (int j = 0; j < list1.size(); j++)
            {
                ((ArrayList) (obj)).add((TResInfo)list1.get(j));
            }

            ti1.c = ((ArrayList) (obj));
            a.add(ti1);
        }

        if (b != null)
        {
            b.a(a);
        }
    }

    public void a(tk tk1)
    {
        b = tk1;
    }
}
