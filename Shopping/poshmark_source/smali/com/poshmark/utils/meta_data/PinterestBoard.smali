.class public Lcom/poshmark/utils/meta_data/PinterestBoard;
.super Ljava/lang/Object;
.source "PinterestBoard.java"


# instance fields
.field public board_id:Ljava/lang/String;

.field public enabled:Z

.field public image_url:Ljava/lang/String;

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBoardHash()Ljava/util/Map;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 48
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 49
    .local v0, "boardHash":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "board_id"

    iget-object v3, p0, Lcom/poshmark/utils/meta_data/PinterestBoard;->board_id:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    const-string v2, "name"

    iget-object v3, p0, Lcom/poshmark/utils/meta_data/PinterestBoard;->name:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    iget-boolean v2, p0, Lcom/poshmark/utils/meta_data/PinterestBoard;->enabled:Z

    if-eqz v2, :cond_0

    const-string v1, "1"

    .line 52
    .local v1, "enabled":Ljava/lang/String;
    :goto_0
    const-string v2, "enabled"

    invoke-interface {v0, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    return-object v0

    .line 51
    .end local v1    # "enabled":Ljava/lang/String;
    :cond_0
    const-string v1, "0"

    goto :goto_0
.end method

.method public getDisplay()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/PinterestBoard;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/PinterestBoard;->board_id:Ljava/lang/String;

    return-object v0
.end method

.method public getImage_url()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/PinterestBoard;->image_url:Ljava/lang/String;

    return-object v0
.end method

.method public isEnabled()Z
    .locals 1

    .prologue
    .line 40
    iget-boolean v0, p0, Lcom/poshmark/utils/meta_data/PinterestBoard;->enabled:Z

    return v0
.end method

.method public setBoard_id(Ljava/lang/String;)V
    .locals 0
    .param p1, "board_id"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/PinterestBoard;->board_id:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public setEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 44
    iput-boolean p1, p0, Lcom/poshmark/utils/meta_data/PinterestBoard;->enabled:Z

    .line 45
    return-void
.end method

.method public setImage_url(Ljava/lang/String;)V
    .locals 0
    .param p1, "image_url"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/PinterestBoard;->image_url:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/poshmark/utils/meta_data/PinterestBoard;->name:Ljava/lang/String;

    .line 29
    return-void
.end method
