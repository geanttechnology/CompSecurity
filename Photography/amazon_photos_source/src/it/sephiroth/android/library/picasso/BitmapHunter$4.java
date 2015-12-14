// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;


// Referenced classes of package it.sephiroth.android.library.picasso:
//            BitmapHunter, Transformation

static final class val.transformation
    implements Runnable
{

    final Transformation val$transformation;

    public void run()
    {
        throw new IllegalStateException((new StringBuilder()).append("Transformation ").append(val$transformation.key()).append(" returned input Bitmap but recycled it.").toString());
    }

    _cls9(Transformation transformation1)
    {
        val$transformation = transformation1;
        super();
    }
}
