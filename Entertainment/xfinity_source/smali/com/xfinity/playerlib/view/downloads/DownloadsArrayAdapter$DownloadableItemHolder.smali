.class Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;
.super Ljava/lang/Object;
.source "DownloadsArrayAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DownloadableItemHolder"
.end annotation


# instance fields
.field protected coverArt:Landroid/widget/ImageView;

.field protected downloadedLayout:Landroid/widget/LinearLayout;

.field protected episodeNumText:Landroid/widget/TextView;

.field protected expirationText:Landroid/widget/TextView;

.field protected inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

.field protected networkLogo:Landroid/widget/ImageView;

.field protected networkText:Landroid/widget/TextView;

.field protected playButton:Landroid/widget/LinearLayout;

.field public playButtonArt:Landroid/widget/ImageView;

.field public playButtonCaption:Landroid/widget/TextView;

.field protected playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

.field protected progressIndicator:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

.field protected titleText:Landroid/widget/TextView;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;)V
    .locals 0

    .prologue
    .line 407
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$1;

    .prologue
    .line 407
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;)V

    return-void
.end method
