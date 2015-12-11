.class Lcom/aio/downloader/unstall/BackupAdapter$ViewHold;
.super Ljava/lang/Object;
.source "BackupAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/unstall/BackupAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHold"
.end annotation


# instance fields
.field icon:Landroid/widget/ImageView;

.field name:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/unstall/BackupAdapter;

.field tv_uninstall:Landroid/widget/TextView;

.field tv_uninstall_size:Landroid/widget/TextView;

.field tv_uninstall_version:Landroid/widget/TextView;

.field view_up:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/BackupAdapter;)V
    .locals 0

    .prologue
    .line 208
    iput-object p1, p0, Lcom/aio/downloader/unstall/BackupAdapter$ViewHold;->this$0:Lcom/aio/downloader/unstall/BackupAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
