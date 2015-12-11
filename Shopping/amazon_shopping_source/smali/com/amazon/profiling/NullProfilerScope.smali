.class public final enum Lcom/amazon/profiling/NullProfilerScope;
.super Ljava/lang/Enum;
.source "NullProfilerScope.java"

# interfaces
.implements Lcom/amazon/profiling/ProfilerScope;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/profiling/NullProfilerScope;",
        ">;",
        "Lcom/amazon/profiling/ProfilerScope;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/profiling/NullProfilerScope;

.field public static final enum INSTANCE:Lcom/amazon/profiling/NullProfilerScope;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 9
    new-instance v0, Lcom/amazon/profiling/NullProfilerScope;

    const-string/jumbo v1, "INSTANCE"

    invoke-direct {v0, v1, v2}, Lcom/amazon/profiling/NullProfilerScope;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/profiling/NullProfilerScope;->INSTANCE:Lcom/amazon/profiling/NullProfilerScope;

    .line 6
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/amazon/profiling/NullProfilerScope;

    sget-object v1, Lcom/amazon/profiling/NullProfilerScope;->INSTANCE:Lcom/amazon/profiling/NullProfilerScope;

    aput-object v1, v0, v2

    sput-object v0, Lcom/amazon/profiling/NullProfilerScope;->$VALUES:[Lcom/amazon/profiling/NullProfilerScope;

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
    .line 6
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/profiling/NullProfilerScope;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 6
    const-class v0, Lcom/amazon/profiling/NullProfilerScope;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/profiling/NullProfilerScope;

    return-object v0
.end method

.method public static values()[Lcom/amazon/profiling/NullProfilerScope;
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/amazon/profiling/NullProfilerScope;->$VALUES:[Lcom/amazon/profiling/NullProfilerScope;

    invoke-virtual {v0}, [Lcom/amazon/profiling/NullProfilerScope;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/profiling/NullProfilerScope;

    return-object v0
.end method
