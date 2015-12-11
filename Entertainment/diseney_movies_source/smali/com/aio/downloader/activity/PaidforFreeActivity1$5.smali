.class Lcom/aio/downloader/activity/PaidforFreeActivity1$5;
.super Ljava/lang/Object;
.source "PaidforFreeActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/PaidforFreeActivity1;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/PaidforFreeActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$5;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    .line 279
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 283
    iget-object v0, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$5;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$5;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    .line 284
    const-class v3, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 283
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/PaidforFreeActivity1;->startActivity(Landroid/content/Intent;)V

    .line 286
    return-void
.end method
