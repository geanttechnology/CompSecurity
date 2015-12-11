// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import com.bestbuy.android.bbyobjects.BBYTextAppearnceSpan;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.bestbuy.android.bbyobjects.BBYTypefaceSpan;

public class lt
{

    private static int a = -1;

    public static void a(Context context, TextView textview, String s)
    {
        context = lo.a(context, 0x7f080022, context.getResources());
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        spannablestringbuilder.setSpan(new BBYTypefaceSpan("", context), 0, s.length(), 34);
        textview.setText(spannablestringbuilder);
    }

    public static void a(Context context, TextView textview, String s, int i)
    {
        a(context, textview, s, i, -1);
    }

    public static void a(Context context, TextView textview, String s, int i, int j)
    {
        boolean flag = false;
        a = j;
        String s1 = s;
        if (s.contains("\\u00BB"))
        {
            s1 = ns.a(s);
        }
        int k;
        if (s1.contains("<span class='bold'>") && s1.contains("AND") && (s1.contains("\n") || s1.contains("\\n")))
        {
            k = 600;
            s = s1;
            j = ((flag) ? 1 : 0);
        } else
        if (s1.contains("<span class='bold'>"))
        {
            if (i == 500)
            {
                s = s1.replace("<span class='bold'>", "").replace("</span>", "");
                j = ((flag) ? 1 : 0);
                k = i;
            } else
            if (i == 300)
            {
                s = s1.replace("<span class='bold'>", "").replace("</span>", "|");
                j = s.indexOf("|");
                k = i;
            } else
            {
                j = s1.indexOf("<span class='bold'>");
                k = 300;
                s = s1;
            }
        } else
        {
            j = ((flag) ? 1 : 0);
            s = s1;
            k = i;
            if (s1.contains("italic"))
            {
                s = s1.replace("<span class='italic'>", "").replace("</span>", "");
                j = ((flag) ? 1 : 0);
                k = i;
            }
        }
        switch (k)
        {
        default:
            return;

        case 200: 
            d(context, textview, s, j);
            return;

        case 100: // 'd'
            e(context, textview, s, j);
            return;

        case 300: 
            b(context, textview, s, j);
            return;

        case 400: 
            d(context, textview, s);
            return;

        case 500: 
            c(context, textview, s, j);
            return;

        case 600: 
            c(context, textview, s);
            return;

        case 700: 
            f(context, textview, s, j);
            return;

        case 800: 
            a(context, textview, s);
            return;

        case 900: 
            b(context, textview, s);
            return;

        case 1100: 
            e(context, textview, s);
            return;

        case 1000: 
            f(context, textview, s);
            return;
        }
    }

