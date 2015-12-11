.class public Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;
.super Ljava/lang/Object;
.source "RefinementsLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$1;,
        Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;,
        Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RequestListener;
    }
.end annotation


# static fields
.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private final listener:Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;

.field private path:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;Ljava/lang/String;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;
    .param p2, "path"    # Ljava/lang/String;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->listener:Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;

    .line 33
    iput-object p2, p0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->path:Ljava/lang/String;

    .line 34
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;)Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->listener:Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;

    return-object v0
.end method


# virtual methods
.method public getRefinements()V
    .locals 5

    .prologue
    .line 39
    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v0

    .line 40
    .local v0, "client":Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    new-instance v3, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RequestListener;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v4}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RequestListener;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$1;)V

    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->path:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->refinements(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;

    move-result-object v2

    .line 43
    .local v2, "serviceCall":Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;
    :try_start_0
    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/RefinementsServiceCall;->execute()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 49
    :goto_0
    return-void

    .line 45
    :catch_0
    move-exception v1

    .line 47
    .local v1, "e":Ljava/io/IOException;
    sget-object v3, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v4, "Could not load refinements"

    invoke-interface {v3, v4, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
