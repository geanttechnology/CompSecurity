// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.Properties;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer

public class Loader
{
    public static class ClassProperties extends HashMap
    {

        String pathSeparator;
        String platformName;
        String platformRoot;

        public void addAll(String s, Collection collection)
        {
            if (collection != null)
            {
                String s1 = null;
                if (s.equals("compiler.path") || s.equals("compiler.sysroot") || s.equals("compiler.includepath") || s.equals("compiler.linkpath"))
                {
                    s1 = platformRoot;
                }
                LinkedList linkedlist = get(s);
                Iterator iterator = collection.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    collection = (String)iterator.next();
                    if (collection != null && !linkedlist.contains(collection))
                    {
                        s = collection;
                        if (s1 != null)
                        {
                            s = collection;
                            if (!(new File(collection)).isAbsolute())
                            {
                                s = collection;
                                if ((new File((new StringBuilder()).append(s1).append(collection).toString())).exists())
                                {
                                    s = (new StringBuilder()).append(s1).append(collection).toString();
                                }
                            }
                        }
                        linkedlist.add(s);
                    }
                } while (true);
            }
        }

        public transient void addAll(String s, String as[])
        {
            if (as != null)
            {
                addAll(s, ((Collection) (Arrays.asList(as))));
            }
        }

        public LinkedList get(String s)
        {
            LinkedList linkedlist1 = (LinkedList)super.get(s);
            LinkedList linkedlist = linkedlist1;
            if (linkedlist1 == null)
            {
                linkedlist = new LinkedList();
                put(s, linkedlist);
            }
            return linkedlist;
        }

