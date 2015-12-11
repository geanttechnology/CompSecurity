// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.places.a;
import com.google.android.gms.location.places.b;
import com.google.android.gms.location.places.k;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.support.v7:
//            aqo

public class hv extends BaseAdapter
    implements Filterable
{
    public class a
    {

        final hv a;
        private final String b;
        private final String c;

        public String a()
        {
            return b;
        }

        public String b()
        {
            return c;
        }

        public a(String s, String s1)
        {
            a = hv.this;
            super();
            c = s;
            b = s1;
        }
    }

    private class b
    {

        final TextView a;
        final hv b;

        public b(View view)
        {
            b = hv.this;
            super();
            a = (TextView)view.findViewById(0x7f1000ec);
        }
    }


    private ArrayList a;
    private final c b;
    private final LatLngBounds c;
    private LayoutInflater d;

    public hv(Context context, c c1, LatLng latlng)
    {
        b = c1;
        c = LatLngBounds.b().a(latlng).a();
        d = LayoutInflater.from(context);
    }

    static ArrayList a(hv hv1)
    {
        return hv1.a;
    }

    static ArrayList a(hv hv1, String s)
    {
        return hv1.a(s);
    }

    static ArrayList a(hv hv1, ArrayList arraylist)
    {
        hv1.a = arraylist;
        return arraylist;
    }

    private ArrayList a(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (s != null && s.length() > 2 && b.d())
        {
            android.support.v7.aqo.a((new StringBuilder()).append("Starting autocomplete query for: ").append(s).toString(), new Object[0]);
            s = (com.google.android.gms.location.places.b)k.e.a(b, s, c, null).a(60L, TimeUnit.SECONDS);
            Status status = s.a();
            if (!status.f())
            {
                aqo.d((new StringBuilder()).append("Error getting autocomplete prediction API call: ").append(status.toString()).toString(), new Object[0]);
                s.b();
                return null;
            }
            android.support.v7.aqo.a((new StringBuilder()).append("Query completed. Received ").append(s.c()).append(" predictions.").toString(), new Object[0]);
            com.google.android.gms.location.places.a a1;
            for (Iterator iterator = s.iterator(); iterator.hasNext(); arraylist.add(new a(a1.b(), a1.a())))
            {
                a1 = (com.google.android.gms.location.places.a)iterator.next();
            }

            s.b();
            return arraylist;
        }
        if (!b.d())
        {
            aqo.d("Google API client is not connected for autocomplete query.", new Object[0]);
        }
        return arraylist;
    }

    public String a(int i)
    {
        return ((a)a.get(i)).b();
    }

    public String b(int i)
    {
        if (a == null)
        {
            return null;
        } else
        {
            return ((a)a.get(i)).a();
        }
    }

    public int getCount()
    {
        if (a == null)
        {
            return 0;
        } else
        {
            return a.size();
        }
    }

    public Filter getFilter()
    {
        return new Filter() {

            final hv a;

            protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
            {
                android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
                if (charsequence != null)
                {
                    android.support.v7.hv.a(a, android.support.v7.hv.a(a, charsequence.toString()));
                    filterresults.values = android.support.v7.hv.a(a);
                    int i;
                    if (android.support.v7.hv.a(a) == null)
                    {
                        i = 0;
                    } else
                    {
                        i = android.support.v7.hv.a(a).size();
                    }
                    filterresults.count = i;
                }
                return filterresults;
            }

            protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
            {
                a.notifyDataSetChanged();
            }

            
            {
                a = hv.this;
                super();
            }
        };
    }

    public Object getItem(int i)
    {
        return b(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = d.inflate(0x7f040043, viewgroup, false);
            viewgroup = new b(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (b)view.getTag();
        }
        ((b) (viewgroup)).a.setText(b(i));
        return view;
    }
}
