.class public final Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;
.super Ljava/lang/Object;
.source "UrlIntercepterConfigManager.java"


# static fields
.field private static sConfigManager:Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;


# instance fields
.field private mUrlHandlerList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    invoke-direct {p0}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->initUrlHandlerList()V

    .line 40
    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;
    .locals 2

    .prologue
    .line 28
    const-class v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->sConfigManager:Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;

    if-nez v0, :cond_0

    .line 29
    new-instance v0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;

    invoke-direct {v0}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;-><init>()V

    sput-object v0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->sConfigManager:Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;

    .line 31
    :cond_0
    sget-object v0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->sConfigManager:Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 28
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static init()V
    .locals 0

    .prologue
    .line 46
    invoke-static {}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->getInstance()Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;

    .line 47
    return-void
.end method

.method private initUrlHandlerList()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x3

    .line 62
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    .line 65
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/b"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 66
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/b/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 67
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/b"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 68
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/b/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 69
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/browse.html"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 70
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/browse"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 71
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/browse/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 72
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/mn/s/browse"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 73
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/mn/search/browse"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 74
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/s/browse"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 75
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/*/b"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 76
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/*/b/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 77
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->browse:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/*/s/browse"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 79
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->cart:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/cart/view.html"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 81
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->detail:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/aw/d/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    const-string/jumbo v2, "asin"

    invoke-virtual {v1, v2, v4}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->addUrlPathIndexToParseParameter(Ljava/lang/String;I)Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 82
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->detail:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/dp/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    const-string/jumbo v2, "asin"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->addUrlPathIndexToParseParameter(Ljava/lang/String;I)Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 83
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->detail:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/mobile/dp/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    const-string/jumbo v2, "asin"

    invoke-virtual {v1, v2, v4}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->addUrlPathIndexToParseParameter(Ljava/lang/String;I)Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 84
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->detail:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/mobile/udp/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    const-string/jumbo v2, "asin"

    invoke-virtual {v1, v2, v4}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->addUrlPathIndexToParseParameter(Ljava/lang/String;I)Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 85
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->detail:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/product/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    const-string/jumbo v2, "asin"

    invoke-virtual {v1, v2, v5}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->addUrlPathIndexToParseParameter(Ljava/lang/String;I)Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 86
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->detail:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/exec/obidos/ASIN/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    const-string/jumbo v2, "asin"

    invoke-virtual {v1, v2, v4}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->addUrlPathIndexToParseParameter(Ljava/lang/String;I)Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 87
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->detail:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/*/dp/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    const-string/jumbo v2, "asin"

    invoke-virtual {v1, v2, v5}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->addUrlPathIndexToParseParameter(Ljava/lang/String;I)Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 89
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->home:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/homepage.html"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 90
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->home:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/mobile/ipad-home"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 91
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->home:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/mobile/tablet-home"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 92
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->home:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/aw"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 93
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->home:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 94
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->home:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/exec/obidos/subst/home/home.html"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 96
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/s"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 97
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/s/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 98
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/*/s"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 99
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/*/s/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 100
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/s"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 101
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/search"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 102
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/aw/search/s"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 103
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/aw/s"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 104
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/aw/s/*"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 105
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/mn/s"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 106
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->search:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/mn/search"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 108
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->checkout:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/checkoutportal/enter-checkout.html"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 110
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    new-instance v1, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    sget-object v2, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->appstore:Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    const-string/jumbo v3, "*/gp/mshop/apps"

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;-><init>(Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 113
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;

    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 114
    return-void
.end method


# virtual methods
.method public declared-synchronized getUrlConfigList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 122
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->mUrlHandlerList:Ljava/util/ArrayList;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
