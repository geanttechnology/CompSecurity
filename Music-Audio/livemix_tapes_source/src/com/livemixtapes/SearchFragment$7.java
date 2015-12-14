// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;


// Referenced classes of package com.livemixtapes:
//            SearchFragment

class tpCallback extends tpCallback
{

    final SearchFragment this$0;

    protected void always()
    {
        SearchFragment.access$3(SearchFragment.this, false);
    }

    protected void exception(Exception exception1)
    {
        exception1.printStackTrace();
    }

    protected void success(String s, String s1, int i)
    {
        SearchFragment.access$4(SearchFragment.this, s);
    }

    tpCallback()
    {
        this$0 = SearchFragment.this;
        super();
    }
}
