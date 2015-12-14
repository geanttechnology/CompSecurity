// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.q;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.cc;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.model.GraphPlace;
import com.facebook.model.GraphUser;
import com.facebook.widget.ProfilePictureView;
import com.pf.common.utility.m;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookFriendPickerActivity, FacebookPlacePickerActivity

public class FacebookSharingActivity extends BaseActivity
{

    public static final UUID a = UUID.randomUUID();
    public static int b = 150;
    public static int c = 150;
    private static final String d = com/cyberlink/youcammakeup/kernelctrl/status/StatusManager.getName();
    private com.facebook.Session.StatusCallback A;
    private com.facebook.Session.StatusCallback B;
    private android.view.View.OnClickListener C;
    private android.view.View.OnClickListener D;
    private android.view.View.OnClickListener E;
    private android.view.View.OnClickListener F;
    private android.view.View.OnClickListener G;
    private android.view.View.OnClickListener H;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private EditText j;
    private TextView k;
    private View l;
    private View m;
    private ProfilePictureView n;
    private File o;
    private Toast p;
    private FacebookAction q;
    private boolean r;
    private Request s;
    private FacebookPostTarget t;
    private long u;
    private String v;
    private String w;
    private String x;
    private NetworkManager y;
    private com.facebook.Session.StatusCallback z;

