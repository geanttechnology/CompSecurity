// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.util.Vector;

// Referenced classes of package org.apache.log4j:
//            Logger

class ProvisionNode extends Vector
{

    ProvisionNode(Logger logger)
    {
        addElement(logger);
    }
}
