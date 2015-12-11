.class Lcom/aio/downloader/activity/MiniGamePlayActivity$2;
.super Ljava/lang/Object;
.source "MiniGamePlayActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MiniGamePlayActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MiniGamePlayActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity$2;->this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;

    .line 136
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 139
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity$2;->this$0:Lcom/aio/downloader/activity/MiniGamePlayActivity;

    # getter for: Lcom/aio/downloader/activity/MiniGamePlayActivity;->gameplaywebview:Landroid/webkit/WebView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->access$2(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->reload()V

    .line 140
    return-void
.end method
