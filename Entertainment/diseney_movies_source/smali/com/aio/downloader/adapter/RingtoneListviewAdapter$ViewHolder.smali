.class Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "RingtoneListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field private list_bg:Landroid/widget/RelativeLayout;

.field private ringtone_download_bt:Landroid/widget/Button;

.field private ringtone_ratingbar:Landroid/widget/RatingBar;

.field private ringtonecat:Landroid/widget/TextView;

.field private ringtonetitle:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)V
    .locals 0

    .prologue
    .line 345
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 347
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtonetitle:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 348
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtonecat:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;Landroid/widget/RatingBar;)V
    .locals 0

    .prologue
    .line 349
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtone_ratingbar:Landroid/widget/RatingBar;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;Landroid/widget/Button;)V
    .locals 0

    .prologue
    .line 350
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtone_download_bt:Landroid/widget/Button;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;Landroid/widget/RelativeLayout;)V
    .locals 0

    .prologue
    .line 351
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->list_bg:Landroid/widget/RelativeLayout;

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 351
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->list_bg:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 347
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtonetitle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 348
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtonecat:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;)Landroid/widget/RatingBar;
    .locals 1

    .prologue
    .line 349
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtone_ratingbar:Landroid/widget/RatingBar;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 350
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtone_download_bt:Landroid/widget/Button;

    return-object v0
.end method
