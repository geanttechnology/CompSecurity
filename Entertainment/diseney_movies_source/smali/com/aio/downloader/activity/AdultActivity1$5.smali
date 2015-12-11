.class Lcom/aio/downloader/activity/AdultActivity1$5;
.super Ljava/lang/Object;
.source "AdultActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AdultActivity1;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AdultActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AdultActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AdultActivity1$5;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    .line 278
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 282
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1$5;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1$5;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    .line 283
    const-class v3, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 282
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AdultActivity1;->startActivity(Landroid/content/Intent;)V

    .line 285
    return-void
.end method
