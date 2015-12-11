// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import org.w3c.dom.Document;

// Referenced classes of package com.tapjoy:
//            TapjoyHttpURLResponse, TapjoyUtil, TapjoyLog, TJEarnedCurrencyListener, 
//            TJGetCurrencyBalanceListener, TJSpendCurrencyListener, TJAwardCurrencyListener, TapjoyURLConnection, 
//            TapjoyConnectCore

public class TJCurrency
{

    private static TJGetCurrencyBalanceListener d;
    private static TJSpendCurrencyListener e;
    private static TJAwardCurrencyListener f;
    private static TJEarnedCurrencyListener g;
    String a;
    int b;
    Context c;

    public TJCurrency(Context context)
    {
        a = null;
        b = 0;
        c = context;
    }

    static void a(TJCurrency tjcurrency, TapjoyHttpURLResponse tapjoyhttpurlresponse)
    {
        tjcurrency.a(tapjoyhttpurlresponse);
    }

    private void a(TapjoyHttpURLResponse tapjoyhttpurlresponse)
    {
        this;
        JVM INSTR monitorenter ;
        if (tapjoyhttpurlresponse.response == null)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        tapjoyhttpurlresponse = TapjoyUtil.buildDocument(tapjoyhttpurlresponse.response);
        if (tapjoyhttpurlresponse == null) goto _L2; else goto _L1
_L1:
        String s = TapjoyUtil.getNodeTrimValue(tapjoyhttpurlresponse.getElementsByTagName("Success"));
        if (s == null) goto _L4; else goto _L3
_L3:
        if (!s.equals("true")) goto _L4; else goto _L5
_L5:
        s = TapjoyUtil.getNodeTrimValue(tapjoyhttpurlresponse.getElementsByTagName("TapPoints"));
        tapjoyhttpurlresponse = TapjoyUtil.getNodeTrimValue(tapjoyhttpurlresponse.getElementsByTagName("CurrencyName"));
        if (s == null || tapjoyhttpurlresponse == null) goto _L7; else goto _L6
_L6:
        int i;
        int j;
        i = Integer.parseInt(s);
        j = getLocalCurrencyBalance();
        if (g == null || j == -9999 || i <= j)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        TapjoyLog.i("TJCurrency", (new StringBuilder("earned: ")).append(i - j).toString());
        g.onEarnedCurrency(tapjoyhttpurlresponse, i - j);
        saveCurrencyBalance(i);
        if (d != null)
        {
            d.onGetCurrencyBalanceResponse(tapjoyhttpurlresponse, i);
        }
_L9:
        this;
        JVM INSTR monitorexit ;
        return;
        tapjoyhttpurlresponse;
        TapjoyLog.e("TJCurrency", (new StringBuilder("Error parsing XML and calling listener: ")).append(tapjoyhttpurlresponse.toString()).toString());
_L2:
        if (d != null)
        {
            d.onGetCurrencyBalanceResponseFailure("Failed to get currency balance");
        }
        if (true) goto _L9; else goto _L8
_L8:
        tapjoyhttpurlresponse;
        throw tapjoyhttpurlresponse;
_L7:
        TapjoyLog.e("TJCurrency", "Invalid XML: Missing tags.");
          goto _L2
_L4:
        TapjoyLog.e("TJCurrency", "Invalid XML: Missing <Success> tag.");
          goto _L2
        TapjoyLog.e("TJCurrency", "Null response");
          goto _L2
    }

    static void b(TJCurrency tjcurrency, TapjoyHttpURLResponse tapjoyhttpurlresponse)
    {
        tjcurrency.b(tapjoyhttpurlresponse);
    }

