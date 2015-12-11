.class final Lcom/amazon/retailsearch/client/SearchClientUtil$1;
.super Ljava/lang/Object;
.source "SearchClientUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/client/SearchClientUtil;->executeRequest(Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;)Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$searchCall:Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/retailsearch/client/SearchClientUtil$1;->val$searchCall:Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 48
    :try_start_0
    iget-object v0, p0, Lcom/amazon/retailsearch/client/SearchClientUtil$1;->val$searchCall:Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;->execute()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 53
    :goto_0
    return-void

    .line 50
    :catch_0
    move-exception v0

    goto :goto_0
.end method
