// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.appboy.Appboy;
import com.bumptech.glide.b;
import com.bumptech.glide.k;
import com.picsart.studio.ads.g;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.c;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.constants.EventParam;
import com.socialin.android.picsart.profile.activity.CommentImageZoomActivity;
import com.socialin.android.picsart.profile.invite.NotificationInviteService;
import com.socialin.android.picsart.profile.invite.i;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.util.Utils;
import com.socialin.android.util.an;
import com.socialin.android.util.s;
import com.socialin.gson.Gson;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import myobfuscated.co.f;
import myobfuscated.cs.d;
import myobfuscated.cs.e;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.notifications:
//            c, NotificationsService, d, b

public class a extends Fragment
    implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, com.socialin.android.adapter.a, CommonConstants, d, e
{

    private static final String g = com/socialin/android/photo/notifications/a.getSimpleName();
    private g A;
    private LinearLayoutManager B;
    private com.socialin.android.photo.notifications.c C;
    private an D;
    private Point E;
    private com.socialin.android.photo.notifications.b F;
    private com.picsart.studio.d G;
    public com.socialin.android.e f;
    private String h;
    private myobfuscated.co.c i;
    private Activity j;
    private Map k;
    private RecyclerView l;
    private SwipeRefreshLayout m;
    private View n;
    private View o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public a()
    {
        C = new com.socialin.android.photo.notifications.c(this, (byte)0);
    }

    private Intent a(com.socialin.android.apiv3.model.BannersResponse.BannerItem banneritem)
    {
        Object obj = new Intent();
        ((Intent) (obj)).setClassName(j.getApplicationContext(), banneritem.activityName);
        banneritem = banneritem.activityParams;
        if (banneritem == null) goto _L2; else goto _L1
_L1:
        if (banneritem.size() <= 0) goto _L2; else goto _L3
_L3:
        banneritem = banneritem.iterator();
_L7:
        if (!banneritem.hasNext()) goto _L2; else goto _L4
_L4:
        Object obj1 = (com.socialin.android.apiv3.model.BannersResponse.ActivityParams)banneritem.next();
        if (!"int".equalsIgnoreCase(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).type)) goto _L6; else goto _L5
_L5:
        ((Intent) (obj)).putExtra(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).name, Integer.parseInt(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).value));
          goto _L7
        obj1;
        banneritem = ((com.socialin.android.apiv3.model.BannersResponse.BannerItem) (obj));
        obj = obj1;
_L8:
        com.socialin.android.d.b(g, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
        return banneritem;
_L6:
label0:
        {
            if (!"boolean".equalsIgnoreCase(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).type))
            {
                break label0;
            }
            ((Intent) (obj)).putExtra(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).name, Boolean.parseBoolean(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).value));
        }
          goto _L7
        ((Intent) (obj)).putExtra(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).name, ((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).value);
          goto _L7
_L2:
        return ((Intent) (obj));
        obj;
        banneritem = null;
          goto _L8
    }

    static com.picsart.studio.d a(a a1)
    {
        return a1.G;
    }

    private static com.socialin.android.apiv3.model.NotificationResponse.NotificationItem a(myobfuscated.co.e e1, com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem)
    {
        if (e1 != null && e1.b != null && notificationitem != null) goto _L2; else goto _L1
_L1:
        e1 = null;
_L6:
        return e1;
_L2:
        Iterator iterator = e1.b.iterator();
_L13:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem1;
        notificationitem1 = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)iterator.next();
        if (notificationitem.id == null)
        {
            break; /* Loop/switch isn't completed */
        }
        e1 = notificationitem1;
        if (notificationitem1.id.equals(notificationitem.id)) goto _L6; else goto _L5
_L5:
        e1 = notificationitem.action;
        byte byte0 = -1;
        e1.hashCode();
        JVM INSTR lookupswitch 4: default 299
    //                   -2109581921: 194
    //                   -794646952: 178
    //                   456345042: 210
    //                   492094105: 162;
           goto _L7 _L8 _L9 _L10 _L11
_L16:
        if (notificationitem.user.id != notificationitem1.user.id || notificationitem.item.id != notificationitem1.item.id) goto _L13; else goto _L12
_L12:
        return notificationitem1;
_L11:
        if (e1.equals("friend_like_added"))
        {
            byte0 = 0;
        }
          goto _L7
_L9:
        if (e1.equals("like_added"))
        {
            byte0 = 1;
        }
          goto _L7
_L8:
        if (e1.equals("follower_added"))
        {
            byte0 = 2;
        }
          goto _L7
_L10:
        if (e1.equals("following_added"))
        {
            byte0 = 3;
        }
          goto _L7
_L17:
        if (notificationitem.user.id != notificationitem1.user.id) goto _L13; else goto _L14
_L14:
        return notificationitem1;
_L18:
        if (notificationitem.user.id != notificationitem1.user.id) goto _L13; else goto _L15
_L15:
        long l1;
        long l2;
        l1 = notificationitem.user1.id;
        l2 = notificationitem1.user1.id;
        if (l1 == l2)
        {
            return notificationitem1;
        }
          goto _L13
        e1;
        e1.printStackTrace();
_L4:
        return null;
