.class Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;
.super Ljava/lang/Object;
.source "Move2SDAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/unstall/Move2SDAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHold"
.end annotation


# instance fields
.field icon:Landroid/widget/ImageView;

.field name:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/unstall/Move2SDAdapter;

.field tv_uninstall:Landroid/widget/TextView;

.field tv_uninstall_size:Landroid/widget/TextView;

.field tv_uninstall_version:Landroid/widget/TextView;

.field view_up:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/Move2SDAdapter;)V
    .locals 0

    .prologue
    .line 145
    iput-object p1, p0, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->this$0:Lcom/aio/downloader/unstall/Move2SDAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
