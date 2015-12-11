.class final Lcom/amazon/mShop/util/DebugUtil$6;
.super Ljava/lang/Object;
.source "DebugUtil.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/DebugUtil;->handleOnReceivedHTTPAuthenticationRequest(Landroid/app/Activity;Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$dialogView:Landroid/view/View;

.field final synthetic val$handler:Landroid/webkit/HttpAuthHandler;

.field final synthetic val$host:Ljava/lang/String;

.field final synthetic val$realm:Ljava/lang/String;

.field final synthetic val$view:Landroid/webkit/WebView;


# direct methods
.method constructor <init>(Landroid/view/View;Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/HttpAuthHandler;)V
    .locals 0

    .prologue
    .line 170
    iput-object p1, p0, Lcom/amazon/mShop/util/DebugUtil$6;->val$dialogView:Landroid/view/View;

    iput-object p2, p0, Lcom/amazon/mShop/util/DebugUtil$6;->val$view:Landroid/webkit/WebView;

    iput-object p3, p0, Lcom/amazon/mShop/util/DebugUtil$6;->val$host:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/util/DebugUtil$6;->val$realm:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/mShop/util/DebugUtil$6;->val$handler:Landroid/webkit/HttpAuthHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "arg1"    # I

    .prologue
    .line 173
    iget-object v2, p0, Lcom/amazon/mShop/util/DebugUtil$6;->val$dialogView:Landroid/view/View;

    sget v3, Lcom/amazon/mShop/android/lib/R$id;->http_username:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 174
    .local v1, "username":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/util/DebugUtil$6;->val$dialogView:Landroid/view/View;

    sget v3, Lcom/amazon/mShop/android/lib/R$id;->http_password:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 175
    .local v0, "password":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 176
    iget-object v2, p0, Lcom/amazon/mShop/util/DebugUtil$6;->val$view:Landroid/webkit/WebView;

    iget-object v3, p0, Lcom/amazon/mShop/util/DebugUtil$6;->val$host:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/mShop/util/DebugUtil$6;->val$realm:Ljava/lang/String;

    invoke-virtual {v2, v3, v4, v1, v0}, Landroid/webkit/WebView;->setHttpAuthUsernamePassword(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 177
    iget-object v2, p0, Lcom/amazon/mShop/util/DebugUtil$6;->val$handler:Landroid/webkit/HttpAuthHandler;

    invoke-virtual {v2, v1, v0}, Landroid/webkit/HttpAuthHandler;->proceed(Ljava/lang/String;Ljava/lang/String;)V

    .line 179
    :cond_0
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 180
    return-void
.end method
