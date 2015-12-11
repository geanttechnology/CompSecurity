// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import lo;

// Referenced classes of package com.bestbuy.android.bbyobjects:
//            BBYTextAppearnceSpan

public class BBYTextView extends TextView
{

    private String a;
    private Context b;
    private String c;
    private String d;

    public BBYTextView(Context context)
    {
        super(context);
        a = "<html><head><meta http-equiv=\"content-type\" content=\"text/html;\" charset=\"UTF-8\"><style>@font-face {font-family: \"Roboto-Bold\";src: url('file:///android_asset/fonts/Roboto-Bold.ttf');}@font-face {font-family: \"Roboto-Black\";src: url('file:///android_asset/fonts/Roboto-Black.ttf');}@font-face {font-family: \"Roboto-Regular\";src: url('file:///android_asset/fonts/Roboto-Regular.ttf');}@font-face {font-family: \"Roboto-Light\";src: url('file:///android_asset/fonts/Roboto-Light.ttf');}@font-face {font-family: \"Roboto-Light-Italic\";src: url('file:///android_asset/fonts/Roboto-LightItalic.ttf');}body { font-family:\"Roboto-Regular\"} h3 { font-family:\"Roboto-Bold\"} i { font-family:\"Roboto-Light-Italic\"} u { font-family:\"Roboto-Regular\"}</style></head><body>%s</body></html>";
        b = context;
    }

    public BBYTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = "<html><head><meta http-equiv=\"content-type\" content=\"text/html;\" charset=\"UTF-8\"><style>@font-face {font-family: \"Roboto-Bold\";src: url('file:///android_asset/fonts/Roboto-Bold.ttf');}@font-face {font-family: \"Roboto-Black\";src: url('file:///android_asset/fonts/Roboto-Black.ttf');}@font-face {font-family: \"Roboto-Regular\";src: url('file:///android_asset/fonts/Roboto-Regular.ttf');}@font-face {font-family: \"Roboto-Light\";src: url('file:///android_asset/fonts/Roboto-Light.ttf');}@font-face {font-family: \"Roboto-Light-Italic\";src: url('file:///android_asset/fonts/Roboto-LightItalic.ttf');}body { font-family:\"Roboto-Regular\"} h3 { font-family:\"Roboto-Bold\"} i { font-family:\"Roboto-Light-Italic\"} u { font-family:\"Roboto-Regular\"}</style></head><body>%s</body></html>";
        b = context;
        a(context, attributeset);
    }

    public BBYTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = "<html><head><meta http-equiv=\"content-type\" content=\"text/html;\" charset=\"UTF-8\"><style>@font-face {font-family: \"Roboto-Bold\";src: url('file:///android_asset/fonts/Roboto-Bold.ttf');}@font-face {font-family: \"Roboto-Black\";src: url('file:///android_asset/fonts/Roboto-Black.ttf');}@font-face {font-family: \"Roboto-Regular\";src: url('file:///android_asset/fonts/Roboto-Regular.ttf');}@font-face {font-family: \"Roboto-Light\";src: url('file:///android_asset/fonts/Roboto-Light.ttf');}@font-face {font-family: \"Roboto-Light-Italic\";src: url('file:///android_asset/fonts/Roboto-LightItalic.ttf');}body { font-family:\"Roboto-Regular\"} h3 { font-family:\"Roboto-Bold\"} i { font-family:\"Roboto-Light-Italic\"} u { font-family:\"Roboto-Regular\"}</style></head><body>%s</body></html>";
        b = context;
        a(context, attributeset);
    }

    private int a(String s)
    {
        if (!s.contains(b.getResources().getString(0x7f080021)))
        {
            if (s.contains(b.getResources().getString(0x7f080024)))
            {
                return 0x7f080024;
            }
            if (s.contains(b.getResources().getString(0x7f080022)))
            {
                return 0x7f080022;
            }
            if (!s.contains("Roboto-Black"))
            {
                if (s.contains("Roboto-Regular"))
                {
                    return 0x7f080024;
                }
                if (s.contains("Roboto-LightItalic"))
                {
                    return 0x7f080023;
                }
                return !s.contains("Roboto-Light") ? 0 : 0x7f080022;
            }
        }
        return 0x7f080021;
    }

    private void a(Context context, AttributeSet attributeset)
    {
        context = b.obtainStyledAttributes(attributeset, com.bestbuy.android.R.styleable.BBYTextView);
        c = context.getString(0);
        d = context.getString(1);
        a(b, c, d);
        context.recycle();
    }

    private void a(Context context, BBYTextView bbytextview, String s)
    {
        if (s.equals("")) goto _L2; else goto _L1
_L1:
        if (!s.contains("<span class='bold'>")) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        j = s.indexOf("<span class='bold'>");
        s = s.replace("<span class='bold'>", "");
        i = s.indexOf("</span>");
        s = s.replace("</span>", "");
_L9:
        SpannableString spannablestring = new SpannableString(s);
        if (j != -1) goto _L6; else goto _L5
_L5:
        spannablestring.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080021, context.getResources())), 0, s.length(), 33);
