// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.mosaic.MosaicInfo;
import com.wantu.model.res.TFrameItemInfo;
import java.util.ArrayList;
import java.util.List;

public class alh
{

    private ArrayList a;
    private ArrayList b;

    public alh()
    {
    }

    private void c()
    {
        b = new ArrayList();
        for (int i = 0; i <= 15; i++)
        {
            MosaicInfo mosaicinfo = new MosaicInfo();
            mosaicinfo.a = com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Paint_Normal;
            mosaicinfo.d = String.format("mosaicRes/paintBrush/paintBrush%d.png", new Object[] {
                Integer.valueOf(i)
            });
            mosaicinfo.f = String.format("mosaicRes/paintBrush/paintBrush%d.png", new Object[] {
                Integer.valueOf(i)
            });
            b.add(mosaicinfo);
        }

        for (int j = 1; j <= 6; j++)
        {
            MosaicInfo mosaicinfo1 = new MosaicInfo();
            mosaicinfo1.a = com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Paint_3D;
            mosaicinfo1.e = String.format("mosaicRes/paint3DBrush/3dbrush%d.png", new Object[] {
                Integer.valueOf(j)
            });
            mosaicinfo1.f = String.format("mosaicRes/paint3DBrush/3dbrush%d.png", new Object[] {
                Integer.valueOf(j)
            });
            b.add(mosaicinfo1);
        }

    }

    private void d()
    {
        a = new ArrayList();
        Object obj = new MosaicInfo();
        obj.a = com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Maoboli;
        obj.f = "mosaicRes/mosaicBrushIcon/maoboli.jpg";
        a.add(obj);
        obj = new MosaicInfo();
        obj.a = com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Normal;
        obj.f = "mosaicRes/mosaicBrushIcon/mosaic.jpg";
        a.add(obj);
        for (int i = 1; i <= 11; i++)
        {
            obj = new MosaicInfo();
            obj.a = com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Youhua;
            obj.b = String.format("mosaicRes/mosaicBrush/%d.png", new Object[] {
                Integer.valueOf(i)
            });
            obj.f = String.format("mosaicRes/mosaicBrushIcon/n%d.jpg", new Object[] {
                Integer.valueOf(i)
            });
            a.add(obj);
        }

        obj = (new boa()).a();
        int j = 0;
        while (j < ((List) (obj)).size() - 10) 
        {
            TFrameItemInfo tframeiteminfo = (TFrameItemInfo)((List) (obj)).get(j);
            if (!tframeiteminfo.icon.equals(""))
            {
                MosaicInfo mosaicinfo = new MosaicInfo();
                mosaicinfo.a = com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Image;
                mosaicinfo.c = tframeiteminfo.imageURL;
                mosaicinfo.f = tframeiteminfo.icon;
                a.add(mosaicinfo);
            }
            j++;
        }
    }

    public ArrayList a()
    {
        if (a == null)
        {
            d();
        }
        return a;
    }

    public ArrayList b()
    {
        if (b == null)
        {
            c();
        }
        return b;
    }
}
