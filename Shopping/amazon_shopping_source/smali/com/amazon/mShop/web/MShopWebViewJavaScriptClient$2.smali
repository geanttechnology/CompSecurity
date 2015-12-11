.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->showAlert(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$buttonTitles:[Ljava/lang/String;

.field final synthetic val$callbackId:Ljava/lang/String;

.field final synthetic val$cancelButtonTitle:Ljava/lang/String;

.field final synthetic val$message:Ljava/lang/String;

.field final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 157
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$title:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$message:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$callbackId:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$buttonTitles:[Ljava/lang/String;

    iput-object p6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$cancelButtonTitle:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v3, 0x0

    .line 160
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v4}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v4

    invoke-direct {v1, v4}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 163
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$title:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v4, v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 164
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$title:Ljava/lang/String;

    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 167
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$message:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v4, v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 168
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$message:Ljava/lang/String;

    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 182
    :cond_1
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$buttonTitles:[Ljava/lang/String;

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 183
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$buttonTitles:[Ljava/lang/String;

    array-length v4, v4

    if-lt v4, v6, :cond_2

    .line 185
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$buttonTitles:[Ljava/lang/String;

    aget-object v4, v4, v3

    new-instance v5, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;

    invoke-direct {v5, p0, v3}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;I)V

    invoke-virtual {v1, v4, v5}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 187
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$buttonTitles:[Ljava/lang/String;

    array-length v4, v4

    const/4 v5, 0x2

    if-lt v4, v5, :cond_2

    .line 189
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$buttonTitles:[Ljava/lang/String;

    aget-object v4, v4, v6

    new-instance v5, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;

    invoke-direct {v5, p0, v6}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;I)V

    invoke-virtual {v1, v4, v5}, Landroid/app/AlertDialog$Builder;->setNeutralButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 194
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$cancelButtonTitle:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v4, v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 195
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$buttonTitles:[Ljava/lang/String;

    if-eqz v4, :cond_4

    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$buttonTitles:[Ljava/lang/String;

    array-length v2, v4

    .line 196
    .local v2, "buttonsLength":I
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;->val$cancelButtonTitle:Ljava/lang/String;

    new-instance v5, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;

    invoke-direct {v5, p0, v2}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2$1OnButtonClickListener;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;I)V

    invoke-virtual {v1, v4, v5}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 198
    .end local v2    # "buttonsLength":I
    :cond_3
    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 199
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 200
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 201
    return-void

    .end local v0    # "alert":Landroid/app/AlertDialog;
    :cond_4
    move v2, v3

    .line 195
    goto :goto_0
.end method
