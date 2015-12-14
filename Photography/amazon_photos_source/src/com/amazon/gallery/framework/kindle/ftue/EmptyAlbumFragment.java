// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.MediaContentUtil;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

public class EmptyAlbumFragment extends Fragment
{

    private View addIcon;
    private NetworkConnectivity networkConnectivity;

    public EmptyAlbumFragment()
    {
        networkConnectivity = (NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (viewgroup == null)
        {
            return null;
        } else
        {
            layoutinflater = layoutinflater.inflate(0x7f030089, viewgroup, false);
            addIcon = layoutinflater.findViewById(0x7f0c0132);
            addIcon.setOnClickListener(new android.view.View.OnClickListener() {

                final EmptyAlbumFragment this$0;

                public void onClick(View view)
                {
                    if (networkConnectivity.promptIfOffline(getActivity()))
                    {
                        return;
                    } else
                    {
                        view = MediaContentUtil.getTagFromContentConfiguration();
                        Intent intent = IntentUtil.getBaseAddToAlbumIntent(getActivity());
                        ObjectID objectid = view.getObjectId();
                        intent.putExtra("TAG_NODE_ID", IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits()));
                        intent.putExtra("TAG_NAME", view.getLabel());
                        getActivity().startActivity(intent);
                        return;
                    }
                }

            
            {
                this$0 = EmptyAlbumFragment.this;
                super();
            }
            });
            return layoutinflater;
        }
    }

}
