// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.bestbuy.android.api.lib.models.browse.Category;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.exacttarget.etpushsdk.ETException;
import com.exacttarget.etpushsdk.ETPush;
import java.util.ArrayList;
import java.util.List;

public class ef extends ArrayAdapter
{

    private List a;
    private LayoutInflater b;
    private Context c;
    private ArrayList d;

    public ef(Context context, int i, List list)
    {
        super(context, i, list);
        d = new ArrayList();
        a = list;
        c = context;
        d = lq.a(context);
        b = LayoutInflater.from(context);
    }

    static List a(ef ef1)
    {
        return ef1.a;
    }

    public int a(Category category)
    {
        return a.indexOf(category);
    }

    public Category a(int i)
    {
        return (Category)a.get(i);
    }

    public void a(ImageView imageview, Category category)
    {
        if (imageview.getVisibility() != 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        imageview.setVisibility(8);
        imageview = category.getCategoryId();
        d.remove(imageview);
        ETPush.pushManager().removeTag(imageview);
        lq.b(c, imageview);
_L1:
        return;
        imageview;
        imageview.printStackTrace();
        return;
        if (imageview.getVisibility() == 8)
        {
            category = category.getCategoryId();
            d.add(category);
            try
            {
                ETPush.pushManager().addTag(category);
                lq.a(c, category);
            }
            // Misplaced declaration of an exception variable
            catch (Category category)
            {
                category.printStackTrace();
            }
            imageview.setVisibility(0);
            imageview.setImageResource(0x7f020076);
            return;
        }
          goto _L1
    }

    public int getCount()
    {
        return a.size();
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public int getPosition(Object obj)
    {
        return a((Category)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = b.inflate(0x7f030086, null);
        viewgroup = (BBYTextView)view.findViewById(0x7f0c0070);
        ImageView imageview = (ImageView)view.findViewById(0x7f0c01f1);
        Category category = a(i);
        viewgroup.setText(category.getName());
        view.setOnClickListener(new android.view.View.OnClickListener(i, imageview) {

            final int a;
            final ImageView b;
            final ef c;

            public void onClick(View view1)
            {
                view1 = (Category)ef.a(c).get(a);
                c.a(b, view1);
            }

            
            {
                c = ef.this;
                a = i;
                b = imageview;
                super();
            }
        });
        if (d.contains(category.getCategoryId()))
        {
            imageview.setVisibility(0);
            imageview.setImageResource(0x7f020076);
            return view;
        } else
        {
            imageview.setVisibility(8);
            return view;
        }
    }
}
