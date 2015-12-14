// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.editview.savemylook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.k;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.m;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.o;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.ba;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.idunnololz.widgets.a;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.editview.savemylook:
//            d, e, c

public class b extends a
{

    private final List a = new ArrayList();
    private i b;

    public b(i j)
    {
        if (j != null)
        {
            b = new i();
            if (a(j.b()))
            {
                b.a(j.b());
                a.add(BeautyMode.n);
            }
            if (b(j.e()))
            {
                b.b(j.e());
                a.add(BeautyMode.l);
            }
            if (b(j.f()))
            {
                b.c(j.f());
                a.add(BeautyMode.m);
            }
            if (a(j.a()))
            {
                b.a(j.a());
                a.add(BeautyMode.r);
            }
            if (a(j.c()))
            {
                b.a(j.c());
                a.add(BeautyMode.s);
            }
            if (b(j.h()))
            {
                b.e(j.h());
                a.add(BeautyMode.v);
            }
            if (b(j.g()))
            {
                b.d(j.g());
                a.add(BeautyMode.a);
            }
            if (j.i() != null)
            {
                b.f(j.i());
                a.add(BeautyMode.b);
            }
            if (a(j.u()))
            {
                b.a(j.u());
                a.add(BeautyMode.x);
            }
            if (a(j.d()))
            {
                b.a(j.d());
                a.add(BeautyMode.t);
            }
            if (a(j.D()))
            {
                b.a(j.D());
                a.add(BeautyMode.j);
                return;
            }
        }
    }

    public View a(int j, int l, boolean flag, View view, ViewGroup viewgroup)
    {
        return null;
    }

    public i a()
    {
        return b;
    }

    public BeautyMode a(int j)
    {
        return (BeautyMode)a.get(j);
    }

    public boolean a(k k1)
    {
        if (k1 == null)
        {
            return false;
        } else
        {
            return bo.g(k1.a());
        }
    }

    public boolean a(m m1)
    {
        if (m1 == null)
        {
            return false;
        } else
        {
            return bo.g(m1.b());
        }
    }

