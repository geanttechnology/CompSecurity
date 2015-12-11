// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.MenuItem;
import com.jumio.netswipe.sdk.activity.ScanCardActivity;

public class db
    implements android.view.MenuItem.OnMenuItemClickListener
{

    final ScanCardActivity a;

    public db(ScanCardActivity scancardactivity)
    {
        a = scancardactivity;
        super();
    }

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        ScanCardActivity.e(a);
        return false;
    }
}
