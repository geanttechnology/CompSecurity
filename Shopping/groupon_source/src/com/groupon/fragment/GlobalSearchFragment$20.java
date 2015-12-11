// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;


// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class val.categoryId
    implements Runnable
{

    final GlobalSearchFragment this$0;
    final String val$categoryId;
    final String val$suggestionValue;

    public void run()
    {
        if (getActivity() != null)
        {
            GlobalSearchFragment.access$2300(GlobalSearchFragment.this, val$suggestionValue, val$categoryId);
        }
    }

    ()
    {
        this$0 = final_globalsearchfragment;
        val$suggestionValue = s;
        val$categoryId = String.this;
        super();
    }
}
