// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.view.View;
import android.webkit.WebView;
import com.actionbarsherlock.app.SherlockFragmentActivity;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            WebFragment

class val.wv
    implements android.view.stener
{

    final WebFragment this$0;
    final WebView val$wv;

    public void onClick(View view)
    {
        if (val$wv.canGoForward())
        {
            val$wv.goForward();
            if (getActivity() != null)
            {
                ((SherlockFragmentActivity)getActivity()).setSupportProgressBarIndeterminateVisibility(true);
            }
        }
    }

    ty()
    {
        this$0 = final_webfragment;
        val$wv = WebView.this;
        super();
    }
}
