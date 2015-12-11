// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.view.MenuItem;
import android.view.SubMenu;
import dm;
import hl;
import lk;

public class ShareActionProvider extends dm
{

    private int c;
    private final lk d = new lk(this);
    private final Context e;
    private String f;

    public ShareActionProvider(Context context)
    {
        super(context);
        c = 4;
        f = "share_history.xml";
        e = context;
    }

    public static Context a(ShareActionProvider shareactionprovider)
    {
        return shareactionprovider.e;
    }

    public static String b(ShareActionProvider shareactionprovider)
    {
        return shareactionprovider.f;
    }

    public final void a(SubMenu submenu)
    {
        submenu.clear();
        hl hl1 = hl.a(e, f);
        android.content.pm.PackageManager packagemanager = e.getPackageManager();
        int k = hl1.a();
        int l = Math.min(k, c);
        for (int i = 0; i < l; i++)
        {
            ResolveInfo resolveinfo = hl1.a(i);
            submenu.add(0, i, i, resolveinfo.loadLabel(packagemanager)).setIcon(resolveinfo.loadIcon(packagemanager)).setOnMenuItemClickListener(d);
        }

        if (l < k)
        {
            submenu = submenu.addSubMenu(0, l, l, e.getString(0x7f0b0178));
            for (int j = 0; j < k; j++)
            {
                ResolveInfo resolveinfo1 = hl1.a(j);
                submenu.add(0, j, j, resolveinfo1.loadLabel(packagemanager)).setIcon(resolveinfo1.loadIcon(packagemanager)).setOnMenuItemClickListener(d);
            }

        }
    }

    public final boolean a()
    {
        return true;
    }
}
