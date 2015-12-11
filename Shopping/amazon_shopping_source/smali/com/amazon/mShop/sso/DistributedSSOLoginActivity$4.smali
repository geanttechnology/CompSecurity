.class Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$4;
.super Ljava/lang/Object;
.source "DistributedSSOLoginActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->notifyUserSignin(Lcom/amazon/mShop/model/auth/User;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

.field final synthetic val$user:Lcom/amazon/mShop/model/auth/User;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;Lcom/amazon/mShop/model/auth/User;)V
    .locals 0

    .prologue
    .line 417
    iput-object p1, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$4;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    iput-object p2, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$4;->val$user:Lcom/amazon/mShop/model/auth/User;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 421
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$4;->val$user:Lcom/amazon/mShop/model/auth/User;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->userSignedIn(Lcom/amazon/mShop/model/auth/User;)V

    .line 422
    return-void
.end method
