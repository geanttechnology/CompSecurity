// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Hashtable;

// Referenced classes of package com.socialin.android.photo.textart:
//            b, TextArtView, TextArt, TextArtStyle

public final class c extends BaseAdapter
{

    private ArrayList a;
    private Hashtable b;
    private b c;

    public c(b b1, Context context, ArrayList arraylist, Hashtable hashtable)
    {
        c = b1;
        super();
        a = null;
        b = null;
        com.socialin.android.photo.textart.b.a(b1, (LayoutInflater)context.getSystemService("layout_inflater"));
        a = arraylist;
        b = hashtable;
    }

    public final int getCount()
    {
        return a.size();
    }

    public final Object getItem(int i)
    {
        return a.get(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        Hashtable hashtable;
        TextArtStyle textartstyle;
        if (view == null)
        {
            viewgroup = com.socialin.android.photo.textart.b.r(c).inflate(0x7f030255, viewgroup, false);
        } else
        {
            viewgroup = view;
        }
        view = (TextArtView)viewgroup;
        if (i < b.size() && b.get(Integer.valueOf(i)) != null)
        {
            view.setTextArtObj((TextArt)b.get(Integer.valueOf(i)));
            return viewgroup;
        }
        hashtable = b;
        textartstyle = (TextArtStyle)a.get(i);
        if (textartstyle == null)
        {
            view = null;
        } else
        if (textartstyle.equals(((TextArtView) (view)).c) && "ABC".equals(((TextArtView) (view)).b))
        {
            view = ((TextArtView) (view)).a;
        } else
        {
            view.c = textartstyle;
            view.b = "ABC";
            view.a = new TextArt(view.getContext(), textartstyle, "ABC", view, 0, 0, false);
            view.invalidate();
            view = ((TextArtView) (view)).a;
        }
        hashtable.put(Integer.valueOf(i), view);
        return viewgroup;
    }
}
