.class Lcom/aio/downloader/activity/AnzhuangActivity$3;
.super Ljava/lang/Thread;
.source "AnzhuangActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AnzhuangActivity;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AnzhuangActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AnzhuangActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AnzhuangActivity$3;->this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

    .line 203
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 208
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 209
    const-string v0, "http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=install_click"

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 211
    return-void
.end method
