// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.util.List;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Comment;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;

// Referenced classes of package my.googlemusic.play.interfaces:
//            DatabaseCallback, LikeHitCallback, SearchCallback

public interface Server
{
    public static interface Callback
    {

        public abstract void onFailure(Response response);

        public abstract void onProgress(int i);

        public abstract void onSuccess(Object obj);
    }

    public static interface ServerCallback
    {

        public abstract void onFailed(Object obj);

        public abstract void onSuccess(Object obj);
    }


    public static final String BROADCAST_ACTION = "MIXTAPEZ BROADCAST";
    public static final String BROADCAST_EXTRAS = "EXTRAS";
    public static final String BROADCAST_EXTRAS_ADDITIONAL = "EXTRAS ADDITIONAL";
    public static final String BROADCAST_EXTRAS_AD_FINISHED = "ADS FINISHED";
    public static final String BROADCAST_EXTRAS_ALBUM_DELETED = "ALBUM DELETED";
    public static final String BROADCAST_EXTRAS_DOWNLOAD_ADDED = "DOWNLOAD ADDED";
    public static final String BROADCAST_EXTRAS_DOWNLOAD_COMPLETED = "DOWNLOAD COMPLETED";
    public static final String BROADCAST_EXTRAS_DOWNLOAD_DELETED = "DOWNLOAD DELETED";
    public static final String BROADCAST_EXTRAS_DOWNLOAD_FINISHED = "DOWNLOAD FINISHED";
    public static final String BROADCAST_EXTRAS_FAVORITE_ADDED = "FAVORITE ADDED";
    public static final String BROADCAST_EXTRAS_FAVORITE_DELETED = "FAVORITE REMOVED";
    public static final String BROADCAST_EXTRAS_MUSIC_BUFFERING = "MUSIC BUFFERING";
    public static final String BROADCAST_EXTRAS_MUSIC_CHANGED = "MUSIC CHANGED";
    public static final String BROADCAST_EXTRAS_MUSIC_MEDIA_PLAYER_FINISHED = "MUSIC MEDIA PLAYER FINISHED";
    public static final String BROADCAST_EXTRAS_MUSIC_PAUSED = "MUSIC PAUSED";
    public static final String BROADCAST_EXTRAS_MUSIC_PLAYING = "MUSIC PLAYING";
    public static final String BROADCAST_EXTRAS_MUSIC_PREPARED = "MUSIC PREPARED";
    public static final String BROADCAST_EXTRAS_PLAYER_QUEUE = "PLAYER QUEUE";
    public static final String DIRECTORY_MUSIC = "My Mixtapez";
    public static final String DIRECTORY_MUSIC_OLD = "my_music";

    public abstract void addComment(Comment comment, Callback callback);

    public abstract void addDownload(List list, Callback callback);

    public abstract void addDownload(Song song, Callback callback);

    public abstract void addFavorite(Song song, Callback callback);

    public abstract void addFriend(long l, long l1, Callback callback);

    public abstract void addHit(long l, long l1);

    public abstract void addLike(long l, long l1, int i, Callback callback);

    public abstract void addReply(Comment comment, long l, Callback callback);

    public abstract void addSongInHitList(long l);

    public abstract void changeBadge(int i);

    public abstract void changeBio(String s, Callback callback);

    public abstract void changeEmail(String s, Callback callback);

    public abstract void changeInstagram(String s, Callback callback);

    public abstract void changeName(String s, String s1, Callback callback);

    public abstract void changePassword(String s, String s1, Callback callback);

    public abstract void changeUsername(String s, Callback callback);

    public abstract void createAccount(String s, String s1, String s2, String s3, Callback callback);

    public abstract long decryptAlbumId(String s, String s1);

    public abstract void deleteAlbum(Album album, Callback callback);

    public abstract void deleteComment(Comment comment, Callback callback);

    public abstract void deleteDownload(Song song, Callback callback);

    public abstract void deleteFavorite(Song song, Callback callback);

    public abstract void deleteReply(Comment comment, Callback callback);

    public abstract void downloadDabbSong(Song song, Callback callback);

    public abstract void enterPromoCode(long l, String s, Callback callback);

    public abstract Album getAlbum(long l);

    public abstract void getAlbum(long l, Callback callback);

    public abstract void getAlbumFromServer(long l, Callback callback);

    public abstract List getAlbumsArtist(Artist artist);

    public abstract List getAlbumsArtist(Artist artist, int i);

    public abstract List getAlbumsRelated(Artist artist);

    public abstract List getAlbumsRelated(Artist artist, int i);

    public abstract List getArtistSongs(long l);

    public abstract void getArtistsFeatured(long l, DatabaseCallback databasecallback);

    public abstract void getBadgeList(long l, Callback callback);

    public abstract void getComments(Album album, int i, String s, Callback callback);

