// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;


// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class val.isFiltering
    implements android.widget.ent._cls3
{

    final GlobalSearchFragment this$0;
    final boolean val$isFiltering;

    public void onFilterComplete(int i)
    {
        if (i == 0 && val$isFiltering)
        {
            GlobalSearchFragment.access$200(GlobalSearchFragment.this);
        }
    }

    ()
    {
        this$0 = final_globalsearchfragment;
        val$isFiltering = Z.this;
        super();
    }
}
