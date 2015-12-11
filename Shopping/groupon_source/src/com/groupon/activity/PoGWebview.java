// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.LoginService;
import com.groupon.util.CacheUtils;
import com.groupon.util.InternalDeeplink;
import com.groupon.util.WebViewHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            BaseWebViewActivity, IntentFactory

public class PoGWebview extends BaseWebViewActivity
{
    public class PoGWebViewHelper extends WebViewHelper
    {

        final PoGWebview this$0;

        public Map createWebViewHeaders(String s, String s1)
        {
            s1 = new HashMap();
            s1.put("Authorization", String.format("%s %s", new Object[] {
                "OAuth", s
            }));
            return s1;
        }

        public String getUrl()
        {
            if (prefs.getBoolean("enable_pog_test_webview", false))
            {
                return "file:///android_asset/groupon-links.html";
            } else
            {
                return processUrl(url);
            }
        }

        public boolean shouldOverrideUrlLoading(String s)
        {
            if (!InternalDeeplink.isUrlInternal(s))
            {
                break MISSING_BLOCK_LABEL_164;
            }
            internalDeeplink = new InternalDeeplink(PoGWebview.this, s);
            if (!internalDeeplink.isCameraAction()) goto _L2; else goto _L1
_L1:
            startActivityForResult(intentFactory.newCameraCapture(tempfile), 100);
_L4:
            return true;
_L2:
            if (internalDeeplink.isPhotoAction())
            {
                startActivityForResult(intentFactory.newPhotoPicker(), 200);
                return true;
            }
            if (internalDeeplink.isCloseIntent())
            {
                finish();
                return true;
            }
            if (!internalDeeplink.isLoginIntent())
            {
                break MISSING_BLOCK_LABEL_164;
            }
            if (loginService.isLoggedIn()) goto _L4; else goto _L3
_L3:
            startActivity(intentFactory.newLoginIntent(PoGWebview.this));
            return true;
            if (!deepLinkUtil.isDeepLink(s))
            {
                break MISSING_BLOCK_LABEL_214;
            }
            com.groupon.deeplink.DeepLinkData deeplinkdata = deepLinkUtil.getDeepLink(url);
            deepLinkManager.followDeepLink(context, deeplinkdata);
            return true;
            InvalidDeepLinkException invaliddeeplinkexception;
            invaliddeeplinkexception;
            return super.shouldOverrideUrlLoading(s);
        }

        public PoGWebViewHelper(Context context)
        {
            this$0 = PoGWebview.this;
            super(context);
        }
    }


    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final String CUSTOM_LOCAL_WEBVIEW = "file:///android_asset/groupon-links.html";
    private static final String JAVASCRIPT_HOOK = "javascript:%s('%s')";
    private static final String QUERY_PARAM = "&%s=%s";
    private static final int SELECT_IMAGE_ACTIVITY_REQUEST_CODE = 200;
    private static final String TEMPORARY_IMAGE_NAME = "pog_temp_image";
    private static final String WEB_PLATFORM = "platform=mobile-app-web-view";
    ImageView closeButton;
    String contxt;
    private DeepLinkManager deepLinkManager;
    private DeepLinkUtil deepLinkUtil;
    protected InternalDeeplink internalDeeplink;
    private LoginService loginService;
    String placeId;
    private SharedPreferences prefs;
    String surveyId;
    protected File tempfile;
    String url;

    public PoGWebview()
    {
    }

    private int exifToDegrees(Uri uri)
    {
        int i = (new ExifInterface(uri.getPath())).getAttributeInt("Orientation", 1);
        if (i == 6)
        {
            return 90;
        }
        if (i == 3)
        {
            return 180;
        }
        if (i == 8)
        {
            return 270;
        }
        break MISSING_BLOCK_LABEL_52;
        uri;
        Ln.e(uri);
        return 0;
    }

    private int getOrientation(Uri uri)
    {
        Cursor cursor;
        cursor = getContentResolver().query(uri, new String[] {
            "orientation"
        }, null, null, null);
        if (cursor == null)
        {
            return exifToDegrees(uri);
        }
        int i = cursor.getCount();
        if (i != 1)
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        i = cursor.getInt(0);
        cursor.close();
        return i;
        uri;
        cursor.close();
        throw uri;
    }

