// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.cyberlink.you.l;
import com.cyberlink.you.n;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.widgetpool.clhorizontalgridview.e;
import java.util.List;

// Referenced classes of package com.cyberlink.you.sticker:
//            b, EmojiHelper, StickerFragment

class a extends ArrayAdapter
{

    final StickerFragment a;
    private int b;

    public a(StickerFragment stickerfragment, Context context, int i, List list)
    {
        a = stickerfragment;
        super(context, i, list);
        b = 0;
    }

    public void a(int i)
    {
        b = i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        EmojiHelper.EmojiCategory emojicategory;
        if (view == null)
        {
            view = new RelativeLayout(getContext());
            View view1 = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(p.u_view_item_emoji_category, viewgroup, false);
            viewgroup = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            viewgroup.addRule(13, -1);
            view1.setLayoutParams(viewgroup);
            viewgroup = new b(this, null);
            viewgroup.a = (ImageView)view1.findViewById(o.emoji_category_image);
            viewgroup.b = (RelativeLayout)view1.findViewById(o.emoji_category_background);
            view.addView(view1);
            view.setLayoutParams(new e(-1, -1));
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (b)view.getTag();
        }
        emojicategory = (EmojiHelper.EmojiCategory)getItem(i);
        ((b) (viewgroup)).a.setImageBitmap(EmojiHelper.a(getContext(), emojicategory));
        if (b == i)
        {
            ((b) (viewgroup)).b.setBackgroundResource(n.u_bg_emoji_category_selected);
            return view;
        } else
        {
            ((b) (viewgroup)).b.setBackgroundColor(a.getActivity().getResources().getColor(l.you_color_hint));
            return view;
        }
    }
}
