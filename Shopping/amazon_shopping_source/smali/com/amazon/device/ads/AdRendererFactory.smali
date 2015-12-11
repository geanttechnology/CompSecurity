.class Lcom/amazon/device/ads/AdRendererFactory;
.super Ljava/lang/Object;
.source "AdRendererFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdRendererFactory$1;
    }
.end annotation


# static fields
.field public static final LOG_TAG:Ljava/lang/String; = "AdRendererFactory"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected createHtmlRenderer(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/AdController;Landroid/webkit/WebView;Landroid/content/Context;)Lcom/amazon/device/ads/AdRenderer;
    .locals 1
    .param p1, "ad"    # Lcom/amazon/device/ads/AdData;
    .param p2, "controller"    # Lcom/amazon/device/ads/AdController;
    .param p3, "webView"    # Landroid/webkit/WebView;
    .param p4, "context"    # Landroid/content/Context;

    .prologue
    .line 66
    new-instance v0, Lcom/amazon/device/ads/HtmlRenderer;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/amazon/device/ads/HtmlRenderer;-><init>(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/IAdController;Landroid/webkit/WebView;Landroid/content/Context;)V

    .line 67
    .local v0, "adRenderer":Lcom/amazon/device/ads/AdRenderer;
    return-object v0
.end method

.method protected createMraidRenderer(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/AdController;Landroid/webkit/WebView;Landroid/content/Context;)Lcom/amazon/device/ads/AdRenderer;
    .locals 1
    .param p1, "ad"    # Lcom/amazon/device/ads/AdData;
    .param p2, "controller"    # Lcom/amazon/device/ads/AdController;
    .param p3, "webView"    # Landroid/webkit/WebView;
    .param p4, "context"    # Landroid/content/Context;

    .prologue
    .line 71
    new-instance v0, Lcom/amazon/device/ads/MraidRenderer;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/amazon/device/ads/MraidRenderer;-><init>(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/IAdController;Landroid/webkit/WebView;Landroid/content/Context;)V

    .line 72
    .local v0, "adRenderer":Lcom/amazon/device/ads/AdRenderer;
    return-object v0
.end method

.method public getAdRenderer(Lcom/amazon/device/ads/AdData$AAXCreative;Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/AdController;Landroid/webkit/WebView;Landroid/content/Context;)Lcom/amazon/device/ads/AdRenderer;
    .locals 3
    .param p1, "adType"    # Lcom/amazon/device/ads/AdData$AAXCreative;
    .param p2, "ad"    # Lcom/amazon/device/ads/AdData;
    .param p3, "controller"    # Lcom/amazon/device/ads/AdController;
    .param p4, "webView"    # Landroid/webkit/WebView;
    .param p5, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    const/4 v0, 0x0

    .line 31
    .local v0, "adRenderer":Lcom/amazon/device/ads/AdRenderer;
    sget-object v1, Lcom/amazon/device/ads/AdRendererFactory$1;->$SwitchMap$com$amazon$device$ads$AdData$AAXCreative:[I

    invoke-virtual {p1}, Lcom/amazon/device/ads/AdData$AAXCreative;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 44
    :goto_0
    return-object v0

    .line 34
    :pswitch_0
    invoke-virtual {p0, p2, p3, p4, p5}, Lcom/amazon/device/ads/AdRendererFactory;->createHtmlRenderer(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/AdController;Landroid/webkit/WebView;Landroid/content/Context;)Lcom/amazon/device/ads/AdRenderer;

    move-result-object v0

    .line 35
    goto :goto_0

    .line 37
    :pswitch_1
    invoke-virtual {p0, p2, p3, p4, p5}, Lcom/amazon/device/ads/AdRendererFactory;->createMraidRenderer(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/AdController;Landroid/webkit/WebView;Landroid/content/Context;)Lcom/amazon/device/ads/AdRenderer;

    move-result-object v0

    .line 38
    goto :goto_0

    .line 31
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected getAdRendererClass(Lcom/amazon/device/ads/AdData$AAXCreative;)Ljava/lang/Class;
    .locals 3
    .param p1, "adType"    # Lcom/amazon/device/ads/AdData$AAXCreative;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/device/ads/AdData$AAXCreative;",
            ")",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 49
    const/4 v0, 0x0

    .line 50
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    sget-object v1, Lcom/amazon/device/ads/AdRendererFactory$1;->$SwitchMap$com$amazon$device$ads$AdData$AAXCreative:[I

    invoke-virtual {p1}, Lcom/amazon/device/ads/AdData$AAXCreative;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 62
    :goto_0
    return-object v0

    .line 53
    :pswitch_0
    const-class v0, Lcom/amazon/device/ads/HtmlRenderer;

    .line 54
    goto :goto_0

    .line 56
    :pswitch_1
    const-class v0, Lcom/amazon/device/ads/MraidRenderer;

    .line 57
    goto :goto_0

    .line 50
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public shouldCreateNewRenderer(Lcom/amazon/device/ads/AdData$AAXCreative;Lcom/amazon/device/ads/AdRenderer;)Z
    .locals 2
    .param p1, "adType"    # Lcom/amazon/device/ads/AdData$AAXCreative;
    .param p2, "currentRenderer"    # Lcom/amazon/device/ads/AdRenderer;

    .prologue
    .line 23
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Lcom/amazon/device/ads/AdRenderer;->shouldReuse()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdRendererFactory;->getAdRendererClass(Lcom/amazon/device/ads/AdData$AAXCreative;)Ljava/lang/Class;

    move-result-object v1

    if-eq v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
