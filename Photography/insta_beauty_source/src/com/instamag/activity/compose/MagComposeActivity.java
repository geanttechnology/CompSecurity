// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.compose;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;
import apa;
import apn;
import apq;
import aqx;
import axw;
import azn;
import azr;
import azs;
import azt;
import azu;
import azv;
import azw;
import azx;
import azy;
import azz;
import baa;
import bab;
import bac;
import bad;
import bcn;
import bcv;
import bcx;
import bdg;
import beh;
import ber;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.comlib.ui.HorizontalListView;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.commonview.TResTypeScrollView;
import com.instamag.activity.commonview.TStyleCollectionView;
import com.instamag.activity.library.activity.NewMagCountListActivity;
import com.instamag.activity.library.model.TResTypeManager;
import com.instamag.activity.model.StyleListAdapter;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.activity.link.model.TPhotoLinkComposeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import yp;
import zr;

// Referenced classes of package com.instamag.activity.compose:
//            MagComposeFragement

public class MagComposeActivity extends FullscreenActivity
    implements android.widget.AdapterView.OnItemClickListener, azr, bcx
{

    public static LocationManager h;
    private Button A;
    private Button B;
    private RelativeLayout C;
    private FrameLayout D;
    private FrameLayout E;
    private BroadcastReceiver F;
    private View G;
    private TPhotoComposeInfo H;
    private TPhotoComposeInfo I;
    private FrameLayout J;
    public TStyleCollectionView a;
    HorizontalListView b;
    TResTypeScrollView c;
    FrameLayout d;
    StyleListAdapter e;
    beh f;
    ImageView g;
    public int i;
    protected Handler j;
    public int k;
    boolean l;
    boolean m;
    final int n = 3;
    Runnable o;
    public final LocationListener p = new azw(this);
    private ProgressDialog q;
    private String r;
    private boolean s;
    private ArrayList t;
    private int u;
    private int v;
    private TPhotoMagComposeManager w;
    private ArrayList x;
    private Button y;
    private Button z;

    public MagComposeActivity()
    {
        r = "MagComposeActivity";
        s = false;
        t = null;
        u = 0;
        v = 0;
        x = null;
        F = null;
        i = -1;
        j = new Handler();
        l = true;
        m = false;
        o = new bad(this);
    }

    private int a(List list, int i1)
    {
        if (list != null)
        {
            for (int j1 = 0; j1 < list.size(); j1++)
            {
                if (((TPhotoComposeInfo)list.get(j1)).resId == i1)
                {
                    return j1;
                }
            }

        }
        return -1;
    }

    private List a(int i1, bdg bdg1)
    {
        if (!axw.k(this))
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        List list = apn.a().b();
        if (list != null && list.size() > 0)
        {
            int j1 = 0;
            do
            {
                if (j1 >= list.size())
                {
                    break;
                }
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)list.get(j1);
                if (tphotocomposeinfo.imageCount == i1 && (tphotocomposeinfo.typeId == bdg1.a || bdg1.a == TResTypeManager.KRES_OTHERTYPE && tphotocomposeinfo.typeId == TResTypeManager.KRES_HOLIDAYS) && !c().isExistedByResId(tphotocomposeinfo.resId) && arraylist.size() < 3)
                {
                    arraylist.add(tphotocomposeinfo);
                }
                j1++;
            } while (true);
        }
        return arraylist;
    }

    private List a(int i1, InstaMagType instamagtype)
    {
        if (!axw.k(this))
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        List list = apn.a().b();
        if (list != null && list.size() > 0)
        {
            int j1 = 0;
            do
            {
                if (j1 >= list.size())
                {
                    break;
                }
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)list.get(j1);
                if (tphotocomposeinfo.imageCount == i1 && TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo) == instamagtype && !c().isExistedByResId(tphotocomposeinfo.resId) && arraylist.size() < 3)
                {
                    arraylist.add(tphotocomposeinfo);
                }
                j1++;
            } while (true);
        }
        return arraylist;
    }

    private List a(int i1, List list)
    {
        boolean flag = false;
        List list1;
        if (axw.k(this))
        {
            if ((list1 = apn.a().b()) != null && list1.size() > 0)
            {
                ArrayList arraylist = new ArrayList();
                ArrayList arraylist1 = new ArrayList();
                int j1 = 0;
                while (j1 < list1.size()) 
                {
                    TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)list1.get(j1);
                    if (tphotocomposeinfo.imageCount != i1)
                    {
                        continue;
                    }
                    if (tphotocomposeinfo.typeId == 0)
                    {
                        tphotocomposeinfo.typeId = TResTypeManager.KRES_OTHERTYPE;
                    }
                    if (!arraylist1.contains(Integer.valueOf(tphotocomposeinfo.typeId)))
                    {
                        if (tphotocomposeinfo.typeId == TResTypeManager.KRES_HOLIDAYS)
                        {
                            arraylist1.add(Integer.valueOf(TResTypeManager.KRES_OTHERTYPE));
                        } else
                        {
                            arraylist1.add(Integer.valueOf(tphotocomposeinfo.typeId));
                        }
                    }
                    j1++;
                }
                for (i1 = 0; i1 < list.size(); i1++)
                {
                    bdg bdg1 = (bdg)list.get(i1);
                    if (!arraylist1.contains(Integer.valueOf(bdg1.a)))
                    {
                        arraylist1.add(Integer.valueOf(bdg1.a));
                    }
                }

                if (arraylist1 != null && arraylist1.size() > 0)
                {
                    Collections.sort(arraylist1, new azu(this));
                    for (i1 = ((flag) ? 1 : 0); i1 < arraylist1.size(); i1++)
                    {
                        list = (Integer)arraylist1.get(i1);
                        list = TResTypeManager.instance().getResTypeById(list.intValue());
                        if (list != null && !arraylist.contains(list))
                        {
                            arraylist.add(list);
                        }
                    }

                }
                return arraylist;
            }
        }
        return list;
    }

    private void a(int i1, View view)
    {
        int k2 = b.getAdapter().getCount();
        int l1 = view.getLeft();
        int i2 = view.getRight();
        int j1 = view.getWidth();
        int j2 = b.getWidth();
        int k1 = yp.a(this, 5F);
        if (j1 / 2 + l1 < j2 / 2)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (!j1) goto _L2; else goto _L1
_L1:
        if (i1 <= 0 || e == null) goto _L4; else goto _L3
_L3:
        view = (TPhotoComposeInfo)(TPhotoComposeInfo)e.getItem(i1 - 1);
        i1 = e.getItemWdithByInfo(view);
        if (l1 - (i1 + k1) < 0)
        {
            i1 = (i1 + k1) - l1;
            Log.d(r, (new StringBuilder()).append(r).append(" left scroll:").append(i1).toString());
            b.scrollByHorizolOffset(-i1);
        }
_L6:
        return;
_L4:
        if (i1 != 0) goto _L6; else goto _L5
_L5:
        b.scrollTo(0);
        return;
_L2:
        if (i1 + 1 >= k2 || e == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        view = (TPhotoComposeInfo)(TPhotoComposeInfo)e.getItem(i1 + 1);
        i1 = e.getItemWdithByInfo(view);
        if (k1 * 2 + i1 + i2 <= j2) goto _L6; else goto _L7
_L7:
        i1 = (i1 + k1 * 2 + i2) - j2;
        b.scrollByHorizolOffset(i1);
        Log.d(r, (new StringBuilder()).append(r).append(" right scroll:").append(i1).toString());
        return;
        if (i1 + 1 != k2) goto _L6; else goto _L8
_L8:
        b.scrollByHorizolOffset(i2 - j2);
        return;
    }

    private void a(View view)
    {
        k();
    }

    public static void a(MagComposeActivity magcomposeactivity)
    {
        magcomposeactivity.q();
    }

    public static void a(MagComposeActivity magcomposeactivity, int i1)
    {
        magcomposeactivity.b(i1);
    }

    public static void a(MagComposeActivity magcomposeactivity, int i1, View view)
    {
        magcomposeactivity.a(i1, view);
    }

    public static void a(MagComposeActivity magcomposeactivity, View view)
    {
        magcomposeactivity.b(view);
    }

    private boolean a(String s1, String s2)
    {
        if (s1 == null)
        {
            return s2 == null;
        } else
        {
            return s1.equals(s2);
        }
    }

    private Location b(String s1)
    {
        Location location;
label0:
        {
            location = null;
            try
            {
                if (!h.isProviderEnabled(s1))
                {
                    break label0;
                }
                Log.v("InstaBeautyApplication", (new StringBuilder()).append("InstaBeautyApplication").append(" : ").append("requestLocationUpdates").toString());
                location = h.getLastKnownLocation(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return null;
            }
        }
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if (s1.equalsIgnoreCase("gps"))
        {
            boolean flag;
            if ((new Date(System.currentTimeMillis())).getTime() - location.getTime() > 0xf731400L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                try
                {
                    h.requestLocationUpdates(s1, 10000L, 10F, p);
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    return location;
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    return location;
                }
            }
            return location;
        }
        h.requestLocationUpdates(s1, 10000L, 10F, p);
        return location;
        h.requestLocationUpdates(s1, 10000L, 10F, p);
        return location;
    }

    public static String b(MagComposeActivity magcomposeactivity)
    {
        return magcomposeactivity.r;
    }

    private void b(int i1)
    {
        if (b != null && b.getAdapter() != null)
        {
            StyleListAdapter stylelistadapter = (StyleListAdapter)b.getAdapter();
            if (i1 < stylelistadapter.getCount())
            {
                stylelistadapter.setSelectPosition(i1);
            }
        }
    }

    private void b(View view)
    {
        view = getSupportFragmentManager().findFragmentById(0x7f0d00f6);
        if (view instanceof MagComposeFragement)
        {
            ((MagComposeFragement)view).flipInfo();
        }
    }

    private void b(bdg bdg1)
    {
        boolean flag = false;
        c.setSelectedType(bdg1);
        g();
        if (bdg1.a == TResTypeManager.KSTRIPSTYPEID)
        {
            List list = c().getLinkComposeInfos();
            ArrayList arraylist;
            int i1;
            int j1;
            if (InstaBeautyApplication.c())
            {
                b(list, 105);
                b(list, 107);
                bdg1 = null;
            } else
            {
                bdg1 = null;
            }
        } else
        if (bdg1.a == TResTypeManager.KPORTRAITTYPEID)
        {
            list = c().getInfosByImageCountAndMagType(t.size(), InstaMagType.RECT_LIB_SIZE_TYPE);
            bdg1 = a(t.size(), InstaMagType.RECT_LIB_SIZE_TYPE);
        } else
        if (bdg1.a == TResTypeManager.KSQUARETYPEID)
        {
            list = c().getInfosByImageCountAndMagType(t.size(), InstaMagType.SQ_LIB_SIZE_TYPE);
            bdg1 = a(t.size(), InstaMagType.SQ_LIB_SIZE_TYPE);
        } else
        if (bdg1.a == TResTypeManager.KLANDSCAPETYPEID)
        {
            list = c().getInfosByImageCountAndMagType(t.size(), InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
            bdg1 = a(t.size(), InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
        } else
        if (bdg1.a == TResTypeManager.KRES_COMMONLYUSED)
        {
            list = apq.c().d().getCommonlyUsedInfos(I.imageCount);
            bdg1 = null;
        } else
        {
            list = c().getInfosByImageCountTypeId(t.size(), bdg1.a);
            bdg1 = a(t.size(), bdg1);
        }
        j1 = list.size();
        if (bdg1 != null)
        {
            i1 = bdg1.size();
        } else
        {
            i1 = 0;
        }
        arraylist = new ArrayList(i1 + j1);
        if (bdg1 != null && bdg1.size() > 0)
        {
            for (i1 = 0; i1 < bdg1.size(); i1++)
            {
                arraylist.add((TPhotoComposeInfo)bdg1.get(i1));
            }

        }
        Collections.sort(list, new azt(this));
        if (list != null && list.size() > 0)
        {
            for (i1 = ((flag) ? 1 : 0); i1 < list.size(); i1++)
            {
                arraylist.add((TPhotoComposeInfo)list.get(i1));
            }

        }
        e = new StyleListAdapter(this, r(), arraylist);
        b.setAdapter(e);
        if (I != null)
        {
            i1 = a(arraylist, I.resId);
            if (i1 >= 0)
            {
                e.setSelectPosition(i1);
                g(I);
            }
        }
    }

    public static void b(MagComposeActivity magcomposeactivity, View view)
    {
        magcomposeactivity.a(view);
    }

    private void b(List list, int i1)
    {
        if (list != null && list != null && list.size() > 0)
        {
            int j1 = 0;
            while (j1 < list.size()) 
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)list.get(j1);
                if (tphotocomposeinfo.resId == i1)
                {
                    list.remove(tphotocomposeinfo);
                    return;
                }
                j1++;
            }
        }
    }

    public static TPhotoComposeInfo c(MagComposeActivity magcomposeactivity)
    {
        return magcomposeactivity.H;
    }

    private void c(View view)
    {
        if (view instanceof Button)
        {
            ((Button)view).setEnabled(false);
        }
        if (k == 13)
        {
            FlurryAgent.logEvent("PhotoSave_Continu_Collage");
        } else
        {
            FlurryAgent.logEvent("PhotoSave_Collage");
        }
        if (I != null)
        {
            FotoCustomReport.addStringToArray(FotoCustomReport.instamagfilterUsed, String.valueOf(I.resId));
            apq.c().d().addInfoToCommonlyUsed(I);
        }
        view = getSupportFragmentManager().findFragmentById(0x7f0d00f6);
        if (view instanceof MagComposeFragement)
        {
            ((MagComposeFragement)view).goNext();
        }
    }

    public static void c(MagComposeActivity magcomposeactivity, View view)
    {
        magcomposeactivity.c(view);
    }

    public static void d(MagComposeActivity magcomposeactivity)
    {
        magcomposeactivity.n();
    }

    public static void e(MagComposeActivity magcomposeactivity)
    {
        magcomposeactivity.t();
    }

    private void g(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (e != null && tphotocomposeinfo != null)
        {
            int k1 = e.getIndexByInfo(tphotocomposeinfo);
            int l1 = yp.a(this, 5F);
            if (k1 >= 0 && e != null && k1 < e.getCount())
            {
                int j1 = 0;
                int i1 = 0;
                for (; j1 < k1; j1++)
                {
                    tphotocomposeinfo = (TPhotoComposeInfo)(TPhotoComposeInfo)e.getItem(j1);
                    i1 += e.getItemWdithByInfo(tphotocomposeinfo) + l1;
                }

                if (k1 > 0)
                {
                    tphotocomposeinfo = (TPhotoComposeInfo)(TPhotoComposeInfo)e.getItem(k1 - 1);
                    i1 -= e.getItemWdithByInfo(tphotocomposeinfo) + l1;
                }
                b.scrollByHorizolOffset(i1);
                return;
            }
        }
    }

    private void h(TPhotoComposeInfo tphotocomposeinfo)
    {
        byte byte0 = 4;
        if (tphotocomposeinfo instanceof TPhotoLinkComposeInfo)
        {
            B.setVisibility(4);
        } else
        if (tphotocomposeinfo instanceof TPhotoComposeInfo)
        {
            Button button = B;
            if (tphotocomposeinfo.isHFlip || tphotocomposeinfo.isVFlip)
            {
                byte0 = 0;
            }
            button.setVisibility(byte0);
            return;
        }
    }

    private void i(TPhotoComposeInfo tphotocomposeinfo)
    {
        while (tphotocomposeinfo == null || I != null && I.resId == tphotocomposeinfo.resId) 
        {
            return;
        }
        aqx.b(InstaBeautyApplication.a, "TRESINFOUSED", (new StringBuilder()).append("resInfoUesd_").append(tphotocomposeinfo.resId).toString(), true);
        I = tphotocomposeinfo;
        h(tphotocomposeinfo);
        Log.d(r, (new StringBuilder()).append(r).append(" ").append(String.format("%d", new Object[] {
            Integer.valueOf(tphotocomposeinfo.resId)
        })).toString());
        Log.d(r, (new StringBuilder()).append(r).append(" ").append(tphotocomposeinfo.name).toString());
        if (!(tphotocomposeinfo instanceof TPhotoComposeInfo)) goto _L2; else goto _L1
_L1:
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentById(0x7f0d00f6);
        if (!(fragment instanceof MagComposeFragement)) goto _L4; else goto _L3
_L3:
        ((MagComposeFragement)fragment).reloadNewInfo();
_L2:
        f(tphotocomposeinfo);
        return;
_L4:
        try
        {
            MagComposeFragement magcomposefragement = new MagComposeFragement();
            getSupportFragmentManager().beginTransaction().replace(0x7f0d00f6, magcomposefragement).commitAllowingStateLoss();
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void n()
    {
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentById(0x7f0d00f6);
        if (fragment instanceof MagComposeFragement)
        {
            ((MagComposeFragement)fragment).reloadNewInfo();
        }
    }

    private void o()
    {
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentById(0x7f0d00f6);
        if (fragment instanceof MagComposeFragement)
        {
            ((MagComposeFragement)fragment).hideFilterListView();
        }
    }

    private void p()
    {
        if (a.getVisibility() == 4 || a.getVisibility() == 8)
        {
            a.setVisibility(0);
            D.setVisibility(0);
            android.view.animation.Animation animation = AnimationUtils.loadAnimation(this, 0x7f040027);
            C.startAnimation(animation);
            A.setBackgroundResource(0x7f0200a5);
        }
    }

    private void q()
    {
        if (a.getVisibility() == 0)
        {
            D.setVisibility(4);
            A.setBackgroundResource(0x7f0200a6);
            android.view.animation.Animation animation = AnimationUtils.loadAnimation(this, 0x7f040028);
            C.startAnimation(animation);
            (new Handler()).postDelayed(o, 350L);
        }
    }

    private beh r()
    {
        if (f == null)
        {
            zr zr1 = new zr(getApplicationContext(), ImageCache.b);
            zr1.g = true;
            zr1.d = android.graphics.Bitmap.CompressFormat.JPEG;
            zr1.a(0.05F);
            f = new beh(this, 200);
            f.a(getSupportFragmentManager(), zr1);
        }
        return f;
    }

    private void s()
    {
        Log.v("InstaBeautyApplication", (new StringBuilder()).append("InstaBeautyApplication").append(" : ").append("requestLocation").toString());
        if (h == null)
        {
            h = (LocationManager)getSystemService("location");
        }
        if (p != null)
        {
            h.removeUpdates(p);
        }
        Location location = b("gps");
        Location location1 = b("network");
        if (location != null && location1 != null)
        {
            location = a(location, location1);
            InstaBeautyApplication.d.a(location.getLatitude());
            InstaBeautyApplication.d.b(location.getLongitude());
        } else
        {
            if (location != null)
            {
                InstaBeautyApplication.d.a(location.getLatitude());
                InstaBeautyApplication.d.b(location.getLongitude());
                return;
            }
            if (location1 != null)
            {
                InstaBeautyApplication.d.a(location1.getLatitude());
                InstaBeautyApplication.d.b(location1.getLongitude());
                return;
            }
        }
    }

    private void t()
    {
        bcv.a().b();
    }

    public void OnTypeEditClicked(View view)
    {
        o();
        if (a.getVisibility() == 4 || a.getVisibility() == 8)
        {
            p();
            return;
        } else
        {
            q();
            return;
        }
    }

    protected Location a(Location location, Location location1)
    {
        boolean flag3 = true;
        if (location1 != null)
        {
            long l1 = location.getTime() - location1.getTime();
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (l1 > 0x1d4c0L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (l1 < 0xfffffffffffe2b40L)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (l1 > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag1)
            {
                if (flag2)
                {
                    return location1;
                }
                int i1 = (int)(location.getAccuracy() - location1.getAccuracy());
                boolean flag4;
                if (i1 > 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (i1 < 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (i1 <= 200)
                {
                    flag3 = false;
                }
                flag4 = a(location.getProvider(), location1.getProvider());
                if (!flag2 && (!flag || flag1) && (!flag || flag3 || !flag4))
                {
                    return location1;
                }
            }
        }
        return location;
    }

    protected void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("ACTION_MATERIAL_ADDED");
        intentfilter.addAction("ACTION_MAG_MATERIAL_SHARETOWECHAT");
        intentfilter.addAction(ber.a);
        registerReceiver(F, intentfilter);
    }

    protected void a(int i1)
    {
        b();
        TPhotoComposeInfo tphotocomposeinfo = c().getComposeInfoByResId(i1);
        if (tphotocomposeinfo == null)
        {
            return;
        } else
        {
            i(tphotocomposeinfo);
            b(TResTypeManager.instance().getResTypeById(tphotocomposeinfo.typeId));
            return;
        }
    }

    public void a(bdg bdg1)
    {
        b(bdg1);
    }

    public void a(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo != null)
        {
            H = tphotocomposeinfo;
            if (!(new bcn(this, tphotocomposeinfo)).a() && H != null)
            {
                b(H);
                return;
            }
        }
    }

    public void a(TPhotoComposeInfo tphotocomposeinfo, float f1)
    {
    }

    public void a(String s1)
    {
        while (q != null && q.isShowing() || isFinishing()) 
        {
            return;
        }
        try
        {
            q = ProgressDialog.show(this, "", s1);
            q.setOnCancelListener(new bac(this));
            q.setCancelable(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Crashlytics.logException(s1);
        }
    }

    public void a(ArrayList arraylist)
    {
        if (x != null)
        {
            x.clear();
        }
        x = arraylist;
    }

    public void a(boolean flag)
    {
label0:
        {
            if (A != null)
            {
                if (!flag)
                {
                    break label0;
                }
                A.setVisibility(0);
                h(I);
            }
            return;
        }
        A.setVisibility(0);
        B.setVisibility(4);
    }

    public void b()
    {
        if (q == null || !q.isShowing() || isFinishing())
        {
            break MISSING_BLOCK_LABEL_36;
        }
        q.dismiss();
        q = null;
        return;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        return;
    }

    public void b(TPhotoComposeInfo tphotocomposeinfo)
    {
        bcv.a().a(tphotocomposeinfo, this);
    }

    public void b(boolean flag)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)J.getLayoutParams();
        int i1 = yp.a(this, 25);
        if (flag)
        {
            G.setVisibility(8);
            if (m)
            {
                m = false;
                l = true;
                layoutparams.topMargin = layoutparams.topMargin - i1;
                layoutparams.bottomMargin = i1 + layoutparams.bottomMargin;
                J.requestLayout();
            }
        } else
        {
            G.setVisibility(0);
            if (l)
            {
                m = true;
                l = false;
                layoutparams.topMargin = layoutparams.topMargin + i1;
                layoutparams.bottomMargin = layoutparams.bottomMargin - i1;
                J.requestLayout();
                return;
            }
        }
    }

    public TPhotoMagComposeManager c()
    {
        if (w == null)
        {
            w = apq.c().d();
        }
        return w;
    }

    public void c(TPhotoComposeInfo tphotocomposeinfo)
    {
        a(getResources().getString(0x7f0600e9));
    }

    public TPhotoComposeInfo d()
    {
        if (I == null)
        {
            I = c().getComposeInfoByResId(u);
        }
        return I;
    }

    public void d(TPhotoComposeInfo tphotocomposeinfo)
    {
        try
        {
            if (q != null && !isFinishing())
            {
                q.dismiss();
                q = null;
            }
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        if (tphotocomposeinfo != null)
        {
            i = -1;
            s = true;
            c().MagInfoDownloadFinished(tphotocomposeinfo);
            if (e != null)
            {
                e.replaceAblsulateInfo(tphotocomposeinfo);
            }
            i(tphotocomposeinfo);
        }
    }

    public List e()
    {
        return t;
    }

    public void e(TPhotoComposeInfo tphotocomposeinfo)
    {
        b();
        Toast.makeText(this, getResources().getString(0x7f0600e7), 0).show();
    }

    public ArrayList f()
    {
        return x;
    }

    public void f(TPhotoComposeInfo tphotocomposeinfo)
    {
        boolean flag = true;
        if (tphotocomposeinfo == null) goto _L2; else goto _L1
_L1:
        tphotocomposeinfo = TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo);
        if (tphotocomposeinfo != InstaMagType.RECT_LIB_SIZE_TYPE) goto _L4; else goto _L3
_L3:
        b(flag);
        return;
_L4:
        if (tphotocomposeinfo == InstaMagType.SQ_LIB_SIZE_TYPE)
        {
            flag = false;
        } else
        if (tphotocomposeinfo == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
        {
            flag = false;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void g()
    {
        if (a.getVisibility() == 4 || a.getVisibility() == 8)
        {
            p();
        }
    }

    public void h()
    {
        a.setVisibility(0);
        D.setVisibility(0);
    }

    public void i()
    {
        List list = c().getInfoTypesByImageCount(t.size());
        list = a(t.size(), list);
        List list1 = apq.c().d().getCommonlyUsedInfos(I.imageCount);
        if (list1 != null && list1.size() > 0)
        {
            list.add(0, TResTypeManager.instance().getCommonlyType());
        }
        list.addAll(TResTypeManager.instance().getSpecailList());
        c.setScrollViewWithResTypes(list, this);
    }

    public void j()
    {
        Intent intent = new Intent(this, com/instamag/activity/library/activity/NewMagCountListActivity);
        intent.putExtra("initalInstaMagCount", e().size());
        startActivity(intent);
        overridePendingTransition(0x7f04002d, 0x7f040025);
        FlurryAgent.logEvent("OnLineLibraryCountClicked");
    }

    public void k()
    {
        if (a.getVisibility() == 0)
        {
            D.setVisibility(4);
            a.setVisibility(8);
            return;
        } else
        {
            finish();
            overridePendingTransition(0x10a0002, 0x10a0003);
            return;
        }
    }

    public bdg l()
    {
        return TResTypeManager.instance().getResTypeById(d().typeId);
    }

    public void m()
    {
        if (h != null && p != null)
        {
            Log.v("InstaBeautyApplication", (new StringBuilder()).append("InstaBeautyApplication").append(" : ").append("removeGPSLisenter").toString());
            h.removeUpdates(p);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030072);
        Log.v(r, (new StringBuilder()).append(r).append("onCreate").toString());
        if (bundle == null) goto _L2; else goto _L1
_L1:
        t = bundle.getStringArrayList("SelectedImageUriStrings");
        u = bundle.getInt("SelectedComposeInfoResId");
_L4:
        w = c();
        I = w.getComposeInfoByResId(u);
        D = (FrameLayout)findViewById(0x7f0d024e);
        D.setOnTouchListener(new azs(this));
        J = (FrameLayout)findViewById(0x7f0d00f6);
        G = findViewById(0x7f0d00b0);
        if (!azn.a(this))
        {
            G.setVisibility(8);
        }
        C = (RelativeLayout)findViewById(0x7f0d024f);
        bundle = new MagComposeFragement();
        getSupportFragmentManager().beginTransaction().replace(0x7f0d00f6, bundle).commit();
        E = (FrameLayout)findViewById(0x7f0d00ad);
        A = (Button)findViewById(0x7f0d0253);
        B = (Button)findViewById(0x7f0d0250);
        y = (Button)findViewById(0x7f0d00ae);
        z = (Button)findViewById(0x7f0d01ed);
        B.setOnClickListener(new azx(this));
        y.setOnClickListener(new azy(this));
        z.setOnClickListener(new azz(this));
        a = (TStyleCollectionView)findViewById(0x7f0d0251);
        g = (ImageView)a.findViewById(0x7f0d029e);
        c = (TResTypeScrollView)findViewById(0x7f0d0254);
        d = (FrameLayout)findViewById(0x7f0d0252);
        g.setOnClickListener(new baa(this));
        b = (HorizontalListView)a.findViewById(0x7f0d029d);
        b.setOnItemClickListener(this);
        h(I);
        F = new bab(this);
        a();
        i();
        b(l());
        return;
_L2:
        bundle = getIntent();
        if (bundle != null)
        {
            u = bundle.getIntExtra("SelectedComposeInfoResId", 0);
            t = bundle.getStringArrayListExtra("SelectedImageUriStrings");
            k = bundle.getIntExtra("use_for_flurry_mag", 0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onDestroy()
    {
        b();
        if (x != null)
        {
            for (Iterator iterator = x.iterator(); iterator.hasNext(); iterator.remove())
            {
                Bitmap bitmap = (Bitmap)iterator.next();
                if (bitmap != null && !bitmap.isRecycled())
                {
                    Log.v(r, (new StringBuilder()).append(r).append(" onDestroy recycle bitmap").toString());
                    bitmap.recycle();
                }
            }

        }
        m();
        unregisterReceiver(F);
        super.onDestroy();
        Log.v(r, (new StringBuilder()).append(r).append("onDestroy").toString());
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        if (e != null && e.getItem(i1) != null && (e.getItem(i1) instanceof TPhotoComposeInfo))
        {
            j.post(new azv(this, i1, view));
            adapterview = (TPhotoComposeInfo)e.getItem(i1);
            if (adapterview != null)
            {
                Log.d(r, (new StringBuilder()).append(r).append("selected info resid:").append(((TPhotoComposeInfo) (adapterview)).resId).toString());
                if (adapterview instanceof TPhotoComposeInfo)
                {
                    if (!c().isExistedByResId(((TPhotoComposeInfo) (adapterview)).resId) && !(adapterview instanceof TPhotoLinkComposeInfo))
                    {
                        a(adapterview);
                        return;
                    }
                    i(adapterview);
                    Log.v(r, (new StringBuilder()).append(r).append(" selectedInfo: ").append(((TPhotoComposeInfo) (adapterview)).resId).toString());
                    adapterview = TPhotoComposeInfo.getInstaMagType(adapterview);
                    if (adapterview == InstaMagType.RECT_LIB_SIZE_TYPE)
                    {
                        i1 = 0;
                    } else
                    if (adapterview == InstaMagType.SQ_LIB_SIZE_TYPE)
                    {
                        i1 = 1;
                    } else
                    if (adapterview == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
                    {
                        i1 = 2;
                    } else
                    {
                        i1 = 0;
                    }
                    adapterview = getSharedPreferences("config", 0).edit();
                    adapterview.putInt("lastTypeInt", i1);
                    adapterview.commit();
                    return;
                }
            }
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            k();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    protected void onResume()
    {
        Log.v(r, (new StringBuilder()).append(r).append(" onResume").toString());
        super.onResume();
        FlurryAgent.onPageView();
        if (z != null)
        {
            z.setEnabled(true);
        }
        if (i > 0)
        {
            int i1 = i;
            i = -1;
            a(i1);
        }
        if (!yp.m(this))
        {
            FotoAdFactory.createAdBanner(this, G);
        }
        f(I);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("SelectedComposeInfoResId", u);
        bundle.putStringArrayList("SelectedImageUriStrings", t);
    }

    public void onStart()
    {
        super.onStart();
        Log.v(r, (new StringBuilder()).append(r).append(" onStart").toString());
        if (!InstaBeautyApplication.f)
        {
            s();
        }
    }

    public void onStop()
    {
        if (s)
        {
            s = false;
            apq.c().d().asynArchive();
        }
        super.onStop();
        Log.v(r, (new StringBuilder()).append(r).append(" onStop").toString());
        m();
    }
}
