// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.reflect;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.reflect:
//            Reflection

public final class ClassPath
{
    public static final class ClassInfo extends ResourceInfo
    {

        private final String className;

        public String getName()
        {
            return className;
        }

        public String getPackageName()
        {
            return Reflection.getPackageName(className);
        }

        public String getSimpleName()
        {
            int i = className.lastIndexOf('$');
            if (i != -1)
            {
                String s = className.substring(i + 1);
                return CharMatcher.DIGIT.trimLeadingFrom(s);
            }
            String s1 = getPackageName();
            if (s1.isEmpty())
            {
                return className;
            } else
            {
                return className.substring(s1.length() + 1);
            }
        }

        public Class load()
        {
            Class class1;
            try
            {
                class1 = loader.loadClass(className);
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                throw new IllegalStateException(classnotfoundexception);
            }
            return class1;
        }

        public String toString()
        {
            return className;
        }


        ClassInfo(String s, ClassLoader classloader)
        {
            super(s, classloader);
            className = ClassPath.getClassName(s);
        }
    }

    static final class DefaultScanner extends Scanner
    {

        private final SetMultimap resources = MultimapBuilder.hashKeys().linkedHashSetValues().build();

        private void scanDirectory(File file, ClassLoader classloader, String s)
            throws IOException
        {
            File afile[] = file.listFiles();
            if (afile == null)
            {
                classloader = ClassPath.logger;
                file = String.valueOf(file);
                classloader.warning((new StringBuilder(String.valueOf(file).length() + 22)).append("Cannot read directory ").append(file).toString());
            } else
            {
                int j = afile.length;
                int i = 0;
                while (i < j) 
                {
                    File file1 = afile[i];
                    file = file1.getName();
                    if (file1.isDirectory())
                    {
                        scanDirectory(file1, classloader, (new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(file).length())).append(s).append(file).append("/").toString());
                    } else
                    {
                        String s1 = String.valueOf(s);
                        file = String.valueOf(file);
                        if (file.length() != 0)
                        {
                            file = s1.concat(file);
                        } else
                        {
                            file = new String(s1);
                        }
                        if (!file.equals("META-INF/MANIFEST.MF"))
                        {
                            resources.get(classloader).add(file);
                        }
                    }
                    i++;
                }
            }
        }

        ImmutableSet getResources()
        {
            com.google.common.collect.ImmutableSet.Builder builder = ImmutableSet.builder();
            java.util.Map.Entry entry;
            for (Iterator iterator = resources.entries().iterator(); iterator.hasNext(); builder.add(ResourceInfo.of((String)entry.getValue(), (ClassLoader)entry.getKey())))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            return builder.build();
        }

        protected void scanDirectory(ClassLoader classloader, File file)
            throws IOException
        {
            scanDirectory(file, classloader, "");
        }

        protected void scanJarFile(ClassLoader classloader, JarFile jarfile)
        {
            jarfile = jarfile.entries();
            do
            {
                if (!jarfile.hasMoreElements())
                {
                    break;
                }
                JarEntry jarentry = (JarEntry)jarfile.nextElement();
                if (!jarentry.isDirectory() && !jarentry.getName().equals("META-INF/MANIFEST.MF"))
                {
                    resources.get(classloader).add(jarentry.getName());
                }
            } while (true);
        }

