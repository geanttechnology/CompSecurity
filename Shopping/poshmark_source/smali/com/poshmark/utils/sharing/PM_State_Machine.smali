.class public abstract Lcom/poshmark/utils/sharing/PM_State_Machine;
.super Ljava/lang/Object;
.source "PM_State_Machine.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT;
    }
.end annotation


# instance fields
.field currentState:Lcom/poshmark/utils/sharing/share_states/ShareState;

.field transitions:Lcom/poshmark/utils/sharing/FSMTransition;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    new-instance v0, Lcom/poshmark/utils/sharing/FSMTransition;

    invoke-direct {v0}, Lcom/poshmark/utils/sharing/FSMTransition;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/sharing/PM_State_Machine;->transitions:Lcom/poshmark/utils/sharing/FSMTransition;

    .line 13
    return-void
.end method
