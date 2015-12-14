// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.cyberlink.beautycircle.controller.a.bb;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.ShareOutUtils;
import com.cyberlink.beautycircle.utility.ab;
import com.cyberlink.beautycircle.utility.ae;
import com.cyberlink.beautycircle.utility.ah;
import com.cyberlink.beautycircle.utility.c;
import com.cyberlink.beautycircle.view.widgetpool.facebook.LoginButton;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.FacebookDialog;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseActivity, m, j, Globals, 
//            d

public class BaseFbActivity extends BaseActivity
{

    private com.facebook.Session.StatusCallback e;
    private com.facebook.widget.FacebookDialog.Callback f;
    public UiLifecycleHelper h;
    public LoginButton i;
    public ah j;
    public ae k;
    public boolean l;
    public Runnable m;
    public Post n;

    public BaseFbActivity()
    {
        l = false;
        n = null;
        e = new com.facebook.Session.StatusCallback() {

            final BaseFbActivity a;

            public void call(Session session, SessionState sessionstate, Exception exception)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    session, ", ", sessionstate, ", ", exception
                });
                a.a(session, sessionstate, exception);
            }

            
            {
                a = BaseFbActivity.this;
                super();
            }
        };
        f = new com.facebook.widget.FacebookDialog.Callback() {

            final BaseFbActivity a;

            public void onComplete(com.facebook.widget.FacebookDialog.PendingCall pendingcall, Bundle bundle)
            {
                if (FacebookDialog.getNativeDialogDidComplete(bundle))
                {
                    if (FacebookDialog.getNativeDialogCompletionGesture(bundle) == null || "cancel".equals(FacebookDialog.getNativeDialogCompletionGesture(bundle)))
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "FB dialog cancel"
                        });
                        a.t();
                    } else
                    {
                        pendingcall = FacebookDialog.getNativeDialogPostId(bundle);
                        com.perfectcorp.utility.e.b(new Object[] {
                            (new StringBuilder()).append("FB post id :").append(pendingcall).toString()
                        });
                        if (a.n != null)
                        {
                            BCTileImage.a(a.n);
                        }
                        a.s();
                    }
                } else
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "FB dialog cancel"
                    });
                    a.t();
                }
                a.n = null;
            }

            public void onError(com.facebook.widget.FacebookDialog.PendingCall pendingcall, Exception exception, Bundle bundle)
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    exception
                });
                a.n = null;
            }

            
            {
                a = BaseFbActivity.this;
                super();
            }
        };
    }

    public String a(Post post, String s1)
    {
        if (post == null)
        {
            return null;
        }
        String s3 = getString(m.bc_scheme);
        String s4 = getString(m.bc_host_post);
        String s2 = null;
        if (post.extLookUrl != null)
        {
            s2 = "how_to";
        }
        if (s1 != null)
        {
            return String.format(Locale.getDefault(), "%s://%s/%d?%s=%s&%s=%s", new Object[] {
                s3, s4, post.postId, "sourceType", s1, "campaign", s2
            });
        } else
        {
            return String.format(Locale.getDefault(), "%s://%s/%d?&%s=%s", new Object[] {
                s3, s4, post.postId, "campaign", s2
            });
        }
    }

    public void a(Bundle bundle, boolean flag)
    {
        i = (LoginButton)findViewById(j.register_facebook);
        if (i != null)
        {
            if (flag)
            {
                i.b();
                i.setReadPermissions(Arrays.asList(new String[] {
                    "email", "user_birthday", "user_about_me", "user_friends"
                }));
            }
            i.setSoundEffectsEnabled(false);
            h = new UiLifecycleHelper(this, e);
            h.onCreate(bundle);
        }
    }

    public void a(View view, Post post)
    {
        n = post;
        a(com.cyberlink.beautycircle.controller.adapter.ShareAdapter.ShareListMode.c);
    }

    public void a(com.cyberlink.beautycircle.controller.adapter.ShareAdapter.ShareListMode sharelistmode)
    {
        if (n == null)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "No action post."
            });
            return;
        } else
        {
            int i1 = m.bc_share_to_title;
            sharelistmode = com.cyberlink.beautycircle.utility.ShareOutUtils.ShareInfo.a(n);
            sharelistmode.j = new ab() {

                final BaseFbActivity a;

                public void a()
                {
                    a.l();
                }

            
            {
                a = BaseFbActivity.this;
                super();
            }
            };
            ShareOutUtils.a(this, sharelistmode, com.cyberlink.beautycircle.controller.adapter.ShareAdapter.ShareListMode.c, i1, null);
            return;
        }
    }

    protected void a(UserInfo userinfo, c c1)
    {
        if (userinfo.receiveEmail != null && !userinfo.receiveEmail.isEmpty())
        {
            if (c1 != null)
            {
                c1.a();
            }
        } else
        if (i != null)
        {
            Session session = Session.getActiveSession();
            String s1 = AccountManager.b();
            if (session.isOpened())
            {
                a(session, s1, userinfo, c1);
                return;
            }
        }
    }

    public void a(Session session, SessionState sessionstate, Exception exception)
    {
        if (sessionstate.isOpened())
        {
            com.cyberlink.beautycircle.Globals.b("FB opened");
            if (l)
            {
                l = false;
                if (m != null)
                {
                    m.run();
                }
            }
        } else
        if (sessionstate == SessionState.CLOSED_LOGIN_FAILED)
        {
            if (exception != null && exception.getMessage() != null)
            {
                session = exception.getMessage();
            } else
            {
                session = "Unknow error";
            }
            com.cyberlink.beautycircle.Globals.b(session);
            l();
            return;
        }
    }

    protected void a(Session session, String s1, UserInfo userinfo, c c1)
    {
        runOnUiThread(new Runnable(session, userinfo, s1, c1) {

            final Session a;
            final UserInfo b;
            final String c;
            final c d;
            final BaseFbActivity e;

            public void run()
            {
                Request.newMeRequest(a, new com.facebook.Request.GraphUserCallback(this) {

                    final _cls2 a;

                    public void onCompleted(GraphUser graphuser, Response response)
                    {
                        if (graphuser != null)
                        {
                            graphuser = (String)graphuser.getProperty("email");
                            a.b.receiveEmail = graphuser;
                            NetworkUser.a(a.c, null, null, null, null, null, null, null, null, null, null, graphuser, null, null);
                            AccountManager.c(graphuser);
                            AccountManager.a(a.c, a.b, false);
                            if (a.d != null)
                            {
                                a.d.a();
                            }
                        } else
                        {
                            com.perfectcorp.utility.e.b(new Object[] {
                                "Can't get GraphUser."
                            });
                            if (a.d != null)
                            {
                                a.d.b();
                                return;
                            }
                        }
                    }

            
            {
                a = _pcls2;
                super();
            }
                }).executeAsync();
            }

            
            {
                e = BaseFbActivity.this;
                a = session;
                b = userinfo;
                c = s1;
                d = c1;
                super();
            }
        });
    }

    public void a(String s1, String s2, String s3, String s4, String s5, String s6, long l1)
    {
        boolean flag;
        if (s5 != null && s6 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (s1 == null)
        {
            s1 = "";
        }
        if (s2 == null)
        {
            s2 = "";
        }
        if (s3 == null)
        {
            s3 = "";
        }
        if (s4 == null)
        {
            s4 = "";
        }
        if (FacebookDialog.canPresentShareDialog(this, new com.facebook.widget.FacebookDialog.ShareDialogFeature[] {
    com.facebook.widget.FacebookDialog.ShareDialogFeature.SHARE_DIALOG
}))
        {
            s1 = ((com.facebook.widget.FacebookDialog.ShareDialogBuilder)((com.facebook.widget.FacebookDialog.ShareDialogBuilder)((com.facebook.widget.FacebookDialog.ShareDialogBuilder)((com.facebook.widget.FacebookDialog.ShareDialogBuilder)(new com.facebook.widget.FacebookDialog.ShareDialogBuilder(this)).setName(s1)).setLink(s4)).setDescription(s2)).setPicture(s3)).build();
            if (h != null)
            {
                h.trackPendingDialogCall(s1.present());
            }
            if (flag)
            {
                b.a(new bb(s5, "share", s6, "Yes", d.d, l1));
            }
            return;
        } else
        {
            Session session = Session.getActiveSession();
            Bundle bundle = new Bundle();
            bundle.putString("name", s1);
            bundle.putString("link", s4);
            bundle.putString("description", s2);
            bundle.putString("picture", s3);
            (new Request(session, "/me/feed", bundle, HttpMethod.POST, new com.facebook.Request.Callback(flag, s5, s6, l1) {

                final boolean a;
                final String b;
                final String c;
                final long d;
                final BaseFbActivity e;

                public void onCompleted(Response response)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "response", response.toString()
                    });
                    if (response == null || response.getConnection() == null) goto _L2; else goto _L1
_L1:
                    if (response.getConnection().getResponseCode() != 200) goto _L4; else goto _L3
_L3:
                    Globals.a(e.getResources().getString(m.bc_share_success));
                    if (e.n != null)
                    {
                        BCTileImage.a(e.n);
                    }
                    if (a)
                    {
                        com.perfectcorp.a.b.a(new bb(b, "share", c, "Yes", d.d, d));
                    }
                    e.s();
_L6:
                    e.n = null;
                    return;
_L4:
                    try
                    {
                        if (a)
                        {
                            com.perfectcorp.a.b.a(new bb(b, "share", c, "No", d.d, d));
                        }
                        e.t();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Response response)
                    {
                        response.printStackTrace();
                    }
                    continue; /* Loop/switch isn't completed */
_L2:
                    com.perfectcorp.a.b.a(new bb(b, "share", c, "No", d.d, d));
                    e.t();
                    if (true) goto _L6; else goto _L5
_L5:
                }

            
            {
                e = BaseFbActivity.this;
                a = flag;
                b = s1;
                c = s2;
                d = l1;
                super();
            }
            })).executeAsync();
            return;
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (h != null)
        {
            h.onActivityResult(i1, j1, intent, f);
        }
        if (j != null && j.c != null)
        {
            j.c.authorizeCallBack(i1, j1, intent);
        }
    }

    protected void onDestroy()
    {
        if (h != null)
        {
            h.onDestroy();
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        if (h != null)
        {
            h.onPause();
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (h != null)
        {
            h.onResume();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (h != null)
        {
            h.onSaveInstanceState(bundle);
        }
    }

    protected void onStop()
    {
        super.onStop();
        if (h != null)
        {
            h.onStop();
        }
    }

    public void s()
    {
        l();
    }

    public void t()
    {
        l();
        Globals.a(getResources().getString(m.bc_share_fail));
    }
}
