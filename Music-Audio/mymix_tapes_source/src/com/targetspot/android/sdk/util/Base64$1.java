// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

// Referenced classes of package com.targetspot.android.sdk.util:
//            Base64

static final class val.loader extends ObjectInputStream
{

    final ClassLoader val$loader;

    public Class resolveClass(ObjectStreamClass objectstreamclass)
        throws IOException, ClassNotFoundException
    {
        Class class2 = Class.forName(objectstreamclass.getName(), false, val$loader);
        Class class1 = class2;
        if (class2 == null)
        {
            class1 = super.resolveClass(objectstreamclass);
        }
        return class1;
    }

    (InputStream inputstream, ClassLoader classloader)
    {
        val$loader = classloader;
        super(inputstream);
    }
}
