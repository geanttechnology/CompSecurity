.class Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity$2;
.super Ljava/lang/Object;
.source "CloudDriveUploadActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->showNetworkErrorView()V
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
    .line 80
    iput-object p1, p0, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity$2;->this$0:Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity$2;->this$0:Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;

    # invokes: Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->initActivity()V
    invoke-static {v0}, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;->access$000(Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;)V

    .line 85
    return-void
.end method
