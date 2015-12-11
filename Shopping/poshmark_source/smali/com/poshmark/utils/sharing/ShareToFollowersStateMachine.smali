.class public Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;
.super Lcom/poshmark/utils/sharing/PM_State_Machine;
.source "ShareToFollowersStateMachine.java"

# interfaces
.implements Lcom/poshmark/utils/sharing/StateCompletionListener;


# instance fields
.field shareManager:Lcom/poshmark/utils/ShareManager;


# direct methods
.method public constructor <init>(Lcom/poshmark/utils/ShareManager;)V
    .locals 4
    .param p1, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/PM_State_Machine;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->shareManager:Lcom/poshmark/utils/ShareManager;

    .line 20
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    new-instance v1, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersInit;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersInit;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->addStateObject(Lcom/poshmark/utils/sharing/share_states/ShareState;)V

    .line 21
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    new-instance v1, Lcom/poshmark/utils/sharing/share_states/GetServerContent;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/sharing/share_states/GetServerContent;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->addStateObject(Lcom/poshmark/utils/sharing/share_states/ShareState;)V

    .line 22
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    new-instance v1, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->addStateObject(Lcom/poshmark/utils/sharing/share_states/ShareState;)V

    .line 23
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    new-instance v1, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->addStateObject(Lcom/poshmark/utils/sharing/share_states/ShareState;)V

    .line 24
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    new-instance v1, Lcom/poshmark/utils/sharing/share_states/Finish;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/sharing/share_states/Finish;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->addStateObject(Lcom/poshmark/utils/sharing/share_states/ShareState;)V

    .line 27
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    sget-object v1, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersInit;->id:Ljava/util/UUID;

    sget-object v2, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->id:Ljava/util/UUID;

    sget-object v3, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/utils/sharing/FSMTransition;->addTransition(Ljava/util/UUID;Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)V

    .line 28
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    sget-object v1, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->id:Ljava/util/UUID;

    sget-object v2, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;->id:Ljava/util/UUID;

    sget-object v3, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/utils/sharing/FSMTransition;->addTransition(Ljava/util/UUID;Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)V

    .line 29
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    sget-object v1, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->id:Ljava/util/UUID;

    sget-object v2, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->id:Ljava/util/UUID;

    sget-object v3, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->FAIL:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/utils/sharing/FSMTransition;->addTransition(Ljava/util/UUID;Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)V

    .line 30
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    sget-object v1, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->id:Ljava/util/UUID;

    sget-object v2, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;->id:Ljava/util/UUID;

    sget-object v3, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/utils/sharing/FSMTransition;->addTransition(Ljava/util/UUID;Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)V

    .line 31
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    sget-object v1, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersShare;->id:Ljava/util/UUID;

    sget-object v2, Lcom/poshmark/utils/sharing/share_states/Finish;->id:Ljava/util/UUID;

    sget-object v3, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/utils/sharing/FSMTransition;->addTransition(Ljava/util/UUID;Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)V

    .line 34
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    sget-object v1, Lcom/poshmark/utils/sharing/share_states/ShareToFollowersInit;->id:Ljava/util/UUID;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->getState(Ljava/util/UUID;)Lcom/poshmark/utils/sharing/share_states/ShareState;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    .line 35
    return-void
.end method


# virtual methods
.method public init()V
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/share_states/ShareState;->executeState()V

    .line 39
    return-void
.end method

.method public stateCompleted()V
    .locals 3

    .prologue
    .line 42
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    invoke-virtual {v1}, Lcom/poshmark/utils/sharing/share_states/ShareState;->getId()Ljava/util/UUID;

    move-result-object v1

    sget-object v2, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/sharing/FSMTransition;->getNextState(Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)Lcom/poshmark/utils/sharing/share_states/ShareState;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    .line 44
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/share_states/ShareState;->executeState()V

    .line 48
    :cond_0
    return-void
.end method

.method public stateFailed()V
    .locals 3

    .prologue
    .line 52
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    invoke-virtual {v1}, Lcom/poshmark/utils/sharing/share_states/ShareState;->getId()Ljava/util/UUID;

    move-result-object v1

    sget-object v2, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->FAIL:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/sharing/FSMTransition;->getNextState(Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)Lcom/poshmark/utils/sharing/share_states/ShareState;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    .line 54
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    if-eqz v0, :cond_0

    .line 55
    iget-object v0, p0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/share_states/ShareState;->executeState()V

    .line 58
    :cond_0
    return-void
.end method
