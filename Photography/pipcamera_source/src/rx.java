// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.flurry.android.FlurryAgent;
import com.pipcamera.activity.PhotoShareActivity;
import com.pipcamera.activity.ShareEditActivity;
import com.wantu.weibo.other.facebook.DialogError;
import com.wantu.weibo.other.facebook.FacebookError;

public final class rx
    implements zd
{

    final PhotoShareActivity a;

    private rx(PhotoShareActivity photoshareactivity)
    {
        a = photoshareactivity;
        super();
    }

    public rx(PhotoShareActivity photoshareactivity, com.pipcamera.activity.PhotoShareActivity._cls1 _pcls1)
    {
        this(photoshareactivity);
    }

    public void a()
    {
    }

    public void a(Bundle bundle)
    {
        String s = bundle.getString("access_token");
        String s1 = bundle.getString("expires_in");
        bundle.getString("code");
        bundle = a.getSharedPreferences("com.wantu.android.WantuSetting", 0).edit();
        bundle.putBoolean("com.wantu.android.facebook.isconnected.key", true);
        bundle.putString("com.wantu.android.facebook.accesstoken.key", s);
        bundle.putString("com.wantu.android.facebook.accesstoken.expire.key", s1);
        bundle.commit();
        bundle = new Intent(a, com/pipcamera/activity/ShareEditActivity);
        bundle.putExtra("com.wantu.android.weibo", "facebook");
        a.startActivity(bundle);
        FlurryAgent.logEvent("PhotoSharebyFacebook");
    }

    public void a(DialogError dialogerror)
    {
    }

    public void a(FacebookError facebookerror)
    {
    }
}
