// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.activity.CollectionListActivity;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.thor.metrics.MetricsHelper;

public class AlbumsMetricsHelper extends MetricsHelper
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AddDynamic;
        public static final MetricsEvent AddPhotos;
        public static final MetricsEvent AddPhotosError;
        public static final MetricsEvent AddPhotosTime;
        public static final MetricsEvent CreatePhotoAlbum;
        public static final MetricsEvent CreatePhotoAlbumError;
        public static final MetricsEvent CreatePhotoAlbumTime;
        public static final MetricsEvent DeletePhotoAlbum;
        public static final MetricsEvent DeletePhotoAlbumError;
        public static final MetricsEvent DeletePhotoAlbumTime;
        public static final MetricsEvent DeletePhotoAlbumUndo;
        public static final MetricsEvent DeletePhotoAlbumUndoError;
        public static final MetricsEvent FolderMigrationViewAll;
        public static final MetricsEvent FolderMigrationsViewAll;
        public static final MetricsEvent PhotoAlbumViewAll;
        public static final MetricsEvent PhotoAlbumsLetterClose;
        public static final MetricsEvent PhotoAlbumsLetterView;
        public static final MetricsEvent PhotoAlbumsViewAll;
        public static final MetricsEvent RemoveDynamic;
        public static final MetricsEvent RemovePhotos;
        public static final MetricsEvent RemovePhotosError;
        public static final MetricsEvent RemovePhotosTime;
        public static final MetricsEvent RemovePhotosUndo;
        public static final MetricsEvent RemovePhotosUndoError;
        public static final MetricsEvent RenamePhotoAlbum;
        public static final MetricsEvent RenamePhotoAlbumTime;
        public static final MetricsEvent SetPhotoAlbumCover;
        public static final MetricsEvent SetPhotoAlbumCoverError;
        public static final MetricsEvent SetPhotoAlbumCoverTime;
        public static final MetricsEvent SharePhotoAlbum;
        public static final MetricsEvent SharePhotoAlbumError;
        public static final MetricsEvent SharePhotoAlbumTime;
        public static final MetricsEvent ViewAlbumInfo;
        public static final MetricsEvent ViewAlbumInfoTime;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/albums/AlbumsMetricsHelper$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            PhotoAlbumsLetterView = new MetricsEvent("PhotoAlbumsLetterView", 0);
            PhotoAlbumsLetterClose = new MetricsEvent("PhotoAlbumsLetterClose", 1);
            CreatePhotoAlbum = new MetricsEvent("CreatePhotoAlbum", 2);
            CreatePhotoAlbumError = new MetricsEvent("CreatePhotoAlbumError", 3);
            CreatePhotoAlbumTime = new MetricsEvent("CreatePhotoAlbumTime", 4);
            DeletePhotoAlbum = new MetricsEvent("DeletePhotoAlbum", 5);
            DeletePhotoAlbumError = new MetricsEvent("DeletePhotoAlbumError", 6);
            DeletePhotoAlbumUndo = new MetricsEvent("DeletePhotoAlbumUndo", 7);
            DeletePhotoAlbumUndoError = new MetricsEvent("DeletePhotoAlbumUndoError", 8);
            DeletePhotoAlbumTime = new MetricsEvent("DeletePhotoAlbumTime", 9);
            PhotoAlbumViewAll = new MetricsEvent("PhotoAlbumViewAll", 10);
            PhotoAlbumsViewAll = new MetricsEvent("PhotoAlbumsViewAll", 11);
            FolderMigrationViewAll = new MetricsEvent("FolderMigrationViewAll", 12);
            FolderMigrationsViewAll = new MetricsEvent("FolderMigrationsViewAll", 13);
            AddPhotos = new MetricsEvent("AddPhotos", 14);
            AddPhotosError = new MetricsEvent("AddPhotosError", 15);
            AddPhotosTime = new MetricsEvent("AddPhotosTime", 16);
            RemovePhotos = new MetricsEvent("RemovePhotos", 17);
            RemovePhotosError = new MetricsEvent("RemovePhotosError", 18);
            RemovePhotosUndo = new MetricsEvent("RemovePhotosUndo", 19);
            RemovePhotosUndoError = new MetricsEvent("RemovePhotosUndoError", 20);
            RemovePhotosTime = new MetricsEvent("RemovePhotosTime", 21);
            SharePhotoAlbum = new MetricsEvent("SharePhotoAlbum", 22);
            SharePhotoAlbumError = new MetricsEvent("SharePhotoAlbumError", 23);
            SharePhotoAlbumTime = new MetricsEvent("SharePhotoAlbumTime", 24);
            SetPhotoAlbumCover = new MetricsEvent("SetPhotoAlbumCover", 25);
            SetPhotoAlbumCoverError = new MetricsEvent("SetPhotoAlbumCoverError", 26);
            SetPhotoAlbumCoverTime = new MetricsEvent("SetPhotoAlbumCoverTime", 27);
            RenamePhotoAlbum = new MetricsEvent("RenamePhotoAlbum", 28);
            RenamePhotoAlbumTime = new MetricsEvent("RenamePhotoAlbumTime", 29);
            ViewAlbumInfo = new MetricsEvent("ViewAlbumInfo", 30);
            ViewAlbumInfoTime = new MetricsEvent("ViewAlbumInfoTime", 31);
            AddDynamic = new MetricsEvent("AddDynamic", 32);
            RemoveDynamic = new MetricsEvent("RemoveDynamic", 33);
            $VALUES = (new MetricsEvent[] {
                PhotoAlbumsLetterView, PhotoAlbumsLetterClose, CreatePhotoAlbum, CreatePhotoAlbumError, CreatePhotoAlbumTime, DeletePhotoAlbum, DeletePhotoAlbumError, DeletePhotoAlbumUndo, DeletePhotoAlbumUndoError, DeletePhotoAlbumTime, 
                PhotoAlbumViewAll, PhotoAlbumsViewAll, FolderMigrationViewAll, FolderMigrationsViewAll, AddPhotos, AddPhotosError, AddPhotosTime, RemovePhotos, RemovePhotosError, RemovePhotosUndo, 
                RemovePhotosUndoError, RemovePhotosTime, SharePhotoAlbum, SharePhotoAlbumError, SharePhotoAlbumTime, SetPhotoAlbumCover, SetPhotoAlbumCoverError, SetPhotoAlbumCoverTime, RenamePhotoAlbum, RenamePhotoAlbumTime, 
                ViewAlbumInfo, ViewAlbumInfoTime, AddDynamic, RemoveDynamic
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public static String getPageName(Activity activity)
    {
        if (activity instanceof NativeGalleryActivity)
        {
            if (((NativeGalleryActivity)activity).getMediaContentConfiguration().toViewDescriptor().getTag() == null)
            {
                return "AllView";
            } else
            {
                return "PhotoAlbumView";
            }
        }
        if (activity instanceof CollectionListActivity)
        {
            return "PhotoAlbumsView";
        } else
        {
            return null;
        }
    }
}
