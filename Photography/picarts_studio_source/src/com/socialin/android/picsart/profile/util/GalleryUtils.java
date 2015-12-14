// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.util;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.studio.profile.ProfileActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Stream;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.model.card.Card;
import com.socialin.android.apiv3.request.ReportParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.g;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.googleplus.a;
import com.socialin.android.picsart.profile.activity.ActionShareInfoActivity;
import com.socialin.android.picsart.profile.activity.GalleryItemShowActivity;
import com.socialin.android.picsart.profile.activity.MemboxItemsActivity;
import com.socialin.android.picsart.profile.activity.SliderActivity;
import com.socialin.android.picsart.profile.activity.TopTagsActivity;
import com.socialin.android.picsart.profile.activity.WebViewActivity;
import com.socialin.android.picsart.profile.fragment.aa;
import com.socialin.android.util.Utils;
import com.socialin.android.util.al;
import com.socialin.android.util.s;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import myobfuscated.cv.c;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.picsart.profile.util:
//            r, y, v, t, 
//            s, u

public class GalleryUtils
{

    public static final int a = 0x7f040043;
    private static String b = (new StringBuilder()).append(com/socialin/android/picsart/profile/util/GalleryUtils.getSimpleName()).append(" - ").toString();
    private static String c = null;

    public GalleryUtils()
    {
    }

    public static SpannableStringBuilder a(Activity activity, String as[], String s1, int i, int j)
    {
        String as1[] = a(as, s1);
        if (as1 != null && as1.length > 0)
        {
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            int l = as1.length;
            for (int k = 0; k < l; k++)
            {
                s1 = as1[k];
                as = s1;
                if (!s1.startsWith("#"))
                {
                    as = (new StringBuilder("#")).append(s1).toString();
                }
                spannablestringbuilder.append(c(as, activity, 0xff000000, i, j));
            }

            return spannablestringbuilder;
        } else
        {
            return null;
        }
    }

    public static SpannableStringBuilder a(String s1, Activity activity)
    {
        return a(s1, activity, -1, activity.getResources().getColor(0x7f0f0039), activity.getResources().getColor(0x7f0f00ee));
    }

