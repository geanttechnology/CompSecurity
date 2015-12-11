.class public Lcom/poshmark/data_model/models/FeedItemImageLayout;
.super Ljava/lang/Object;
.source "FeedItemImageLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;
    }
.end annotation


# instance fields
.field currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->Invalid:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    .line 20
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "layoutString"    # Ljava/lang/String;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->Invalid:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    .line 23
    invoke-virtual {p0, p1}, Lcom/poshmark/data_model/models/FeedItemImageLayout;->setLayoutType(Ljava/lang/String;)V

    .line 24
    return-void
.end method


# virtual methods
.method public getCurrentLayout()Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    return-object v0
.end method

.method public isLayoutValid()Z
    .locals 2

    .prologue
    .line 31
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->Invalid:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setLayoutType(Ljava/lang/String;)V
    .locals 1
    .param p1, "layoutType"    # Ljava/lang/String;

    .prologue
    .line 35
    if-eqz p1, :cond_0

    .line 36
    const-string v0, "SIFU_SUMMARY"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 37
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_SUMMARY:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    .line 50
    :cond_0
    :goto_0
    return-void

    .line 38
    :cond_1
    const-string v0, "SIFU_SOCIAL"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 39
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_SOCIAL:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    goto :goto_0

    .line 40
    :cond_2
    const-string v0, "MIFU_3_FLUID_LARGE_LEFT"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 41
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->MIFU_3_FLUID_LARGE_LEFT:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    goto :goto_0

    .line 42
    :cond_3
    const-string v0, "MIFU_4_GRID"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 43
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->MIFU_4_GRID:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    goto :goto_0

    .line 44
    :cond_4
    const-string v0, "SIFU_LEFT_IMAGE_RIGHT_TEXT"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 45
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_LEFT_IMAGE_RIGHT_TEXT:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    goto :goto_0

    .line 47
    :cond_5
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->Invalid:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    goto :goto_0
.end method
