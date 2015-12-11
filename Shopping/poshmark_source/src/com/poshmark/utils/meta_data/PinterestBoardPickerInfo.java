// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.utils.meta_data:
//            PinterestBoard

public class PinterestBoardPickerInfo
{

    public List allboards;
    public PinterestBoard currentSelection;

    public PinterestBoardPickerInfo()
    {
        allboards = new ArrayList();
    }

    public List getAllboards()
    {
        return allboards;
    }

    public PinterestBoard getCurrentSelection()
    {
        return currentSelection;
    }

    public void setAllboards(List list)
    {
        allboards.addAll(list);
    }

    public void setCurrentSelection(PinterestBoard pinterestboard)
    {
        currentSelection = pinterestboard;
    }
}
