// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.Appboy;
import com.appboy.AppboyUser;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.facebook.CallbackManager;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.utils.f;
import com.picsart.studio.view.SlidingTabLayout;
import com.picsart.studio.view.WrappingListPopupWindow;
import com.picsart.studio.view.p;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.AddFollowingController;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RemoveFollowingController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.controllers.UpdateUserController;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.exception.SocialinApiException;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.StatusObj;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.request.ParamWithUserData;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.dropbox.DropBoxSessionManager;
import com.socialin.android.facebook.m;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.instagram.h;
import com.socialin.android.photo.exif.ExifTool;
import com.socialin.android.picsart.profile.activity.FindFriendsActivity;
import com.socialin.android.picsart.profile.activity.ProfileSettingsActivity;
import com.socialin.android.picsart.profile.activity.UserAvatarUploadActivity;
import com.socialin.android.picsart.profile.adapter.aa;
import com.socialin.android.picsart.profile.fragment.NavigationFragment;
import com.socialin.android.picsart.profile.fragment.UserConnectionsFragment;
import com.socialin.android.picsart.profile.fragment.ar;
import com.socialin.android.picsart.profile.fragment.bu;
import com.socialin.android.picsart.profile.fragment.bv;
import com.socialin.android.picsart.profile.fragment.y;
import com.socialin.android.picsart.profile.fragment.z;
import com.socialin.android.picsart.profile.invite.i;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.picsart.profile.util.NetworkFragmentException;
import com.socialin.android.twitter.TwitterSessionManager;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import com.socialin.asyncnet.Request;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import myobfuscated.bd.a;
import myobfuscated.ct.b;

// Referenced classes of package com.picsart.studio.profile:
//            a

