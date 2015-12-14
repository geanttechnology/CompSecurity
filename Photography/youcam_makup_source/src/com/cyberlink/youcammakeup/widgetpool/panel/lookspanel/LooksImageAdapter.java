// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.database.more.l.b;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.makeup.e;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.f;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.ImageCacheChannel;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.aj;
import com.cyberlink.youcammakeup.utility.ak;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.bn;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            LooksGridItem, g, f

public class LooksImageAdapter extends BaseAdapter
    implements f
{

    private static Map l;
    private static int m = -1;
    protected Context a;
    protected com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType b;
    protected android.view.View.OnClickListener c;
    protected List d;
    protected List e;
    protected List f;
    protected List g;
    protected b h;
    protected boolean i;
    protected boolean j;
    protected boolean k;
    private final ag n;
    private int o;
    private int p;
    private final ExecutorService q = Executors.newFixedThreadPool(1);
    private final com.cyberlink.youcammakeup.e r = new com.cyberlink.youcammakeup.e() {

        final LooksImageAdapter a;

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            if (list == null)
            {
                return;
            }
            com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter.a(a, list.size());
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                MakeupItemMetadata makeupitemmetadata = (MakeupItemMetadata)list.next();
                if (makeupitemmetadata.w() && !com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter.a(a, makeupitemmetadata.m()))
                {
                    as as2 = bo.a(makeupitemmetadata);
                    if (makeupitemmetadata.w())
                    {
                        int i1 = a.a(makeupitemmetadata.b());
                        if (i1 == -1)
                        {
                            a.f.add(0, as2);
                        } else
                        {
                            as as1 = (as)a.f.get(i1);
                            a.f.remove(i1);
                            a.f.add(0, as1);
                        }
                    }
                }
            } while (true);
            (new Handler(Looper.getMainLooper())).post(new Runnable(this) {

                final _cls2 a;

                public void run()
                {
                    a.a.notifyDataSetChanged();
                }

            
            {
                a = _pcls2;
                super();
            }
            });
        }

        public void b(Object obj)
        {
        }

        public void c(Object obj)
        {
        }

            
            {
                a = LooksImageAdapter.this;
                super();
            }
    };
    private LooksGridItem s;

    public LooksImageAdapter(Context context, com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType looktype, android.view.View.OnClickListener onclicklistener)
    {
        d = new ArrayList();
        e = new ArrayList();
        f = new ArrayList();
        g = new ArrayList();
        k = true;
        a = context;
        b = looktype;
        c = onclicklistener;
        h = com.cyberlink.youcammakeup.h.c();
        p = -1;
        n = new ag(context);
        context = new k(a, null);
        context.g = false;
        context.a(0.15F);
        n.a(((Activity)a).getFragmentManager(), context);
        h();
        o = 0;
        if (ImageCacheChannel.a(ImageCacheChannel.a) == null)
        {
            o();
        }
        l();
    }

    static int a(LooksImageAdapter looksimageadapter, int i1)
    {
        looksimageadapter.o = i1;
        return i1;
    }

    static Map a(Map map)
    {
        l = map;
        return map;
    }

    private void a(LooksGridItem looksgriditem)
    {
        s = looksgriditem;
        Bitmap bitmap = ImageCacheChannel.a(ImageCacheChannel.a);
        if (bitmap != null)
        {
            looksgriditem.setPreviewImage(bitmap);
        }
    }

    private void a(LooksGridItem looksgriditem, int i1)
    {
        as as1 = a(i1);
        String s1 = as1.a();
        if (l != null && l.get(s1) != null)
        {
            as1.a(((Long)l.get(s1)).toString());
        }
        if (h(i1))
        {
            boolean flag;
            if (i1 != m)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            looksgriditem.a(Boolean.valueOf(flag));
            return;
        } else
        {
            looksgriditem.a(Boolean.valueOf(false));
            return;
        }
    }

    private void a(LooksGridItem looksgriditem, ItemType itemtype)
    {
        boolean flag;
        if (i && itemtype == com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.ItemType.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        looksgriditem.e(flag);
    }

    static void a(LooksImageAdapter looksimageadapter)
    {
        looksimageadapter.m();
    }

    private void a(String s1, LooksGridItem looksgriditem)
    {
        Float float1 = null;
        if (s1.equalsIgnoreCase("look_thumb_02"))
        {
            float1 = aj.a(((Activity)a).getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 6F, new String[] {
                    "it"
                })
            });
        }
        if (s1.equalsIgnoreCase("look_thumb_05"))
        {
            float1 = aj.a(((Activity)a).getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 6F, new String[] {
                    "ja"
                })
            });
        }
        if (s1.equalsIgnoreCase("look_thumb_09"))
        {
            float1 = aj.a(((Activity)a).getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 6F, new String[] {
                    "ru"
                })
            });
        }
        if (s1.equalsIgnoreCase("look_thumb_10"))
        {
            float1 = aj.a(((Activity)a).getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 6F, new String[] {
                    "ja", "it"
                })
            });
        }
        if (s1.equalsIgnoreCase("look_thumb_14"))
        {
            float1 = aj.a(((Activity)a).getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 6F, new String[] {
                    "ja"
                })
            });
        }
        if (s1.equalsIgnoreCase("look_thumb_17"))
        {
            float1 = aj.a(((Activity)a).getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 6F, new String[] {
                    "fr", "ja", "de", "it"
                })
            });
        }
        if (s1.equalsIgnoreCase("look_thumb_23"))
        {
            float1 = aj.a(((Activity)a).getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 6F, new String[] {
                    "fr", "ja", "es", "it"
                })
            });
        }
        if (s1.equalsIgnoreCase("look_thumb_25"))
        {
            float1 = aj.a(((Activity)a).getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 6F, new String[] {
                    "ja", "ru"
                })
            });
        }
        if (s1.equalsIgnoreCase("look_thumb_32"))
        {
            float1 = aj.a(((Activity)a).getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 6F, new String[] {
                    "fr", "ja", "ru", "es"
                })
            });
        }
        s1 = float1;
        if (float1 == null)
        {
            s1 = Float.valueOf(looksgriditem.getDefaultNameFontSize());
        }
        looksgriditem.setNameFontSize(s1.floatValue());
    }

    static boolean a(LooksImageAdapter looksimageadapter, String s1)
    {
        return looksimageadapter.b(s1);
    }

    private boolean b(String s1)
    {
        for (Iterator iterator = f.iterator(); iterator.hasNext();)
        {
            if (((as)iterator.next()).a().equals(s1))
            {
                return true;
            }
        }

        return false;
    }

    public static void c(int i1)
    {
        m = i1;
    }

    private boolean h(int i1)
    {
        return i1 == f() && a(i1).n() != null;
    }

    static Map k()
    {
        return l;
    }

    private void l()
    {
        ArrayList arraylist = new ArrayList();
        for (int i1 = 0; i1 < getCount(); i1++)
        {
            arraylist.add(a(i1));
        }

        bn.a(new com.cyberlink.youcammakeup.e(arraylist) {

            final List a;
            final LooksImageAdapter b;

            public volatile void a(Object obj)
            {
                a((Map)obj);
            }

            public void a(Map map)
            {
                if (map != null)
                {
                    if (com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter.k() == null)
                    {
                        com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter.a(map);
                    } else
                    {
                        map = new HashMap(map);
                        map.keySet().removeAll(com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter.k().keySet());
                        com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter.k().putAll(map);
                    }
                    map = a.iterator();
                    do
                    {
                        if (!map.hasNext())
                        {
                            break;
                        }
                        as as1 = (as)map.next();
                        if (!com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter.k().containsKey(as1.a()))
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter.k().put(as1.a(), null);
                        }
                    } while (true);
                }
            }

            public void b(Object obj)
            {
            }

            public void c(Object obj)
            {
            }

            
            {
                b = LooksImageAdapter.this;
                a = list;
                super();
            }
        });
    }

    private void m()
    {
        int i1 = 0;
        do
        {
label0:
            {
                if (i1 < getCount())
                {
                    if (a(i1) != null && l != null && !l.containsKey(a(i1).a()))
                    {
                        break label0;
                    }
                    l();
                }
                return;
            }
            i1++;
        } while (true);
    }

    private Context n()
    {
        return a;
    }

    private void o()
    {
        long l1 = StatusManager.j().l();
        v v1 = MotionControlHelper.e().M();
        i i1 = StatusManager.j().d();
        Object obj = i1;
        if (i1 == null)
        {
            obj = new i();
        }
        if (((i) (obj)).m() > 0.0F && ((i) (obj)).m() <= 100F)
        {
            BeautifierManager.a().a(this);
            i j1 = new i();
            j1.d(((i) (obj)).m());
            obj = MotionControlHelper.e();
            ((MotionControlHelper) (obj)).n();
            if (!((MotionControlHelper) (obj)).j())
            {
                ((MotionControlHelper) (obj)).b(StatusManager.j().f(l1));
            }
            BeautifierTaskInfo beautifiertaskinfo = new BeautifierTaskInfo(false, false, false, true);
            beautifiertaskinfo.a("LooksImageAdapter", com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo.ResultBufferType.a);
            ((MotionControlHelper) (obj)).a(j1, beautifiertaskinfo);
            if (v1 != null)
            {
                BeautifierEditCenter.a().a(v1.f(), true);
            }
            if (a instanceof BaseActivity)
            {
                ((BaseActivity)a).h();
            }
        } else
        {
            Object obj1 = StatusManager.j().c(l1);
            ImageBufferWrapper imagebufferwrapper = ((d) (obj1)).g().b();
            if (imagebufferwrapper != null)
            {
                Bitmap bitmap = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
                imagebufferwrapper.c(bitmap);
                imagebufferwrapper.m();
                obj1 = ((d) (obj1)).e();
                obj1 = aa.a(bitmap, (ar)((a) (obj1)).d().get(((a) (obj1)).e), ((a) (obj1)).d, true);
                ImageCacheChannel.a(ImageCacheChannel.a, ((Bitmap) (obj1)));
                bitmap.recycle();
                if (s != null)
                {
                    a(s);
                    return;
                }
            }
        }
    }

    public int a(String s1)
    {
        for (int i1 = 0; i1 < getCount(); i1++)
        {
            if (b(i1).equals(s1))
            {
                return i1;
            }
        }

        return -1;
    }

    public as a(int i1)
    {
        if (i1 >= 0)
        {
            if (i1 < d.size())
            {
                return (as)d.get(i1);
            }
            i1 -= d.size();
            if (i1 < f.size())
            {
                return (as)f.get(i1);
            }
            i1 -= f.size();
            if (i1 < e.size())
            {
                return (as)e.get(i1);
            }
            i1 -= e.size();
            if (i1 < g.size())
            {
                return (as)g.get(i1);
            }
        }
        return null;
    }

    public void a()
    {
        d.clear();
        e.clear();
        f.clear();
        g.clear();
        a = null;
    }

    public void a(int i1, as as1)
    {
        if (i1 - d.size() < f.size())
        {
            f.set(i1 - d.size(), as1);
        }
    }

    public void a(int i1, boolean flag)
    {
        as as1 = a(i1);
        if (as1.f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b)
        {
            as1.b(Boolean.valueOf(false));
        }
    }

    public void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        if (beautifiertaskinfo != null && beautifiertaskinfo.e() != null && beautifiertaskinfo.e().equalsIgnoreCase("LooksImageAdapter"))
        {
            Object obj = beautifiertaskinfo.g();
            beautifiertaskinfo = Bitmap.createBitmap((int)((ImageBufferWrapper) (obj)).b(), (int)((ImageBufferWrapper) (obj)).c(), android.graphics.Bitmap.Config.ARGB_8888);
            ((ImageBufferWrapper) (obj)).c(beautifiertaskinfo);
            ((ImageBufferWrapper) (obj)).m();
            long l1 = StatusManager.j().l();
            obj = StatusManager.j().c(l1).e();
            obj = aa.a(beautifiertaskinfo, (ar)((a) (obj)).d().get(((a) (obj)).e), ((a) (obj)).d, true);
            ImageCacheChannel.a(ImageCacheChannel.a, ((Bitmap) (obj)));
            beautifiertaskinfo.recycle();
            if (s != null)
            {
                a(s);
            }
            BeautifierManager.a().b(this);
            if (a instanceof BaseActivity)
            {
                ((BaseActivity)a).i();
                return;
            }
        }
    }

    public void a(com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType looktype)
    {
        b = looktype;
        e.clear();
        g(-1);
        (new g(this)).executeOnExecutor(q, new Void[0]);
    }

    public void a(boolean flag)
    {
        k = flag;
    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public String b(int i1)
    {
        if (a(i1) == null)
        {
            return null;
        } else
        {
            return a(i1).a();
        }
    }

    public void b()
    {
        ArrayList arraylist;
        int j1;
        arraylist = new ArrayList(o);
        if (f.size() > 0)
        {
            for (int i1 = 0; i1 < o; i1++)
            {
                arraylist.add(f.get(i1));
            }

        }
        Object obj1 = PanelDataCenter.a().a(com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a(b), new com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b
        });
        Object obj;
        if (b == com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a)
        {
            obj = bo.a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, new com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode[] {
                com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.c, com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.a
            });
        } else
        {
            obj = new ArrayList();
        }
        ((List) (obj1)).addAll(((java.util.Collection) (obj)));
        f.clear();
        obj = ((List) (obj1)).iterator();
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        obj1 = bo.z((String)((Iterator) (obj)).next());
        j1 = 0;
