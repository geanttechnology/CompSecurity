// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.info.TTieZhiInfo;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.EResType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

public class oo
{

    public static String a = "TTieZhiInfoManager";
    public static String b = "tiezhi_archive";
    public static String c = "KTieZHiRecentUseIDs";
    public static int d = 12;
    private static oo g = null;
    private static Semaphore i = new Semaphore(1);
    List e;
    List f;
    private tm h;

    private oo()
    {
        e = new ArrayList();
        f = new ArrayList();
        if (h == null)
        {
            h = new tm(PIPCameraApplication.b().c(), "tiezhi");
        }
        j();
        l();
        boolean flag = b();
        if (i())
        {
            flag = true;
        }
        if (flag)
        {
            a(new ArrayList(e));
        }
    }

    private TTieZhiInfo a(int i1, int j1, int k1)
    {
        TTieZhiInfo ttiezhiinfo = new TTieZhiInfo();
        ttiezhiinfo.resId = i1;
        String s = (new StringBuilder()).append("tzRes/tiezhi_style_").append(ttiezhiinfo.resId).toString();
        ttiezhiinfo.setResType(EResType.LOCAL);
        ttiezhiinfo.icon = (new StringBuilder()).append(s).append("/icon.png").toString();
        ttiezhiinfo.src = (new StringBuilder()).append(s).append("/src.png").toString();
        ttiezhiinfo.faceType = TTieZhiInfo.faceTypeFromInt(j1);
        ttiezhiinfo.faceAlign = TTieZhiInfo.faceAlignFromInt(k1);
        ttiezhiinfo.margin = 0.0F;
        ttiezhiinfo.position = com.fotoable.sketch.info.TTieZhiInfo.TIEZHIPOSITION.CENTER;
        return ttiezhiinfo;
    }

    public static oo a()
    {
        if (g == null)
        {
            g = new oo();
        }
        return g;
    }

    static tm a(oo oo1)
    {
        return oo1.h;
    }

    static Semaphore h()
    {
        return i;
    }

