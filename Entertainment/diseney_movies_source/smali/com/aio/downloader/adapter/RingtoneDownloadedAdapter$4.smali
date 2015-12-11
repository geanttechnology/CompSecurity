.class Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$4;
.super Ljava/lang/Object;
.source "RingtoneDownloadedAdapter.java"

# interfaces
.implements Landroid/widget/PopupWindow$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->initPopuWindow1(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$4;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    .line 269
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss()V
    .locals 2

    .prologue
    .line 273
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$4;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    iget-object v1, v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    .line 274
    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 275
    .local v0, "lp":Landroid/view/WindowManager$LayoutParams;
    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->alpha:F

    .line 276
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$4;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    iget-object v1, v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 277
    return-void
.end method