    public static SpannableStringBuilder a(String s1, Activity activity, int i, int j, int k)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (s1 != null)
        {
            s1 = s1.replaceAll("\n", " \n").split(" ");
            int k1 = s1.length;
            int l = 0;
            while (l < k1) 
            {
                Object obj = s1[l];
                String s2 = ((String) (obj)).toLowerCase();
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    if (s2.equals("http://") || s2.equals("www.") || s2.equals("@") || s2.equals("#"))
                    {
                        spannablestringbuilder.append(new SpannableString((new StringBuilder()).append(((String) (obj))).append(" ").toString()));
                    } else
                    if (s2.equals("\nhttp://") || s2.equals("\nwww.") || s2.equals("\n@") || s2.equals("\n#"))
                    {
                        spannablestringbuilder.append("\n");
                        spannablestringbuilder.append(new SpannableString((new StringBuilder()).append(((String) (obj)).substring(2)).append(" ").toString()));
                    } else
                    if (((String) (obj)).startsWith("@") || ((String) (obj)).startsWith("\n@"))
                    {
                        obj = ((String) (obj)).split("@");
                        int l1 = obj.length;
                        int i1 = 0;
                        while (i1 < l1) 
                        {
                            s2 = obj[i1];
                            if (s2 != null && s2.trim().length() > 0)
                            {
                                spannablestringbuilder.append(b((new StringBuilder("@")).append(s2).toString(), activity, i, j, k));
                            }
                            i1++;
                        }
                    } else
                    if (((String) (obj)).startsWith("#") || ((String) (obj)).startsWith("\n#"))
                    {
                        obj = ((String) (obj)).split("#");
                        int i2 = obj.length;
                        int j1 = 0;
                        while (j1 < i2) 
                        {
                            s2 = obj[j1];
                            if (s2 != null && s2.trim().length() > 0)
                            {
                                spannablestringbuilder.append(c((new StringBuilder("#")).append(s2).toString(), activity, i, j, k));
                            }
                            j1++;
                        }
                    } else
                    if (s2.startsWith("http://") || s2.startsWith("www.") || s2.startsWith("\nhttp://") || s2.startsWith("\nwww."))
                    {
                        SpannableString spannablestring = new SpannableString((new StringBuilder()).append(((String) (obj))).append(" ").toString());
                        spannablestring.setSpan(new _cls4(j, k, ((String) (obj)), activity), 0, spannablestring.length(), 33);
                        spannablestringbuilder.append(spannablestring);
                    } else
                    if (((String) (obj)).contains("#"))
                    {
                        a(((String) (obj)), spannablestringbuilder, activity, i, j, k);
                    } else
                    if (((String) (obj)).contains("@"))
                    {
                        b(((String) (obj)), spannablestringbuilder, activity, i, j, k);
                    } else
                    {
                        spannablestringbuilder.append(new SpannableString((new StringBuilder()).append(((String) (obj))).append(" ").toString()));
                    }
                }
                l++;
            }
        }
        return spannablestringbuilder;
    }

    public static r a(Parcelable aparcelable[], int i)
    {
        Parcelable aparcelable1[];
        int j;
        int k;
        int l;
        int i1;
        boolean flag = false;
        int j1 = aparcelable.length;
        if (i < 200)
        {
            k = 0;
        } else
        {
            k = i - 200;
        }
        if (i + 200 > j1)
        {
            l = j1;
        } else
        {
            l = i + 200;
        }
        aparcelable1 = new Parcelable[400];
        i1 = k;
        if (l - k >= 400) goto _L2; else goto _L1
_L1:
        j = k;
        if (k != 0)
        {
            if (k - (400 - (l - k)) < 0)
            {
                j = 0;
            } else
            {
                j = k - (400 - (l - k));
            }
        }
        i1 = j;
        if (l - j >= 400) goto _L2; else goto _L3
_L3:
        if ((400 - (l - j)) + l > j1)
        {
            k = j1;
        } else
        {
            k = (400 - (l - j)) + l;
        }
        l = k;
_L5:
        k = j;
        i1 = ((flag) ? 1 : 0);
        for (; k < l; k++)
        {
            aparcelable1[i1] = aparcelable[k];
            i1++;
        }

        aparcelable = new r();
        aparcelable.a = aparcelable1;
        aparcelable.b = i - j;
        return aparcelable;
_L2:
        j = i1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String a(int i, Context context)
    {
        return a(i, context, false);
    }

    public static String a(int i, Context context, boolean flag)
    {
        Object obj = "";
        if (context != null)
        {
            long l = (long)i * 1L;
            long l1 = l / 60L;
            long l2 = l1 / 60L;
            long l3 = l2 / 24L;
            if (l3 > 0L)
            {
                if (l3 == 1L)
                {
                    if (l2 > 0L)
                    {
                        obj = (new StringBuilder()).append(l2).append(" ");
                        if (flag)
                        {
                            context = context.getString(0x7f0802de);
                        } else
                        {
                            context = context.getString(0x7f0802dc);
                        }
                        return ((StringBuilder) (obj)).append(context).toString();
                    }
                    if (flag)
                    {
                        return context.getString(0x7f080313);
                    } else
                    {
                        return context.getString(0x7f080312);
                    }
                }
                obj = (new StringBuilder()).append(l3).append(" ");
                if (flag)
                {
                    context = context.getString(0x7f0802b1);
                } else
                {
                    context = context.getString(0x7f0802b0);
                }
                return ((StringBuilder) (obj)).append(context).toString();
            }
            if (l2 > 0L)
            {
                if (l2 == 1L)
                {
                    if (l1 > 0L)
                    {
                        String s1;
                        if (flag)
                        {
                            obj = context.getString(0x7f080317);
                        } else
                        {
                            obj = context.getString(0x7f080316);
                        }
                        if (flag)
                        {
                            s1 = context.getString(0x7f080302);
                        } else
                        {
                            s1 = context.getString(0x7f080301);
                        }
                        if (l1 != 1L)
                        {
                            obj = (new StringBuilder()).append(l1).append(" ").append(s1).toString();
                        }
                        if (l1 == 60L)
                        {
                            if (flag)
                            {
                                return context.getString(0x7f080315);
                            } else
                            {
                                return context.getString(0x7f080314);
                            }
                        }
                    } else
                    {
                        if (l > 0L)
                        {
                            if (l == 1L)
                            {
                                return context.getString(0x7f080318);
                            } else
                            {
                                return (new StringBuilder()).append(l).append(" ").append(context.getString(0x7f080344)).toString();
                            }
                        }
                        if (flag)
                        {
                            return context.getString(0x7f080315);
                        } else
                        {
                            return context.getString(0x7f080314);
                        }
                    }
                } else
                {
                    StringBuilder stringbuilder = (new StringBuilder()).append(l2);
                    if (flag)
                    {
                        context = context.getString(0x7f0802de);
                    } else
                    {
                        context = (new StringBuilder(" ")).append(context.getString(0x7f0802dc)).toString();
                    }
                    return stringbuilder.append(context).toString();
                }
            } else
            {
                if (l1 > 0L)
                {
                    StringBuilder stringbuilder1 = (new StringBuilder()).append(l1);
                    if (flag)
                    {
                        context = context.getString(0x7f080302);
                    } else
                    {
                        context = (new StringBuilder(" ")).append(context.getString(0x7f080301)).toString();
                    }
                    return stringbuilder1.append(context).toString();
                }
                if (l > 0L)
                {
                    StringBuilder stringbuilder2 = (new StringBuilder()).append(l);
                    if (flag)
                    {
                        context = context.getString(0x7f080345);
                    } else
                    {
                        context = (new StringBuilder(" ")).append(context.getString(0x7f080344)).toString();
                    }
                    return stringbuilder2.append(context).toString();
                } else
                {
                    return context.getString(0x7f08030d);
                }
            }
        }
        return ((String) (obj));
    }

    private static String a(Context context)
    {
        if (c == null)
        {
            c = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0808c0)).append("/").append(context.getString(0x7f0808f4)).append("/").toString();
        }
        return c;
    }

    public static String a(Context context, String s1)
    {
        if (s1 == null)
        {
            return "";
        } else
        {
            return (new StringBuilder()).append(a(context)).append(al.a(s1)).append("_thumb").toString();
        }
    }

    public static String a(Context context, String s1, String s2)
    {
        if (s1 == null)
        {
            return "";
        }
        context = (new StringBuilder()).append(a(context)).append(s1).append("_thumb");
        if (s2 == null)
        {
            s2 = "";
        }
        return context.append(s2).toString();
    }

    public static String a(Adress adress)
    {
        String s1 = "";
        Object obj = s1;
        if (adress != null)
        {
            obj = s1;
            if (adress.street != null)
            {
                obj = s1;
                if (!"null".equals(adress.street))
                {
                    obj = adress.street;
                }
            }
            obj = (new StringBuilder()).append(((String) (obj)));
            if (adress.place != null && !adress.place.equals(""))
            {
                s1 = adress.place;
            } else
            {
                s1 = "";
            }
            s1 = ((StringBuilder) (obj)).append(s1).toString();
            obj = (new StringBuilder()).append(s1);
            if (adress.city != null && !adress.city.equals(""))
            {
                StringBuilder stringbuilder = new StringBuilder();
                if (s1.equals(""))
                {
                    s1 = "";
                } else
                {
                    s1 = ",";
                }
                s1 = stringbuilder.append(s1).append(adress.city).toString();
            } else
            {
                s1 = "";
            }
            s1 = ((StringBuilder) (obj)).append(s1).toString();
            obj = (new StringBuilder()).append(s1);
            if (adress.country != null && !adress.country.equals(""))
            {
                stringbuilder = new StringBuilder();
                if (s1.equals(""))
                {
                    s1 = "";
                } else
                {
                    s1 = ",";
                }
                adress = stringbuilder.append(s1).append(adress.country).toString();
            } else
            {
                adress = "";
            }
            obj = ((StringBuilder) (obj)).append(adress).toString();
        }
        return ((String) (obj));
    }

    public static String a(String s1)
    {
        s1 = b(s1);
        StringBuilder stringbuilder = new StringBuilder("");
        for (int i = 0; i < s1.size(); i++)
        {
            stringbuilder.append((String)s1.get(i)).append(",");
        }

        return stringbuilder.substring(0, Math.max(0, stringbuilder.length() - 1));
    }

    public static String a(Date date, Context context)
    {
        return b(date, context);
    }

    private static String a(Date date, SimpleDateFormat simpledateformat, int i, int j, int k, int l, int i1, Context context)
    {
_L2:
        do
        {
            return s1;
        } while (i1 < 2 || i1 < 0);
        return (new StringBuilder()).append(i1).append("").append(context.getString(0x7f080345)).toString();
        String s1 = context.getString(0x7f0802ea);
        String s2 = context.getString(0x7f08028e);
        (new StringBuilder(", ")).append(s2).append(" ");
        s2 = context.getString(0x7f0802b1);
        date = simpledateformat.format(date);
        if (i == 0)
        {
            if (j == 0)
            {
                if (k == 0)
                {
                    if (l == 0)
                    {
                        break MISSING_BLOCK_LABEL_74;
                    } else
                    {
                        if (l >= 0)
                        {
                            return (new StringBuilder()).append(l).append("").append(context.getString(0x7f080302)).toString();
                        }
                        continue; /* Loop/switch isn't completed */
                    }
                } else
                {
                    if (k >= 0)
                    {
                        return (new StringBuilder()).append(k).append("").append(context.getString(0x7f0802dd)).toString();
                    }
                    continue; /* Loop/switch isn't completed */
                }
            } else
            {
                if (j >= 0)
                {
                    return (new StringBuilder()).append(j).append(context.getString(0x7f0802b1)).append("").toString();
                }
                continue; /* Loop/switch isn't completed */
            }
        }
        if (i >= 0)
        {
            if (i == 1)
            {
                date = (new StringBuilder(" ")).append(j).append("").append(s2).toString();
                return (new StringBuilder()).append(date).append("").toString();
            } else
            {
                return date;
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Calendar a(String s1, Calendar calendar)
    {
        s1 = TimeZone.getTimeZone(s1);
        int i = s1.getOffset(calendar.getTimeInMillis());
        s1 = new GregorianCalendar(s1);
        s1.setTimeInMillis(calendar.getTimeInMillis());
        s1.add(14, i);
        return s1;
    }

    public static void a(Activity activity)
    {
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
            DialogUtils.showNoNetworkDialog(activity, 0x7f080307, 0x7f080306, 0x7f080308, 0x7f0802a4, 0x108009b);
            return;
        } else
        {
            activity.runOnUiThread(new _cls1(activity));
            return;
        }
    }

    public static void a(Activity activity, int i, ViewerUser vieweruser, long l, String s1, String s2, String s3, 
            JSONObject jsonobject)
    {
        if (jsonobject != null)
        {
            AnalyticUtils.getInstance(activity.getApplicationContext()).track((new com.socialin.android.apiv3.events.EventsFactory.ProfileOpenEvent(s3, l)).setExtras(jsonobject));
        } else
        {
            AnalyticUtils.getInstance(activity.getApplicationContext()).track(new com.socialin.android.apiv3.events.EventsFactory.ProfileOpenEvent(s3, l));
        }
        if (!s.a(activity))
        {
            a(activity);
            return;
        }
        if (vieweruser == null && l < 0L && TextUtils.isEmpty(s1))
        {
            Utils.a(activity, 0x7f0805cb);
            return;
        }
        s3 = new Intent(activity, com/picsart/studio/profile/ProfileActivity);
        if (activity.getIntent() != null)
        {
            myobfuscated.cv.c.a(s3, activity);
        }
        s3.addCategory("android.intent.category.DEFAULT");
        s3.putExtra("from", "publicStream");
        if (s3.hasExtra("profileUser"))
        {
            s3.removeExtra("profileUser");
        }
        if (s3.hasExtra("profileUserId"))
        {
            s3.removeExtra("profileUserId");
        }
        if (s3.hasExtra("profileUserName"))
        {
            s3.removeExtra("profileUserName");
        }
        if (vieweruser != null)
        {
            s3.putExtra("profileUser", vieweruser);
        }
        if (l > 0L)
        {
            s3.putExtra("profileUserId", l);
        }
        if (!TextUtils.isEmpty(s1))
        {
            s3.putExtra("profileUserName", s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            s3.putExtra("profileTab", s2);
        }
        if (i > 0)
        {
            activity.startActivityForResult(s3, i);
            return;
        } else
        {
            activity.startActivity(s3);
            return;
        }
    }

    public static void a(Activity activity, long l, String s1, String s2)
    {
        a(activity, 0, ((ViewerUser) (null)), l, ((String) (null)), s1, s2, ((JSONObject) (null)));
    }

    public static void a(Activity activity, Parcelable parcelable, String s1, String s2)
    {
        Intent intent = new Intent(activity, com/socialin/android/picsart/profile/activity/ActionShareInfoActivity);
        intent.putExtra("title", activity.getString(0x7f08058b));
        intent.putExtra("message", s2);
        intent.putExtra("send_to", "share_facebook");
        intent.putExtra("action", s1);
        intent.putExtra("item", parcelable);
        activity.startActivityForResult(intent, 4549);
    }

    public static void a(Activity activity, ImageItem imageitem)
    {
        if (activity != null && !activity.isFinishing())
        {
            Intent intent = new Intent(activity, com/socialin/android/picsart/profile/activity/GalleryItemShowActivity);
            if (activity.getIntent() != null && activity.getIntent().getExtras() != null)
            {
                intent.putExtras(activity.getIntent().getExtras());
            }
            intent.putExtra("item_position", 0);
            intent.putExtra("all_items", new Parcelable[] {
                imageitem
            });
            activity.startActivityForResult(intent, 0);
        }
    }

    public static void a(Activity activity, ImageItem imageitem, String s1)
    {
        String s2 = (new StringBuilder("http://picsart.com/i/")).append(imageitem.id).toString();
        imageitem = FacebookUtils.getPhotoOGParams(imageitem.width, imageitem.height, imageitem.getSmallUrl());
        FacebookUtils.checkAndSendPhotoAction(activity, s1, (new StringBuilder()).append(s2).append(imageitem).toString());
    }

    public static void a(Activity activity, ImageItem imageitem, String s1, v v1)
    {
        if (!com.socialin.android.picsart.profile.util.y.c(activity))
        {
            return;
        }
        BaseSocialinApiRequestController basesocialinapirequestcontroller = RequestControllerFactory.createReportItemController();
        ReportParams reportparams = new ReportParams();
        g g1 = g.a(activity, "Report is sending...", true);
        if (imageitem.origin != null)
        {
            reportparams.itemId = imageitem.origin.id;
        } else
        {
            reportparams.itemId = imageitem.id;
        }
        reportparams.type = s1;
        if (v1 != null)
        {
            reportparams.materialUrl = v1.a;
            reportparams.description = v1.b;
            reportparams.firstName = v1.c;
            reportparams.lastName = v1.d;
            reportparams.address = v1.e;
            reportparams.phone = v1.f;
            reportparams.email = v1.g;
            reportparams.isOwner = v1.h;
            reportparams.isAccurate = v1.i;
            reportparams.signature = v1.j;
        }
        basesocialinapirequestcontroller.setRequestParams(reportparams);
        basesocialinapirequestcontroller.setRequestCompleteListener(new _cls5(activity, g1, imageitem, s1));
        basesocialinapirequestcontroller.doRequest("reportItem", reportparams);
    }

    public static void a(Activity activity, ViewerUser vieweruser)
    {
        FacebookUtils.checkAndPostStoryWithProfile(activity, "og.follows", (new StringBuilder("http://")).append(vieweruser.username).append(".picsart.com?target_user_id=").append(vieweruser.id).toString());
    }

    public static void a(Activity activity, ViewerUser vieweruser, String s1)
    {
        a(activity, 0, vieweruser, vieweruser.id, vieweruser.username, ((String) (null)), s1, ((JSONObject) (null)));
    }

    public static void a(Activity activity, ViewerUser vieweruser, String s1, JSONObject jsonobject)
    {
        a(activity, 0, vieweruser, vieweruser.id, vieweruser.username, ((String) (null)), s1, jsonobject);
    }

    public static void a(Activity activity, PreferencesAbout preferencesabout)
    {
        Object obj = null;
        com.socialin.android.picsart.profile.util._cls8.a[preferencesabout.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 76
    //                   2 83
    //                   3 90
    //                   4 97;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        preferencesabout = obj;
_L7:
        if (!TextUtils.isEmpty(preferencesabout))
        {
            Intent intent = new Intent(activity, com/socialin/android/picsart/profile/activity/WebViewActivity);
            intent.putExtra("url", preferencesabout);
            activity.startActivity(intent);
        }
        return;
_L2:
        preferencesabout = "http://picsart.com/mobile/terms";
        continue; /* Loop/switch isn't completed */
_L3:
        preferencesabout = "http://picsart.com/license/android";
        continue; /* Loop/switch isn't completed */
_L4:
        preferencesabout = "http://picsart.com/mobile/privacy";
        continue; /* Loop/switch isn't completed */
_L5:
        preferencesabout = "http://picsart.com/mobile/dmca";
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void a(Activity activity, Integer integer)
    {
        if (SocialinV3.getInstance().getUser() != null)
        {
            Intent intent = new Intent(activity, com/picsart/studio/profile/ProfileActivity);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from", "direct");
            intent.putExtra("profileUser", SocialinV3.getInstance().getUser());
            intent.setFlags(0x4000000);
            myobfuscated.cv.c.a(intent, activity);
            if (integer != null)
            {
                activity.startActivityForResult(intent, integer.intValue());
                return;
            } else
            {
                activity.startActivity(intent);
                return;
            }
        } else
        {
            d.b(d.a, (new StringBuilder()).append(activity.getClass().getName()).append("...... Something is wrong!!! User is NULL").toString());
            return;
        }
    }

    public static void a(Activity activity, String s1)
    {
        if (!s.a(activity))
        {
            a(activity);
            return;
        }
        if (SocialinV3.getInstance().isRegistered())
        {
            Intent intent = activity.getIntent();
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from", "direct");
            intent.putExtra("profileUserId", s1);
            intent.setClassName(activity.getPackageName(), com/picsart/studio/profile/ProfileActivity.getName());
            intent.setFlags(0x4000000);
            activity.startActivityForResult(intent, 6);
            return;
        } else
        {
            y.e(activity);
            return;
        }
    }

    public static void a(Activity activity, String s1, String s2)
    {
        a(activity, 0, ((ViewerUser) (null)), 0L, s1, ((String) (null)), s2, ((JSONObject) (null)));
    }

    public static void a(Activity activity, List list, int i)
    {
        Parcelable aparcelable[] = new Parcelable[list.size()];
        if (list.size() > 0)
        {
            for (int j = 0; j < list.size(); j++)
            {
                aparcelable[j] = (Parcelable)list.get(j);
            }

            a(activity, aparcelable, i, ((String) (null)), 4539);
        }
    }

    public static void a(Activity activity, Parcelable aparcelable[], int i, int j)
    {
        activity.getIntent().putExtra("request_controller_code", j);
        a(activity, aparcelable, i, ((String) (null)), 4539);
    }

    public static void a(Activity activity, Parcelable aparcelable[], int i, String s1, int j)
    {
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        if (!s.a(activity))
        {
            a(activity);
            return;
        }
        Intent intent = new Intent(activity, com/socialin/android/picsart/profile/activity/GalleryItemShowActivity);
        if (activity.getIntent() != null && activity.getIntent().getExtras() != null)
        {
            intent.putExtras(activity.getIntent().getExtras());
        }
        if (aparcelable.length > 400)
        {
            aparcelable = a(aparcelable, i);
            intent.putExtra("item_position", ((r) (aparcelable)).b);
            intent.putExtra("all_items", ((r) (aparcelable)).a);
        } else
        {
            intent.putExtra("item_position", i);
            intent.putExtra("all_items", aparcelable);
        }
        intent.putExtra("bitmap_path", s1);
        intent.setFlags(0x20000000);
        activity.startActivityForResult(intent, 4539);
    }

    public static void a(Activity activity, Parcelable aparcelable[], int i, String s1, String s2)
    {
        if (activity != null && !activity.isFinishing())
        {
            Intent intent = new Intent(activity, com/socialin/android/picsart/profile/activity/SliderActivity);
            intent.putExtra("currentItem", aparcelable[i]);
            intent.putExtra("sliderContent", "commentFragment");
            intent.putExtra("source", s2);
            if (s1 != null)
            {
                intent.putExtra("selectedTab", s1);
            }
            intent.putExtra("keyboardHide", activity.getIntent().getBooleanExtra("keyboardHide", false));
            activity.startActivityForResult(intent, 4539);
        }
    }

    public static void a(Fragment fragment, Stream stream)
    {
        if (!s.a(fragment.getActivity()))
        {
            a(fragment.getActivity());
            return;
        }
        Intent intent = new Intent(fragment.getActivity(), com/socialin/android/picsart/profile/activity/MemboxItemsActivity);
        intent.setFlags(0x4000000);
        intent.putExtra("memboxType", stream.type);
        intent.putExtra("memboxId", stream.id);
        if (stream.user != null)
        {
            intent.putExtra("userId", stream.user.id);
            intent.putExtra("profileUser", stream.user);
        }
        if (intent.hasExtra("item_id"))
        {
            intent.removeExtra("item_id");
        }
        fragment.startActivityForResult(intent, 4548);
    }

    public static void a(Fragment fragment, List list, int i, int j, FrameLayout framelayout, Card card)
    {
        if (list.size() > i)
        {
            JSONObject jsonobject = m.a(card);
            Activity activity = fragment.getActivity();
            Object obj;
            int k;
            long l;
            long l1;
            if (activity == null || activity.isFinishing())
            {
                card = null;
            } else
            {
                Bundle bundle = new Bundle();
                card = bundle;
                if (activity.getIntent() != null)
                {
                    card = bundle;
                    if (activity.getIntent().getExtras() != null)
                    {
                        card = activity.getIntent().getExtras();
                    }
                }
                Parcelable aparcelable[] = a(list);
                if (list.size() > 400)
                {
                    aparcelable = a(aparcelable, i);
                    card.putInt("item_position", ((r) (aparcelable)).b);
                    card.putParcelableArray("all_items", ((r) (aparcelable)).a);
                } else
                {
                    card.putInt("item_position", i);
                    card.putParcelableArray("all_items", aparcelable);
                }
            }
            obj = fragment.getActivity();
            list = (ImageItem)list.get(i);
            obj = AnalyticUtils.getInstance(((Context) (obj)));
            l1 = ((ImageItem) (list)).id;
            if (((ImageItem) (list)).user != null)
            {
                l = ((ImageItem) (list)).user.id;
            } else
            {
                l = -1L;
            }
            i = ((ImageItem) (list)).likesCount;
            k = ((ImageItem) (list)).commentsCount;
            if (((ImageItem) (list)).tags == null)
            {
                list = new JSONArray();
            } else
            {
                list = new JSONArray(Arrays.asList(((ImageItem) (list)).tags));
            }
            ((AnalyticUtils) (obj)).track((new com.socialin.android.apiv3.events.EventsFactory.PhotoOpenEvent(l1, l, i, k, list)).setExtras(jsonobject));
            if (framelayout == null)
            {
                if (fragment != null && fragment.getActivity() != null && !fragment.getActivity().isFinishing())
                {
                    list = new Intent(fragment.getActivity(), com/socialin/android/picsart/profile/activity/GalleryItemShowActivity);
                    list.putExtras(card);
                    if (j >= 0)
                    {
                        fragment.startActivityForResult(list, j);
                        return;
                    } else
                    {
                        fragment.startActivity(list);
                        return;
                    }
                }
            } else
            {
                Object obj1 = fragment.getActivity().getFragmentManager();
                list = ((FragmentManager) (obj1)).beginTransaction();
                obj1 = (aa)((FragmentManager) (obj1)).findFragmentByTag("gallery_item_show_fragment_tag");
                if (obj1 == null)
                {
                    obj1 = new aa();
                    list.add(framelayout.getId(), ((Fragment) (obj1)), "gallery_item_show_fragment_tag");
                    ((aa) (obj1)).setArguments(card);
                } else
                {
                    list.show(((Fragment) (obj1)));
                }
                list.commitAllowingStateLoss();
                fragment.setUserVisibleHint(false);
                return;
            }
        }
    }

    public static void a(Fragment fragment, List list, int i, FrameLayout framelayout)
    {
        a(fragment, list, i, -1, framelayout, ((Card) (null)));
    }

    public static void a(Fragment fragment, Parcelable aparcelable[], int i, String s1)
    {
        Activity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        Intent intent = new Intent(activity, com/socialin/android/picsart/profile/activity/GalleryItemShowActivity);
        if (activity.getIntent() != null && activity.getIntent().getExtras() != null)
        {
            intent.putExtras(activity.getIntent().getExtras());
        }
        if (aparcelable.length > 400)
        {
            aparcelable = a(aparcelable, i);
            intent.putExtra("item_position", ((r) (aparcelable)).b);
            intent.putExtra("all_items", ((r) (aparcelable)).a);
        } else
        {
            intent.putExtra("item_position", i);
            intent.putExtra("all_items", aparcelable);
        }
        intent.putExtra("bitmap_path", s1);
        fragment.startActivityForResult(intent, 4539);
    }

    public static void a(Context context, ImageItem imageitem)
    {
        context = new a(context);
        context.b = new _cls7(context, 2, imageitem, null);
        context.a(false);
    }

    public static void a(View view)
    {
        _cls6 _lcls6 = new _cls6(view);
        view.setVisibility(0);
        view.animate().setDuration(500L).scaleXBy(0.0F).scaleX(1.5F).setListener(_lcls6);
        view.animate().setDuration(500L).scaleYBy(0.0F).scaleY(1.5F).setListener(_lcls6);
        view.animate().setDuration(500L).alpha(0.0F).setListener(_lcls6);
    }

    public static void a(String s1, Activity activity, Parcelable parcelable)
    {
        Intent intent = new Intent();
        if (activity.getIntent().getExtras() != null && activity.getIntent().getExtras().size() > 0)
        {
            intent.putExtras(activity.getIntent().getExtras());
        }
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClassName(activity.getPackageName(), "com.socialin.android.share.SaveExportActivity");
        intent.putExtra("subject", activity.getString(0x7f08040b));
        intent.putExtra("item", parcelable);
        intent.putExtra("forEdit", true);
        intent.putExtra("path", s1);
        activity.startActivity(intent);
    }

    private static void a(String s1, SpannableStringBuilder spannablestringbuilder, Activity activity, int i, int j, int k)
    {
        int l = 0;
        int i1 = s1.indexOf("#");
        String s2 = s1.substring(0, i1);
        if (!TextUtils.isEmpty(s2))
        {
            spannablestringbuilder.append(new SpannableString(s2));
        }
        s1 = s1.substring(i1).split("#");
        for (int j1 = s1.length; l < j1; l++)
        {
            String s3 = s1[l];
            if (s3 != null && s3.trim().length() > 0)
            {
                spannablestringbuilder.append(c((new StringBuilder("#")).append(s3).toString(), activity, i, j, k));
            }
        }

    }

    public static void a(String s1, List list)
    {
        boolean flag = false;
        if (list != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        File file;
        int i;
        int j;
        file = Environment.getExternalStorageDirectory();
        (new File((new StringBuilder()).append(file.getAbsolutePath()).append("/").append(s1).toString())).mkdir();
        file = new File((new StringBuilder()).append(file.getAbsolutePath()).append("/").append(s1).append("/user_recent_tags.txt").toString());
        String s2;
        IOException ioexception;
        try
        {
            if (file.exists())
            {
                file.delete();
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return;
        }
        file.createNewFile();
_L8:
        if (!file.canWrite()) goto _L1; else goto _L3
_L3:
        s1 = b(s1);
        if (list.size() <= 10) goto _L5; else goto _L4
_L4:
        i = list.size() - 10 - 1;
_L9:
        j = list.size() - 1;
_L12:
        if (j < i) goto _L7; else goto _L6
_L6:
        s2 = ((String)list.get(j)).trim().toLowerCase();
        if (s2.isEmpty() || s1.contains(s2))
        {
            break MISSING_BLOCK_LABEL_329;
        }
        s1.add(s2);
        if (s1.size() != 10)
        {
            break MISSING_BLOCK_LABEL_329;
        }
          goto _L7
        ioexception;
        ioexception.printStackTrace();
          goto _L8
_L5:
        i = 0;
          goto _L9
_L7:
        list = new StringBuilder("");
        i = ((flag) ? 1 : 0);
_L11:
        if (i >= s1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        list.append((String)s1.get(i)).append(",");
        i++;
        if (true) goto _L11; else goto _L10
_L10:
        s1 = new FileWriter(file, true);
        s1.write(list.substring(0, Math.max(0, list.length() - 1)));
        s1.flush();
        s1.close();
        return;
        j--;
          goto _L12
    }

    private static ImageItem[] a(List list)
    {
        ImageItem aimageitem[] = new ImageItem[list.size()];
        if (list.size() > 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                aimageitem[i] = ((ImageItem)list.get(i)).clone();
            }

        }
        return aimageitem;
    }

    public static String[] a(String as[], String s1)
    {
        int i = 0;
        LinkedList linkedlist = new LinkedList();
        if (as == null)
        {
            return new String[0];
        }
        s1 = s1.toLowerCase();
        for (int j = as.length; i < j; i++)
        {
            String s2 = as[i];
            if (s2 != null && !s1.contains((new StringBuilder("#")).append(s2.toLowerCase()).toString()))
            {
                linkedlist.add(s2);
            }
        }

        return (String[])linkedlist.toArray(new String[linkedlist.size()]);
    }

    private static SpannableString b(String s1, Activity activity, int i, int j, int k)
    {
        SpannableString spannablestring = new SpannableString((new StringBuilder()).append(s1).append(" ").toString());
        s1 = s1.substring(s1.indexOf("@") + 1, s1.length());
        if (!TextUtils.isEmpty(s1))
        {
            spannablestring.setSpan(new _cls2(i, j, k, activity, s1), 0, spannablestring.length(), 33);
        }
        return spannablestring;
    }

    public static String b(Context context, String s1)
    {
        return (new StringBuilder()).append(a(context)).append("avatar_").append(s1).toString();
    }

    public static String b(Context context, String s1, String s2)
    {
        if (s1 == null)
        {
            return "";
        }
        context = (new StringBuilder()).append(a(context)).append(s1).append("_small");
        if (s2 == null)
        {
            s2 = "";
        }
        return context.append(s2).toString();
    }

    public static String b(Date date, Context context)
    {
        Object obj1;
label0:
        {
            Object obj;
            int i;
            int j;
            int k;
            int l;
            int i1;
            int j1;
label1:
            {
                obj = "";
                if (date != null)
                {
                    obj1 = Calendar.getInstance(TimeZone.getDefault());
                    obj = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                    ((Calendar) (obj)).setTimeInMillis(date.getTime());
                    obj = a(TimeZone.getDefault().getID(), ((Calendar) (obj)));
                    i = ((Calendar) (obj1)).get(13) - ((Calendar) (obj)).get(13);
                    j = ((Calendar) (obj1)).get(12) - ((Calendar) (obj)).get(12);
                    k = ((Calendar) (obj1)).get(11) - ((Calendar) (obj)).get(11);
                    l = ((Calendar) (obj1)).get(6) - ((Calendar) (obj)).get(6);
                    i1 = ((Calendar) (obj1)).get(3) - ((Calendar) (obj)).get(3);
                    j1 = ((Calendar) (obj1)).get(2) - ((Calendar) (obj)).get(2);
                    int k1 = ((Calendar) (obj1)).get(1) - ((Calendar) (obj)).get(1);
                    date = "MMM dd";
                    if (k1 > 0)
                    {
                        date = (new StringBuilder("yyyy ")).append("MMM dd").toString();
                    }
                    date = new SimpleDateFormat(date);
                    date.setTimeZone(TimeZone.getDefault());
                    (new SimpleDateFormat("HH:mm")).setTimeZone(TimeZone.getDefault());
                    obj = ((Calendar) (obj)).getTime();
                    obj1 = date.format(((Date) (obj)));
                    if (k1 != 0)
                    {
                        break label0;
                    }
                    if (j1 != 0)
                    {
                        break label1;
                    }
                    obj = a(((Date) (obj)), date, i1, l, k, j, i, context);
                }
                return ((String) (obj));
            }
            if (j1 < 0)
            {
                return context.getString(0x7f0802ea);
            }
            if (j1 == 1)
            {
                return a(((Date) (obj)), date, i1, l, k, j, i, context);
            }
        }
        return ((String) (obj1));
    }

    private static ArrayList b(String s1)
    {
        ArrayList arraylist = new ArrayList();
        Object obj = Environment.getExternalStorageDirectory();
        String as[];
        int i;
        int j;
        try
        {
            s1 = new InputStreamReader(new DataInputStream(new FileInputStream((new StringBuilder()).append(((File) (obj)).getAbsolutePath()).append("/").append(s1).append("/user_recent_tags.txt").toString())));
            obj = new BufferedReader(s1);
            arraylist.clear();
            obj = ((BufferedReader) (obj)).readLine();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            ExceptionReportService.report(s1);
            return arraylist;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        as = ((String) (obj)).trim().split(",");
        j = as.length;
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(as[i].trim());
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        s1.close();
        return arraylist;
    }

    public static void b(Activity activity, ImageItem imageitem)
    {
        Object obj = new t();
        b b1 = ((t) (obj)).a(0, 0x7f0c0181);
        b1.a = activity.getString(0x7f080526);
        b1.f = 0x7f03020a;
        b1.g = false;
        b1.h = true;
        obj = new com.socialin.android.picsart.profile.util.s(((t) (obj)).a, ((t) (obj)).e, ((t) (obj)).b, ((t) (obj)).f, ((t) (obj)).g, ((t) (obj)).h, ((t) (obj)).k, ((t) (obj)).l, ((t) (obj)).m, ((t) (obj)).o, ((t) (obj)).n, ((t) (obj)).p, ((t) (obj)).d, ((t) (obj)).c, (byte)0);
        obj.n = new u(activity, imageitem);
        ((com.socialin.android.picsart.profile.util.s) (obj)).show(activity.getFragmentManager(), null);
    }

    public static void b(Activity activity, String s1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        ((ClipboardManager)activity.getSystemService("clipboard")).setText(s1);
_L1:
        Utils.c(activity, activity.getString(0x7f0802aa));
        return;
        try
        {
            ((android.content.ClipboardManager)activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(activity.getString(0x7f0808af), s1));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            d.c(new Object[] {
                b, "Fail to copy to Cliboard !!!"
            });
            return;
        }
          goto _L1
    }

    public static void b(Fragment fragment, List list, int i, FrameLayout framelayout)
    {
        a(fragment, list, i, 4539, framelayout, ((Card) (null)));
    }

    public static void b(String s1, Activity activity)
    {
        Intent intent = new Intent(activity.getApplicationContext(), com/socialin/android/picsart/profile/activity/TopTagsActivity);
        if (activity.getIntent().getExtras() != null)
        {
            myobfuscated.cv.c.a(intent, activity);
        }
        intent.putExtra("key.tag", s1);
        activity.startActivity(intent);
    }

    private static void b(String s1, SpannableStringBuilder spannablestringbuilder, Activity activity, int i, int j, int k)
    {
        int l = 0;
        int i1 = s1.indexOf("@");
        String s2 = s1.substring(0, i1);
        if (!TextUtils.isEmpty(s2))
        {
            spannablestringbuilder.append(new SpannableString(s2));
        }
        s1 = s1.substring(i1).split("@");
        for (int j1 = s1.length; l < j1; l++)
        {
            String s3 = s1[l];
            if (s3 != null && s3.trim().length() > 0)
            {
                spannablestringbuilder.append(b((new StringBuilder("@")).append(s3).toString(), activity, i, j, k));
            }
        }

    }

    private static SpannableString c(String s1, Activity activity, int i, int j, int k)
    {
        SpannableString spannablestring = new SpannableString((new StringBuilder()).append(s1).append(" ").toString());
        s1 = s1.substring(s1.indexOf("#") + 1, s1.length());
        if (!TextUtils.isEmpty(s1))
        {
            spannablestring.setSpan(new _cls3(i, j, k, s1, activity), 0, spannablestring.length(), 33);
        }
        return spannablestring;
    }

    public static String c(Context context, String s1, String s2)
    {
        if (s1 == null)
        {
            return "";
        }
        context = (new StringBuilder()).append(a(context)).append(s1).append("_normal");
        if (s2 == null)
        {
            s2 = "";
        }
        return context.append(s2).toString();
    }

    public static void c(Activity activity, ImageItem imageitem)
    {
        if (com.socialin.android.picsart.profile.util.y.c(activity))
        {
            Intent intent = new Intent(activity, com/socialin/android/picsart/profile/activity/SliderActivity);
            intent.putExtra("sliderContent", "addToMembox");
            intent.putExtra("source", "add_to_membox");
            if (imageitem.origin != null)
            {
                intent.putExtra("item_id", imageitem.origin.id);
            } else
            {
                intent.putExtra("item_id", imageitem.id);
            }
            activity.startActivityForResult(intent, 4543);
        }
    }


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class PreferencesAbout {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