_L7:
        byte0;
        JVM INSTR tableswitch 0 3: default 332
    //                   0 124
    //                   1 124
    //                   2 226
    //                   3 246;
           goto _L13 _L16 _L16 _L17 _L18
    }

    private static String a(com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem, String s1)
    {
        if (notificationitem.user == null || notificationitem.user.username == null)
        {
            return s1;
        } else
        {
            return notificationitem.user.username;
        }
    }

    private List a(Cursor cursor)
    {
        ArrayList arraylist = new ArrayList();
        try
        {
            if (cursor.moveToFirst())
            {
                do
                {
                    byte abyte0[] = cursor.getBlob(cursor.getColumnIndex("notification_item"));
                    int i1 = cursor.getInt(cursor.getColumnIndex("read"));
                    Object obj = new InputStreamReader(new ByteArrayInputStream(abyte0), com.socialin.android.util.e.a);
                    obj = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)com.socialin.android.c.a().fromJson(((java.io.Reader) (obj)), com/socialin/android/apiv3/model/NotificationResponse$NotificationItem);
                    if ((((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).isKnownType() || ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).checkActionValidity(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).action)) && (!SocialinV3.getInstance().isRegistered() || (((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).user == null || SocialinV3.getInstance().getUser().id != ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).user.id) && (!"following_added".equalsIgnoreCase(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).action) || ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).user1 == null || ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).user1.id != SocialinV3.getInstance().getUser().id)) && (((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).type == null || !((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).type.equalsIgnoreCase("update_available") || ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).getAppLastVersion() > Utils.d(j)) && a(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj))))
                    {
                        obj.read = i1;
                        if (!arraylist.contains(obj))
                        {
                            arraylist.add(obj);
                        }
                    }
                } while (cursor.moveToNext());
                cursor.close();
            }
            cursor = a(((List) (arraylist)));
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            ExceptionReportService.report(j, cursor, String.valueOf(arraylist.size()));
            return null;
        }
        return cursor;
    }

    static List a(a a1, Cursor cursor)
    {
        return a1.a(cursor);
    }

    private List a(List list)
    {
        ArrayList arraylist = new ArrayList();
        if (j != null && !j.isFinishing())
        {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)iterator.next();
                if (notificationitem.isKnownType())
                {
                    Object obj;
                    int i1;
                    if (notificationitem.action.equalsIgnoreCase("facebook_added") || notificationitem.action.equalsIgnoreCase("twitter_added"))
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = 0;
                    }
                    if (i1 != 0)
                    {
                        obj = new myobfuscated.co.e();
                        obj.c = b(notificationitem);
                        obj.b = new ArrayList();
                        ((myobfuscated.co.e) (obj)).b.add(notificationitem);
                        obj.d = notificationitem.read;
                        Object obj1;
                        if (notificationitem.action.equalsIgnoreCase("facebook_added"))
                        {
                            list = "facebook";
                        } else
                        if (notificationitem.action.equalsIgnoreCase("twitter_added"))
                        {
                            list = "twitter";
                        } else
                        {
                            list = "";
                        }
                        obj1 = new SpannableStringBuilder();
                        list = new SpannableString(list);
                        list.setSpan(new StyleSpan(1), 0, list.length(), 17);
                        ((SpannableStringBuilder) (obj1)).append(new SpannableString((new StringBuilder()).append(j.getString(0x7f080374)).append(" ").toString()));
                        ((SpannableStringBuilder) (obj1)).append(list);
                        ((SpannableStringBuilder) (obj1)).append(new SpannableString((new StringBuilder(" ")).append(j.getString(0x7f0802d4)).toString()));
                        if (notificationitem.user != null)
                        {
                            list = notificationitem.user.name;
                        } else
                        {
                            list = "";
                        }
                        if (!TextUtils.isEmpty(list))
                        {
                            list = new SpannableString((new StringBuilder(" ")).append(list).toString());
                            list.setSpan(new StyleSpan(1), 0, list.length(), 17);
                            ((SpannableStringBuilder) (obj1)).append(list);
                        }
                        ((SpannableStringBuilder) (obj1)).append(new SpannableString((new StringBuilder(" ")).append(r).toString()));
                        ((myobfuscated.co.e) (obj)).c.b = ((CharSequence) (obj1));
                        obj1 = ((myobfuscated.co.e) (obj)).c;
                        if (notificationitem.user != null)
                        {
                            list = notificationitem.user.getPhoto();
                        } else
                        {
                            list = null;
                        }
                        obj1.c = list;
                        ((myobfuscated.co.e) (obj)).c.f = 0;
                        if (!((myobfuscated.co.e) (obj)).b.isEmpty() && !arraylist.contains(obj))
                        {
                            arraylist.add(obj);
                        }
                    }
                    if (notificationitem.action.equalsIgnoreCase("follower_added"))
                    {
                        list = a(arraylist, notificationitem);
                        if (list != null)
                        {
                            ((myobfuscated.co.e) (list)).c.a = notificationitem.createdAt;
                        } else
                        {
                            list = new myobfuscated.co.e();
                            list.b = new ArrayList();
                            ((myobfuscated.co.e) (list)).b.add(notificationitem);
                            list.d = notificationitem.read;
                            list.c = b(notificationitem);
                            ((myobfuscated.co.e) (list)).c.f = 0;
                            ((myobfuscated.co.e) (list)).c.b = x;
                            if (!((myobfuscated.co.e) (list)).b.isEmpty() && !arraylist.contains(list))
                            {
                                arraylist.add(list);
                            }
                        }
                    }
                    if ("comment_added".equalsIgnoreCase(notificationitem.action) || "reply_added".equalsIgnoreCase(notificationitem.action) || "mention_added".equalsIgnoreCase(notificationitem.action) || "user_tag_added".equalsIgnoreCase(notificationitem.action))
                    {
                        obj1 = new myobfuscated.co.e();
                        obj1.c = b(notificationitem);
                        obj1.b = new ArrayList();
                        ((myobfuscated.co.e) (obj1)).b.add(notificationitem);
                        obj1.d = notificationitem.read;
                        if ("mention_added".equalsIgnoreCase(notificationitem.action))
                        {
                            list = v;
                        } else
                        if ("reply_added".equalsIgnoreCase(notificationitem.action))
                        {
                            list = t;
                        } else
                        if ("user_tag_added".equalsIgnoreCase(notificationitem.action))
                        {
                            list = w;
                        } else
                        {
                            list = u;
                        }
                        obj = list;
                        if (notificationitem.data != null)
                        {
                            obj = (new StringBuilder()).append(list).append(" \"").append(notificationitem.data).append("\"").toString();
                        }
                        ((myobfuscated.co.e) (obj1)).c.b = ((CharSequence) (obj));
                        obj = ((myobfuscated.co.e) (obj1)).c;
                        if (notificationitem.item != null)
                        {
                            list = notificationitem.item.getThumbUrl();
                        } else
                        {
                            list = null;
                        }
                        obj.c = list;
                        ((myobfuscated.co.e) (obj1)).c.f = 0;
                        if (!((myobfuscated.co.e) (obj1)).b.isEmpty() && !arraylist.contains(obj1))
                        {
                            arraylist.add(obj1);
                        }
                    }
                    if (notificationitem.action.equalsIgnoreCase("following_added"))
                    {
                        list = a(arraylist, notificationitem);
                        if (list != null)
                        {
                            ((myobfuscated.co.e) (list)).c.a = notificationitem.createdAt;
                        } else
                        {
                            obj2 = new myobfuscated.co.e();
                            obj2.c = b(notificationitem);
                            obj2.b = new ArrayList();
                            ((myobfuscated.co.e) (obj2)).b.add(notificationitem);
                            obj2.d = notificationitem.read;
                            ((myobfuscated.co.e) (obj2)).c.f = 0;
                            obj = ((myobfuscated.co.e) (obj2)).c;
                            if (notificationitem.user1 != null)
                            {
                                list = notificationitem.user1.getPhoto();
                            } else
                            {
                                list = null;
                            }
                            obj.c = list;
                            list = "";
                            if (notificationitem.user1 != null)
                            {
                                if (notificationitem.user1.name == null || notificationitem.user1.name.trim().equals(""))
                                {
                                    obj = notificationitem.user1.username;
                                    list = ((List) (obj));
                                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                                    {
                                        list = (new StringBuilder("@")).append(((String) (obj))).toString();
                                    }
                                } else
                                {
                                    list = notificationitem.user1.name;
                                }
                            }
                            list = new SpannableString(list);
                            list.setSpan(new myobfuscated.ct.c(getActivity().getResources().getColor(0x7f0f0091), getActivity().getResources().getColor(0x7f0f0099), notificationitem) {

                                private com.socialin.android.apiv3.model.NotificationResponse.NotificationItem b;
                                private a c;

                                public final void onClick(View view)
                                {
                                    GalleryUtils.a(com.socialin.android.photo.notifications.a.d(c), b.user1, "notifications");
                                }

            
            {
                c = a.this;
                b = notificationitem;
                super(0xff000000, i1, j1, 1);
            }
                            }, 0, list.length(), 17);
                            obj = new SpannableStringBuilder();
                            ((SpannableStringBuilder) (obj)).append(new SpannableString((new StringBuilder()).append(s).append(" ").toString()));
                            ((SpannableStringBuilder) (obj)).append(list);
                            ((myobfuscated.co.e) (obj2)).c.b = ((CharSequence) (obj));
                            if (!arraylist.contains(obj2))
                            {
                                arraylist.add(obj2);
                            }
                        }
                    }
                    if (notificationitem.isSystemType())
                    {
                        list = new myobfuscated.co.e();
                        list.c = b(notificationitem);
                        list.b = new ArrayList();
                        ((myobfuscated.co.e) (list)).b.add(notificationitem);
                        list.d = notificationitem.read;
                        ((myobfuscated.co.e) (list)).c.f = 1;
                        ((myobfuscated.co.e) (list)).c.b = notificationitem.message;
                        if (!arraylist.contains(list))
                        {
                            arraylist.add(list);
                        }
                    }
                    if (notificationitem.action.equalsIgnoreCase("like_added"))
                    {
                        list = a(arraylist, notificationitem);
                        if (list == null)
                        {
                            list = new myobfuscated.co.e();
                            list.c = b(notificationitem);
                            list.b = new ArrayList();
                        }
                        if (a(((myobfuscated.co.e) (list)), notificationitem) == null)
                        {
                            ((myobfuscated.co.e) (list)).b.add(0, notificationitem);
                            ((myobfuscated.co.e) (list)).c.f = 0;
                            ((myobfuscated.co.e) (list)).c.e = c(notificationitem);
                            ((myobfuscated.co.e) (list)).c.d = a(notificationitem, ((myobfuscated.co.e) (list)).c.e);
                            list.d = notificationitem.read;
                            if (!((myobfuscated.co.e) (list)).b.isEmpty())
                            {
                                Collections.sort(((myobfuscated.co.e) (list)).b, new Comparator() {

                                    public final int compare(Object obj3, Object obj4)
                                    {
                                        obj3 = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)obj3;
                                        return (int)(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)obj4).createdAt.getTime() - ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj3)).createdAt.getTime());
                                    }

                                });
                                ((myobfuscated.co.e) (list)).c.a = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)((myobfuscated.co.e) (list)).b.get(0)).createdAt;
                                ((myobfuscated.co.e) (list)).c.c = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)((myobfuscated.co.e) (list)).b.get(0)).item.getThumbUrl();
                                i1 = ((myobfuscated.co.e) (list)).b.size();
                                obj1 = new SpannableStringBuilder();
                                if (i1 > 3)
                                {
                                    if (i1 == 4)
                                    {
                                        obj = (new StringBuilder(" 1 ")).append(j.getString(0x7f0804b5)).toString();
                                    } else
                                    {
                                        obj = (new StringBuilder()).append(i1 - 3).append(" ").append(j.getString(0x7f0804b6)).toString();
                                    }
                                    obj = new SpannableString(((CharSequence) (obj)));
                                    ((SpannableString) (obj)).setSpan(new StyleSpan(1), 0, ((SpannableString) (obj)).length(), 17);
                                    ((SpannableStringBuilder) (obj1)).append(new SpannableString((new StringBuilder(" ")).append(j.getString(0x7f08028b)).append(" ").toString()));
                                    ((SpannableStringBuilder) (obj1)).append(((CharSequence) (obj)));
                                }
                                ((SpannableStringBuilder) (obj1)).append(new SpannableString((new StringBuilder(" ")).append(p).toString()));
                                ((myobfuscated.co.e) (list)).c.b = ((CharSequence) (obj1));
                                if (!arraylist.contains(list))
                                {
                                    arraylist.add(list);
                                }
                            }
                        }
                    }
                    if ("appboy_news".equals(notificationitem.action))
                    {
                        list = new myobfuscated.co.e();
                        list.c = b(notificationitem);
                        ((myobfuscated.co.e) (list)).c.c = notificationitem.data;
                        list.d = notificationitem.read;
                        ((myobfuscated.co.e) (list)).c.b = notificationitem.message;
                        list.b = new ArrayList();
                        ((myobfuscated.co.e) (list)).b.add(notificationitem);
                        arraylist.add(list);
                    }
                    if (notificationitem.action.equalsIgnoreCase("friend_like_added"))
                    {
                        list = a(arraylist, notificationitem);
                        if (list == null)
                        {
                            list = new myobfuscated.co.e();
                            list.c = b(notificationitem);
                            list.b = new ArrayList();
                        }
                        if (a(((myobfuscated.co.e) (list)), notificationitem) == null)
                        {
                            ((myobfuscated.co.e) (list)).b.add(0, notificationitem);
                            ((myobfuscated.co.e) (list)).c.f = 0;
                            list.d = notificationitem.read;
                            if (!((myobfuscated.co.e) (list)).b.isEmpty())
                            {
                                Collections.sort(((myobfuscated.co.e) (list)).b, new Comparator() {

                                    public final int compare(Object obj3, Object obj4)
                                    {
                                        obj3 = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)obj3;
                                        return (int)(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)obj4).createdAt.getTime() - ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj3)).createdAt.getTime());
                                    }

                                });
                                ((myobfuscated.co.e) (list)).c.a = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)((myobfuscated.co.e) (list)).b.get(0)).createdAt;
                                if (((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)((myobfuscated.co.e) (list)).b.get(0)).item != null)
                                {
                                    ((myobfuscated.co.e) (list)).c.c = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)((myobfuscated.co.e) (list)).b.get(0)).item.getThumbUrl();
                                }
                                i1 = ((myobfuscated.co.e) (list)).b.size();
                                obj = new SpannableStringBuilder();
                                Object obj2 = new SpannableString(String.valueOf(i1));
                                ((SpannableString) (obj2)).setSpan(new StyleSpan(1), 0, ((SpannableString) (obj2)).length(), 17);
                                if (i1 == 1)
                                {
                                    ((SpannableStringBuilder) (obj)).append(new SpannableString((new StringBuilder(" ")).append(j.getString(0x7f0804ad)).toString()));
                                } else
                                {
                                    ((SpannableStringBuilder) (obj)).append(new SpannableString((new StringBuilder(" ")).append(j.getString(0x7f0804b1)).append(" ").toString()));
                                    ((SpannableStringBuilder) (obj)).append(new SpannableString(((CharSequence) (obj2))));
                                    ((SpannableStringBuilder) (obj)).append(new SpannableString((new StringBuilder(" ")).append(j.getString(0x7f080323)).append(".").toString()));
                                }
                                ((myobfuscated.co.e) (list)).c.b = ((CharSequence) (obj));
                                if (!arraylist.contains(list))
                                {
                                    arraylist.add(list);
                                }
                            }
                        }
                    }
                    if ("photo_added".equals(notificationitem.action))
                    {
                        a(((List) (arraylist)), a(arraylist, notificationitem), notificationitem, q, j.getString(0x7f08032c), false);
                    }
                    if (notificationitem.action.equalsIgnoreCase("photo_reposted") || notificationitem.action.equalsIgnoreCase("user_photo_reposted"))
                    {
                        obj = a(arraylist, notificationitem);
                        if ("photo_reposted".equals(notificationitem.action))
                        {
                            list = y;
                        } else
                        {
                            list = z;
                        }
                        a(((List) (arraylist)), ((myobfuscated.co.e) (obj)), notificationitem, ((String) (list)), j.getString(0x7f0804b9), "user_photo_reposted".equals(notificationitem.action));
                    }
                }
            }
        }
        return arraylist;
    }

    private static myobfuscated.co.e a(ArrayList arraylist, com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem)
    {
        if (arraylist.isEmpty())
        {
            return null;
        }
        Object obj;
        Object obj1;
        myobfuscated.co.e e1;
        Iterator iterator;
        Iterator iterator1;
        String s1;
        int i1;
        boolean flag;
        long l1;
        long l2;
        if (!notificationitem.action.equals("friend_like_added") && !notificationitem.action.equals("photo_added") && !notificationitem.action.equals("like_added"))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        iterator = arraylist.iterator();
        obj = null;
_L32:
        obj1 = obj;
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        e1 = (myobfuscated.co.e)iterator.next();
        obj1 = obj;
        iterator1 = e1.b.iterator();
_L6:
        arraylist = ((ArrayList) (obj));
        obj1 = obj;
        if (!iterator1.hasNext()) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        arraylist = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)iterator1.next();
        obj1 = obj;
        if (!notificationitem.action.equals(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (arraylist)).action)) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        s1 = notificationitem.action;
        i1 = -1;
        obj1 = obj;
        s1.hashCode();
        JVM INSTR lookupswitch 7: default 670
    //                   -2109581921: 396
    //                   -794646952: 453
    //                   456345042: 472
    //                   492094105: 358
    //                   1182873491: 434
    //                   1427018931: 377
    //                   1538532511: 415;
           goto _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L27:
        obj1 = obj;
        l1 = notificationitem.user.id;
        obj1 = obj;
        l2 = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (arraylist)).user.id;
        if (l1 != l2) goto _L6; else goto _L15
