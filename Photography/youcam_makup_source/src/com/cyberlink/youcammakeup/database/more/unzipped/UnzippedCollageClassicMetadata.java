// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.unzipped;

import android.content.ContentValues;
import java.io.File;
import java.util.HashMap;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.unzipped:
//            a

public class UnzippedCollageClassicMetadata extends a
{

    private static String c = "UnzippedCollageClassicMetadata";
    protected final HashMap a = new HashMap();

    public UnzippedCollageClassicMetadata(String s, int i, int j)
    {
        super(new File(s), i, j);
        a.put(FileType.a, new File(b(), "thumbnail.png"));
        a.put(FileType.b, new File(b(), "layout.xml"));
        a.put(FileType.c, new File(b(), "cover_image.jpg"));
        a.put(FileType.d, new File(b(), "cover_mask.png"));
        a.put(FileType.e, new File(b(), "global_mask.png"));
        a.put(FileType.f, new File(b(), "thumbnail2.png"));
    }

    public void a(ContentValues contentvalues)
    {
    }


    private class FileType extends Enum
    {

        public static final FileType a;
        public static final FileType b;
        public static final FileType c;
        public static final FileType d;
        public static final FileType e;
        public static final FileType f;
        private static final FileType g[];

        public static FileType valueOf(String s)
        {
            return (FileType)Enum.valueOf(com/cyberlink/youcammakeup/database/more/unzipped/UnzippedCollageClassicMetadata$FileType, s);
        }

        public static FileType[] values()
        {
            return (FileType[])g.clone();
        }

        static 
        {
            a = new FileType("THUMBNAIL", 0);
            b = new FileType("LAYOUT_XML", 1);
            c = new FileType("LAYOUT_PICTURE", 2);
            d = new FileType("COVER_MASK", 3);
            e = new FileType("GLOBAL_MASK", 4);
            f = new FileType("THUMBNAIL_2", 5);
            g = (new FileType[] {
                a, b, c, d, e, f
            });
        }

        private FileType(String s, int i)
        {
            super(s, i);
        }
    }

}
