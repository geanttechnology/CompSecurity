// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ag;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

// Referenced classes of package myobfuscated.ag:
//            c

public class b extends c
{

    public b(ImageView imageview)
    {
        super(imageview);
    }

    protected final void a(Object obj)
    {
        obj = (Drawable)obj;
        ((ImageView)a).setImageDrawable(((Drawable) (obj)));
    }
}
