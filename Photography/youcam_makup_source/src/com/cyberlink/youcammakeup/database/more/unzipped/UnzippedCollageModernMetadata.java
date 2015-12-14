// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.unzipped;

import android.content.ContentValues;
import java.io.File;
import java.util.HashMap;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.unzipped:
//            a

public class UnzippedCollageModernMetadata extends a
{

    static String a = "UnzippedCollageModernMetadata";
    protected final HashMap c = new HashMap();

    public UnzippedCollageModernMetadata(String s, int i, int j)
    {
        super(new File(s), i, j);
        c.put(FileType.a, new File(b(), "thumbnail.png"));
        c.put(FileType.b, new File(b(), "layout.xml"));
        c.put(FileType.c, new File(b(), "thumbnail2.png"));
    }

    public void a(ContentValues contentvalues)
    {
    }


    private class FileType extends Enum
    {

        public static final FileType a;
        public static final FileType b;
        public static final FileType c;
        private static final FileType d[];

        public static FileType valueOf(String s)
        {
            return (FileType)Enum.valueOf(com/cyberlink/youcammakeup/database/more/unzipped/UnzippedCollageModernMetadata$FileType, s);
        }

        public static FileType[] values()
        {
            return (FileType[])d.clone();
        }

        static 
        {
            a = new FileType("THUMBNAIL", 0);
            b = new FileType("LAYOUT_XML", 1);
            c = new FileType("THUMBNAIL_2", 2);
            d = (new FileType[] {
                a, b, c
            });
        }

        private FileType(String s, int i)
        {
            super(s, i);
        }
    }

}
