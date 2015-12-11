.class Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$2;
.super Ljava/lang/Object;
.source "CentralSSOLogoutActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->createSignOutDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$2;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 79
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 80
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$2;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->finish()V

    .line 81
    return-void
.end method
