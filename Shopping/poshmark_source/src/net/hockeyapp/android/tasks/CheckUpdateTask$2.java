// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.tasks;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;
import net.hockeyapp.android.UpdateManager;
import net.hockeyapp.android.utils.VersionCache;
import org.json.JSONArray;

// Referenced classes of package net.hockeyapp.android.tasks:
//            CheckUpdateTask

class val.updateInfo
    implements android.content.ClickListener
{

    final CheckUpdateTask this$0;
    final JSONArray val$updateInfo;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (getCachingEnabled())
        {
            VersionCache.setVersionInfo(CheckUpdateTask.access$100(CheckUpdateTask.this), "[]");
        }
        dialoginterface = new WeakReference(CheckUpdateTask.access$100(CheckUpdateTask.this));
        if (UpdateManager.fragmentsSupported().booleanValue() && UpdateManager.runsOnTablet(dialoginterface).booleanValue())
        {
            CheckUpdateTask.access$200(CheckUpdateTask.this, val$updateInfo);
            return;
        } else
        {
            CheckUpdateTask.access$300(CheckUpdateTask.this, val$updateInfo, Boolean.valueOf(false));
            return;
        }
    }

    r()
    {
        this$0 = final_checkupdatetask;
        val$updateInfo = JSONArray.this;
        super();
    }
}
