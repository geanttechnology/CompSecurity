// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapEditItem;
import java.util.ArrayList;
import java.util.Iterator;

public class qn extends BaseAdapter
{

    protected Context a;
    public boolean b;
    private final String c = "CacheImageKey";
    private Point d;
    private ArrayList e;
    private qr f;

    public qn(Context context, ArrayList arraylist, qr qr)
    {
        e = new ArrayList();
        b = false;
        e.addAll(arraylist);
        f = qr;
        a = context;
        int i = a.getResources().getDisplayMetrics().widthPixels / 2 - 5;
        d = new Point(i, i);
    }

    static ArrayList a(qn qn1)
    {
        return qn1.e;
    }

    static qr b(qn qn1)
    {
        return qn1.f;
    }

    public ArrayList a()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            contiCapEditItem conticapedititem = (contiCapEditItem)iterator.next();
            if (conticapedititem.isChecked)
            {
                arraylist.add(conticapedititem);
            }
        } while (true);
        return arraylist;
    }

    public void a(ArrayList arraylist)
    {
        e.clear();
        e.addAll(arraylist);
    }

    public void b()
    {
        for (int i = 0; i < e.size(); i++)
        {
            ((contiCapEditItem)e.get(i)).isChecked = false;
        }

    }

    public void c()
    {
        pn.a().b();
    }

    public int getCount()
    {
        return e.size();
    }

    public Object getItem(int i)
    {
        return e.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (e == null || e.size() == 0)
        {
            return view;
        }
        String s = ((contiCapEditItem)e.get(i)).urlStr;
        Object obj;
        if (view == null)
        {
            view = LayoutInflater.from(a).inflate(0x7f0300ae, null);
            viewgroup = new qs(this, null);
            viewgroup.a = (ImageView)view.findViewById(0x7f0d02dc);
            viewgroup.b = (CheckBox)view.findViewById(0x7f0d02dd);
            viewgroup.c = (FrameLayout)view.findViewById(0x7f0d02de);
            viewgroup.d = (FrameLayout)view.findViewById(0x7f0d00d2);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (qs)view.getTag();
        }
        ((qs) (viewgroup)).b.setOnCheckedChangeListener(new qo(this, i));
        ((qs) (viewgroup)).b.setChecked(((contiCapEditItem)e.get(i)).isChecked);
        ((qs) (viewgroup)).a.setOnClickListener(new qp(this, i));
        obj = new android.widget.FrameLayout.LayoutParams(d.x, d.y);
        obj.width = d.x;
        obj.height = d.y;
        ((qs) (viewgroup)).d.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        if (((contiCapEditItem)e.get(i)).hasBeautyed)
        {
            ((qs) (viewgroup)).c.setVisibility(8);
        } else
        {
            ((qs) (viewgroup)).c.setVisibility(0);
        }
        obj = (new StringBuilder()).append("CacheImageKey").append(i).toString();
        s = Uri.parse(s).getPath();
        pn.a().a(a, ((String) (obj)), s, ((qs) (viewgroup)).a, new aqe(d.x / 2, d.y / 2), new qq(this));
        return view;
    }
}
