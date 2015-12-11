.class Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$1;
.super Ljava/lang/Object;
.source "CentralSSOLogoutActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


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
    .line 44
    iput-object p1, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 47
    packed-switch p2, :pswitch_data_0

    .line 57
    :goto_0
    return-void

    .line 49
    :pswitch_0
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 50
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    # invokes: Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->logout()V
    invoke-static {v0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->access$000(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;)V

    goto :goto_0

    .line 53
    :pswitch_1
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 54
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$1;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->finish()V

    goto :goto_0

    .line 47
    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
