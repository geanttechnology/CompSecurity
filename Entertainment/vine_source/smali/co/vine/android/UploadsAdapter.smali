.class public Lco/vine/android/UploadsAdapter;
.super Landroid/support/v4/widget/CursorAdapter;
.source "UploadsAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/UploadsAdapter$UploadViewHolder;
    }
.end annotation


# instance fields
.field protected final mAppController:Lco/vine/android/client/AppController;

.field private final mDividerColor:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Lco/vine/android/client/AppController;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .param p3, "flags"    # I

    .prologue
    .line 51
    const v0, 0x7f090094

    invoke-direct {p0, p1, p2, p3, v0}, Lco/vine/android/UploadsAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;II)V

    .line 52
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lco/vine/android/client/AppController;II)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .param p3, "flags"    # I
    .param p4, "dividerColorId"    # I

    .prologue
    .line 45
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p3}, Landroid/support/v4/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 46
    iput-object p2, p0, Lco/vine/android/UploadsAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 47
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/UploadsAdapter;->mDividerColor:I

    .line 48
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 68
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/UploadsAdapter$UploadViewHolder;

    .line 70
    .local v0, "holder":Lco/vine/android/UploadsAdapter$UploadViewHolder;
    iget-object v2, v0, Lco/vine/android/UploadsAdapter$UploadViewHolder;->status:Landroid/widget/TextView;

    const v3, 0x7f0e025a

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    .line 71
    iget-object v2, v0, Lco/vine/android/UploadsAdapter$UploadViewHolder;->retry:Landroid/widget/ImageView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 72
    invoke-interface {p3}, Landroid/database/Cursor;->getPosition()I

    move-result v2

    if-nez v2, :cond_0

    .line 73
    iget-object v2, v0, Lco/vine/android/UploadsAdapter$UploadViewHolder;->retry:Landroid/widget/ImageView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 76
    :cond_0
    const/4 v2, 0x6

    invoke-interface {p3, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 77
    .local v1, "thumbnailPath":Ljava/lang/String;
    iget-object v2, v0, Lco/vine/android/UploadsAdapter$UploadViewHolder;->thumbnail:Landroid/widget/ImageView;

    invoke-static {v1}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 78
    return-void
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 56
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 57
    .local v1, "layoutInflater":Landroid/view/LayoutInflater;
    const v3, 0x7f03009f

    const/4 v4, 0x0

    invoke-virtual {v1, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 58
    .local v2, "v":Landroid/view/View;
    const v3, 0x7f0a0060

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    iget v4, p0, Lco/vine/android/UploadsAdapter;->mDividerColor:I

    invoke-virtual {v3, v4}, Landroid/view/View;->setBackgroundColor(I)V

    .line 60
    new-instance v0, Lco/vine/android/UploadsAdapter$UploadViewHolder;

    invoke-direct {v0, p0, v2}, Lco/vine/android/UploadsAdapter$UploadViewHolder;-><init>(Lco/vine/android/UploadsAdapter;Landroid/view/View;)V

    .line 62
    .local v0, "holder":Lco/vine/android/UploadsAdapter$UploadViewHolder;
    invoke-virtual {v2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 63
    return-object v2
.end method
