.class public Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;
.super Landroid/widget/ArrayAdapter;
.source "DownloadsArrayAdapter.java"

# interfaces
.implements Lcom/comcast/cim/downloads/DownloadServiceListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;,
        Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
        ">;",
        "Lcom/comcast/cim/downloads/DownloadServiceListener",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
        ">;"
    }
.end annotation


# instance fields
.field protected final LOG:Lorg/slf4j/Logger;

.field private final activity:Landroid/app/Activity;

.field protected final coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field protected final downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private downloadServiceListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/downloads/DownloadServiceListener",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
            ">;>;"
        }
    .end annotation
.end field

.field private handler:Landroid/os/Handler;

.field private inflater:Landroid/view/LayoutInflater;

.field protected final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private isEditMode:Z

.field protected final listener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

.field protected final logoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

.field private final scrollStateTracker:Lcom/xfinity/playerlib/view/ScrollStateTracker;

.field private final sdf:Lorg/apache/commons/lang3/time/FastDateFormat;

.field private videoBookmarks:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation
.end field

.field private videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/util/List;Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/xfinity/playerlib/view/ScrollStateTracker;Lorg/apache/commons/lang3/time/FastDateFormat;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p3, "inflater"    # Landroid/view/LayoutInflater;
    .param p4, "imageLoader"    # Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    .param p5, "listener"    # Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;
    .param p6, "downloadManager"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .param p7, "logoImageLoader"    # Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    .param p8, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .param p9, "scrollStateTracker"    # Lcom/xfinity/playerlib/view/ScrollStateTracker;
    .param p10, "sdf"    # Lorg/apache/commons/lang3/time/FastDateFormat;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
            ">;",
            "Landroid/view/LayoutInflater;",
            "Lcom/xfinity/playerlib/image/CoverArtImageLoader;",
            "Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;",
            "Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;",
            "Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;",
            "Lcom/xfinity/playerlib/view/ScrollStateTracker;",
            "Lorg/apache/commons/lang3/time/FastDateFormat;",
            ")V"
        }
    .end annotation

    .prologue
    .local p2, "objects":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    const/4 v1, 0x0

    .line 97
    invoke-direct {p0, p1, v1, p2}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 46
    const-class v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->LOG:Lorg/slf4j/Logger;

    .line 57
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->handler:Landroid/os/Handler;

    .line 63
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->isEditMode:Z

    .line 67
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->downloadServiceListeners:Ljava/util/Set;

    .line 98
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->activity:Landroid/app/Activity;

    .line 99
    iput-object p3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 100
    iput-object p4, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 101
    iput-object p5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->listener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    .line 102
    iput-object p6, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 103
    iput-object p7, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->logoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 104
    iput-object p8, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 105
    iput-object p9, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->scrollStateTracker:Lcom/xfinity/playerlib/view/ScrollStateTracker;

    .line 106
    iput-object p10, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->sdf:Lorg/apache/commons/lang3/time/FastDateFormat;

    .line 107
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    return-object v0
.end method

.method private showDownloadedInfo(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 7
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;
    .param p2, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p3, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    const/16 v4, 0x8

    const/4 v6, 0x0

    const/4 v3, 0x0

    .line 320
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->downloadedLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 321
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-virtual {v0, v4}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setVisibility(I)V

    .line 322
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 325
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideo()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProviderCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 326
    if-eqz p3, :cond_0

    .line 327
    iget-object v1, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButtonCaption:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {p3}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v0

    if-lez v0, :cond_1

    invoke-virtual {p3}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->isFinished()Z

    move-result v0

    if-nez v0, :cond_1

    sget v0, Lcom/xfinity/playerlib/R$string;->resume:I

    :goto_0
    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v2}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 330
    :cond_0
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpirationStatus()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->AAW_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    if-ne v0, v1, :cond_2

    .line 331
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 332
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    invoke-virtual {v0, v3, v3, v3, v3}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 333
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$color;->MediumLightGray:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 334
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->unavailable:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 335
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 346
    :goto_1
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButtonArt:Landroid/widget/ImageView;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->play_button_entitled_graphic:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 347
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->play_button_entitled_background:I

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 358
    :goto_2
    return-void

    .line 327
    :cond_1
    sget v0, Lcom/xfinity/playerlib/R$string;->play:I

    goto :goto_0

    .line 336
    :cond_2
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAssetExpirationDate()Ljava/util/Date;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAssetExpirationDate()Ljava/util/Date;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/utils/UIPresentationUtil;->getDaysLeft(Ljava/util/Date;)I

    move-result v0

    const/16 v1, 0xe

    if-ge v0, v1, :cond_3

    .line 337
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 338
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    invoke-virtual {v0, v3, v3, v3, v3}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 339
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$color;->MediumLightGray:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 340
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->available_until:I

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->sdf:Lorg/apache/commons/lang3/time/FastDateFormat;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAssetExpirationDate()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/apache/commons/lang3/time/FastDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 341
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 343
    :cond_3
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 349
    :cond_4
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButtonArt:Landroid/widget/ImageView;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->icn_upsell_btn:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 351
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButtonCaption:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$color;->white:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 352
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButtonCaption:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_play_button_unentitled:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 353
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->play_button_unentitled:I

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 355
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_2
.end method

