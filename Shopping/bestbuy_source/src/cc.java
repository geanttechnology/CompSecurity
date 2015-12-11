// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.bestbuy.android.api.lib.models.home.GroupedDeal;
import java.util.Comparator;

public class cc
    implements Comparator
{

    private cc()
    {
    }

    public cc(com.bestbuy.android.activities.home.DODHomeCard._cls1 _pcls1)
    {
        this();
    }

    public int a(GroupedDeal groupeddeal, GroupedDeal groupeddeal1)
    {
        byte byte0;
        boolean flag;
        flag = false;
        byte0 = flag;
        if (groupeddeal.getWidgetType() == null) goto _L2; else goto _L1
_L1:
        byte0 = flag;
        if (groupeddeal.getWidgetType() == null) goto _L2; else goto _L3
_L3:
        if (!groupeddeal.getWidgetType().equalsIgnoreCase("feature") || groupeddeal.getWidgetType().equalsIgnoreCase(groupeddeal1.getWidgetType())) goto _L5; else goto _L4
_L4:
        byte0 = -1;
_L2:
        return byte0;
_L5:
        if (!groupeddeal.getWidgetType().equalsIgnoreCase("feature"))
        {
            break; /* Loop/switch isn't completed */
        }
        byte0 = flag;
        if (groupeddeal.getWidgetType().equalsIgnoreCase(groupeddeal1.getWidgetType())) goto _L2; else goto _L6
_L6:
        byte0 = flag;
        if (!groupeddeal.getWidgetType().equalsIgnoreCase("feature"))
        {
            byte0 = flag;
            if (groupeddeal1.getWidgetType().equalsIgnoreCase("feature"))
            {
                return 1;
            }
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public int compare(Object obj, Object obj1)
    {
        return a((GroupedDeal)obj, (GroupedDeal)obj1);
    }
}
