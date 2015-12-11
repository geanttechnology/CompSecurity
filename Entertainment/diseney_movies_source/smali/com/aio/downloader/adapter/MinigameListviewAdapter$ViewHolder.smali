.class Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "MinigameListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/MinigameListviewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field private minigame_ratingbar:Landroid/widget/RatingBar;

.field private minigamehints:Landroid/widget/TextView;

.field private minigameicon:Landroid/widget/ImageView;

.field private minigameplaybt:Landroid/widget/Button;

.field private minigametitle:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/adapter/MinigameListviewAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/MinigameListviewAdapter;)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 132
    iput-object p1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigameicon:Landroid/widget/ImageView;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 133
    iput-object p1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigametitle:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 136
    iput-object p1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigamehints:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;Landroid/widget/RatingBar;)V
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigame_ratingbar:Landroid/widget/RatingBar;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;Landroid/widget/Button;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigameplaybt:Landroid/widget/Button;

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigametitle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigamehints:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigameicon:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;)Landroid/widget/RatingBar;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigame_ratingbar:Landroid/widget/RatingBar;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigameplaybt:Landroid/widget/Button;

    return-object v0
.end method
