// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.File;
import java.io.IOException;

// Referenced classes of package a.a:
//            eu

public class aw
{

    protected File a;

    public aw(File file)
    {
        a = file;
    }

    public Object a()
    {
        String s;
        try
        {
            s = eu.b(a);
        }
        catch (IOException ioexception)
        {
            return "";
        }
        return s;
    }
}
