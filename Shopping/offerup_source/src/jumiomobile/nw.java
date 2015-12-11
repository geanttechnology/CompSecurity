// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.enums.NVGender;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package jumiomobile:
//            nx, nz, ny

public class nw
{

    private final String a = "^(?:(?:19|20)\\d{2})$";
    private final String b = "^(?:0[1-9]|1[0-2])(?:0[1-9]|[12][0-9]|3[01])$";
    private final String c = "^(?:0[1-9]|[12][0-9]|3[01])(?:0[1-9]|1[0-2])$";
    private final String d = "yyyy";
    private final String e = "MMdd";
    private final String f = "ddMM";
    private SimpleDateFormat g;
    private String h;
    private char i[];
    private ArrayList j;
    private String k;
    private int l;
    private int m;
    private nz n;

    public nw()
    {
        g = null;
        h = "";
        k = "";
        l = -1;
        m = 0;
        n = null;
        g = new SimpleDateFormat();
        j = new ArrayList();
    }

    private Date a(String s, boolean flag)
    {
        if (!s.isEmpty()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        String s1;
        Pattern pattern;
        Pattern pattern1;
        Pattern pattern2;
        s = s.replaceAll("\\D", "");
        obj = s.substring(0, 4);
        s1 = s.substring(4);
        pattern = Pattern.compile("^(?:(?:19|20)\\d{2})$");
        pattern1 = Pattern.compile("^(?:0[1-9]|1[0-2])(?:0[1-9]|[12][0-9]|3[01])$");
        pattern2 = Pattern.compile("^(?:0[1-9]|[12][0-9]|3[01])(?:0[1-9]|1[0-2])$");
        if (!pattern.matcher(((CharSequence) (obj))).matches() || !pattern1.matcher(s1).matches()) goto _L4; else goto _L3
_L3:
        g.applyPattern("yyyyMMdd");
_L6:
        s = g.parse(s);
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            obj = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            flag = s.after(((SimpleDateFormat) (obj)).parse(((SimpleDateFormat) (obj)).format(new Date())));
        }
        catch (Exception exception)
        {
            return s;
        }
        if (flag) goto _L1; else goto _L5
_L5:
        return s;
_L4:
        try
        {
label0:
            {
                if (!pattern.matcher(((CharSequence) (obj))).matches() || !pattern2.matcher(s1).matches())
                {
                    break label0;
                }
                g.applyPattern("yyyyddMM");
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
          goto _L6
        if (!pattern1.matcher(((CharSequence) (obj))).matches() || !pattern.matcher(s1).matches()) goto _L8; else goto _L7
_L7:
        g.applyPattern("MMddyyyy");
          goto _L6
_L8:
        if (!pattern2.matcher(((CharSequence) (obj))).matches() || !pattern.matcher(s1).matches()) goto _L6; else goto _L9
_L9:
        g.applyPattern("ddMMyyyy");
          goto _L6
    }

    private void a()
    {
        Matcher matcher = Pattern.compile("@([\\x00-\\x1F\\x21-\\x40\\x5B-\\xFF]{2,3})[A-Z ]*([0-9]{6})([0-9]{2})[0-9]*").matcher(h);
        if (matcher.find())
        {
            String s = matcher.group(1);
            i = new char[s.length()];
            s.getChars(0, s.length(), i, 0);
            k = matcher.group(2);
            l = Integer.parseInt(matcher.group(3));
        }
        h = h.replaceAll("@([\\x00-\\x1F\\x21-\\x40\\x5B-\\xFF]{2,3})[A-Z ]*([0-9]{6})([0-9]{2})[0-9]*", "");
        m = 0;
    }

    private void b()
    {
        Matcher matcher = Pattern.compile("^((?:[A-Z]{2}[0-9]{8})*)").matcher(h);
        j.clear();
        if (matcher.find())
        {
            for (matcher = Pattern.compile("([A-Z]{2})").matcher(matcher.group(1)); matcher.find(); j.add(matcher.group(1))) { }
        }
        h = h.replaceAll("^((?:[A-Z]{2}[0-9]{8})*)", "");
        m = 0;
    }

    private int c()
    {
        if (i == null || h == null)
        {
            throw new nx("Delimiter or rawdata not set");
        }
        if (m < h.length()) goto _L2; else goto _L1
_L1:
        int k1 = -1;
_L4:
        return k1;
_L2:
        int i1 = h.length();
        int j1 = 0;
        do
        {
            k1 = i1;
            if (j1 >= i.length)
            {
                continue;
            }
            int l1 = h.indexOf(i[j1], m);
            k1 = i1;
            if (l1 < i1)
            {
                k1 = i1;
                if (l1 != -1)
                {
                    k1 = l1;
                }
            }
            j1++;
            i1 = k1;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void d()
    {
        n = new nz();
        int i1 = c();
label0:
        do
        {
            if (i1 != -1)
            {
                Object obj = h.substring(m, i1);
                int j1 = 0;
                do
                {
label1:
                    {
                        if (j1 < j.size())
                        {
                            if (!((String) (obj)).startsWith((String)j.get(j1)))
                            {
                                break label1;
                            }
                            obj = ((String) (obj)).substring(((String)j.get(j1)).length());
                        }
                        if (((String) (obj)).startsWith("DAA"))
                        {
                            obj = ((String) (obj)).substring(3);
                            if (((String) (obj)).contains(","))
                            {
                                obj = ((String) (obj)).split(",");
                                if (l == 1 && "636020".equals(k))
                                {
                                    if (obj.length > 0)
                                    {
                                        n.f(obj[0]);
                                    }
                                    if (obj.length > 2)
                                    {
                                        n.h(obj[1]);
                                    }
                                    if (obj.length > 1)
                                    {
                                        n.g(obj[obj.length - 1]);
                                    }
                                } else
                                {
                                    if (obj.length > 0)
                                    {
                                        n.g(obj[0]);
                                    }
                                    if (obj.length > 1)
                                    {
                                        n.f(obj[1]);
                                    }
                                    if (obj.length > 2)
                                    {
                                        n.h(obj[2]);
                                    }
                                }
                            } else
                            {
                                obj = ((String) (obj)).split(" ");
                                if (obj.length > 0)
                                {
                                    if (obj.length == 1)
                                    {
                                        n.g(obj[0]);
                                    } else
                                    if (obj.length == 2)
                                    {
                                        n.f(obj[0]);
                                        n.g(obj[1]);
                                    } else
                                    {
                                        n.f(obj[0]);
                                        n.h(obj[1]);
                                        StringBuilder stringbuilder = new StringBuilder();
                                        for (int k1 = 2; k1 < obj.length; k1++)
                                        {
                                            stringbuilder.append(obj[k1]);
                                            stringbuilder.append(" ");
                                        }

                                        obj = stringbuilder.toString();
                                        n.g(((String) (obj)));
                                    }
                                }
                            }
                        } else
                        if (((String) (obj)).startsWith("DAC"))
                        {
                            n.f(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DCT"))
                        {
                            n.f(((String) (obj)).substring(3).replaceAll(",", " "));
                        } else
                        if (((String) (obj)).startsWith("DCS") || ((String) (obj)).startsWith("DAB"))
                        {
                            n.g(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DAD"))
                        {
                            n.h(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DBC"))
                        {
                            obj = ((String) (obj)).substring(3);
                            if ("M".equals(obj) || "1".equals(obj))
                            {
                                n.a(NVGender.M);
                            } else
                            if ("F".equals(obj) || "2".equals(obj))
                            {
                                n.a(NVGender.F);
                            }
                        } else
                        if (((String) (obj)).startsWith("DBB"))
                        {
                            n.c(a(((String) (obj)).substring(3), true));
                        } else
                        if (((String) (obj)).startsWith("DAY"))
                        {
                            obj = ((String) (obj)).substring(3);
                            if (((String) (obj)).equals("BLK"))
                            {
                                n.a(ny.a);
                            } else
                            if (((String) (obj)).equals("BLU"))
                            {
                                n.a(ny.b);
                            } else
                            if (((String) (obj)).equals("BRO") || ((String) (obj)).equals("BR") || ((String) (obj)).equals("BRN"))
                            {
                                n.a(ny.c);
                            } else
                            if (((String) (obj)).equals("GRY"))
                            {
                                n.a(ny.d);
                            } else
                            if (((String) (obj)).equals("GRN"))
                            {
                                n.a(ny.e);
                            } else
                            if (((String) (obj)).equals("HAZ") || ((String) (obj)).equals("HZL"))
                            {
                                n.a(ny.f);
                            } else
                            if (((String) (obj)).equals("MAR"))
                            {
                                n.a(ny.g);
                            } else
                            if (((String) (obj)).equals("PNK"))
                            {
                                n.a(ny.h);
                            } else
                            if (((String) (obj)).equals("DIC"))
                            {
                                n.a(ny.i);
                            } else
                            if (((String) (obj)).equals("UNK"))
                            {
                                n.a(ny.j);
                            }
                        } else
                        if (((String) (obj)).startsWith("DAU"))
                        {
                            n.i(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DAG") || ((String) (obj)).startsWith("DAL"))
                        {
                            n.j(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DAH") || ((String) (obj)).startsWith("DAM"))
                        {
                            n.k(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DAI") || ((String) (obj)).startsWith("DAN"))
                        {
                            n.l(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DAJ") || ((String) (obj)).startsWith("DAO"))
                        {
                            n.m(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DAK") || ((String) (obj)).startsWith("DAP"))
                        {
                            n.n(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DAQ"))
                        {
                            n.a(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DCG"))
                        {
                            n.b(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DBD"))
                        {
                            n.a(a(((String) (obj)).substring(3), true));
                        } else
                        if (((String) (obj)).startsWith("DBA"))
                        {
                            n.b(a(((String) (obj)).substring(3), false));
                        } else
                        if (((String) (obj)).startsWith("DCA"))
                        {
                            n.c(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DCB"))
                        {
                            n.d(((String) (obj)).substring(3));
                        } else
                        if (((String) (obj)).startsWith("DCD"))
                        {
                            n.e(((String) (obj)).substring(3));
                        } else
                        {
                            n.a(((String) (obj)), "\n");
                        }
                        m = i1 + 1;
                        i1 = c();
                        continue label0;
                    }
                    j1++;
                } while (true);
            }
            return;
        } while (true);
    }

    private nz e()
    {
        int i1;
        int j1;
        int k1;
        boolean flag = true;
        String as[];
        Object obj;
        Date date;
        GregorianCalendar gregoriancalendar;
        int l1;
        try
        {
            n = new nz();
            m = 0;
            if (h.startsWith("%"))
            {
                m = m + 1;
            }
            n.m(h.substring(m, m + 2));
            m = m + 2;
            k1 = h.indexOf("^", m) - m;
        }
        catch (Exception exception)
        {
            throw new nx(exception, "Incompatible magstripe structure");
        }
        if (k1 < 13)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
          goto _L1
_L5:
        n.l(h.substring(m, m + k1));
        l1 = m;
        if (j1 != 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        m = j1 + k1 + l1;
        k1 = h.indexOf("^", m) - m;
        if (k1 < m + 35)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
          goto _L2
_L6:
        as = h.substring(m, m + i1).split("\\$");
        n.g(as[0].replaceAll("(\\w*).*", "$1"));
        if (as.length > 1)
        {
            n.f(as[1]);
        }
        l1 = m;
        if (j1 != 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        m = j1 + i1 + l1;
        i1 = h.indexOf("^", m) - m;
        if (i1 > m + 29 + k1)
        {
            i1 = k1 + 29;
            j1 = 0;
        } else
        {
            j1 = 1;
        }
        as = h.substring(m, m + i1).split("\\$");
        n.j(as[0]);
        if (as.length > 1)
        {
            n.k(as[1]);
        }
        k1 = m;
        if (j1 != 0)
        {
            j1 = ((flag) ? 1 : 0);
        } else
        {
            j1 = 0;
        }
        m = j1 + i1 + k1;
        if (h.startsWith("^", m))
        {
            m = m + 1;
        }
        if (h.startsWith(";", m))
        {
            m = m + 1;
        }
        k = h.substring(m, m + 6);
        m = m + 6;
        i1 = h.indexOf("=", m) - m;
        n.a(h.substring(m, m + i1));
        m = i1 + 1 + m;
        g.applyPattern("yyMM");
        obj = g.parse(h.substring(m, m + 4));
        m = m + 4;
        g.applyPattern("yyyyMMdd");
        date = g.parse(h.substring(m, m + 8));
        n.c(date);
        m = m + 8;
        gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTime(date);
        i1 = gregoriancalendar.get(5);
        gregoriancalendar.setTime(((Date) (obj)));
        gregoriancalendar.set(5, i1);
        obj = gregoriancalendar.getTime();
        n.b(((Date) (obj)));
        if (h.indexOf("%", m) != -1)
        {
            m = h.indexOf("%", m) + 1;
        }
        m = m + 1;
        m = m + 1;
        n.n(h.substring(m, m + 11));
        m = m + 11;
        m = m + 2;
        m = m + 10;
        m = m + 4;
        obj = h.substring(m, m + 1);
        if (!"1".equals(obj) && !"M".equals(obj)) goto _L4; else goto _L3
_L3:
        n.a(NVGender.M);
_L8:
        return n;
_L10:
        k1 = 13;
        i1 = 0;
          goto _L5
_L12:
        k1 = i1;
        i1 = 35;
          goto _L6
_L4:
        if (!"2".equals(obj) && !"F".equals(obj)) goto _L8; else goto _L7
_L7:
        n.a(NVGender.F);
          goto _L8
_L1:
        if (j1 == 0) goto _L10; else goto _L9
_L9:
        i1 = (13 - k1) + 0;
          goto _L5
_L2:
        if (j1 == 0) goto _L12; else goto _L11
_L11:
        int i2 = i1 + (35 - k1);
        i1 = k1;
        k1 = i2;
          goto _L6
    }

    public nz a(String s)
    {
        if (s == null)
        {
            throw new nx("Empty data");
        }
        h = s;
        if (s.substring(m, m + 1).equals("@"))
        {
            m = m + 1;
            a();
            b();
            d();
        } else
        {
            e();
        }
        return n;
    }
}
