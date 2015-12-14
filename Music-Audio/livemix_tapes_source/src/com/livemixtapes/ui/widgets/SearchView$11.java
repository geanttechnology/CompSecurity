// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui.widgets;

import android.content.Context;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.livemixtapes.ui.widgets:
//            SearchView

class val.expand
    implements android.view.animation.ationListener
{

    final SearchView this$0;
    private final boolean val$expand;

    public void onAnimationEnd(Animation animation)
    {
        animation = (android.widget..LayoutParams)SearchView.access$0(SearchView.this).getLayoutParams();
        animation.rightMargin = -(int)0.0F;
        SearchView.access$0(SearchView.this).setLayoutParams(animation);
        if (SearchView.access$10(SearchView.this) != null)
        {
            SearchView.access$10(SearchView.this).onAfterExpand(val$expand);
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        SearchView.access$9(SearchView.this).setVisibility(8);
        SearchView.access$12(SearchView.this);
        SearchView.access$11(SearchView.this).setVisibility(0);
        SearchView.access$5(SearchView.this).setVisibility(8);
        ((InputMethodManager)SearchView.access$8(SearchView.this).getSystemService("input_method")).hideSoftInputFromWindow(SearchView.access$5(SearchView.this).getWindowToken(), 0);
        if (SearchView.access$10(SearchView.this) != null)
        {
            SearchView.access$10(SearchView.this).onBeforeExpand(val$expand);
        }
    }

    r()
    {
        this$0 = final_searchview;
        val$expand = Z.this;
        super();
    }
}
