.class public final Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;
.super Ljava/lang/Object;
.source "SearchConfigurationSet.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private configs:Ljava/util/Map;
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
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;->configs:Ljava/util/Map;

    return-object v0
.end method


# virtual methods
.method public build()Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;
    .locals 2

    .prologue
    .line 41
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;-><init>(Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$1;)V

    return-object v0
.end method

.method public setConfigurations(Ljava/util/Map;)Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;",
            ">;)",
            "Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;"
        }
    .end annotation

    .prologue
    .line 36
    .local p1, "configs":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;->configs:Ljava/util/Map;

    .line 37
    return-object p0
.end method
