// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

// Referenced classes of package com.googlecode.javacpp:
//            Loader, Generator, Parser

public class Builder
{
    public static class ClassScanner
    {

        private Collection classes;
        private UserClassLoader loader;

        public void addClass(String s)
        {
            if (s != null)
            {
                String s1 = s;
                if (s.endsWith(".class"))
                {
                    s1 = s.substring(0, s.length() - 6);
                }
                try
                {
                    s = Class.forName(s1, false, loader);
                    if (!classes.contains(s))
                    {
                        classes.add(s);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    System.err.println((new StringBuilder()).append("Warning: Could not find class ").append(s1).append(": ").append(s).toString());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    System.err.println((new StringBuilder()).append("Warning: Could not load class ").append(s1).append(": ").append(s).toString());
                    return;
                }
            }
        }

        public void addClassOrPackage(String s)
            throws IOException
        {
            if (s == null)
            {
                return;
            }
            s = s.replace('/', '.');
            if (s.endsWith(".**"))
            {
                addPackage(s.substring(0, s.length() - 3), true);
                return;
            }
            if (s.endsWith(".*"))
            {
                addPackage(s.substring(0, s.length() - 2), false);
                return;
            } else
            {
                addClass(s);
                return;
            }
        }

        public void addMatchingDir(String s, File file, String s1, boolean flag)
        {
            File afile[] = file.listFiles();
            Arrays.sort(afile);
            int j = afile.length;
            int i = 0;
            while (i < j) 
            {
                File file1 = afile[i];
                if (s == null)
                {
                    file = file1.getName();
                } else
                {
                    file = (new StringBuilder()).append(s).append(file1.getName()).toString();
                }
                if (file1.isDirectory())
                {
                    addMatchingDir((new StringBuilder()).append(file).append("/").toString(), file1, s1, flag);
                } else
                {
                    addMatchingFile(file, s1, flag);
                }
                i++;
            }
        }

        public void addMatchingFile(String s, String s1, boolean flag)
        {
            if (s != null && s.endsWith(".class") && (s1 == null || flag && s.startsWith(s1) || s.regionMatches(0, s1, 0, Math.max(s.lastIndexOf('/'), s1.lastIndexOf('/')))))
            {
                addClass(s.replace('/', '.'));
            }
        }

        public void addPackage(String s, boolean flag)
            throws IOException
        {
            String as[] = loader.getPaths();
            String s1;
            int i;
            int j;
            int k;
            if (s == null)
            {
                s1 = null;
            } else
            {
                s1 = (new StringBuilder()).append(s.replace('.', '/')).append("/").toString();
            }
            j = classes.size();
            k = as.length;
            i = 0;
            while (i < k) 
            {
                File file = new File(as[i]);
                if (file.isDirectory())
                {
                    addMatchingDir(null, file, s1, flag);
                } else
                {
                    JarInputStream jarinputstream = new JarInputStream(new FileInputStream(file));
                    for (ZipEntry zipentry = jarinputstream.getNextEntry(); zipentry != null; zipentry = jarinputstream.getNextEntry())
                    {
                        addMatchingFile(zipentry.getName(), s1, flag);
                        jarinputstream.closeEntry();
                    }

                    jarinputstream.close();
                }
                i++;
            }
            if (classes.size() == 0 && s == null)
            {
                System.err.println("Warning: No classes found in the unnamed package");
                Builder.printHelp();
            } else
            if (j == classes.size() && s != null)
            {
                System.err.println((new StringBuilder()).append("Warning: No classes found in package ").append(s).toString());
                return;
            }
        }

        public UserClassLoader getClassLoader()
        {
            return loader;
        }

        public Collection getClasses()
        {
            return classes;
        }

        public ClassScanner(Collection collection, UserClassLoader userclassloader)
        {
            classes = collection;
            loader = userclassloader;
        }
    }

    public static class Piper extends Thread
    {

        InputStream is;
        OutputStream os;

        public void run()
        {
            byte abyte0[] = new byte[1024];
_L1:
            int i = is.read(abyte0);
            if (i == -1)
            {
                break MISSING_BLOCK_LABEL_62;
            }
            os.write(abyte0, 0, i);
              goto _L1
            IOException ioexception;
            ioexception;
            System.err.println((new StringBuilder()).append("Could not pipe from the InputStream to the OutputStream: ").append(ioexception.getMessage()).toString());
        }

