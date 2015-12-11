.class public Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;
.super Ljava/lang/Object;
.source "ServiceCallState.java"


# static fields
.field public static final CANCELLED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

.field public static final COMPLETED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

.field public static final ERROR:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

.field public static final EXECUTING:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

.field public static final NOT_STARTED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;


# instance fields
.field private final name:Ljava/lang/String;

.field private final terminalState:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 8
    new-instance v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    const-string/jumbo v1, "NOT_STARTED"

    invoke-direct {v0, v1, v3}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->NOT_STARTED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    .line 9
    new-instance v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    const-string/jumbo v1, "EXECUTING"

    invoke-direct {v0, v1, v3}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->EXECUTING:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    .line 10
    new-instance v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    const-string/jumbo v1, "ERROR"

    invoke-direct {v0, v1, v2}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->ERROR:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    .line 11
    new-instance v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    const-string/jumbo v1, "COMPLETED"

    invoke-direct {v0, v1, v2}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->COMPLETED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    .line 12
    new-instance v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    const-string/jumbo v1, "CANCELLED"

    invoke-direct {v0, v1, v2}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->CANCELLED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "terminalState"    # Z

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->name:Ljava/lang/String;

    .line 19
    iput-boolean p2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->terminalState:Z

    .line 20
    return-void
.end method


# virtual methods
.method public isTerminalState()Z
    .locals 1

    .prologue
    .line 22
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->terminalState:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->name:Ljava/lang/String;

    return-object v0
.end method
