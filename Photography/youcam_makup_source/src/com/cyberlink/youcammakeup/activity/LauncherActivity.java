// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.Toast;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableRelativeLayout;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.b.e;
import com.cyberlink.youcammakeup.camera.o;
import com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent;
import com.cyberlink.youcammakeup.clflurry.YMKClicksLipsCartEvent;
import com.cyberlink.youcammakeup.clflurry.YMKCostumeMakeupEvent;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.a.d;
import com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper;
import com.cyberlink.youcammakeup.flurry.CrashAfterOutputBigImageEvent;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.flurry.LauncherPageViewEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.Camera;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.BannerRequest;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.n;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.an;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ao;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.g;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.i;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.sku.j;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.setting.PhotoQuality;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.bd;
import com.cyberlink.youcammakeup.utility.bn;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.f;
import com.cyberlink.youcammakeup.widgetpool.common.HorizontalScrollView;
import com.cyberlink.youcammakeup.widgetpool.common.x;
import com.kochava.android.tracker.c;
import com.pf.common.restart.RestartService;
import com.pf.common.utility.BaiduAutoUpdateUtils;
import com.pf.common.utility.m;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity, CostumeLooksPagerActivity, RecommendationActivity, SettingActivity, 
//            CameraLandscapeActivity, CameraActivity, WeekStarActivity, MoreMakeupActivity, 
//            BeautyTipCategoryActivity

