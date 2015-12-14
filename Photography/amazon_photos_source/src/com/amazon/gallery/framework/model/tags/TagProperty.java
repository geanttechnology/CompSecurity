// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.tags;


public interface TagProperty
{

    public static final TagProperty AUTO_SAVE = CommonTagProperty.AutoSave.YES;
    public static final TagProperty CAMERA = CommonTagProperty.Misc.CAMERA;
    public static final TagProperty CLOUD = CommonTagProperty.Storage.CLOUD;
    public static final TagProperty FREETIME = CommonTagProperty.Misc.FREETIME;
    public static final TagProperty LOCAL = CommonTagProperty.Storage.LOCAL;
    public static final TagProperty NEW_CONTENT = CommonTagProperty.NewContent.YES;
    public static final TagProperty NOT_UPLOADED = CommonTagProperty.Status.NOT_UPLOADED;
    public static final TagProperty NO_AUTO_SAVE = CommonTagProperty.AutoSave.NO;
    public static final TagProperty NO_NEW_CONTENT = CommonTagProperty.NewContent.NO;
    public static final TagProperty NO_UPLOAD_STATE = CommonTagProperty.Status.NO_UPLOAD_STATE;
    public static final TagProperty REMOVABLE = CommonTagProperty.RemovableStorage.YES;
    public static final TagProperty UPLOADED = CommonTagProperty.Status.UPLOADED;
    public static final TagProperty UPLOADING = CommonTagProperty.Status.UPLOADING;
    public static final TagProperty YOUR_CLOUD_DRIVE = CommonTagProperty.Misc.YOUR_CLOUD_DRIVE;

    public abstract int ordinal();

}
