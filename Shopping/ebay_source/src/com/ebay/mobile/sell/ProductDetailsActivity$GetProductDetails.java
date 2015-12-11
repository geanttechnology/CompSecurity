// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.os.AsyncTask;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.net.DataRequest;
import com.ebay.nautilus.domain.net.DataResponse;
import java.io.IOException;
import java.net.URL;

// Referenced classes of package com.ebay.mobile.sell:
//            ProductDetailsActivity

public final class this._cls0 extends AsyncTask
{

    final ProductDetailsActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        if (!Util.hasNetwork())
        {
            return null;
        }
        avoid = (new StringBuilder()).append("http://syicatalogs.ebay.com/ws/eBayISAPI.dll?PageSyiProductDetails&IncludeAttributes=0&ShowAttributesTable=1&ProductMementoString=").append(productMementoId).toString();
        avoid = ((DataResponse)com.ebay.nautilus.kernel.net.ground(getEbayContext(), new DataRequest(new URL(avoid)))).getText();
        return avoid;
        avoid;
        avoid.printStackTrace();
_L2:
        return null;
        avoid;
        avoid.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (s == null)
        {
            showNetworkErrorToast();
            finish();
            return;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("<html><body>");
            stringbuilder.append("<img style=\"margin-left:5px;margin-bottom:5px;width:80px;float:left;\" + src=\"").append(productPhotoUrl).append("\"\\>");
            stringbuilder.append("<span style=\"margin-left:5px;float:left;font-size:16pt;font-weight:bold;width:70%\">").append(productTitle).append("</span>");
            stringbuilder.append(s).append("</html></body>");
            webview.loadDataWithBaseURL(null, stringbuilder.toString(), "text/html", "utf-8", null);
            webview.setWebViewClient(new WebViewClient() {

                final ProductDetailsActivity.GetProductDetails this$1;

                public void onPageFinished(WebView webview, String s1)
                {
                    this$0.webview.setVisibility(0);
                    loading.setVisibility(8);
                }

            
            {
                this$1 = ProductDetailsActivity.GetProductDetails.this;
                super();
            }
            });
            return;
        }
    }

    public _cls1.this._cls1()
    {
        this$0 = ProductDetailsActivity.this;
        super();
    }
}
