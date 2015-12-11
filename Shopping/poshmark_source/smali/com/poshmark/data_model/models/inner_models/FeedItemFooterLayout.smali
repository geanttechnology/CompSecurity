.class public Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;
.super Ljava/lang/Object;
.source "FeedItemFooterLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;
    }
.end annotation


# instance fields
.field public currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->invalid:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    .line 18
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;)V
    .locals 1
    .param p1, "layout"    # Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->invalid:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    .line 21
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    .line 22
    return-void
.end method