        LinkedList getHeaderFiles()
        {
            LinkedList linkedlist1;
            LinkedList linkedlist2;
            Iterator iterator;
            linkedlist1 = get("compiler.includepath");
            LinkedList linkedlist = new LinkedList();
            linkedlist.addAll(get("generator.include"));
            linkedlist.addAll(get("generator.cinclude"));
            linkedlist2 = new LinkedList();
            iterator = linkedlist.iterator();
_L6:
            String s;
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            s = (String)iterator.next();
            if (!s.startsWith("<") || !s.endsWith(">")) goto _L2; else goto _L1
_L1:
            s = s.substring(1, s.length() - 1);
_L4:
            Iterator iterator1 = linkedlist1.iterator();
            File file1;
            do
            {
                if (!iterator1.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                file1 = new File((String)iterator1.next(), s);
            } while (!file1.exists());
            linkedlist2.add(file1);
            continue; /* Loop/switch isn't completed */
_L2:
            File file = new File(s);
            if (!file.exists()) goto _L4; else goto _L3
_L3:
            linkedlist2.add(file);
            if (true) goto _L6; else goto _L5
_L5:
            return linkedlist2;
        }

        public String getProperty(String s)
        {
            return getProperty(s, null);
        }

        public String getProperty(String s, String s1)
        {
            s = get(s);
            if (s.isEmpty())
            {
                return s1;
            } else
            {
                return (String)s.get(0);
            }
        }

        public void load(Class class1, boolean flag)
        {
            String as[];
            String as1[];
            String as2[];
            String as3[];
            String as4[];
            String as5[];
            String as6[];
            String as7[];
            String as8[];
            String s;
            Platform platform;
            String as17[][];
            boolean aflag[];
            int i;
            for (class1 = Loader.getEnclosingClass(class1); !class1.isAnnotationPresent(com/googlecode/javacpp/annotation/Properties) && !class1.isAnnotationPresent(com/googlecode/javacpp/annotation/Platform) && class1.getSuperclass() != null; class1 = class1.getSuperclass()) { }
            as = (Properties)class1.getAnnotation(com/googlecode/javacpp/annotation/Properties);
            Platform aplatform[];
            String as9[];
            String s1;
            int j;
            int i1;
            int j1;
            if (as == null)
            {
                as = (Platform)class1.getAnnotation(com/googlecode/javacpp/annotation/Platform);
                if (as == null)
                {
                    return;
                }
                aplatform = new Platform[1];
                aplatform[0] = as;
            } else
            {
                as1 = as.inherit();
                if (flag && as1 != null)
                {
                    int k = as1.length;
                    for (i = 0; i < k; i++)
                    {
                        load(((Class) (as1[i])), flag);
                    }

                }
                as1 = as.target();
                if (as1.length() > 0)
                {
                    addAll("parser.target", new String[] {
                        as1
                    });
                }
                as = as.value();
                aplatform = as;
                if (as == null)
                {
                    return;
                }
            }
            as5 = new String[0];
            as6 = new String[0];
            as7 = new String[0];
            as8 = new String[0];
            as4 = new String[0];
            as2 = new String[0];
            as1 = new String[0];
            as3 = new String[0];
            as = new String[0];
            as9 = new String[0];
            s = (new StringBuilder()).append("jni").append(class1.getSimpleName()).toString();
            i1 = aplatform.length;
            i = 0;
            class1 = as9;
_L1:
            Object obj;
            String as10[];
            String as11[];
            Class class2;
            Object obj1;
            String as12[];
            String as13[];
            String as14[];
            String as15[];
            String as16[];
            String s2;
            if (i < i1)
            {
                platform = aplatform[i];
                as17 = new String[2][];
                as17[0] = platform.value();
                as17[1] = platform.not();
                aflag = new boolean[2];
                aflag;
                aflag[0] = false;
                aflag[1] = false;
                j = 0;
                do
                {
label0:
                    {
                        if (j >= as17.length)
                        {
                            break label0;
                        }
                        as9 = as17[j];
                        j1 = as9.length;
                        int l = 0;
                        do
                        {
label1:
                            {
                                if (l < j1)
                                {
                                    s1 = as9[l];
                                    if (!platformName.startsWith(s1))
                                    {
                                        break label1;
                                    }
                                    aflag[j] = true;
                                }
                                j++;
                            }
                            if (true)
                            {
                                break;
                            }
                            l++;
                        } while (true);
                    }
                } while (true);
            } else
            {
                addAll("generator.define", as5);
                addAll("generator.include", as6);
                addAll("generator.cinclude", as7);
                addAll("compiler.includepath", as8);
                addAll("compiler.options", as4);
                addAll("compiler.linkpath", as2);
                addAll("compiler.link", as1);
                addAll("compiler.framework", as3);
                addAll("loader.preloadpath", as);
                addAll("loader.preload", class1);
                setProperty("loader.library", s);
                return;
            }
label2:
            {
                if (as17[0].length != 0)
                {
                    as12 = as7;
                    as13 = as5;
                    as14 = as3;
                    as15 = as6;
                    as16 = as8;
                    s2 = s;
                    obj = as1;
                    as10 = as2;
                    as11 = as4;
                    class2 = class1;
                    obj1 = as;
                    if (!aflag[0])
                    {
                        break label2;
                    }
                }
                if (as17[1].length != 0)
                {
                    as12 = as7;
                    as13 = as5;
                    as14 = as3;
                    as15 = as6;
                    as16 = as8;
                    s2 = s;
                    obj = as1;
                    as10 = as2;
                    as11 = as4;
                    class2 = class1;
                    obj1 = as;
                    if (aflag[1])
                    {
                        break label2;
                    }
                }
                if (platform.define().length > 0)
                {
                    as5 = platform.define();
                }
                if (platform.include().length > 0)
                {
                    as6 = platform.include();
                }
                if (platform.cinclude().length > 0)
                {
                    as7 = platform.cinclude();
                }
                if (platform.includepath().length > 0)
                {
                    as8 = platform.includepath();
                }
                if (platform.options().length > 0)
                {
                    as4 = platform.options();
                }
                if (platform.linkpath().length > 0)
                {
                    as2 = platform.linkpath();
                }
                if (platform.link().length > 0)
                {
                    as1 = platform.link();
                }
                if (platform.framework().length > 0)
                {
                    as3 = platform.framework();
                }
                if (platform.preloadpath().length > 0)
                {
                    as = platform.preloadpath();
                }
                if (platform.preload().length > 0)
                {
                    class1 = platform.preload();
                }
                as12 = as7;
                as13 = as5;
                as14 = as3;
                as15 = as6;
                as16 = as8;
                s2 = s;
                obj = as1;
                as10 = as2;
                as11 = as4;
                class2 = class1;
                obj1 = as;
                if (platform.library().length() > 0)
                {
                    s2 = platform.library();
                    obj1 = as;
                    class2 = class1;
                    as11 = as4;
                    as10 = as2;
                    obj = as1;
                    as16 = as8;
                    as15 = as6;
                    as14 = as3;
                    as13 = as5;
                    as12 = as7;
                }
            }
            i++;
            as7 = as12;
            as5 = as13;
            as3 = as14;
            as6 = as15;
            as8 = as16;
            s = s2;
            as1 = ((String []) (obj));
            as2 = as10;
            as4 = as11;
            class1 = class2;
            as = ((String []) (obj1));
              goto _L1
        }

        public String setProperty(String s, String s1)
        {
            LinkedList linkedlist = get(s);
            String s2;
            if (linkedlist.isEmpty())
            {
                s2 = null;
            } else
            {
                s2 = (String)linkedlist.get(0);
            }
            linkedlist.clear();
            addAll(s, new String[] {
                s1
            });
            return s2;
        }

        public ClassProperties()
        {
        }

        public ClassProperties(java.util.Properties properties)
        {
            platformName = properties.getProperty("platform.name");
            platformRoot = properties.getProperty("platform.root");
            pathSeparator = properties.getProperty("path.separator");
            if (platformRoot == null || platformRoot.length() == 0)
            {
                platformRoot = ".";
            }
            if (!platformRoot.endsWith(File.separator))
            {
                platformRoot = (new StringBuilder()).append(platformRoot).append(File.separator).toString();
            }
            properties = properties.entrySet().iterator();
            do
            {
                if (!properties.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)properties.next();
                String s = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (String)((java.util.Map.Entry) (obj)).getValue();
                if (obj != null && ((String) (obj)).length() != 0)
                {
                    if (s.equals("compiler.includepath") || s.equals("compiler.include") || s.equals("compiler.linkpath") || s.equals("compiler.link") || s.equals("compiler.framework"))
                    {
                        addAll(s, ((String) (obj)).split(pathSeparator));
                    } else
                    {
                        setProperty(s, ((String) (obj)));
                    }
                }
            } while (true);
        }
    }


