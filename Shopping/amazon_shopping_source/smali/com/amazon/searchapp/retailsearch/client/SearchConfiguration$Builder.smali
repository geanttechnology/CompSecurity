.class public final Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;
.super Ljava/lang/Object;
.source "SearchConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private id:Ljava/lang/String;

.field private realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

.field private realms:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/SearchRealm;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 225
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    .prologue
    .line 225
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->id:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    .prologue
    .line 225
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->realms:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    .prologue
    .line 225
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    return-object v0
.end method


# virtual methods
.method public build()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;
    .locals 2

    .prologue
    .line 258
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;-><init>(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$1;)V

    return-object v0
.end method

.method public setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 235
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->id:Ljava/lang/String;

    .line 236
    return-object p0
.end method

.method public setRealms(Ljava/util/Map;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/SearchRealm;",
            ">;)",
            "Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;"
        }
    .end annotation

    .prologue
    .line 244
    .local p1, "realms":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/SearchRealm;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->realms:Ljava/util/Map;

    .line 245
    return-object p0
.end method
