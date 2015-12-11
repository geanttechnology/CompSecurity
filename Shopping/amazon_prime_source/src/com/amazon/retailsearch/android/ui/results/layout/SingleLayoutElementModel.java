// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            LayoutElementModel

public class SingleLayoutElementModel
    implements LayoutElementModel
{

    private Object canonicalModel;

    public SingleLayoutElementModel(Object obj)
    {
        canonicalModel = obj;
    }

    public static SingleLayoutElementModel create(Object obj)
    {
        return new SingleLayoutElementModel(obj);
    }

    public List getAllModels()
    {
        return Arrays.asList(new Object[] {
            canonicalModel
        });
    }

    public Object getCanonicalModel()
    {
        return canonicalModel;
    }
}
