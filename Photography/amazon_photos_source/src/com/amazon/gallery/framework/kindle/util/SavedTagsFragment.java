// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import java.util.List;

public class SavedTagsFragment extends Fragment
{

    public static final String TAG = com/amazon/gallery/framework/kindle/util/SavedTagsFragment.getName();
    private List savedTags;
    private List selectedTags;

    public SavedTagsFragment()
    {
    }

    public List getSavedTags()
    {
        return savedTags;
    }

    public List getSelectedTags()
    {
        return selectedTags;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void onDetach()
    {
        super.onDetach();
    }

    public void setSavedTags(List list)
    {
        savedTags = list;
    }

    public void setSelectedTags(List list)
    {
        selectedTags = list;
    }

}
