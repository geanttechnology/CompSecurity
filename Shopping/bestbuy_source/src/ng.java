// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class ng
{

    private static Context a = null;
    private static Picasso b;

    public static void a(Context context)
    {
        if (a == null)
        {
            a = context;
        }
        b = Picasso.with(a);
    }

    public static void a(String s, ImageView imageview, boolean flag)
    {
        if (s != null && !s.isEmpty() && !s.equals("null"))
        {
            b.load(s).error(0x7f020130).into(imageview);
            return;
        } else
        {
            b.load(0x7f020130).into(imageview);
            return;
        }
    }

    public static void a(String s, ImageView imageview, boolean flag, Object obj, int i, RelativeLayout relativelayout)
    {
        if (s != null && !s.isEmpty() && !s.equals("null"))
        {
            b.load(s).error(0x7f020130).into(imageview, new Callback(obj, i, relativelayout) {

                final Object a;
                final int b;
                final RelativeLayout c;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    ((nh)a).a(b, c);
                }

            
            {
                a = obj;
                b = i;
                c = relativelayout;
                super();
            }
            });
            return;
        } else
        {
            b.load(0x7f020130).into(imageview);
            return;
        }
    }

}
