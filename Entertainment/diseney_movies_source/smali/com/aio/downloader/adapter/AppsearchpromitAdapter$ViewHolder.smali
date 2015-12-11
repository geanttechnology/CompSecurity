.class Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "AppsearchpromitAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/AppsearchpromitAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field private keytv:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/adapter/AppsearchpromitAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppsearchpromitAdapter;)V
    .locals 0

    .prologue
    .line 61
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/AppsearchpromitAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;->keytv:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;->keytv:Landroid/widget/TextView;

    return-object v0
.end method