    private static void a(Context context, BBYTextView bbytextview, String s, int i)
    {
        int ai[] = new int[10];
        int ai1[] = new int[10];
        int ai2[] = new int[10];
        int ai3[] = new int[10];
        int ai4[] = new int[10];
        int ai5[] = new int[10];
        int j = 0;
        int j1 = 0;
        int i1 = 0;
        boolean flag = false;
        int k1 = 0;
        boolean flag5 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        String s1 = s;
        if (s.contains("<span class='bold'>"))
        {
            do
            {
                i1 = ((flag) ? 1 : 0);
                s1 = s;
                if (j == -1)
                {
                    break;
                }
                i1 = s.indexOf("<span class='bold'>", j);
                j = i1;
                if (i1 != -1)
                {
                    j = i1 + "<span class='bold'>".length();
                    ai[j1] = s.indexOf("<span class='bold'>");
                    s = s.replaceFirst("<span class='bold'>", "");
                    ai1[j1] = s.indexOf("</span>");
                    s = s.replaceFirst("</span>", "");
                    flag = true;
                    j1++;
                }
            } while (true);
        }
        j1 = k1;
        s = s1;
        if (s1.contains("<i>"))
        {
            k1 = 0;
            int k = 0;
            boolean flag1 = flag5;
            do
            {
                j1 = ((flag1) ? 1 : 0);
                s = s1;
                if (k == -1)
                {
                    break;
                }
                j1 = s1.indexOf("<i>", k);
                k = j1;
                if (j1 != -1)
                {
                    k = j1 + "<i>".length();
                    ai2[k1] = s1.indexOf("<i>");
                    s = s1.replaceFirst("<i>", "");
                    ai3[k1] = s.indexOf("</i>");
                    s1 = s.replaceFirst("</i>", "");
                    flag1 = true;
                    k1++;
                }
            } while (true);
        }
        k1 = ((flag3) ? 1 : 0);
        s1 = s;
        if (s.contains("<u>"))
        {
            int l1 = 0;
            int l = 0;
            boolean flag2 = flag4;
            do
            {
                k1 = ((flag2) ? 1 : 0);
                s1 = s;
                if (l == -1)
                {
                    break;
                }
                k1 = s.indexOf("<u>", l);
                l = k1;
                if (k1 != -1)
                {
                    l = k1 + "<u>".length();
                    ai4[l1] = s.indexOf("<u>");
                    s = s.replaceFirst("<u>", "");
                    ai5[l1] = s.indexOf("</u>");
                    s = s.replaceFirst("</u>", "");
                    flag2 = true;
                    l1++;
                }
            } while (true);
        }
        s = new SpannableString(s1);
        s.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, i, context.getResources())), 0, s1.length(), 33);
        if (i1 != 0)
        {
            for (i = 0; i < ai.length; i++)
            {
                s.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080021, context.getResources())), ai[i], ai1[i], 33);
            }

        }
        if (j1 != 0)
        {
            for (i = 0; i < ai2.length; i++)
            {
                s.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080023, context.getResources())), ai2[i], ai3[i], 33);
            }

        }
        if (k1 != 0)
        {
            for (i = 0; i < ai4.length; i++)
            {
                s.setSpan(new UnderlineSpan(), ai4[i], ai5[i], 33);
            }

        }
        bbytextview.setText(s, android.widget.TextView.BufferType.SPANNABLE);
    }

    public static void a(Context context, BBYTextView bbytextview, String s, int i, int j)
    {
        if (i == 1000)
        {
            a(context, bbytextview, s, j);
        }
    }

    public static void b(Context context, TextView textview, String s)
    {
        context = lo.a(context, 0x7f080023, context.getResources());
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        spannablestringbuilder.setSpan(new BBYTypefaceSpan("", context), 0, s.length(), 34);
        if (a != -1)
        {
            spannablestringbuilder.setSpan(new ForegroundColorSpan(a), 0, s.length(), 33);
        }
        textview.setText(spannablestringbuilder);
    }

    public static void b(Context context, TextView textview, String s, int i)
    {
        android.graphics.Typeface typeface = lo.a(context, 0x7f080021, context.getResources());
        context = lo.a(context, 0x7f080024, context.getResources());
        s = s.replace("|", "");
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        spannablestringbuilder.setSpan(new BBYTypefaceSpan("", typeface), 0, i, 34);
        if (a != -1)
        {
            spannablestringbuilder.setSpan(new ForegroundColorSpan(a), 0, i, 33);
        }
        spannablestringbuilder.setSpan(new BBYTypefaceSpan("", context), i, s.length(), 34);
        textview.setText(spannablestringbuilder);
    }

    private static void c(Context context, TextView textview, String s)
    {
        s = s.replace("\\n", "\n");
        int i = s.indexOf("\n");
        Object obj = s.substring(0, i);
        s = s.substring(i, s.length());
        i = ((String) (obj)).indexOf("<span class='bold'>");
        obj = ((String) (obj)).replace("<span class='bold'>", "").replace("</span>", "");
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(((CharSequence) (obj)));
        spannablestringbuilder.setSpan(new BBYTypefaceSpan("", lo.a(context, 0x7f080024, context.getResources())), 0, i, 34);
        spannablestringbuilder.setSpan(new BBYTypefaceSpan("", lo.a(context, 0x7f080021, context.getResources())), i, ((String) (obj)).length(), 33);
        textview.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
        i = s.indexOf("<span class='bold'>");
        s = s.replace("<span class='bold'>", "").replace("</span>", "");
        obj = new SpannableStringBuilder(s);
        ((SpannableStringBuilder) (obj)).setSpan(new BBYTypefaceSpan("", lo.a(context, 0x7f080024, context.getResources())), 0, i, 34);
        ((SpannableStringBuilder) (obj)).setSpan(new BBYTypefaceSpan("", lo.a(context, 0x7f080021, context.getResources())), i, s.length(), 34);
        textview.append(((CharSequence) (obj)));
    }

    public static void c(Context context, TextView textview, String s, int i)
    {
        android.graphics.Typeface typeface = lo.a(context, 0x7f080021, context.getResources());
        context = lo.a(context, 0x7f080024, context.getResources());
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        spannablestringbuilder.setSpan(new BBYTypefaceSpan("", typeface), 0, i, 34);
        spannablestringbuilder.setSpan(new BBYTypefaceSpan("", context), i, s.length(), 34);
        textview.setText(spannablestringbuilder);
    }

    private static void d(Context context, TextView textview, String s)
    {
        s = s.replace("\\n", "\n");
        int i = s.indexOf("\n");
        SpannableString spannablestring = new SpannableString(s);
        spannablestring.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080024, context.getResources())), 0, i, 33);
        spannablestring.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080021, context.getResources())), i + 1, s.length(), 33);
        textview.setText(spannablestring, android.widget.TextView.BufferType.SPANNABLE);
    }

    private static void d(Context context, TextView textview, String s, int i)
    {
        context = lo.a(context, 0x7f080021, context.getResources());
        SpannableString spannablestring = new SpannableString(s);
        spannablestring.setSpan(new StyleSpan(1), 0, s.length(), 33);
        if (a != -1)
        {
            spannablestring.setSpan(new ForegroundColorSpan(a), 0, i, 33);
        }
        textview.setText(spannablestring, android.widget.TextView.BufferType.SPANNABLE);
        textview.setTypeface(context);
    }

    private static void e(Context context, TextView textview, String s)
    {
        if (s != null)
        {
            s = new SpannableString(s);
            s.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080023, context.getResources())), 0, s.length(), 33);
            s.setSpan(new UnderlineSpan(), 0, s.length(), 0);
            textview.setText(s, android.widget.TextView.BufferType.SPANNABLE);
        }
    }

    private static void e(Context context, TextView textview, String s, int i)
    {
        context = lo.a(context, 0x7f080024, context.getResources());
        SpannableString spannablestring = new SpannableString(s);
        spannablestring.setSpan(new StyleSpan(0), 0, s.length(), 33);
        textview.setText(spannablestring, android.widget.TextView.BufferType.SPANNABLE);
        textview.setTypeface(context);
    }

    private static void f(Context context, TextView textview, String s)
    {
        if (s != null)
        {
            s = new SpannableString(s);
            s.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080022, context.getResources())), 0, s.length(), 33);
            s.setSpan(new UnderlineSpan(), 0, s.length(), 0);
            textview.setText(s, android.widget.TextView.BufferType.SPANNABLE);
        }
    }

    private static void f(Context context, TextView textview, String s, int i)
    {
        context = lo.a(context, 0x7f080024, context.getResources());
        SpannableString spannablestring = new SpannableString(s);
        spannablestring.setSpan(new UnderlineSpan(), 0, s.length(), 33);
        textview.setText(spannablestring, android.widget.TextView.BufferType.SPANNABLE);
        textview.setTypeface(context);
    }

}
