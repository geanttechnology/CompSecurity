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

class this._cls1
    implements android.view.nouncerView._cls1._cls1
{

    final l.self this$1;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            FashionAnnouncerView.access$000(self);
        }
        return false;
    }

    t>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/bitstrips/imoji/ui/views/FashionAnnouncerView$1

/* anonymous class */
    class FashionAnnouncerView._cls1 extends ReadWebpageAsyncTask
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
            webview.setOnTouchListener(new FashionAnnouncerView._cls1._cls1());
            webview.setWebViewClient(new FashionAnnouncerView._cls1._cls2());
            webview.loadDataWithBaseURL("", s.replace("AVATAR_ID", avatarId), "text/html", "UTF-8", "");
        }

            
            {
                this$0 = final_fashionannouncerview;
                self = FashionAnnouncerView.this;
                avatarId = s1;
                super(final_s);
            }

        // Unreferenced inner class com/bitstrips/imoji/ui/views/FashionAnnouncerView$1$2

/* anonymous class */
        class FashionAnnouncerView._cls1._cls2 extends WebViewClient
        {

            final FashionAnnouncerView._cls1 this$1;

            public void onPageFinished(WebView webview, String s)
            {
                FashionAnnouncerView.access$100(self);
                webview = findViewById(0x7f0b00ac);
                s = findViewById(0x7f0b00ad);
                android.view.View.OnClickListener onclicklistener = new FashionAnnouncerView._cls1._cls2._cls1();
                webview.setOnClickListener(onclicklistener);
                s.setOnClickListener(onclicklistener);
            }

                    
                    {
                        this$1 = FashionAnnouncerView._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/bitstrips/imoji/ui/views/FashionAnnouncerView$1$2$1

/* anonymous class */
        class FashionAnnouncerView._cls1._cls2._cls1
            implements android.view.View.OnClickListener
        {

            final FashionAnnouncerView._cls1._cls2 this$2;

            public void onClick(View view)
            {
                self.onCloseClick();
            }

                    
                    {
                        this$2 = FashionAnnouncerView._cls1._cls2.this;
                        super();
                    }
        }

    }

}
