.class public abstract Lcom/amazon/retailsearch/data/search/ResultModel;
.super Lcom/amazon/retailsearch/data/search/ResultEvent;
.source "ResultModel.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Model:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/amazon/retailsearch/data/search/ResultEvent;"
    }
.end annotation


# instance fields
.field private final model:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TModel;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TModel;)V"
        }
    .end annotation

    .prologue
    .line 6
    .local p0, "this":Lcom/amazon/retailsearch/data/search/ResultModel;, "Lcom/amazon/retailsearch/data/search/ResultModel<TModel;>;"
    .local p1, "model":Ljava/lang/Object;, "TModel;"
    invoke-direct {p0}, Lcom/amazon/retailsearch/data/search/ResultEvent;-><init>()V

    .line 7
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/ResultModel;->model:Ljava/lang/Object;

    .line 8
    return-void
.end method


# virtual methods
.method public get()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TModel;"
        }
    .end annotation

    .prologue
    .line 11
    .local p0, "this":Lcom/amazon/retailsearch/data/search/ResultModel;, "Lcom/amazon/retailsearch/data/search/ResultModel<TModel;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultModel;->model:Ljava/lang/Object;

    return-object v0
.end method
