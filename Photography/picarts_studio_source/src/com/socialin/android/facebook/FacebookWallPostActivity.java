// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.engine.l;
import com.facebook.AccessToken;
import com.facebook.GraphResponse;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.studio.utils.c;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.AddPhotoController;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.request.UploadParams;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.constants.b;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.ab;
import com.socialin.android.util.e;
import com.socialin.android.util.f;
import com.socialin.android.util.s;
import com.socialin.asyncnet.Request;
import io.branch.referral.m;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook:
//            g, l

public class FacebookWallPostActivity extends BaseActivity
    implements CommonConstants, b
{

    private static final String g = (new StringBuilder()).append(com/socialin/android/facebook/FacebookWallPostActivity.getSimpleName()).append(" - ").toString();
    private static final String h = (new StringBuilder()).append(com/socialin/android/facebook/FacebookWallPostActivity.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
    private boolean A;
    private boolean B;
    private g C;
    private com.facebook.GraphRequest.Callback D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private Adress J;
    List f;
    private AddPhotoController i;
    private UploadParams j;
    private boolean k;
    private FacebookWallPostActivity l;
    private EditText m;
    private ImageView n;
    private ImageView o;
    private TextView p;
    private ImageItem q;
    private long r;
    private String s;
    private int t;
    private int u;
    private String v;
    private String w;
    private String x;
    private View y;
    private CheckBox z;

    public FacebookWallPostActivity()
    {
        i = new AddPhotoController();
        j = new UploadParams();
        f = new ArrayList();
        k = false;
        l = this;
        m = null;
        r = -1L;
        s = "";
        v = "";
        w = "";
        x = null;
        A = false;
        B = false;
        C = null;
        D = new com.facebook.GraphRequest.Callback() {

            private FacebookWallPostActivity a;

            public final void onCompleted(GraphResponse graphresponse)
            {
                if (!FacebookWallPostActivity.a(a).isFinishing()) goto _L2; else goto _L1
_L1:
                return;
_L2:
                FacebookUtils.dismissDialog(FacebookWallPostActivity.a(a));
                DialogUtils.dismissDialog(FacebookWallPostActivity.a(a), com.socialin.android.facebook.FacebookWallPostActivity.b(a));
                if (graphresponse == null) goto _L1; else goto _L3
_L3:
                Object obj;
                obj = graphresponse.getJSONObject();
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_87;
                }
                obj = ((JSONObject) (obj)).optString("id");
_L4:
                graphresponse = graphresponse.getError();
                if (graphresponse != null)
                {
                    FacebookUtils.evaluateFacebookErrorResponse(FacebookWallPostActivity.a(a), graphresponse);
                    return;
                } else
                {
                    FacebookWallPostActivity.a(a, null, ((String) (obj)));
                    return;
                }
                obj;
                ((Exception) (obj)).printStackTrace();
                obj = null;
                  goto _L4
            }

            
            {
                a = FacebookWallPostActivity.this;
                super();
            }
        };
        F = null;
        G = null;
    }

    static int a(FacebookWallPostActivity facebookwallpostactivity, int i1)
    {
        facebookwallpostactivity.t = i1;
        return i1;
    }

    static long a(FacebookWallPostActivity facebookwallpostactivity, long l1)
    {
        facebookwallpostactivity.r = l1;
        return l1;
    }

    static ImageItem a(FacebookWallPostActivity facebookwallpostactivity, ImageItem imageitem)
    {
        facebookwallpostactivity.q = imageitem;
        return imageitem;
    }

    static FacebookWallPostActivity a(FacebookWallPostActivity facebookwallpostactivity)
    {
        return facebookwallpostactivity.l;
    }

    static String a()
    {
        return h;
    }

    static String a(FacebookWallPostActivity facebookwallpostactivity, String s1)
    {
        facebookwallpostactivity.s = s1;
        return s1;
    }

    static void a(FacebookWallPostActivity facebookwallpostactivity, Request request)
    {
        com.socialin.asyncnet.b.a().a(request, facebookwallpostactivity. new com.socialin.asyncnet.d() {

            private FacebookWallPostActivity a;

            public final volatile void onCancelRequest(Object obj, Request request1)
            {
            }

            public final void onFailure(Exception exception, Request request1)
            {
                FacebookWallPostActivity.a(a, exception.getMessage(), null);
            }

            public final transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public final void onSuccess(Object obj, Request request1)
            {
                String s1;
                String s2;
                Object obj1;
                Object obj2;
                obj2 = (String)obj;
                s1 = a.getString(0x7f0805ca);
                obj1 = null;
                s2 = obj1;
                request1 = s1;
                if (TextUtils.isEmpty(((CharSequence) (obj2))))
                {
                    break MISSING_BLOCK_LABEL_78;
                }
                obj = s1;
                obj2 = new JSONObject(((String) (obj2)));
                s2 = obj1;
                request1 = s1;
                obj = s1;
                if (((JSONObject) (obj2)).has("id"))
                {
                    request1 = "";
                    obj = request1;
                    try
                    {
                        s2 = ((JSONObject) (obj2)).getString("id");
                    }
                    // Misplaced declaration of an exception variable
                    catch (Request request1)
                    {
                        request1.printStackTrace();
                        s2 = obj1;
                        request1 = ((Request) (obj));
                    }
                }
                FacebookWallPostActivity.a(a, request1, s2);
                return;
            }

            
            {
                a = FacebookWallPostActivity.this;
                super();
            }
        });
    }

    static void a(FacebookWallPostActivity facebookwallpostactivity, String s1, String s2)
    {
        if (!TextUtils.isEmpty(s1))
        {
            if (s1.contains("User not visible"))
            {
                facebookwallpostactivity.a(facebookwallpostactivity.getString(0x7f08027d));
                return;
            } else
            {
                facebookwallpostactivity.a(((String) (null)));
                return;
            }
        }
        if (s2 != null)
        {
            com.socialin.android.d.b(g, new Object[] {
                (new StringBuilder("wall post is success : postId = ")).append(s2).toString()
            });
            if (Inventory.isAdsEnabled())
            {
                ab.a(facebookwallpostactivity, 5);
            }
            Utils.c(facebookwallpostactivity, facebookwallpostactivity.getString(0x7f08027c));
            FacebookUtils.dismissDialog(facebookwallpostactivity);
            facebookwallpostactivity.setResult(-1);
            facebookwallpostactivity.finish();
            return;
        } else
        {
            facebookwallpostactivity.a(((String) (null)));
            return;
        }
    }

    static void a(FacebookWallPostActivity facebookwallpostactivity, String s1, String s2, Boolean boolean1)
    {
        facebookwallpostactivity.a(s1, s2, boolean1);
    }

    static void a(FacebookWallPostActivity facebookwallpostactivity, String s1, String s2, String s3)
    {
        if (facebookwallpostactivity.s != null)
        {
            String s4 = (new StringBuilder()).append(facebookwallpostactivity.s).append("\n").append(s2).toString();
            s2 = s4;
            if (420 - s4.length() <= 0)
            {
                s2 = s4.substring(0, 420);
            }
        }
        facebookwallpostactivity.runOnUiThread(facebookwallpostactivity. new Runnable(s3, s1, s2) {

            private String a;
            private String b;
            private String c;
            private FacebookWallPostActivity d;

            public final void run()
            {
                if (!TextUtils.isEmpty(FacebookWallPostActivity.j(d)))
                {
                    Request request = new Request((new StringBuilder("https://graph.facebook.com/v2.4/")).append(FacebookWallPostActivity.j(d)).append("/feed").toString(), null, "POST");
                    request.b("name", a);
                    request.b("link", b);
                    request.b("access_token", FacebookWallPostActivity.k(d));
                    request.b("message", c);
                    FacebookWallPostActivity.a(d, request);
                }
            }

            
            {
                d = FacebookWallPostActivity.this;
                a = s1;
                b = s2;
                c = s3;
                super();
            }
        });
    }

    static void a(FacebookWallPostActivity facebookwallpostactivity, String s1, String s2, String s3, String s4, boolean flag)
    {
        if (!TextUtils.isEmpty(facebookwallpostactivity.s))
        {
            s3 = (new StringBuilder()).append(facebookwallpostactivity.s).append("\n").append(s3).toString();
        }
        if (flag)
        {
            FacebookUtils.postStoryAddPhoto(s1, s2, s3, facebookwallpostactivity.d(), facebookwallpostactivity.t, facebookwallpostactivity.u, facebookwallpostactivity.I, facebookwallpostactivity.D);
            return;
        } else
        {
            FacebookUtils.postStorySharePhoto(facebookwallpostactivity.w, s1, s2, s3, facebookwallpostactivity.d(), s4, facebookwallpostactivity.t, facebookwallpostactivity.u, facebookwallpostactivity.r, null, facebookwallpostactivity.D);
            return;
        }
    }

    private void a(String s1)
    {
        DialogUtils.dismissDialog(this, C);
        Intent intent = getIntent();
        if (!TextUtils.isEmpty(s1))
        {
            intent.putExtra("errorMessage", s1);
        }
        setResult(0, intent);
        finish();
    }

    private void a(String s1, String s2, Boolean boolean1)
    {
        String s3;
        s3 = null;
        if (!com.socialin.android.util.s.a(this))
        {
            FacebookUtils.showNoNetworkDialog(this);
            setResult(1);
            finish();
            return;
        }
        if (!TextUtils.isEmpty(F) || !TextUtils.isEmpty(G))
        {
            String s4;
            if (s2 != null)
            {
                boolean1 = s2;
            } else
            {
                boolean1 = s1;
            }
            s2 = boolean1;
            if (s1 != null)
            {
                s2 = boolean1;
                if (s1.contains("fbstaging:"))
                {
                    s2 = "http://picsart.com";
                }
            }
            boolean1 = s2;
            if (!FacebookUtils.directToFbDomain(s2))
            {
                boolean1 = (new StringBuilder("http://picsart.com/i?og_image=")).append(s1).toString();
            }
            s4 = getString(0x7f08031f);
            s1 = s4;
            s2 = s3;
            if (q != null)
            {
                s1 = s4;
                s2 = s3;
                if (q.user != null)
                {
                    if (!TextUtils.isEmpty(q.title))
                    {
                        s1 = q.title;
                    } else
                    {
                        s1 = getString(0x7f08031f);
                    }
                    s2 = q.user.username;
                }
            }
            if (!TextUtils.isEmpty(s2))
            {
                s1 = (new StringBuilder("@")).append(s2).append("'s photo").toString();
            }
            myobfuscated.cy.d.a(this, "facebook", "photo_share_facebook", r, new io.branch.referral.g(boolean1, s1) {

                private String a;
                private String b;
                private FacebookWallPostActivity c;

                public final void a(String s5, m m1)
                {
                    s5 = FacebookUtils.createFacebookMessage(c, null, -1L, s5);
                    FacebookWallPostActivity.a(c, a, s5, b);
                }

            
            {
                c = FacebookWallPostActivity.this;
                a = s1;
                b = s2;
                super();
            }
            });
            return;
        }
        if (TextUtils.isEmpty(s2) && r > 0L)
        {
            s2 = (new StringBuilder("http://picsart.com/i/")).append(r).toString();
        }
        s3 = s2;
        if (s1 != null)
        {
            s3 = s2;
            if (s1.contains("fbstaging:"))
            {
                s3 = "http://picsart.com";
            }
        }
        if (TextUtils.isEmpty(s3))
        {
            s3 = "http://picsart.com/i";
        }
        s2 = boolean1;
        if (q == null) goto _L2; else goto _L1
_L1:
        s2 = boolean1;
        if (q.user == null) goto _L2; else goto _L3
_L3:
        boolean flag;
        if (q.user.id == SocialinV3.getInstance().getUser().id)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s2 = Boolean.valueOf(flag);
        boolean1 = URLEncoder.encode(q.user.username, e.a.name());
_L5:
        com.socialin.android.d.a(g, (new StringBuilder("isMyPhoto:   ")).append(s2).toString());
        flag = s2.booleanValue();
        myobfuscated.cy.d.a(this, "facebook", "photo_share_facebook", r, new io.branch.referral.g(s1, s3, boolean1, flag) {

            private String a;
            private String b;
            private String c;
            private boolean d;
            private FacebookWallPostActivity e;

            public final void a(String s5, m m1)
            {
                s5 = FacebookUtils.createFacebookMessage(e, FacebookWallPostActivity.h(e), FacebookWallPostActivity.i(e), s5);
                FacebookWallPostActivity.a(e, a, b, s5, c, d);
            }

            
            {
                e = FacebookWallPostActivity.this;
                a = s1;
                b = s2;
                c = s3;
                d = flag;
                super();
            }
        });
        return;
        boolean1;
        a(((String) (null)));
_L2:
        boolean1 = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    static int b(FacebookWallPostActivity facebookwallpostactivity, int i1)
    {
        facebookwallpostactivity.u = i1;
        return i1;
    }

    static g b(FacebookWallPostActivity facebookwallpostactivity)
    {
        return facebookwallpostactivity.C;
    }

    static String b()
    {
        return g;
    }

    private boolean b(String s1)
    {
        boolean flag1 = false;
        Object obj = getFragmentManager();
        s1 = ((FragmentManager) (obj)).findFragmentByTag(s1);
        boolean flag = flag1;
        if (s1 != null)
        {
            flag = flag1;
            if (s1.isAdded())
            {
                flag = flag1;
                if (!s1.isRemoving())
                {
                    obj = ((FragmentManager) (obj)).beginTransaction();
                    ((FragmentTransaction) (obj)).setCustomAnimations(0, 0x7f050003);
                    ((FragmentTransaction) (obj)).remove(s1);
                    ((FragmentTransaction) (obj)).commitAllowingStateLoss();
                    k = false;
                    flag = true;
                }
            }
        }
        return flag;
    }

    static EditText c(FacebookWallPostActivity facebookwallpostactivity)
    {
        return facebookwallpostactivity.m;
    }

    private void c()
    {
        if (SocialinV3.getInstance().getAppProps() == null)
        {
            Utils.c(this, getString(0x7f08024e));
            return;
        }
        Object obj;
        if (q != null)
        {
            obj = q.getLargeUrl();
        } else
        {
            obj = null;
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            a(((String) (obj)), (new StringBuilder("http://picsart.com/i/")).append(q.id).toString(), Boolean.valueOf(false));
            return;
        }
        File file = new File(v);
        obj = new android.graphics.BitmapFactory.Options();
        obj.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(v, ((android.graphics.BitmapFactory.Options) (obj)));
        t = ((android.graphics.BitmapFactory.Options) (obj)).outWidth;
        u = ((android.graphics.BitmapFactory.Options) (obj)).outHeight;
        Object obj1 = FacebookUtils.getMimeType(v);
        obj = obj1;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            if (B)
            {
                obj = "video/*";
            } else
            {
                obj = "image/jpg";
            }
        }
        obj1 = new Request("https://graph.facebook.com/v2.4/me/staging_resources", null, "POST");
        if (!B)
        {
            ((Request) (obj1)).a("access_token", AccessToken.getCurrentAccessToken().getToken());
            ((Request) (obj1)).a("file", file.getName(), ((String) (obj)), file);
            ((Request) (obj1)).a("type", ((String) (obj)));
        } else
        {
            ((Request) (obj1)).a("access_token", AccessToken.getCurrentAccessToken().getToken());
            ((Request) (obj1)).a("path", file.getAbsolutePath());
            ((Request) (obj1)).a("type", ((String) (obj)));
        }
        ((Request) (obj1)).c();
        com.socialin.asyncnet.b.a().a(((Request) (obj1)), new com.socialin.asyncnet.d() {

            private FacebookWallPostActivity a;

            public final volatile void onCancelRequest(Object obj2, Request request)
            {
            }

            public final void onFailure(Exception exception, Request request)
            {
                exception.printStackTrace();
                DialogUtils.dismissDialog(FacebookWallPostActivity.a(a), com.socialin.android.facebook.FacebookWallPostActivity.b(a));
                FacebookUtils.dismissDialog(FacebookWallPostActivity.a(a));
                Utils.c(FacebookWallPostActivity.a(a), exception.getLocalizedMessage());
            }

            public final transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public final void onSuccess(Object obj2, Request request)
            {
                String s1 = (String)obj2;
                request = "";
                obj2 = request;
                if (!TextUtils.isEmpty(s1))
                {
                    try
                    {
                        obj2 = (new JSONObject(s1)).optString("uri");
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj2)
                    {
                        ((Exception) (obj2)).printStackTrace();
                        obj2 = request;
                    }
                }
                if (!TextUtils.isEmpty(((CharSequence) (obj2))))
                {
                    com.socialin.android.d.b(com.socialin.android.facebook.FacebookWallPostActivity.b(), new Object[] {
                        (new StringBuilder("postToWall: imageUrl=  ")).append(((String) (obj2))).toString()
                    });
                    FacebookWallPostActivity.a(a, ((String) (obj2)), null, Boolean.valueOf(true));
                    return;
                } else
                {
                    DialogUtils.dismissDialog(FacebookWallPostActivity.a(a), com.socialin.android.facebook.FacebookWallPostActivity.b(a));
                    FacebookUtils.dismissDialog(FacebookWallPostActivity.a(a));
                    return;
                }
            }

            
            {
                a = FacebookWallPostActivity.this;
                super();
            }
        });
    }

    private String d()
    {
        String s1 = "";
        String s2 = s1;
        if (!f.isEmpty())
        {
            int j1 = f.size();
            int i1 = 0;
            do
            {
                s2 = s1;
                if (i1 >= j1)
                {
                    break;
                }
                s2 = (new StringBuilder()).append(s1).append(((com.socialin.android.facebook.g)f.get(i1)).getId()).toString();
                s1 = s2;
                if (i1 < j1 - 1)
                {
                    s1 = (new StringBuilder()).append(s2).append(",").toString();
                }
                i1++;
            } while (true);
        }
        return s2;
    }

    static boolean d(FacebookWallPostActivity facebookwallpostactivity)
    {
        facebookwallpostactivity.k = true;
        return true;
    }

    static CheckBox e(FacebookWallPostActivity facebookwallpostactivity)
    {
        return facebookwallpostactivity.z;
    }

    static void f(FacebookWallPostActivity facebookwallpostactivity)
    {
        facebookwallpostactivity.c();
    }

    static View g(FacebookWallPostActivity facebookwallpostactivity)
    {
        return facebookwallpostactivity.y;
    }

    static ImageItem h(FacebookWallPostActivity facebookwallpostactivity)
    {
        return facebookwallpostactivity.q;
    }

    static long i(FacebookWallPostActivity facebookwallpostactivity)
    {
        return facebookwallpostactivity.r;
    }

    static String j(FacebookWallPostActivity facebookwallpostactivity)
    {
        return facebookwallpostactivity.G;
    }

    static String k(FacebookWallPostActivity facebookwallpostactivity)
    {
        return facebookwallpostactivity.H;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 != -1 || intent == null || intent.getExtras() == null) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 167 168: default 48
    //                   167 49
    //                   168 81;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        J = com.picsart.studio.utils.c.a(intent, this);
        if (J != null)
        {
            intent = J.place;
            throw new NullPointerException();
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        if (intent != null && intent.hasExtra("venue_Id"))
        {
            I = intent.getExtras().getString("venue_Id");
        }
        if (intent.hasExtra("text"))
        {
            intent = intent.getExtras().getString("text");
            if (J == null)
            {
                J = new Adress();
            }
            J.place = intent;
            if (!TextUtils.isEmpty(intent))
            {
                throw new NullPointerException();
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300fa);
        bundle = getSupportActionBar();
        bundle.setIcon(0x7f020362);
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setDisplayShowHomeEnabled(true);
        bundle.setIcon(getResources().getDrawable(0x7f020362));
        bundle.setTitle(getResources().getString(0x7f0802c7));
        bundle = getIntent();
        int i1;
        if (bundle.hasExtra("path"))
        {
            v = bundle.getStringExtra("path");
            if (d.b)
            {
                com.socialin.android.d.b(g, new Object[] {
                    (new StringBuilder("onCreate() - UploadedImagePath: ")).append(v).toString()
                });
            }
        } else
        {
            setResult(0);
            finish();
        }
        if (bundle.hasExtra("postMessage"))
        {
            s = bundle.getStringExtra("postMessage");
            com.socialin.android.d.b(g, new Object[] {
                (new StringBuilder("onCreate() - postMessage: ")).append(s).toString()
            });
            if (s == null || s.equals("null"))
            {
                s = "";
            }
        }
        if (bundle.hasExtra("item"))
        {
            try
            {
                q = (ImageItem)bundle.getParcelableExtra("item");
                if (q != null)
                {
                    r = q.id;
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        if (bundle.hasExtra("freeToEdit"))
        {
            A = bundle.getBooleanExtra("freeToEdit", false);
        }
        if (q == null && bundle.hasExtra("item_id"))
        {
            r = bundle.getLongExtra("item_id", -1L);
        }
        if (F == null && bundle.hasExtra("fbGroupId"))
        {
            F = bundle.getStringExtra("fbGroupId");
        }
        if (E == null && bundle.hasExtra("fbGroupName"))
        {
            E = bundle.getStringExtra("fbGroupName");
        }
        if (G == null && bundle.hasExtra("fbPageId"))
        {
            G = bundle.getStringExtra("fbPageId");
            if (bundle.hasExtra("access_token"))
            {
                H = bundle.getStringExtra("access_token");
            }
        }
        if (E == null && bundle.hasExtra("fbPageId"))
        {
            E = bundle.getStringExtra("fbPageName");
        }
        if (bundle.hasExtra("videoPost"))
        {
            B = bundle.getExtras().getBoolean("videoPost");
        }
        C = new g(this);
        C.setCancelable(true);
        bundle = FacebookUtils.getUserData();
        if (bundle != null)
        {
            x = ((com.socialin.android.facebook.l) (bundle)).a;
            if (TextUtils.isEmpty(E))
            {
                E = ((com.socialin.android.facebook.l) (bundle)).d;
            }
        }
        ((FrameLayout)findViewById(0x7f10050a)).setVisibility(8);
        y = findViewById(0x7f100512);
        z = (CheckBox)findViewById(0x7f100514);
        if (q != null && q.user != null && q.user.id == SocialinV3.getInstance().getUser().id)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (A && i1 == 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            bundle = findViewById(0x7f100516);
            boolean flag = SocialinV3.getInstance().getSettings().isMatureContentEnabled();
            y.setVisibility(0);
            if (TextUtils.isEmpty(F) && TextUtils.isEmpty(G) || q != null)
            {
                y.setOnClickListener(new android.view.View.OnClickListener(bundle, flag) {

                    private View a;
                    private boolean b;
                    private FacebookWallPostActivity c;

                    public final void onClick(View view)
                    {
                        int j1 = 0;
                        boolean flag2 = com.socialin.android.facebook.FacebookWallPostActivity.e(c).isChecked();
                        view = com.socialin.android.facebook.FacebookWallPostActivity.e(c);
                        boolean flag1;
                        if (!flag2)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        view.setChecked(flag1);
                        view = a;
                        if (!b || flag2)
                        {
                            j1 = 8;
                        }
                        view.setVisibility(j1);
                    }

            
            {
                c = FacebookWallPostActivity.this;
                a = view;
                b = flag;
                super();
            }
                });
                z.setChecked(SocialinV3.getInstance().isRegistered());
                if (flag && z.isChecked())
                {
                    i1 = 0;
                } else
                {
                    i1 = 8;
                }
                bundle.setVisibility(i1);
            } else
            {
                z.setChecked(true);
                z.setVisibility(0);
            }
        } else
        {
            y.setVisibility(8);
            z.setChecked(false);
        }
        p = (TextView)findViewById(0x7f100509);
        p.setText(E);
        o = (ImageView)findViewById(0x7f100508);
        bundle = (com.bumptech.glide.request.e)((com.bumptech.glide.request.e)com.bumptech.glide.request.e.b(l.e).a(0x7f020669)).b(0x7f020669);
        (new f(getApplicationContext())).a((new StringBuilder("https://graph.facebook.com/v2.4/")).append(x).append("/picture?type=normal").toString(), o, bundle, null);
        m = (EditText)findViewById(0x7f10050d);
        bundle = m;
        bundle.setOnTouchListener(new android.view.View.OnTouchListener(bundle) {

            private View a;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                if (view.getId() == a.getId())
                {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if ((motionevent.getAction() & 0xff) == 1)
                    {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }

            
            {
                a = view;
                super();
            }
        });
        m.addTextChangedListener(new TextWatcher() {

            private FacebookWallPostActivity a;

            public final void afterTextChanged(Editable editable)
            {
                FacebookWallPostActivity.a(a, com.socialin.android.facebook.FacebookWallPostActivity.c(a).getText().toString());
            }

            public final void beforeTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
            }

            public final void onTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
            }

            
            {
                a = FacebookWallPostActivity.this;
                super();
            }
        });
        if (s != null)
        {
            m.setText(s);
            m.setSelection(m.length());
        }
        n = (ImageView)findViewById(0x7f100507);
        if (SocialinV3.getInstance().getSettings().isMatureContentEnabled())
        {
            findViewById(0x7f100516).setVisibility(0);
            findViewById(0x7f100518).setOnClickListener(new android.view.View.OnClickListener() {

                private FacebookWallPostActivity a;

                public final void onClick(View view)
                {
                    DialogUtils.openInfoDialog(0x7f020392, a.getResources().getString(0x7f080417), "", a.getResources().getString(0x7f080418), FacebookWallPostActivity.a(a), Integer.valueOf(0));
                }

            
            {
                a = FacebookWallPostActivity.this;
                super();
            }
            });
        }
        bundle = findViewById(0x7f10050e);
        if (!TextUtils.isEmpty(F) || !TextUtils.isEmpty(G))
        {
            bundle.setVisibility(8);
        } else
        {
            bundle.setVisibility(0);
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final FacebookWallPostActivity a;

                public final void onClick(View view)
                {
                /* block-local class not found */
                class _cls1 {}

                    FacebookUtils.approveFriendInfoAction(FacebookWallPostActivity.a(a), com.facebook.CallbackManager.Factory.create(), new _cls1());
                }

            
            {
                a = FacebookWallPostActivity.this;
                super();
            }
            });
        }
        if (v == null)
        {
            Utils.b(self, 0x7f08024e);
            finish();
            return;
        } else
        {
            (new com.picsart.studio.d(getApplicationContext())).a((new StringBuilder("file:///")).append(v).toString(), n, com.bumptech.glide.request.e.b(l.e));
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 1, 0, 0x7f080367).setIcon(0x7f020341).setShowAsAction(2);
        return true;
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && b(h))
        {
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i1 = 0;
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 36
    //                   1: 38
    //                   16908332: 455;
           goto _L1 _L2 _L3
_L1:
        return true;
_L2:
        if (k)
        {
            b(h);
            TextView textview = (TextView)findViewById(0x7f100510);
            menuitem = "";
            for (i1 = 0; i1 < f.size();)
            {
                Object obj = menuitem;
                if (i1 < 4)
                {
                    obj = (new StringBuilder()).append(menuitem).append(((com.socialin.android.facebook.g)f.get(i1)).getTitle()).append(", ").toString();
                }
                i1++;
                menuitem = ((MenuItem) (obj));
            }

            textview.setText(menuitem);
            return true;
        }
        if (!isFinishing())
        {
            if (!com.socialin.android.util.s.a(this))
            {
                FacebookUtils.showNoNetworkDialog(this);
                setResult(1);
                finish();
                return true;
            }
            if (z.isChecked())
            {
                if (!SocialinV3.getInstance().isRegistered())
                {
                    menuitem = getIntent();
                    menuitem.addCategory("android.intent.category.DEFAULT");
                    menuitem.setClassName(getPackageName(), "com.socialin.android.picsart.profile.activity.LoginFragmentActivity");
                    menuitem.putExtra("from", com/socialin/android/facebook/FacebookWallPostActivity.getName());
                    menuitem.putExtra("fbToken", SocialinV3.getInstance().getUserFbToken());
                    menuitem.putExtra("fbAppId", w);
                    menuitem.putExtra("fbAppName", getString(0x7f0808af));
                    startActivityForResult(menuitem, 59);
                    return true;
                }
                DialogUtils.showDialog(this, C);
                j.apiKey = SocialinApiV3.getInstance().getApiKey();
                j.title = s;
                j.desc = "";
                j.tags = "";
                menuitem = j;
                if (((CheckBox)findViewById(0x7f100517)).isChecked())
                {
                    i1 = 1;
                }
                menuitem.isMature = i1;
                j.isPublic = 1;
                j.location = J;
                j.imagePath = v;
                i.setRequestParams(j);
                i.setRequestCompleteListener(new com.socialin.asyncnet.d() {

                    private FacebookWallPostActivity a;

                    public final volatile void onCancelRequest(Object obj1, Request request)
                    {
                    }

                    public final void onFailure(Exception exception, Request request)
                    {
                        Utils.a(FacebookWallPostActivity.a(a), "Post to Picsart Failed", 1);
                        request = com.socialin.android.facebook.FacebookWallPostActivity.b();
                        if (exception.getLocalizedMessage() != null)
                        {
                            exception = exception.getLocalizedMessage();
                        } else
                        {
                            exception = " FbWallPost PicsArt upload -onFailure !!!";
                        }
                        com.socialin.android.d.c(new Object[] {
                            request, exception
                        });
                        com.socialin.android.facebook.FacebookWallPostActivity.f(a);
                    }

                    public final transient void onProgressUpdate(Integer ainteger[])
                    {
                    }

                    public final void onSuccess(Object obj1, Request request)
                    {
                        request = (ImageItem)obj1;
                        FacebookWallPostActivity.a(a, request);
                        long l1;
                        if (request != null)
                        {
                            l1 = ((ImageItem) (request)).id;
                        } else
                        {
                            l1 = -1L;
                        }
                        if (l1 < 0L)
                        {
                            com.socialin.android.facebook.FacebookWallPostActivity.f(a);
                            return;
                        }
                        if (com.socialin.android.facebook.FacebookWallPostActivity.g(a) != null)
                        {
                            com.socialin.android.facebook.FacebookWallPostActivity.g(a).setVisibility(8);
                        }
                        String s1;
                        if (request == null)
                        {
                            obj1 = "";
                        } else
                        if (((ImageItem) (request)).url != null)
                        {
                            obj1 = ((ImageItem) (request)).url;
                        } else
                        if (request.getMidleUrl() != null)
                        {
                            obj1 = request.getMidleUrl();
                        } else
                        if (request.getSmallUrl() != null)
                        {
                            obj1 = request.getSmallUrl();
                        } else
                        {
                            obj1 = request.getThumbUrl();
                        }
                        s1 = (new StringBuilder("http://picsart.com/i/")).append(l1).toString();
                        FacebookWallPostActivity.a(a, ((ImageItem) (request)).width);
                        com.socialin.android.facebook.FacebookWallPostActivity.b(a, ((ImageItem) (request)).height);
                        FacebookWallPostActivity.a(a, ((ImageItem) (request)).id);
                        FacebookWallPostActivity.a(a, ((String) (obj1)), s1, Boolean.valueOf(true));
                    }

            
            {
                a = FacebookWallPostActivity.this;
                super();
            }
                });
                i.doRequest(g, j);
                return true;
            } else
            {
                DialogUtils.showDialog(this, C);
                c();
                return true;
            }
        }
          goto _L1
_L3:
        if (k)
        {
            b(h);
            f.clear();
            return true;
        } else
        {
            finish();
            overridePendingTransition(0, 0x7f040048);
            return true;
        }
    }

}
