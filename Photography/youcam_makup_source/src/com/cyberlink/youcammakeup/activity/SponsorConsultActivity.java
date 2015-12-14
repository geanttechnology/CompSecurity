// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKADFromFeatureRoomUsageEvent;
import com.cyberlink.youcammakeup.clflurry.ak;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.j;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.kernelctrl.Camera;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.av;
import com.cyberlink.youcammakeup.widgetpool.common.MultiLangTextView;
import com.pf.common.utility.m;
import java.io.File;
import java.net.URI;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, EditViewActivity, WebViewerExActivity

public class SponsorConsultActivity extends BaseActivity
{

    public static final UUID a = UUID.randomUUID();
    com.cyberlink.youcammakeup.clflurry.YMKADFromFeatureRoomUsageEvent.ButtonName b;
    com.cyberlink.youcammakeup.clflurry.YMKADFromFeatureRoomUsageEvent.ButtonName c;
    private View d;
    private ImageView e;
    private ImageView f;
    private View g;
    private MultiLangTextView h;
    private View i;
    private MultiLangTextView j;
    private View k;
    private View l;
    private com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl m;
    private Uri n;
    private Uri o;
    private Uri p;

    public SponsorConsultActivity()
    {
        b = null;
        c = null;
    }

    static void a(SponsorConsultActivity sponsorconsultactivity)
    {
        sponsorconsultactivity.m();
    }

    static void a(SponsorConsultActivity sponsorconsultactivity, boolean flag)
    {
        sponsorconsultactivity.b(flag);
    }

    static Uri b(SponsorConsultActivity sponsorconsultactivity)
    {
        return sponsorconsultactivity.o;
    }

    private void b(boolean flag)
    {
        k.setClickable(flag);
    }

    static com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl c(SponsorConsultActivity sponsorconsultactivity)
    {
        return sponsorconsultactivity.m;
    }

    static Uri d(SponsorConsultActivity sponsorconsultactivity)
    {
        return sponsorconsultactivity.p;
    }

    static Uri e(SponsorConsultActivity sponsorconsultactivity)
    {
        return sponsorconsultactivity.n;
    }

    private void j()
    {
        d = findViewById(0x7f0c01a7);
        e = (ImageView)findViewById(0x7f0c01a8);
        f = (ImageView)findViewById(0x7f0c01ae);
        k = findViewById(0x7f0c01ab);
        l = findViewById(0x7f0c01ad);
        g = findViewById(0x7f0c01b4);
        h = (MultiLangTextView)findViewById(0x7f0c01b5);
        i = findViewById(0x7f0c01b6);
        j = (MultiLangTextView)findViewById(0x7f0c01b7);
    }