    public abstract Song getDownload(long l);

    public abstract int getDownloadQuality();

    public abstract List getDownloads();

    public abstract List getFavorites();

    public abstract List getFeatures();

    public abstract void getFeaturesFromServer(ServerCallback servercallback);

    public abstract void getFeed(long l, int i, String s, Callback callback);

    public abstract void getFollowers(long l, long l1, int i, Callback callback);

    public abstract void getFollowing(long l, long l1, int i, Callback callback);

    public abstract List getJustAdded();

    public abstract List getJustAdded(long l);

    public abstract void getJustAddedFromServer(ServerCallback servercallback);

    public abstract void getLikeHits(LikeHitCallback likehitcallback, long l);

    public abstract String getLinkAlbumImage();

    public abstract String getLinkAlbumImage(long l, long l1, String s);

    public abstract String getLinkArtistImage(long l);

    public abstract String getLinkBadge(long l, int i);

    public abstract String getLinkDownloadSong();

    public abstract String getLinkStreamingSong();

    public abstract String getLinkUserImage(long l);

    public abstract String getLinkVideoImage();

    public abstract String getLinkVideoStream();

    public abstract List getMoreFromArtist(String s);

    public abstract File getMusicDirectory(Song song);

    public abstract void getPremiumPass(Callback callback);

    public abstract void getProfile(long l, long l1, Callback callback);

    public abstract void getProfileFavorites(long l, int i, int j, Callback callback);

    public abstract void getProfileFeed(long l, int i, String s, Callback callback);

    public abstract List getRadio();

    public abstract void getRealAlbumId(String s, Callback callback);

    public abstract void getRecommendedUser(Callback callback);

    public abstract void getReply(long l, Callback callback);

    public abstract List getSearchAlbum(String s, int i);

    public abstract List getSearchArtist(String s, int i);

    public abstract List getSearchSong(String s, int i);

    public abstract void getSearchUser(String s, int i, Callback callback);

    public abstract List getSingles();

    public abstract void getSinglesFromServer(ServerCallback servercallback);

    public abstract Song getSong(long l);

    public abstract String getSongPath(Song song);

    public abstract List getSongs(List list);

    public abstract List getSongs(Album album);

    public abstract int getStreamQuality();

    public abstract void getTargetSpot(Callback callback);

    public abstract void getUpcoming(Callback callback);

    public abstract User getUser();

    public abstract void getVideos(Callback callback);

    public abstract boolean hasSongHit(long l);

    public abstract File isDownloadFinished(String s, String s1, String s2);

    public abstract boolean isDownloadFinished(Song song);

    public abstract boolean isDownloaded(long l);

    public abstract boolean isDownloaded(Song song);

    public abstract boolean isEmptyLinks();

    public abstract boolean isFavorited(Song song);

    public abstract boolean isLogged();

    public abstract boolean isStreaming(long l);

    public abstract void loadMoreJustAdded(ServerCallback servercallback, long l, int i);

    public abstract void login(String s, String s1, Callback callback);

    public abstract void loginGoogle(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, Callback callback);

    public abstract void loginSkip();

    public abstract void logout();

    public abstract void moveFile(String s, String s1, Callback callback);

    public abstract void recoverPassword(String s, Callback callback);

    public abstract void registerNotification(long l, String s, String s1, Callback callback);

    public abstract void removeFriend(long l, long l1, Callback callback);

    public abstract void removeNotification(long l, String s);

    public abstract void replyComment(Comment comment, Callback callback);

    public abstract void reportComment(Comment comment, Callback callback);

    public abstract void requestStore(Callback callback, long l);

    public abstract void searchAlbum(SearchCallback searchcallback, String s, int i, int j);

    public abstract void searchArtist(SearchCallback searchcallback, String s, int i, int j);

    public abstract void searchSong(SearchCallback searchcallback, String s, int i, int j);

    public abstract void sendBroadcast(String s);

    public abstract void sendPremiumPass(String s, Callback callback);

    public abstract void sendSongVote(long l);

    public abstract void setBadge(long l, int i, Callback callback);

    public abstract void setDownloadQuality(int i);

    public abstract void setRateUs(boolean flag);

    public abstract void setRingtoner(Song song, Context context, Callback callback);

    public abstract void setStreamQuality(int i);

    public abstract void tempSearchArtist(SearchCallback searchcallback, String s, int i, int j);

    public abstract void updateDatabase(Callback callback);

    public abstract void updateLinks(Callback callback);

    public abstract void updatePlayLists(Callback callback);

    public abstract void updateRadio(Callback callback);

    public abstract void upgradePremium(long l);

    public abstract void upgradePremium(long l, Callback callback);

    public abstract void uploadImageUser(Bitmap bitmap, Callback callback);

    public abstract void verifyDownloadsFiles();

    public abstract void verifyVersion(Callback callback);
}
