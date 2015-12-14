// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.Appboy;
import com.appboy.enums.CardCategory;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.google.android.gms.common.api.GoogleApiClient;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.view.viewpagerindicator.CirclePageIndicator;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.GetWhatsNewController;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.WhatsNewResponse;
import com.socialin.android.apiv3.request.WhatsNewParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import myobfuscated.e.a;
import myobfuscated.e.b;
import myobfuscated.f.m;
import myobfuscated.g.c;
import myobfuscated.g.f;

// Referenced classes of package com.socialin.android.activity:
//            BaseActivity

public class WhatsNewActivity extends BaseActivity
    implements CommonConstants, d
{

    private static final int REQUEST_CROP_IMG_FOR_DRAW = 20;
    private static final int REQUEST_OPEN_IMAGE_CHOOSER_FOR_DRAW = 12;
    private static final int REQUEST_OPEN_IMAGE_CHOOSER_FOR_EDIT = 13;
    private static final int REQUEST_OPEN_IMAGE_CHOOSER_FOR_EFFECT = 11;
    private final String BUNDLE_KEY = "whatsnew_bundle";
    private Appboy appboy;
    private int availableVersionCode;
    private GoogleApiClient client;
    private e displayOptions;
    private b feedUpdatedSubscriber;
    private boolean forAppBoyNews;
    private com.picsart.studio.d glideLoader;
    private int imageWidth;
    private CirclePageIndicator indicator;
    private TextView messageView;
    private Bundle paramsBundle;
    private View progressView;
    private ViewPager viewPager;

    public WhatsNewActivity()
    {
        forAppBoyNews = false;
    }

    private void checkForUpdatesFromServer()
    {
        int i = 0;
        int j = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        i = j;
_L2:
        int k = SocialinV3.getInstance().getAppProps().getData().getAppLastVersion();
        if (k > i)
        {
            availableVersionCode = k;
        }
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void disallowTouchEvent(View view)
    {
        view.setOnTouchListener(new android.view.View.OnTouchListener(view) {

            private View a;

            public final boolean onTouch(View view1, MotionEvent motionevent)
            {
                if (view1.getId() == a.getId())
                {
                    view1.getParent().requestDisallowInterceptTouchEvent(true);
                    if ((motionevent.getAction() & 0xff) == 1)
                    {
                        view1.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }

            
            {
                a = view;
                super();
            }
        });
    }

    private void getAppNews(String s1)
    {
        try
        {
            appboy.removeSingleSubscription(feedUpdatedSubscriber, myobfuscated/e/a);
            feedUpdatedSubscriber = new b(s1) {

                final String a;
                final WhatsNewActivity b;

                public final void trigger(Object obj)
                {
                    a a1;
                    ArrayList arraylist;
                    int i;
                    int j;
                    a1 = (a)obj;
                    j = a1.b(CardCategory.ALL_CATEGORIES);
                    arraylist = new ArrayList();
                    i = 0;
_L16:
                    if (i >= j) goto _L2; else goto _L1
_L1:
                    obj = (c)a1.a(CardCategory.ALL_CATEGORIES).get(i);
                    if (!((c) (obj)).c().equals(a)) goto _L4; else goto _L3
_L3:
                    if (!(obj instanceof myobfuscated.g.b)) goto _L6; else goto _L5
_L5:
                    String s2;
                    String s3;
                    String s4;
                    String s5;
                    s5 = ((myobfuscated.g.b)obj).b;
                    s4 = ((myobfuscated.g.b)obj).d;
                    s3 = ((myobfuscated.g.b)obj).c;
                    s2 = ((myobfuscated.g.b)obj).a;
                    obj = ((myobfuscated.g.b)obj).e;
_L14:
                    com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem whatsnewitem = new com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem();
                    whatsnewitem.data = new com.socialin.android.apiv3.model.WhatsNewResponse.Data();
                    whatsnewitem.data.title = s5;
                    whatsnewitem.data.text = s3;
                    whatsnewitem.data.link = s4;
                    whatsnewitem.data.linkName = ((String) (obj));
                    whatsnewitem.data.photoUrl = s2;
                    arraylist.add(whatsnewitem);
_L4:
                    i++;
                    continue; /* Loop/switch isn't completed */
_L6:
                    if (!(obj instanceof myobfuscated.g.e)) goto _L8; else goto _L7
_L7:
                    s5 = ((myobfuscated.g.e)obj).c;
                    s4 = ((myobfuscated.g.e)obj).d;
                    s3 = ((myobfuscated.g.e)obj).a;
                    s2 = ((myobfuscated.g.e)obj).b;
                    obj = ((myobfuscated.g.e)obj).e;
                      goto _L9
_L8:
                    if (!(obj instanceof myobfuscated.g.a)) goto _L11; else goto _L10
_L10:
                    s2 = ((myobfuscated.g.a)obj).a;
                    obj = ((myobfuscated.g.a)obj).c;
                    s3 = null;
                    s4 = null;
                    s5 = null;
                      goto _L9
_L11:
                    if (obj instanceof myobfuscated.g.d) goto _L13; else goto _L12
_L12:
                    if (obj instanceof f)
                    {
                        s5 = ((f)obj).b;
                        s4 = ((f)obj).c;
                        s3 = ((f)obj).a;
                        obj = ((f)obj).d;
                        s2 = null;
                    } else
                    {
                        obj = null;
                        s2 = null;
                        s3 = null;
                        s4 = null;
                        s5 = null;
                    }
_L9:
                    if (true) goto _L14; else goto _L13
_L2:
                    b.runOnUiThread(new Runnable(this, arraylist) {

                        private ArrayList a;
                        private _cls2 b;

                        public final void run()
                        {
                            b.b.progressView.setVisibility(8);
                            b.b.viewPager.setVisibility(0);
                            b.b.init(a);
                            if (a.size() > 0)
                            {
                                Appboy.getInstance(b.b).logFeedCardImpression(b.a);
                            }
                        }

            
            {
                b = _pcls2;
                a = arraylist;
                super();
            }
                    });
_L13:
                    return;
                    if (true) goto _L16; else goto _L15
_L15:
                }

            
            {
                b = WhatsNewActivity.this;
                a = s1;
                super();
            }
            };
            appboy.subscribeToFeedUpdates(feedUpdatedSubscriber);
            appboy.requestFeedRefresh();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.socialin.android.d.a(s1.getMessage(), s1);
        }
    }

    private double getScreenSmallSize()
    {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        float f = getResources().getDisplayMetrics().density;
        return (double)Math.min((float)displaymetrics.widthPixels / f, (float)displaymetrics.heightPixels / f);
    }

    private void init(ArrayList arraylist)
    {
        if (arraylist == null || arraylist.size() == 0)
        {
            Utils.c(this, getString(0x7f080449));
            finish();
        } else
        {
            WhatsNewAdapter whatsnewadapter = new WhatsNewAdapter(this, arraylist);
            viewPager.setAdapter(whatsnewadapter);
            indicator.setViewPager(viewPager);
            indicator.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

                private WhatsNewActivity a;

                public final void onPageScrollStateChanged(int i)
                {
                }

                public final void onPageScrolled(int i, float f, int j)
                {
                }

                public final void onPageSelected(int i)
                {
                    com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem whatsnewitem = ((WhatsNewAdapter)a.viewPager.getAdapter()).getItem(i);
                    a.initButtons(whatsnewitem);
                }

            
            {
                a = WhatsNewActivity.this;
                super();
            }
            });
            indicator.setCurrentItem(0);
            initButtons(whatsnewadapter.getItem(0));
            if (arraylist.size() == 1)
            {
                indicator.setVisibility(4);
                return;
            }
        }
    }

    private void initButtons(com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem whatsnewitem)
    {
        Button button = (Button)findViewById(0x7f100a4a);
        button.setOnClickListener(new android.view.View.OnClickListener(whatsnewitem) {

            private com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem a;
            private WhatsNewActivity b;

            public final void onClick(View view)
            {
                if (b.availableVersionCode > 0)
                {
                    b.openAppInMarket();
                    return;
                } else
                {
                    b.openItem(a);
                    return;
                }
            }

            
            {
                b = WhatsNewActivity.this;
                a = whatsnewitem;
                super();
            }
        });
        if (availableVersionCode > 0)
        {
            button.setVisibility(0);
            button.setText(getString(0x7f080366));
        } else
        {
            if (whatsnewitem == null)
            {
                whatsnewitem = null;
            } else
            {
                whatsnewitem = whatsnewitem.getActionButton();
            }
            if (whatsnewitem != null && !TextUtils.isEmpty(((com.socialin.android.apiv3.model.WhatsNewResponse.ActionButton) (whatsnewitem)).action))
            {
                button.setVisibility(0);
                if (!TextUtils.isEmpty(((com.socialin.android.apiv3.model.WhatsNewResponse.ActionButton) (whatsnewitem)).title))
                {
                    if (((com.socialin.android.apiv3.model.WhatsNewResponse.ActionButton) (whatsnewitem)).title.equals(getString(0x7f08035c)))
                    {
                        button.setText(getString(0x7f08035c));
                        return;
                    } else
                    {
                        button.setText(((com.socialin.android.apiv3.model.WhatsNewResponse.ActionButton) (whatsnewitem)).title);
                        return;
                    }
                }
            } else
            {
                button.setVisibility(8);
                return;
            }
        }
    }

    private void openAppInMarket()
    {
        String s1 = getPackageName();
        Intent intent = new Intent("android.intent.action.VIEW");
        String s2 = getString(m.e(this, (new StringBuilder("market_url_")).append(getString(0x7f0808c8)).toString()));
        if (TextUtils.isEmpty(s2))
        {
            intent.setData(Uri.parse((new StringBuilder("market://details?id=")).append(s1).toString()));
        } else
        {
            intent.setData(Uri.parse((new StringBuilder()).append(s2).append(s1).toString()));
        }
        try
        {
            startActivity(intent);
            return;
        }
        catch (Exception exception)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://play.google.com/store/apps/details?id=")).append(s1).toString())));
        }
    }

    private void openChoosePhoto(int i, boolean flag, boolean flag1)
    {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), "com.picsart.studio.ImagePickerActivity");
        intent.putExtra("showCameraEffects", true);
        intent.putExtra("showPicsart", true);
        intent.putExtra("extra.for.main.activity", true);
        startActivityForResult(intent, i);
    }

    private void openCropImage(String s1, int i, HashMap hashmap, int j)
    {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), "com.socialin.android.photo.crop.CropImage");
        intent.putExtra("imagePath", s1);
        intent.putExtra("bufferData", hashmap);
        intent.putExtra("noFaceDetection", false);
        intent.putExtra("degree", i);
        intent.putExtra("scale", true);
        intent.putExtra("maxPixel", PicsartContext.a.getMaxImageSizePixel());
        startActivityForResult(intent, j);
    }

    private void openEdit(String s1, HashMap hashmap, int i)
    {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), "com.picsart.studio.editor.activity.EditorActivity");
        if (paramsBundle != null)
        {
            intent.putExtras(paramsBundle);
        }
        intent.putExtra("path", s1);
        intent.putExtra("degree", i);
        intent.putExtra("bufferData", hashmap);
        startActivity(intent);
    }

    private void openEffects(String s1, HashMap hashmap, int i, String s2, String s3)
    {
        AnalyticUtils.getInstance(this).trackLocalAction("whatsnew:openEffect");
        Intent intent = new Intent();
        if (SocialinV3.getInstance().getAppProps() != null && SocialinV3.getInstance().getAppProps().getProcess().equals("multy"))
        {
            intent.setClassName(getPackageName(), "com.picsart.effects.activity.EffectsActivity");
        } else
        {
            intent.setClassName(getPackageName(), "com.picsart.effects.activity.EffectsActivityMainProcess");
        }
        if (paramsBundle != null)
        {
            intent.putExtras(paramsBundle);
        }
        intent.putExtra("path", s1);
        intent.putExtra("bufferData", hashmap);
        intent.putExtra("degree", i);
        intent.putExtra("closeAfterEdit", true);
        intent.putExtra("fx_pixels_max_count", PicsartContext.a(this));
        intent.putExtra("imageSource", s2);
        intent.putExtra("origImagePath", s3);
        startActivity(intent);
    }

    private void openItem(com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem whatsnewitem)
    {
        com.socialin.android.apiv3.model.WhatsNewResponse.ActionButton actionbutton;
        if (whatsnewitem == null)
        {
            actionbutton = null;
        } else
        {
            actionbutton = whatsnewitem.getActionButton();
        }
        if (actionbutton != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (actionbutton.activityParams != null)
        {
            paramsBundle = new Bundle();
            int i = 0;
            while (i < actionbutton.activityParams.size()) 
            {
                whatsnewitem = (com.socialin.android.apiv3.model.WhatsNewResponse.ActivityParams)actionbutton.activityParams.get(i);
                if (whatsnewitem != null && !TextUtils.isEmpty(((com.socialin.android.apiv3.model.WhatsNewResponse.ActivityParams) (whatsnewitem)).value))
                {
                    if ("int".equalsIgnoreCase(((com.socialin.android.apiv3.model.WhatsNewResponse.ActivityParams) (whatsnewitem)).type))
                    {
                        paramsBundle.putInt(((com.socialin.android.apiv3.model.WhatsNewResponse.ActivityParams) (whatsnewitem)).name, Integer.parseInt(((com.socialin.android.apiv3.model.WhatsNewResponse.ActivityParams) (whatsnewitem)).value));
                    } else
                    if ("boolean".equalsIgnoreCase(((com.socialin.android.apiv3.model.WhatsNewResponse.ActivityParams) (whatsnewitem)).type))
                    {
                        paramsBundle.putBoolean(((com.socialin.android.apiv3.model.WhatsNewResponse.ActivityParams) (whatsnewitem)).name, Boolean.parseBoolean(((com.socialin.android.apiv3.model.WhatsNewResponse.ActivityParams) (whatsnewitem)).value));
                    } else
                    {
                        paramsBundle.putString(((com.socialin.android.apiv3.model.WhatsNewResponse.ActivityParams) (whatsnewitem)).name, ((com.socialin.android.apiv3.model.WhatsNewResponse.ActivityParams) (whatsnewitem)).value);
                    }
                }
                i++;
            }
        }
        if (TextUtils.isEmpty(actionbutton.action))
        {
            break MISSING_BLOCK_LABEL_358;
        }
        if (!actionbutton.action.equals("open_effect"))
        {
            break; /* Loop/switch isn't completed */
        }
        openChoosePhoto(11, true, false);
        whatsnewitem = null;
_L4:
        if (!TextUtils.isEmpty(actionbutton.actionUrl))
        {
            whatsnewitem = new Intent("android.intent.action.VIEW", Uri.parse(actionbutton.actionUrl));
        }
        if (whatsnewitem != null)
        {
            if (paramsBundle != null)
            {
                whatsnewitem.putExtras(paramsBundle);
            }
            startActivity(whatsnewitem);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (actionbutton.action.equals("open_draw"))
        {
            openChoosePhoto(12, true, false);
            whatsnewitem = null;
        } else
        if (actionbutton.action.equals("open_tools"))
        {
            openChoosePhoto(13, true, false);
            whatsnewitem = null;
        } else
        if (actionbutton.action.equals("open_app_on_market"))
        {
            openAppInMarket();
            whatsnewitem = null;
        } else
        {
            if (actionbutton.activityName == null)
            {
                break MISSING_BLOCK_LABEL_358;
            }
            whatsnewitem = new Intent();
            whatsnewitem.setClassName(getApplicationContext(), actionbutton.activityName);
        }
          goto _L4
        whatsnewitem = null;
          goto _L4
    }

    private void openPhotoDraw(String s1, HashMap hashmap, int i)
    {
        AnalyticUtils.getInstance(this).trackLocalAction("whatsnew:openDraw");
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), "com.socialin.android.photo.draw.DrawingActivity");
        if (paramsBundle != null)
        {
            intent.putExtras(paramsBundle);
        }
        intent.putExtra("extra.has.bg.image", true);
        intent.putExtra("extra.is.new.project", true);
        intent.putExtra("extra.project.name", FileUtils.c(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/PicsArt/drawing/").toString()), "Drawing "));
        intent.putExtra("path", s1);
        intent.putExtra("bufferData", hashmap);
        intent.putExtra("degree", i);
        intent.putExtra("comingFrom", 1);
        startActivity(intent);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        HashMap hashmap;
        hashmap = null;
        super.onActivityResult(i, j, intent);
        if (j != -1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR lookupswitch 4: default 60
    //                   11: 61
    //                   12: 138
    //                   13: 189
    //                   20: 242;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        return;
_L3:
        String s1 = intent.getExtras().getString("path");
        i = intent.getExtras().getInt("degree");
        String s2 = intent.getStringExtra("source");
        String s3 = intent.getStringExtra("origFile");
        if (intent.hasExtra("bufferData"))
        {
            hashmap = (HashMap)intent.getSerializableExtra("bufferData");
        }
        openEffects(s1, hashmap, i, s2, s3);
        return;
_L4:
        Object obj;
        Bundle bundle;
        if (intent.hasExtra("bufferData"))
        {
            obj = (HashMap)intent.getSerializableExtra("bufferData");
        } else
        {
            obj = null;
        }
        openCropImage(intent.getExtras().getString("path"), intent.getExtras().getInt("degree"), ((HashMap) (obj)), 20);
        return;
_L5:
        obj = intent.getExtras().getString("path");
        i = intent.getExtras().getInt("degree");
        if (intent.hasExtra("bufferData"))
        {
            intent = (HashMap)intent.getSerializableExtra("bufferData");
        } else
        {
            intent = null;
        }
        openEdit(((String) (obj)), intent, i);
        return;
_L6:
        bundle = intent.getExtras();
        obj = bundle.getString("path");
        i = bundle.getInt("degree");
        if (intent.hasExtra("bufferData"))
        {
            intent = (HashMap)intent.getSerializableExtra("bufferData");
        } else
        {
            intent = null;
        }
        openPhotoDraw(((String) (obj)), intent, i);
        return;
    }

    public void onCancelRequest(WhatsNewResponse whatsnewresponse, Request request)
    {
    }

    public volatile void onCancelRequest(Object obj, Request request)
    {
        onCancelRequest((WhatsNewResponse)obj, request);
    }

    protected void onCreate(Bundle bundle)
    {
        float f;
        int i;
        boolean flag;
        int j;
        int k;
        super.onCreate(bundle);
        setContentView(0x7f030237);
        ((ImageView)findViewById(0x7f100117)).setOnClickListener(new android.view.View.OnClickListener() {

            private WhatsNewActivity a;

            public final void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = WhatsNewActivity.this;
                super();
            }
        });
        if (getScreenSmallSize() > 400D)
        {
            ((ImageView)findViewById(0x7f100117)).setImageResource(0x7f020323);
        }
        AnalyticUtils.getInstance(this).trackLocalAction("whatsnew:onCreate");
        int i1;
        if (getIntent() != null && getIntent().hasExtra("version_code"))
        {
            availableVersionCode = getIntent().getIntExtra("version_code", -1);
        } else
        {
            checkForUpdatesFromServer();
        }
        try
        {
            appboy = Appboy.getInstance(getApplicationContext());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            if (com.socialin.android.d.b)
            {
                bundle.getMessage();
            } else
            {
                ExceptionReportService.report(getApplicationContext(), bundle, SocialinV3.getInstance().getUser().id);
            }
        }
        viewPager = (ViewPager)findViewById(0x7f100a48);
        indicator = (CirclePageIndicator)findViewById(0x7f100a49);
        progressView = findViewById(0x7f100a46);
        messageView = (TextView)findViewById(0x7f100a47);
        j = getResources().getDisplayMetrics().widthPixels;
        k = getResources().getDisplayMetrics().heightPixels;
        if (getResources().getConfiguration().orientation == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i1 = getResources().getConfiguration().screenLayout & 0xf;
        if (k < j)
        {
            f = (float)k * 0.85F;
        } else
        {
            f = (float)k * 0.7F;
        }
        i = (int)f;
        imageWidth = (int)Utils.a(300F, this);
        i1;
        JVM INSTR tableswitch 0 4: default 292
    //                   0 659
    //                   1 659
    //                   2 597
    //                   3 556
    //                   4 527;
           goto _L1 _L2 _L2 _L3 _L4 _L5
_L2:
        break MISSING_BLOCK_LABEL_659;
_L1:
        f = 1.5F;
_L6:
        if (flag)
        {
            findViewById(0x7f100a45).getLayoutParams().width = (int)((float)imageWidth * f);
            findViewById(0x7f100a45).getLayoutParams().height = (int)((float)k * 0.8F);
            imageWidth = (int)((double)imageWidth / 1.3D);
        } else
        {
            findViewById(0x7f100a45).getLayoutParams().width = imageWidth;
            findViewById(0x7f100a45).getLayoutParams().height = i;
        }
        if (i1 == 4)
        {
            imageWidth = (int)Utils.a(533F, this);
            findViewById(0x7f100a45).getLayoutParams().width = (int)Utils.a(565F, this);
            findViewById(0x7f100a45).getLayoutParams().height = (int)Math.min((float)imageWidth + (float)imageWidth / 3F, (float)k * 0.85F);
        }
        if (viewPager.getAdapter() != null)
        {
            break MISSING_BLOCK_LABEL_764;
        }
        if (!s.a(this))
        {
            Utils.c(this, getString(0x7f080423));
            finish();
            return;
        }
        break MISSING_BLOCK_LABEL_705;
_L5:
        imageWidth = (int)Utils.a(533F, this);
        i = (k * 80) / 100;
        f = 1.15F;
          goto _L6
_L4:
        if (flag)
        {
            j = (int)Utils.a(520F, this);
        } else
        {
            j = (int)Utils.a(450F, this);
        }
        imageWidth = j;
        f = 1.15F;
          goto _L6
_L3:
        if (j <= 480 || k <= 480)
        {
            i = (k * 85) / 100;
            f = 1.5F;
        } else
        {
            imageWidth = (int)Utils.a(320F, this);
            i = (k * 80) / 100;
            f = 1.5F;
        }
          goto _L6
        i = k;
        f = 1.5F;
          goto _L6
        progressView.setVisibility(0);
        viewPager.setVisibility(8);
        if (getIntent() != null && getIntent().hasExtra("appboy_news_id"))
        {
            forAppBoyNews = true;
            getAppNews(getIntent().getExtras().getString("appboy_news_id"));
        } else
        {
            bundle = new GetWhatsNewController();
            WhatsNewParams whatsnewparams = new WhatsNewParams();
            if (availableVersionCode > 0)
            {
                whatsnewparams.version = String.valueOf(availableVersionCode);
            }
            bundle.setRequestParams(whatsnewparams);
            bundle.setRequestCompleteListener(this);
            bundle.doRequest();
        }
        client = m.a(this);
        e.c(getApplicationContext());
        displayOptions = e.b(l.a);
        glideLoader = new com.picsart.studio.d(getApplicationContext());
        return;
    }

    protected void onDestroy()
    {
        try
        {
            appboy.removeSingleSubscription(feedUpdatedSubscriber, myobfuscated/e/a);
        }
        catch (Exception exception)
        {
            if (com.socialin.android.d.b)
            {
                exception.getMessage();
            } else
            {
                ExceptionReportService.report(getApplicationContext(), exception, SocialinV3.getInstance().getUser().id);
            }
        }
        if (viewPager != null && viewPager.getAdapter() != null)
        {
            ((WhatsNewAdapter)viewPager.getAdapter()).clear();
        }
        super.onDestroy();
    }

    public void onFailure(Exception exception, Request request)
    {
        progressView.setVisibility(8);
        exception.printStackTrace();
        messageView.setText(getString(0x7f0805ca));
        messageView.setVisibility(0);
    }

    public transient void onProgressUpdate(Integer ainteger[])
    {
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (bundle != null && bundle.containsKey("whatsnew_bundle"))
        {
            paramsBundle = bundle.getBundle("whatsnew_bundle");
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.putBundle("whatsnew_bundle", paramsBundle);
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        super.onStart();
        if (client != null)
        {
            client.connect();
            m.a(client, "http://schema.org/ViewAction", getString(0x7f080675), "android-app://com.picsart.studio/picsart/whatsnew");
        }
    }

    protected void onStop()
    {
        super.onStop();
        if (client != null)
        {
            m.b(client, "http://schema.org/ViewAction", getString(0x7f080675), "android-app://com.picsart.studio/picsart/whatsnew");
            client.disconnect();
        }
    }

    public void onSuccess(WhatsNewResponse whatsnewresponse, Request request)
    {
        progressView.setVisibility(8);
        if (whatsnewresponse == null || whatsnewresponse.response == null)
        {
            messageView.setText(getString(0x7f0805ca));
            messageView.setVisibility(0);
            return;
        }
        if (whatsnewresponse.response.size() == 0)
        {
            messageView.setText(getString(0x7f0805bd));
            messageView.setVisibility(0);
            return;
        } else
        {
            viewPager.setVisibility(0);
            init(whatsnewresponse.response);
            return;
        }
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((WhatsNewResponse)obj, request);
    }













    private class WhatsNewAdapter extends PagerAdapter
    {

        private Context context;
        private boolean isLowMemory;
        private ArrayList itemList;
        final WhatsNewActivity this$0;

        private void clear()
        {
            itemList.clear();
        }

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            if (viewgroup == null || obj == null)
            {
                return;
            }
            if (viewgroup.getChildCount() > 0 && i < viewgroup.getChildCount())
            {
                try
                {
                    viewgroup.removeView((View)obj);
                }
                // Misplaced declaration of an exception variable
                catch (ViewGroup viewgroup)
                {
                    viewgroup.printStackTrace();
                }
            }
            notifyDataSetChanged();
        }

        public int getCount()
        {
            return itemList.size();
        }

        public com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem getItem(int i)
        {
            com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem whatsnewitem;
            try
            {
                whatsnewitem = (com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem)itemList.get(i);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return null;
            }
            return whatsnewitem;
        }

        public int getItemPosition(Object obj)
        {
            return super.getItemPosition(obj);
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            Object obj;
            TextView textview;
            TextView textview1;
            WebView webview;
            View view1;
            ImageView imageview;
            Object obj1;
            View view = LayoutInflater.from(context).inflate(0x7f030238, null);
            imageview = (ImageView)view.findViewById(0x7f100a4c);
            textview = (TextView)view.findViewById(0x7f100a51);
            textview1 = (TextView)view.findViewById(0x7f100a53);
            webview = (WebView)view.findViewById(0x7f100a52);
            if (forAppBoyNews && getResources().getConfiguration().orientation == 2)
            {
                disallowTouchEvent(webview);
            }
            int j = getResources().getConfiguration().screenLayout;
            int k = getResources().getConfiguration().orientation;
            if ((j & 0xf) == 3 && k == 2)
            {
                webview.getSettings().setDefaultFontSize(18);
            }
            obj = view.findViewById(0x7f100a4f);
            view1 = view.findViewById(0x7f100a50);
            obj1 = view.findViewById(0x7f100a4e);
            Object obj2;
            if (availableVersionCode > 0)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            ((View) (obj1)).setVisibility(j);
            obj1 = (com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem)itemList.get(i);
            ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1))) {

                private com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem a;
                private WhatsNewAdapter b;

                public final void onClick(View view2)
                {
                    view2 = new Intent("android.intent.action.VIEW", Uri.parse(a.getUrl()));
                    b._fld0.startActivity(view2);
                }

                
                {
                    b = WhatsNewAdapter.this;
                    a = whatsnewitem;
                    super();
                }
            });
            if (!TextUtils.isEmpty(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getUrl()))
            {
                ((View) (obj)).setVisibility(0);
            } else
            {
                ((View) (obj)).setVisibility(8);
            }
            if (TextUtils.isEmpty(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getPhotoUrl()))
            {
                break MISSING_BLOCK_LABEL_719;
            }
            imageview.getLayoutParams().height = imageWidth;
            imageview.getLayoutParams().width = imageWidth;
            obj2 = new android.view.View.OnClickListener(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1))) {

                private com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem a;
                private WhatsNewAdapter b;

                public final void onClick(View view2)
                {
                    view2 = new Intent("android.intent.action.VIEW");
                    view2.setData(Uri.parse(a.data.link));
                    view2.putExtra("title", a.data.title);
                    b._fld0.startActivity(view2);
                }

                
                {
                    b = WhatsNewAdapter.this;
                    a = whatsnewitem;
                    super();
                }
            };
            view1.setVisibility(0);
            if (!((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getUrl().contains(".gif")) goto _L2; else goto _L1
_L1:
            obj = Uri.parse(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getUrl()).toString();
_L3:
            imageview.setVisibility(0);
            imageview.setTag(0x2f0e24fb, view1);
            if (!TextUtils.isEmpty(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).data.link) && forAppBoyNews)
            {
                imageview.setOnClickListener(((android.view.View.OnClickListener) (obj2)));
            }
            displayOptions.a(0x7f0201f8);
            obj2 = glideLoader;
            if (isLowMemory && !((String) (obj)).contains(".gif"))
            {
                obj = (new StringBuilder()).append(((String) (obj))).append(ImageItem.prefixThumb).toString();
            }
            ((com.picsart.studio.d) (obj2)).a(((String) (obj)), imageview, (e)((e)e.b(l.a).b(glideLoader.a)).a(0x7f0201f8), new com.bumptech.glide.request.d(view1) {

                private View a;

                public final boolean a(Object obj3)
                {
                    a.setVisibility(8);
                    return false;
                }

                
                {
                    a = view;
                    super();
                }
            });
_L4:
            if (view.findViewById(0x7f100a54) != null)
            {
                view.findViewById(0x7f100a54).getLayoutParams().height = imageWidth;
            }
            Exception exception;
            if (!TextUtils.isEmpty(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getTitle()))
            {
                textview.setVisibility(0);
                textview.setText(Html.fromHtml(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getTitle()));
            } else
            {
                textview.setVisibility(8);
            }
            if (!TextUtils.isEmpty(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getText()))
            {
                webview.setVisibility(0);
                webview.loadData(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getText(), "text/html", com.socialin.android.util.e.a.name());
                if (textview.getVisibility() != 0)
                {
                    ((android.widget.LinearLayout.LayoutParams)webview.getLayoutParams()).topMargin = (int)Utils.a(7F, context);
                }
            } else
            {
                webview.setVisibility(8);
            }
            if (!TextUtils.isEmpty(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getLink()))
            {
                textview1.setPaintFlags(8);
                textview1.setVisibility(0);
                if (!TextUtils.isEmpty(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getLinkName()))
                {
                    textview1.setText(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getLinkName());
                }
                textview1.setOnClickListener(new android.view.View.OnClickListener(((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1))) {

                    private com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem a;
                    private WhatsNewAdapter b;

                    public final void onClick(View view2)
                    {
                        view2 = new Intent("android.intent.action.VIEW", Uri.parse(a.getLink()));
                        b._fld0.startActivity(view2);
                    }

                
                {
                    b = WhatsNewAdapter.this;
                    a = whatsnewitem;
                    super();
                }
                });
            } else
            {
                textview1.setVisibility(8);
            }
            viewgroup.addView(view);
            return view;
_L2:
            obj = ((com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem) (obj1)).getPhotoUrl();
              goto _L3
            exception;
            exception.printStackTrace();
            view1.setVisibility(8);
              goto _L4
            imageview.setVisibility(8);
            view1.setVisibility(8);
              goto _L4
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view.equals(obj);
        }


        public WhatsNewAdapter(Context context1, ArrayList arraylist)
        {
            boolean flag = false;
            this$0 = WhatsNewActivity.this;
            super();
            itemList = new ArrayList();
            isLowMemory = false;
            context = context1;
            itemList = new ArrayList();
            itemList.addAll(arraylist);
            if ((int)(Runtime.getRuntime().maxMemory() / 1024L / 1024L) < 64)
            {
                flag = true;
            }
            isLowMemory = flag;
        }
    }

}
