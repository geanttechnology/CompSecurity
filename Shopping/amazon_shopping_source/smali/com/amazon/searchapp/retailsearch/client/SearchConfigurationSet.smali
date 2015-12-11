.class public Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;
.super Ljava/lang/Object;
.source "SearchConfigurationSet.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$1;,
        Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;
    }
.end annotation


# instance fields
.field private final configs:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;->configs:Ljava/util/Map;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;->access$000(Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;->configs:Ljava/util/Map;

    .line 16
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;
    .param p2, "x1"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$1;

    .prologue
    .line 11
    invoke-direct {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;-><init>(Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;)V

    return-void
.end method


# virtual methods
.method public getConfigurations()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;",
            ">;"
        }
    .end annotation

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;->configs:Ljava/util/Map;

    return-object v0
.end method
