.class Lcom/aio/downloader/activity/FunGifActivity$6;
.super Ljava/lang/Object;
.source "FunGifActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunGifActivity;->initDatas()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunGifActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunGifActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunGifActivity$6;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    .line 311
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 318
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity$6;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/FunGifActivity$6;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->fullPath:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/FunGifActivity;->access$8(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/aio/downloader/activity/FunGifActivity;->getImage(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/aio/downloader/activity/FunGifActivity;->access$9(Lcom/aio/downloader/activity/FunGifActivity;Ljava/lang/String;)V

    .line 319
    return-void
.end method