    public FacebookSharingActivity()
    {
        o = null;
        q = null;
        r = false;
        s = null;
        u = 0L;
        z = new com.facebook.Session.StatusCallback() {

            final FacebookSharingActivity a;

            public void call(Session session, SessionState sessionstate, Exception exception)
            {
                com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a);
                if (session != null)
                {
                    session = session.getPermissions();
                    if (session != null)
                    {
                        for (session = session.iterator(); session.hasNext(); com.pf.common.utility.m.b("FacebookSharingActivity", (new StringBuilder()).append("mStatusCallback, permission=").append(exception).toString()))
                        {
                            exception = (String)session.next();
                        }

                    }
                }
                if (!FacebookSharingActivity.b(a) || FacebookSharingActivity.c(a) == null) goto _L2; else goto _L1
_L1:
                if (FacebookSharingActivity.c(a) != com.cyberlink.youcammakeup.activity.FacebookAction.a) goto _L4; else goto _L3
_L3:
                com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a, com.cyberlink.youcammakeup.activity.FacebookAction.a);
_L6:
                return;
_L4:
                if (FacebookSharingActivity.c(a) == FacebookAction.b)
                {
                    com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a, FacebookAction.b);
                    return;
                }
                if (FacebookSharingActivity.c(a) == FacebookAction.c)
                {
                    FacebookSharingActivity.d(a);
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (sessionstate == SessionState.CLOSED_LOGIN_FAILED)
                {
                    a.finish();
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                a = FacebookSharingActivity.this;
                super();
            }

            private class FacebookAction extends Enum
            {

                public static final FacebookAction a;
                public static final FacebookAction b;
                public static final FacebookAction c;
                private static final FacebookAction d[];

                public static FacebookAction valueOf(String s1)
                {
                    return (FacebookAction)Enum.valueOf(com/cyberlink/youcammakeup/activity/FacebookSharingActivity$FacebookAction, s1);
                }

                public static FacebookAction[] values()
                {
                    return (FacebookAction[])d.clone();
                }

                static 
                {
                    a = new FacebookAction("PickFriend", 0);
                    b = new FacebookAction("PickPlace", 1);
                    c = new FacebookAction("Upload", 2);
                    d = (new FacebookAction[] {
                        a, b, c
                    });
                }

                private FacebookAction(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        };
        A = new com.facebook.Session.StatusCallback() {

            final FacebookSharingActivity a;

            public void call(Session session, SessionState sessionstate, Exception exception)
            {
                if (!FacebookSharingActivity.e(a))
                {
                    com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a, 0x7f07068e);
                    FacebookSharingActivity.b(a, null);
                }
            }

            
            {
                a = FacebookSharingActivity.this;
                super();
            }
        };
        B = new com.facebook.Session.StatusCallback() {

            final FacebookSharingActivity a;

            public void call(Session session, SessionState sessionstate, Exception exception)
            {
                if (!session.getPermissions().contains("user_friends"))
                {
                    com.pf.common.utility.m.b("FacebookSharingActivity", "Can't get the user_friends permission");
                    FacebookSharingActivity.b(a, null);
                }
            }

            
            {
                a = FacebookSharingActivity.this;
                super();
            }
        };
        C = new android.view.View.OnClickListener() {

            final FacebookSharingActivity a;

            public void onClick(View view)
            {
                if (!FacebookSharingActivity.g(a))
                {
                    FacebookSharingActivity.h(a);
                    return;
                }
                if (!FacebookSharingActivity.b(a))
                {
                    FacebookSharingActivity.b(a, com.cyberlink.youcammakeup.activity.FacebookAction.a);
                    FacebookSharingActivity.i(a);
                    return;
                }
                if (!FacebookSharingActivity.e(a))
                {
                    FacebookSharingActivity.b(a, com.cyberlink.youcammakeup.activity.FacebookAction.a);
                    FacebookSharingActivity.j(a);
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a, com.cyberlink.youcammakeup.activity.FacebookAction.a);
                    return;
                }
            }

            
            {
                a = FacebookSharingActivity.this;
                super();
            }
        };
        D = new android.view.View.OnClickListener() {

            final FacebookSharingActivity a;

            public void onClick(View view)
            {
                view = " #";
                int i1 = Math.max(com.cyberlink.youcammakeup.activity.FacebookSharingActivity.k(a).getSelectionStart(), 0);
                int j1 = Math.max(com.cyberlink.youcammakeup.activity.FacebookSharingActivity.k(a).getSelectionEnd(), 0);
                String s1 = com.cyberlink.youcammakeup.activity.FacebookSharingActivity.k(a).getText().toString();
                if (i1 == 0 || !com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a, i1, s1))
                {
                    view = "#";
                }
                com.cyberlink.youcammakeup.activity.FacebookSharingActivity.k(a).getText().replace(i1, j1, view, 0, view.length());
            }

            
            {
                a = FacebookSharingActivity.this;
                super();
            }
        };
        E = new android.view.View.OnClickListener() {

            final FacebookSharingActivity a;

            public void onClick(View view)
            {
                if (!FacebookSharingActivity.g(a))
                {
                    FacebookSharingActivity.h(a);
                    return;
                }
                if (FacebookSharingActivity.b(a))
                {
                    com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a, FacebookAction.b);
                    return;
                } else
                {
                    FacebookSharingActivity.b(a, FacebookAction.b);
                    FacebookSharingActivity.i(a);
                    return;
                }
            }

            
            {
                a = FacebookSharingActivity.this;
                super();
            }
        };
        F = new android.view.View.OnClickListener() {

            final FacebookSharingActivity a;

            public void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = FacebookSharingActivity.this;
                super();
            }
        };
        G = new android.view.View.OnClickListener() {

            final FacebookSharingActivity a;

            public void onClick(View view)
            {
                if (FacebookSharingActivity.g(a))
                {
                    af.b(com.cyberlink.youcammakeup.Globals.ActivityType.f);
                }
            }

            
            {
                a = FacebookSharingActivity.this;
                super();
            }
        };
        H = new android.view.View.OnClickListener() {

            final FacebookSharingActivity a;

            public void onClick(View view)
            {
                if (!FacebookSharingActivity.g(a))
                {
                    FacebookSharingActivity.h(a);
                    return;
                }
                FacebookSharingActivity.b(a, FacebookAction.c);
                if (FacebookSharingActivity.b(a))
                {
                    FacebookSharingActivity.d(a);
                    return;
                } else
                {
                    FacebookSharingActivity.i(a);
                    return;
                }
            }

            
            {
                a = FacebookSharingActivity.this;
                super();
            }
        };
    }

    public static FacebookPostTarget a(String s1)
    {
        if (s1 == null)
        {
            return com.cyberlink.youcammakeup.activity.FacebookPostTarget.a;
        }
        if (s1.equalsIgnoreCase(FacebookPostTarget.b.name()))
        {
            return FacebookPostTarget.b;
        }
        if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.activity.FacebookPostTarget.a.name()))
        {
            return com.cyberlink.youcammakeup.activity.FacebookPostTarget.a;
        } else
        {
            return com.cyberlink.youcammakeup.activity.FacebookPostTarget.a;
        }
    }

    static Request a(FacebookSharingActivity facebooksharingactivity, Request request)
    {
        facebooksharingactivity.s = request;
        return request;
    }

    private void a(int i1)
    {
        if (p != null)
        {
            p.cancel();
        }
        p = Toast.makeText(this, i1, 0);
        p.setGravity(17, 0, 0);
        p.show();
    }

    static void a(FacebookSharingActivity facebooksharingactivity)
    {
        facebooksharingactivity.k();
    }

    static void a(FacebookSharingActivity facebooksharingactivity, int i1)
    {
        facebooksharingactivity.a(i1);
    }

    static void a(FacebookSharingActivity facebooksharingactivity, FacebookAction facebookaction)
    {
        facebooksharingactivity.b(facebookaction);
    }

    static void a(FacebookSharingActivity facebooksharingactivity, String s1)
    {
        facebooksharingactivity.b(s1);
    }

    private void a(URI uri)
    {
        Globals.d().w().a(new k(u, "Makeup_Category_item", uri), new l() {

            final FacebookSharingActivity a;

            public void a(a a1)
            {
            }

            public void a(bn bn1)
            {
                if (bn1 == null);
            }

            public volatile void a(Object obj)
            {
                a((String)obj);
            }

            public void a(String s1)
            {
                Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.f);
                if (activity == null)
                {
                    return;
                } else
                {
                    activity.runOnUiThread(new Runnable(this, s1) {

                        final String a;
                        final _cls8 b;

                        public void run()
                        {
                            com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(b.a, a);
                        }

            
            {
                b = _pcls8;
                a = s1;
                super();
            }
                    });
                    return;
                }
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            public void d(Object obj)
            {
                a((a)obj);
            }

            
            {
                a = FacebookSharingActivity.this;
                super();
            }
        });
    }

    private boolean a(int i1, String s1)
    {
        while (s1 == null || s1.isEmpty() || i1 - 1 < 0 || i1 > s1.length() || Character.isWhitespace(s1.charAt(i1 - 1))) 
        {
            return false;
        }
        return true;
    }

    static boolean a(FacebookSharingActivity facebooksharingactivity, int i1, String s1)
    {
        return facebooksharingactivity.a(i1, s1);
    }

    static boolean a(FacebookSharingActivity facebooksharingactivity, boolean flag)
    {
        facebooksharingactivity.r = flag;
        return flag;
    }

    static FacebookAction b(FacebookSharingActivity facebooksharingactivity, FacebookAction facebookaction)
    {
        facebooksharingactivity.q = facebookaction;
        return facebookaction;
    }

    private void b(FacebookAction facebookaction)
    {
        q = null;
        a(facebookaction);
    }

    static void b(FacebookSharingActivity facebooksharingactivity, boolean flag)
    {
        facebooksharingactivity.b(flag);
    }

    private void b(String s1)
    {
        s1 = BitmapFactory.decodeFile(s1);
        if (s1 != null)
        {
            l.setVisibility(0);
            m.setVisibility(8);
            ((ImageView)findViewById(0x7f0c0127)).setImageBitmap(s1);
        }
    }

    private void b(boolean flag)
    {
        e.setClickable(flag);
        f.setClickable(flag);
        g.setClickable(flag);
        h.setClickable(flag);
        i.setClickable(flag);
    }

    static boolean b(FacebookSharingActivity facebooksharingactivity)
    {
        return facebooksharingactivity.o();
    }

    static FacebookAction c(FacebookSharingActivity facebooksharingactivity)
    {
        return facebooksharingactivity.q;
    }

    static void d(FacebookSharingActivity facebooksharingactivity)
    {
        facebooksharingactivity.s();
    }

    static boolean e(FacebookSharingActivity facebooksharingactivity)
    {
        return facebooksharingactivity.p();
    }

    static ProfilePictureView f(FacebookSharingActivity facebooksharingactivity)
    {
        return facebooksharingactivity.n;
    }

    static boolean g(FacebookSharingActivity facebooksharingactivity)
    {
        return facebooksharingactivity.r();
    }

    static void h(FacebookSharingActivity facebooksharingactivity)
    {
        facebooksharingactivity.v();
    }

    static void i(FacebookSharingActivity facebooksharingactivity)
    {
        facebooksharingactivity.m();
    }

    private void j()
    {
        if (x != null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        if (Globals.d().G() != -1L) goto _L2; else goto _L1
_L1:
        ImageBufferWrapper imagebufferwrapper;
        return;
_L2:
        if ((imagebufferwrapper = ViewEngine.a().a(Globals.d().G(), new q())) == null) goto _L1; else goto _L3
_L3:
        Bitmap bitmap1 = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
        imagebufferwrapper.c(bitmap1);
        imagebufferwrapper.m();
        l.setVisibility(8);
        m.setVisibility(0);
        ((ImageView)findViewById(0x7f0c0125)).setImageBitmap(bitmap1);
        return;
        Bitmap bitmap = aa.a(((Uri)Globals.d().C().get(0)).getPath(), b, c, 0x2a3000, false);
        l.setVisibility(8);
        m.setVisibility(0);
        ((ImageView)findViewById(0x7f0c0125)).setImageBitmap(bitmap);
        return;
    }

    static void j(FacebookSharingActivity facebooksharingactivity)
    {
        facebooksharingactivity.n();
    }

    static EditText k(FacebookSharingActivity facebooksharingactivity)
    {
        return facebooksharingactivity.j;
    }

    private void k()
    {
        Session session = Session.getActiveSession();
        if (session.isOpened() && !r && s == null)
        {
            s = Request.newMeRequest(session, new com.facebook.Request.GraphUserCallback() {

                final FacebookSharingActivity a;

                public void onCompleted(GraphUser graphuser, Response response)
                {
                    if (graphuser != null)
                    {
                        FacebookSharingActivity.f(a).setProfileId(graphuser.getId());
                        com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a, true);
                    }
                    com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a, null);
                }

            
            {
                a = FacebookSharingActivity.this;
                super();
            }
            });
            s.executeAsync();
        }
    }

    static String l(FacebookSharingActivity facebooksharingactivity)
    {
        return facebooksharingactivity.x;
    }

    private void l()
    {
        Object obj1 = Globals.d();
        Object obj = ((Globals) (obj1)).E();
        obj1 = ((Globals) (obj1)).F();
        if (obj1 == null && (obj == null || ((List) (obj)).isEmpty()))
        {
            k.setVisibility(8);
            return;
        }
        k.setVisibility(0);
        String s1;
        if (obj1 != null)
        {
            obj1 = ((GraphPlace) (obj1)).getName();
        } else
        {
            obj1 = null;
        }
        if (obj != null && !((List) (obj)).isEmpty())
        {
            s1 = ((GraphUser)((List) (obj)).get(0)).getName();
            if (((List) (obj)).size() > 1)
            {
                obj = Integer.valueOf(((List) (obj)).size() - 1);
            } else
            {
                obj = null;
            }
        } else
        {
            obj = null;
            s1 = null;
        }
        if (s1 != null && obj == null && obj1 == null)
        {
            obj = getString(0x7f07069b, new Object[] {
                s1
            });
        } else
        if (s1 != null && obj != null && obj1 == null)
        {
            obj = getString(0x7f07069d, new Object[] {
                s1, obj
            });
        } else
        if (s1 == null && obj == null && obj1 != null)
        {
            obj = getString(0x7f070674, new Object[] {
                obj1
            });
        } else
        if (s1 != null && obj == null && obj1 != null)
        {
            obj = getString(0x7f07069c, new Object[] {
                s1, obj1
            });
        } else
        if (s1 != null && obj != null && obj1 != null)
        {
            obj = getString(0x7f07069e, new Object[] {
                s1, obj, obj1
            });
        } else
        {
            obj = null;
        }
        k.setText(((CharSequence) (obj)));
    }

    static File m(FacebookSharingActivity facebooksharingactivity)
    {
        return facebooksharingactivity.o;
    }

    private void m()
    {
        if (!r())
        {
            q = null;
            v();
            return;
        }
        Session session = Session.getActiveSession();
        if (!session.isOpened() && !session.isClosed())
        {
            session.openForRead((new com.facebook.Session.OpenRequest(this)).setCallback(z));
            return;
        } else
        {
            Session.openActiveSession(this, true, z);
            return;
        }
    }

    static String n(FacebookSharingActivity facebooksharingactivity)
    {
        return facebooksharingactivity.v;
    }

    private void n()
    {
        if (!r())
        {
            v();
            return;
        } else
        {
            com.facebook.Session.NewPermissionsRequest newpermissionsrequest = new com.facebook.Session.NewPermissionsRequest(this, new String[] {
                "user_friends"
            });
            newpermissionsrequest.setCallback(B);
            Session.getActiveSession().requestNewPublishPermissions(newpermissionsrequest);
            return;
        }
    }

    private boolean o()
    {
        Session session = Session.getActiveSession();
        return session != null && session.isOpened();
    }

    private boolean p()
    {
        Session session = Session.getActiveSession();
        return session != null && session.getPermissions().contains("user_friends");
    }

    private boolean q()
    {
        Session session = Session.getActiveSession();
        return session != null && session.getPermissions().contains("publish_actions");
    }

    private boolean r()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnected();
    }

    private void s()
    {
        Session session = Session.getActiveSession();
        if (session == null) goto _L2; else goto _L1
_L1:
        if (!q())
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (t != com.cyberlink.youcammakeup.activity.FacebookPostTarget.a) goto _L4; else goto _L3
_L3:
        t();
_L2:
        return;
_L4:
        if (t != FacebookPostTarget.b) goto _L2; else goto _L5
_L5:
        u();
        return;
        if (session.isOpened() && r())
        {
            com.facebook.Session.NewPermissionsRequest newpermissionsrequest = new com.facebook.Session.NewPermissionsRequest(this, new String[] {
                "publish_actions"
            });
            newpermissionsrequest.setCallback(A);
            session.requestNewPublishPermissions(newpermissionsrequest);
            return;
        } else
        {
            a(0x7f070694);
            return;
        }
    }

    private void t()
    {
        if (q())
        {
            q = null;
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(j.getWindowToken(), 2);
            j.clearFocus();
            j.setFocusableInTouchMode(false);
            j.setFocusable(false);
            b(false);
            (new Handler()).postDelayed(new Runnable() {

                com.facebook.Request.Callback a;
                final FacebookSharingActivity b;

                public void run()
                {
                    int i1;
                    b.a(MakeupMode.g);
                    Object obj;
                    Object obj1;
                    Request request;
                    Bundle bundle;
                    Globals globals;
                    List list;
                    try
                    {
                        globals = Globals.d();
                        request = Request.newUploadPhotoRequest(Session.getActiveSession(), com.cyberlink.youcammakeup.activity.FacebookSharingActivity.m(b), a);
                        bundle = request.getParameters();
                        bundle.putString("message", com.cyberlink.youcammakeup.activity.FacebookSharingActivity.k(b).getText().toString());
                        list = globals.E();
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                        com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(b, 0x7f070694);
                        return;
                    }
                    if (list == null) goto _L2; else goto _L1
_L1:
                    if (list.size() <= 0) goto _L2; else goto _L3
_L3:
                    obj = "[";
                    i1 = 0;
_L8:
                    if (i1 >= list.size()) goto _L5; else goto _L4
_L4:
                    obj1 = (GraphUser)list.get(i1);
                    obj1 = (new StringBuilder()).append("{\"tag_uid\": \"").append(((GraphUser) (obj1)).getId()).toString();
                    obj1 = (new StringBuilder()).append(((String) (obj1))).append("\"}").toString();
                    obj1 = (new StringBuilder()).append(((String) (obj))).append(((String) (obj1))).toString();
                    obj = obj1;
                    if (i1 < list.size() - 1)
                    {
                        obj = (new StringBuilder()).append(((String) (obj1))).append(",").toString();
                    }
                      goto _L6
_L5:
                    bundle.putString("tags", (new StringBuilder()).append(((String) (obj))).append("]").toString());
_L2:
                    obj = globals.F();
                    if (obj == null)
                    {
                        break MISSING_BLOCK_LABEL_264;
                    }
                    bundle.putString("place", ((GraphPlace) (obj)).getId());
                    request.executeAsync();
                    com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(b, 0x7f070696);
                    return;
_L6:
                    i1++;
                    if (true) goto _L8; else goto _L7
_L7:
                }

            
            {
                b = FacebookSharingActivity.this;
                super();
                a = new _cls1(this);
            }
            }, 1000L);
        }
    }

    private void u()
    {
        if (q())
        {
            q = null;
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(j.getWindowToken(), 2);
            j.clearFocus();
            j.setFocusableInTouchMode(false);
            j.setFocusable(false);
            b(false);
            (new Handler()).postDelayed(new Runnable() {

                com.facebook.Request.Callback a;
                final FacebookSharingActivity b;

                public void run()
                {
                    int i1;
                    b.a(MakeupMode.g);
                    Object obj;
                    Object obj1;
                    Bundle bundle;
                    Globals globals;
                    List list;
                    try
                    {
                        globals = Globals.d();
                        String s1 = com.cyberlink.youcammakeup.activity.FacebookSharingActivity.k(b).getText().toString();
                        bundle = new Bundle();
                        bundle.putString("message", s1);
                        bundle.putString("link", FacebookSharingActivity.n(b));
                        list = globals.E();
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                        com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(b, 0x7f070694);
                        return;
                    }
                    if (list == null) goto _L2; else goto _L1
_L1:
                    if (list.size() <= 0) goto _L2; else goto _L3
_L3:
                    obj = "[";
                    i1 = 0;
_L8:
                    if (i1 >= list.size()) goto _L5; else goto _L4
_L4:
                    obj1 = (GraphUser)list.get(i1);
                    obj1 = (new StringBuilder()).append("{\"tag_uid\": \"").append(((GraphUser) (obj1)).getId()).toString();
                    obj1 = (new StringBuilder()).append(((String) (obj1))).append("\"}").toString();
                    obj1 = (new StringBuilder()).append(((String) (obj))).append(((String) (obj1))).toString();
                    obj = obj1;
                    if (i1 < list.size() - 1)
                    {
                        obj = (new StringBuilder()).append(((String) (obj1))).append(",").toString();
                    }
                      goto _L6
_L5:
                    bundle.putString("tags", (new StringBuilder()).append(((String) (obj))).append("]").toString());
_L2:
                    obj = globals.F();
                    if (obj == null)
                    {
                        break MISSING_BLOCK_LABEL_260;
                    }
                    bundle.putString("place", ((GraphPlace) (obj)).getId());
                    (new Request(Session.getActiveSession(), "feed", bundle, HttpMethod.POST, a)).executeAsync();
                    com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(b, 0x7f070696);
                    return;
_L6:
                    i1++;
                    if (true) goto _L8; else goto _L7
_L7:
                }

            
            {
                b = FacebookSharingActivity.this;
                super();
                a = new _cls1(this);
            }
            }, 1000L);
        }
    }

    private void v()
    {
        String s1 = Globals.d().getResources().getString(0x7f070533);
        af.b(com.cyberlink.youcammakeup.Globals.ActivityType.f, G, 0x7f0c0128, s1);
    }

    protected void a(FacebookAction facebookaction)
    {
        if (facebookaction == com.cyberlink.youcammakeup.activity.FacebookAction.a)
        {
            startActivity(new Intent(this, com/cyberlink/youcammakeup/activity/FacebookFriendPickerActivity));
        } else
        if (facebookaction == FacebookAction.b)
        {
            startActivity(new Intent(this, com/cyberlink/youcammakeup/activity/FacebookPlacePickerActivity));
            return;
        }
    }

    public void finish()
    {
        super.finish();
        Globals.d().c("");
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        Session.getActiveSession().onActivityResult(this, i1, j1, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03000f);
        StatusManager.j().a("facebookSharingPage");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.f, this);
        if (Globals.d().v() == "facebookSharingPage")
        {
            StatusManager.j().D();
        }
        e = findViewById(0x7f0c011b);
        e.setOnClickListener(C);
        f = findViewById(0x7f0c011e);
        f.setOnClickListener(D);
        g = findViewById(0x7f0c011f);
        g.setOnClickListener(E);
        h = findViewById(0x7f0c0118);
        h.setOnClickListener(H);
        i = findViewById(0x7f0c0115);
        i.setOnClickListener(F);
        j = (EditText)findViewById(0x7f0c0122);
        k = (TextView)findViewById(0x7f0c0123);
        n = (ProfilePictureView)findViewById(0x7f0c0121);
        y = Globals.d().w();
        l = findViewById(0x7f0c0126);
        m = findViewById(0x7f0c0124);
        Object obj = Globals.d().C();
        if (obj != null && ((ArrayList) (obj)).get(0) != null)
        {
            o = new File(((Uri)((ArrayList) (obj)).get(0)).getPath());
        }
        Settings.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        obj = Session.getActiveSession();
        if (obj == null)
        {
            if (bundle != null)
            {
                obj = Session.restoreSession(this, null, z, bundle);
            }
            bundle = ((Bundle) (obj));
            if (obj == null)
            {
                bundle = new Session(this);
                bundle.closeAndClearTokenInformation();
            }
            Session.setActiveSession(bundle);
            if (bundle.getState().equals(SessionState.CREATED_TOKEN_LOADED))
            {
                bundle.openForRead((new com.facebook.Session.OpenRequest(this)).setCallback(z));
            }
        }
        m();
        bundle = getIntent();
        t = a(bundle.getStringExtra("facebook_post_target"));
        if (t == com.cyberlink.youcammakeup.activity.FacebookPostTarget.a)
        {
            x = bundle.getStringExtra("unlock_key_id");
            j();
        } else
        {
            u = bundle.getLongExtra("facebook_post_link_mkid", 0L);
            v = bundle.getStringExtra("facebook_post_link_uri");
            w = bundle.getStringExtra("facebook_post_link_thumbnail_uri");
            a(URI.create(w));
        }
        k.setVisibility(8);
    }

    public void onDestroy()
    {
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.f, null);
        super.onDestroy();
        if (isFinishing())
        {
            Globals.d().a(null);
            Globals.d().a(null);
            Globals.d().a(null);
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
            finish();
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        Globals.d().c("facebookSharingPage");
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        Globals.d().c(null);
        k();
        l();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(d, StatusManager.j());
        Session.saveSession(Session.getActiveSession(), bundle);
    }

    protected void onStart()
    {
        super.onStart();
        StatusManager.j().a("facebookSharingPage");
        StatusManager.j().a(Boolean.valueOf(true));
        Session.getActiveSession().addCallback(z);
    }

    public void onStop()
    {
        super.onStop();
        Session.getActiveSession().removeCallback(z);
    }


    // Unreferenced inner class com/cyberlink/youcammakeup/activity/FacebookSharingActivity$4$1

