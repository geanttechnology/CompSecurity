// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchResult

public static interface er
{

    public abstract List getDataList();

    public abstract int getHigestPageLoaded();

    public abstract ResultStatus getLastResultStatus();

    public abstract void loadPage(int i);

    public abstract void setObserver(er er);
}
