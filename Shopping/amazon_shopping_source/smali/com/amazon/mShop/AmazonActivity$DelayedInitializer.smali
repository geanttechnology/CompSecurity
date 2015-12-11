.class public final Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;
.super Ljava/lang/Object;
.source "AmazonActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x14
    name = "DelayedInitializer"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/AmazonActivity;

.field private final view:Lcom/amazon/mShop/DelayedInitView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/DelayedInitView;Z)V
    .locals 2
    .param p2, "view"    # Lcom/amazon/mShop/DelayedInitView;
    .param p3, "delayed"    # Z

    .prologue
    .line 383
    iput-object p1, p0, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;->this$0:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 384
    iput-object p2, p0, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;->view:Lcom/amazon/mShop/DelayedInitView;

    .line 385
    if-eqz p3, :cond_0

    .line 386
    check-cast p2, Landroid/view/View;

    .end local p2    # "view":Lcom/amazon/mShop/DelayedInitView;
    invoke-virtual {p1}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$integer;->animation_default_duration:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    int-to-long v0, v0

    invoke-virtual {p2, p0, v0, v1}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 390
    :goto_0
    return-void

    .line 388
    .restart local p2    # "view":Lcom/amazon/mShop/DelayedInitView;
    :cond_0
    check-cast p2, Landroid/view/View;

    .end local p2    # "view":Lcom/amazon/mShop/DelayedInitView;
    invoke-virtual {p2, p0}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;)Lcom/amazon/mShop/DelayedInitView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;

    .prologue
    .line 379
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;->view:Lcom/amazon/mShop/DelayedInitView;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 396
    new-instance v0, Lcom/amazon/mShop/util/MShopUiOOMHandler;

    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;->this$0:Lcom/amazon/mShop/AmazonActivity;

    new-instance v2, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;

    new-instance v3, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer$1;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer$1;-><init>(Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;)V

    const/4 v4, 0x0

    invoke-direct {v2, v3, v4}, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;-><init>(Ljava/lang/Runnable;Z)V

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/util/MShopUiOOMHandler;-><init>(Landroid/app/Activity;Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;)V

    .line 403
    .local v0, "oomHandler":Lcom/amazon/mShop/util/MShopUiOOMHandler;
    invoke-virtual {v0}, Lcom/amazon/mShop/util/MShopUiOOMHandler;->execute()V

    .line 404
    return-void
.end method
