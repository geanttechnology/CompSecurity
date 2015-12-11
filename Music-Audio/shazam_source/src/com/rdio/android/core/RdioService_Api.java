// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import java.util.List;

// Referenced classes of package com.rdio.android.core:
//            RdioApiRequestArg, RdioApiResponse

public abstract class RdioService_Api
{
    public static final class AddToPlaylist_duplicateHandling extends Enum
    {

        private static final AddToPlaylist_duplicateHandling $VALUES[];
        public static final AddToPlaylist_duplicateHandling Allow;
        public static final AddToPlaylist_duplicateHandling Error;
        public static final AddToPlaylist_duplicateHandling Ignore;

        public static AddToPlaylist_duplicateHandling valueOf(String s)
        {
            return (AddToPlaylist_duplicateHandling)Enum.valueOf(com/rdio/android/core/RdioService_Api$AddToPlaylist_duplicateHandling, s);
        }

        public static AddToPlaylist_duplicateHandling[] values()
        {
            return (AddToPlaylist_duplicateHandling[])$VALUES.clone();
        }

        static 
        {
            Ignore = new AddToPlaylist_duplicateHandling("Ignore", 0);
            Allow = new AddToPlaylist_duplicateHandling("Allow", 1);
            Error = new AddToPlaylist_duplicateHandling("Error", 2);
            $VALUES = (new AddToPlaylist_duplicateHandling[] {
                Ignore, Allow, Error
            });
        }

