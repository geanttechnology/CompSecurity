// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ag;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package myobfuscated.ag:
//            c

public class a extends c
{

    public a(ImageView imageview)
    {
        super(imageview);
    }

    public void a(Bitmap bitmap)
    {
        ((ImageView)a).setImageBitmap(bitmap);
    }

    public volatile void a(Object obj)
    {
        a((Bitmap)obj);
    }
}
