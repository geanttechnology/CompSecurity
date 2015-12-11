.class public Lcom/amazon/mShop/util/MShopUiOOMHandler;
.super Ljava/lang/Object;
.source "MShopUiOOMHandler.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;
    }
.end annotation


# instance fields
.field private mActivityWeakReference:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field private mUiRunnable:Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "uiRunnable"    # Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/amazon/mShop/util/MShopUiOOMHandler;->mActivityWeakReference:Ljava/lang/ref/WeakReference;

    .line 32
    iput-object p2, p0, Lcom/amazon/mShop/util/MShopUiOOMHandler;->mUiRunnable:Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;

    .line 33
    return-void
.end method


# virtual methods
.method public execute()V
    .locals 2

    .prologue
    .line 36
    iget-object v1, p0, Lcom/amazon/mShop/util/MShopUiOOMHandler;->mActivityWeakReference:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    .line 37
    .local v0, "activity":Landroid/app/Activity;
    if-eqz v0, :cond_0

    .line 38
    iget-object v1, p0, Lcom/amazon/mShop/util/MShopUiOOMHandler;->mUiRunnable:Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 40
    :cond_0
    return-void
.end method
