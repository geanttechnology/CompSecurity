.class Lcom/amazon/mShop/startup/UserAgreementActivity$3;
.super Ljava/lang/Object;
.source "UserAgreementActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


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
    .line 90
    iput-object p1, p0, Lcom/amazon/mShop/startup/UserAgreementActivity$3;->this$0:Lcom/amazon/mShop/startup/UserAgreementActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/mShop/startup/UserAgreementActivity$3;->this$0:Lcom/amazon/mShop/startup/UserAgreementActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/startup/UserAgreementActivity;->finishIfNotFinishing()V

    .line 94
    return-void
.end method
