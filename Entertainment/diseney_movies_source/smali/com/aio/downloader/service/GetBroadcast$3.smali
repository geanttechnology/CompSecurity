.class Lcom/aio/downloader/service/GetBroadcast$3;
.super Ljava/lang/Object;
.source "GetBroadcast.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/GetBroadcast;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/GetBroadcast;

.field private final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/GetBroadcast;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/GetBroadcast$3;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    iput-object p2, p0, Lcom/aio/downloader/service/GetBroadcast$3;->val$context:Landroid/content/Context;

    .line 272
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 277
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$3;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->anzhuangDialog:Lcom/aio/downloader/dialog/AnzhuangDialog;
    invoke-static {v4}, Lcom/aio/downloader/service/GetBroadcast;->access$0(Lcom/aio/downloader/service/GetBroadcast;)Lcom/aio/downloader/dialog/AnzhuangDialog;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/AnzhuangDialog;->show()V

    .line 278
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$3;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->anzhuangDialog:Lcom/aio/downloader/dialog/AnzhuangDialog;
    invoke-static {v4}, Lcom/aio/downloader/service/GetBroadcast;->access$0(Lcom/aio/downloader/service/GetBroadcast;)Lcom/aio/downloader/dialog/AnzhuangDialog;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/AnzhuangDialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 280
    .local v0, "dialogWindow":Landroid/view/Window;
    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v1

    .line 281
    .local v1, "lp":Landroid/view/WindowManager$LayoutParams;
    const/16 v4, 0x50

    invoke-virtual {v0, v4}, Landroid/view/Window;->setGravity(I)V

    .line 282
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$3;->val$context:Landroid/content/Context;

    .line 283
    const-string v5, "window"

    invoke-virtual {v4, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    .line 282
    check-cast v3, Landroid/view/WindowManager;

    .line 285
    .local v3, "wm":Landroid/view/WindowManager;
    invoke-interface {v3}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/Display;->getWidth()I

    move-result v2

    .line 288
    .local v2, "width":I
    iput v2, v1, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 294
    invoke-virtual {v0, v1}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 295
    return-void
.end method
