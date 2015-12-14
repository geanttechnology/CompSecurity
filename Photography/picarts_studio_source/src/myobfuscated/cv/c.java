// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cv;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.studio.EditingData;
import com.socialin.android.a;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.AddConnectionController;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.TwitterConnection;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.constants.b;
import com.socialin.android.d;
import com.socialin.android.dropbox.DropboxStartActivity;
import com.socialin.android.googledrive.OpenGoogleDriveActivity;
import com.socialin.android.instagram.InstagramMainActivity;
import com.socialin.android.social.activity.SocialConnectionsActivity;
import com.socialin.android.social.activity.SocialMainActivity;
import com.socialin.android.twitter.TwitterOAuthActivity;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import java.io.File;
import java.util.List;
import myobfuscated.f.m;
import org.json.JSONObject;

public class c
    implements b
{

    private static final String c = myobfuscated/cv/c.getSimpleName();
    private static int d;

    public c()
    {
    }

    public static int a()
    {
        return d;
    }

    public static String a(Context context, String s1)
    {
        Object obj = new Intent("android.intent.action.SEND", null);
        ((Intent) (obj)).setPackage("com.instagram.android");
        ((Intent) (obj)).setDataAndType(null, "image/*");
        Object obj1 = context.getPackageManager().queryIntentActivities(((Intent) (obj)), 0x10000);
        obj = s1;
        if (obj1 != null)
        {
            obj = s1;
            if (!((List) (obj1)).isEmpty())
            {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setPackage("com.instagram.android");
                intent.setClassName(((ResolveInfo)((List) (obj1)).get(0)).activityInfo.packageName, ((ResolveInfo)((List) (obj1)).get(0)).activityInfo.name);
                intent.putExtra("android.intent.extra.TEXT", "#PicsArt");
                intent.setType("image/*");
                obj1 = BitmapFactory.decodeFile(s1);
                obj = s1;
                if (obj1 != null)
                {
                    obj = s1;
                    if (((Bitmap) (obj1)).getWidth() != ((Bitmap) (obj1)).getHeight())
                    {
                        Bitmap bitmap = w.a(((Bitmap) (obj1)));
                        String s2 = s1.substring(0, s1.lastIndexOf(File.separator));
                        String s3 = (new StringBuilder()).append(s1.substring(s1.lastIndexOf(File.separator) + 1)).append("_insta").toString();
                        obj1 = EditingData.a(s1);
                        obj = s1;
                        if ((new File(s1)).delete())
                        {
                            obj = w.a(s2, s3, bitmap, context, android.graphics.Bitmap.CompressFormat.JPEG, false).getAbsolutePath();
                            if (SocialinV3.getInstance().isRegistered())
                            {
                                s1 = String.valueOf(SocialinV3.getInstance().getUser().id);
                            } else
                            {
                                s1 = null;
                            }
                            m.a(((String) (obj)), s1, ((EditingData) (obj1)).c().toString());
                        }
                    }
                }
                intent.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(((String) (obj))).toString()));
                context.startActivity(intent);
            }
        }
        return ((String) (obj));
    }

    public static void a(int i)
    {
        d = i;
    }

    public static void a(Activity activity)
    {
        com.socialin.android.d.b(c, new Object[] {
            "Network error occurred"
        });
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            g(activity);
            return;
        } else
        {
            activity.runOnUiThread(new Runnable(activity) {

                private Activity a;

                public final void run()
                {
                    c.f(a);
                }

            
            {
                a = activity;
                super();
            }
            });
            return;
        }
    }

    public static void a(Activity activity, int i, boolean flag, String s1, int j, int k, String s2, String s3)
    {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClassName(activity.getPackageName(), "com.socialin.android.share.SaveExportActivity");
        intent.setFlags(0x4200000);
        intent.putExtra("showPublicGallery", false);
        intent.putExtra("isReturnResult", flag);
        intent.putExtra("path", s1);
        intent.putExtra("from", s2);
        intent.putExtra("action", s3);
        intent.putExtra("imageWidth", j);
        intent.putExtra("imageHeight", k);
        a(intent, activity);
        activity.startActivityForResult(intent, i);
    }

    public static void a(Activity activity, Intent intent)
    {
        if (!s.a(activity))
        {
            a(activity);
            return;
        } else
        {
            intent.setClass(activity, com/socialin/android/googledrive/OpenGoogleDriveActivity);
            activity.startActivityForResult(intent, 1340);
            return;
        }
    }

    public static void a(Activity activity, ImageItem imageitem, long l, String s1, String s2, String s3)
    {
        Intent intent = new Intent();
        intent.setClassName(activity.getPackageName(), "com.socialin.android.picsart.upload.PicsartUploadEditActivity");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("is_edit_mode", false);
        intent.putExtra("item", imageitem);
        intent.putExtra("item_id", l);
        intent.putExtra("path", s1);
        intent.putExtra("origin", s2);
        intent.putExtra("action", s3);
        intent.putExtra("gifEditorExport", false);
        activity.startActivityForResult(intent, 91);
    }

    public static void a(Activity activity, String s1)
    {
        b(activity, s1, ((String) (null)));
    }

    public static void a(Activity activity, String s1, int i, int j)
    {
        a(activity, 0, false, s1, i, j, null, null);
    }

    public static void a(Activity activity, String s1, int i, int j, String s2, String s3)
    {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClassName(activity.getPackageName(), "com.socialin.android.share.SaveExportActivity");
        intent.setFlags(0x4200000);
        intent.putExtra("path", s1);
        intent.putExtra("from", s2);
        intent.putExtra("action", s3);
        intent.putExtra("showPublicGallery", false);
        intent.putExtra("imageWidth", i);
        intent.putExtra("imageHeight", j);
        intent.putExtra("fixOrientation", true);
        a(intent, activity);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, String s1, String s2)
    {
        s1.contains(".gif");
        b(activity, s1, s2);
    }

    public static void a(Activity activity, String s1, String s2, String s3)
    {
        a(activity, ((ImageItem) (null)), -1L, s1, s2, s3);
    }

    public static void a(Activity activity, boolean flag, int i)
    {
        if (!s.a(activity))
        {
            a(activity);
            return;
        }
        String s1 = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append(File.separator).append(activity.getString(0x7f0808fb)).append(File.separator).append(activity.getString(0x7f0808c0)).append(File.separator).toString();
        Intent intent = new Intent(activity, com/socialin/android/dropbox/DropboxStartActivity);
        intent.setFlags(0x400000);
        intent.setFlags(0x4000000);
        intent.putExtra("multipleCheckMode", flag);
        intent.putExtra("multipleCheckPhotoCount", i);
        intent.putExtra("dropboxMethod", "dropboxMethodGet");
        intent.putExtra("dropboxCacheDir", s1);
        if (flag)
        {
            i = 1339;
        } else
        {
            i = 1238;
        }
        activity.startActivityForResult(intent, i);
    }

    public static void a(Context context)
    {
        context.startActivity(b(context));
    }

    public static void a(Intent intent, Activity activity)
    {
        intent.putExtra("package", activity.getPackageName());
        intent.putExtra("subject", activity.getString(0x7f0808af));
        intent.putExtra("body", Utils.e(activity));
        intent.putExtra("subFolderName", activity.getString(0x7f0808fb));
        intent.putExtra("orientation", activity.getResources().getConfiguration().orientation);
        intent.putExtra("showContactIcon", false);
        intent.putExtra("fbAppId", activity.getString(0x7f0808e2));
        intent.putExtra("fbAppName", activity.getString(0x7f0808ad));
        intent.putExtra("fbToken", SocialinV3.getInstance().getUserFbToken());
        intent.putExtra("fApiKey", activity.getString(0x7f0808ea));
        intent.putExtra("fApiSecret", activity.getString(0x7f0808eb));
        intent.putExtra("twitterConsumer", activity.getString(0x7f080976));
        intent.putExtra("twitterConsumerSecret", activity.getString(0x7f080977));
        intent.putExtra("dropboxConsumerKey", activity.getString(0x7f0808df));
        intent.putExtra("dropboxConsumerSecret", activity.getString(0x7f0808e0));
        intent.putExtra("foursquareClinetId", activity.getString(0x7f0808f0));
        intent.putExtra("foursquareClinetSecret", activity.getString(0x7f0808f1));
        intent.putExtra("deviantArtClinetId", activity.getString(0x7f0808da));
        intent.putExtra("deviantArtClinetSecret", activity.getString(0x7f0808db));
        intent.putExtra("showContactIcon", false);
    }

    public static void a(Intent intent, a a1)
    {
        if (intent != null)
        {
            TwitterConnection twitterconnection = new TwitterConnection();
            String s1 = intent.getStringExtra("tw_user_token");
            twitterconnection.setUserName(intent.getStringExtra("tw_user_name"));
            twitterconnection.setUserScreenName(intent.getStringExtra("tw_user_screen_name"));
            twitterconnection.setProfileImgUrl(intent.getStringExtra("tw_user_profile_url"));
            twitterconnection.setTokenSecret(intent.getStringExtra("tw_user_token_secret"));
            twitterconnection.setToken(s1);
            twitterconnection.token = s1;
            twitterconnection.connectionId = intent.getStringExtra("tw_user_id");
            intent = new AddConnectionController();
            intent.setAddControllerListener(a1);
            intent.doRequest(null, twitterconnection);
        }
    }

    public static void a(String s1, Activity activity)
    {
        if (!s.a(activity))
        {
            a(activity);
            return;
        } else
        {
            Intent intent = new Intent(activity, com/socialin/android/twitter/TwitterOAuthActivity);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(0x24000000);
            intent.putExtra("path", s1);
            intent.putExtra("twitterMethod", "createTweetWithPic");
            intent.putExtra("android.intent.extra.TEXT", "#PicsArt");
            intent.putExtra("item_id", -1L);
            activity.startActivityForResult(intent, 1234);
            return;
        }
    }

    public static Intent b(Context context)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        String s1 = context.getString(0x7f0808c8);
        s1 = context.getString(m.e(context, (new StringBuilder("market_url_")).append(s1).toString()));
        if ("".equals(s1))
        {
            intent.setData(Uri.parse((new StringBuilder("market://details?id=")).append(context.getPackageName()).toString()));
            return intent;
        } else
        {
            intent.setData(Uri.parse((new StringBuilder()).append(s1).append(context.getPackageName()).toString()));
            return intent;
        }
    }

    private static void b(Activity activity, String s1, String s2)
    {
        a(activity, ((ImageItem) (null)), -1L, s1, s2, null);
    }

    public static void b(Activity activity, boolean flag, int i)
    {
        if (!s.a(activity))
        {
            a(activity);
            return;
        }
        Intent intent = new Intent(activity, com/socialin/android/social/activity/SocialMainActivity);
        intent.setFlags(0x400000);
        intent.setFlags(0x4000000);
        intent.putExtra("key_social_type", 1);
        intent.putExtra("method", "get");
        intent.putExtra("multipleCheckMode", flag);
        intent.putExtra("multipleCheckPhotoCount", i);
        if (flag)
        {
            i = 1336;
        } else
        {
            i = 1224;
        }
        activity.startActivityForResult(intent, i);
    }

    public static boolean b(Activity activity)
    {
        if (!SocialinV3.getInstance().isRegistered())
        {
            com.socialin.android.d.b((new StringBuilder()).append(myobfuscated/cv/c.getSimpleName()).append(" - ").toString(), "User is not registered!");
            if (activity != null && !activity.isFinishing())
            {
                Intent intent = new Intent();
                intent.setClassName(activity, "com.socialin.android.picsart.profile.activity.LoginFragmentActivity");
                intent.putExtra("from", activity.getClass().getSimpleName());
                if (activity.getIntent() != null && activity.getIntent().getExtras() != null)
                {
                    intent.putExtras(activity.getIntent().getExtras());
                }
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setFlags(0x24000000);
                activity.startActivityForResult(intent, 4538);
            }
            return false;
        } else
        {
            return true;
        }
    }

    public static void c(Activity activity)
    {
        if (!s.a(activity))
        {
            a(activity);
            return;
        } else
        {
            Intent intent = new Intent(activity, com/socialin/android/social/activity/SocialConnectionsActivity);
            intent.putExtra("isFromSettings", true);
            activity.startActivity(intent);
            return;
        }
    }

    public static void c(Activity activity, boolean flag, int i)
    {
        if (!s.a(activity))
        {
            a(activity);
            return;
        }
        Intent intent = new Intent(activity, com/socialin/android/instagram/InstagramMainActivity);
        intent.setFlags(0x400000);
        intent.setFlags(0x4000000);
        intent.putExtra("multipleCheckMode", flag);
        intent.putExtra("multipleCheckPhotoCount", i);
        if (flag)
        {
            i = 1342;
        } else
        {
            i = 1341;
        }
        activity.startActivityForResult(intent, i);
    }

    public static void d(Activity activity)
    {
        String s1 = (new StringBuilder("fb://page/")).append(activity.getString(0x7f0808e3)).toString();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s1));
        if (activity.getPackageManager().queryIntentActivities(intent, 0x10000).isEmpty())
        {
            String s2 = (new StringBuilder("http://facebook.com/")).append(activity.getString(0x7f0808e4)).toString();
            intent.putExtra("client_id", activity.getString(0x7f0808e2));
            intent.setData(Uri.parse(s2));
        }
        activity.startActivity(intent);
    }

    public static void d(Activity activity, boolean flag, int i)
    {
        if (!s.a(activity))
        {
            a(activity);
            return;
        }
        Intent intent = new Intent(activity, com/socialin/android/social/activity/SocialMainActivity);
        intent.setFlags(0x400000);
        intent.setFlags(0x4000000);
        intent.putExtra("key_social_type", 2);
        intent.putExtra("method", "get");
        intent.putExtra("multipleCheckMode", flag);
        intent.putExtra("multipleCheckPhotoCount", i);
        if (flag)
        {
            i = 1335;
        } else
        {
            i = 1235;
        }
        activity.startActivityForResult(intent, i);
    }

    public static void e(Activity activity)
    {
        try
        {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("twitter://user?screen_name=")).append(activity.getString(0x7f080978)).toString())));
            return;
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(c, "openTwitterAppPage", exception);
        }
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/#!")).append(activity.getString(0x7f080978)).toString())));
    }

    public static void e(Activity activity, boolean flag, int i)
    {
        if (!s.a(activity))
        {
            a(activity);
            return;
        }
        Intent intent = new Intent(activity, com/socialin/android/social/activity/SocialMainActivity);
        intent.putExtra("key_social_type", 0);
        intent.putExtra("fApiKey", activity.getString(0x7f0808ea));
        intent.putExtra("fApiSecret", activity.getString(0x7f0808eb));
        intent.putExtra("multipleCheckMode", flag);
        intent.putExtra("multipleCheckPhotoCount", i);
        if (flag)
        {
            i = 1334;
        } else
        {
            i = 1222;
        }
        activity.startActivityForResult(intent, i);
    }

    static Dialog f(Activity activity)
    {
        return g(activity);
    }

    public static void f(Activity activity, boolean flag, int i)
    {
        Intent intent = new Intent();
        a(intent, activity);
        if (!s.a(activity))
        {
            a(activity);
            return;
        }
        intent.setClassName(activity.getPackageName(), "com.socialin.android.picsart.profile.activity.UserPhotosActivity");
        intent.putExtra("fromPicsin", true);
        intent.putExtra("profileUser", SocialinV3.getInstance().getUser());
        intent.putExtra("multipleCheckMode", flag);
        intent.putExtra("multipleCheckPhotoCount", i);
        intent.putExtra("contest_item", activity.getIntent().getBooleanExtra("contest_item", false));
        if (flag)
        {
            i = 1337;
        } else
        {
            i = 1236;
        }
        activity.startActivityForResult(intent, i);
    }

    private static Dialog g(Activity activity)
    {
        return DialogUtils.showNoNetworkDialog(activity, 0x7f080307, 0x7f080306, 0x7f080308, 0x7f0802a4, 0x108009b);
    }

}
