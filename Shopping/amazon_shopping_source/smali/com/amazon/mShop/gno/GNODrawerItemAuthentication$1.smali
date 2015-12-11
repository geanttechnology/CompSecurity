.class Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;
.super Ljava/lang/Object;
.source "GNODrawerItemAuthentication.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;

.field final synthetic val$callingActivity:Lcom/amazon/mShop/AmazonActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;->val$callingActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 184
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;

    # getter for: Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->access$100(Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;)I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_signin:I

    if-ne v0, v1, :cond_1

    .line 185
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;->val$callingActivity:Lcom/amazon/mShop/AmazonActivity;

    const-string/jumbo v1, "gno"

    const/4 v4, 0x0

    new-array v3, v3, [I

    invoke-static {v0, v1, v2, v4, v3}, Lcom/amazon/mShop/util/ActivityUtils;->startLoginActivity(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;[I)Z

    .line 193
    :cond_0
    :goto_0
    return-void

    .line 186
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;

    # getter for: Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->access$100(Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;)I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_signout:I

    if-ne v0, v1, :cond_2

    .line 187
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;->val$callingActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startLogoutActivity(Landroid/content/Context;)Z

    goto :goto_0

    .line 188
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;

    # getter for: Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->access$100(Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;)I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_sso_signin:I

    if-ne v0, v1, :cond_3

    .line 189
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;->val$callingActivity:Lcom/amazon/mShop/AmazonActivity;

    const-string/jumbo v5, "gno"

    move v4, v3

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/sso/IdentityType;->handleSSOLogin(Landroid/app/Activity;ZZZLjava/lang/String;)V

    goto :goto_0

    .line 190
    :cond_3
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;

    # getter for: Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->access$100(Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;)I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_sso_signout:I

    if-ne v0, v1, :cond_0

    .line 191
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;->val$callingActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/sso/IdentityType;->handleSSOLogout(Lcom/amazon/mShop/AmazonActivity;)V

    goto :goto_0
.end method
