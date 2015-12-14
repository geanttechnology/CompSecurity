// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.Html;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.at;
import com.cyberlink.beautycircle.controller.activity.WebViewerActivity;
import com.cyberlink.beautycircle.m;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.u;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.util.List;

public class PostContentTextView extends EmojiconTextView
{

    public static LinkMovementMethod a = new LinkMovementMethod() {

        public boolean onTouchEvent(TextView textview, Spannable spannable, MotionEvent motionevent)
        {
            ClickableSpan aclickablespan[];
            int i;
            if (textview == null || !(textview instanceof PostContentTextView))
            {
                return false;
            }
            textview = (PostContentTextView)textview;
            i = motionevent.getAction();
            if (i != 1 && i != 0)
            {
                break MISSING_BLOCK_LABEL_263;
            }
            int j = (int)motionevent.getX();
            int k = (int)motionevent.getY();
            int l = textview.getTotalPaddingLeft();
            int i1 = textview.getTotalPaddingTop();
            int j1 = textview.getScrollX();
            int k1 = textview.getScrollY();
            Layout layout = textview.getLayout();
            j = layout.getOffsetForHorizontal(layout.getLineForVertical((k - i1) + k1), (j - l) + j1);
            aclickablespan = (ClickableSpan[])spannable.getSpans(j, j, android/text/style/ClickableSpan);
            if (aclickablespan.length == 0) goto _L2; else goto _L1
_L1:
            PostContentTextView.a(textview, true);
            if (i != 1 || ((URLSpan)aclickablespan[0]).getURL() == null) goto _L4; else goto _L3
_L3:
            if ((aclickablespan[0] instanceof URLSpan) && !textview.a(Uri.parse(((URLSpan)aclickablespan[0]).getURL())))
            {
                try
                {
                    aclickablespan[0].onClick(textview);
                }
                // Misplaced declaration of an exception variable
                catch (TextView textview)
                {
                    e.b(new Object[] {
                        textview
                    });
                }
            }
_L5:
            return true;
_L4:
            if (i == 0)
            {
                Selection.setSelection(spannable, spannable.getSpanStart(aclickablespan[0]), spannable.getSpanEnd(aclickablespan[0]));
            }
            if (true) goto _L5; else goto _L2
_L2:
            PostContentTextView.a(textview, false);
            Selection.removeSelection(spannable);
            Touch.onTouchEvent(textview, spannable, motionevent);
            return false;
            return Touch.onTouchEvent(textview, spannable, motionevent);
        }

    };
    private boolean b;

    public PostContentTextView(Context context)
    {
        super(context);
        b = false;
        a(((AttributeSet) (null)));
    }

    public PostContentTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = false;
        a(attributeset);
    }

    public PostContentTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = false;
        a(attributeset);
    }

    private void a(AttributeSet attributeset)
    {
        setMovementMethod(a);
    }

    static boolean a(PostContentTextView postcontenttextview, boolean flag)
    {
        postcontenttextview.b = flag;
        return flag;
    }

    public boolean a(Uri uri)
    {
        Context context;
        byte byte0;
        byte0 = 2;
        if (uri == null)
        {
            return false;
        }
        context = getContext();
        String s = uri.getScheme();
        if (s == null)
        {
            c.a(context, (new StringBuilder()).append("http://").append(uri.toString()).toString(), 2);
            return true;
        }
        if (s.equals("ybc"))
        {
            return false;
        }
        if (s.equals("ymk"))
        {
            return a(uri, "com.cyberlink.youcammakeup");
        }
        if (s.equals("ycp"))
        {
            return a(uri, "com.cyberlink.youperfect");
        }
        if (WebViewerActivity.q.contains(s))
        {
            return c.a(getContext(), uri);
        }
        if (u.e(uri.toString()))
        {
            return c.c(context, uri.getQueryParameter("id"));
        }
        if (!uri.toString().equals(context.getString(m.bc_url_privacy_policy))) goto _L2; else goto _L1
_L1:
        com.perfectcorp.a.b.a(new at("privacy_policy"));
        byte0 = 1;
_L4:
        c.a(context, uri.toString(), byte0);
        return true;
_L2:
        if (uri.toString().equals(context.getString(m.bc_url_terms_of_service)))
        {
            com.perfectcorp.a.b.a(new at("terms_of_service"));
            byte0 = 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean a(Uri uri, String s)
    {
        Context context;
        context = getContext();
        PackageManager packagemanager = context.getPackageManager();
        if (packagemanager == null || packagemanager.getLaunchIntentForPackage(s) == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        context.startActivity(new Intent("android.intent.action.VIEW", uri));
        return true;
        uri;
        try
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(s).toString())));
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(s).toString())));
            return true;
        }
        return true;
    }

    public boolean hasFocusable()
    {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        super.onTouchEvent(motionevent);
        return b;
    }

    public void setTextViewHTML(String s)
    {
        if (s == null)
        {
            setText("");
            return;
        }
        try
        {
            setText(new SpannableStringBuilder(Html.fromHtml(u.c(s))));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        e.e(new Object[] {
            (new StringBuilder()).append("The input html :").append(s).toString()
        });
        setText(s);
    }

}
