// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.support.v4.view.ActionProvider;
import android.support.v7.internal.widget.ActivityChooserView;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import cg;
import du;
import fx;
import r;
import z;

public class ShareActionProvider extends ActionProvider
{

    private int a;
    private final fx b;
    private final Context c;
    private String d;

    public static Context a(ShareActionProvider shareactionprovider)
    {
        return shareactionprovider.c;
    }

    public static String b(ShareActionProvider shareactionprovider)
    {
        return shareactionprovider.d;
    }

    public boolean hasSubMenu()
    {
        return true;
    }

    public View onCreateActionView()
    {
        Object obj = cg.a(c, d);
        ActivityChooserView activitychooserview = new ActivityChooserView(c);
        activitychooserview.setActivityChooserModel(((cg) (obj)));
        obj = new TypedValue();
        c.getTheme().resolveAttribute(r.actionModeShareDrawable, ((TypedValue) (obj)), true);
        activitychooserview.setExpandActivityOverflowButtonDrawable(du.a(c, ((TypedValue) (obj)).resourceId));
        activitychooserview.setProvider(this);
        activitychooserview.setDefaultActionButtonContentDescription(z.abc_shareactionprovider_share_with_application);
        activitychooserview.setExpandActivityOverflowButtonContentDescription(z.abc_shareactionprovider_share_with);
        return activitychooserview;
    }

    public void onPrepareSubMenu(SubMenu submenu)
    {
        submenu.clear();
        cg cg1 = cg.a(c, d);
        android.content.pm.PackageManager packagemanager = c.getPackageManager();
        int k = cg1.a();
        int l = Math.min(k, a);
        for (int i = 0; i < l; i++)
        {
            ResolveInfo resolveinfo = cg1.a(i);
            submenu.add(0, i, i, resolveinfo.loadLabel(packagemanager)).setIcon(resolveinfo.loadIcon(packagemanager)).setOnMenuItemClickListener(b);
        }

        if (l < k)
        {
            submenu = submenu.addSubMenu(0, l, l, c.getString(z.abc_activity_chooser_view_see_all));
            for (int j = 0; j < k; j++)
            {
                ResolveInfo resolveinfo1 = cg1.a(j);
                submenu.add(0, j, j, resolveinfo1.loadLabel(packagemanager)).setIcon(resolveinfo1.loadIcon(packagemanager)).setOnMenuItemClickListener(b);
            }

        }
    }
}