        public Piper(InputStream inputstream, OutputStream outputstream)
        {
            is = inputstream;
            os = outputstream;
        }
    }

    public static class UserClassLoader extends URLClassLoader
    {

        private LinkedList paths;

        public transient void addPaths(String as[])
        {
            if (as != null)
            {
                int j = as.length;
                int i = 0;
                while (i < j) 
                {
                    String s = as[i];
                    File file = new File(s);
                    if (file.exists())
                    {
                        paths.add(s);
                        try
                        {
                            addURL(file.toURI().toURL());
                        }
                        // Misplaced declaration of an exception variable
                        catch (String as[])
                        {
                            throw new RuntimeException(as);
                        }
                    }
                    i++;
                }
            }
        }

        protected Class findClass(String s)
            throws ClassNotFoundException
        {
            if (paths.isEmpty())
            {
                addPaths(new String[] {
                    System.getProperty("user.dir")
                });
            }
            return super.findClass(s);
        }

        public String[] getPaths()
        {
            if (paths.isEmpty())
            {
                addPaths(new String[] {
                    System.getProperty("user.dir")
                });
            }
            return (String[])paths.toArray(new String[paths.size()]);
        }

        public UserClassLoader()
        {
            super(new URL[0]);
            paths = new LinkedList();
        }

        public UserClassLoader(ClassLoader classloader)
        {
            super(new URL[0], classloader);
            paths = new LinkedList();
        }
    }


    ClassScanner classScanner;
    boolean compile;
    Collection compilerOptions;
    boolean copyLibs;
    Map environmentVariables;
    boolean header;
    String jarPrefix;
    File outputDirectory;
    String outputName;
    Properties properties;

    public Builder()
    {
        outputDirectory = null;
        outputName = null;
        jarPrefix = null;
        compile = true;
        header = false;
        copyLibs = false;
        properties = null;
        classScanner = null;
        environmentVariables = null;
        compilerOptions = null;
        Loader.loadLibraries = false;
        properties = Loader.loadProperties();
        classScanner = new ClassScanner(new LinkedList(), new UserClassLoader(Thread.currentThread().getContextClassLoader()));
        compilerOptions = new LinkedList();
    }

    public static transient void createJar(File file, String as[], File afile[])
        throws IOException
    {
        System.out.println((new StringBuilder()).append("Creating JAR file: ").append(file).toString());
        JarOutputStream jaroutputstream = new JarOutputStream(new FileOutputStream(file));
        int i1 = afile.length;
        for (int i = 0; i < i1; i++)
        {
            File file1 = afile[i];
            file = file1.getPath();
            Object obj = file;
            if (as != null)
            {
                String as1[] = new String[as.length];
                for (int j = 0; j < as.length; j++)
                {
                    obj = (new File(as[j])).getCanonicalPath();
                    if (file.startsWith(((String) (obj))))
                    {
                        as1[j] = file.substring(((String) (obj)).length() + 1);
                    }
                }

                int k = 0;
                do
                {
                    obj = file;
                    if (k >= as1.length)
                    {
                        break;
                    }
                    obj = file;
                    if (as1[k] != null)
                    {
                        obj = file;
                        if (as1[k].length() < file.length())
                        {
                            obj = as1[k];
                        }
                    }
                    k++;
                    file = ((File) (obj));
                } while (true);
            }
            file = new ZipEntry(((String) (obj)).replace(File.separatorChar, '/'));
            file.setTime(file1.lastModified());
            jaroutputstream.putNextEntry(file);
            file = new FileInputStream(file1);
            byte abyte0[] = new byte[1024];
            do
            {
                int l = file.read(abyte0);
                if (l == -1)
                {
                    break;
                }
                jaroutputstream.write(abyte0, 0, l);
            } while (true);
            file.close();
            jaroutputstream.closeEntry();
        }

        jaroutputstream.close();
    }

