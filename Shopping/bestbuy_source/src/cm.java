// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.bestbuy.android.activities.mybby.CIALoginFragment;
import org.json.JSONObject;

public class cm
{

    final CIALoginFragment a;
    private Context b;

    public cm(CIALoginFragment cialoginfragment, Context context)
    {
        a = cialoginfragment;
        super();
        b = context;
    }

    public String a(String s, String s1)
    {
        String s2;
        String s3;
        s2 = "";
        CookieSyncManager.getInstance().sync();
        s3 = CookieManager.getInstance().getCookie(s);
        s = s2;
        if (s3 == null) goto _L2; else goto _L1
_L1:
        String as[];
        as = s3.split(";");
        s = s2;
        if (as == null) goto _L2; else goto _L3
_L3:
        int i;
        int j;
        j = as.length;
        i = 0;
_L8:
        s = s2;
        if (i >= j) goto _L2; else goto _L4
_L4:
        s = as[i].split("=");
        if (s.length < 2 || !s[0].trim().equals(s1)) goto _L6; else goto _L5
_L5:
        s = s[1];
_L2:
        return s;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void eventBusCallback(String s)
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (s != null)
        {
            i = ((flag) ? 1 : 0);
            if (!s.isEmpty())
            {
                i = Integer.parseInt(s);
            }
        }
        nb.a().b().edit().putInt(b.getResources().getString(0x7f080031), i).commit();
        s = new Intent();
        a.d.setResult(-1, s);
        a.d.finish();
        a.d.overridePendingTransition(0x7f040005, 0x7f040008);
    }

    public void eventBusRegister()
    {
        CIALoginFragment.e(a).loadUrl(nl.a(0x7f080195, b));
        CIALoginFragment.e(a).loadUrl(nl.a(0x7f0800ed, b));
    }

    public void executeMainCSS()
    {
        CIALoginFragment.e(a).loadUrl(nl.a(0x7f08021e, CIALoginFragment.e(a).getContext()));
    }

    public void showHTML(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        s = s.replaceAll("\\<[^>]*>", "");
        Object obj;
        try
        {
            obj = new JSONObject(s.replace(a.getString(0x7f080155), ""));
            if (!((JSONObject) (obj)).optString("status", "").equals("success"))
            {
                break MISSING_BLOCK_LABEL_131;
            }
            s = ((JSONObject) (obj)).optString("userToken", "");
            obj = ((JSONObject) (obj)).optString("accessToken", "");
            nb.a().e(false);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        if (obj == null || s == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        a.f.d(true);
        (new io(a.d, a, CIALoginFragment.a(a), s, ((String) (obj)))).execute(new Void[0]);
    }

    public void updateCartCount(String s)
    {
        int i;
        boolean flag = false;
        s = a(s, "CartItemCount");
        i = ((flag) ? 1 : 0);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        i = ((flag) ? 1 : 0);
        if (!s.isEmpty())
        {
            i = Integer.parseInt(s);
        }
        nb.a().b().edit().putInt(b.getResources().getString(0x7f080031), i).commit();
        s = new Intent();
        a.d.setResult(-1, s);
        a.d.finish();
        a.d.overridePendingTransition(0x7f040005, 0x7f040008);
        return;
        s;
        s.printStackTrace();
        return;
    }
}