_L7:
        bbytextview.setText(spannablestring, android.widget.TextView.BufferType.SPANNABLE);
        return;
_L4:
        try
        {
            s = s.replace("\\n", " ").replace("\n", " ").replace("\t", " ");
            j = s.indexOf(" ");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        i = -1;
        continue; /* Loop/switch isn't completed */
_L6:
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        s = s.trim();
        spannablestring.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080021, context.getResources())), j, i, 33);
        spannablestring.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080024, context.getResources())), i, s.length(), 33);
          goto _L7
        spannablestring.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080024, context.getResources())), 0, j, 33);
        spannablestring.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080021, context.getResources())), j, s.length(), 33);
          goto _L7
_L2:
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void b(Context context, BBYTextView bbytextview, String s)
    {
        String as[] = s.split(":");
        s = null;
        int i = 0;
        while (i < as.length) 
        {
            Object obj = as[i];
            if (((String) (obj)).contains("<span class='bold'>"))
            {
                int j = ((String) (obj)).indexOf("<span class='bold'>");
                String s1 = ((String) (obj)).replace("<span class='bold'>", "").replace("</span>", "");
                obj = new SpannableString(s1);
                s = ((String) (obj));
                if (j != -1)
                {
                    ((SpannableString) (obj)).setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080021, context.getResources())), 0, s1.length(), 33);
                    ((SpannableString) (obj)).setSpan(new ForegroundColorSpan(0xff444444), 0, s1.length(), 33);
                    s = ((String) (obj));
                }
            } else
            if (((String) (obj)).contains("</font>"))
            {
                s = ((String) (obj)).replace("</font>", "").replace("<font color=", "");
                obj = s.substring(s.indexOf("#") + 1, s.indexOf("\">"));
                String s2 = s.substring(s.indexOf(">") + 1, s.length());
                s = new SpannableString(Html.fromHtml(s2));
                int k = Integer.parseInt(((String) (obj)), 16);
                s.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080024, context.getResources())), 0, s2.length(), 33);
                s.setSpan(new ForegroundColorSpan(Color.rgb(k >> 16 & 0xff, k >> 8 & 0xff, k >> 0 & 0xff)), 0, s2.length(), 33);
            }
            if (i == 0)
            {
                bbytextview.setText(s);
            } else
            {
                bbytextview.append(s);
            }
            i++;
        }
    }

    private void c(Context context, BBYTextView bbytextview, String s)
    {
        if (!s.equals(""))
        {
            s = new SpannableString(s);
            s.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080024, context.getResources())), 0, s.length(), 33);
            s.setSpan(new StyleSpan(2), 0, s.length(), 0);
            bbytextview.setText(s, android.widget.TextView.BufferType.SPANNABLE);
        }
    }

    private void d(Context context, BBYTextView bbytextview, String s)
    {
        if (!s.equals(""))
        {
            s = new SpannableString(s);
            s.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080024, context.getResources())), 0, s.length(), 33);
            s.setSpan(new UnderlineSpan(), 0, s.length(), 0);
            bbytextview.setText(s, android.widget.TextView.BufferType.SPANNABLE);
        }
    }

    private void e(Context context, BBYTextView bbytextview, String s)
    {
        if (!s.equals(""))
        {
            s = s.replace("\\n", "\n");
            int i = s.indexOf("\n");
            SpannableString spannablestring = new SpannableString(s);
            spannablestring.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080024, context.getResources())), 0, i, 33);
            spannablestring.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080021, context.getResources())), i + 1, s.length(), 33);
            bbytextview.setText(spannablestring, android.widget.TextView.BufferType.SPANNABLE);
        }
    }

    private void f(Context context, BBYTextView bbytextview, String s)
    {
        if (!s.equals(""))
        {
            s = s.replace("\\n", "\n");
            int i = s.indexOf("\n");
            SpannableString spannablestring = new SpannableString(s);
            spannablestring.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080024, context.getResources())), 0, i, 33);
            spannablestring.setSpan(new BBYTextAppearnceSpan(context, 0, lo.a(context, 0x7f080024, context.getResources())), i + 1, s.length(), 33);
            bbytextview.setText(spannablestring, android.widget.TextView.BufferType.SPANNABLE);
        }
    }

    public boolean a(Context context, String s, String s1)
    {
        Object obj = null;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!s1.equals("NEW_LINE_STYLE")) goto _L4; else goto _L3
