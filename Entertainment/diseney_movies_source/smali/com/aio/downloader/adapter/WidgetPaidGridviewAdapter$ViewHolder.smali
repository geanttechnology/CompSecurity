.class Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "WidgetPaidGridviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field private gvimg:Landroid/widget/ImageView;

.field private gvtitle:Landroid/widget/TextView;

.field private gvtitlepaid:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)V
    .locals 0

    .prologue
    .line 577
    iput-object p1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 578
    iput-object p1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;->gvimg:Landroid/widget/ImageView;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 579
    iput-object p1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;->gvtitle:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 580
    iput-object p1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;->gvtitlepaid:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 579
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;->gvtitle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 578
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;->gvimg:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 580
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$ViewHolder;->gvtitlepaid:Landroid/widget/TextView;

    return-object v0
.end method
