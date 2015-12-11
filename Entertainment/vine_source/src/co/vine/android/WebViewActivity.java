// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import co.vine.android.client.VineAPI;
import co.vine.android.util.BuildUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity

public class WebViewActivity extends BaseControllerActionBarActivity
{

    public static final String EXTRA_TYPE = "type";
    public static final int TYPE_ATTRIBUTION = 5;
    public static final int TYPE_PRIVACY_POLICY_TWITTER = 3;
    public static final int TYPE_PRIVACY_POLICY_VINE = 1;
    public static final int TYPE_TOS_TWITTER = 4;
    public static final int TYPE_TOS_VINE = 2;

    public WebViewActivity()
    {
    }

    public static void start(Context context, Uri uri)
    {
        context.startActivity((new Intent(context, co/vine/android/WebViewActivity)).setData(uri));
    }

    protected void onCreate(Bundle bundle)
    {
        Bundle bundle1;
        super.onCreate(bundle, 0x7f0300a9, false);
        bundle = (WebView)findViewById(0x7f0a00e1);
        bundle.setWebViewClient(new WebViewClient());
        bundle.getSettings().setJavaScriptEnabled(true);
        bundle1 = getIntent().getExtras();
        if (bundle1 == null) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        hashmap = new HashMap(1);
        String s = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(s))
        {
            hashmap.put("Accept-Language", s);
            hashmap.put("X-Vine-Client", VineAPI.getInstance(this).getVineClientHeader());
        }
        bundle1.getInt("type");
        JVM INSTR tableswitch 1 5: default 140
    //                   1 152
    //                   2 166
    //                   3 180
    //                   4 194
    //                   5 208;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        setupActionBar(Boolean.valueOf(true), null, null, null);
        return;
_L4:
        bundle.loadUrl(getString(0x7f0e018c), hashmap);
        continue; /* Loop/switch isn't completed */
_L5:
        bundle.loadUrl(getString(0x7f0e024e), hashmap);
        continue; /* Loop/switch isn't completed */
_L6:
        bundle.loadUrl(getString(0x7f0e018b), hashmap);
        continue; /* Loop/switch isn't completed */
_L7:
        bundle.loadUrl(getString(0x7f0e024d), hashmap);
        continue; /* Loop/switch isn't completed */
_L8:
        if (BuildUtil.isAStar())
        {
            bundle.loadUrl("file:///android_asset/astar_attribution.html");
        } else
        {
            bundle.loadUrl(getString(0x7f0e0050), hashmap);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        Uri uri = getIntent().getData();
        if (uri != null)
        {
            bundle.loadUrl(uri.toString());
        }
        if (true) goto _L3; else goto _L9
_L9:
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f100004, menu);
        menu.findItem(0x7f0a0245).setEnabled(true);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131362373: 
            finish();
            break;
        }
        return true;
    }
}