    public static void includeJavaPaths(Loader.ClassProperties classproperties, boolean flag)
    {
        Object obj;
        String s1;
        String as[];
        String as1[];
        FilenameFilter filenamefilter;
        s1 = Loader.getPlatformName();
        obj = (new StringBuilder()).append(classproperties.getProperty("compiler.link.prefix", "")).append("jvm").append(classproperties.getProperty("compiler.link.suffix", "")).toString();
        String s = (new StringBuilder()).append(classproperties.getProperty("library.prefix", "")).append("jvm").append(classproperties.getProperty("library.suffix", "")).toString();
        as = new String[2];
        as1 = new String[2];
        filenamefilter = new FilenameFilter(as, ((String) (obj)), as1, s) {

            final String val$jnipath[];
            final String val$jvmlib;
            final String val$jvmlink;
            final String val$jvmpath[];

            public boolean accept(File file1, String s3)
            {
                if ((new File(file1, "jni.h")).exists())
                {
                    jnipath[0] = file1.getAbsolutePath();
                }
                if ((new File(file1, "jni_md.h")).exists())
                {
                    jnipath[1] = file1.getAbsolutePath();
                }
                if ((new File(file1, jvmlink)).exists())
                {
                    jvmpath[0] = file1.getAbsolutePath();
                }
                if ((new File(file1, jvmlib)).exists())
                {
                    jvmpath[1] = file1.getAbsolutePath();
                }
                return (new File(file1, s3)).isDirectory();
            }

            
            {
                jnipath = as;
                jvmlink = s;
                jvmpath = as1;
                jvmlib = s1;
                super();
            }
        };
        obj = (new File(System.getProperty("java.home"))).getParentFile();
        File file = ((File) (obj)).getCanonicalFile();
        obj = file;
_L10:
        LinkedList linkedlist = new LinkedList(Arrays.asList(((File) (obj)).listFiles(filenamefilter)));
_L4:
        if (linkedlist.isEmpty()) goto _L2; else goto _L1
_L1:
        String s2;
        File afile[];
        int i;
        int j;
        obj = (File)linkedlist.pop();
        s2 = ((File) (obj)).getPath();
        afile = ((File) (obj)).listFiles(filenamefilter);
        j = afile.length;
        i = 0;
_L5:
        if (i >= j) goto _L4; else goto _L3
_L3:
        obj = afile[i];
        file = ((File) (obj)).getCanonicalFile();
        obj = file;
_L11:
        if (!s2.startsWith(((File) (obj)).getPath()))
        {
            linkedlist.add(obj);
        }
        i++;
          goto _L5
          goto _L4
_L2:
        if (as[0] == null || !as[0].equals(as[1])) goto _L7; else goto _L6
_L6:
        as[1] = null;
_L9:
        if (as1[0] != null && as1[0].equals(as1[1]))
        {
            as1[1] = null;
        }
        classproperties.addAll("compiler.includepath", as);
        if (s1.equals(classproperties.getProperty("platform.name", s1)))
        {
            if (flag)
            {
                classproperties.get("compiler.link").add(0, "jvm");
                classproperties.addAll("compiler.linkpath", as1);
            }
            if (s1.startsWith("macosx"))
            {
                classproperties.addAll("compiler.framework", new String[] {
                    "JavaVM"
                });
            }
        }
        return;
_L7:
        if (as[0] == null && (new File("/System/Library/Frameworks/JavaVM.framework/Headers/")).isDirectory())
        {
            as[0] = "/System/Library/Frameworks/JavaVM.framework/Headers/";
        }
        if (true) goto _L9; else goto _L8
_L8:
        IOException ioexception;
        ioexception;
          goto _L10
        ioexception;
          goto _L11
    }