    public boolean a(o o1)
    {
        if (o1 == null)
        {
            return false;
        }
        o1 = o1.a().iterator();
_L4:
        if (!o1.hasNext()) goto _L2; else goto _L1
_L1:
        if (bo.g((String)o1.next())) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L6:
        return flag;
_L2:
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean a(r r1)
    {
        if (r1 != null)
        {
            String s1 = r1.b();
            r1 = r1.c();
            if (bo.g(s1) && bo.f(r1))
            {
                return true;
            }
        }
        return false;
    }

    public boolean a(s s1)
    {
        if (s1 == null)
        {
            return false;
        } else
        {
            return bo.g(s1.b());
        }
    }

    public boolean a(u u1)
    {
        if (u1 == null)
        {
            return false;
        } else
        {
            return bo.g(u1.b());
        }
    }

    public int a_(int j)
    {
        return 0;
    }

    public boolean b(r r1)
    {
        if (r1 == null)
        {
            return false;
        }
        String s1 = r1.b();
        r1 = r1.c();
        boolean flag;
        boolean flag1;
        if (s1 != null)
        {
            flag = bo.g(s1);
        } else
        {
            flag = false;
        }
        if (r1 != null)
        {
            flag1 = bo.f(r1);
        } else
        {
            flag1 = true;
        }
        return flag1 & (flag | false);
    }

    public Object getChild(int j, int l)
    {
        return null;
    }

    public long getChildId(int j, int l)
    {
        return -1L;
    }

    public Object getGroup(int j)
    {
        return a(j);
    }

    public int getGroupCount()
    {
        return a.size();
    }

    public long getGroupId(int j)
    {
        return -1L;
    }

    public View getGroupView(int j, boolean flag, View view, ViewGroup viewgroup)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        View view1;
        Object obj9;
        d d1;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        Integer integer;
        Object obj17;
        ViewGroup viewgroup1;
        Object obj18;
        BeautyMode beautymode;
        if (view != null)
        {
            d1 = (d)view;
        } else
        {
            d1 = new d(viewgroup.getContext());
        }
        beautymode = a(j);
        obj7 = null;
        obj6 = null;
        obj3 = null;
        obj2 = null;
        obj12 = null;
        obj11 = null;
        obj1 = null;
        obj9 = null;
        view1 = null;
        obj18 = null;
        viewgroup1 = null;
        obj17 = null;
        integer = null;
        obj15 = null;
        obj14 = null;
        obj13 = null;
        obj = null;
        obj8 = null;
        obj10 = null;
        d1.setFirstPropertyImageTexture(e.c);
        d1.setSecondPropertyImageTexture(e.c);
        d1.setThirdPropertyImageTexture(e.c);
        d1.setOrderTextVisibility(8);
        d1.setBrandImage(null);
        if (beautymode == BeautyMode.x)
        {
            obj1 = b.u();
            view = ((u) (obj1)).e();
            obj = ((u) (obj1)).b();
            obj2 = viewgroup.getContext().getString(0x7f070501);
            viewgroup = PanelDataCenter.a().i(((u) (obj1)).c());
            Integer integer1;
            Object obj22;
            if (viewgroup != null)
            {
                viewgroup = viewgroup.k();
            } else
            {
                viewgroup = null;
            }
            obj7 = com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.i;
            if (view != null)
            {
                view = Integer.valueOf(view.e());
            } else
            {
                view = null;
            }
            integer1 = Integer.valueOf(100 - (int)((u) (obj1)).g());
            obj4 = obj;
            obj3 = null;
            obj22 = null;
            obj1 = null;
            obj6 = viewgroup;
            obj5 = obj;
            obj = obj22;
            viewgroup = integer1;
        } else
        if (beautymode == BeautyMode.n)
        {
            obj2 = b.b();
            String s1 = ((r) (obj2)).b();
            obj7 = viewgroup.getContext().getString(0x7f07033c);
            viewgroup = PanelDataCenter.a().i(((r) (obj2)).c());
            com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType featuretype;
            if (viewgroup != null)
            {
                obj6 = viewgroup.k();
            } else
            {
                obj6 = null;
            }
            if (viewgroup != null)
            {
                view = viewgroup.a();
            } else
            {
                view = null;
            }
            featuretype = com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.b;
            if (obj6 == null)
            {
                Object obj26;
                Object obj27;
                Object obj28;
                int l;
                int l1;
                if (obj2 != null && ((r) (obj2)).f() != null && ((r) (obj2)).f().size() > 0 && ((r) (obj2)).f().get(0) != null)
                {
                    viewgroup = Integer.valueOf(((at)((r) (obj2)).f().get(0)).e());
                } else
                {
                    viewgroup = null;
                }
                if (obj2 != null && ((r) (obj2)).f() != null && ((r) (obj2)).f().size() > 1 && ((r) (obj2)).f().get(1) != null)
                {
                    obj = Integer.valueOf(((at)((r) (obj2)).f().get(1)).e());
                } else
                {
                    obj = null;
                }
                if (obj2 != null && ((r) (obj2)).f() != null && ((r) (obj2)).f().size() > 2 && ((r) (obj2)).f().get(2) != null)
                {
                    obj1 = Integer.valueOf(((at)((r) (obj2)).f().get(2)).e());
                } else
                {
                    obj1 = null;
                }
                if (obj2 != null && ((r) (obj2)).f() != null && ((r) (obj2)).f().size() > 0 && ((r) (obj2)).f().get(0) != null)
                {
                    j = ((at)((r) (obj2)).f().get(0)).d();
                } else
                {
                    j = 0;
                }
                if (obj2 != null && ((r) (obj2)).f() != null && ((r) (obj2)).f().size() > 1 && ((r) (obj2)).f().get(1) != null)
                {
                    l = ((at)((r) (obj2)).f().get(1)).d();
                } else
                {
                    l = 0;
                }
                if (obj2 != null && ((r) (obj2)).f() != null && ((r) (obj2)).f().size() > 2 && ((r) (obj2)).f().get(2) != null)
                {
                    l1 = ((at)((r) (obj2)).f().get(2)).d();
                } else
                {
                    l1 = 0;
                }
                if (obj2 != null && ((r) (obj2)).f() != null && ((r) (obj2)).f().size() > 0 && ((r) (obj2)).f().get(0) != null && ((at)((r) (obj2)).f().get(0)).k())
                {
                    d1.setFirstPropertyImageTexture(e.b);
                }
                if (obj2 != null && ((r) (obj2)).f() != null && ((r) (obj2)).f().size() > 1 && ((r) (obj2)).f().get(1) != null && ((at)((r) (obj2)).f().get(1)).k())
                {
                    d1.setSecondPropertyImageTexture(e.b);
                }
                if (obj2 != null && ((r) (obj2)).f() != null && ((r) (obj2)).f().size() > 2 && ((r) (obj2)).f().get(2) != null && ((at)((r) (obj2)).f().get(2)).k())
                {
                    d1.setThirdPropertyImageTexture(e.b);
                }
                d1.setOrderTextVisibility(0);
                obj5 = Integer.valueOf(l1);
                obj8 = Integer.valueOf(l);
                obj10 = Integer.valueOf(j);
                obj4 = viewgroup;
                obj3 = obj;
                obj2 = obj1;
                obj1 = obj10;
                obj = obj8;
                viewgroup = ((ViewGroup) (obj5));
            } else
            {
                d1.setBrandImage(h.b().c("eye_shadow", viewgroup.k(), viewgroup.a()));
                viewgroup = null;
                obj = null;
                obj1 = null;
                obj2 = null;
                obj3 = null;
                obj4 = null;
            }
            obj28 = null;
            obj27 = null;
            obj26 = null;
            obj5 = view;
            view = ((View) (obj4));
            obj10 = viewgroup;
            obj8 = obj;
            viewgroup = ((ViewGroup) (obj1));
            obj11 = obj2;
            obj12 = obj3;
            obj = obj28;
            obj1 = obj27;
            obj2 = obj7;
            obj3 = obj26;
            obj4 = s1;
            obj7 = featuretype;
        } else
        if (beautymode == BeautyMode.r)
        {
            obj1 = b.a();
            obj = PanelDataCenter.a().i(((s) (obj1)).c());
            obj5 = ((s) (obj1)).b();
            obj6 = viewgroup.getContext().getString(0x7f070338);
            ViewGroup viewgroup2;
            Object obj23;
            Integer integer6;
            int i1;
            if (obj != null)
            {
                view = ((aw) (obj)).k();
            } else
            {
                view = null;
            }
            if (obj != null)
            {
                obj = ((aw) (obj)).a();
            } else
            {
                obj = null;
            }
            obj7 = com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.d;
            if (view == null && ((String) (obj5)).equals("Eyebrow_general"))
            {
                viewgroup = viewgroup.getContext().getString(0x7f0703ce);
            } else
            {
                viewgroup = null;
            }
            j = (int)((s) (obj1)).g();
            i1 = (int)((s) (obj1)).a();
            obj2 = h.b().d(SkuTemplateUtils.a(beautymode), view, ((String) (obj)));
            if (obj2 != null && !((String) (obj2)).equals(""))
            {
                obj1 = ((String) (obj2)).split(",");
                int i2 = Color.parseColor((new StringBuilder()).append("#").append(obj1[0]).toString());
                obj4 = Integer.valueOf(Color.parseColor((new StringBuilder()).append("#").append(obj1[1]).toString()));
                obj1 = Integer.valueOf(Color.parseColor((new StringBuilder()).append("#").append(obj1[2]).toString()));
                obj2 = null;
                obj3 = Integer.valueOf(i2);
            } else
            {
                if (((s) (obj1)).e() != null)
                {
                    obj1 = Integer.valueOf(((s) (obj1)).e().e());
                } else
                {
                    obj1 = null;
                }
                obj4 = null;
                obj3 = null;
                obj2 = obj1;
                obj1 = null;
            }
            obj14 = obj4;
            obj15 = obj3;
            integer6 = Integer.valueOf(j);
            obj13 = "assets://makeup/eyebrow/strenth_eyebrowahape.png";
            obj3 = obj6;
            obj23 = null;
            obj4 = obj5;
            obj5 = obj;
            obj6 = view;
            viewgroup2 = viewgroup;
            view = ((View) (obj2));
            obj8 = Integer.valueOf(i1);
            viewgroup = integer6;
            obj = obj13;
            obj13 = obj1;
            obj1 = viewgroup2;
            obj2 = obj3;
            obj3 = obj23;
        } else
        if (beautymode == BeautyMode.s)
        {
            obj3 = b.c();
            obj4 = PanelDataCenter.a().i(((m) (obj3)).c());
            j = ((aw) (obj4)).b();
            obj = MotionControlHelper.e();
            if (j == 2)
            {
                obj1 = ((m) (obj3)).f();
                if (obj1 != null && ((List) (obj1)).size() >= 2)
                {
                    Object obj19;
                    int j1;
                    if (obj1 != null && ((List) (obj1)).get(0) != null)
                    {
                        view = ((MotionControlHelper) (obj)).b((at)((List) (obj1)).get(0));
                    } else
                    {
                        view = null;
                    }
                    if (obj1 != null && ((List) (obj1)).get(1) != null)
                    {
                        obj1 = ((MotionControlHelper) (obj)).b((at)((List) (obj1)).get(1));
                    } else
                    {
                        obj1 = null;
                    }
                    if (view != null)
                    {
                        obj = Integer.valueOf(Color.rgb(view.a().intValue(), view.b().intValue(), view.c().intValue()));
                    } else
                    {
                        obj = null;
                    }
                    if (obj1 != null)
                    {
                        view = Integer.valueOf(Color.rgb(((at) (obj1)).a().intValue(), ((at) (obj1)).b().intValue(), ((at) (obj1)).c().intValue()));
                        obj1 = obj2;
                    } else
                    {
                        view = null;
                        obj1 = obj2;
                    }
                } else
                {
                    view = ((MotionControlHelper) (obj)).b(((m) (obj3)).e());
                    if (view != null)
                    {
                        view = Integer.valueOf(Color.rgb(view.a().intValue(), view.b().intValue(), view.c().intValue()));
                    } else
                    {
                        view = null;
                    }
                    obj = null;
                    obj1 = view;
                    view = null;
                }
            } else
            {
                view = ((MotionControlHelper) (obj)).b(((m) (obj3)).e());
                if (view != null)
                {
                    view = Integer.valueOf(Color.rgb(view.a().intValue(), view.b().intValue(), view.c().intValue()));
                } else
                {
                    view = null;
                }
                obj = null;
                obj1 = view;
                view = null;
            }
            obj5 = ((m) (obj3)).b();
            obj2 = viewgroup.getContext().getString(0x7f070339);
            if (obj4 != null)
            {
                viewgroup = ((aw) (obj4)).k();
            } else
            {
                viewgroup = null;
            }
            obj7 = com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.c;
            j = (int)((m) (obj3)).g();
            j1 = (int)((m) (obj3)).a();
            obj6 = viewgroup;
            obj4 = obj5;
            obj8 = Integer.valueOf(j1);
            viewgroup = Integer.valueOf(j);
            view1 = view;
            obj19 = null;
            obj3 = null;
            obj9 = obj;
            view = ((View) (obj1));
            obj = "assets://makeup/eyecontact/strenth_eyecontact.png";
            obj1 = obj19;
        } else
        if (beautymode == BeautyMode.l)
        {
            obj1 = b.e();
            view = PanelDataCenter.a().i(((r) (obj1)).c());
            obj4 = ((r) (obj1)).b();
            obj2 = viewgroup.getContext().getString(0x7f07033b);
            Integer integer2;
            if (view != null)
            {
                viewgroup = view.k();
            } else
            {
                viewgroup = null;
            }
            if (view != null)
            {
                obj = view.a();
            } else
            {
                obj = null;
            }
            obj7 = com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.e;
            if (((r) (obj1)).e() != null)
            {
                view = Integer.valueOf(((r) (obj1)).e().e());
            } else
            {
                view = null;
            }
            integer2 = Integer.valueOf((int)((r) (obj1)).g());
            obj6 = viewgroup;
            obj3 = null;
            obj5 = obj;
            obj = null;
            obj1 = null;
            viewgroup = integer2;
        } else
        if (beautymode == BeautyMode.m)
        {
            obj1 = b.f();
            view = PanelDataCenter.a().i(((r) (obj1)).c());
            obj4 = ((r) (obj1)).b();
            obj2 = viewgroup.getContext().getString(0x7f07033a);
            Integer integer3;
            if (view != null)
            {
                viewgroup = view.k();
            } else
            {
                viewgroup = null;
            }
            if (view != null)
            {
                obj = view.a();
            } else
            {
                obj = null;
            }
            obj7 = com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.f;
            if (((r) (obj1)).e() != null)
            {
                view = Integer.valueOf(((r) (obj1)).e().e());
            } else
            {
                view = null;
            }
            integer3 = Integer.valueOf((int)((r) (obj1)).g());
            obj6 = viewgroup;
            obj3 = null;
            obj5 = obj;
            obj = null;
            obj1 = null;
            viewgroup = integer3;
        } else
        if (beautymode == BeautyMode.v)
        {
            obj5 = b.h();
            obj6 = PanelDataCenter.a().i(((r) (obj5)).c());
            if (((aw) (obj6)).b() == 2)
            {
                view = ((r) (obj5)).f();
                if (view != null && view.size() >= 2)
                {
                    Integer integer4;
                    Object obj24;
                    if (view != null && view.get(0) != null)
                    {
                        obj9 = Integer.valueOf(((at)view.get(0)).e());
                    } else
                    {
                        obj9 = null;
                    }
                    if (view != null && view.get(1) != null)
                    {
                        view = Integer.valueOf(((at)view.get(1)).e());
                        obj = obj3;
                    } else
                    {
                        view = null;
                        obj = obj3;
                    }
                } else
                {
                    view = ((r) (obj5)).e();
                    if (view != null)
                    {
                        view = Integer.valueOf(view.e());
                    } else
                    {
                        view = null;
                    }
                    obj = view;
                    view = null;
                    obj9 = obj1;
                }
            } else
            {
                view = ((r) (obj5)).e();
                if (view != null)
                {
                    view = Integer.valueOf(view.e());
                } else
                {
                    view = null;
                }
                obj = view;
                view = null;
                obj9 = obj1;
            }
            obj4 = ((r) (obj5)).b();
            obj2 = viewgroup.getContext().getString(0x7f070345);
            if (obj6 != null)
            {
                viewgroup = ((aw) (obj6)).k();
            } else
            {
                viewgroup = null;
            }
            if (obj6 != null)
            {
                obj1 = ((aw) (obj6)).a();
            } else
            {
                obj1 = null;
            }
            obj7 = com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.a;
            integer4 = Integer.valueOf((int)((r) (obj5)).g());
            obj6 = viewgroup;
            obj3 = null;
            obj5 = obj1;
            obj24 = null;
            obj1 = null;
            view1 = view;
            view = ((View) (obj));
            viewgroup = integer4;
            obj = obj24;
        } else
        if (beautymode == BeautyMode.a)
        {
            obj17 = b.g();
            view = PanelDataCenter.a().i(((r) (obj17)).c());
            obj4 = ((r) (obj17)).b();
            obj5 = viewgroup.getContext().getString(0x7f070332);
            Object obj20;
            Object obj25;
            if (view != null)
            {
                obj6 = view.k();
            } else
            {
                obj6 = null;
            }
            if (view != null)
            {
                view = view.a();
            } else
            {
                view = null;
            }
            obj7 = com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.g;
            viewgroup = h.b().d(SkuTemplateUtils.a(beautymode), ((String) (obj6)), view);
            if (viewgroup != null && !viewgroup.equals(""))
            {
                viewgroup = viewgroup.split(",");
                j = Color.parseColor((new StringBuilder()).append("#").append(viewgroup[0]).toString());
                int k1 = Color.parseColor((new StringBuilder()).append("#").append(viewgroup[1]).toString());
                obj = Integer.valueOf(Color.parseColor((new StringBuilder()).append("#").append(viewgroup[2]).toString()));
                obj2 = Integer.valueOf(Color.parseColor((new StringBuilder()).append("#").append(viewgroup[3]).toString()));
                obj3 = Integer.valueOf(j);
                obj1 = null;
                viewgroup = Integer.valueOf(k1);
            } else
            {
                Object obj16;
                if (((r) (obj17)).e() != null)
                {
                    viewgroup = Integer.valueOf(((r) (obj17)).e().e());
                } else
                {
                    viewgroup = null;
                }
                obj = null;
                obj3 = null;
                obj1 = viewgroup;
                obj2 = null;
                obj16 = null;
                viewgroup = ((ViewGroup) (obj3));
                obj3 = obj16;
            }
            j = (int)((r) (obj17)).g();
            integer = ((Integer) (obj2));
            obj17 = obj;
            obj18 = Integer.valueOf(j);
            viewgroup1 = viewgroup;
            obj = null;
            obj25 = null;
            obj2 = obj5;
            obj20 = null;
            obj5 = view;
            view = ((View) (obj1));
            viewgroup = ((ViewGroup) (obj18));
            obj18 = obj3;
            obj1 = obj25;
            obj3 = obj20;
        } else
        if (beautymode == BeautyMode.b)
        {
            obj1 = b.i();
            view = ((r) (obj1)).e();
            obj2 = viewgroup.getContext().getString(0x7f07034f);
            Integer integer5;
            if (view != null && (view instanceof ba))
            {
                viewgroup = ((ba)view).n();
            } else
            {
                viewgroup = null;
            }
            if (viewgroup != null)
            {
                obj = ((ba)view).h();
            } else
            {
                obj = null;
            }
            obj7 = com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.h;
            if (((r) (obj1)).e() != null)
            {
                view = Integer.valueOf(((r) (obj1)).e().e());
            } else
            {
                view = null;
            }
            integer5 = Integer.valueOf((int)((r) (obj1)).g());
            obj6 = viewgroup;
            obj4 = null;
            obj3 = null;
            obj5 = obj;
            obj = null;
            obj1 = null;
            viewgroup = integer5;
        } else
        if (beautymode == BeautyMode.t)
        {
            obj = b.d();
            obj4 = ((k) (obj)).a();
            obj2 = viewgroup.getContext().getString(0x7f07033d);
            view = ((k) (obj)).c();
            if (view != null)
            {
                view = Integer.valueOf(view.e());
            } else
            {
                view = null;
            }
            viewgroup = Integer.valueOf((int)((k) (obj)).b());
            obj3 = null;
            obj5 = null;
            obj = null;
            obj1 = null;
        } else
        if (beautymode == BeautyMode.j)
        {
            obj3 = b.D().a();
            obj2 = viewgroup.getContext().getString(0x7f07033e);
            view = null;
            viewgroup = null;
            obj5 = null;
            obj4 = null;
            obj = null;
            obj1 = null;
        } else
        if (beautymode == BeautyMode.k)
        {
            view = b.E();
            obj4 = (String)view.a().get(0);
            obj = view.b(((String) (obj4)));
            obj2 = viewgroup.getContext().getString(0x7f070346);
            view = Integer.valueOf(((at) (obj)).e());
            viewgroup = Integer.valueOf(100 - ((at) (obj)).d());
            obj3 = null;
            obj5 = null;
            obj1 = null;
            obj = null;
        } else
        {
            view = null;
            Object obj21 = null;
            obj1 = null;
            obj2 = null;
            obj5 = null;
            obj4 = null;
            obj3 = null;
            viewgroup = ((ViewGroup) (obj));
            obj = obj21;
        }
        if (view == null && true && obj9 == null && view1 == null && obj18 == null && obj15 == null || viewgroup == null)
        {
            d1.setFirstPropertyVisibility(8);
        } else
        {
            d1.setFirstPropertyVisibility(0);
            d1.setFirstPropertyImage((Bitmap)null);
        }
        if (obj12 == null && obj == null || obj8 == null)
        {
            d1.setSecondPropertyVisibility(8);
        } else
        {
            d1.setSecondPropertyVisibility(0);
            d1.setSecondPropertyImage((Bitmap)null);
        }
        if (obj11 == null && true || obj10 == null)
        {
            d1.setThirdPropertyVisibility(8);
        } else
        {
            d1.setThirdPropertyVisibility(0);
            d1.setThirdPropertyImage((Bitmap)null);
        }
        if (obj9 == null && view1 == null)
        {
            d1.setFirstPropertyTwoColorViewVisibility(8);
        } else
        {
            d1.setFirstPropertyTwoColorViewVisibility(0);
        }
        if (obj18 == null && viewgroup1 == null && obj17 == null && integer == null)
        {
            d1.setFirstPropertyFourColorViewVisibility(8);
        } else
        {
            d1.setFirstPropertyFourColorViewVisibility(0);
        }
        if (obj15 == null && obj14 == null && obj13 == null)
        {
            d1.setFirstPropertyThreeColorViewVisibility(8);
        } else
        {
            d1.setFirstPropertyThreeColorViewVisibility(0);
        }
        if (view != null)
        {
            d1.setFirstPropertyColor(view.intValue());
        }
        if (obj12 != null)
        {
            d1.setSecondPropertyColor(((Integer) (obj12)).intValue());
        }
        if (obj11 != null)
        {
            d1.setThirdPropertyColor(((Integer) (obj11)).intValue());
        }
        if (obj9 != null && view1 != null)
        {
            d1.a(((Integer) (obj9)).intValue(), view1.intValue());
        }
        if (obj18 != null && viewgroup1 != null && obj17 != null && integer != null)
        {
            d1.a(((Integer) (obj18)).intValue(), viewgroup1.intValue(), ((Integer) (obj17)).intValue(), integer.intValue());
        }
        if (obj15 != null && obj14 != null && obj13 != null)
        {
            d1.a(((Integer) (obj15)).intValue(), ((Integer) (obj14)).intValue(), ((Integer) (obj13)).intValue(), 0.7F);
        }
        if (false)
        {
            d1.setFirstPropertyImageTexture(com.cyberlink.youcammakeup.pages.editview.savemylook.e.a);
            d1.setFirstPropertyImage(null);
        }
        if (obj != null)
        {
            d1.setSecondPropertyImageTexture(com.cyberlink.youcammakeup.pages.editview.savemylook.e.a);
            d1.setSecondPropertyImage(((String) (obj)));
        }
        if (false)
        {
            d1.setThirdPropertyImageTexture(com.cyberlink.youcammakeup.pages.editview.savemylook.e.a);
            d1.setThirdPropertyImage(null);
        }
        if (viewgroup != null)
        {
            d1.setFirstPropertyIntensity(viewgroup.intValue());
        }
        if (obj8 != null)
        {
            d1.setSecondPropertyIntensity(((Integer) (obj8)).intValue());
        }
        if (obj10 != null)
        {
            d1.setThirdPropertyIntensity(((Integer) (obj10)).intValue());
        }
        if (obj6 != null && obj7 != null)
        {
            view = h.b().a(com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.a(((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType) (obj7))), ((String) (obj6)), ((String) (obj5)));
            d1.setBuyButtonVisibility(8);
            if (view != null && view.c() != null && !view.c().toString().equals(""))
            {
                d1.setBuyButtonVisibility(0);
                d1.setBuyUri(Uri.parse(view.c().toString()));
            }
            d1.setPatternImage(SkuTemplateUtils.a(((String) (obj6)), ((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType) (obj7))));
            d1.setSkuNameTextVisibility(0);
            d1.setSkuNameText(h.b().u(com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType.a(((com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType) (obj7))), ((String) (obj6))));
        } else
        {
            d1.setBuyButtonVisibility(8);
            d1.setSkuNameTextVisibility(8);
            if (beautymode == BeautyMode.b)
            {
                d1.setPatternImage("assets://makeup/skintoner/pattern_foundation.png");
            } else
            if (obj3 != null)
            {
                view = new ArrayList();
                viewgroup = ((List) (obj3)).iterator();
                while (viewgroup.hasNext()) 
                {
                    obj = (String)viewgroup.next();
                    obj = PanelDataCenter.a().p(((String) (obj)));
                    if (obj != null)
                    {
                        view.add(((ax) (obj)).c());
                    }
                    d1.setPatternImages(view);
                }
            } else
            {
                view = PanelDataCenter.a().p(((String) (obj4)));
                if (view != null)
                {
                    view = view.c();
                } else
                {
                    view = null;
                }
                d1.setPatternImage(view);
            }
        }
        if (beautymode == BeautyMode.s || beautymode == BeautyMode.x || beautymode == BeautyMode.j || beautymode == BeautyMode.k || obj6 != null)
        {
            d1.setPatternBackground((Bitmap)null);
        } else
        {
            d1.setPatternBackground("assets://makeup/pattern_general.png");
        }
        d1.setPatternText(((CharSequence) (obj1)));
        d1.setTitle(((CharSequence) (obj2)));
        d1.setSubTitle(null);
        d1.setTag(new c(beautymode, ((String) (obj4))));
        return d1;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int j, int l)
    {
        return false;
    }
}
