// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import com.bumptech.glide.load.e;
import java.io.File;
import myobfuscated.ai.b;

// Referenced classes of package myobfuscated.v:
//            ae, af, l

public final class k
    implements ae
{

    public k()
    {
    }

    public final af buildLoadData(Object obj, int i, int j, e e)
    {
        obj = (File)obj;
        return new af(new b(obj), new l(((File) (obj))));
    }

    public final volatile boolean handles(Object obj)
    {
        return true;
    }
}
