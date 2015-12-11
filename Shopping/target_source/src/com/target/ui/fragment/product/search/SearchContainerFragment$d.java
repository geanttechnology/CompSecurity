// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import android.support.v7.widget.SearchView;
import com.target.ui.util.e.a;

// Referenced classes of package com.target.ui.fragment.product.search:
//            SearchContainerFragment

private class <init>
    implements <init>
{

    final SearchContainerFragment this$0;

    public void a()
    {
    }

    public void a(String s)
    {
    }

    public void b(String s)
    {
        SearchContainerFragment.d(SearchContainerFragment.this).a(s, false);
    }

    public void c(String s)
    {
        SearchContainerFragment.b(SearchContainerFragment.this, s);
        if (SearchContainerFragment.d(SearchContainerFragment.this) != null)
        {
            SearchContainerFragment.d(SearchContainerFragment.this).postDelayed(new Runnable() {

                final SearchContainerFragment.d this$1;

                public void run()
                {
                    if (SearchContainerFragment.d(this$0) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.util.e.a.c(SearchContainerFragment.d(this$0).findFocus());
                        return;
                    }
                }

            
            {
                this$1 = SearchContainerFragment.d.this;
                super();
            }
            }, 500L);
            SearchContainerFragment.d(SearchContainerFragment.this).a(SearchContainerFragment.b(SearchContainerFragment.this), false);
        }
    }

    private _cls1.this._cls1()
    {
        this$0 = SearchContainerFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
