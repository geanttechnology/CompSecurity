// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.share;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.util.Log;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.util.Util;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.mShop.share:
//            SharableAppInfo, SocialAppConfig

public class WechatSDKManager
{
    private static class SendRequestTask extends AsyncTask
    {

        protected transient Boolean doInBackground(WechatMessageParams awechatmessageparams[])
        {
            Object obj = awechatmessageparams[0].getShareContext();
            Intent intent = awechatmessageparams[0].getShareIntent();
            boolean flag = awechatmessageparams[0].isShareToFriend();
            WXMediaMessage wxmediamessage = WechatSDKManager.buildMessage(((Context) (obj)), intent, flag);
            awechatmessageparams = new com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req();
            awechatmessageparams.transaction = WechatSDKManager.buildTransaction(intent);
            awechatmessageparams.message = wxmediamessage;
            if (flag)
            {
                awechatmessageparams.scene = 0;
            } else
            {
                awechatmessageparams.scene = 1;
            }
            obj = WechatSDKManager.getAPIHandle(((Context) (obj)));
            if (obj == null)
            {
                return Boolean.valueOf(false);
            } else
            {
                return Boolean.valueOf(((IWXAPI) (obj)).sendReq(awechatmessageparams));
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((WechatMessageParams[])aobj);
        }

        private SendRequestTask()
        {
        }

    }

    private static class SendResponseTask extends AsyncTask
    {

        protected transient Boolean doInBackground(WechatMessageParams awechatmessageparams[])
        {
            Object obj = awechatmessageparams[0].getShareContext();
            WXMediaMessage wxmediamessage = WechatSDKManager.buildMessage(((Context) (obj)), awechatmessageparams[0].getShareIntent(), awechatmessageparams[0].isShareToFriend());
            awechatmessageparams = new com.tencent.mm.sdk.modelmsg.GetMessageFromWX.Resp();
            awechatmessageparams.transaction = WechatSDKManager.sPendingTransaction;
            awechatmessageparams.message = wxmediamessage;
            obj = WechatSDKManager.getAPIHandle(((Context) (obj)));
            if (obj == null)
            {
                return Boolean.valueOf(false);
            } else
            {
                return Boolean.valueOf(((IWXAPI) (obj)).sendResp(awechatmessageparams));
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((WechatMessageParams[])aobj);
        }

        private SendResponseTask()
        {
        }

    }

    private static class WechatMessageParams
    {

        private final Context context;
        private final Intent intent;
        private boolean shareToFriend;

        public Context getShareContext()
        {
            return context;
        }

        public Intent getShareIntent()
        {
            return intent;
        }

        public boolean isShareToFriend()
        {
            return shareToFriend;
        }

        public WechatMessageParams(Context context1, Intent intent1, boolean flag)
        {
            context = context1;
            intent = intent1;
            shareToFriend = flag;
        }
    }


    private static String sPendingTransaction = null;
    private static IWXAPI sWXapi;
    private static SharableAppInfo sWechatLauncherInfo = new SharableAppInfo(null, null, SocialAppConfig.getWechatPackageName(), "we_upd_awd_wl", SocialAppConfig.getDefaultPriority(), null);

    public WechatSDKManager()
    {
    }

    private static WXMediaMessage buildMessage(Context context, Intent intent, boolean flag)
    {
        String s1 = intent.getStringExtra("android.intent.extra.TEXT");
        String s = intent.getStringExtra("android.intent.extra.SUBJECT");
        Object obj;
        if (!Util.isEmpty(s1) && !Util.isEmpty(s))
        {
            if (((Matcher) (obj = Pattern.compile("(http|https)://\\S*").matcher(s1))).find())
            {
                Object obj1 = s1.substring(0, ((Matcher) (obj)).start());
                String s2 = s1.substring(((Matcher) (obj)).start(), ((Matcher) (obj)).end());
                String s3 = context.getResources().getString(com.amazon.mShop.android.lib.R.string.sharing_sms_heading);
                obj = obj1;
                if (s1.startsWith(s3))
                {
                    obj = ((String) (obj1)).replace(s3, "").trim();
                }
                obj1 = new WXMediaMessage(new WXWebpageObject(s2));
                if (flag)
                {
                    obj1.title = s;
                } else
                {
                    obj1.title = ((String) (obj));
                }
                obj1.description = ((String) (obj));
                ((WXMediaMessage) (obj1)).setThumbImage(processThumbnail(context, intent));
                return ((WXMediaMessage) (obj1));
            }
        }
        return null;
    }