public class LauncherActivity extends BaseActivity
    implements n
{

    public static final UUID a = UUID.randomUUID();
    protected static c b;
    protected static Handler c = new Handler() {

        public void handleMessage(Message message)
        {
            com.pf.common.utility.m.b("Kochava", message.getData().getString("attributionData"));
        }

    };
    private View A;
    private View B;
    private View C;
    private g D;
    private android.view.View.OnClickListener E;
    private android.view.View.OnClickListener F;
    private android.view.View.OnClickListener G;
    private android.view.View.OnClickListener H;
    private android.view.View.OnClickListener I;
    private android.view.View.OnClickListener J;
    private android.view.View.OnClickListener K;
    private android.view.View.OnClickListener L;
    private android.view.View.OnClickListener M;
    private com.cyberlink.beautycircle.utility.a N;
    private com.cyberlink.beautycircle.view.widgetpool.common.m O;
    public android.view.View.OnTouchListener d;
    private boolean e;
    private j f;
    private e g;
    private com.cyberlink.youcammakeup.b.f h;
    private com.cyberlink.youcammakeup.pages.b.b i;
    private View j;
    private ObservableRelativeLayout k;
    private ObservableRelativeLayout l;
    private ObservableRelativeLayout m;
    private ObservableRelativeLayout n;
    private ObservableRelativeLayout o;
    private ObservableRelativeLayout p;
    private ObservableRelativeLayout q;
    private ObservableRelativeLayout r;
    private ObservableRelativeLayout s;
    private View t;
    private View u;
    private View v;
    private HorizontalScrollView w;
    private View x;
    private View y;
    private ImageView z;

    public LauncherActivity()
    {
        e = false;
        f = null;
        g = null;
        h = null;
        D = new g() {

            final LauncherActivity a;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                if (bn1 == null);
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.e e1)
            {
                com.cyberlink.youcammakeup.utility.f.a("GetADUnitContentTask", e1.b());
                com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, com.cyberlink.youcammakeup.activity.LauncherActivity.d(a), 0);
            }

            public volatile void a(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.e)obj);
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        E = new android.view.View.OnClickListener() {

            final LauncherActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.activity.LauncherActivity.e(a))
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.c));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent.LauncherTileName.c));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.b, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                    YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Source.c.a());
                    YMKFeatureRoomLookEvent.b(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Source.c.a());
                    com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
                    com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
                    StatusManager.j().b(-1L);
                    StatusManager.j().a(null, com.cyberlink.youcammakeup.activity.LauncherActivity.a);
                    Globals.d().a(false);
                    view = new LibraryPickerActivity.State("editView");
                    com.cyberlink.youcammakeup.g.a(a, view, null, null, null, null);
                    return;
                }
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        F = new android.view.View.OnClickListener() {

            final LauncherActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.activity.LauncherActivity.e(a))
                {
                    return;
                }
                com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
                com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
                com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.f));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent.LauncherTileName.f));
                view = Globals.d().w();
                if (view != null && view.K().a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.c))
                {
                    YMKLauncherEvent.b(true);
                }
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.c, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                Globals.d().a(true);
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/MoreMakeupActivity);
                a.startActivity(view);
                a.finish();
                a.overridePendingTransition(0x7f040001, 0x7f040008);
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        G = new android.view.View.OnClickListener() {

            final LauncherActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.activity.LauncherActivity.e(a))
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.e, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                    com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
                    com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
                    bd.a(a, "com.cyberlink.youperfect", "ymk", "launcher");
                    return;
                }
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        H = new android.view.View.OnClickListener() {

            final LauncherActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.activity.LauncherActivity.e(a))
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.f, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                    com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
                    com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
                    bd.a(a, "com.perfectcorp.ycn", "ymk", "launcher");
                    return;
                }
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        I = new android.view.View.OnClickListener() {

            final LauncherActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.activity.LauncherActivity.e(a))
                {
                    return;
                }
                com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.g));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent.LauncherTileName.g));
                if (af.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.d))
                {
                    YMKLauncherEvent.b(true);
                }
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.g, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
                com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/BeautyTipCategoryActivity);
                a.startActivity(view);
                a.finish();
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        J = new android.view.View.OnClickListener() {

            final LauncherActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.activity.LauncherActivity.e(a))
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.e));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent.LauncherTileName.e));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.h, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                    com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
                    com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
                    com.cyberlink.beautycircle.Globals.a(Globals.O());
                    com.cyberlink.beautycircle.c.a(a, "ymk");
                    return;
                }
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        K = new android.view.View.OnClickListener() {

            final LauncherActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.activity.LauncherActivity.e(a))
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.d));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent.LauncherTileName.d));
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.d, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                    YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Source.d.a());
                    YMKCostumeMakeupEvent.b(com.cyberlink.youcammakeup.clflurry.YMKCostumeMakeupEvent.Source.a.a());
                    YMKFeatureRoomLookEvent.b(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Source.d.a());
                    com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
                    com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
                    view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CostumeLooksPagerActivity);
                    a.startActivity(view);
                    a.finish();
                    return;
                }
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        L = new android.view.View.OnClickListener() {

            final LauncherActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
                com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.j));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent.LauncherTileName.j));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.j, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/RecommendationActivity);
                view.putExtra("previousActivity", "launcher");
                view.putExtra("title", a.getString(0x7f070528));
                com.cyberlink.youcammakeup.activity.RecommendationActivity.Groups.a.a(view);
                a.startActivity(view);
                a.finish();
                a.overridePendingTransition(0x7f040001, 0x7f040008);
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        M = new android.view.View.OnClickListener() {

            final LauncherActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.h));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent.LauncherTileName.h));
                view = Globals.d().w();
                if (view != null && view.K().a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.e))
                {
                    YMKLauncherEvent.b(true);
                }
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.k, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/SettingActivity);
                a.startActivity(view);
                a.finish();
                a.overridePendingTransition(0x7f040001, 0x7f040008);
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        N = new com.cyberlink.beautycircle.utility.a() {

            final LauncherActivity a;

            public void a(UserInfo userinfo)
            {
                com.cyberlink.youcammakeup.activity.LauncherActivity.g(a);
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        d = new android.view.View.OnTouchListener() {

            final LauncherActivity a;
            private AnimatorSet b;
            private Toast c;

            private void a(View view)
            {
                if (com.cyberlink.youcammakeup.activity.LauncherActivity.e(a) && view.isClickable())
                {
                    return;
                }
                if (!com.cyberlink.youcammakeup.camera.o.a())
                {
                    if (c != null)
                    {
                        c.cancel();
                        c = null;
                    }
                    c = Toast.makeText(a, 0x7f070062, 0);
                    c.show();
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
                    com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
                    Globals.d().a(false);
                    float f1 = com.cyberlink.youcammakeup.activity.LauncherActivity.j(a).getHeight();
                    view.setVisibility(8);
                    view = ObjectAnimator.ofPropertyValuesHolder(com.cyberlink.youcammakeup.activity.LauncherActivity.i(a), new PropertyValuesHolder[] {
                        PropertyValuesHolder.ofFloat("translationY", new float[] {
                            f1
                        })
                    });
                    ObjectAnimator objectanimator = ObjectAnimator.ofPropertyValuesHolder(com.cyberlink.youcammakeup.activity.LauncherActivity.j(a), new PropertyValuesHolder[] {
                        PropertyValuesHolder.ofFloat("translationY", new float[] {
                            -f1
                        })
                    });
                    AnimatorSet animatorset = (new AnimatorSet()).setDuration(300L);
                    animatorset.playTogether(new Animator[] {
                        view, objectanimator
                    });
                    animatorset.addListener(new ch(this) {

                        final _cls18 a;

                        public void onAnimationEnd(Animator animator)
                        {
                            com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.LauncherGotoEvent.DestName.b));
                            com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent.LauncherTileName.b));
                            com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.a, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                            YMKLiveCamEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent.Source.a.a());
                            com.cyberlink.youcammakeup.g.a(a.a, null, null, null);
                            com.cyberlink.youcammakeup.activity.LauncherActivity.a(a.a, true);
                            com.cyberlink.youcammakeup.activity.LauncherActivity.b(a.a, false);
                            Globals.d().a(false);
                            if (LiveDemoConfigHelper.h().d())
                            {
                                animator = new Intent(a.a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraLandscapeActivity);
                            } else
                            {
                                animator = new Intent(a.a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraActivity);
                            }
                            a.a.startActivity(animator);
                            a.a.finish();
                        }

            
            {
                a = _pcls18;
                super();
            }
                    });
                    animatorset.start();
                    return;
                }
            }

            private void a(View view, boolean flag)
            {
                if (!flag);
                float f1;
                float f2;
                ObjectAnimator objectanimator;
                ObjectAnimator objectanimator1;
                ObjectAnimator objectanimator2;
                Object obj;
                Object obj1;
                if (flag)
                {
                    f2 = 1.2F;
                } else
                {
                    f2 = 1.0F;
                }
                if (flag)
                {
                    f1 = 70F;
                } else
                {
                    f1 = 0.0F;
                }
                view = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofFloat("rotation", new float[] {
                        0.0F
                    }), PropertyValuesHolder.ofFloat("scaleX", new float[] {
                        f2
                    }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                        f2
                    })
                });
                objectanimator = ObjectAnimator.ofFloat(com.cyberlink.youcammakeup.activity.LauncherActivity.i(a), "translationY", new float[] {
                    f1
                });
                objectanimator1 = ObjectAnimator.ofFloat(com.cyberlink.youcammakeup.activity.LauncherActivity.j(a), "translationY", new float[] {
                    -f1
                });
                objectanimator2 = ObjectAnimator.ofFloat(LauncherActivity.k(a), "translationY", new float[] {
                    -f1
                });
                obj = LauncherActivity.l(a);
                if (flag)
                {
                    f2 = 0.0F;
                } else
                {
                    f2 = 1.0F;
                }
                obj = ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofFloat("alpha", new float[] {
                        f2
                    })
                });
                obj1 = com.cyberlink.youcammakeup.activity.LauncherActivity.m(a);
                if (flag)
                {
                    f1 = (f1 + (float)com.cyberlink.youcammakeup.activity.LauncherActivity.m(a).getHeight()) / (float)com.cyberlink.youcammakeup.activity.LauncherActivity.m(a).getHeight();
                } else
                {
                    f1 = 1.0F;
                }
                obj1 = ObjectAnimator.ofPropertyValuesHolder(obj1, new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofFloat("scaleY", new float[] {
                        f1
                    })
                });
                com.cyberlink.youcammakeup.activity.LauncherActivity.m(a).setPivotY(com.cyberlink.youcammakeup.activity.LauncherActivity.m(a).getHeight());
                b = (new AnimatorSet()).setDuration(100L);
                b.playTogether(new Animator[] {
                    view, objectanimator, objectanimator1, objectanimator2, obj1, obj
                });
                b.start();
            }

            static void a(_cls18 _pcls18, View view)
            {
                _pcls18.a(view);
            }

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                switch (motionevent.getActionMasked())
                {
                default:
                    return true;

                case 0: // '\0'
                    com.cyberlink.youcammakeup.activity.LauncherActivity.h(a).setSelected(true);
                    a(view, true);
                    return true;

                case 1: // '\001'
                    com.cyberlink.youcammakeup.activity.LauncherActivity.h(a).setSelected(false);
                    break;
                }
                float f1 = motionevent.getX();
                float f2 = motionevent.getY();
                if (f1 >= 0.0F && f1 <= (float)view.getWidth() && f2 >= 0.0F && f2 <= (float)view.getHeight())
                {
                    if (b != null && b.isRunning())
                    {
                        b.addListener(new ch(this, view) {

                            final View a;
                            final _cls18 b;

                            public void onAnimationEnd(Animator animator)
                            {
                                com.cyberlink.youcammakeup.activity._cls18.a(b, a);
                            }

            
            {
                b = _pcls18;
                a = view;
                super();
            }
                        });
                        return true;
                    } else
                    {
                        a(view);
                        return true;
                    }
                } else
                {
                    a(view, false);
                    return true;
                }
            }

            
            {
                a = LauncherActivity.this;
                super();
                b = null;
                c = null;
            }
        };
        O = new com.cyberlink.beautycircle.view.widgetpool.common.m() {

            final LauncherActivity a;

            public void a(ObservableRelativeLayout observablerelativelayout, boolean flag)
            {
                float f1;
                if (flag)
                {
                    f1 = 1.1F;
                } else
                {
                    f1 = 1.0F;
                }
                observablerelativelayout.animate().scaleX(f1).scaleY(f1).setDuration(100L).start();
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
    }

    static ObservableRelativeLayout a(LauncherActivity launcheractivity)
    {
        return launcheractivity.k;
    }

    private void a(View view, int i1)
    {
        if (view != null)
        {
            Globals.d(new Runnable(view, i1) {

                final View a;
                final int b;
                final LauncherActivity c;

                public void run()
                {
                    a.setVisibility(b);
                }

            
            {
                c = LauncherActivity.this;
                a = view;
                b = i1;
                super();
            }
            });
        }
    }

    static void a(LauncherActivity launcheractivity, View view, int i1)
    {
        launcheractivity.a(view, i1);
    }

    static void a(LauncherActivity launcheractivity, com.cyberlink.youcammakeup.database.a.c c1, String s1)
    {
        launcheractivity.a(c1, s1);
    }

    static void a(LauncherActivity launcheractivity, ap ap)
    {
        launcheractivity.a(ap);
    }

    private void a(com.cyberlink.youcammakeup.database.a.c c1, String s1)
    {
        y.setOnClickListener(new android.view.View.OnClickListener(c1, s1) {

            final com.cyberlink.youcammakeup.database.a.c a;
            final String b;
            final LauncherActivity c;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.n, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.b));
                view = new Intent(c.getApplicationContext(), com/cyberlink/youcammakeup/activity/WeekStarActivity);
                view.putStringArrayListExtra("Guid", a.g().a());
                view.putExtra("Button", a.g().b());
                view.putExtra("ImageURI", (new File(b, BannerRequest.a())).toString());
                c.startActivity(view);
                c.finish();
            }

            
            {
                c = LauncherActivity.this;
                a = c1;
                b = s1;
                super();
            }
        });
        z.post(new Runnable(s1) {

            final String a;
            final LauncherActivity b;

            public void run()
            {
                com.cyberlink.youcammakeup.activity.LauncherActivity.b(b).setImageURI(Uri.fromFile(new File(a, BannerRequest.b())));
            }

            
            {
                b = LauncherActivity.this;
                a = s1;
                super();
            }
        });
    }

    private void a(ap ap)
    {
        h h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
        h1.a(ap);
        if (!b() && !isFinishing())
        {
            ap = new j() {

                final LauncherActivity a;

                public void a()
                {
                    a.runOnUiThread(new Runnable(this) {

                        final _cls15 a;

                        public void run()
                        {
                            if (com.cyberlink.youcammakeup.activity.LauncherActivity.f(a.a) != null)
                            {
                                com.cyberlink.youcammakeup.activity.LauncherActivity.f(a.a).v();
                            }
                        }

            
            {
                a = _pcls15;
                super();
            }
                    });
                }

                public void a(String s1)
                {
                }

                public void b(String s1)
                {
                }

            
            {
                a = LauncherActivity.this;
                super();
            }
            };
            f = ap;
            h1.a(ap);
        }
    }

    static boolean a(LauncherActivity launcheractivity, boolean flag)
    {
        launcheractivity.e = flag;
        return flag;
    }

    static ImageView b(LauncherActivity launcheractivity)
    {
        return launcheractivity.z;
    }

    static void b(LauncherActivity launcheractivity, boolean flag)
    {
        launcheractivity.b(flag);
    }

    private void b(boolean flag)
    {
        j.setClickable(flag);
        k.setClickable(flag);
        t.setClickable(flag);
        p.setClickable(flag);
        q.setClickable(flag);
        r.setClickable(flag);
        l.setClickable(flag);
        u.setClickable(flag);
    }

    static g c(LauncherActivity launcheractivity)
    {
        return launcheractivity.D;
    }

    static View d(LauncherActivity launcheractivity)
    {
        return launcheractivity.u;
    }

    static boolean e(LauncherActivity launcheractivity)
    {
        return launcheractivity.e;
    }

    static e f(LauncherActivity launcheractivity)
    {
        return launcheractivity.g;
    }

    static void g(LauncherActivity launcheractivity)
    {
        launcheractivity.k();
    }

    static View h(LauncherActivity launcheractivity)
    {
        return launcheractivity.j;
    }

    static View i(LauncherActivity launcheractivity)
    {
        return launcheractivity.x;
    }

    static View j(LauncherActivity launcheractivity)
    {
        return launcheractivity.y;
    }

    private void j()
    {
        com.kochava.android.tracker.c.a(c);
        HashMap hashmap = new HashMap();
        hashmap.put("kochava_app_id", "koyoucam-makeup---makeover-studio554ac53c01c72");
        hashmap.put("request_attribution", Boolean.valueOf(true));
        b = new c(this, hashmap);
    }

    static View k(LauncherActivity launcheractivity)
    {
        return launcheractivity.A;
    }

    private void k()
    {
        if (com.cyberlink.youcammakeup.utility.h.e())
        {
            com.cyberlink.youcammakeup.utility.h.b();
            return;
        }
        if (com.cyberlink.youcammakeup.utility.h.e())
        {
            com.cyberlink.youcammakeup.utility.h.a((ViewGroup)findViewById(0x7f0c0144));
            com.cyberlink.youcammakeup.utility.h.c();
            return;
        } else
        {
            k.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final LauncherActivity a;

                public void onGlobalLayout()
                {
                    if (android.os.Build.VERSION.SDK_INT >= 16)
                    {
                        com.cyberlink.youcammakeup.activity.LauncherActivity.a(a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else
                    {
                        com.cyberlink.youcammakeup.activity.LauncherActivity.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    com.cyberlink.youcammakeup.utility.h.a(com.cyberlink.youcammakeup.activity.LauncherActivity.a(a).getWidth(), com.cyberlink.youcammakeup.activity.LauncherActivity.a(a).getHeight());
                    com.cyberlink.youcammakeup.utility.h.a((ViewGroup)a.findViewById(0x7f0c0144));
                }

            
            {
                a = LauncherActivity.this;
                super();
            }
            });
            return;
        }
    }

    static View l(LauncherActivity launcheractivity)
    {
        return launcheractivity.C;
    }

    static View m(LauncherActivity launcheractivity)
    {
        return launcheractivity.B;
    }

    private void m()
    {
        if (!com.cyberlink.youcammakeup.utility.f.a("GetADUnitListTask", TimeUnit.DAYS.toMillis(1L)) && NetworkManager.L())
        {
            a(u, 0);
            return;
        } else
        {
            NetworkManager networkmanager = Globals.d().w();
            String s1 = com.cyberlink.youcammakeup.activity.RecommendationActivity.Groups.a.toString();
            String s2 = com.cyberlink.youcammakeup.activity.RecommendationActivity.Groups.b.toString();
            networkmanager.a(new i(networkmanager, new com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.j(networkmanager) {

                final NetworkManager a;
                final LauncherActivity b;

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
                {
                    if (bn1 == null);
                }

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.h h1)
                {
                    com.cyberlink.youcammakeup.utility.f.a("GetADUnitListTask");
                    com.cyberlink.youcammakeup.utility.f.a("GetADUnitListTask", h1.b());
                    Object obj = h1.a();
                    h1 = new LinkedList();
                    for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); h1.add(((com.cyberlink.youcammakeup.database.a.e)((Iterator) (obj)).next()).a())) { }
                    if (h1.size() != 0)
                    {
                        a.a(new com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.f(a, com.cyberlink.youcammakeup.activity.LauncherActivity.c(b), h1));
                    }
                }

                public volatile void a(Object obj)
                {
                    a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.h)obj);
                }

                public void a(Void void1)
                {
                }

                public void b(Object obj)
                {
                    a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
                }

                public void c(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                b = LauncherActivity.this;
                a = networkmanager;
                super();
            }
            }, new String[] {
                s1, s2
            }));
            return;
        }
    }

    private void n()
    {
        findViewById(0x7f0c0139).setOnTouchListener(new android.view.View.OnTouchListener() {

            final LauncherActivity a;
            private boolean b;
            private int c;
            private Toast d;

            static int a(_cls25 _pcls25, int i1)
            {
                _pcls25.c = i1;
                return i1;
            }

            static boolean a(_cls25 _pcls25, boolean flag)
            {
                _pcls25.b = flag;
                return flag;
            }

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getActionMasked() == 0)
                {
                    if (!b)
                    {
                        b = true;
                        c = 0;
                        view.postDelayed(new Runnable(this) {

                            final _cls25 a;

                            public void run()
                            {
                                com.cyberlink.youcammakeup.activity._cls25.a(a, false);
                                com.cyberlink.youcammakeup.activity._cls25.a(a, 0);
                            }

            
            {
                a = _pcls25;
                super();
            }
                        }, 600L);
                    }
                    c = c + 1;
                }
                if (c >= 4)
                {
                    DatabaseOpenHelper.a();
                } else
                if (c >= 3)
                {
                    view = com.cyberlink.youcammakeup.widgetpool.a.b.a().c();
                    motionevent = NetworkManager.d();
                    if (d != null)
                    {
                        d.cancel();
                        d = null;
                    }
                    d = Toast.makeText(a.getApplicationContext(), (new StringBuilder()).append(view).append("(").append(motionevent).append(")").toString(), 1);
                    d.show();
                    return true;
                }
                return true;
            }

            
            {
                a = LauncherActivity.this;
                super();
                b = false;
                c = 0;
            }
        });
        findViewById(0x7f0c0138).setOnTouchListener(new android.view.View.OnTouchListener() {

            final LauncherActivity a;
            private boolean b;
            private int c;
            private Toast d;

            static int a(_cls26 _pcls26, int i1)
            {
                _pcls26.c = i1;
                return i1;
            }

            static boolean a(_cls26 _pcls26, boolean flag)
            {
                _pcls26.b = flag;
                return flag;
            }

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (!Globals.u() && !NetworkManager.e())
                {
                    return false;
                }
                if (motionevent.getActionMasked() == 0)
                {
                    if (!b)
                    {
                        b = true;
                        c = 0;
                        view.postDelayed(new Runnable(this) {

                            final _cls26 a;

                            public void run()
                            {
                                com.cyberlink.youcammakeup.activity._cls26.a(a, false);
                                com.cyberlink.youcammakeup.activity._cls26.a(a, 0);
                            }

            
            {
                a = _pcls26;
                super();
            }
                        }, 600L);
                    }
                    c = c + 1;
                }
                if (c >= 3)
                {
                    if (d != null)
                    {
                        d.cancel();
                        d = null;
                    }
                    com.cyberlink.youcammakeup.kernelctrl.z.a();
                    d = Toast.makeText(a.getApplicationContext(), "All preference cleared!!", 1);
                    d.show();
                }
                return true;
            }

            
            {
                a = LauncherActivity.this;
                super();
                b = false;
                c = 0;
            }
        });
    }

    private void o()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.a(this);
        }
        AccountManager.a(N);
    }

    private void p()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
        }
        AccountManager.b(N);
    }

    private void q()
    {
        byte byte0 = 4;
        boolean flag = false;
        Object obj = Globals.d().w();
        if (obj != null)
        {
            obj = ((NetworkManager) (obj)).K();
            ((NewBadgeState) (obj)).b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.a);
            View view = findViewById(0x7f0c014f);
            boolean flag1;
            if (view != null)
            {
                if (((NewBadgeState) (obj)).a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.c))
                {
                    view.setVisibility(0);
                } else
                {
                    view.setVisibility(4);
                }
            }
            view = findViewById(0x7f0c0152);
            if (view != null)
            {
                if (((NewBadgeState) (obj)).a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.e))
                {
                    byte0 = 0;
                }
                view.setVisibility(byte0);
            }
        }
        flag1 = af.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.d);
        obj = findViewById(0x7f0c014b);
        if (obj != null)
        {
            int i1;
            if (flag1)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 8;
            }
            ((View) (obj)).setVisibility(i1);
        }
    }

    private void r()
    {
        NetworkManager networkmanager = Globals.d().w();
        networkmanager.a(new an(this, networkmanager, new ao(networkmanager) {

            final NetworkManager a;
            final LauncherActivity b;

            public void a(ap ap1)
            {
                a.K().a(ap1);
                com.cyberlink.youcammakeup.activity.LauncherActivity.a(b, ap1);
                bn.a(ap1.i(), -1L, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a, new com.cyberlink.youcammakeup.e(this) {

                    final _cls14 a;

                    public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
                    {
                    }

                    public volatile void a(Object obj)
                    {
                        a((Void)obj);
                    }

                    public void a(Void void1)
                    {
                        if (!com.cyberlink.youcammakeup.kernelctrl.z.a("HAS_SET_SEEN", Globals.d()))
                        {
                            void1 = new ArrayList();
                            void1.add(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.c);
                            Globals.d().w().K().a(void1);
                            com.cyberlink.youcammakeup.kernelctrl.z.a("HAS_SET_SEEN", Boolean.valueOf(true), Globals.d());
                        }
                    }

                    public void b(Object obj)
                    {
                        a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
                    }

                    public void c(Object obj)
                    {
                    }

            
            {
                a = _pcls14;
                super();
            }
                });
            }

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
                com.cyberlink.youcammakeup.activity.LauncherActivity.a(b, null);
            }

            public volatile void a(Object obj)
            {
                a((ap)obj);
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                b = LauncherActivity.this;
                a = networkmanager;
                super();
            }
        }));
    }

    private int s()
    {
        EGL10 egl10;
        int ai[];
        javax.microedition.khronos.egl.EGLDisplay egldisplay;
        egl10 = (EGL10)EGLContext.getEGL();
        Object obj = EGL10.EGL_NO_DISPLAY;
        obj = EGL10.EGL_NO_SURFACE;
        obj = EGL10.EGL_NO_CONTEXT;
        ai = new int[1];
        ai[0] = 0;
        egldisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        break MISSING_BLOCK_LABEL_37;
        while (true) 
        {
            do
            {
                return ai[0];
            } while (egldisplay == EGL10.EGL_NO_DISPLAY || !egl10.eglInitialize(egldisplay, new int[2]));
            int ai1[] = new int[15];
            ai1;
            ai1[0] = 12325;
            ai1[1] = 0;
            ai1[2] = 12326;
            ai1[3] = 0;
            ai1[4] = 12324;
            ai1[5] = 8;
            ai1[6] = 12323;
            ai1[7] = 8;
            ai1[8] = 12322;
            ai1[9] = 8;
            ai1[10] = 12321;
            ai1[11] = 8;
            ai1[12] = 12352;
            ai1[13] = 4;
            ai1[14] = 12344;
            int ai2[] = new int[1];
            if (egl10.eglChooseConfig(egldisplay, ai1, null, 0, ai2))
            {
                int i1 = ai2[0];
                EGLConfig aeglconfig[] = new EGLConfig[i1];
                if (egl10.eglChooseConfig(egldisplay, ai1, aeglconfig, i1, ai2))
                {
                    Object obj1 = aeglconfig[0];
                    EGLContext eglcontext = egl10.eglCreateContext(egldisplay, ((EGLConfig) (obj1)), EGL10.EGL_NO_CONTEXT, new int[] {
                        12440, 2, 12344
                    });
                    if (eglcontext != EGL10.EGL_NO_CONTEXT)
                    {
                        obj1 = egl10.eglCreatePbufferSurface(egldisplay, ((EGLConfig) (obj1)), new int[] {
                            12375, 1, 12374, 1, 12344
                        });
                        if (obj1 != EGL10.EGL_NO_SURFACE && egl10.eglMakeCurrent(egldisplay, ((javax.microedition.khronos.egl.EGLSurface) (obj1)), ((javax.microedition.khronos.egl.EGLSurface) (obj1)), eglcontext))
                        {
                            GLES10.glGetIntegerv(3379, ai, 0);
                            egl10.eglDestroySurface(egldisplay, ((javax.microedition.khronos.egl.EGLSurface) (obj1)));
                            egl10.eglDestroyContext(egldisplay, eglcontext);
                            egl10.eglTerminate(egldisplay);
                        }
                    }
                }
            }
        }
    }

    public void finish()
    {
        if (Globals.d().s() == this)
        {
            Globals.d().a(null);
        }
        super.finish();
    }

    public void l()
    {
        if (af.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.c))
        {
            af.a(this, findViewById(0x7f0c014f), com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.c);
        }
        if (af.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.d))
        {
            af.a(this, findViewById(0x7f0c014b), com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.d);
        }
        if (af.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.b) && com.cyberlink.youcammakeup.kernelctrl.z.a("HAS_SET_SEEN_LAUNCHER_SETTING", Globals.d()))
        {
            af.a(this, findViewById(0x7f0c0152), com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.e);
        }
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
                    startActivity(intent1);
                    return;
                }
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        Globals.d().H();
        super.onCreate(bundle);
        setContentView(0x7f030012);
        bundle = RestartService.a(getIntent());
        if (bundle != null)
        {
            (new android.app.AlertDialog.Builder(this)).setTitle(0x7f070725).setMessage(bundle).setPositiveButton(0x7f0703fd, null).show();
        }
        Globals.d().a(this);
        x = findViewById(0x7f0c0134);
        y = findViewById(0x7f0c0133);
        z = (ImageView)findViewById(0x7f0c0135);
        A = findViewById(0x7f0c013b);
        B = findViewById(0x7f0c013a);
        C = findViewById(0x7f0c0155);
        BeautifierManager.a();
        k = (ObservableRelativeLayout)findViewById(0x7f0c013e);
        l = (ObservableRelativeLayout)findViewById(0x7f0c0140);
        m = (ObservableRelativeLayout)findViewById(0x7f0c0143);
        n = (ObservableRelativeLayout)findViewById(0x7f0c013f);
        o = (ObservableRelativeLayout)findViewById(0x7f0c0145);
        p = (ObservableRelativeLayout)findViewById(0x7f0c0146);
        q = (ObservableRelativeLayout)findViewById(0x7f0c0147);
        r = (ObservableRelativeLayout)findViewById(0x7f0c014a);
        s = (ObservableRelativeLayout)findViewById(0x7f0c014c);
        j = findViewById(0x7f0c0154);
        t = findViewById(0x7f0c014e);
        u = findViewById(0x7f0c0150);
        v = findViewById(0x7f0c0151);
        m.setVisibility(8);
        s.setVisibility(8);
        u.setVisibility(4);
        k.setOnClickListener(E);
        n.setOnClickListener(K);
        o.setOnClickListener(G);
        p.setOnClickListener(H);
        r.setOnClickListener(I);
        s.setOnClickListener(L);
        j.setOnTouchListener(d);
        t.setOnClickListener(F);
        l.setOnClickListener(J);
        u.setOnClickListener(L);
        v.setOnClickListener(M);
        w = (HorizontalScrollView)findViewById(0x7f0c013c);
        w.setOnTouchListener(new x(w, (ViewGroup)findViewById(0x7f0c013d), true, null, true));
        if (Globals.e && !Globals.d)
        {
            if (NetworkManager.a(this));
        }
        Globals.d().b(Globals.d().getApplicationContext());
        o();
        StatusManager.j().f(false);
        StatusManager.j().g(false);
        StatusManager.j().c(null);
        StatusManager.j().a(BeautyMode.D);
        StatusManager.j().a(MakeupMode.g);
        r();
        n();
        i = new com.cyberlink.youcammakeup.pages.b.b() {

            final LauncherActivity a;
            private View b;
            private ImageView c;
            private View d;

            static View a(_cls1 _pcls1)
            {
                return _pcls1.b;
            }

            private void a()
            {
                b.animate().alpha(1.0F).setDuration(1000L).setListener(new android.animation.Animator.AnimatorListener(this) {

                    final _cls1 a;

                    public void onAnimationCancel(Animator animator)
                    {
                    }

                    public void onAnimationEnd(Animator animator)
                    {
                        Globals.d(new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                com.cyberlink.youcammakeup.activity._cls1.a(a.a).setAlpha(1.0F);
                                Globals.a(new Runnable(this) {

                                    final _cls1 a;

                                    public void run()
                                    {
                                        com.cyberlink.youcammakeup.activity._cls1.b(a.a.a);
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                }, 3000L);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }

                    public void onAnimationRepeat(Animator animator)
                    {
                    }

                    public void onAnimationStart(Animator animator)
                    {
                    }

            
            {
                a = _pcls1;
                super();
            }
                }).start();
            }

            private void b()
            {
                b.animate().alpha(0.0F).setDuration(1000L).setListener(new android.animation.Animator.AnimatorListener(this) {

                    final _cls1 a;

                    public void onAnimationCancel(Animator animator)
                    {
                    }

                    public void onAnimationEnd(Animator animator)
                    {
                        Globals.d(new Runnable(this) {

                            final _cls2 a;

                            public void run()
                            {
                                com.cyberlink.youcammakeup.activity._cls1.a(a.a).setAlpha(1.0F);
                                com.cyberlink.youcammakeup.activity._cls1.a(a.a).setVisibility(4);
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                    }

                    public void onAnimationRepeat(Animator animator)
                    {
                    }

                    public void onAnimationStart(Animator animator)
                    {
                    }

            
            {
                a = _pcls1;
                super();
            }
                }).start();
            }

            static void b(_cls1 _pcls1)
            {
                _pcls1.b();
            }

            public void a(Pair pair)
            {
                if (b == null)
                {
                    b = a.findViewById(0x7f0c08e3);
                    c = (ImageView)b.findViewById(0x7f0c08e4);
                    d = a.findViewById(0x7f0c0142);
                }
                com.pf.common.utility.m.b("onGetBeautyCircleStatus::first", String.valueOf(pair.first));
                com.pf.common.utility.m.b("onGetBeautyCircleStatus::second", String.valueOf(pair.second));
                if (pair.first != null && ((Integer)pair.first).intValue() > 0)
                {
                    d.setVisibility(0);
                } else
                {
                    d.setVisibility(4);
                }
                if (aa.b((Bitmap)pair.second))
                {
                    c.setImageBitmap((Bitmap)pair.second);
                    b.setVisibility(0);
                    b.clearAnimation();
                    b.setAlpha(0.0F);
                    a();
                    return;
                } else
                {
                    b.setVisibility(4);
                    b.clearAnimation();
                    return;
                }
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        };
        j();
        if (Globals.d().c() != com.cyberlink.youcammakeup.Globals.STORE_NAME.d)
        {
            m();
        }
        if (com.cyberlink.youcammakeup.kernelctrl.z.b("TEXTURE_MAX_SIZE", 0, this) == 0)
        {
            com.cyberlink.youcammakeup.kernelctrl.z.a("TEXTURE_MAX_SIZE", s(), this);
        }
        if (com.cyberlink.youcammakeup.kernelctrl.z.k())
        {
            com.cyberlink.youcammakeup.kernelctrl.z.a("PHOTO_QUALITY", PhotoQuality.b.toString(), Globals.d());
            com.cyberlink.youcammakeup.kernelctrl.z.o();
            com.cyberlink.youcammakeup.kernelctrl.z.m();
            bundle = Globals.d().e();
            if (bundle == null)
            {
                bundle = "";
            } else
            {
                bundle = bundle.toString();
            }
            com.cyberlink.youcammakeup.flurry.a.a(new CrashAfterOutputBigImageEvent(Build.MANUFACTURER, Build.BRAND, Build.MODEL, bundle));
        }
        BaiduAutoUpdateUtils.a.a(this);
    }

    public void onDestroy()
    {
        if (g != null)
        {
            g.n();
            g = null;
        }
        com.cyberlink.youcammakeup.utility.h.a(findViewById(0x7f0c0144));
        if (f != null)
        {
            com.cyberlink.youcammakeup.kernelctrl.sku.h.b().b(f);
        }
        p();
        super.onDestroy();
    }

    protected void onPause()
    {
        if (g != null)
        {
            g.k();
        }
        com.cyberlink.youcammakeup.kernelctrl.z.a("HAS_SET_SEEN_LAUNCHER_SETTING", Boolean.valueOf(true), Globals.d());
        com.cyberlink.youcammakeup.pages.b.a.a().b(i);
        com.cyberlink.youcammakeup.utility.h.d();
        Globals.d().c("launcher");
        super.onPause();
    }

    public void onResume()
    {
        String s1;
        super.onResume();
        BannerRequest.a(new com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.a() {

            final LauncherActivity a;

            public void a(com.cyberlink.youcammakeup.database.a.c c1, String s2)
            {
                YMKLauncherEvent.c(true);
                com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, c1, s2);
            }

            
            {
                a = LauncherActivity.this;
                super();
            }
        });
        k.setOnPressStateChangeListener(O);
        k.setPressed(false);
        l.setOnPressStateChangeListener(O);
        l.setPressed(false);
        m.setPressed(false);
        n.setOnPressStateChangeListener(O);
        n.setPressed(false);
        o.setOnPressStateChangeListener(O);
        o.setPressed(false);
        p.setOnPressStateChangeListener(O);
        p.setPressed(false);
        q.setOnPressStateChangeListener(O);
        q.setPressed(false);
        r.setOnPressStateChangeListener(O);
        r.setPressed(false);
        s.setOnPressStateChangeListener(O);
        s.setPressed(false);
        long l1;
        if (Globals.d().c() == com.cyberlink.youcammakeup.Globals.STORE_NAME.d || al.a("com.cyberlink.youperfect"))
        {
            o.setVisibility(8);
            YMKLauncherEvent.d(false);
        } else
        {
            o.setVisibility(0);
            YMKLauncherEvent.d(true);
        }
        if (Globals.d().c() == com.cyberlink.youcammakeup.Globals.STORE_NAME.d || al.a("com.perfectcorp.ycn"))
        {
            p.setVisibility(8);
            YMKLauncherEvent.e(false);
        } else
        {
            p.setVisibility(0);
            YMKLauncherEvent.e(true);
        }
        YMKLauncherEvent.b("Launcher");
        YMKLauncherEvent.a(false);
        YMKLauncherEvent.b(false);
        k();
        s1 = com.cyberlink.youcammakeup.kernelctrl.z.g();
        if (s1.isEmpty()) goto _L2; else goto _L1
_L1:
        if (!s1.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.a.toString())) goto _L4; else goto _L3
_L3:
        if (al.a(getPackageManager()))
        {
            com.cyberlink.youcammakeup.kernelctrl.z.a(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.b);
            com.cyberlink.youcammakeup.clflurry.b.a(new YCPInstallTrackEvent(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.b));
        }
_L2:
        com.cyberlink.youcammakeup.flurry.a.a(new LauncherPageViewEvent(0));
        com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.an());
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.TileType.m, com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent.Operation.a));
        YMKClicksLipsCartEvent.a(com.cyberlink.youcammakeup.clflurry.YMKClicksLipsCartEvent.SourceName.b);
        Globals.d().c(null);
        b(true);
        e = false;
        q();
        l1 = StatusManager.j().l();
        ViewEngine.a().b(l1);
        StatusManager.j().F();
        StatusManager.j().a(-1L, a);
        StatusManager.j().a(null, a);
        if (g != null)
        {
            g.u();
            g.j();
        }
        com.cyberlink.youcammakeup.pages.b.a.a().a(i);
        com.cyberlink.youcammakeup.pages.b.a.a().b();
        Globals.d("");
        if (LiveDemoConfigHelper.h().d() && LiveDemoConfigHelper.h().m())
        {
            Globals.a(new Runnable() {

                final LauncherActivity a;

                public void run()
                {
                    Intent intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraLandscapeActivity);
                    a.startActivity(intent);
                    a.finish();
                }

            
            {
                a = LauncherActivity.this;
                super();
            }
            }, 2000L);
        }
        return;
_L4:
        if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.b.toString()) && !al.a(getPackageManager()))
        {
            com.cyberlink.youcammakeup.kernelctrl.z.a(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.c);
            com.cyberlink.youcammakeup.clflurry.b.a(new YCPInstallTrackEvent(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS.c));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void onStart()
    {
        super.onStart();
        StatusManager.j().a("launcher");
        StatusManager.j().a(Boolean.valueOf(true));
    }

}
