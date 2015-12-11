.class public Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;
.super Ljava/lang/Object;
.source "SearchConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$1;,
        Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;
    }
.end annotation


# instance fields
.field private final id:Ljava/lang/String;

.field private volatile realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

.field private final realms:Ljava/util/Map;
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
.method private constructor <init>(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->id:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->access$000(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->id:Ljava/lang/String;

    .line 34
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->realms:Ljava/util/Map;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->access$100(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->realms:Ljava/util/Map;

    .line 35
    # getter for: Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    invoke-static {p1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->access$200(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    .line 36
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;
    .param p2, "x1"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$1;

    .prologue
    .line 14
    invoke-direct {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;-><init>(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;)V

    return-void
.end method

.method public static getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;
    .locals 1

    .prologue
    .line 216
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->getInstance()Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getDefaultRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    .locals 1

    .prologue
    .line 119
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealmForLocale(Ljava/util/Locale;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v0

    return-object v0
.end method

.method public getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    .locals 1

    .prologue
    .line 58
    monitor-enter p0

    .line 59
    :try_start_0
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    monitor-exit p0

    .line 65
    :goto_0
    return-object v0

    .line 63
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getDefaultRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    .line 65
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    monitor-exit p0

    goto :goto_0

    .line 66
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getRealmById(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    .locals 1
    .param p1, "realmId"    # Ljava/lang/String;

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->realms:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    return-object v0
.end method

.method public getRealmForLocale(Ljava/util/Locale;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    .locals 8
    .param p1, "locale"    # Ljava/util/Locale;

    .prologue
    .line 129
    const/4 v4, 0x0

    .line 131
    .local v4, "searchRealm":Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    if-nez p1, :cond_0

    .line 132
    const-string/jumbo v6, "us"

    invoke-virtual {p0, v6}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealmById(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v6

    .line 163
    :goto_0
    return-object v6

    .line 135
    :cond_0
    const/4 v2, -0x1

    .line 137
    .local v2, "maxScore":I
    iget-object v6, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->realms:Ljava/util/Map;

    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 138
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/SearchRealm;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    .line 139
    .local v5, "sr":Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    const/4 v3, 0x0

    .line 141
    .local v3, "score":I
    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getLocale()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_2

    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getLocale()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 142
    add-int/lit8 v3, v3, 0x8

    .line 145
    :cond_2
    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getCountry()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_3

    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getCountry()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 146
    add-int/lit8 v3, v3, 0x4

    .line 149
    :cond_3
    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getLanguage()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_4

    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getLanguage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 150
    add-int/lit8 v3, v3, 0x2

    .line 153
    :cond_4
    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getVariant()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_5

    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getVariant()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Ljava/util/Locale;->getVariant()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 154
    add-int/lit8 v3, v3, 0x1

    .line 157
    :cond_5
    const/4 v6, 0x1

    if-le v3, v6, :cond_1

    if-le v3, v2, :cond_1

    .line 158
    move-object v4, v5

    .line 159
    move v2, v3

    goto :goto_1

    .line 163
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/SearchRealm;>;"
    .end local v3    # "score":I
    .end local v5    # "sr":Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    :cond_6
    if-eqz v4, :cond_7

    move-object v6, v4

    goto/16 :goto_0

    :cond_7
    const-string/jumbo v6, "us"

    invoke-virtual {p0, v6}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealmById(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v6

    goto/16 :goto_0
.end method

.method public setRealm(Lcom/amazon/searchapp/retailsearch/client/SearchRealm;)V
    .locals 1
    .param p1, "realm"    # Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    .prologue
    .line 99
    monitor-enter p0

    .line 100
    :try_start_0
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->realm:Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    .line 101
    monitor-exit p0

    .line 102
    return-void

    .line 101
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
