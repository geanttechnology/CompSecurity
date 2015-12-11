// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.groupon.util:
//            GrouponNavigationDrawerActivity

public class 
    implements butterknife.nder
{

    public void bind(butterknife.nder nder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        grouponnavigationdraweractivity.loginPromptView = (ViewGroup)nder.omptView((View)nder.omptView(obj, 0x7f100454, null), 0x7f100454, "field 'loginPromptView'");
        grouponnavigationdraweractivity.profileContentView = (ViewGroup)nder.ContentView((View)nder.ContentView(obj, 0x7f10044c, null), 0x7f10044c, "field 'profileContentView'");
        grouponnavigationdraweractivity.profileEmail = (TextView)nder.Email((View)nder.Email(obj, 0x7f100452, null), 0x7f100452, "field 'profileEmail'");
        grouponnavigationdraweractivity.profileName = (TextView)nder.Name((View)nder.Name(obj, 0x7f100453, null), 0x7f100453, "field 'profileName'");
        grouponnavigationdraweractivity.drawerItemsListContainer = (ViewGroup)nder.temsListContainer((View)nder.temsListContainer(obj, 0x7f100457, null), 0x7f100457, "field 'drawerItemsListContainer'");
        grouponnavigationdraweractivity.expandAccount = (ImageView)nder.ccount((View)nder.ccount(obj, 0x7f100451, null), 0x7f100451, "field 'expandAccount'");
        grouponnavigationdraweractivity.drawerLayout = (DrawerLayout)nder.ayout((View)nder.ayout(obj, 0x7f10017c, null), 0x7f10017c, "field 'drawerLayout'");
        nder = nder.ayout(obj).getResources();
        grouponnavigationdraweractivity.selectedBackground = nder.getColor(0x7f0e012f);
        grouponnavigationdraweractivity.navDrawerSelectedTextColor = nder.getColor(0x7f0e0132);
        grouponnavigationdraweractivity.navDrawerTextColor = nder.getColor(0x7f0e0131);
        grouponnavigationdraweractivity.navDrawerSelectedIconTint = nder.getColor(0x7f0e012c);
        grouponnavigationdraweractivity.navDrawerIconTint = nder.getColor(0x7f0e012b);
    }

    public volatile void bind(butterknife.nder nder, Object obj, Object obj1)
    {
        bind(nder, (GrouponNavigationDrawerActivity)obj, obj1);
    }

    public void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        grouponnavigationdraweractivity.loginPromptView = null;
        grouponnavigationdraweractivity.profileContentView = null;
        grouponnavigationdraweractivity.profileEmail = null;
        grouponnavigationdraweractivity.profileName = null;
        grouponnavigationdraweractivity.drawerItemsListContainer = null;
        grouponnavigationdraweractivity.expandAccount = null;
        grouponnavigationdraweractivity.drawerLayout = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GrouponNavigationDrawerActivity)obj);
    }

    public ()
    {
    }
}
