// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;

import com.shazam.model.advert.AdvertisingInfo;
import com.shazam.model.store.Stores;
import com.shazam.server.response.play.Streams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.model:
//            TrackCategory, TrackLayoutType, Art, Genre, 
//            Label, TrackStyle, AddOn

public class Track
{
    public static class Builder
    {

        private final List addOns = new ArrayList();
        public AdvertisingInfo advertisingInfo;
        public String album;
        public Art art;
        public String artistName;
        public String beaconKey;
        public String campaign;
        public TrackCategory category;
        public Genre genre;
        public String id;
        public boolean isFull;
        public String json;
        public String key;
        public Label label;
        public final Map metadata = new LinkedHashMap();
        public String playWith;
        public String promoFullScreenUrl;
        public String released;
        public Stores stores;
        public Streams streams;
        public Genre subgenre;
        public String subtitle;
        public String title;
        public TrackLayoutType trackLayoutType;
        public TrackStyle trackStyle;
        public Map urlParams;

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(Track track)
        {
            Builder builder = new Builder();
            for (Iterator iterator = track.addOns.iterator(); iterator.hasNext(); builder.a((AddOn)iterator.next())) { }
            builder.album = track.album;
            builder.artistName = track.artistName;
            builder.art = track.art;
            builder.beaconKey = track.beaconKey;
            builder.campaign = track.campaign;
            builder.category = track.category;
            builder.isFull = track.isFull;
            builder.genre = track.genre;
            builder.id = track.id;
            builder.json = track.json;
            builder.key = track.key;
            builder.label = track.label;
            Map map = track.metadata;
            builder.metadata.putAll(map);
            builder.playWith = track.playWith;
            builder.streams = track.c();
            builder.promoFullScreenUrl = track.promoFullScreenUrl;
            builder.released = track.released;
            builder.trackStyle = track.trackStyle;
            builder.subgenre = track.subgenre;
            builder.subtitle = track.subtitle;
            builder.title = track.title;
            builder.trackLayoutType = track.trackLayoutType;
            builder.stores = track.stores;
            builder.urlParams = track.urlParams;
            return builder;
        }

        static String a(Builder builder)
        {
            return builder.id;
        }

        static boolean b(Builder builder)
        {
            return builder.isFull;
        }

        static String c(Builder builder)
        {
            return builder.subtitle;
        }

        static TrackCategory d(Builder builder)
        {
            return builder.category;
        }

        static String e(Builder builder)
        {
            return builder.title;
        }

        static TrackLayoutType f(Builder builder)
        {
            return builder.trackLayoutType;
        }

        static Art g(Builder builder)
        {
            return builder.art;
        }

        static List h(Builder builder)
        {
            return builder.addOns;
        }

        static Label i(Builder builder)
        {
            return builder.label;
        }

        static String j(Builder builder)
        {
            return builder.album;
        }

        static Genre k(Builder builder)
        {
            return builder.genre;
        }

        static Genre l(Builder builder)
        {
            return builder.subgenre;
        }

        static Map m(Builder builder)
        {
            return builder.metadata;
        }

        static String n(Builder builder)
        {
            return builder.promoFullScreenUrl;
        }

        static String o(Builder builder)
        {
            return builder.json;
        }

        static TrackStyle p(Builder builder)
        {
            return builder.trackStyle;
        }

        static AdvertisingInfo q(Builder builder)
        {
            return builder.advertisingInfo;
        }

        static String r(Builder builder)
        {
            return builder.playWith;
        }

        static String s(Builder builder)
        {
            return builder.key;
        }

        static String t(Builder builder)
        {
            return builder.beaconKey;
        }

        static String u(Builder builder)
        {
            return builder.campaign;
        }

        static Stores v(Builder builder)
        {
            return builder.stores;
        }

        static Map w(Builder builder)
        {
            return builder.urlParams;
        }

        static Streams x(Builder builder)
        {
            return builder.streams;
        }

        static String y(Builder builder)
        {
            return builder.artistName;
        }

        public final Builder a(AddOn addon)
        {
            addOns.add(addon);
            return this;
        }

        public final Track b()
        {
            return new Track(this, null);
        }

        private Builder()
        {
            category = TrackCategory.MUSIC;
            isFull = true;
            trackStyle = TrackStyle.getDefaultStyle();
        }
    }


    public List addOns;
    public AdvertisingInfo advertisingInfo;
    public String album;
    public Art art;
    public String artistName;
    public String beaconKey;
    public String campaign;
    public TrackCategory category;
    public Genre genre;
    public String id;
    public boolean isFull;
    public String json;
    public String key;
    public Label label;
    public final Map metadata;
    public String playWith;
    public String promoFullScreenUrl;
    public String released;
    public Stores stores;
    private Streams streams;
    public Genre subgenre;
    public String subtitle;
    public String title;
    public TrackLayoutType trackLayoutType;
    public TrackStyle trackStyle;
    public Map urlParams;

    public Track()
    {
        category = TrackCategory.MUSIC;
        metadata = new LinkedHashMap();
        addOns = new ArrayList();
        isFull = true;
    }

    private Track(Builder builder)
    {
        category = TrackCategory.MUSIC;
        metadata = new LinkedHashMap();
        addOns = new ArrayList();
        isFull = true;
        id = Builder.a(builder);
        isFull = Builder.b(builder);
        subtitle = Builder.c(builder);
        category = Builder.d(builder);
        title = Builder.e(builder);
        trackLayoutType = Builder.f(builder);
        art = Builder.g(builder);
        addOns = Builder.h(builder);
        label = Builder.i(builder);
        album = Builder.j(builder);
        genre = Builder.k(builder);
        subgenre = Builder.l(builder);
        metadata.putAll(Builder.m(builder));
        promoFullScreenUrl = Builder.n(builder);
        json = Builder.o(builder);
        released = builder.released;
        trackStyle = Builder.p(builder);
        advertisingInfo = Builder.q(builder);
        playWith = Builder.r(builder);
        key = Builder.s(builder);
        beaconKey = Builder.t(builder);
        campaign = Builder.u(builder);
        stores = Builder.v(builder);
        urlParams = Builder.w(builder);
        streams = Builder.x(builder);
        artistName = Builder.y(builder);
    }

    Track(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public static TrackLayoutType a()
    {
        return TrackLayoutType.MUSIC;
    }

    public final String b()
    {
        return (new StringBuilder()).append(title).append(" - ").append(artistName).toString();
    }

    public final Streams c()
    {
        if (streams == null)
        {
            return Streams.EMPTY;
        } else
        {
            return streams;
        }
    }
}
