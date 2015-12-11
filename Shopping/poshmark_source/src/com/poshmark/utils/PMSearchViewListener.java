// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.os.Bundle;

// Referenced classes of package com.poshmark.utils:
//            SearchFilterModel

public interface PMSearchViewListener
{

    public abstract void clearSearchString();

    public abstract void fireKeywordSearch(Bundle bundle, SearchFilterModel searchfiltermodel, boolean flag);
}
