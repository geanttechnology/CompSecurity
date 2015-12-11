.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->showChooser(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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

.field final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$title:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$buttonTitles:[Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$callbackId:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$cancelButtonTitle:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/4 v5, 0x0

    .line 101
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v6}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v6

    invoke-direct {v1, v6}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 104
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$title:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v6, v7}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 105
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$title:Ljava/lang/String;

    invoke-virtual {v1, v6}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 109
    :cond_0
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$buttonTitles:[Ljava/lang/String;

    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 112
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$buttonTitles:[Ljava/lang/String;

    array-length v6, v6

    new-array v3, v6, [Ljava/lang/String;

    .line 113
    .local v3, "decodedStr":[Ljava/lang/String;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$buttonTitles:[Ljava/lang/String;

    array-length v6, v6

    if-ge v4, v6, :cond_1

    .line 114
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$buttonTitles:[Ljava/lang/String;

    aget-object v6, v6, v4

    invoke-static {v6}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v4

    .line 113
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 116
    :cond_1
    new-instance v6, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1$1;

    invoke-direct {v6, p0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1$1;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;)V

    invoke-virtual {v1, v3, v6}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 125
    .end local v3    # "decodedStr":[Ljava/lang/String;
    .end local v4    # "i":I
    :cond_2
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$cancelButtonTitle:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v6, v7}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 127
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$buttonTitles:[Ljava/lang/String;

    if-eqz v6, :cond_4

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$buttonTitles:[Ljava/lang/String;

    array-length v2, v6

    .line 128
    .local v2, "buttonsLength":I
    :goto_1
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;->val$cancelButtonTitle:Ljava/lang/String;

    new-instance v7, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1$2;

    invoke-direct {v7, p0, v2}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1$2;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;I)V

    invoke-virtual {v1, v6, v7}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 137
    .end local v2    # "buttonsLength":I
    :cond_3
    invoke-virtual {v1, v5}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 138
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 139
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 140
    return-void

    .end local v0    # "alert":Landroid/app/AlertDialog;
    :cond_4
    move v2, v5

    .line 127
    goto :goto_1
.end method
