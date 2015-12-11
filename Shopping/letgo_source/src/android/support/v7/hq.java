// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.abtnprojects.ambatana.models.chat.Conversation;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.user.User;
import java.util.Date;
import java.util.List;

// Referenced classes of package android.support.v7:
//            aky, ih, alc

public class hq extends ArrayAdapter
{
    private static class a
    {

        ImageView a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;
        ImageView f;
        TextView g;

        public a(View view)
        {
            a = (ImageView)view.findViewById(0x7f10011c);
            b = (TextView)view.findViewById(0x7f10011d);
            c = (TextView)view.findViewById(0x7f10011e);
            d = (TextView)view.findViewById(0x7f100120);
            e = (TextView)view.findViewById(0x7f10011f);
            f = (ImageView)view.findViewById(0x7f100121);
            g = (TextView)view.findViewById(0x7f100122);
        }
    }


    private Context a;
    private LayoutInflater b;
    private Date c;

    public hq(Context context, List list)
    {
        super(context, 0, list);
        a = context;
        c = new Date();
        b = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        String s;
        Conversation conversation;
        Product product;
        if (view == null)
        {
            view1 = b.inflate(0x7f040047, viewgroup, false);
            viewgroup = new a(view1);
        } else
        {
            viewgroup = (a)view.getTag();
            view1 = view;
        }
        conversation = (Conversation)getItem(i);
        product = conversation.getProduct();
        if (conversation == null)
        {
            view = null;
        } else
        {
            view = conversation.getUserToDisplay();
        }
        if (view == null)
        {
            s = a.getString(0x7f0901c7);
        } else
        {
            s = view.getName();
        }
        ((a) (viewgroup)).b.setText(s);
        if (product == null)
        {
            s = a.getResources().getString(0x7f090117);
        } else
        {
            s = product.getName();
        }
        ((a) (viewgroup)).c.setText(s);
        if (view == null)
        {
            view = null;
        } else
        {
            view = view.getAvatarUrl();
        }
        if (!TextUtils.isEmpty(view))
        {
            aky.a(a).a(view).a(new ih()).a().c().a(((a) (viewgroup)).a);
        } else
        {
            ((a) (viewgroup)).a.setImageResource(0x7f02011e);
        }
        if (product.isDeleted())
        {
            view = a.getString(0x7f09004e);
        } else
        {
            view = conversation.getUpdatedAt();
            if (c.getTime() < view.getTime() + 60000L)
            {
                view = a.getString(0x7f0901a6);
            } else
            {
                view = DateUtils.getRelativeTimeSpanString(view.getTime(), c.getTime(), 60000L, 0);
            }
        }
        ((a) (viewgroup)).e.setText(view);
        i = conversation.getUnreadCount();
        if (i > 0)
        {
            ((a) (viewgroup)).f.setVisibility(8);
            ((a) (viewgroup)).g.setText(String.valueOf(i));
            ((a) (viewgroup)).g.setVisibility(0);
        } else
        {
            ((a) (viewgroup)).f.setVisibility(0);
            ((a) (viewgroup)).g.setVisibility(8);
        }
        view1.setTag(viewgroup);
        return view1;
    }
}
