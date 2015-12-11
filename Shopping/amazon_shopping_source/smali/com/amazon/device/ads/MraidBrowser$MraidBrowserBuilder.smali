.class Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;
.super Ljava/lang/Object;
.source "MraidBrowser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidBrowser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MraidBrowserBuilder"
.end annotation


# static fields
.field private static final LOGTAG:Ljava/lang/String;


# instance fields
.field private context:Landroid/content/Context;

.field private showOpenExternalBrowserButton:Z

.field private url:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 455
    const-class v0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->LOGTAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 453
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method show()V
    .locals 6

    .prologue
    .line 499
    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->context:Landroid/content/Context;

    if-nez v1, :cond_0

    .line 501
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Context must not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 503
    :cond_0
    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->url:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 505
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Url must not be null or white space"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 508
    :cond_1
    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/Assets;->ensureAssetsCreated()Z

    move-result v1

    if-nez v1, :cond_2

    .line 510
    sget-object v1, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->LOGTAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not load application assets, failed to open URI: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->url:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 520
    :goto_0
    return-void

    .line 514
    :cond_2
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->context:Landroid/content/Context;

    const-class v2, Lcom/amazon/device/ads/AdActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 515
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "adapter"

    const-class v2, Lcom/amazon/device/ads/MraidBrowser;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 516
    const-string/jumbo v1, "extra_url"

    iget-object v2, p0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->url:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 517
    const-string/jumbo v1, "extra_open_btn"

    iget-boolean v2, p0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->showOpenExternalBrowserButton:Z

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 518
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 519
    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method withContext(Landroid/content/Context;)Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 468
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->context:Landroid/content/Context;

    .line 469
    return-object p0
.end method

.method withExternalBrowserButton()Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;
    .locals 1

    .prologue
    .line 489
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->showOpenExternalBrowserButton:Z

    .line 490
    return-object p0
.end method

.method withUrl(Ljava/lang/String;)Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 479
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;->url:Ljava/lang/String;

    .line 480
    return-object p0
.end method
