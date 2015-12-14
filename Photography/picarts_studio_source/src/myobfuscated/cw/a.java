// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cw;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.picsart.studio.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cv.b;

public class a extends ArrayAdapter
{

    private static String c = myobfuscated/cw/a.getSimpleName();
    public int a;
    public int b;
    private Context d;
    private List e;
    private boolean f;
    private boolean g;
    private ColorDrawable h;
    private ColorDrawable i;
    private d j;

    public a(Context context, List list, int k, boolean flag)
    {
        boolean flag1 = false;
        super(context, -1);
        f = false;
        b = 3;
        h = new ColorDrawable(Color.parseColor("#EFEFEF"));
        i = new ColorDrawable(Color.parseColor("#DEDEDE"));
        d = context;
        a = k;
        g = false;
        f = flag;
        if (f)
        {
            e = new ArrayList();
            for (k = ((flag1) ? 1 : 0); k < list.size(); k++)
            {
                e.add(null);
            }

        }
        j = new d(context);
    }

    public void addAll(Collection collection)
    {
        setNotifyOnChange(false);
        if (collection != null)
        {
            collection = collection.iterator();
            do
            {
                if (!collection.hasNext())
                {
                    break;
                }
                add((b)collection.next());
                if (f && e != null)
                {
                    int k = getCount() - 1;
                    if (k >= 0)
                    {
                        try
                        {
                            e.get(k);
                        }
                        catch (IndexOutOfBoundsException indexoutofboundsexception)
                        {
                            e.add(k, null);
                            com.socialin.android.d.b(c, "addCheckBox", indexoutofboundsexception);
                        }
                    }
                }
                setNotifyOnChange(true);
            } while (true);
        }
    }

    public void clear()
    {
        super.clear();
        if (e != null)
        {
            e.clear();
        }
    }

    public long getItemId(int k)
    {
        return (long)k;
    }

    public View getView(int k, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = LayoutInflater.from(d).inflate(0x7f030241, viewgroup, false);
        }
        ImageView imageview = (ImageView)view1.findViewById(0x7f100a5b);
        View view2 = view1.findViewById(0x7f100a5c);
        view = (TextView)view1.findViewById(0x7f100a5d);
        if (a > 0)
        {
            int i1 = a;
            try
            {
                view1.findViewById(0x7f100a5e).setLayoutParams(new android.widget.RelativeLayout.LayoutParams(i1, i1));
                view1.findViewById(0x7f100a5a).setLayoutParams(new android.widget.AbsListView.LayoutParams(i1, -2));
                view1.findViewById(0x7f100a5b).setLayoutParams(new android.widget.RelativeLayout.LayoutParams(i1, i1));
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                com.socialin.android.d.b(c, "getView", viewgroup);
            }
        }
        viewgroup = (b)getItem(k);
        if (view != null)
        {
            view.setVisibility(8);
        }
        if (a > 75)
        {
            view = ((b) (viewgroup)).f;
        } else
        {
            view = ((b) (viewgroup)).b;
        }
        if (TextUtils.isEmpty(view))
        {
            if (viewgroup == null)
            {
                view = "";
            } else
            {
                view = ((b) (viewgroup)).d;
            }
        }
        i1 = k / b;
        if ((i1 + (k - b * i1)) % 2 == 0)
        {
            viewgroup = i;
        } else
        {
            viewgroup = h;
        }
        imageview.setBackgroundDrawable(viewgroup);
        ((e)(new e()).a(l.e)).b(getContext());
        j.b(view, imageview, (e)((e)com.bumptech.glide.request.e.b(l.a).b()).a(android.graphics.Bitmap.CompressFormat.PNG));
        if (f)
        {
            if (e == null)
            {
                e = new ArrayList();
            }
            view2.setVisibility(0);
            try
            {
                if (e.get(k) == null)
                {
                    e.set(k, view2);
                }
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                e.add(k, view2);
                com.socialin.android.d.a(c, view);
                return view1;
            }
            return view1;
        } else
        {
            view2.setVisibility(8);
            return view1;
        }
    }

    public boolean hasStableIds()
    {
        return true;
    }

}
