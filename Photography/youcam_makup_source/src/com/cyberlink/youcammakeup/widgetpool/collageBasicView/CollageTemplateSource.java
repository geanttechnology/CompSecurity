// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.collageBasicView;

import android.os.Environment;
import com.cyberlink.youcammakeup.database.more.l.b;
import com.cyberlink.youcammakeup.database.more.l.c;
import com.cyberlink.youcammakeup.database.more.l.d;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.CollageLayoutType;
import com.cyberlink.youcammakeup.database.more.types.CollageType;
import com.cyberlink.youcammakeup.database.more.types.OrderType;
import com.cyberlink.youcammakeup.database.more.types.a;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.j;
import com.pf.common.utility.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.collageBasicView:
//            a, b, c, d

public class CollageTemplateSource
{

    public HashMap a;
    public HashMap b;
    private b c;
    private d d;

    private CollageTemplateSource()
    {
        a = new HashMap();
        b = new HashMap();
        a.clear();
        b.clear();
        c = h.c();
        d = h.d();
        ItemDirection aitemdirection[] = new ItemDirection[2];
        aitemdirection[0] = com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.b;
        aitemdirection[1] = com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.a;
        HashMap hashmap = new HashMap();
        a.put(com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.a, hashmap);
        long l2 = -1L;
        int i2 = aitemdirection.length;
        for (int i = 0; i < i2; i++)
        {
            ItemDirection itemdirection = aitemdirection[i];
            for (int i1 = 1; i1 <= 6; i1++)
            {
                List list = (List)((HashMap)a.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.a)).get(Integer.valueOf(i1));
                Object obj = list;
                if (list == null)
                {
                    obj = new ArrayList();
                    hashmap.put(Integer.valueOf(i1), obj);
                }
                String s2 = itemdirection.name().toLowerCase();
                String as[] = b(com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.a, itemdirection, i1);
                int j2 = as.length;
                int k1 = 0;
                while (k1 < j2) 
                {
                    String s9 = as[k1];
                    String s5 = String.format("assets://collage/magazine/%s/", new Object[] {
                        s2
                    });
                    String s7 = String.format("%s.xml", new Object[] {
                        s9
                    });
                    String s;
                    String s10;
                    if (itemdirection == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.a)
                    {
                        s = "_l";
                    } else
                    {
                        s = "";
                    }
                    s10 = String.format("tiny/%s%s.png", new Object[] {
                        s9, s
                    });
                    if (itemdirection == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.a)
                    {
                        s = "_l";
                    } else
                    {
                        s = "";
                    }
                    s = String.format("small/%s%s.png", new Object[] {
                        s9, s
                    });
                    m.e("CollageTemplateSource", (new StringBuilder()).append("folderPath = ").append(s5).toString());
                    m.e("CollageTemplateSource", (new StringBuilder()).append("xmlPath = ").append(s7).toString());
                    m.e("CollageTemplateSource", (new StringBuilder()).append("tinyPreview = ").append(s10).toString());
                    m.e("CollageTemplateSource", (new StringBuilder()).append("smallPreview = ").append(s).toString());
                    ((List) (obj)).add(new com.cyberlink.youcammakeup.widgetpool.collageBasicView.a(s5, s7, s10, s, com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.a, itemdirection, l2, 1.0D, false));
                    k1++;
                    l2--;
                }
            }

        }

