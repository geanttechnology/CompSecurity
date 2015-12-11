.class public abstract Lcom/amazon/analytics/session/SessionState;
.super Ljava/lang/Object;
.source "SessionState.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/analytics/session/SessionState$1;,
        Lcom/amazon/analytics/session/SessionState$MaybeEndSessionState;,
        Lcom/amazon/analytics/session/SessionState$RunningSessionState;,
        Lcom/amazon/analytics/session/SessionState$OrphanedSessionState;,
        Lcom/amazon/analytics/session/SessionState$NoSessionState;
    }
.end annotation


# static fields
.field static final MAYBE_END_SESSION:Lcom/amazon/analytics/session/SessionState;

.field static final NO_SESSION:Lcom/amazon/analytics/session/SessionState;

.field static final ORPHANED_SESSION:Lcom/amazon/analytics/session/SessionState;

.field static final RUNNING_SESSION:Lcom/amazon/analytics/session/SessionState;

.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 16
    const-class v0, Lcom/amazon/analytics/session/SessionState;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/analytics/session/SessionState;->logger:Lcom/amazon/device/analytics/log/Logger;

    .line 22
    new-instance v0, Lcom/amazon/analytics/session/SessionState$NoSessionState;

    invoke-direct {v0, v1}, Lcom/amazon/analytics/session/SessionState$NoSessionState;-><init>(Lcom/amazon/analytics/session/SessionState$1;)V

    sput-object v0, Lcom/amazon/analytics/session/SessionState;->NO_SESSION:Lcom/amazon/analytics/session/SessionState;

    .line 23
    new-instance v0, Lcom/amazon/analytics/session/SessionState$RunningSessionState;

    invoke-direct {v0, v1}, Lcom/amazon/analytics/session/SessionState$RunningSessionState;-><init>(Lcom/amazon/analytics/session/SessionState$1;)V

    sput-object v0, Lcom/amazon/analytics/session/SessionState;->RUNNING_SESSION:Lcom/amazon/analytics/session/SessionState;

    .line 24
    new-instance v0, Lcom/amazon/analytics/session/SessionState$MaybeEndSessionState;

    invoke-direct {v0, v1}, Lcom/amazon/analytics/session/SessionState$MaybeEndSessionState;-><init>(Lcom/amazon/analytics/session/SessionState$1;)V

    sput-object v0, Lcom/amazon/analytics/session/SessionState;->MAYBE_END_SESSION:Lcom/amazon/analytics/session/SessionState;

    .line 25
    new-instance v0, Lcom/amazon/analytics/session/SessionState$OrphanedSessionState;

    invoke-direct {v0, v1}, Lcom/amazon/analytics/session/SessionState$OrphanedSessionState;-><init>(Lcom/amazon/analytics/session/SessionState$1;)V

    sput-object v0, Lcom/amazon/analytics/session/SessionState;->ORPHANED_SESSION:Lcom/amazon/analytics/session/SessionState;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/analytics/session/SessionState$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/analytics/session/SessionState$1;

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/amazon/analytics/session/SessionState;-><init>()V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/analytics/util/Message;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-static {p0, p1}, Lcom/amazon/analytics/session/SessionState;->isSamePackage(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private static isSamePackage(Lcom/amazon/analytics/util/Message;Ljava/lang/String;)Z
    .locals 4
    .param p0, "message"    # Lcom/amazon/analytics/util/Message;
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-virtual {p0}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v1

    const-string/jumbo v2, "PackageName"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 35
    .local v0, "messagePkgName":Ljava/lang/String;
    sget-object v1, Lcom/amazon/analytics/session/SessionState;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "isSamePackage check - message package name is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 36
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    return v1
.end method


# virtual methods
.method public abstract getNextState(Lcom/amazon/analytics/session/PackageSession;ILcom/amazon/analytics/util/Message;)Lcom/amazon/analytics/session/SessionState;
.end method

.method public abstract triggerOnStateAction(Lcom/amazon/analytics/session/PackageSession;Lcom/amazon/analytics/session/SessionState;Lcom/amazon/analytics/util/Message;)Lcom/amazon/device/analytics/events/Event;
.end method
