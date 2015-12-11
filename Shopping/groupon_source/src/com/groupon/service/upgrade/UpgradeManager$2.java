// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.upgrade;

import java.lang.reflect.Method;
import java.util.Comparator;

// Referenced classes of package com.groupon.service.upgrade:
//            UpgradeManager

class this._cls0
    implements Comparator
{

    final UpgradeManager this$0;

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Method)obj, (Method)obj1);
    }

    public int compare(Method method, Method method1)
    {
        return ((nIfUpgradingFrom)method.getAnnotation(com/groupon/service/upgrade/UpgradeManager$RunIfUpgradingFrom)).value() - ((nIfUpgradingFrom)method1.getAnnotation(com/groupon/service/upgrade/UpgradeManager$RunIfUpgradingFrom)).value();
    }

    nIfUpgradingFrom()
    {
        this$0 = UpgradeManager.this;
        super();
    }
}
