// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.boldchat.visitor.api.PersonType;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatHistory

public class BoldChatWebHistory extends WebView
    implements BoldChatHistory
{
    private class HistoryColor
    {

        public int color;
        public String key;
        final BoldChatWebHistory this$0;

        public HistoryColor(int i, String s)
        {
            this$0 = BoldChatWebHistory.this;
            super();
            color = i;
            key = s;
        }
    }

    public static interface HistoryPageLoadedListener
    {

        public abstract void historyPageLoaded();
    }

    private class JsObject
    {

        final BoldChatWebHistory this$0;

        private JsObject()
        {
            this$0 = BoldChatWebHistory.this;
            super();
        }

    }

    private class OpenLinksExternalWebClient extends WebViewClient
    {

        final BoldChatWebHistory this$0;

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            webview = new Intent("android.intent.action.VIEW");
            webview.setFlags(0x4000000);
            webview.setData(Uri.parse(s));
            getContext().startActivity(webview);
            return true;
        }

        private OpenLinksExternalWebClient()
        {
            this$0 = BoldChatWebHistory.this;
            super();
        }

    }


    private HashMap historyColors;
    private boolean mIsLoaded;
    private HistoryPageLoadedListener mLoadedListener;

    public BoldChatWebHistory(Context context)
    {
        super(context);
        historyColors = new HashMap();
        mLoadedListener = null;
        mIsLoaded = false;
        initView(context, null);
    }

    public BoldChatWebHistory(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        historyColors = new HashMap();
        mLoadedListener = null;
        mIsLoaded = false;
        initView(context, attributeset);
    }

    public BoldChatWebHistory(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        historyColors = new HashMap();
        mLoadedListener = null;
        mIsLoaded = false;
        initView(context, attributeset);
    }

    public BoldChatWebHistory(Context context, AttributeSet attributeset, int i, boolean flag)
    {
        super(context, attributeset, i, flag);
        historyColors = new HashMap();
        mLoadedListener = null;
        mIsLoaded = false;
        initView(context, attributeset);
    }

    private void initView(Context context, AttributeSet attributeset)
    {
        if (!isInEditMode())
        {
            int i = R.raw.bc_chat_history;
            Resources resources = context.getResources();
            historyColors.put(Integer.valueOf(R.styleable.BoldChatWebHistory_historyBackgroundColor), new HistoryColor(resources.getColor(R.color.bc_history_background), "bc_history_background"));
            historyColors.put(Integer.valueOf(R.styleable.BoldChatWebHistory_visitorTextColor), new HistoryColor(resources.getColor(R.color.bc_history_visitor_text), "bc_history_visitor_text"));
            historyColors.put(Integer.valueOf(R.styleable.BoldChatWebHistory_visitorBackgroundColor), new HistoryColor(resources.getColor(R.color.bc_history_visitor_background), "bc_history_visitor_background"));
            historyColors.put(Integer.valueOf(R.styleable.BoldChatWebHistory_visitorTimeColor), new HistoryColor(resources.getColor(R.color.bc_history_visitor_time), "bc_history_visitor_time"));
            historyColors.put(Integer.valueOf(R.styleable.BoldChatWebHistory_visitorSenderColor), new HistoryColor(resources.getColor(R.color.bc_history_visitor_sender), "bc_history_visitor_sender"));
            historyColors.put(Integer.valueOf(R.styleable.BoldChatWebHistory_operatorTextColor), new HistoryColor(resources.getColor(R.color.bc_history_operator_text), "bc_history_operator_text"));
            historyColors.put(Integer.valueOf(R.styleable.BoldChatWebHistory_operatorBackgroundColor), new HistoryColor(resources.getColor(R.color.bc_history_operator_background), "bc_history_operator_background"));
            historyColors.put(Integer.valueOf(R.styleable.BoldChatWebHistory_operatorTimeColor), new HistoryColor(resources.getColor(R.color.bc_history_operator_time), "bc_history_operator_time"));
            historyColors.put(Integer.valueOf(R.styleable.BoldChatWebHistory_operatorSenderColor), new HistoryColor(resources.getColor(R.color.bc_history_operator_sender), "bc_history_operator_sender"));
            historyColors.put(Integer.valueOf(R.styleable.BoldChatWebHistory_systemTextColor), new HistoryColor(resources.getColor(R.color.bc_history_system_text), "bc_history_system_text"));
            historyColors.put(Integer.valueOf(R.styleable.BoldChatWebHistory_systemBackgroundColor), new HistoryColor(resources.getColor(R.color.bc_history_system_background), "bc_history_system_background"));
            int j = i;
            if (attributeset != null)
            {
                context = context.obtainStyledAttributes(attributeset, R.styleable.BoldChatWebHistory);
                int k = context.getIndexCount();
                j = 0;
                while (j < k) 
                {
                    int l = context.getIndex(j);
                    attributeset = (HistoryColor)historyColors.get(Integer.valueOf(l));
                    if (attributeset != null)
                    {
                        attributeset.color = context.getColor(j, ((HistoryColor) (attributeset)).color);
                    } else
                    if (l == R.styleable.BoldChatWebHistory_html)
                    {
                        i = context.getResourceId(j, R.raw.bc_chat_history);
                    }
                    j++;
                }
                context.recycle();
                j = i;
            }
            getSettings().setJavaScriptEnabled(true);
            setHtmlResource(j);
        }
    }

    private transient void runJavascript(String s, Object aobj[])
    {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(s).append('(');
        int j = aobj.length;
        int i = 0;
        while (i < j) 
        {
            s = ((String) (aobj[i]));
            if (s == null)
            {
                buffer.append("null");
            } else
            if ((s instanceof Boolean) || (s instanceof Integer))
            {
                buffer.append(s.toString());
            } else
            if (s instanceof Long)
            {
                buffer.append('\'').append(s.toString()).append('\'');
            } else
            {
                try
                {
                    buffer.append("decodeURIComponent('").append(URLEncoder.encode(s.toString(), "UTF-8").replace("+", "%20")).append("')");
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Log.e("BOLD", "UTF-8 Encoding not supported", s);
                }
            }
            buffer.append(',');
            i++;
        }
        if (aobj.length > 0)
        {
            buffer.setLength(buffer.length() - 1);
        }
        buffer.append(");");
        runMain(new Runnable() {

            final BoldChatWebHistory this$0;
            final StringBuilder val$buffer;

            public void run()
            {
                String s2 = buffer.toString();
                String s1 = s2;
                if (android.os.Build.VERSION.SDK_INT >= 19)
                {
                    try
                    {
                        s1 = URLEncoder.encode(s2, "UTF-8");
                    }
                    catch (UnsupportedEncodingException unsupportedencodingexception)
                    {
                        Log.e("BOLD", "UTF-8 Encoding not supported", unsupportedencodingexception);
                        unsupportedencodingexception = s2;
                    }
                }
                loadUrl((new StringBuilder()).append("javascript:").append(s1).toString());
            }

            
            {
                this$0 = BoldChatWebHistory.this;
                buffer = stringbuilder;
                super();
            }
        });
    }

    private void runMain(Runnable runnable)
    {
        (new Handler(getContext().getMainLooper())).post(runnable);
    }

    public void addMessage(String s, PersonType persontype, long l, String s1, String s2, String s3)
    {
        runJavascript("addMessage", new Object[] {
            s, persontype.name().toLowerCase(), Long.valueOf(l), s1, s2, s3
        });
    }

    public void clearChatHistory()
    {
        runJavascript("clearHistory", new Object[0]);
    }

    public void scrollToBottom()
    {
        runMain(new Runnable() {

            final BoldChatWebHistory this$0;

            public void run()
            {
                pageDown(true);
            }

            
            {
                this$0 = BoldChatWebHistory.this;
                super();
            }
        });
    }

    public void setHistoryPageLoadedListener(HistoryPageLoadedListener historypageloadedlistener)
    {
        mLoadedListener = historypageloadedlistener;
        if (mIsLoaded)
        {
            historypageloadedlistener.historyPageLoaded();
        }
    }

    public void setHtmlResource(int i)
    {
        StringBuilder stringbuilder;
        char ac[];
        stringbuilder = new StringBuilder();
        ac = new char[1024];
        Object obj = new InputStreamReader(getResources().openRawResource(i), "UTF-8");
_L3:
        i = ((InputStreamReader) (obj)).read(ac);
        if (i <= -1) goto _L2; else goto _L1
_L1:
        stringbuilder.append(ac, 0, i);
          goto _L3
_L5:
        obj = historyColors.values().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            HistoryColor historycolor = (HistoryColor)((Iterator) (obj)).next();
            String s = (new StringBuilder()).append("${").append(historycolor.key).append("}").toString();
            i = 0;
            do
            {
                int j = stringbuilder.indexOf(s, i);
                if (j <= -1)
                {
                    break;
                }
                String s1 = String.format("#%06X", new Object[] {
                    Integer.valueOf(historycolor.color & 0xffffff)
                });
                i = j + s.length();
                stringbuilder.replace(j, i, s1);
            } while (true);
        } while (true);
