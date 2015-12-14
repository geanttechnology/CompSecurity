// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.service.collage;

import com.fotoable.photocollage.model.res.collage.TPhotoCollageComposeInfo;
import java.util.ArrayList;
import java.util.List;
import lo;
import lp;
import lq;
import lr;
import ls;
import lt;
import lu;
import lv;
import lw;
import lx;

public class FixComposeResourceManager
{

    private List a;
    private List b;

    public FixComposeResourceManager()
    {
        a = new ArrayList();
        b = new ArrayList();
    }

    private void a()
    {
        List list = lo.b();
        b.addAll(list);
        list = lq.b();
        b.addAll(list);
        list = lr.b();
        b.addAll(list);
        list = ls.b();
        b.addAll(list);
        list = lt.b();
        b.addAll(list);
        list = lu.b();
        b.addAll(list);
        list = lv.b();
        b.addAll(list);
        list = lw.b();
        b.addAll(list);
        list = lx.b();
        b.addAll(list);
        list = lp.b();
        b.addAll(list);
    }

    private void b()
    {
        List list = lp.a();
        a.addAll(list);
        list = lx.a();
        a.addAll(list);
        list = lw.a();
        a.addAll(list);
        list = lv.a();
        a.addAll(list);
        list = lu.a();
        a.addAll(list);
        list = lt.a();
        a.addAll(list);
        list = ls.a();
        a.addAll(list);
        list = lr.a();
        a.addAll(list);
        list = lq.a();
        a.addAll(list);
        list = lo.a();
        a.addAll(list);
    }

    public List a(FixComposeType fixcomposetype)
    {
        if (fixcomposetype == FixComposeType.COMPOSE_11)
        {
            if (a.size() == 0)
            {
                b();
            }
            return a;
        }
        if (fixcomposetype == FixComposeType.COMPOSE_43)
        {
            if (b.size() == 0)
            {
                a();
            }
            return b;
        } else
        {
            return new ArrayList();
        }
    }

    public List a(FixComposeType fixcomposetype, int i)
    {
        fixcomposetype = a(fixcomposetype);
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < fixcomposetype.size(); j++)
        {
            TPhotoCollageComposeInfo tphotocollagecomposeinfo = (TPhotoCollageComposeInfo)fixcomposetype.get(j);
            if (tphotocollagecomposeinfo.getPhotoFrameArray() != null && tphotocollagecomposeinfo.getPhotoFrameArray().size() == i || tphotocollagecomposeinfo.getTrackPointsArray() != null && tphotocollagecomposeinfo.getTrackPointsArray().size() == i)
            {
                arraylist.add(tphotocollagecomposeinfo);
            }
        }

        return arraylist;
    }

    private class FixComposeType extends Enum
    {

        private static final FixComposeType $VALUES[];
        public static final FixComposeType COMPOSE_11;
        public static final FixComposeType COMPOSE_43;

        public static FixComposeType valueOf(String s)
        {
            return (FixComposeType)Enum.valueOf(com/fotoable/photocollage/service/collage/FixComposeResourceManager$FixComposeType, s);
        }

        public static FixComposeType[] values()
        {
            return (FixComposeType[])$VALUES.clone();
        }

        static 
        {
            COMPOSE_11 = new FixComposeType("COMPOSE_11", 0);
            COMPOSE_43 = new FixComposeType("COMPOSE_43", 1);
            $VALUES = (new FixComposeType[] {
                COMPOSE_11, COMPOSE_43
            });
        }

        private FixComposeType(String s, int i)
        {
            super(s, i);
        }
    }

}
