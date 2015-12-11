.class public Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;
.super Ljava/lang/Object;
.source "FeedItemHeaderLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;
    }
.end annotation


# instance fields
.field public currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->invalid:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    .line 19
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;)V
    .locals 1
    .param p1, "layout"    # Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->invalid:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    .line 22
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    .line 23
    return-void
.end method
