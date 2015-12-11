// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

final class aw
    implements Runnable
{

    private final av a;
    private final ao b;
    private final ah c;
    private final File d;
    private final char e[] = new char[4096];

    public aw(av av1, ao ao1, ah ah1)
    {
        a = av1;
        b = ao1;
        c = ah1;
        d = av.a(av.a(av1));
    }

    private JSONObject a(File file, StringBuilder stringbuilder)
    {
        FileReader filereader = new FileReader(file);
_L2:
        Object obj = filereader;
        int i = filereader.read(e);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = filereader;
        stringbuilder.append(e, 0, i);
        if (true) goto _L2; else goto _L1
        obj;
_L6:
        obj = filereader;
        bc.a((new StringBuilder("Failure converting contents of file: ")).append(file).append(" to json. Deleting it immediately").toString());
        obj = filereader;
        file.delete();
        stringbuilder.setLength(0);
        bc.a(filereader);
        return null;
_L1:
        obj = filereader;
        JSONObject jsonobject = az.a(stringbuilder.toString());
        stringbuilder.setLength(0);
        bc.a(filereader);
        return jsonobject;
        file;
        obj = null;
_L4:
        stringbuilder.setLength(0);
        bc.a(((java.io.Closeable) (obj)));
        throw file;
        file;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        filereader = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void run()
    {
        bc.a((new StringBuilder("Contents of folder = ")).append(d).append(", is = ").append(Arrays.toString(d.list())).toString());
        File afile1[] = d.listFiles(new FilenameFilter() {

            public final boolean accept(File file, String s)
            {
                return s.startsWith("crash-");
            }

        });
        File afile[] = afile1;
        if (afile1.length > 4)
        {
            Arrays.sort(afile1, new Comparator() {

                public final int compare(Object obj2, Object obj3)
                {
                    obj2 = (File)obj2;
                    obj3 = (File)obj3;
                    long l = ((File) (obj2)).lastModified();
                    long l1 = ((File) (obj3)).lastModified();
                    if (l == l1)
                    {
                        return 0;
                    }
                    return l <= l1 ? -1 : 1;
                }

            });
            afile = (File[])Arrays.copyOf(afile1, 4);
        }
        Object obj = new ArrayList();
        StringBuilder stringbuilder = new StringBuilder();
        int k = afile.length;
        for (int i = 0; i < k; i++)
        {
            Object obj1 = afile[i];
            bc.a((new StringBuilder("Read contents of file: ")).append(obj1).toString());
            obj1 = a(((File) (obj1)), stringbuilder);
            if (obj1 != null)
            {
                ((List) (obj)).add(obj1);
            }
        }

        if (((List) (obj)).isEmpty())
        {
            return;
        }
        bc.a((new StringBuilder("Deleting contents of crash reports folder: ")).append(d).toString());
        afile = d.listFiles();
        k = afile.length;
        for (int j = 0; j < k; j++)
        {
            afile[j].delete();
        }

        bc.a((new StringBuilder("Total number of reports sent: ")).append(((List) (obj)).size()).toString());
        for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); b.b(((JSONObject) (obj))))
        {
            obj = (JSONObject)iterator.next();
        }

        c.a();
    }
}
