.class Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$2;
.super Ljava/lang/Object;
.source "DistributedSSOLogoutActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->createSignOutDialog(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$2;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 115
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 116
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$2;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->finish()V

    .line 117
    return-void
.end method