    private void b(TapjoyHttpURLResponse tapjoyhttpurlresponse)
    {
        this;
        JVM INSTR monitorenter ;
        String s = "Failed to spend currency";
        if (tapjoyhttpurlresponse.response == null) goto _L2; else goto _L1
_L1:
        Object obj = TapjoyUtil.buildDocument(tapjoyhttpurlresponse.response);
        tapjoyhttpurlresponse = s;
        if (obj == null) goto _L4; else goto _L3
_L3:
        tapjoyhttpurlresponse = TapjoyUtil.getNodeTrimValue(((Document) (obj)).getElementsByTagName("Success"));
        if (tapjoyhttpurlresponse == null) goto _L6; else goto _L5
_L5:
        if (!tapjoyhttpurlresponse.equals("true")) goto _L6; else goto _L7
_L7:
        tapjoyhttpurlresponse = TapjoyUtil.getNodeTrimValue(((Document) (obj)).getElementsByTagName("TapPoints"));
        obj = TapjoyUtil.getNodeTrimValue(((Document) (obj)).getElementsByTagName("CurrencyName"));
        if (tapjoyhttpurlresponse == null || obj == null) goto _L9; else goto _L8
_L8:
        int i = Integer.parseInt(tapjoyhttpurlresponse);
        saveCurrencyBalance(i);
        if (e != null)
        {
            e.onSpendCurrencyResponse(((String) (obj)), i);
        }
_L11:
        this;
        JVM INSTR monitorexit ;
        return;
_L9:
        TapjoyLog.e("TJCurrency", "Invalid XML: Missing tags.");
        tapjoyhttpurlresponse = s;
_L4:
        if (e == null) goto _L11; else goto _L10
_L10:
        e.onSpendCurrencyResponseFailure(tapjoyhttpurlresponse);
          goto _L11
        tapjoyhttpurlresponse;
        throw tapjoyhttpurlresponse;
_L6:
        if (tapjoyhttpurlresponse == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        if (!tapjoyhttpurlresponse.endsWith("false"))
        {
            break MISSING_BLOCK_LABEL_181;
        }
        tapjoyhttpurlresponse = TapjoyUtil.getNodeTrimValue(((Document) (obj)).getElementsByTagName("Message"));
        TapjoyLog.i("TJCurrency", tapjoyhttpurlresponse);
          goto _L4
        TapjoyLog.e("TJCurrency", "Invalid XML: Missing <Success> tag.");
        tapjoyhttpurlresponse = s;
          goto _L4
_L2:
        TapjoyLog.e("TJCurrency", "Null response");
        tapjoyhttpurlresponse = s;
          goto _L4
    }

    static void c(TJCurrency tjcurrency, TapjoyHttpURLResponse tapjoyhttpurlresponse)
    {
        tjcurrency.c(tapjoyhttpurlresponse);
    }

    private void c(TapjoyHttpURLResponse tapjoyhttpurlresponse)
    {
        this;
        JVM INSTR monitorenter ;
        String s = "Failed to award currency";
        if (tapjoyhttpurlresponse.response == null) goto _L2; else goto _L1
_L1:
        Object obj = TapjoyUtil.buildDocument(tapjoyhttpurlresponse.response);
        tapjoyhttpurlresponse = s;
        if (obj == null) goto _L4; else goto _L3
_L3:
        tapjoyhttpurlresponse = TapjoyUtil.getNodeTrimValue(((Document) (obj)).getElementsByTagName("Success"));
        if (tapjoyhttpurlresponse == null) goto _L6; else goto _L5
_L5:
        if (!tapjoyhttpurlresponse.equals("true")) goto _L6; else goto _L7
_L7:
        tapjoyhttpurlresponse = TapjoyUtil.getNodeTrimValue(((Document) (obj)).getElementsByTagName("TapPoints"));
        obj = TapjoyUtil.getNodeTrimValue(((Document) (obj)).getElementsByTagName("CurrencyName"));
        if (tapjoyhttpurlresponse == null || obj == null) goto _L9; else goto _L8
_L8:
        int i = Integer.parseInt(tapjoyhttpurlresponse);
        saveCurrencyBalance(i);
        if (f != null)
        {
            f.onAwardCurrencyResponse(((String) (obj)), i);
        }
_L11:
        this;
        JVM INSTR monitorexit ;
        return;
_L9:
        TapjoyLog.e("TJCurrency", "Invalid XML: Missing tags.");
        tapjoyhttpurlresponse = s;
_L4:
        if (f == null) goto _L11; else goto _L10
_L10:
        f.onAwardCurrencyResponseFailure(tapjoyhttpurlresponse);
          goto _L11
        tapjoyhttpurlresponse;
        throw tapjoyhttpurlresponse;
_L6:
        if (tapjoyhttpurlresponse == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        if (!tapjoyhttpurlresponse.endsWith("false"))
        {
            break MISSING_BLOCK_LABEL_181;
        }
        tapjoyhttpurlresponse = TapjoyUtil.getNodeTrimValue(((Document) (obj)).getElementsByTagName("Message"));
        TapjoyLog.i("TJCurrency", tapjoyhttpurlresponse);
          goto _L4
        TapjoyLog.e("TJCurrency", "Invalid XML: Missing <Success> tag.");
        tapjoyhttpurlresponse = s;
          goto _L4
_L2:
        TapjoyLog.e("TJCurrency", "Null response");
        tapjoyhttpurlresponse = s;
          goto _L4
    }

    public void awardCurrency(int i, TJAwardCurrencyListener tjawardcurrencylistener)
    {
        if (i < 0)
        {
            TapjoyLog.e("TJCurrency", "awardCurrency error: amount must be a positive number");
            return;
        } else
        {
            b = i;
            f = tjawardcurrencylistener;
            (new Thread(new Runnable() {

                final TJCurrency a;

                public final void run()
                {
                    Object obj = UUID.randomUUID().toString();
                    long l = System.currentTimeMillis() / 1000L;
                    java.util.Map map = TapjoyConnectCore.getGenericURLParams();
                    TapjoyUtil.safePut(map, "tap_points", String.valueOf(a.b), true);
                    TapjoyUtil.safePut(map, "guid", ((String) (obj)), true);
                    TapjoyUtil.safePut(map, "timestamp", String.valueOf(l), true);
                    TapjoyUtil.safePut(map, "verifier", TapjoyConnectCore.getAwardCurrencyVerifier(l, a.b, ((String) (obj))), true);
                    obj = (new TapjoyURLConnection()).getResponseFromURL((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("points/award?").toString(), map);
                    TJCurrency.c(a, ((TapjoyHttpURLResponse) (obj)));
                }

            
            {
                a = TJCurrency.this;
                super();
            }
            })).start();
            return;
        }
    }

    public void getCurrencyBalance(TJGetCurrencyBalanceListener tjgetcurrencybalancelistener)
    {
        d = tjgetcurrencybalancelistener;
        (new Thread(new Runnable() {

            final TJCurrency a;

            public final void run()
            {
                TapjoyHttpURLResponse tapjoyhttpurlresponse = (new TapjoyURLConnection()).getResponseFromURL((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("get_vg_store_items/user_account?").toString(), TapjoyConnectCore.getURLParams());
                TJCurrency.a(a, tapjoyhttpurlresponse);
            }

            
            {
                a = TJCurrency.this;
                super();
            }
        })).start();
    }

    public int getLocalCurrencyBalance()
    {
        return c.getSharedPreferences("tjcPrefrences", 0).getInt("last_currency_balance", -9999);
    }

    public void saveCurrencyBalance(int i)
    {
        android.content.SharedPreferences.Editor editor = c.getSharedPreferences("tjcPrefrences", 0).edit();
        editor.putInt("last_currency_balance", i);
        editor.commit();
    }

    public void setEarnedCurrencyListener(TJEarnedCurrencyListener tjearnedcurrencylistener)
    {
        g = tjearnedcurrencylistener;
    }

    public void spendCurrency(int i, TJSpendCurrencyListener tjspendcurrencylistener)
    {
        if (i < 0)
        {
            TapjoyLog.e("TJCurrency", "spendCurrency error: amount must be a positive number");
            return;
        } else
        {
            a = (new StringBuilder()).append(i).toString();
            e = tjspendcurrencylistener;
            (new Thread(new Runnable() {

                final TJCurrency a;

                public final void run()
                {
                    Object obj = TapjoyConnectCore.getURLParams();
                    TapjoyUtil.safePut(((java.util.Map) (obj)), "tap_points", a.a, true);
                    obj = (new TapjoyURLConnection()).getResponseFromURL((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("points/spend?").toString(), ((java.util.Map) (obj)));
                    TJCurrency.b(a, ((TapjoyHttpURLResponse) (obj)));
                }

            
            {
                a = TJCurrency.this;
                super();
            }
            })).start();
            return;
        }
    }
}
