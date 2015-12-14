// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.IntrospectiveArrayList;
import com.socialin.android.apiv3.controllers.GetTagsGroupedController;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Tag;
import com.socialin.android.apiv3.request.GetItemsParams;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.activity.TopTagsActivity;
import com.socialin.android.picsart.profile.adapter.au;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import java.util.List;
import myobfuscated.cr.f;
import myobfuscated.cr.h;
import myobfuscated.cv.c;

public final class bi extends f
    implements a
{

    private au c;

    public bi()
    {
    }

    public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
    {
        Tag tag = (Tag)c.getItem(i);
        com.socialin.android.picsart.profile.fragment._cls1.a[itemcontrol.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 60
    //                   2 113;
           goto _L1 _L2 _L3
_L1:
        d.b("TagsFragment", new Object[] {
            "onClick"
        });
_L5:
        return;
_L2:
        itemcontrol = new Intent(getActivity(), com/socialin/android/picsart/profile/activity/TopTagsActivity);
        if (getActivity().getIntent().getExtras() != null)
        {
            myobfuscated.cv.c.a(itemcontrol, getActivity());
        }
        itemcontrol.putExtra("key.tag", tag.name);
        startActivity(itemcontrol);
        return;
_L3:
        ImageItem imageitem = (ImageItem)aobj[0];
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing() && imageitem != null)
        {
            IntrospectiveArrayList introspectivearraylist = tag.items;
            itemcontrol = new ImageItem[0];
            if (introspectivearraylist != null)
            {
                itemcontrol = new ImageItem[introspectivearraylist.size()];
                tag.items.toArray(itemcontrol);
            }
            activity.getIntent().putExtra("request_controller_code", 7);
            activity.getIntent().putExtra("key.tag", tag.name);
            if (imageitem.url == null)
            {
                aobj = null;
            } else
            {
                aobj = imageitem.url.substring(imageitem.url.lastIndexOf("."), imageitem.url.length());
            }
            aobj = GalleryUtils.b(activity, String.valueOf(imageitem.id), ((String) (aobj)));
            GalleryUtils.a(this, itemcontrol, introspectivearraylist.indexOf(imageitem), ((String) (aobj)));
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        c = new au(getActivity(), this);
        Object obj;
        if (getActivity().getIntent().hasExtra("type") && !"picsart://tags".equals(getActivity().getIntent().getStringExtra("type")))
        {
            bundle = getActivity().getIntent().getStringExtra("type");
        } else
        {
            bundle = "top";
        }
        if (getActivity() instanceof AppCompatActivity)
        {
            obj = ((AppCompatActivity)getActivity()).getSupportActionBar();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((ActionBar) (obj)).setTitle(getActivity().getIntent().getStringExtra("title"));
        }
        obj = new GetTagsGroupedController();
        ((GetItemsParams)((GetTagsGroupedController) (obj)).getRequestParams()).type = bundle;
        bundle = myobfuscated.cr.a.a(((com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController) (obj)), c);
        b(c, bundle);
        a((new h(getResources())).a().b());
    }

    public final void onResume()
    {
        super.onResume();
        if (c != null && c.isEmpty())
        {
            a(false, true, true);
        }
    }

    /* member class not found */
    class _cls1 {}

}
