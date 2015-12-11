// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.android.dexload.compatibility;

import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

// Referenced classes of package amazon.android.dexload.compatibility:
//            DexElementCompatibility

static class  extends DexElementCompatibility
{

    protected void findConstructor(Class class1)
        throws NoSuchMethodException, SecurityException
    {
        mElementConstructor = class1.getConstructor(new Class[] {
            java/io/File, java/util/zip/ZipFile, dalvik/system/DexFile
        });
    }

    public Object newInstance(File file, DexFile dexfile)
        throws InstantiationException
    {
        ZipFile zipfile = new ZipFile(file);
        file = ((File) (mElementConstructor.newInstance(new Object[] {
            file, zipfile, dexfile
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
