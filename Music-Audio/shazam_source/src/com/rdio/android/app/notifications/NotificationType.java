// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.app.notifications;


public final class NotificationType extends Enum
{

    private static final NotificationType $VALUES[];
    public static final NotificationType AddedSongToPlaylist;
    public static final NotificationType CollectionSetComment;
    public static final NotificationType CollectionSetFavorited;
    public static final NotificationType CollectionSetUpdated;
    public static final NotificationType CommentAlsoReplied;
    public static final NotificationType CommentLike;
    public static final NotificationType CommentReply;
    public static final NotificationType FacebookFriendJoined;
    public static final NotificationType ItemShared;
    public static final NotificationType LabelNewReleases;
    public static final NotificationType MessageThreadReply;
    public static final NotificationType NewAlbumRights;
    public static final NotificationType NewEpisodeForSeasonPass;
    public static final NotificationType NewEpisodesForSeries;
    public static final NotificationType NewExtraForSeasonPass;
    public static final NotificationType NewExtrasForSeries;
    public static final NotificationType NewMovieDirectedByFavoritedContributor;
    public static final NotificationType NewMovieFeaturingFavoritedContributor;
    public static final NotificationType NewMovieForStudio;
    public static final NotificationType NewMovieWrittenByFavoritedContributor;
    public static final NotificationType NewReleaseInNotifyWhenAvailable;
    public static final NotificationType NewSeriesDirectedByFavoritedContributor;
    public static final NotificationType NewSeriesFeaturingFavoritedContributor;
    public static final NotificationType NewSeriesForNetwork;
    public static final NotificationType NewSeriesWrittenByFavoritedContributor;
    public static final NotificationType None;
    public static final NotificationType PendingFollowRequestAccepted;
    public static final NotificationType PreorderedMovieNowAvailable;
    public static final NotificationType ReviewedPlaylist;
    public static final NotificationType SubscribedToPlaylist;
    public static final NotificationType TwitterFriendJoined;
    public static final NotificationType UserFollowed;
    public static final NotificationType UserFollowedRequest;
    public static final NotificationType UserMentionedInComment;

    private NotificationType(String s, int i)
    {
        super(s, i);
    }

    public static NotificationType valueOf(String s)
    {
        return (NotificationType)Enum.valueOf(com/rdio/android/app/notifications/NotificationType, s);
    }

    public static NotificationType[] values()
    {
        return (NotificationType[])$VALUES.clone();
    }

    static 
    {
        None = new NotificationType("None", 0);
        UserFollowed = new NotificationType("UserFollowed", 1);
        ItemShared = new NotificationType("ItemShared", 2);
        SubscribedToPlaylist = new NotificationType("SubscribedToPlaylist", 3);
        ReviewedPlaylist = new NotificationType("ReviewedPlaylist", 4);
        AddedSongToPlaylist = new NotificationType("AddedSongToPlaylist", 5);
        UserFollowedRequest = new NotificationType("UserFollowedRequest", 6);
        TwitterFriendJoined = new NotificationType("TwitterFriendJoined", 7);
        FacebookFriendJoined = new NotificationType("FacebookFriendJoined", 8);
        NewAlbumRights = new NotificationType("NewAlbumRights", 9);
        CollectionSetUpdated = new NotificationType("CollectionSetUpdated", 10);
        CollectionSetFavorited = new NotificationType("CollectionSetFavorited", 11);
        CollectionSetComment = new NotificationType("CollectionSetComment", 12);
        NewEpisodesForSeries = new NotificationType("NewEpisodesForSeries", 13);
        NewMovieForStudio = new NotificationType("NewMovieForStudio", 14);
        NewSeriesForNetwork = new NotificationType("NewSeriesForNetwork", 15);
        NewMovieFeaturingFavoritedContributor = new NotificationType("NewMovieFeaturingFavoritedContributor", 16);
        NewMovieDirectedByFavoritedContributor = new NotificationType("NewMovieDirectedByFavoritedContributor", 17);
        NewMovieWrittenByFavoritedContributor = new NotificationType("NewMovieWrittenByFavoritedContributor", 18);
        NewSeriesDirectedByFavoritedContributor = new NotificationType("NewSeriesDirectedByFavoritedContributor", 19);
        NewSeriesFeaturingFavoritedContributor = new NotificationType("NewSeriesFeaturingFavoritedContributor", 20);
        NewSeriesWrittenByFavoritedContributor = new NotificationType("NewSeriesWrittenByFavoritedContributor", 21);
        NewEpisodeForSeasonPass = new NotificationType("NewEpisodeForSeasonPass", 22);
        PreorderedMovieNowAvailable = new NotificationType("PreorderedMovieNowAvailable", 23);
        NewReleaseInNotifyWhenAvailable = new NotificationType("NewReleaseInNotifyWhenAvailable", 24);
        PendingFollowRequestAccepted = new NotificationType("PendingFollowRequestAccepted", 25);
        NewExtrasForSeries = new NotificationType("NewExtrasForSeries", 26);
        NewExtraForSeasonPass = new NotificationType("NewExtraForSeasonPass", 27);
        CommentReply = new NotificationType("CommentReply", 28);
        CommentLike = new NotificationType("CommentLike", 29);
        CommentAlsoReplied = new NotificationType("CommentAlsoReplied", 30);
        MessageThreadReply = new NotificationType("MessageThreadReply", 31);
        UserMentionedInComment = new NotificationType("UserMentionedInComment", 32);
        LabelNewReleases = new NotificationType("LabelNewReleases", 33);
        $VALUES = (new NotificationType[] {
            None, UserFollowed, ItemShared, SubscribedToPlaylist, ReviewedPlaylist, AddedSongToPlaylist, UserFollowedRequest, TwitterFriendJoined, FacebookFriendJoined, NewAlbumRights, 
            CollectionSetUpdated, CollectionSetFavorited, CollectionSetComment, NewEpisodesForSeries, NewMovieForStudio, NewSeriesForNetwork, NewMovieFeaturingFavoritedContributor, NewMovieDirectedByFavoritedContributor, NewMovieWrittenByFavoritedContributor, NewSeriesDirectedByFavoritedContributor, 
            NewSeriesFeaturingFavoritedContributor, NewSeriesWrittenByFavoritedContributor, NewEpisodeForSeasonPass, PreorderedMovieNowAvailable, NewReleaseInNotifyWhenAvailable, PendingFollowRequestAccepted, NewExtrasForSeries, NewExtraForSeasonPass, CommentReply, CommentLike, 
            CommentAlsoReplied, MessageThreadReply, UserMentionedInComment, LabelNewReleases
        });
    }
}
