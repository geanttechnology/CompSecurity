// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.b;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.helpshift.g;
import com.helpshift.i.o;
import com.helpshift.i.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b extends ArrayAdapter
{
    private static class a
    {

        public TextView a;

        private a()
        {
        }

    }


    private List a;
    private LayoutInflater b;
    private Context c;

    public b(Context context, int i, List list)
    {
        super(context, i, list);
        a = list;
        b = (LayoutInflater)context.getSystemService("layout_inflater");
        c = context;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        g g1;
        Object obj;
        String s3;
        if (view == null)
        {
            view = b.inflate(com.helpshift.d.f, null);
            viewgroup = new a();
            viewgroup.a = (TextView)view.findViewById(0x1020014);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (a)view.getTag();
        }
        g1 = (g)a.get(i);
        obj = g1.j();
        s3 = g1.e();
        if (obj != null && ((ArrayList) (obj)).size() > 0)
        {
            int k = w.a(c, com.helpshift.a.s);
            SpannableString spannablestring = new SpannableString(s3);
            if (s3.equals(o.a(s3)))
            {
                String s = s3.toLowerCase();
                obj = ((ArrayList) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    String s2 = (String)((Iterator) (obj)).next();
                    if (s2.length() >= 3)
                    {
                        i = TextUtils.indexOf(s, s2, 0);
                        while (i >= 0) 
                        {
                            spannablestring.setSpan(new BackgroundColorSpan(k), i, s2.length() + i, 33);
                            i = TextUtils.indexOf(s, s2, i + s2.length());
                        }
                    }
                } while (true);
            } else
            {
                int l = s3.length();
                String s1 = "";
                ArrayList arraylist = new ArrayList();
                for (i = 0; i < l; i++)
                {
                    char c1 = s3.charAt(i);
                    String s4 = o.a((new StringBuilder()).append(c1).append("").toString());
                    for (int j = 0; j < s4.length(); j++)
                    {
                        s1 = (new StringBuilder()).append(s1).append(s4.charAt(j)).toString();
                        arraylist.add(Integer.valueOf(i));
                    }

                }

                s1 = s1.toLowerCase();
                obj = ((ArrayList) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    s3 = ((String)((Iterator) (obj)).next()).toLowerCase();
                    if (s3.length() >= 3)
                    {
                        i = TextUtils.indexOf(s1, s3, 0);
                        while (i >= 0) 
                        {
                            spannablestring.setSpan(new BackgroundColorSpan(k), ((Integer)arraylist.get(i)).intValue(), ((Integer)arraylist.get((s3.length() + i) - 1)).intValue() + 1, 33);
                            i = TextUtils.indexOf(s1, s3, s3.length() + i);
                        }
                    }
                } while (true);
            }
            ((a) (viewgroup)).a.setText(spannablestring);
            return view;
        } else
        {
            ((a) (viewgroup)).a.setText(s3);
            return view;
        }
    }
}
