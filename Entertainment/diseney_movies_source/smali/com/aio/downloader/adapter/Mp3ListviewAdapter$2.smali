.class Lcom/aio/downloader/adapter/Mp3ListviewAdapter$2;
.super Ljava/lang/Object;
.source "Mp3ListviewAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->downwifi()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$2;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    .line 393
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 397
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$2;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->dismiss()V

    .line 399
    return-void
.end method