/* anonymous class */
    class _cls1
        implements com.facebook.Request.Callback
    {

        final _cls4 a;

        public void onCompleted(Response response)
        {
            if (response.getError() != null)
            {
                com.cyberlink.youcammakeup.activity.FacebookSharingActivity.k(a.b).setFocusableInTouchMode(true);
                com.cyberlink.youcammakeup.activity.FacebookSharingActivity.k(a.b).setFocusable(true);
                FacebookSharingActivity.b(a.b, true);
                a.b.i();
                com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a.b, 0x7f070694);
                return;
            }
            a.b.i();
            com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a.b, 0x7f070695);
            if (com.cyberlink.youcammakeup.activity.FacebookSharingActivity.l(a.b) != null)
            {
                cc.c(com.cyberlink.youcammakeup.activity.FacebookSharingActivity.l(a.b));
            }
            a.b.finish();
        }

            
            {
                a = _pcls4;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/youcammakeup/activity/FacebookSharingActivity$5$1

/* anonymous class */
    class _cls1
        implements com.facebook.Request.Callback
    {

        final _cls5 a;

        public void onCompleted(Response response)
        {
            if (response.getError() != null)
            {
                com.cyberlink.youcammakeup.activity.FacebookSharingActivity.k(a.b).setFocusableInTouchMode(true);
                com.cyberlink.youcammakeup.activity.FacebookSharingActivity.k(a.b).setFocusable(true);
                FacebookSharingActivity.b(a.b, true);
                a.b.i();
                com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a.b, 0x7f070694);
                return;
            } else
            {
                a.b.i();
                com.cyberlink.youcammakeup.activity.FacebookSharingActivity.a(a.b, 0x7f070695);
                a.b.finish();
                return;
            }
        }

            
            {
                a = _pcls5;
                super();
            }
    }


    private class FacebookPostTarget extends Enum
    {

        public static final FacebookPostTarget a;
        public static final FacebookPostTarget b;
        private static final FacebookPostTarget c[];

        public static FacebookPostTarget valueOf(String s1)
        {
            return (FacebookPostTarget)Enum.valueOf(com/cyberlink/youcammakeup/activity/FacebookSharingActivity$FacebookPostTarget, s1);
        }

        public static FacebookPostTarget[] values()
        {
            return (FacebookPostTarget[])c.clone();
        }

        static 
        {
            a = new FacebookPostTarget("SharePhoto", 0);
            b = new FacebookPostTarget("ShareLink", 1);
            c = (new FacebookPostTarget[] {
                a, b
            });
        }

        private FacebookPostTarget(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
