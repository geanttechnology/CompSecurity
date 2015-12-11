// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a;

import com.shazam.f.a.i;
import com.shazam.f.c.a;
import com.shazam.f.c.b;
import com.shazam.h.j;
import com.shazam.h.k;
import com.shazam.h.o;
import com.shazam.h.r;
import com.shazam.j.c;
import com.shazam.server.request.like.LikeCountsAndStatusesRequest;
import com.shazam.server.request.post.PublishPostRequest;
import com.shazam.server.request.preferences.NotificationWritePreferences;
import com.shazam.server.request.recognition.RecognitionRequest;
import com.shazam.server.response.artist.Artist;
import com.shazam.server.response.artist.ArtistPage;
import com.shazam.server.response.chart.Chart;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.details.Details;
import com.shazam.server.response.explore.TopTracks;
import com.shazam.server.response.follow.FollowCountResponse;
import com.shazam.server.response.follow.FollowStatusResponse;
import com.shazam.server.response.follow.FollowingListResponse;
import com.shazam.server.response.imdb.IMDBActorSearchResults;
import com.shazam.server.response.like.LikeCountsAndStatusesResponse;
import com.shazam.server.response.news.Feed;
import com.shazam.server.response.post.PostResponse;
import com.shazam.server.response.preferences.NotificationReadPreferences;
import com.shazam.server.response.product.Product;
import com.shazam.server.response.recognition.RecognitionResponse;
import com.shazam.server.response.search.SearchResponse;
import com.shazam.server.response.streaming.StreamingProviderTrackMappings;
import com.shazam.server.response.track.TagCount;
import com.shazam.server.response.tv.TVAbout;
import com.shazam.server.response.video.VideoResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

// Referenced classes of package com.shazam.a:
//            g, f