_L15:
        arraylist = e1;
_L4:
        obj = arraylist;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = arraylist;
        if (arraylist == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = arraylist;
        obj = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)((myobfuscated.co.e) (arraylist)).b.get(0);
        i1 = 1;
_L19:
        obj1 = arraylist;
        if (i1 >= ((myobfuscated.co.e) (arraylist)).b.size())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = arraylist;
        if (!((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)((myobfuscated.co.e) (arraylist)).b.get(i1)).createdAt.before(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).createdAt)) goto _L17; else goto _L16
_L16:
        obj1 = arraylist;
        obj = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)((myobfuscated.co.e) (arraylist)).b.get(i1);
_L17:
        i1++;
        if (true) goto _L19; else goto _L18
_L11:
        obj1 = obj;
        if (s1.equals("friend_like_added"))
        {
            i1 = 0;
        }
          goto _L7
_L13:
        obj1 = obj;
        if (s1.equals("photo_added"))
        {
            i1 = 1;
        }
          goto _L7
_L8:
        obj1 = obj;
        if (s1.equals("follower_added"))
        {
            i1 = 2;
        }
          goto _L7
_L14:
        obj1 = obj;
        if (s1.equals("photo_reposted"))
        {
            i1 = 3;
        }
          goto _L7
_L12:
        obj1 = obj;
        if (s1.equals("user_photo_reposted"))
        {
            i1 = 4;
        }
          goto _L7
