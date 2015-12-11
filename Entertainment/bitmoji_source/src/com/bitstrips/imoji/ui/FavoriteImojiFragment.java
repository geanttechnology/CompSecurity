// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.GridView;
import com.bitstrips.imoji.manager.RecentImojiesManager;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.util.PreferenceUtils;
import java.util.List;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AbstractFragment, AvatarChangeRegister, ImagesGridViewsWrapper

public class FavoriteImojiFragment extends AbstractFragment
{

    public static final String SUPERTAG = "supertag";
    AvatarChangeRegister avatarChangeRegister;
    private GridView popularGridView;
    ImagesGridViewsWrapper popularGridViewsWrapper;
    PreferenceUtils preferenceUtils;
    private GridView purchasedGridView;
    ImagesGridViewsWrapper purchasedGridViewsWrapper;
    private GridView recentGridView;
    ImagesGridViewsWrapper recentGridViewsWrapper;
    RecentImojiesManager recentImojiesManager;
    private String supertag;
    TemplatesManager templatesManager;

    public FavoriteImojiFragment()
    {
    }

    public static FavoriteImojiFragment newInstance(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("supertag", s);
        s = new FavoriteImojiFragment();
        s.setArguments(bundle);
        return s;
    }

    protected int getLayout()
    {
        return 0x7f030034;
    }

    protected void initArgs(Bundle bundle)
    {
        supertag = bundle.getString("supertag");
    }

    protected void initSubViews(View view)
    {
        recentGridView = (GridView)view.findViewById(0x7f0b00b0);
        popularGridView = (GridView)view.findViewById(0x7f0b00b2);
        purchasedGridView = (GridView)view.findViewById(0x7f0b00b4);
        if (!view.getContext().getResources().getBoolean(0x7f080007))
        {
            view.findViewById(0x7f0b00b3).setVisibility(8);
        }
    }

    public void onDetach()
    {
        super.onDetach();
        avatarChangeRegister.unregister();
    }

    public void onResume()
    {
        super.onResume();
        update();
    }

    protected void populateContentView()
    {
        recentGridViewsWrapper.init(getActivity(), recentGridView, "recent");
        popularGridViewsWrapper.init(getActivity(), popularGridView, "#popmoji");
        purchasedGridViewsWrapper.init(getActivity(), purchasedGridView, "#purchased");
        avatarChangeRegister.registerAvatarIdChangeListener(getActivity(), new AvatarChangeRegister.AvatarChangeListener() {

            final FavoriteImojiFragment this$0;

            public void onChanged()
            {
                recentGridViewsWrapper.notifyDataSetChanged();
                popularGridViewsWrapper.notifyDataSetChanged();
                purchasedGridViewsWrapper.notifyDataSetChanged();
            }

            
            {
                this$0 = FavoriteImojiFragment.this;
                super();
            }
        });
    }

    public void update()
    {
        List list = recentImojiesManager.getRecentImojies();
        recentGridViewsWrapper.updateData();
        if (list.size() > 0)
        {
            getActivity().findViewById(0x7f0b009e).setVisibility(8);
            recentGridViewsWrapper.makeVisible();
        }
        popularGridViewsWrapper.makeVisible();
        purchasedGridViewsWrapper.updateData();
        if (templatesManager.getListForTag(purchasedGridViewsWrapper.getSupertag()).size() > 0)
        {
            getActivity().findViewById(0x7f0b009a).setVisibility(8);
            purchasedGridViewsWrapper.makeVisible();
        }
    }
}
