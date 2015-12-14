// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.HashMap;

public class bmv extends bmy
{

    private bmu e;
    private bmw f;

    public bmv()
    {
        a("simple");
    }

    public void a(Context context, HashMap hashmap)
    {
        super.a(context, hashmap);
        e = (bmu)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR_HOR, hashmap);
        a(((bmx) (e)));
        f = (bmw)ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR_VER, hashmap);
        a(((bmx) (f)));
    }
}