_L9:
        obj1 = obj;
        if (s1.equals("like_added"))
        {
            i1 = 5;
        }
          goto _L7
_L10:
        obj1 = obj;
        if (s1.equals("following_added"))
        {
            i1 = 6;
        }
          goto _L7
_L28:
        obj1 = obj;
        if (notificationitem.item.id != ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (arraylist)).item.id) goto _L6; else goto _L20
_L20:
        arraylist = e1;
          goto _L4
_L29:
        obj1 = obj;
        if (notificationitem.user.id != ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (arraylist)).user.id) goto _L6; else goto _L21
_L21:
        obj1 = obj;
        l1 = notificationitem.user1.id;
        obj1 = obj;
        l2 = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (arraylist)).user1.id;
        if (l1 != l2) goto _L6; else goto _L22
_L22:
        arraylist = e1;
          goto _L4
_L18:
        obj1 = arraylist;
        l1 = Math.abs(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).createdAt.getTime() - notificationitem.createdAt.getTime());
        obj1 = arraylist;
        l1 = TimeUnit.MILLISECONDS.toSeconds(l1);
        if (l1 > 0x15180L)
        {
            arraylist = null;
        }
        obj = arraylist;
        continue; /* Loop/switch isn't completed */
        obj;
        obj1 = arraylist;
        ((NullPointerException) (obj)).printStackTrace();
        obj = arraylist;
        continue; /* Loop/switch isn't completed */
        arraylist;
        notificationitem = arraylist;
        arraylist = ((ArrayList) (obj1));
