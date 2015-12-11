.class final Lcom/amazon/mShop/util/DebugUtil$3;
.super Landroid/webkit/WebViewClient;
.source "DebugUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/DebugUtil;->requestNewWeblabAssignment(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$subscriber:Lcom/amazon/mShop/feature/FeatureStateSubscriber;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/feature/FeatureStateSubscriber;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/amazon/mShop/util/DebugUtil$3;->val$subscriber:Lcom/amazon/mShop/feature/FeatureStateSubscriber;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 112
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/util/DebugUtil$3;->val$subscriber:Lcom/amazon/mShop/feature/FeatureStateSubscriber;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/feature/Features;->addFeatureStateSubscriber(Lcom/amazon/mShop/feature/FeatureStateSubscriber;)V

    .line 114
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/feature/Features;->fetchFeatureStates(Z)V

    .line 115
    return-void
.end method
