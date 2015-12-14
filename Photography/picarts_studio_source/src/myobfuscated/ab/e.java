// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

// Referenced classes of package myobfuscated.ab:
//            d, i

final class e extends android.graphics.drawable.Drawable.ConstantState
{

    final i a;

    public e(Context context, i i)
    {
        context.getApplicationContext();
        a = i;
    }

    public final int getChangingConfigurations()
    {
        return 0;
    }

    public final Drawable newDrawable()
    {
        return new d(this);
    }

    public final Drawable newDrawable(Resources resources)
    {
        return newDrawable();
    }
}
