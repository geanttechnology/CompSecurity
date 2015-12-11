.class public Lco/vine/android/CropActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "CropActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/CropActivity$CropImageTask;,
        Lco/vine/android/CropActivity$LoadImageTask;
    }
.end annotation


# static fields
.field private static final DIALOG_CROPPING_PROGRESS_ID:I = 0x0

.field private static final DIALOG_LOADING_PROGRESS_ID:I = 0x1

.field public static final EXTRA_CROP_RECT:Ljava/lang/String; = "cropped_rect"

.field public static final EXTRA_CROP_TYPE:Ljava/lang/String; = "crop_type"

.field public static final EXTRA_URI:Ljava/lang/String; = "uri"

.field private static final STATE_DEGREES:Ljava/lang/String; = "degrees"


# instance fields
.field mBitmapHeight:I

.field mBitmapHeightOffset:I

.field protected mBitmapLoaded:Z

.field mBitmapWidth:I

.field mBitmapWidthOffset:I

.field protected mCropTask:Lco/vine/android/CropActivity$CropImageTask;

.field private mCurrDegrees:I

.field mFileToViewScale:I

.field protected mUri:Landroid/net/Uri;

.field protected mView:Lco/vine/android/widget/CroppableImageView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    .line 206
    return-void
.end method


