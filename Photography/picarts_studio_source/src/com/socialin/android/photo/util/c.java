// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.net.d;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.socialin.android.photo.util:
//            b, a

class c extends PagerAdapter
{

    final a a;
    private ArrayList b;
    private Context c;
    private String d;

    public c(a a1, Context context, ArrayList arraylist)
    {
        a = a1;
        super();
        b = new ArrayList();
        d = (new StringBuilder()).append(com/socialin/android/photo/util/c.getName()).append("_").append(System.currentTimeMillis()).toString();
        c = context;
        b = arraylist;
    }

    static void a(c c1)
    {
        try
        {
            Iterator iterator = c1.b.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                b b1 = (b)iterator.next();
                if (b1.a != null)
                {
                    com.socialin.android.util.c.a(b1.a);
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            return;
        }
        c1.b.clear();
        com.socialin.android.util.c.b(c1.d);
        return;
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        if (viewgroup == null || obj == null)
        {
            return;
        }
        if (viewgroup.getChildCount() > 0 && i < viewgroup.getChildCount())
        {
            try
            {
                viewgroup.removeView((View)obj);
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                viewgroup.printStackTrace();
            }
        }
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return b.size();
    }

    public int getItemPosition(Object obj)
    {
        return super.getItemPosition(obj);
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        View view;
        ImageView imageview;
        TextView textview;
        b b1;
        Object obj;
        View view1;
        view = LayoutInflater.from(c).inflate(0x7f030034, null);
        imageview = (ImageView)view.findViewById(0x7f10019b);
        textview = (TextView)view.findViewById(0x7f10019d);
        obj = view.findViewById(0x7f10019a);
        b1 = (b)b.get(i);
        if (obj != null)
        {
            ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener(b1, imageview) {

                private b a;
                private ImageView b;
                private c c;

                public final void onClick(View view2)
                {
                    AnalyticUtils.getInstance(view2.getContext()).trackLocalAction((new StringBuilder("start:click_bunner_")).append(a.data.imageUrl).toString());
                    com.socialin.android.photo.util.a.a(b, a.data);
                }

            
            {
                c = c.this;
                a = b1;
                b = imageview;
                super();
            }
            });
        }
        obj = a;
        view1 = view.findViewById(0x7f10019c);
        if (!((a) (obj)).a && imageview != null && b1 != null) goto _L2; else goto _L1
_L1:
        viewgroup.addView(view);
        return view;
_L2:
        if (b1.a != null && !b1.a.isRecycled())
        {
            imageview.setImageBitmap(b1.a);
            view1.setVisibility(8);
            String s;
            long l;
            if (textview != null && !TextUtils.isEmpty(b1.data.message))
            {
                textview.setVisibility(0);
                textview.setText(b1.data.message);
            } else
            {
                textview.setVisibility(8);
            }
            obj.b = System.currentTimeMillis();
            i = 0;
        } else
        if (b1.b > 0)
        {
            imageview.setImageResource(b1.b);
            obj.b = System.currentTimeMillis();
            i = 0;
        } else
        {
            i = 1;
        }
        if (i != 0 && !TextUtils.isEmpty(b1.data.imageUrl))
        {
            s = GalleryUtils.a(imageview.getContext(), b1.data.imageUrl);
            l = ((a) (obj)).b;
            obj.b = System.currentTimeMillis();
            (new a._cls1(((a) (obj)), s, imageview, b1, view1, textview, l)).a(new String[] {
                b1.data.imageUrl, s
            });
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view.equals(obj);
    }
}
