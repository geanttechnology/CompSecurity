.class public final enum Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;
.super Ljava/lang/Enum;
.source "IssLogger.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/metrics/IssLogger;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "UserAction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

.field public static final enum explicit_acceptance:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

.field public static final enum implicit_acceptance:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

.field public static final enum mismatch:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

.field public static final enum rejection:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

.field public static final enum zero_impression:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 61
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    const-string/jumbo v1, "explicit_acceptance"

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->explicit_acceptance:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    .line 63
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    const-string/jumbo v1, "implicit_acceptance"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->implicit_acceptance:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    .line 65
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    const-string/jumbo v1, "rejection"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->rejection:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    .line 71
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    const-string/jumbo v1, "mismatch"

    invoke-direct {v0, v1, v5}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->mismatch:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    .line 73
    new-instance v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    const-string/jumbo v1, "zero_impression"

    invoke-direct {v0, v1, v6}, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->zero_impression:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    .line 58
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    sget-object v1, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->explicit_acceptance:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->implicit_acceptance:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->rejection:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->mismatch:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->zero_impression:Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->$VALUES:[Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 58
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 58
    const-class v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;
    .locals 1

    .prologue
    .line 58
    sget-object v0, Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->$VALUES:[Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/metrics/IssLogger$UserAction;

    return-object v0
.end method