# virtual methods
.method protected doCrop()V
    .locals 2

    .prologue
    .line 86
    iget-boolean v0, p0, Lco/vine/android/CropActivity;->mBitmapLoaded:Z

    if-nez v0, :cond_0

    .line 94
    :goto_0
    return-void

    .line 89
    :cond_0
    iget-object v0, p0, Lco/vine/android/CropActivity;->mCropTask:Lco/vine/android/CropActivity$CropImageTask;

    if-eqz v0, :cond_1

    .line 90
    iget-object v0, p0, Lco/vine/android/CropActivity;->mCropTask:Lco/vine/android/CropActivity$CropImageTask;

    invoke-virtual {v0}, Lco/vine/android/CropActivity$CropImageTask;->detachActivity()V

    .line 92
    :cond_1
    new-instance v0, Lco/vine/android/CropActivity$CropImageTask;

    invoke-direct {v0, p0}, Lco/vine/android/CropActivity$CropImageTask;-><init>(Lco/vine/android/CropActivity;)V

    iput-object v0, p0, Lco/vine/android/CropActivity;->mCropTask:Lco/vine/android/CropActivity$CropImageTask;

    .line 93
    iget-object v0, p0, Lco/vine/android/CropActivity;->mCropTask:Lco/vine/android/CropActivity$CropImageTask;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lco/vine/android/CropActivity$CropImageTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method protected onBitmapProcessingDone(Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 135
    iget-object v0, p0, Lco/vine/android/CropActivity;->mView:Lco/vine/android/widget/CroppableImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/CroppableImageView;->setVisibility(I)V

    .line 136
    iget-object v0, p0, Lco/vine/android/CropActivity;->mView:Lco/vine/android/widget/CroppableImageView;

    invoke-virtual {v0, p1}, Lco/vine/android/widget/CroppableImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 137
    return-void
.end method

.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 317
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/CropActivity;->setResult(I)V

    .line 318
    invoke-virtual {p0}, Lco/vine/android/CropActivity;->finish()V

    .line 319
    return-void
.end method

.method public onClickHandler(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 97
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 111
    :goto_0
    return-void

    .line 99
    :pswitch_0
    invoke-virtual {p0}, Lco/vine/android/CropActivity;->doCrop()V

    goto :goto_0

    .line 103
    :pswitch_1
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/CropActivity;->setResult(I)V

    .line 104
    invoke-virtual {p0}, Lco/vine/android/CropActivity;->finish()V

    goto :goto_0

    .line 97
    :pswitch_data_0
    .packed-switch 0x7f0a00c8
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;I)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .param p2, "layout"    # I

    .prologue
    const/4 v2, 0x0

    .line 50
    invoke-super {p0, p1, p2, v2}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 51
    invoke-virtual {p0}, Lco/vine/android/CropActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "uri"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lco/vine/android/CropActivity;->mUri:Landroid/net/Uri;

    .line 52
    const v0, 0x7f0a0046

    invoke-virtual {p0, v0}, Lco/vine/android/CropActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/CroppableImageView;

    iput-object v0, p0, Lco/vine/android/CropActivity;->mView:Lco/vine/android/widget/CroppableImageView;

    .line 53
    iget-object v0, p0, Lco/vine/android/CropActivity;->mView:Lco/vine/android/widget/CroppableImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lco/vine/android/widget/CroppableImageView;->setVisibility(I)V

    .line 54
    if-eqz p1, :cond_0

    .line 55
    const-string v0, "degrees"

    invoke-virtual {p1, v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lco/vine/android/CropActivity;->mCurrDegrees:I

    .line 59
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/CropActivity;->getLastCustomNonConfigurationInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/CropActivity$CropImageTask;

    iput-object v0, p0, Lco/vine/android/CropActivity;->mCropTask:Lco/vine/android/CropActivity$CropImageTask;

    .line 60
    iget-object v0, p0, Lco/vine/android/CropActivity;->mCropTask:Lco/vine/android/CropActivity$CropImageTask;

    if-nez v0, :cond_1

    .line 61
    new-instance v0, Lco/vine/android/CropActivity$LoadImageTask;

    invoke-direct {v0, p0, p0}, Lco/vine/android/CropActivity$LoadImageTask;-><init>(Lco/vine/android/CropActivity;Lco/vine/android/CropActivity;)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lco/vine/android/CropActivity$LoadImageTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 65
    :goto_1
    return-void

    .line 57
    :cond_0
    iput v2, p0, Lco/vine/android/CropActivity;->mCurrDegrees:I

    goto :goto_0

    .line 63
    :cond_1
    iget-object v0, p0, Lco/vine/android/CropActivity;->mCropTask:Lco/vine/android/CropActivity$CropImageTask;

    invoke-virtual {v0, p0}, Lco/vine/android/CropActivity$CropImageTask;->attachActivity(Lco/vine/android/CropActivity;)V

    goto :goto_1
.end method

.method protected onCreateDialog(I)Landroid/app/Dialog;
    .locals 3
    .param p1, "id"    # I

    .prologue
    const/4 v2, 0x0

    .line 115
    new-instance v0, Landroid/app/ProgressDialog;

    const v1, 0x7f0f0037

    invoke-direct {v0, p0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 116
    .local v0, "dialog":Landroid/app/ProgressDialog;
    invoke-virtual {v0, v2}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 117
    invoke-virtual {v0, v2}, Landroid/app/ProgressDialog;->setCanceledOnTouchOutside(Z)V

    .line 118
    invoke-virtual {v0, p0}, Landroid/app/ProgressDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 119
    packed-switch p1, :pswitch_data_0

    .line 129
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onCreateDialog(I)Landroid/app/Dialog;

    move-result-object v0

    .end local v0    # "dialog":Landroid/app/ProgressDialog;
    :goto_0
    return-object v0

    .line 121
    .restart local v0    # "dialog":Landroid/app/ProgressDialog;
    :pswitch_0
    const v1, 0x7f0e00a6

    invoke-virtual {p0, v1}, Lco/vine/android/CropActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 125
    :pswitch_1
    const v1, 0x7f0e011d

    invoke-virtual {p0, v1}, Lco/vine/android/CropActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 119
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCropDone(ZLandroid/content/Intent;)V
    .locals 2
    .param p1, "success"    # Z
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 197
    if-eqz p1, :cond_0

    .line 198
    const/4 v0, -0x1

    invoke-virtual {p0, v0, p2}, Lco/vine/android/CropActivity;->setResult(ILandroid/content/Intent;)V

    .line 203
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/CropActivity;->finish()V

    .line 204
    return-void

    .line 200
    :cond_0
    const v0, 0x7f0e00a7

    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 201
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/CropActivity;->setResult(I)V

    goto :goto_0
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 141
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onPause()V

    .line 142
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/CropActivity;->removeDialog(I)V

    .line 143
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/CropActivity;->removeDialog(I)V

    .line 144
    return-void
.end method

.method public onRetainCustomNonConfigurationInstance()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lco/vine/android/CropActivity;->mCropTask:Lco/vine/android/CropActivity$CropImageTask;

    if-eqz v0, :cond_0

    .line 75
    iget-object v0, p0, Lco/vine/android/CropActivity;->mCropTask:Lco/vine/android/CropActivity$CropImageTask;

    invoke-virtual {v0}, Lco/vine/android/CropActivity$CropImageTask;->detachActivity()V

    .line 77
    :cond_0
    iget-object v0, p0, Lco/vine/android/CropActivity;->mCropTask:Lco/vine/android/CropActivity$CropImageTask;

    return-object v0
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 69
    const-string v0, "degrees"

    iget v1, p0, Lco/vine/android/CropActivity;->mCurrDegrees:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 70
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 82
    const/4 v0, 0x0

    return v0
.end method
