// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import java.util.Collections;
import java.util.Map;

// Referenced classes of package myobfuscated.v:
//            w, x

public interface u
{

    public static final u a = new w((new x()).a);

    public abstract Map a();

    
    {
        new u() {

            public final Map a()
            {
                return Collections.emptyMap();
            }

        };
    }
}
