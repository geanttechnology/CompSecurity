.class public Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "HistoryAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "ViewHolder"
.end annotation


# instance fields
.field public button:Landroid/widget/LinearLayout;

.field public buttonArt:Landroid/widget/ImageView;

.field public buttonCaption:Landroid/widget/TextView;

.field public coverArt:Landroid/widget/ImageView;

.field public downloadedLayout:Landroid/view/View;

.field public expirationText:Landroid/widget/TextView;

.field public inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

.field public itemContainerLayout:Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableLinearLayout;

.field public progressIndicator:Landroid/widget/TextView;

.field public seriesInfo:Landroid/widget/TextView;

.field public title:Landroid/widget/TextView;

.field public watchingButton:Landroid/widget/LinearLayout;


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 529
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
