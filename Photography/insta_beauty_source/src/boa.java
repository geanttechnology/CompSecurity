// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.model.res.EResProcessType;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TFrameItemInfo;
import java.util.ArrayList;
import java.util.List;

public class boa
{

    private List a;

    public boa()
    {
        a = new ArrayList();
    }

    private void b()
    {
        a(TFrameItemInfo.ItemByInfo("black", "freestyle/icon_black.png", EResType.ASSET, EResProcessType.OTHER, 0xff000000));
        a(TFrameItemInfo.ItemByInfo("white", "freestyle/icon_white.png", EResType.ASSET, EResProcessType.OTHER, -1));
        TFrameItemInfo tframeiteminfo = TFrameItemInfo.ItemByInfo("01", "fixComposeStyle/bg2/01_icon.jpg", EResType.ASSET, EResProcessType.OTHER, "fixComposeStyle/bg2/01.jpg");
        tframeiteminfo.isTiledImage = true;
        a(tframeiteminfo);
        tframeiteminfo = TFrameItemInfo.ItemByInfo("011", "fixComposeStyle/bg2/011_icon.jpg", EResType.ASSET, EResProcessType.OTHER, "fixComposeStyle/bg2/011.jpg");
        tframeiteminfo.isTiledImage = true;
        a(tframeiteminfo);
        tframeiteminfo = TFrameItemInfo.ItemByInfo("02", "fixComposeStyle/bg2/02_icon.jpg", EResType.ASSET, EResProcessType.OTHER, "fixComposeStyle/bg2/02.jpg");
        tframeiteminfo.isTiledImage = true;
        a(tframeiteminfo);
        tframeiteminfo = TFrameItemInfo.ItemByInfo("03", "fixComposeStyle/bg2/03_icon.jpg", EResType.ASSET, EResProcessType.OTHER, "fixComposeStyle/bg2/03.jpg");
        tframeiteminfo.isTiledImage = true;
        a(tframeiteminfo);
        tframeiteminfo = TFrameItemInfo.ItemByInfo("04", "fixComposeStyle/bg2/04_icon.jpg", EResType.ASSET, EResProcessType.OTHER, "fixComposeStyle/bg2/04.jpg");
        tframeiteminfo.isTiledImage = true;
        a(tframeiteminfo);
        tframeiteminfo = TFrameItemInfo.ItemByInfo("05", "fixComposeStyle/bg2/05_icon.jpg", EResType.ASSET, EResProcessType.OTHER, "fixComposeStyle/bg2/05.jpg");
        tframeiteminfo.isTiledImage = true;
        a(tframeiteminfo);
        tframeiteminfo = TFrameItemInfo.ItemByInfo("06", "fixComposeStyle/bg2/06_icon.jpg", EResType.ASSET, EResProcessType.OTHER, "fixComposeStyle/bg2/06.jpg");
        tframeiteminfo.isTiledImage = true;
        a(tframeiteminfo);
        tframeiteminfo = TFrameItemInfo.ItemByInfo("zhiyang_01", "fixComposeStyle/bg2/zhiyang_01_icon.png", EResType.ASSET, EResProcessType.OTHER, "fixComposeStyle/bg2/zhiyang_01.png");
        tframeiteminfo.isTiledImage = true;
        a(tframeiteminfo);
        tframeiteminfo = TFrameItemInfo.ItemByInfo("zhiyang_02", "fixComposeStyle/bg2/zhiyang_02_icon.png", EResType.ASSET, EResProcessType.OTHER, "fixComposeStyle/bg2/zhiyang_02.png");
        tframeiteminfo.isTiledImage = true;
        a(tframeiteminfo);
        tframeiteminfo = TFrameItemInfo.ItemByInfo("zhiyang_03", "fixComposeStyle/bg2/zhiyang_03_icon.png", EResType.ASSET, EResProcessType.OTHER, "fixComposeStyle/bg2/zhiyang_03.png");
        tframeiteminfo.isTiledImage = true;
        a(tframeiteminfo);
        tframeiteminfo = TFrameItemInfo.ItemByInfo("zhiyang_04", "fixComposeStyle/bg2/zhiyang_04_icon.png", EResType.ASSET, EResProcessType.OTHER, "fixComposeStyle/bg2/zhiyang_04.png");
        tframeiteminfo.isTiledImage = true;
        a(tframeiteminfo);
    }

    public List a()
    {
        if (a.size() == 0)
        {
            b();
        }
        return a;
    }

    public void a(TFrameItemInfo tframeiteminfo)
    {
        a.add(tframeiteminfo);
    }
}
