// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.shazam.b.e.a;
import com.shazam.j.b;
import com.shazam.j.c;
import com.shazam.model.Art;
import com.shazam.model.Factory;
import com.shazam.model.Genre;
import com.shazam.model.TrackCategory;
import com.shazam.model.TrackLayoutType;
import com.shazam.model.TrackStyle;
import com.shazam.model.gimbal.AlternativeTrack;
import com.shazam.model.module.ModuleDimension;
import com.shazam.model.news.SponsoredFeedCard;
import com.shazam.model.share.ShareData;
import com.shazam.model.store.Stores;
import com.shazam.server.legacy.IntentUri;
import com.shazam.server.legacy.Json;
import com.shazam.server.legacy.track.AddOn;
import com.shazam.server.legacy.track.AddOnIcon;
import com.shazam.server.legacy.track.Artist;
import com.shazam.server.legacy.track.ContextAwareTrack;
import com.shazam.server.legacy.track.CoverArt;
import com.shazam.server.legacy.track.GenreCategory;
import com.shazam.server.legacy.track.Label;
import com.shazam.server.legacy.track.Link;
import com.shazam.server.legacy.track.Metadatum;
import com.shazam.server.legacy.track.Product;
import com.shazam.server.legacy.track.Track;
import com.shazam.server.response.actions.Actions;
import com.shazam.server.response.details.Share;
import com.shazam.server.response.follow.Follow;
import com.shazam.server.response.lyricplay.LyricPlay;
import com.shazam.server.response.news.FeedCard;
import com.shazam.server.response.play.Streams;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class t
{

    public long a;
    private final b b;
    private final Factory c;
    private final com.shazam.b.a.a d;
    private final com.shazam.b.a.a e;
    private final com.shazam.b.a.a f;
    private final com.shazam.b.a.a g;
    private final com.shazam.b.a.a h;
    private final com.shazam.b.a.a i;

    public t(b b1, Factory factory, com.shazam.b.a.a a1, com.shazam.b.a.a a2, com.shazam.b.a.a a3, com.shazam.b.a.a a4, com.shazam.b.a.a a5, 
            com.shazam.b.a.a a6)
    {
        b = b1;
        c = factory;
        d = a1;
        e = a2;
        f = a3;
        g = a4;
        h = a5;
        i = a6;
    }

    private com.shazam.model.AddOn a(AddOn addon, Track track)
    {
        Object obj = addon.getProviderName();
        com.shazam.model.AddOn.Builder builder = com.shazam.model.AddOn.Builder.a();
        builder.id = addon.getId();
        builder.typeId = addon.getTypeId();
        builder.typeName = addon.getTypeName();
        builder.providerName = ((String) (obj));
        builder.screenName = addon.getScreenName();
        builder.moduleOrder = addon.getModuleOrder();
        builder.moduleTitle = addon.getModuleTitle();
        builder.moduleSize = addon.getModuleSize();
        builder.moduleStyle = addon.getModuleStyle();
        builder.moduleDecorator = addon.getModuleDecorator();
        builder.moduleImage = addon.getModuleImage();
        builder.moduleBeacons = addon.getModuleBeacons();
        builder.moduleTitle = addon.getModuleTitle();
        builder.trackId = track.getTrackId();
        boolean flag;
        if (ModuleDimension.from(addon.getModuleSize()) == ModuleDimension.RAIL && addon.getLink() != null)
        {
            builder.extra = addon.getLink().getHref();
        } else
        if ("ShazamBiography".equals(obj) && addon.getBiographyArtistId() != null)
        {
            builder.biographyArtistId = addon.getBiographyArtistId();
        } else
        if ("FacebookAdvert".equals(obj))
        {
            builder.moduleFacebookAd = addon.getModuleFacebookAd();
        } else
        if ("Lyrics".equals(obj))
        {
            track = addon.getLyricPlay();
            if (com.shazam.b.e.a.c(track))
            {
                try
                {
                    track = (LyricPlay)b.a(track, com/shazam/server/response/lyricplay/LyricPlay);
                    if (((LyricPlay) (track)).synchInfo != null)
                    {
                        builder.lyricPlay = (com.shazam.model.lyrics.LyricPlay)((com.shazam.b.a.a)c.create(Long.valueOf(a))).a(track);
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Track track) { }
            }
            builder.copyright = addon.getCopyright();
            builder.writers = addon.getWriters();
            builder.lyrics = addon.getLyrics();
        } else
        if ("AlternativeResult".equals(obj))
        {
            track = addon.getTrackJson();
            if (track != null)
            {
                try
                {
                    track = (ContextAwareTrack)b.a(track, com/shazam/server/legacy/track/ContextAwareTrack);
                    builder.alternativeTrack = (AlternativeTrack)i.a(track);
                }
                // Misplaced declaration of an exception variable
                catch (AddOn addon)
                {
                    throw new RuntimeException(addon);
                }
            }
        } else
        if ("FacebookAdcolonyAdvert".equals(obj))
        {
            track = addon.getAnnouncementJson();
            if (track != null)
            {
                try
                {
                    track = (FeedCard)b.a(track, com/shazam/server/response/news/FeedCard);
                    builder.sponsoredNewsCard = (SponsoredFeedCard)f.a(track);
                }
                // Misplaced declaration of an exception variable
                catch (AddOn addon)
                {
                    throw new RuntimeException(addon);
                }
            }
        } else
        if ("Follow".equals(obj))
        {
            track = addon.getFollowJson();
            if (com.shazam.b.e.a.c(track))
            {
                try
                {
                    track = (Follow)b.a(track, com/shazam/server/response/follow/Follow);
                    builder.follow = (com.shazam.model.follow.Follow)g.a(track);
                }
                // Misplaced declaration of an exception variable
                catch (AddOn addon)
                {
                    throw new RuntimeException(addon);
                }
            }
        } else
        if ("Share".equals(obj))
        {
            obj = addon.getShareJson();
            if (com.shazam.b.e.a.c(((String) (obj))))
            {
                try
                {
                    obj = (Share)b.a(((String) (obj)), com/shazam/server/response/details/Share);
                    obj = com.shazam.model.share.ShareData.Builder.a((ShareData)h.a(obj));
                    obj.trackId = track.getTrackId();
                    obj.beaconKey = track.getBeaconKey();
                    obj.campaign = track.getCampaign();
                    obj.trackStyle = track.getStyle();
                    builder.shareData = ((com.shazam.model.share.ShareData.Builder) (obj)).b();
                }
                // Misplaced declaration of an exception variable
                catch (AddOn addon)
                {
                    throw new RuntimeException(addon);
                }
            }
        }
        track = addon.getAutoLaunch();
        if (track != null && track.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        builder.autoLaunch = flag;
        if (addon.getIcon() != null)
        {
            builder.iconVersion = addon.getIcon().getVersion();
            builder.iconURL = addon.getIcon().getPlain();
        }
        track = new ArrayList();
        obj = addon.getIntentUris();
        if (obj != null)
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                IntentUri intenturi = (IntentUri)((Iterator) (obj)).next();
                try
                {
                    track.add(Intent.parseUri(intenturi.getUri(), 1));
                }
                catch (URISyntaxException urisyntaxexception) { }
            }

        }
        addon = addon.getActionsJson();
        if (addon != null)
        {
            try
            {
                addon = (Actions)b.a(addon, com/shazam/server/response/actions/Actions);
            }
            // Misplaced declaration of an exception variable
            catch (AddOn addon)
            {
                addon = new Actions(Collections.emptyList());
            }
            builder.actions = (com.shazam.model.Actions)e.a(addon);
        }
        builder.a(track);
        return builder.b();
    }

    private Streams a(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        s = (Streams)b.a(s, com/shazam/server/response/play/Streams);
        return s;
        s;
        return null;
    }

    private Map b(Track track)
    {
        Map map;
        map = Collections.emptyMap();
        track = track.getUrlParams();
        if (track == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        track = track.getJsonString();
        track = (Map)b.a(track, ((com.google.b.c.a) (new com.google.b.c.a() {

            final t d;

            
            {
                d = t.this;
                super();
            }
        })).b);
        return track;
        track;
        return map;
    }

    public final com.shazam.model.Track a(Track track)
    {
        com.shazam.model.Track.Builder builder = com.shazam.model.Track.Builder.a();
        builder.isFull = true;
        builder.trackLayoutType = TrackLayoutType.getByString(track.getType(), com.shazam.model.Track.a());
        builder.id = track.getTrackId();
        builder.title = track.getTitle();
        builder.category = TrackCategory.fromString(track.getCategory());
        builder.trackStyle = TrackStyle.from(track.getStyle());
        builder.subtitle = track.getSubtitle();
        builder.key = track.getKey();
        builder.beaconKey = track.getBeaconKey();
        builder.campaign = track.getCampaign();
        builder.playWith = track.getPlayWith();
        builder.streams = a(track.getPlayWith());
        builder.urlParams = b(track);
        if (track.getStores() != null && track.getStores().getJsonString() != null)
        {
            Object obj = track.getStores().getJsonString();
            Object obj1;
            byte abyte0[];
            Object obj2;
            try
            {
                obj = (Map)b.a(((String) (obj)), ((com.google.b.c.a) (new com.google.b.c.a() {

                    final t d;

            
            {
                d = t.this;
                super();
            }
                })).b);
                builder.stores = (Stores)d.a(obj);
            }
            catch (c c1) { }
        }
        if (track.getJson() != null)
        {
            builder.json = track.getJson().getJsonString();
        }
        if (track.getLabel() != null)
        {
            obj = com.shazam.model.Label.Builder.a();
            obj.id = track.getLabel().getId();
            obj.name = track.getLabel().getName();
            builder.label = ((com.shazam.model.Label.Builder) (obj)).b();
        }
        if (track.getProduct() != null)
        {
            builder.album = track.getProduct().getName();
        }
        obj = track.getGenreCategory();
        if (obj != null)
        {
            obj1 = ((GenreCategory) (obj)).getParentGenre();
            if (obj1 != null)
            {
                builder.genre = new Genre(((com.shazam.server.legacy.track.Genre) (obj1)).getId(), ((com.shazam.server.legacy.track.Genre) (obj1)).getName());
            }
            obj = ((GenreCategory) (obj)).getSubGenre();
            if (obj != null)
            {
                builder.subgenre = new Genre(((com.shazam.server.legacy.track.Genre) (obj)).getId(), ((com.shazam.server.legacy.track.Genre) (obj)).getName());
            }
        }
        if (track.getCoverArt() != null)
        {
            obj1 = track.getCoverArt().getData();
            if (!com.shazam.b.e.a.a(((String) (obj1))))
            {
                obj = new Art();
                obj2 = track.getCoverArt().getEncoding();
                if (obj2 == null || !"base64".equals(((String) (obj2)).toLowerCase(Locale.US)))
                {
                    obj.url = ((String) (obj1));
                } else
                {
                    abyte0 = Base64.decode(((String) (obj1)).getBytes(), 0);
                    if (abyte0 != null && BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length) != null)
                    {
                        obj.data = abyte0;
                    }
                    obj.type = track.getCoverArt().getType();
                    obj.expireDateTime = track.getCoverArt().getExpiryDateTime();
                }
                builder.art = ((Art) (obj));
            }
        }
        obj = track.getArtists();
        if (com.shazam.o.b.b(((java.util.Collection) (obj))))
        {
            builder.artistName = ((Artist)((List) (obj)).get(0)).getName();
        }
        if (track.getAdvertisingInfo() != null)
        {
            new com.shazam.c.a.a();
            builder.advertisingInfo = com.shazam.c.a.a.a(track.getAdvertisingInfo());
        }
        if (track.getPromoHd() != null)
        {
            builder.promoFullScreenUrl = track.getPromoHd().getHref();
        }
        if (track.getMetadata() != null)
        {
            for (obj = track.getMetadata().iterator(); ((Iterator) (obj)).hasNext(); builder.metadata.put(obj1, obj2))
            {
                obj2 = (Metadatum)((Iterator) (obj)).next();
                obj1 = ((Metadatum) (obj2)).getKey();
                obj2 = ((Metadatum) (obj2)).getValue();
            }

        }
        if (track.getReleased() != null)
        {
            builder.released = track.getReleased();
        }
        if (track.getAddOns() != null)
        {
            for (obj = track.getAddOns().iterator(); ((Iterator) (obj)).hasNext(); builder.a(a((AddOn)((Iterator) (obj)).next(), track))) { }
        } else
        {
            builder.isFull = false;
        }
        return builder.b();
    }
}
