// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.android.apptools;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.DatabaseFieldSimple;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrmLiteConfigUtil
{

    protected static final String RAW_DIR_NAME = "raw";
    protected static final String RESOURCE_DIR_NAME = "res";
    private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
    protected static int maxFindSourceLevel = 20;

    public OrmLiteConfigUtil()
    {
    }

    private static boolean classHasAnnotations(Class class1)
    {
_L5:
        if (class1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (class1.getAnnotation(com/j256/ormlite/table/DatabaseTable) == null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        Field afield[];
        int i;
        int j;
        try
        {
            afield = class1.getDeclaredFields();
        }
        catch (Throwable throwable)
        {
            System.err.println((new StringBuilder()).append("Could not load get delcared fields from: ").append(class1).toString());
            System.err.println((new StringBuilder()).append("     ").append(throwable).toString());
            return false;
        }
        j = afield.length;
        i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                Field field = afield[i];
                if (field.getAnnotation(com/j256/ormlite/field/DatabaseField) != null || field.getAnnotation(com/j256/ormlite/field/DatabaseFieldSimple) != null)
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        Class class2;
        try
        {
            class2 = class1.getSuperclass();
        }
        catch (Throwable throwable1)
        {
            System.err.println((new StringBuilder()).append("Could not get super class for: ").append(class1).toString());
            System.err.println((new StringBuilder()).append("     ").append(throwable1).toString());
            return false;
        }
        class1 = class2;
        if (true) goto _L5; else goto _L4
_L4:
        return false;
    }

    private static void findAnnotatedClasses(BufferedWriter bufferedwriter, File file, int i)
    {
        int j;
        int k;
        file = file.listFiles();
        k = file.length;
        j = 0;
_L2:
        File file1;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        file1 = file[j];
        if (!file1.isDirectory())
        {
            break; /* Loop/switch isn't completed */
        }
        if (i < maxFindSourceLevel)
        {
            findAnnotatedClasses(bufferedwriter, file1, i + 1);
        }
_L4:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!file1.getName().endsWith(".java")) goto _L4; else goto _L3
_L3:
        Object obj;
label0:
        {
            obj = getPackageOfClass(file1);
            if (obj != null)
            {
                break label0;
            }
            System.err.println((new StringBuilder()).append("Could not find package name for: ").append(file1).toString());
        }
          goto _L4
        String s = file1.getName();
        s = s.substring(0, s.length() - ".java".length());
        obj = (new StringBuilder()).append(((String) (obj))).append(".").append(s).toString();
        obj = Class.forName(((String) (obj)));
        if (classHasAnnotations(((Class) (obj))))
        {
            writeConfigForTable(bufferedwriter, ((Class) (obj)));
        }
          goto _L4
        Throwable throwable;
        throwable;
        System.err.println((new StringBuilder()).append("Could not load class file for: ").append(file1).toString());
        System.err.println((new StringBuilder()).append("     ").append(throwable).toString());
          goto _L4
    }

    protected static File findRawDir(File file)
    {
        for (int i = 0; file != null && i < 20; i++)
        {
            File file1 = findResRawDir(file);
            if (file1 != null)
            {
                return file1;
            }
            file = file.getParentFile();
        }

        return null;
    }

    private static File findResRawDir(File file)
    {
        file = file.listFiles();
        int j = file.length;
        for (int i = 0; i < j; i++)
        {
            File file1 = file[i];
            if (!file1.getName().equals("res") || !file1.isDirectory())
            {
                continue;
            }
            File afile[] = file1.listFiles(new FileFilter() {

                public boolean accept(File file2)
                {
                    return file2.getName().equals("raw") && file2.isDirectory();
                }

            });
            if (afile.length == 1)
            {
                return afile[0];
            }
        }

        return null;
    }

    private static String getPackageOfClass(File file)
    {
        file = new BufferedReader(new FileReader(file));
_L2:
        String s = file.readLine();
        if (s == null)
        {
            file.close();
            return null;
        }
        if (!s.contains("package")) goto _L2; else goto _L1
_L1:
        String as[] = s.split("[ \t;]");
        if (as.length <= 1 || !as[0].equals("package")) goto _L2; else goto _L3
_L3:
        String s1 = as[1];
        file.close();
        return s1;
        Exception exception;
        exception;
        file.close();
        throw exception;
    }

    public static void main(String args[])
    {
        if (args.length != 1)
        {
            throw new IllegalArgumentException("Main can take a single file-name argument.");
        } else
        {
            writeConfigFile(args[0]);
            return;
        }
    }

    public static void writeConfigFile(File file)
    {
        System.out.println((new StringBuilder()).append("Writing configurations to ").append(file.getAbsolutePath()).toString());
        file = new BufferedWriter(new FileWriter(file), 4096);
        writeHeader(file);
        findAnnotatedClasses(file, new File("."), 0);
        System.out.println("Done.");
        file.close();
        return;
        Exception exception;
        exception;
        file.close();
        throw exception;
    }

    public static void writeConfigFile(File file, Class aclass[])
    {
        System.out.println((new StringBuilder()).append("Writing configurations to ").append(file.getAbsolutePath()).toString());
        writeConfigFile(((OutputStream) (new FileOutputStream(file))), aclass);
    }

    public static void writeConfigFile(OutputStream outputstream, Class aclass[])
    {
        outputstream = new BufferedWriter(new OutputStreamWriter(outputstream), 4096);
        int j;
        writeHeader(outputstream);
        j = aclass.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        writeConfigForTable(outputstream, aclass[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        System.out.println("Done.");
        outputstream.close();
        return;
        aclass;
        outputstream.close();
        throw aclass;
    }

    public static void writeConfigFile(String s)
    {
        File file = findRawDir(new File("."));
        if (file == null)
        {
            System.err.println("Could not find raw directory");
            return;
        } else
        {
            writeConfigFile(new File(file, s));
            return;
        }
    }

    public static void writeConfigFile(String s, Class aclass[])
    {
        File file = findRawDir(new File("."));
        if (file == null)
        {
            System.err.println("Could not find raw directory");
            return;
        } else
        {
            writeConfigFile(new File(file, s), aclass);
            return;
        }
    }

    private static void writeConfigForTable(BufferedWriter bufferedwriter, Class class1)
    {
        String s = DatabaseTableConfig.extractTableName(class1);
        ArrayList arraylist = new ArrayList();
        for (Class class2 = class1; class2 != null; class2 = class2.getSuperclass())
        {
            Field afield[] = class2.getDeclaredFields();
            int j = afield.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = afield[i];
                obj = DatabaseFieldConfig.fromField(databaseType, s, ((Field) (obj)));
                if (obj != null)
                {
                    arraylist.add(obj);
                }
            }

        }

        if (arraylist.isEmpty())
        {
            System.out.println((new StringBuilder()).append("Skipping ").append(class1).append(" because no annotated fields found").toString());
            return;
        } else
        {
            DatabaseTableConfigLoader.write(bufferedwriter, new DatabaseTableConfig(class1, s, arraylist));
            bufferedwriter.append("#################################");
            bufferedwriter.newLine();
            System.out.println((new StringBuilder()).append("Wrote config for ").append(class1).toString());
            return;
        }
    }

    private static void writeHeader(BufferedWriter bufferedwriter)
    {
        bufferedwriter.append('#');
        bufferedwriter.newLine();
        bufferedwriter.append("# generated on ").append((new SimpleDateFormat("yyyy/MM/dd hh:mm:ss")).format(new Date()));
        bufferedwriter.newLine();
        bufferedwriter.append('#');
        bufferedwriter.newLine();
    }

}
