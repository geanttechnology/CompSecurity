.class Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity$1;
.super Ljava/lang/Object;
.source "CloudDriveUploadActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->initActivity()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity$1;->this$0:Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 60
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity$1;->this$0:Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/sso/IdentityType;->handleSSOLogin(Landroid/app/Activity;)V

    .line 61
    return-void
.end method
