// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.instamag.activity.compose.MagComposeActivity;
import com.instamag.activity.compose.MagComposeFragement;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.io.File;
import java.util.HashMap;

public class bal
    implements Runnable
{

    final Bitmap a;
    final TPhotoComposeInfo b;
    final MagComposeFragement c;

    public bal(MagComposeFragement magcomposefragement, Bitmap bitmap, TPhotoComposeInfo tphotocomposeinfo)
    {
        c = magcomposefragement;
        a = bitmap;
        b = tphotocomposeinfo;
        super();
    }

    public void run()
    {
        if (c.mActivity == null)
        {
            return;
        }
        Object obj = sm.a(a);
        if (obj == null)
        {
            c.mActivity.runOnUiThread(new bam(this));
            return;
        }
        sm.a(((File) (obj)).getAbsolutePath(), c.mActivity);
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("resId", String.format("%d", new Object[] {
                Integer.valueOf(b.resId)
            }));
            hashmap.put("resType", String.format("%d", new Object[] {
                Integer.valueOf(b.typeId)
            }));
            FlurryAgent.logEvent("useMag", hashmap);
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        obj = ((File) (obj)).getAbsolutePath();
        c.mActivity.runOnUiThread(new ban(this, ((String) (obj))));
    }
}