    private String processUrl(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(prefs.getString("webview_base_url", "https://www.groupon.com"));
        stringbuffer.append(s);
        stringbuffer.append("?");
        stringbuffer.append("platform=mobile-app-web-view");
        if (Strings.notEmpty(contxt))
        {
            stringbuffer.append(String.format("&%s=%s", new Object[] {
                "context".toLowerCase(), contxt
            }));
        }
        if (Strings.notEmpty(placeId))
        {
            stringbuffer.append(String.format("&%s=%s", new Object[] {
                "placeId", placeId
            }));
        }
        if (Strings.notEmpty(surveyId))
        {
            stringbuffer.append(String.format("&%s=%s", new Object[] {
                "surveyId", surveyId
            }));
        }
        return stringbuffer.toString();
    }

    public WebViewHelper createHelper()
    {
        return new PoGWebViewHelper(this);
    }

    public String getCorrectlyOrientedImage(Uri uri, int i)
        throws IOException
    {
        Object obj = getContentResolver().openInputStream(uri);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(((InputStream) (obj)), null, options);
        ((InputStream) (obj)).close();
        int l = getOrientation(uri);
        int j;
        int k;
        if (l == 90 || l == 270)
        {
            k = options.outHeight;
            j = options.outWidth;
        } else
        {
            k = options.outWidth;
            j = options.outHeight;
        }
        obj = getContentResolver().openInputStream(uri);
        if (k > i || j > i)
        {
            float f = Math.max((float)k / (float)i, (float)j / (float)i);
            uri = new android.graphics.BitmapFactory.Options();
            uri.inSampleSize = (int)f;
            uri = BitmapFactory.decodeStream(((InputStream) (obj)), null, uri);
        } else
        {
            uri = BitmapFactory.decodeStream(((InputStream) (obj)));
        }
        ((InputStream) (obj)).close();
        obj = uri;
        if (l > 0)
        {
            obj = new Matrix();
            ((Matrix) (obj)).postRotate(l);
            obj = Bitmap.createBitmap(uri, 0, 0, uri.getWidth(), uri.getHeight(), ((Matrix) (obj)), true);
        }
        uri = new ByteArrayOutputStream();
        ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.PNG, 100, uri);
        return Base64.encodeToString(uri.toByteArray(), 0);
    }

    protected int getLayoutResId()
    {
        return 0x7f030192;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        bundle = getSupportActionBar();
        bundle.setTitle(null);
        bundle.setDisplayShowTitleEnabled(false);
        bundle.setDisplayHomeAsUpEnabled(false);
        bundle.setBackgroundDrawable(new ColorDrawable(getResources().getColor(0x7f0e0196)));
        closeButton.setImageDrawable(getResources().getDrawable(0x7f02032a));
        int i = (int)getResources().getDimension(0x7f0b021b);
        closeButton.getLayoutParams().height = i;
        closeButton.getLayoutParams().width = i;
        closeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final PoGWebview this$0;

            public void onClick(View view)
            {
                if (isDeepLinked)
                {
                    view = getDeepLinkUpIntent();
                    view.setFlags(view.getFlags() | 0x10000000 | 0x8000);
                    startActivity(view);
                    return;
                } else
                {
                    finish();
                    return;
                }
            }

            
            {
                this$0 = PoGWebview.this;
                super();
            }
        });
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        String s = internalDeeplink.getParam("callback");
        int k = internalDeeplink.getIntParam("maxSize");
        if (i == 100 && j == -1)
        {
            sendImageToWebview(s, Uri.fromFile(tempfile), k);
        } else
        if (i == 200 && -1 == j)
        {
            sendImageToWebview(s, intent.getData(), k);
            tempfile.delete();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        tempfile = CacheUtils.getImageCacheDirWithNewFile("pog_temp_image");
        toolbar.setVisibility(0);
    }

    public void sendImageToWebview(String s, Uri uri, int i)
    {
        try
        {
            webView.loadUrl(String.format("javascript:%s('%s')", new Object[] {
                s, getCorrectlyOrientedImage(uri, i)
            }));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.e(s);
        }
    }




}
