.class public Lcom/amazon/mShop/search/viewit/ViewItTutorialView1;
.super Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;
.source "ViewItTutorialView1.java"

# interfaces
.implements Lcom/amazon/mShop/DelayedInitView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 12
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;-><init>(Landroid/content/Context;)V

    .line 13
    return-void
.end method


# virtual methods
.method public onPushViewCompleted()V
    .locals 0

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView1;->updateContentView()V

    .line 18
    return-void
.end method

.method public updateContentView()V
    .locals 4

    .prologue
    .line 22
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->updateContentView()V

    .line 25
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialView1$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView1$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialView1;)V

    const-wide/16 v2, 0x12c

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 31
    return-void
.end method
