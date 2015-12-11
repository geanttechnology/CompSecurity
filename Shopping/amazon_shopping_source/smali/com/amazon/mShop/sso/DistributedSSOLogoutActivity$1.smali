.class Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$1;
.super Ljava/lang/Object;
.source "DistributedSSOLogoutActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


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
    .line 73
    iput-object p1, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$1;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 76
    packed-switch p2, :pswitch_data_0

    .line 86
    :goto_0
    return-void

    .line 78
    :pswitch_0
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 79
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$1;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    # invokes: Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->logout()V
    invoke-static {v0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->access$000(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;)V

    goto :goto_0

    .line 82
    :pswitch_1
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 83
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$1;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->finish()V

    goto :goto_0

    .line 76
    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
