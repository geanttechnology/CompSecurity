// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a;

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
import java.net.URL;

public interface g
{

    public abstract LikeCountsAndStatusesResponse a(URL url, LikeCountsAndStatusesRequest likecountsandstatusesrequest);

    public abstract Feed a(URL url);

    public abstract PostResponse a(URL url, PublishPostRequest publishpostrequest);

    public abstract RecognitionResponse a(URL url, RecognitionRequest recognitionrequest);

    public abstract StreamingProviderTrackMappings a(URL url, String s1);

    public abstract void a(URL url, NotificationWritePreferences notificationwritepreferences);

    public abstract AmpConfig b(URL url, String s1);

    public abstract NotificationReadPreferences b(URL url);

    public abstract TopTracks c(URL url);

    public abstract Chart d(URL url);

    public abstract Artist e(URL url);

    public abstract Details f(URL url);

    public abstract TVAbout g(URL url);

    public abstract Product h(URL url);

    public abstract IMDBActorSearchResults i(URL url);

    public abstract VideoResponse j(URL url);

    public abstract FollowStatusResponse k(URL url);

    public abstract FollowCountResponse l(URL url);

    public abstract FollowCountResponse m(URL url);

    public abstract FollowingListResponse n(URL url);

    public abstract ArtistPage o(URL url);

    public abstract void p(URL url);

    public abstract void q(URL url);

    public abstract PostResponse r(URL url);

    public abstract void s(URL url);

    public abstract void t(URL url);

    public abstract void u(URL url);

    public abstract TagCount v(URL url);

    public abstract SearchResponse w(URL url);
}
