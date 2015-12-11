.class public Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;
.super Ljava/lang/Object;
.source "CategoryBrowseController.java"


# static fields
.field private static final AIV_DE_NODE:Ljava/lang/String; = "3010075031"

.field private static final AIV_UK_NODE:Ljava/lang/String; = "3010085031"

.field private static final AIV_US_NODE:Ljava/lang/String; = "2858778011"

.field private static final APPSTORE_DE_NODE:Ljava/lang/String; = "1661648031"

.field private static final APPSTORE_UK_NODE:Ljava/lang/String; = "1661657031"

.field private static final APPSTORE_US_NODE:Ljava/lang/String; = "2350149011"

.field private static final APP_ACTION_PARAM:Ljava/lang/String; = "app-action"

.field private static final BROWSE_APP_ACTION:Ljava/lang/String; = "browse"

.field public static final BROWSE_APS:Ljava/lang/String; = "/s/browse?node=aps"

.field public static final BROWSE_BASE:Ljava/lang/String; = "/s/browse?node="

.field private static final DATA_PARAM:Ljava/lang/String; = "data-url"

.field private static final HEADER_ID:Ljava/lang/String; = "sx-amzn-app"

.field private static final HEADER_VALUE:Ljava/lang/String; = "type=phone"

.field private static final NODE_PARAM:Ljava/lang/String; = "node"

.field public static final WEBVIEW_HEADER:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 47
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;->WEBVIEW_HEADER:Ljava/util/Map;

    .line 49
    sget-object v0, Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;->WEBVIEW_HEADER:Ljava/util/Map;

    const-string/jumbo v1, "sx-amzn-app"

    const-string/jumbo v2, "type=phone"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static buildCategoryBrowseLink(Landroid/net/Uri;)Ljava/lang/String;
    .locals 4
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 59
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getSecureSearchServiceUrl()Ljava/lang/String;

    move-result-object v0

    .line 60
    .local v0, "domain":Ljava/lang/String;
    const-string/jumbo v1, "/s/browse?node=aps"

    .line 63
    .local v1, "path":Ljava/lang/String;
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 65
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 81
    :goto_0
    return-object v2

    .line 68
    :cond_1
    const-string/jumbo v2, "browse"

    const-string/jumbo v3, "app-action"

    invoke-virtual {p0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    const-string/jumbo v2, "data-url"

    invoke-virtual {p0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 70
    const-string/jumbo v2, "data-url"

    invoke-virtual {p0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 81
    :cond_2
    :goto_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 72
    :cond_3
    const-string/jumbo v2, "browse"

    const-string/jumbo v3, "app-action"

    invoke-virtual {p0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    const-string/jumbo v2, "node"

    invoke-virtual {p0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 74
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "/s/browse?node="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "node"

    invoke-virtual {p0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 77
    :cond_4
    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x2f

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    const/4 v3, -0x1

    if-eq v2, v3, :cond_2

    .line 79
    invoke-static {p0}, Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;->getPathFromUri(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method

.method public static getCurrentRefinement(Lcom/amazon/searchapp/retailsearch/model/Refinements;)Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    .locals 2
    .param p0, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 92
    if-eqz p0, :cond_0

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 96
    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v0

    invoke-interface {p0}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .line 98
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static getPathFromUri(Landroid/net/Uri;)Ljava/lang/String;
    .locals 5
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 109
    :try_start_0
    new-instance v1, Ljava/net/URL;

    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 110
    .local v1, "url":Ljava/net/URL;
    invoke-virtual {v1}, Ljava/net/URL;->getFile()Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 113
    .end local v1    # "url":Ljava/net/URL;
    :goto_0
    return-object v2

    .line 111
    :catch_0
    move-exception v0

    .line 113
    .local v0, "e":Ljava/net/MalformedURLException;
    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x2f

    invoke-virtual {v3, v4}, Ljava/lang/String;->indexOf(I)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public static shouldLaunchAIVBrowse(Ljava/lang/String;)Z
    .locals 2
    .param p0, "node"    # Ljava/lang/String;

    .prologue
    .line 119
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    .line 120
    .local v0, "locale":Ljava/util/Locale;
    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string/jumbo v1, "2858778011"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    :cond_0
    sget-object v1, Ljava/util/Locale;->UK:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string/jumbo v1, "3010085031"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    :cond_1
    sget-object v1, Ljava/util/Locale;->GERMANY:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    const-string/jumbo v1, "3010075031"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    :cond_2
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_3
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static shouldLaunchAppStoreBrowse(Ljava/lang/String;)Z
    .locals 2
    .param p0, "node"    # Ljava/lang/String;

    .prologue
    .line 127
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    .line 128
    .local v0, "locale":Ljava/util/Locale;
    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string/jumbo v1, "2350149011"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    :cond_0
    sget-object v1, Ljava/util/Locale;->UK:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string/jumbo v1, "1661657031"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    :cond_1
    sget-object v1, Ljava/util/Locale;->GERMANY:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    const-string/jumbo v1, "1661648031"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    :cond_2
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_3
    const/4 v1, 0x0

    goto :goto_0
.end method
