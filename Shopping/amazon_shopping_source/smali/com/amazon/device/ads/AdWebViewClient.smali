.class Lcom/amazon/device/ads/AdWebViewClient;
.super Landroid/webkit/WebViewClient;
.source "AdWebViewClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdWebViewClient$DefaultExecutor;,
        Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;,
        Lcom/amazon/device/ads/AdWebViewClient$IntentExecutor;,
        Lcom/amazon/device/ads/AdWebViewClient$MopubExecutor;,
        Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;
    }
.end annotation


# static fields
.field public static final AMAZON_MOBILE:Ljava/lang/String; = "amazonmobile"

.field public static final GEO:Ljava/lang/String; = "geo"

.field public static final GOOGLE_STREETVIEW:Ljava/lang/String; = "google.streetview"

.field private static final LOG_TAG:Ljava/lang/String;

.field public static final MAILTO:Ljava/lang/String; = "mailto"

.field public static final MOPUB:Ljava/lang/String; = "mopub"

.field public static final MRAID:Ljava/lang/String; = "mraid"

.field public static final SMS:Ljava/lang/String; = "sms"

.field public static final TELEPHONE:Ljava/lang/String; = "tel"

.field public static final VOICEMAIL:Ljava/lang/String; = "voicemail"

.field protected static final intentSchemes:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected static redirectHosts:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final adView:Lcom/amazon/device/ads/AdView;

.field private final context:Landroid/content/Context;

.field private final urlExecutors:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 28
    const-class v0, Lcom/amazon/device/ads/AdWebViewClient;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/AdWebViewClient;->LOG_TAG:Ljava/lang/String;

    .line 44
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/AdWebViewClient;->intentSchemes:Ljava/util/HashSet;

    .line 45
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->intentSchemes:Ljava/util/HashSet;

    const-string/jumbo v1, "tel"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 46
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->intentSchemes:Ljava/util/HashSet;

    const-string/jumbo v1, "voicemail"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 47
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->intentSchemes:Ljava/util/HashSet;

    const-string/jumbo v1, "sms"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 48
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->intentSchemes:Ljava/util/HashSet;

    const-string/jumbo v1, "mailto"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 49
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->intentSchemes:Ljava/util/HashSet;

    const-string/jumbo v1, "geo"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 50
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->intentSchemes:Ljava/util/HashSet;

    const-string/jumbo v1, "google.streetview"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 60
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/AdWebViewClient;->redirectHosts:Ljava/util/Set;

    .line 61
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->redirectHosts:Ljava/util/Set;

    const-string/jumbo v1, "aax-us-east.amazon-adsystem.com"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 62
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->redirectHosts:Ljava/util/Set;

    const-string/jumbo v1, "aax-us-east.amazon-adsystem.com"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 63
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->redirectHosts:Ljava/util/Set;

    const-string/jumbo v1, "aax-beta.integ.amazon.com"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 64
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->redirectHosts:Ljava/util/Set;

    const-string/jumbo v1, "pda-bes.amazon.com"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 65
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->redirectHosts:Ljava/util/Set;

    const-string/jumbo v1, "d16g-cornerstone-bes.integ.amazon.com"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 66
    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/ads/AdView;Landroid/content/Context;)V
    .locals 1
    .param p1, "adView"    # Lcom/amazon/device/ads/AdView;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 75
    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    .line 76
    iput-object p2, p0, Lcom/amazon/device/ads/AdWebViewClient;->context:Landroid/content/Context;

    .line 77
    iput-object p1, p0, Lcom/amazon/device/ads/AdWebViewClient;->adView:Lcom/amazon/device/ads/AdView;

    .line 78
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/AdWebViewClient;->urlExecutors:Ljava/util/HashMap;

    .line 79
    invoke-direct {p0}, Lcom/amazon/device/ads/AdWebViewClient;->setupUrlExecutors()V

    .line 80
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/AdWebViewClient;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdWebViewClient;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/device/ads/AdWebViewClient;->context:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/device/ads/AdWebViewClient;)Lcom/amazon/device/ads/AdView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdWebViewClient;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/device/ads/AdWebViewClient;->adView:Lcom/amazon/device/ads/AdView;

    return-object v0
.end method

