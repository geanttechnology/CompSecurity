// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.photoselector.uicomp.DialogChooseDirectory;
import java.io.File;
import java.util.Comparator;

public class ast
    implements Comparator
{

    final DialogChooseDirectory a;

    public ast(DialogChooseDirectory dialogchoosedirectory)
    {
        a = dialogchoosedirectory;
        super();
    }

    public int a(File file, File file1)
    {
        return file.getName().toLowerCase().compareTo(file1.getName().toLowerCase());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((File)obj, (File)obj1);
    }
}