    static boolean loadLibraries = true;
    static Map loadedLibraries = Collections.synchronizedMap(new HashMap());
    static WeakHashMap memberOffsets = new WeakHashMap();
    private static final String platformName;
    private static java.util.Properties platformProperties = null;
    static File tempDir = null;

    public Loader()
    {
    }

    public static File extractResource(Class class1, String s, File file, String s1, String s2)
        throws IOException
    {
        return extractResource(class1.getResource(s), file, s1, s2);
    }

    public static File extractResource(String s, File file, String s1, String s2)
        throws IOException
    {
        return extractResource(getCallerClass(2), s, file, s1, s2);
    }

    public static File extractResource(URL url, File file, String s, String s1)
        throws IOException
    {
        InputStream inputstream;
        Object obj;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (url != null)
        {
            inputstream = url.openStream();
        } else
        {
            inputstream = null;
        }
        if (inputstream == null)
        {
            return null;
        }
        obj = null;
        flag3 = false;
        flag1 = false;
        flag2 = false;
        if (s != null || s1 != null) goto _L2; else goto _L1
_L1:
        URL url1;
        boolean flag;
        s = file;
        if (file != null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        url1 = obj;
        flag = flag3;
        s = new File(System.getProperty("java.io.tmpdir"));
        url1 = obj;
        flag = flag3;
        url = new File(s, (new File(url.getPath())).getName());
        flag = url.exists();
        flag1 = flag;
_L5:
        url1 = url;
        flag = flag1;
        file = new FileOutputStream(url);
        url1 = url;
        flag = flag1;
        s = new byte[1024];
_L4:
        url1 = url;
        flag = flag1;
        int i = inputstream.read(s);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        url1 = url;
        flag = flag1;
        file.write(s, 0, i);
        if (true) goto _L4; else goto _L3
        url;
_L6:
        if (url1 != null && !flag)
        {
            url1.delete();
        }
        throw url;
_L2:
        url1 = obj;
        flag = flag3;
        url = File.createTempFile(s, s1, file);
        flag1 = flag2;
          goto _L5
_L3:
        url1 = url;
        flag = flag1;
        inputstream.close();
        url1 = url;
        flag = flag1;
        file.close();
        return url;
        file;
        url1 = url;
        url = file;
        flag = flag1;
          goto _L6
    }

    public static URL[] findLibrary(Class class1, ClassProperties classproperties, String s)
    {
        String as[] = s.split("@");
        String s2 = as[0];
        Object obj;
        if (as.length > 1)
        {
            obj = as[as.length - 1];
        } else
        {
            obj = "";
        }
        s = (String)loadedLibraries.get(s);
        if (s != null)
        {
            try
            {
                class1 = (new File(s)).toURI().toURL();
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                return new URL[0];
            }
            return (new URL[] {
                class1
            });
        }
        String s1 = (new StringBuilder()).append(classproperties.getProperty("platform.name")).append('/').toString();
        s2 = (new StringBuilder()).append(classproperties.getProperty("library.prefix", "")).append(s2).toString();
        String s3 = classproperties.getProperty("library.suffix", "");
        s = new String[3];
        s[0] = (new StringBuilder()).append(s2).append(s3).append(((String) (obj))).toString();
        s[1] = (new StringBuilder()).append(s2).append(((String) (obj))).append(s3).toString();
        s[2] = (new StringBuilder()).append(s2).append(s3).toString();
        obj = new LinkedList();
        ((LinkedList) (obj)).addAll(classproperties.get("loader.preloadpath"));
        ((LinkedList) (obj)).addAll(classproperties.get("compiler.linkpath"));
        classproperties = new URL[s.length * (((LinkedList) (obj)).size() + 1)];
        int k = 0;
        int i = 0;
        for (; class1 != null && k < s.length; k++)
        {
            URL url = class1.getResource((new StringBuilder()).append(s1).append(s[k]).toString());
            if (url != null)
            {
                int l = i + 1;
                classproperties[i] = url;
                i = l;
            }
        }

        boolean flag = false;
        k = i;
label0:
        for (int j = ((flag) ? 1 : 0); ((LinkedList) (obj)).size() > 0 && j < s.length; j++)
        {
            class1 = ((LinkedList) (obj)).iterator();
            do
            {
                if (!class1.hasNext())
                {
                    continue label0;
                }
                File file = new File((String)class1.next(), s[j]);
                if (file.exists())
                {
                    try
                    {
                        classproperties[k] = file.toURI().toURL();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Class class1)
                    {
                        throw new RuntimeException(class1);
                    }
                    k++;
                }
            } while (true);
        }

        return (URL[])Arrays.copyOf(classproperties, k);
    }

    public static Class getCallerClass(int i)
    {
        Class aclass[] = (new SecurityManager() {

            public Class[] getClassContext()
            {
                return super.getClassContext();
            }

        }).getClassContext();
        if (aclass == null) goto _L2; else goto _L1
_L1:
        for (int j = 0; j < aclass.length; j++)
        {
            if (aclass[j] == com/googlecode/javacpp/Loader)
            {
                return aclass[i + j];
            }
        }

          goto _L3
_L2:
        StackTraceElement astacktraceelement[];
        Class class1;
        int k;
        try
        {
            astacktraceelement = Thread.currentThread().getStackTrace();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            break; /* Loop/switch isn't completed */
        }
        k = 0;
_L4:
        if (k >= astacktraceelement.length)
        {
            break; /* Loop/switch isn't completed */
        }
        if (Class.forName(astacktraceelement[k].getClassName()) != com/googlecode/javacpp/Loader)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        class1 = Class.forName(astacktraceelement[i + k].getClassName());
        return class1;
        k++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        return null;
    }

    public static Class getEnclosingClass(Class class1)
    {
_L5:
        if (class1.getDeclaringClass() != null && !class1.isAnnotationPresent(com/googlecode/javacpp/annotation/Properties)) goto _L2; else goto _L1
_L1:
        return class1;
_L2:
        Platform platform;
        if (class1.isAnnotationPresent(com/googlecode/javacpp/annotation/Platform) && ((platform = (Platform)class1.getAnnotation(com/googlecode/javacpp/annotation/Platform)).define().length > 0 || platform.include().length > 0 || platform.cinclude().length > 0 || platform.includepath().length > 0 || platform.options().length > 0 || platform.linkpath().length > 0 || platform.link().length > 0 || platform.framework().length > 0 || platform.preloadpath().length > 0 || platform.preload().length > 0 || platform.library().length() > 0)) goto _L1; else goto _L3
_L3:
        class1 = class1.getDeclaringClass();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String getPlatformName()
    {
        return System.getProperty("com.googlecode.javacpp.platform.name", platformName);
    }

    public static File getTempDir()
    {
        if (tempDir != null) goto _L2; else goto _L1
_L1:
        File file;
        int i;
        file = new File(System.getProperty("java.io.tmpdir"));
        i = 0;
_L7:
        if (i >= 1000) goto _L2; else goto _L3
_L3:
        File file1 = new File(file, (new StringBuilder()).append("javacpp").append(System.nanoTime()).toString());
        if (!file1.mkdir()) goto _L5; else goto _L4
_L4:
        tempDir = file1;
        tempDir.deleteOnExit();
_L2:
        return tempDir;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static boolean isLoadLibraries()
    {
        return loadLibraries;
    }

    public static String load()
    {
        return load(getCallerClass(2));
    }

    public static String load(Class class1)
    {
        if (!loadLibraries || class1 == null)
        {
            return null;
        }
        class1 = getEnclosingClass(class1);
        Object obj;
        ClassProperties classproperties;
        Object obj1;
        try
        {
            obj = Class.forName(class1.getName(), true, class1.getClassLoader());
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            obj = new NoClassDefFoundError(class1.toString());
            ((Error) (obj)).initCause(class1);
            throw obj;
        }
        classproperties = loadProperties(((Class) (obj)), loadProperties(), true);
        obj1 = new LinkedList();
        ((LinkedList) (obj1)).addAll(classproperties.get("loader.preload"));
        ((LinkedList) (obj1)).addAll(classproperties.get("compiler.link"));
        class1 = null;
        for (obj1 = ((LinkedList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            String s1 = (String)((Iterator) (obj1)).next();
            try
            {
                loadLibrary(findLibrary(((Class) (obj)), classproperties, s1), s1);
            }
            // Misplaced declaration of an exception variable
            catch (Class class1) { }
        }

        try
        {
            String s = classproperties.getProperty("loader.library");
            obj = loadLibrary(findLibrary(((Class) (obj)), classproperties, s), s);
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            if (class1 != null)
            {
                unsatisfiedlinkerror.initCause(class1);
            }
            throw unsatisfiedlinkerror;
        }
        return ((String) (obj));
    }

    public static String loadLibrary(URL aurl[], String s)
    {
        Object obj = null;
        if (loadLibraries) goto _L2; else goto _L1
_L1:
        return ((String) (obj));
_L2:
        Object obj1;
        obj1 = (String)loadedLibraries.get(s);
        obj = obj1;
        if (obj1 != null) goto _L1; else goto _L3
_L3:
        Object obj2;
        File file;
        Object obj3;
        Object obj4;
        Object obj5;
        obj2 = null;
        obj = null;
        file = null;
        obj1 = null;
        obj4 = null;
        obj5 = null;
        obj3 = null;
        int j = aurl.length;
        int i = 0;
_L5:
        Object obj7;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_337;
        }
        obj7 = aurl[i];
        obj4 = obj3;
        obj2 = obj1;
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        Object obj6 = new File(((URL) (obj7)).toURI());
_L4:
        obj7 = obj3;
        if (obj6 == null)
        {
            break MISSING_BLOCK_LABEL_536;
        }
        obj4 = obj3;
        obj2 = obj1;
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        obj7 = obj3;
        if (!((File) (obj6)).exists())
        {
            break MISSING_BLOCK_LABEL_536;
        }
        obj4 = obj3;
        obj2 = obj1;
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        obj6 = ((File) (obj6)).getAbsolutePath();
        obj2 = obj6;
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        loadedLibraries.put(s, obj2);
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        System.load(((String) (obj2)));
        obj = obj2;
        if (obj1 != null)
        {
            obj = obj2;
            if (((File) (obj1)).exists())
            {
                ((File) (obj1)).deleteOnExit();
                return ((String) (obj2));
            }
        }
          goto _L1
        obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        obj4 = obj3;
        obj2 = obj1;
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        if (!((File) (obj1)).exists())
        {
            break MISSING_BLOCK_LABEL_269;
        }
        obj4 = obj3;
        obj2 = obj1;
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        ((File) (obj1)).deleteOnExit();
        obj4 = obj3;
        obj2 = obj1;
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        obj1 = extractResource(((URL) (obj7)), getTempDir(), null, null);
        obj6 = obj1;
          goto _L4
        obj3;
        obj4 = obj3;
        obj2 = obj1;
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        loadedLibraries.remove(s);
        obj7 = obj3;
        break MISSING_BLOCK_LABEL_536;
        obj4 = obj3;
        obj2 = obj1;
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        aurl = s.split("@")[0];
        obj4 = obj3;
        obj2 = obj1;
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        loadedLibraries.put(s, aurl);
        obj4 = obj3;
        obj2 = obj1;
        obj = obj1;
        obj5 = obj3;
        file = ((File) (obj1));
        System.loadLibrary(aurl);
        if (obj1 != null && ((File) (obj1)).exists())
        {
            ((File) (obj1)).deleteOnExit();
        }
        return aurl;
        aurl;
        obj = obj2;
        loadedLibraries.remove(s);
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_455;
        }
        obj = obj2;
        aurl.initCause(((Throwable) (obj4)));
        obj = obj2;
        throw aurl;
        aurl;
        if (obj != null && ((File) (obj)).exists())
        {
            ((File) (obj)).deleteOnExit();
        }
        throw aurl;
        aurl;
        obj = file;
        loadedLibraries.remove(s);
        if (obj5 == null)
        {
            break MISSING_BLOCK_LABEL_507;
        }
        obj = file;
        aurl.initCause(((Throwable) (obj5)));
        obj = file;
        s = new UnsatisfiedLinkError(aurl.toString());
        obj = file;
        s.initCause(aurl);
        obj = file;
        throw s;
        i++;
        obj3 = obj7;
          goto _L5
    }

    public static ClassProperties loadProperties(Class class1, java.util.Properties properties, boolean flag)
    {
        properties = new ClassProperties(properties);
        properties.load(class1, flag);
        return properties;
    }

    public static ClassProperties loadProperties(Class aclass[], java.util.Properties properties, boolean flag)
    {
        properties = new ClassProperties(properties);
        int j = aclass.length;
        for (int i = 0; i < j; i++)
        {
            properties.load(aclass[i], flag);
        }

        return properties;
    }

    public static java.util.Properties loadProperties()
    {
        Object obj = getPlatformName();
        if (platformProperties != null && ((String) (obj)).equals(platformProperties.getProperty("platform.name")))
        {
            return platformProperties;
        } else
        {
            obj = loadProperties(((String) (obj)));
            platformProperties = ((java.util.Properties) (obj));
            return ((java.util.Properties) (obj));
        }
    }

    public static java.util.Properties loadProperties(String s)
    {
        java.util.Properties properties;
        properties = new java.util.Properties();
        properties.put("platform.name", s);
        s = com/googlecode/javacpp/Loader.getResourceAsStream((new StringBuilder()).append("properties/").append(s).append(".properties").toString());
        properties.load(new InputStreamReader(s));
        return properties;
        NoSuchMethodError nosuchmethoderror;
        nosuchmethoderror;
        properties.load(s);
        return properties;
        s;
        s = com/googlecode/javacpp/Loader.getResourceAsStream("properties/generic.properties");
        properties.load(new InputStreamReader(s));
        return properties;
        nosuchmethoderror;
        try
        {
            properties.load(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new MissingResourceException((new StringBuilder()).append("Could not even get generic properties: ").append(s.getMessage()).toString(), com/googlecode/javacpp/Loader.getName(), "properties/generic.properties");
        }
        return properties;
    }

    public static void main(String args[])
    {
        File file = new File(System.getProperty("java.io.tmpdir"));
        args = new File(args[0]);
        if (!file.equals(args.getParentFile()) || !args.getName().startsWith("javacpp"))
        {
            return;
        }
        File afile[] = args.listFiles();
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            for (File file1 = afile[i]; file1.exists() && !file1.delete();)
            {
                try
                {
                    Thread.sleep(100L);
                }
                catch (InterruptedException interruptedexception) { }
            }

        }

        args.delete();
    }

    public static int offsetof(Class class1, String s)
    {
        return ((Integer)((HashMap)memberOffsets.get(class1)).get(s)).intValue();
    }

    static void putMemberOffset(Class class1, String s, int i)
    {
        com/googlecode/javacpp/Loader;
        JVM INSTR monitorenter ;
        HashMap hashmap1 = (HashMap)memberOffsets.get(class1);
        HashMap hashmap;
        hashmap = hashmap1;
        if (hashmap1 != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        WeakHashMap weakhashmap = memberOffsets;
        hashmap = new HashMap();
        weakhashmap.put(class1, hashmap);
        hashmap.put(s, Integer.valueOf(i));
        com/googlecode/javacpp/Loader;
        JVM INSTR monitorexit ;
        return;
        class1;
        throw class1;
    }

    static void putMemberOffset(String s, String s1, int i)
        throws ClassNotFoundException
    {
        putMemberOffset(Class.forName(s.replace('/', '.'), false, com/googlecode/javacpp/Loader.getClassLoader()).asSubclass(com/googlecode/javacpp/Pointer), s1, i);
    }

    public static int sizeof(Class class1)
    {
        return ((Integer)((HashMap)memberOffsets.get(class1)).get("sizeof")).intValue();
    }

    static 
    {
        String s = System.getProperty("java.vm.name").toLowerCase();
        String s1 = System.getProperty("os.name").toLowerCase();
        String s2 = System.getProperty("os.arch").toLowerCase();
        if (s.startsWith("dalvik") && s1.startsWith("linux"))
        {
            s = "android";
        } else
        if (s1.startsWith("mac os x"))
        {
            s = "macosx";
        } else
        {
            int i = s1.indexOf(' ');
            s = s1;
            if (i > 0)
            {
                s = s1.substring(0, i);
            }
        }
        if (s2.equals("i386") || s2.equals("i486") || s2.equals("i586") || s2.equals("i686"))
        {
            s1 = "x86";
        } else
        if (s2.equals("amd64") || s2.equals("x86-64") || s2.equals("x64"))
        {
            s1 = "x86_64";
        } else
        {
            s1 = s2;
            if (s2.startsWith("arm"))
            {
                s1 = "arm";
            }
        }
        platformName = (new StringBuilder()).append(s).append("-").append(s1).toString();
        if (getPlatformName().startsWith("windows"))
        {
            Runtime.getRuntime().addShutdownHook(new Thread() {

                public void run()
                {
                    if (Loader.tempDir == null)
                    {
                        return;
                    }
                    try
                    {
                        LinkedList linkedlist = new LinkedList();
                        linkedlist.add((new StringBuilder()).append(System.getProperty("java.home")).append("/bin/java").toString());
                        linkedlist.add("-classpath");
                        linkedlist.add(System.getProperty("java.class.path"));
                        linkedlist.add(com/googlecode/javacpp/Loader.getName());
                        linkedlist.add(Loader.tempDir.getAbsolutePath());
                        (new ProcessBuilder(linkedlist)).start();
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        throw new RuntimeException(ioexception);
                    }
                }

            });
        }
    }
}
