// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.fotoable.fotoproedit.activity.font.FontItemView;
import com.fotoable.fotoproedit.activity.font.FontTFontView;
import java.util.ArrayList;

public class hp extends BaseAdapter
{

    final FontTFontView a;
    private ArrayList b;
    private int c;

    private hp(FontTFontView fonttfontview)
    {
        a = fonttfontview;
        super();
        b = new ArrayList();
        c = 0;
    }

    public hp(FontTFontView fonttfontview, com.fotoable.fotoproedit.activity.font.FontTFontView._cls1 _pcls1)
    {
        this(fonttfontview);
    }

    public void a()
    {
        notifyDataSetChanged();
    }

    public void a(int i)
    {
        c = i;
        notifyDataSetChanged();
    }

    public void a(ArrayList arraylist, ArrayList arraylist1)
    {
        b = arraylist1;
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return b.size();
    }

    public Object getItem(int i)
    {
        if (b.size() == 0)
        {
            return null;
        } else
        {
            return b.get(i);
        }
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        hb hb1 = (hb)b.get(i);
        viewgroup = (FontItemView)view;
        if (view == null)
        {
            viewgroup = new FontItemView(a.getContext(), null);
        }
        viewgroup.setTextWithFont(hb1);
        if (c == i)
        {
            viewgroup.setIsselected(true);
            Log.e("TProEditTextFontListView", (new StringBuilder()).append("selected fontName:").append(hb1.f).toString());
            return viewgroup;
        } else
        {
            viewgroup.setIsselected(false);
            return viewgroup;
        }
    }
}
