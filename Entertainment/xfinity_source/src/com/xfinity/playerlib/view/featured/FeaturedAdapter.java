// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.comcast.cim.cmasl.android.util.view.widget.ViewHolderBaseAdapter;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.EditorialProgram;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.view.ScrollStateTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class FeaturedAdapter extends ViewHolderBaseAdapter
{
    protected static class VideoViewHolder
    {

        public View container;
        public ImageView lockedIndicator;
        public ImageView networkLogo;
        public TextView placeholderTitle;
        public ImageView videoImage;

        protected VideoViewHolder()
        {
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/featured/FeaturedAdapter);
    protected Context context;
    protected CoverArtImageLoader coverArtImageLoader;
    private VideoEntitlement entitlement;
    private Handler handler;
    private String listHeadingForAccessibility;
    private NetworkLogoImageLoader networkLogoImageLoader;
    private Map premiumNetworks;
    private List programs;
    private final ScrollStateTracker scrollStateTracker;
    private final boolean shouldSuppressNetworkLogos = PlayerContainer.getInstance().getConfiguration().shouldSuppressNetworkLogos();

    public FeaturedAdapter(LayoutInflater layoutinflater, CoverArtImageLoader coverartimageloader, NetworkLogoImageLoader networklogoimageloader, String s, ScrollStateTracker scrollstatetracker)
    {
        super(layoutinflater);
        handler = new Handler();
        programs = new ArrayList();
        coverArtImageLoader = coverartimageloader;
        networkLogoImageLoader = networklogoimageloader;
        listHeadingForAccessibility = s;
        scrollStateTracker = scrollstatetracker;
        context = layoutinflater.getContext();
    }

    private String getBestTitle(EditorialProgram editorialprogram)
    {
        if (editorialprogram.getEpisodeTitle() != null && editorialprogram.getSeasonNumber() != null && editorialprogram.getEpisodeNumber() != null)
        {
            return context.getResources().getString(com.xfinity.playerlib.R.string.featured_title_text, new Object[] {
                editorialprogram.getSeasonNumber(), editorialprogram.getEpisodeNumber(), editorialprogram.getEpisodeTitle()
            });
        } else
        {
            return editorialprogram.getTitle();
        }
    }

    private String getContentDescription(EditorialProgram editorialprogram)
    {
        if (editorialprogram.getEpisodeTitle() != null && editorialprogram.getSeasonNumber() != null && editorialprogram.getEpisodeNumber() != null)
        {
            return context.getString(com.xfinity.playerlib.R.string.content_description_featured_tv_series_title_text, new Object[] {
                editorialprogram.getTitle(), editorialprogram.getSeasonNumber(), editorialprogram.getEpisodeNumber(), editorialprogram.getEpisodeTitle(), listHeadingForAccessibility
            });
        } else
        {
            return context.getString(com.xfinity.playerlib.R.string.content_description_featured_movie_title_text, new Object[] {
                editorialprogram.getTitle(), listHeadingForAccessibility
            });
        }
    }

    protected void bindItem(VideoViewHolder videoviewholder, EditorialProgram editorialprogram)
    {
        setupProgramArt(videoviewholder, editorialprogram);
        if (videoviewholder.lockedIndicator != null)
        {
            setupLockedIndicator(videoviewholder.lockedIndicator, editorialprogram, entitlement);
        }
        if (shouldSuppressNetworkLogos)
        {
            videoviewholder.networkLogo.setVisibility(8);
        } else
        if (videoviewholder.networkLogo != null)
        {
            setupNetworkLogo(videoviewholder.networkLogo, editorialprogram, networkLogoImageLoader, premiumNetworks);
            return;
        }
    }

    protected volatile void bindItem(Object obj, Object obj1)
    {
        bindItem((VideoViewHolder)obj, (EditorialProgram)obj1);
    }

    protected VideoViewHolder createViewHolder()
    {
        return new VideoViewHolder();
    }

    protected volatile Object createViewHolder()
    {
        return createViewHolder();
    }

    public int getCount()
    {
        return programs.size();
    }

    protected abstract String getImageUrl(EditorialProgram editorialprogram);

    public Object getItem(int i)
    {
        return programs.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    protected void initializeViewHolder(View view, ViewGroup viewgroup, VideoViewHolder videoviewholder)
    {
        videoviewholder.videoImage = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.cover_art);
        videoviewholder.placeholderTitle = (TextView)view.findViewById(com.xfinity.playerlib.R.id.placeholder_title);
        videoviewholder.lockedIndicator = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.locked_indicator);
        videoviewholder.networkLogo = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.network_logo);
        videoviewholder.container = view;
    }

    protected volatile void initializeViewHolder(View view, ViewGroup viewgroup, Object obj)
    {
        initializeViewHolder(view, viewgroup, (VideoViewHolder)obj);
    }

    public void setData(List list, VideoEntitlement videoentitlement, Map map)
    {
        programs = list;
        entitlement = videoentitlement;
        premiumNetworks = map;
        notifyDataSetChanged();
    }

    protected void setupLockedIndicator(ImageView imageview, EditorialProgram editorialprogram, VideoEntitlement videoentitlement)
    {
        setupLockedIndicator(imageview, editorialprogram, videoentitlement, 8);
    }

    protected void setupLockedIndicator(ImageView imageview, EditorialProgram editorialprogram, VideoEntitlement videoentitlement, int i)
    {
        if (videoentitlement.isEntitledToList(editorialprogram.getProviderCode()))
        {
            imageview.setVisibility(i);
            return;
        } else
        {
            imageview.setVisibility(0);
            return;
        }
    }

    protected void setupNetworkLogo(ImageView imageview, EditorialProgram editorialprogram, NetworkLogoImageLoader networklogoimageloader, Map map)
    {
        setupNetworkLogo(imageview, editorialprogram, networklogoimageloader, map, 8);
    }

    protected void setupNetworkLogo(ImageView imageview, EditorialProgram editorialprogram, NetworkLogoImageLoader networklogoimageloader, Map map, int i)
    {
        editorialprogram = editorialprogram.getBrand();
        if (map.containsKey(editorialprogram))
        {
            editorialprogram = (Network)map.get(editorialprogram);
            imageview.setVisibility(0);
            networklogoimageloader.loadNetworkLogoSmall(editorialprogram.getCompanyId(), imageview);
            return;
        } else
        {
            imageview.setVisibility(i);
            return;
        }
    }

    protected void setupProgramArt(VideoViewHolder videoviewholder, EditorialProgram editorialprogram)
    {
        setupProgramArt(videoviewholder, editorialprogram, false);
    }

    protected void setupProgramArt(final VideoViewHolder holder, EditorialProgram editorialprogram, final boolean leavePlaceHolderOn)
    {
        final boolean placeholderTitleIsPresent;
        boolean flag;
        if (holder.placeholderTitle != null)
        {
            placeholderTitleIsPresent = true;
        } else
        {
            placeholderTitleIsPresent = false;
        }
        holder.container.setContentDescription(getContentDescription(editorialprogram));
        if (placeholderTitleIsPresent)
        {
            holder.placeholderTitle.setVisibility(0);
            holder.placeholderTitle.setText(getBestTitle(editorialprogram));
        }
        editorialprogram = getImageUrl(editorialprogram);
        flag = coverArtImageLoader.loadImageFromMemory(editorialprogram, null, holder.videoImage);
        if (scrollStateTracker != null && scrollStateTracker.isFlinging())
        {
            holder.videoImage.setTag(null);
            if (!flag)
            {
                holder.videoImage.setImageDrawable(null);
                return;
            } else
            {
                holder.placeholderTitle.setVisibility(8);
                return;
            }
        } else
        {
            holder.videoImage.setImageDrawable(null);
            coverArtImageLoader.loadImage(editorialprogram, holder.videoImage, new com.comcast.cim.android.image.CimImageLoader.OnLoadListener() {

                final FeaturedAdapter this$0;
                final VideoViewHolder val$holder;
                final boolean val$leavePlaceHolderOn;
                final boolean val$placeholderTitleIsPresent;

                public void onLoad(ImageView imageview, String s, Bitmap bitmap)
                {
                    if (!leavePlaceHolderOn && placeholderTitleIsPresent)
                    {
                        holder.placeholderTitle.setVisibility(8);
                    }
                }

                public void onLoadError(ImageView imageview, String s)
                {
                    imageview = programs.iterator();
                    do
                    {
                        if (!imageview.hasNext())
                        {
                            break;
                        }
                        String s1 = ((EditorialProgram)imageview.next()).getImageKey();
                        if (s1 == null || !s1.equalsIgnoreCase(s))
                        {
                            continue;
                        }
                        imageview.remove();
                        notifyDataSetChanged();
                        break;
                    } while (true);
                }

            
            {
                this$0 = FeaturedAdapter.this;
                leavePlaceHolderOn = flag;
                placeholderTitleIsPresent = flag1;
                holder = videoviewholder;
                super();
            }
            });
            return;
        }
    }


}
