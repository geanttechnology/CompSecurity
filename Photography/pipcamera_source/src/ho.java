// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.fotoable.fotoproedit.activity.font.FontOnlineInfo;
import com.fotoable.fotoproedit.activity.font.FontTBgGridView;
import java.util.ArrayList;

public class ho extends BaseAdapter
{

    final FontTBgGridView a;
    private ArrayList b;

    public ho(FontTBgGridView fonttbggridview)
    {
        a = fonttbggridview;
        super();
        b = new ArrayList();
    }

    public ArrayList a()
    {
        return b;
    }

    public void a(ArrayList arraylist)
    {
        b.clear();
        b.addAll(arraylist);
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return b.size();
    }

    public Object getItem(int i)
    {
        return b.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = (FontOnlineInfo)b.get(i);
        if (view == null)
        {
            view = LayoutInflater.from(a.getContext()).inflate(0x7f0300d8, null);
            viewgroup = new hm(a, null);
            viewgroup.b = (ImageView)view.findViewById(0x7f0c034a);
            viewgroup.c = (ImageView)view.findViewById(0x7f0c0348);
            viewgroup.a = (ImageView)view.findViewById(0x7f0c0349);
            view.setTag(viewgroup);
            i = (a.getResources().getDisplayMetrics().widthPixels - ew.a(a.getContext(), 24F)) / 3;
            view.setLayoutParams(new android.widget.AbsListView.LayoutParams(i, (i * 56) / 100));
        } else
        {
            viewgroup = (hm)view.getTag();
        }
        ((hm) (viewgroup)).b.setVisibility(4);
        if (FontTBgGridView.access$300(a) != null)
        {
            ((hm) (viewgroup)).a.setVisibility(0);
            FontTBgGridView.access$300(a).a(obj, ((hm) (viewgroup)).c);
            return view;
        } else
        {
            ((hm) (viewgroup)).a.setVisibility(4);
            obj = ((FontOnlineInfo) (obj)).getIconImage();
            ((hm) (viewgroup)).c.setImageBitmap(((android.graphics.Bitmap) (obj)));
            return view;
        }
    }
}