.method private showInProgressInfo(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 3
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;
    .param p2, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    const/16 v2, 0x8

    .line 361
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setVisibility(I)V

    .line 362
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->downloadedLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 363
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 365
    iget-object v0, p1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v0, p2, v1, v2}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgress(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V

    .line 366
    return-void
.end method

.method private updateWithEditMode(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;)V
    .locals 5
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "holder"    # Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 302
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->isEditMode:Z

    if-eqz v0, :cond_0

    .line 303
    iget-object v0, p2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setButtonsEnable(Z)V

    .line 304
    iget-object v0, p2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setClickable(Z)V

    .line 305
    iget-object v0, p2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 306
    iget-object v0, p2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 317
    :goto_0
    return-void

    .line 308
    :cond_0
    iget-object v0, p2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-virtual {v0, v3}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setButtonsEnable(Z)V

    .line 309
    iget-object v0, p2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpirationStatus()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->OVP_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    if-ne v0, v1, :cond_1

    .line 310
    iget-object v0, p2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 311
    iget-object v0, p2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 313
    :cond_1
    iget-object v0, p2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 314
    iget-object v0, p2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;

    iget-object v2, p2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-direct {v1, p0, p1, v2}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 19
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 124
    invoke-virtual/range {p0 .. p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 125
    .local v9, "playerDownloadFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    invoke-virtual {v9}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v13

    .line 126
    .local v13, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-virtual {v9}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v14

    invoke-interface {v13, v14, v15}, Lcom/xfinity/playerlib/model/consumable/Watchable;->findVideoById(J)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v12

    .line 128
    .local v12, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    if-nez p2, :cond_2

    .line 129
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->inflater:Landroid/view/LayoutInflater;

    sget v15, Lcom/xfinity/playerlib/R$layout;->downloads_list_item:I

    const/16 v16, 0x0

    invoke-virtual/range {v14 .. v16}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 131
    new-instance v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;

    const/4 v14, 0x0

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v14}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$1;)V

    .line 132
    .local v4, "holder":Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;
    sget v14, Lcom/xfinity/playerlib/R$id;->cover_art:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/ImageView;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->coverArt:Landroid/widget/ImageView;

    .line 133
    sget v14, Lcom/xfinity/playerlib/R$id;->title_text:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->titleText:Landroid/widget/TextView;

    .line 134
    sget v14, Lcom/xfinity/playerlib/R$id;->season_episode_text:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->episodeNumText:Landroid/widget/TextView;

    .line 135
    sget v14, Lcom/xfinity/playerlib/R$id;->network_logo:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/ImageView;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->networkLogo:Landroid/widget/ImageView;

    .line 136
    sget v14, Lcom/xfinity/playerlib/R$id;->network_name:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->networkText:Landroid/widget/TextView;

    .line 137
    sget v14, Lcom/xfinity/playerlib/R$id;->progress_indicator:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->progressIndicator:Landroid/widget/TextView;

    .line 139
    sget v14, Lcom/xfinity/playerlib/R$id;->in_progress_layout:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    .line 141
    sget v14, Lcom/xfinity/playerlib/R$id;->downloaded_layout:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/LinearLayout;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->downloadedLayout:Landroid/widget/LinearLayout;

    .line 142
    sget v14, Lcom/xfinity/playerlib/R$id;->expiration_text:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->expirationText:Landroid/widget/TextView;

    .line 143
    sget v14, Lcom/xfinity/playerlib/R$id;->play_button:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/LinearLayout;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    .line 144
    sget v14, Lcom/xfinity/playerlib/R$id;->button_caption:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButtonCaption:Landroid/widget/TextView;

    .line 145
    sget v14, Lcom/xfinity/playerlib/R$id;->button_art:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/ImageView;

    iput-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButtonArt:Landroid/widget/ImageView;

    .line 147
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    new-instance v15, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$1;

    move-object/from16 v0, p0

    invoke-direct {v15, v0, v4}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$1;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;)V

    invoke-virtual {v14, v15}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setOnCancelListener(Landroid/view/View$OnClickListener;)V

    .line 154
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    new-instance v15, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$2;

    move-object/from16 v0, p0

    invoke-direct {v15, v0, v4}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$2;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;)V

    invoke-virtual {v14, v15}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setOnHotwireDownloadClickListener(Landroid/view/View$OnClickListener;)V

    .line 161
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    new-instance v15, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$3;

    move-object/from16 v0, p0

    invoke-direct {v15, v0, v4}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$3;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;)V

    invoke-virtual {v14, v15}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setOnRetryDownloadClickListener(Landroid/view/View$OnClickListener;)V

    .line 168
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playButton:Landroid/widget/LinearLayout;

    new-instance v15, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;

    iget-object v0, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v15, v0, v12, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    invoke-virtual {v14, v15}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 170
    new-instance v3, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;

    move-object/from16 v0, p0

    invoke-direct {v3, v0, v4}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$4;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;)V

    .line 183
    .local v3, "downloadServiceListener":Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;, "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->downloadServiceListeners:Ljava/util/Set;

    invoke-interface {v14, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 185
    move-object/from16 v0, p2

    invoke-virtual {v0, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 191
    .end local v3    # "downloadServiceListener":Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;, "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    :goto_0
    iput-object v9, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 193
    new-instance v8, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$5;

    move-object/from16 v0, p0

    invoke-direct {v8, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$5;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;)V

    .line 201
    .local v8, "onLoadListener":Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;
    invoke-interface {v13}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;

    move-result-object v10

    .line 204
    .local v10, "seriesInfo":Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->coverArt:Landroid/widget/ImageView;

    if-eqz v14, :cond_5

    .line 205
    invoke-interface {v13}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v6

    .line 207
    .local v6, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v15, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->coverArt:Landroid/widget/ImageView;

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v14, v6, v15, v0}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImageFromMemory(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z

    move-result v5

    .line 210
    .local v5, "loadedFromMemory":Z
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->scrollStateTracker:Lcom/xfinity/playerlib/view/ScrollStateTracker;

    invoke-interface {v14}, Lcom/xfinity/playerlib/view/ScrollStateTracker;->isFlinging()Z

    move-result v14

    if-eqz v14, :cond_3

    .line 213
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->coverArt:Landroid/widget/ImageView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 214
    if-nez v5, :cond_0

    .line 215
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->coverArt:Landroid/widget/ImageView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 224
    :cond_0
    :goto_1
    if-eqz v10, :cond_4

    .line 225
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->titleText:Landroid/widget/TextView;

    invoke-interface {v13}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Lcom/comcast/cim/utils/UIPresentationUtil;->addQuotesToString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 238
    .end local v5    # "loadedFromMemory":Z
    .end local v6    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    :goto_2
    if-eqz v10, :cond_8

    .line 240
    invoke-interface {v10}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v14

    invoke-interface {v10}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v15

    .line 239
    invoke-static {v14, v15}, Lcom/comcast/cim/utils/UIPresentationUtil;->getSeriesString(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;

    move-result-object v11

    .line 242
    .local v11, "seriesString":Ljava/lang/String;
    invoke-virtual {v11}, Ljava/lang/String;->isEmpty()Z

    move-result v14

    if-nez v14, :cond_7

    .line 243
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->episodeNumText:Landroid/widget/TextView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 245
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->episodeNumText:Landroid/widget/TextView;

    invoke-virtual {v14, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 246
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->episodeNumText:Landroid/widget/TextView;

    .line 248
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->getContext()Landroid/content/Context;

    move-result-object v15

    sget v16, Lcom/xfinity/playerlib/R$string;->content_description_season:I

    invoke-virtual/range {v15 .. v16}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v15

    .line 250
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->getContext()Landroid/content/Context;

    move-result-object v16

    sget v17, Lcom/xfinity/playerlib/R$string;->content_description_episode:I

    invoke-virtual/range {v16 .. v17}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v16

    .line 247
    move-object/from16 v0, v16

    invoke-static {v11, v15, v0}, Lcom/comcast/cim/utils/UIPresentationUtil;->getSeriesStringSpoken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 246
    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 260
    .end local v11    # "seriesString":Ljava/lang/String;
    :goto_3
    invoke-virtual {v12}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v14

    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->isPremium()Z

    move-result v14

    if-eqz v14, :cond_9

    .line 261
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->logoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    invoke-virtual {v12}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v15

    invoke-virtual {v15}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v16

    iget-object v15, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->networkLogo:Landroid/widget/ImageView;

    move-wide/from16 v0, v16

    invoke-virtual {v14, v0, v1, v15}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadNetworkLogoSmall(JLandroid/widget/ImageView;)V

    .line 262
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->networkLogo:Landroid/widget/ImageView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 263
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->networkText:Landroid/widget/TextView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 271
    :goto_4
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->getContext()Landroid/content/Context;

    move-result-object v14

    sget v15, Lcom/xfinity/playerlib/R$string;->content_description_on_network:I

    const/16 v16, 0x2

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    const-string v18, ""

    aput-object v18, v16, v17

    const/16 v17, 0x1

    .line 272
    invoke-virtual {v12}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getName()Ljava/lang/String;

    move-result-object v18

    aput-object v18, v16, v17

    .line 271
    invoke-virtual/range {v14 .. v16}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 274
    .local v7, "networkInfo":Ljava/lang/String;
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->networkLogo:Landroid/widget/ImageView;

    invoke-virtual {v14, v7}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 275
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->networkText:Landroid/widget/TextView;

    invoke-virtual {v14, v7}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 277
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->videoBookmarks:Ljava/util/Map;

    invoke-interface {v14, v12}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 278
    .local v2, "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    if-eqz v2, :cond_a

    invoke-virtual {v2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v14

    if-lez v14, :cond_a

    .line 279
    invoke-virtual {v2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getCategories()Ljava/util/List;

    move-result-object v14

    sget-object v15, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->CATEGORY_RECENT:Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    invoke-interface {v14, v15}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_1

    .line 281
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->progressIndicator:Landroid/widget/TextView;

    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->getContext()Landroid/content/Context;

    move-result-object v15

    .line 282
    invoke-virtual {v2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getDuration()I

    move-result v16

    .line 283
    invoke-virtual {v2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v17

    .line 281
    invoke-static/range {v15 .. v17}, Lcom/comcast/cim/utils/UIPresentationUtil;->getRemainingTime(Landroid/content/Context;II)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 284
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->progressIndicator:Landroid/widget/TextView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 290
    :cond_1
    :goto_5
    invoke-virtual {v9}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->isDownloadComplete()Z

    move-result v14

    if-eqz v14, :cond_b

    .line 291
    move-object/from16 v0, p0

    invoke-direct {v0, v4, v9, v2}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->showDownloadedInfo(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 296
    :goto_6
    move-object/from16 v0, p0

    invoke-direct {v0, v12, v4}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->updateWithEditMode(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;)V

    .line 298
    return-object p2

    .line 187
    .end local v2    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .end local v4    # "holder":Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;
    .end local v7    # "networkInfo":Ljava/lang/String;
    .end local v8    # "onLoadListener":Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;
    .end local v10    # "seriesInfo":Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;
    :cond_2
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;

    .restart local v4    # "holder":Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;
    goto/16 :goto_0

    .line 218
    .restart local v5    # "loadedFromMemory":Z
    .restart local v6    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v8    # "onLoadListener":Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;
    .restart local v10    # "seriesInfo":Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;
    :cond_3
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->coverArt:Landroid/widget/ImageView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 221
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v15, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->coverArt:Landroid/widget/ImageView;

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v14, v6, v15, v0}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    goto/16 :goto_1

    .line 227
    :cond_4
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->titleText:Landroid/widget/TextView;

    invoke-interface {v13}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 230
    .end local v5    # "loadedFromMemory":Z
    .end local v6    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    :cond_5
    if-eqz v10, :cond_6

    .line 231
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->titleText:Landroid/widget/TextView;

    invoke-interface {v10}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeriesTitle()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 233
    :cond_6
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->titleText:Landroid/widget/TextView;

    invoke-interface {v13}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 253
    .restart local v11    # "seriesString":Ljava/lang/String;
    :cond_7
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->episodeNumText:Landroid/widget/TextView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_3

    .line 256
    .end local v11    # "seriesString":Ljava/lang/String;
    :cond_8
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->episodeNumText:Landroid/widget/TextView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_3

    .line 265
    :cond_9
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->networkText:Landroid/widget/TextView;

    invoke-virtual {v12}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v15

    invoke-virtual {v15}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getName()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 266
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->networkLogo:Landroid/widget/ImageView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 267
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->networkText:Landroid/widget/TextView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_4

    .line 287
    .restart local v2    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .restart local v7    # "networkInfo":Ljava/lang/String;
    :cond_a
    iget-object v14, v4, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->progressIndicator:Landroid/widget/TextView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_5

    .line 293
    :cond_b
    move-object/from16 v0, p0

    invoke-direct {v0, v4, v9}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->showInProgressInfo(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    goto/16 :goto_6
.end method

.method public onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .locals 3
    .param p1, "status"    # Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    .prologue
    .line 380
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->downloadServiceListeners:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/downloads/DownloadServiceListener;

    .line 381
    .local v0, "listener":Lcom/comcast/cim/downloads/DownloadServiceListener;, "Lcom/comcast/cim/downloads/DownloadServiceListener<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    invoke-interface {v0, p1}, Lcom/comcast/cim/downloads/DownloadServiceListener;->onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V

    goto :goto_0

    .line 383
    .end local v0    # "listener":Lcom/comcast/cim/downloads/DownloadServiceListener;, "Lcom/comcast/cim/downloads/DownloadServiceListener<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    :cond_0
    return-void
.end method

.method public onDownloadServiceConnected()V
    .locals 2

    .prologue
    .line 370
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Connected to the download Service!!!"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 371
    return-void
.end method

.method public bridge synthetic onFileDownloadError(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 45
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->onFileDownloadError(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileDownloadError(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 0
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 395
    return-void
.end method

.method public bridge synthetic onFileDownloadFinished(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 45
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->onFileDownloadFinished(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileDownloadFinished(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 0
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 405
    return-void
.end method

.method public bridge synthetic onFileDownloadStarted(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 45
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->onFileDownloadStarted(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileDownloadStarted(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 0
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 400
    return-void
.end method

.method public onFileListUpdated()V
    .locals 0

    .prologue
    .line 376
    return-void
.end method

.method public bridge synthetic onFileProgressUpdated(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 45
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->onFileProgressUpdated(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileProgressUpdated(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 3
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 387
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->downloadServiceListeners:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/downloads/DownloadServiceListener;

    .line 388
    .local v0, "listener":Lcom/comcast/cim/downloads/DownloadServiceListener;, "Lcom/comcast/cim/downloads/DownloadServiceListener<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    invoke-interface {v0, p1}, Lcom/comcast/cim/downloads/DownloadServiceListener;->onFileProgressUpdated(Lcom/comcast/cim/downloads/DownloadFile;)V

    goto :goto_0

    .line 390
    .end local v0    # "listener":Lcom/comcast/cim/downloads/DownloadServiceListener;, "Lcom/comcast/cim/downloads/DownloadServiceListener<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    :cond_0
    return-void
.end method

.method public setEditMode(Z)V
    .locals 0
    .param p1, "isEditMode"    # Z

    .prologue
    .line 118
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->isEditMode:Z

    .line 119
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->notifyDataSetChanged()V

    .line 120
    return-void
.end method

.method public setVideoBookmarks(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 110
    .local p1, "videoBookmarks":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->videoBookmarks:Ljava/util/Map;

    .line 111
    return-void
.end method

.method public setVideoEntitlement(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 0
    .param p1, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 114
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 115
    return-void
.end method
