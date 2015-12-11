// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.activity;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netverify.sdk.NetverifyDocumentData;
import com.jumio.netverify.sdk.core.BarcodeScannerModel;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.NetverifyModel;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.custom.NetverifyCountry;
import com.jumio.netverify.sdk.custom.NetverifyCustomSDKInterface;
import com.jumio.netverify.sdk.custom.NetverifyDocumentPart;
import com.jumio.netverify.sdk.custom.SDKNotConfiguredException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import jumiomobile.ab;
import jumiomobile.ba;
import jumiomobile.cb;
import jumiomobile.ce;
import jumiomobile.ch;
import jumiomobile.cj;
import jumiomobile.cl;
import jumiomobile.cn;
import jumiomobile.cv;
import jumiomobile.gf;
import jumiomobile.gg;
import jumiomobile.gh;
import jumiomobile.gi;
import jumiomobile.ha;
import jumiomobile.hh;
import jumiomobile.hq;
import jumiomobile.hr;
import jumiomobile.ht;
import jumiomobile.kh;
import jumiomobile.kp;
import jumiomobile.ks;
import jumiomobile.kt;
import jumiomobile.lh;
import jumiomobile.lj;
import jumiomobile.ll;
import jumiomobile.lm;
import jumiomobile.ln;
import jumiomobile.lo;
import jumiomobile.lp;
import jumiomobile.mf;
import jumiomobile.mk;

