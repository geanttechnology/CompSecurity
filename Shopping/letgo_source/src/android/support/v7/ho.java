// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.abtnprojects.ambatana.models.Category;
import java.util.List;

// Referenced classes of package android.support.v7:
//            r, hr

public class ho extends android.support.v7.widget.RecyclerView.Adapter
{
    public static class a extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        final TextView a;
        final ImageView b;

        public a(View view)
        {
            super(view);
            a = (TextView)view.findViewById(0x7f10011b);
            b = (ImageView)view.findViewById(0x7f10011a);
        }
    }


    private List a;
    private final Context b;
    private LayoutInflater c;

    public ho(Context context, List list)
    {
        a = list;
        b = context;
        c = LayoutInflater.from(context);
    }

    private int a()
    {
        if (a == null)
        {
            return 0;
        } else
        {
            return a.size();
        }
    }

    private Drawable a(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException("Unknown category, index must be a valid number from 1 to 8");

        case 1: // '\001'
            return r.a(b.getResources(), 0x7f0200b7, b.getTheme());

        case 2: // '\002'
            return r.a(b.getResources(), 0x7f020086, b.getTheme());

        case 3: // '\003'
            return r.a(b.getResources(), 0x7f02013c, b.getTheme());

        case 4: // '\004'
            return r.a(b.getResources(), 0x7f0200c3, b.getTheme());

        case 5: // '\005'
            return r.a(b.getResources(), 0x7f02011c, b.getTheme());

        case 6: // '\006'
            return r.a(b.getResources(), 0x7f0200bb, b.getTheme());

        case 7: // '\007'
            return r.a(b.getResources(), 0x7f020041, b.getTheme());

        case 8: // '\b'
            return r.a(b.getResources(), 0x7f02011f, b.getTheme());
        }
    }

    public int getItemCount()
    {
        return a() + 1;
    }

    public long getItemId(int i)
    {
        return (long)((Category)a.get(i)).getId();
    }

    public int getItemViewType(int i)
    {
        return i != a() ? 0 : 1;
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        if (viewholder instanceof a)
        {
            viewholder = (a)viewholder;
            Category category = (Category)a.get(i);
            ((a) (viewholder)).a.setText(category.getName());
            ((a) (viewholder)).b.setImageDrawable(a(category.getId()));
        }
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        if (i == 0)
        {
            return new a(c.inflate(0x7f040046, viewgroup, false));
        } else
        {
            return new hr(c.inflate(0x7f04003a, viewgroup, false));
        }
    }
}
