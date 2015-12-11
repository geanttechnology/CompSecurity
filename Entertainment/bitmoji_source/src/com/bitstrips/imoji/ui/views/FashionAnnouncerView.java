// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.bitstrips.imoji.models.AnnouncerData;
import com.bitstrips.imoji.ui.tasks.ReadWebpageAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;

public class FashionAnnouncerView extends RelativeLayout
{
    public static interface FashionAnnouncerViewListener
    {

        public abstract void onFashionAnnouncerCloseTouch(AnnouncerData announcerdata);

        public abstract void onFashionAnnouncerLoaded(AnnouncerData announcerdata);

        public abstract void onFashionAnnouncerTouch(AnnouncerData announcerdata);
    }


    private AnnouncerData announcerData;
    LayoutInflater inflater;
    private ArrayList listeners;

    public FashionAnnouncerView(Context context)
    {
        super(context);
        listeners = new ArrayList();
        inflater = LayoutInflater.from(context);
        init();
    }

    public FashionAnnouncerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        listeners = new ArrayList();
        inflater = LayoutInflater.from(context);
        init();
    }

    public FashionAnnouncerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        listeners = new ArrayList();
        inflater = LayoutInflater.from(context);
        init();
    }

    private void onLoaded()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((FashionAnnouncerViewListener)iterator.next()).onFashionAnnouncerLoaded(announcerData)) { }
    }

    private void onTouch()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((FashionAnnouncerViewListener)iterator.next()).onFashionAnnouncerTouch(announcerData)) { }
    }

    public void addListener(FashionAnnouncerViewListener fashionannouncerviewlistener)
    {
        if (fashionannouncerviewlistener != null && !listeners.contains(fashionannouncerviewlistener))
        {
            listeners.add(fashionannouncerviewlistener);
        }
    }

    public void init()
    {
        inflater.inflate(0x7f030033, this, true);
    }

    public void load(AnnouncerData announcerdata, String s)
    {
        announcerData = announcerdata;
        (new ReadWebpageAsyncTask(s) {

            final FashionAnnouncerView this$0;
            final String val$avatarId;
            final FashionAnnouncerView val$self;

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((String)obj);
            }

            protected void onPostExecute(String s1)
            {
                WebView webview = (WebView)findViewById(0x7f0b00ab);
                webview.setOnTouchListener(new android.view.View.OnTouchListener() {

                    final _cls1 this$1;

                    public boolean onTouch(View view, MotionEvent motionevent)
                    {
                        if (motionevent.getAction() == 0)
                        {
                            self.onTouch();
                        }
                        return false;
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                webview.setWebViewClient(new WebViewClient() {

                    final _cls1 this$1;

                    public void onPageFinished(WebView webview, String s)
                    {
                        self.onLoaded();
                        webview = findViewById(0x7f0b00ac);
                        s = findViewById(0x7f0b00ad);
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
                        webview.setOnClickListener(onclicklistener);
                        s.setOnClickListener(onclicklistener);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                webview.loadDataWithBaseURL("", s1.replace("AVATAR_ID", avatarId), "text/html", "UTF-8", "");
            }

            
            {
                this$0 = FashionAnnouncerView.this;
                self = fashionannouncerview1;
                avatarId = s1;
                super(final_s);
            }
        }).execute(new String[0]);
    }

    public void onCloseClick()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((FashionAnnouncerViewListener)iterator.next()).onFashionAnnouncerCloseTouch(announcerData)) { }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        listeners.clear();
    }

    public void removeListener(FashionAnnouncerViewListener fashionannouncerviewlistener)
    {
        if (fashionannouncerviewlistener != null && listeners.contains(fashionannouncerviewlistener))
        {
            listeners.remove(fashionannouncerviewlistener);
        }
    }

    public void setNotchPosition(View view)
    {
        View view1 = findViewById(0x7f0b00aa);
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view1.getLayoutParams();
        int ai[] = new int[2];
        view.getLocationInWindow(ai);
        marginlayoutparams.setMargins(ai[0] + (view.getWidth() - view1.getWidth()) / 2, 0, 0, 0);
        view1.requestLayout();
    }


}
