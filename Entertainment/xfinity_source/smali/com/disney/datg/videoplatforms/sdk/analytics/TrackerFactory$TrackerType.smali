.class public final enum Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;
.super Ljava/lang/Enum;
.source "TrackerFactory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "TrackerType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

.field public static final enum OMNITURE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

.field public static final enum SLOGGER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

.field public static final enum UNKNOWN:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 13
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    const-string v1, "OMNITURE"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->OMNITURE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    const-string v1, "SLOGGER"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->SLOGGER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->UNKNOWN:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->OMNITURE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->SLOGGER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->UNKNOWN:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

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
    .line 13
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    return-object v0
.end method
