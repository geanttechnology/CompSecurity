// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Fragment;
import android.content.Intent;
import com.jumio.netverify.sdk.core.ModelTemplate;

// Referenced classes of package jumiomobile:
//            ht, ha, hr, ll

public interface lm
{

    public abstract void cancelSDK(ht ht);

    public abstract void checkOrientation();

    public abstract void finishSDK(Intent intent, int i);

    public abstract ha getController();

    public abstract ModelTemplate getModel();

    public abstract boolean isScanViewNext(hr hr);

    public abstract void registerActivityCallback(ll ll);

    public abstract void showFragment(Fragment fragment);

    public abstract void showFragment(hr hr);
}
