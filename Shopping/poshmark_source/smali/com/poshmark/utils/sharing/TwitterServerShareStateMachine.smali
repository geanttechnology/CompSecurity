.class public Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;
.super Lcom/poshmark/utils/sharing/PM_State_Machine;
.source "TwitterServerShareStateMachine.java"

# interfaces
.implements Lcom/poshmark/utils/sharing/StateCompletionListener;


# instance fields
.field shareManager:Lcom/poshmark/utils/ShareManager;


# direct methods
.method public constructor <init>(Lcom/poshmark/utils/ShareManager;)V
    .locals 4
    .param p1, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/PM_State_Machine;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->shareManager:Lcom/poshmark/utils/ShareManager;

    .line 18
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    new-instance v1, Lcom/poshmark/utils/sharing/share_states/TwitterInit;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/sharing/share_states/TwitterInit;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->addStateObject(Lcom/poshmark/utils/sharing/share_states/ShareState;)V

    .line 19
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    new-instance v1, Lcom/poshmark/utils/sharing/share_states/GetServerContent;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/sharing/share_states/GetServerContent;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->addStateObject(Lcom/poshmark/utils/sharing/share_states/ShareState;)V

    .line 20
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    new-instance v1, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->addStateObject(Lcom/poshmark/utils/sharing/share_states/ShareState;)V

    .line 21
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    new-instance v1, Lcom/poshmark/utils/sharing/share_states/ServerShare;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/sharing/share_states/ServerShare;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->addStateObject(Lcom/poshmark/utils/sharing/share_states/ShareState;)V

    .line 22
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    new-instance v1, Lcom/poshmark/utils/sharing/share_states/Finish;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/sharing/share_states/Finish;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->addStateObject(Lcom/poshmark/utils/sharing/share_states/ShareState;)V

    .line 25
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    sget-object v1, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->id:Ljava/util/UUID;

    sget-object v2, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->id:Ljava/util/UUID;

    sget-object v3, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/utils/sharing/FSMTransition;->addTransition(Ljava/util/UUID;Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)V

    .line 26
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    sget-object v1, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->id:Ljava/util/UUID;

    sget-object v2, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->id:Ljava/util/UUID;

    sget-object v3, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->FAIL:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/utils/sharing/FSMTransition;->addTransition(Ljava/util/UUID;Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)V

    .line 27
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    sget-object v1, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->id:Ljava/util/UUID;

    sget-object v2, Lcom/poshmark/utils/sharing/share_states/ServerShare;->id:Ljava/util/UUID;

    sget-object v3, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/utils/sharing/FSMTransition;->addTransition(Ljava/util/UUID;Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)V

    .line 28
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    sget-object v1, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->id:Ljava/util/UUID;

    sget-object v2, Lcom/poshmark/utils/sharing/share_states/ServerShare;->id:Ljava/util/UUID;

    sget-object v3, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/utils/sharing/FSMTransition;->addTransition(Ljava/util/UUID;Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)V

    .line 31
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    sget-object v1, Lcom/poshmark/utils/sharing/share_states/TwitterInit;->id:Ljava/util/UUID;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/FSMTransition;->getState(Ljava/util/UUID;)Lcom/poshmark/utils/sharing/share_states/ShareState;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    .line 32
    return-void
.end method


# virtual methods
.method public init()V
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/share_states/ShareState;->executeState()V

    .line 36
    return-void
.end method

.method public stateCompleted()V
    .locals 3

    .prologue
    .line 41
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    if-eqz v0, :cond_0

    .line 42
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    iget-object v1, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    invoke-virtual {v1}, Lcom/poshmark/utils/sharing/share_states/ShareState;->getId()Ljava/util/UUID;

    move-result-object v1

    sget-object v2, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->OK:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/sharing/FSMTransition;->getNextState(Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)Lcom/poshmark/utils/sharing/share_states/ShareState;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    .line 43
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/share_states/ShareState;->executeState()V

    .line 47
    :cond_0
    return-void
.end method

.method public stateFailed()V
    .locals 3

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    iget-object v1, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    invoke-virtual {v1}, Lcom/poshmark/utils/sharing/share_states/ShareState;->getId()Ljava/util/UUID;

    move-result-object v1

    sget-object v2, Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;->FAIL:Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/sharing/FSMTransition;->getNextState(Ljava/util/UUID;Lcom/poshmark/utils/sharing/FSMTransition$CONDITION;)Lcom/poshmark/utils/sharing/share_states/ShareState;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    .line 53
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    if-eqz v0, :cond_0

    .line 54
    iget-object v0, p0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/share_states/ShareState;->executeState()V

    .line 57
    :cond_0
    return-void
.end method
