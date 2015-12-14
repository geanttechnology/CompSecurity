// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.DynamicDrawableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.NotificationList;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.network.o;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.view.widgetpool.common.CircleList;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.model.Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            m, l

public class k extends com.cyberlink.beautycircle.controller.adapter.m
{

    private Activity a;
    private l b;
    private String c;
    private Date d;
    private Map e;
    private DynamicDrawableSpan f;

    public k(Activity activity, ViewGroup viewgroup, int i1, l l1)
    {
        super(activity, viewgroup, i1, 20, l1);
        b = null;
        c = "Friend";
        d = null;
        e = new HashMap();
        f = null;
        if (activity == null)
        {
            throw new NullPointerException("The first parameter cannot be null");
        } else
        {
            a = activity;
            b = l1;
            return;
        }
    }

    private android.view.View.OnClickListener a(String s, Long long1, Long long2)
    {
        if (s != null && !s.isEmpty())
        {
            if ("AddPost".equals(s) || "FriendLikePost".equals(s))
            {
                return new android.view.View.OnClickListener(long2) {

                    final Long a;
                    final k b;

                    public void onClick(View view)
                    {
                        k.a(b, a, false);
                    }

            
            {
                b = k.this;
                a = long1;
                super();
            }
                };
            }
            if ("CreateCircle".equals(s) || "FriendFollowCircle".equals(s))
            {
                return new android.view.View.OnClickListener(long2) {

                    final Long a;
                    final k b;

                    public void onClick(View view)
                    {
                        k.b(b, a);
                    }

            
            {
                b = k.this;
                a = long1;
                super();
            }
                };
            }
        }
        return null;
    }

    static l a(k k1)
    {
        return k1.b;
    }

    static Date a(k k1, Date date)
    {
        k1.d = date;
        return date;
    }

    private void a(View view)
    {
        TextView textview = (TextView)view.findViewById(j.bc_notification_main_desc);
        if (textview != null && a != null)
        {
            textview.setText(a.getResources().getString(m.need_update_description));
        }
        a(view, false, false, null, null, null, null);
        d(view);
        e(view);
        f(view);
    }

