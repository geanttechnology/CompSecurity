.class public Lcom/poshmark/data_model/models/inner_models/Like;
.super Ljava/lang/Object;
.source "Like.java"


# instance fields
.field public created_at:Ljava/lang/String;

.field public creator_display_handle:Ljava/lang/String;

.field public creator_id:Ljava/lang/String;

.field public id:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/Like;)V
    .locals 1
    .param p1, "newLike"    # Lcom/poshmark/data_model/models/inner_models/Like;

    .prologue
    .line 14
    if-eqz p1, :cond_0

    .line 15
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Like;->id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Like;->id:Ljava/lang/String;

    .line 16
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Like;->created_at:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Like;->created_at:Ljava/lang/String;

    .line 17
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Like;->creator_display_handle:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Like;->creator_display_handle:Ljava/lang/String;

    .line 18
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Like;->creator_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Like;->creator_id:Ljava/lang/String;

    .line 20
    :cond_0
    return-void
.end method

.method public getDisplayHandle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 10
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Like;->creator_display_handle:Ljava/lang/String;

    return-object v0
.end method
