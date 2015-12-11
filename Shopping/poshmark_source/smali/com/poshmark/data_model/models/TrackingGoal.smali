.class public Lcom/poshmark/data_model/models/TrackingGoal;
.super Ljava/lang/Object;
.source "TrackingGoal.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/TrackingGoal$Node;
    }
.end annotation


# instance fields
.field goal:Ljava/lang/String;

.field stack:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/TrackingGoal$Node;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/List;)V
    .locals 4
    .param p1, "goal"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 14
    .local p2, "navList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/poshmark/data_model/models/TrackingGoal;->goal:Ljava/lang/String;

    .line 16
    if-eqz p2, :cond_0

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 17
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/poshmark/data_model/models/TrackingGoal;->stack:Ljava/util/ArrayList;

    .line 18
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 19
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 20
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 21
    .local v2, "tag":Ljava/lang/String;
    new-instance v1, Lcom/poshmark/data_model/models/TrackingGoal$Node;

    const/4 v3, 0x0

    invoke-direct {v1, p0, v2, v3}, Lcom/poshmark/data_model/models/TrackingGoal$Node;-><init>(Lcom/poshmark/data_model/models/TrackingGoal;Ljava/lang/String;Ljava/lang/Object;)V

    .line 22
    .local v1, "n":Lcom/poshmark/data_model/models/TrackingGoal$Node;
    iget-object v3, p0, Lcom/poshmark/data_model/models/TrackingGoal;->stack:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 25
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v1    # "n":Lcom/poshmark/data_model/models/TrackingGoal$Node;
    .end local v2    # "tag":Ljava/lang/String;
    :cond_0
    return-void
.end method
