// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jpush.android.a;
import cn.jpush.android.data.d;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.x;

public final class f extends WebViewClient
{

    private static final String z[];
    private final d a;

    public f(d d1)
    {
        a = d1;
    }

    public final void onLoadResource(WebView webview, String s)
    {
        super.onLoadResource(webview, s);
    }

    public final void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Object obj;
        obj = webview.getContext();
        (new StringBuilder(z[1])).append(s).toString();
        x.d();
        String s1;
        s1 = String.format(z[18], new Object[] {
            s
        });
        if (!a.O)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        ((Context) (obj)).startActivity(new Intent(z[14], Uri.parse(s)));
        ServiceInterface.a(a.c, 1016, s1, a.d);
        return true;
        if (!s.endsWith(z[7]))
        {
            break MISSING_BLOCK_LABEL_156;
        }
        obj = new Intent(z[14]);
        ((Intent) (obj)).setDataAndType(Uri.parse(s), z[20]);
        webview.getContext().startActivity(((Intent) (obj)));
        return true;
        if (!s.endsWith(z[17]) && !s.endsWith(z[3]))
        {
            break MISSING_BLOCK_LABEL_220;
        }
        obj = new Intent(z[14]);
        ((Intent) (obj)).setDataAndType(Uri.parse(s), z[19]);
        webview.getContext().startActivity(((Intent) (obj)));
        return true;
        if (s.startsWith(z[8]))
        {
            webview.loadUrl(s);
            ServiceInterface.a(a.c, 1016, s1, a.d);
            break MISSING_BLOCK_LABEL_645;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_645;
        }
        if (!s.startsWith(z[5]))
        {
            break MISSING_BLOCK_LABEL_645;
        }
        webview = s;
        if (s.lastIndexOf(z[13]) >= 0) goto _L2; else goto _L1
_L1:
        webview = s;
        if (s.startsWith(z[5])) goto _L2; else goto _L3
_L3:
        if (s.indexOf("?") <= 0)
        {
            break MISSING_BLOCK_LABEL_618;
        }
        webview = (new StringBuilder()).append(s).append(z[21]).toString();
_L4:
        webview.lastIndexOf(z[13]);
_L2:
        String s2;
        String s3;
        int i = webview.indexOf("?");
        s3 = webview.substring(0, i);
        s2 = webview.substring(i);
        (new StringBuilder(z[4])).append(s3).toString();
        x.b();
        (new StringBuilder(z[2])).append(s2).toString();
        x.b();
        s = null;
        webview = s;
        String as[];
        if (!s3.startsWith(z[5]))
        {
            break MISSING_BLOCK_LABEL_589;
        }
        as = s3.split(":");
        webview = s;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_589;
        }
        webview = s;
        if (as.length != 2)
        {
            break MISSING_BLOCK_LABEL_589;
        }
        int j = s2.indexOf(z[10]);
        int k = s2.indexOf(z[15]);
        s = s2.substring(j + 6, k);
        s2 = s2.substring(k + 9);
        String s4 = as[1];
        try
        {
            webview = new Intent(z[16]);
            webview.setType(z[9]);
            webview.putExtra(z[12], new String[] {
                s4
            });
            webview.putExtra(z[11], s);
            webview.putExtra(z[0], s2);
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            x.f();
            return true;
        }
        if (webview == null)
        {
            break MISSING_BLOCK_LABEL_598;
        }
        ((Context) (obj)).startActivity(webview);
        ServiceInterface.a(a.c, 1016, s1, a.d);
        return true;
        webview = (new StringBuilder()).append(s).append(z[6]).toString();
          goto _L4
        return false;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[22];
        i = 0;
        obj1 = "\0321\tbl\022;Cym\017:\003d-\036'\031bbU\013(HW";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int k;
        int l;
        int i1;
        byte byte2;
        int j1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        i1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac;
        j1 = i;
        as1 = ((String []) (obj));
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 744
    //                   1 751
    //                   2 758
    //                   3 765;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_765;
_L3:
        byte0 = 3;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ i1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        i1 = l;
        l = j;
        as1 = as2;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as2 = as1;
        j = l;
        k = i1;
        if (l > i1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j1] = ((String) (obj));
            i = 1;
            obj1 = ".-\0010u\032*\001u#\022,M*";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "**\bbz(+\037ym\034eM";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "Ul\n`";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = ".-\004*#";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "\026>\004|w\024";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            i = 6;
            obj1 = "D;\004bf\030+Pvb\027,\b";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j1] = ((String) (obj));
            i = 7;
            obj1 = "U2\035#";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j1] = ((String) (obj));
            i = 8;
            obj1 = "\023+\031`";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j1] = ((String) (obj));
            i = 9;
            obj1 = "\0133\fymT+\bhw";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j1] = ((String) (obj));
            i = 10;
            obj1 = "\0176\031|fF";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j1] = ((String) (obj));
            i = 11;
            obj1 = "\0321\tbl\022;Cym\017:\003d-\036'\031bbU\f8RI>\0349";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j1] = ((String) (obj));
            i = 12;
            obj1 = "\0321\tbl\022;Cym\017:\003d-\036'\031bbU\032 QJ7";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j1] = ((String) (obj));
            i = 13;
            obj1 = "\0376\037u`\017b";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j1] = ((String) (obj));
            i = 14;
            obj1 = "\0321\tbl\022;Cym\017:\003d-\032<\031yl\025q;YF,";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[j1] = ((String) (obj));
            i = 15;
            obj1 = "]<\002~w\0361\031-";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[j1] = ((String) (obj));
            i = 16;
            obj1 = "\0321\tbl\022;Cym\017:\003d-\032<\031yl\025q>UM?";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[j1] = ((String) (obj));
            i = 17;
            obj1 = "U2\035$";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[j1] = ((String) (obj));
            i = 18;
            obj1 = "\000}\030boYeO5pY\"";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[j1] = ((String) (obj));
            i = 19;
            obj1 = "\r6\tulTu";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[j1] = ((String) (obj));
            i = 20;
            obj1 = "\032*\tylTu";
            byte0 = 19;
            obj = as;
            break;

        case 19: // '\023'
            as1[j1] = ((String) (obj));
            i = 21;
            obj1 = "];\004bf\030+Pvb\027,\b";
            byte0 = 20;
            obj = as;
            break;

        case 20: // '\024'
            as1[j1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 123;
          goto _L13
_L5:
        byte0 = 95;
          goto _L13
_L6:
        byte0 = 109;
          goto _L13
        byte0 = 16;
          goto _L13
    }
}
