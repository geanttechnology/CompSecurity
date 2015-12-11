.class public Lcom/poshmark/utils/sharing/FSMTransition;
.super Ljava/lang/Object;
.source "FSMTransition.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/sharing/FSMTransition$1;,
        Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;
    }
.end annotation


# instance fields
.field public allStates:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/util/UUID;",
            "Lcom/poshmark/utils/sharing/share_states/ShareState;",
            ">;"
        }
    .end annotation
.end field

.field transitionMap_FAIL:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/util/UUID;",
            "Ljava/util/UUID;",
            ">;"
        }
    .end annotation
.end field

.field transitionMap_OK:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/util/UUID;",
            "Ljava/util/UUID;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/sharing/FSMTransition;->allStates:Ljava/util/Map;

    .line 16
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/sharing/FSMTransition;->transitionMap_OK:Ljava/util/Map;

    .line 17
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/sharing/FSMTransition;->transitionMap_FAIL:Ljava/util/Map;

    .line 20
    return-void
.end method


# virtual methods
.method public addStateObject(Lcom/poshmark/utils/sharing/share_states/ShareState;)V
    .locals 2
    .param p1, "state"    # Lcom/poshmark/utils/sharing/share_states/ShareState;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/poshmark/utils/sharing/FSMTransition;->allStates:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/poshmark/utils/sharing/share_states/ShareState;->getId()Ljava/util/UUID;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 24
    return-void
.end method

.method public addTransition(Ljava/util/UUID;Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)V
    .locals 2
    .param p1, "currentStateId"    # Ljava/util/UUID;
    .param p2, "nextStateId"    # Ljava/util/UUID;
    .param p3, "condition"    # Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    .prologue
    .line 27
    sget-object v0, Lcom/poshmark/utils/sharing/FSMTransition$1;->$SwitchMap$com$poshmark$utils$sharing$FSMTransition$CONDITION:[I

    invoke-virtual {p3}, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 34
    :goto_0
    return-void

    .line 29
    :pswitch_0
    iget-object v0, p0, Lcom/poshmark/utils/sharing/FSMTransition;->transitionMap_OK:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 32
    :pswitch_1
    iget-object v0, p0, Lcom/poshmark/utils/sharing/FSMTransition;->transitionMap_FAIL:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 27
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public getNextState(Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)Lcom/poshmark/utils/sharing/share_states/ShareState;
    .locals 4
    .param p1, "currentStateId"    # Ljava/util/UUID;
    .param p2, "condition"    # Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    .prologue
    .line 37
    const/4 v0, 0x0

    .line 39
    .local v0, "newState":Lcom/poshmark/utils/sharing/share_states/ShareState;
    sget-object v2, Lcom/poshmark/utils/sharing/FSMTransition$1;->$SwitchMap$com$poshmark$utils$sharing$FSMTransition$CONDITION:[I

    invoke-virtual {p2}, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 48
    :goto_0
    return-object v0

    .line 41
    :pswitch_0
    iget-object v2, p0, Lcom/poshmark/utils/sharing/FSMTransition;->transitionMap_OK:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/UUID;

    .line 42
    .local v1, "nextStateId":Ljava/util/UUID;
    iget-object v2, p0, Lcom/poshmark/utils/sharing/FSMTransition;->allStates:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "newState":Lcom/poshmark/utils/sharing/share_states/ShareState;
    check-cast v0, Lcom/poshmark/utils/sharing/share_states/ShareState;

    .line 43
    .restart local v0    # "newState":Lcom/poshmark/utils/sharing/share_states/ShareState;
    goto :goto_0

    .line 45
    .end local v1    # "nextStateId":Ljava/util/UUID;
    :pswitch_1
    iget-object v2, p0, Lcom/poshmark/utils/sharing/FSMTransition;->transitionMap_FAIL:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/UUID;

    .line 46
    .restart local v1    # "nextStateId":Ljava/util/UUID;
    iget-object v2, p0, Lcom/poshmark/utils/sharing/FSMTransition;->allStates:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "newState":Lcom/poshmark/utils/sharing/share_states/ShareState;
    check-cast v0, Lcom/poshmark/utils/sharing/share_states/ShareState;

    .restart local v0    # "newState":Lcom/poshmark/utils/sharing/share_states/ShareState;
    goto :goto_0

    .line 39
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public getState(Ljava/util/UUID;)Lcom/poshmark/utils/sharing/share_states/ShareState;
    .locals 1
    .param p1, "id"    # Ljava/util/UUID;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/poshmark/utils/sharing/FSMTransition;->allStates:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/sharing/share_states/ShareState;

    return-object v0
.end method
