// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package jumiomobile:
//            bg

public class c extends ArrayAdapter
{

    protected int a;
    protected Context b;
    protected LayoutInflater c;
    private String d;
    private String e;
    private boolean f;

    public c(Context context, ArrayList arraylist, String s, boolean flag, String s1)
    {
        int i = 1;
        super(context, 0x1090008, arraylist);
        a = 1;
        b = context;
        c = LayoutInflater.from(context);
        d = s;
        e = s1;
        f = flag;
        if (!flag)
        {
            i = 0;
        }
        a = i;
    }

    public String a(int i)
    {
        if (i == 0 && f)
        {
            return null;
        } else
        {
            return (String)super.getItem(i - a);
        }
    }

    public int getCount()
    {
        return super.getCount() + a;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null || !(view instanceof TextView))
        {
            view = c.inflate(0x1090009, viewgroup, false);
            ((TextView)view).setTextSize(2, 18F);
            ((TextView)view).setTextColor(0xff444444);
        }
        if (i == 0 && f)
        {
            ((TextView)view).setText(e);
            return view;
        } else
        {
            ((TextView)view).setText(a(i));
            return view;
        }
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        if (i == 0 && f)
        {
            return 0L;
        } else
        {
            return super.getItemId(i - a);
        }
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            int j = bg.a(b, 1);
            int k = bg.a(b, 23);
            view = (TextView)c.inflate(0x1090008, viewgroup, false);
            ((TextView)view).setGravity(5);
            ((TextView)view).setTextSize(2, 20F);
            ((TextView)view).setPadding(j, j, k, j);
        }
        if (i == 0 && f)
        {
            ((TextView)view).setText(d);
            ((TextView)view).setTextColor(0xff969696);
            return view;
        } else
        {
            ((TextView)view).setText(a(i));
            ((TextView)view).setTextColor(0xff444444);
            return view;
        }
    }
}