    private boolean i()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (e != null)
        {
            flag = flag1;
            if (e.size() > 0)
            {
                ArrayList arraylist = new ArrayList();
                for (int i1 = 0; i1 < e.size(); i1++)
                {
                    TTieZhiInfo ttiezhiinfo = (TTieZhiInfo)e.get(i1);
                    if (!a(ttiezhiinfo))
                    {
                        arraylist.add(ttiezhiinfo);
                    }
                }

                flag = flag1;
                if (arraylist.size() > 0)
                {
                    e.removeAll(arraylist);
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void j()
    {
        Object obj = h.a(b, new ahq());
        if (obj == null) goto _L2; else goto _L1
_L1:
        Gson gson;
        obj = (String)obj;
        gson = new Gson();
        e = (List)gson.fromJson(((String) (obj)), (new TypeToken() {

            final oo a;

            
            {
                a = oo.this;
                super();
            }
        }).getType());
        obj = new ArrayList();
        int i1 = 0;
_L10:
        if (i1 >= e.size()) goto _L4; else goto _L3
_L3:
        TTieZhiInfo ttiezhiinfo = (TTieZhiInfo)e.get(i1);
        if (ttiezhiinfo.icon == null || ttiezhiinfo.icon != null && ttiezhiinfo.icon.length() == 0)
        {
            ((List) (obj)).add(ttiezhiinfo);
        }
          goto _L5
_L4:
        if (obj == null) goto _L2; else goto _L6
_L6:
        if (((List) (obj)).size() <= 0) goto _L2; else goto _L7
_L7:
        i1 = 0;
_L8:
        if (i1 >= ((List) (obj)).size())
        {
            break; /* Loop/switch isn't completed */
        }
        e.remove(((List) (obj)).get(i1));
        i1++;
        if (true) goto _L8; else goto _L2
        Object obj1;
        obj1;
        h.a(b);
_L2:
        return;
        obj1;
        h.a(b);
        return;
_L5:
        i1++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private List k()
    {
        String s = lb.a(c, ",");
        if (!s.startsWith(","))
        {
            s = (new StringBuilder()).append(",").append(s).toString();
        }
        String as[] = s.split(",");
        ArrayList arraylist = new ArrayList();
        for (int i1 = 0; i1 < as.length; i1++)
        {
            Object obj = as[i1];
            if (((String) (obj)).length() <= 0 || Integer.valueOf(((String) (obj))).intValue() <= 0)
            {
                continue;
            }
            arraylist.add(Integer.valueOf(((String) (obj))));
            obj = c(Integer.valueOf(((String) (obj))).intValue());
            if (obj == null || !((TTieZhiInfo) (obj)).isGroupEnable)
            {
                continue;
            }
            for (int j1 = 0; j1 < ((TTieZhiInfo) (obj)).groupIds.size(); j1++)
            {
                if (!s.contains((new StringBuilder()).append(",").append(((TTieZhiInfo) (obj)).groupIds.get(j1)).append(",").toString()))
                {
                    arraylist.add(Integer.valueOf(((Integer)((TTieZhiInfo) (obj)).groupIds.get(j1)).intValue()));
                }
            }

        }

        return arraylist;
    }

    private void l()
    {
        TTieZhiInfo ttiezhiinfo = a(10722, 4, 0);
        String s = (new StringBuilder()).append(",").append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10179, 1, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10181, 4, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10529, 0, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11191, 2, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10350, 1, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11011, 0, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10274, 5, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11381, 0, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11032, 0, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10679, 0, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10176, 2, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10522, 0, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10324, 3, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10525, 0, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10171, 2, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10349, 1, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10367, 2, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11247, 1, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11012, 0, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11250, 5, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10217, 1, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10177, 6, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11010, 0, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11230, 0, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10280, 5, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11244, 1, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(10383, 2, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11018, 5, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        ttiezhiinfo = a(11043, 2, 0);
        s = (new StringBuilder()).append(s).append(ttiezhiinfo.resId).append(",").toString();
        f.add(ttiezhiinfo);
        if (!lb.a("KChangeRecentUseIds", false))
        {
            lb.b("KChangeRecentUseIds", true);
            String s1 = lb.a(c, ",");
            s = (new StringBuilder()).append(s1).append(s).toString();
            lb.b(c, s);
        }
    }

    public void a(int i1)
    {
        boolean flag = false;
        List list = k();
        if (list.size() > 0 && list.contains(Integer.valueOf(i1)))
        {
            list.remove(Integer.valueOf(i1));
        }
        String s;
        if (list.size() > 0)
        {
            list.add(0, Integer.valueOf(i1));
        } else
        {
            list.add(Integer.valueOf(i1));
        }
        s = ",";
        for (i1 = ((flag) ? 1 : 0); i1 < list.size(); i1++)
        {
            s = (new StringBuilder()).append(s).append(list.get(i1)).toString();
            s = (new StringBuilder()).append(s).append(",").toString();
        }

        lb.b(c, s);
    }

    public void a(List list)
    {
        op;
        JVM INSTR monitorenter ;
        (new op(this, list)).execute(new Void[0]);
        op;
        JVM INSTR monitorexit ;
        return;
        list;
        op;
        JVM INSTR monitorexit ;
        throw list;
    }

    public boolean a(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i1 = 0;
_L4:
        if (i1 >= f.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (ttiezhiinfo.resId == ((TTieZhiInfo)f.get(i1)).resId) goto _L1; else goto _L3
_L3:
        i1++;
          goto _L4
        if (!ttiezhiinfo.isGroupEnable && (ttiezhiinfo.src == null || ttiezhiinfo.src.length() <= 0) || ttiezhiinfo.icon == null || ttiezhiinfo.icon.length() <= 0) goto _L1; else goto _L5
_L5:
        return true;
    }

    public void b(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo == null)
        {
            return;
        }
        synchronized (e)
        {
            e.add(ttiezhiinfo);
        }
        a(new ArrayList(e));
        return;
        ttiezhiinfo;
        list;
        JVM INSTR monitorexit ;
        throw ttiezhiinfo;
    }

    public boolean b()
    {
        int i1;
        boolean flag;
        i1 = 0;
        flag = false;
_L2:
        TTieZhiInfo ttiezhiinfo;
        if (i1 >= e.size())
        {
            break; /* Loop/switch isn't completed */
        }
        ttiezhiinfo = (TTieZhiInfo)e.get(i1);
        if (a(ttiezhiinfo))
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ttiezhiinfo = ok.a(h.a(), ttiezhiinfo.resId);
        e.set(i1, ttiezhiinfo);
        flag = true;
_L3:
        i1++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L3
        exception;
        exception.printStackTrace();
_L1:
        return flag;
    }

    public boolean b(int i1)
    {
label0:
        {
            synchronized (e)
            {
                Iterator iterator = e.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                } while (((TTieZhiInfo)iterator.next()).resId != i1);
            }
            return true;
        }
        Iterator iterator1 = f.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_85;
            }
        } while (((TTieZhiInfo)iterator1.next()).resId != i1);
        list;
        JVM INSTR monitorexit ;
        return true;
        list;
        JVM INSTR monitorexit ;
        return false;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public TTieZhiInfo c(int i1)
    {
label0:
        {
            TTieZhiInfo ttiezhiinfo;
            synchronized (e)
            {
                Iterator iterator = e.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    ttiezhiinfo = (TTieZhiInfo)iterator.next();
                } while (ttiezhiinfo.resId != i1);
            }
            return ttiezhiinfo;
        }
        TTieZhiInfo ttiezhiinfo1;
        Iterator iterator1 = f.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_100;
            }
            ttiezhiinfo1 = (TTieZhiInfo)iterator1.next();
        } while (ttiezhiinfo1.resId != i1);
        list;
        JVM INSTR monitorexit ;
        return ttiezhiinfo1;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
        return null;
    }

