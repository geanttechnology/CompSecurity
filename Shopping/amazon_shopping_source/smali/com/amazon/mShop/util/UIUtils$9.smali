.class final Lcom/amazon/mShop/util/UIUtils$9;
.super Ljava/lang/Object;
.source "UIUtils.java"

# interfaces
.implements Lcom/amazon/mShop/util/UIUtils$WebViewURLSpanFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/UIUtils;->setHyperTexts(Landroid/widget/TextView;Lcom/amazon/mShop/AmazonActivity;Ljava/util/List;Ljava/util/List;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$activity:Lcom/amazon/mShop/AmazonActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 837
    iput-object p1, p0, Lcom/amazon/mShop/util/UIUtils$9;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getURLSpan(Ljava/lang/String;Ljava/lang/String;)Landroid/text/style/URLSpan;
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    .line 840
    new-instance v0, Lcom/amazon/mShop/util/UIUtils$WebViewURLSpan;

    iget-object v1, p0, Lcom/amazon/mShop/util/UIUtils$9;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v0, v1, p1, p2}, Lcom/amazon/mShop/util/UIUtils$WebViewURLSpan;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method
