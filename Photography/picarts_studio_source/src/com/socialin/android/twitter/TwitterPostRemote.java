// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.d;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.aj;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.File;
import java.util.UUID;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.media.ImageUpload;
import twitter4j.media.ImageUploadFactory;
import twitter4j.media.MediaProvider;

public class TwitterPostRemote
{

    private static final String TAG = com/socialin/android/twitter/TwitterPostRemote.getSimpleName();
    private final String TWITTER_TOO_LARGE_MEDIA = "One or more of the uploaded media is too large.";
    private Context context;
    private String path;
    private SharedPreferences settings;
    private String tweetLink;
    private String tweetTitle;
    private aj twitterSessionListener;

    public TwitterPostRemote(String s, String s1, String s2, Context context1)
    {
        settings = null;
        path = s;
        tweetLink = s2;
        tweetTitle = s1;
        context = context1;
        settings = context1.getSharedPreferences("TwitterPrefs", 0);
    }

    private String getTwitterTempDir()
    {
        return (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f08096f)).toString();
    }

    private AccessToken loadAccessToken()
    {
        Object obj1 = null;
        Object obj = SocialinV3.getInstance().getUserTwitterToken();
        String s = SocialinV3.getInstance().getUserTwitterSecret();
        if (obj != null && s != null)
        {
            obj = new AccessToken(((String) (obj)), s);
        } else
        {
            String s1 = settings.getString("user_token", null);
            String s2 = settings.getString("user_secret", null);
            obj = obj1;
            if (s1 != null)
            {
                obj = obj1;
                if (s2 != null)
                {
                    return new AccessToken(s1, s2);
                }
            }
        }
        return ((AccessToken) (obj));
    }

    private void resizeAndDoTwitterPost()
    {
        if (TextUtils.isEmpty(path)) goto _L2; else goto _L1
_L1:
        Bitmap bitmap;
        Bitmap bitmap1;
        bitmap = c.a(path, null);
        int i = bitmap.getWidth();
        int j = bitmap.getHeight();
        float f = 1024F / (float)Math.max(i, j);
        d.b(TAG, new Object[] {
            "resizeAndDoTwitterPost", (new StringBuilder("orig= ")).append(i).append("x").append(j).append(" resize_to= ").append((int)((float)i * f)).append("x").append((int)((float)j * f)).toString()
        });
        bitmap1 = c.a(bitmap, (int)((float)i * f), (int)((float)j * f), false);
        if (bitmap1 == null) goto _L4; else goto _L3
_L3:
        String s = UUID.randomUUID().toString();
        String s1 = getTwitterTempDir();
        w.a(new File(s1, s), bitmap1, android.graphics.Bitmap.CompressFormat.PNG, context);
        s = (new StringBuilder()).append(s1).append("/").append(s).toString();
        if (bitmap != null && !bitmap.isRecycled())
        {
            bitmap.recycle();
        }
        if (bitmap1 != null && !bitmap1.isRecycled())
        {
            bitmap1.recycle();
        }
        doTwitterPost(s);
_L6:
        return;
_L4:
        if (twitterSessionListener != null)
        {
            twitterSessionListener.b();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (twitterSessionListener != null)
        {
            twitterSessionListener.b();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void showMessage(int i)
    {
        (new Handler()).post(new Runnable(i) {

            private int a;
            private TwitterPostRemote b;

            public final void run()
            {
                Toast.makeText(b.context.getApplicationContext(), a, 1).show();
            }

            
            {
                b = TwitterPostRemote.this;
                a = i;
                super();
            }
        });
    }

    public void clearTempDir()
    {
        FileUtils.a(new File(getTwitterTempDir()));
    }

    public void doTwitterPost()
    {
        doTwitterPost(path);
    }

    public void doTwitterPost(String s)
    {
        boolean flag = true;
        Object obj = loadAccessToken();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (TextUtils.isEmpty(((AccessToken) (obj)).getToken()) || TextUtils.isEmpty(((AccessToken) (obj)).getTokenSecret())) goto _L2; else goto _L3
_L3:
        int i = 1;
_L8:
        if (i == 0) goto _L5; else goto _L4
_L4:
        Object obj1;
        Object obj2;
        obj1 = (new TwitterFactory()).getInstance();
        ((Twitter) (obj1)).setOAuthConsumer("N3aQqOLTNqrDcwTRTmUBOg", "VSLR3p6DYYxS5l7LvAQmTfCtmDLfHwBUveKSbH9Bw");
        ((Twitter) (obj1)).setOAuthAccessToken(((AccessToken) (obj)));
        obj1 = (new ConfigurationBuilder()).setOAuthConsumerKey("N3aQqOLTNqrDcwTRTmUBOg").setOAuthConsumerSecret("VSLR3p6DYYxS5l7LvAQmTfCtmDLfHwBUveKSbH9Bw").setOAuthAccessToken(((AccessToken) (obj)).getToken()).setOAuthAccessTokenSecret(((AccessToken) (obj)).getTokenSecret()).build();
        obj2 = new StringBuilder(" #PicsArt");
        if (tweetLink == null)
        {
            break MISSING_BLOCK_LABEL_457;
        }
        obj = (new StringBuilder("\n ")).append(tweetLink).toString();
_L9:
        obj2 = ((StringBuilder) (obj2)).append(((String) (obj))).toString();
        obj = tweetTitle;
        if (((String) (obj2)).length() > 87)
        {
            obj = "";
            break MISSING_BLOCK_LABEL_173;
        }
        i = 87 - ((String) (obj2)).length();
        if (i < tweetTitle.length())
        {
            obj = tweetTitle.substring(0, i);
        }
          goto _L6
_L5:
        if (twitterSessionListener != null)
        {
            twitterSessionListener.b();
            return;
        }
          goto _L7
_L6:
        try
        {
            obj = (new StringBuilder()).append(((String) (obj))).append(((String) (obj2))).toString();
            Log.i(TAG, (new StringBuilder("tweet= ")).append(((String) (obj))).append(" \ntweet size = ").append(((String) (obj)).length()).toString());
            s = (new ImageUploadFactory(((twitter4j.conf.Configuration) (obj1)))).getInstance(MediaProvider.TWITTER).upload(new File(s), ((String) (obj)));
            Log.i(TAG, (new StringBuilder("url= ")).append(s).toString());
            if (twitterSessionListener != null)
            {
                twitterSessionListener.a();
            }
            clearTempDir();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            d.b(TAG, "doTwitterPost", s);
        }
        if (s instanceof TwitterException)
        {
            s = (TwitterException)s;
            if (s.getErrorMessage() != null && s.getErrorMessage().contains("One or more of the uploaded media is too large."))
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 0;
            }
            if (i != 0 || s.getErrorCode() == 193)
            {
                resizeAndDoTwitterPost();
                return;
            }
        }
        if (twitterSessionListener != null)
        {
            twitterSessionListener.b();
        }
        clearTempDir();
_L7:
        return;
_L2:
        i = 0;
          goto _L8
        obj = "";
          goto _L9
    }

    public void setTwitterSessionListener(aj aj1)
    {
        twitterSessionListener = aj1;
    }


}
