// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.abtnprojects.ambatana.models.chat.Message;
import com.parse.ParseUser;
import java.util.Date;
import java.util.List;

// Referenced classes of package android.support.v7:
//            aqo, aky, ih, alc

public class ht extends ArrayAdapter
    implements ListAdapter
{
    public abstract class a
    {

        final TextView a;
        final TextView b;
        final ht c;

        public a(View view)
        {
            c = ht.this;
            super();
            b = (TextView)view.findViewById(0x7f100093);
            a = (TextView)view.findViewById(0x7f10012e);
        }
    }

    public class b extends a
    {

        final ImageView d;
        final TextView e;
        final ht f;

        public b(View view)
        {
            f = ht.this;
            super(view);
            d = (ImageView)view.findViewById(0x7f10012f);
            e = (TextView)view.findViewById(0x7f10012d);
        }
    }

    public class c extends a
    {

        final TextView d;
        final ht e;

        public c(View view)
        {
            e = ht.this;
            super(view);
            d = (TextView)view.findViewById(0x7f10012d);
        }
    }


    private Context a;
    private final Date b = new Date();
    private LayoutInflater c;

    public ht(Context context, List list)
    {
        super(context, 0, list);
        a = context;
        c = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    private CharSequence a(Date date)
    {
        if (b.getTime() < date.getTime() + 60000L)
        {
            return a.getString(0x7f0901a6);
        } else
        {
            return DateUtils.getRelativeTimeSpanString(date.getTime(), b.getTime(), 60000L, 0);
        }
    }

    public Message a(int i)
    {
        return (Message)super.getItem(i);
    }

    public int getCount()
    {
        return super.getCount();
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return !a(i).getUserId().equals(ParseUser.getCurrentUser().getObjectId()) ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
        String s;
        Message message;
        if (view == null)
        {
            obj = null;
        } else
        {
            obj = (a)view.getTag();
        }
        message = a(i);
        aqo.a("will show : %s", new Object[] {
            message.toString()
        });
        s = message.getText();
        if (getItemViewType(i) == 0)
        {
            if (obj == null || !(obj instanceof c))
            {
                view = c.inflate(0x7f04004e, viewgroup, false);
                viewgroup = new c(view);
            } else
            {
                viewgroup = ((ViewGroup) (obj));
            }
            ((c)viewgroup).d.setText(a.getString(0x7f0900e1));
        } else
        {
            b b1;
            if (obj == null || !(obj instanceof b))
            {
                view = c.inflate(0x7f04004f, viewgroup, false);
                viewgroup = new b(view);
            } else
            {
                viewgroup = ((ViewGroup) (obj));
            }
            obj = message.getUserAvatarUrl();
            b1 = (b)viewgroup;
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                aky.a(a).a(((String) (obj))).a(new ih()).a().c().a(b1.d);
            } else
            {
                b1.d.setImageResource(0x7f02011e);
            }
            b1.e.setText(message.getUserName());
        }
        obj = a(message.getCreatedAt());
        ((a) (viewgroup)).a.setText(((CharSequence) (obj)));
        ((a) (viewgroup)).b.setText(s);
        view.setTag(viewgroup);
        return view;
    }

    public int getViewTypeCount()
    {
        return 2;
    }
}