    public static void main(String args[])
        throws Exception
    {
        boolean flag = false;
        Builder builder = new Builder();
        int i = 0;
        while (i < args.length) 
        {
            if ("-help".equals(args[i]) || "--help".equals(args[i]))
            {
                printHelp();
                System.exit(0);
            } else
            if ("-classpath".equals(args[i]) || "-cp".equals(args[i]) || "-lib".equals(args[i]))
            {
                i++;
                builder.classPaths(args[i]);
            } else
            if ("-d".equals(args[i]))
            {
                i++;
                builder.outputDirectory(args[i]);
            } else
            if ("-o".equals(args[i]))
            {
                i++;
                builder.outputName(args[i]);
            } else
            if ("-cpp".equals(args[i]) || "-nocompile".equals(args[i]))
            {
                builder.compile(false);
            } else
            if ("-header".equals(args[i]))
            {
                builder.header(true);
            } else
            if ("-copylibs".equals(args[i]))
            {
                builder.copyLibs(true);
            } else
            if ("-jarprefix".equals(args[i]))
            {
                i++;
                builder.jarPrefix(args[i]);
            } else
            if ("-properties".equals(args[i]))
            {
                i++;
                builder.properties(args[i]);
            } else
            if ("-propertyfile".equals(args[i]))
            {
                i++;
                builder.propertyFile(args[i]);
            } else
            if (args[i].startsWith("-D"))
            {
                builder.property(args[i]);
            } else
            if ("-Xcompiler".equals(args[i]))
            {
                i++;
                builder.compilerOptions(new String[] {
                    args[i]
                });
            } else
            if (args[i].startsWith("-"))
            {
                System.err.println((new StringBuilder()).append("Error: Invalid option \"").append(args[i]).append("\"").toString());
                printHelp();
                System.exit(1);
            } else
            {
                builder.classesOrPackages(new String[] {
                    args[i]
                });
                flag = true;
            }
            i++;
        }
        if (!flag)
        {
            builder.classesOrPackages((String[])null);
        }
        builder.build();
    }

    public static void printHelp()
    {
        String s1 = com/googlecode/javacpp/Builder.getPackage().getImplementationVersion();
        String s = s1;
        if (s1 == null)
        {
            s = "unknown";
        }
        System.out.println((new StringBuilder()).append("JavaCPP version ").append(s).append("\n").append("Copyright (C) 2011-2013 Samuel Audet <samuel.audet@gmail.com>\n").append("Project site: http://code.google.com/p/javacpp/\n\n").append("Licensed under the GNU General Public License version 2 (GPLv2) with Classpath exception.\n").append("Please refer to LICENSE.txt or http://www.gnu.org/licenses/ for details.").toString());
        System.out.println();
        System.out.println("Usage: java -jar javacpp.jar [options] [class or package (suffixed with .* or .**)]");
        System.out.println();
        System.out.println("where options include:");
        System.out.println();
        System.out.println("    -classpath <path>      Load user classes from path");
        System.out.println("    -d <directory>         Output all generated files to directory");
        System.out.println("    -o <name>              Output everything in a file named after given name");
        System.out.println("    -nocompile             Do not compile or delete the generated source files");
        System.out.println("    -header                Generate header file with declarations of callbacks functions");
        System.out.println("    -copylibs              Copy to output directory dependent libraries (link and preload)");
        System.out.println("    -jarprefix <prefix>    Also create a JAR file named \"<prefix>-<platform.name>.jar\"");
        System.out.println("    -properties <resource> Load all properties from resource");
        System.out.println("    -propertyfile <file>   Load all properties from file");
        System.out.println("    -D<property>=<value>   Set property to value");
        System.out.println("    -Xcompiler <option>    Pass option directly to compiler");
        System.out.println();
    }

