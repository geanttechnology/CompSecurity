// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            RefinementLink

public interface RefinementFilter
{

    public abstract List getAncestry();

    public abstract RefinementLink getClearLink();

    public abstract String getDetail();

    public abstract String getGroup();

    public abstract String getId();

    public abstract String getLabel();

    public abstract boolean getRemovesSiblings();

    public abstract String getType();

    public abstract List getValues();
}
