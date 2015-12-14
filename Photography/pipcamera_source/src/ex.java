// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.widget.ImageView;

public class ex
{

    private static ex a = null;

    public ex()
    {
    }

    public static ex a()
    {
        if (a == null)
        {
            a = new ex();
        }
        return a;
    }

    static ez a(ImageView imageview)
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
                Object obj1 = ez.a(imageview);
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

    private static ez b(ImageView imageview)
    {
        if (imageview != null)
        {
            imageview = imageview.getDrawable();
            if (imageview instanceof ey)
            {
                return ((ey)imageview).a();
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
        ez ez1 = new ez(this, context, imageview, i, j);
        imageview.setImageDrawable(new ey(context.getResources(), null, ez1));
        ez1.execute(new Object[] {
            obj
        });
        return;
        context;
        return;
        context;
    }

}