        private AddToPlaylist_duplicateHandling(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetAlbumsForArtistInCollection_sort extends Enum
    {

        private static final GetAlbumsForArtistInCollection_sort $VALUES[];
        public static final GetAlbumsForArtistInCollection_sort Name;
        public static final GetAlbumsForArtistInCollection_sort ReleaseDate;

        public static GetAlbumsForArtistInCollection_sort valueOf(String s)
        {
            return (GetAlbumsForArtistInCollection_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetAlbumsForArtistInCollection_sort, s);
        }

        public static GetAlbumsForArtistInCollection_sort[] values()
        {
            return (GetAlbumsForArtistInCollection_sort[])$VALUES.clone();
        }

        static 
        {
            ReleaseDate = new GetAlbumsForArtistInCollection_sort("ReleaseDate", 0);
            Name = new GetAlbumsForArtistInCollection_sort("Name", 1);
            $VALUES = (new GetAlbumsForArtistInCollection_sort[] {
                ReleaseDate, Name
            });
        }

        private GetAlbumsForArtistInCollection_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetAlbumsForArtist_sort extends Enum
    {

        private static final GetAlbumsForArtist_sort $VALUES[];
        public static final GetAlbumsForArtist_sort Name;
        public static final GetAlbumsForArtist_sort PlayCount;
        public static final GetAlbumsForArtist_sort ReleaseDate;

        public static GetAlbumsForArtist_sort valueOf(String s)
        {
            return (GetAlbumsForArtist_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetAlbumsForArtist_sort, s);
        }

        public static GetAlbumsForArtist_sort[] values()
        {
            return (GetAlbumsForArtist_sort[])$VALUES.clone();
        }

        static 
        {
            ReleaseDate = new GetAlbumsForArtist_sort("ReleaseDate", 0);
            PlayCount = new GetAlbumsForArtist_sort("PlayCount", 1);
            Name = new GetAlbumsForArtist_sort("Name", 2);
            $VALUES = (new GetAlbumsForArtist_sort[] {
                ReleaseDate, PlayCount, Name
            });
        }

        private GetAlbumsForArtist_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetAlbumsForLabel_sort extends Enum
    {

        private static final GetAlbumsForLabel_sort $VALUES[];
        public static final GetAlbumsForLabel_sort Name;
        public static final GetAlbumsForLabel_sort PlayCount;
        public static final GetAlbumsForLabel_sort ReleaseDate;

        public static GetAlbumsForLabel_sort valueOf(String s)
        {
            return (GetAlbumsForLabel_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetAlbumsForLabel_sort, s);
        }

        public static GetAlbumsForLabel_sort[] values()
        {
            return (GetAlbumsForLabel_sort[])$VALUES.clone();
        }

        static 
        {
            ReleaseDate = new GetAlbumsForLabel_sort("ReleaseDate", 0);
            PlayCount = new GetAlbumsForLabel_sort("PlayCount", 1);
            Name = new GetAlbumsForLabel_sort("Name", 2);
            $VALUES = (new GetAlbumsForLabel_sort[] {
                ReleaseDate, PlayCount, Name
            });
        }

        private GetAlbumsForLabel_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetAlbumsInCollection_sort extends Enum
    {

        private static final GetAlbumsInCollection_sort $VALUES[];
        public static final GetAlbumsInCollection_sort Artist;
        public static final GetAlbumsInCollection_sort DateAdded;
        public static final GetAlbumsInCollection_sort Name;
        public static final GetAlbumsInCollection_sort PlayCount;

        public static GetAlbumsInCollection_sort valueOf(String s)
        {
            return (GetAlbumsInCollection_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetAlbumsInCollection_sort, s);
        }

        public static GetAlbumsInCollection_sort[] values()
        {
            return (GetAlbumsInCollection_sort[])$VALUES.clone();
        }

        static 
        {
            PlayCount = new GetAlbumsInCollection_sort("PlayCount", 0);
            DateAdded = new GetAlbumsInCollection_sort("DateAdded", 1);
            Name = new GetAlbumsInCollection_sort("Name", 2);
            Artist = new GetAlbumsInCollection_sort("Artist", 3);
            $VALUES = (new GetAlbumsInCollection_sort[] {
                PlayCount, DateAdded, Name, Artist
            });
        }

        private GetAlbumsInCollection_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetArtistsFromFavoriteTracks_sort extends Enum
    {

        private static final GetArtistsFromFavoriteTracks_sort $VALUES[];
        public static final GetArtistsFromFavoriteTracks_sort DateAdded;
        public static final GetArtistsFromFavoriteTracks_sort Name;

        public static GetArtistsFromFavoriteTracks_sort valueOf(String s)
        {
            return (GetArtistsFromFavoriteTracks_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetArtistsFromFavoriteTracks_sort, s);
        }

        public static GetArtistsFromFavoriteTracks_sort[] values()
        {
            return (GetArtistsFromFavoriteTracks_sort[])$VALUES.clone();
        }

        static 
        {
            DateAdded = new GetArtistsFromFavoriteTracks_sort("DateAdded", 0);
            Name = new GetArtistsFromFavoriteTracks_sort("Name", 1);
            $VALUES = (new GetArtistsFromFavoriteTracks_sort[] {
                DateAdded, Name
            });
        }

        private GetArtistsFromFavoriteTracks_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetArtistsFromSyncedTracks_sort extends Enum
    {

        private static final GetArtistsFromSyncedTracks_sort $VALUES[];
        public static final GetArtistsFromSyncedTracks_sort DateAdded;
        public static final GetArtistsFromSyncedTracks_sort Name;

        public static GetArtistsFromSyncedTracks_sort valueOf(String s)
        {
            return (GetArtistsFromSyncedTracks_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetArtistsFromSyncedTracks_sort, s);
        }

        public static GetArtistsFromSyncedTracks_sort[] values()
        {
            return (GetArtistsFromSyncedTracks_sort[])$VALUES.clone();
        }

        static 
        {
            DateAdded = new GetArtistsFromSyncedTracks_sort("DateAdded", 0);
            Name = new GetArtistsFromSyncedTracks_sort("Name", 1);
            $VALUES = (new GetArtistsFromSyncedTracks_sort[] {
                DateAdded, Name
            });
        }

        private GetArtistsFromSyncedTracks_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetArtistsInCollection_sort extends Enum
    {

        private static final GetArtistsInCollection_sort $VALUES[];
        public static final GetArtistsInCollection_sort Name;
        public static final GetArtistsInCollection_sort PlayCount;

        public static GetArtistsInCollection_sort valueOf(String s)
        {
            return (GetArtistsInCollection_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetArtistsInCollection_sort, s);
        }

        public static GetArtistsInCollection_sort[] values()
        {
            return (GetArtistsInCollection_sort[])$VALUES.clone();
        }

        static 
        {
            PlayCount = new GetArtistsInCollection_sort("PlayCount", 0);
            Name = new GetArtistsInCollection_sort("Name", 1);
            $VALUES = (new GetArtistsInCollection_sort[] {
                PlayCount, Name
            });
        }

        private GetArtistsInCollection_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetFavoritesByArtist_sort extends Enum
    {

        private static final GetFavoritesByArtist_sort $VALUES[];
        public static final GetFavoritesByArtist_sort DateAdded;
        public static final GetFavoritesByArtist_sort Name;
        public static final GetFavoritesByArtist_sort PlayCount;

        public static GetFavoritesByArtist_sort valueOf(String s)
        {
            return (GetFavoritesByArtist_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetFavoritesByArtist_sort, s);
        }

        public static GetFavoritesByArtist_sort[] values()
        {
            return (GetFavoritesByArtist_sort[])$VALUES.clone();
        }

        static 
        {
            PlayCount = new GetFavoritesByArtist_sort("PlayCount", 0);
            DateAdded = new GetFavoritesByArtist_sort("DateAdded", 1);
            Name = new GetFavoritesByArtist_sort("Name", 2);
            $VALUES = (new GetFavoritesByArtist_sort[] {
                PlayCount, DateAdded, Name
            });
        }

        private GetFavoritesByArtist_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetFavorites_sort extends Enum
    {

        private static final GetFavorites_sort $VALUES[];
        public static final GetFavorites_sort DateAdded;
        public static final GetFavorites_sort Name;
        public static final GetFavorites_sort PlayCount;

        public static GetFavorites_sort valueOf(String s)
        {
            return (GetFavorites_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetFavorites_sort, s);
        }

        public static GetFavorites_sort[] values()
        {
            return (GetFavorites_sort[])$VALUES.clone();
        }

        static 
        {
            PlayCount = new GetFavorites_sort("PlayCount", 0);
            DateAdded = new GetFavorites_sort("DateAdded", 1);
            Name = new GetFavorites_sort("Name", 2);
            $VALUES = (new GetFavorites_sort[] {
                PlayCount, DateAdded, Name
            });
        }

        private GetFavorites_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetFavorites_types extends Enum
    {

        private static final GetFavorites_types $VALUES[];
        public static final GetFavorites_types Artists;
        public static final GetFavorites_types Labels;
        public static final GetFavorites_types Playlists;
        public static final GetFavorites_types Stations;
        public static final GetFavorites_types TracksAndAlbums;

        public static GetFavorites_types valueOf(String s)
        {
            return (GetFavorites_types)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetFavorites_types, s);
        }

        public static GetFavorites_types[] values()
        {
            return (GetFavorites_types[])$VALUES.clone();
        }

        static 
        {
            Artists = new GetFavorites_types("Artists", 0);
            Labels = new GetFavorites_types("Labels", 1);
            Playlists = new GetFavorites_types("Playlists", 2);
            Stations = new GetFavorites_types("Stations", 3);
            TracksAndAlbums = new GetFavorites_types("TracksAndAlbums", 4);
            $VALUES = (new GetFavorites_types[] {
                Artists, Labels, Playlists, Stations, TracksAndAlbums
            });
        }

        private GetFavorites_types(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetHeavyRotation_type extends Enum
    {

        private static final GetHeavyRotation_type $VALUES[];
        public static final GetHeavyRotation_type Albums;
        public static final GetHeavyRotation_type Artists;
        public static final GetHeavyRotation_type Playlists;
        public static final GetHeavyRotation_type Stations;
        public static final GetHeavyRotation_type Tracks;

        public static GetHeavyRotation_type valueOf(String s)
        {
            return (GetHeavyRotation_type)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetHeavyRotation_type, s);
        }

        public static GetHeavyRotation_type[] values()
        {
            return (GetHeavyRotation_type[])$VALUES.clone();
        }

        static 
        {
            Albums = new GetHeavyRotation_type("Albums", 0);
            Stations = new GetHeavyRotation_type("Stations", 1);
            Playlists = new GetHeavyRotation_type("Playlists", 2);
            Tracks = new GetHeavyRotation_type("Tracks", 3);
            Artists = new GetHeavyRotation_type("Artists", 4);
            $VALUES = (new GetHeavyRotation_type[] {
                Albums, Stations, Playlists, Tracks, Artists
            });
        }

        private GetHeavyRotation_type(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetNewReleasesStationAndAlbums_time extends Enum
    {

        private static final GetNewReleasesStationAndAlbums_time $VALUES[];
        public static final GetNewReleasesStationAndAlbums_time Lastweek;
        public static final GetNewReleasesStationAndAlbums_time Overview;
        public static final GetNewReleasesStationAndAlbums_time Thisweek;
        public static final GetNewReleasesStationAndAlbums_time Twoweeks;

        public static GetNewReleasesStationAndAlbums_time valueOf(String s)
        {
            return (GetNewReleasesStationAndAlbums_time)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetNewReleasesStationAndAlbums_time, s);
        }

        public static GetNewReleasesStationAndAlbums_time[] values()
        {
            return (GetNewReleasesStationAndAlbums_time[])$VALUES.clone();
        }

        static 
        {
            Thisweek = new GetNewReleasesStationAndAlbums_time("Thisweek", 0);
            Overview = new GetNewReleasesStationAndAlbums_time("Overview", 1);
            Lastweek = new GetNewReleasesStationAndAlbums_time("Lastweek", 2);
            Twoweeks = new GetNewReleasesStationAndAlbums_time("Twoweeks", 3);
            $VALUES = (new GetNewReleasesStationAndAlbums_time[] {
                Thisweek, Overview, Lastweek, Twoweeks
            });
        }

        private GetNewReleasesStationAndAlbums_time(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetNewReleases_time extends Enum
    {

        private static final GetNewReleases_time $VALUES[];
        public static final GetNewReleases_time Lastweek;
        public static final GetNewReleases_time Overview;
        public static final GetNewReleases_time Thisweek;
        public static final GetNewReleases_time Twoweeks;

        public static GetNewReleases_time valueOf(String s)
        {
            return (GetNewReleases_time)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetNewReleases_time, s);
        }

        public static GetNewReleases_time[] values()
        {
            return (GetNewReleases_time[])$VALUES.clone();
        }

        static 
        {
            Thisweek = new GetNewReleases_time("Thisweek", 0);
            Overview = new GetNewReleases_time("Overview", 1);
            Lastweek = new GetNewReleases_time("Lastweek", 2);
            Twoweeks = new GetNewReleases_time("Twoweeks", 3);
            $VALUES = (new GetNewReleases_time[] {
                Thisweek, Overview, Lastweek, Twoweeks
            });
        }

        private GetNewReleases_time(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetSyncedByArtist_sort extends Enum
    {

        private static final GetSyncedByArtist_sort $VALUES[];
        public static final GetSyncedByArtist_sort DateAdded;
        public static final GetSyncedByArtist_sort Name;

        public static GetSyncedByArtist_sort valueOf(String s)
        {
            return (GetSyncedByArtist_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetSyncedByArtist_sort, s);
        }

        public static GetSyncedByArtist_sort[] values()
        {
            return (GetSyncedByArtist_sort[])$VALUES.clone();
        }

        static 
        {
            DateAdded = new GetSyncedByArtist_sort("DateAdded", 0);
            Name = new GetSyncedByArtist_sort("Name", 1);
            $VALUES = (new GetSyncedByArtist_sort[] {
                DateAdded, Name
            });
        }

        private GetSyncedByArtist_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetSynced_sort extends Enum
    {

        private static final GetSynced_sort $VALUES[];
        public static final GetSynced_sort DateAdded;
        public static final GetSynced_sort Name;
        public static final GetSynced_sort PlayCount;

        public static GetSynced_sort valueOf(String s)
        {
            return (GetSynced_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetSynced_sort, s);
        }

        public static GetSynced_sort[] values()
        {
            return (GetSynced_sort[])$VALUES.clone();
        }

        static 
        {
            PlayCount = new GetSynced_sort("PlayCount", 0);
            DateAdded = new GetSynced_sort("DateAdded", 1);
            Name = new GetSynced_sort("Name", 2);
            $VALUES = (new GetSynced_sort[] {
                PlayCount, DateAdded, Name
            });
        }

        private GetSynced_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetSynced_type extends Enum
    {

        private static final GetSynced_type $VALUES[];
        public static final GetSynced_type Playlists;
        public static final GetSynced_type TracksAndAlbums;

        public static GetSynced_type valueOf(String s)
        {
            return (GetSynced_type)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetSynced_type, s);
        }

        public static GetSynced_type[] values()
        {
            return (GetSynced_type[])$VALUES.clone();
        }

        static 
        {
            TracksAndAlbums = new GetSynced_type("TracksAndAlbums", 0);
            Playlists = new GetSynced_type("Playlists", 1);
            $VALUES = (new GetSynced_type[] {
                TracksAndAlbums, Playlists
            });
        }

        private GetSynced_type(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetTracksForArtist_sort extends Enum
    {

        private static final GetTracksForArtist_sort $VALUES[];
        public static final GetTracksForArtist_sort Name;
        public static final GetTracksForArtist_sort PlayCount;
        public static final GetTracksForArtist_sort ReleaseDate;

        public static GetTracksForArtist_sort valueOf(String s)
        {
            return (GetTracksForArtist_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetTracksForArtist_sort, s);
        }

        public static GetTracksForArtist_sort[] values()
        {
            return (GetTracksForArtist_sort[])$VALUES.clone();
        }

        static 
        {
            ReleaseDate = new GetTracksForArtist_sort("ReleaseDate", 0);
            PlayCount = new GetTracksForArtist_sort("PlayCount", 1);
            Name = new GetTracksForArtist_sort("Name", 2);
            $VALUES = (new GetTracksForArtist_sort[] {
                ReleaseDate, PlayCount, Name
            });
        }

        private GetTracksForArtist_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetTracksInCollection_sort extends Enum
    {

        private static final GetTracksInCollection_sort $VALUES[];
        public static final GetTracksInCollection_sort Album;
        public static final GetTracksInCollection_sort Artist;
        public static final GetTracksInCollection_sort DateAdded;
        public static final GetTracksInCollection_sort Name;
        public static final GetTracksInCollection_sort PlayCount;

        public static GetTracksInCollection_sort valueOf(String s)
        {
            return (GetTracksInCollection_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetTracksInCollection_sort, s);
        }

        public static GetTracksInCollection_sort[] values()
        {
            return (GetTracksInCollection_sort[])$VALUES.clone();
        }

        static 
        {
            Album = new GetTracksInCollection_sort("Album", 0);
            PlayCount = new GetTracksInCollection_sort("PlayCount", 1);
            DateAdded = new GetTracksInCollection_sort("DateAdded", 2);
            Name = new GetTracksInCollection_sort("Name", 3);
            Artist = new GetTracksInCollection_sort("Artist", 4);
            $VALUES = (new GetTracksInCollection_sort[] {
                Album, PlayCount, DateAdded, Name, Artist
            });
        }

        private GetTracksInCollection_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetUserPlaylists_kind extends Enum
    {

        private static final GetUserPlaylists_kind $VALUES[];
        public static final GetUserPlaylists_kind Collab;
        public static final GetUserPlaylists_kind Favorites;
        public static final GetUserPlaylists_kind Owned;
        public static final GetUserPlaylists_kind Subscribed;

        public static GetUserPlaylists_kind valueOf(String s)
        {
            return (GetUserPlaylists_kind)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetUserPlaylists_kind, s);
        }

        public static GetUserPlaylists_kind[] values()
        {
            return (GetUserPlaylists_kind[])$VALUES.clone();
        }

        static 
        {
            Favorites = new GetUserPlaylists_kind("Favorites", 0);
            Subscribed = new GetUserPlaylists_kind("Subscribed", 1);
            Collab = new GetUserPlaylists_kind("Collab", 2);
            Owned = new GetUserPlaylists_kind("Owned", 3);
            $VALUES = (new GetUserPlaylists_kind[] {
                Favorites, Subscribed, Collab, Owned
            });
        }

        private GetUserPlaylists_kind(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class GetUserPlaylists_sort extends Enum
    {

        private static final GetUserPlaylists_sort $VALUES[];
        public static final GetUserPlaylists_sort LastUpdated;
        public static final GetUserPlaylists_sort Name;

        public static GetUserPlaylists_sort valueOf(String s)
        {
            return (GetUserPlaylists_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetUserPlaylists_sort, s);
        }

        public static GetUserPlaylists_sort[] values()
        {
            return (GetUserPlaylists_sort[])$VALUES.clone();
        }

        static 
        {
            Name = new GetUserPlaylists_sort("Name", 0);
            LastUpdated = new GetUserPlaylists_sort("LastUpdated", 1);
            $VALUES = (new GetUserPlaylists_sort[] {
                Name, LastUpdated
            });
        }

        private GetUserPlaylists_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface ResponseListener
    {

        public abstract void onResponse(RdioApiResponse rdioapiresponse);
    }

    public static final class SearchSuggestions_countryCode extends Enum
    {

        private static final SearchSuggestions_countryCode $VALUES[];
        public static final SearchSuggestions_countryCode AG;
        public static final SearchSuggestions_countryCode AI;
        public static final SearchSuggestions_countryCode AR;
        public static final SearchSuggestions_countryCode AT;
        public static final SearchSuggestions_countryCode AU;
        public static final SearchSuggestions_countryCode AW;
        public static final SearchSuggestions_countryCode BB;
        public static final SearchSuggestions_countryCode BE;
        public static final SearchSuggestions_countryCode BM;
        public static final SearchSuggestions_countryCode BO;
        public static final SearchSuggestions_countryCode BR;
        public static final SearchSuggestions_countryCode CA;
        public static final SearchSuggestions_countryCode CH;
        public static final SearchSuggestions_countryCode CL;
        public static final SearchSuggestions_countryCode CO;
        public static final SearchSuggestions_countryCode CR;
        public static final SearchSuggestions_countryCode CY;
        public static final SearchSuggestions_countryCode CZ;
        public static final SearchSuggestions_countryCode DE;
        public static final SearchSuggestions_countryCode DK;
        public static final SearchSuggestions_countryCode DM;
        public static final SearchSuggestions_countryCode DO;
        public static final SearchSuggestions_countryCode EC;
        public static final SearchSuggestions_countryCode EE;
        public static final SearchSuggestions_countryCode ES;
        public static final SearchSuggestions_countryCode FI;
        public static final SearchSuggestions_countryCode FJ;
        public static final SearchSuggestions_countryCode FR;
        public static final SearchSuggestions_countryCode GB;
        public static final SearchSuggestions_countryCode GD;
        public static final SearchSuggestions_countryCode GR;
        public static final SearchSuggestions_countryCode GT;
        public static final SearchSuggestions_countryCode GY;
        public static final SearchSuggestions_countryCode HK;
        public static final SearchSuggestions_countryCode HN;
        public static final SearchSuggestions_countryCode HR;
        public static final SearchSuggestions_countryCode HT;
        public static final SearchSuggestions_countryCode HU;
        public static final SearchSuggestions_countryCode ID;
        public static final SearchSuggestions_countryCode IE;
        public static final SearchSuggestions_countryCode IL;
        public static final SearchSuggestions_countryCode IN;
        public static final SearchSuggestions_countryCode IS;
        public static final SearchSuggestions_countryCode IT;
        public static final SearchSuggestions_countryCode JM;
        public static final SearchSuggestions_countryCode KN;
        public static final SearchSuggestions_countryCode KY;
        public static final SearchSuggestions_countryCode LC;
        public static final SearchSuggestions_countryCode LI;
        public static final SearchSuggestions_countryCode LT;
        public static final SearchSuggestions_countryCode LU;
        public static final SearchSuggestions_countryCode LV;
        public static final SearchSuggestions_countryCode MC;
        public static final SearchSuggestions_countryCode MX;
        public static final SearchSuggestions_countryCode MY;
        public static final SearchSuggestions_countryCode NI;
        public static final SearchSuggestions_countryCode NL;
        public static final SearchSuggestions_countryCode NO;
        public static final SearchSuggestions_countryCode NR;
        public static final SearchSuggestions_countryCode NZ;
        public static final SearchSuggestions_countryCode PA;
        public static final SearchSuggestions_countryCode PE;
        public static final SearchSuggestions_countryCode PG;
        public static final SearchSuggestions_countryCode PH;
        public static final SearchSuggestions_countryCode PL;
        public static final SearchSuggestions_countryCode PT;
        public static final SearchSuggestions_countryCode PY;
        public static final SearchSuggestions_countryCode SE;
        public static final SearchSuggestions_countryCode SG;
        public static final SearchSuggestions_countryCode SI;
        public static final SearchSuggestions_countryCode SK;
        public static final SearchSuggestions_countryCode SR;
        public static final SearchSuggestions_countryCode SV;
        public static final SearchSuggestions_countryCode TC;
        public static final SearchSuggestions_countryCode TH;
        public static final SearchSuggestions_countryCode TO;
        public static final SearchSuggestions_countryCode TT;
        public static final SearchSuggestions_countryCode US;
        public static final SearchSuggestions_countryCode UY;
        public static final SearchSuggestions_countryCode VC;
        public static final SearchSuggestions_countryCode VE;
        public static final SearchSuggestions_countryCode VG;
        public static final SearchSuggestions_countryCode VU;
        public static final SearchSuggestions_countryCode WS;
        public static final SearchSuggestions_countryCode ZA;

        public static SearchSuggestions_countryCode valueOf(String s)
        {
            return (SearchSuggestions_countryCode)Enum.valueOf(com/rdio/android/core/RdioService_Api$SearchSuggestions_countryCode, s);
        }

        public static SearchSuggestions_countryCode[] values()
        {
            return (SearchSuggestions_countryCode[])$VALUES.clone();
        }

        static 
        {
            BE = new SearchSuggestions_countryCode("BE", 0);
            FR = new SearchSuggestions_countryCode("FR", 1);
            BB = new SearchSuggestions_countryCode("BB", 2);
            BM = new SearchSuggestions_countryCode("BM", 3);
            BO = new SearchSuggestions_countryCode("BO", 4);
            JM = new SearchSuggestions_countryCode("JM", 5);
            WS = new SearchSuggestions_countryCode("WS", 6);
            BR = new SearchSuggestions_countryCode("BR", 7);
            FI = new SearchSuggestions_countryCode("FI", 8);
            FJ = new SearchSuggestions_countryCode("FJ", 9);
            NI = new SearchSuggestions_countryCode("NI", 10);
            NL = new SearchSuggestions_countryCode("NL", 11);
            NO = new SearchSuggestions_countryCode("NO", 12);
            VU = new SearchSuggestions_countryCode("VU", 13);
            NZ = new SearchSuggestions_countryCode("NZ", 14);
            LU = new SearchSuggestions_countryCode("LU", 15);
            AI = new SearchSuggestions_countryCode("AI", 16);
            NR = new SearchSuggestions_countryCode("NR", 17);
            GT = new SearchSuggestions_countryCode("GT", 18);
            CO = new SearchSuggestions_countryCode("CO", 19);
            GR = new SearchSuggestions_countryCode("GR", 20);
            CL = new SearchSuggestions_countryCode("CL", 21);
            CA = new SearchSuggestions_countryCode("CA", 22);
            GY = new SearchSuggestions_countryCode("GY", 23);
            CZ = new SearchSuggestions_countryCode("CZ", 24);
            CY = new SearchSuggestions_countryCode("CY", 25);
            GD = new SearchSuggestions_countryCode("GD", 26);
            GB = new SearchSuggestions_countryCode("GB", 27);
            CR = new SearchSuggestions_countryCode("CR", 28);
            HU = new SearchSuggestions_countryCode("HU", 29);
            SR = new SearchSuggestions_countryCode("SR", 30);
            SV = new SearchSuggestions_countryCode("SV", 31);
            SK = new SearchSuggestions_countryCode("SK", 32);
            SI = new SearchSuggestions_countryCode("SI", 33);
            KY = new SearchSuggestions_countryCode("KY", 34);
            SG = new SearchSuggestions_countryCode("SG", 35);
            SE = new SearchSuggestions_countryCode("SE", 36);
            DO = new SearchSuggestions_countryCode("DO", 37);
            DM = new SearchSuggestions_countryCode("DM", 38);
            DK = new SearchSuggestions_countryCode("DK", 39);
            HR = new SearchSuggestions_countryCode("HR", 40);
            DE = new SearchSuggestions_countryCode("DE", 41);
            HT = new SearchSuggestions_countryCode("HT", 42);
            KN = new SearchSuggestions_countryCode("KN", 43);
            HK = new SearchSuggestions_countryCode("HK", 44);
            CH = new SearchSuggestions_countryCode("CH", 45);
            HN = new SearchSuggestions_countryCode("HN", 46);
            LC = new SearchSuggestions_countryCode("LC", 47);
            PT = new SearchSuggestions_countryCode("PT", 48);
            TT = new SearchSuggestions_countryCode("TT", 49);
            PY = new SearchSuggestions_countryCode("PY", 50);
            LI = new SearchSuggestions_countryCode("LI", 51);
            LV = new SearchSuggestions_countryCode("LV", 52);
            TO = new SearchSuggestions_countryCode("TO", 53);
            LT = new SearchSuggestions_countryCode("LT", 54);
            PA = new SearchSuggestions_countryCode("PA", 55);
            PG = new SearchSuggestions_countryCode("PG", 56);
            TH = new SearchSuggestions_countryCode("TH", 57);
            PE = new SearchSuggestions_countryCode("PE", 58);
            PH = new SearchSuggestions_countryCode("PH", 59);
            TC = new SearchSuggestions_countryCode("TC", 60);
            PL = new SearchSuggestions_countryCode("PL", 61);
            VC = new SearchSuggestions_countryCode("VC", 62);
            VE = new SearchSuggestions_countryCode("VE", 63);
            AG = new SearchSuggestions_countryCode("AG", 64);
            VG = new SearchSuggestions_countryCode("VG", 65);
            EE = new SearchSuggestions_countryCode("EE", 66);
            IS = new SearchSuggestions_countryCode("IS", 67);
            IT = new SearchSuggestions_countryCode("IT", 68);
            EC = new SearchSuggestions_countryCode("EC", 69);
            ZA = new SearchSuggestions_countryCode("ZA", 70);
            AR = new SearchSuggestions_countryCode("AR", 71);
            AU = new SearchSuggestions_countryCode("AU", 72);
            AT = new SearchSuggestions_countryCode("AT", 73);
            AW = new SearchSuggestions_countryCode("AW", 74);
            IN = new SearchSuggestions_countryCode("IN", 75);
            IE = new SearchSuggestions_countryCode("IE", 76);
            ID = new SearchSuggestions_countryCode("ID", 77);
            ES = new SearchSuggestions_countryCode("ES", 78);
            UY = new SearchSuggestions_countryCode("UY", 79);
            MC = new SearchSuggestions_countryCode("MC", 80);
            US = new SearchSuggestions_countryCode("US", 81);
            MY = new SearchSuggestions_countryCode("MY", 82);
            MX = new SearchSuggestions_countryCode("MX", 83);
            IL = new SearchSuggestions_countryCode("IL", 84);
            $VALUES = (new SearchSuggestions_countryCode[] {
                BE, FR, BB, BM, BO, JM, WS, BR, FI, FJ, 
                NI, NL, NO, VU, NZ, LU, AI, NR, GT, CO, 
                GR, CL, CA, GY, CZ, CY, GD, GB, CR, HU, 
                SR, SV, SK, SI, KY, SG, SE, DO, DM, DK, 
                HR, DE, HT, KN, HK, CH, HN, LC, PT, TT, 
                PY, LI, LV, TO, LT, PA, PG, TH, PE, PH, 
                TC, PL, VC, VE, AG, VG, EE, IS, IT, EC, 
                ZA, AR, AU, AT, AW, IN, IE, ID, ES, UY, 
                MC, US, MY, MX, IL
            });
        }

        private SearchSuggestions_countryCode(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class UserFollowers_sort extends Enum
    {

        private static final UserFollowers_sort $VALUES[];
        public static final UserFollowers_sort DateAdded;
        public static final UserFollowers_sort Name;

        public static UserFollowers_sort valueOf(String s)
        {
            return (UserFollowers_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$UserFollowers_sort, s);
        }

        public static UserFollowers_sort[] values()
        {
            return (UserFollowers_sort[])$VALUES.clone();
        }

        static 
        {
            DateAdded = new UserFollowers_sort("DateAdded", 0);
            Name = new UserFollowers_sort("Name", 1);
            $VALUES = (new UserFollowers_sort[] {
                DateAdded, Name
            });
        }

        private UserFollowers_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class UserFollowing_activityFilter extends Enum
    {

        private static final UserFollowing_activityFilter $VALUES[];
        public static final UserFollowing_activityFilter Active;
        public static final UserFollowing_activityFilter All;
        public static final UserFollowing_activityFilter Inactive;

        public static UserFollowing_activityFilter valueOf(String s)
        {
            return (UserFollowing_activityFilter)Enum.valueOf(com/rdio/android/core/RdioService_Api$UserFollowing_activityFilter, s);
        }

        public static UserFollowing_activityFilter[] values()
        {
            return (UserFollowing_activityFilter[])$VALUES.clone();
        }

        static 
        {
            Active = new UserFollowing_activityFilter("Active", 0);
            All = new UserFollowing_activityFilter("All", 1);
            Inactive = new UserFollowing_activityFilter("Inactive", 2);
            $VALUES = (new UserFollowing_activityFilter[] {
                Active, All, Inactive
            });
        }

        private UserFollowing_activityFilter(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class UserFollowing_sort extends Enum
    {

        private static final UserFollowing_sort $VALUES[];
        public static final UserFollowing_sort DateAdded;
        public static final UserFollowing_sort Name;
        public static final UserFollowing_sort Recent;

        public static UserFollowing_sort valueOf(String s)
        {
            return (UserFollowing_sort)Enum.valueOf(com/rdio/android/core/RdioService_Api$UserFollowing_sort, s);
        }

        public static UserFollowing_sort[] values()
        {
            return (UserFollowing_sort[])$VALUES.clone();
        }

        static 
        {
            DateAdded = new UserFollowing_sort("DateAdded", 0);
            Name = new UserFollowing_sort("Name", 1);
            Recent = new UserFollowing_sort("Recent", 2);
            $VALUES = (new UserFollowing_sort[] {
                DateAdded, Name, Recent
            });
        }

        private UserFollowing_sort(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class VoteForItemOnStation_vote extends Enum
    {

        private static final VoteForItemOnStation_vote $VALUES[];
        public static final VoteForItemOnStation_vote Ban;
        public static final VoteForItemOnStation_vote Unban;

        public static VoteForItemOnStation_vote valueOf(String s)
        {
            return (VoteForItemOnStation_vote)Enum.valueOf(com/rdio/android/core/RdioService_Api$VoteForItemOnStation_vote, s);
        }

        public static VoteForItemOnStation_vote[] values()
        {
            return (VoteForItemOnStation_vote[])$VALUES.clone();
        }

        static 
        {
            Ban = new VoteForItemOnStation_vote("Ban", 0);
            Unban = new VoteForItemOnStation_vote("Unban", 1);
            $VALUES = (new VoteForItemOnStation_vote[] {
                Ban, Unban
            });
        }

        private VoteForItemOnStation_vote(String s, int i)
        {
            super(s, i);
        }
    }


    private boolean useSynchronousRequests;

    public RdioService_Api()
    {
    }

    public void addFriend(String s, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "addFriend"), createArg("user", s)
        }, responselistener, flag, obj);
    }

    public void addToCollection(List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "addToCollection"), createArg("keys", list)
        }, responselistener, flag, obj);
    }

    public void addToFavorites(List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "addToFavorites"), createArg("keys", list)
        }, responselistener, flag, obj);
    }

    public void addToLimitedDownloads(List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "addToLimitedDownloads"), createArg("keys", list)
        }, responselistener, flag, obj);
    }

    public void addToPlaylist(String s, List list, AddToPlaylist_duplicateHandling addtoplaylist_duplicatehandling, List list1, boolean flag, Object obj, ResponseListener responselistener)
    {
        String s1;
        Object obj1;
        obj1 = null;
        s1 = obj1;
        if (addtoplaylist_duplicatehandling == null) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$AddToPlaylist_duplicateHandling[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForArtistInCollection_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForArtist_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForLabel_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsInCollection_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsFromFavoriteTracks_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsFromSyncedTracks_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsInCollection_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavoritesByArtist_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_types[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetHeavyRotation_type[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleasesStationAndAlbums_time[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleases_time[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetSyncedByArtist_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetSynced_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetSynced_type[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksForArtist_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksInCollection_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetUserPlaylists_kind[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$GetUserPlaylists_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowers_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowing_activityFilter[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowing_sort[];
            static final int $SwitchMap$com$rdio$android$core$RdioService_Api$VoteForItemOnStation_vote[];

            static 
            {
                $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowing_sort = new int[UserFollowing_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowing_sort[UserFollowing_sort.DateAdded.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror160) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowing_sort[UserFollowing_sort.Name.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror159) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowing_sort[UserFollowing_sort.Recent.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror158) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowing_activityFilter = new int[UserFollowing_activityFilter.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowing_activityFilter[UserFollowing_activityFilter.Active.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror157) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowing_activityFilter[UserFollowing_activityFilter.All.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror156) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowing_activityFilter[UserFollowing_activityFilter.Inactive.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror155) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowers_sort = new int[UserFollowers_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowers_sort[UserFollowers_sort.DateAdded.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror154) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$UserFollowers_sort[UserFollowers_sort.Name.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror153) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleasesStationAndAlbums_time = new int[GetNewReleasesStationAndAlbums_time.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleasesStationAndAlbums_time[GetNewReleasesStationAndAlbums_time.Thisweek.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror152) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleasesStationAndAlbums_time[GetNewReleasesStationAndAlbums_time.Overview.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror151) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleasesStationAndAlbums_time[GetNewReleasesStationAndAlbums_time.Lastweek.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror150) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleasesStationAndAlbums_time[GetNewReleasesStationAndAlbums_time.Twoweeks.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror149) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleases_time = new int[GetNewReleases_time.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleases_time[GetNewReleases_time.Thisweek.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror148) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleases_time[GetNewReleases_time.Overview.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror147) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleases_time[GetNewReleases_time.Lastweek.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror146) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetNewReleases_time[GetNewReleases_time.Twoweeks.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror145) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetHeavyRotation_type = new int[GetHeavyRotation_type.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetHeavyRotation_type[GetHeavyRotation_type.Albums.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror144) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetHeavyRotation_type[GetHeavyRotation_type.Stations.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror143) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetHeavyRotation_type[GetHeavyRotation_type.Playlists.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror142) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetHeavyRotation_type[GetHeavyRotation_type.Tracks.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror141) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetHeavyRotation_type[GetHeavyRotation_type.Artists.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror140) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetSyncedByArtist_sort = new int[GetSyncedByArtist_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetSyncedByArtist_sort[GetSyncedByArtist_sort.DateAdded.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror139) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetSyncedByArtist_sort[GetSyncedByArtist_sort.Name.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror138) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetSynced_sort = new int[GetSynced_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetSynced_sort[GetSynced_sort.PlayCount.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror137) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetSynced_sort[GetSynced_sort.DateAdded.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror136) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetSynced_sort[GetSynced_sort.Name.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror135) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetSynced_type = new int[GetSynced_type.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetSynced_type[GetSynced_type.TracksAndAlbums.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror134) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetSynced_type[GetSynced_type.Playlists.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror133) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavoritesByArtist_sort = new int[GetFavoritesByArtist_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavoritesByArtist_sort[GetFavoritesByArtist_sort.PlayCount.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror132) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavoritesByArtist_sort[GetFavoritesByArtist_sort.DateAdded.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror131) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavoritesByArtist_sort[GetFavoritesByArtist_sort.Name.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror130) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_sort = new int[GetFavorites_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_sort[GetFavorites_sort.PlayCount.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror129) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_sort[GetFavorites_sort.DateAdded.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror128) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_sort[GetFavorites_sort.Name.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror127) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_types = new int[GetFavorites_types.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_types[GetFavorites_types.Artists.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror126) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_types[GetFavorites_types.Labels.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror125) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_types[GetFavorites_types.Playlists.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror124) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_types[GetFavorites_types.Stations.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror123) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetFavorites_types[GetFavorites_types.TracksAndAlbums.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror122) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsFromSyncedTracks_sort = new int[GetArtistsFromSyncedTracks_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsFromSyncedTracks_sort[GetArtistsFromSyncedTracks_sort.DateAdded.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror121) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsFromSyncedTracks_sort[GetArtistsFromSyncedTracks_sort.Name.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror120) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsFromFavoriteTracks_sort = new int[GetArtistsFromFavoriteTracks_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsFromFavoriteTracks_sort[GetArtistsFromFavoriteTracks_sort.DateAdded.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror119) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsFromFavoriteTracks_sort[GetArtistsFromFavoriteTracks_sort.Name.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror118) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode = new int[SearchSuggestions_countryCode.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.BE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror117) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.FR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror116) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.BB.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror115) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.BM.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror114) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.BO.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror113) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.JM.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror112) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.WS.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror111) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.BR.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror110) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.FI.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror109) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.FJ.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror108) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.NI.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror107) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.NL.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror106) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.NO.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror105) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.VU.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror104) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.NZ.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror103) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.LU.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror102) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.AI.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror101) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.NR.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror100) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.GT.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror99) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.CO.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror98) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.GR.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror97) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.CL.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror96) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.CA.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror95) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.GY.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror94) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.CZ.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror93) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.CY.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror92) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.GD.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror91) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.GB.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror90) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.CR.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror89) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.HU.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror88) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.SR.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror87) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.SV.ordinal()] = 32;
                }
                catch (NoSuchFieldError nosuchfielderror86) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.SK.ordinal()] = 33;
                }
                catch (NoSuchFieldError nosuchfielderror85) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.SI.ordinal()] = 34;
                }
                catch (NoSuchFieldError nosuchfielderror84) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.KY.ordinal()] = 35;
                }
                catch (NoSuchFieldError nosuchfielderror83) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.SG.ordinal()] = 36;
                }
                catch (NoSuchFieldError nosuchfielderror82) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.SE.ordinal()] = 37;
                }
                catch (NoSuchFieldError nosuchfielderror81) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.DO.ordinal()] = 38;
                }
                catch (NoSuchFieldError nosuchfielderror80) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.DM.ordinal()] = 39;
                }
                catch (NoSuchFieldError nosuchfielderror79) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.DK.ordinal()] = 40;
                }
                catch (NoSuchFieldError nosuchfielderror78) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.HR.ordinal()] = 41;
                }
                catch (NoSuchFieldError nosuchfielderror77) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.DE.ordinal()] = 42;
                }
                catch (NoSuchFieldError nosuchfielderror76) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.HT.ordinal()] = 43;
                }
                catch (NoSuchFieldError nosuchfielderror75) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.KN.ordinal()] = 44;
                }
                catch (NoSuchFieldError nosuchfielderror74) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.HK.ordinal()] = 45;
                }
                catch (NoSuchFieldError nosuchfielderror73) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.CH.ordinal()] = 46;
                }
                catch (NoSuchFieldError nosuchfielderror72) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.HN.ordinal()] = 47;
                }
                catch (NoSuchFieldError nosuchfielderror71) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.LC.ordinal()] = 48;
                }
                catch (NoSuchFieldError nosuchfielderror70) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.PT.ordinal()] = 49;
                }
                catch (NoSuchFieldError nosuchfielderror69) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.TT.ordinal()] = 50;
                }
                catch (NoSuchFieldError nosuchfielderror68) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.PY.ordinal()] = 51;
                }
                catch (NoSuchFieldError nosuchfielderror67) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.LI.ordinal()] = 52;
                }
                catch (NoSuchFieldError nosuchfielderror66) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.LV.ordinal()] = 53;
                }
                catch (NoSuchFieldError nosuchfielderror65) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.TO.ordinal()] = 54;
                }
                catch (NoSuchFieldError nosuchfielderror64) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.LT.ordinal()] = 55;
                }
                catch (NoSuchFieldError nosuchfielderror63) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.PA.ordinal()] = 56;
                }
                catch (NoSuchFieldError nosuchfielderror62) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.PG.ordinal()] = 57;
                }
                catch (NoSuchFieldError nosuchfielderror61) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.TH.ordinal()] = 58;
                }
                catch (NoSuchFieldError nosuchfielderror60) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.PE.ordinal()] = 59;
                }
                catch (NoSuchFieldError nosuchfielderror59) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.PH.ordinal()] = 60;
                }
                catch (NoSuchFieldError nosuchfielderror58) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.TC.ordinal()] = 61;
                }
                catch (NoSuchFieldError nosuchfielderror57) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.PL.ordinal()] = 62;
                }
                catch (NoSuchFieldError nosuchfielderror56) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.VC.ordinal()] = 63;
                }
                catch (NoSuchFieldError nosuchfielderror55) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.VE.ordinal()] = 64;
                }
                catch (NoSuchFieldError nosuchfielderror54) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.AG.ordinal()] = 65;
                }
                catch (NoSuchFieldError nosuchfielderror53) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.VG.ordinal()] = 66;
                }
                catch (NoSuchFieldError nosuchfielderror52) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.EE.ordinal()] = 67;
                }
                catch (NoSuchFieldError nosuchfielderror51) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.IS.ordinal()] = 68;
                }
                catch (NoSuchFieldError nosuchfielderror50) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.IT.ordinal()] = 69;
                }
                catch (NoSuchFieldError nosuchfielderror49) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.EC.ordinal()] = 70;
                }
                catch (NoSuchFieldError nosuchfielderror48) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.ZA.ordinal()] = 71;
                }
                catch (NoSuchFieldError nosuchfielderror47) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.AR.ordinal()] = 72;
                }
                catch (NoSuchFieldError nosuchfielderror46) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.AU.ordinal()] = 73;
                }
                catch (NoSuchFieldError nosuchfielderror45) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.AT.ordinal()] = 74;
                }
                catch (NoSuchFieldError nosuchfielderror44) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.AW.ordinal()] = 75;
                }
                catch (NoSuchFieldError nosuchfielderror43) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.IN.ordinal()] = 76;
                }
                catch (NoSuchFieldError nosuchfielderror42) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.IE.ordinal()] = 77;
                }
                catch (NoSuchFieldError nosuchfielderror41) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.ID.ordinal()] = 78;
                }
                catch (NoSuchFieldError nosuchfielderror40) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.ES.ordinal()] = 79;
                }
                catch (NoSuchFieldError nosuchfielderror39) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.UY.ordinal()] = 80;
                }
                catch (NoSuchFieldError nosuchfielderror38) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.MC.ordinal()] = 81;
                }
                catch (NoSuchFieldError nosuchfielderror37) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.US.ordinal()] = 82;
                }
                catch (NoSuchFieldError nosuchfielderror36) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.MY.ordinal()] = 83;
                }
                catch (NoSuchFieldError nosuchfielderror35) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.MX.ordinal()] = 84;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$SearchSuggestions_countryCode[SearchSuggestions_countryCode.IL.ordinal()] = 85;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksForArtist_sort = new int[GetTracksForArtist_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksForArtist_sort[GetTracksForArtist_sort.ReleaseDate.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksForArtist_sort[GetTracksForArtist_sort.PlayCount.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksForArtist_sort[GetTracksForArtist_sort.Name.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForLabel_sort = new int[GetAlbumsForLabel_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForLabel_sort[GetAlbumsForLabel_sort.ReleaseDate.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForLabel_sort[GetAlbumsForLabel_sort.PlayCount.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForLabel_sort[GetAlbumsForLabel_sort.Name.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForArtist_sort = new int[GetAlbumsForArtist_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForArtist_sort[GetAlbumsForArtist_sort.ReleaseDate.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForArtist_sort[GetAlbumsForArtist_sort.PlayCount.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForArtist_sort[GetAlbumsForArtist_sort.Name.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksInCollection_sort = new int[GetTracksInCollection_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksInCollection_sort[GetTracksInCollection_sort.Album.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksInCollection_sort[GetTracksInCollection_sort.PlayCount.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksInCollection_sort[GetTracksInCollection_sort.DateAdded.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksInCollection_sort[GetTracksInCollection_sort.Name.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetTracksInCollection_sort[GetTracksInCollection_sort.Artist.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsInCollection_sort = new int[GetArtistsInCollection_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsInCollection_sort[GetArtistsInCollection_sort.PlayCount.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetArtistsInCollection_sort[GetArtistsInCollection_sort.Name.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsInCollection_sort = new int[GetAlbumsInCollection_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsInCollection_sort[GetAlbumsInCollection_sort.PlayCount.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsInCollection_sort[GetAlbumsInCollection_sort.DateAdded.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsInCollection_sort[GetAlbumsInCollection_sort.Name.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsInCollection_sort[GetAlbumsInCollection_sort.Artist.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForArtistInCollection_sort = new int[GetAlbumsForArtistInCollection_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForArtistInCollection_sort[GetAlbumsForArtistInCollection_sort.ReleaseDate.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetAlbumsForArtistInCollection_sort[GetAlbumsForArtistInCollection_sort.Name.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$VoteForItemOnStation_vote = new int[VoteForItemOnStation_vote.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$VoteForItemOnStation_vote[VoteForItemOnStation_vote.Ban.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$VoteForItemOnStation_vote[VoteForItemOnStation_vote.Unban.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetUserPlaylists_sort = new int[GetUserPlaylists_sort.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetUserPlaylists_sort[GetUserPlaylists_sort.Name.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetUserPlaylists_sort[GetUserPlaylists_sort.LastUpdated.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$GetUserPlaylists_kind = new int[GetUserPlaylists_kind.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetUserPlaylists_kind[GetUserPlaylists_kind.Favorites.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetUserPlaylists_kind[GetUserPlaylists_kind.Subscribed.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetUserPlaylists_kind[GetUserPlaylists_kind.Collab.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$GetUserPlaylists_kind[GetUserPlaylists_kind.Owned.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$rdio$android$core$RdioService_Api$AddToPlaylist_duplicateHandling = new int[AddToPlaylist_duplicateHandling.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$AddToPlaylist_duplicateHandling[AddToPlaylist_duplicateHandling.Ignore.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$AddToPlaylist_duplicateHandling[AddToPlaylist_duplicateHandling.Allow.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$RdioService_Api$AddToPlaylist_duplicateHandling[AddToPlaylist_duplicateHandling.Error.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.AddToPlaylist_duplicateHandling[addtoplaylist_duplicatehandling.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 119
    //                   2 126
    //                   3 133;
           goto _L3 _L4 _L5 _L6
_L3:
        s1 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "addToPlaylist"), createArg("playlist", s), createArg("tracks", list), createArg("duplicateHandling", s1), createArg("extras", list1)
        }, responselistener, flag, obj);
        return;
_L4:
        s1 = "ignore";
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = "allow";
        continue; /* Loop/switch isn't completed */
_L6:
        s1 = "error";
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void addToPlaylist(String s, List list, ResponseListener responselistener)
    {
        addToPlaylist(s, list, null, null, false, null, responselistener);
    }

    public void addToSynced(List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "addToSynced"), createArg("keys", list)
        }, responselistener, flag, obj);
    }

    protected void asyncPostRequest(RdioApiRequestArg ardioapirequestarg[], ResponseListener responselistener)
    {
        asyncPostRequest(ardioapirequestarg, responselistener, false, null);
    }

    protected abstract void asyncPostRequest(RdioApiRequestArg ardioapirequestarg[], ResponseListener responselistener, boolean flag, Object obj);

    public void banArtist(List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "banArtist"), createArg("artist_key", list)
        }, responselistener, flag, obj);
    }

    public RdioApiRequestArg createArg(String s, Object obj)
    {
        return new RdioApiRequestArg(s, obj);
    }

    protected RdioApiRequestArg createArg(String s, Object aobj[])
    {
        return new RdioApiRequestArg(s, aobj);
    }

    public void createPlaylist(String s, String s1, List list, int i, boolean flag, List list1, boolean flag1, 
            Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "createPlaylist"), createArg("name", s), createArg("description", s1), createArg("tracks", list), createArg("collaborationMode", Integer.valueOf(i)), createArg("isPublished", Boolean.valueOf(flag)), createArg("extras", list1)
        }, responselistener, flag1, obj);
    }

    public void createPlaylist(String s, String s1, List list, ResponseListener responselistener)
    {
        createPlaylist(s, s1, list, 0, false, null, false, null, responselistener);
    }

    public void currentUser(ResponseListener responselistener)
    {
        currentUser(null, false, null, responselistener);
    }

    public void currentUser(List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "currentUser"), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void deletePlaylist(String s, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "deletePlaylist"), createArg("playlist", s)
        }, responselistener, flag, obj);
    }

    public void findUser(ResponseListener responselistener)
    {
        findUser(null, null, null, false, null, responselistener);
    }

    public void findUser(String s, String s1, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "findUser"), createArg("email", s), createArg("vanityName", s1), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void get(List list, ResponseListener responselistener)
    {
        get(list, null, null, false, null, responselistener);
    }

    public void get(List list, String s, List list1, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "get"), createArg("keys", list), createArg("options", s), createArg("extras", list1)
        }, responselistener, flag, obj);
    }

    public void getActivityStream(String s, String s1, ResponseListener responselistener)
    {
        getActivityStream(s, s1, null, 0, null, null, false, null, responselistener);
    }

    public void getActivityStream(String s, String s1, String s2, int i, List list, List list1, boolean flag, 
            Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getActivityStream"), createArg("user", s), createArg("scope", s1), createArg("last_id", s2), createArg("count", Integer.valueOf(i)), createArg("types", list), createArg("extras", list1)
        }, responselistener, flag, obj);
    }

    public void getAlbumsByUPC(String s, ResponseListener responselistener)
    {
        getAlbumsByUPC(s, null, false, null, responselistener);
    }

    public void getAlbumsByUPC(String s, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getAlbumsByUPC"), createArg("upc", s), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getAlbumsForArtist(String s, ResponseListener responselistener)
    {
        getAlbumsForArtist(s, false, 0, 0, null, null, null, false, null, responselistener);
    }

    public void getAlbumsForArtist(String s, boolean flag, int i, int j, GetAlbumsForArtist_sort getalbumsforartist_sort, String s1, List list, 
            boolean flag1, Object obj, ResponseListener responselistener)
    {
        String s2;
        Object obj1;
        obj1 = null;
        s2 = obj1;
        if (getalbumsforartist_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetAlbumsForArtist_sort[getalbumsforartist_sort.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 173
    //                   2 181
    //                   3 189;
           goto _L3 _L4 _L5 _L6
_L3:
        s2 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getAlbumsForArtist"), createArg("artist", s), createArg("featuring", Boolean.valueOf(flag)), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("sort", s2), createArg("query", s1), createArg("extras", list)
        }, responselistener, flag1, obj);
        return;
_L4:
        s2 = "releaseDate";
        continue; /* Loop/switch isn't completed */
_L5:
        s2 = "playCount";
        continue; /* Loop/switch isn't completed */
_L6:
        s2 = "name";
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void getAlbumsForArtistInCollection(String s, ResponseListener responselistener)
    {
        getAlbumsForArtistInCollection(s, null, null, null, false, null, responselistener);
    }

    public void getAlbumsForArtistInCollection(String s, String s1, GetAlbumsForArtistInCollection_sort getalbumsforartistincollection_sort, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        String s2;
        Object obj1;
        obj1 = null;
        s2 = obj1;
        if (getalbumsforartistincollection_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetAlbumsForArtistInCollection_sort[getalbumsforartistincollection_sort.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 118
    //                   2 126;
           goto _L3 _L4 _L5
_L3:
        s2 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getAlbumsForArtistInCollection"), createArg("artist", s), createArg("user", s1), createArg("sort", s2), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s2 = "releaseDate";
        continue; /* Loop/switch isn't completed */
_L5:
        s2 = "name";
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void getAlbumsForLabel(String s, int i, int j, GetAlbumsForLabel_sort getalbumsforlabel_sort, String s1, List list, boolean flag, 
            Object obj, ResponseListener responselistener)
    {
        String s2;
        Object obj1;
        obj1 = null;
        s2 = obj1;
        if (getalbumsforlabel_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetAlbumsForLabel_sort[getalbumsforlabel_sort.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 157
    //                   2 165
    //                   3 173;
           goto _L3 _L4 _L5 _L6
_L3:
        s2 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getAlbumsForLabel"), createArg("label", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("sort", s2), createArg("query", s1), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s2 = "releaseDate";
        continue; /* Loop/switch isn't completed */
_L5:
        s2 = "playCount";
        continue; /* Loop/switch isn't completed */
_L6:
        s2 = "name";
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void getAlbumsForLabel(String s, ResponseListener responselistener)
    {
        getAlbumsForLabel(s, 0, 0, null, null, null, false, null, responselistener);
    }

    public void getAlbumsInCollection(ResponseListener responselistener)
    {
        getAlbumsInCollection(null, 0, 0, null, null, null, null, false, null, responselistener);
    }

    public void getAlbumsInCollection(String s, int i, int j, GetAlbumsInCollection_sort getalbumsincollection_sort, String s1, String s2, List list, 
            boolean flag, Object obj, ResponseListener responselistener)
    {
        String s3;
        Object obj1;
        obj1 = null;
        s3 = obj1;
        if (getalbumsincollection_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetAlbumsInCollection_sort[getalbumsincollection_sort.ordinal()];
        JVM INSTR tableswitch 1 4: default 52
    //                   1 173
    //                   2 181
    //                   3 189
    //                   4 196;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        s3 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getAlbumsInCollection"), createArg("user", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("sort", s3), createArg("query", s1), createArg("artist", s2), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s3 = "playCount";
        continue; /* Loop/switch isn't completed */
_L5:
        s3 = "dateAdded";
        continue; /* Loop/switch isn't completed */
_L6:
        s3 = "name";
        continue; /* Loop/switch isn't completed */
_L7:
        s3 = "artist";
        if (true) goto _L2; else goto _L8
_L8:
    }

    public void getArtistsForLabel(String s, int i, int j, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getArtistsForLabel"), createArg("label", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getArtistsForLabel(String s, ResponseListener responselistener)
    {
        getArtistsForLabel(s, 0, 0, null, false, null, responselistener);
    }

    public void getArtistsFromFavoriteTracks(ResponseListener responselistener)
    {
        getArtistsFromFavoriteTracks(null, null, null, 0, 0, null, false, null, responselistener);
    }

    public void getArtistsFromFavoriteTracks(String s, String s1, GetArtistsFromFavoriteTracks_sort getartistsfromfavoritetracks_sort, int i, int j, List list, boolean flag, 
            Object obj, ResponseListener responselistener)
    {
        String s2;
        Object obj1;
        obj1 = null;
        s2 = obj1;
        if (getartistsfromfavoritetracks_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetArtistsFromFavoriteTracks_sort[getartistsfromfavoritetracks_sort.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 149
    //                   2 157;
           goto _L3 _L4 _L5
_L3:
        s2 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getArtistsFromFavoriteTracks"), createArg("user", s), createArg("query", s1), createArg("sort", s2), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s2 = "dateAdded";
        continue; /* Loop/switch isn't completed */
_L5:
        s2 = "name";
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void getArtistsFromSyncedTracks(ResponseListener responselistener)
    {
        getArtistsFromSyncedTracks(null, null, null, 0, 0, null, false, null, responselistener);
    }

    public void getArtistsFromSyncedTracks(String s, String s1, GetArtistsFromSyncedTracks_sort getartistsfromsyncedtracks_sort, int i, int j, List list, boolean flag, 
            Object obj, ResponseListener responselistener)
    {
        String s2;
        Object obj1;
        obj1 = null;
        s2 = obj1;
        if (getartistsfromsyncedtracks_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetArtistsFromSyncedTracks_sort[getartistsfromsyncedtracks_sort.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 149
    //                   2 157;
           goto _L3 _L4 _L5
_L3:
        s2 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getArtistsFromSyncedTracks"), createArg("user", s), createArg("query", s1), createArg("sort", s2), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s2 = "dateAdded";
        continue; /* Loop/switch isn't completed */
_L5:
        s2 = "name";
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void getArtistsInCollection(ResponseListener responselistener)
    {
        getArtistsInCollection(null, 0, 0, null, null, null, false, null, responselistener);
    }

    public void getArtistsInCollection(String s, int i, int j, GetArtistsInCollection_sort getartistsincollection_sort, String s1, List list, boolean flag, 
            Object obj, ResponseListener responselistener)
    {
        String s2;
        Object obj1;
        obj1 = null;
        s2 = obj1;
        if (getartistsincollection_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetArtistsInCollection_sort[getartistsincollection_sort.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 152
    //                   2 160;
           goto _L3 _L4 _L5
_L3:
        s2 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getArtistsInCollection"), createArg("user", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("sort", s2), createArg("query", s1), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s2 = "playCount";
        continue; /* Loop/switch isn't completed */
_L5:
        s2 = "name";
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void getCollectionAlbumKeys(List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getCollectionAlbumKeys"), createArg("keys", list)
        }, responselistener, flag, obj);
    }

    public void getFavorites(ResponseListener responselistener)
    {
        getFavorites(null, null, null, 0, 0, null, false, null, responselistener);
    }

    public void getFavorites(String s, List list, GetFavorites_sort getfavorites_sort, int i, int j, List list1, boolean flag, 
            Object obj, ResponseListener responselistener)
    {
        String s1;
        String s2;
        int k;
        s2 = "";
        s1 = s2;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        s1 = s2;
        if (list.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        s2 = "";
        s1 = "";
        k = 0;
_L7:
        if (k >= list.size())
        {
            break MISSING_BLOCK_LABEL_219;
        }
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetFavorites_types[((GetFavorites_types)list.get(k)).ordinal()];
        JVM INSTR tableswitch 1 5: default 104
    //                   1 154
    //                   2 162
    //                   3 170
    //                   4 178
    //                   5 186;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        if (k < list.size() - 1)
        {
            s2 = (new StringBuilder()).append(s2).append(s1).append(",").toString();
        } else
        {
            s2 = (new StringBuilder()).append(s2).append(s1).toString();
        }
        k++;
        if (true) goto _L7; else goto _L2
_L2:
        s1 = "artists";
          goto _L1
_L3:
        s1 = "labels";
          goto _L1
_L4:
        s1 = "playlists";
          goto _L1
_L5:
        s1 = "stations";
          goto _L1
_L6:
        s1 = "tracksAndAlbums";
          goto _L1
        s1 = s2;
        s2 = null;
        list = s2;
        if (getfavorites_sort == null) goto _L9; else goto _L8
_L8:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetFavorites_sort[getfavorites_sort.ordinal()];
        JVM INSTR tableswitch 1 3: default 268
    //                   1 375
    //                   2 382
    //                   3 389;
           goto _L10 _L11 _L12 _L13
_L10:
        list = s2;
_L9:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getFavorites"), createArg("user", s), createArg("types", s1), createArg("sort", list), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list1)
        }, responselistener, flag, obj);
        return;
_L11:
        list = "playCount";
        continue; /* Loop/switch isn't completed */
_L12:
        list = "dateAdded";
        continue; /* Loop/switch isn't completed */
_L13:
        list = "name";
        if (true) goto _L9; else goto _L14
_L14:
    }

    public void getFavoritesByArtist(String s, ResponseListener responselistener)
    {
        getFavoritesByArtist(s, null, null, 0, 0, null, false, null, responselistener);
    }

    public void getFavoritesByArtist(String s, String s1, GetFavoritesByArtist_sort getfavoritesbyartist_sort, int i, int j, List list, boolean flag, 
            Object obj, ResponseListener responselistener)
    {
        String s2;
        Object obj1;
        obj1 = null;
        s2 = obj1;
        if (getfavoritesbyartist_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetFavoritesByArtist_sort[getfavoritesbyartist_sort.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 153
    //                   2 161
    //                   3 169;
           goto _L3 _L4 _L5 _L6
_L3:
        s2 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getFavoritesByArtist"), createArg("artist", s), createArg("user", s1), createArg("sort", s2), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s2 = "playCount";
        continue; /* Loop/switch isn't completed */
_L5:
        s2 = "dateAdded";
        continue; /* Loop/switch isn't completed */
_L6:
        s2 = "name";
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void getHeavyRotation(ResponseListener responselistener)
    {
        getHeavyRotation(null, null, false, 0, 0, 0, null, false, null, responselistener);
    }

    public void getHeavyRotation(String s, GetHeavyRotation_type getheavyrotation_type, boolean flag, int i, int j, int k, List list, 
            boolean flag1, Object obj, ResponseListener responselistener)
    {
        String s1;
        Object obj1;
        obj1 = null;
        s1 = obj1;
        if (getheavyrotation_type == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetHeavyRotation_type[getheavyrotation_type.ordinal()];
        JVM INSTR tableswitch 1 5: default 52
    //                   1 180
    //                   2 188
    //                   3 196
    //                   4 204
    //                   5 211;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        s1 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getHeavyRotation"), createArg("user", s), createArg("type", s1), createArg("friends", Boolean.valueOf(flag)), createArg("limit", Integer.valueOf(i)), createArg("start", Integer.valueOf(j)), createArg("count", Integer.valueOf(k)), createArg("extras", list)
        }, responselistener, flag1, obj);
        return;
_L4:
        s1 = "albums";
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = "stations";
        continue; /* Loop/switch isn't completed */
_L6:
        s1 = "playlists";
        continue; /* Loop/switch isn't completed */
_L7:
        s1 = "tracks";
        continue; /* Loop/switch isn't completed */
_L8:
        s1 = "artists";
        if (true) goto _L2; else goto _L9
_L9:
    }

    public void getKeepListening(int i, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getKeepListening"), createArg("count", Integer.valueOf(i)), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getKeepListening(ResponseListener responselistener)
    {
        getKeepListening(0, null, false, null, responselistener);
    }

    public void getKeysInLimitedDownloads(ResponseListener responselistener)
    {
        getKeysInLimitedDownloads(null, 0, false, null, responselistener);
    }

    public void getKeysInLimitedDownloads(String s, int i, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getKeysInLimitedDownloads"), createArg("user", s), createArg("version", Integer.valueOf(i))
        }, responselistener, flag, obj);
    }

    public void getLimitedDownloads(ResponseListener responselistener)
    {
        getLimitedDownloads(null, null, false, null, responselistener);
    }

    public void getLimitedDownloads(String s, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getLimitedDownloads"), createArg("user", s), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getNewReleases(GetNewReleases_time getnewreleases_time, int i, int j, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        String s;
        Object obj1;
        obj1 = null;
        s = obj1;
        if (getnewreleases_time == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetNewReleases_time[getnewreleases_time.ordinal()];
        JVM INSTR tableswitch 1 4: default 48
    //                   1 132
    //                   2 140
    //                   3 148
    //                   4 156;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        s = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getNewReleases"), createArg("time", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s = "thisweek";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "overview";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "lastweek";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "twoweeks";
        if (true) goto _L2; else goto _L8
_L8:
    }

    public void getNewReleases(ResponseListener responselistener)
    {
        getNewReleases(null, 0, 0, null, false, null, responselistener);
    }

    public void getNewReleasesStationAndAlbums(GetNewReleasesStationAndAlbums_time getnewreleasesstationandalbums_time, int i, int j, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        String s;
        Object obj1;
        obj1 = null;
        s = obj1;
        if (getnewreleasesstationandalbums_time == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetNewReleasesStationAndAlbums_time[getnewreleasesstationandalbums_time.ordinal()];
        JVM INSTR tableswitch 1 4: default 48
    //                   1 132
    //                   2 140
    //                   3 148
    //                   4 156;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        s = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getNewReleasesStationAndAlbums"), createArg("time", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s = "thisweek";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "overview";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "lastweek";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "twoweeks";
        if (true) goto _L2; else goto _L8
_L8:
    }

    public void getNewReleasesStationAndAlbums(ResponseListener responselistener)
    {
        getNewReleasesStationAndAlbums(null, 0, 0, null, false, null, responselistener);
    }

    public void getObjectFromShortCode(String s, ResponseListener responselistener)
    {
        getObjectFromShortCode(s, null, false, null, responselistener);
    }

    public void getObjectFromShortCode(String s, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getObjectFromShortCode"), createArg("short_code", s), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getObjectFromUrl(String s, ResponseListener responselistener)
    {
        getObjectFromUrl(s, null, false, null, responselistener);
    }

    public void getObjectFromUrl(String s, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getObjectFromUrl"), createArg("url", s), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getOfflineTracks(int i, int j, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getOfflineTracks"), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getOfflineTracks(ResponseListener responselistener)
    {
        getOfflineTracks(0, 0, null, false, null, responselistener);
    }

    public void getPlaybackToken(ResponseListener responselistener)
    {
        getPlaybackToken(null, false, null, responselistener);
    }

    public void getPlaybackToken(String s, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getPlaybackToken"), createArg("domain", s)
        }, responselistener, flag, obj);
    }

    public void getPlaylistSubscribers(String s, int i, int j, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getPlaylistSubscribers"), createArg("playlist", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getPlaylistSubscribers(String s, ResponseListener responselistener)
    {
        getPlaylistSubscribers(s, 0, 0, null, false, null, responselistener);
    }

    public void getPlaylists(ResponseListener responselistener)
    {
        getPlaylists(null, false, null, false, null, responselistener);
    }

    public void getPlaylists(String s, boolean flag, List list, boolean flag1, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getPlaylists"), createArg("user", s), createArg("ordered_list", Boolean.valueOf(flag)), createArg("extras", list)
        }, responselistener, flag1, obj);
    }

    public void getRelatedStations(String s, int i, int j, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getRelatedStations"), createArg("station", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getRelatedStations(String s, ResponseListener responselistener)
    {
        getRelatedStations(s, 0, 0, null, false, null, responselistener);
    }

    public void getSynced(ResponseListener responselistener)
    {
        getSynced(null, null, null, 0, 0, null, false, null, responselistener);
    }

    public void getSynced(String s, GetSynced_type getsynced_type, GetSynced_sort getsynced_sort, int i, int j, List list, boolean flag, 
            Object obj, ResponseListener responselistener)
    {
        if (getsynced_type == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetSynced_type[getsynced_type.ordinal()];
        JVM INSTR tableswitch 1 2: default 36
    //                   1 192
    //                   2 200;
           goto _L2 _L3 _L4
_L2:
        String s1 = null;
_L11:
        Object obj1;
        obj1 = null;
        getsynced_type = obj1;
        if (getsynced_sort == null) goto _L6; else goto _L5
_L5:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetSynced_sort[getsynced_sort.ordinal()];
        JVM INSTR tableswitch 1 3: default 84
    //                   1 208
    //                   2 215
    //                   3 222;
           goto _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_222;
_L7:
        getsynced_type = obj1;
_L6:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getSynced"), createArg("user", s), createArg("type", s1), createArg("sort", getsynced_type), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L3:
        s1 = "tracksAndAlbums";
          goto _L11
_L4:
        s1 = "playlists";
          goto _L11
_L8:
        getsynced_type = "playCount";
          goto _L6
_L9:
        getsynced_type = "dateAdded";
          goto _L6
        getsynced_type = "name";
          goto _L6
    }

    public void getSyncedByArtist(String s, ResponseListener responselistener)
    {
        getSyncedByArtist(s, null, null, 0, 0, null, false, null, responselistener);
    }

    public void getSyncedByArtist(String s, String s1, GetSyncedByArtist_sort getsyncedbyartist_sort, int i, int j, List list, boolean flag, 
            Object obj, ResponseListener responselistener)
    {
        String s2;
        Object obj1;
        obj1 = null;
        s2 = obj1;
        if (getsyncedbyartist_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetSyncedByArtist_sort[getsyncedbyartist_sort.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 149
    //                   2 157;
           goto _L3 _L4 _L5
_L3:
        s2 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getSyncedByArtist"), createArg("artist", s), createArg("user", s1), createArg("sort", s2), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s2 = "dateAdded";
        continue; /* Loop/switch isn't completed */
_L5:
        s2 = "name";
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void getTopCharts(String s, int i, int j, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getTopCharts"), createArg("type", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getTopCharts(String s, ResponseListener responselistener)
    {
        getTopCharts(s, 0, 0, null, false, null, responselistener);
    }

    public void getTracksByISRC(String s, ResponseListener responselistener)
    {
        getTracksByISRC(s, null, false, null, responselistener);
    }

    public void getTracksByISRC(String s, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getTracksByISRC"), createArg("isrc", s), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getTracksForAlbumInCollection(String s, ResponseListener responselistener)
    {
        getTracksForAlbumInCollection(s, null, null, false, null, responselistener);
    }

    public void getTracksForAlbumInCollection(String s, String s1, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getTracksForAlbumInCollection"), createArg("album", s), createArg("user", s1), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getTracksForArtist(String s, ResponseListener responselistener)
    {
        getTracksForArtist(s, false, 0, 0, null, null, null, false, null, responselistener);
    }

    public void getTracksForArtist(String s, boolean flag, int i, int j, GetTracksForArtist_sort gettracksforartist_sort, String s1, List list, 
            boolean flag1, Object obj, ResponseListener responselistener)
    {
        String s2;
        Object obj1;
        obj1 = null;
        s2 = obj1;
        if (gettracksforartist_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetTracksForArtist_sort[gettracksforartist_sort.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 173
    //                   2 181
    //                   3 189;
           goto _L3 _L4 _L5 _L6
_L3:
        s2 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getTracksForArtist"), createArg("artist", s), createArg("appears_on", Boolean.valueOf(flag)), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("sort", s2), createArg("query", s1), createArg("extras", list)
        }, responselistener, flag1, obj);
        return;
_L4:
        s2 = "releaseDate";
        continue; /* Loop/switch isn't completed */
_L5:
        s2 = "playCount";
        continue; /* Loop/switch isn't completed */
_L6:
        s2 = "name";
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void getTracksForArtistInCollection(String s, ResponseListener responselistener)
    {
        getTracksForArtistInCollection(s, null, null, false, null, responselistener);
    }

    public void getTracksForArtistInCollection(String s, String s1, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getTracksForArtistInCollection"), createArg("artist", s), createArg("user", s1), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void getTracksInCollection(ResponseListener responselistener)
    {
        getTracksInCollection(null, 0, 0, null, null, null, null, false, null, responselistener);
    }

    public void getTracksInCollection(String s, int i, int j, GetTracksInCollection_sort gettracksincollection_sort, String s1, String s2, List list, 
            boolean flag, Object obj, ResponseListener responselistener)
    {
        String s3;
        Object obj1;
        obj1 = null;
        s3 = obj1;
        if (gettracksincollection_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetTracksInCollection_sort[gettracksincollection_sort.ordinal()];
        JVM INSTR tableswitch 1 5: default 56
    //                   1 177
    //                   2 185
    //                   3 193
    //                   4 201
    //                   5 208;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        s3 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getTracksInCollection"), createArg("user", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("sort", s3), createArg("query", s1), createArg("artist", s2), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s3 = "album";
        continue; /* Loop/switch isn't completed */
_L5:
        s3 = "playCount";
        continue; /* Loop/switch isn't completed */
_L6:
        s3 = "dateAdded";
        continue; /* Loop/switch isn't completed */
_L7:
        s3 = "name";
        continue; /* Loop/switch isn't completed */
_L8:
        s3 = "artist";
        if (true) goto _L2; else goto _L9
_L9:
    }

    public void getUserPlaylists(String s, GetUserPlaylists_kind getuserplaylists_kind, GetUserPlaylists_sort getuserplaylists_sort, int i, int j, List list, boolean flag, 
            Object obj, ResponseListener responselistener)
    {
        if (getuserplaylists_kind == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetUserPlaylists_kind[getuserplaylists_kind.ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 197
    //                   2 204
    //                   3 211
    //                   4 218;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        getuserplaylists_kind = null;
_L12:
        String s1;
        Object obj1;
        obj1 = null;
        s1 = obj1;
        if (getuserplaylists_sort == null) goto _L8; else goto _L7
_L7:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.GetUserPlaylists_sort[getuserplaylists_sort.ordinal()];
        JVM INSTR tableswitch 1 2: default 88
    //                   1 225
    //                   2 232;
           goto _L9 _L10 _L11
_L11:
        break MISSING_BLOCK_LABEL_232;
_L9:
        s1 = obj1;
_L8:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "getUserPlaylists"), createArg("user", s), createArg("kind", getuserplaylists_kind), createArg("sort", s1), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L3:
        getuserplaylists_kind = "favorites";
          goto _L12
_L4:
        getuserplaylists_kind = "subscribed";
          goto _L12
_L5:
        getuserplaylists_kind = "collab";
          goto _L12
_L6:
        getuserplaylists_kind = "owned";
          goto _L12
_L10:
        s1 = "name";
          goto _L8
        s1 = "lastUpdated";
          goto _L8
    }

    public void getUserPlaylists(String s, ResponseListener responselistener)
    {
        getUserPlaylists(s, null, null, 0, 0, null, false, null, responselistener);
    }

    public void postRequest(RdioApiRequestArg ardioapirequestarg[], ResponseListener responselistener)
    {
        postRequest(ardioapirequestarg, responselistener, false, null);
    }

    public void postRequest(RdioApiRequestArg ardioapirequestarg[], ResponseListener responselistener, boolean flag, Object obj)
    {
        if (useSynchronousRequests())
        {
            syncPostRequest(ardioapirequestarg, responselistener, flag, obj);
            return;
        } else
        {
            asyncPostRequest(ardioapirequestarg, responselistener, flag, obj);
            return;
        }
    }

    public void removeFriend(String s, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "removeFriend"), createArg("user", s)
        }, responselistener, flag, obj);
    }

    public void removeFromCollection(List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "removeFromCollection"), createArg("keys", list)
        }, responselistener, flag, obj);
    }

    public void removeFromFavorites(List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "removeFromFavorites"), createArg("keys", list)
        }, responselistener, flag, obj);
    }

    public void removeFromPlaylist(String s, int i, int j, List list, ResponseListener responselistener)
    {
        removeFromPlaylist(s, i, j, list, null, false, null, responselistener);
    }

    public void removeFromPlaylist(String s, int i, int j, List list, List list1, boolean flag, Object obj, 
            ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "removeFromPlaylist"), createArg("playlist", s), createArg("index", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("tracks", list), createArg("extras", list1)
        }, responselistener, flag, obj);
    }

    public void removeFromSynced(List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "removeFromSynced"), createArg("keys", list)
        }, responselistener, flag, obj);
    }

    public void removeRangesFromPlaylist(String s, String s1, ResponseListener responselistener)
    {
        removeRangesFromPlaylist(s, s1, null, false, null, responselistener);
    }

    public void removeRangesFromPlaylist(String s, String s1, List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "removeRangesFromPlaylist"), createArg("playlist", s), createArg("ranges", s1), createArg("extras", list)
        }, responselistener, flag, obj);
    }

    public void search(String s, List list, ResponseListener responselistener)
    {
        search(s, list, false, 0, 0, null, false, null, responselistener);
    }

    public void search(String s, List list, boolean flag, int i, int j, List list1, boolean flag1, 
            Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "search"), createArg("query", s), createArg("types", list), createArg("never_or", Boolean.valueOf(flag)), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("extras", list1)
        }, responselistener, flag1, obj);
    }

    public void searchSuggestions(String s, ResponseListener responselistener)
    {
        searchSuggestions(s, null, null, null, false, null, responselistener);
    }

    public void searchSuggestions(String s, List list, SearchSuggestions_countryCode searchsuggestions_countrycode, List list1, boolean flag, Object obj, ResponseListener responselistener)
    {
        String s1;
        Object obj1;
        obj1 = null;
        s1 = obj1;
        if (searchsuggestions_countrycode == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.SearchSuggestions_countryCode[searchsuggestions_countrycode.ordinal()];
        JVM INSTR tableswitch 1 85: default 372
    //                   1 450
    //                   2 458
    //                   3 466
    //                   4 474
    //                   5 482
    //                   6 490
    //                   7 498
    //                   8 506
    //                   9 514
    //                   10 522
    //                   11 530
    //                   12 538
    //                   13 546
    //                   14 554
    //                   15 562
    //                   16 570
    //                   17 578
    //                   18 586
    //                   19 594
    //                   20 602
    //                   21 610
    //                   22 618
    //                   23 626
    //                   24 634
    //                   25 642
    //                   26 650
    //                   27 658
    //                   28 666
    //                   29 674
    //                   30 682
    //                   31 690
    //                   32 698
    //                   33 706
    //                   34 714
    //                   35 722
    //                   36 730
    //                   37 738
    //                   38 746
    //                   39 754
    //                   40 762
    //                   41 770
    //                   42 778
    //                   43 786
    //                   44 794
    //                   45 802
    //                   46 810
    //                   47 818
    //                   48 826
    //                   49 834
    //                   50 842
    //                   51 850
    //                   52 858
    //                   53 866
    //                   54 874
    //                   55 882
    //                   56 890
    //                   57 898
    //                   58 906
    //                   59 914
    //                   60 922
    //                   61 930
    //                   62 938
    //                   63 946
    //                   64 954
    //                   65 962
    //                   66 970
    //                   67 978
    //                   68 986
    //                   69 994
    //                   70 1002
    //                   71 1010
    //                   72 1018
    //                   73 1026
    //                   74 1034
    //                   75 1042
    //                   76 1050
    //                   77 1058
    //                   78 1066
    //                   79 1074
    //                   80 1082
    //                   81 1090
    //                   82 1098
    //                   83 1106
    //                   84 1114
    //                   85 1122;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68 _L69 _L70 _L71 _L72 _L73 _L74 _L75 _L76 _L77 _L78 _L79 _L80 _L81 _L82 _L83 _L84 _L85 _L86 _L87 _L88
_L3:
        s1 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "searchSuggestions"), createArg("query", s), createArg("types", list), createArg("countryCode", s1), createArg("extras", list1)
        }, responselistener, flag, obj);
        return;
_L4:
        s1 = "BE";
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = "FR";
        continue; /* Loop/switch isn't completed */
_L6:
        s1 = "BB";
        continue; /* Loop/switch isn't completed */
_L7:
        s1 = "BM";
        continue; /* Loop/switch isn't completed */
_L8:
        s1 = "BO";
        continue; /* Loop/switch isn't completed */
_L9:
        s1 = "JM";
        continue; /* Loop/switch isn't completed */
_L10:
        s1 = "WS";
        continue; /* Loop/switch isn't completed */
_L11:
        s1 = "BR";
        continue; /* Loop/switch isn't completed */
_L12:
        s1 = "FI";
        continue; /* Loop/switch isn't completed */
_L13:
        s1 = "FJ";
        continue; /* Loop/switch isn't completed */
_L14:
        s1 = "NI";
        continue; /* Loop/switch isn't completed */
_L15:
        s1 = "NL";
        continue; /* Loop/switch isn't completed */
_L16:
        s1 = "NO";
        continue; /* Loop/switch isn't completed */
_L17:
        s1 = "VU";
        continue; /* Loop/switch isn't completed */
_L18:
        s1 = "NZ";
        continue; /* Loop/switch isn't completed */
_L19:
        s1 = "LU";
        continue; /* Loop/switch isn't completed */
_L20:
        s1 = "AI";
        continue; /* Loop/switch isn't completed */
_L21:
        s1 = "NR";
        continue; /* Loop/switch isn't completed */
_L22:
        s1 = "GT";
        continue; /* Loop/switch isn't completed */
_L23:
        s1 = "CO";
        continue; /* Loop/switch isn't completed */
_L24:
        s1 = "GR";
        continue; /* Loop/switch isn't completed */
_L25:
        s1 = "CL";
        continue; /* Loop/switch isn't completed */
_L26:
        s1 = "CA";
        continue; /* Loop/switch isn't completed */
_L27:
        s1 = "GY";
        continue; /* Loop/switch isn't completed */
_L28:
        s1 = "CZ";
        continue; /* Loop/switch isn't completed */
_L29:
        s1 = "CY";
        continue; /* Loop/switch isn't completed */
_L30:
        s1 = "GD";
        continue; /* Loop/switch isn't completed */
_L31:
        s1 = "GB";
        continue; /* Loop/switch isn't completed */
_L32:
        s1 = "CR";
        continue; /* Loop/switch isn't completed */
_L33:
        s1 = "HU";
        continue; /* Loop/switch isn't completed */
_L34:
        s1 = "SR";
        continue; /* Loop/switch isn't completed */
_L35:
        s1 = "SV";
        continue; /* Loop/switch isn't completed */
_L36:
        s1 = "SK";
        continue; /* Loop/switch isn't completed */
_L37:
        s1 = "SI";
        continue; /* Loop/switch isn't completed */
_L38:
        s1 = "KY";
        continue; /* Loop/switch isn't completed */
_L39:
        s1 = "SG";
        continue; /* Loop/switch isn't completed */
_L40:
        s1 = "SE";
        continue; /* Loop/switch isn't completed */
_L41:
        s1 = "DO";
        continue; /* Loop/switch isn't completed */
_L42:
        s1 = "DM";
        continue; /* Loop/switch isn't completed */
_L43:
        s1 = "DK";
        continue; /* Loop/switch isn't completed */
_L44:
        s1 = "HR";
        continue; /* Loop/switch isn't completed */
_L45:
        s1 = "DE";
        continue; /* Loop/switch isn't completed */
_L46:
        s1 = "HT";
        continue; /* Loop/switch isn't completed */
_L47:
        s1 = "KN";
        continue; /* Loop/switch isn't completed */
_L48:
        s1 = "HK";
        continue; /* Loop/switch isn't completed */
_L49:
        s1 = "CH";
        continue; /* Loop/switch isn't completed */
_L50:
        s1 = "HN";
        continue; /* Loop/switch isn't completed */
_L51:
        s1 = "LC";
        continue; /* Loop/switch isn't completed */
_L52:
        s1 = "PT";
        continue; /* Loop/switch isn't completed */
_L53:
        s1 = "TT";
        continue; /* Loop/switch isn't completed */
_L54:
        s1 = "PY";
        continue; /* Loop/switch isn't completed */
_L55:
        s1 = "LI";
        continue; /* Loop/switch isn't completed */
_L56:
        s1 = "LV";
        continue; /* Loop/switch isn't completed */
_L57:
        s1 = "TO";
        continue; /* Loop/switch isn't completed */
_L58:
        s1 = "LT";
        continue; /* Loop/switch isn't completed */
_L59:
        s1 = "PA";
        continue; /* Loop/switch isn't completed */
_L60:
        s1 = "PG";
        continue; /* Loop/switch isn't completed */
_L61:
        s1 = "TH";
        continue; /* Loop/switch isn't completed */
_L62:
        s1 = "PE";
        continue; /* Loop/switch isn't completed */
_L63:
        s1 = "PH";
        continue; /* Loop/switch isn't completed */
_L64:
        s1 = "TC";
        continue; /* Loop/switch isn't completed */
_L65:
        s1 = "PL";
        continue; /* Loop/switch isn't completed */
_L66:
        s1 = "VC";
        continue; /* Loop/switch isn't completed */
_L67:
        s1 = "VE";
        continue; /* Loop/switch isn't completed */
_L68:
        s1 = "AG";
        continue; /* Loop/switch isn't completed */
_L69:
        s1 = "VG";
        continue; /* Loop/switch isn't completed */
_L70:
        s1 = "EE";
        continue; /* Loop/switch isn't completed */
_L71:
        s1 = "IS";
        continue; /* Loop/switch isn't completed */
_L72:
        s1 = "IT";
        continue; /* Loop/switch isn't completed */
_L73:
        s1 = "EC";
        continue; /* Loop/switch isn't completed */
_L74:
        s1 = "ZA";
        continue; /* Loop/switch isn't completed */
_L75:
        s1 = "AR";
        continue; /* Loop/switch isn't completed */
_L76:
        s1 = "AU";
        continue; /* Loop/switch isn't completed */
_L77:
        s1 = "AT";
        continue; /* Loop/switch isn't completed */
_L78:
        s1 = "AW";
        continue; /* Loop/switch isn't completed */
_L79:
        s1 = "IN";
        continue; /* Loop/switch isn't completed */
_L80:
        s1 = "IE";
        continue; /* Loop/switch isn't completed */
_L81:
        s1 = "ID";
        continue; /* Loop/switch isn't completed */
_L82:
        s1 = "ES";
        continue; /* Loop/switch isn't completed */
_L83:
        s1 = "UY";
        continue; /* Loop/switch isn't completed */
_L84:
        s1 = "MC";
        continue; /* Loop/switch isn't completed */
_L85:
        s1 = "US";
        continue; /* Loop/switch isn't completed */
_L86:
        s1 = "MY";
        continue; /* Loop/switch isn't completed */
_L87:
        s1 = "MX";
        continue; /* Loop/switch isn't completed */
_L88:
        s1 = "IL";
        if (true) goto _L2; else goto _L89
_L89:
    }

    public void setAvailableOffline(List list, boolean flag, boolean flag1, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "setAvailableOffline"), createArg("keys", list), createArg("offline", Boolean.valueOf(flag))
        }, responselistener, flag1, obj);
    }

    public void setPlaylistCollaborating(String s, boolean flag, boolean flag1, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "setPlaylistCollaborating"), createArg("playlist", s), createArg("collaborating", Boolean.valueOf(flag))
        }, responselistener, flag1, obj);
    }

    public void setPlaylistCollaborationMode(String s, int i, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "setPlaylistCollaborationMode"), createArg("playlist", s), createArg("mode", Integer.valueOf(i))
        }, responselistener, flag, obj);
    }

    public void setPlaylistFields(String s, ResponseListener responselistener)
    {
        setPlaylistFields(s, null, null, false, null, responselistener);
    }

    public void setPlaylistFields(String s, String s1, String s2, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "setPlaylistFields"), createArg("playlist", s), createArg("name", s1), createArg("description", s2)
        }, responselistener, flag, obj);
    }

    public void setPlaylistOrder(String s, List list, ResponseListener responselistener)
    {
        setPlaylistOrder(s, list, null, false, null, responselistener);
    }

    public void setPlaylistOrder(String s, List list, List list1, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "setPlaylistOrder"), createArg("playlist", s), createArg("tracks", list), createArg("extras", list1)
        }, responselistener, flag, obj);
    }

    public void setUseSynchronousRequests(boolean flag)
    {
        useSynchronousRequests = flag;
    }

    public void stationsSearchSuggestions(String s, ResponseListener responselistener)
    {
        stationsSearchSuggestions(s, null, 0, null, false, null, responselistener);
    }

    public void stationsSearchSuggestions(String s, List list, int i, List list1, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "stationsSearchSuggestions"), createArg("query", s), createArg("types", list), createArg("count", Integer.valueOf(i)), createArg("extras", list1)
        }, responselistener, flag, obj);
    }

    public void steerStation(String s, int i, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "steerStation"), createArg("station_key", s), createArg("preset", Integer.valueOf(i))
        }, responselistener, flag, obj);
    }

    protected void syncPostRequest(RdioApiRequestArg ardioapirequestarg[], ResponseListener responselistener)
    {
        syncPostRequest(ardioapirequestarg, responselistener, false, null);
    }

    protected void syncPostRequest(RdioApiRequestArg ardioapirequestarg[], ResponseListener responselistener, boolean flag, Object obj)
    {
        throw new UnsupportedOperationException("Synchronous requests are not supported.");
    }

    public void unbanArtist(List list, boolean flag, Object obj, ResponseListener responselistener)
    {
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "unbanArtist"), createArg("artist_key", list)
        }, responselistener, flag, obj);
    }

    public boolean useSynchronousRequests()
    {
        return useSynchronousRequests;
    }

    public void userFollowers(String s, int i, int j, String s1, String s2, UserFollowers_sort userfollowers_sort, List list, 
            boolean flag, Object obj, ResponseListener responselistener)
    {
        String s3;
        Object obj1;
        obj1 = null;
        s3 = obj1;
        if (userfollowers_sort == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.UserFollowers_sort[userfollowers_sort.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 165
    //                   2 173;
           goto _L3 _L4 _L5
_L3:
        s3 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "userFollowers"), createArg("user", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("inCommon", s1), createArg("inNetwork", s2), createArg("sort", s3), createArg("extras", list)
        }, responselistener, flag, obj);
        return;
_L4:
        s3 = "dateAdded";
        continue; /* Loop/switch isn't completed */
_L5:
        s3 = "name";
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void userFollowers(String s, ResponseListener responselistener)
    {
        userFollowers(s, 0, 0, null, null, null, null, false, null, responselistener);
    }

    public void userFollowing(String s, int i, int j, boolean flag, String s1, UserFollowing_activityFilter userfollowing_activityfilter, UserFollowing_sort userfollowing_sort, 
            List list, boolean flag1, Object obj, ResponseListener responselistener)
    {
        if (userfollowing_activityfilter == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.UserFollowing_activityFilter[userfollowing_activityfilter.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 229
    //                   2 237
    //                   3 245;
           goto _L2 _L3 _L4 _L5
_L2:
        userfollowing_activityfilter = null;
_L12:
        String s2;
        Object obj1;
        obj1 = null;
        s2 = obj1;
        if (userfollowing_sort == null) goto _L7; else goto _L6
_L6:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.UserFollowing_sort[userfollowing_sort.ordinal()];
        JVM INSTR tableswitch 1 3: default 92
    //                   1 253
    //                   2 261
    //                   3 268;
           goto _L8 _L9 _L10 _L11
_L11:
        break MISSING_BLOCK_LABEL_268;
_L8:
        s2 = obj1;
_L7:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "userFollowing"), createArg("user", s), createArg("start", Integer.valueOf(i)), createArg("count", Integer.valueOf(j)), createArg("interleave", Boolean.valueOf(flag)), createArg("inCommon", s1), createArg("activityFilter", userfollowing_activityfilter), createArg("sort", s2), createArg("extras", list)
        }, responselistener, flag1, obj);
        return;
_L3:
        userfollowing_activityfilter = "active";
          goto _L12
_L4:
        userfollowing_activityfilter = "all";
          goto _L12
_L5:
        userfollowing_activityfilter = "inactive";
          goto _L12
_L9:
        s2 = "dateAdded";
          goto _L7
_L10:
        s2 = "name";
          goto _L7
        s2 = "recent";
          goto _L7
    }

    public void userFollowing(String s, ResponseListener responselistener)
    {
        userFollowing(s, 0, 0, false, null, null, null, null, false, null, responselistener);
    }

    public void voteForItemOnStation(String s, String s1, VoteForItemOnStation_vote voteforitemonstation_vote, boolean flag, Object obj, ResponseListener responselistener)
    {
        String s2;
        Object obj1;
        obj1 = null;
        s2 = obj1;
        if (voteforitemonstation_vote == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.rdio.android.core.RdioService_Api.VoteForItemOnStation_vote[voteforitemonstation_vote.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 108
    //                   2 116;
           goto _L3 _L4 _L5
_L3:
        s2 = obj1;
_L2:
        postRequest(new RdioApiRequestArg[] {
            new RdioApiRequestArg("method", "voteForItemOnStation"), createArg("stationKey", s), createArg("itemKey", s1), createArg("vote", s2)
        }, responselistener, flag, obj);
        return;
_L4:
        s2 = "ban";
        continue; /* Loop/switch isn't completed */
_L5:
        s2 = "unban";
        if (true) goto _L2; else goto _L6
_L6:
    }
}
