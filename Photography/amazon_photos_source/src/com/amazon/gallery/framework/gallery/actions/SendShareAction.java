// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            GenericShareAction

public class SendShareAction extends GenericShareAction
{

    private static final String TAG = com/amazon/gallery/framework/gallery/actions/SendShareAction.getName();

    public SendShareAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, ShareStore sharestore, RestClient restclient, Profiler profiler)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e0097, sharestore, restclient, profiler);
    }

    private void displayNoAppsDialog()
    {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setMessage(0x7f0e00f2);
        builder.setPositiveButton(0x7f0e0093, null);
        builder.create().show();
    }

    protected void startActivity(Intent intent)
    {
        final PackageManager pm = context.getPackageManager();
        Object obj = pm.queryIntentActivities(intent, 0);
        if (((List) (obj)).isEmpty())
        {
            displayNoAppsDialog();
            return;
        }
        Collections.sort(((List) (obj)), new Comparator() {

            final SendShareAction this$0;
            final PackageManager val$pm;

            public int compare(ResolveInfo resolveinfo1, ResolveInfo resolveinfo2)
            {
                return resolveinfo1.loadLabel(pm).toString().compareTo(resolveinfo2.loadLabel(pm).toString());
            }

            public volatile int compare(Object obj1, Object obj2)
            {
                return compare((ResolveInfo)obj1, (ResolveInfo)obj2);
            }

            
            {
                this$0 = SendShareAction.this;
                pm = packagemanager;
                super();
            }
        });
        pm = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            ResolveInfo resolveinfo = (ResolveInfo)((Iterator) (obj)).next();
            String s = resolveinfo.activityInfo.packageName;
            if (!context.getPackageName().equals(s))
            {
                Intent intent1 = new Intent(intent);
                intent1.setPackage(s);
                intent1.setClassName(resolveinfo.activityInfo.packageName, resolveinfo.activityInfo.name);
                pm.add(intent1);
            }
        } while (true);
        intent = Intent.createChooser((Intent)pm.remove(pm.size() - 1), null);
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])pm.toArray(new Parcelable[pm.size()]));
        context.startActivity(intent);
    }

}
