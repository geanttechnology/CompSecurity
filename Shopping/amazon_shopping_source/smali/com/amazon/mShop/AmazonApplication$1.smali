.class final Lcom/amazon/mShop/AmazonApplication$1;
.super Ljava/lang/Object;
.source "AmazonApplication.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonApplication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 320
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 1
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 332
    const/4 v0, 0x1

    # invokes: Lcom/amazon/mShop/AmazonApplication;->updateCloudDriveSignInStatus(Z)V
    invoke-static {v0}, Lcom/amazon/mShop/AmazonApplication;->access$300(Z)V

    .line 333
    return-void
.end method

.method public userSignedOut()V
    .locals 1

    .prologue
    .line 327
    const/4 v0, 0x0

    # invokes: Lcom/amazon/mShop/AmazonApplication;->updateCloudDriveSignInStatus(Z)V
    invoke-static {v0}, Lcom/amazon/mShop/AmazonApplication;->access$300(Z)V

    .line 328
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 323
    return-void
.end method
