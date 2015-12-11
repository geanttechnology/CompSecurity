// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.mobile.experimentation.Experiments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.mobile.dcs:
//            DcsTest

public static final class ents
    implements com.ebay.nautilus.domain.dcs.
{

    public List getProperties()
    {
        List list = Experiments.getExperiments();
        ArrayList arraylist = new ArrayList(list.size());
        arraylist.addAll(list);
        return Collections.unmodifiableList(arraylist);
    }

    public ents()
    {
    }
}
