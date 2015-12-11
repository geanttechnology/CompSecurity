// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.ui.InviteFragment;
import java.util.List;

public class InvitePagerAdapter extends FragmentStatePagerAdapter
{

    private String avatarId;
    private List templates;
    private TemplatesManager templatesManager;

    public InvitePagerAdapter(FragmentManager fragmentmanager, List list, String s, TemplatesManager templatesmanager)
    {
        super(fragmentmanager);
        templates = list;
        templatesManager = templatesmanager;
        avatarId = s;
    }

    public int getCount()
    {
        return templates.size();
    }

    public Fragment getItem(int i)
    {
        InviteFragment invitefragment = new InviteFragment();
        Bundle bundle = new Bundle();
        Imoji imoji = (Imoji)templates.get(i);
        bundle.putString("url", templatesManager.getImageUrlFromImoji(imoji, avatarId));
        invitefragment.setArguments(bundle);
        return invitefragment;
    }
}
