// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bitstrips.imoji.ui.tasks.ReadWebpageAsyncTask;

// Referenced classes of package com.bitstrips.imoji.ui.views:
//            FashionAnnouncerView

class nit> extends ReadWebpageAsyncTask
{

    final FashionAnnouncerView this$0;
    final String val$avatarId;
    final FashionAnnouncerView val$self;

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        WebView webview = (WebView)findViewById(0x7f0b00ab);
        webview.setOnTouchListener(new android.view.View.OnTouchListener() {

            final FashionAnnouncerView._cls1 this$1;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 0)
                {
                    FashionAnnouncerView.access$000(self);
                }
                return false;
            }

            
            {
                this$1 = FashionAnnouncerView._cls1.this;
                super();
            }
        });
        webview.setWebViewClient(new WebViewClient() {

            final FashionAnnouncerView._cls1 this$1;

            public void onPageFinished(WebView webview1, String s1)
            {
                FashionAnnouncerView.access$100(self);
                webview1 = findViewById(0x7f0b00ac);
                s1 = findViewById(0x7f0b00ad);
                android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

                    final _cls2 this$2;

                    public void onClick(View view)
                    {
                        self.onCloseClick();
                    }

            
            {
                this$2 = _cls2.this;
                super();
            }
                };
                webview1.setOnClickListener(onclicklistener);
                s1.setOnClickListener(onclicklistener);
            }

            
            {
                this$1 = FashionAnnouncerView._cls1.this;
                super();
            }
        });
        webview.loadDataWithBaseURL("", s.replace("AVATAR_ID", val$avatarId), "text/html", "UTF-8", "");
    }

    _cls2.this._cls1(String s1)
    {
        this$0 = final_fashionannouncerview;
        val$self = FashionAnnouncerView.this;
        val$avatarId = s1;
        super(final_s);
    }
}
