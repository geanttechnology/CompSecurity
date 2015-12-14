// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.cyberlink.beautycircle.controller.activity.AboutInfoActivity;
import com.cyberlink.beautycircle.controller.activity.AutoPostActivity;
import com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity;
import com.cyberlink.beautycircle.controller.activity.CircleActivity;
import com.cyberlink.beautycircle.controller.activity.CircleEditorActivity;
import com.cyberlink.beautycircle.controller.activity.CircleGroupActivity;
import com.cyberlink.beautycircle.controller.activity.ConnectionHistoryActivity;
import com.cyberlink.beautycircle.controller.activity.ContestActivity;
import com.cyberlink.beautycircle.controller.activity.ContestShareActivity;
import com.cyberlink.beautycircle.controller.activity.CropImageActivity;
import com.cyberlink.beautycircle.controller.activity.DeepLinkHistoryActivity;
import com.cyberlink.beautycircle.controller.activity.EditAboutActivity;
import com.cyberlink.beautycircle.controller.activity.EditCircleActivity;
import com.cyberlink.beautycircle.controller.activity.EditCommentActivity;
import com.cyberlink.beautycircle.controller.activity.EditFeedbackActivity;
import com.cyberlink.beautycircle.controller.activity.EditNotificationActivity;
import com.cyberlink.beautycircle.controller.activity.FreeSampleActivity;
import com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity;
import com.cyberlink.beautycircle.controller.activity.FreeSampleListActivity;
import com.cyberlink.beautycircle.controller.activity.FreeSampleResultActivity;
import com.cyberlink.beautycircle.controller.activity.GeneralWaterFallActivity;
import com.cyberlink.beautycircle.controller.activity.HotTopicActivity;
import com.cyberlink.beautycircle.controller.activity.LikeListActivity;
import com.cyberlink.beautycircle.controller.activity.LogBrowserActivity;
import com.cyberlink.beautycircle.controller.activity.LookInfoActivity;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.controller.activity.MeActivity;
import com.cyberlink.beautycircle.controller.activity.PostActivity;
import com.cyberlink.beautycircle.controller.activity.PostCommentActivity;
import com.cyberlink.beautycircle.controller.activity.PostGroupActivity;
import com.cyberlink.beautycircle.controller.activity.PreviewFeedbackActivity;
import com.cyberlink.beautycircle.controller.activity.ProductReviewActivity;
import com.cyberlink.beautycircle.controller.activity.ProductSocialActivity;
import com.cyberlink.beautycircle.controller.activity.ProductsActivity;
import com.cyberlink.beautycircle.controller.activity.RegisterActivity;
import com.cyberlink.beautycircle.controller.activity.RegisterChangePasswordActivity;
import com.cyberlink.beautycircle.controller.activity.RegisterForgetPasswordActivity;
import com.cyberlink.beautycircle.controller.activity.RegisterVerifyActivity;
import com.cyberlink.beautycircle.controller.activity.SearchActivity;
import com.cyberlink.beautycircle.controller.activity.SelectCategoryActivity;
import com.cyberlink.beautycircle.controller.activity.SelectReportActivity;
import com.cyberlink.beautycircle.controller.activity.ShareInActivity;
import com.cyberlink.beautycircle.controller.activity.ShareInPostActivity;
import com.cyberlink.beautycircle.controller.activity.TagProductActivity;
import com.cyberlink.beautycircle.controller.activity.TutorialActivity;
import com.cyberlink.beautycircle.controller.activity.UserListActivity;
import com.cyberlink.beautycircle.controller.activity.WebViewerActivity;
import com.cyberlink.beautycircle.controller.activity.WritePostActivity;
import com.cyberlink.beautycircle.controller.activity.YouTubeActivity;
import com.cyberlink.beautycircle.controller.adapter.a;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.CompletePost;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.Tags;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

// Referenced classes of package com.cyberlink.beautycircle:
//            f, Globals, m, BaseActivity, 
//            d

public class c
{

