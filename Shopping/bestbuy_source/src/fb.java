// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import com.bestbuy.android.api.lib.models.pdpreviews.ReviewResults;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class fb extends ArrayAdapter
{

    private ArrayList a;
    private LayoutInflater b;
    private int c;
    private Activity d;

    public fb(Activity activity, int i, ArrayList arraylist)
    {
        super(activity, i, arraylist);
        d = activity;
        a = arraylist;
        b = activity.getLayoutInflater();
    }

    static int a(fb fb1)
    {
        return fb1.c;
    }

    static int a(fb fb1, int i)
    {
        fb1.c = i;
        return i;
    }

    public int a(ReviewResults reviewresults)
    {
        return a.indexOf(reviewresults);
    }

    public int getCount()
    {
        return a.size();
    }

    public int getPosition(Object obj)
    {
        return a((ReviewResults)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        String s;
        if (view == null)
        {
            fc fc1 = new fc();
            view = b.inflate(0x7f0300d8, viewgroup, false);
            fc1.a = (BBYTextView)view.findViewById(0x7f0c0354);
            fc1.b = (BBYTextView)view.findViewById(0x7f0c0359);
            fc1.e = (BBYTextView)view.findViewById(0x7f0c0355);
            fc1.f = (BBYTextView)view.findViewById(0x7f0c0356);
            fc1.g = (BBYTextView)view.findViewById(0x7f0c0357);
            fc1.c = (RatingBar)view.findViewById(0x7f0c0358);
            fc1.d = (BBYTextView)view.findViewById(0x7f0c02b8);
            fc1.h = (BBYTextView)view.findViewById(0x7f0c035a);
            fc1.i = (BBYTextView)view.findViewById(0x7f0c035b);
            view.setTag(fc1);
            viewgroup = fc1;
        } else
        {
            viewgroup = (fc)view.getTag();
        }
        ((fc) (viewgroup)).a.setText(Html.fromHtml(((ReviewResults)a.get(i)).getTitle()));
        s = ((ReviewResults)a.get(i)).getUserNickname();
        if (s != null && !s.isEmpty() && !s.equalsIgnoreCase(d.getString(0x7f080068)))
        {
            ((fc) (viewgroup)).e.setVisibility(0);
            ((fc) (viewgroup)).e.setText((new StringBuilder()).append("by ").append(((ReviewResults)a.get(i)).getUserNickname()).toString());
        } else
        {
            ((fc) (viewgroup)).e.setVisibility(8);
        }
        s = ((ReviewResults)a.get(i)).getUserLocation();
        if (s != null && s.length() > 0 && !s.equals(d.getString(0x7f080068)))
        {
            ((fc) (viewgroup)).f.setText((new StringBuilder()).append("from ").append(s).toString());
            ((fc) (viewgroup)).f.setVisibility(0);
        } else
        {
            ((fc) (viewgroup)).f.setVisibility(8);
        }
        s = ((ReviewResults)a.get(i)).getSubmissionTime();
        ((fc) (viewgroup)).g.setText((new StringBuilder()).append("on ").append(s.substring(5, 7)).append("/").append(s.substring(8, 10)).append("/").append(s.substring(0, 4)).toString());
        ((fc) (viewgroup)).c.setRating(((ReviewResults)a.get(i)).getRating());
        ((fc) (viewgroup)).d.setText((new StringBuilder()).append("").append(((ReviewResults)a.get(i)).getRating()).toString());
        ((fc) (viewgroup)).b.setText(Html.fromHtml(((ReviewResults)a.get(i)).getReviewText()));
        ((fc) (viewgroup)).b.post(new Runnable(viewgroup) {

            final fc a;
            final fb b;

            public void run()
            {
                fb.a(b, a.b.getLineCount());
                if (fb.a(b) <= 5)
                {
                    a.h.setVisibility(8);
                    a.i.setVisibility(8);
                    return;
                }
                if (a.i.getVisibility() == 0)
                {
                    a.h.setVisibility(8);
                    return;
                } else
                {
                    a.h.setVisibility(0);
                    return;
                }
            }

            
            {
                b = fb.this;
                a = fc1;
                super();
            }
        });
        ((fc) (viewgroup)).h.setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

            final fc a;
            final fb b;

            public void onClick(View view1)
            {
                a.b.setMaxLines(0x7fffffff);
                a.i.setVisibility(0);
                a.h.setVisibility(8);
                a.i.setOnClickListener(new android.view.View.OnClickListener(this) {

                    final _cls2 a;

                    public void onClick(View view)
                    {
                        a.a.i.setVisibility(8);
                        a.a.h.setVisibility(0);
                        a.a.b.setMaxLines(5);
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
            }

            
            {
                b = fb.this;
                a = fc1;
                super();
            }
        });
        return view;
    }
}