public class ProfileActivity extends BaseActivity
    implements f
{

    private static final String f = com/picsart/studio/profile/ProfileActivity.getSimpleName();
    private ImageView A;
    private View B;
    private View C;
    private View D;
    private View E;
    private View F;
    private SlidingTabLayout G;
    private g H;
    private ViewPager I;
    private a J;
    private NavigationFragment K;
    private bv L;
    private TwitterSessionManager M;
    private SharedPreferences N;
    private Runnable O;
    private List P;
    private List Q;
    private WrappingListPopupWindow R;
    private WrappingListPopupWindow S;
    private String T;
    private int U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private boolean Z;
    AddFollowingController a;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private com.socialin.android.dialog.a ae;
    private com.picsart.studio.d af;
    private boolean ag;
    private CallbackManager ah;
    private int ai;
    RemoveFollowingController b;
    ParamWithUserData c;
    public ViewerUser d;
    CheckBox e;
    private final android.widget.AdapterView.OnItemClickListener g = a("cover_image");
    private final android.widget.AdapterView.OnItemClickListener h = a("profile_image");
    private BroadcastReceiver i;
    private BaseSocialinApiRequestController j;
    private BaseSocialinApiRequestController k;
    private BaseSocialinApiRequestController l;
    private UpdateUserController m;
    private UpdateUserParams n;
    private Runnable o;
    private Toolbar p;
    private DrawerLayout q;
    private View r;
    private View s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private View x;
    private ImageView y;
    private ImageView z;

    public ProfileActivity()
    {
        j = RequestControllerFactory.createGetViewerController();
        k = RequestControllerFactory.createAddBlockedUserController();
        l = RequestControllerFactory.createRemoveBlockedUserController();
        m = new UpdateUserController();
        a = new AddFollowingController();
        b = new RemoveFollowingController();
        c = new ParamWithUserData();
        n = new UpdateUserParams();
        o = new Runnable() {

            private ProfileActivity a;

            public final void run()
            {
                if (!a.isFinishing())
                {
                    com.picsart.studio.profile.ProfileActivity.a(a, SocialinV3.getInstance().getUser());
                    com.picsart.studio.profile.ProfileActivity.a(a);
                }
            }

            
            {
                a = ProfileActivity.this;
                super();
            }
        };
        ad = false;
        ae = null;
        ai = 0;
    }

    static UpdateUserController A(ProfileActivity profileactivity)
    {
        return profileactivity.m;
    }

    static void B(ProfileActivity profileactivity)
    {
        profileactivity.k();
    }

    static void C(ProfileActivity profileactivity)
    {
        profileactivity.l();
    }

    static int a(ProfileActivity profileactivity, int i1)
    {
        profileactivity.ai = i1;
        return i1;
    }

    private android.widget.AdapterView.OnItemClickListener a(String s1)
    {
        return new android.widget.AdapterView.OnItemClickListener(s1) {

            private String a;
            private ProfileActivity b;

            public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                com.picsart.studio.profile.ProfileActivity.a(b, a, i1);
            }

            
            {
                b = ProfileActivity.this;
                a = s1;
                super();
            }
        };
    }

    static ViewerUser a(ProfileActivity profileactivity, ViewerUser vieweruser)
    {
        profileactivity.d = vieweruser;
        return vieweruser;
    }

    private void a(float f1)
    {
        float f2;
        float f3;
        int i1;
        int j1;
        p.animate().cancel();
        E.animate().cancel();
        i1 = p.getHeight();
        j1 = I.getHeight();
        f3 = E.getTranslationY();
        f2 = p.getTranslationY();
        if (ac)
        {
            b((int)Math.min(((float)(-X) * 255F) / (float)(F.getHeight() - i1), 255F));
        } else
        {
            b((int)Math.min(((float)(-X) * 255F) / (((float)r.getTop() + (float)u.getHeight() / 2.0F) - (float)i1 / 2.0F), 255F));
        }
        if (-X >= F.getHeight() - i1) goto _L2; else goto _L1
_L1:
        p.setTranslationY(0.0F);
        E.setTranslationY(X);
_L4:
        if (E.getTranslationY() > 0.0F)
        {
            E.setTranslationY(0.0F);
        }
        return;
_L2:
        if (-X <= j1)
        {
            p.setTranslationY(0.0F);
            s.setTranslationY(0.0F);
            E.setTranslationY(-(F.getHeight() - i1));
        } else
        if (-X > j1)
        {
            f3 = Math.min(Math.max(f3 + f1, -E.getHeight()), -F.getHeight() + i1);
            E.setTranslationY(f3);
            f1 = Math.min(Math.max(f2 + f1, -i1), 0.0F);
            p.setTranslationY(f1);
            s.setTranslationY(f1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Menu menu)
    {
        if (d())
        {
            getMenuInflater().inflate(0x7f11000a, menu);
            return;
        }
        getMenuInflater().inflate(0x7f11000f, menu);
        menu = menu.findItem(0x7f100aef);
        int i1;
        if (d != null && d.isBlocked)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            i1 = 0x7f08064c;
        } else
        {
            i1 = 0x7f08005b;
        }
        menu.setTitle(i1);
    }

    static void a(ProfileActivity profileactivity)
    {
        profileactivity.n();
    }

    static void a(ProfileActivity profileactivity, float f1)
    {
        int i1 = 0;
        ActionBar actionbar = profileactivity.getSupportActionBar();
        if (actionbar != null)
        {
            if (f1 > 0.0F)
            {
                if (!profileactivity.ab)
                {
                    profileactivity.ab = true;
                    profileactivity.invalidateOptionsMenu();
                    actionbar.setDisplayShowCustomEnabled(false);
                    i1 = profileactivity.Y;
                }
                profileactivity.b(Math.max(i1, (int)(255F * f1)));
            } else
            if (f1 == 0.0F)
            {
                if (profileactivity.ab)
                {
                    profileactivity.ab = false;
                    profileactivity.invalidateOptionsMenu();
                }
                profileactivity.b(0);
                return;
            }
        }
    }

    static void a(ProfileActivity profileactivity, int i1, int j1)
    {
        profileactivity.e();
        profileactivity.R.setHorizontalOffset(i1);
        profileactivity.R.setVerticalOffset(j1);
        profileactivity.R.show();
    }

    static void a(ProfileActivity profileactivity, Intent intent, int i1)
    {
        String s4 = intent.getExtras().getString("path");
        String s1;
        String s2;
        String s3;
        Object obj;
        if (intent.hasExtra("origFile"))
        {
            s1 = intent.getStringExtra("origFile");
        } else
        {
            s1 = null;
        }
        if (SocialinV3.getInstance().isRegistered())
        {
            s2 = SocialinV3.getInstance().getUser().username;
        } else
        {
            s2 = null;
        }
        if (intent.hasExtra("source"))
        {
            s3 = intent.getStringExtra("source");
        } else
        {
            s3 = null;
        }
        try
        {
            intent = com.socialin.android.util.w.a(s4, i1);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            com.socialin.android.d.c(new Object[] {
                intent.getMessage(), intent, "image cannot be decoded (too large or doesn't exist or broken)"
            });
            intent = null;
        }
        obj = intent;
        if (intent == null)
        {
            try
            {
                obj = com.socialin.android.util.w.b(s4, PicsartContext.a.getMaxImageSizePixel(), i1);
            }
            catch (Exception exception)
            {
                com.socialin.android.d.c(new Object[] {
                    exception.getMessage(), exception, "image cannot be decoded "
                });
                exception = intent;
            }
        }
        if (obj != null)
        {
            intent = (new StringBuilder()).append(profileactivity.getString(0x7f0808fc)).append("_").append(System.currentTimeMillis()).toString();
            intent = com.socialin.android.util.w.a(profileactivity.getString(0x7f08096b), intent, ((android.graphics.Bitmap) (obj)), profileactivity, android.graphics.Bitmap.CompressFormat.JPEG, false);
            ExifTool.a(intent.getAbsolutePath(), ExifTool.b(s4));
            if (s3 != null)
            {
                com.socialin.android.util.x.a(intent.getPath(), s1, s2, s3);
            }
            com.socialin.android.util.c.a(((android.graphics.Bitmap) (obj)));
            DialogUtils.dismissDialog(profileactivity, profileactivity.H);
            myobfuscated.cv.c.a(profileactivity, intent.getAbsolutePath());
        }
    }

    static void a(ProfileActivity profileactivity, StatusObj statusobj, ViewerUser vieweruser)
    {
        DialogUtils.dismissDialog(profileactivity, profileactivity.H);
        boolean flag;
        if (statusobj.reason != null && statusobj.reason.contains("user_blocked"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            statusobj = vieweruser.name;
            vieweruser = (new StringBuilder()).append(profileactivity.getResources().getString(0x7f08064b)).append(" ").toString();
            vieweruser = (new StringBuilder()).append(vieweruser);
            Resources resources = profileactivity.getResources();
            if (statusobj == null)
            {
                statusobj = profileactivity.getString(0x7f0805f9);
            }
            Utils.c(profileactivity, vieweruser.append(resources.getString(0x7f080659, new Object[] {
                statusobj
            })).toString());
            return;
        }
        vieweruser.isOwnerFollowing = true;
        statusobj = profileactivity.d;
        statusobj.followingsCount = ((ViewerUser) (statusobj)).followingsCount + 1;
        if (profileactivity.e != null)
        {
            profileactivity.e.setChecked(profileactivity.d.isOwnerFollowing);
            profileactivity.e.setEnabled(true);
        }
        if (profileactivity.N == null || profileactivity.N.getBoolean("enable_fb_action_follow", true))
        {
            GalleryUtils.a(profileactivity, vieweruser);
        }
        profileactivity.j();
    }

    static void a(ProfileActivity profileactivity, Exception exception)
    {
label0:
        {
label1:
            {
                if (profileactivity.isFinishing())
                {
                    break label0;
                }
                DialogUtils.dismissDialog(profileactivity, profileactivity.H);
                String s1 = exception.getLocalizedMessage();
                if (s1 != null)
                {
                    exception = s1;
                    if (!"".equals(s1))
                    {
                        break label1;
                    }
                }
                exception = profileactivity.getString(0x7f08024e);
            }
            Utils.c(profileactivity, exception);
            profileactivity.e.setEnabled(true);
        }
    }

    static void a(ProfileActivity profileactivity, String s1, int i1)
    {
        b b1;
        if (s1.equals("cover_image"))
        {
            b1 = (b)profileactivity.Q.get(i1);
        } else
        {
            b1 = (b)profileactivity.P.get(i1);
        }
        if (b1.c == -1) goto _L2; else goto _L1
_L1:
        profileactivity.T = s1;
        b1.c;
        JVM INSTR lookupswitch 5: default 92
    //                   1: 110
    //                   2: 239
    //                   3: 294
    //                   4: 312
    //                   16: 317;
           goto _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        return;
_L3:
        s1 = profileactivity.getIntent();
        s1.putExtra("imgaeType", profileactivity.T);
        if ("profile_image".equals(profileactivity.T))
        {
            s1.removeExtra("imageWIdth");
            s1.removeExtra("imageHeight");
        } else
        {
            s1.putExtra("imageWIdth", PicsartContext.a.getCollageImageMaxSize());
            s1.putExtra("imageHeight", (PicsartContext.a.getCollageImageMaxSize() * 9) / 16);
        }
        s1.putExtra("getImgFrom", "image_chooser");
        s1.setClass(profileactivity, com/socialin/android/picsart/profile/activity/UserAvatarUploadActivity);
        if ("profile_image".equals(profileactivity.T))
        {
            profileactivity.startActivityForResult(s1, 116);
            return;
        } else
        {
            profileactivity.startActivityForResult(s1, 159);
            return;
        }
_L4:
        if (!profileactivity.isFinishing())
        {
            if (!com.socialin.android.util.s.a(profileactivity))
            {
                GalleryUtils.a(profileactivity);
            } else
            {
                profileactivity.ah = com.facebook.CallbackManager.Factory.create();
                FacebookUtils.fetchUserPictureData(profileactivity, profileactivity.ah, profileactivity. new com.socialin.android.facebook.p() {

                    private ProfileActivity a;

                    public final void a()
                    {
                        if ("profile_image".equals(com.picsart.studio.profile.ProfileActivity.x(a)))
                        {
                            com.picsart.studio.profile.ProfileActivity.y(a).photo = FacebookUtils.getUserData().e;
                        } else
                        {
                            Object obj = FacebookUtils.getUserData();
                            if (((com.socialin.android.facebook.l) (obj)).f == null)
                            {
                                obj = "";
                            } else
                            {
                                obj = ((com.socialin.android.facebook.l) (obj)).f.a;
                            }
                            if (TextUtils.isEmpty(((CharSequence) (obj))))
                            {
                                DialogUtils.dismissDialog(a, com.picsart.studio.profile.ProfileActivity.z(a));
                                Utils.c(a, a.getString(0x7f08026a));
                                return;
                            }
                            com.picsart.studio.profile.ProfileActivity.y(a).cover = ((String) (obj));
                        }
                        ProfileActivity.A(a).setRequestParams(com.picsart.studio.profile.ProfileActivity.y(a));
                        ProfileActivity.A(a).doRequest("userUpdate", com.picsart.studio.profile.ProfileActivity.y(a));
                    }

            
            {
                a = ProfileActivity.this;
                super();
            }
                });
            }
        }
        AnalyticUtils.getInstance(profileactivity).trackLocalAction("my_profile:change_cover_fb");
        return;
_L5:
        profileactivity.c(165);
        AnalyticUtils.getInstance(profileactivity).trackLocalAction("my_profile:change_cover_twitter");
        return;
_L6:
        profileactivity.o();
        return;
_L7:
        profileactivity.A.setImageDrawable(null);
        if (profileactivity.d != null)
        {
            profileactivity.d.cover = " ";
        } else
        {
            SocialinV3.getInstance().getUser().cover = " ";
        }
        profileactivity.n.cover = " ";
        profileactivity.m.setRequestCompleteListener(new com.picsart.studio.profile.a(profileactivity, (byte)0));
        profileactivity.m.doRequest("reloadUser", profileactivity.n);
        return;
    }

    static void a(ProfileActivity profileactivity, Map map, Intent intent)
    {
        String s1;
        String s2;
        String s3;
        Object obj;
        if (intent.hasExtra("origFile"))
        {
            s1 = intent.getStringExtra("origFile");
        } else
        {
            s1 = null;
        }
        if (SocialinV3.getInstance().isRegistered())
        {
            s2 = SocialinV3.getInstance().getUser().username;
        } else
        {
            s2 = null;
        }
        if (intent.hasExtra("source"))
        {
            s3 = intent.getStringExtra("source");
        } else
        {
            s3 = null;
        }
        try
        {
            intent = com.socialin.android.util.w.a(map, 0, 0, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            com.socialin.android.d.c(new Object[] {
                intent.getMessage(), intent, "image cannot be decoded (too large or doesn't exist or broken)"
            });
            intent = null;
        }
        obj = intent;
        if (intent == null)
        {
            obj = com.socialin.android.util.w.a(map, PicsartContext.a.getMaxImageSizePixel());
        }
        if (obj != null)
        {
            map = (new StringBuilder()).append(profileactivity.getString(0x7f0808fc)).append("_").append(System.currentTimeMillis()).toString();
            map = com.socialin.android.util.w.a(profileactivity.getString(0x7f08096b), map, ((android.graphics.Bitmap) (obj)), profileactivity, android.graphics.Bitmap.CompressFormat.JPEG, false);
            if (s3 != null)
            {
                com.socialin.android.util.x.a(map.getPath(), s1, s2, s3);
            }
            com.socialin.android.util.c.a(((android.graphics.Bitmap) (obj)));
            DialogUtils.dismissDialog(profileactivity, profileactivity.H);
            myobfuscated.cv.c.a(profileactivity, map.getAbsolutePath());
        }
    }

    private void a(boolean flag)
    {
        d.isBlocked = flag;
        if (!isFinishing())
        {
            invalidateOptionsMenu();
        }
    }

    private static boolean a(ViewerUser vieweruser)
    {
        return vieweruser != null && vieweruser.id > 0L && !TextUtils.isEmpty(vieweruser.username);
    }

    private void b(int i1)
    {
        TypedArray typedarray = getTheme().obtainStyledAttributes(new int[] {
            0x7f010120
        });
        int k1 = typedarray.getColor(0, 0xff000000);
        typedarray.recycle();
        int j1 = i1;
        if (i1 < 0)
        {
            j1 = 0;
        }
        Y = j1;
        p.setBackgroundColor(Color.argb(j1, Color.red(k1), Color.green(k1), Color.blue(k1)));
    }

    static void b(ProfileActivity profileactivity)
    {
label0:
        {
            if (!SocialinV3.getInstance().isRegistered())
            {
                AnalyticUtils.getInstance(profileactivity).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("user_profile", "block"));
            }
            if (profileactivity.d != null && profileactivity.a(1003) && !profileactivity.d())
            {
                if (!profileactivity.d.isBlocked)
                {
                    break label0;
                }
                if (profileactivity.a(1003) && !profileactivity.d())
                {
                    AnalyticUtils.getInstance(profileactivity).trackLocalAction("profile:unBlock");
                    profileactivity.l.setRequestCompleteListener(profileactivity. new com.socialin.asyncnet.d() {

                        private ProfileActivity a;

                        public final volatile void onCancelRequest(Object obj, Request request)
                        {
                        }

                        public final void onFailure(Exception exception, Request request)
                        {
                            com.picsart.studio.profile.ProfileActivity.d(a, exception);
                        }

                        public final transient void onProgressUpdate(Integer ainteger[])
                        {
                        }

                        public final void onSuccess(Object obj, Request request)
                        {
                            com.picsart.studio.profile.ProfileActivity.w(a);
                        }

            
            {
                a = ProfileActivity.this;
                super();
            }
                    });
                    DialogUtils.showDialog(profileactivity, profileactivity.H);
                    profileactivity.c.userId = profileactivity.d.id;
                    profileactivity.l.setRequestParams(profileactivity.c);
                    profileactivity.l.doRequest("unBlockUser", profileactivity.c);
                }
            }
            return;
        }
        AnalyticUtils analyticutils = AnalyticUtils.getInstance(profileactivity);
        String s1;
        if (profileactivity.d())
        {
            s1 = "my_profile:block";
        } else
        {
            s1 = "profile:block";
        }
        analyticutils.trackLocalAction(s1);
        profileactivity.k.setRequestCompleteListener(profileactivity. new com.socialin.asyncnet.d() {

            private ProfileActivity a;

            public final volatile void onCancelRequest(Object obj, Request request)
            {
            }

            public final void onFailure(Exception exception, Request request)
            {
                com.picsart.studio.profile.ProfileActivity.c(a, exception);
            }

            public final transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public final void onSuccess(Object obj, Request request)
            {
                ProfileActivity.v(a);
            }

            
            {
                a = ProfileActivity.this;
                super();
            }
        });
        DialogUtils.showDialog(profileactivity, profileactivity.H);
        profileactivity.c.userId = profileactivity.d.id;
        profileactivity.k.setRequestParams(profileactivity.c);
        profileactivity.k.doRequest("blockUser", profileactivity.c);
    }

    static void b(ProfileActivity profileactivity, int i1)
    {
        if (profileactivity.J == null || profileactivity.J.a(i1) == null) goto _L2; else goto _L1
_L1:
        Object obj = (bu)profileactivity.J.a(0);
        if (obj != null)
        {
            obj.j = null;
        }
        obj = (z)profileactivity.J.a(2);
        if (obj != null)
        {
            obj.j = null;
        }
        obj = (y)profileactivity.J.a(1);
        if (obj != null)
        {
            obj.j = null;
        }
        obj = (ar)profileactivity.J.a(3);
        if (obj != null)
        {
            obj.j = null;
        }
        int k1 = profileactivity.F.getHeight();
        int j1;
        if (profileactivity.getSupportActionBar() != null)
        {
            j1 = profileactivity.getSupportActionBar().getHeight();
        } else
        {
            j1 = 0;
        }
        j1 = -(k1 - j1);
        profileactivity.X = Math.max(profileactivity.X, j1);
        i1;
        JVM INSTR tableswitch 0 3: default 176
    //                   0 267
    //                   1 357
    //                   2 312
    //                   3 402;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        obj = profileactivity.getSupportActionBar();
        if (obj != null)
        {
            i1 = ((ActionBar) (obj)).getHeight();
            if (profileactivity.p.getTranslationY() < (float)(-i1) / 2.0F)
            {
                profileactivity.p.animate().translationY(0.0F);
                if (profileactivity.E.getTranslationY() < (float)(i1 - profileactivity.F.getHeight()))
                {
                    profileactivity.E.animate().translationY(-(profileactivity.F.getHeight() - i1));
                }
            }
        }
_L2:
        return;
_L4:
        bu bu1 = (bu)profileactivity.J.a(0);
        bu1.j = profileactivity;
        bu1.a(profileactivity.X);
        AnalyticUtils.getInstance(profileactivity).track(new com.socialin.android.apiv3.events.EventsFactory.ProfileTabEvent("photos"));
        continue; /* Loop/switch isn't completed */
_L6:
        z z1 = (z)profileactivity.J.a(2);
        z1.j = profileactivity;
        z1.a(profileactivity.X);
        AnalyticUtils.getInstance(profileactivity).track(new com.socialin.android.apiv3.events.EventsFactory.ProfileTabEvent("followers"));
        continue; /* Loop/switch isn't completed */
_L5:
        y y1 = (y)profileactivity.J.a(1);
        y1.j = profileactivity;
        y1.a(profileactivity.X);
        AnalyticUtils.getInstance(profileactivity).track(new com.socialin.android.apiv3.events.EventsFactory.ProfileTabEvent("following"));
        continue; /* Loop/switch isn't completed */
_L7:
        ar ar1 = (ar)profileactivity.J.a(3);
        ar1.j = profileactivity;
        ar1.a(profileactivity.X);
        AnalyticUtils.getInstance(profileactivity).track(new com.socialin.android.apiv3.events.EventsFactory.ProfileTabEvent("membox"));
        if (true) goto _L3; else goto _L8
_L8:
    }

    static void b(ProfileActivity profileactivity, ViewerUser vieweruser)
    {
label0:
        {
            if (!profileactivity.ag)
            {
                if (a(vieweruser))
                {
                    break label0;
                }
                profileactivity.h();
            }
            return;
        }
        profileactivity.d = vieweruser;
        profileactivity.f();
    }

    static void b(ProfileActivity profileactivity, Exception exception)
    {
label0:
        {
label1:
            {
                if (profileactivity.isFinishing())
                {
                    break label0;
                }
                DialogUtils.dismissDialog(profileactivity, profileactivity.H);
                String s1 = exception.getLocalizedMessage();
                if (s1 != null)
                {
                    exception = s1;
                    if (!"".equals(s1))
                    {
                        break label1;
                    }
                }
                exception = profileactivity.getString(0x7f08024e);
            }
            Utils.c(profileactivity, exception);
            profileactivity.e.setEnabled(true);
        }
    }

    static int c(ProfileActivity profileactivity, int i1)
    {
        profileactivity.V = i1;
        return i1;
    }

    static ViewerUser c(ProfileActivity profileactivity)
    {
        return profileactivity.d;
    }

    private void c(int i1)
    {
        U = i1;
        if (a(157))
        {
            if (M == null)
            {
                M = new TwitterSessionManager(this);
            }
            M.startTwitterNewSession(U, true);
        }
    }

    static void c(ProfileActivity profileactivity, ViewerUser vieweruser)
    {
        if (!a(vieweruser))
        {
            profileactivity.h();
            return;
        } else
        {
            profileactivity.d = vieweruser;
            profileactivity.b();
            profileactivity.g();
            return;
        }
    }

    static void c(ProfileActivity profileactivity, Exception exception)
    {
        DialogUtils.dismissDialog(profileactivity, profileactivity.H);
        String s1;
        if (exception.getLocalizedMessage() != null)
        {
            s1 = exception.getLocalizedMessage();
        } else
        {
            s1 = profileactivity.getResources().getString(0x7f0805cb);
        }
        Utils.c(profileactivity, s1);
        if ("user_not_found".equals(((SocialinApiException)exception).getReason()))
        {
            SocialinV3.getInstance().removeDevice();
        }
    }

    static int d(ProfileActivity profileactivity, int i1)
    {
        profileactivity.W = i1;
        return i1;
    }

    static z d(ProfileActivity profileactivity)
    {
        return (z)profileactivity.getFragmentManager().findFragmentByTag("followings.fragment");
    }

    static void d(ProfileActivity profileactivity, ViewerUser vieweruser)
    {
        DialogUtils.dismissDialog(profileactivity, profileactivity.H);
        vieweruser.isOwnerFollowing = false;
        vieweruser = profileactivity.d;
        vieweruser.followingsCount = vieweruser.followingsCount - 1;
        if (profileactivity.e != null)
        {
            profileactivity.e.setChecked(profileactivity.d.isOwnerFollowing);
            profileactivity.e.setEnabled(true);
        }
        profileactivity.j();
    }

    static void d(ProfileActivity profileactivity, Exception exception)
    {
        DialogUtils.dismissDialog(profileactivity, profileactivity.H);
        String s1;
        if (exception.getLocalizedMessage() != null)
        {
            s1 = exception.getLocalizedMessage();
        } else
        {
            s1 = profileactivity.getResources().getString(0x7f0805cb);
        }
        Utils.c(profileactivity, s1);
        if ("user_not_found".equals(((SocialinApiException)exception).getReason()))
        {
            SocialinV3.getInstance().removeDevice();
        }
    }

    static y e(ProfileActivity profileactivity)
    {
        return (y)profileactivity.getFragmentManager().findFragmentByTag("followers.fragment");
    }

    private void e()
    {
        boolean flag = false;
        Q = new ArrayList(6);
        Q.add(new b(getString(0x7f0802ac), -1, -1));
        Q.add(new b(getString(0x7f08029e), 0x7f020382, 1));
        if (!getString(0x7f0808c8).equalsIgnoreCase(getString(0x7f0808cc)))
        {
            Q.add(new b(getString(0x7f080073), 0x7f020363, 2));
            Q.add(new b(getString(0x7f080073), 0x7f02040e, 3));
        }
        if (!ad)
        {
            Q.add(new b(getString(0x7f080334), 0x7f020336, 16));
        }
        Q.add(new b(getString(0x7f0804d8), -1, -1));
        Q.add(new b(getString(0x7f0802bd), 0x7f02034b, 4));
        P = new ArrayList(3);
        P.add(new b(getString(0x7f08029e), 0x7f020382, 1));
        if (!getString(0x7f0808c8).equalsIgnoreCase(getString(0x7f0808cc)))
        {
            P.add(new b(getString(0x7f080073), 0x7f020363, 2));
            P.add(new b(getString(0x7f080073), 0x7f02040e, 3));
        }
        String as[] = new String[Q.size()];
        int ai1[] = new int[Q.size()];
        for (int i1 = 0; i1 < Q.size(); i1++)
        {
            as[i1] = ((b)Q.get(i1)).a;
            ai1[i1] = ((b)Q.get(i1)).b;
        }

        aa aa1 = new aa(this, 0x1090008, 0x7f03023a, as, ai1);
        p p1 = WrappingListPopupWindow.a(this);
        p1.a = A;
        p1.d = 0x7f0c0228;
        p1.a = A;
        p1.b = aa1;
        p1.c = g;
        R = p1.a();
        R.setModal(true);
        aa1 = new String[P.size()];
        p1 = new int[P.size()];
        for (int j1 = ((flag) ? 1 : 0); j1 < P.size(); j1++)
        {
            aa1[j1] = ((b)P.get(j1)).a;
            p1[j1] = ((b)P.get(j1)).b;
        }

        aa1 = new aa(this, 0x1090008, 0x7f03023a, aa1, p1);
        p1 = WrappingListPopupWindow.a(this);
        p1.a = y;
        p1.d = 0x7f0c0228;
        p1.a = y;
        p1.b = aa1;
        p1.c = h;
        S = p1.a();
        S.setModal(true);
    }

    private void f()
    {
        B.setVisibility(0);
        C.setVisibility(8);
        D.setVisibility(8);
        if (Z)
        {
            if (!isFinishing())
            {
                Intent intent = getIntent();
                intent.setClass(this, com/socialin/android/picsart/profile/activity/FindFriendsActivity);
                startActivityForResult(intent, 105);
            }
            Z = false;
        }
        g();
        Object obj = getFragmentManager();
        Object obj2 = ((FragmentManager) (obj)).beginTransaction();
        Object obj3 = ((FragmentManager) (obj)).findFragmentByTag("photos.fragment");
        if (obj3 != null)
        {
            ((FragmentTransaction) (obj2)).remove(((Fragment) (obj3)));
        }
        obj3 = ((FragmentManager) (obj)).findFragmentByTag("followers.fragment");
        if (obj3 != null)
        {
            ((FragmentTransaction) (obj2)).remove(((Fragment) (obj3)));
        }
        obj3 = ((FragmentManager) (obj)).findFragmentByTag("followings.fragment");
        if (obj3 != null)
        {
            ((FragmentTransaction) (obj2)).remove(((Fragment) (obj3)));
        }
        obj3 = ((FragmentManager) (obj)).findFragmentByTag("membox.fragment");
        if (obj3 != null)
        {
            ((FragmentTransaction) (obj2)).remove(((Fragment) (obj3)));
        }
        ar ar1;
        Bundle bundle;
        int i1;
        try
        {
            ((FragmentTransaction) (obj2)).commitAllowingStateLoss();
        }
        catch (IllegalStateException illegalstateexception)
        {
            illegalstateexception.printStackTrace();
        }
        ((FragmentManager) (obj)).executePendingTransactions();
        obj = J;
        ((a) (obj)).a.clear();
        ((a) (obj)).notifyDataSetChanged();
        obj = new bu();
        obj.j = this;
        obj2 = new y();
        obj2.j = this;
        obj3 = new z();
        obj3.j = this;
        ar1 = new ar();
        ar1.j = this;
        J.a(((Fragment) (obj)), getString(0x7f080320), "photos.fragment");
        J.a(((Fragment) (obj2)), getString(0x7f0805b7), "followers.fragment");
        J.a(((Fragment) (obj3)), getString(0x7f0805b8), "followings.fragment");
        J.a(ar1, getString(0x7f0803ef), "membox.fragment");
        I.setAdapter(J);
        I.setCurrentItem(ai);
        G.setViewPager(I);
        G.a(ai).setSelected(true);
        G.setOnPageChangeListener(new _cls27());
        E.measure(-1, -2);
        G.measure(-1, -2);
        p.measure(-1, -2);
        i1 = E.getMeasuredHeight();
        bundle = new Bundle();
        bundle.putLong("profileUserId", d.id);
        bundle.putBoolean("myProfile", d());
        bundle.putInt("coverHeight", i1);
        bundle.putInt("topScrollHeight", G.getMeasuredHeight() + p.getMeasuredHeight());
        ((bu) (obj)).setArguments(bundle);
        ((y) (obj2)).setArguments(bundle);
        ((z) (obj3)).setArguments(bundle);
        ar1.setArguments(bundle);
        invalidateOptionsMenu();
        if (J != null)
        {
            Object obj1 = (y)J.a(1);
            if (obj1 != null)
            {
                ((y) (obj1)).a(d());
            }
            obj1 = (z)J.a(2);
            if (obj1 != null)
            {
                ((z) (obj1)).a(d());
            }
        }
        if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
        {
            com.socialin.android.util.b b1 = com.socialin.android.util.b.a(this);
            String s1 = Long.toString(d.id);
            if (b1.a != null)
            {
                b1.a.getCurrentUser().addToCustomAttributeArray("recent_artists_viewed", s1);
            }
        }
    }

    static void f(ProfileActivity profileactivity)
    {
        profileactivity.a(0.0F);
    }

    private void g()
    {
        k();
        l();
        n();
        w.setText(d.name);
        w.post(new _cls28());
        j();
    }

    static void g(ProfileActivity profileactivity)
    {
        if (profileactivity.O != null)
        {
            profileactivity.O.run();
            profileactivity.O = null;
        }
    }

    private void h()
    {
        B.setVisibility(8);
        C.setVisibility(8);
        D.setVisibility(0);
    }

    static boolean h(ProfileActivity profileactivity)
    {
        return profileactivity.ac;
    }

    static TextView i(ProfileActivity profileactivity)
    {
        return profileactivity.w;
    }

    private void i()
    {
        j.setRequestCompleteListener(new com.socialin.asyncnet.d() {

            private ProfileActivity a;

            public final volatile void onCancelRequest(Object obj, Request request)
            {
            }

            public final void onFailure(Exception exception, Request request)
            {
                com.picsart.studio.profile.ProfileActivity.l(a);
            }

            public final transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public final void onSuccess(Object obj, Request request)
            {
                obj = (ViewerUser)obj;
                com.picsart.studio.profile.ProfileActivity.c(a, ((ViewerUser) (obj)));
            }

            
            {
                a = ProfileActivity.this;
                super();
            }
        });
        if (com.socialin.android.util.s.a(this))
        {
            c.userId = d.id;
            j.doRequest(f, c);
        }
    }

    static Toolbar j(ProfileActivity profileactivity)
    {
        return profileactivity.p;
    }

    private void j()
    {
        if (I != null)
        {
            I.setCurrentItem(ai);
        }
        J.notifyDataSetChanged();
    }

    private void k()
    {
        if (d != null)
        {
            String s1 = d.cover;
            if ((TextUtils.isEmpty(s1) || " ".equals(s1)) && d())
            {
                ad = true;
                findViewById(0x7f100178).setVisibility(0);
            } else
            {
                ad = false;
                findViewById(0x7f100178).setVisibility(8);
                if (PicsartContext.a() < 0x100000)
                {
                    s1 = (new StringBuilder()).append(s1).append(ImageItem.prefixMidle).toString();
                }
                af.a(s1, A, (e)((e)com.bumptech.glide.request.e.c(af.a).a(new ColorDrawable(getResources().getColor(0x7f0f0096)))).b(new ColorDrawable(getResources().getColor(0x7f0f0096))));
            }
            if (d())
            {
                A.setOnTouchListener(new android.view.View.OnTouchListener() {

                    private ProfileActivity a;

                    public final boolean onTouch(View view, MotionEvent motionevent)
                    {
                        com.picsart.studio.profile.ProfileActivity.c(a, (int)motionevent.getX());
                        com.picsart.studio.profile.ProfileActivity.d(a, (int)motionevent.getY());
                        return false;
                    }

            
            {
                a = ProfileActivity.this;
                super();
            }
                });
                A.setOnClickListener(new android.view.View.OnClickListener() {

                    private ProfileActivity a;

                    public final void onClick(View view)
                    {
                        com.picsart.studio.profile.ProfileActivity.a(a, com.picsart.studio.profile.ProfileActivity.m(a), ProfileActivity.n(a) - ProfileActivity.o(a).getHeight());
                    }

            
            {
                a = ProfileActivity.this;
                super();
            }
                });
                findViewById(0x7f10017d).setVisibility(0);
                findViewById(0x7f10017d).setOnClickListener(new android.view.View.OnClickListener() {

                    private ProfileActivity a;

                    public final void onClick(View view)
                    {
                        a.c();
                    }

            
            {
                a = ProfileActivity.this;
                super();
            }
                });
            }
        }
    }

    static void k(ProfileActivity profileactivity)
    {
        profileactivity.m();
    }

    private void l()
    {
        Object obj = d.getPhotoSmall();
        if (obj != null && ((String) (obj)).startsWith("http://graph.facebook.com"))
        {
            obj = ((String) (obj)).replaceFirst("http", "https");
        }
        (new com.socialin.android.util.f(getApplicationContext())).a(((String) (obj)), y, (e)((e)com.bumptech.glide.request.e.b(l.e).a(0x7f020669)).b(0x7f020669), null);
        obj = z;
        int i1;
        if (d.isValidated)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        ((ImageView) (obj)).setVisibility(i1);
        if (d())
        {
            e.setVisibility(8);
            x.setOnClickListener(new android.view.View.OnClickListener() {

                private ProfileActivity a;

                public final void onClick(View view)
                {
                    com.picsart.studio.profile.ProfileActivity.p(a);
                }

            
            {
                a = ProfileActivity.this;
                super();
            }
            });
            return;
        } else
        {
            e.setVisibility(0);
            e.setChecked(d.isOwnerFollowing);
            e.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                private ProfileActivity a;

                public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    if (!SocialinV3.getInstance().isRegistered())
                    {
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("user_profile", "follow"));
                    }
                    if (!flag) goto _L2; else goto _L1
_L1:
                    ViewerUser vieweruser;
                    ProfileActivity.q(a).setEnabled(false);
                    compoundbutton = a;
                    vieweruser = com.picsart.studio.profile.ProfileActivity.c(a);
                    if (!compoundbutton.a(1003) || compoundbutton.d()) goto _L4; else goto _L3
_L3:
                    AnalyticUtils.getInstance(compoundbutton).trackLocalAction("profile:FOLLOW");
                    AnalyticUtils.getInstance(compoundbutton).track(new com.socialin.android.apiv3.events.EventsFactory.FollowEvent("profile", vieweruser.id));
                    ((ProfileActivity) (compoundbutton)).c.userId = vieweruser.id;
                    ((ProfileActivity) (compoundbutton)).a.setRequestParams(((ProfileActivity) (compoundbutton)).c);
                    ((ProfileActivity) (compoundbutton)).a.setRequestCompleteListener(compoundbutton. new com.socialin.asyncnet.d(vieweruser) {

                        private ViewerUser a;
                        private ProfileActivity b;

                        public final volatile void onCancelRequest(Object obj, Request request)
                        {
                        }

                        public final void onFailure(Exception exception, Request request)
                        {
                            com.picsart.studio.profile.ProfileActivity.a(b, exception);
                        }

                        public final transient void onProgressUpdate(Integer ainteger[])
                        {
                        }

                        public final void onSuccess(Object obj, Request request)
                        {
                            obj = (StatusObj)obj;
                            com.picsart.studio.profile.ProfileActivity.a(b, ((StatusObj) (obj)), a);
                        }

            
            {
                b = ProfileActivity.this;
                a = vieweruser;
                super();
            }
                    });
                    ((ProfileActivity) (compoundbutton)).a.doRequest("addFollowing", ((ProfileActivity) (compoundbutton)).c);
_L6:
                    return;
_L4:
                    ((ProfileActivity) (compoundbutton)).e.setEnabled(true);
                    ((ProfileActivity) (compoundbutton)).e.setChecked(false);
                    return;
_L2:
                    ProfileActivity.q(a).setEnabled(false);
                    compoundbutton = a;
                    ViewerUser vieweruser1 = com.picsart.studio.profile.ProfileActivity.c(a);
                    if (compoundbutton.a(1003) && !compoundbutton.d())
                    {
                        AnalyticUtils.getInstance(compoundbutton).trackLocalAction("profile:unFollow");
                        AnalyticUtils.getInstance(compoundbutton).track(new com.socialin.android.apiv3.events.EventsFactory.UnFollowEvent("profile", vieweruser1.id));
                        ((ProfileActivity) (compoundbutton)).c.userId = vieweruser1.id;
                        ((ProfileActivity) (compoundbutton)).b.setRequestParams(((ProfileActivity) (compoundbutton)).c);
                        ((ProfileActivity) (compoundbutton)).b.setRequestCompleteListener(compoundbutton. new com.socialin.asyncnet.d(vieweruser1) {

                            private ViewerUser a;
                            private ProfileActivity b;

                            public final volatile void onCancelRequest(Object obj, Request request)
                            {
                            }

                            public final void onFailure(Exception exception, Request request)
                            {
                                com.picsart.studio.profile.ProfileActivity.b(b, exception);
                            }

                            public final transient void onProgressUpdate(Integer ainteger[])
                            {
                            }

                            public final void onSuccess(Object obj, Request request)
                            {
                                com.picsart.studio.profile.ProfileActivity.d(b, a);
                            }

            
            {
                b = ProfileActivity.this;
                a = vieweruser;
                super();
            }
                        });
                        ((ProfileActivity) (compoundbutton)).b.doRequest("removeFollowing", ((ProfileActivity) (compoundbutton)).c);
                        return;
                    }
                    if (true) goto _L6; else goto _L5
_L5:
                }

            
            {
                a = ProfileActivity.this;
                super();
            }
            });
            return;
        }
    }

    static void l(ProfileActivity profileactivity)
    {
        profileactivity.h();
    }

    static int m(ProfileActivity profileactivity)
    {
        return profileactivity.V;
    }

    private void m()
    {
        int i1 = 0;
        if (ac)
        {
            TextView textview = w;
            if ((float)(-(F.getHeight() - p.getHeight())) < E.getTranslationY())
            {
                i1 = 4;
            }
            textview.setVisibility(i1);
            return;
        } else
        {
            float f1 = r.getTop();
            float f2 = E.getTranslationY();
            float f3 = (float)u.getHeight() / 2.0F;
            w.setVisibility(0);
            w.setTranslationY(Math.max(0.0F, (f1 + f2 + f3) - (float)(p.getHeight() / 2)));
            return;
        }
    }

    static int n(ProfileActivity profileactivity)
    {
        return profileactivity.W;
    }

    private void n()
    {
        String s1;
        if (TextUtils.isEmpty(d.profileStatus) || d.profileStatus.equalsIgnoreCase(" "))
        {
            if (d())
            {
                s1 = getString(0x7f08022d);
            } else
            {
                s1 = "";
            }
        } else
        {
            s1 = d.profileStatus;
        }
        t.setText(s1);
        t.setOnClickListener(new android.view.View.OnClickListener() {

            private ProfileActivity a;

            public final void onClick(View view)
            {
                ProfileActivity.r(a);
            }

            
            {
                a = ProfileActivity.this;
                super();
            }
        });
        v.setText((new StringBuilder("@")).append(d.username).toString());
        u.setText(d.name);
        t.postDelayed(new Runnable(s1) {

            private String a;
            private ProfileActivity b;

            public final void run()
            {
                com.picsart.studio.profile.ProfileActivity.s(b).setText(a);
            }

            
            {
                b = ProfileActivity.this;
                a = s1;
                super();
            }
        }, 100L);
    }

    static ImageView o(ProfileActivity profileactivity)
    {
        return profileactivity.A;
    }

    private void o()
    {
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        Object obj = getFragmentManager().findFragmentByTag("editStatusFragment");
        if (obj != null)
        {
            fragmenttransaction.remove(((Fragment) (obj)));
        }
        L = new bv();
        L.a = o;
        obj = new Bundle();
        ((Bundle) (obj)).putString("user_status", d.profileStatus);
        ((Bundle) (obj)).putString("user_name", d.username);
        ((Bundle) (obj)).putLong("user_id", d.id);
        ((Bundle) (obj)).putBoolean("edit_mode", false);
        L.setArguments(((Bundle) (obj)));
        L.show(fragmenttransaction, "editStatusFragment");
    }

    static void p(ProfileActivity profileactivity)
    {
        profileactivity.S.show();
    }

    static CheckBox q(ProfileActivity profileactivity)
    {
        return profileactivity.e;
    }

    static void r(ProfileActivity profileactivity)
    {
        profileactivity.o();
    }

    static TextView s(ProfileActivity profileactivity)
    {
        return profileactivity.t;
    }

    static void t(ProfileActivity profileactivity)
    {
        PreferenceManager.getDefaultSharedPreferences(profileactivity).edit().remove((new StringBuilder()).append(SocialinV3.getInstance().getUser().id).append("prefs.since.id").toString()).apply();
        profileactivity.setSupportProgressBarIndeterminateVisibility(true);
        try
        {
            SocialinV3.getInstance().logoutUser();
            FacebookUtils.logoutFacebook(false);
            (new TwitterSessionManager(profileactivity)).clearTwitterSession();
            com.socialin.android.instagram.h.c(profileactivity.getApplicationContext());
            DropBoxSessionManager.getInstance(profileactivity.getApplicationContext()).clearDropBoxSession();
            com.socialin.android.oauth2.a.a((new com.socialin.android.deviantart.a(profileactivity.getApplicationContext())).b);
            (new com.socialin.android.googleplus.a(profileactivity.getApplicationContext())).a();
            (new com.socialin.android.tumblr.b(profileactivity.getApplicationContext())).a();
            profileactivity.setSupportProgressBarIndeterminateVisibility(false);
            com.socialin.android.picsart.profile.invite.i.i(profileactivity);
            profileactivity.getIntent().putExtra("reloadPager", true);
            profileactivity.setResult(126);
            profileactivity.finish();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ProfileActivity profileactivity) { }
        if (d.b)
        {
            throw new NetworkFragmentException(profileactivity);
        } else
        {
            ExceptionReportService.report(SocialinV3.getInstance().getContext(), profileactivity, String.valueOf(SocialinV3.getInstance().getUser().id));
            return;
        }
    }

    static com.socialin.android.dialog.a u(ProfileActivity profileactivity)
    {
        return profileactivity.ae;
    }

    static void v(ProfileActivity profileactivity)
    {
        DialogUtils.dismissDialog(profileactivity, profileactivity.H);
        String s1 = profileactivity.d.name;
        Utils.c(profileactivity, profileactivity.getResources().getString(0x7f08005d, new Object[] {
            s1
        }));
        profileactivity.a(true);
    }

    static void w(ProfileActivity profileactivity)
    {
        DialogUtils.dismissDialog(profileactivity, profileactivity.H);
        String s1 = profileactivity.d.name;
        Utils.c(profileactivity, profileactivity.getResources().getString(0x7f08064e, new Object[] {
            s1
        }));
        profileactivity.a(false);
        profileactivity.aa = true;
    }

    static String x(ProfileActivity profileactivity)
    {
        return profileactivity.T;
    }

    static UpdateUserParams y(ProfileActivity profileactivity)
    {
        return profileactivity.n;
    }

    static g z(ProfileActivity profileactivity)
    {
        return profileactivity.H;
    }

    public final void a()
    {
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            int i1 = actionbar.getHeight();
            if (p.getTranslationY() < (float)(-i1) / 2.0F)
            {
                p.animate().translationY(-i1);
                E.animate().translationY(-E.getHeight());
            } else
            {
                p.animate().translationY(0.0F);
                if (E.getTranslationY() < (float)(i1 - F.getHeight()))
                {
                    E.animate().translationY(-(F.getHeight() - i1));
                    return;
                }
            }
        }
    }

    public final void a(float f1, float f2)
    {
        X = (int)f2;
        a(f1);
        m();
    }

    final boolean a(int i1)
    {
        if (!com.socialin.android.util.s.a(this))
        {
            GalleryUtils.a(this);
            return false;
        }
        if (!a(d))
        {
            h();
            return false;
        }
        if (!SocialinV3.getInstance().isRegistered())
        {
            com.socialin.android.picsart.profile.util.y.a(this, Integer.valueOf(i1), com/picsart/studio/profile/ProfileActivity.getName());
            return false;
        } else
        {
            return true;
        }
    }

    public final void b()
    {
        ((TextView)G.a(Integer.valueOf(0x7f10005c)).findViewById(0x7f100793)).setText(String.valueOf(Utils.a(d.followersCount)));
        ((TextView)G.a(Integer.valueOf(0x7f10005d)).findViewById(0x7f100793)).setText(String.valueOf(Utils.a(d.followingsCount)));
        ((TextView)G.a(Integer.valueOf(0x7f10005e)).findViewById(0x7f100793)).setText(String.valueOf(Utils.a(d.streamsCount)));
        ((TextView)G.a(Integer.valueOf(0x7f10005f)).findViewById(0x7f100793)).setText(String.valueOf(Utils.a(d.photosCount)));
    }

    public final void c()
    {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), "com.picsart.studio.ImagePickerActivity");
        intent.putExtra("showCameraEffects", false);
        intent.putExtra("showPicsart", false);
        myobfuscated.cv.c.a(intent, this);
        startActivityForResult(intent, 4545);
    }

    public void closeNavigationBar(Runnable runnable)
    {
        if (q != null)
        {
            q.closeDrawers();
        }
        O = runnable;
    }

    final boolean d()
    {
        if (d == null || d.id != SocialinV3.getInstance().getUser().id)
        {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null)
            {
                long l1 = bundle.getLong("profileUserId", -1L);
                if (SocialinV3.getInstance().getUser().id != l1)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        Object obj;
        String s3;
        String s4;
        String s5;
        Object obj1;
        boolean flag;
        flag = true;
        s5 = null;
        obj = null;
        s3 = null;
        obj1 = null;
        s4 = null;
        super.onActivityResult(i1, j1, intent);
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        if (i1 != 100) goto _L4; else goto _L3
_L3:
        finish();
_L6:
        if ((i1 == 4 || i1 == 5) && intent != null)
        {
            aa = intent.getBooleanExtra("dataChanged", aa);
        }
        J.a(ai).onActivityResult(i1, j1, intent);
        return;
_L4:
        if (i1 == 4545)
        {
            int k1 = intent.getExtras().getInt("degree");
            if (intent.hasExtra("bufferData"))
            {
                obj = (HashMap)intent.getSerializableExtra("bufferData");
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                DialogUtils.showDialog(this, H);
                (new Thread(((Map) (obj)), intent) {

                    private Map a;
                    private Intent b;
                    private ProfileActivity c;

                    public final void run()
                    {
                        com.picsart.studio.profile.ProfileActivity.a(c, a, b);
                    }

            
            {
                c = ProfileActivity.this;
                a = map;
                b = intent;
                super();
            }
                }).start();
            } else
            if (k1 != 0)
            {
                DialogUtils.showDialog(this, H);
                (new Thread(intent, k1) {

                    private Intent a;
                    private int b;
                    private ProfileActivity c;

                    public final void run()
                    {
                        com.picsart.studio.profile.ProfileActivity.a(c, a, b);
                    }

            
            {
                c = ProfileActivity.this;
                a = intent;
                b = i1;
                super();
            }
                }).start();
            } else
            {
                s5 = intent.getExtras().getString("path");
                if (intent.hasExtra("origFile"))
                {
                    obj = intent.getStringExtra("origFile");
                } else
                {
                    obj = null;
                }
                if (SocialinV3.getInstance().isRegistered())
                {
                    s3 = SocialinV3.getInstance().getUser().username;
                } else
                {
                    s3 = null;
                }
                if (intent.hasExtra("source"))
                {
                    s4 = intent.getStringExtra("source");
                }
                if (s4 != null)
                {
                    com.socialin.android.util.x.a(s5, ((String) (obj)), s3, s4);
                }
                myobfuscated.cv.c.a(this, s5);
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i1 != 3)
        {
            break; /* Loop/switch isn't completed */
        }
        d = SocialinV3.getInstance().getUser();
        g();
        if (true) goto _L6; else goto _L5
_L5:
        if (i1 == 160 || i1 == 116 || i1 == 159)
        {
            switch (i1)
            {
            case 116: // 't'
                aa = true;
                d = SocialinV3.getInstance().getUser();
                l();
                break;

            case 160: 
                AnalyticUtils.getInstance(this).trackLocalAction("profile:editStatus");
                n();
                break;

            case 159: 
                aa = true;
                d = SocialinV3.getInstance().getUser();
                k();
                break;
            }
        } else
        if (i1 == 1003 || i1 == 1004)
        {
            Z = intent.getBooleanExtra("firstRegister", false);
        } else
        if (i1 == 4544)
        {
            com.socialin.android.picsart.profile.util.y.a(this, intent);
        } else
        if (i1 == 102)
        {
            if (ai != 3)
            {
                flag = false;
            }
            aa = flag;
        } else
        if (i1 == 157 || i1 == 165 || i1 == 164)
        {
            if (i1 == 157)
            {
                c(i1);
            } else
            if ("profile_image".equals(T))
            {
                myobfuscated.cv.c.a(intent, null);
                T = "profile_image";
                if (intent != null)
                {
                    obj = s5;
                    if (intent.hasExtra("tw_user_profile_url"))
                    {
                        obj = intent.getStringExtra("tw_user_profile_url");
                    }
                    n.photo = ((String) (obj));
                }
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    if (d != null)
                    {
                        d.photo = ((String) (obj));
                    } else
                    {
                        SocialinV3.getInstance().getUser().photo = ((String) (obj));
                    }
                    l();
                    m.setRequestCompleteListener(new com.picsart.studio.profile.a(this, (byte)0));
                    m.doRequest("reloadUser", n);
                } else
                {
                    Utils.c(this, getString(0x7f080480));
                }
            } else
            {
                myobfuscated.cv.c.a(intent, null);
                T = "cover_image";
                String s1 = obj1;
                if (intent != null)
                {
                    if (intent.hasExtra("tw_profile_banner_img_url"))
                    {
                        s1 = intent.getStringExtra("tw_profile_banner_img_url");
                    } else
                    {
                        s1 = null;
                    }
                    if (TextUtils.isEmpty(s1))
                    {
                        s1 = s3;
                        if (intent.hasExtra("tw_profile_bg_img_url"))
                        {
                            s1 = intent.getStringExtra("tw_profile_bg_img_url");
                        }
                    }
                    n.cover = s1;
                }
                if (!TextUtils.isEmpty(s1))
                {
                    if (d != null)
                    {
                        d.cover = s1;
                    } else
                    {
                        SocialinV3.getInstance().getUser().cover = s1;
                    }
                    k();
                    m.setRequestCompleteListener(new com.picsart.studio.profile.a(this, (byte)0));
                    m.doRequest("reloadUser", n);
                } else
                {
                    Utils.c(this, getString(0x7f08047f));
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (j1 == 1 && i1 == 1003)
        {
            finish();
        } else
        if (j1 == 0)
        {
            if (i1 == 1004 || i1 == 157)
            {
                finish();
            } else
            if (i1 == 104 && ai == 0)
            {
                i();
            } else
            if (i1 == 4539)
            {
                DialogUtils.dismissDialog(this, H);
            } else
            if (i1 == 165 || i1 == 164)
            {
                String s2;
                if (intent != null && intent.hasExtra("errorMessage"))
                {
                    s2 = intent.getStringExtra("errorMessage");
                } else
                {
                    s2 = getString(0x7f0805cb);
                }
                Utils.c(this, s2);
            }
        } else
        if (j1 == 4540)
        {
            aa = true;
            g();
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (R != null)
        {
            R.dismiss();
        }
        v.post(new Runnable() {

            private ProfileActivity a;

            public final void run()
            {
                com.picsart.studio.profile.ProfileActivity.f(a);
            }

            
            {
                a = ProfileActivity.this;
                super();
            }
        });
        if (L != null)
        {
            L.a = o;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        Intent intent;
        super.onCreate(bundle);
        setContentView(0x7f030026);
        ag = false;
        setTitle(null);
        H = new g(this);
        H.setMessage(getString(0x7f08043d));
        H.setCancelable(true);
        af = new com.picsart.studio.d(getApplicationContext());
        J = new a(this);
        intent = getIntent();
        if (intent == null || !intent.hasExtra("profileTab")) goto _L2; else goto _L1
_L1:
        String s1 = intent.getStringExtra("profileTab");
        if (s1 == null) goto _L4; else goto _L3
_L3:
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 4: default 164
    //                   -1077769258: 880
    //                   -989034367: 864
    //                   765912085: 912
    //                   765915793: 896;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        byte0;
        JVM INSTR tableswitch 0 3: default 196
    //                   0 928
    //                   1 936
    //                   2 944
    //                   3 952;
           goto _L4 _L10 _L11 _L12 _L13
_L4:
        intent.removeExtra("profileTab");
_L2:
        p = (Toolbar)findViewById(0x7f10017b);
        p.setBackgroundColor(0);
        Y = 0;
        setSupportActionBar(p);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowHomeEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayUseLogoEnabled(false);
        K = (NavigationFragment)getFragmentManager().findFragmentById(0x7f100180);
        K.a(12);
        q = (DrawerLayout)findViewById(0x7f100167);
        q.setScrollBarStyle(0x2000000);
        q.setDrawerListener(new android.support.v4.widget.DrawerLayout.DrawerListener() {

            private ProfileActivity a;

            public final void onDrawerClosed(View view)
            {
                com.picsart.studio.profile.ProfileActivity.g(a);
            }

            public final void onDrawerOpened(View view)
            {
            }

            public final void onDrawerSlide(View view, float f1)
            {
                com.picsart.studio.profile.ProfileActivity.a(a, f1);
            }

            public final void onDrawerStateChanged(int i1)
            {
            }

            
            {
                a = ProfileActivity.this;
                super();
            }
        });
        B = findViewById(0x7f100181);
        if (B == null)
        {
            B = findViewById(0x7f100168);
            ac = true;
        } else
        {
            ac = false;
        }
        s = findViewById(0x7f10017a);
        C = findViewById(0x7f10017f);
        D = findViewById(0x7f10017e);
        E = findViewById(0x7f10016a);
        F = findViewById(0x7f10016c);
        r = findViewById(0x7f10016f);
        t = (TextView)findViewById(0x7f100173);
        u = (TextView)findViewById(0x7f100170);
        v = (TextView)findViewById(0x7f100172);
        w = (TextView)findViewById(0x7f10017c);
        I = (ViewPager)findViewById(0x7f100169);
        G = (SlidingTabLayout)findViewById(0x7f100179);
        x = findViewById(0x7f100175);
        y = (ImageView)findViewById(0x7f100176);
        A = (ImageView)findViewById(0x7f10016b);
        z = (ImageView)findViewById(0x7f100171);
        e = (CheckBox)findViewById(0x7f100177);
        e();
        if (bundle != null)
        {
            d = (ViewerUser)bundle.getParcelable("key.user");
            if (bundle.containsKey("imgaeType"))
            {
                T = bundle.getString("imgaeType");
            }
            if (bundle.containsKey("activeTab"))
            {
                ai = bundle.getInt("activeTab");
            }
        }
        if (a(d))
        {
            f();
        } else
        {
            bundle = getIntent().getExtras();
            if (bundle != null)
            {
                ViewerUser vieweruser = (ViewerUser)bundle.getParcelable("profileUser");
                if (vieweruser != null && vieweruser.id == SocialinV3.getInstance().getUser().id)
                {
                    d = SocialinV3.getInstance().getUser();
                    f();
                    i();
                } else
                {
                    long l1 = bundle.getLong("profileUserId", -1L);
                    bundle = bundle.getString("profileUserName");
                    j.setRequestCompleteListener(new com.socialin.asyncnet.d() {

                        private ProfileActivity a;

                        public final volatile void onCancelRequest(Object obj, Request request)
                        {
                        }

                        public final void onFailure(Exception exception, Request request)
                        {
                            com.picsart.studio.profile.ProfileActivity.l(a);
                        }

                        public final transient void onProgressUpdate(Integer ainteger[])
                        {
                        }

                        public final void onSuccess(Object obj, Request request)
                        {
                            obj = (ViewerUser)obj;
                            com.picsart.studio.profile.ProfileActivity.b(a, ((ViewerUser) (obj)));
                        }

            
            {
                a = ProfileActivity.this;
                super();
            }
                    });
                    if (com.socialin.android.util.s.a(this))
                    {
                        c.userId = l1;
                        c.username = bundle;
                        j.doRequest(f, c);
                    }
                }
            }
        }
        N = getSharedPreferences((new StringBuilder("sinPref_")).append(getResources().getString(0x7f0808b0)).toString(), 0);
        getWindow().setSoftInputMode(3);
        m.setRequestCompleteListener(new com.picsart.studio.profile.a(this, (byte)0));
        X = 0;
        if (d())
        {
            i = new BroadcastReceiver() {

                private ProfileActivity a;

                public final void onReceive(Context context, Intent intent1)
                {
                    if (com.picsart.studio.profile.ProfileActivity.c(a) == null) goto _L2; else goto _L1
_L1:
                    byte byte1;
                    context = intent1.getAction();
                    byte1 = -1;
                    context.hashCode();
                    JVM INSTR lookupswitch 5: default 72
                //                               -1555240915: 116
                //                               -842164364: 144
                //                               -643138436: 158
                //                               -337176445: 130
                //                               1200538861: 172;
                       goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
                    byte1;
                    JVM INSTR tableswitch 0 4: default 108
                //                               0 186
                //                               1 226
                //                               2 279
                //                               3 337
                //                               4 358;
                       goto _L9 _L10 _L11 _L12 _L13 _L14
_L9:
                    a.b();
_L2:
                    return;
_L4:
                    if (context.equals("com.picsart.studio.action.follow_from_followers"))
                    {
                        byte1 = 0;
                    }
                      goto _L3
_L7:
                    if (context.equals("com.picsart.studio.action.unfollow_from_followings"))
                    {
                        byte1 = 1;
                    }
                      goto _L3
_L5:
                    if (context.equals("com.picsart.studio.action.unfollow_from_followers"))
                    {
                        byte1 = 2;
                    }
                      goto _L3
_L6:
                    if (context.equals("com.picsart.studio.action.update.tabs.create.membox"))
                    {
                        byte1 = 3;
                    }
                      goto _L3
_L8:
                    if (context.equals("com.picsart.studio.action.update.tabs.delete.membox"))
                    {
                        byte1 = 4;
                    }
                      goto _L3
_L10:
                    context = com.picsart.studio.profile.ProfileActivity.d(a);
                    if (context != null)
                    {
                        context.a(true, false, false);
                    }
                    context = com.picsart.studio.profile.ProfileActivity.c(a);
                    context.followingsCount = ((ViewerUser) (context)).followingsCount + 1;
                      goto _L9
_L11:
                    context = com.picsart.studio.profile.ProfileActivity.e(a);
                    if (context != null)
                    {
                        context.a(true, false, false);
                    }
                    if (com.picsart.studio.profile.ProfileActivity.c(a).followingsCount > 0)
                    {
                        context = com.picsart.studio.profile.ProfileActivity.c(a);
                        context.followingsCount = ((ViewerUser) (context)).followingsCount - 1;
                    }
                      goto _L9
_L12:
                    context = intent1.getStringExtra("com.picsart.studio.action.update.username");
                    intent1 = com.picsart.studio.profile.ProfileActivity.d(a);
                    if (intent1 != null)
                    {
                        intent1.b(context);
                    }
                    if (com.picsart.studio.profile.ProfileActivity.c(a).followingsCount > 0)
                    {
                        context = com.picsart.studio.profile.ProfileActivity.c(a);
                        context.followingsCount = ((ViewerUser) (context)).followingsCount - 1;
                    }
                      goto _L9
_L13:
                    context = com.picsart.studio.profile.ProfileActivity.c(a);
                    context.streamsCount = ((ViewerUser) (context)).streamsCount + 1;
                      goto _L9
_L14:
                    if (com.picsart.studio.profile.ProfileActivity.c(a).streamsCount > 0)
                    {
                        context = com.picsart.studio.profile.ProfileActivity.c(a);
                        context.streamsCount = ((ViewerUser) (context)).streamsCount - 1;
                    }
                      goto _L9
                }

            
            {
                a = ProfileActivity.this;
                super();
            }
            };
            bundle = new IntentFilter();
            bundle.addAction("com.picsart.studio.action.follow_from_followers");
            bundle.addAction("com.picsart.studio.action.unfollow_from_followers");
            bundle.addAction("com.picsart.studio.action.unfollow_from_followings");
            bundle.addAction("com.picsart.studio.action.update.tabs.create.membox");
            bundle.addAction("com.picsart.studio.action.update.tabs.delete.membox");
            registerReceiver(i, bundle);
        }
        try
        {
            L = (bv)getFragmentManager().findFragmentByTag("editStatusFragment");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            com.socialin.android.d.a("ContestRateActivity", bundle);
        }
        if (L != null && L.isAdded())
        {
            L.a = o;
        }
        bundle = getFragmentManager().findFragmentByTag("blockConfirmDialog");
        if (bundle != null)
        {
            ((com.socialin.android.dialog.a)bundle).e = new android.view.View.OnClickListener() {

                private ProfileActivity a;

                public final void onClick(View view)
                {
                    com.picsart.studio.profile.ProfileActivity.b(a);
                }

            
            {
                a = ProfileActivity.this;
                super();
            }
            };
        }
        return;
_L7:
        if (s1.equals("photos"))
        {
            byte0 = 0;
        }
          goto _L5
_L6:
        if (s1.equals("membox"))
        {
            byte0 = 1;
        }
          goto _L5
_L9:
        if (s1.equals("following"))
        {
            byte0 = 2;
        }
          goto _L5
_L8:
        if (s1.equals("followers"))
        {
            byte0 = 3;
        }
          goto _L5
_L10:
        ai = 0;
          goto _L4
_L11:
        ai = 3;
          goto _L4
_L12:
        ai = 2;
          goto _L4
_L13:
        ai = 1;
          goto _L4
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        a(menu);
        return true;
    }

    public void onDestroy()
    {
        super.onDestroy();
        try
        {
            if (aa)
            {
                SocialinV3.getInstance().writeUser();
                getIntent().putExtra("dataChanged", aa);
            }
        }
        catch (Exception exception)
        {
            com.socialin.android.d.a(exception.getMessage(), exception);
        }
        ag = true;
        if (i != null)
        {
            unregisterReceiver(i);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i1 = menuitem.getItemId();
        if (i1 != 0x102002c) goto _L2; else goto _L1
_L1:
        finish();
_L4:
        return true;
_L2:
        if (i1 != 0x7f100aef)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!isFinishing())
        {
            menuitem = getFragmentManager().beginTransaction();
            com.socialin.android.dialog.b b1;
            if (d.isBlocked)
            {
                i1 = 0x7f08064d;
            } else
            {
                i1 = 0x7f08005c;
            }
            b1 = (new com.socialin.android.dialog.b()).a(1, 0x7f0c0181);
            b1.b = getString(i1);
            ae = b1.a(new android.view.View.OnClickListener() {

                private ProfileActivity a;

                public final void onClick(View view)
                {
                    ProfileActivity.u(a).dismiss();
                    com.picsart.studio.profile.ProfileActivity.b(a);
                }

            
            {
                a = ProfileActivity.this;
                super();
            }
            }).b(new android.view.View.OnClickListener() {

                private ProfileActivity a;

                public final void onClick(View view)
                {
                    ProfileActivity.u(a).dismiss();
                }

            
            {
                a = ProfileActivity.this;
                super();
            }
            }).a();
            ae.show(menuitem, "blockConfirmDialog");
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i1 == 0x7f100af0)
        {
            menuitem = new Intent();
            menuitem.setClassName(this, "com.socialin.android.preference.ContentPreferencesActivity");
            startActivityForResult(menuitem, 2);
            return true;
        }
        if (i1 == 0x7f100ae5)
        {
            menuitem = new Intent();
            menuitem.setClass(this, com/socialin/android/picsart/profile/activity/ProfileSettingsActivity);
            menuitem.setFlags(0x20000);
            startActivityForResult(menuitem, 3);
            return true;
        }
        if (i1 != 0x7f100aed && i1 != 0x7f100af1)
        {
            continue; /* Loop/switch isn't completed */
        }
        menuitem = d;
        if (menuitem == null) goto _L4; else goto _L5
_L5:
        ((ClipboardManager)getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("userlink", (new StringBuilder("http://")).append(((ViewerUser) (menuitem)).username).append(".picsart.com").toString()));
        Utils.c(this, getString(0x7f0802aa));
        return true;
        if (i1 != 0x7f100aee || isFinishing()) goto _L4; else goto _L6
_L6:
        menuitem = getFragmentManager().beginTransaction();
        Object obj = getFragmentManager().findFragmentByTag("fragmentDialogLogout");
        if (obj != null)
        {
            menuitem.remove(((Fragment) (obj)));
        }
        obj = (new com.socialin.android.dialog.b()).a(1, 0x7f0c0190);
        obj.b = getResources().getString(0x7f0802fa);
        ((com.socialin.android.dialog.b) (obj)).a(new android.view.View.OnClickListener() {

            private ProfileActivity a;

            public final void onClick(View view)
            {
                ProfileActivity.t(a);
            }

            
            {
                a = ProfileActivity.this;
                super();
            }
        }).a().show(menuitem, "fragmentDialogLogout");
        return true;
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        if (K != null && !d())
        {
            K.a(-1);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.clear();
        a(menu);
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        v.post(new Runnable() {

            private ProfileActivity a;

            public final void run()
            {
                com.picsart.studio.profile.ProfileActivity.f(a);
            }

            
            {
                a = ProfileActivity.this;
                super();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putString("imgaeType", T);
        bundle1.putInt("activieTab", ai);
        bundle1.putParcelable("key.user", d);
        super.onSaveInstanceState(bundle1);
    }


    /* member class not found */
    class _cls27 {}


    /* member class not found */
    class _cls28 {}

}