public final class NetverifyActivity extends AppCompatActivity
    implements NetverifyCustomSDKInterface, lm
{

    private static float e = 0.625F;
    private static float f = 0.775F;
    private ArrayList a;
    private ll b;
    private ModelTemplate c;
    private boolean d;
    private final Object g = new Object();
    private ha h;

    public NetverifyActivity()
    {
        a = null;
        b = null;
    }

    private Fragment a(hr hr1)
    {
        do
        {
            switch (gh.a[hr1.ordinal()])
            {
            case 6: // '\006'
            default:
                return null;

            case 1: // '\001'
                if (d)
                {
                    return kh.a();
                }
                if (h.m())
                {
                    hr1 = hr.d;
                } else
                {
                    return kp.a();
                }
                break;

            case 2: // '\002'
                return ks.a();

            case 3: // '\003'
                h.n();
                if (c.v != null)
                {
                    h.q();
                    hr1 = hr.e;
                } else
                {
                    return lh.a();
                }
                break;

            case 4: // '\004'
                h.o();
                if (h.p() && c.v.getDocumentVariant() == null)
                {
                    return lj.a();
                }
                if (c.F)
                {
                    if (c.v.getDocumentVariant() != null)
                    {
                        h.q();
                        hr1 = hr.g;
                    } else
                    {
                        return lj.a();
                    }
                } else
                {
                    h.q();
                    return kt.a(c.v.getDocumentScanMode(), c.v.getDocumentScanMode().a(), c.v.getDocumentScanSide(), false);
                }
                break;

            case 5: // '\005'
                return lo.a();

            case 7: // '\007'
                return lp.b();
            }
        } while (true);
    }

    private Intent a(int i, String s)
    {
        Intent intent = new Intent();
        intent.putExtra("errorMessage", s);
        intent.putExtra("errorCode", i);
        if (c != null)
        {
            s = c.j;
        } else
        {
            s = null;
        }
        intent.putExtra("scanReference", s);
        return intent;
    }

    public static Intent a(NetverifyActivity netverifyactivity, int i, String s)
    {
        return netverifyactivity.a(i, s);
    }

    public static ha a(NetverifyActivity netverifyactivity)
    {
        return netverifyactivity.h;
    }

    public final void cancelSDK(ht ht1)
    {
        if (h != null)
        {
            h.c();
        }
        finishSDK(a(ht1.a(), ht1.a(this)), 101);
    }

    public final void checkOrientation()
    {
        if (!c.d)
        {
            setRequestedOrientation(1);
            if (getSupportActionBar() != null)
            {
                getSupportActionBar().show();
            }
        }
    }

    public final void closeFragment()
    {
label0:
        {
            synchronized (g)
            {
                if (!isFinishing())
                {
                    break label0;
                }
            }
            return;
        }
        if (a.size() != 0)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        FragmentTransaction fragmenttransaction;
        Fragment fragment = (Fragment)a.get(a.size() - 1);
        fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.remove(fragment);
        a.remove(fragment);
        if (a.size() > 0)
        {
            fragmenttransaction.attach((Fragment)a.get(a.size() - 1));
        }
        fragmenttransaction.commitAllowingStateLoss();
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        ab.a(illegalstateexception);
          goto _L1
    }

    public final void finishSDK(Intent intent, int i)
    {
        synchronized (g)
        {
            setResult(i, intent);
            finish();
            if (c != null)
            {
                c.b.d();
            }
            cb.b();
        }
        return;
        intent;
        obj;
        JVM INSTR monitorexit ;
        throw intent;
    }

    public final ha getController()
    {
        return h;
    }

    public final ModelTemplate getModel()
    {
        return c;
    }

    public final boolean isScanViewNext(hr hr1)
    {
        boolean flag1 = true;
_L13:
        boolean flag = flag1;
        gh.a[hr1.ordinal()];
        JVM INSTR tableswitch 1 7: default 56
    //                   1 60
    //                   2 88
    //                   3 90
    //                   4 123
    //                   5 189
    //                   6 58
    //                   7 191;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        flag = false;
_L7:
        return flag;
_L2:
        flag = flag1;
        if (d) goto _L7; else goto _L9
_L9:
        if (h.m())
        {
            hr1 = hr.d;
        } else
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        return false;
_L4:
        h.n();
        if (c.v != null)
        {
            h.q();
            hr1 = hr.e;
        } else
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        h.o();
        if (h.p() && c.v.getDocumentVariant() == null)
        {
            return false;
        }
        flag = flag1;
        if (!c.F) goto _L7; else goto _L10
_L10:
        if (c.v.getDocumentVariant() != null)
        {
            hr1 = hr.g;
        } else
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        return false;
_L8:
        flag = flag1;
        if (getController().f().size() == 1) goto _L7; else goto _L11
_L11:
        return false;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public final void onBackPressed()
    {
label0:
        {
            boolean flag = true;
            boolean flag1;
            if (b != null)
            {
                flag1 = b.d();
            } else
            {
                flag1 = false;
            }
            if (!flag1)
            {
                if (a.size() <= 1)
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
                closeFragment();
            }
            return;
        }
        cancelSDK(ht.m);
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (c.d)
        {
            int i = cv.a(this, "netverify_dialogToScreenRatioPortrait", "attr");
            int j = cv.a(this, "netverify_dialogToScreenRatioLandscape", "attr");
            Object obj = getTheme().obtainStyledAttributes(new int[] {
                i, j
            });
            Display display = getWindowManager().getDefaultDisplay();
            configuration = new DisplayMetrics();
            display.getMetrics(configuration);
            float f1;
            float f2;
            if (((DisplayMetrics) (configuration)).heightPixels > ((DisplayMetrics) (configuration)).widthPixels)
            {
                f2 = ((TypedArray) (obj)).getFloat(0, 0.0F);
                f1 = e;
            } else
            {
                f2 = ((TypedArray) (obj)).getFloat(1, 0.0F);
                f1 = f;
            }
            if (f2 != 0.0F)
            {
                getWindow().setFlags(2, 2);
                obj = getWindow().getAttributes();
                obj.height = (int)(f2 * (float)((DisplayMetrics) (configuration)).heightPixels);
                obj.width = (int)(f1 * (float)((android.view.WindowManager.LayoutParams) (obj)).height);
                obj.alpha = 1.0F;
                obj.dimAmount = 0.5F;
                getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
            }
        }
    }

    public final void onCreate(Bundle bundle)
    {
        getWindow().requestFeature(13);
        super.onCreate(null);
        ch.a(new cj());
        cl.a(new cn());
        mf.a(this);
        if (c == null && bundle != null)
        {
            cancelSDK(ht.o);
            ba.a();
            NetverifyModel.a();
        } else
        {
            d = getIntent().getBooleanExtra(hh.a, false);
            float f1;
            float f2;
            Object obj;
            Object obj1;
            Display display;
            int i;
            int k;
            if (d)
            {
                obj = BarcodeScannerModel.a(new gi(this, null));
            } else
            {
                obj = NetverifyModel.a(new gi(this, null));
            }
            c = ((ModelTemplate) (obj));
            i = cv.a(this, "netverify_dialogToScreenRatioPortrait", "attr");
            k = cv.a(this, "netverify_dialogToScreenRatioLandscape", "attr");
            obj1 = getTheme().obtainStyledAttributes(new int[] {
                i, k
            });
            display = getWindowManager().getDefaultDisplay();
            obj = new DisplayMetrics();
            display.getMetrics(((DisplayMetrics) (obj)));
            getWindow().addFlags(128);
            if (((DisplayMetrics) (obj)).heightPixels > ((DisplayMetrics) (obj)).widthPixels)
            {
                f2 = ((TypedArray) (obj1)).getFloat(0, 0.0F);
                f1 = e;
            } else
            {
                f2 = ((TypedArray) (obj1)).getFloat(1, 0.0F);
                f1 = f;
            }
            ((TypedArray) (obj1)).recycle();
            if (f2 != 0.0F)
            {
                c.d = true;
                getWindow().setFlags(2, 2);
                obj1 = getWindow().getAttributes();
                obj1.height = (int)(f2 * (float)((DisplayMetrics) (obj)).heightPixels);
                obj1.width = (int)(f1 * (float)((android.view.WindowManager.LayoutParams) (obj1)).height);
                obj1.alpha = 1.0F;
                obj1.dimAmount = 0.5F;
                getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj1)));
            } else
            {
                setRequestedOrientation(1);
            }
            setContentView(mf.a(this));
            a = new ArrayList();
            if (getSupportActionBar() != null)
            {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeButtonEnabled(true);
                int j = cv.a(this, "abc_ic_clear_mtrl_alpha", "drawable");
                getSupportActionBar().setHomeAsUpIndicator(j);
            }
            if (c != null)
            {
                c.a = this;
                if (c.b == null)
                {
                    c.b = new hh(c);
                }
            }
            h = new ha(c, this);
            h.b();
            if (bundle == null)
            {
                showFragment(hr.a);
                return;
            }
        }
    }

    public final void onDestroy()
    {
        if (h != null)
        {
            h.e();
        }
        super.onDestroy();
    }

    public final void onNetverifyCountriesReceived(HashMap hashmap, String s)
    {
        int i = 0;
        s = c;
        boolean flag;
        if (c.F && c.G)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s.F = flag;
        s = (ImageView)findViewById(mf.m);
        if (s != null)
        {
            if (!c.H)
            {
                i = 4;
            }
            s.setVisibility(i);
        }
        if (c.l != null && c.l.length() != 0 && c.m != null)
        {
            s = null;
            if (hashmap.containsKey(c.l))
            {
                s = (NetverifyCountry)hashmap.get(c.l);
            }
            if (s != null && s.getDocumentTypes().contains(c.m))
            {
                h.a(s);
                h.a(c.m);
                h.g();
                return;
            } else
            {
                onNetverifyResourcesLoaded();
                return;
            }
        } else
        {
            onNetverifyResourcesLoaded();
            return;
        }
    }

    public final void onNetverifyError(int i, String s, boolean flag, String s1)
    {
        boolean flag1;
        if (b != null)
        {
            flag1 = b.a(ht.a(i));
        } else
        {
            flag1 = false;
        }
        if (i != 0 && !flag1)
        {
            if (Environment.isLollipop())
            {
                s1 = new android.app.AlertDialog.Builder(this, 5);
            } else
            {
                s1 = new android.app.AlertDialog.Builder(this);
            }
            s1.setMessage(s);
            s1.setTitle(mk.a(this, "dialog_title_error"));
            if (flag)
            {
                s1.setPositiveButton(mk.a(this, "button_retry"), new gf(this));
            }
            s1.setNegativeButton(mk.a(this, "button_cancel"), new gg(this, i, s));
            s1.setCancelable(false);
            s = s1.show();
            s.getButton(-2).setTextColor(ce.b(this, cv.a(this, "netverify_dialogNegativeButtonTextColor", "attr"), 0xff666666));
            s.getButton(-1).setTextColor(ce.b(this, cv.a(this, "netverify_dialogPositiveButtonTextColor", "attr"), 0xff97be0d));
        }
    }

    public final void onNetverifyFinished(NetverifyDocumentData netverifydocumentdata, String s)
    {
        if (c.F)
        {
            if (b instanceof ln)
            {
                ((ln)b).a();
            }
            return;
        } else
        {
            Intent intent = new Intent();
            intent.putExtra("scanReference", s);
            intent.putExtra("scanData", netverifydocumentdata);
            finishSDK(intent, 100);
            return;
        }
    }

    public final void onNetverifyResourcesLoaded()
    {
        showFragment(hr.b);
    }

    public final void onNetverifyScanForPartFinished(NetverifyDocumentPart netverifydocumentpart, String s, boolean flag)
    {
        if (!c.F)
        {
            try
            {
                h.k();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (NetverifyDocumentPart netverifydocumentpart)
            {
                ab.a(netverifydocumentpart);
            }
            return;
        } else
        {
            closeFragment();
            return;
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            if (b == null || !b.c())
            {
                cancelSDK(ht.m);
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected final void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("model", c);
        super.onSaveInstanceState(bundle);
    }

    public final void registerActivityCallback(ll ll1)
    {
        b = ll1;
    }

    public final void showFragment(Fragment fragment)
    {
label0:
        {
            synchronized (g)
            {
                if (!isFinishing())
                {
                    break label0;
                }
            }
            return;
        }
        FragmentTransaction fragmenttransaction;
        b = null;
        fragmenttransaction = getFragmentManager().beginTransaction();
        if (a.size() > 0)
        {
            Fragment fragment1 = (Fragment)a.get(a.size() - 1);
            if (fragment1 instanceof lo)
            {
                a.remove(fragment1);
            }
            fragmenttransaction.detach(fragment1);
        }
        if (fragment == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        fragmenttransaction.add(mf.R, fragment);
        a.add(fragment);
        fragmenttransaction.commitAllowingStateLoss();
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        fragment;
        obj;
        JVM INSTR monitorexit ;
        throw fragment;
        fragment;
        ab.a(fragment);
          goto _L1
    }

    public final void showFragment(hr hr1)
    {
        showFragment(a(hr1));
    }

}
