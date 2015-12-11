// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Context;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.aio.downloader.refresh.PullableListView_load;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.DeletableEditText;
import java.net.URLEncoder;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            AppRecommendKeywordsActivity

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        String s = URLEncoder.encode(AppRecommendKeywordsActivity.access$1(_fld0).getText().toString());
        publicTools.getUrl((new StringBuilder(String.valueOf("http://android.downloadatoz.com/_201409/market/hits.php?type=search&id=app&title="))).append(s).toString());
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/AppRecommendKeywordsActivity$8

/* anonymous class */
    class AppRecommendKeywordsActivity._cls8
        implements android.view.View.OnKeyListener
    {

        final AppRecommendKeywordsActivity this$0;

        public boolean onKey(View view, int i, KeyEvent keyevent)
        {
            try
            {
                AppRecommendKeywordsActivity.access$20(AppRecommendKeywordsActivity.this).clear();
            }
            // Misplaced declaration of an exception variable
            catch (View view) { }
            if (keyevent.getAction() == 0 && i == 66)
            {
                try
                {
                    ((InputMethodManager)AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).getContext().getSystemService("input_method")).hideSoftInputFromWindow(AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).getWindowToken(), 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                try
                {
                    AppRecommendKeywordsActivity.access$15(AppRecommendKeywordsActivity.this, AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).getText().toString());
                    ((RelativeLayout)AppRecommendKeywordsActivity.access$18(AppRecommendKeywordsActivity.this).findViewById(0x7f0701db)).setVisibility(8);
                    (new AppRecommendKeywordsActivity.Mya1(AppRecommendKeywordsActivity.this)).execute(new Void[0]);
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                try
                {
                    (new Thread(new AppRecommendKeywordsActivity._cls8._cls1())).start();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return false;
                }
            }
            return false;
        }


            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
    }

}
