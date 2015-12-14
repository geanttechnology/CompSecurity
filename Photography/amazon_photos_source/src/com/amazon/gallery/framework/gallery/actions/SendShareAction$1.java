// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.Comparator;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            SendShareAction

class val.pm
    implements Comparator
{

    final SendShareAction this$0;
    final PackageManager val$pm;

    public int compare(ResolveInfo resolveinfo, ResolveInfo resolveinfo1)
    {
        return resolveinfo.loadLabel(val$pm).toString().compareTo(resolveinfo1.loadLabel(val$pm).toString());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((ResolveInfo)obj, (ResolveInfo)obj1);
    }

    ()
    {
        this$0 = final_sendshareaction;
        val$pm = PackageManager.this;
        super();
    }
}
