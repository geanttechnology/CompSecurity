// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.SimpleAdapter;
import com.pipcamera.activity.SettingActivity;
import com.wantu.weibo.other.facebook.DialogError;
import com.wantu.weibo.other.facebook.FacebookError;
import java.util.Iterator;
import java.util.Set;

public final class ry
    implements zd
{

    final SettingActivity a;

    private ry(SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }

    public ry(SettingActivity settingactivity, com.pipcamera.activity.SettingActivity._cls1 _pcls1)
    {
        this(settingactivity);
    }

    public void a()
    {
    }

    public void a(Bundle bundle)
    {
        String s1;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); Log.v("lb", (new StringBuilder()).append("facebook keys =").append(s1).toString()))
        {
            s1 = (String)iterator.next();
        }

        String s = bundle.getString("access_token");
        String s2 = bundle.getString("expires_in");
        bundle.getString("code");
        bundle = a.getSharedPreferences("com.wantu.android.WantuSetting", 0).edit();
        bundle.putBoolean("com.wantu.android.facebook.isconnected.key", true);
        bundle.putString("com.wantu.android.facebook.accesstoken.key", s);
        bundle.putString("com.wantu.android.facebook.accesstoken.expire.key", s2);
        bundle.commit();
        SettingActivity.b(a);
        if (SettingActivity.c(a) != null)
        {
            SettingActivity.c(a).notifyDataSetChanged();
        }
    }

    public void a(DialogError dialogerror)
    {
    }

    public void a(FacebookError facebookerror)
    {
    }
}
