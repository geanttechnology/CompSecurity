// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.ebay.motors.videos.FwContextUtil;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessageFragment, MessagesBaseFragment

class this._cls0 extends WebViewClient
{

    final MessageFragment this$0;

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Toast.makeText(getActivity(), s, 0).show();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Uri uri;
        Object obj1;
        boolean flag1;
        boolean flag2;
        if (MessagesBaseFragment.log.ggable || MessageFragment.logWebView.ggable)
        {
            MessageFragment.logWebView.w((new StringBuilder()).append("WebView redirect: ").append(s).toString());
        }
        notifyPaneActivated(nt.ActivePane.MESSAGES_DETAIL);
        uri = Uri.parse(s);
        flag1 = false;
        flag2 = false;
        obj1 = null;
        String s1 = uri.getQueryParameter("loc");
        Object obj = obj1;
        int i;
        int j;
        long l;
        boolean flag;
        if (s1 != null)
        {
            try
            {
                obj = Uri.parse(s1);
            }
            catch (Exception exception)
            {
                exception = obj1;
            }
        }
        if (obj == null)
        {
            obj = uri;
        }
        if (!s.contains("ViewItem") && !s.contains("?BinConfirm&")) goto _L2; else goto _L1
_L1:
        if (MessagesBaseFragment.log.ggable || MessageFragment.logWebView.ggable)
        {
            MessageFragment.logWebView.w("  Handle as ItemView/BIN");
        }
        webview = null;
        obj = uri.getQueryParameter("loc");
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = Uri.parse(((String) (obj))).getQueryParameter("item");
        webview = ((WebView) (obj));
_L8:
        flag = flag2;
        if (webview == null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        obj = webview;
        flag = flag1;
        if (12 >= webview.length())
        {
            break MISSING_BLOCK_LABEL_200;
        }
        flag = flag1;
        obj = webview.substring(0, 12);
        flag = flag1;
        l = Long.parseLong(((String) (obj)));
        flag = true;
        flag1 = true;
        MessageFragment.access$000(MessageFragment.this, l);
        flag = flag1;
_L6:
        flag1 = flag;
        if (!flag)
        {
            if (MessagesBaseFragment.log.ggable || MessageFragment.logWebView.ggable)
            {
                MessageFragment.logWebView.w("  Handle as web redirect");
            }
            flag = false;
            if (uri.getHost().startsWith("bulksell."))
            {
                flag = true;
            }
            MessageFragment.access$800(MessageFragment.this, s, flag);
            flag1 = true;
        }
        return flag1;
_L4:
        obj = uri.getQueryParameter("item");
        webview = ((WebView) (obj));
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.contains("?ManageBestOffers&") || ((Uri) (obj)).isHierarchical() && ((Uri) (obj)).getQueryParameter("ManageBestOffers") != null)
        {
            if (MessagesBaseFragment.log.ggable || MessageFragment.logWebView.ggable)
            {
                MessageFragment.logWebView.w("  Handle as ItemView/Best Offer");
            }
            flag = MessageFragment.access$100(MessageFragment.this, s);
        } else
        if (s.contains("M2MContact"))
        {
            if (MessagesBaseFragment.log.ggable || MessageFragment.logWebView.ggable)
            {
                MessageFragment.logWebView.w("  Handle as Reply");
            }
            MessageFragment.access$200(MessageFragment.this);
            flag = true;
        } else
        if (s.contains("FBuyHub"))
        {
            if (MessagesBaseFragment.log.ggable || MessageFragment.logWebView.ggable)
            {
                MessageFragment.logWebView.w("  Handle as Home");
            }
            MessageFragment.access$300(MessageFragment.this, false);
            flag = true;
        } else
        if (((Uri) (obj)).isHierarchical() && (((Uri) (obj)).getQueryParameter("MyeBay") != null || ((Uri) (obj)).getQueryParameter("MyEbay") != null))
        {
            if (MessagesBaseFragment.log.ggable || MessageFragment.logWebView.ggable)
            {
                MessageFragment.logWebView.w("  Handle as My eBay");
            }
            MessageFragment.access$400(MessageFragment.this);
            flag = true;
        } else
        if (s.contains("myworld.ebay.com"))
        {
            if (MessagesBaseFragment.log.ggable || MessageFragment.logWebView.ggable)
            {
                MessageFragment.logWebView.w("  Handle as User Details");
            }
            webview = ((Uri) (obj)).getPathSegments();
            flag = flag2;
            if (webview != null)
            {
                flag = flag2;
                if (!webview.isEmpty())
                {
                    webview = (String)webview.get(webview.size() - 1);
                    MessageFragment.access$500(MessageFragment.this, webview);
                    flag = true;
                }
            }
        } else
        {
            flag = flag2;
            if (!s.contains("?ReviseFeedbackAccept&"))
            {
                flag = flag2;
                if (!s.contains("?ReviseFeedbackDecline&"))
                {
                    if (s.contains("feedback.ebay.com"))
                    {
                        if (MessagesBaseFragment.log.ggable || MessageFragment.logWebView.ggable)
                        {
                            MessageFragment.logWebView.w("  Handle as Seller Feedback");
                        }
                        i = s.indexOf("userid%") + 9;
                        j = s.indexOf("%", i);
                        flag = flag2;
                        if (i >= 0)
                        {
                            flag = flag2;
                            if (i < j)
                            {
                                MessageFragment.access$600(MessageFragment.this, s.substring(i, j));
                                flag = true;
                            }
                        }
                    } else
                    {
                        obj = new Intent("android.intent.action.VIEW", uri);
                        if (!uri.isHierarchical())
                        {
                            if (MessagesBaseFragment.log.ggable || MessageFragment.logWebView.ggable)
                            {
                                MessageFragment.logWebView.w("  Handle as a non-hierarchical link");
                            }
                            MessageFragment.access$700(MessageFragment.this, ((Intent) (obj)));
                            flag = true;
                        } else
                        {
                            webview = FwContextUtil.getLocalActivity(webview.getContext(), ((Intent) (obj)));
                            flag = flag2;
                            if (webview.getComponent() != null)
                            {
                                if (MessagesBaseFragment.log.ggable || MessageFragment.logWebView.ggable)
                                {
                                    MessageFragment.logWebView.w("  Handle as Deep Link");
                                }
                                MessageFragment.access$700(MessageFragment.this, webview);
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        continue; /* Loop/switch isn't completed */
        webview;
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        if (true) goto _L8; else goto _L7
_L7:
    }

    nt.ActivePane()
    {
        this$0 = MessageFragment.this;
        super();
    }
}
