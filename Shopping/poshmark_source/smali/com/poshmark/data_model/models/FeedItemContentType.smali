.class public Lcom/poshmark/data_model/models/FeedItemContentType;
.super Ljava/lang/Object;
.source "FeedItemContentType.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;
    }
.end annotation


# instance fields
.field public type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Invalid:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    .line 22
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "typeString"    # Ljava/lang/String;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Invalid:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    .line 25
    invoke-direct {p0, p1}, Lcom/poshmark/data_model/models/FeedItemContentType;->setContentType(Ljava/lang/String;)V

    .line 26
    return-void
.end method

.method private setContentType(Ljava/lang/String;)V
    .locals 1
    .param p1, "typeString"    # Ljava/lang/String;

    .prologue
    .line 29
    if-eqz p1, :cond_0

    .line 30
    const-string v0, "post"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 31
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Post:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    .line 46
    :cond_0
    :goto_0
    return-void

    .line 32
    :cond_1
    const-string v0, "brand"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 33
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Brand:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    goto :goto_0

    .line 34
    :cond_2
    const-string v0, "user"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 35
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->User:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    goto :goto_0

    .line 36
    :cond_3
    const-string v0, "event"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 37
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Event:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    goto :goto_0

    .line 38
    :cond_4
    const-string v0, "collection"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 39
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Collection:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    goto :goto_0

    .line 40
    :cond_5
    const-string v0, "cpu_message"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 41
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->PoshmarkPost:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    goto :goto_0

    .line 43
    :cond_6
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Invalid:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    goto :goto_0
.end method