    private void a(View view, boolean flag, boolean flag1, Uri uri, Uri uri1, String s, android.view.View.OnClickListener onclicklistener)
    {
        boolean flag2 = false;
        int i1;
        if (flag)
        {
            UICImageView uicimageview = (UICImageView)view.findViewById(j.bc_notification_right_image);
            if (uicimageview != null)
            {
                uicimageview.setVisibility(0);
                if (flag1)
                {
                    CircleList.a(uicimageview, uri1, s);
                } else
                {
                    uicimageview.setImageURI(uri);
                }
                uicimageview.setOnClickListener(onclicklistener);
            }
        } else
        {
            b(view);
        }
        uri = view.findViewById(j.bc_notification_right_image_mask);
        if (uri != null)
        {
            if (flag && flag1)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            uri.setVisibility(i1);
        }
        view = view.findViewById(j.bc_notification_right_image_square_mask);
        if (view != null)
        {
            if (flag && !flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
    }

    static void a(k k1, Long long1)
    {
        k1.a(long1);
    }

    static void a(k k1, Long long1, boolean flag)
    {
        k1.a(long1, flag);
    }

    private void a(NotificationList notificationlist, View view, boolean flag)
    {
        if (view != null)
        {
            if (notificationlist == null)
            {
                view.setVisibility(8);
                return;
            }
            Object obj;
            View view1;
            int i1;
            if (notificationlist.groupNum.longValue() > 0L)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
            if ("AddPost".equals(notificationlist.notifyType) || "FriendLikePost".equals(notificationlist.notifyType))
            {
                obj = e(notificationlist);
                i1 = 0;
            } else
            if ("CreateCircle".equals(notificationlist.notifyType) || "FriendFollowCircle".equals(notificationlist.notifyType))
            {
                obj = f(notificationlist);
                i1 = 1;
            } else
            {
                obj = null;
                i1 = 0;
            }
            view1 = view.findViewById(j.bc_bottom_image_first);
            if (view1 != null)
            {
                Object obj2 = (UICImageView)view1.findViewById(j.bc_bottom_main_image);
                View view2 = view1.findViewById(j.bc_bottom_main_image_mask);
                Object obj3 = view1.findViewById(j.bc_bottom_main_image_square_mask);
                int j1;
                if (notificationlist.groupNum.longValue() > 0L)
                {
                    j1 = 0;
                } else
                {
                    j1 = 8;
                }
                view1.setVisibility(j1);
                if (obj2 != null)
                {
                    if (notificationlist.groupNum.longValue() > 0L)
                    {
                        Object obj1;
                        Object obj4;
                        Long long1;
                        if (obj != null && ((ArrayList) (obj)).size() > 0)
                        {
                            obj1 = (Uri)((ArrayList) (obj)).get(0);
                        } else
                        {
                            obj1 = null;
                        }
                        if (i1 != 0 && notificationlist.circleNames != null && notificationlist.circleNames.size() > 0)
                        {
                            CircleList.a(((UICImageView) (obj2)), ((Uri) (obj1)), (String)notificationlist.circleNames.get(0));
                        } else
                        {
                            ((UICImageView) (obj2)).setImageURI(((Uri) (obj1)));
                        }
                        ((UICImageView) (obj2)).setVisibility(0);
                        ((UICImageView) (obj2)).setOnClickListener(a(notificationlist.notifyType, notificationlist.senderId, notificationlist.refId));
                    } else
                    {
                        ((UICImageView) (obj2)).setImageURI(null);
                        ((UICImageView) (obj2)).setVisibility(8);
                        ((UICImageView) (obj2)).setOnClickListener(null);
                    }
                }
                if (view2 != null && obj3 != null)
                {
                    if (flag)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = 8;
                    }
                    view2.setVisibility(j1);
                    if (!flag)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = 8;
                    }
                    ((View) (obj3)).setVisibility(j1);
                }
            }
            obj1 = view.findViewById(j.bc_bottom_image_second);
            if (obj1 != null)
            {
                obj2 = (UICImageView)((View) (obj1)).findViewById(j.bc_bottom_main_image);
                view2 = ((View) (obj1)).findViewById(j.bc_bottom_main_image_mask);
                obj3 = ((View) (obj1)).findViewById(j.bc_bottom_main_image_square_mask);
                if (notificationlist.groupNum.longValue() > 1L)
                {
                    j1 = 0;
                } else
                {
                    j1 = 8;
                }
                ((View) (obj1)).setVisibility(j1);
                if (obj2 != null)
                {
                    if (notificationlist.groupNum.longValue() > 1L)
                    {
                        if (obj != null && ((ArrayList) (obj)).size() > 1)
                        {
                            obj1 = (Uri)((ArrayList) (obj)).get(1);
                        } else
                        {
                            obj1 = null;
                        }
                        if (i1 != 0 && notificationlist.circleNames != null && notificationlist.circleNames.size() > 1)
                        {
                            CircleList.a(((UICImageView) (obj2)), ((Uri) (obj1)), (String)notificationlist.circleNames.get(1));
                        } else
                        {
                            ((UICImageView) (obj2)).setImageURI(((Uri) (obj1)));
                        }
                        ((UICImageView) (obj2)).setVisibility(0);
                        obj4 = notificationlist.notifyType;
                        long1 = notificationlist.senderId;
                        if (notificationlist.idList != null && notificationlist.idList.size() > 0)
                        {
                            obj1 = (Long)notificationlist.idList.get(0);
                        } else
                        {
                            obj1 = null;
                        }
                        ((UICImageView) (obj2)).setOnClickListener(a(((String) (obj4)), long1, ((Long) (obj1))));
                    } else
                    {
                        ((UICImageView) (obj2)).setImageURI(null);
                        ((UICImageView) (obj2)).setVisibility(8);
                        ((UICImageView) (obj2)).setOnClickListener(null);
                    }
                }
                if (view2 != null && view2 != null)
                {
                    if (flag)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = 8;
                    }
                    view2.setVisibility(j1);
                    if (!flag)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = 8;
                    }
                    ((View) (obj3)).setVisibility(j1);
                }
            }
            obj3 = view.findViewById(j.bc_bottom_image_third);
            if (obj3 != null)
            {
                obj1 = (UICImageView)((View) (obj3)).findViewById(j.bc_bottom_main_image);
                obj2 = ((View) (obj3)).findViewById(j.bc_bottom_main_image_mask);
                view2 = ((View) (obj3)).findViewById(j.bc_bottom_main_image_square_mask);
                if (notificationlist.groupNum.longValue() > 2L)
                {
                    j1 = 0;
                } else
                {
                    j1 = 8;
                }
                ((View) (obj3)).setVisibility(j1);
                if (obj1 != null)
                {
                    if (notificationlist.groupNum.longValue() > 2L)
                    {
                        if (obj != null && ((ArrayList) (obj)).size() > 2)
                        {
                            obj = (Uri)((ArrayList) (obj)).get(2);
                        } else
                        {
                            obj = null;
                        }
                        if (i1 != 0 && notificationlist.circleNames != null && notificationlist.circleNames.size() > 2)
                        {
                            CircleList.a(((UICImageView) (obj1)), ((Uri) (obj)), (String)notificationlist.circleNames.get(2));
                        } else
                        {
                            ((UICImageView) (obj1)).setImageURI(((Uri) (obj)));
                        }
                        ((UICImageView) (obj1)).setVisibility(0);
                        obj3 = notificationlist.notifyType;
                        obj4 = notificationlist.senderId;
                        if (notificationlist.idList != null && notificationlist.idList.size() > 1)
                        {
                            obj = (Long)notificationlist.idList.get(1);
                        } else
                        {
                            obj = null;
                        }
                        ((UICImageView) (obj1)).setOnClickListener(a(((String) (obj3)), ((Long) (obj4)), ((Long) (obj))));
                    } else
                    {
                        ((UICImageView) (obj1)).setImageURI(null);
                        ((UICImageView) (obj1)).setVisibility(8);
                        ((UICImageView) (obj1)).setOnClickListener(null);
                    }
                }
                if (obj2 != null && view2 != null)
                {
                    if (flag)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = 8;
                    }
                    ((View) (obj2)).setVisibility(i1);
                    if (!flag)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = 8;
                    }
                    view2.setVisibility(i1);
                }
            }
            obj = view.findViewById(j.bc_bottom_count_outter);
            obj1 = (TextView)view.findViewById(j.bc_bottom_count_text);
            if (obj1 != null)
            {
                if (notificationlist.groupNum.longValue() > 3L)
                {
                    view = (new StringBuilder()).append("+").append(notificationlist.groupNum.longValue() - 3L).toString();
                } else
                {
                    view = "";
                }
                ((TextView) (obj1)).setText(view);
            }
            if (obj != null)
            {
                if (notificationlist.groupNum.longValue() > 3L)
                {
                    i1 = 0;
                } else
                {
                    i1 = 8;
                }
                ((View) (obj)).setVisibility(i1);
                return;
            }
        }
    }

    private void a(Long long1)
    {
        if (long1 == null)
        {
            return;
        } else
        {
            com.cyberlink.beautycircle.c.a(a, long1.longValue(), com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
            return;
        }
    }

    private void a(Long long1, com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode)
    {
        if (long1 == null)
        {
            return;
        } else
        {
            com.cyberlink.beautycircle.c.a(a, long1.longValue(), melistmode);
            return;
        }
    }

    private void a(Long long1, String s)
    {
        if (long1 == null)
        {
            return;
        } else
        {
            com.cyberlink.beautycircle.c.a(a, long1, s, null);
            return;
        }
    }

    private void a(Long long1, boolean flag)
    {
        if (long1 == null)
        {
            return;
        }
        Activity activity = a;
        long l1 = long1.longValue();
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        com.cyberlink.beautycircle.c.a(activity, l1, true, byte0, null, null);
    }

    static String b(k k1)
    {
        return k1.c;
    }

    private void b(View view)
    {
        view = (UICImageView)view.findViewById(j.bc_notification_right_image);
        if (view != null)
        {
            view.setVisibility(8);
            view.setImageURI(null);
            view.setOnClickListener(null);
        }
    }

    static void b(k k1, Long long1)
    {
        k1.c(long1);
    }

    private void b(NotificationList notificationlist, View view)
    {
        a(view, true, false, c(notificationlist), null, null, new android.view.View.OnClickListener(notificationlist) {

            final NotificationList a;
            final k b;

            public void onClick(View view1)
            {
                if (a != null)
                {
                    view1 = a.refId;
                } else
                {
                    view1 = null;
                }
                k.a(b, view1, true);
            }

            
            {
                b = k.this;
                a = notificationlist;
                super();
            }
        });
        Object obj = view.findViewById(j.bc_notification_divi);
        if (obj != null)
        {
            ((View) (obj)).setVisibility(0);
        }
        obj = (TextView)view.findViewById(j.bc_notification_comment_desc);
        if (obj != null)
        {
            ((TextView) (obj)).setVisibility(0);
            if (notificationlist.comments != null && notificationlist.comments.size() > 0)
            {
                ((TextView) (obj)).setText((CharSequence)notificationlist.comments.get(0));
            }
        }
        e(view);
    }

    private Uri c(NotificationList notificationlist)
    {
        if (notificationlist == null || notificationlist.files == null || notificationlist.files.size() == 0)
        {
            return null;
        }
        for (notificationlist = notificationlist.files.iterator(); notificationlist.hasNext();)
        {
            Object obj = (com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile)notificationlist.next();
            if (((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).b() != null)
            {
                obj = ((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).b();
                if (obj != null && ((FileMetadata) (obj)).originalUrl != null)
                {
                    return ((FileMetadata) (obj)).originalUrl;
                }
            }
        }

        return null;
    }

    static Date c(k k1)
    {
        return k1.d;
    }

    private void c(NotificationList notificationlist, View view)
    {
        a(view, false, false, null, null, null, null);
        e(view);
        d(view);
        f(view);
    }

    private void c(Long long1)
    {
        if (long1 == null)
        {
            return;
        } else
        {
            com.cyberlink.beautycircle.c.a(a, null, long1);
            return;
        }
    }

    static Activity d(k k1)
    {
        return k1.a;
    }

    private Uri d(NotificationList notificationlist)
    {
        if (notificationlist == null || notificationlist.files == null || notificationlist.files.size() == 0)
        {
            return null;
        }
        for (notificationlist = notificationlist.files.iterator(); notificationlist.hasNext();)
        {
            Object obj = (com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile)notificationlist.next();
            if (((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).b() != null)
            {
                obj = ((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).b();
                if (obj != null && ((FileMetadata) (obj)).originalUrl != null)
                {
                    return ((FileMetadata) (obj)).originalUrl;
                }
            }
        }

        return null;
    }

    private void d(View view)
    {
        view = view.findViewById(j.bc_notification_divi);
        if (view != null)
        {
            view.setVisibility(8);
        }
    }

    private void d(NotificationList notificationlist, View view)
    {
        a(view, true, true, null, h(notificationlist), i(notificationlist), new android.view.View.OnClickListener(notificationlist) {

            final NotificationList a;
            final k b;

            public void onClick(View view1)
            {
                if (a != null)
                {
                    k.b(b, a.refId);
                }
            }

            
            {
                b = k.this;
                a = notificationlist;
                super();
            }
        });
        e(view);
        d(view);
        f(view);
    }

    private void d(Long long1)
    {
        if (long1 == null)
        {
            return;
        }
        String s;
        if (a != null)
        {
            s = a.getResources().getString(m.bc_notification_new_posts);
        } else
        {
            s = "";
        }
        com.cyberlink.beautycircle.c.a(a, s, long1.longValue());
    }

    private ArrayList e(NotificationList notificationlist)
    {
        if (notificationlist == null || notificationlist.files == null || notificationlist.files.size() == 0)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        notificationlist = notificationlist.files.iterator();
        do
        {
            if (!notificationlist.hasNext())
            {
                break;
            }
            Object obj = (com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile)notificationlist.next();
            if (((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).b() != null)
            {
                obj = ((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).b();
                if (obj != null && ((FileMetadata) (obj)).originalUrl != null)
                {
                    arraylist.add(((FileMetadata) (obj)).originalUrl);
                }
            }
        } while (true);
        return arraylist;
    }

    private void e(View view)
    {
        view = (LinearLayout)view.findViewById(j.bc_notification_bottom_image);
        if (view != null)
        {
            view.setVisibility(8);
        }
    }

    private void e(NotificationList notificationlist, View view)
    {
        a(view, false, false, null, null, null, null);
        e(view);
        d(view);
        f(view);
    }

    private void e(Long long1)
    {
        if (long1 == null)
        {
            return;
        }
        String s;
        if (a != null)
        {
            s = a.getResources().getString(m.bc_notification_posts_like);
        } else
        {
            s = "";
        }
        com.cyberlink.beautycircle.c.a(a, s, long1.longValue());
    }

    private ArrayList f(NotificationList notificationlist)
    {
        if (notificationlist == null || notificationlist.circleIcons == null || notificationlist.circleIcons.size() == 0)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = notificationlist.circleIcons.iterator();
        while (iterator.hasNext()) 
        {
            notificationlist = (String)iterator.next();
            if (notificationlist != null && !notificationlist.isEmpty())
            {
                notificationlist = Uri.parse(notificationlist);
            } else
            {
                notificationlist = null;
            }
            arraylist.add(notificationlist);
        }
        return arraylist;
    }

    private void f(View view)
    {
        view = (TextView)view.findViewById(j.bc_notification_comment_desc);
        if (view != null)
        {
            view.setVisibility(8);
            view.setText("");
        }
    }

    private void f(NotificationList notificationlist, View view)
    {
        a(view, false, false, null, null, null, null);
        LinearLayout linearlayout = (LinearLayout)view.findViewById(j.bc_notification_bottom_image);
        if (linearlayout != null)
        {
            linearlayout.setVisibility(0);
            a(notificationlist, linearlayout, false);
        }
        d(view);
        f(view);
    }

    private void f(Long long1)
    {
        if (long1 == null)
        {
            return;
        }
        String s;
        if (a != null)
        {
            s = a.getResources().getString(m.bc_notification_new_circles);
        } else
        {
            s = "";
        }
        com.cyberlink.beautycircle.c.b(a, s, long1.longValue());
    }

    private Uri g(NotificationList notificationlist)
    {
        if (notificationlist == null || notificationlist.files == null || notificationlist.files.size() == 0)
        {
            return null;
        }
        for (notificationlist = notificationlist.files.iterator(); notificationlist.hasNext();)
        {
            Object obj = (com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile)notificationlist.next();
            if (((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).b() != null)
            {
                obj = ((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).b();
                if (obj != null && ((FileMetadata) (obj)).originalUrl != null)
                {
                    return ((FileMetadata) (obj)).originalUrl;
                }
            }
        }

        return null;
    }

    private void g(NotificationList notificationlist, View view)
    {
        a(view, false, false, null, null, null, null);
        LinearLayout linearlayout = (LinearLayout)view.findViewById(j.bc_notification_bottom_image);
        if (linearlayout != null)
        {
            linearlayout.setVisibility(0);
            a(notificationlist, linearlayout, true);
        }
        d(view);
        f(view);
    }

    private void g(Long long1)
    {
        if (long1 == null)
        {
            return;
        }
        String s;
        if (a != null)
        {
            s = a.getResources().getString(m.bc_notification_circles_followed);
        } else
        {
            s = "";
        }
        com.cyberlink.beautycircle.c.b(a, s, long1.longValue());
    }

    private Uri h(NotificationList notificationlist)
    {
        if (notificationlist == null || notificationlist.circleIcons == null || notificationlist.circleIcons.size() == 0)
        {
            return null;
        } else
        {
            return Uri.parse((String)notificationlist.circleIcons.get(0));
        }
    }

    private void h(NotificationList notificationlist, View view)
    {
        a(view, true, false, d(notificationlist), null, null, new android.view.View.OnClickListener(notificationlist) {

            final NotificationList a;
            final k b;

            public void onClick(View view1)
            {
                if (a != null)
                {
                    view1 = a.refId;
                } else
                {
                    view1 = null;
                }
                k.a(b, view1, false);
            }

            
            {
                b = k.this;
                a = notificationlist;
                super();
            }
        });
        e(view);
        d(view);
        f(view);
    }

    private String i(NotificationList notificationlist)
    {
        if (notificationlist == null || notificationlist.circleNames == null || notificationlist.circleNames.isEmpty())
        {
            return null;
        } else
        {
            return (String)notificationlist.circleNames.get(0);
        }
    }

    private void i(NotificationList notificationlist, View view)
    {
        a(view, true, false, g(notificationlist), null, null, new android.view.View.OnClickListener(notificationlist) {

            final NotificationList a;
            final k b;

            public void onClick(View view1)
            {
                if (a != null)
                {
                    view1 = a.refId;
                } else
                {
                    view1 = null;
                }
                k.a(b, view1, false);
            }

            
            {
                b = k.this;
                a = notificationlist;
                super();
            }
        });
        e(view);
        d(view);
        f(view);
    }

    private void j(NotificationList notificationlist, View view)
    {
        a(view, false, false, null, null, null, null);
        LinearLayout linearlayout = (LinearLayout)view.findViewById(j.bc_notification_bottom_image);
        if (linearlayout != null)
        {
            linearlayout.setVisibility(0);
            a(notificationlist, linearlayout, false);
        }
        d(view);
        f(view);
    }

    private void k(NotificationList notificationlist, View view)
    {
        a(view, false, false, null, null, null, null);
        LinearLayout linearlayout = (LinearLayout)view.findViewById(j.bc_notification_bottom_image);
        if (linearlayout != null)
        {
            linearlayout.setVisibility(0);
            a(notificationlist, linearlayout, true);
        }
        d(view);
        f(view);
    }

    private void l(NotificationList notificationlist, View view)
    {
        a(view, false, false, null, null, null, null);
        e(view);
        d(view);
        f(view);
    }

    protected void a(NotificationList notificationlist)
    {
    }

    protected void a(NotificationList notificationlist, View view)
    {
label0:
        {
            if (notificationlist != null && notificationlist.notifyType != null)
            {
                view.setTag(notificationlist);
                Object obj1 = (UICImageView)view.findViewById(j.bc_notification_avatar);
                Object obj;
                if (obj1 != null)
                {
                    if (notificationlist.avatarUrl != null)
                    {
                        obj = Uri.parse(notificationlist.avatarUrl);
                    } else
                    {
                        obj = null;
                    }
                    ((UICImageView) (obj1)).setImageURI(((Uri) (obj)));
                    ((UICImageView) (obj1)).setOnClickListener(new android.view.View.OnClickListener(notificationlist) {

                        final NotificationList a;
                        final k b;

                        public void onClick(View view1)
                        {
                            if (a != null)
                            {
                                view1 = a.senderId;
                            } else
                            {
                                view1 = null;
                            }
                            k.a(b, view1);
                        }

            
            {
                b = k.this;
                a = notificationlist;
                super();
            }
                    });
                }
                obj1 = (TextView)view.findViewById(j.bc_notification_main_desc);
                if (obj1 != null)
                {
                    if (notificationlist.msg != null)
                    {
                        obj = Html.fromHtml(notificationlist.msg);
                    } else
                    {
                        obj = "";
                    }
                    ((TextView) (obj1)).setText(((CharSequence) (obj)));
                }
                obj = (TextView)view.findViewById(j.bc_notification_main_time);
                if (obj != null && notificationlist.createTime != null)
                {
                    if (f == null)
                    {
                        f = new DynamicDrawableSpan(1, (int)((double)((TextView) (obj)).getTextSize() * 0.80000000000000004D)) {

                            final int a;
                            final k b;

                            public Drawable getDrawable()
                            {
                                Drawable drawable = b.getContext().getResources().getDrawable(com.cyberlink.beautycircle.i.bc_issue_comment_time);
                                drawable.setBounds(0, 0, a, a);
                                return drawable;
                            }

            
            {
                b = k.this;
                a = j1;
                super(i1);
            }
                        };
                    }
                    obj1 = new SpannableString((new StringBuilder()).append("  ").append(com.cyberlink.beautycircle.utility.i.a(notificationlist.createTime)).toString());
                    ((SpannableString) (obj1)).setSpan(f, 0, 1, 17);
                    ((TextView) (obj)).setText(((CharSequence) (obj1)));
                }
                if (!"CommentPost".equals(notificationlist.notifyType))
                {
                    break label0;
                }
                b(notificationlist, view);
            }
            return;
        }
        if ("FollowUser".equals(notificationlist.notifyType))
        {
            c(notificationlist, view);
            return;
        }
        if ("FollowCircle".equals(notificationlist.notifyType))
        {
            d(notificationlist, view);
            return;
        }
        if ("JoinBCFromFB".equals(notificationlist.notifyType) || "JoinBCFromWeibo".equals(notificationlist.notifyType))
        {
            e(notificationlist, view);
            return;
        }
        if ("AddPost".equals(notificationlist.notifyType))
        {
            f(notificationlist, view);
            return;
        }
        if ("CreateCircle".equals(notificationlist.notifyType))
        {
            g(notificationlist, view);
            return;
        }
        if ("LikePost".equals(notificationlist.notifyType))
        {
            h(notificationlist, view);
            return;
        }
        if ("CircleInPost".equals(notificationlist.notifyType))
        {
            i(notificationlist, view);
            return;
        }
        if ("FriendLikePost".equals(notificationlist.notifyType))
        {
            j(notificationlist, view);
            return;
        }
        if ("FriendFollowCircle".equals(notificationlist.notifyType))
        {
            k(notificationlist, view);
            return;
        }
        if ("FreeSample".equals(notificationlist.notifyType))
        {
            l(notificationlist, view);
            return;
        }
        if ("Consultation".equals(notificationlist.notifyType))
        {
            l(notificationlist, view);
            return;
        } else
        {
            a(view);
            return;
        }
    }

    protected void a(Model model)
    {
        b((NotificationList)model);
    }

    protected volatile void a(Model model, View view)
    {
        a((NotificationList)model, view);
    }

    public boolean a(String s)
    {
        if (s == null || s.isEmpty())
        {
            return false;
        }
        if (!c.equals(s))
        {
            String s1 = c;
            ArrayList arraylist = f();
            if (s1 != null && arraylist != null)
            {
                e.put(s1, (ArrayList)arraylist.clone());
            }
            c = s;
            if (e.containsKey(c))
            {
                s = (ArrayList)e.get(c);
                if (s != null && s.size() > 0)
                {
                    if (a != null)
                    {
                        a.runOnUiThread(new Runnable(s) {

                            final ArrayList a;
                            final k b;

                            public void run()
                            {
                                if (k.a(b) != null)
                                {
                                    k.a(b, ((NotificationList)a.get(0)).createTime);
                                    k.a(b).a(k.b(b), com.cyberlink.beautycircle.controller.adapter.k.c(b));
                                    k.a(b).a(false);
                                }
                            }

            
            {
                b = k.this;
                a = arraylist;
                super();
            }
                        });
                    }
                    clear();
                    addAll(s);
                } else
                {
                    if (a != null)
                    {
                        a.runOnUiThread(new Runnable() {

                            final k a;

                            public void run()
                            {
                                if (k.a(a) != null)
                                {
                                    k.a(a).a(true);
                                }
                            }

            
            {
                a = k.this;
                super();
            }
                        });
                    }
                    clear();
                }
                return false;
            } else
            {
                b(false);
                return true;
            }
        } else
        {
            return false;
        }
    }

    protected d b(int i1, int j1)
    {
        Object obj;
label0:
        {
            try
            {
                obj = (d)o.a(AccountManager.b(), c, i1, j1).a(new com.perfectcorp.utility.j() {

                    final k a;

                    public d a(d d1)
                    {
                        return d1;
                    }

                    public volatile Object a(Object obj1)
                    {
                        return a((d)obj1);
                    }

                    public void a(int k1)
                    {
                        super.a(k1);
                        if (com.cyberlink.beautycircle.controller.adapter.k.d(a) != null && (com.cyberlink.beautycircle.controller.adapter.k.d(a) instanceof MainActivity))
                        {
                            ((BaseActivity)com.cyberlink.beautycircle.controller.adapter.k.d(a)).a(com.cyberlink.beautycircle.controller.adapter.k.d(a).getString(m.bc_server_connect_fail), 3000);
                        }
                    }

            
            {
                a = k.this;
                super();
            }
                }).d();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((InterruptedException) (obj)).printStackTrace();
                obj = null;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((ExecutionException) (obj)).printStackTrace();
                obj = null;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((CancellationException) (obj)).printStackTrace();
                obj = null;
            }
            if (h() && b != null)
            {
                if (obj == null || ((d) (obj)).b == null || ((d) (obj)).b.size() <= 0)
                {
                    break label0;
                }
                d = ((NotificationList)((d) (obj)).b.get(0)).createTime;
                b.a(c, d);
            }
            return ((d) (obj));
        }
        b.a(c, null);
        return ((d) (obj));
    }

    public Date b()
    {
        return d;
    }

    protected void b(NotificationList notificationlist)
    {
        if (notificationlist != null)
        {
            if ("CommentPost".equals(notificationlist.notifyType))
            {
                a(notificationlist.refId, true);
                return;
            }
            if ("FollowUser".equals(notificationlist.notifyType))
            {
                a(notificationlist.receiverId, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e);
                return;
            }
            if ("FollowCircle".equals(notificationlist.notifyType))
            {
                c(notificationlist.refId);
                return;
            }
            if ("JoinBCFromFB".equals(notificationlist.notifyType) || "JoinBCFromWeibo".equals(notificationlist.notifyType))
            {
                a(notificationlist.senderId);
                return;
            }
            if ("AddPost".equals(notificationlist.notifyType))
            {
                if (notificationlist.groupNum.longValue() > 1L)
                {
                    d(notificationlist.id);
                    return;
                } else
                {
                    a(notificationlist.refId, false);
                    return;
                }
            }
            if ("CreateCircle".equals(notificationlist.notifyType))
            {
                if (notificationlist.groupNum.longValue() > 1L)
                {
                    f(notificationlist.id);
                    return;
                } else
                {
                    c(notificationlist.refId);
                    return;
                }
            }
            if ("LikePost".equals(notificationlist.notifyType))
            {
                a(notificationlist.refId, false);
                return;
            }
            if ("CircleInPost".equals(notificationlist.notifyType))
            {
                a(notificationlist.refId, false);
                return;
            }
            if ("FriendLikePost".equals(notificationlist.notifyType))
            {
                if (notificationlist.groupNum.longValue() > 1L)
                {
                    e(notificationlist.id);
                    return;
                } else
                {
                    a(notificationlist.refId, false);
                    return;
                }
            }
            if ("FriendFollowCircle".equals(notificationlist.notifyType))
            {
                if (notificationlist.groupNum.longValue() > 1L)
                {
                    g(notificationlist.id);
                    return;
                } else
                {
                    c(notificationlist.refId);
                    return;
                }
            }
            if ("FreeSample".equals(notificationlist.notifyType))
            {
                a(notificationlist.refId, ((String) (null)));
                return;
            }
            if ("Consultation".equals(notificationlist.notifyType))
            {
                a(notificationlist.refId, com.cyberlink.beautycircle.controller.activity.FreeSampleActivity.EventAction.e.action);
                return;
            }
        }
    }

    protected void b(Model model)
    {
        a((NotificationList)model);
    }

    public void b(boolean flag)
    {
        if (flag)
        {
            e.clear();
        }
        super.c();
    }

    public void c()
    {
        b(true);
    }

    public String d()
    {
        return c;
    }

    public void e()
    {
        super.e();
        if (e != null)
        {
            e.clear();
        }
    }
}
