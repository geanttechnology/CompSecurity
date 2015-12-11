// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.manager.RecentImojiesManager;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.ui.views.ImojiWithBadgeView;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends ArrayAdapter
{

    B4MService b4MService;
    private List imojiList;
    private final int layout;
    Picasso picasso;
    PreferenceUtils preferenceUtils;
    RecentImojiesManager recentImojiesManager;
    private final String supertag;
    TemplatesManager templatesManager;

    public ImageAdapter(Activity activity, int i, String s)
    {
        super(activity, i);
        layout = i;
        supertag = s;
        ((InjectorApplication)activity.getApplication()).inject(this);
        refreshImojis();
    }

    public int getCount()
    {
        return imojiList.size();
    }

    public Imoji getItem(int i)
    {
        return (Imoji)imojiList.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, final View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = (ImojiWithBadgeView)LayoutInflater.from(getContext()).inflate(layout, viewgroup, false);
        } else
        {
            view = (ImojiWithBadgeView)view;
        }
        if (view == null)
        {
            throw new NullPointerException("Grid layout should have a SquareImojiView");
        } else
        {
            viewgroup = getItem(i);
            String s = preferenceUtils.getString(0x7f06002a, null);
            s = templatesManager.getImageUrlFromImoji(viewgroup, s);
            view.setImoji(viewgroup);
            view.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
            picasso.load(s).resizeDimen(0x7f0a00d8, 0x7f0a00d8).placeholder(0x7f0200a9).into(view, new Callback() {

                final ImageAdapter this$0;
                final ImojiWithBadgeView val$view;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    view.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                }

            
            {
                this$0 = ImageAdapter.this;
                view = imojiwithbadgeview;
                super();
            }
            });
            return view;
        }
    }

    public void notifyDataSetChanged()
    {
        refreshImojis();
        super.notifyDataSetChanged();
    }

    public void refreshImojis()
    {
        if (preferenceUtils.getString(0x7f06002a, null) == null)
        {
            imojiList = new ArrayList();
            return;
        }
        if ("recent".equals(supertag))
        {
            imojiList = recentImojiesManager.getRecentImojies();
            return;
        }
        imojiList = new ArrayList();
        if (b4MService.isReplyWithFriends())
        {
            imojiList.addAll(templatesManager.getFriendmojiListForTag(supertag));
        }
        imojiList.addAll(templatesManager.getListForTag(supertag));
    }
}