    private void k()
    {
        d.setOnClickListener(new android.view.View.OnClickListener() {

            final SponsorConsultActivity a;

            public void onClick(View view)
            {
                SponsorConsultActivity.a(a, false);
                SponsorConsultActivity.a(a);
            }

            
            {
                a = SponsorConsultActivity.this;
                super();
            }
        });
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final SponsorConsultActivity a;

            public void onClick(View view)
            {
                if (!view.isClickable() || !view.isEnabled() || com.cyberlink.youcammakeup.activity.SponsorConsultActivity.b(a) == null)
                {
                    return;
                }
                SponsorConsultActivity.a(a, false);
                if (SponsorConsultActivity.c(a) != null)
                {
                    view = SponsorConsultActivity.c(a).type;
                    String s = SponsorConsultActivity.c(a).skuGuid;
                    String s1 = SponsorConsultActivity.c(a).itemGuid;
                    com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.h(view, s, s1));
                    if (a.b != null)
                    {
                        com.cyberlink.youcammakeup.clflurry.b.a(new YMKADFromFeatureRoomUsageEvent(s, s1, a.b));
                    }
                }
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                view.putExtra("RedirectUrl", com.cyberlink.youcammakeup.activity.SponsorConsultActivity.b(a).toString());
                a.startActivity(view);
            }

            
            {
                a = SponsorConsultActivity.this;
                super();
            }
        });
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final SponsorConsultActivity a;

            public void onClick(View view)
            {
                if (!view.isClickable() || !view.isEnabled() || SponsorConsultActivity.d(a) == null)
                {
                    return;
                }
                SponsorConsultActivity.a(a, false);
                if (SponsorConsultActivity.c(a) != null)
                {
                    view = SponsorConsultActivity.c(a).type;
                    String s = SponsorConsultActivity.c(a).skuGuid;
                    String s1 = SponsorConsultActivity.c(a).itemGuid;
                    com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.h(view, s, s1));
                    if (a.c != null)
                    {
                        com.cyberlink.youcammakeup.clflurry.b.a(new YMKADFromFeatureRoomUsageEvent(s, s1, a.c));
                    }
                }
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                view.putExtra("RedirectUrl", SponsorConsultActivity.d(a).toString());
                a.startActivity(view);
            }

            
            {
                a = SponsorConsultActivity.this;
                super();
            }
        });
        k.setOnClickListener(new android.view.View.OnClickListener() {

            final SponsorConsultActivity a;

            public void onClick(View view)
            {
                if (!view.isClickable() || !view.isEnabled() || com.cyberlink.youcammakeup.activity.SponsorConsultActivity.e(a) == null)
                {
                    return;
                }
                SponsorConsultActivity.a(a, false);
                if (SponsorConsultActivity.c(a) != null)
                {
                    view = SponsorConsultActivity.c(a).type;
                    String s = SponsorConsultActivity.c(a).skuGuid;
                    String s1 = SponsorConsultActivity.c(a).itemGuid;
                    com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.h(view, s, s1));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKADFromFeatureRoomUsageEvent(s, s1, com.cyberlink.youcammakeup.clflurry.YMKADFromFeatureRoomUsageEvent.ButtonName.a));
                }
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                view.putExtra("RedirectUrl", com.cyberlink.youcammakeup.activity.SponsorConsultActivity.e(a).toString());
                a.startActivity(view);
            }

            
            {
                a = SponsorConsultActivity.this;
                super();
            }
        });
    }

    private boolean l()
    {
        if (m != null) goto _L2; else goto _L1
_L1:
        Object obj;
        return false;
_L2:
        if ((obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().d(m.type, m.skuGuid)) == null) goto _L1; else goto _L3
_L3:
        obj = BitmapFactory.decodeFile(((String) (obj)));
        e.setImageBitmap(((android.graphics.Bitmap) (obj)));
        obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().r(m.type, m.skuGuid);
        if (obj == null) goto _L1; else goto _L4
_L4:
        com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl skutryiturl;
        obj = BitmapFactory.decodeFile(((String) (obj)));
        f.setImageBitmap(((android.graphics.Bitmap) (obj)));
        skutryiturl = m;
        if (StatusManager.j().s() == BeautyMode.s)
        {
            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(skutryiturl.type, com.cyberlink.youcammakeup.kernelctrl.sku.h.b().c(skutryiturl.skuGuid), skutryiturl.patternGuid);
        } else
        {
            obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(skutryiturl.type, skutryiturl.skuGuid, skutryiturl.itemGuid);
        }
        if (obj != null) goto _L6; else goto _L5
_L5:
        k.setVisibility(4);
        l.setVisibility(4);
        g.setVisibility(4);
        h.setVisibility(4);
        i.setVisibility(4);
        j.setVisibility(4);
_L8:
        return true;
_L6:
        String s = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().h(skutryiturl.type, skutryiturl.skuGuid);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_585;
        }
        Object obj1;
        if (!s.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.b.a()))
        {
            break MISSING_BLOCK_LABEL_585;
        }
        k.setVisibility(4);
        l.setVisibility(4);
        obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().i(skutryiturl.type, skutryiturl.skuGuid);
        s = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().j(skutryiturl.type, skutryiturl.skuGuid);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_374;
        }
        if (!((String) (obj1)).equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.b.a()))
        {
            break MISSING_BLOCK_LABEL_374;
        }
        o = Uri.parse(((e) (obj)).d().toString());
        b = com.cyberlink.youcammakeup.clflurry.YMKADFromFeatureRoomUsageEvent.ButtonName.c;
        obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().k(skutryiturl.type, skutryiturl.skuGuid);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_374;
        }
        obj1 = av.a(((av) (obj1)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_374;
        }
        if (!((String) (obj1)).equals(""))
        {
            h.setText(((CharSequence) (obj1)));
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_489;
        }
        if (!s.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.c.a()))
        {
            break MISSING_BLOCK_LABEL_489;
        }
        p = Uri.parse(((e) (obj)).b().toString());
        c = com.cyberlink.youcammakeup.clflurry.YMKADFromFeatureRoomUsageEvent.ButtonName.d;
        i.setBackgroundResource(0x7f020838);
        obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().l(skutryiturl.type, skutryiturl.skuGuid);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = av.a(((av) (obj)));
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((String) (obj)).equals(""))
        {
            j.setText(((CharSequence) (obj)));
        }
        continue; /* Loop/switch isn't completed */
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!s.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent.ActionName.a.a()))
        {
            continue; /* Loop/switch isn't completed */
        }
        p = Uri.parse(((e) (obj)).c().toString());
        c = com.cyberlink.youcammakeup.clflurry.YMKADFromFeatureRoomUsageEvent.ButtonName.b;
        i.setBackgroundResource(0x7f0207f4);
        obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().l(skutryiturl.type, skutryiturl.skuGuid);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = av.a(((av) (obj)));
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((String) (obj)).equals(""))
        {
            j.setText(((CharSequence) (obj)));
        }
        continue; /* Loop/switch isn't completed */
        try
        {
            g.setVisibility(4);
            h.setVisibility(4);
            i.setVisibility(4);
            j.setVisibility(4);
            n = Uri.parse(((e) (obj)).b().toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            k.setVisibility(4);
            l.setVisibility(4);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void m()
    {
        if (m != null)
        {
            String s = m.type;
            String s1 = m.skuGuid;
            String s2 = m.itemGuid;
            com.cyberlink.youcammakeup.clflurry.b.a(new j(s, s1, s2));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKADFromFeatureRoomUsageEvent(s1, s2, com.cyberlink.youcammakeup.clflurry.YMKADFromFeatureRoomUsageEvent.ButtonName.e));
        }
        if (isTaskRoot())
        {
            startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        }
        finish();
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 100)
        {
            com.pf.common.utility.m.e("onActivityResult", (new StringBuilder()).append("resultCode = ").append(String.valueOf(j1)).toString());
            if (j1 == -1)
            {
                intent = Camera.a().b();
                if (intent == null)
                {
                    com.pf.common.utility.m.e("onActivityResult", "capturedPath is null");
                    return;
                } else
                {
                    Camera.a().a(null);
                    StatusManager.j().f(true);
                    StatusManager.j().a(-9L, a);
                    Intent intent1 = new Intent(this, com/cyberlink/youcammakeup/activity/EditViewActivity);
                    intent1.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(intent)));
                    intent1.setAction("android.intent.action.SEND");
                    intent1.putExtra("EXTRA_KEY_SKU_TRY_IT_URL", getIntent().getSerializableExtra("URL_CONTENT"));
                    startActivity(intent1);
                    return;
                }
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001f);
        j();
        k();
        m = (com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl)getIntent().getSerializableExtra("URL_CONTENT");
        if (!l())
        {
            m();
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            m();
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onPause()
    {
        Globals.d().c("sponsorConsultActivity");
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        b(true);
        if (m != null)
        {
            String s = m.type;
            String s1 = m.skuGuid;
            String s2 = m.itemGuid;
            com.cyberlink.youcammakeup.clflurry.b.a(new ak(SkuTemplateUtils.i(s), s1, s2));
        }
        Globals.d().c(null);
    }

}
