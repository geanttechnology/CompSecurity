// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.logging.Logger;
import org.roboguice.shaded.goole.common.cache.CacheLoader;

// Referenced classes of package com.google.inject.internal:
//            BytecodeGen

class val.typeClassLoader
    implements PrivilegedAction
{

    final run this$0;
    final ClassLoader val$typeClassLoader;

    public ClassLoader run()
    {
        return new geClassLoader(val$typeClassLoader);
    }

    public volatile Object run()
    {
        return run();
    }

    heLoader()
    {
        this$0 = final_heloader;
        val$typeClassLoader = ClassLoader.this;
        super();
    }

    // Unreferenced inner class com/google/inject/internal/BytecodeGen$1

/* anonymous class */
    static final class BytecodeGen._cls1 extends CacheLoader
    {

        public ClassLoader load(ClassLoader classloader)
        {
            BytecodeGen.logger.fine((new StringBuilder()).append("Creating a bridge ClassLoader for ").append(classloader).toString());
            return (ClassLoader)AccessController.doPrivileged(classloader. new BytecodeGen._cls1._cls1());
        }

        public volatile Object load(Object obj)
            throws Exception
        {
            return load((ClassLoader)obj);
        }

    }

}
