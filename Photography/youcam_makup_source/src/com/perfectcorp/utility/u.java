// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.util.Pair;
import com.perfectcorp.model.Model;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.perfectcorp.utility:
//            x, e, w, v

public class u
{

    public static final Pattern a = Pattern.compile("((aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(biz|b[abdefghijmnorstvwyz])|(cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(edu|e[cegrstu])|f[ijkmor]|(gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(info|int|i[delmnoqrst])|(jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(name|net|n[acefgilopruz])|(org|om)|(pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(\u03B4\u03BF\u03BA\u03B9\u03BC\u03AE|\u0438\u0441\u043F\u044B\u0442\u0430\u043D\u0438\u0435|\u0440\u0444|\u0441\u0440\u0431|\u05D8\u05E2\u05E1\u05D8|\u0622\u0632\u0645\u0627\u06CC\u0634\u06CC|\u0625\u062E\u062A\u0628\u0627\u0631|\u0627\u0644\u0627\u0631\u062F\u0646|\u0627\u0644\u062C\u0632\u0627\u0626\u0631|\u0627\u0644\u0633\u0639\u0648\u062F\u064A\u0629|\u0627\u0644\u0645\u063A\u0631\u0628|\u0627\u0645\u0627\u0631\u0627\u062A|\u0628\u06BE\u0627\u0631\u062A|\u062A\u0648\u0646\u0633|\u0633\u0648\u0631\u064A\u0629|\u0641\u0644\u0633\u0637\u064A\u0646|\u0642\u0637\u0631|\u0645\u0635\u0631|\u092A\u0930\u0940\u0915\u094D\u0937\u093E|\u092D\u093E\u0930\u0924|\u09AD\u09BE\u09B0\u09A4|\u0A2D\u0A3E\u0A30\u0A24|\u0AAD\u0ABE\u0AB0\u0AA4|\u0B87\u0BA8\u0BCD\u0BA4\u0BBF\u0BAF\u0BBE|\u0B87\u0BB2\u0B99\u0BCD\u0B95\u0BC8|\u0B9A\u0BBF\u0B99\u0BCD\u0B95\u0BAA\u0BCD\u0BAA\u0BC2\u0BB0\u0BCD|\u0BAA\u0BB0\u0BBF\u0B9F\u0BCD\u0B9A\u0BC8|\u0C2D\u0C3E\u0C30\u0C24\u0C4D|\u0DBD\u0D82\u0D9A\u0DCF|\u0E44\u0E17\u0E22|\u30C6\u30B9\u30C8|\u4E2D\u56FD|\u4E2D\u570B|\u53F0\u6E7E|\u53F0\u7063|\u65B0\u52A0\u5761|\u6D4B\u8BD5|\u6E2C\u8A66|\u9999\u6E2F|\uD14C\uC2A4\uD2B8|\uD55C\uAD6D|xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-80akhbyknj4f|xn\\-\\-90a3ac|xn\\-\\-9t4b11yi5a|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-deba0ad|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-g6w251d|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-j6w193g|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-s9brj9c|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zckzah|xxx)|y[et]|z[amw])");
    public static final Pattern b = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9\240-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-zA-Z0-9\240-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF\\-]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:\u03B4\u03BF\u03BA\u03B9\u03BC\u03AE|\u0438\u0441\u043F\u044B\u0442\u0430\u043D\u0438\u0435|\u0440\u0444|\u0441\u0440\u0431|\u05D8\u05E2\u05E1\u05D8|\u0622\u0632\u0645\u0627\u06CC\u0634\u06CC|\u0625\u062E\u062A\u0628\u0627\u0631|\u0627\u0644\u0627\u0631\u062F\u0646|\u0627\u0644\u062C\u0632\u0627\u0626\u0631|\u0627\u0644\u0633\u0639\u0648\u062F\u064A\u0629|\u0627\u0644\u0645\u063A\u0631\u0628|\u0627\u0645\u0627\u0631\u0627\u062A|\u0628\u06BE\u0627\u0631\u062A|\u062A\u0648\u0646\u0633|\u0633\u0648\u0631\u064A\u0629|\u0641\u0644\u0633\u0637\u064A\u0646|\u0642\u0637\u0631|\u0645\u0635\u0631|\u092A\u0930\u0940\u0915\u094D\u0937\u093E|\u092D\u093E\u0930\u0924|\u09AD\u09BE\u09B0\u09A4|\u0A2D\u0A3E\u0A30\u0A24|\u0AAD\u0ABE\u0AB0\u0AA4|\u0B87\u0BA8\u0BCD\u0BA4\u0BBF\u0BAF\u0BBE|\u0B87\u0BB2\u0B99\u0BCD\u0B95\u0BC8|\u0B9A\u0BBF\u0B99\u0BCD\u0B95\u0BAA\u0BCD\u0BAA\u0BC2\u0BB0\u0BCD|\u0BAA\u0BB0\u0BBF\u0B9F\u0BCD\u0B9A\u0BC8|\u0C2D\u0C3E\u0C30\u0C24\u0C4D|\u0DBD\u0D82\u0D9A\u0DCF|\u0E44\u0E17\u0E22|\u30C6\u30B9\u30C8|\u4E2D\u56FD|\u4E2D\u570B|\u53F0\u6E7E|\u53F0\u7063|\u65B0\u52A0\u5761|\u6D4B\u8BD5|\u6E2C\u8A66|\u9999\u6E2F|\uD14C\uC2A4\uD2B8|\uD55C\uAD6D|xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-80akhbyknj4f|xn\\-\\-90a3ac|xn\\-\\-9t4b11yi5a|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-deba0ad|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-g6w251d|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-j6w193g|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-s9brj9c|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zckzah|xxx)|y[et]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\240-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
    public static final Pattern c = Pattern.compile("(?i)<a([^>]+)>(.+?)</a>");
    public static x i = new x();
    ArrayList d;
    ArrayList e;
    String f;
    String g;
    public String h;

    public u(String s)
    {
        int j;
        j = 0;
        super();
        d = new ArrayList();
        e = new ArrayList();
        f = "";
        g = "";
        h = "";
        Long long1 = (Long)i.d.get(s);
        int k;
        if (long1 == null)
        {
            long1 = Long.valueOf(1L);
        } else
        {
            long1 = Long.valueOf(long1.longValue() + 1L);
        }
        i.d.put(s, long1);
        k = s.length();
        if (k != 0) goto _L2; else goto _L1
_L1:
        String as[];
        return;
_L2:
        if ((as = s.split("\\?")).length == 0) goto _L1; else goto _L3
_L3:
        f = as[0];
        if (as.length <= 1) goto _L5; else goto _L4
_L4:
        String as1[];
        int l;
        as1 = as[1].split("&");
        l = as1.length;
_L6:
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        String as2[] = as1[j].split("=");
        String s1;
        s1 = as2[0];
        s = "";
        if (as2.length == 2)
        {
            s = as2[1];
        }
        d.add(new Pair(s1, s));
        j++;
        if (true) goto _L6; else goto _L5
_L5:
        try
        {
            g = (new URL(as[0])).getHost();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
    }

    public static String a(String s)
    {
        Matcher matcher;
        if (s != null)
        {
            if ((matcher = Pattern.compile("((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)", 2).matcher(s)).find())
            {
                return s.substring(matcher.start(0), matcher.end(0));
            }
        }
        return null;
    }

    public static String a(String s, boolean flag)
    {
        String s1 = null;
        String s2;
        String s3;
        try
        {
            s2 = (new URI(s)).getHost();
        }
        catch (URISyntaxException urisyntaxexception)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                (new StringBuilder()).append("URISyntaxException ").append(s).toString()
            });
            return s1;
        }
        s3 = s2;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        s3 = s2;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        s3 = s2;
        s1 = s2;
        if (s2.length() <= 4)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        s3 = s2;
        s1 = s2;
        if (!s2.substring(0, 4).toLowerCase(Locale.getDefault()).equals("www."))
        {
            break MISSING_BLOCK_LABEL_75;
        }
        s1 = s2;
        s3 = s2.substring(4);
        return s3;
    }

    private void a(PrintWriter printwriter, String s, w w1, OutputStream outputstream, String s1)
    {
        printwriter.append((new StringBuilder()).append("--").append(s1).toString()).append("\r\n");
        printwriter.append((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"; filename=\"").append(w1.c).append("\"").toString()).append("\r\n");
        printwriter.append((new StringBuilder()).append("Content-Type: ").append(w1.a).toString()).append("\r\n");
        printwriter.append("\r\n");
        printwriter.flush();
        try
        {
            outputstream.write(w1.b);
            outputstream.write("\r\n".getBytes());
            outputstream.flush();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PrintWriter printwriter) { }
        try
        {
            printwriter.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PrintWriter printwriter)
        {
            printwriter.printStackTrace();
        }
        return;
    }

    private void a(PrintWriter printwriter, String s, String s1, String s2)
    {
        try
        {
            printwriter.append((new StringBuilder()).append("--").append(s2).toString()).append("\r\n");
            printwriter.append((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"").toString()).append("\r\n");
            printwriter.append("\r\n");
            printwriter.append(s1).append("\r\n");
            printwriter.flush();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PrintWriter printwriter)
        {
            printwriter.printStackTrace();
        }
    }

    private static boolean a(String s, int j, int k, ArrayList arraylist)
    {
        if (j > 0 && s.charAt(j - 1) == '@')
        {
            return false;
        }
        int i1 = arraylist.size();
        for (int l = 0; l < i1; l++)
        {
            if (j >= ((v)arraylist.get(l)).b && k <= ((v)arraylist.get(l)).c)
            {
                return false;
            }
        }

        return true;
    }

    public static final String c(String s)
    {
        if (s == null)
        {
            return "";
        }
        ArrayList arraylist = new ArrayList();
        v v1;
        for (Matcher matcher = c.matcher(s); matcher.find(); arraylist.add(v1))
        {
            v1 = new v();
            v1.a = matcher.group(0);
            v1.b = matcher.start();
            v1.c = matcher.end();
        }

        Matcher matcher1 = b.matcher(s);
        StringBuilder stringbuilder = new StringBuilder();
        int j = 0;
        while (matcher1.find()) 
        {
            int l = matcher1.start();
            int k = matcher1.end();
            if (a(s, l, k, arraylist))
            {
                stringbuilder.append(s.subSequence(j, l));
                stringbuilder.append((new StringBuilder()).append("<a href=\"").append(matcher1.group(0)).append("\">").append(matcher1.group(0)).append("</a> ").toString());
            } else
            {
                stringbuilder.append(s.subSequence(j, l));
                stringbuilder.append(matcher1.group(0));
            }
            j = k;
        }
        if (j != s.length())
        {
            stringbuilder.append(s.subSequence(j, s.length()));
        }
        return d(stringbuilder.toString());
    }

    public static String d(String s)
    {
        return s.replaceAll("(\r\n|\n)", "<br />");
    }

    public static boolean e(String s)
    {
        return s.startsWith("https://play.google.com/store/apps/details");
    }

    public String a()
    {
        return f;
    }

    public void a(Model model)
    {
        Class class1 = model.getClass();
        if (class1 != null && model != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Field afield[];
        int j;
        int k;
        afield = class1.getFields();
        k = afield.length;
        j = 0;
_L6:
        if (j >= k) goto _L1; else goto _L3
_L3:
        Object obj1;
        int l;
        obj1 = afield[j];
        l = ((Field) (obj1)).getModifiers();
        if (Modifier.isPublic(l) && !Modifier.isStatic(l) && !Modifier.isTransient(l)) goto _L5; else goto _L4
_L4:
        j++;
          goto _L6
_L5:
        Object obj = ((Field) (obj1)).get(model);
        if (obj != null)
        {
            try
            {
                obj1 = ((Field) (obj1)).getName();
                obj = obj.toString();
                d.add(new Pair(obj1, obj));
            }
            catch (Exception exception)
            {
                com.perfectcorp.utility.e.d(new Object[] {
                    exception
                });
            }
        }
          goto _L4
    }

    public void a(String s, Object obj)
    {
        if (obj != null)
        {
            d.add(new Pair(s, obj.toString()));
        }
    }

    public void a(String s, byte abyte0[], String s1, String s2)
    {
        if (abyte0 != null)
        {
            abyte0 = new w(this, abyte0, s1, s2);
            e.add(new Pair(s, abyte0));
        }
    }

    public boolean a(PrintWriter printwriter, OutputStream outputstream, String s)
    {
        if (d.size() > 0)
        {
            Iterator iterator = d.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (Pair)iterator.next();
                String s1 = (String)((Pair) (obj)).first;
                obj = (String)((Pair) (obj)).second;
                if (!s1.isEmpty())
                {
                    a(printwriter, s1, ((String) (obj)), s);
                }
            } while (true);
            iterator = e.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj1 = (Pair)iterator.next();
                String s2 = (String)((Pair) (obj1)).first;
                obj1 = (w)((Pair) (obj1)).second;
                if (!s2.isEmpty() && obj1 != null)
                {
                    a(printwriter, s2, ((w) (obj1)), outputstream, s);
                }
            } while (true);
            printwriter.append((new StringBuilder()).append("--").append(s).append("--").toString()).append("\r\n").flush();
            printwriter.close();
        }
        return true;
    }

    public String b()
    {
        String s = "";
        String s1 = s;
        if (d.size() > 0)
        {
            boolean flag = false;
            Iterator iterator = d.iterator();
            do
            {
                s1 = s;
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (Pair)iterator.next();
                s1 = (String)((Pair) (obj)).first;
                obj = (String)((Pair) (obj)).second;
                if (!s1.isEmpty())
                {
                    if (!flag)
                    {
                        flag = true;
                    } else
                    {
                        s = (new StringBuilder()).append(s).append("&").toString();
                    }
                    s = (new StringBuilder()).append(s).append(s1).append("=").append(((String) (obj))).toString();
                }
            } while (true);
        }
        return s1;
    }

    public void b(String s)
    {
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((String)((Pair)iterator.next()).first).equals(s))
            {
                iterator.remove();
            }
        } while (true);
    }

    public String c()
    {
        String s;
        s = "";
        if (f != "")
        {
            s = f;
        }
        if (d.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        boolean flag;
        iterator = d.iterator();
        flag = false;
_L4:
        Object obj;
        obj = s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Pair)iterator.next();
        String s2 = (String)((Pair) (obj)).first;
        obj = (String)((Pair) (obj)).second;
        if (s2.isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        String s1;
        if (!flag)
        {
            flag = true;
            s = (new StringBuilder()).append(s).append("?").toString();
        } else
        {
            s = (new StringBuilder()).append(s).append("&").toString();
        }
        s1 = URLEncoder.encode(((String) (obj)), "UTF-8").replaceAll("\\+", "%20");
        obj = s1;
_L5:
        s = (new StringBuilder()).append(s).append(s2).append("=").append(((String) (obj))).toString();
        if (true) goto _L4; else goto _L3
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
          goto _L5
_L2:
        obj = s;
_L3:
        return ((String) (obj));
    }

}