        hashmap = new HashMap();
        a.put(com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.b, hashmap);
        i2 = aitemdirection.length;
        for (int k = 0; k < i2; k++)
        {
            ItemDirection itemdirection1 = aitemdirection[k];
            for (int j1 = 1; j1 <= 6; j1++)
            {
                List list1 = (List)((HashMap)a.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.b)).get(Integer.valueOf(j1));
                Object obj1 = list1;
                if (list1 == null)
                {
                    obj1 = new ArrayList();
                    hashmap.put(Integer.valueOf(j1), obj1);
                }
                String s3 = itemdirection1.name().toLowerCase();
                int k2 = a(com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.b, itemdirection1, j1);
                int l1 = 1;
                while (l1 <= k2) 
                {
                    String s4 = String.format("assets://collage/basic/%s/", new Object[] {
                        s3
                    });
                    String s6 = String.format("%d-%d.xml", new Object[] {
                        Integer.valueOf(j1), Integer.valueOf(l1)
                    });
                    String s1;
                    String s8;
                    if (itemdirection1 == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.a)
                    {
                        s1 = "_l";
                    } else
                    {
                        s1 = "";
                    }
                    s8 = String.format("tiny/%d_%d%s.png", new Object[] {
                        Integer.valueOf(j1), Integer.valueOf(l1), s1
                    });
                    if (itemdirection1 == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.a)
                    {
                        s1 = "_l";
                    } else
                    {
                        s1 = "";
                    }
                    s1 = String.format("small/%d_%d%s.png", new Object[] {
                        Integer.valueOf(j1), Integer.valueOf(l1), s1
                    });
                    m.e("CollageTemplateSource", (new StringBuilder()).append("folderPath = ").append(s4).toString());
                    m.e("CollageTemplateSource", (new StringBuilder()).append("xmlPath = ").append(s6).toString());
                    m.e("CollageTemplateSource", (new StringBuilder()).append("tinyPreview = ").append(s8).toString());
                    m.e("CollageTemplateSource", (new StringBuilder()).append("smallPreview = ").append(s1).toString());
                    ((List) (obj1)).add(new com.cyberlink.youcammakeup.widgetpool.collageBasicView.a(s4, s6, s8, s1, com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.b, itemdirection1, l2, 1.0D, false));
                    l1++;
                    l2--;
                }
            }

        }

        b.put(com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.a, new HashMap());
        b.put(com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.b, new HashMap());
        for (int l = 1; l <= 6; l++)
        {
            ((HashMap)b.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.a)).put(Integer.valueOf(l), new ArrayList());
            ((HashMap)b.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.b)).put(Integer.valueOf(l), new ArrayList());
        }

        if (NetworkManager.e())
        {
            c();
        }
    }


    public static CollageTemplateSource a()
    {
        return com.cyberlink.youcammakeup.widgetpool.collageBasicView.b.a();
    }

    public int a(ItemType itemtype, ItemDirection itemdirection, int i)
    {
        if (itemtype == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.b)
        {
            if (itemdirection == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.a)
            {
                return com.cyberlink.youcammakeup.widgetpool.collageBasicView.c.a[i];
            }
            if (itemdirection == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.b)
            {
                return com.cyberlink.youcammakeup.widgetpool.collageBasicView.c.b[i];
            }
        } else
        if (itemtype == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.a)
        {
            if (itemdirection == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.a)
            {
                return com.cyberlink.youcammakeup.widgetpool.collageBasicView.c.c[i];
            }
            if (itemdirection == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.b)
            {
                return com.cyberlink.youcammakeup.widgetpool.collageBasicView.c.d[i];
            }
        }
        return 0;
    }

    public boolean a(long l)
    {
        boolean flag = false;
        c c1 = d.a(l);
        if (c1 != null)
        {
            flag = c1.f();
        }
        return flag;
    }

    public void b()
    {
        for (int i = 1; i <= 6; i++)
        {
            ItemType aitemtype[] = ItemType.values();
            int i1 = aitemtype.length;
            for (int l = 0; l < i1; l++)
            {
                ItemType itemtype = aitemtype[l];
                ((List)((HashMap)b.get(itemtype)).get(Integer.valueOf(i))).clear();
            }

        }

        a a1 = new a(OrderType.a, CategoryType.h, CollageType.c, CollageLayoutType.a);
        int k = 0;
        while (k < c.a(a1)) 
        {
            Object obj = c.a(a1, Integer.valueOf(k).intValue());
            if (((com.cyberlink.youcammakeup.database.more.l.a) (obj)).f().getTimeInMillis() >= System.currentTimeMillis())
            {
                com.cyberlink.youcammakeup.database.more.unzipped.a a2 = (com.cyberlink.youcammakeup.database.more.unzipped.a)((com.cyberlink.youcammakeup.database.more.l.a) (obj)).c();
                long l1 = ((com.cyberlink.youcammakeup.database.more.l.a) (obj)).a();
                String s = ((com.cyberlink.youcammakeup.database.more.l.a) (obj)).c().b().getAbsolutePath().concat(File.separator);
                double d1;
                if (((com.cyberlink.youcammakeup.database.more.l.a) (obj)).g() == CollageLayoutType.a)
                {
                    obj = com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.a;
                } else
                {
                    obj = com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.b;
                }
                d1 = a2.c();
                ((List)((HashMap)b.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.b)).get(Integer.valueOf(a2.a()))).add(new com.cyberlink.youcammakeup.widgetpool.collageBasicView.a(s, "layout.xml", "thumbnail.png", "thumbnail2.png", com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.b, ((ItemDirection) (obj)), l1, d1, a(l1)));
            }
            k++;
        }
    }

    public String[] b(ItemType itemtype, ItemDirection itemdirection, int i)
    {
        if (itemtype == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.b)
        {
            if (itemdirection == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.a)
            {
                return com.cyberlink.youcammakeup.widgetpool.collageBasicView.d.a;
            }
            if (itemdirection == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.b)
            {
                return com.cyberlink.youcammakeup.widgetpool.collageBasicView.d.a;
            }
        } else
        if (itemtype == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemType.a)
        {
            if (itemdirection == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.a)
            {
                return com.cyberlink.youcammakeup.widgetpool.collageBasicView.d.a;
            }
            if (itemdirection == com.cyberlink.youcammakeup.widgetpool.collageBasicView.ItemDirection.b)
            {
                return com.cyberlink.youcammakeup.widgetpool.collageBasicView.d.b[i];
            }
        }
        return com.cyberlink.youcammakeup.widgetpool.collageBasicView.d.a;
    }

    public void c()
    {
        File file;
        long l1;
        ArrayList arraylist = (ArrayList)c.a();
        if (arraylist.size() > 0)
        {
            l1 = ((Long)arraylist.get(arraylist.size() - 1)).longValue();
        } else
        {
            l1 = 0L;
        }
        file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/cyberlink/ymk/collage/").toString());
        if (file.exists()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        String as[];
        int i;
        int l;
        as = new String[2];
        as[0] = CollageType.a.name();
        as[1] = CollageType.b.name();
        l = as.length;
        i = 0;
        obj = Long.valueOf(l1);
_L6:
        if (i >= l) goto _L1; else goto _L3
_L3:
        String s = as[i];
        if ((new File((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).append(s).toString())).exists()) goto _L5; else goto _L4
_L4:
        Long long1 = ((Long) (obj));
_L8:
        i++;
        obj = long1;
          goto _L6
_L5:
        File file1;
        file1 = new File((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).append(s).toString());
        long1 = ((Long) (obj));
        if (!file1.exists()) goto _L8; else goto _L7
_L7:
        File afile[];
        afile = file1.listFiles();
        long1 = ((Long) (obj));
        if (afile == null) goto _L8; else goto _L9
_L9:
        int k;
        int i1;
        i1 = afile.length;
        k = 0;
_L11:
        long1 = ((Long) (obj));
        if (k >= i1) goto _L8; else goto _L10
_L10:
        File file2;
        JSONObject jsonobject;
        file2 = afile[k];
        jsonobject = new JSONObject();
        long1 = ((Long) (obj));
        obj = Long.valueOf(((Long) (obj)).longValue() + 1L);
        long1 = ((Long) (obj));
        jsonobject.put("tid", obj);
        long1 = ((Long) (obj));
        jsonobject.put("guid", "testGUID");
        long1 = ((Long) (obj));
        jsonobject.put("type", CategoryType.h.name());
        long1 = ((Long) (obj));
        jsonobject.put("name", file2.getName());
        long1 = ((Long) (obj));
        jsonobject.put("collagetype", s);
        long1 = ((Long) (obj));
        jsonobject.put("collagelayout", CollageLayoutType.a.name());
        long1 = ((Long) (obj));
        jsonobject.put("thumbnail", "THUMBNAIL_URL");
        long1 = ((Long) (obj));
        jsonobject.put("downloadurl", "DOWNLOAD_URL");
        long1 = ((Long) (obj));
        jsonobject.put("downloadchecksum", "DOWNLOAD_CHECKSUM");
        long1 = ((Long) (obj));
        jsonobject.put("publishdate", "1000/01/01");
        long1 = ((Long) (obj));
        jsonobject.put("expireddate", "9999/01/01");
        long1 = ((Long) (obj));
        try
        {
            j.a(new c(jsonobject), file2);
        }
        catch (Exception exception)
        {
            m.b("[CollageTemplateSource] generateTestContent()", "occur an error", exception);
            exception = long1;
        }
        k++;
          goto _L11
    }

    private class ItemDirection extends Enum
    {

        public static final ItemDirection a;
        public static final ItemDirection b;
        private static final ItemDirection c[];

        public static ItemDirection valueOf(String s)
        {
            return (ItemDirection)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/collageBasicView/CollageTemplateSource$ItemDirection, s);
        }

        public static ItemDirection[] values()
        {
            return (ItemDirection[])c.clone();
        }

        static 
        {
            a = new ItemDirection("LANDSCAPE", 0);
            b = new ItemDirection("PORTRAIT", 1);
            c = (new ItemDirection[] {
                a, b
            });
        }

        private ItemDirection(String s, int i)
        {
            super(s, i);
        }
    }


    private class ItemType extends Enum
    {

        public static final ItemType a;
        public static final ItemType b;
        private static final ItemType c[];

        public static ItemType valueOf(String s)
        {
            return (ItemType)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/collageBasicView/CollageTemplateSource$ItemType, s);
        }

        public static ItemType[] values()
        {
            return (ItemType[])c.clone();
        }

        static 
        {
            a = new ItemType("MAGAZINE", 0);
            b = new ItemType("CLASSIC", 1);
            c = (new ItemType[] {
                a, b
            });
        }

        private ItemType(String s, int i)
        {
            super(s, i);
        }
    }

}