_L25:
        notificationitem.printStackTrace();
_L24:
        return arraylist;
_L2:
        arraylist = ((ArrayList) (obj));
        if (true) goto _L24; else goto _L23
_L23:
        notificationitem;
        arraylist = null;
        if (true) goto _L25; else goto _L7
_L7:
        i1;
        JVM INSTR tableswitch 0 6: default 716
    //                   0 224
    //                   1 224
    //                   2 224
    //                   3 224
    //                   4 224
    //                   5 492
    //                   6 518;
           goto _L26 _L27 _L27 _L27 _L27 _L27 _L28 _L29
_L26:
        if (true) goto _L6; else goto _L30
_L30:
        if (true) goto _L32; else goto _L31
_L31:
    }

    private void a(int i1, int j1)
    {
        if (i1 >= 0 && j1 < i.getItemCount()) goto _L2; else goto _L1
_L1:
        return;
_L5:
        i1++;
_L2:
        if (i1 > j1) goto _L1; else goto _L3
_L3:
        if (i.a(i1) == null || i.a(i1).b == null || i.a(i1).b.isEmpty() || i.a(i1).d != 0) goto _L5; else goto _L4
_L4:
        Iterator iterator;
        i.a(i1).d = 1;
        f.d();
        iterator = i.a(i1).b.iterator();
_L8:
        if (!iterator.hasNext()) goto _L5; else goto _L6
_L6:
        String s1;
        s1 = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)iterator.next()).id;
        Intent intent = new Intent(j, com/socialin/android/photo/notifications/NotificationsService);
        intent.setAction("action.mark.as.read");
        intent.putExtra("extra.deleted.ids", s1);
        j.startService(intent);
        if (s1 == null) goto _L8; else goto _L7
_L7:
        if (!s1.contains("appboy")) goto _L8; else goto _L9
