.class Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "MyAppAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/unstall/MyAppAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field icon:Landroid/widget/ImageView;

.field myapp_bt:Lcom/aio/downloader/views/LImageButton;

.field name:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

.field tv_uninstall_size:Landroid/widget/TextView;

.field tv_uninstall_version:Landroid/widget/TextView;

.field view_up:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/MyAppAdapter;)V
    .locals 0

    .prologue
    .line 290
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
