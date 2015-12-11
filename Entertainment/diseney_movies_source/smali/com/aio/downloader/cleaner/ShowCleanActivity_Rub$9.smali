.class Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$9;
.super Ljava/lang/Object;
.source "ShowCleanActivity_Rub.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->downwifi()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;Lcom/aio/downloader/dialog/LianwangDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$9;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    iput-object p2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$9;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    .line 491
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 495
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$9;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->dismiss()V

    .line 497
    return-void
.end method
