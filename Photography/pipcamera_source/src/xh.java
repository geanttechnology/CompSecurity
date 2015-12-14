// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class xh extends xk
{

    private xg e;
    private xi f;

    public xh()
    {
        a("simple");
    }

    public void a(Context context, HashMap hashmap)
    {
        super.a(context, hashmap);
        e = (xg)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR_HOR, hashmap);
        a(((xj) (e)));
        f = (xi)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR_VER, hashmap);
        a(((xj) (f)));
    }
}
