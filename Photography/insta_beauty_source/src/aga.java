// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.imagelib.filter.TImageFilterManager;
import com.wantu.view.TFilterListScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class aga
    implements Runnable
{

    final afz a;

    aga(afz afz1)
    {
        a = afz1;
        super();
    }

    public void run()
    {
        a.d.a.addFilterItem(ProEditFilterActivity.o(a.d), a.d.getResources().getString(0x7f0601a0));
        agi agi1;
        for (Iterator iterator = a.a.iterator(); iterator.hasNext(); ProEditFilterActivity.p(a.d).add(agi1))
        {
            Object obj = (String)iterator.next();
            obj = (TImageFilterInfo)a.b.get(obj);
            a.d.a.addFilterItem(ProEditFilterActivity.o(a.d), ((TImageFilterInfo) (obj)).filterName);
            agi1 = new agi(a.d, null);
            agi1.a = ((TImageFilterInfo) (obj)).filterName;
            agi1.b = 0;
        }

        a.d.a.setCallback(a.d);
        a.d.b.addFilterItem(ProEditFilterActivity.o(a.d), a.d.getResources().getString(0x7f0601a0));
        agi agi2;
        for (Iterator iterator1 = a.c.iterator(); iterator1.hasNext(); ProEditFilterActivity.j(a.d).add(agi2))
        {
            Object obj1 = (String)iterator1.next();
            obj1 = (TImageFilterInfo)a.b.get(obj1);
            a.d.b.addFilterItem(ProEditFilterActivity.o(a.d), ((TImageFilterInfo) (obj1)).filterName);
            agi2 = new agi(a.d, null);
            agi2.a = ((TImageFilterInfo) (obj1)).filterName;
            agi2.b = 1;
        }

        a.d.b.setCallback(a.d);
        a.d.c.addFilterItem(ProEditFilterActivity.o(a.d), a.d.getResources().getString(0x7f0601a0));
        if (!InstaBeautyApplication.d())
        {
            agi agi3;
            for (Iterator iterator2 = ProEditFilterActivity.a(a.d, a.d).filterNamesByCatalogeName("arts").iterator(); iterator2.hasNext(); ProEditFilterActivity.m(a.d).add(agi3))
            {
                Object obj2 = (String)iterator2.next();
                obj2 = (TImageFilterInfo)a.b.get(obj2);
                a.d.c.addFilterItem(ProEditFilterActivity.o(a.d), ((TImageFilterInfo) (obj2)).filterName);
                agi3 = new agi(a.d, null);
                agi3.a = ((TImageFilterInfo) (obj2)).filterName;
                agi3.b = 2;
            }

            a.d.c.setCallback(a.d);
        }
        if (ProEditFilterActivity.q(a.d))
        {
            ProEditFilterActivity.e(a.d, false);
            ProEditFilterActivity.a(a.d, ProEditFilterActivity.p(a.d), 0);
        }
    }
}