_L3:
        e(b, this, getText().toString());
        context = obj;
_L6:
        setTypeface(context);
        return true;
_L4:
        if (s1.equals("REGULAR_BOLD_STYLE"))
        {
            a(b, this, getText().toString());
            context = obj;
        } else
        if (s1.equals("MULTI_SPAN_STYLE"))
        {
            b(b, this, getText().toString());
            context = obj;
        } else
        if (s1.equals("NEW_LINE_STYLE_WITH_REG"))
        {
            f(b, this, getText().toString());
            context = obj;
        } else
        if (s1.equals("REGULAR_ITALIC_STYLE"))
        {
            c(b, this, getText().toString());
            context = obj;
        } else
        {
            context = obj;
            if (s1.equals("REGULAR_UNDERLINE_STYLE"))
            {
                d(b, this, getText().toString());
                context = obj;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        context = obj;
        if (s != null)
        {
            int i = a(s);
            s = lo.a(b, i, b.getResources());
            s1 = getText().toString();
            context = s;
            if (s1 != null)
            {
                context = s;
                if (s1.contains("<body>"))
                {
                    setText(Html.fromHtml(s1), android.widget.TextView.BufferType.SPANNABLE);
                    context = s;
                }
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (d != null && d.equals("NEW_LINE_STYLE") || getText() != null && getText().toString().contains("\n"))
        {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + 30);
        }
    }

    public void setText(String s)
    {
        super.setText(s);
        if (d != null && d.equals("REGULAR_BOLD_STYLE"))
        {
            a(b, this, getText().toString());
        }
    }

    public void setTextWithBoldness(String s)
    {
        if (s != null)
        {
            String as[] = s.split("<span class='bold'>");
            boolean flag;
            int i;
            int j;
            if (s.startsWith("<span class='bold'>"))
            {
                flag = false;
            } else
            {
                flag = true;
            }
            j = as.length;
            i = 0;
            while (i < j) 
            {
                s = as[i];
                boolean flag1;
                if (flag)
                {
                    append(new SpannableString(Html.fromHtml(s)));
                    flag1 = false;
                } else
                {
                    s = s.split("</span>");
                    flag1 = flag;
                    if (s.length > 0)
                    {
                        SpannableString spannablestring = new SpannableString(Html.fromHtml(s[0]));
                        spannablestring.setSpan(new BBYTextAppearnceSpan(b, 0, lo.a(b, 0x7f080021, b.getResources())), 0, spannablestring.length(), 33);
                        append(spannablestring);
                        flag1 = flag;
                        if (s.length > 1)
                        {
                            s = new SpannableString(Html.fromHtml(s[1]));
                            s.setSpan(new BBYTextAppearnceSpan(b, 0, lo.a(b, 0x7f080024, b.getResources())), 0, s.length(), 33);
                            append(s);
                            flag1 = flag;
                        }
                    }
                }
                i++;
                flag = flag1;
            }
        }
    }
}
