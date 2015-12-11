// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.Tag;
import com.xfinity.playerlib.view.PlayNowActivity;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            NetworkActionBarController

public abstract class NetworkActivity extends PlayNowActivity
    implements NetworkActionBarController
{

    private TextView collectionTitle;
    private ImageView networkLogo;
    private final NetworkLogoImageLoader networkLogoLoader = PlayerContainer.getInstance().createNetworkLogoImageLoader();
    protected TextView title;

    public NetworkActivity()
    {
    }

    private void setCategory(Tag tag)
    {
        collectionTitle.setText(tag.getName());
    }

    private void setNetworkName(String s)
    {
        title.setText(s);
    }

    public void loadNetworkLogo(Network network)
    {
        setNetworkName(network.getName());
        if (!network.isPremium())
        {
            title.setVisibility(0);
        } else
        if (networkLogo != null)
        {
            networkLogoLoader.loadNetworkLogoLarge(network, networkLogo, new com.comcast.cim.android.image.CimImageLoader.OnLoadListener() {

                final NetworkActivity this$0;

                public void onLoad(ImageView imageview, String s, Bitmap bitmap)
                {
                    title.setVisibility(8);
                    imageview.setVisibility(0);
                }

                public void onLoadError(ImageView imageview, String s)
                {
                    title.setVisibility(0);
                }

            
            {
                this$0 = NetworkActivity.this;
                super();
            }
            });
            return;
        }
    }

    public void loadNetworkLogoAndCategory(Network network, Tag tag)
    {
        loadNetworkLogo(network);
        setCategory(tag);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getActionBar().getCustomView();
        networkLogo = (ImageView)bundle.findViewById(com.xfinity.playerlib.R.id.network_logo);
        title = (TextView)bundle.findViewById(com.xfinity.playerlib.R.id.title);
        collectionTitle = (TextView)getActionBar().getCustomView().findViewById(com.xfinity.playerlib.R.id.collection_title);
    }

    public void setNetworkNameAndCategory(Network network, Tag tag)
    {
        setNetworkName(network.getName());
        setCategory(tag);
    }
}
