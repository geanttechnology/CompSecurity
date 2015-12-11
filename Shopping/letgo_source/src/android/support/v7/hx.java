// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.product.Thumb;
import java.util.Date;
import java.util.List;
import java.util.Random;

// Referenced classes of package android.support.v7:
//            ew, aik, iv, hr, 
//            aij

public class hx extends android.support.v7.widget.RecyclerView.Adapter
{
    public static class a extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        final TextView a;
        final ImageView b;
        final TextView c;
        final TextView d;
        final TextView e;

        public a(View view)
        {
            super(view);
            a = (TextView)view.findViewById(0x7f10011b);
            b = (ImageView)view.findViewById(0x7f10011a);
            c = (TextView)view.findViewById(0x7f100133);
            d = (TextView)view.findViewById(0x7f100131);
            e = (TextView)view.findViewById(0x7f100132);
        }
    }


    public aij a;
    public aik b;
    private final Random c = new Random();
    private final int d;
    private List e;
    private final Context f;
    private Date g;
    private LayoutInflater h;
    private ew i;

    public hx(Context context, List list)
    {
        i = ew.a(0, null);
        e = list;
        f = context;
        h = LayoutInflater.from(context);
        a = (new aij.a()).a(0x106000d).b(0x7f0200d7).c(0x106000d).a(true).b(true).a();
        b = aik.a();
        d = iv.a(context);
        g = new Date(System.currentTimeMillis() - 0x5265c00L);
    }

    private void a(a a1)
    {
        int j = b();
        a1.b.setBackgroundColor(j);
    }

    private boolean a(Product product)
    {
        product = product.getCreatedAt();
        return product != null && product.after(g);
    }

    private int b()
    {
        return f.getResources().getColor(f.getResources().getIdentifier((new StringBuilder()).append("ambatana_background_palette_").append(String.valueOf(a(0, 6))).toString(), "color", f.getPackageName()));
    }

    public int a()
    {
        if (e == null)
        {
            return 0;
        } else
        {
            return e.size();
        }
    }

    public int a(int j, int k)
    {
        return c.nextInt((k - j) + 1) + j;
    }

    public Product a(int j)
        throws IllegalArgumentException
    {
        if (e == null || e.isEmpty())
        {
            throw new IllegalArgumentException("The collection is empty");
        }
        if (j >= 0 && j < e.size())
        {
            return (Product)e.get(j);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("The position value must be in the range 0 to products size : ").append(a()).append("requested : ").append(j).toString());
        }
    }

    public int getItemCount()
    {
        return a() + 1;
    }

    public long getItemId(int j)
    {
        return (long)j;
    }

    public int getItemViewType(int j)
    {
        return j != a() ? 0 : 1;
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int j)
    {
        if (viewholder instanceof a)
        {
            viewholder = (a)viewholder;
            Product product = (Product)e.get(j);
            String s = product.getName();
            Object obj = product.getThumb();
            String s1 = ((Thumb) (obj)).getUrl();
            ((a) (viewholder)).b.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            String s2 = (String)((a) (viewholder)).b.getTag();
            if (!TextUtils.isEmpty(s1))
            {
                if (s2 == null || !s2.equals(s1))
                {
                    Integer integer = ((Thumb) (obj)).getHeight();
                    obj = ((Thumb) (obj)).getWidth();
                    if (integer != null && obj != null && integer.intValue() != 0 && ((Integer) (obj)).intValue() != 0)
                    {
                        float f1 = (float)((Integer) (obj)).intValue() / (float)integer.intValue();
                        obj = ((a) (viewholder)).b.getLayoutParams();
                        obj.height = (int)((float)d / f1);
                        ((a) (viewholder)).b.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                    }
                    a(viewholder);
                    i.a(s1, ((a) (viewholder)).b, null);
                }
            } else
            {
                a(viewholder);
                ((a) (viewholder)).b.setImageResource(0x106000d);
            }
            ((a) (viewholder)).a.setText(s);
            ((a) (viewholder)).a.setEllipsize(android.text.TextUtils.TruncateAt.END);
            s = product.getFormattedPrice();
            ((a) (viewholder)).c.setText(s);
            if (product.isSold())
            {
                ((a) (viewholder)).d.setVisibility(0);
                ((a) (viewholder)).d.setRotation(45F);
                return;
            }
            ((a) (viewholder)).d.setVisibility(8);
            if (a(product))
            {
                ((a) (viewholder)).e.setVisibility(0);
                ((a) (viewholder)).e.setRotation(45F);
                return;
            } else
            {
                ((a) (viewholder)).e.setVisibility(8);
                return;
            }
        }
        if (viewholder instanceof hr)
        {
            android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams layoutparams = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams)viewholder.itemView.getLayoutParams();
            layoutparams.setFullSpan(true);
            viewholder.itemView.setLayoutParams(layoutparams);
            return;
        }
        if (viewholder == null)
        {
            viewholder = "null";
        } else
        {
            viewholder = viewholder.getClass().getSimpleName();
        }
        throw new IllegalArgumentException((new StringBuilder()).append("Unaccepted viewHolder : ").append(viewholder).toString());
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int j)
    {
        if (j == 0)
        {
            return new a(h.inflate(0x7f040050, viewgroup, false));
        } else
        {
            return new hr(h.inflate(0x7f04003a, viewgroup, false));
        }
    }
}
