// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.or;


// Referenced classes of package org.apache.log4j.or:
//            ObjectRenderer

class DefaultRenderer
    implements ObjectRenderer
{

    DefaultRenderer()
    {
    }

    public String doRender(Object obj)
    {
        try
        {
            obj = obj.toString();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return ((Throwable) (obj)).toString();
        }
        return ((String) (obj));
    }
}
