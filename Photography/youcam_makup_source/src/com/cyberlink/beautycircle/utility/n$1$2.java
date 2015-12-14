// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            AccountManager, n, o, t, 
//            v, DialogUtils, b

class a extends j
{

    final tManager.b a;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected String a(Void void1)
    {
        return AccountManager.b();
    }

    tail(tail tail)
    {
        a = tail;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/utility/n$1

/* anonymous class */
    final class n._cls1
        implements android.view.View.OnClickListener
    {

        final CircleDetail a;
        final o b;

        private void a(View view)
        {
            if (!(view instanceof TextView)) goto _L2; else goto _L1
_L1:
            ((TextView)view).setText(m.bc_following);
            view.setSelected(false);
_L4:
            if (a.followerCount != null)
            {
                view = a.followerCount;
                view = a;
                view.followerCount = Long.valueOf(((CircleDetail) (view)).followerCount.longValue() + 1L);
            }
            if (b != null)
            {
                b.a(a, true);
            }
            return;
_L2:
            view = view.findViewById(com.cyberlink.beautycircle.j.follow_text);
            if (view instanceof TextView)
            {
                ((TextView)view).setText(m.bc_following);
                view.setSelected(false);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void a(View view, String s)
        {
            if (a.isFollowed == null)
            {
                e.d(new Object[] {
                    "Unable to follow/unfollow: circleId=", a.id
                });
                Globals.b((new StringBuilder()).append("Unable to follow circleId=").append(a.id).toString());
                view.setVisibility(4);
                return;
            }
            if (!a.isFollowed.booleanValue())
            {
                a.isFollowed = Boolean.valueOf(true);
                NetworkCircle.a(s, a.id, a.circleCreatorId).a(new n._cls1._cls3(view));
                a(view);
                t.c.a();
                return;
            }
            s = new n._cls1._cls4(s, view);
            android.content.Context context = view.getContext();
            if (n.a() && (context instanceof Activity))
            {
                view = view.getResources();
                DialogUtils.a((Activity)context, view.getString(m.bc_unfollow_title), view.getString(m.bc_unfollow_confirm), view.getString(m.bc_dialog_button_cancel), null, view.getString(m.bc_unfollow_button), s);
                return;
            } else
            {
                s.run();
                return;
            }
        }

        static void a(n._cls1 _pcls1, View view)
        {
            _pcls1.b(view);
        }

        static void a(n._cls1 _pcls1, View view, String s)
        {
            _pcls1.a(view, s);
        }

        private void b(View view)
        {
            if (!(view instanceof TextView)) goto _L2; else goto _L1
_L1:
            ((TextView)view).setText(m.bc_plus_follow);
            view.setSelected(true);
_L4:
            if (a.followerCount != null)
            {
                view = a.followerCount;
                view = a;
                view.followerCount = Long.valueOf(((CircleDetail) (view)).followerCount.longValue() - 1L);
            }
            if (b != null)
            {
                b.a(a, false);
            }
            return;
_L2:
            view = view.findViewById(com.cyberlink.beautycircle.j.follow_text);
            if (view instanceof TextView)
            {
                ((TextView)view).setText(m.bc_plus_follow);
                view.setSelected(true);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        static void b(n._cls1 _pcls1, View view)
        {
            _pcls1.a(view);
        }

        public void onClick(View view)
        {
            if (view == null)
            {
                return;
            } else
            {
                (new n._cls1._cls2(this)).d(null).a(new n._cls1._cls1(view));
                return;
            }
        }

            
            {
                a = circledetail;
                b = o1;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/utility/n$1$1

/* anonymous class */
        class n._cls1._cls1 extends com.perfectcorp.utility.m
        {

            final View a;
            final n._cls1 b;

            protected void a(String s)
            {
                if (s == null)
                {
                    aq.c = "follow_circle";
                    AccountManager.a(a.getContext(), new n._cls1._cls1._cls1(this));
                    return;
                } else
                {
                    n._cls1.a(b, a, s);
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((String)obj);
            }

                    
                    {
                        b = n._cls1.this;
                        a = view;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/utility/n$1$1$1

/* anonymous class */
        class n._cls1._cls1._cls1
            implements b
        {

            final n._cls1._cls1 a;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s)
            {
                a.a.post(new n._cls1._cls1._cls1._cls1(this, s));
            }

            public void b()
            {
                Globals.b("Get AccountToken Cancel");
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/utility/n$1$1$1$1

/* anonymous class */
        class n._cls1._cls1._cls1._cls1
            implements Runnable
        {

            final String a;
            final n._cls1._cls1._cls1 b;

            public void run()
            {
                n._cls1.a(b.a.b, b.a.a, a);
            }

                    
                    {
                        b = _pcls1;
                        a = s;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/utility/n$1$3

/* anonymous class */
        class n._cls1._cls3 extends com.perfectcorp.utility.m
        {

            final View a;
            final n._cls1 b;

            protected void a()
            {
                a(0x80000005);
            }

            protected void a(int i)
            {
                e.b(new Object[] {
                    "Follow circleId=", b.a.id, " fail: ", Integer.valueOf(i)
                });
                String s = a.getResources().getString(m.bc_follow_fail);
                Globals.a(String.format(Locale.getDefault(), s, new Object[] {
                    b.a.circleName
                }));
                b.a.isFollowed = Boolean.valueOf(false);
                n._cls1.a(b, a);
            }

            public void a(Void void1)
            {
                e.b(new Object[] {
                    "Follow circleId=", b.a.id, " success"
                });
                void1 = a.getResources().getString(m.bc_follow_success);
                Globals.a(String.format(Locale.getDefault(), void1, new Object[] {
                    b.a.circleName
                }));
            }

            public void b(Object obj)
            {
                a((Void)obj);
            }

                    
                    {
                        b = n._cls1.this;
                        a = view;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/utility/n$1$4

/* anonymous class */
        class n._cls1._cls4
            implements Runnable
        {

            final String a;
            final View b;
            final n._cls1 c;

            public void run()
            {
                c.a.isFollowed = Boolean.valueOf(false);
                NetworkCircle.b(a, c.a.id, c.a.circleCreatorId).a(new n._cls1._cls4._cls1(this));
                n._cls1.a(c, b);
                t.c.a();
            }

                    
                    {
                        c = n._cls1.this;
                        a = s;
                        b = view;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/utility/n$1$4$1

/* anonymous class */
        class n._cls1._cls4._cls1 extends com.perfectcorp.utility.m
        {

            final n._cls1._cls4 a;

            protected void a()
            {
                a(0x80000005);
            }

            protected void a(int i)
            {
                e.b(new Object[] {
                    "Unfollow circleId=", a.c.a.id, " fail: ", Integer.valueOf(i)
                });
                String s = a.b.getResources().getString(m.bc_unfollow_fail);
                Globals.a(String.format(Locale.getDefault(), s, new Object[] {
                    a.c.a.circleName
                }));
                a.c.a.isFollowed = Boolean.valueOf(true);
                n._cls1.b(a.c, a.b);
            }

            public void a(Void void1)
            {
                e.b(new Object[] {
                    "Unfollow circleId=", a.c.a.id, " success"
                });
                void1 = a.b.getResources().getString(m.bc_unfollow_success);
                Globals.a(String.format(Locale.getDefault(), void1, new Object[] {
                    a.c.a.circleName
                }));
            }

            public void b(Object obj)
            {
                a((Void)obj);
            }

                    
                    {
                        a = _pcls4;
                        super();
                    }
        }

    }

}
