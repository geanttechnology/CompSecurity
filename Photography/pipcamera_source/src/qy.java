// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.compose.CollageType;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class qy
{

    private ArrayList a;
    private tu b;
    private qz c;

    public qy()
    {
        a = new ArrayList(0);
    }

    public int a(CollageType collagetype, int i)
    {
        for (i = 0; i < a.size(); i++)
        {
            collagetype = (TPhotoComposeInfo)a.get(i);
        }

        return 0;
    }

    public InstaMagType a(TPhotoComposeInfo tphotocomposeinfo)
    {
        InstaMagType instamagtype1 = InstaMagType.RECT_LIB_SIZE_TYPE;
        InstaMagType instamagtype;
        if (tphotocomposeinfo.width == 320F && tphotocomposeinfo.height == 480F)
        {
            instamagtype = InstaMagType.RECT_LIB_SIZE_TYPE;
        } else
        {
            if (tphotocomposeinfo.width == 320F && tphotocomposeinfo.height == 320F)
            {
                return InstaMagType.SQ_LIB_SIZE_TYPE;
            }
            instamagtype = instamagtype1;
            if (tphotocomposeinfo.width == 320F)
            {
                instamagtype = instamagtype1;
                if (tphotocomposeinfo.height == 214F)
                {
                    return InstaMagType.LANDSCAPE_LIB_SIZE_TYPE;
                }
            }
        }
        return instamagtype;
    }

    public List a(CollageType collagetype, InstaMagType instamagtype)
    {
        ArrayList arraylist = new ArrayList(0);
        if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            for (int i = 0; i < a.size(); i++)
            {
                instamagtype = (TPhotoComposeInfo)a.get(i);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 480F && collagetype == instamagtype.getInfoCollageType())
                {
                    arraylist.add(instamagtype);
                }
            }

        } else
        if (instamagtype == InstaMagType.SQ_LIB_SIZE_TYPE)
        {
            for (int j = 0; j < a.size(); j++)
            {
                instamagtype = (TPhotoComposeInfo)a.get(j);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 320F && collagetype == instamagtype.getInfoCollageType())
                {
                    arraylist.add(instamagtype);
                }
            }

        } else
        if (instamagtype == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
        {
            for (int k = 0; k < a.size(); k++)
            {
                instamagtype = (TPhotoComposeInfo)a.get(k);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 214F && collagetype == instamagtype.getInfoCollageType())
                {
                    arraylist.add(instamagtype);
                }
            }

        } else
        if (instamagtype == InstaMagType.LINK_LIB_SIZE_TYPE)
        {
            for (int l = 0; l < a.size(); l++)
            {
                instamagtype = (TPhotoComposeInfo)a.get(l);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 960F && collagetype == instamagtype.getInfoCollageType())
                {
                    arraylist.add(instamagtype);
                }
            }

        } else
        {
            for (int i1 = 0; i1 < a.size(); i1++)
            {
                instamagtype = (TPhotoComposeInfo)a.get(i1);
                if (collagetype == instamagtype.getInfoCollageType())
                {
                    arraylist.add(instamagtype);
                }
            }

            Collections.sort(arraylist, new Comparator() {

                final qy a;

                public int compare(Object obj, Object obj1)
                {
                    boolean flag = false;
                    byte byte0 = flag;
                    if (obj instanceof TPhotoComposeInfo)
                    {
                        byte0 = flag;
                        if (obj1 instanceof TPhotoComposeInfo)
                        {
                            obj = (TPhotoComposeInfo)obj;
                            obj1 = (TPhotoComposeInfo)obj1;
                            if (((TPhotoComposeInfo) (obj)).height > ((TPhotoComposeInfo) (obj1)).height)
                            {
                                byte0 = -1;
                            } else
                            {
                                byte0 = flag;
                                if (((TPhotoComposeInfo) (obj)).height < ((TPhotoComposeInfo) (obj1)).height)
                                {
                                    return 1;
                                }
                            }
                        }
                    }
                    return byte0;
                }

            
            {
                a = qy.this;
                super();
            }
            });
            return arraylist;
        }
        return arraylist;
    }

    public List a(CollageType collagetype, InstaMagType instamagtype, int i)
    {
        if (i == -1)
        {
            return a(collagetype, instamagtype);
        }
        if (i == 0)
        {
            return a(instamagtype);
        }
        instamagtype = a(collagetype, instamagtype);
        Iterator iterator = instamagtype.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
            if (tphotocomposeinfo.imageCount != i || collagetype != tphotocomposeinfo.getInfoCollageType())
            {
                iterator.remove();
            }
        } while (true);
        Collections.sort(instamagtype, new Comparator() {

            final qy a;

            public int compare(Object obj, Object obj1)
            {
                boolean flag = false;
                byte byte0 = flag;
                if (obj instanceof TPhotoComposeInfo)
                {
                    byte0 = flag;
                    if (obj1 instanceof TPhotoComposeInfo)
                    {
                        obj = (TPhotoComposeInfo)obj;
                        obj1 = (TPhotoComposeInfo)obj1;
                        if (((TPhotoComposeInfo) (obj)).isShouldFirst() && !((TPhotoComposeInfo) (obj1)).isShouldFirst())
                        {
                            byte0 = -1;
                        } else
                        {
                            byte0 = flag;
                            if (!((TPhotoComposeInfo) (obj)).isShouldFirst())
                            {
                                byte0 = flag;
                                if (((TPhotoComposeInfo) (obj1)).isShouldFirst())
                                {
                                    return 1;
                                }
                            }
                        }
                    }
                }
                return byte0;
            }

            
            {
                a = qy.this;
                super();
            }
        });
        return instamagtype;
    }

    public List a(InstaMagType instamagtype)
    {
        List list = c();
        if (list != null)
        {
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (a((TPhotoComposeInfo)iterator.next()) != instamagtype)
                {
                    iterator.remove();
                }
            } while (true);
        }
        return list;
    }

    public void a()
    {
        Object obj = EOnlineResType.MAG_MASK_INFO;
        a.clear();
        b = ts.a(((EOnlineResType) (obj)));
        obj = b.AllInfos();
        if (obj != null)
        {
            for (int i = 0; i < ((List) (obj)).size(); i++)
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)((List) (obj)).get(i);
                if (tphotocomposeinfo.icon != null && tphotocomposeinfo.icon.length() > 0)
                {
                    a.add(tphotocomposeinfo);
                }
            }

        }
        if (c != null)
        {
            c.a(a);
        }
    }

    public List b(CollageType collagetype, int i)
    {
        ArrayList arraylist = new ArrayList(0);
        for (int j = 0; j < a.size(); j++)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)a.get(j);
            if (collagetype == tphotocomposeinfo.getInfoCollageType() && tphotocomposeinfo.imageCount == i && tphotocomposeinfo.resId > TPhotoMagComposeManager.KMAXADRESID)
            {
                arraylist.add(tphotocomposeinfo);
            }
        }

        Collections.sort(arraylist, new Comparator() {

            final qy a;

            public int compare(Object obj, Object obj1)
            {
                boolean flag = false;
                byte byte0 = flag;
                if (obj instanceof TPhotoComposeInfo)
                {
                    byte0 = flag;
                    if (obj1 instanceof TPhotoComposeInfo)
                    {
                        obj = (TPhotoComposeInfo)obj;
                        obj1 = (TPhotoComposeInfo)obj1;
                        if (((TPhotoComposeInfo) (obj)).height > ((TPhotoComposeInfo) (obj1)).height)
                        {
                            byte0 = -1;
                        } else
                        {
                            byte0 = flag;
                            if (((TPhotoComposeInfo) (obj)).height < ((TPhotoComposeInfo) (obj1)).height)
                            {
                                return 1;
                            }
                        }
                    }
                }
                return byte0;
            }

            
            {
                a = qy.this;
                super();
            }
        });
        return arraylist;
    }

    public void b()
    {
        b = ts.a(EOnlineResType.MAG_MASK_INFO);
        a.clear();
        List list = b.AllInfos();
        if (list != null)
        {
            for (int i = 0; i < list.size(); i++)
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)list.get(i);
                if (tphotocomposeinfo.icon != null && tphotocomposeinfo.icon.length() > 0)
                {
                    a.add(tphotocomposeinfo);
                }
            }

        }
    }

    public List c()
    {
        ArrayList arraylist = new ArrayList(0);
        for (int i = 0; i < a.size(); i++)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)a.get(i);
            if (tphotocomposeinfo.useCount > 0)
            {
                arraylist.add(tphotocomposeinfo);
            }
        }

        Collections.sort(arraylist, new Comparator() {

            final qy a;

            public int compare(Object obj, Object obj1)
            {
                boolean flag = false;
                byte byte0 = flag;
                if (obj instanceof TPhotoComposeInfo)
                {
                    byte0 = flag;
                    if (obj1 instanceof TPhotoComposeInfo)
                    {
                        obj = (TPhotoComposeInfo)obj;
                        obj1 = (TPhotoComposeInfo)obj1;
                        if (((TPhotoComposeInfo) (obj)).useCount > ((TPhotoComposeInfo) (obj1)).useCount)
                        {
                            byte0 = -1;
                        } else
                        {
                            byte0 = flag;
                            if (((TPhotoComposeInfo) (obj)).useCount != ((TPhotoComposeInfo) (obj1)).useCount)
                            {
                                return 1;
                            }
                        }
                    }
                }
                return byte0;
            }

            
            {
                a = qy.this;
                super();
            }
        });
        Collections.sort(arraylist, new Comparator() {

            final qy a;

            public int compare(Object obj, Object obj1)
            {
                boolean flag = false;
                byte byte0 = flag;
                if (obj instanceof TPhotoComposeInfo)
                {
                    byte0 = flag;
                    if (obj1 instanceof TPhotoComposeInfo)
                    {
                        obj = (TPhotoComposeInfo)obj;
                        obj1 = (TPhotoComposeInfo)obj1;
                        if (((TPhotoComposeInfo) (obj)).isShouldFirst() && !((TPhotoComposeInfo) (obj1)).isShouldFirst())
                        {
                            byte0 = -1;
                        } else
                        {
                            byte0 = flag;
                            if (!((TPhotoComposeInfo) (obj)).isShouldFirst())
                            {
                                byte0 = flag;
                                if (((TPhotoComposeInfo) (obj1)).isShouldFirst())
                                {
                                    return 1;
                                }
                            }
                        }
                    }
                }
                return byte0;
            }

            
            {
                a = qy.this;
                super();
            }
        });
        return arraylist;
    }
}
