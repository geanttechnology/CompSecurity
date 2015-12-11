.class Lcom/amazon/mShop/startup/UserAgreementActivity$2;
.super Ljava/lang/Object;
.source "UserAgreementActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/startup/UserAgreementActivity;->showUserAgreement(Landroid/app/Activity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/startup/UserAgreementActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/UserAgreementActivity;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/mShop/startup/UserAgreementActivity$2;->this$0:Lcom/amazon/mShop/startup/UserAgreementActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 78
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 79
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->exitApp()V

    .line 80
    iget-object v0, p0, Lcom/amazon/mShop/startup/UserAgreementActivity$2;->this$0:Lcom/amazon/mShop/startup/UserAgreementActivity;

    const-string/jumbo v1, "taskResultFail"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/startup/UserAgreementActivity;->endStartupTask(Ljava/lang/String;)V

    .line 81
    return-void
.end method
