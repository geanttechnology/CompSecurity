.class public Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;
.super Ljava/lang/Object;
.source "RetailSearchLoggingProvider.java"


# static fields
.field private static loggingProvider:Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;


# instance fields
.field private final categoryBrowseLogger:Lcom/amazon/retailsearch/android/api/log/CategoryBrowseLogger;

.field private final retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field private final searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->loggingProvider:Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    new-instance v0, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-direct {v0, p1}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;-><init>(Landroid/content/Context;)V

    .line 41
    .local v0, "loggingConfig":Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;
    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->isLoggingEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 43
    new-instance v1, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;

    invoke-direct {v1, p1, v0}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;-><init>(Landroid/content/Context;Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;)V

    iput-object v1, p0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 44
    new-instance v1, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;

    invoke-direct {v1, p1, v0}, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;-><init>(Landroid/content/Context;Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;)V

    iput-object v1, p0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->categoryBrowseLogger:Lcom/amazon/retailsearch/android/api/log/CategoryBrowseLogger;

    .line 45
    new-instance v1, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;

    invoke-direct {v1, p1, v0}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;-><init>(Landroid/content/Context;Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;)V

    iput-object v1, p0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    .line 53
    :goto_0
    return-void

    .line 49
    :cond_0
    new-instance v1, Lcom/amazon/retailsearch/metrics/NullRetailSearchLogger;

    invoke-direct {v1}, Lcom/amazon/retailsearch/metrics/NullRetailSearchLogger;-><init>()V

    iput-object v1, p0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 50
    new-instance v1, Lcom/amazon/retailsearch/metrics/NullCategoryBrowseLogger;

    invoke-direct {v1}, Lcom/amazon/retailsearch/metrics/NullCategoryBrowseLogger;-><init>()V

    iput-object v1, p0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->categoryBrowseLogger:Lcom/amazon/retailsearch/android/api/log/CategoryBrowseLogger;

    .line 51
    new-instance v1, Lcom/amazon/retailsearch/metrics/NullSearchBoxLogger;

    invoke-direct {v1}, Lcom/amazon/retailsearch/metrics/NullSearchBoxLogger;-><init>()V

    iput-object v1, p0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    goto :goto_0
.end method

.method public static getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;
    .locals 1

    .prologue
    .line 71
    sget-object v0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->loggingProvider:Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    return-object v0
.end method

.method public static init(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 61
    new-instance v0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->loggingProvider:Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    .line 62
    return-void
.end method


# virtual methods
.method public final getCategoryBrowseLogger()Lcom/amazon/retailsearch/android/api/log/CategoryBrowseLogger;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->categoryBrowseLogger:Lcom/amazon/retailsearch/android/api/log/CategoryBrowseLogger;

    return-object v0
.end method

.method public final getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    return-object v0
.end method

.method public final getSearchBoxLogger()Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    return-object v0
.end method
