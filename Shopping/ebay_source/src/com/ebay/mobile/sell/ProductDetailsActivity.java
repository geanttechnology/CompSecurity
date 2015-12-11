// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.net.DataRequest;
import com.ebay.nautilus.domain.net.DataResponse;
import java.io.IOException;
import java.net.URL;

public class ProductDetailsActivity extends BaseActivity
{
    public final class GetProductDetails extends AsyncTask
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
            avoid = ((DataResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(getEbayContext(), new DataRequest(new URL(avoid)))).getText();
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

                    final GetProductDetails this$1;

                    public void onPageFinished(WebView webview1, String s)
                    {
                        webview.setVisibility(0);
                        loading.setVisibility(8);
                    }

            
            {
                this$1 = GetProductDetails.this;
                super();
            }
                });
                return;
            }
        }

        public GetProductDetails()
        {
            this$0 = ProductDetailsActivity.this;
            super();
        }
    }


    public static final String EXTRA_PHOTO = "photo";
    public static final String EXTRA_PRODUCT_MEMENTO_ID = "product_memento_id";
    public static final String EXTRA_TITLE = "title";
    protected View loading;
    protected String productMementoId;
    protected String productPhotoUrl;
    protected String productTitle;
    protected WebView webview;

    public ProductDetailsActivity()
    {
    }

    protected boolean cancelNetworkErrorOnClose()
    {
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030213);
        ((TextView)findViewById(0x7f1003a5)).setText(getTitle());
        webview = (WebView)findViewById(0x7f100316);
        bundle = webview.getSettings();
        bundle.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        bundle.setTextSize(android.webkit.WebSettings.TextSize.SMALLER);
        bundle.setLoadsImagesAutomatically(true);
        bundle.setJavaScriptEnabled(true);
        bundle.setJavaScriptCanOpenWindowsAutomatically(false);
        bundle.setSupportZoom(true);
        bundle.setBuiltInZoomControls(true);
        bundle.setDisplayZoomControls(false);
        loading = findViewById(0x7f100143);
        bundle = getIntent().getExtras();
        productMementoId = bundle.getString("product_memento_id");
        productTitle = bundle.getString("title");
        productPhotoUrl = bundle.getString("photo");
        (new GetProductDetails()).execute(new Void[0]);
        findViewById(0x7f1003ab).setVisibility(8);
        bundle = findViewById(0x7f1003aa);
        bundle.setVisibility(0);
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            final ProductDetailsActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = ProductDetailsActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }
}
