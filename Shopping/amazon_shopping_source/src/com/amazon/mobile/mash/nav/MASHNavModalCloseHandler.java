// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.amazon.mobile.mash.api.MASHNavigationPlugin;
import java.util.List;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavHandler, MASHNavInterface, MASHNavOperation, MASHNavException

public class MASHNavModalCloseHandler extends MASHNavHandler
{

    public MASHNavModalCloseHandler(MASHNavigationPlugin mashnavigationplugin, List list, int i)
    {
        super(mashnavigationplugin, list, i);
    }

    public void navigate()
    {
        Activity activity = getMASHNavigationPlugin().cordova.getActivity();
        if ((activity instanceof MASHNavInterface) && activity.getClass() == ((MASHNavInterface)activity).getModalActivityClass())
        {
            Intent intent = new Intent();
            intent.putExtra("remainingOperations", getRemainingOperations());
            activity.setResult(10001, intent);
            activity.finish();
            return;
        } else
        {
            Log.e("MASHNavModalCloseHandler", (new StringBuilder()).append("MASH API can not do operation ").append(getCurrentOperation().getOperation()).toString());
            throw new MASHNavException((new StringBuilder()).append("Not able to do op. ").append(getCurrentOperation().getOperation()).toString());
        }
    }
}