_L5:
        if (j1 >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_295;
        }
        if (!((as)arraylist.get(j1)).a().equals(((as) (obj1)).a())) goto _L4; else goto _L3
_L3:
        j1 = 1;
_L6:
        if (j1 == 0)
        {
            f.add(0, obj1);
        }
        break MISSING_BLOCK_LABEL_144;
_L4:
        j1++;
          goto _L5
_L2:
        for (j1 = 0; j1 < arraylist.size(); j1++)
        {
            f.add(0, arraylist.get(o - j1 - 1));
        }

        return;
        j1 = 0;
          goto _L6
    }

    public void b(boolean flag)
    {
        i = flag;
        notifyDataSetChanged();
    }

    public void c(boolean flag)
    {
        j = flag;
    }

    public boolean c()
    {
        return i;
    }

    public boolean d()
    {
        return j;
    }

    public boolean d(int i1)
    {
        return a(i1).g().booleanValue();
    }

    public boolean e()
    {
        return f.size() > 0;
    }

    public boolean e(int i1)
    {
        return a(i1).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a;
    }

    public int f()
    {
        return p;
    }

    public boolean f(int i1)
    {
        return a(i1).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c;
    }

    public as g()
    {
        return a(p);
    }

    public void g(int i1)
    {
        if (p != i1)
        {
            p = i1;
            notifyDataSetChanged();
        }
    }

    public int getCount()
    {
        return d.size() + e.size() + f.size() + g.size();
    }

    public Object getItem(int i1)
    {
        return a(i1);
    }

    public long getItemId(int i1)
    {
        return -1L;
    }

    public View getView(int i1, View view, ViewGroup viewgroup)
    {
        boolean flag2 = false;
        Object obj;
        boolean flag;
        if (view != null)
        {
            view = (LooksGridItem)view;
        } else
        {
            view = new LooksGridItem(n(), c);
        }
        if (i1 == p)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setActivated(flag);
        obj = a(i1);
        if (obj == null)
        {
            return view;
        }
        String s2 = ((as) (obj)).a();
        viewgroup = (com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f)view.getTag();
        if (viewgroup == null || !((com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f) (viewgroup)).a.equals(s2))
        {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType sourcetype = a(i1).f();
            viewgroup = com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.ItemType.a;
            if (sourcetype == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b)
            {
                viewgroup = com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.ItemType.b;
            }
            viewgroup = new com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f(s2, com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.ItemStatus.e, viewgroup);
            view.setTag(viewgroup);
            if (sourcetype == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c)
            {
                view.setNameMaxLines(1);
            } else
            {
                view.setNameMaxLines(2);
            }
        }
        if (i1 == 0)
        {
            boolean flag1;
            if (!z.a("HAS_SET_SEEN_MAKEUP_LOOK_RED_ICON", Globals.d()))
            {
                flag1 = true;
            } else
            if (com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.b == i())
            {
                flag1 = af.a(MoreMakeupActivity.a, 0x15ab1cL);
            } else
            {
                flag1 = flag2;
                if (com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType.a == i())
                {
                    flag1 = af.a(MoreMakeupActivity.a, 0x15ab1bL);
                }
            }
            view.c(flag1);
            view.a(true);
        } else
        if (((com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f) (viewgroup)).b != com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.ItemStatus.b && ((com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f) (viewgroup)).b != com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.ItemStatus.a)
        {
            viewgroup.b = com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.ItemStatus.a;
            view.a(false);
            String s1 = a(i1).d();
            Object obj1;
            if (i1 == 1)
            {
                a(view);
                view.d(false);
            } else
            if (a(i1).h().booleanValue())
            {
                view.a(n, a(i1).k());
                view.a(a(i1).j().booleanValue(), a(i1).i().booleanValue());
            } else
            {
                view.a(n, s1);
                view.d(false);
            }
            view.b(false);
            a(view, ((com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f) (viewgroup)).c);
            view.setName(((as) (obj)).b());
            s1 = "";
            obj1 = com.cyberlink.youcammakeup.h.c().a(s2);
            obj = s1;
            if (obj1 != null)
            {
                long l1 = ((com.cyberlink.youcammakeup.database.more.l.a) (obj1)).a();
                obj1 = com.cyberlink.youcammakeup.h.v().a(l1);
                obj = s1;
                if (obj1 != null)
                {
                    obj = ((MakeupItemMetadata) (obj1)).d();
                }
            }
            view.setVendorName(((CharSequence) (obj)));
            a(s2, view);
            viewgroup.b = com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.ItemStatus.b;
        } else
        {
            view.a(false);
            a(view, ((com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f) (viewgroup)).c);
        }
        a(view, i1);
        view.b(d(i1));
        if (i1 == p)
        {
            view.getNameTextView().setBackgroundColor(Color.parseColor("#C0F23B77"));
            return view;
        } else
        {
            view.getNameTextView().setBackgroundColor(Color.parseColor("#B2000000"));
            return view;
        }
    }

    public void h()
    {
        as as1 = bo.z("default_original_looks");
        d.add(as1);
        d.add(as1);
        bo.z("default_switcher_looks");
        a(b);
    }

    public com.cyberlink.youcammakeup.utility.PanelDataCenter.LookType i()
    {
        return b;
    }

    public boolean isEnabled(int i1)
    {
        return k;
    }

    public void j()
    {
        o();
    }


    private class ItemType extends Enum
    {

        public static final ItemType a;
        public static final ItemType b;
        private static final ItemType c[];

        public static ItemType valueOf(String s1)
        {
            return (ItemType)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/lookspanel/LooksImageAdapter$ItemType, s1);
        }

        public static ItemType[] values()
        {
            return (ItemType[])c.clone();
        }

        static 
        {
            a = new ItemType("Sample", 0);
            b = new ItemType("Download", 1);
            c = (new ItemType[] {
                a, b
            });
        }

        private ItemType(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class ItemStatus extends Enum
    {

        public static final ItemStatus a;
        public static final ItemStatus b;
        public static final ItemStatus c;
        public static final ItemStatus d;
        public static final ItemStatus e;
        private static final ItemStatus f[];

        public static ItemStatus valueOf(String s1)
        {
            return (ItemStatus)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/lookspanel/LooksImageAdapter$ItemStatus, s1);
        }

        public static ItemStatus[] values()
        {
            return (ItemStatus[])f.clone();
        }

        static 
        {
            a = new ItemStatus("Loading", 0);
            b = new ItemStatus("Loaded", 1);
            c = new ItemStatus("Canceled", 2);
            d = new ItemStatus("Error", 3);
            e = new ItemStatus("Init", 4);
            f = (new ItemStatus[] {
                a, b, c, d, e
            });
        }

        private ItemStatus(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
