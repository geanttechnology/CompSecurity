// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import com.cyberlink.beautycircle.model.CircleBasic;
import java.util.Comparator;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CirclePager

class a
    implements Comparator
{

    final CirclePager a;

    public int a(CircleBasic circlebasic, CircleBasic circlebasic1)
    {
        return circlebasic.id.compareTo(circlebasic1.id);
    }

    public int compare(Object obj, Object obj1)
    {
        return a((CircleBasic)obj, (CircleBasic)obj1);
    }

    (CirclePager circlepager)
    {
        a = circlepager;
        super();
    }
}