    public File[] build()
        throws IOException, InterruptedException, Parser.Exception
    {
        Object obj;
        if (classScanner.getClasses().isEmpty())
        {
            obj = null;
        } else
        {
            LinkedList linkedlist3 = new LinkedList();
            LinkedHashMap linkedhashmap = new LinkedHashMap();
            Iterator iterator = classScanner.getClasses().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Class class1 = (Class)iterator.next();
                if (Loader.getEnclosingClass(class1) == class1)
                {
                    obj = Loader.loadProperties(class1, properties, false);
                    String s = ((Loader.ClassProperties) (obj)).getProperty("parser.target");
                    if (s != null && !class1.getName().equals(s))
                    {
                        obj = parse(class1);
                        if (obj != null)
                        {
                            linkedlist3.add(obj);
                        }
                    } else
                    {
                        if (outputName != null)
                        {
                            obj = outputName;
                        } else
                        {
                            obj = ((Loader.ClassProperties) (obj)).getProperty("loader.library", "");
                        }
                        if (((String) (obj)).length() != 0)
                        {
                            LinkedList linkedlist2 = (LinkedList)linkedhashmap.get(obj);
                            LinkedList linkedlist = linkedlist2;
                            if (linkedlist2 == null)
                            {
                                linkedlist = new LinkedList();
                                linkedhashmap.put(obj, linkedlist);
                            }
                            linkedlist.add(class1);
                        }
                    }
                }
            } while (true);
            obj = linkedhashmap.keySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Object obj1 = (String)((Iterator) (obj)).next();
                LinkedList linkedlist1 = (LinkedList)linkedhashmap.get(obj1);
                Class aclass[] = (Class[])linkedlist1.toArray(new Class[linkedlist1.size()]);
                obj1 = generateAndCompile(aclass, ((String) (obj1)));
                if (obj1 != null)
                {
                    linkedlist3.add(obj1);
                    if (copyLibs)
                    {
                        Loader.ClassProperties classproperties1 = Loader.loadProperties(aclass, properties, false);
                        Object obj2 = new LinkedList();
                        ((LinkedList) (obj2)).addAll(classproperties1.get("loader.preload"));
                        ((LinkedList) (obj2)).addAll(classproperties1.get("compiler.link"));
                        Loader.ClassProperties classproperties = Loader.loadProperties(aclass, properties, true);
                        obj1 = ((File) (obj1)).getParentFile();
                        obj2 = ((LinkedList) (obj2)).iterator();
                        do
                        {
                            if (!((Iterator) (obj2)).hasNext())
                            {
                                break;
                            }
                            URL aurl[] = Loader.findLibrary(null, classproperties, (String)((Iterator) (obj2)).next());
                            Object obj3;
                            Object obj4;
                            FileOutputStream fileoutputstream;
                            byte abyte0[];
                            try
                            {
                                obj4 = new File(aurl[0].toURI());
                            }
                            // Misplaced declaration of an exception variable
                            catch (Object obj3)
                            {
                                continue;
                            }
                            obj3 = new File(((File) (obj1)), ((File) (obj4)).getName());
                            if (!((File) (obj4)).exists() || linkedlist3.contains(obj3))
                            {
                                continue;
                            }
                            System.out.println((new StringBuilder()).append("Copying library file: ").append(obj4).toString());
                            obj4 = new FileInputStream(((File) (obj4)));
                            fileoutputstream = new FileOutputStream(((File) (obj3)));
                            abyte0 = new byte[1024];
                            do
                            {
                                int i = ((FileInputStream) (obj4)).read(abyte0);
                                if (i == -1)
                                {
                                    break;
                                }
                                fileoutputstream.write(abyte0, 0, i);
                            } while (true);
                            fileoutputstream.close();
                            ((FileInputStream) (obj4)).close();
                            linkedlist3.add(obj3);
                        } while (true);
                    }
                }
            } while (true);
            File afile[] = (File[])linkedlist3.toArray(new File[linkedlist3.size()]);
            obj = afile;
            if (jarPrefix != null)
            {
                obj = afile;
                if (afile.length > 0)
                {
                    File file1 = new File((new StringBuilder()).append(jarPrefix).append("-").append(properties.get("platform.name")).append(".jar").toString());
                    File file = file1.getParentFile();
                    if (file != null && !file.exists())
                    {
                        file.mkdir();
                    }
                    String as[];
                    if (outputDirectory == null)
                    {
                        as = classScanner.getClassLoader().getPaths();
                    } else
                    {
                        as = null;
                    }
                    createJar(file1, as, afile);
                    return afile;
                }
            }
        }
        return ((File []) (obj));
    }

    public Builder classPaths(String s)
    {
        if (s == null)
        {
            s = null;
        } else
        {
            s = s.split(File.pathSeparator);
        }
        classPaths(((String []) (s)));
        return this;
    }

    public transient Builder classPaths(String as[])
    {
        classScanner.getClassLoader().addPaths(as);
        return this;
    }

    public transient Builder classesOrPackages(String as[])
        throws IOException
    {
        if (as == null)
        {
            classScanner.addPackage(null, true);
        } else
        {
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String s = as[i];
                classScanner.addClassOrPackage(s);
                i++;
            }
        }
        return this;
    }

    public int compile(String s, String s1, Loader.ClassProperties classproperties)
        throws IOException, InterruptedException
    {
        LinkedList linkedlist = new LinkedList();
        includeJavaPaths(classproperties, header);
        String s2 = Loader.getPlatformName();
        linkedlist.add(classproperties.getProperty("compiler.path"));
        Object obj = classproperties.getProperty("compiler.sysroot.prefix", "");
        Iterator iterator = classproperties.get("compiler.sysroot").iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s6 = (String)iterator.next();
            if ((new File(s6)).isDirectory())
            {
                if (((String) (obj)).endsWith(" "))
                {
                    linkedlist.add(((String) (obj)).trim());
                    linkedlist.add(s6);
                } else
                {
                    linkedlist.add((new StringBuilder()).append(((String) (obj))).append(s6).toString());
                }
            }
        } while (true);
        obj = classproperties.getProperty("compiler.includepath.prefix", "");
        iterator = classproperties.get("compiler.includepath").iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s7 = (String)iterator.next();
            if ((new File(s7)).isDirectory())
            {
                if (((String) (obj)).endsWith(" "))
                {
                    linkedlist.add(((String) (obj)).trim());
                    linkedlist.add(s7);
                } else
                {
                    linkedlist.add((new StringBuilder()).append(((String) (obj))).append(s7).toString());
                }
            }
        } while (true);
        linkedlist.add(s);
        s = classproperties.get("compiler.options");
        if (s.isEmpty())
        {
            s.add("default");
        }
        s = s.iterator();
        do
        {
            if (!s.hasNext())
            {
                break;
            }
            obj = (String)s.next();
            if (obj != null && ((String) (obj)).length() != 0)
            {
                String s4 = (new StringBuilder()).append("compiler.options.").append(((String) (obj))).toString();
                String s8 = classproperties.getProperty(s4);
                if (s8 != null && s8.length() > 0)
                {
                    linkedlist.addAll(Arrays.asList(s8.split(" ")));
                } else
                if (!"default".equals(obj))
                {
                    System.err.println((new StringBuilder()).append("Warning: Could not get the property named \"").append(s4).append("\"").toString());
                }
            }
        } while (true);
        linkedlist.addAll(compilerOptions);
        s = classproperties.getProperty("compiler.output.prefix");
        if (s != null && s.length() > 0)
        {
            linkedlist.addAll(Arrays.asList(s.split(" ")));
        }
        if (s == null || s.length() == 0 || s.endsWith(" "))
        {
            linkedlist.add(s1);
        } else
        {
            linkedlist.add((new StringBuilder()).append((String)linkedlist.removeLast()).append(s1).toString());
        }
        s = classproperties.getProperty("compiler.linkpath.prefix", "");
        s1 = classproperties.getProperty("compiler.linkpath.prefix2");
        obj = classproperties.get("compiler.linkpath").iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s5 = (String)((Iterator) (obj)).next();
            if ((new File(s5)).isDirectory())
            {
                if (s.endsWith(" "))
                {
                    linkedlist.add(s.trim());
                    linkedlist.add(s5);
                } else
                {
                    linkedlist.add((new StringBuilder()).append(s).append(s5).toString());
                }
                if (s1 != null)
                {
                    if (s1.endsWith(" "))
                    {
                        linkedlist.add(s1.trim());
                        linkedlist.add(s5);
                    } else
                    {
                        linkedlist.add((new StringBuilder()).append(s1).append(s5).toString());
                    }
                }
            }
        } while (true);
        s1 = classproperties.getProperty("compiler.link.prefix", "");
        obj = classproperties.getProperty("compiler.link.suffix", "");
        int i = linkedlist.size();
        for (Iterator iterator1 = classproperties.get("compiler.link").iterator(); iterator1.hasNext();)
        {
            s = ((String)iterator1.next()).split("@");
            if (s.length == 3 && s[1].length() == 0)
            {
                s = (new StringBuilder()).append(s[0]).append(s[2]).toString();
            } else
            {
                s = s[0];
            }
            if (s1.endsWith(" ") && ((String) (obj)).startsWith(" "))
            {
                linkedlist.add(i, s1.trim());
                linkedlist.add(i + 1, s);
                linkedlist.add(i + 2, ((String) (obj)).trim());
            } else
            if (s1.endsWith(" "))
            {
                linkedlist.add(i, s1.trim());
                linkedlist.add(i + 1, (new StringBuilder()).append(s).append(((String) (obj))).toString());
            } else
            if (((String) (obj)).startsWith(" "))
            {
                linkedlist.add(i, (new StringBuilder()).append(s1).append(s).toString());
                linkedlist.add(i + 1, ((String) (obj)).trim());
            } else
            {
                linkedlist.add(i, (new StringBuilder()).append(s1).append(s).append(((String) (obj))).toString());
            }
        }

        s = classproperties.getProperty("compiler.framework.prefix", "");
        s1 = classproperties.getProperty("compiler.framework.suffix", "");
        for (classproperties = classproperties.get("compiler.framework").iterator(); classproperties.hasNext();)
        {
            String s3 = (String)classproperties.next();
            if (s.endsWith(" ") && s1.startsWith(" "))
            {
                linkedlist.add(s.trim());
                linkedlist.add(s3);
                linkedlist.add(s1.trim());
            } else
            if (s.endsWith(" "))
            {
                linkedlist.add(s.trim());
                linkedlist.add((new StringBuilder()).append(s3).append(s1).toString());
            } else
            if (s1.startsWith(" "))
            {
                linkedlist.add((new StringBuilder()).append(s).append(s3).toString());
                linkedlist.add(s1.trim());
            } else
            {
                linkedlist.add((new StringBuilder()).append(s).append(s3).append(s1).toString());
            }
        }

        boolean flag1 = s2.startsWith("windows");
        s1 = linkedlist.iterator();
        while (s1.hasNext()) 
        {
            classproperties = (String)s1.next();
            boolean flag;
            if (classproperties.indexOf(" ") > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                PrintStream printstream = System.out;
                if (flag1)
                {
                    s = "\"";
                } else
                {
                    s = "'";
                }
                printstream.print(s);
            }
            System.out.print(classproperties);
            if (flag)
            {
                classproperties = System.out;
                if (flag1)
                {
                    s = "\"";
                } else
                {
                    s = "'";
                }
                classproperties.print(s);
            }
            System.out.print(" ");
        }
        System.out.println();
        s = new ProcessBuilder(linkedlist);
        if (environmentVariables != null)
        {
            s.environment().putAll(environmentVariables);
        }
        s = s.start();
        (new Piper(s.getErrorStream(), System.err)).start();
        (new Piper(s.getInputStream(), System.out)).start();
        return s.waitFor();
    }

    public Builder compile(boolean flag)
    {
        compile = flag;
        return this;
    }

    public transient Builder compilerOptions(String as[])
    {
        if (as != null)
        {
            compilerOptions.addAll(Arrays.asList(as));
        }
        return this;
    }

    public Builder copyLibs(boolean flag)
    {
        copyLibs = flag;
        return this;
    }

    public Builder environmentVariables(Map map)
    {
        environmentVariables = map;
        return this;
    }

    public File generateAndCompile(Class aclass[], String s)
        throws IOException, InterruptedException
    {
        Loader.ClassProperties classproperties = Loader.loadProperties(aclass, properties, true);
        Object obj1 = classproperties.getProperty("platform.name");
        String s2 = classproperties.getProperty("source.suffix", ".cpp");
        String s1 = (new StringBuilder()).append(classproperties.getProperty("library.prefix", "")).append(s).append(classproperties.getProperty("library.suffix", "")).toString();
        Object obj;
        Generator generator;
        if (outputDirectory == null)
        {
            String as[];
            String s3;
            int i;
            int k;
            try
            {
                obj = (new File(aclass[0].getResource((new StringBuilder()).append('/').append(aclass[0].getName().replace('.', '/')).append(".class").toString()).toURI())).getParentFile();
                obj1 = new File(((File) (obj)), ((String) (obj1)));
                obj = (new StringBuilder()).append(((File) (obj)).getPath()).append(File.separator).append(s).toString();
            }
            // Misplaced declaration of an exception variable
            catch (Class aclass[])
            {
                throw new RuntimeException(aclass);
            }
            s = ((String) (obj1));
        } else
        {
            obj = outputDirectory;
            obj1 = (new StringBuilder()).append(((File) (obj)).getPath()).append(File.separator).append(s).toString();
            s = ((String) (obj));
            obj = obj1;
        }
        if (!s.exists())
        {
            s.mkdirs();
        }
        generator = new Generator(classproperties);
        s2 = (new StringBuilder()).append(((String) (obj))).append(s2).toString();
        if (header)
        {
            obj = (new StringBuilder()).append(((String) (obj))).append(".h").toString();
        } else
        {
            obj = null;
        }
        obj1 = System.getProperty("java.class.path");
        as = classScanner.getClassLoader().getPaths();
        k = as.length;
        for (i = 0; i < k; i++)
        {
            s3 = as[i];
            obj1 = (new StringBuilder()).append(((String) (obj1))).append(File.pathSeparator).append(s3).toString();
        }

        System.out.println((new StringBuilder()).append("Generating source file: ").append(s2).toString());
        if (generator.generate(s2, ((String) (obj)), ((String) (obj1)), aclass))
        {
            generator.close();
            if (compile)
            {
                aclass = (new StringBuilder()).append(s.getPath()).append(File.separator).append(s1).toString();
                System.out.println((new StringBuilder()).append("Compiling library file: ").append(aclass).toString());
                int j = compile(s2, aclass, classproperties);
                if (j == 0)
                {
                    (new File(s2)).delete();
                    return new File(aclass);
                } else
                {
                    System.exit(j);
                    return null;
                }
            } else
            {
                return new File(s2);
            }
        } else
        {
            System.out.println((new StringBuilder()).append("Source file not generated: ").append(s2).toString());
            return null;
        }
    }

    public Builder header(boolean flag)
    {
        header = flag;
        return this;
    }

    public Builder jarPrefix(String s)
    {
        jarPrefix = s;
        return this;
    }

    public Builder outputDirectory(File file)
    {
        outputDirectory = file;
        return this;
    }

    public Builder outputDirectory(String s)
    {
        if (s == null)
        {
            s = null;
        } else
        {
            s = new File(s);
        }
        outputDirectory(((File) (s)));
        return this;
    }

    public Builder outputName(String s)
    {
        outputName = s;
        return this;
    }

    public File parse(Class class1)
        throws IOException, Parser.Exception
    {
        Parser.InfoMap infomap = new Parser.InfoMap();
        try
        {
            Object obj = class1.newInstance();
            if (obj instanceof Parser.InfoMapper)
            {
                ((Parser.InfoMapper)obj).map(infomap);
            }
        }
        catch (InstantiationException instantiationexception) { }
        catch (IllegalAccessException illegalaccessexception) { }
        return (new Parser(properties, infomap)).parse(outputDirectory, class1);
    }

    public Builder properties(String s)
    {
        if (s == null)
        {
            s = null;
        } else
        {
            s = Loader.loadProperties(s);
        }
        properties(((Properties) (s)));
        return this;
    }

    public Builder properties(Properties properties1)
    {
        if (properties1 != null)
        {
            properties.putAll(properties1);
        }
        return this;
    }

    public Builder property(String s)
    {
        int j = s.indexOf('=');
        int i = j;
        if (j < 0)
        {
            i = s.indexOf(':');
        }
        property(s.substring(2, i), s.substring(i + 1));
        return this;
    }

    public Builder property(String s, String s1)
    {
        if (s.length() > 0 && s1.length() > 0)
        {
            properties.put(s, s1);
        }
        return this;
    }

    public Builder propertyFile(File file)
        throws IOException
    {
        if (file == null)
        {
            return this;
        }
        file = new FileInputStream(file);
        properties = new Properties(properties);
        try
        {
            properties.load(new InputStreamReader(file));
        }
        catch (NoSuchMethodError nosuchmethoderror)
        {
            properties.load(file);
        }
        file.close();
        return this;
    }

    public Builder propertyFile(String s)
        throws IOException
    {
        if (s == null)
        {
            s = null;
        } else
        {
            s = new File(s);
        }
        propertyFile(((File) (s)));
        return this;
    }
}