_L9:
        Appboy.getInstance(getActivity()).logFeedCardImpression(s1.substring(s1.indexOf('_') + 1, s1.lastIndexOf('_')));
          goto _L8
        Exception exception;
        exception;
        com.socialin.android.d.b(g, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
          goto _L8
    }

    static void a(a a1, int i1, int j1)
    {
        a1.a(i1, j1);
    }

    private void a(List list, int i1)
    {
        if (list == null || list.isEmpty())
        {
            return;
        }
        int k1 = list.size();
        ArrayList arraylist = new ArrayList();
        int j1 = 0;
        while (j1 < k1) 
        {
            ImageItem imageitem;
            if (((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)list.get(j1)).item.origin != null)
            {
                imageitem = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)list.get(j1)).item.origin;
            } else
            {
                imageitem = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)list.get(j1)).item;
            }
            if (imageitem.user == null)
            {
                imageitem.user = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)list.get(j1)).user;
            }
            arraylist.add(imageitem);
            j1++;
        }
        GalleryUtils.a(this, arraylist, i1, ((BaseActivity)getActivity()).getGalleryItemFragmentFrame());
    }

    private void a(List list, myobfuscated.co.e e1, com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem, String s1, String s2, boolean flag)
    {
        myobfuscated.co.e e2 = e1;
        if (e1 == null)
        {
            e2 = new myobfuscated.co.e();
            e2.c = b(notificationitem);
            e2.b = new ArrayList();
        }
        if (a(e2, notificationitem) == null)
        {
            e2.b.add(0, notificationitem);
            e2.c.f = 0;
            e2.d = notificationitem.read;
            if (!e2.b.isEmpty())
            {
                Collections.sort(e2.b, new Comparator() {

                    public final int compare(Object obj, Object obj1)
                    {
                        obj = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)obj;
                        return (int)(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)obj1).createdAt.getTime() - ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).createdAt.getTime());
                    }

                });
                e2.c.a = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)e2.b.get(0)).createdAt;
                e2.c.c = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)e2.b.get(0)).item.getThumbUrl();
                e2.c.a = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)e2.b.get(0)).createdAt;
                if (((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)e2.b.get(0)).item != null)
                {
                    e2.c.c = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)e2.b.get(0)).item.getThumbUrl();
                }
                int i1 = e2.b.size();
                notificationitem = new SpannableStringBuilder();
                e1 = new SpannableString(String.valueOf(i1));
                e1.setSpan(new StyleSpan(1), 0, e1.length(), 17);
                if (i1 == 1)
                {
                    notificationitem.append(new SpannableString((new StringBuilder(" ")).append(s1).toString()));
                } else
                {
                    notificationitem.append(new SpannableString((new StringBuilder(" ")).append(s2).append(" ").toString()));
                    notificationitem.append(new SpannableString(e1));
                    s1 = new StringBuilder(" ");
                    if (flag)
                    {
                        e1 = j.getString(0x7f080310);
                    } else
                    {
                        e1 = j.getString(0x7f080323);
                    }
                    notificationitem.append(new SpannableString(s1.append(e1).append(".").toString()));
                }
                e2.c.b = notificationitem;
                if (!list.contains(e2))
                {
                    list.add(e2);
                }
            }
        }
    }

    private boolean a(com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem)
    {
        for (Iterator iterator = k.keySet().iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            if (s1.equals(notificationitem.action))
            {
                return ((Boolean)k.get(s1)).booleanValue();
            }
        }

        return true;
    }

    static LinearLayoutManager b(a a1)
    {
        return a1.B;
    }

    private static myobfuscated.co.d b(com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem)
    {
        myobfuscated.co.d d1 = new myobfuscated.co.d();
        d1.e = c(notificationitem);
        d1.d = a(notificationitem, d1.e);
        d1.a = notificationitem.createdAt;
        return d1;
    }

    private void b(String s1)
    {
        s1 = new Intent("android.intent.action.VIEW", Uri.parse(s1));
        j.startActivity(s1);
    }

    private static String c(com.socialin.android.apiv3.model.NotificationResponse.NotificationItem notificationitem)
    {
        if (notificationitem.user == null)
        {
            return null;
        } else
        {
            return notificationitem.user.name;
        }
    }

    static void c(a a1)
    {
        a1.i();
    }

    static Activity d(a a1)
    {
        return a1.j;
    }

    static myobfuscated.co.c e(a a1)
    {
        return a1.i;
    }

    static g f(a a1)
    {
        return a1.A;
    }

    static void g(a a1)
    {
        if (a1.i.isEmpty())
        {
            a1.o.setVisibility(0);
            return;
        } else
        {
            a1.o.setVisibility(8);
            return;
        }
    }

    private void h()
    {
        n.setVisibility(8);
        if (m.isRefreshing())
        {
            m.setRefreshing(false);
        }
    }

    static void h(a a1)
    {
        a1.h();
    }

    static com.socialin.android.e i(a a1)
    {
        return a1.f;
    }

    private void i()
    {
        if (n.getVisibility() == 8 && !m.isRefreshing())
        {
            n.setVisibility(0);
        }
    }

    static boolean j(a a1)
    {
        return a1.isAdded() && !a1.isRemoving() && !a1.isDetached();
    }

    public final void a()
    {
        if (getActivity() == null || getActivity().isFinishing() || getView() == null)
        {
            return;
        }
        SharedPreferences sharedpreferences = com.socialin.android.picsart.profile.invite.i.a(j.getApplicationContext());
        View view = getView().findViewById(0x7f1005e3);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            public final void onClick(View view2)
            {
            }

        });
        Object obj2 = getView().findViewById(0x7f100698);
        View view1 = getView().findViewById(0x7f100699);
        Object obj = (TextView)getView().findViewById(0x7f100695);
        Object obj1 = (TextView)getView().findViewById(0x7f100697);
        FrameLayout framelayout = (FrameLayout)getView().findViewById(0x7f100696);
        TextView textview = (TextView)getView().findViewById(0x7f100694);
        if (sharedpreferences.contains("invite.redeem.suspend.start.time"))
        {
            long l3 = sharedpreferences.getLong("invite.redeem.suspend.start.time", 0L);
            long l1 = System.currentTimeMillis() - l3;
            com.socialin.android.d.b(g, new Object[] {
                (new StringBuilder("redeemSuspendTime= ")).append(l3).append(" \ntimeDelay= ").append(l1).append("  \nvalid_period= ").append(com.socialin.android.picsart.profile.invite.i.b()).toString()
            });
            if (l1 >= com.socialin.android.picsart.profile.invite.i.b())
            {
                view.setVisibility(8);
                com.socialin.android.picsart.profile.invite.i.j(getActivity());
                return;
            }
            view.setVisibility(0);
            ((View) (obj2)).setVisibility(0);
            view1.setVisibility(8);
            obj1 = new android.view.View.OnClickListener() {

                private a a;

                public final void onClick(View view2)
                {
                    a.b();
                }

            
            {
                a = a.this;
                super();
            }
            };
            ((View) (obj2)).setOnClickListener(((android.view.View.OnClickListener) (obj1)));
            view.setOnClickListener(((android.view.View.OnClickListener) (obj1)));
            ((TextView) (obj)).setText(0x7f0803be);
            l3 = com.socialin.android.picsart.profile.invite.i.b();
            obj = new ArrayList();
            ((List) (obj)).add(new com.socialin.android.photo.notifications.d(textview, (new StringBuilder("KEY_TIME ")).append(getResources().getString(0x7f0803b4)).toString()));
            if (F != null)
            {
                F.cancel();
            }
            F = new com.socialin.android.photo.notifications.b(this, l3 - l1, ((List) (obj)), view);
            F.start();
            return;
        }
        if (sharedpreferences.contains("invite.redeem.start.time"))
        {
            long l2 = sharedpreferences.getLong("invite.redeem.start.time", 0L);
            l2 = System.currentTimeMillis() - l2;
            if (l2 >= com.socialin.android.picsart.profile.invite.i.c())
            {
                view.setVisibility(8);
                NotificationInviteService.a(getActivity());
                return;
            }
            view.setVisibility(0);
            ((View) (obj2)).setVisibility(8);
            view1.setVisibility(0);
            obj2 = new android.view.View.OnClickListener() {

                private a a;

                public final void onClick(View view2)
                {
                    com.socialin.android.picsart.profile.invite.i.a(a, "ad_remover", EventParam.NOTIFICATIONS.getName(), com.socialin.android.constants.CommonConstants.InviteMode.AD_REMOVER);
                }

            
            {
                a = a.this;
                super();
            }
            };
            view1.setOnClickListener(((android.view.View.OnClickListener) (obj2)));
            view.setOnClickListener(((android.view.View.OnClickListener) (obj2)));
            long l4 = com.socialin.android.picsart.profile.invite.i.c();
            obj2 = new ArrayList();
            ((List) (obj2)).add(new com.socialin.android.photo.notifications.d(textview, (new StringBuilder("KEY_TIME ")).append(getResources().getString(0x7f0803b7)).toString()));
            ((List) (obj2)).add(new com.socialin.android.photo.notifications.d(((TextView) (obj1)), (new StringBuilder("\000 \000 \000 \000 \000 \000 \0")).append(getString(0x7f0803bc, new Object[] {
                "KEY_TIME"
            })).toString()));
            if (F != null)
            {
                F.cancel();
            }
            F = new com.socialin.android.photo.notifications.b(this, l4 - l2, ((List) (obj2)), view);
            F.start();
            ((TextView) (obj)).setText(getString(0x7f0803bd, new Object[] {
                String.valueOf(com.socialin.android.picsart.profile.invite.i.d())
            }));
            framelayout.setVisibility(0);
            return;
        } else
        {
            view.setVisibility(8);
            return;
        }
    }

    public final transient void a(int i1, ItemControl itemcontrol, Object aobj[])
    {
        Object obj = i.a(i1);
        final class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[ItemControl.values().length];
                try
                {
                    a[ItemControl.COMMENT_IMAGE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[ItemControl.OWNER_NAME_TEXT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[ItemControl.FOLLOW_USER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[ItemControl.OWNER_IMAGE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[ItemControl.IMAGE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[ItemControl.APPBOY_NEWS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        Object obj1;
        String s1;
        if (obj != null && ((myobfuscated.co.e) (obj)).b != null)
        {
            obj1 = ((myobfuscated.co.e) (obj)).b;
            obj = (com.socialin.android.apiv3.model.NotificationResponse.NotificationItem)((List) (obj1)).get(0);
        } else
        {
            obj = null;
            obj1 = null;
        }
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        s1 = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).action;
        if (SocialinV3.getInstance().getUser().id > 1L)
        {
            AnalyticUtils.getInstance(j).track(new com.socialin.android.apiv3.events.EventsFactory.NotificationsClickEvent(SocialinV3.getInstance().getUser().id, s1));
        }
        if (!((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).isSystemType())
        {
            break MISSING_BLOCK_LABEL_329;
        }
        obj1 = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).type;
        if (((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).sysParams == null)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        itemcontrol = ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).sysParams.actionUrl;
_L5:
        aobj = itemcontrol;
        if (!"open_url".equalsIgnoreCase(s1))
        {
            break MISSING_BLOCK_LABEL_184;
        }
        aobj = itemcontrol;
        if (itemcontrol == null)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        aobj = itemcontrol;
        if (!itemcontrol.startsWith("http://"))
        {
            aobj = (new StringBuilder("http://")).append(itemcontrol).toString();
        }
        b(((String) (aobj)));
        if (!"open_deep_linking".equalsIgnoreCase(s1) || aobj == null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        b(((String) (aobj)));
        if (!"start_activity".equalsIgnoreCase(s1))
        {
            break MISSING_BLOCK_LABEL_237;
        }
        itemcontrol = a(((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).sysParams);
        if (itemcontrol != null)
        {
            try
            {
                j.startActivity(itemcontrol);
            }
            // Misplaced declaration of an exception variable
            catch (ItemControl itemcontrol)
            {
                com.socialin.android.d.b(g, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(itemcontrol.getMessage()).toString()
                });
                return;
            }
        }
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if ("info_sys_notice".equalsIgnoreCase(((String) (obj1))))
        {
            myobfuscated.f.m.c(j, ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).id);
        }
        if (obj1 == null) goto _L1; else goto _L3
_L3:
        if (!"update_available".equalsIgnoreCase(((String) (obj1)))) goto _L1; else goto _L4
_L4:
        myobfuscated.cv.c.a(j);
        return;
        itemcontrol = null;
          goto _L5
        switch (_cls3.a[itemcontrol.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (aobj[0] != null)
            {
                itemcontrol = new Intent(j, com/socialin/android/picsart/profile/activity/CommentImageZoomActivity);
                itemcontrol.putExtra("url", aobj[0].toString());
                j.startActivity(itemcontrol);
                return;
            }
            break;

        case 2: // '\002'
            if (aobj[0] != null && (aobj[0] instanceof ViewerUser))
            {
                GalleryUtils.a(j, (ViewerUser)aobj[0], "notifications");
                return;
            }
            break;

        case 3: // '\003'
            GalleryUtils.a(j, ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).user1, "notifications");
            return;

        case 4: // '\004'
            GalleryUtils.a(j, ((com.socialin.android.apiv3.model.NotificationResponse.NotificationItem) (obj)).user, "notifications");
            return;

        case 5: // '\005'
            if (aobj[0] != null)
            {
                i1 = Integer.parseInt(aobj[0].toString());
                if ("like_added".equals(s1) || "photo_reposted".equals(s1) || "user_photo_reposted".equals(s1))
                {
                    ((List) (obj1)).clear();
                    ((List) (obj1)).add(obj);
                }
                a(((List) (obj1)), i1);
                return;
            }
            break;

        case 6: // '\006'
            itemcontrol = new Intent("android.intent.action.VIEW");
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L6
_L6:
        if (aobj[0] == null || aobj[0].toString() == null) goto _L1; else goto _L7
_L7:
        itemcontrol.setData(Uri.parse(aobj[0].toString()));
        startActivity(itemcontrol);
        return;
    }

    public final void a(String s1)
    {
        Intent intent = new Intent(j, com/socialin/android/photo/notifications/NotificationsService);
        intent.setAction(s1);
        j.startService(intent);
    }

    public final void a(boolean flag)
    {
        if (flag)
        {
            a();
        }
    }

    public final void b()
    {
        if (SocialinV3.getInstance().isRegistered())
        {
            if (!Inventory.isAdsEnabled() || !Inventory.isEditorAdsEnabled())
            {
                com.socialin.android.picsart.profile.invite.i.e(getActivity());
                a(true);
                return;
            } else
            {
                com.socialin.android.picsart.profile.invite.i.a(getActivity(), EventParam.NOTIFICATIONS.getName(), this);
                return;
            }
        } else
        {
            com.socialin.android.picsart.profile.invite.i.a(this, com.socialin.android.constants.CommonConstants.InviteMode.AD_REMOVER, EventParam.NOTIFICATIONS.getName());
            return;
        }
    }

    public final void c()
    {
        if (i != null && i.getItemCount() > 0 && B != null && f != null && f.c())
        {
            a(B.findFirstCompletelyVisibleItemPosition(), B.findLastCompletelyVisibleItemPosition());
        }
    }

    public final void d()
    {
        if (!isAdded() || j.isFinishing())
        {
            return;
        }
        if (!com.socialin.android.util.s.a(j))
        {
            Utils.a(j, 0x7f080424);
            h();
            return;
        } else
        {
            i();
            a("action.refresh");
            return;
        }
    }

    public final void e()
    {
        D = new an() {

            private a a;

            protected final Object doInBackground(Object aobj[])
            {
                if (com.socialin.android.photo.notifications.a.d(a) != null && !com.socialin.android.photo.notifications.a.d(a).isFinishing() && a.isAdded())
                {
                    if ((aobj = com.socialin.android.photo.notifications.a.d(a).getContentResolver().query(com.socialin.android.photo.database.b.a, null, null, null, null)) != null)
                    {
                        List list = a.a(a, ((Cursor) (aobj)));
                        ((Cursor) (aobj)).close();
                        return list;
                    }
                }
                return null;
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (List)obj;
                if (com.socialin.android.photo.notifications.a.d(a) == null || com.socialin.android.photo.notifications.a.d(a).isFinishing() || !a.isAdded() || com.socialin.android.photo.notifications.a.e(a) == null || obj == null)
                {
                    return;
                }
                if (com.socialin.android.photo.notifications.a.f(a) != null)
                {
                    com.socialin.android.photo.notifications.a.f(a).setItems(((List) (obj)));
                } else
                {
                    com.socialin.android.photo.notifications.a.e(a).setItems(((List) (obj)));
                }
                com.socialin.android.photo.notifications.a.g(a);
                a.c();
                a.h(a);
            }

            protected final void onPreExecute()
            {
                super.onPreExecute();
                com.socialin.android.photo.notifications.a.c(a);
            }

            
            {
                a = a.this;
                super();
            }
        };
        D.a(new Void[0]);
    }

    public final void f()
    {
    }

    public final void g()
    {
        if (A != null && Inventory.isAdsEnabled())
        {
            com.socialin.android.apiv3.model.AppProps.AdType adtype = com.socialin.android.picsart.profile.fragment.a.a(com.socialin.android.apiv3.model.AppProps.TabAdType.NOTIFICATIONS);
            A.setAdapterConfigs(adtype, E);
            A.loadNativeAds(null);
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 == -1 && i1 == 1122)
        {
            b();
        }
        if (i1 == 1125)
        {
            a();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        j = activity;
        h = getString(myobfuscated.f.m.e(j, "app_name_short"));
        G = new com.picsart.studio.d(j.getApplicationContext());
        p = getString(0x7f0804b2);
        q = getString(0x7f0804b7);
        r = getString(0x7f0804b0);
        s = getString(0x7f0802e9);
        t = getString(0x7f0804b8);
        u = getString(0x7f0804ae);
        v = getString(0x7f0804b3);
        w = getString(0x7f0804b4);
        x = getString(0x7f0804af);
        y = getString(0x7f0804ba);
        z = getString(0x7f0804bb);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030111, viewgroup, false);
        l = (RecyclerView)layoutinflater.findViewById(0x7f100260);
        n = layoutinflater.findViewById(0x7f1005e5);
        m = (SwipeRefreshLayout)layoutinflater.findViewById(0x7f1005e4);
        o = layoutinflater.findViewById(0x7f1005e6);
        if (i == null || l == null)
        {
            i = new myobfuscated.co.c(j, f);
            i.setOnItemClickListener(this);
            E = com.socialin.android.picsart.profile.util.y.a(getActivity().getApplicationContext());
            A = myobfuscated.f.m.a(getActivity(), i);
            l.setRecyclerListener(new android.support.v7.widget.RecyclerView.RecyclerListener() {

                private a a;

                public final void onViewRecycled(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
                {
                    if (viewholder instanceof f)
                    {
                        viewholder = (f)viewholder;
                        if (viewholder != null && ((f) (viewholder)).c != null)
                        {
                            com.bumptech.glide.b.b(a.a(a).a).a(((f) (viewholder)).c);
                        }
                    }
                }

            
            {
                a = a.this;
                super();
            }
            });
            if (A != null)
            {
                l.setAdapter(A);
            } else
            {
                l.setAdapter(i);
            }
            B = new LinearLayoutManager(j, 1, false);
            l.setLayoutManager(B);
            l.setOnScrollListener(new android.support.v7.widget.RecyclerView.OnScrollListener() {

                private a a;

                public final void onScrollStateChanged(RecyclerView recyclerview, int i1)
                {
                    super.onScrollStateChanged(recyclerview, i1);
                    switch (i1)
                    {
                    default:
                        com.bumptech.glide.b.b(a.a(a).a).a();
                        return;

                    case 0: // '\0'
                        a.a(a, com.socialin.android.photo.notifications.a.b(a).findFirstCompletelyVisibleItemPosition(), com.socialin.android.photo.notifications.a.b(a).findLastCompletelyVisibleItemPosition());
                        break;
                    }
                    com.bumptech.glide.b.b(a.a(a).a).c();
                }

            
            {
                a = a.this;
                super();
            }
            });
            m.setOnRefreshListener(this);
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (D != null)
        {
            D.cancel(true);
        }
        if (A != null)
        {
            A.destroyAds();
        }
    }

    public void onPause()
    {
        super.onPause();
        j.unregisterReceiver(C);
        if (F != null)
        {
            F.cancel();
        }
    }

    public void onRefresh()
    {
        d();
    }

    public void onResume()
    {
        super.onResume();
        SharedPreferences sharedpreferences = j.getSharedPreferences((new StringBuilder("sinPref_")).append(h).toString(), 0);
        k = new HashMap();
        k.put("friend_like_added", Boolean.valueOf(sharedpreferences.getBoolean("notifications_enable_likes", true)));
        k.put("like_added", Boolean.valueOf(sharedpreferences.getBoolean("notifications_enable_likes_me", true)));
        k.put("comment_added", Boolean.valueOf(sharedpreferences.getBoolean("notifications_enable_comments", true)));
        k.put("mention_added", Boolean.valueOf(sharedpreferences.getBoolean("notifications_enable_mention", true)));
        k.put("user_tag_added", Boolean.valueOf(sharedpreferences.getBoolean("notifications_enable_mention", true)));
        k.put("photo_added", Boolean.valueOf(sharedpreferences.getBoolean("notifications_enable_publishs", true)));
        k.put("facebook_added", Boolean.valueOf(sharedpreferences.getBoolean("enable_facebook_notifications", true)));
        k.put("twitter_added", Boolean.valueOf(sharedpreferences.getBoolean("enable_twitter_notifications", true)));
        k.put("following_added", Boolean.valueOf(sharedpreferences.getBoolean("notifications_enable_follow", true)));
        k.put("follower_added", Boolean.valueOf(sharedpreferences.getBoolean("notifications_enable_follow_me", true)));
        k.put("user_photo_reposted", Boolean.valueOf(sharedpreferences.getBoolean("notifications_enable_reposts_me", true)));
        k.put("photo_reposted", Boolean.valueOf(sharedpreferences.getBoolean("notifications_enable_reposts_other", true)));
        k.put("appboy_news", Boolean.valueOf(true));
        if (i.isEmpty())
        {
            e();
        }
        j.registerReceiver(C, new IntentFilter("com.picsart.studio.notification.action"));
    }

}
