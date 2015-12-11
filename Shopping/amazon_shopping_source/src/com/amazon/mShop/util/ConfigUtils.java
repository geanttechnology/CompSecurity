// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.res.Resources;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.mobileads.DebugSettingsActivityForAds;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

// Referenced classes of package com.amazon.mShop.util:
//            ResourcesUtils, Util

public class ConfigUtils
{

    public ConfigUtils()
    {
    }

    public static String getString(Context context, int i)
    {
        String s;
        if (context != null)
        {
            if ((s = context.getString(i)) != null)
            {
                return ResourcesUtils.getStringForCurrentLocale(context, s);
            }
        }
        return null;
    }

    public static String getStringForApp(Context context, int i)
    {
        if (context == null)
        {
            return null;
        } else
        {
            return context.getResources().getString(i);
        }
    }

    public static String getStringForSpecificLocale(Context context, int i, String s)
    {
        String s1;
        if (context != null)
        {
            if ((s1 = context.getString(i)) != null)
            {
                return ResourcesUtils.getStringOfSpecificLocale(context, s1, s);
            }
        }
        return null;
    }

    public static void injectDefaultDebugSettings(Context context)
    {
        if (DebugSettings.isDebugEnabled()) goto _L2; else goto _L1
_L1:
        int i;
        return;
_L2:
        if ((i = context.getResources().getIdentifier("debugsettings", "raw", context.getPackageName())) == 0) goto _L1; else goto _L3
_L3:
        Object obj;
        Object obj1;
        Object obj2;
        HashMap hashmap;
        HashMap hashmap1;
        HashMap hashmap2;
        boolean flag1;
        obj1 = context.getResources().openRawResource(i);
        context.getText(i).toString();
        obj2 = null;
        flag1 = false;
        hashmap2 = new HashMap();
        hashmap1 = new HashMap();
        hashmap = new HashMap();
        obj = null;
        XmlPullParser xmlpullparser;
        obj1 = readTextFile(((InputStream) (obj1)));
        XmlPullParserFactory xmlpullparserfactory = XmlPullParserFactory.newInstance();
        xmlpullparserfactory.setNamespaceAware(true);
        xmlpullparser = xmlpullparserfactory.newPullParser();
        xmlpullparser.setInput(new StringReader(((String) (obj1))));
        i = xmlpullparser.getEventType();
          goto _L4
_L17:
        i = xmlpullparser.next();
        Object obj3;
        boolean flag;
        obj = obj3;
        flag1 = flag;
        obj2 = obj1;
          goto _L4
_L14:
        if (i != 2) goto _L6; else goto _L5
_L5:
        obj1 = xmlpullparser.getName();
        if (!"DataStore".equals(obj1)) goto _L8; else goto _L7
_L7:
        obj = hashmap2;
_L10:
        obj1 = xmlpullparser.getAttributeValue(null, "name");
        flag = "string".equals(xmlpullparser.getAttributeValue(null, "type"));
        obj3 = obj;
        continue; /* Loop/switch isn't completed */
_L8:
        if ("Cookie".equals(obj1))
        {
            obj = hashmap1;
            continue; /* Loop/switch isn't completed */
        }
        if ("MobileAdsDataStore".equals(obj1))
        {
            obj = hashmap;
        }
        if (true) goto _L10; else goto _L9
_L9:
        obj3 = obj;
        flag = flag1;
        obj1 = obj2;
        if (i != 4)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj3 = obj;
        flag = flag1;
        obj1 = obj2;
        if (obj2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj3 = obj;
        flag = flag1;
        obj1 = obj2;
        if ("".equals(((String) (obj2)).trim()))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj3 = xmlpullparser.getText();
        obj1 = obj3;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        obj1 = (new StringBuilder()).append("\"").append(((String) (obj3))).append("\"").toString();
        ((HashMap) (obj)).put(obj2, obj1);
        obj3 = obj;
        flag = flag1;
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
        obj;
_L11:
        obj = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        obj1 = hashmap2.entrySet().iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            obj3 = (java.util.Map.Entry)((Iterator) (obj1)).next();
            obj2 = (String)((java.util.Map.Entry) (obj3)).getKey();
            obj3 = (String)((java.util.Map.Entry) (obj3)).getValue();
            if (Util.isEmpty(((DataStore) (obj)).getString(((String) (obj2)))))
            {
                ((DataStore) (obj)).putString(((String) (obj2)), ((String) (obj3)), false);
            }
        } while (true);
        obj3 = hashmap1.entrySet().iterator();
        do
        {
            if (!((Iterator) (obj3)).hasNext())
            {
                break;
            }
            obj = (java.util.Map.Entry)((Iterator) (obj3)).next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj2 = (String)((java.util.Map.Entry) (obj)).getValue();
            obj1 = null;
            Map map = CookieBridge.getCookie(s, context);
            obj = obj1;
            if (map != null)
            {
                obj = obj1;
                if (map.size() > 0)
                {
                    obj = (String)map.get(s);
                }
            }
            obj1 = obj2;
            if (obj2 == null)
            {
                obj1 = "";
            }
            if (Util.isEmpty(((String) (obj))))
            {
                CookieBridge.setCookie(context, false, s, ((String) (obj1)));
            }
        } while (true);
        DebugSettingsActivityForAds.writeSettingsMap(context, hashmap);
        obj = new WebView(context);
        ((WebView) (obj)).setWebViewClient(new WebViewClient());
        ((WebView) (obj)).loadUrl(context.getString(com.amazon.mShop.android.lib.R.string.wishlist_web_page_url));
        return;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L11; else goto _L4
_L4:
        if (i == 1) goto _L11; else goto _L12
_L12:
        if (i != 0) goto _L14; else goto _L13
_L13:
        obj3 = obj;
        flag = flag1;
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
_L6:
        if (i != 3) goto _L9; else goto _L15
_L15:
        obj1 = null;
        flag = false;
        obj3 = obj;
        if (true) goto _L17; else goto _L16
_L16:
    }

    public static boolean isDigitalContentEnabled()
    {
        return isEnabled(com.amazon.mShop.android.lib.R.string.config_hasAppstore) || isEnabled(com.amazon.mShop.android.lib.R.string.config_hasAIV);
    }

    public static boolean isEnabled(int i)
    {
        return isEnabled(AndroidPlatform.getInstance().getApplicationContext(), i);
    }

    public static boolean isEnabled(Context context, int i)
    {
        String s;
        if (context != null)
        {
            if ((s = context.getString(i)) != null)
            {
                return ResourcesUtils.getBoolForCurrentLocale(context, s);
            }
        }
        return false;
    }

    public static boolean isEnabledForApp(Context context, int i)
    {
        if (context == null)
        {
            return false;
        } else
        {
            return context.getResources().getBoolean(i);
        }
    }

    private static String readTextFile(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[1024];
_L1:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        bytearrayoutputstream.write(abyte0, 0, i);
          goto _L1
        Object obj;
        obj;
        ((IOException) (obj)).printStackTrace();
        try
        {
            bytearrayoutputstream.close();
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        return bytearrayoutputstream.toString();
        try
        {
            bytearrayoutputstream.close();
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        obj;
        try
        {
            bytearrayoutputstream.close();
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        throw obj;
    }
}