    public static void a(Activity activity)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/ProductsActivity);
        intent.putExtra("IsPickProduct", true);
        activity.startActivityForResult(intent, 48142);
    }

    public static void a(Activity activity, int i)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/EditAboutActivity);
        intent.putExtra("EditProfileMode", i);
        activity.startActivityForResult(intent, 48129);
    }

    public static void a(Activity activity, int i, int j, int k)
    {
        a(activity, i, j, k, "");
    }

    public static void a(Activity activity, int i, int j, int k, String s)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/RegisterActivity);
        intent.putExtra("SignInMode", i);
        intent.putExtra("ReDirectMode", j);
        intent.putExtra("EditProfileMode", k);
        intent.putExtra("eventName", s);
        activity.startActivityForResult(intent, 48144);
    }

    public static void a(Activity activity, int i, CircleDetail circledetail)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/EditCircleActivity);
        intent.putExtra("EditProfileMode", i);
        if (circledetail != null)
        {
            intent.putExtra("CircleDetail", circledetail.toString());
        }
        activity.startActivityForResult(intent, 48153);
    }

    public static void a(Activity activity, long l)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/SelectCategoryActivity);
        intent.putExtra("CategoryId", l);
        activity.startActivityForResult(intent, 48155);
    }

    public static void a(Activity activity, long l, String s)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/SelectReportActivity);
        intent.putExtra("UserId", l);
        intent.putExtra("UserDisplayName", s);
        activity.startActivityForResult(intent, 48164);
    }

    public static void a(Activity activity, long l, String s, Runnable runnable, boolean flag, CompletePost completepost, Long long1, 
            String s1)
    {
        a(activity, l, s, runnable, flag, completepost, long1, null, s1);
    }

    public static void a(Activity activity, long l, String s, Runnable runnable, boolean flag, CompletePost completepost, Long long1, 
            String s1, String s2)
    {
        if (activity == null)
        {
            return;
        } else
        {
            AccountManager.a(activity, new b(activity, l, s, flag, s2, completepost, long1, s1, runnable) {

                final Activity a;
                final long b;
                final String c;
                final boolean d;
                final String e;
                final CompletePost f;
                final Long g;
                final String h;
                final Runnable i;

                public void a()
                {
                    com.cyberlink.beautycircle.Globals.b("Get AccountToken Fail");
                    if (i != null)
                    {
                        (new Handler(Looper.getMainLooper())).post(i);
                    }
                }

                public void a(String s3)
                {
                    s3 = new Intent();
                    s3.setClass(a, com/cyberlink/beautycircle/controller/activity/WritePostActivity);
                    s3.putExtra("CategoryId", b);
                    if (c != null)
                    {
                        s3.putExtra("FilePath", c);
                    }
                    s3.putExtra("IsForceToFeed", d);
                    s3.putExtra("CategoryType", e);
                    if (f != null)
                    {
                        s3.putExtra("CompletePost", f.toString());
                    }
                    s3.putExtra("PostId", g);
                    s3.putExtra("Content", h);
                    a.startActivityForResult(s3, 48150);
                }

                public void b()
                {
                    com.cyberlink.beautycircle.Globals.b("Get AccountToken Cancel");
                    if (i != null)
                    {
                        (new Handler(Looper.getMainLooper())).post(i);
                    }
                }

            
            {
                a = activity;
                b = l;
                c = s;
                d = flag;
                e = s1;
                f = completepost;
                g = long1;
                h = s2;
                i = runnable;
                super();
            }
            });
            return;
        }
    }

    public static void a(Activity activity, long l, boolean flag, int i, String s, String s1)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/PostActivity);
        intent.putExtra("PostId", l);
        intent.putExtra("ShowTopPanel", flag);
        intent.putExtra("ScrollPosition", i);
        intent.putExtra("sourceType", s);
        intent.putExtra("PostType", s1);
        activity.startActivity(intent);
        activity.overridePendingTransition(f.bc_slide_in_right, f.bc_slide_out_left);
    }

    public static void a(Activity activity, Uri uri, Long long1, String s, Tags tags)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/EditCommentActivity);
        intent.putExtra("UserAvatarUri", uri);
        intent.putExtra("UserCommentId", long1);
        intent.putExtra("UserComment", s);
        if (tags != null)
        {
            intent.putExtra("UserCommentTags", tags.toString());
        }
        activity.startActivityForResult(intent, 48149);
    }

    public static void a(Activity activity, Uri uri, String s, String s1, boolean flag, String s2, Long long1)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/AboutInfoActivity);
        intent.putExtra("UserAvatarUri", uri);
        intent.putExtra("UserDisplayName", s);
        intent.putExtra("UserAboutInfo", s1);
        intent.putExtra("UserMyAbout", flag);
        intent.putExtra("UserWebSiteUrl", s2);
        intent.putExtra("UserId", long1);
        activity.startActivityForResult(intent, 48146);
    }

    public static void a(Activity activity, Uri uri, ArrayList arraylist)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/TagProductActivity);
        intent.putExtra("PhotoUri", uri);
        intent.putExtra("ProductTags", Model.b(arraylist).toString());
        activity.startActivityForResult(intent, 48143);
    }

    public static void a(Activity activity, CircleDetail circledetail)
    {
        if (activity == null)
        {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/CircleActivity);
        if (circledetail != null)
        {
            intent.putExtra("CircleDetail", circledetail.toString());
        }
        activity.startActivityForResult(intent, 48156);
    }

    public static void a(Activity activity, CircleDetail circledetail, Boolean boolean1)
    {
        if (activity == null)
        {
            return;
        } else
        {
            AccountManager.a(activity, new b(activity, circledetail, boolean1) {

                final Activity a;
                final CircleDetail b;
                final Boolean c;

                public void a()
                {
                    com.cyberlink.beautycircle.Globals.b("Get AccountToken Fail");
                }

                public void a(String s)
                {
                    s = new Intent();
                    s.setClass(a, com/cyberlink/beautycircle/controller/activity/CircleEditorActivity);
                    if (b != null)
                    {
                        s.putExtra("CircleDetail", b.toString());
                    }
                    s.putExtra("CircleEditorMode", c);
                    a.startActivityForResult(s, 48152);
                }

                public void b()
                {
                    com.cyberlink.beautycircle.Globals.b("Get AccountToken Cancel");
                }

            
            {
                a = activity;
                b = circledetail;
                c = boolean1;
                super();
            }
            });
            return;
        }
    }

    public static void a(Activity activity, CompletePost completepost)
    {
        a(activity, -1L, null, null, false, completepost, null, null);
    }

    public static void a(Activity activity, com.cyberlink.beautycircle.model.Event.BrandEventInfo brandeventinfo)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/FreeSampleFillDataActivity);
        if (brandeventinfo != null)
        {
            intent.putExtra("brandEventInfo", brandeventinfo.toString());
        }
        activity.startActivityForResult(intent, 48161);
    }

    public static void a(Activity activity, Post post)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/ShareInPostActivity);
        intent.putExtra("ShareInPost", post.toString());
        activity.startActivityForResult(intent, 48157);
    }

    public static void a(Activity activity, Post post, boolean flag, int i)
    {
        if (activity == null || post == null)
        {
            return;
        } else
        {
            Intent intent = new Intent();
            intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/PostCommentActivity);
            intent.putExtra("Post", post.toString());
            intent.putExtra("CommentMode", flag);
            intent.putExtra("ScrollPosition", i);
            activity.startActivityForResult(intent, 48163);
            activity.overridePendingTransition(f.bc_slide_in_right, f.bc_slide_out_left);
            return;
        }
    }

    public static void a(Activity activity, Post post, boolean flag, a a1, int i, boolean flag1)
    {
        if (activity == null || post == null)
        {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/PostActivity);
        intent.putExtra("Post", post.toString());
        intent.putExtra("ShowTopPanel", flag);
        intent.putExtra("ScrollPosition", i);
        intent.putExtra("Slide", i);
        com.cyberlink.beautycircle.Globals.e = a1;
        if (a1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        intent.putExtra("HasListAdapter", flag);
        activity.startActivityForResult(intent, 48148);
        activity.overridePendingTransition(f.bc_slide_in_right, f.bc_slide_out_left);
    }

    public static void a(Activity activity, com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig feedbackconfig, int i)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/EditFeedbackActivity);
        intent.putExtra("FeedbackConfig", feedbackconfig);
        intent.putExtra("TopBarStyle", i);
        activity.startActivityForResult(intent, 48159);
    }

    public static void a(Activity activity, com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig feedbackconfig, String s, String s1, ArrayList arraylist, int i)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/PreviewFeedbackActivity);
        intent.putExtra("FeedbackConfig", feedbackconfig);
        intent.putExtra("FeedbackDesc", s);
        intent.putExtra("FeedbackEmail", s1);
        intent.putExtra("TopBarStyle", i);
        if (arraylist != null)
        {
            intent.putExtra("FeedbackImage", Model.b(arraylist).toString());
        }
        activity.startActivityForResult(intent, 48160);
    }

    public static void a(Activity activity, Long long1, Long long2)
    {
        if (activity == null)
        {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/CircleActivity);
        if (long1 != null)
        {
            intent.putExtra("CreatorId", long1);
        }
        if (long2 != null)
        {
            intent.putExtra("CircleId", long2);
        }
        activity.startActivity(intent);
    }

    public static void a(Activity activity, String s)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/RegisterForgetPasswordActivity);
        intent.putExtra("UserEmail", s);
        activity.startActivityForResult(intent, 48140);
    }

    public static void a(Activity activity, String s, int i, int j)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/WebViewerActivity);
        intent.putExtra("RedirectUrl", s);
        intent.putExtra("BrowserMode", i);
        activity.startActivityForResult(intent, j);
    }

    public static void a(Activity activity, String s, int i, String s1)
    {
        if (activity == null)
        {
            return;
        } else
        {
            Intent intent = new Intent();
            intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/GeneralWaterFallActivity);
            intent.putExtra("Title", s);
            intent.putExtra("ListMode", i);
            intent.putExtra("Params", s1);
            activity.startActivity(intent);
            return;
        }
    }

    public static void a(Activity activity, String s, long l)
    {
        if (activity == null)
        {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/PostGroupActivity);
        if (s == null)
        {
            s = "";
        }
        intent.putExtra("Title", s);
        intent.putExtra("NotificationId", l);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, String s, com.cyberlink.beautycircle.controller.activity.ShareInActivity.ShareInParam shareinparam)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/ShareInActivity);
        intent.putExtra("ShareInUrl", s);
        intent.putExtra("ShareInParam", shareinparam);
        activity.startActivityForResult(intent, 48166);
    }

    public static void a(Activity activity, ArrayList arraylist, Globals.CropSettings cropsettings, int i)
    {
        if (activity == null || arraylist == null || arraylist.isEmpty() || cropsettings == null)
        {
            return;
        } else
        {
            Intent intent = new Intent(activity, com/cyberlink/beautycircle/controller/activity/CropImageActivity);
            intent.putParcelableArrayListExtra("PhotoUriList", arraylist);
            intent.putExtra("CropSettings", cropsettings.toString());
            intent.putExtra("RequestCode", i);
            activity.startActivityForResult(intent, i);
            return;
        }
    }

    public static void a(Activity activity, boolean flag, String s, boolean flag1)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/SearchActivity);
        intent.putExtra("IsSearchLanding", flag);
        intent.putExtra("SearchKeyword", s);
        intent.putExtra("ForShare", flag1);
        activity.startActivityForResult(intent, 48165);
        activity.overridePendingTransition(f.bc_slide_in_right, f.bc_slide_out_left);
    }

    public static void a(Context context)
    {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        intent.putExtra(context.getResources().getString(m.extra_key_force_launcher), true);
        context.startActivity(intent);
    }

    public static void a(Context context, long l)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/ProductSocialActivity);
        intent.putExtra("ProductId", l);
        context.startActivity(intent);
    }

    public static void a(Context context, long l, com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/MeActivity);
        intent.putExtra("UserId", l);
        intent.putExtra("ListMode", melistmode);
        context.startActivity(intent);
    }

    public static void a(Context context, com.cyberlink.beautycircle.controller.activity.MainActivity.TabPage tabpage)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/MainActivity);
        intent.putExtra("TabPage", tabpage);
        context.startActivity(intent);
    }

    public static void a(Context context, com.cyberlink.beautycircle.controller.fragment.PageFreeSampleListFragment.EventListType eventlisttype, boolean flag, String s)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/FreeSampleListActivity);
        intent.putExtra("eventListType", eventlisttype);
        intent.putExtra("IsFromDeepLink", flag);
        intent.putExtra("locale", s);
        context.startActivity(intent);
    }

    public static void a(Context context, com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.NotificationTab notificationtab)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/MainActivity);
        intent.putExtra("TabPage", com.cyberlink.beautycircle.controller.activity.MainActivity.TabPage.e);
        intent.putExtra("SubTabPage", notificationtab);
        context.startActivity(intent);
    }

    public static void a(Context context, com.cyberlink.beautycircle.model.network.NetworkUser.UserListType userlisttype, Long long1, Long long2)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/UserListActivity);
        intent.putExtra("UserListType", userlisttype);
        if (long1 != null)
        {
            intent.putExtra("UserId", long1);
        }
        if (long2 != null)
        {
            intent.putExtra("ListId", long2);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, Long long1)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/FreeSampleResultActivity);
        intent.putExtra("brandEventId", long1);
        context.startActivity(intent);
    }

    public static void a(Context context, Long long1, String s, String s1)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/FreeSampleActivity);
        intent.putExtra("eventId", long1);
        intent.putExtra("eventAction", s);
        intent.putExtra("sourceType", s1);
        context.startActivity(intent);
    }

    public static void a(Context context, Long long1, String s, boolean flag)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/ContestActivity);
        intent.putExtra("eventId", long1);
        intent.putExtra("sourceType", s);
        intent.putExtra("IsFromDeepLink", flag);
        context.startActivity(intent);
    }

    public static void a(Context context, String s)
    {
        com.cyberlink.beautycircle.BaseActivity.a(s, null);
        if (s.equals("ycn") && !Globals.E())
        {
            a(context, ((String) (null)), Long.valueOf(-1L), "NAILS", false, false, true);
            return;
        } else
        {
            s = new Intent();
            s.setClass(context, com/cyberlink/beautycircle/controller/activity/MainActivity);
            context.startActivity(s);
            return;
        }
    }

    public static void a(Context context, String s, int i)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/WebViewerActivity);
        intent.putExtra("RedirectUrl", s);
        intent.putExtra("BrowserMode", i);
        context.startActivity(intent);
    }

    public static void a(Context context, String s, long l)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/LikeListActivity);
        intent.putExtra("ListLikeTargetType", s);
        intent.putExtra("ListLikeTargetId", l);
        context.startActivity(intent);
    }

    public static void a(Context context, String s, Long long1, Uri uri)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/ContestShareActivity);
        intent.putExtra("eventInfo", s);
        intent.putExtra("PostId", long1);
        intent.putExtra("PhotoUri", uri);
        context.startActivity(intent);
    }

    public static void a(Context context, String s, Long long1, String s1, boolean flag, boolean flag1, boolean flag2)
    {
        if (context == null)
        {
            return;
        } else
        {
            Intent intent = new Intent();
            intent.setClass(context, com/cyberlink/beautycircle/controller/activity/HotTopicActivity);
            intent.putExtra("CategoryName", s);
            intent.putExtra("CategoryId", long1);
            intent.putExtra("CategoryType", s1);
            intent.putExtra("Slide", flag);
            intent.putExtra("LoginCheck", flag1);
            intent.putExtra("BackToBC", flag2);
            context.startActivity(intent);
            return;
        }
    }

    public static void a(Context context, String s, String s1, String s2, String s3)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/ProductsActivity);
        if (s != null)
        {
            intent.putExtra("brandId", Long.parseLong(s));
        }
        if (s1 != null)
        {
            intent.putExtra("typeId", Long.parseLong(s1));
        }
        if (s2 != null)
        {
            intent.putExtra("priceRangeId", Long.parseLong(s2));
        }
        intent.putExtra("locale", s3);
        intent.putExtra("IsListProduct", true);
        context.startActivity(intent);
    }

    public static void a(FragmentActivity fragmentactivity, long l)
    {
        Intent intent = new Intent();
        intent.setClass(fragmentactivity, com/cyberlink/beautycircle/controller/activity/ProductReviewActivity);
        intent.putExtra("ProductId", l);
        fragmentactivity.startActivityForResult(intent, 48137);
    }

    public static void a(FragmentActivity fragmentactivity, String s, String s1, int i)
    {
        Intent intent = new Intent();
        intent.setClass(fragmentactivity, com/cyberlink/beautycircle/controller/activity/RegisterVerifyActivity);
        intent.putExtra("UserEmail", s);
        intent.putExtra("UserPassword", s1);
        intent.putExtra("EditProfileMode", i);
        fragmentactivity.startActivityForResult(intent, 48128);
    }

    public static boolean a(Context context, Uri uri)
    {
        try
        {
            context.startActivity(new Intent("android.intent.action.VIEW", uri));
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            String s = uri.getScheme();
            if (s == null)
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    "Null scheme: ", uri
                });
                return false;
            }
            if (s.equals("ycp"))
            {
                return c(context, com.cyberlink.beautycircle.d.a);
            }
            if (s.equals("ymk"))
            {
                return c(context, com.cyberlink.beautycircle.d.b);
            }
            if (s.equals("ycn"))
            {
                return c(context, d.c);
            } else
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    uri, ", ", activitynotfoundexception
                });
                return false;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return true;
    }

    public static void b(Activity activity)
    {
        a(activity, -1L, null, null, false, null, null, null);
    }

    public static void b(Activity activity, int i)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/BeautyProfileActivity);
        intent.putExtra("EditProfileMode", i);
        activity.startActivityForResult(intent, 48141);
    }

    public static void b(Activity activity, String s, long l)
    {
        if (activity == null)
        {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/CircleGroupActivity);
        if (s == null)
        {
            s = "";
        }
        intent.putExtra("Title", s);
        intent.putExtra("NotificationId", l);
        activity.startActivity(intent);
    }

    public static void b(Context context)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/RegisterActivity);
        context.startActivity(intent);
    }

    public static void b(Context context, String s)
    {
        Intent intent;
        ArrayList arraylist;
        ArrayList arraylist1;
        ArrayList arraylist2;
        String s3;
        String as2[];
        intent = null;
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        arraylist2 = new ArrayList();
        s3 = s.replaceFirst("mailto:", "");
        as2 = s3.split("&");
        if (as2.length < 2) goto _L2; else goto _L1
_L1:
        int i;
        arraylist.addAll(Arrays.asList(as2[0].split(",")));
        i = 1;
        s = null;
_L7:
        if (i >= as2.length) goto _L4; else goto _L3
_L3:
        String as[] = as2[i].split("=");
        if (as.length != 2) goto _L6; else goto _L5
_L5:
        String s1;
        String s2;
        Object obj;
        String s4;
        s4 = as[0];
        s1 = as[1];
        try
        {
            s2 = URLDecoder.decode(s1, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        if (s4.equals("cc"))
        {
            arraylist1.addAll(Arrays.asList(s3.split(",")));
            s1 = s;
            obj = intent;
        } else
        {
label0:
            {
                if (!s4.equals("bcc"))
                {
                    break label0;
                }
                arraylist2.addAll(Arrays.asList(s3.split(",")));
                obj = intent;
                s1 = s;
            }
        }
_L9:
        i++;
        s = s1;
        intent = ((Intent) (obj));
          goto _L7
        obj = intent;
        s1 = s2;
        if (s4.equals("subject")) goto _L9; else goto _L8
_L8:
        if (!s4.equals("body")) goto _L6; else goto _L10
_L10:
        obj = s2;
        s1 = s;
          goto _L9
_L4:
        s1 = s;
        s = intent;
_L11:
        intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        String as1[] = new String[0];
        intent.putExtra("android.intent.extra.EMAIL", (String[])arraylist.toArray(as1));
        if (arraylist1.size() > 0)
        {
            intent.putExtra("android.intent.extra.CC", (String[])arraylist1.toArray(as1));
        }
        if (arraylist2.size() > 0)
        {
            intent.putExtra("android.intent.extra.BCC", (String[])arraylist2.toArray(as1));
        }
        if (s1 != null)
        {
            intent.putExtra("android.intent.extra.SUBJECT", s1);
        }
        if (s != null)
        {
            intent.putExtra("android.intent.extra.TEXT", s);
        }
        context.startActivity(intent);
        return;
_L2:
        arraylist.addAll(Arrays.asList(s3.split(",")));
        s = null;
        s1 = null;
        if (true) goto _L11; else goto _L6
_L6:
        obj = intent;
        s1 = s;
          goto _L9
    }

    public static void c(Activity activity)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/EditNotificationActivity);
        activity.startActivityForResult(intent, 48153);
    }

    public static void c(Context context)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/AutoPostActivity);
        context.startActivity(intent);
    }

    public static boolean c(Context context, String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return a(context, Uri.parse((new StringBuilder()).append("market://details?id=").append(s).toString()));
        }
    }

    public static void d(Activity activity)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/RegisterChangePasswordActivity);
        activity.startActivityForResult(intent, 48154);
    }

    public static void d(Context context)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/TutorialActivity);
        context.startActivity(intent);
    }

    public static void d(Context context, String s)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/LookInfoActivity);
        intent.putExtra("lookPath", s);
        context.startActivity(intent);
    }

    public static void e(Activity activity)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/LogBrowserActivity);
        activity.startActivity(intent);
    }

    public static void e(Context context, String s)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/beautycircle/controller/activity/YouTubeActivity);
        intent.putExtra("YouTubeVideoId", s);
        context.startActivity(intent);
    }

    public static void f(Activity activity)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/ConnectionHistoryActivity);
        activity.startActivity(intent);
    }

    public static void g(Activity activity)
    {
        Intent intent = new Intent();
        intent.setClass(activity, com/cyberlink/beautycircle/controller/activity/DeepLinkHistoryActivity);
        activity.startActivity(intent);
    }
}