.method private static isHoneycombVersion()Z
    .locals 2

    .prologue
    .line 193
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xd

    if-gt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setupUrlExecutors()V
    .locals 8

    .prologue
    .line 84
    iget-object v3, p0, Lcom/amazon/device/ads/AdWebViewClient;->urlExecutors:Ljava/util/HashMap;

    const-string/jumbo v4, "mopub"

    new-instance v5, Lcom/amazon/device/ads/AdWebViewClient$MopubExecutor;

    invoke-direct {v5, p0}, Lcom/amazon/device/ads/AdWebViewClient$MopubExecutor;-><init>(Lcom/amazon/device/ads/AdWebViewClient;)V

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    iget-object v3, p0, Lcom/amazon/device/ads/AdWebViewClient;->urlExecutors:Ljava/util/HashMap;

    const-string/jumbo v4, "amazonmobile"

    new-instance v5, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;

    iget-object v6, p0, Lcom/amazon/device/ads/AdWebViewClient;->adView:Lcom/amazon/device/ads/AdView;

    iget-object v7, p0, Lcom/amazon/device/ads/AdWebViewClient;->context:Landroid/content/Context;

    invoke-direct {v5, v6, v7}, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;-><init>(Lcom/amazon/device/ads/AdView;Landroid/content/Context;)V

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    new-instance v1, Lcom/amazon/device/ads/AdWebViewClient$IntentExecutor;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/AdWebViewClient$IntentExecutor;-><init>(Lcom/amazon/device/ads/AdWebViewClient;)V

    .line 87
    .local v1, "intentExecutor":Lcom/amazon/device/ads/AdWebViewClient$IntentExecutor;
    sget-object v3, Lcom/amazon/device/ads/AdWebViewClient;->intentSchemes:Ljava/util/HashSet;

    invoke-virtual {v3}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 89
    .local v2, "scheme":Ljava/lang/String;
    invoke-virtual {p0, v2, v1}, Lcom/amazon/device/ads/AdWebViewClient;->putUrlExecutor(Ljava/lang/String;Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;)V

    goto :goto_0

    .line 91
    .end local v2    # "scheme":Ljava/lang/String;
    :cond_0
    return-void
.end method


# virtual methods
.method protected getScheme(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 146
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 147
    .local v0, "uri":Landroid/net/Uri;
    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method protected interpretScheme(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 4
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "scheme"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 158
    if-eqz p2, :cond_0

    .line 160
    iget-object v1, p0, Lcom/amazon/device/ads/AdWebViewClient;->urlExecutors:Ljava/util/HashMap;

    invoke-virtual {v1, p2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 162
    iget-object v0, p0, Lcom/amazon/device/ads/AdWebViewClient;->urlExecutors:Ljava/util/HashMap;

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;

    invoke-interface {v0, p1}, Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;->execute(Ljava/lang/String;)Z

    move-result v0

    .line 170
    :cond_0
    :goto_0
    return v0

    .line 166
    :cond_1
    sget-object v1, Lcom/amazon/device/ads/AdWebViewClient;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "Scheme %s unrecognized. Launching external browser."

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p2, v3, v0

    invoke-static {v1, v2, v3}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 167
    iget-object v0, p0, Lcom/amazon/device/ads/AdWebViewClient;->adView:Lcom/amazon/device/ads/AdView;

    invoke-interface {v0, p1}, Lcom/amazon/device/ads/AdView;->launchExternalBrowserForLink(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method

.method public onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 188
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Loaded resource: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p2, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 189
    return-void
.end method

.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 176
    iget-object v0, p0, Lcom/amazon/device/ads/AdWebViewClient;->adView:Lcom/amazon/device/ads/AdView;

    if-nez v0, :cond_0

    .line 178
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Call to onPageFinished() ignored because view is null."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 183
    :goto_0
    return-void

    .line 182
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/AdWebViewClient;->adView:Lcom/amazon/device/ads/AdView;

    invoke-interface {v0}, Lcom/amazon/device/ads/AdView;->onPageFinished()V

    goto :goto_0
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 106
    sget-object v0, Lcom/amazon/device/ads/AdWebViewClient;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Error: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p3, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 107
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V

    .line 108
    return-void
.end method

.method public putUrlExecutor(Ljava/lang/String;Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;)V
    .locals 1
    .param p1, "scheme"    # Ljava/lang/String;
    .param p2, "executor"    # Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/device/ads/AdWebViewClient;->urlExecutors:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    return-void
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 5
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 113
    iget-object v3, p0, Lcom/amazon/device/ads/AdWebViewClient;->adView:Lcom/amazon/device/ads/AdView;

    if-nez v3, :cond_1

    .line 115
    const/4 v0, 0x0

    .line 136
    :cond_0
    :goto_0
    return v0

    .line 118
    :cond_1
    iget-object v3, p0, Lcom/amazon/device/ads/AdWebViewClient;->adView:Lcom/amazon/device/ads/AdView;

    invoke-interface {v3}, Lcom/amazon/device/ads/AdView;->isAdViewRenderable()Z

    move-result v3

    if-nez v3, :cond_2

    move v0, v2

    .line 120
    goto :goto_0

    .line 123
    :cond_2
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 124
    .local v1, "uri":Landroid/net/Uri;
    const/4 v0, 0x1

    .line 125
    .local v0, "ret":Z
    sget-object v3, Lcom/amazon/device/ads/AdWebViewClient;->redirectHosts:Ljava/util/Set;

    invoke-virtual {v1}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-static {}, Lcom/amazon/device/ads/AdWebViewClient;->isHoneycombVersion()Z

    move-result v3

    if-nez v3, :cond_3

    .line 129
    const/4 v0, 0x0

    .line 131
    :cond_3
    invoke-virtual {p0, p2}, Lcom/amazon/device/ads/AdWebViewClient;->getScheme(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, p2, v3}, Lcom/amazon/device/ads/AdWebViewClient;->interpretScheme(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    move v0, v2

    .line 133
    goto :goto_0
.end method
