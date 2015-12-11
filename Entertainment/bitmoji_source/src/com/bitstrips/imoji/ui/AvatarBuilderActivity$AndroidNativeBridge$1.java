// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.webkit.WebView;
import com.bitstrips.imoji.util.WebUtils;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AvatarBuilderActivity

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        String s = Locale.getDefault().getLanguage();
        String s1 = cess._mth100(this._cls1.this).getString(0x7f0600cf);
        String s2 = (new StringBuilder()).append(cess._mth100(this._cls1.this).getString(0x7f060038)).append(cess._mth100(this._cls1.this).getString(0x7f060027)).toString();
        String s3 = cess._mth100(this._cls1.this).getString(0x7f060026);
        Object obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("endPoint", s2);
            ((JSONObject) (obj)).put("fbToken", cess._mth200(this._cls1.this));
            ((JSONObject) (obj)).put("bsauthToken", cess._mth300(this._cls1.this));
            ((JSONObject) (obj)).put("renderHost", s1);
            ((JSONObject) (obj)).put("locale", s);
            ((JSONObject) (obj)).put("localizedStrings", tWebviewTranslations());
            ((JSONObject) (obj)).put("theme", s3);
            ((JSONObject) (obj)).put("requestAvatarStyle", true);
            ((JSONObject) (obj)).put("appName", cess._mth100(this._cls1.this).getString(0x7f060017));
            ((JSONObject) (obj)).put("userAgent", WebUtils.getBitmojiUserAgent(getApplication()));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        obj = String.format("javascript:imoji_app.getValueCallback(%s)", new Object[] {
            ((JSONObject) (obj)).toString()
        });
        cess._mth400(this._cls1.this).loadUrl(((String) (obj)));
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