_L2:
        try
        {
            ((InputStreamReader) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("BOLD", "Failed to read bc_chat_history.html from raw resources", ((Throwable) (obj)));
        }
        if (true) goto _L5; else goto _L4
_L4:
        obj = new StringBuilder();
        InputStreamReader inputstreamreader = new InputStreamReader(getResources().openRawResource(R.raw.bc_chat_history_js), "UTF-8");
_L8:
        i = inputstreamreader.read(ac);
        if (i <= -1) goto _L7; else goto _L6
_L6:
        IOException ioexception;
        ((StringBuilder) (obj)).append(ac, 0, i);
          goto _L8
_L10:
        i = stringbuilder.indexOf("${bc_chat_history_js}");
        if (i > -1)
        {
            stringbuilder.replace(i, i + "${bc_chat_history_js}".length(), ((StringBuilder) (obj)).toString());
        }
        addJavascriptInterface(new JsObject(), "injectedObject");
        loadDataWithBaseURL("file:///android_asset/", stringbuilder.toString(), "text/html", "utf-8", "");
        setWebViewClient(new OpenLinksExternalWebClient());
        return;
_L7:
        try
        {
            inputstreamreader.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            Log.e("BOLD", "Failed to read bc_chat_history_js.js from raw resources", ioexception);
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void setStatus(String s)
    {
        boolean flag;
        if (!TextUtils.isEmpty(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        runJavascript("setStatus", new Object[] {
            Boolean.valueOf(flag), s
        });
    }
}
