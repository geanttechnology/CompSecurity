.class Lcom/aio/downloader/activity/TodaysPickActivity$6;
.super Ljava/lang/Object;
.source "TodaysPickActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/TodaysPickActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/TodaysPickActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$6;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    .line 223
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 227
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity$6;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity$6;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 228
    const-class v3, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 227
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V

    .line 230
    return-void
.end method