    private static String buildTransaction(Intent intent)
    {
        intent = intent.getStringExtra("android.intent.extra.TEXT");
        if (intent == null)
        {
            return String.valueOf(System.currentTimeMillis());
        } else
        {
            return (new StringBuilder()).append(intent).append(System.currentTimeMillis()).toString();
        }
    }

    public static void clearPendingTransaction()
    {
        sPendingTransaction = null;
    }

    public static IWXAPI getAPIHandle(Context context)
    {
        if (sWXapi == null)
        {
            sWXapi = WXAPIFactory.createWXAPI(context, "wx58ea2d5aab116b83", true);
            if (sWXapi != null)
            {
                sWXapi.registerApp("wx58ea2d5aab116b83");
            }
        }
        return sWXapi;
    }

    public static String getIconLaunchReftag()
    {
        return "we_an_il";
    }

    public static SharableAppInfo getWechatLauncherInfo()
    {
        return sWechatLauncherInfo;
    }

    public static boolean hasPendingTransaction()
    {
        return sPendingTransaction != null;
    }

    private static Bitmap paddingThumbnail(Bitmap bitmap)
    {
        int i = bitmap.getHeight();
        int j = bitmap.getWidth();
        Bitmap bitmap1;
        if (i != j)
        {
            if (i > j)
            {
                Bitmap bitmap2 = Bitmap.createBitmap(i, i, android.graphics.Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap2);
                canvas.drawARGB(255, 255, 255, 255);
                canvas.drawBitmap(bitmap, (i - j) / 2, 0.0F, null);
                bitmap = bitmap2;
            } else
            {
                Bitmap bitmap3 = Bitmap.createBitmap(j, j, android.graphics.Bitmap.Config.ARGB_8888);
                Canvas canvas1 = new Canvas(bitmap3);
                canvas1.drawARGB(255, 255, 255, 255);
                canvas1.drawBitmap(bitmap, 0.0F, (j - i) / 2, null);
                bitmap = bitmap3;
            }
        }
        bitmap1 = bitmap;
        if (bitmap.getWidth() > 200)
        {
            bitmap1 = Bitmap.createScaledBitmap(bitmap, 200, 200, false);
        }
        return bitmap1;
    }

    private static Bitmap processThumbnail(Context context, Intent intent)
    {
        Object obj = null;
        if (!intent.hasExtra("mShop.android.intent.extra.THUMBNAIL")) goto _L2; else goto _L1
_L1:
        intent = intent.getByteArrayExtra("mShop.android.intent.extra.THUMBNAIL");
        context = obj;
        if (intent != null)
        {
            try
            {
                context = paddingThumbnail(BitmapFactory.decodeByteArray(intent, 0, intent.length));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                LRUCache.reduceByPercent(50);
                return null;
            }
        }
_L4:
        return context;
_L2:
        context = obj;
        if (!intent.hasExtra("imgUrl")) goto _L4; else goto _L3
_L3:
        context = intent.getStringExtra("imgUrl");
        try
        {
            context = (new URL(context)).openConnection();
            context.setConnectTimeout(1000);
            context.setReadTimeout(3000);
            intent = BitmapFactory.decodeStream(context.getInputStream());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (context instanceof OutOfMemoryError)
            {
                LRUCache.reduceByPercent(50);
            }
            Log.e("WechatSDKManager", (new StringBuilder()).append("Failed to load product thumbnail from url, ").append(context.toString()).toString());
            return null;
        }
        context = obj;
        if (intent == null) goto _L4; else goto _L5
_L5:
        context = paddingThumbnail(intent);
        return context;
    }

    public static boolean sendRequest(Context context, Intent intent, String s)
    {
        context = new WechatMessageParams(context, intent, s.equals(SocialAppConfig.getWechatPackageName()));
        intent = new SendRequestTask();
        intent.execute(new WechatMessageParams[] {
            context
        });
        boolean flag;
        try
        {
            flag = ((Boolean)intent.get()).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return flag;
    }

    public static boolean sendResponse(Context context, Intent intent)
    {
        context = new WechatMessageParams(context, intent, true);
        intent = new SendResponseTask();
        intent.execute(new WechatMessageParams[] {
            context
        });
        boolean flag;
        try
        {
            flag = ((Boolean)intent.get()).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return flag;
    }

    public static void setPendingTransaction(String s)
    {
        sPendingTransaction = s;
    }

    public static boolean timelineSupported(Context context)
    {
        for (context = getAPIHandle(context); context == null || context.getWXAppSupportAPI() < 0x21020001;)
        {
            return false;
        }

        return true;
    }




}
