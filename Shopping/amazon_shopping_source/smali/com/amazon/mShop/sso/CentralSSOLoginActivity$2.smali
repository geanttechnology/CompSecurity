.class final Lcom/amazon/mShop/sso/CentralSSOLoginActivity$2;
.super Ljava/lang/Object;
.source "CentralSSOLoginActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->showErrorToast(Landroid/content/Context;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$errorCode:I

.field final synthetic val$errorMessageId:I


# direct methods
.method constructor <init>(ILandroid/content/Context;I)V
    .locals 0

    .prologue
    .line 182
    iput p1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$2;->val$errorCode:I

    iput-object p2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$2;->val$context:Landroid/content/Context;

    iput p3, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$2;->val$errorMessageId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 185
    new-instance v1, Lcom/amazon/mShop/net/ServiceCallIdentifier;

    const-string/jumbo v2, "MobileAuthenticationPlatform"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "centralSSOError_"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$2;->val$errorCode:I

    invoke-static {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->fromValue(I)Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazon/mShop/net/ServiceCallIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 186
    .local v1, "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    invoke-static {v1}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v0

    .line 187
    .local v0, "callObserver":Lcom/amazon/mShop/net/CallObserver;
    invoke-virtual {v0}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V

    .line 188
    iget-object v2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$2;->val$context:Landroid/content/Context;

    iget v3, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$2;->val$errorMessageId:I

    const/4 v4, 0x1

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 189
    return-void
.end method
