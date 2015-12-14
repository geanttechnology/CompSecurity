// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.facebook;

import android.content.Context;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.internal.SessionTracker;
import com.facebook.internal.Utility;
import com.facebook.model.GraphUser;
import com.facebook.widget.ToolTipPopup;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.facebook:
//            b, c, a, e, 
//            d

public class LoginButton extends ImageButton
{

    private static final String a = com/cyberlink/beautycircle/view/widgetpool/facebook/LoginButton.getName();
    private String b;
    private SessionTracker c;
    private GraphUser d;
    private Session e;
    private boolean f;
    private boolean g;
    private e h;
    private Fragment i;
    private b j;
    private String k;
    private android.view.View.OnClickListener l;
    private boolean m;
    private com.facebook.widget.ToolTipPopup.Style n;
    private ToolTipMode o;
    private long p;
    private ToolTipPopup q;

    public LoginButton(Context context)
    {
        super(context);
        b = null;
        d = null;
        e = null;
        j = new b();
        k = "fb_login_view_usage";
        n = com.facebook.widget.ToolTipPopup.Style.BLUE;
        o = ToolTipMode.a;
        p = 6000L;
        a(context);
        d();
    }

    public LoginButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = null;
        d = null;
        e = null;
        j = new b();
        k = "fb_login_view_usage";
        n = com.facebook.widget.ToolTipPopup.Style.BLUE;
        o = ToolTipMode.a;
        p = 6000L;
        if (!isInEditMode())
        {
            a(context);
        }
    }

    public LoginButton(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        b = null;
        d = null;
        e = null;
        j = new b();
        k = "fb_login_view_usage";
        n = com.facebook.widget.ToolTipPopup.Style.BLUE;
        o = ToolTipMode.a;
        p = 6000L;
        a(attributeset);
        a(context);
    }

    static SessionTracker a(LoginButton loginbutton)
    {
        return loginbutton.c;
    }

    static GraphUser a(LoginButton loginbutton, GraphUser graphuser)
    {
        loginbutton.d = graphuser;
        return graphuser;
    }

    private void a(AttributeSet attributeset)
    {
        f = false;
        g = true;
    }

    static void a(LoginButton loginbutton, com.facebook.internal.Utility.FetchedAppSettings fetchedappsettings)
    {
        loginbutton.a(fetchedappsettings);
    }

    private void a(com.facebook.internal.Utility.FetchedAppSettings fetchedappsettings)
    {
        if (fetchedappsettings != null && fetchedappsettings.getNuxEnabled() && getVisibility() == 0)
        {
            a(fetchedappsettings.getNuxContent());
        }
    }

    private void a(String s)
    {
        q = new ToolTipPopup(s, this);
        q.setStyle(n);
        q.setNuxDisplayTime(p);
        q.show();
    }

    private boolean a(Context context)
    {
        if (context != null)
        {
            Session session = Session.getActiveSession();
            if (session != null)
            {
                return session.isOpened();
            }
            if (Utility.getMetadataApplicationId(context) != null && Session.openActiveSessionFromCache(context) != null)
            {
                return true;
            }
        }
        return false;
    }

    static e b(LoginButton loginbutton)
    {
        return loginbutton.h;
    }

    static GraphUser c(LoginButton loginbutton)
    {
        return loginbutton.d;
    }

    static String c()
    {
        return a;
    }

    private void d()
    {
        super.setOnClickListener(new c(this));
        if (!isInEditMode())
        {
            c = new SessionTracker(getContext(), new a(this), null, false);
            f();
        }
    }

    static boolean d(LoginButton loginbutton)
    {
        return loginbutton.f;
    }

    static String e(LoginButton loginbutton)
    {
        return loginbutton.b;
    }

    private void e()
    {
        if (o == ToolTipMode.b)
        {
            return;
        } else
        {
            (new AsyncTask(Utility.getMetadataApplicationId(getContext())) {

                final String a;
                final LoginButton b;

                protected transient com.facebook.internal.Utility.FetchedAppSettings a(Void avoid[])
                {
                    return Utility.queryAppSettings(a, false);
                }

                protected void a(com.facebook.internal.Utility.FetchedAppSettings fetchedappsettings)
                {
                    LoginButton.a(b, fetchedappsettings);
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((com.facebook.internal.Utility.FetchedAppSettings)obj);
                }

            
            {
                b = LoginButton.this;
                a = s;
                super();
            }
            }).execute((Void[])null);
            return;
        }
    }

    static Fragment f(LoginButton loginbutton)
    {
        return loginbutton.i;
    }

    private void f()
    {
        if (g)
        {
            Session session = c.getOpenSession();
            if (session != null)
            {
                if (session != e)
                {
                    Request.executeBatchAsync(new Request[] {
                        Request.newMeRequest(session, new com.facebook.Request.GraphUserCallback(session) {

                            final Session a;
                            final LoginButton b;

                            public void onCompleted(GraphUser graphuser, Response response)
                            {
                                if (a == LoginButton.a(b).getOpenSession())
                                {
                                    LoginButton.a(b, graphuser);
                                    if (LoginButton.b(b) != null)
                                    {
                                        LoginButton.b(b).a(LoginButton.c(b));
                                    }
                                }
                                if (response.getError() != null)
                                {
                                    b.a(response.getError().getException());
                                }
                            }

            
            {
                b = LoginButton.this;
                a = session;
                super();
            }
                        })
                    });
                    e = session;
                }
            } else
            {
                d = null;
                if (h != null)
                {
                    h.a(d);
                    return;
                }
            }
        }
    }

    static b g(LoginButton loginbutton)
    {
        return loginbutton.j;
    }

    static String h(LoginButton loginbutton)
    {
        return loginbutton.k;
    }

    static android.view.View.OnClickListener i(LoginButton loginbutton)
    {
        return loginbutton.l;
    }

    static void j(LoginButton loginbutton)
    {
        loginbutton.f();
    }

    public void a()
    {
        if (q != null)
        {
            q.dismiss();
            q = null;
        }
    }

    void a(Exception exception)
    {
label0:
        {
            if (com.cyberlink.beautycircle.view.widgetpool.facebook.b.f(j) != null)
            {
                if (!(exception instanceof FacebookException))
                {
                    break label0;
                }
                com.cyberlink.beautycircle.view.widgetpool.facebook.b.f(j).a((FacebookException)exception);
            }
            return;
        }
        com.cyberlink.beautycircle.view.widgetpool.facebook.b.f(j).a(new FacebookException(exception));
    }

    public void b()
    {
        Session session = c.getOpenSession();
        if (session != null)
        {
            session.closeAndClearTokenInformation();
        }
    }

    public SessionDefaultAudience getDefaultAudience()
    {
        return j.b();
    }

    public SessionLoginBehavior getLoginBehavior()
    {
        return j.d();
    }

    public d getOnErrorListener()
    {
        return j.a();
    }

    List getPermissions()
    {
        return j.c();
    }

    public com.facebook.Session.StatusCallback getSessionStatusCallback()
    {
        return j.e();
    }

    public long getToolTipDisplayTime()
    {
        return p;
    }

    public ToolTipMode getToolTipMode()
    {
        return o;
    }

    public e getUserInfoChangedCallback()
    {
        return h;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (c != null && !c.isTracking())
        {
            c.startTracking();
            f();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (c != null)
        {
            c.stopTracking();
        }
        a();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!m && o != ToolTipMode.c && !isInEditMode())
        {
            m = true;
            e();
        }
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        d();
    }

    protected void onVisibilityChanged(View view, int i1)
    {
        super.onVisibilityChanged(view, i1);
        if (i1 != 0)
        {
            a();
        }
    }

    public void setApplicationId(String s)
    {
        b = s;
    }

    public void setDefaultAudience(SessionDefaultAudience sessiondefaultaudience)
    {
        j.a(sessiondefaultaudience);
    }

    public void setFragment(Fragment fragment)
    {
        i = fragment;
    }

    public void setLoginBehavior(SessionLoginBehavior sessionloginbehavior)
    {
        j.a(sessionloginbehavior);
    }

    void setLoginLogoutEventName(String s)
    {
        k = s;
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        l = onclicklistener;
    }

    public void setOnErrorListener(d d1)
    {
        j.a(d1);
    }

    void setProperties(b b1)
    {
        j = b1;
    }

    public void setPublishPermissions(List list)
    {
        j.b(list, c.getSession());
    }

    public transient void setPublishPermissions(String as[])
    {
        j.b(Arrays.asList(as), c.getSession());
    }

    public void setReadPermissions(List list)
    {
        j.a(list, c.getSession());
    }

    public transient void setReadPermissions(String as[])
    {
        j.a(Arrays.asList(as), c.getSession());
    }

    public void setSession(Session session)
    {
        c.setSession(session);
        f();
    }

    public void setSessionStatusCallback(com.facebook.Session.StatusCallback statuscallback)
    {
        j.a(statuscallback);
    }

    public void setToolTipDisplayTime(long l1)
    {
        p = l1;
    }

    public void setToolTipMode(ToolTipMode tooltipmode)
    {
        o = tooltipmode;
    }

    public void setToolTipStyle(com.facebook.widget.ToolTipPopup.Style style)
    {
        n = style;
    }

    public void setUserInfoChangedCallback(e e1)
    {
        h = e1;
    }


    private class ToolTipMode extends Enum
    {

        public static final ToolTipMode a;
        public static final ToolTipMode b;
        public static final ToolTipMode c;
        private static final ToolTipMode d[];

        public static ToolTipMode valueOf(String s)
        {
            return (ToolTipMode)Enum.valueOf(com/cyberlink/beautycircle/view/widgetpool/facebook/LoginButton$ToolTipMode, s);
        }

        public static ToolTipMode[] values()
        {
            return (ToolTipMode[])d.clone();
        }

        static 
        {
            a = new ToolTipMode("DEFAULT", 0);
            b = new ToolTipMode("DISPLAY_ALWAYS", 1);
            c = new ToolTipMode("NEVER_DISPLAY", 2);
            d = (new ToolTipMode[] {
                a, b, c
            });
        }

        private ToolTipMode(String s, int i1)
        {
            super(s, i1);
        }
    }

}
