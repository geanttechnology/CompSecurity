// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.android.dexload.compatibility;

import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public abstract class DexElementCompatibility
{
    static class ElementObjectFileBooleanFileDexFile extends DexElementCompatibility
    {

        private Constructor mElementConstructor;

        protected void findConstructor(Class class1)
            throws NoSuchMethodException, SecurityException
        {
            mElementConstructor = class1.getConstructor(new Class[] {
                java/io/File, Boolean.TYPE, java/io/File, dalvik/system/DexFile
            });
        }

        public Object newInstance(File file, DexFile dexfile)
            throws InstantiationException
        {
            file = ((File) (mElementConstructor.newInstance(new Object[] {
                file, Boolean.valueOf(false), file, dexfile
            })));
            return file;
            file;
            DexElementCompatibility.logInstantiationFailed(file);
_L2:
            throw new InstantiationException("Could not instantiate DexPathList$Element");
            file;
            DexElementCompatibility.logInstantiationFailed(file);
            continue; /* Loop/switch isn't completed */
            file;
            DexElementCompatibility.logInstantiationFailed(file);
            continue; /* Loop/switch isn't completed */
            file;
            DexElementCompatibility.logInstantiationFailed(file);
            if (true) goto _L2; else goto _L1
_L1:
        }

        ElementObjectFileBooleanFileDexFile()
        {
        }
    }

    static class ElementObjectFileFileDexFile extends DexElementCompatibility
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
            DexElementCompatibility.logInstantiationFailed(file);
_L2:
            throw new InstantiationException("Could not instantiate DexPathList$Element");
            file;
            DexElementCompatibility.logInstantiationFailed(file);
            continue; /* Loop/switch isn't completed */
            file;
            DexElementCompatibility.logInstantiationFailed(file);
            continue; /* Loop/switch isn't completed */
            file;
            DexElementCompatibility.logInstantiationFailed(file);
            if (true) goto _L2; else goto _L1
_L1:
        }

        ElementObjectFileFileDexFile()
        {
        }
    }

    static class ElementObjectFileZipFileDexFile extends DexElementCompatibility
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
            DexElementCompatibility.logInstantiationFailed(file);
_L2:
            throw new InstantiationException("Could not instantiate DexPathList$Element");
            file;
            DexElementCompatibility.logInstantiationFailed(file);
            continue; /* Loop/switch isn't completed */
            file;
            DexElementCompatibility.logInstantiationFailed(file);
            continue; /* Loop/switch isn't completed */
            file;
            DexElementCompatibility.logInstantiationFailed(file);
            continue; /* Loop/switch isn't completed */
            file;
            DexElementCompatibility.logInstantiationFailed(file);
            continue; /* Loop/switch isn't completed */
            file;
            DexElementCompatibility.logInstantiationFailed(file);
            if (true) goto _L2; else goto _L1
_L1:
        }

        ElementObjectFileZipFileDexFile()
        {
        }
    }


    private static final List DEX_ELEMENT_VARIATIONS = Arrays.asList(new DexElementCompatibility[] {
        new ElementObjectFileFileDexFile(), new ElementObjectFileZipFileDexFile(), new ElementObjectFileBooleanFileDexFile()
    });
    protected Constructor mElementConstructor;

    private DexElementCompatibility()
    {
    }


    public static DexElementCompatibility getDexElementCompatibility(Class class1)
    {
        Iterator iterator = DEX_ELEMENT_VARIATIONS.iterator();
_L2:
        DexElementCompatibility dexelementcompatibility;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        dexelementcompatibility = (DexElementCompatibility)iterator.next();
        dexelementcompatibility.findConstructor(class1);
        return dexelementcompatibility;
        Object obj;
        obj;
        Log.v("DexElementCompatibility", (new StringBuilder()).append(dexelementcompatibility.getClass().getSimpleName()).append(" is not the right one for this platform").toString());
        continue; /* Loop/switch isn't completed */
        obj;
        Log.v("DexElementCompatibility", (new StringBuilder()).append(dexelementcompatibility.getClass().getSimpleName()).append(" has a SecurityException").toString());
        if (true) goto _L2; else goto _L1
_L1:
        throw new NoSuchMethodError("DexPath$Element contructor for this version of android is unhandled by DexElementCompatibility");
    }

    private static void logInstantiationFailed(Exception exception)
    {
        Log.e("DexElementCompatibility", (new StringBuilder()).append("Instantiation of the object failed. This might be a new version of android that needs to be handled.This is due to this exception: ").append(exception.getClass().getSimpleName()).toString());
    }

    protected abstract void findConstructor(Class class1)
        throws NoSuchMethodException, SecurityException;

    public abstract Object newInstance(File file, DexFile dexfile)
        throws InstantiationException;


}