        DefaultScanner()
        {
        }
    }

    public static class ResourceInfo
    {

        final ClassLoader loader;
        private final String resourceName;

        static ResourceInfo of(String s, ClassLoader classloader)
        {
            if (s.endsWith(".class"))
            {
                return new ClassInfo(s, classloader);
            } else
            {
                return new ResourceInfo(s, classloader);
            }
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof ResourceInfo)
            {
                obj = (ResourceInfo)obj;
                flag = flag1;
                if (resourceName.equals(((ResourceInfo) (obj)).resourceName))
                {
                    flag = flag1;
                    if (loader == ((ResourceInfo) (obj)).loader)
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        public final String getResourceName()
        {
            return resourceName;
        }

        public int hashCode()
        {
            return resourceName.hashCode();
        }

        public String toString()
        {
            return resourceName;
        }

        public final URL url()
            throws NoSuchElementException
        {
            URL url1 = loader.getResource(resourceName);
            if (url1 == null)
            {
                throw new NoSuchElementException(resourceName);
            } else
            {
                return url1;
            }
        }

        ResourceInfo(String s, ClassLoader classloader)
        {
            resourceName = (String)Preconditions.checkNotNull(s);
            loader = (ClassLoader)Preconditions.checkNotNull(classloader);
        }
    }

    static abstract class Scanner
    {

        private final Set scannedUris = Sets.newHashSet();

        static ImmutableMap getClassPathEntries(ClassLoader classloader)
        {
            LinkedHashMap linkedhashmap = Maps.newLinkedHashMap();
            ClassLoader classloader1 = classloader.getParent();
            if (classloader1 != null)
            {
                linkedhashmap.putAll(getClassPathEntries(classloader1));
            }
            if (classloader instanceof URLClassLoader)
            {
                URL aurl[] = ((URLClassLoader)classloader).getURLs();
                int j = aurl.length;
                for (int i = 0; i < j; i++)
                {
                    Object obj = aurl[i];
                    if (!((URL) (obj)).getProtocol().equals("file"))
                    {
                        continue;
                    }
                    obj = new File(((URL) (obj)).getFile());
                    if (!linkedhashmap.containsKey(obj))
                    {
                        linkedhashmap.put(obj, classloader);
                    }
                }

            }
            return ImmutableMap.copyOf(linkedhashmap);
        }

        static URL getClassPathEntry(File file, String s)
            throws MalformedURLException
        {
            return new URL(file.toURI().toURL(), s);
        }

        static ImmutableSet getClassPathFromManifest(File file, Manifest manifest)
        {
            com.google.common.collect.ImmutableSet.Builder builder;
            if (manifest == null)
            {
                return ImmutableSet.of();
            }
            builder = ImmutableSet.builder();
            manifest = manifest.getMainAttributes().getValue(java.util.jar.Attributes.Name.CLASS_PATH.toString());
            if (manifest == null) goto _L2; else goto _L1
_L1:
            Iterator iterator = ClassPath.CLASS_PATH_ATTRIBUTE_SEPARATOR.split(manifest).iterator();
_L3:
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            manifest = (String)iterator.next();
            URL url = getClassPathEntry(file, manifest);
            if (url.getProtocol().equals("file"))
            {
                builder.add(new File(url.getFile()));
            }
            continue; /* Loop/switch isn't completed */
            MalformedURLException malformedurlexception;
            malformedurlexception;
            Logger logger1 = ClassPath.logger;
            manifest = String.valueOf(manifest);
            if (manifest.length() != 0)
            {
                manifest = "Invalid Class-Path entry: ".concat(manifest);
            } else
            {
                manifest = new String("Invalid Class-Path entry: ");
            }
            logger1.warning(manifest);
            if (true) goto _L3; else goto _L2
_L2:
            return builder.build();
        }

        private void scanFrom(File file, ClassLoader classloader)
            throws IOException
        {
            if (!file.exists())
            {
                return;
            }
            if (file.isDirectory())
            {
                scanDirectory(classloader, file);
                return;
            } else
            {
                scanJar(file, classloader);
                return;
            }
        }

        private void scanJar(File file, ClassLoader classloader)
            throws IOException
        {
            JarFile jarfile;
            try
            {
                jarfile = new JarFile(file);
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return;
            }
            for (file = getClassPathFromManifest(file, jarfile.getManifest()).iterator(); file.hasNext(); scan((File)file.next(), classloader)) { }
            break MISSING_BLOCK_LABEL_56;
            file;
            try
            {
                jarfile.close();
            }
            // Misplaced declaration of an exception variable
            catch (ClassLoader classloader) { }
            throw file;
            scanJarFile(classloader, jarfile);
            try
            {
                jarfile.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return;
            }
        }

        final void scan(File file, ClassLoader classloader)
            throws IOException
        {
            if (scannedUris.add(file.getCanonicalFile()))
            {
                scanFrom(file, classloader);
            }
        }

        public final void scan(ClassLoader classloader)
            throws IOException
        {
            java.util.Map.Entry entry;
            for (classloader = getClassPathEntries(classloader).entrySet().iterator(); classloader.hasNext(); scan((File)entry.getKey(), (ClassLoader)entry.getValue()))
            {
                entry = (java.util.Map.Entry)classloader.next();
            }

        }

        protected abstract void scanDirectory(ClassLoader classloader, File file)
            throws IOException;

        protected abstract void scanJarFile(ClassLoader classloader, JarFile jarfile)
            throws IOException;

        Scanner()
        {
        }
    }


    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(" ").omitEmptyStrings();
    private static final Predicate IS_TOP_LEVEL = new Predicate() {

        public boolean apply(ClassInfo classinfo)
        {
            return classinfo.className.indexOf('$') == -1;
        }

        public volatile boolean apply(Object obj)
        {
            return apply((ClassInfo)obj);
        }

    };
    private static final Logger logger = Logger.getLogger(com/google/common/reflect/ClassPath.getName());
    private final ImmutableSet resources;

    private ClassPath(ImmutableSet immutableset)
    {
        resources = immutableset;
    }

    public static ClassPath from(ClassLoader classloader)
        throws IOException
    {
        DefaultScanner defaultscanner = new DefaultScanner();
        defaultscanner.scan(classloader);
        return new ClassPath(defaultscanner.getResources());
    }

    static String getClassName(String s)
    {
        return s.substring(0, s.length() - ".class".length()).replace('/', '.');
    }

    public ImmutableSet getAllClasses()
    {
        return FluentIterable.from(resources).filter(com/google/common/reflect/ClassPath$ClassInfo).toSet();
    }

    public ImmutableSet getResources()
    {
        return resources;
    }

    public ImmutableSet getTopLevelClasses()
    {
        return FluentIterable.from(resources).filter(com/google/common/reflect/ClassPath$ClassInfo).filter(IS_TOP_LEVEL).toSet();
    }

    public ImmutableSet getTopLevelClasses(String s)
    {
        Preconditions.checkNotNull(s);
        com.google.common.collect.ImmutableSet.Builder builder = ImmutableSet.builder();
        com.google.common.collect.UnmodifiableIterator unmodifiableiterator = getTopLevelClasses().iterator();
        do
        {
            if (!unmodifiableiterator.hasNext())
            {
                break;
            }
            ClassInfo classinfo = (ClassInfo)unmodifiableiterator.next();
            if (classinfo.getPackageName().equals(s))
            {
                builder.add(classinfo);
            }
        } while (true);
        return builder.build();
    }

    public ImmutableSet getTopLevelClassesRecursive(String s)
    {
        Preconditions.checkNotNull(s);
        s = (new StringBuilder(String.valueOf(s).length() + 1)).append(s).append(".").toString();
        com.google.common.collect.ImmutableSet.Builder builder = ImmutableSet.builder();
        com.google.common.collect.UnmodifiableIterator unmodifiableiterator = getTopLevelClasses().iterator();
        do
        {
            if (!unmodifiableiterator.hasNext())
            {
                break;
            }
            ClassInfo classinfo = (ClassInfo)unmodifiableiterator.next();
            if (classinfo.getName().startsWith(s))
            {
                builder.add(classinfo);
            }
        } while (true);
        return builder.build();
    }



}