public final class e
    implements g
{

    private static final Set a = com.shazam.b.b.e.a(new Integer[] {
        Integer.valueOf(200), Integer.valueOf(201)
    });
    private final com.shazam.h.i b;
    private final f c;
    private final com.shazam.j.b d;

    public e(com.shazam.h.i i1, f f1, com.shazam.j.b b1)
    {
        b = i1;
        c = f1;
        d = b1;
    }

    private void a(o o1, Exception exception)
    {
        if (c.a(o1))
        {
            throw new i("Request unauthorized: Auth token expired?");
        } else
        {
            throw exception;
        }
    }

    public final LikeCountsAndStatusesResponse a(URL url, LikeCountsAndStatusesRequest likecountsandstatusesrequest)
    {
        String s1 = (new StringBuilder("Error getting like counts and statuses via ")).append(url).toString();
        url = (LikeCountsAndStatusesResponse)b.a(url, likecountsandstatusesrequest, r.a, com/shazam/server/response/like/LikeCountsAndStatusesResponse);
        return url;
        url;
        int i1;
        url = url.a();
        i1 = ((o) (url)).a;
        i1;
        JVM INSTR tableswitch 456 456: default 72
    //                   456 104;
           goto _L1 _L2
_L1:
        throw new a((new StringBuilder()).append(s1).append(" code ").append(i1).toString());
_L2:
        a(((o) (url)), ((Exception) (new a((new StringBuilder()).append(s1).append(" code ").append(i1).toString()))));
        if (true) goto _L1; else goto _L3
_L3:
        url;
        throw new a(s1, url);
    }

    public final Feed a(URL url)
    {
        Feed feed;
        try
        {
            feed = (Feed)b.b(url, com/shazam/server/response/news/Feed);
        }
        catch (j j1)
        {
            if (j1.a().a == 204)
            {
                throw new b("Token invalid logged out, changed password, or deauthorised app)", j1);
            } else
            {
                throw new a((new StringBuilder("Error while loading social feed at ")).append(url).toString(), j1);
            }
        }
        return feed;
    }

    public final PostResponse a(URL url, PublishPostRequest publishpostrequest)
    {
        String s1 = (new StringBuilder("Error publishing post via ")).append(url).toString();
        Object obj = new com.shazam.h.l.a();
        obj.e = k.c;
        obj.a = url;
        url = ((com.shazam.h.l.a) (obj)).a(r.a);
        obj = com.shazam.h.a.b.a.a(d);
        obj.b = publishpostrequest;
        url = url.b(((com.shazam.h.a.b.a) (obj)).a()).a();
        url = (PostResponse)b.a(url, com/shazam/server/response/post/PostResponse);
        return url;
        url;
        int i1;
        url = url.a();
        i1 = ((o) (url)).a;
        i1;
        JVM INSTR tableswitch 456 456: default 128
    //                   456 160;
           goto _L1 _L2
_L1:
        throw new a((new StringBuilder()).append(s1).append(" code ").append(i1).toString());
_L2:
        a(((o) (url)), ((Exception) (new a((new StringBuilder()).append(s1).append(" code ").append(i1).toString()))));
        if (true) goto _L1; else goto _L3
_L3:
        url;
        throw new a(s1, url);
    }

    public final RecognitionResponse a(URL url, RecognitionRequest recognitionrequest)
    {
        RecognitionResponse recognitionresponse = (RecognitionResponse)b.a(url, recognitionrequest, r.a, com/shazam/server/response/recognition/RecognitionResponse);
        return recognitionresponse;
        Object obj;
        obj;
_L2:
        throw new a((new StringBuilder("Error performing recognition request to ")).append(url).append(" for ").append(recognitionrequest.toString()).toString(), ((Exception) (obj)));
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final StreamingProviderTrackMappings a(URL url, String s1)
    {
        Object obj;
        try
        {
            obj = (new com.shazam.h.y.a()).a("ids", s1).a();
            obj = (StreamingProviderTrackMappings)b.a(url, ((com.shazam.h.y) (obj)), com/shazam/server/response/streaming/StreamingProviderTrackMappings);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error getting streaming provider track mappings for track ids ")).append(s1).append(" from ").append(url).toString(), j1);
        }
        return ((StreamingProviderTrackMappings) (obj));
    }

    public final void a(URL url, NotificationWritePreferences notificationwritepreferences)
    {
        notificationwritepreferences = b.a(url, notificationwritepreferences, r.a);
        if (!a.contains(Integer.valueOf(((o) (notificationwritepreferences)).a)))
        {
            throw new a((new StringBuilder("Error writing notification preferences to ")).append(url).toString());
        }
          goto _L1
        notificationwritepreferences;
_L3:
        throw new a((new StringBuilder("Error writing notification preferences to ")).append(url).toString(), notificationwritepreferences);
_L1:
        return;
        notificationwritepreferences;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final AmpConfig b(URL url, String s1)
    {
        try
        {
            com.shazam.h.l.a a1 = new com.shazam.h.l.a();
            a1.e = k.a;
            if (com.shazam.b.e.a.c(s1))
            {
                a1.a(com.shazam.o.k.a("X-Shazam-AMPKey", s1));
            }
            a1.a = url;
            s1 = a1.a();
            s1 = (AmpConfig)b.a(s1, com/shazam/server/response/config/AmpConfig);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new com.shazam.android.j.a((new StringBuilder("Error getting AMP config from ")).append(url).toString(), s1);
        }
        return s1;
    }

    public final NotificationReadPreferences b(URL url)
    {
        NotificationReadPreferences notificationreadpreferences = (NotificationReadPreferences)b.a(url, com/shazam/server/response/preferences/NotificationReadPreferences);
        return notificationreadpreferences;
        Object obj;
        obj;
_L2:
        throw new a((new StringBuilder("Error getting notification preferences from ")).append(url).toString(), ((Exception) (obj)));
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final TopTracks c(URL url)
    {
        TopTracks toptracks;
        try
        {
            toptracks = (TopTracks)b.a(url, com/shazam/server/response/explore/TopTracks);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error getting top tracks from ")).append(url).toString(), j1);
        }
        return toptracks;
    }

    public final Chart d(URL url)
    {
        Chart chart;
        try
        {
            chart = (Chart)b.a(url, com/shazam/server/response/chart/Chart);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error getting chart from ")).append(url).toString(), j1);
        }
        return chart;
    }

    public final Artist e(URL url)
    {
        Artist artist;
        try
        {
            artist = (Artist)b.a(url, com/shazam/server/response/artist/Artist);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error getting artist details from ")).append(url).toString(), j1);
        }
        return artist;
    }

    public final Details f(URL url)
    {
        Details details;
        try
        {
            details = (Details)b.a(url, com/shazam/server/response/details/Details);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error getting details from ")).append(url).toString(), j1);
        }
        return details;
    }

    public final TVAbout g(URL url)
    {
        TVAbout tvabout;
        try
        {
            tvabout = (TVAbout)b.a(url, com/shazam/server/response/tv/TVAbout);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error getting TV About from ")).append(url).toString(), j1);
        }
        return tvabout;
    }

    public final Product h(URL url)
    {
        Product product;
        try
        {
            product = (Product)b.a(url, com/shazam/server/response/product/Product);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error getting product from ")).append(url).toString(), j1);
        }
        return product;
    }

    public final IMDBActorSearchResults i(URL url)
    {
        IMDBActorSearchResults imdbactorsearchresults;
        try
        {
            imdbactorsearchresults = (IMDBActorSearchResults)b.a(url, com/shazam/server/response/imdb/IMDBActorSearchResults);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error getting IMDB actor search results from ")).append(url).toString(), j1);
        }
        return imdbactorsearchresults;
    }

    public final VideoResponse j(URL url)
    {
        VideoResponse videoresponse;
        try
        {
            videoresponse = (VideoResponse)b.a(url, com/shazam/server/response/video/VideoResponse);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error getting video from ")).append(url).toString(), j1);
        }
        return videoresponse;
    }

    public final FollowStatusResponse k(URL url)
    {
        FollowStatusResponse followstatusresponse = (FollowStatusResponse)b.a(url, com/shazam/server/response/follow/FollowStatusResponse);
        return followstatusresponse;
        j j1;
        j1;
        url = (new StringBuilder("Error getting follow status from ")).append(url).toString();
        j1.a().a;
        JVM INSTR tableswitch 456 456: default 64
    //                   456 74;
           goto _L1 _L2
_L1:
        throw new a(url, j1);
_L2:
        a(j1.a(), new a(url, j1));
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final FollowCountResponse l(URL url)
    {
        FollowCountResponse followcountresponse = (FollowCountResponse)b.a(url, com/shazam/server/response/follow/FollowCountResponse);
        return followcountresponse;
        j j1;
        j1;
        url = (new StringBuilder("Error getting followers count from ")).append(url).toString();
        j1.a().a;
        JVM INSTR tableswitch 456 456: default 64
    //                   456 74;
           goto _L1 _L2
_L1:
        throw new a(url, j1);
_L2:
        a(j1.a(), new a(url, j1));
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final FollowCountResponse m(URL url)
    {
        FollowCountResponse followcountresponse = (FollowCountResponse)b.a(url, com/shazam/server/response/follow/FollowCountResponse);
        return followcountresponse;
        j j1;
        j1;
        url = (new StringBuilder("Error getting following count from ")).append(url).toString();
        j1.a().a;
        JVM INSTR tableswitch 456 456: default 64
    //                   456 74;
           goto _L1 _L2
_L1:
        throw new a(url, j1);
_L2:
        a(j1.a(), new a(url, j1));
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final FollowingListResponse n(URL url)
    {
        FollowingListResponse followinglistresponse = (FollowingListResponse)b.a(url, com/shazam/server/response/follow/FollowingListResponse);
        return followinglistresponse;
        j j1;
        j1;
        url = (new StringBuilder("Error getting followings from ")).append(url).toString();
        j1.a().a;
        JVM INSTR tableswitch 456 456: default 64
    //                   456 74;
           goto _L1 _L2
_L1:
        throw new a(url, j1);
_L2:
        a(j1.a(), new a(url, j1));
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final ArtistPage o(URL url)
    {
        ArtistPage artistpage;
        try
        {
            artistpage = (ArtistPage)b.a(url, com/shazam/server/response/artist/ArtistPage);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error getting artist page from ")).append(url).toString(), j1);
        }
        return artistpage;
    }

    public final void p(URL url)
    {
        String s1;
        int j1;
        s1 = (new StringBuilder("Error following artist via ")).append(url).toString();
        try
        {
            com.shazam.h.i i1 = b;
            com.shazam.h.l.a a1 = new com.shazam.h.l.a();
            a1.e = k.c;
            a1.a = url;
            url = i1.a(a1.a());
            j1 = ((o) (url)).a;
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            throw new a(s1, url);
        }
        j1;
        JVM INSTR lookupswitch 2: default 175
    //                   204: 174
    //                   456: 135;
           goto _L1 _L2 _L3
_L1:
        throw new a((new StringBuilder()).append(s1).append(" code ").append(j1).toString());
_L3:
        a(url, new a((new StringBuilder()).append(s1).append(" code ").append(j1).toString()));
          goto _L1
_L2:
    }

    public final void q(URL url)
    {
        String s1;
        int j1;
        s1 = (new StringBuilder("Error unfollowing artist via ")).append(url).toString();
        try
        {
            com.shazam.h.i i1 = b;
            com.shazam.h.l.a a1 = new com.shazam.h.l.a();
            a1.e = k.d;
            a1.a = url;
            url = i1.a(a1.a());
            j1 = ((o) (url)).a;
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            throw new a(s1, url);
        }
        j1;
        JVM INSTR lookupswitch 2: default 175
    //                   204: 174
    //                   456: 135;
           goto _L1 _L2 _L3
_L1:
        throw new a((new StringBuilder()).append(s1).append(" code ").append(j1).toString());
_L3:
        a(url, new a((new StringBuilder()).append(s1).append(" code ").append(j1).toString()));
          goto _L1
_L2:
    }

    public final PostResponse r(URL url)
    {
        PostResponse postresponse = (PostResponse)b.a(url, com/shazam/server/response/post/PostResponse);
        return postresponse;
        j j1;
        j1;
        url = (new StringBuilder("Error getting post from ")).append(url).toString();
        j1.a().a;
        JVM INSTR tableswitch 456 456: default 64
    //                   456 74;
           goto _L1 _L2
_L1:
        throw new a(url, j1);
_L2:
        a(j1.a(), new a(url, j1));
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void s(URL url)
    {
        String s1;
        int j1;
        s1 = (new StringBuilder("Error unpublishing post via ")).append(url).toString();
        try
        {
            com.shazam.h.i i1 = b;
            com.shazam.h.l.a a1 = new com.shazam.h.l.a();
            a1.e = k.d;
            a1.a = url;
            url = i1.a(a1.a());
            j1 = ((o) (url)).a;
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            throw new a(s1, url);
        }
        j1;
        JVM INSTR lookupswitch 2: default 175
    //                   204: 174
    //                   456: 135;
           goto _L1 _L2 _L3
_L1:
        throw new a((new StringBuilder()).append(s1).append(" code ").append(j1).toString());
_L3:
        a(url, new a((new StringBuilder()).append(s1).append(" code ").append(j1).toString()));
          goto _L1
_L2:
    }

    public final void t(URL url)
    {
        String s1;
        int j1;
        s1 = (new StringBuilder("Error liking post via ")).append(url).toString();
        try
        {
            com.shazam.h.i i1 = b;
            com.shazam.h.l.a a1 = new com.shazam.h.l.a();
            a1.e = k.c;
            a1.a = url;
            url = i1.a(a1.a());
            j1 = ((o) (url)).a;
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            throw new a(s1, url);
        }
        j1;
        JVM INSTR lookupswitch 2: default 175
    //                   204: 174
    //                   456: 135;
           goto _L1 _L2 _L3
_L1:
        throw new a((new StringBuilder()).append(s1).append(" code ").append(j1).toString());
_L3:
        a(url, new a((new StringBuilder()).append(s1).append(" code ").append(j1).toString()));
          goto _L1
_L2:
    }

    public final void u(URL url)
    {
        String s1;
        int j1;
        s1 = (new StringBuilder("Error unliking post via ")).append(url).toString();
        try
        {
            com.shazam.h.i i1 = b;
            com.shazam.h.l.a a1 = new com.shazam.h.l.a();
            a1.e = k.d;
            a1.a = url;
            url = i1.a(a1.a());
            j1 = ((o) (url)).a;
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            throw new a(s1, url);
        }
        j1;
        JVM INSTR lookupswitch 2: default 175
    //                   204: 174
    //                   456: 135;
           goto _L1 _L2 _L3
_L1:
        throw new a((new StringBuilder()).append(s1).append(" code ").append(j1).toString());
_L3:
        a(url, new a((new StringBuilder()).append(s1).append(" code ").append(j1).toString()));
          goto _L1
_L2:
    }

    public final TagCount v(URL url)
    {
        TagCount tagcount;
        try
        {
            tagcount = (TagCount)b.a(url, com/shazam/server/response/track/TagCount);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error getting tag count from ")).append(url).toString(), j1);
        }
        return tagcount;
    }

    public final SearchResponse w(URL url)
    {
        SearchResponse searchresponse;
        try
        {
            searchresponse = (SearchResponse)b.a(url, com/shazam/server/response/search/SearchResponse);
        }
        catch (j j1)
        {
            throw new a((new StringBuilder("Error performing search with url ")).append(url).toString(), j1);
        }
        return searchresponse;
    }

}