    public tm c()
    {
        return h;
    }

    public List d()
    {
        List list = k();
        ArrayList arraylist = new ArrayList();
        if (list != null && list.size() > 0)
        {
            for (int i1 = 0; i1 < list.size(); i1++)
            {
                TTieZhiInfo ttiezhiinfo = c(((Integer)list.get(i1)).intValue());
                if (ttiezhiinfo != null)
                {
                    arraylist.add(ttiezhiinfo);
                }
            }

        }
        return arraylist;
    }

    public oq e()
    {
        List list = d();
        if (list.size() <= 0)
        {
            return null;
        } else
        {
            oq oq1 = new oq();
            oq1.a = 0;
            oq1.e = list;
            oq1.b = "\u5DF2\u4E0B\u8F7D";
            oq1.c = "\u5DF2\u4E0B\u8F09";
            oq1.d = "Downloaded";
            return oq1;
        }
    }

    public or f()
    {
        or or1 = new or();
        or1.a = TTieZhiInfo.kTZLocalTypeID;
        or1.b = "\u672C\u5730";
        or1.c = "\u672C\u5730";
        or1.d = "Local";
        or1.e = new ArrayList();
        oq oq1 = e();
        if (oq1 != null)
        {
            or1.e.add(oq1);
        }
        return or1;
    }

    public List g()
    {
        ArrayList arraylist = new ArrayList();
        or or1 = new or();
        or1.a = TTieZhiInfo.kTZRecommendTypeID;
        or1.b = "\u63A8\u8350";
        or1.c = "\u63A8\u85A6";
        or1.d = "Hot";
        or1.e = new ArrayList();
        arraylist.add(or1);
        or1 = new or();
        or1.a = TTieZhiInfo.kTZDecorationTypeID;
        or1.b = "\u88C5\u9970";
        or1.c = "\u88DD\u98FE";
        or1.d = "Decoration";
        or1.e = new ArrayList();
        arraylist.add(or1);
        or1 = new or();
        or1.a = TTieZhiInfo.kTZFacialTypeID;
        or1.b = "\u8868\u60C5";
        or1.c = "\u8868\u60C5";
        or1.d = "Emotions";
        or1.e = new ArrayList();
        arraylist.add(or1);
        or1 = new or();
        or1.a = TTieZhiInfo.kTZWordsTypeID;
        or1.b = "\u6587\u5B57";
        or1.c = "\u6587\u5B57";
        or1.d = "Words";
        or1.e = new ArrayList();
        arraylist.add(or1);
        arraylist.add(f());
        return arraylist;
    }

}
