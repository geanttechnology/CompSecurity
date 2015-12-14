// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.widget.ImageView;

public class yq
{

    private static yq a = null;

    public yq()
    {
    }

    public static yq a()
    {
        if (a == null)
        {
            a = new yq();
        }
        return a;
    }

    static ys a(ImageView imageview)
    {
        return b(imageview);
    }

    public static boolean a(Object obj, ImageView imageview)
    {
label0:
        {
            imageview = b(imageview);
            if (imageview != null)
            {
                Object obj1 = ys.a(imageview);
                if (obj1.getClass().equals(obj.getClass()) && obj1 == obj)
                {
                    break label0;
                }
                imageview.cancel(true);
            }
            return true;
        }
        return false;
    }

    private static ys b(ImageView imageview)
    {
        if (imageview != null)
        {
            imageview = imageview.getDrawable();
            if (imageview instanceof yr)
            {
                return ((yr)imageview).a();
            }
        }
        return null;
    }

    public void a(Context context, Object obj, ImageView imageview, int i, int j)
    {
        if (!a(obj, imageview))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        ys ys1 = new ys(this, context, imageview, i, j);
        imageview.setImageDrawable(new yr(context.getResources(), null, ys1));
        ys1.execute(new Object[] {
            obj
        });
        return;
        context;
        return;
        context;
    }

}
