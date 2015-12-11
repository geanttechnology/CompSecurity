// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.android.dexload.compatibility;

import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package amazon.android.dexload.compatibility:
//            DexElementCompatibility

static class  extends DexElementCompatibility
{

    protected void findConstructor(Class class1)
        throws NoSuchMethodException, SecurityException
    {
        mElementConstructor = class1.getConstructor(new Class[] {
            java/io/File, java/io/File, dalvik/system/DexFile
        });
    }

    public Object newInstance(File file, DexFile dexfile)
        throws InstantiationException
    {
        file = ((File) (mElementConstructor.newInstance(new Object[] {
            file, file, dexfile
        })));
        return file;
        file;
        DexElementCompatibility.access$100(file);
_L2:
        throw new InstantiationException("Could not instantiate DexPathList$Element");
        file;
        DexElementCompatibility.access$100(file);
        continue; /* Loop/switch isn't completed */
        file;
        DexElementCompatibility.access$100(file);
        continue; /* Loop/switch isn't completed */
        file;
        DexElementCompatibility.access$100(file);
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
        super(null);
    }
}
