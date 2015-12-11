// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.processor.javawriter.JavaWriter;
import java.io.IOException;

// Referenced classes of package io.realm.processor:
//            RealmProxyMediatorGenerator

private static interface I
{

    public abstract void emitStatement(int i, JavaWriter javawriter)
        throws IOException;
}
