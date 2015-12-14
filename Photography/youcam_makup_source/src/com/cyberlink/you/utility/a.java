// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Patterns;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.cyberlink.you.utility:
//            c, j, b

public class a
{

    public static final b a = new b() {

        public final boolean a(CharSequence charsequence, int i, int k)
        {
            if (charsequence.subSequence(i, k).toString().matches("[\\x00-\\x7F]+"))
            {
                if (i == 0)
                {
                    return true;
                }
                if (charsequence.charAt(i - 1) != '@')
                {
                    return true;
                }
            }
            return false;
        }

    };
    public static final c b = new c() {

        public final String a(Matcher matcher, String s)
        {
            return Patterns.digitsAndPlusOnly(matcher);
        }

    };

    private static final String a(String s, String as[], Matcher matcher, c c1)
    {
        boolean flag1 = true;
        int i;
        boolean flag;
        if (c1 != null)
        {
            matcher = c1.a(matcher, s);
        } else
        {
            matcher = s;
        }
        i = 0;
        if (i >= as.length)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (!matcher.regionMatches(true, 0, as[i], 0, as[i].length())) goto _L2; else goto _L1
_L1:
        s = matcher;
        flag = flag1;
        if (!matcher.regionMatches(false, 0, as[i], 0, as[i].length()))
        {
            s = (new StringBuilder()).append(as[i]).append(matcher.substring(as[i].length())).toString();
            flag = flag1;
        }
_L4:
        matcher = s;
        if (!flag)
        {
            matcher = (new StringBuilder()).append(as[0]).append(s).toString();
        }
        return matcher;
_L2:
        i++;
        break MISSING_BLOCK_LABEL_19;
        flag = false;
        s = matcher;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static final void a(TextView textview)
    {
        android.text.method.MovementMethod movementmethod = textview.getMovementMethod();
        if ((movementmethod == null || !(movementmethod instanceof LinkMovementMethod)) && textview.getLinksClickable())
        {
            textview.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private static final void a(String s, int i, int k, Spannable spannable)
    {
        spannable.setSpan(new URLSpan(s), i, k, 33);
    }

    private static final void a(ArrayList arraylist)
    {
        Collections.sort(arraylist, new Comparator() {

            public final int a(j j3, j j4)
            {
                if (j3.b >= j4.b)
                {
                    if (j3.b > j4.b)
                    {
                        return 1;
                    }
                    if (j3.c < j4.c)
                    {
                        return 1;
                    }
                    if (j3.c <= j4.c)
                    {
                        return 0;
                    }
                }
                return -1;
            }

            public int compare(Object obj, Object obj1)
            {
                return a((j)obj, (j)obj1);
            }

            public final boolean equals(Object obj)
            {
                return false;
            }

        });
        int l = arraylist.size();
        int k = 0;
        do
        {
            if (k >= l - 1)
            {
                break;
            }
            j j1 = (j)arraylist.get(k);
            j j2 = (j)arraylist.get(k + 1);
            if (j1.b <= j2.b && j1.c > j2.b)
            {
                int i;
                if (j2.c <= j1.c)
                {
                    i = k + 1;
                } else
                if (j1.c - j1.b > j2.c - j2.b)
                {
                    i = k + 1;
                } else
                if (j1.c - j1.b < j2.c - j2.b)
                {
                    i = k;
                } else
                {
                    i = -1;
                }
                if (i != -1)
                {
                    arraylist.remove(i);
                    l--;
                    continue;
                }
            }
            k++;
        } while (true);
    }

    private static final void a(ArrayList arraylist, Spannable spannable, Pattern pattern, String as[], b b1, c c1)
    {
        pattern = pattern.matcher(spannable);
        do
        {
            if (!pattern.find())
            {
                break;
            }
            int i = pattern.start();
            int k = pattern.end();
            if (b1 == null || b1.a(spannable, i, k))
            {
                j j1 = new j();
                j1.a = a(pattern.group(0), as, ((Matcher) (pattern)), c1);
                j1.b = i;
                j1.c = k;
                arraylist.add(j1);
            }
        } while (true);
    }

    public static final boolean a(Spannable spannable, int i)
    {
        if (i == 0)
        {
            return false;
        }
        URLSpan aurlspan[] = (URLSpan[])spannable.getSpans(0, spannable.length(), android/text/style/URLSpan);
        for (int k = aurlspan.length - 1; k >= 0; k--)
        {
            spannable.removeSpan(aurlspan[k]);
        }

        Object obj = new ArrayList();
        if ((i & 1) != 0)
        {
            Pattern pattern = Patterns.WEB_URL;
            b b1 = a;
            a(((ArrayList) (obj)), spannable, pattern, new String[] {
                "http://", "https://", "rtsp://"
            }, b1, null);
        }
        a(((ArrayList) (obj)));
        if (((ArrayList) (obj)).size() == 0)
        {
            return false;
        }
        j j1;
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a(j1.a, j1.b, j1.c, spannable))
        {
            j1 = (j)((Iterator) (obj)).next();
        }

        return true;
    }

    public static final boolean a(Spannable spannable, Pattern pattern, String s, b b1, c c1)
    {
        boolean flag;
        if (s == null)
        {
            s = "";
        } else
        {
            s = s.toLowerCase(Locale.ROOT);
        }
        pattern = pattern.matcher(spannable);
        flag = false;
        do
        {
            if (!pattern.find())
            {
                break;
            }
            int i = pattern.start();
            int k = pattern.end();
            boolean flag1;
            if (b1 != null)
            {
                flag1 = b1.a(spannable, i, k);
            } else
            {
                flag1 = true;
            }
            if (flag1)
            {
                a(a(pattern.group(0), new String[] {
                    s
                }, ((Matcher) (pattern)), c1), i, k, spannable);
                flag = true;
            }
        } while (true);
        return flag;
    }

    public static final boolean a(TextView textview, int i)
    {
        if (i == 0)
        {
            return false;
        }
        Object obj = textview.getText();
        if (obj instanceof Spannable)
        {
            if (a((Spannable)obj, i))
            {
                a(textview);
                return true;
            } else
            {
                return false;
            }
        }
        obj = SpannableString.valueOf(((CharSequence) (obj)));
        if (a(((Spannable) (obj)), i))
        {
            a(textview);
            textview.setText(((CharSequence) (obj)));
            return true;
        } else
        {
            return false;
        }
    }

    public static final boolean a(TextView textview, Pattern pattern, String s, b b1, c c1)
    {
        SpannableString spannablestring = SpannableString.valueOf(textview.getText());
        if (a(((Spannable) (spannablestring)), pattern, s, b1, c1))
        {
            textview.setText(spannablestring);
            a(textview);
            return true;
        } else
        {
            return false;
        }
    }

}
