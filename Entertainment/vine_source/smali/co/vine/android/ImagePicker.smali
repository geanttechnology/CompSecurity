.class public Lco/vine/android/ImagePicker;
.super Ljava/lang/Object;
.source "ImagePicker.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ImagePicker$Listener;
    }
.end annotation


# instance fields
.field private mActiveUserId:J

.field private mActivity:Landroid/app/Activity;

.field private mListener:Lco/vine/android/ImagePicker$Listener;

.field private mSavedImageUri:Landroid/net/Uri;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lco/vine/android/ImagePicker$Listener;J)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "listener"    # Lco/vine/android/ImagePicker$Listener;
    .param p3, "activeUserId"    # J

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    .line 33
    iput-wide p3, p0, Lco/vine/android/ImagePicker;->mActiveUserId:J

    .line 34
    iput-object p2, p0, Lco/vine/android/ImagePicker;->mListener:Lco/vine/android/ImagePicker$Listener;

    .line 35
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/ImagePicker;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ImagePicker;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public captureImage(I)V
    .locals 11
    .param p1, "requestCode"    # I

    .prologue
    const/4 v10, 0x0

    .line 38
    const-string v0, "android.media.action.IMAGE_CAPTURE"

    .line 39
    .local v0, "action":Ljava/lang/String;
    iget-object v7, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    iget-wide v8, p0, Lco/vine/android/ImagePicker;->mActiveUserId:J

    invoke-static {v7, v10, v8, v9}, Lco/vine/android/util/image/ImageUtils;->getTempPic(Landroid/content/Context;ZJ)Ljava/io/File;

    move-result-object v4

    .line 41
    .local v4, "profileFile":Ljava/io/File;
    if-eqz v4, :cond_0

    iget-object v7, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    invoke-static {v7}, Lco/vine/android/util/image/ImageUtils;->hasEnoughExternalStorageForNewPhoto(Landroid/content/Context;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 43
    :cond_0
    iget-object v7, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    const v8, 0x7f0e0055

    invoke-static {v7, v8, v10}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/Toast;->show()V

    .line 62
    :goto_0
    return-void

    .line 47
    :cond_1
    iget-object v7, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    const v8, 0x7f0e019d

    invoke-virtual {v7, v8}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 48
    .local v3, "profile":Ljava/lang/String;
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6}, Landroid/content/ContentValues;-><init>()V

    .line 49
    .local v6, "values":Landroid/content/ContentValues;
    const-string v7, "title"

    invoke-virtual {v6, v7, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    const-string v7, "description"

    invoke-virtual {v6, v7, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    invoke-static {v4}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v5

    .line 52
    .local v5, "uri":Landroid/net/Uri;
    iget-object v7, p0, Lco/vine/android/ImagePicker;->mListener:Lco/vine/android/ImagePicker$Listener;

    invoke-interface {v7, v5}, Lco/vine/android/ImagePicker$Listener;->setAvatarUrl(Landroid/net/Uri;)V

    .line 53
    new-instance v7, Landroid/content/Intent;

    const-string v8, "android.media.action.IMAGE_CAPTURE"

    invoke-direct {v7, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v8, "output"

    invoke-virtual {v7, v8, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    move-result-object v1

    .line 56
    .local v1, "i":Landroid/content/Intent;
    :try_start_0
    iget-object v7, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    invoke-virtual {v7, v1, p1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 57
    :catch_0
    move-exception v2

    .line 58
    .local v2, "ignored":Landroid/content/ActivityNotFoundException;
    iget-object v7, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    const v8, 0x7f0e0256

    invoke-static {v7, v8}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 59
    invoke-static {v5}, Lco/vine/android/util/image/ImageUtils;->deleteTempPic(Landroid/net/Uri;)Z

    .line 60
    iget-object v7, p0, Lco/vine/android/ImagePicker;->mListener:Lco/vine/android/ImagePicker$Listener;

    const/4 v8, 0x0

    invoke-interface {v7, v8}, Lco/vine/android/ImagePicker$Listener;->setAvatarUrl(Landroid/net/Uri;)V

    goto :goto_0
.end method

.method public chooseImage(I)V
    .locals 4
    .param p1, "requestCode"    # I

    .prologue
    .line 65
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.PICK"

    sget-object v3, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 68
    .local v1, "intent":Landroid/content/Intent;
    :try_start_0
    iget-object v2, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    invoke-virtual {v2, v1, p1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 72
    :goto_0
    return-void

    .line 69
    :catch_0
    move-exception v0

    .line 70
    .local v0, "ignored":Landroid/content/ActivityNotFoundException;
    iget-object v2, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    const v3, 0x7f0e0256

    invoke-static {v2, v3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0
.end method

.method public getSavedImageUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lco/vine/android/ImagePicker;->mSavedImageUri:Landroid/net/Uri;

    return-object v0
.end method

.method public saveProfileImage(Landroid/graphics/Bitmap;)V
    .locals 7
    .param p1, "bm"    # Landroid/graphics/Bitmap;

    .prologue
    .line 79
    new-instance v3, Ljava/io/File;

    iget-object v5, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    invoke-static {v5}, Lco/vine/android/util/Util;->getExternalCacheDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v5

    const-string v6, "twitter_profile.jpg"

    invoke-direct {v3, v5, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 80
    .local v3, "f":Ljava/io/File;
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 81
    .local v0, "bos":Ljava/io/ByteArrayOutputStream;
    sget-object v5, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v6, 0x64

    invoke-virtual {p1, v5, v6, v0}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 82
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    .line 85
    .local v1, "compressed":[B
    :try_start_0
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 86
    .local v4, "fos":Ljava/io/FileOutputStream;
    invoke-virtual {v4, v1}, Ljava/io/FileOutputStream;->write([B)V

    .line 87
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V

    .line 88
    invoke-static {v3}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v5

    iput-object v5, p0, Lco/vine/android/ImagePicker;->mSavedImageUri:Landroid/net/Uri;

    .line 89
    const-string v5, "Pending Uri for profile photo is {}."

    iget-object v6, p0, Lco/vine/android/ImagePicker;->mSavedImageUri:Landroid/net/Uri;

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 90
    iget-object v5, p0, Lco/vine/android/ImagePicker;->mListener:Lco/vine/android/ImagePicker$Listener;

    iget-object v6, p0, Lco/vine/android/ImagePicker;->mSavedImageUri:Landroid/net/Uri;

    invoke-interface {v5, v6}, Lco/vine/android/ImagePicker$Listener;->setAvatarUrl(Landroid/net/Uri;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 103
    .end local v4    # "fos":Ljava/io/FileOutputStream;
    :goto_0
    return-void

    .line 91
    :catch_0
    move-exception v2

    .line 92
    .local v2, "e":Ljava/lang/Exception;
    iget-object v5, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    if-eqz v5, :cond_0

    .line 93
    iget-object v5, p0, Lco/vine/android/ImagePicker;->mActivity:Landroid/app/Activity;

    new-instance v6, Lco/vine/android/ImagePicker$1;

    invoke-direct {v6, p0}, Lco/vine/android/ImagePicker$1;-><init>(Lco/vine/android/ImagePicker;)V

    invoke-virtual {v5, v6}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 101
    :cond_0
    iget-object v5, p0, Lco/vine/android/ImagePicker;->mListener:Lco/vine/android/ImagePicker$Listener;

    const/4 v6, 0x0

    invoke-interface {v5, v6}, Lco/vine/android/ImagePicker$Listener;->setAvatarUrl(Landroid/net/Uri;)V

    goto :goto_0
.end method
