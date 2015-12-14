// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res;

import java.util.ArrayList;

// Referenced classes of package com.wantu.model.res:
//            TResInfo, TPhotoFreeComposeLayoutInfo

public class TPhotoFreeFrameLayoutInfo extends TResInfo
{

    public Boolean disableRotate;
    public boolean isRect;
    public ArrayList layoutInfoes;

    public TPhotoFreeFrameLayoutInfo()
    {
        isRect = false;
        layoutInfoes = new ArrayList();
    }

    public void addLayoutInfo(TPhotoFreeComposeLayoutInfo tphotofreecomposelayoutinfo)
    {
        layoutInfoes.add(tphotofreecomposelayoutinfo);
    }
}
