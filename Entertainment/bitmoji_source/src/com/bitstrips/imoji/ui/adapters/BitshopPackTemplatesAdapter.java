// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.ui.views.ImojiView;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;

public class BitshopPackTemplatesAdapter extends ArrayAdapter
{

    Picasso picasso;
    PreferenceUtils preferenceUtils;
    TemplatesManager templatesManager;

    public BitshopPackTemplatesAdapter(Activity activity, List list)
    {
        super(activity, 0, list);
        ((InjectorApplication)activity.getApplication()).inject(this);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Imoji imoji = (Imoji)getItem(i);
        viewgroup = view;
        if (view == null)
        {
            viewgroup = new ImojiView(getContext());
        }
        view = (ImojiView)viewgroup;
        viewgroup = imoji.getUncachedUrl(preferenceUtils.getString(0x7f06002a, null));
        view.setImoji(imoji);
        view.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        picasso.load(viewgroup).resizeDimen(0x7f0a005c, 0x7f0a005c).into(view);
        return view;
    }
}
