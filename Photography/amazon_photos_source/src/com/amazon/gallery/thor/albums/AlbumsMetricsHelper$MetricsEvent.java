// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;


// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumsMetricsHelper

public static final class  extends Enum
{

    private static final RemoveDynamic $VALUES[];
    public static final RemoveDynamic AddDynamic;
    public static final RemoveDynamic AddPhotos;
    public static final RemoveDynamic AddPhotosError;
    public static final RemoveDynamic AddPhotosTime;
    public static final RemoveDynamic CreatePhotoAlbum;
    public static final RemoveDynamic CreatePhotoAlbumError;
    public static final RemoveDynamic CreatePhotoAlbumTime;
    public static final RemoveDynamic DeletePhotoAlbum;
    public static final RemoveDynamic DeletePhotoAlbumError;
    public static final RemoveDynamic DeletePhotoAlbumTime;
    public static final RemoveDynamic DeletePhotoAlbumUndo;
    public static final RemoveDynamic DeletePhotoAlbumUndoError;
    public static final RemoveDynamic FolderMigrationViewAll;
    public static final RemoveDynamic FolderMigrationsViewAll;
    public static final RemoveDynamic PhotoAlbumViewAll;
    public static final RemoveDynamic PhotoAlbumsLetterClose;
    public static final RemoveDynamic PhotoAlbumsLetterView;
    public static final RemoveDynamic PhotoAlbumsViewAll;
    public static final RemoveDynamic RemoveDynamic;
    public static final RemoveDynamic RemovePhotos;
    public static final RemoveDynamic RemovePhotosError;
    public static final RemoveDynamic RemovePhotosTime;
    public static final RemoveDynamic RemovePhotosUndo;
    public static final RemoveDynamic RemovePhotosUndoError;
    public static final RemoveDynamic RenamePhotoAlbum;
    public static final RemoveDynamic RenamePhotoAlbumTime;
    public static final RemoveDynamic SetPhotoAlbumCover;
    public static final RemoveDynamic SetPhotoAlbumCoverError;
    public static final RemoveDynamic SetPhotoAlbumCoverTime;
    public static final RemoveDynamic SharePhotoAlbum;
    public static final RemoveDynamic SharePhotoAlbumError;
    public static final RemoveDynamic SharePhotoAlbumTime;
    public static final RemoveDynamic ViewAlbumInfo;
    public static final RemoveDynamic ViewAlbumInfoTime;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/albums/AlbumsMetricsHelper$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PhotoAlbumsLetterView = new <init>("PhotoAlbumsLetterView", 0);
        PhotoAlbumsLetterClose = new <init>("PhotoAlbumsLetterClose", 1);
        CreatePhotoAlbum = new <init>("CreatePhotoAlbum", 2);
        CreatePhotoAlbumError = new <init>("CreatePhotoAlbumError", 3);
        CreatePhotoAlbumTime = new <init>("CreatePhotoAlbumTime", 4);
        DeletePhotoAlbum = new <init>("DeletePhotoAlbum", 5);
        DeletePhotoAlbumError = new <init>("DeletePhotoAlbumError", 6);
        DeletePhotoAlbumUndo = new <init>("DeletePhotoAlbumUndo", 7);
        DeletePhotoAlbumUndoError = new <init>("DeletePhotoAlbumUndoError", 8);
        DeletePhotoAlbumTime = new <init>("DeletePhotoAlbumTime", 9);
        PhotoAlbumViewAll = new <init>("PhotoAlbumViewAll", 10);
        PhotoAlbumsViewAll = new <init>("PhotoAlbumsViewAll", 11);
        FolderMigrationViewAll = new <init>("FolderMigrationViewAll", 12);
        FolderMigrationsViewAll = new <init>("FolderMigrationsViewAll", 13);
        AddPhotos = new <init>("AddPhotos", 14);
        AddPhotosError = new <init>("AddPhotosError", 15);
        AddPhotosTime = new <init>("AddPhotosTime", 16);
        RemovePhotos = new <init>("RemovePhotos", 17);
        RemovePhotosError = new <init>("RemovePhotosError", 18);
        RemovePhotosUndo = new <init>("RemovePhotosUndo", 19);
        RemovePhotosUndoError = new <init>("RemovePhotosUndoError", 20);
        RemovePhotosTime = new <init>("RemovePhotosTime", 21);
        SharePhotoAlbum = new <init>("SharePhotoAlbum", 22);
        SharePhotoAlbumError = new <init>("SharePhotoAlbumError", 23);
        SharePhotoAlbumTime = new <init>("SharePhotoAlbumTime", 24);
        SetPhotoAlbumCover = new <init>("SetPhotoAlbumCover", 25);
        SetPhotoAlbumCoverError = new <init>("SetPhotoAlbumCoverError", 26);
        SetPhotoAlbumCoverTime = new <init>("SetPhotoAlbumCoverTime", 27);
        RenamePhotoAlbum = new <init>("RenamePhotoAlbum", 28);
        RenamePhotoAlbumTime = new <init>("RenamePhotoAlbumTime", 29);
        ViewAlbumInfo = new <init>("ViewAlbumInfo", 30);
        ViewAlbumInfoTime = new <init>("ViewAlbumInfoTime", 31);
        AddDynamic = new <init>("AddDynamic", 32);
        RemoveDynamic = new <init>("RemoveDynamic", 33);
        $VALUES = (new .VALUES[] {
            PhotoAlbumsLetterView, PhotoAlbumsLetterClose, CreatePhotoAlbum, CreatePhotoAlbumError, CreatePhotoAlbumTime, DeletePhotoAlbum, DeletePhotoAlbumError, DeletePhotoAlbumUndo, DeletePhotoAlbumUndoError, DeletePhotoAlbumTime, 
            PhotoAlbumViewAll, PhotoAlbumsViewAll, FolderMigrationViewAll, FolderMigrationsViewAll, AddPhotos, AddPhotosError, AddPhotosTime, RemovePhotos, RemovePhotosError, RemovePhotosUndo, 
            RemovePhotosUndoError, RemovePhotosTime, SharePhotoAlbum, SharePhotoAlbumError, SharePhotoAlbumTime, SetPhotoAlbumCover, SetPhotoAlbumCoverError, SetPhotoAlbumCoverTime, RenamePhotoAlbum, RenamePhotoAlbumTime, 
            ViewAlbumInfo, ViewAlbumInfoTime, AddDynamic, RemoveDynamic
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
